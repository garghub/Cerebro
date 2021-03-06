protected int getMaximumCacheSize () {
return maximumCacheSize ;
}
protected void setMaximumCacheSize ( final int maximumCacheSize ) {
this . maximumCacheSize = maximumCacheSize ;
shrinkCacheToMaximumSize () ;
}
protected void shrinkCacheToMaximumSize () {
while ( cacheSize > maximumCacheSize ) {
getNodeFromCache () ;
}
}
protected Node < E > getNodeFromCache () {
if ( cacheSize == 0 ) {
return null ;
}
final Node < E > cachedNode = firstCachedNode ;
firstCachedNode = cachedNode . next ;
cachedNode . next = null ;
cacheSize -- ;
return cachedNode ;
}
protected boolean isCacheFull () {
return cacheSize >= maximumCacheSize ;
}
protected void addNodeToCache ( final Node < E > node ) {
if ( isCacheFull () ) {
return;
}
final Node < E > nextCachedNode = firstCachedNode ;
node . previous = null ;
node . next = nextCachedNode ;
node . setValue ( null ) ;
firstCachedNode = node ;
cacheSize ++ ;
}
@Override
protected Node < E > createNode ( final E value ) {
final Node < E > cachedNode = getNodeFromCache () ;
if ( cachedNode == null ) {
return super . createNode ( value ) ;
}
cachedNode . setValue ( value ) ;
return cachedNode ;
}
@Override
protected void removeNode ( final Node < E > node ) {
super . removeNode ( node ) ;
addNodeToCache ( node ) ;
}
@Override
protected void removeAllNodes () {
final int numberOfNodesToCache = Math . min ( size , maximumCacheSize - cacheSize ) ;
Node < E > node = header . next ;
for ( int currentIndex = 0 ; currentIndex < numberOfNodesToCache ; currentIndex ++ ) {
final Node < E > oldNode = node ;
node = node . next ;
addNodeToCache ( oldNode ) ;
}
super . removeAllNodes () ;
}
private void writeObject ( final ObjectOutputStream out ) throws IOException {
out . defaultWriteObject () ;
doWriteObject ( out ) ;
}
private void readObject ( final ObjectInputStream in ) throws IOException , ClassNotFoundException {
in . defaultReadObject () ;
doReadObject ( in ) ;
}
