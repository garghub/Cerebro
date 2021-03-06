@Override
public K getKey () {
return current () . getKey () ;
}
@Override
public V getValue () {
return current () . getValue () ;
}
@Override
public V setValue ( final V value ) {
return current () . setValue ( value ) ;
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public K next () {
entry = iterator . next () ;
return getKey () ;
}
@Override
public synchronized void reset () {
iterator = entrySet . iterator () ;
}
@Override
public void remove () {
iterator . remove () ;
entry = null ;
}
protected synchronized Map . Entry < K , V > current () {
if ( entry == null ) {
throw new IllegalStateException () ;
}
return entry ;
}
