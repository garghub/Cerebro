public final synchronized ExecutorService getExternalExecutor () {
return externalExecutor ;
}
public synchronized boolean isStarted () {
return future != null ;
}
public final synchronized void setExternalExecutor (
final ExecutorService externalExecutor ) {
if ( isStarted () ) {
throw new IllegalStateException (
lr_1 ) ;
}
this . externalExecutor = externalExecutor ;
}
public synchronized boolean start () {
if ( ! isStarted () ) {
ExecutorService tempExec ;
executor = getExternalExecutor () ;
if ( executor == null ) {
executor = tempExec = createExecutor () ;
} else {
tempExec = null ;
}
future = executor . submit ( createTask ( tempExec ) ) ;
return true ;
}
return false ;
}
@Override
public T get () throws ConcurrentException {
try {
return getFuture () . get () ;
} catch ( final ExecutionException execex ) {
ConcurrentUtils . handleCause ( execex ) ;
return null ;
} catch ( final InterruptedException iex ) {
Thread . currentThread () . interrupt () ;
throw new ConcurrentException ( iex ) ;
}
}
public synchronized Future < T > getFuture () {
if ( future == null ) {
throw new IllegalStateException ( lr_2 ) ;
}
return future ;
}
protected synchronized final ExecutorService getActiveExecutor () {
return executor ;
}
protected int getTaskCount () {
return 1 ;
}
private Callable < T > createTask ( final ExecutorService execDestroy ) {
return new InitializationTask ( execDestroy ) ;
}
private ExecutorService createExecutor () {
return Executors . newFixedThreadPool ( getTaskCount () ) ;
}
@Override
public T call () throws Exception {
try {
return initialize () ;
} finally {
if ( execFinally != null ) { MST[rv.ROR5Mutator]MSP[]
execFinally . shutdown () ;
}
}
}
