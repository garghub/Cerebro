@Override
protected void fn_1 ()
{
vl_1 = new fn_2 ( lr_1 ) ;
vl_2 = new fn_2 ( lr_2 , true , true , true , true ) ;
vl_3 = new fn_2 ( lr_2 , false , false , false , false ) ;
}
@Override
public void fn_3 ()
{
fn_4 ( vl_1 . vr_1 () , vr_2 . vr_3 ) ;
super . fn_3 () ;
}
@Override
public void fn_5 ()
{
final int vr_4 [] = vl_1 . vr_5 () ;
final int vr_6 [] = vl_1 . vr_7 () ;
fn_4 ( vr_4 , null ) ;
fn_4 ( vr_6 , null ) ;
}
@Override
public void fn_6 ()
{
final int vr_8 [] =
{
vr_2 . vr_3 , 1
} ;
final int vr_9 [] =
{
vr_2 . vr_3 , 0 , 'V' , 'T' , '1' , '0' , '0'
} ;
final int vr_10 [] =
{
vr_2 . vr_3 , 0 , 'A' , 'N' , 'S' , 'I'
} ;
final int vr_4 [] = vl_1 . vr_11 ( vr_8 , vr_8 . length ) ;
final int vr_6 [] = vl_2 . vr_11 ( vr_8 , vr_8 . length ) ;
fn_7 ( fn_8 ( vr_4 , vr_9 ) ) ;
fn_7 ( fn_8 ( vr_6 , vr_10 ) ) ;
}
protected boolean fn_8 ( final int vr_12 [] , final int vr_13 [] )
{
if( vr_12 . length != vr_13 . length )
{
return false ;
}
boolean vr_14 = true ;
for( int vr_15 = 0 ; vr_15 < vr_12 . length ; vr_15 ++ )
{
if( vr_12 [ vr_15 ] != vr_13 [ vr_15 ] ) {
vr_14 = false ;
}
}
return vr_14 ;
}
