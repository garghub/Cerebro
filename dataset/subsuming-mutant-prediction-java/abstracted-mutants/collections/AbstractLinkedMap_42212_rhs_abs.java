@Override
protected void fn_1 () {
vl_1 = fn_2 ( null , - 1 , null , null ) ;
vl_1 . vr_1 = vl_1 . vr_2 = vl_1 ;
}
@Override
public boolean fn_3 ( final Object vr_3 ) {
if ( vr_3 == null ) {
for ( vr_4 < vt_1 , vt_2 > vr_5 = vl_1 . vr_2 ; vr_5 != vl_1 ; vr_5 = vr_5 . vr_2 ) {
if ( vr_5 . vr_6 () == null ) {
return true ;
}
}
} else {
for ( vr_4 < vt_1 , vt_2 > vr_5 = vl_1 . vr_2 ; vr_5 != vl_1 ; vr_5 = vr_5 . vr_2 ) {
if ( fn_4 ( vr_3 , vr_5 . vr_6 () ) ) {
return true ;
}
}
}
return false ;
}
@Override
public void clear () {
super . clear () ;
vl_1 . vr_1 = vl_1 . vr_2 = vl_1 ;
}
@Override
public vt_1 fn_5 () {
if ( size == 0 ) {
throw new fn_6 ( lr_1 ) ;
}
return vl_1 . vr_2 . vr_7 () ;
}
@Override
public vt_1 fn_7 () {
if ( size == 0 ) {
throw new fn_6 ( lr_1 ) ;
}
return vl_1 . vr_1 . vr_7 () ;
}
@Override
public vt_1 fn_8 ( final Object vr_8 ) {
final vr_4 < vt_1 , vt_2 > vr_5 = fn_9 ( vr_8 ) ;
return vr_5 == null || vr_5 . vr_2 == vl_1 ? null : vr_5 . vr_2 . vr_7 () ;
}
@Override
protected vr_4 < vt_1 , vt_2 > fn_9 ( final Object vr_8 ) {
return ( vr_4 < vt_1 , vt_2 > ) super . fn_9 ( vr_8 ) ;
}
@Override
public vt_1 fn_10 ( final Object vr_8 ) {
final vr_4 < vt_1 , vt_2 > vr_5 = fn_9 ( vr_8 ) ;
return vr_5 == null || vr_5 . vr_1 == vl_1 ? null : vr_5 . vr_1 . vr_7 () ;
}
protected vr_4 < vt_1 , vt_2 > fn_9 ( final int vr_9 ) {
if ( vr_9 < 0 ) {
throw new fn_11 ( lr_2 + vr_9 + lr_3 ) ;
}
if ( vr_9 >= size ) {
throw new fn_11 ( lr_2 + vr_9 + lr_4 + size ) ;
}
vr_4 < vt_1 , vt_2 > vr_5 ;
if ( vr_9 < size / 2 ) { MST[rv.CRCR6Mutator]MSP[S]
vr_5 = vl_1 . vr_2 ;
for ( int vr_10 = 0 ; vr_10 < vr_9 ; vr_10 ++ ) {
vr_5 = vr_5 . vr_2 ;
}
} else {
vr_5 = vl_1 ;
for ( int vr_10 = size ; vr_10 > vr_9 ; vr_10 -- ) {
vr_5 = vr_5 . vr_1 ;
}
}
return vr_5 ;
}
@Override
protected void fn_12 ( final vr_11 < vt_1 , vt_2 > vr_5 , final int vr_12 ) {
final vr_4 < vt_1 , vt_2 > vr_13 = ( vr_4 < vt_1 , vt_2 > ) vr_5 ;
vr_13 . vr_2 = vl_1 ;
vr_13 . vr_1 = vl_1 . vr_1 ;
vl_1 . vr_1 . vr_2 = vr_13 ;
vl_1 . vr_1 = vr_13 ;
vr_14 [ vr_12 ] = vr_13 ;
}
@Override
protected vr_4 < vt_1 , vt_2 > fn_2 ( final vr_11 < vt_1 , vt_2 > vr_15 , final int vr_16 , final vt_1 vr_8 , final vt_2 vr_3 ) {
return new vr_4 <> ( vr_15 , vr_16 , fn_13 ( vr_8 ) , vr_3 ) ;
}
@Override
protected void fn_14 ( final vr_11 < vt_1 , vt_2 > vr_5 , final int vr_12 , final vr_11 < vt_1 , vt_2 > vr_17 ) {
final vr_4 < vt_1 , vt_2 > vr_13 = ( vr_4 < vt_1 , vt_2 > ) vr_5 ;
vr_13 . vr_1 . vr_2 = vr_13 . vr_2 ;
vr_13 . vr_2 . vr_1 = vr_13 . vr_1 ;
vr_13 . vr_2 = null ;
vr_13 . vr_1 = null ;
super . fn_14 ( vr_5 , vr_12 , vr_17 ) ;
}
protected vr_4 < vt_1 , vt_2 > fn_15 ( final vr_4 < vt_1 , vt_2 > vr_5 ) {
return vr_5 . vr_1 ;
}
protected vr_4 < vt_1 , vt_2 > fn_16 ( final vr_4 < vt_1 , vt_2 > vr_5 ) {
return vr_5 . vr_2 ;
}
@Override
public vr_18 < vt_1 , vt_2 > fn_17 () {
if ( size == 0 ) {
return vr_19 . <vt_1 , vt_2 > fn_18 () ;
}
return new vr_20 <> ( this ) ;
}
@Override
public vt_1 vr_15 () {
return super . vr_21 () . vr_7 () ;
}
@Override
public vt_1 vr_17 () {
return super . vr_22 () . vr_7 () ;
}
@Override
public vt_1 vr_7 () {
final vr_4 < vt_1 , vt_2 > vr_23 = fn_19 () ;
if ( vr_23 == null ) {
throw new fn_20 ( vr_24 . vr_25 ) ;
}
return vr_23 . vr_7 () ;
}
@Override
public vt_2 vr_6 () {
final vr_4 < vt_1 , vt_2 > vr_23 = fn_19 () ;
if ( vr_23 == null ) {
throw new fn_20 ( vr_24 . vr_26 ) ;
}
return vr_23 . vr_6 () ;
}
@Override
public vt_2 fn_21 ( final vt_2 vr_3 ) {
final vr_4 < vt_1 , vt_2 > vr_23 = fn_19 () ;
if ( vr_23 == null ) {
throw new fn_20 ( vr_24 . vr_27 ) ;
}
return vr_23 . fn_21 ( vr_3 ) ;
}
@Override
protected Iterator < vr_28 . vr_29 < vt_1 , vt_2 > > fn_22 () {
if ( size () == 0 ) {
return vr_30 . < vr_28 . vr_29 < vt_1 , vt_2 > > fn_23 () ;
}
return new vr_31 <> ( this ) ;
}
@Override
public vr_28 . vr_29 < vt_1 , vt_2 > vr_15 () {
return super . vr_21 () ;
}
@Override
public vr_28 . vr_29 < vt_1 , vt_2 > vr_17 () {
return super . vr_22 () ;
}
@Override
protected Iterator < vt_1 > fn_24 () {
if ( size () == 0 ) {
return vr_30 . <vt_1 > fn_23 () ;
}
return new vr_32 <> ( this ) ;
}
@Override
public vt_1 vr_15 () {
return super . vr_21 () . vr_7 () ;
}
@Override
public vt_1 vr_17 () {
return super . vr_22 () . vr_7 () ;
}
@Override
protected Iterator < vt_2 > fn_25 () {
if ( size () == 0 ) {
return vr_30 . <vt_2 > fn_23 () ;
}
return new vr_33 <> ( this ) ;
}
@Override
public vt_2 vr_15 () {
return super . vr_21 () . vr_6 () ;
}
@Override
public vt_2 vr_17 () {
return super . vr_22 () . vr_6 () ;
}
public boolean hasNext () {
return vr_15 != vr_34 . vl_1 ;
}
public boolean fn_26 () {
return vr_15 . vr_1 != vr_34 . vl_1 ;
}
protected vr_4 < vt_1 , vt_2 > vr_21 () {
if ( vr_34 . vr_35 != vl_2 ) {
throw new fn_27 () ;
}
if ( vr_15 == vr_34 . vl_1 ) {
throw new fn_6 ( vr_24 . vr_36 ) ;
}
vl_3 = vr_15 ;
vr_15 = vr_15 . vr_2 ;
return vl_3 ;
}
protected vr_4 < vt_1 , vt_2 > vr_22 () {
if ( vr_34 . vr_35 != vl_2 ) {
throw new fn_27 () ;
}
final vr_4 < vt_1 , vt_2 > vr_17 = vr_15 . vr_1 ;
if ( vr_17 == vr_34 . vl_1 ) {
throw new fn_6 ( vr_24 . vr_37 ) ;
}
vr_15 = vr_17 ;
vl_3 = vr_17 ;
return vl_3 ;
}
protected vr_4 < vt_1 , vt_2 > fn_19 () {
return vl_3 ;
}
public void remove () {
if ( vl_3 == null ) {
throw new fn_20 ( vr_24 . vr_38 ) ;
}
if ( vr_34 . vr_35 != vl_2 ) {
throw new fn_27 () ;
}
vr_34 . remove ( vl_3 . vr_7 () ) ;
vl_3 = null ;
vl_2 = vr_34 . vr_35 ;
}
public void fn_28 () {
vl_3 = null ;
vr_15 = vr_34 . vl_1 . vr_2 ;
}
@Override
public String toString () {
if ( vl_3 != null ) {
return lr_5 + vl_3 . vr_7 () + lr_6 + vl_3 . vr_6 () + lr_7 ;
}
return lr_8 ;
}
