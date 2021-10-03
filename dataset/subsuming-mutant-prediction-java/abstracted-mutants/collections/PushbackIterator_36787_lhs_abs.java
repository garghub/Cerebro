public static < vt_1 > vr_1 < vt_1 > fn_1 ( final Iterator < ? extends vt_1 > iterator ) {
vr_2 . vr_3 ( iterator , lr_1 ) ;
if ( iterator instanceof vr_1 < ? > ) {
@SuppressWarnings ( lr_2 )
final vr_1 < vt_1 > vr_4 = ( vr_1 < vt_1 > ) iterator ;
return vr_4 ;
}
return new vr_1 <> ( iterator ) ;
}
public void fn_2 ( final vt_1 vr_5 ) {
vr_6 . vr_7 ( vr_5 ) ;
}
@Override
public boolean hasNext () {
return ! vr_6 . isEmpty () || iterator . hasNext () ; MST[NonVoidMethodCallMutator]MSP[]
}
@Override
public vt_1 fn_3 () {
return ! vr_6 . isEmpty () ? vr_6 . vr_8 () : iterator . fn_3 () ;
}
@Override
public void remove () {
throw new fn_4 () ;
}
