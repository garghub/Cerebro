public vr_1 < vt_1 > fn_1 () {
final vr_1 < vt_1 > vr_2 = new vr_1 <> () ;
fn_2 ( 0 , vr_3 . size () , 0 , vr_4 . size () , vr_2 ) ;
return vr_2 ;
}
private tp_1 fn_3 ( final int vr_5 , final int vr_6 , final int vr_7 , final int vr_8 ) {
int vr_9 = vr_5 ;
while ( vr_9 - vr_6 < vr_8
&& vr_9 < vr_7
&& vr_10 . vr_11 ( vr_3 . get ( vr_9 ) , vr_4 . get ( vr_9 - vr_6 ) ) ) {
++ vr_9 ;
}
return new tp_1 ( vr_5 , vr_9 , vr_6 ) ;
}
private tp_1 fn_4 ( final int vr_12 , final int vr_7 , final int vr_13 , final int vr_8 ) {
final int vr_14 = vr_7 - vr_12 ;
final int vr_15 = vr_8 - vr_13 ;
if ( vr_14 == 0 || vr_15 == 0 ) {
return null ;
}
final int vr_16 = vr_14 - vr_15 ;
final int vr_17 = vr_15 + vr_14 ;
final int vr_18 = ( vr_17 % 2 == 0 ? vr_17 : vr_17 + 1 ) / 2 ;
vr_19 [ 1 + vr_18 ] = vr_12 ;
vr_20 [ 1 + vr_18 ] = vr_7 + 1 ;
for ( int vr_21 = 0 ; vr_21 <= vr_18 ; ++ vr_21 ) {
for ( int vr_22 = - vr_21 ; vr_22 <= vr_21 ; vr_22 += 2 ) {
final int vr_23 = vr_22 + vr_18 ;
if ( vr_22 == - vr_21 || vr_22 != vr_21 && vr_19 [ vr_23 - 1 ] < vr_19 [ vr_23 + 1 ] ) {
vr_19 [ vr_23 ] = vr_19 [ vr_23 + 1 ] ;
} else {
vr_19 [ vr_23 ] = vr_19 [ vr_23 - 1 ] + 1 ;
}
int vr_24 = vr_19 [ vr_23 ] ;
int vr_25 = vr_24 - vr_12 + vr_13 - vr_22 ;
while ( vr_24 < vr_7 && vr_25 < vr_8 && vr_10 . vr_11 ( vr_3 . get ( vr_24 ) , vr_4 . get ( vr_25 ) ) ) {
vr_19 [ vr_23 ] = ++ vr_24 ;
++ vr_25 ;
}
if ( vr_16 % 2 != 0 && vr_16 - vr_21 <= vr_22 && vr_22 <= vr_16 + vr_21 ) {
if ( vr_20 [ vr_23 - vr_16 ] <= vr_19 [ vr_23 ] ) {
return fn_3 ( vr_20 [ vr_23 - vr_16 ] , vr_22 + vr_12 - vr_13 , vr_7 , vr_8 ) ;
}
}
}
for ( int vr_22 = vr_16 - vr_21 ; vr_22 <= vr_16 + vr_21 ; vr_22 += 2 ) {
final int vr_23 = vr_22 + vr_18 - vr_16 ;
if ( vr_22 == vr_16 - vr_21
|| vr_22 != vr_16 + vr_21 && vr_20 [ vr_23 + 1 ] <= vr_20 [ vr_23 - 1 ] ) {
vr_20 [ vr_23 ] = vr_20 [ vr_23 + 1 ] - 1 ;
} else {
vr_20 [ vr_23 ] = vr_20 [ vr_23 - 1 ] ;
}
int vr_24 = vr_20 [ vr_23 ] - 1 ;
int vr_25 = vr_24 - vr_12 + vr_13 - vr_22 ;
while ( vr_24 >= vr_12 && vr_25 >= vr_13
&& vr_10 . vr_11 ( vr_3 . get ( vr_24 ) , vr_4 . get ( vr_25 ) ) ) {
vr_20 [ vr_23 ] = vr_24 -- ;
vr_25 -- ;
}
if ( vr_16 % 2 == 0 && - vr_21 <= vr_22 && vr_22 <= vr_21 ) {
if ( vr_20 [ vr_23 ] <= vr_19 [ vr_23 + vr_16 ] ) { MST[MathMutator]MSP[]
return fn_3 ( vr_20 [ vr_23 ] , vr_22 + vr_12 - vr_13 , vr_7 , vr_8 ) ;
}
}
}
}
throw new fn_5 ( lr_1 ) ;
}
private void fn_2 ( final int vr_12 , final int vr_7 , final int vr_13 , final int vr_8 ,
final vr_1 < vt_1 > vr_2 ) {
final tp_1 vr_26 = fn_4 ( vr_12 , vr_7 , vr_13 , vr_8 ) ;
if ( vr_26 == null
|| vr_26 . vr_27 () == vr_7 && vr_26 . vr_28 () == vr_7 - vr_8
|| vr_26 . vr_29 () == vr_12 && vr_26 . vr_28 () == vr_12 - vr_13 ) {
int vr_23 = vr_12 ;
int vr_30 = vr_13 ;
while ( vr_23 < vr_7 || vr_30 < vr_8 ) {
if ( vr_23 < vr_7 && vr_30 < vr_8 && vr_10 . vr_11 ( vr_3 . get ( vr_23 ) , vr_4 . get ( vr_30 ) ) ) {
vr_2 . append ( new vr_31 <> ( vr_3 . get ( vr_23 ) ) ) ;
++ vr_23 ;
++ vr_30 ;
} else {
if ( vr_7 - vr_12 > vr_8 - vr_13 ) {
vr_2 . append ( new vr_32 <> ( vr_3 . get ( vr_23 ) ) ) ;
++ vr_23 ;
} else {
vr_2 . append ( new vr_33 <> ( vr_4 . get ( vr_30 ) ) ) ;
++ vr_30 ;
}
}
}
} else {
fn_2 ( vr_12 , vr_26 . vr_27 () ,
vr_13 , vr_26 . vr_27 () - vr_26 . vr_28 () ,
vr_2 ) ;
for ( int vr_23 = vr_26 . vr_27 () ; vr_23 < vr_26 . vr_29 () ; ++ vr_23 ) {
vr_2 . append ( new vr_31 <> ( vr_3 . get ( vr_23 ) ) ) ;
}
fn_2 ( vr_26 . vr_29 () , vr_7 ,
vr_26 . vr_29 () - vr_26 . vr_28 () , vr_8 ,
vr_2 ) ;
}
}
public int vr_27 () {
return vr_5 ;
}
public int vr_29 () {
return vr_9 ;
}
public int vr_28 () {
return vr_6 ;
}
