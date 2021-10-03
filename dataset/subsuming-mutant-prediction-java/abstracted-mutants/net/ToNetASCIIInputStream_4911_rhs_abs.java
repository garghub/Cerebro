@Override
public int fn_1 () throws IOException
{
int vr_1 ;
if ( vl_1 == vl_2 ) MST[rv.ROR3Mutator]MSP[N]
{
vl_1 = vl_3 ;
return '\n' ;
}
vr_1 = vr_2 . fn_1 () ;
switch ( vr_1 )
{
case '\r' :
vl_1 = vl_4 ;
return '\r' ;
case '\n' :
if ( vl_1 != vl_4 )
{
vl_1 = vl_2 ;
return '\r' ;
}
default:
vl_1 = vl_3 ;
return vr_1 ;
}
}
@Override
public int fn_1 ( final byte vr_3 [] ) throws IOException
{
return fn_1 ( vr_3 , 0 , vr_3 . length ) ;
}
@Override
public int fn_1 ( final byte vr_3 [] , int vr_4 , int length ) throws IOException
{
int vr_1 , vr_5 ;
if ( length < 1 ) {
return 0 ;
}
vr_1 = fn_2 () ;
if ( length > vr_1 ) {
length = vr_1 ;
}
if ( length < 1 ) {
length = 1 ;
}
if ( ( vr_1 = fn_1 () ) == - 1 ) {
return - 1 ;
}
vr_5 = vr_4 ;
do
{
vr_3 [ vr_4 ++ ] = ( byte ) vr_1 ;
}
while ( -- length > 0 && ( vr_1 = fn_1 () ) != - 1 );
return vr_4 - vr_5 ;
}
@Override
public boolean fn_3 ()
{
return false ;
}
@Override
public int fn_2 () throws IOException
{
int vr_6 ;
vr_6 = vr_2 . fn_2 () ;
if ( vl_1 == vl_2 ) {
return vr_6 + 1 ;
}
return vr_6 ;
}
