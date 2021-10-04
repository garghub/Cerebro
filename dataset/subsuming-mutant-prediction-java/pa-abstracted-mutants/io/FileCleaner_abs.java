@Deprecated
public static void track ( final File file , final Object marker ) {
theInstance . track ( file , marker ) ;
}
@Deprecated
public static void track ( final File file , final Object marker , final FileDeleteStrategy deleteStrategy ) {
theInstance . track ( file , marker , deleteStrategy ) ;
}
@Deprecated
public static void track ( final String path , final Object marker ) {
theInstance . track ( path , marker ) ;
}
@Deprecated
public static void track ( final String path , final Object marker , final FileDeleteStrategy deleteStrategy ) {
theInstance . track ( path , marker , deleteStrategy ) ;
}
@Deprecated
public static int getTrackCount () {
return theInstance . getTrackCount () ;
}
@Deprecated
public static synchronized void exitWhenFinished () {
theInstance . exitWhenFinished () ;
}
public static FileCleaningTracker getInstance () {
return theInstance ;
}
