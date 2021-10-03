protected vr_1 < ? super tp_1 > fn_1 () {
return vl_1 ;
}
@Override
public String toString () {
final StringBuilder vr_2 = new StringBuilder () ;
vr_2 . append ( lr_1 ) . append ( size () ) . append ( lr_2 ) ;
for ( final vr_3 . vr_4 < tp_1 , vt_1 > vr_5 : fn_2 () ) {
vr_2 . append ( lr_3 ) . append ( vr_5 ) . append ( lr_4 ) ;
}
vr_2 . append ( lr_5 ) ;
return vr_2 . toString () ;
}
@SuppressWarnings ( lr_6 )
final tp_1 fn_3 ( final Object vr_6 ) {
return ( tp_1 ) vr_6 ;
}
final int fn_4 ( final tp_1 vr_6 ) {
if ( vr_6 == null ) {
return 0 ;
}
return vl_1 . fn_4 ( vr_6 ) ;
}
final int fn_5 () {
return vl_1 . fn_5 () ;
}
final boolean fn_6 ( final tp_1 vr_6 , final int vr_7 , final int fn_4 ) {
if ( vr_6 == null ) {
return false ;
}
return vl_1 . fn_6 ( vr_6 , vr_7 , fn_4 ) ;
}
final int vr_7 ( final tp_1 vr_6 , final tp_1 vr_8 ) {
return vl_1 . vr_7 ( vr_6 , 0 , fn_4 ( vr_6 ) , vr_8 , 0 , fn_4 ( vr_8 ) ) ;
}
final boolean fn_7 ( final tp_1 vr_6 , final tp_1 vr_9 ) {
if ( vr_6 == null ) { MST[rv.ROR5Mutator]MSP[N]
return vr_9 == null ;
} else if ( vr_9 == null ) {
return false ;
}
return vl_1 . vr_10 ( vr_6 , vr_9 ) == 0 ;
}
static boolean vr_10 ( final Object vr_11 , final Object vr_12 ) {
return vr_11 == null ? vr_12 == null : vr_11 . equals ( vr_12 ) ;
}
public vt_1 fn_8 ( final tp_1 vr_6 , final vt_1 vr_13 ) {
this . vr_6 = vr_6 ;
return fn_9 ( vr_13 ) ;
}
@Override
public tp_1 fn_10 () {
return vr_6 ;
}
@Override
public vt_1 fn_11 () {
return vr_13 ;
}
@Override
public vt_1 fn_9 ( final vt_1 vr_13 ) {
final vt_1 vr_14 = this . vr_13 ;
this . vr_13 = vr_13 ;
return vr_14 ;
}
@Override
public int fn_12 () {
return ( fn_10 () == null ? 0 : fn_10 () . fn_12 () ) ^
( fn_11 () == null ? 0 : fn_11 () . fn_12 () ) ;
}
@Override
public boolean equals ( final Object vr_15 ) {
if ( vr_15 == this ) {
return true ;
} else if ( ! ( vr_15 instanceof vr_3 . vr_4 ) ) {
return false ;
}
final vr_3 . vr_4 < ? , ? > vr_9 = ( vr_3 . vr_4 < ? , ? > ) vr_15 ;
if ( vr_10 ( vr_6 , vr_9 . fn_10 () )
&& vr_10 ( vr_13 , vr_9 . fn_11 () ) ) {
return true ;
}
return false ;
}
@Override
public String toString () {
return vr_6 + lr_7 + vr_13 ;
}
