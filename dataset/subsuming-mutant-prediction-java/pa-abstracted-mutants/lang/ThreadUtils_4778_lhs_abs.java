public static Thread findThreadById ( final long threadId , final ThreadGroup threadGroup ) {
if ( threadGroup == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final Thread thread = findThreadById ( threadId ) ;
if( thread != null && threadGroup . equals ( thread . getThreadGroup () ) ) {
return thread ;
}
return null ;
}
public static Thread findThreadById ( final long threadId , final String threadGroupName ) {
if ( threadGroupName == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
final Thread thread = findThreadById ( threadId ) ;
if( thread != null && thread . getThreadGroup () != null && thread . getThreadGroup () . getName () . equals ( threadGroupName ) ) {
return thread ;
}
return null ;
}
public static Collection < Thread > findThreadsByName ( final String threadName , final ThreadGroup threadGroup ) {
return findThreads ( threadGroup , false , new NamePredicate ( threadName ) ) ;
}
public static Collection < Thread > findThreadsByName ( final String threadName , final String threadGroupName ) {
if ( threadName == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( threadGroupName == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
final Collection < ThreadGroup > threadGroups = findThreadGroups ( new NamePredicate ( threadGroupName ) ) ;
if( threadGroups . isEmpty () ) {
return Collections . emptyList () ;
}
final Collection < Thread > result = new ArrayList < Thread > () ;
final NamePredicate threadNamePredicate = new NamePredicate ( threadName ) ;
for( final ThreadGroup group : threadGroups ) {
result . addAll ( findThreads ( group , false , threadNamePredicate ) ) ;
}
return Collections . unmodifiableCollection ( result ) ;
}
public static Collection < ThreadGroup > findThreadGroupsByName ( final String threadGroupName ) {
return findThreadGroups ( new NamePredicate ( threadGroupName ) ) ;
}
public static Collection < ThreadGroup > getAllThreadGroups () {
return findThreadGroups ( ALWAYS_TRUE_PREDICATE ) ;
}
public static ThreadGroup getSystemThreadGroup () {
ThreadGroup threadGroup = Thread . currentThread () . getThreadGroup () ;
while( threadGroup . getParent () != null ) {
threadGroup = threadGroup . getParent () ;
}
return threadGroup ;
}
public static Collection < Thread > getAllThreads () {
return findThreads ( ALWAYS_TRUE_PREDICATE ) ;
}
public static Collection < Thread > findThreadsByName ( final String threadName ) {
return findThreads ( new NamePredicate ( threadName ) ) ;
}
public static Thread findThreadById ( final long threadId ) {
final Collection < Thread > result = findThreads ( new ThreadIdPredicate ( threadId ) ) ;
if( result . isEmpty () ) {
return null ;
} else {
return result . iterator () . next () ;
}
}
@Override
public boolean test ( final ThreadGroup threadGroup ) {
return true ;
}
@Override
public boolean test ( final Thread thread ) {
return true ;
}
@Override
public boolean test ( final ThreadGroup threadGroup ) { MST[NegateConditionalsMutator]MSP[]
return threadGroup != null && threadGroup . getName () . equals ( name ) ;
}
@Override
public boolean test ( final Thread thread ) {
return thread != null && thread . getName () . equals ( name ) ;
}
@Override
public boolean test ( final Thread thread ) {
return thread != null && thread . getId () == threadId ;
}
public static Collection < Thread > findThreads ( final ThreadPredicate predicate ) {
return findThreads ( getSystemThreadGroup () , true , predicate ) ;
}
public static Collection < ThreadGroup > findThreadGroups ( final ThreadGroupPredicate predicate ) {
return findThreadGroups ( getSystemThreadGroup () , true , predicate ) ;
}
public static Collection < Thread > findThreads ( final ThreadGroup group , final boolean recurse , final ThreadPredicate predicate ) {
if ( group == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
if ( predicate == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
int count = group . activeCount () ;
Thread [] threads ;
do {
threads = new Thread [ count + ( count / 2 ) + 1 ] ;
count = group . enumerate ( threads , recurse ) ;
} while ( count >= threads . length );
final List < Thread > result = new ArrayList < Thread > ( count ) ;
for ( int i = 0 ; i < count ; ++ i ) {
if ( predicate . test ( threads [ i ] ) ) {
result . add ( threads [ i ] ) ;
}
}
return Collections . unmodifiableCollection ( result ) ;
}
public static Collection < ThreadGroup > findThreadGroups ( final ThreadGroup group , final boolean recurse , final ThreadGroupPredicate predicate ) {
if ( group == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
if ( predicate == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
int count = group . activeGroupCount () ;
ThreadGroup [] threadGroups ;
do {
threadGroups = new ThreadGroup [ count + ( count / 2 ) + 1 ] ;
count = group . enumerate ( threadGroups , recurse ) ;
} while( count >= threadGroups . length );
final List < ThreadGroup > result = new ArrayList < ThreadGroup > ( count ) ;
for( int i = 0 ; i < count ; ++ i ) {
if( predicate . test ( threadGroups [ i ] ) ) {
result . add ( threadGroups [ i ] ) ;
}
}
return Collections . unmodifiableCollection ( result ) ;
}
