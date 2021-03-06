@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return ch == buffer [ pos ] ? 1 : 0 ;
}
@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return Arrays . binarySearch ( chars , buffer [ pos ] ) >= 0 ? 1 : 0 ;
}
@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return 0 ;
}
@Override
public int isMatch ( final char [] buffer , int pos , final int bufferStart , final int bufferEnd ) {
final int len = chars . length ;
if ( pos + len > bufferEnd ) {
return 0 ;
}
for ( int i = 0 ; i < chars . length ; i ++ , pos ++ ) {
if ( chars [ i ] != buffer [ pos ] ) {
return 0 ;
}
}
return len ;
}
@Override
public String toString () {
return super . toString () + ' ' + Arrays . toString ( chars ) ;
}
@Override
public int isMatch ( final char [] buffer , final int pos , final int bufferStart , final int bufferEnd ) {
return buffer [ pos ] <= SPACE_INT ? 1 : 0 ;
}
public int isMatch ( final char [] buffer , final int pos ) {
return isMatch ( buffer , pos , 0 , buffer . length ) ;
}
