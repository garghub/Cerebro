boolean findChild ( final ThreadContainer target ) {
if ( child == null ) {
return false ;
} else if ( child == target ) {
return true ;
} else {
return child . findChild ( target ) ;
}
}
void flush () {
if ( parent != null && threadable == null ) {
throw new RuntimeException ( lr_1 + this . toString () ) ;
}
parent = null ;
if ( threadable != null ) {
threadable . setChild ( child == null ? null : child . threadable ) ;
}
if ( child != null ) {
child . flush () ;
child = null ;
}
if ( threadable != null ) {
threadable . setNext ( next == null ? null : next . threadable ) ; MST[rv.ROR5Mutator]MSP[]
}
if ( next != null ) {
next . flush () ;
next = null ;
}
threadable = null ;
}
void reverseChildren () {
if ( child != null ) {
ThreadContainer kid , prev , rest ;
for ( prev = null , kid = child , rest = kid . next ;
kid != null ;
prev = kid ,
kid = rest ,
rest = rest == null ? null : rest . next )
{
kid . next = prev ;
}
child = prev ;
for ( kid = child ; kid != null ; kid = kid . next ) {
kid . reverseChildren () ;
}
}
}
