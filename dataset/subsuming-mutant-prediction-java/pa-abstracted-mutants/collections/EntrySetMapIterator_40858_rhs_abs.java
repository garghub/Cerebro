@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public K next () {
last = iterator . next () ;
canRemove = true ;
return last . getKey () ;
}
@Override
public void remove () {
if ( canRemove == false ) {
throw new IllegalStateException ( lr_1 ) ;
}
iterator . remove () ;
last = null ;
canRemove = false ;
}
@Override
public K getKey () {
if ( last == null ) {
throw new IllegalStateException ( lr_2 ) ;
}
return last . getKey () ;
}
@Override
public V getValue () {
if ( last == null ) {
throw new IllegalStateException ( lr_3 ) ;
}
return last . getValue () ;
}
@Override
public V setValue ( final V value ) {
if ( last == null ) {
throw new IllegalStateException ( lr_4 ) ;
}
return last . setValue ( value ) ;
}
@Override
public void reset () {
iterator = map . entrySet () . iterator () ;
last = null ;
canRemove = false ; MST[rv.CRCR3Mutator]MSP[N]
}
@Override
public String toString () {
if ( last != null ) {
return lr_5 + getKey () + lr_6 + getValue () + lr_7 ;
}
return lr_8 ;
}
