public List < vr_1 < ? > > fn_1 () {
return vr_2 . vr_3 ( vl_1 ) ;
}
public int fn_2 () {
return vl_1 . size () ;
}
public tp_1 fn_3 () {
return vl_2 ;
}
@Override
public String toString () {
return toString ( vl_2 ) ;
}
public String toString ( final tp_1 vl_2 ) {
if ( vl_1 . size () == 0 ) {
return vl_3 ;
}
final tp_2 vr_4 = new tp_2 ( vl_4 , vl_2 ) ;
final tp_2 vr_5 = new tp_2 ( vl_5 , vl_2 ) ;
for ( final vr_1 < ? > vr_6 : vl_1 ) {
vr_4 . append ( vr_6 . vr_7 () , vr_6 . vr_8 () ) ;
vr_5 . append ( vr_6 . vr_7 () , vr_6 . vr_9 () ) ;
}
return String . vr_10 ( lr_1 , vr_4 . vr_11 () , vl_6 ,
vr_5 . vr_11 () ) ;
}
@Override
public Iterator < vr_1 < ? > > iterator () {
return vl_1 . iterator () ;
}
