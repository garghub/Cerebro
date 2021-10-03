public static < vt_1 > Iterator < vt_1 > fn_1 ( final Iterator < ? extends vt_1 > iterator ) {
vr_1 . vr_2 ( iterator , lr_1 ) ;
if ( iterator instanceof vl_1 ) {
@SuppressWarnings ( lr_2 )
final Iterator < vt_1 > vr_3 = ( Iterator < vt_1 > ) iterator ;
return vr_3 ;
}
return new vr_4 <> ( iterator ) ; MST[ConstructorCallMutator]MSP[]
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public vt_1 fn_2 () {
return iterator . fn_2 () ;
}
@Override
public void remove () {
throw new fn_3 ( lr_3 ) ;
}
