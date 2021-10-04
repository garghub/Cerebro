private void init () {
while ( pos < offset && hasNext () ) {
next () ;
}
}
@Override
public E next () {
final E next = super . next () ;
pos ++ ; MST[experimental.MemberVariableMutator]MSP[]
return next ;
}
@Override
public void remove () {
if ( pos <= offset ) {
throw new IllegalStateException ( lr_1 ) ;
}
super . remove () ;
}
