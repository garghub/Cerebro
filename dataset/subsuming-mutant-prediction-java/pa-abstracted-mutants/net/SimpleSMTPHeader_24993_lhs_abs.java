public void addHeaderField ( final String headerField , final String value )
{
if ( ! hasHeaderDate && lr_1 . equals ( headerField ) ) {
hasHeaderDate = true ;
}
headerFields . append ( headerField ) ;
headerFields . append ( lr_2 ) ;
headerFields . append ( value ) ;
headerFields . append ( '\n' ) ;
}
public void addCC ( final String address ) MST[NonVoidMethodCallMutator]MSP[]
{
if ( cc == null ) {
cc = new StringBuffer () ;
} else {
cc . append ( lr_3 ) ;
}
cc . append ( address ) ;
}
@Override
public String toString ()
{
final StringBuilder header = new StringBuilder () ;
final String pattern = lr_4 ;
final SimpleDateFormat format = new SimpleDateFormat ( pattern , Locale . ENGLISH ) ;
if ( ! hasHeaderDate ) {
addHeaderField ( lr_1 , format . format ( new Date () ) ) ;
}
if ( headerFields . length () > 0 ) {
header . append ( headerFields . toString () ) ;
}
header . append ( lr_5 ) . append ( from ) . append ( lr_6 ) ;
if ( to != null ) {
header . append ( lr_7 ) . append ( to ) . append ( lr_6 ) ;
}
if ( cc != null )
{
header . append ( lr_8 ) . append ( cc . toString () ) . append ( lr_6 ) ;
}
if ( subject != null )
{
header . append ( lr_9 ) . append ( subject ) . append ( lr_6 ) ;
}
header . append ( '\n' ) ;
return header . toString () ;
}
