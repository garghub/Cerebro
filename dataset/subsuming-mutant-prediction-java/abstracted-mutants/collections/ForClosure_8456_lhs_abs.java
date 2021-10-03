@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_1 < vt_1 > fn_1 ( final int vr_2 , final vr_1 < ? super vt_1 > vr_3 ) {
if ( vr_2 <= 0 || vr_3 == null ) { MST[NegateConditionalsMutator]MSP[]
return vr_4 . <vt_1 > fn_2 () ;
}
if ( vr_2 == 1 ) {
return ( vr_1 < vt_1 > ) vr_3 ;
}
return new vr_5 <> ( vr_2 , vr_3 ) ;
}
@Override
public void fn_3 ( final vt_1 vr_6 ) {
for ( int vr_7 = 0 ; vr_7 < vl_1 ; vr_7 ++ ) {
vr_8 . fn_3 ( vr_6 ) ;
}
}
public vr_1 < ? super vt_1 > fn_4 () {
return vr_8 ;
}
public int fn_5 () {
return vl_1 ;
}
