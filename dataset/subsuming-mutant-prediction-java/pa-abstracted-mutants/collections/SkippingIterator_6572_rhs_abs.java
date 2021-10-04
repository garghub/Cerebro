private void init () {
while ( pos < offset && hasNext () ) {
next () ;
}
}
@Override
public E next () {
final E next = super . next () ;
pos ++ ; MST[rv.AOR3Mutator]MSP[N]
return next ;
}
@Override
public void remove () {
if ( pos <= offset ) {
throw new IllegalStateException ( lr_1 ) ;
}
super . remove () ;
}
