public static < vt_1 extends vr_1 < vt_1 > > vr_2 < vt_1 > fn_1 ( final vt_1 vr_3 ) {
return fn_2 ( vr_3 , vr_3 , null ) ;
}
public static < vt_1 > vr_2 < vt_1 > fn_1 ( final vt_1 vr_3 , final vr_4 < vt_1 > vr_5 ) {
return fn_2 ( vr_3 , vr_3 , vr_5 ) ;
}
public static < vt_1 extends vr_1 < vt_1 > > vr_2 < vt_1 > fn_2 ( final vt_1 vr_6 , final vt_1 vr_7 ) {
return fn_2 ( vr_6 , vr_7 , null ) ;
}
public static < vt_1 > vr_2 < vt_1 > fn_2 ( final vt_1 vr_6 , final vt_1 vr_7 , final vr_4 < vt_1 > vr_5 ) {
return new vr_2 < vt_1 > ( vr_6 , vr_7 , vr_5 ) ;
}
public vt_1 fn_3 () {
return vl_1 ;
}
public vt_1 fn_4 () {
return vl_2 ;
}
public vr_4 < vt_1 > fn_5 () {
return vr_5 ;
}
public boolean fn_6 () {
return vr_5 == vr_8 . vr_9 ;
}
public boolean contains ( final vt_1 vr_3 ) {
if ( vr_3 == null ) {
return false ;
}
return vr_5 . vr_10 ( vr_3 , vl_1 ) > - 1 && vr_5 . vr_10 ( vr_3 , vl_2 ) < 1 ;
}
public boolean fn_7 ( final vt_1 vr_3 ) {
if ( vr_3 == null ) {
return false ;
}
return vr_5 . vr_10 ( vr_3 , vl_1 ) < 0 ;
}
public boolean fn_8 ( final vt_1 vr_3 ) {
if ( vr_3 == null ) {
return false ;
}
return vr_5 . vr_10 ( vr_3 , vl_1 ) == 0 ;
}
public boolean fn_9 ( final vt_1 vr_3 ) {
if ( vr_3 == null ) {
return false ;
}
return vr_5 . vr_10 ( vr_3 , vl_2 ) == 0 ;
}
public boolean fn_10 ( final vt_1 vr_3 ) {
if ( vr_3 == null ) {
return false ;
}
return vr_5 . vr_10 ( vr_3 , vl_2 ) > 0 ;
}
public int fn_11 ( final vt_1 vr_3 ) {
if ( vr_3 == null ) {
throw new fn_12 ( lr_1 ) ;
}
if ( fn_7 ( vr_3 ) ) {
return - 1 ;
} else if ( fn_10 ( vr_3 ) ) {
return 1 ;
} else {
return 0 ;
}
}
public boolean fn_13 ( final vr_2 < vt_1 > vr_11 ) {
if ( vr_11 == null ) {
return false ;
}
return contains ( vr_11 . vl_1 )
&& contains ( vr_11 . vl_2 ) ;
}
public boolean fn_14 ( final vr_2 < vt_1 > vr_11 ) {
if ( vr_11 == null ) {
return false ;
}
return fn_7 ( vr_11 . vl_2 ) ;
}
public boolean fn_15 ( final vr_2 < vt_1 > vr_11 ) {
if ( vr_11 == null ) {
return false ;
}
return vr_11 . contains ( vl_1 )
|| vr_11 . contains ( vl_2 )
|| contains ( vr_11 . vl_1 ) ;
}
public boolean fn_16 ( final vr_2 < vt_1 > vr_11 ) {
if ( vr_11 == null ) {
return false ;
}
return fn_10 ( vr_11 . vl_1 ) ;
}
public vr_2 < vt_1 > fn_17 ( final vr_2 < vt_1 > vr_12 ) {
if ( ! this . fn_15 ( vr_12 ) ) {
throw new IllegalArgumentException ( String . vr_13 (
lr_2 , vr_12 ) ) ;
}
if ( this . equals ( vr_12 ) ) {
return this ;
}
final vt_1 vr_14 = fn_5 () . vr_10 ( vl_1 , vr_12 . vl_1 ) < 0 ? vr_12 . vl_1 : vl_1 ;
final vt_1 vr_15 = fn_5 () . vr_10 ( vl_2 , vr_12 . vl_2 ) < 0 ? vl_2 : vr_12 . vl_2 ;
return fn_2 ( vr_14 , vr_15 , fn_5 () ) ;
}
@Override
public boolean equals ( final Object vr_16 ) {
if ( vr_16 == this ) {
return true ;
} else if ( vr_16 == null || vr_16 . getClass () != getClass () ) {
return false ;
} else {
@SuppressWarnings ( lr_3 )
final
vr_2 < vt_1 > vr_17 = ( vr_2 < vt_1 > ) vr_16 ;
return vl_1 . equals ( vr_17 . vl_1 ) &&
vl_2 . equals ( vr_17 . vl_2 ) ;
}
}
@Override
public int fn_18 () {
int vr_18 = fn_18 ;
if ( fn_18 == 0 ) {
vr_18 = 17 ;
vr_18 = 37 * vr_18 + getClass () . fn_18 () ;
vr_18 = 37 * vr_18 + vl_1 . fn_18 () ;
vr_18 = 37 * vr_18 + vl_2 . fn_18 () ;
fn_18 = vr_18 ;
}
return vr_18 ;
}
@Override
public String toString () {
if ( toString == null ) {
toString = lr_4 + vl_1 + lr_5 + vl_2 + lr_6 ;
}
return toString ;
}
public String toString ( final String vr_13 ) {
return String . vr_13 ( vr_13 , vl_1 , vl_2 , vr_5 ) ;
}
@Override
public int vr_10 ( final Object vr_19 , final Object vr_20 ) {
return ( ( vr_1 ) vr_19 ) . fn_19 ( vr_20 ) ;
}
