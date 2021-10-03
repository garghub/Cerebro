public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vt_1 object , final vr_2 < vt_1 > vr_3 ) {
return fn_1 ( object , vr_3 , vr_4 . vr_5 ) ;
}
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vt_1 object , final vr_2 < vt_1 > vr_3 ,
final vr_4 vr_6 ) {
return new vr_7 <> ( object , vr_8 . vr_9 ( vr_3 , lr_1 ) ,
vr_8 . vr_9 ( vr_6 , lr_2 ) ) ;
}
@Override
public boolean fn_2 ( final vt_1 vr_10 ) {
boolean vr_11 = false ;
final int vr_12 = vr_3 . vr_13 ( object , vr_10 ) ;
switch ( vr_6 ) {
case vr_5 :
vr_11 = vr_12 == 0 ; MST[rv.ROR3Mutator]MSP[]
break;
case vl_1 :
vr_11 = vr_12 > 0 ;
break;
case vl_2 :
vr_11 = vr_12 < 0 ;
break;
case vl_3 :
vr_11 = vr_12 >= 0 ;
break;
case vl_4 :
vr_11 = vr_12 <= 0 ;
break;
default:
throw new fn_3 ( lr_3 + vr_6 + lr_4 ) ;
}
return vr_11 ;
}
