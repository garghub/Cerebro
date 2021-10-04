public static Elements select ( String query , Element root ) {
Validate . notEmpty ( query ) ;
return select ( QueryParser . parse ( query ) , root ) ;
}
public static Elements select ( Evaluator evaluator , Element root ) {
Validate . notNull ( evaluator ) ;
Validate . notNull ( root ) ;
return Collector . collect ( evaluator , root ) ;
}
public static Elements select ( String query , Iterable < Element > roots ) {
Validate . notEmpty ( query ) ;
Validate . notNull ( roots ) ;
Evaluator evaluator = QueryParser . parse ( query ) ;
ArrayList < Element > elements = new ArrayList <> () ;
IdentityHashMap < Element , Boolean > seenElements = new IdentityHashMap <> () ;
for ( Element root : roots ) {
final Elements found = select ( evaluator , root ) ;
for ( Element el : found ) {
if ( ! seenElements . containsKey ( el ) ) {
elements . add ( el ) ;
seenElements . put ( el , Boolean . TRUE ) ;
}
}
}
return new Elements ( elements ) ;
}
static Elements filterOut ( Collection < Element > elements , Collection < Element > outs ) {
Elements output = new Elements () ;
for ( Element el : elements ) {
boolean found = false ;
for ( Element out : outs ) {
if ( el . equals ( out ) ) {
found = true ;
break;
}
}
if ( ! found )
output . add ( el ) ;
}
return output ;
}
public static Element selectFirst ( String cssQuery , Element root ) {
Validate . notEmpty ( cssQuery ) ;
return Collector . findFirst ( QueryParser . parse ( cssQuery ) , root ) ;
}
