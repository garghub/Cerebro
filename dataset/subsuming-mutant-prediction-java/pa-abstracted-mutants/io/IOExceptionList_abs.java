public < T extends Throwable > List < T > getCauseList () {
return ( List < T > ) causeList ;
}
public < T extends Throwable > T getCause ( final int index ) {
return ( T ) causeList . get ( index ) ;
}
public < T extends Throwable > T getCause ( final int index , final Class < T > clazz ) {
return ( T ) causeList . get ( index ) ;
}
public < T extends Throwable > List < T > getCauseList ( final Class < T > clazz ) {
return ( List < T > ) causeList ;
}
