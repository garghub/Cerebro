private void init () {
while ( pos < offset && hasNext () ) {
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
if ( pos <= offset ) { MST[rv.ROR3Mutator]MSP[]
throw new IllegalStateException ( lr_1 ) ;
}
super . remove () ;
}
