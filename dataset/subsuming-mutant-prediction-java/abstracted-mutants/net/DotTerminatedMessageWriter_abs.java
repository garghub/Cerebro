@Override
public void fn_1 ( final int vr_1 ) throws IOException
{
synchronized ( vl_1 )
{
switch ( vr_1 )
{
case '\r' :
vl_2 = vl_3 ;
vr_2 . fn_1 ( '\r' ) ;
return ;
case '\n' :
if ( vl_2 != vl_3 ) {
vr_2 . fn_1 ( '\r' ) ;
}
vr_2 . fn_1 ( '\n' ) ;
vl_2 = vl_4 ;
return ;
case '.' :
if ( vl_2 == vl_4 ) {
vr_2 . fn_1 ( '.' ) ;
}
default:
vl_2 = vl_5 ;
vr_2 . fn_1 ( vr_1 ) ;
return ;
}
}
}
@Override
public void fn_1 ( final char [] vr_3 , int vr_4 , int length ) throws IOException
{
synchronized ( vl_1 )
{
while ( length -- > 0 ) {
fn_1 ( vr_3 [ vr_4 ++ ] ) ;
}
}
}
@Override
public void fn_1 ( final char [] vr_3 ) throws IOException
{
fn_1 ( vr_3 , 0 , vr_3 . length ) ;
}
@Override
public void fn_1 ( final String string ) throws IOException
{
fn_1 ( string . vr_5 () ) ;
}
@Override
public void fn_1 ( final String string , final int vr_4 , final int length ) throws IOException
{
fn_1 ( string . vr_5 () , vr_4 , length ) ;
}
@Override
public void fn_2 () throws IOException
{
synchronized ( vl_1 )
{
vr_2 . fn_2 () ;
}
}
@Override
public void fn_3 () throws IOException
{
synchronized ( vl_1 )
{
if ( vr_2 == null ) {
return ;
}
if ( vl_2 == vl_3 ) {
vr_2 . fn_1 ( '\n' ) ;
} else if ( vl_2 != vl_4 ) {
vr_2 . fn_1 ( lr_1 ) ;
}
vr_2 . fn_1 ( lr_2 ) ;
vr_2 . fn_2 () ;
vr_2 = null ;
}
}
