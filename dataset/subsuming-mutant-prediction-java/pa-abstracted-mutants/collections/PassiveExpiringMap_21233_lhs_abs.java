@Override
public long expirationTime ( final K key , final V value ) {
if ( timeToLiveMillis >= 0L ) {
final long now = System . currentTimeMillis () ;
if ( now > Long . MAX_VALUE - timeToLiveMillis ) {
return - 1 ;
}
return now + timeToLiveMillis ;
}
return - 1L ;
}
private static long validateAndConvertToMillis ( final long timeToLive ,
final TimeUnit timeUnit ) {
Objects . requireNonNull ( timeUnit , lr_1 ) ;
return TimeUnit . MILLISECONDS . convert ( timeToLive , timeUnit ) ;
}
@Override
public void clear () {
super . clear () ;
expirationMap . clear () ;
}
@Override
public boolean containsKey ( final Object key ) {
removeIfExpired ( key , now () ) ;
return super . containsKey ( key ) ;
}
@Override
public boolean containsValue ( final Object value ) {
removeAllExpired ( now () ) ;
return super . containsValue ( value ) ;
}
@Override
public Set < Entry < K , V > > entrySet () {
removeAllExpired ( now () ) ;
return super . entrySet () ;
}
@Override
public V get ( final Object key ) {
removeIfExpired ( key , now () ) ;
return super . get ( key ) ;
}
@Override
public boolean isEmpty () {
removeAllExpired ( now () ) ;
return super . isEmpty () ;
}
private boolean isExpired ( final long now , final Long expirationTimeObject ) {
if ( expirationTimeObject != null ) {
final long expirationTime = expirationTimeObject . longValue () ;
return expirationTime >= 0 && now >= expirationTime ;
}
return false ;
}
@Override
public Set < K > keySet () {
removeAllExpired ( now () ) ;
return super . keySet () ;
}
private long now () {
return System . currentTimeMillis () ;
}
@Override
public V put ( final K key , final V value ) {
removeIfExpired ( key , now () ) ;
final long expirationTime = expiringPolicy . expirationTime ( key , value ) ;
expirationMap . put ( key , Long . valueOf ( expirationTime ) ) ;
return super . put ( key , value ) ;
}
@Override
public void putAll ( final Map < ? extends K , ? extends V > mapToCopy ) {
for ( final Map . Entry < ? extends K , ? extends V > entry : mapToCopy . entrySet () ) {
put ( entry . getKey () , entry . getValue () ) ;
}
}
@Override
public V remove ( final Object key ) {
expirationMap . remove ( key ) ;
return super . remove ( key ) ;
}
private void removeAllExpired ( final long now ) {
final Iterator < Map . Entry < Object , Long > > iter = expirationMap . entrySet () . iterator () ;
while ( iter . hasNext () ) {
final Map . Entry < Object , Long > expirationEntry = iter . next () ;
if ( isExpired ( now , expirationEntry . getValue () ) ) {
super . remove ( expirationEntry . getKey () ) ;
iter . remove () ;
}
}
}
private void removeIfExpired ( final Object key , final long now ) {
final Long expirationTimeObject = expirationMap . get ( key ) ;
if ( isExpired ( now , expirationTimeObject ) ) { MST[rv.UOI2Mutator]MSP[]
remove ( key ) ;
}
}
@Override
public int size () {
removeAllExpired ( now () ) ;
return super . size () ;
}
@SuppressWarnings ( lr_2 )
private void readObject ( final ObjectInputStream in )
throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
map = ( Map < K , V > ) in . readObject () ;
}
private void writeObject ( final ObjectOutputStream out )
throws IOException {
out . defaultWriteObject () ;
out . writeObject ( map ) ;
}
@Override
public Collection < V > values () {
removeAllExpired ( now () ) ;
return super . values () ;
}
