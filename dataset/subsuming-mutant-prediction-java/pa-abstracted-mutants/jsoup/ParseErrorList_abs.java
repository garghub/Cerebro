boolean canAddError () {
return size () < maxSize ;
}
int getMaxSize () {
return maxSize ;
}
public static ParseErrorList noTracking () {
return new ParseErrorList ( 0 , 0 ) ;
}
public static ParseErrorList tracking ( int maxSize ) {
return new ParseErrorList ( INITIAL_CAPACITY , maxSize ) ;
}
