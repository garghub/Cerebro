public Integer fn_1 () {
return vl_1 ;
}
public Integer fn_2 () {
return vl_2 ;
}
public Integer fn_3 () {
return vl_3 ;
}
public Integer fn_4 () {
return vl_4 ;
}
@Override
public boolean equals ( final Object vr_1 ) {
if ( this == vr_1 ) {
return true ;
}
if ( vr_1 == null || getClass () != vr_1 . getClass () ) {
return false ;
}
final tp_1 vr_2 = ( tp_1 ) vr_1 ;
return vr_3 . equals ( vl_1 , vr_2 . vl_1 ) && vr_3 . equals ( vl_2 , vr_2 . vl_2 )
&& vr_3 . equals ( vl_3 , vr_2 . vl_3 )
&& vr_3 . equals ( vl_4 , vr_2 . vl_4 ) ;
}
@Override
public int fn_5 () {
return vr_3 . vr_4 ( vl_1 , vl_2 , vl_3 , vl_4 ) ;
}
@Override
public String toString () {
return lr_1 + vl_1 + lr_2 + vl_2 + lr_3 + vl_3 + lr_4
+ vl_4 ;
}
