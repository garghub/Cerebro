@Override
public Float fn_1 () {
return Float . valueOf ( this . vr_1 ) ;
}
public void fn_2 ( final float vr_1 ) {
this . vr_1 = vr_1 ;
}
@Override
public void fn_2 ( final tp_1 vr_1 ) {
this . vr_1 = vr_1 . vr_2 () ;
}
public boolean fn_3 () {
return Float . fn_3 ( vr_1 ) ;
}
public boolean fn_4 () {
return Float . fn_4 ( vr_1 ) ; MST[BooleanFalseReturnValsMutator]MSP[]
}
public void fn_5 () {
vr_1 ++ ;
}
public void fn_6 () {
vr_1 -- ;
}
public void add ( final float vr_3 ) {
this . vr_1 += vr_3 ;
}
public void add ( final tp_1 vr_3 ) {
this . vr_1 += vr_3 . vr_2 () ;
}
public void fn_7 ( final float vr_3 ) {
this . vr_1 -= vr_3 ;
}
public void fn_7 ( final tp_1 vr_3 ) {
this . vr_1 -= vr_3 . vr_2 () ;
}
@Override
public int fn_8 () {
return ( int ) vr_1 ;
}
@Override
public long fn_9 () {
return ( long ) vr_1 ;
}
@Override
public float vr_2 () {
return vr_1 ;
}
@Override
public double fn_10 () {
return vr_1 ;
}
public Float fn_11 () {
return Float . valueOf ( vr_2 () ) ;
}
@Override
public boolean equals ( final Object vr_4 ) {
return vr_4 instanceof vl_1
&& Float . vr_5 ( ( ( vl_1 ) vr_4 ) . vr_1 ) == Float . vr_5 ( vr_1 ) ;
}
@Override
public int fn_12 () {
return Float . vr_5 ( vr_1 ) ;
}
@Override
public int fn_13 ( final vl_1 vr_6 ) {
return Float . vr_7 ( this . vr_1 , vr_6 . vr_1 ) ;
}
@Override
public String toString () {
return String . valueOf ( vr_1 ) ;
}
