private void fn_1 ( final int vr_1 ) throws IOException
{
switch ( vr_1 )
{
case '\r' :
vl_1 = true ;
break;
case '\n' :
if ( vl_1 )
{
out . vr_2 ( vr_3 . vr_4 ) ;
vl_1 = false ;
break;
}
vl_1 = false ;
out . vr_2 ( '\n' ) ;
break;
default:
if ( vl_1 )
{
out . vr_2 ( '\r' ) ;
vl_1 = false ;
}
out . vr_2 ( vr_1 ) ;
break;
}
}
@Override
public synchronized void vr_2 ( final int vr_1 )
throws IOException
{
if ( vr_3 . vr_5 )
{
out . vr_2 ( vr_1 ) ;
return ;
}
fn_1 ( vr_1 ) ;
}
@Override
public synchronized void vr_2 ( final byte vr_6 [] )
throws IOException
{
vr_2 ( vr_6 , 0 , vr_6 . length ) ;
}
@Override
public synchronized void vr_2 ( final byte vr_6 [] , int vr_7 , int length )
throws IOException
{
if ( vr_3 . vr_5 )
{
out . vr_2 ( vr_6 , vr_7 , length ) ;
return ;
}
while ( length -- > 0 ) { MST[RemoveConditionalMutator_ORDER_ELSE]MSP[]
fn_1 ( vr_6 [ vr_7 ++ ] ) ;
}
}
@Override
public synchronized void fn_2 ()
throws IOException
{
if ( vr_3 . vr_5 )
{
super . fn_2 () ;
return ;
}
if ( vl_1 ) {
out . vr_2 ( '\r' ) ;
}
super . fn_2 () ;
}
