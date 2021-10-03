private void fn_1 ( final tp_1 vr_1 ) throws IOException {
if ( ! vr_1 . vr_2 () ) {
throw new IOException (
lr_1 + vr_1 . vr_3 () ) ;
}
if ( ! vr_1 . vr_4 () ) {
throw new IOException (
lr_2 + vr_1 . vr_3 () ) ;
}
}
private void fn_2 () throws IOException {
synchronized ( vr_5 . class ) {
if ( ! vr_6 . vr_7 () ) {
throw new IOException ( lr_3 +
vr_6 . vr_3 () + lr_4 ) ;
}
vr_6 . vr_8 () ;
}
}
private tp_2 fn_3 ( final tp_1 vr_9 , final tp_3 vr_10 , final boolean append ) throws IOException { MST[NonVoidMethodCallMutator]MSP[N]
final boolean vr_11 = vr_9 . vr_2 () ;
try {
return new fn_4 ( new fn_5 ( vr_9 . vr_3 () , append ) ,
vr_12 . vr_13 ( vr_10 ) ) ;
} catch ( final IOException | tp_4 vr_14 ) {
vr_15 . vr_16 ( vr_6 ) ;
if ( vr_11 == false ) {
vr_15 . vr_16 ( vr_9 ) ;
}
throw vr_14 ;
}
}
@Override
public void fn_6 () throws IOException {
try {
out . fn_6 () ;
} finally {
vr_6 . vr_17 () ;
}
}
@Override
public void fn_7 ( final int vr_18 ) throws IOException {
out . fn_7 ( vr_18 ) ;
}
@Override
public void fn_7 ( final char [] vr_19 ) throws IOException {
out . fn_7 ( vr_19 ) ;
}
@Override
public void fn_7 ( final char [] vr_19 , final int vr_20 , final int vr_21 ) throws IOException {
out . fn_7 ( vr_19 , vr_20 , vr_21 ) ;
}
@Override
public void fn_7 ( final String vr_22 ) throws IOException {
out . fn_7 ( vr_22 ) ;
}
@Override
public void fn_7 ( final String vr_22 , final int vr_20 , final int vr_21 ) throws IOException {
out . fn_7 ( vr_22 , vr_20 , vr_21 ) ;
}
@Override
public void fn_8 () throws IOException {
out . fn_8 () ;
}
