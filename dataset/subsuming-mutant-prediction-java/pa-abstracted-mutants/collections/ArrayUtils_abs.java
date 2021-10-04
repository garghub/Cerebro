static boolean contains ( final Object [] array , final Object objectToFind ) {
return indexOf ( array , objectToFind ) != INDEX_NOT_FOUND ;
}
static < T > int indexOf ( final T [] array , final Object objectToFind ) {
return indexOf ( array , objectToFind , 0 ) ;
}
static int indexOf ( final Object [] array , final Object objectToFind , int startIndex ) {
if ( array == null ) {
return INDEX_NOT_FOUND ;
}
if ( startIndex < 0 ) {
startIndex = 0 ;
}
if ( objectToFind == null ) {
for ( int i = startIndex ; i < array . length ; i ++ ) {
if ( array [ i ] == null ) {
return i ;
}
}
} else {
for ( int i = startIndex ; i < array . length ; i ++ ) {
if ( objectToFind . equals ( array [ i ] ) ) {
return i ;
}
}
}
return INDEX_NOT_FOUND ;
}
