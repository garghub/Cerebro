public static < vt_1 > List < vt_1 > fn_1 ( final List < ? extends vt_1 > list ) {
if ( list instanceof vl_1 ) {
@SuppressWarnings ( lr_1 )
final List < vt_1 > vr_1 = ( List < vt_1 > ) list ;
return vr_1 ;
}
return new vr_2 <> ( list ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_3 . vr_4 ( fn_2 () . iterator () ) ;
}
@Override
public boolean add ( final Object object ) {
throw new fn_3 () ;
}
@Override
public boolean fn_4 ( final Collection < ? extends vt_1 > vr_5 ) {
throw new fn_3 () ;
}
@Override
public void clear () {
throw new fn_3 () ;
}
@Override
public boolean remove ( final Object object ) {
throw new fn_3 () ;
}
@Override
public boolean fn_5 ( final vr_6 < ? super vt_1 > vr_7 ) {
throw new fn_3 () ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_5 ) {
throw new fn_3 () ;
}
@Override
public boolean fn_7 ( final Collection < ? > vr_5 ) {
throw new fn_3 () ;
}
@Override
public vr_8 < vt_1 > fn_8 () {
return vr_9 . vr_10 ( fn_2 () . fn_8 () ) ;
}
@Override
public vr_8 < vt_1 > fn_8 ( final int vr_11 ) {
return vr_9 . vr_10 ( fn_2 () . fn_8 ( vr_11 ) ) ; MST[NullReturnValsMutator]MSP[]
}
@Override
public void add ( final int vr_11 , final vt_1 object ) {
throw new fn_3 () ;
}
@Override
public boolean fn_4 ( final int vr_11 , final Collection < ? extends vt_1 > vr_5 ) {
throw new fn_3 () ;
}
@Override
public vt_1 remove ( final int vr_11 ) {
throw new fn_3 () ;
}
@Override
public vt_1 fn_9 ( final int vr_11 , final vt_1 object ) {
throw new fn_3 () ;
}
@Override
public List < vt_1 > fn_10 ( final int vr_12 , final int vr_13 ) {
final List < vt_1 > vr_14 = fn_2 () . fn_10 ( vr_12 , vr_13 ) ;
return new vr_2 <> ( vr_14 ) ;
}
