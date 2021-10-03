public static tp_1 fn_1 ( tp_2 vr_1 , int vr_2 , int vr_3 ) {
return vr_1 instanceof tp_1
? ( tp_1 ) vr_1
: new tp_1 ( vr_1 , vr_2 , vr_3 ) ;
}
@Override
public int fn_2 ( byte [] vr_4 , int vr_5 , int vr_6 ) throws IOException {
if ( vl_1 || vl_2 && vl_3 <= 0 )
return - 1 ;
if ( vr_7 . vl_1 () ) {
vl_1 = true ;
return - 1 ;
}
if ( fn_3 () )
throw new fn_4 ( lr_1 ) ;
if ( vl_2 && vr_6 > vl_3 )
vr_6 = vl_3 ;
try {
final int fn_2 = super . fn_2 ( vr_4 , vr_5 , vr_6 ) ;
vl_3 -= fn_2 ;
return fn_2 ;
} catch ( fn_4 vr_8 ) {
return 0 ;
}
}
public tp_3 fn_5 ( int vr_9 ) throws IOException {
vr_10 . vr_11 ( vr_9 >= 0 , lr_2 ) ;
final boolean vr_12 = vr_9 > 0 ;
final int vr_2 = vr_12 && vr_9 < vl_4 ? vr_9 : vl_4 ;
final byte [] vr_13 = new byte [ vr_2 ] ;
final tp_4 vr_14 = new tp_4 ( vr_2 ) ;
int fn_2 ;
int vl_3 = vr_9 ;
while ( true ) {
fn_2 = fn_2 ( vr_13 ) ;
if ( fn_2 == - 1 ) break;
if ( vr_12 ) {
if ( fn_2 >= vl_3 ) {
vr_14 . vr_15 ( vr_13 , 0 , vl_3 ) ;
break;
}
vl_3 -= fn_2 ;
}
vr_14 . vr_15 ( vr_13 , 0 , fn_2 ) ;
}
return tp_3 . fn_1 ( vr_14 . vr_16 () ) ;
}
@Override
public void fn_6 () throws IOException {
super . fn_6 () ;
vl_3 = vr_3 - vl_5 ;
}
public tp_1 fn_7 ( long vr_17 , long vr_18 ) {
this . vr_19 = vr_17 ;
this . fn_7 = vr_18 * 1000000 ;
return this ;
}
private boolean fn_3 () {
if ( fn_7 == 0 )
return false ;
final long vr_20 = System . vr_21 () ;
final long vr_22 = vr_20 - vr_19 ;
return ( vr_22 > fn_7 ) ;
}
