@Override
public tp_1 fn_1 ( final tp_2 vr_1 , final tp_2 vr_2 ) {
if ( vl_1 != null ) {
return fn_2 ( vr_1 , vr_2 , vl_1 ) ;
}
return fn_3 ( vr_1 , vr_2 ) ;
}
public static tp_3 fn_4 () {
return vl_2 ;
}
public Integer fn_5 () {
return vl_1 ;
}
private static tp_1 fn_2 ( tp_2 vr_1 ,
tp_2 vr_2 ,
final int vl_1 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vl_1 < 0 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
int vr_3 = vr_1 . length () ;
int vr_4 = vr_2 . length () ;
if ( vr_3 == 0 ) {
return vr_4 <= vl_1 ? new tp_1 ( vr_4 , vr_4 , 0 , 0 ) : new tp_1 ( - 1 , 0 , 0 , 0 ) ;
} else if ( vr_4 == 0 ) {
return vr_3 <= vl_1 ? new tp_1 ( vr_3 , 0 , vr_3 , 0 ) : new tp_1 ( - 1 , 0 , 0 , 0 ) ;
}
boolean vr_5 = false ;
if ( vr_3 > vr_4 ) {
final tp_2 vr_6 = vr_1 ;
vr_1 = vr_2 ;
vr_2 = vr_6 ;
vr_3 = vr_4 ;
vr_4 = vr_2 . length () ;
vr_5 = true ;
}
int [] vr_7 = new int [ vr_3 + 1 ] ;
int [] vr_8 = new int [ vr_3 + 1 ] ;
int [] vr_9 ;
final int [] [] vr_10 = new int [ vr_4 + 1 ] [ vr_3 + 1 ] ;
for ( int vr_11 = 0 ; vr_11 <= vr_3 ; vr_11 ++ ) {
vr_10 [ 0 ] [ vr_11 ] = vr_11 ;
}
for ( int vr_11 = 0 ; vr_11 <= vr_4 ; vr_11 ++ ) {
vr_10 [ vr_11 ] [ 0 ] = vr_11 ;
}
final int vr_12 = vr_13 . vr_14 ( vr_3 , vl_1 ) + 1 ;
for ( int vr_15 = 0 ; vr_15 < vr_12 ; vr_15 ++ ) {
vr_7 [ vr_15 ] = vr_15 ;
}
vr_16 . vr_17 ( vr_7 , vr_12 , vr_7 . length , Integer . vr_18 ) ;
vr_16 . vr_17 ( vr_8 , Integer . vr_18 ) ;
for ( int vr_19 = 1 ; vr_19 <= vr_4 ; vr_19 ++ ) {
final char vr_20 = vr_2 . charAt ( vr_19 - 1 ) ;
vr_8 [ 0 ] = vr_19 ;
final int vr_14 = vr_13 . vr_21 ( 1 , vr_19 - vl_1 ) ;
final int vr_21 = vr_19 > Integer . vr_18 - vl_1 ? vr_3 : vr_13 . vr_14 (
vr_3 , vr_19 + vl_1 ) ;
if ( vr_14 > vr_21 ) {
return new tp_1 ( - 1 , 0 , 0 , 0 ) ;
}
if ( vr_14 > 1 ) {
vr_8 [ vr_14 - 1 ] = Integer . vr_18 ;
}
for ( int vr_15 = vr_14 ; vr_15 <= vr_21 ; vr_15 ++ ) {
if ( vr_1 . charAt ( vr_15 - 1 ) == vr_20 ) {
vr_8 [ vr_15 ] = vr_7 [ vr_15 - 1 ] ;
} else {
vr_8 [ vr_15 ] = 1 + vr_13 . vr_14 ( vr_13 . vr_14 ( vr_8 [ vr_15 - 1 ] , vr_7 [ vr_15 ] ) , vr_7 [ vr_15 - 1 ] ) ;
}
vr_10 [ vr_19 ] [ vr_15 ] = vr_8 [ vr_15 ] ;
}
vr_9 = vr_7 ;
vr_7 = vr_8 ;
vr_8 = vr_9 ;
}
if ( vr_7 [ vr_3 ] <= vl_1 ) {
return fn_6 ( vr_1 , vr_2 , vr_10 , vr_5 ) ;
}
return new tp_1 ( - 1 , 0 , 0 , 0 ) ;
}
private static tp_1 fn_3 ( tp_2 vr_1 , tp_2 vr_2 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
int vr_3 = vr_1 . length () ;
int vr_4 = vr_2 . length () ;
if ( vr_3 == 0 ) {
return new tp_1 ( vr_4 , vr_4 , 0 , 0 ) ;
} else if ( vr_4 == 0 ) {
return new tp_1 ( vr_3 , 0 , vr_3 , 0 ) ;
}
boolean vr_5 = false ;
if ( vr_3 > vr_4 ) {
final tp_2 vr_6 = vr_1 ;
vr_1 = vr_2 ;
vr_2 = vr_6 ;
vr_3 = vr_4 ;
vr_4 = vr_2 . length () ;
vr_5 = true ;
}
int [] vr_7 = new int [ vr_3 + 1 ] ;
int [] vr_8 = new int [ vr_3 + 1 ] ;
int [] vr_9 ;
final int [] [] vr_10 = new int [ vr_4 + 1 ] [ vr_3 + 1 ] ;
for ( int vr_11 = 0 ; vr_11 <= vr_3 ; vr_11 ++ ) {
vr_10 [ 0 ] [ vr_11 ] = vr_11 ;
}
for ( int vr_11 = 0 ; vr_11 <= vr_4 ; vr_11 ++ ) {
vr_10 [ vr_11 ] [ 0 ] = vr_11 ;
}
int vr_15 ;
int vr_19 ;
char vr_20 ;
int vr_22 ;
for ( vr_15 = 0 ; vr_15 <= vr_3 ; vr_15 ++ ) {
vr_7 [ vr_15 ] = vr_15 ;
}
for ( vr_19 = 1 ; vr_19 <= vr_4 ; vr_19 ++ ) {
vr_20 = vr_2 . charAt ( vr_19 - 1 ) ;
vr_8 [ 0 ] = vr_19 ;
for ( vr_15 = 1 ; vr_15 <= vr_3 ; vr_15 ++ ) {
vr_22 = vr_1 . charAt ( vr_15 - 1 ) == vr_20 ? 0 : 1 ;
vr_8 [ vr_15 ] = vr_13 . vr_14 ( vr_13 . vr_14 ( vr_8 [ vr_15 - 1 ] + 1 , vr_7 [ vr_15 ] + 1 ) , vr_7 [ vr_15 - 1 ] + vr_22 ) ;
vr_10 [ vr_19 ] [ vr_15 ] = vr_8 [ vr_15 ] ;
}
vr_9 = vr_7 ;
vr_7 = vr_8 ;
vr_8 = vr_9 ;
}
return fn_6 ( vr_1 , vr_2 , vr_10 , vr_5 ) ;
}
private static tp_1 fn_6 ( final tp_2 vr_1 ,
final tp_2 vr_2 ,
final int [] [] vr_10 ,
final boolean vr_5 ) {
int vr_23 = 0 ;
int vr_24 = 0 ;
int vr_25 = 0 ;
int vr_26 = vr_2 . length () ;
int vr_27 = vr_1 . length () ;
int vr_28 = 0 ;
int vr_29 = 0 ;
int vr_30 = 0 ;
int vr_31 = 0 ;
boolean vr_32 = false ;
boolean vr_33 = false ;
while ( vr_26 >= 0 && vr_27 >= 0 ) {
if ( vr_27 == 0 ) {
vr_28 = - 1 ;
} else {
vr_28 = vr_10 [ vr_26 ] [ vr_27 - 1 ] ;
}
if ( vr_26 == 0 ) {
vr_29 = - 1 ;
} else {
vr_29 = vr_10 [ vr_26 - 1 ] [ vr_27 ] ;
}
if ( vr_26 > 0 && vr_27 > 0 ) {
vr_30 = vr_10 [ vr_26 - 1 ] [ vr_27 - 1 ] ;
} else {
vr_30 = - 1 ;
}
if ( vr_28 == - 1 && vr_29 == - 1 && vr_30 == - 1 ) {
break;
}
vr_31 = vr_10 [ vr_26 ] [ vr_27 ] ;
if ( vr_27 > 0 && vr_26 > 0 && vr_1 . charAt ( vr_27 - 1 ) == vr_2 . charAt ( vr_26 - 1 ) ) {
vr_27 -- ;
vr_26 -- ;
continue;
}
vr_32 = false ;
vr_33 = false ;
if ( vr_31 - 1 == vr_28 && ( vr_31 <= vr_30 && vr_31 <= vr_29 )
|| ( vr_30 == - 1 && vr_29 == - 1 ) ) {
vr_27 -- ;
if ( vr_5 ) {
vr_24 ++ ;
vr_33 = true ;
} else {
vr_23 ++ ;
vr_32 = true ;
}
} else if ( vr_31 - 1 == vr_29 && ( vr_31 <= vr_30 && vr_31 <= vr_28 )
|| ( vr_30 == - 1 && vr_28 == - 1 ) ) {
vr_26 -- ;
if ( vr_5 ) {
vr_23 ++ ;
vr_32 = true ;
} else {
vr_24 ++ ;
vr_33 = true ;
}
}
if ( ! vr_33 && ! vr_32 ) {
vr_25 ++ ;
vr_27 -- ;
vr_26 -- ;
}
}
return new tp_1 ( vr_24 + vr_23 + vr_25 , vr_24 , vr_23 , vr_25 ) ;
}
