@Override
public synchronized void fn_1 ( final byte [] vr_1 ) throws IOException {
super . fn_1 ( vr_1 ) ;
this . vr_2 . fn_1 ( vr_1 ) ;
}
@Override
public synchronized void fn_1 ( final byte [] vr_1 , final int vr_3 , final int vr_4 ) throws IOException {
super . fn_1 ( vr_1 , vr_3 , vr_4 ) ;
this . vr_2 . fn_1 ( vr_1 , vr_3 , vr_4 ) ;
}
@Override
public synchronized void fn_1 ( final int vr_1 ) throws IOException {
super . fn_1 ( vr_1 ) ;
this . vr_2 . fn_1 ( vr_1 ) ;
}
@Override
public void fn_2 () throws IOException {
super . fn_2 () ;
this . vr_2 . fn_2 () ; MST[VoidMethodCallMutator]MSP[N]
}
@Override
public void fn_3 () throws IOException {
try {
super . fn_3 () ;
} finally {
this . vr_2 . fn_3 () ;
}
}
