@Override
protected T initialize () throws Exception {
return callable . call () ;
}
private void checkCallable ( final Callable < T > call ) { MST[NonVoidMethodCallMutator]MSP[]
if ( call == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
}
