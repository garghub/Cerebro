public static StopWatch createStarted () {
StopWatch sw = new StopWatch () ;
sw . start () ;
return sw ;
}
@Override boolean isStarted () { return false ; }
@Override boolean isStopped () { return true ; } MST[rv.UOI3Mutator]MSP[]
@Override boolean isSuspended () { return false ; }
@Override boolean isStarted () { return true ; }
@Override boolean isStopped () { return false ; }
@Override boolean isSuspended () { return false ; }
@Override boolean isStarted () { return false ; }
@Override boolean isStopped () { return true ; }
@Override boolean isSuspended () { return false ; }
@Override boolean isStarted () { return true ; }
@Override boolean isStopped () { return false ; }
@Override boolean isSuspended () { return true ; }
public void start () {
if ( this . runningState == State . STOPPED ) {
throw new IllegalStateException ( lr_1 ) ;
}
if ( this . runningState != State . UNSTARTED ) {
throw new IllegalStateException ( lr_2 ) ;
}
this . startTime = System . nanoTime () ;
this . startTimeMillis = System . currentTimeMillis () ;
this . runningState = State . RUNNING ;
}
public void stop () {
if ( this . runningState != State . RUNNING && this . runningState != State . SUSPENDED ) {
throw new IllegalStateException ( lr_3 ) ;
}
if ( this . runningState == State . RUNNING ) {
this . stopTime = System . nanoTime () ;
}
this . runningState = State . STOPPED ;
}
public void reset () {
this . runningState = State . UNSTARTED ;
this . splitState = SplitState . UNSPLIT ;
}
public void split () {
if ( this . runningState != State . RUNNING ) {
throw new IllegalStateException ( lr_3 ) ;
}
this . stopTime = System . nanoTime () ;
this . splitState = SplitState . SPLIT ;
}
public void unsplit () {
if ( this . splitState != SplitState . SPLIT ) {
throw new IllegalStateException ( lr_4 ) ;
}
this . splitState = SplitState . UNSPLIT ;
}
public void suspend () {
if ( this . runningState != State . RUNNING ) {
throw new IllegalStateException ( lr_5 ) ;
}
this . stopTime = System . nanoTime () ;
this . runningState = State . SUSPENDED ;
}
public void resume () {
if ( this . runningState != State . SUSPENDED ) {
throw new IllegalStateException ( lr_6 ) ;
}
this . startTime += System . nanoTime () - this . stopTime ;
this . runningState = State . RUNNING ;
}
public long getTime () {
return getNanoTime () / NANO_2_MILLIS ;
}
public long getNanoTime () {
if ( this . runningState == State . STOPPED || this . runningState == State . SUSPENDED ) {
return this . stopTime - this . startTime ;
} else if ( this . runningState == State . UNSTARTED ) {
return 0 ;
} else if ( this . runningState == State . RUNNING ) {
return System . nanoTime () - this . startTime ;
}
throw new RuntimeException ( lr_7 ) ;
}
public long getSplitTime () {
return getSplitNanoTime () / NANO_2_MILLIS ;
}
public long getSplitNanoTime () {
if ( this . splitState != SplitState . SPLIT ) {
throw new IllegalStateException ( lr_8 ) ;
}
return this . stopTime - this . startTime ;
}
public long getStartTime () {
if ( this . runningState == State . UNSTARTED ) {
throw new IllegalStateException ( lr_9 ) ;
}
return this . startTimeMillis ;
}
@Override
public String toString () {
return DurationFormatUtils . formatDurationHMS ( getTime () ) ;
}
public String toSplitString () {
return DurationFormatUtils . formatDurationHMS ( getSplitTime () ) ;
}
public boolean isStarted () {
return runningState . isStarted () ;
}
public boolean isSuspended () {
return runningState . isSuspended () ;
}
public boolean isStopped () {
return runningState . isStopped () ;
}
