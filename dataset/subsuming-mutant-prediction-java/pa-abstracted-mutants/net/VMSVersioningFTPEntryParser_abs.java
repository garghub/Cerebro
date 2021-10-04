@Override
public List < String > preParse ( final List < String > original ) {
final HashMap < String , Integer > existingEntries = new HashMap <> () ;
final ListIterator < String > iter = original . listIterator () ;
while ( iter . hasNext () ) {
final String entry = iter . next () . trim () ;
MatchResult result = null ;
final Matcher _preparse_matcher_ = preparsePattern . matcher ( entry ) ;
if ( _preparse_matcher_ . matches () ) {
result = _preparse_matcher_ . toMatchResult () ;
final String name = result . group ( 1 ) ;
final String version = result . group ( 2 ) ;
final Integer nv = Integer . valueOf ( version ) ;
final Integer existing = existingEntries . get ( name ) ;
if ( null != existing ) {
if ( nv . intValue () < existing . intValue () ) {
iter . remove () ;
continue;
}
}
existingEntries . put ( name , nv ) ;
}
}
while ( iter . hasPrevious () ) {
final String entry = iter . previous () . trim () ;
MatchResult result = null ;
final Matcher _preparse_matcher_ = preparsePattern . matcher ( entry ) ;
if ( _preparse_matcher_ . matches () ) {
result = _preparse_matcher_ . toMatchResult () ;
final String name = result . group ( 1 ) ;
final String version = result . group ( 2 ) ;
final Integer nv = Integer . valueOf ( version ) ;
final Integer existing = existingEntries . get ( name ) ;
if ( null != existing ) {
if ( nv . intValue () < existing . intValue () ) {
iter . remove () ;
}
}
}
}
return original ;
}
@Override
protected boolean isVersioning () {
return true ;
}
