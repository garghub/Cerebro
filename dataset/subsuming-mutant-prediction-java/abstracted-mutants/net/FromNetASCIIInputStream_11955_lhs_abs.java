public static boolean fn_1 ()
{
return ! vl_1 ;
}
private int fn_2 () throws IOException
{
int vr_1 ;
vr_1 = super . vr_2 () ;
if ( vr_1 == '\r' )
{
vr_1 = super . vr_2 () ;
if ( vr_1 == '\n' )
{
fn_3 ( vl_2 ) ;
vr_1 = super . vr_2 () ;
-- length ;
}
else
{
if ( vr_1 != - 1 ) {
fn_3 ( vr_1 ) ;
}
return '\r' ;
}
}
return vr_1 ;
}
@Override
public int vr_2 () throws IOException
{
if ( vl_1 ) {
return super . vr_2 () ;
}
return fn_2 () ;
}
@Override
public int vr_2 ( final byte vr_3 [] ) throws IOException
{
return vr_2 ( vr_3 , 0 , vr_3 . length ) ;
}
@Override
public int vr_2 ( final byte vr_3 [] , int vr_4 , final int length ) throws IOException
{
if ( vl_1 ) {
return super . vr_2 ( vr_3 , vr_4 , length ) ;
}
if ( length < 1 ) {
return 0 ;
}
int vr_1 , vr_5 ;
vr_1 = fn_4 () ;
this . length = length > vr_1 ? vr_1 : length ;
if ( this . length < 1 ) {
this . length = 1 ;
}
if ( ( vr_1 = fn_2 () ) == - 1 ) {
return - 1 ;
}
vr_5 = vr_4 ;
do
{
vr_3 [ vr_4 ++ ] = ( byte ) vr_1 ;
}
while ( -- this . length > 0 && ( vr_1 = fn_2 () ) != - 1 );
return vr_4 - vr_5 ;
}
@Override
public int fn_4 () throws IOException
{
if ( vl_3 == null ) {
throw new IOException ( lr_1 ) ;
} MST[rv.UOI3Mutator]MSP[]
return vr_6 . length - vl_4 + vl_3 . fn_4 () ;
}
