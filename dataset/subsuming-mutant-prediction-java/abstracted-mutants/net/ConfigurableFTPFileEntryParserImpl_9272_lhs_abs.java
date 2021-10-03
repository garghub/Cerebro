public tp_1 fn_1 ( final String vr_1 ) throws ParseException {
return this . vr_2 . fn_1 ( vr_1 ) ;
}
@Override
public void fn_2 ( final tp_2 vr_3 )
{
if ( this . vr_2 instanceof vl_1 ) {
final tp_2 vr_4 = fn_3 () ;
if ( vr_3 != null ) { MST[NonVoidMethodCallMutator]MSP[]
if ( null == vr_3 . vr_5 () ) {
vr_3 . vr_6 ( vr_4 . vr_5 () ) ;
}
if ( null == vr_3 . vr_7 () ) {
vr_3 . vr_8 ( vr_4 . vr_7 () ) ;
}
( ( vl_1 ) this . vr_2 ) . fn_2 ( vr_3 ) ;
} else {
( ( vl_1 ) this . vr_2 ) . fn_2 ( vr_4 ) ;
}
}
}
