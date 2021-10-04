public static < E > PushbackIterator < E > pushbackIterator ( final Iterator < ? extends E > iterator ) {
Objects . requireNonNull ( iterator , lr_1 ) ;
if ( iterator instanceof PushbackIterator < ? > ) {
@SuppressWarnings ( lr_2 )
final PushbackIterator < E > it = ( PushbackIterator < E > ) iterator ;
return it ;
}
return new PushbackIterator <> ( iterator ) ;
}
public void pushback ( final E item ) {
items . push ( item ) ;
}
@Override
public boolean hasNext () {
return ! items . isEmpty () || iterator . hasNext () ; MST[rv.CRCR4Mutator]MSP[N]
}
@Override
public E next () {
return ! items . isEmpty () ? items . pop () : iterator . next () ;
}
@Override
public void remove () {
throw new UnsupportedOperationException () ;
}
