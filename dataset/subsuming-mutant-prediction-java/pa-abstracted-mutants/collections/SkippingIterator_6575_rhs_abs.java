private void init () {
while ( pos < offset && hasNext () ) { MST[rv.UOI3Mutator]MSP[N]
next () ;
}
}
@Override
public E next () {
final E next = super . next () ;
pos ++ ;
return next ;
}
@Override
public void remove () {
if ( pos <= offset ) {
throw new IllegalStateException ( lr_1 ) ;
}
super . remove () ;
}
