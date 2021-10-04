public void track ( final File file , final Object marker ) {
track ( file , marker , null ) ;
}
public void track ( final File file , final Object marker , final FileDeleteStrategy deleteStrategy ) {
if ( file == null ) {
throw new NullPointerException ( lr_1 ) ;
}
addTracker ( file . getPath () , marker , deleteStrategy ) ;
}
public void track ( final String path , final Object marker ) {
track ( path , marker , null ) ;
}
public void track ( final String path , final Object marker , final FileDeleteStrategy deleteStrategy ) {
if ( path == null ) {
throw new NullPointerException ( lr_2 ) ;
}
addTracker ( path , marker , deleteStrategy ) ;
}
private synchronized void addTracker ( final String path , final Object marker , final FileDeleteStrategy
deleteStrategy ) {
if ( exitWhenFinished ) {
throw new IllegalStateException ( lr_3 ) ;
}
if ( reaper == null ) {
reaper = new Reaper () ;
reaper . start () ;
}
trackers . add ( new Tracker ( path , deleteStrategy , marker , q ) ) ;
}
public int getTrackCount () {
return trackers . size () ;
}
public List < String > getDeleteFailures () {
return deleteFailures ;
}
public synchronized void exitWhenFinished () {
exitWhenFinished = true ;
if ( reaper != null ) {
synchronized ( reaper ) {
reaper . interrupt () ;
}
}
}
@Override
public void run () {
while ( exitWhenFinished == false || trackers . size () > 0 ) {
try {
final Tracker tracker = ( Tracker ) q . remove () ;
trackers . remove ( tracker ) ;
if ( ! tracker . delete () ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
deleteFailures . add ( tracker . getPath () ) ;
}
tracker . clear () ;
} catch ( final InterruptedException e ) {
continue;
}
}
}
public String getPath () {
return path ;
}
public boolean delete () {
return deleteStrategy . deleteQuietly ( new File ( path ) ) ;
}
