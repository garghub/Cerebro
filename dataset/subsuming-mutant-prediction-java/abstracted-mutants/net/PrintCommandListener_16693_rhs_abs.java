@Override
public void fn_1 ( final tp_1 vr_1 )
{
if ( vl_1 ) {
vr_2 . vr_3 ( lr_1 ) ;
}
if ( vl_2 ) {
final String vr_4 = vr_1 . vr_5 () ;
if ( lr_2 . equalsIgnoreCase ( vr_4 ) || lr_3 . equalsIgnoreCase ( vr_4 ) ) {
vr_2 . vr_3 ( vr_4 ) ;
vr_2 . println ( lr_4 ) ;
} else {
final String vr_6 = lr_5 ;
if ( vr_6 . equalsIgnoreCase ( vr_4 ) ) {
String vr_7 = vr_1 . vr_8 () ;
vr_7 = vr_7 . vr_9 ( 0 , vr_7 . indexOf ( vr_6 ) + vr_6 . length () ) ;
vr_2 . vr_3 ( vr_7 ) ;
vr_2 . println ( lr_4 ) ;
} else {
vr_2 . vr_3 ( fn_2 ( vr_1 . vr_8 () ) ) ;
}
}
} else {
vr_2 . vr_3 ( fn_2 ( vr_1 . vr_8 () ) ) ;
}
vr_2 . vr_10 () ;
}
private String fn_2 ( final String vr_7 ) {
if ( vl_3 == 0 ) {
return vr_7 ;
}
final int vr_11 = vr_7 . indexOf ( vr_12 . vr_13 ) ;
if ( vr_11 > 0 ) {
final StringBuilder vr_14 = new StringBuilder () ;
vr_14 . append ( vr_7 . vr_9 ( 0 , vr_11 ) ) ;
vr_14 . append ( vl_3 ) ; MST[NonVoidMethodCallMutator]MSP[S]
vr_14 . append ( vr_7 . vr_9 ( vr_11 ) ) ;
return vr_14 . toString () ;
}
return vr_7 ;
}
@Override
public void fn_3 ( final tp_1 vr_1 )
{
if ( vl_1 ) {
vr_2 . vr_3 ( lr_6 ) ;
}
vr_2 . vr_3 ( vr_1 . vr_8 () ) ;
vr_2 . vr_10 () ;
}
