private static tp_1 fn_1 ( final tp_2 vr_1 , final Object vr_2 , final boolean append ) throws IOException {
if ( vr_1 == null ) {
throw new fn_2 ( lr_1 ) ;
}
if ( vr_2 == null ) {
throw new fn_2 ( lr_2 ) ;
}
tp_3 vr_3 = null ;
final boolean vr_4 = vr_1 . vr_5 () ;
try {
vr_3 = new fn_3 ( vr_1 , append ) ;
if ( vr_2 instanceof vl_1 ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
return new fn_4 ( vr_3 , ( vl_1 ) vr_2 ) ;
} else if ( vr_2 instanceof vl_2 ) {
return new fn_4 ( vr_3 , ( vl_2 ) vr_2 ) ;
} else {
return new fn_4 ( vr_3 , ( String ) vr_2 ) ;
}
} catch ( final IOException | tp_4 vr_6 ) {
try {
if ( vr_3 != null ) {
vr_3 . vr_7 () ;
}
} catch ( final IOException vr_8 ) {
vr_6 . vr_9 ( vr_8 ) ;
}
if ( vr_4 == false ) {
vr_10 . vr_11 ( vr_1 ) ;
}
throw vr_6 ;
}
}
@Override
public void fn_5 ( final int vr_12 ) throws IOException {
out . fn_5 ( vr_12 ) ;
}
@Override
public void fn_5 ( final char [] vr_13 ) throws IOException {
out . fn_5 ( vr_13 ) ;
}
@Override
public void fn_5 ( final char [] vr_13 , final int vr_14 , final int vr_15 ) throws IOException {
out . fn_5 ( vr_13 , vr_14 , vr_15 ) ;
}
@Override
public void fn_5 ( final String vr_16 ) throws IOException {
out . fn_5 ( vr_16 ) ;
}
@Override
public void fn_5 ( final String vr_16 , final int vr_14 , final int vr_15 ) throws IOException {
out . fn_5 ( vr_16 , vr_14 , vr_15 ) ;
}
@Override
public void fn_6 () throws IOException {
out . fn_6 () ;
}
@Override
public void vr_7 () throws IOException {
out . vr_7 () ;
}
