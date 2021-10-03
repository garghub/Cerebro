public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , ? super vt_2 > vr_3 ) {
return fn_1 ( vr_3 , null ) ;
}
public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vr_2 < vt_1 , ? super vt_2 > vr_3 , final vt_2 vr_4 ) {
return new vr_1 <> ( vr_3 , vr_4 ) ;
}
@Override
public int size () {
return vr_3 . size () ;
}
@Override
public boolean isEmpty () {
return vr_3 . isEmpty () ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_3 . vr_5 () . iterator () ;
}
@Override
public boolean contains ( final Object vr_6 ) {
return vr_3 . vr_7 ( vr_6 ) ;
}
@Override
public boolean fn_2 ( final Collection < ? > vr_8 ) {
return vr_3 . vr_5 () . fn_2 ( vr_8 ) ;
}
@Override
public boolean add ( final vt_1 vr_6 ) {
final int size = vr_3 . size () ;
vr_3 . vr_9 ( vr_6 , vr_4 ) ;
return vr_3 . size () != size ; MST[rv.CRCR2Mutator]MSP[S]
}
@Override
public boolean fn_3 ( final Collection < ? extends vt_1 > vr_8 ) {
final int size = vr_3 . size () ;
for ( final vt_1 vr_10 : vr_8 ) {
vr_3 . vr_9 ( vr_10 , vr_4 ) ;
}
return vr_3 . size () != size ;
}
@Override
public boolean remove ( final Object vr_6 ) {
final int size = vr_3 . size () ;
vr_3 . remove ( vr_6 ) ;
return vr_3 . size () != size ;
}
@Override
public boolean fn_4 ( final vr_11 < ? super vt_1 > vr_12 ) {
return vr_3 . vr_5 () . fn_4 ( vr_12 ) ;
}
@Override
public boolean fn_5 ( final Collection < ? > vr_8 ) {
return vr_3 . vr_5 () . fn_5 ( vr_8 ) ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_8 ) {
return vr_3 . vr_5 () . fn_6 ( vr_8 ) ;
}
@Override
public void clear () {
vr_3 . clear () ;
}
@Override
public Object [] toArray () {
return vr_3 . vr_5 () . toArray () ;
}
@Override
public < vt_3 > vt_3 [] toArray ( final vt_3 [] array ) {
return vr_3 . vr_5 () . toArray ( array ) ;
}
@Override
public boolean equals ( final Object vr_6 ) {
return vr_3 . vr_5 () . equals ( vr_6 ) ;
}
@Override
public int fn_7 () {
return vr_3 . vr_5 () . fn_7 () ;
}
