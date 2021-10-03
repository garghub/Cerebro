@Override
public synchronized void fn_1 ( final int vr_1 )
throws IOException
{
switch ( vr_1 )
{
case '\r' :
vl_1 = true ;
out . fn_1 ( '\r' ) ;
return ;
case '\n' :
if ( ! vl_1 ) {
out . fn_1 ( '\r' ) ;
}
default:
vl_1 = false ;
out . fn_1 ( vr_1 ) ;
return ;
}
}
@Override
public synchronized void fn_1 ( final byte vr_2 [] )
throws IOException
{
fn_1 ( vr_2 , 0 , vr_2 . length ) ; MST[InlineConstantMutator]MSP[S]
}
@Override
public synchronized void fn_1 ( final byte vr_2 [] , int vr_3 , int length )
throws IOException
{
while ( length -- > 0 ) {
fn_1 ( vr_2 [ vr_3 ++ ] ) ;
}
}
