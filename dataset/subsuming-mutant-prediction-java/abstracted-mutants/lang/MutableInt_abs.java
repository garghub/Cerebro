@Override
public Integer fn_1 () {
return Integer . valueOf ( this . vr_1 ) ;
}
public void fn_2 ( final int vr_1 ) {
this . vr_1 = vr_1 ;
}
@Override
public void fn_2 ( final tp_1 vr_1 ) {
this . vr_1 = vr_1 . vr_2 () ;
}
public void fn_3 () {
vr_1 ++ ;
}
public void fn_4 () {
vr_1 -- ;
}
public void add ( final int vr_3 ) {
this . vr_1 += vr_3 ;
}
public void add ( final tp_1 vr_3 ) {
this . vr_1 += vr_3 . vr_2 () ;
}
public void fn_5 ( final int vr_3 ) {
this . vr_1 -= vr_3 ;
}
public void fn_5 ( final tp_1 vr_3 ) {
this . vr_1 -= vr_3 . vr_2 () ;
}
@Override
public int vr_2 () {
return vr_1 ;
}
@Override
public long fn_6 () {
return vr_1 ;
}
@Override
public float fn_7 () {
return vr_1 ;
}
@Override
public double fn_8 () {
return vr_1 ;
}
public Integer fn_9 () {
return Integer . valueOf ( vr_2 () ) ;
}
@Override
public boolean equals ( final Object vr_4 ) {
if ( vr_4 instanceof vl_1 ) {
return vr_1 == ( ( vl_1 ) vr_4 ) . vr_2 () ;
}
return false ;
}
@Override
public int fn_10 () {
return vr_1 ;
}
@Override
public int fn_11 ( final vl_1 vr_5 ) {
return vr_6 . vr_7 ( this . vr_1 , vr_5 . vr_1 ) ;
}
@Override
public String toString () {
return String . valueOf ( vr_1 ) ;
}
