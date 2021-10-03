public boolean fn_1 ( final String vr_1 ) {
this . vr_2 = null ;
vl_1 = vr_3 . vr_4 ( vr_1 ) ;
if ( vl_1 . fn_1 () ) {
this . vr_2 = vl_1 . vr_5 () ;
}
return null != this . vr_2 ;
}
public int fn_2 () { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
if ( this . vr_2 == null ) {
return 0 ;
}
return this . vr_2 . vr_6 () ;
}
public String fn_3 ( final int vr_7 ) {
if ( this . vr_2 == null ) {
return null ;
}
return this . vr_2 . fn_3 ( vr_7 ) ;
}
public String fn_4 () {
final StringBuilder vr_8 = new StringBuilder () ;
for ( int vr_9 = 1 ; vr_9 <= this . vr_2 . vr_6 () ; vr_9 ++ ) {
vr_8 . append ( vr_9 ) . append ( lr_1 ) . append ( this . vr_2 . fn_3 ( vr_9 ) ) . append (
System . getProperty ( lr_2 ) ) ;
}
return vr_8 . toString () ;
}
public boolean fn_5 ( final String vr_10 ) {
fn_6 ( vr_10 , 0 ) ;
return true ;
}
public boolean fn_5 ( final String vr_10 , final int vr_11 ) {
fn_6 ( vr_10 , vr_11 ) ;
return true ;
}
private void fn_6 ( final String vr_10 , final int vr_11 ) {
try {
vr_3 = vr_12 . vr_13 ( vr_10 , vr_11 ) ;
} catch ( final tp_1 vr_14 ) {
throw new IllegalArgumentException ( lr_3 + vr_10 ) ;
}
}
