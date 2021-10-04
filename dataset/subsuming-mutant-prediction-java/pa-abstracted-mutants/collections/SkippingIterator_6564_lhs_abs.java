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
if ( pos <= offset ) { MST[RemoveConditionalMutator_ORDER_IF]MSP[]
throw new IllegalStateException ( lr_1 ) ;
}
super . remove () ;
}
