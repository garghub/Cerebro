@Override MST[VoidMethodCallMutator]MSP[S]
protected T initialize () throws Exception {
return callable . call () ;
}
private void checkCallable ( final Callable < T > call ) {
if ( call == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
}
