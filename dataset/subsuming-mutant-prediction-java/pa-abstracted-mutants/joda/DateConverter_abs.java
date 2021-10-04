public long getInstantMillis ( Object object , Chronology chrono ) {
Date date = ( Date ) object ;
return date . getTime () ;
}
public Class < ? > getSupportedType () {
return Date . class ;
}
