@df_1
public void fn_1 () throws Exception
{
fn_2 ( false , lr_1 , lr_1 ) ;
fn_2 ( false , lr_2 , lr_2 ) ;
fn_2 ( false , lr_3 , lr_3 ) ;
fn_2 ( false , lr_4 , lr_5 ) ;
fn_2 ( false , lr_5 , lr_5 ) ;
fn_2 ( false , lr_6 , lr_7 ) ;
fn_2 ( false , lr_8 , lr_9 ) ;
fn_2 ( false , lr_10 , lr_9 ) ;
fn_2 ( false , lr_11 , lr_12 ) ;
}
@df_1
public void fn_3 () throws Exception
{
fn_2 ( true , lr_1 , lr_1 ) ;
fn_2 ( true , lr_2 , lr_2 ) ;
fn_2 ( true , lr_6 , lr_7 ) ;
fn_2 ( true , lr_3 , lr_3 ) ;
fn_2 ( true , lr_4 , lr_5 ) ;
fn_2 ( true , lr_5 , lr_5 ) ;
fn_2 ( true , lr_8 , lr_9 ) ;
fn_2 ( true , lr_10 , lr_9 ) ;
fn_2 ( true , lr_11 , lr_12 ) ;
}
private void fn_2 ( final boolean vr_1 , final String vr_2 , final String vr_3 ) throws IOException {
final byte [] vr_4 = vr_2 . vr_5 ( vl_1 ) ;
final byte [] vr_6 = vr_3 . vr_5 ( vl_1 ) ;
final tp_1 vr_7 = new fn_4 ( vr_4 ) ;
try ( final tp_2 vr_8 = new tp_2 ( vr_7 ) ) {
final byte [] vr_9 = new byte [ vr_4 . length * 2 ] ;
final int length = vr_1 ? fn_5 ( vr_8 , vr_9 ) : fn_6 ( vr_8 , vr_9 ) ;
final byte [] vr_10 = new byte [ length ] ;
System . vr_11 ( vr_9 , 0 , vr_10 , 0 , length ) ;
Assert . vr_12 ( lr_13 + vr_2 , vr_6 , vr_10 ) ;
}
}
private int fn_5 ( final tp_2 vr_8 , final byte [] vr_9 )
throws IOException {
int vr_13 ;
int length = 0 ;
while( ( vr_13 = vr_8 . vr_14 () ) != - 1 ) {
vr_9 [ length ++ ] = ( byte ) vr_13 ;
}
return length ;
}
private int fn_6 ( final tp_2 vr_8 , final byte [] vr_9 )
throws IOException {
int length = 0 ;
int vr_15 = vr_9 . length ;
int vr_16 ;
int vr_17 = 0 ;
while( vr_15 > 0 && ( vr_16 = vr_8 . vr_14 ( vr_9 , vr_17 , vr_15 ) ) != - 1 ) {
length += vr_16 ;
vr_17 += vr_16 ;
vr_15 -= vr_16 ;
}
return length ;
}
