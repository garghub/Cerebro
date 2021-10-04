@Override
public void write ( final int ch ) throws IOException
{
synchronized ( lock )
{
switch ( ch )
{
case '\r' :
state = LAST_WAS_CR_STATE ;
output . write ( '\r' ) ;
return ;
case '\n' :
if ( state != LAST_WAS_CR_STATE ) {
output . write ( '\r' ) ;
}
output . write ( '\n' ) ;
state = LAST_WAS_NL_STATE ;
return ;
case '.' :
if ( state == LAST_WAS_NL_STATE ) {
output . write ( '.' ) ;
}
default:
state = NOTHING_SPECIAL_STATE ;
output . write ( ch ) ;
return ;
}
}
}
@Override
public void write ( final char [] buffer , int offset , int length ) throws IOException
{
synchronized ( lock )
{
while ( length -- > 0 ) {
write ( buffer [ offset ++ ] ) ;
}
}
}
@Override
public void write ( final char [] buffer ) throws IOException
{
write ( buffer , 0 , buffer . length ) ;
}
@Override
public void write ( final String string ) throws IOException
{
write ( string . toCharArray () ) ;
}
@Override
public void write ( final String string , final int offset , final int length ) throws IOException
{
write ( string . toCharArray () , offset , length ) ;
}
@Override
public void flush () throws IOException
{
synchronized ( lock )
{
output . flush () ;
}
}
@Override
public void close () throws IOException
{
synchronized ( lock )
{
if ( output == null ) {
return ;
}
if ( state == LAST_WAS_CR_STATE ) {
output . write ( '\n' ) ;
} else if ( state != LAST_WAS_NL_STATE ) {
output . write ( lr_1 ) ;
}
output . write ( lr_2 ) ;
output . flush () ;
output = null ;
}
}
