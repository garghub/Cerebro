public long getInterval () {
return interval ;
}
public synchronized void setThreadFactory ( final ThreadFactory threadFactory ) {
this . threadFactory = threadFactory ;
}
public void addObserver ( final FileAlterationObserver observer ) {
if ( observer != null ) {
observers . add ( observer ) ;
}
}
public void removeObserver ( final FileAlterationObserver observer ) {
if ( observer != null ) {
while ( observers . remove ( observer ) ) {
}
}
}
public Iterable < FileAlterationObserver > getObservers () {
return observers ;
}
public synchronized void start () throws Exception {
if ( running ) {
throw new IllegalStateException ( lr_1 ) ;
}
for ( final FileAlterationObserver observer : observers ) {
observer . initialize () ;
}
running = true ;
if ( threadFactory != null ) {
thread = threadFactory . newThread ( this ) ;
} else {
thread = new Thread ( this ) ;
}
thread . start () ;
}
public synchronized void stop () throws Exception {
stop ( interval ) ;
}
public synchronized void stop ( final long stopInterval ) throws Exception {
if ( running == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
running = false ;
try {
thread . interrupt () ;
thread . join ( stopInterval ) ;
} catch ( final InterruptedException e ) {
Thread . currentThread () . interrupt () ;
}
for ( final FileAlterationObserver observer : observers ) {
observer . destroy () ;
}
}
@Override
public void run () {
while ( running ) {
for ( final FileAlterationObserver observer : observers ) {
observer . checkAndNotify () ;
}
if ( ! running ) {
break;
}
try {
Thread . sleep ( interval ) ;
} catch ( final InterruptedException ignored ) {
}
}
}
