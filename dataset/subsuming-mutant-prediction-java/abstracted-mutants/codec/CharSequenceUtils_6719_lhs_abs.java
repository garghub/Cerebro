static boolean fn_1 ( final tp_1 vr_1 , final boolean vr_2 , final int vr_3 ,
final tp_1 vr_4 , final int vr_5 , final int length ) {
if ( vr_1 instanceof String && vr_4 instanceof String ) {
return ( ( String ) vr_1 ) . fn_1 ( vr_2 , vr_3 , ( String ) vr_4 , vr_5 , length ) ;
}
int vr_6 = vr_3 ;
int vr_7 = vr_5 ;
int vr_8 = length ;
while ( vr_8 -- > 0 ) {
final char vr_9 = vr_1 . charAt ( vr_6 ++ ) ;
final char vr_10 = vr_4 . charAt ( vr_7 ++ ) ;
if ( vr_9 == vr_10 ) {
continue;
}
if ( ! vr_2 ) {
return false ;
}
if ( vr_11 . vr_12 ( vr_9 ) != vr_11 . vr_12 ( vr_10 ) &&
vr_11 . vr_13 ( vr_9 ) != vr_11 . vr_13 ( vr_10 ) ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
return false ;
}
}
return true ;
}
