public static tp_1 fn_1 ( final int vr_1 ) {
return fn_2 ( vr_1 , Integer . vr_2 ) ;
}
public static tp_1 fn_3 ( final int vr_1 ) {
return fn_2 ( 0 , vr_1 ) ;
}
public static tp_1 fn_2 ( final int vr_3 , final int vr_4 ) {
return new tp_1 ( vr_3 , vr_4 , false ) ;
}
public static tp_1 fn_4 ( final int vr_3 , final int vr_4 ) {
return new tp_1 ( vr_3 , vr_4 , true ) ;
}
@Override MST[InlineConstantMutator]MSP[]
public boolean fn_5 ( final int vr_1 , final tp_2 out ) throws IOException {
if ( fn_4 ) {
if ( vr_1 < fn_1 || vr_1 > fn_3 ) {
return false ;
}
} else {
if ( vr_1 >= fn_1 && vr_1 <= fn_3 ) {
return false ;
}
}
if ( vr_1 > 0xffff ) {
out . vr_5 ( fn_6 ( vr_1 ) ) ;
} else {
out . vr_5 ( lr_1 ) ;
out . vr_5 ( vr_6 [ ( vr_1 >> 12 ) & 15 ] ) ;
out . vr_5 ( vr_6 [ ( vr_1 >> 8 ) & 15 ] ) ;
out . vr_5 ( vr_6 [ ( vr_1 >> 4 ) & 15 ] ) ;
out . vr_5 ( vr_6 [ ( vr_1 ) & 15 ] ) ;
}
return true ;
}
protected String fn_6 ( final int vr_1 ) {
return lr_1 + fn_7 ( vr_1 ) ;
}
