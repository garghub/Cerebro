public vr_1 < vt_1 > fn_1 () {
final vr_1 < vt_1 > vr_2 = new vr_1 <> () ;
fn_2 ( 0 , vr_3 . length () , 0 , vr_4 . length () , vr_2 ) ;
return vr_2 ;
}
private void fn_2 ( final int vr_5 , final int vr_6 , final int vr_7 , final int vr_8 ,
final vr_1 < vt_1 > vr_2 ) {
final tp_1 vr_9 = fn_3 ( vr_5 , vr_6 , vr_7 , vr_8 ) ;
if ( vr_9 == null
|| vr_9 . vr_10 () == vr_6 && vr_9 . vr_11 () == vr_6 - vr_8
|| vr_9 . vr_12 () == vr_5 && vr_9 . vr_11 () == vr_5 - vr_7 ) {
int vr_13 = vr_5 ;
int vr_14 = vr_7 ;
while ( vr_13 < vr_6 || vr_14 < vr_8 ) {
if ( vr_13 < vr_6 && vr_14 < vr_8 && vr_3 . charAt ( vr_13 ) == vr_4 . charAt ( vr_14 ) ) {
vr_2 . append ( new vr_15 <> ( vr_3 . charAt ( vr_13 ) ) ) ;
++ vr_13 ;
++ vr_14 ;
} else {
if ( vr_6 - vr_5 > vr_8 - vr_7 ) {
vr_2 . append ( new vr_16 <> ( vr_3 . charAt ( vr_13 ) ) ) ;
++ vr_13 ;
} else {
vr_2 . append ( new vr_17 <> ( vr_4 . charAt ( vr_14 ) ) ) ;
++ vr_14 ;
}
}
}
} else {
fn_2 ( vr_5 , vr_9 . vr_10 () ,
vr_7 , vr_9 . vr_10 () - vr_9 . vr_11 () ,
vr_2 ) ;
for ( int vr_13 = vr_9 . vr_10 () ; vr_13 < vr_9 . vr_12 () ; ++ vr_13 ) {
vr_2 . append ( new vr_15 <> ( vr_3 . charAt ( vr_13 ) ) ) ;
}
fn_2 ( vr_9 . vr_12 () , vr_6 ,
vr_9 . vr_12 () - vr_9 . vr_11 () , vr_8 ,
vr_2 ) ;
}
}
private tp_1 fn_3 ( final int vr_5 , final int vr_6 , final int vr_7 , final int vr_8 ) {
final int vr_18 = vr_6 - vr_5 ;
final int vr_19 = vr_8 - vr_7 ;
if ( vr_18 == 0 || vr_19 == 0 ) {
return null ;
}
final int vr_20 = vr_18 - vr_19 ;
final int vr_21 = vr_19 + vr_18 ;
final int vr_22 = ( vr_21 % 2 == 0 ? vr_21 : vr_21 + 1 ) / 2 ;
vr_23 [ 1 + vr_22 ] = vr_5 ;
vr_24 [ 1 + vr_22 ] = vr_6 + 1 ;
for ( int vr_25 = 0 ; vr_25 <= vr_22 ; ++ vr_25 ) {
for ( int vr_26 = - vr_25 ; vr_26 <= vr_25 ; vr_26 += 2 ) {
final int vr_13 = vr_26 + vr_22 ;
if ( vr_26 == - vr_25 || vr_26 != vr_25 && vr_23 [ vr_13 - 1 ] < vr_23 [ vr_13 + 1 ] ) {
vr_23 [ vr_13 ] = vr_23 [ vr_13 + 1 ] ;
} else {
vr_23 [ vr_13 ] = vr_23 [ vr_13 - 1 ] + 1 ;
}
int vr_27 = vr_23 [ vr_13 ] ;
int vr_28 = vr_27 - vr_5 + vr_7 - vr_26 ;
while ( vr_27 < vr_6 && vr_28 < vr_8 && vr_3 . charAt ( vr_27 ) == vr_4 . charAt ( vr_28 ) ) {
vr_23 [ vr_13 ] = ++ vr_27 ;
++ vr_28 ;
}
if ( vr_20 % 2 != 0 && vr_20 - vr_25 <= vr_26 && vr_26 <= vr_20 + vr_25 ) {
if ( vr_24 [ vr_13 - vr_20 ] <= vr_23 [ vr_13 ] ) {
return fn_4 ( vr_24 [ vr_13 - vr_20 ] , vr_26 + vr_5 - vr_7 , vr_6 , vr_8 ) ; MST[NonVoidMethodCallMutator]MSP[N]
}
}
}
for ( int vr_26 = vr_20 - vr_25 ; vr_26 <= vr_20 + vr_25 ; vr_26 += 2 ) {
final int vr_13 = vr_26 + vr_22 - vr_20 ;
if ( vr_26 == vr_20 - vr_25
|| vr_26 != vr_20 + vr_25 && vr_24 [ vr_13 + 1 ] <= vr_24 [ vr_13 - 1 ] ) {
vr_24 [ vr_13 ] = vr_24 [ vr_13 + 1 ] - 1 ;
} else {
vr_24 [ vr_13 ] = vr_24 [ vr_13 - 1 ] ;
}
int vr_27 = vr_24 [ vr_13 ] - 1 ;
int vr_28 = vr_27 - vr_5 + vr_7 - vr_26 ;
while ( vr_27 >= vr_5 && vr_28 >= vr_7
&& vr_3 . charAt ( vr_27 ) == vr_4 . charAt ( vr_28 ) ) {
vr_24 [ vr_13 ] = vr_27 -- ;
vr_28 -- ;
}
if ( vr_20 % 2 == 0 && - vr_25 <= vr_26 && vr_26 <= vr_25 ) {
if ( vr_24 [ vr_13 ] <= vr_23 [ vr_13 + vr_20 ] ) {
return fn_4 ( vr_24 [ vr_13 ] , vr_26 + vr_5 - vr_7 , vr_6 , vr_8 ) ;
}
}
}
}
throw new fn_5 ( lr_1 ) ;
}
private tp_1 fn_4 ( final int vr_29 , final int vr_30 , final int vr_6 , final int vr_8 ) {
int vr_31 = vr_29 ;
while ( vr_31 - vr_30 < vr_8
&& vr_31 < vr_6
&& vr_3 . charAt ( vr_31 ) == vr_4 . charAt ( vr_31 - vr_30 ) ) {
++ vr_31 ;
}
return new tp_1 ( vr_29 , vr_31 , vr_30 ) ;
}
public int vr_10 () {
return vr_29 ;
}
public int vr_12 () {
return vr_31 ;
}
public int vr_11 () {
return vr_30 ;
}
