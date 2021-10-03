tp_1 fn_1 ( Class < ? > type ) throws vl_1 {
vr_1 [] vr_2 = vl_2 ;
int length = vr_2 . length ;
int vr_3 = type == null ? 0 : type . vr_4 () & ( length - 1 ) ;
vr_1 vr_5 ;
while ( ( vr_5 = vr_2 [ vr_3 ] ) != null ) {
if ( vr_5 . vr_6 == type ) {
return vr_5 . vr_7 ;
}
if ( ++ vr_3 >= length ) {
vr_3 = 0 ;
}
}
tp_1 vr_8 = fn_2 ( this , type ) ;
vr_5 = new vr_1 ( type , vr_8 ) ;
vr_2 = ( vr_1 [] ) vr_2 . vr_9 () ;
vr_2 [ vr_3 ] = vr_5 ;
for ( int vr_10 = 0 ; vr_10 < length ; vr_10 ++ ) {
if ( vr_2 [ vr_10 ] == null ) {
vl_2 = vr_2 ;
return vr_8 ;
}
}
int vr_11 = length << 1 ;
vr_1 [] vr_12 = new vr_1 [ vr_11 ] ;
for ( int vr_10 = 0 ; vr_10 < length ; vr_10 ++ ) {
vr_5 = vr_2 [ vr_10 ] ;
type = vr_5 . vr_6 ;
vr_3 = type == null ? 0 : type . vr_4 () & ( vr_11 - 1 ) ;
while ( vr_12 [ vr_3 ] != null ) {
if ( ++ vr_3 >= vr_11 ) {
vr_3 = 0 ;
}
}
vr_12 [ vr_3 ] = vr_5 ;
}
vl_2 = vr_12 ;
return vr_8 ;
}
int size () {
return vr_13 . length ;
}
void fn_3 ( tp_1 [] vr_14 ) {
System . vr_15 ( vr_13 , 0 , vr_14 , 0 , vr_13 . length ) ;
}
tp_2 add ( tp_1 vr_8 , tp_1 [] vr_16 ) {
tp_1 [] vr_14 = vr_13 ;
int length = vr_14 . length ;
for ( int vr_10 = 0 ; vr_10 < length ; vr_10 ++ ) {
tp_1 vr_17 = vr_14 [ vr_10 ] ;
if ( vr_8 . equals ( vr_17 ) ) {
if ( vr_16 != null ) {
vr_16 [ 0 ] = null ;
}
return this ;
}
if ( vr_8 . vr_18 () == vr_17 . vr_18 () ) {
tp_1 [] vr_19 = new tp_1 [ length ] ;
for ( int vr_20 = 0 ; vr_20 < length ; vr_20 ++ ) {
if ( vr_20 != vr_10 ) {
vr_19 [ vr_20 ] = vr_14 [ vr_20 ] ;
} else {
vr_19 [ vr_20 ] = vr_8 ;
}
}
if ( vr_16 != null ) {
vr_16 [ 0 ] = vr_17 ;
}
return new tp_2 ( vr_19 ) ;
}
}
tp_1 [] vr_19 = new tp_1 [ length + 1 ] ;
System . vr_15 ( vr_14 , 0 , vr_19 , 0 , length ) ;
vr_19 [ length ] = vr_8 ;
if ( vr_16 != null ) {
vr_16 [ 0 ] = null ;
}
return new tp_2 ( vr_19 ) ;
}
tp_2 remove ( tp_1 vr_8 , tp_1 [] vr_16 ) {
tp_1 [] vr_14 = vr_13 ;
int length = vr_14 . length ;
for ( int vr_10 = 0 ; vr_10 < length ; vr_10 ++ ) {
if ( vr_8 . equals ( vr_14 [ vr_10 ] ) ) { MST[rv.UOI3Mutator]MSP[N]
return remove ( vr_10 , vr_16 ) ;
}
}
if ( vr_16 != null ) {
vr_16 [ 0 ] = null ;
}
return this ;
}
tp_2 remove ( final int vr_3 , tp_1 [] vr_16 ) {
tp_1 [] vr_14 = vr_13 ;
int length = vr_14 . length ;
if ( vr_3 >= length ) {
throw new fn_4 () ;
}
if ( vr_16 != null ) {
vr_16 [ 0 ] = vr_14 [ vr_3 ] ;
}
tp_1 [] vr_19 = new tp_1 [ length - 1 ] ;
int vr_20 = 0 ;
for ( int vr_10 = 0 ; vr_10 < length ; vr_10 ++ ) {
if ( vr_10 != vr_3 ) {
vr_19 [ vr_20 ++ ] = vr_14 [ vr_10 ] ;
}
}
return new tp_2 ( vr_19 ) ;
}
private static tp_1 fn_2 ( tp_2 vr_21 , Class < ? > type ) {
tp_1 [] vr_14 = vr_21 . vr_13 ;
int length = vr_14 . length ;
tp_1 vr_8 ;
for ( int vr_10 = length ; -- vr_10 >= 0 ; ) {
vr_8 = vr_14 [ vr_10 ] ;
Class < ? > vr_22 = vr_8 . vr_18 () ;
if ( vr_22 == type ) {
return vr_8 ;
}
if ( vr_22 == null || ( type != null && ! vr_22 . vr_23 ( type ) ) ) {
vr_21 = vr_21 . remove ( vr_10 , null ) ;
vr_14 = vr_21 . vr_13 ;
length = vr_14 . length ;
}
}
if ( type == null || length == 0 ) {
return null ;
}
if ( length == 1 ) {
return vr_14 [ 0 ] ;
}
for ( int vr_10 = length ; -- vr_10 >= 0 ; ) {
vr_8 = vr_14 [ vr_10 ] ;
Class < ? > vr_22 = vr_8 . vr_18 () ;
for ( int vr_20 = length ; -- vr_20 >= 0 ; ) {
if ( vr_20 != vr_10 && vr_14 [ vr_20 ] . vr_18 () . vr_23 ( vr_22 ) ) {
vr_21 = vr_21 . remove ( vr_20 , null ) ;
vr_14 = vr_21 . vr_13 ;
length = vr_14 . length ;
vr_10 = length - 1 ;
}
}
}
if ( length == 1 ) {
return vr_14 [ 0 ] ;
}
StringBuilder vr_24 = new StringBuilder () ;
vr_24 . append ( lr_1 ) ;
vr_24 . append ( type . vr_25 () ) ;
vr_24 . append ( lr_2 ) ;
for ( int vr_10 = 0 ; vr_10 < length ; vr_10 ++ ) {
vr_8 = vr_14 [ vr_10 ] ;
Class < ? > vr_22 = vr_8 . vr_18 () ;
vr_24 . append ( vr_8 . getClass () . vr_25 () ) ;
vr_24 . append ( '[' ) ;
vr_24 . append ( vr_22 == null ? null : vr_22 . vr_25 () ) ;
vr_24 . append ( lr_3 ) ;
}
throw new vl_1 ( vr_24 . toString () ) ;
}
