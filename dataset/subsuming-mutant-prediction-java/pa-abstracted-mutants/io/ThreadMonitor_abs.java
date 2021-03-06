public static Thread start ( final long timeout ) {
return start ( Thread . currentThread () , timeout ) ;
}
public static Thread start ( final Thread thread , final long timeout ) {
Thread monitor = null ;
if ( timeout > 0 ) {
final ThreadMonitor timout = new ThreadMonitor ( thread , timeout ) ;
monitor = new Thread ( timout , ThreadMonitor . class . getSimpleName () ) ;
monitor . setDaemon ( true ) ;
monitor . start () ;
}
return monitor ;
}
public static void stop ( final Thread thread ) {
if ( thread != null ) {
thread . interrupt () ;
}
}
@Override
public void run () {
try {
sleep ( timeout ) ;
thread . interrupt () ;
} catch ( final InterruptedException e ) {
}
}
private static void sleep ( final long ms ) throws InterruptedException {
final long finishAt = System . currentTimeMillis () + ms ;
long remaining = ms ;
do {
Thread . sleep ( remaining ) ;
remaining = finishAt - System . currentTimeMillis () ;
} while ( remaining > 0 );
}
