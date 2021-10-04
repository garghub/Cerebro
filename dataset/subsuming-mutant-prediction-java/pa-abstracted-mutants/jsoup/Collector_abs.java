public static Elements collect ( Evaluator eval , Element root ) {
Elements elements = new Elements () ;
NodeTraversor . traverse ( new Accumulator ( root , elements , eval ) , root ) ;
return elements ;
}
public void head ( Node node , int depth ) {
if ( node instanceof Element ) {
Element el = ( Element ) node ;
if ( eval . matches ( root , el ) )
elements . add ( el ) ;
}
}
public void tail ( Node node , int depth ) {
}
public static Element findFirst ( Evaluator eval , Element root ) {
FirstFinder finder = new FirstFinder ( root , eval ) ;
NodeTraversor . filter ( finder , root ) ;
return finder . match ;
}
@Override
public FilterResult head ( Node node , int depth ) {
if ( node instanceof Element ) {
Element el = ( Element ) node ;
if ( eval . matches ( root , el ) ) {
match = el ;
return STOP ;
}
}
return CONTINUE ;
}
@Override
public FilterResult tail ( Node node , int depth ) {
return CONTINUE ;
}
