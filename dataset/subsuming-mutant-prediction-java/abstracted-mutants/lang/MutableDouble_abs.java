@Override
public Double fn_1 () {
return Double . valueOf ( this . vr_1 ) ;
}
public void fn_2 ( final double vr_1 ) {
this . vr_1 = vr_1 ;
}
@Override
public void fn_2 ( final tp_1 vr_1 ) {
this . vr_1 = vr_1 . vr_2 () ;
}
public boolean fn_3 () {
return Double . fn_3 ( vr_1 ) ;
}
public boolean fn_4 () {
return Double . fn_4 ( vr_1 ) ;
}
public void fn_5 () {
vr_1 ++ ;
}
public void fn_6 () {
vr_1 -- ;
}
public void add ( final double vr_3 ) {
this . vr_1 += vr_3 ;
}
public void add ( final tp_1 vr_3 ) {
this . vr_1 += vr_3 . vr_2 () ;
}
public void fn_7 ( final double vr_3 ) {
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
public float fn_10 () {
return ( float ) vr_1 ;
}
@Override
public double vr_2 () {
return vr_1 ;
}
public Double fn_11 () {
return Double . valueOf ( vr_2 () ) ;
}
@Override
public boolean equals ( final Object vr_4 ) {
return vr_4 instanceof vl_1
&& Double . vr_5 ( ( ( vl_1 ) vr_4 ) . vr_1 ) == Double . vr_5 ( vr_1 ) ;
}
@Override
public int fn_12 () {
final long vr_6 = Double . vr_5 ( vr_1 ) ;
return (int) ( vr_6 ^ vr_6 >>> 32 ) ;
}
@Override
public int fn_13 ( final vl_1 vr_7 ) {
return Double . vr_8 ( this . vr_1 , vr_7 . vr_1 ) ;
}
@Override
public String toString () {
return String . valueOf ( vr_1 ) ;
}
