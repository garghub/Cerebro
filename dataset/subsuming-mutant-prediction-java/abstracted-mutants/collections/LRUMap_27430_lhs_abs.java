@Override
public tp_1 get ( final Object vr_1 ) {
return get ( vr_1 , true ) ;
}
public tp_1 get ( final Object vr_1 , final boolean vr_2 ) {
final vr_3 < vt_1 , tp_1 > vr_4 = fn_1 ( vr_1 ) ;
if ( vr_4 == null ) {
return null ;
}
if ( vr_2 ) {
fn_2 ( vr_4 ) ;
}
return vr_4 . vr_5 () ;
}
protected void fn_2 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
if ( vr_4 . vr_6 != vl_1 ) {
vl_2 ++ ; MST[rv.CRCR3Mutator]MSP[]
if ( vr_4 . vr_7 == null ) {
throw new fn_3 ( lr_1 +
lr_2 ) ;
}
vr_4 . vr_7 . vr_6 = vr_4 . vr_6 ;
vr_4 . vr_6 . vr_7 = vr_4 . vr_7 ;
vr_4 . vr_6 = vl_1 ;
vr_4 . vr_7 = vl_1 . vr_7 ;
vl_1 . vr_7 . vr_6 = vr_4 ;
vl_1 . vr_7 = vr_4 ;
} else if ( vr_4 == vl_1 ) {
throw new fn_3 ( lr_3 +
lr_2 ) ;
}
}
@Override
protected void fn_4 ( final vr_8 < vt_1 , tp_1 > vr_4 , final tp_1 vr_9 ) {
fn_2 ( ( vr_3 < vt_1 , tp_1 > ) vr_4 ) ;
vr_4 . vr_10 ( vr_9 ) ;
}
@Override
protected void fn_5 ( final int vr_11 , final int vr_12 , final vt_1 vr_1 , final tp_1 vr_13 ) {
if ( fn_6 () ) {
vr_3 < vt_1 , tp_1 > vr_14 = vl_1 . vr_6 ;
boolean vr_15 = false ;
if ( vl_3 ) {
while ( vr_14 != vl_1 && vr_14 != null ) {
if ( fn_7 ( vr_14 ) ) {
vr_15 = true ;
break;
}
vr_14 = vr_14 . vr_6 ;
}
if ( vr_14 == null ) {
throw new fn_3 (
lr_4 + vl_1 . vr_6 + lr_5 + vl_1 . vr_7 +
lr_6 + vr_1 + lr_7 + vr_13 + lr_8 + size + lr_9 + vl_4 +
lr_10 ) ;
}
} else {
vr_15 = fn_7 ( vr_14 ) ;
}
if ( vr_15 ) {
if ( vr_14 == null ) {
throw new fn_3 (
lr_11 + vl_1 . vr_6 + lr_5 + vl_1 . vr_7 +
lr_6 + vr_1 + lr_7 + vr_13 + lr_8 + size + lr_9 + vl_4 +
lr_10 ) ;
}
fn_8 ( vr_14 , vr_11 , vr_12 , vr_1 , vr_13 ) ;
} else {
super . fn_5 ( vr_11 , vr_12 , vr_1 , vr_13 ) ;
}
} else {
super . fn_5 ( vr_11 , vr_12 , vr_1 , vr_13 ) ;
}
}
protected void fn_8 ( final vr_3 < vt_1 , tp_1 > vr_4 , final int vr_11 , final int vr_12 ,
final vt_1 vr_1 , final tp_1 vr_13 ) {
try {
final int vr_16 = vr_11 ( vr_4 . vr_12 , vr_17 . length ) ;
final vr_8 < vt_1 , tp_1 > [] vr_18 = vr_17 ;
vr_8 < vt_1 , tp_1 > vr_19 = vr_18 [ vr_16 ] ;
vr_8 < vt_1 , tp_1 > vr_20 = null ;
while ( vr_19 != vr_4 && vr_19 != null ) {
vr_20 = vr_19 ;
vr_19 = vr_19 . vr_21 ;
}
if ( vr_19 == null ) {
throw new fn_3 (
lr_12 + vr_17 [ vr_16 ] + lr_13 + vr_20 +
lr_6 + vr_1 + lr_7 + vr_13 + lr_8 + size + lr_9 + vl_4 +
lr_2 ) ;
}
vl_2 ++ ;
fn_9 ( vr_4 , vr_16 , vr_20 ) ;
fn_10 ( vr_4 , vr_11 , vr_12 , vr_1 , vr_13 ) ;
fn_11 ( vr_4 , vr_11 ) ;
} catch ( final tp_2 vr_22 ) {
throw new fn_3 (
lr_14 + vr_4 + lr_15 + ( vr_4 == vl_1 ) +
lr_6 + vr_1 + lr_7 + vr_13 + lr_8 + size + lr_9 + vl_4 +
lr_2 ) ;
}
}
protected boolean fn_7 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
return true ;
}
@Override
public boolean fn_6 () {
return size >= vl_4 ;
}
@Override
public int vl_4 () {
return vl_4 ;
}
public boolean fn_12 () {
return vl_3 ;
}
@Override
public vr_23 < vt_1 , tp_1 > fn_13 () {
return ( vr_23 < vt_1 , tp_1 > ) super . fn_13 () ;
}
private void fn_14 ( final tp_3 out ) throws IOException {
out . vr_24 () ;
fn_15 ( out ) ;
}
private void fn_16 ( final tp_4 vr_25 ) throws IOException , vl_5 {
vr_25 . vr_26 () ;
fn_17 ( vr_25 ) ;
}
@Override
protected void fn_15 ( final tp_3 out ) throws IOException {
out . vr_27 ( vl_4 ) ;
super . fn_15 ( out ) ;
}
@Override
protected void fn_17 ( final tp_4 vr_25 ) throws IOException , vl_5 {
vl_4 = vr_25 . vr_28 () ;
super . fn_17 ( vr_25 ) ;
}
