@Override
public void run ()
{
boolean result = false ;
final byte buffer [] = new byte [ 32 ] ;
final long starttime = System . currentTimeMillis () ;
try
{
String readbytes = lr_1 ;
while( ! result &&
System . currentTimeMillis () - starttime < _timeout )
{
if( _is . available () > 0 )
{
final int ret_read = _is . read ( buffer ) ;
readbytes = readbytes + new String ( buffer , 0 , ret_read ) ;
for( int ii = 0 ; ii < _inputs . length ; ii ++ )
{
if( readbytes . indexOf ( _inputs [ ii ] ) >= 0 )
{
Thread . sleep ( 1000 * ii ) ;
_os . write ( _outputs [ ii ] . getBytes () ) ;
result = true ;
}
}
}
else
{
Thread . sleep ( 500 ) ;
}
}
}
catch ( final Exception e )
{
System . err . println ( lr_2 + e . getMessage () ) ;
}
}
