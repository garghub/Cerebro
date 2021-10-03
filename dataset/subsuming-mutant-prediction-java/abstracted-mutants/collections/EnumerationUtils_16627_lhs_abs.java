public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Enumeration < vt_1 > enumeration ) {
return new vr_2 <> ( new vr_3 <> ( enumeration ) ) ;
}
public static < vt_1 > vt_1 get ( final Enumeration < vt_1 > vr_4 , final int vr_5 ) {
vr_6 . vr_7 ( vr_5 ) ;
int vr_8 = vr_5 ;
while ( vr_4 . vr_9 () ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
vr_8 -- ;
if ( vr_8 == - 1 ) {
return vr_4 . nextElement () ;
}
vr_4 . nextElement () ;
}
throw new fn_2 ( lr_1 + vr_8 ) ;
}
public static < vt_2 > List < vt_2 > fn_3 ( final Enumeration < ? extends vt_2 > enumeration ) {
return vr_10 . fn_3 ( new vr_3 <> ( enumeration ) ) ;
}
public static List < String > fn_3 ( final tp_1 vr_11 ) {
final List < String > vr_12 = new ArrayList <> ( vr_11 . vr_13 () ) ;
while ( vr_11 . vr_14 () ) {
vr_12 . add ( vr_11 . vr_15 () ) ;
}
return vr_12 ;
}
