public static tp_1 fn_1 ( final int vr_1 ) {
return fn_2 ( vr_1 , Integer . vr_2 ) ;
}
public static tp_1 fn_3 ( final int vr_1 ) {
return fn_2 ( 0 , vr_1 ) ;
}
public static tp_1 fn_4 ( final int vr_3 , final int vr_4 ) {
return new tp_1 ( vr_3 , vr_4 , true ) ;
}
public static tp_1 fn_2 ( final int vr_3 , final int vr_4 ) {
return new tp_1 ( vr_3 , vr_4 , false ) ;
}
@Override
public boolean fn_5 ( final int vr_1 , final tp_2 out ) throws IOException {
if( fn_4 ) {
if ( vr_1 < fn_1 || vr_1 > fn_3 ) {
return false ;
}
} else {
if ( vr_1 >= fn_1 && vr_1 <= fn_3 ) {
return false ;
}
}
out . vr_5 ( lr_1 ) ;
out . vr_5 ( Integer . toString ( vr_1 , 10 ) ) ;
out . vr_5 ( ';' ) ;
return true ;
}
