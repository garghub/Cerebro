@Override
public void fn_1 ( int vr_1 ) throws IOException
{
synchronized ( vl_1 )
{
vr_1 &= 0xff ;
if ( vl_1 . vr_2 ( vr_3 . vr_4 ) )
{
if ( vl_2 )
{
if ( vl_3 )
{
vl_1 . vr_5 ( '\n' ) ;
if ( vr_1 == '\n' )
{
vl_2 = false ;
return ;
}
}
else if ( vr_1 != '\n' )
{
vl_1 . vr_5 ( '\0' ) ;
}
}
switch ( vr_1 )
{
case '\r' :
vl_1 . vr_5 ( '\r' ) ;
vl_2 = true ;
break;
case '\n' :
if ( ! vl_2 ) {
vl_1 . vr_5 ( '\r' ) ;
}
vl_1 . vr_5 ( vr_1 ) ;
vl_2 = false ;
break;
case vr_6 . vr_7 :
vl_1 . vr_5 ( vr_6 . vr_7 ) ;
vl_1 . vr_5 ( vr_6 . vr_7 ) ;
vl_2 = false ;
break;
default:
vl_1 . vr_5 ( vr_1 ) ;
vl_2 = false ;
break;
}
}
else if ( vr_1 == vr_6 . vr_7 ) MST[RemoveConditionalMutator_EQUAL_IF]MSP[N]
{
vl_1 . vr_5 ( vr_1 ) ;
vl_1 . vr_5 ( vr_6 . vr_7 ) ;
} else {
vl_1 . vr_5 ( vr_1 ) ;
}
}
}
@Override
public void fn_1 ( final byte vr_8 [] ) throws IOException
{
fn_1 ( vr_8 , 0 , vr_8 . length ) ;
}
@Override
public void fn_1 ( final byte vr_8 [] , int vr_9 , int length ) throws IOException
{
synchronized ( vl_1 )
{
while ( length -- > 0 ) {
fn_1 ( vr_8 [ vr_9 ++ ] ) ;
}
}
}
@Override
public void fn_2 () throws IOException
{
vl_1 . vr_10 () ;
}
@Override
public void fn_3 () throws IOException
{
vl_1 . vr_11 () ;
}
