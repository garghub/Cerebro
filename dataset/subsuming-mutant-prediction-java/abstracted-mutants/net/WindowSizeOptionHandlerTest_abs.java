@Override
protected void fn_1 ()
{
vl_1 = new fn_2 ( 80 , 24 ) ;
vl_2 = new fn_2 ( 255 , 255 , true , true , true , true ) ;
vl_3 = new fn_2 ( 0xFFFF , 0x00FF , false , false , false , false ) ;
}
@Override
public void fn_3 ()
{
fn_4 ( vr_1 . vr_2 , vl_1 . vr_3 () ) ;
super . fn_3 () ;
}
@Override
public void fn_5 ()
{
fn_6 ( vl_1 . vr_4 () ) ;
fn_6 ( vl_2 . vr_4 () ) ;
fn_6 ( vl_3 . vr_4 () ) ;
}
public void fn_7 ()
{
final int [] vr_5 = { 31 , 0 , 80 , 0 , 24 } ;
final int [] vr_6 = vl_1 . vr_7 () ;
fn_4 ( 5 , vr_6 . length ) ;
fn_8 ( vr_5 , vr_6 ) ;
final int [] vr_8 = { 31 , 0 , 255 , 255 , 0 , 255 , 255 } ;
final int [] vr_9 = vl_2 . vr_7 () ;
fn_8 ( vr_8 , vr_9 ) ;
final int [] vr_10 = { 31 , 255 , 255 , 255 , 255 , 0 , 255 , 255 } ;
final int [] vr_11 = vl_3 . vr_7 () ;
fn_8 ( vr_10 , vr_11 ) ;
}
@Override
public void fn_9 ()
{
final int vr_12 [] =
{
vr_1 . vr_2 , 24 , 80
} ;
final int vr_13 [] = vl_1 . vr_14 ( vr_12 , vr_12 . length ) ;
final int vr_15 [] = vl_2 . vr_14 ( vr_12 , vr_12 . length ) ;
final int vr_16 [] = vl_3 . vr_14 ( vr_12 , vr_12 . length ) ;
fn_6 ( vr_13 ) ;
fn_6 ( vr_15 ) ;
fn_6 ( vr_16 ) ;
}
private void fn_8 ( final int vr_17 [] , final int vr_18 [] )
{
fn_4 ( lr_1 , vr_17 . length , vr_18 . length ) ;
for( int vr_19 = 0 ; vr_19 < vr_17 . length ; vr_19 ++ )
{
fn_4 ( lr_2 + vr_19 + lr_3 , vr_17 [ vr_19 ] , vr_18 [ vr_19 ] ) ;
}
}
