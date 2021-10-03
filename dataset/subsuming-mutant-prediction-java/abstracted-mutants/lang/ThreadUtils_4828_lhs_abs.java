public static tp_1 fn_1 ( final long vr_1 , final tp_2 vr_2 ) {
if ( vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final tp_1 vr_3 = fn_1 ( vr_1 ) ;
if( vr_3 != null && vr_2 . equals ( vr_3 . vr_4 () ) ) {
return vr_3 ;
}
return null ;
}
public static tp_1 fn_1 ( final long vr_1 , final String vr_5 ) {
if ( vr_5 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
final tp_1 vr_3 = fn_1 ( vr_1 ) ;
if( vr_3 != null && vr_3 . vr_4 () != null && vr_3 . vr_4 () . fn_2 () . equals ( vr_5 ) ) {
return vr_3 ;
}
return null ;
}
public static Collection < tp_1 > fn_3 ( final String vr_6 , final tp_2 vr_2 ) {
return fn_4 ( vr_2 , false , new fn_5 ( vr_6 ) ) ;
}
public static Collection < tp_1 > fn_3 ( final String vr_6 , final String vr_5 ) {
if ( vr_6 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( vr_5 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
final Collection < tp_2 > vr_7 = fn_6 ( new fn_5 ( vr_5 ) ) ;
if( vr_7 . isEmpty () ) {
return vr_8 . vr_9 () ;
}
final Collection < tp_1 > vr_10 = new ArrayList < tp_1 > () ;
final fn_5 vr_11 = new fn_5 ( vr_6 ) ;
for( final tp_2 vr_12 : vr_7 ) {
vr_10 . vr_13 ( fn_4 ( vr_12 , false , vr_11 ) ) ;
}
return vr_8 . vr_14 ( vr_10 ) ;
}
public static Collection < tp_2 > fn_7 ( final String vr_5 ) {
return fn_6 ( new fn_5 ( vr_5 ) ) ;
}
public static Collection < tp_2 > fn_8 () {
return fn_6 ( vl_1 ) ;
}
public static tp_2 fn_9 () {
tp_2 vr_2 = tp_1 . vr_15 () . vr_4 () ;
while( vr_2 . vr_16 () != null ) {
vr_2 = vr_2 . vr_16 () ;
}
return vr_2 ;
}
public static Collection < tp_1 > fn_10 () {
return fn_4 ( vl_1 ) ;
}
public static Collection < tp_1 > fn_3 ( final String vr_6 ) {
return fn_4 ( new fn_5 ( vr_6 ) ) ;
}
public static tp_1 fn_1 ( final long vr_1 ) {
final Collection < tp_1 > vr_10 = fn_4 ( new fn_11 ( vr_1 ) ) ;
if( vr_10 . isEmpty () ) {
return null ;
} else {
return vr_10 . iterator () . fn_12 () ;
}
}
@Override
public boolean fn_13 ( final tp_2 vr_2 ) {
return true ;
}
@Override
public boolean fn_13 ( final tp_1 vr_3 ) {
return true ;
}
@Override
public boolean fn_13 ( final tp_2 vr_2 ) { MST[rv.ROR5Mutator]MSP[]
return vr_2 != null && vr_2 . fn_2 () . equals ( vl_2 ) ;
}
@Override
public boolean fn_13 ( final tp_1 vr_3 ) {
return vr_3 != null && vr_3 . fn_2 () . equals ( vl_2 ) ;
}
@Override
public boolean fn_13 ( final tp_1 vr_3 ) {
return vr_3 != null && vr_3 . vr_17 () == vr_1 ;
}
public static Collection < tp_1 > fn_4 ( final tp_3 vr_18 ) {
return fn_4 ( fn_9 () , true , vr_18 ) ;
}
public static Collection < tp_2 > fn_6 ( final tp_4 vr_18 ) {
return fn_6 ( fn_9 () , true , vr_18 ) ;
}
public static Collection < tp_1 > fn_4 ( final tp_2 vr_12 , final boolean vr_19 , final tp_3 vr_18 ) {
if ( vr_12 == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
if ( vr_18 == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
int vr_20 = vr_12 . vr_21 () ;
tp_1 [] vr_22 ;
do {
vr_22 = new tp_1 [ vr_20 + ( vr_20 / 2 ) + 1 ] ;
vr_20 = vr_12 . vr_23 ( vr_22 , vr_19 ) ;
} while ( vr_20 >= vr_22 . length );
final List < tp_1 > vr_10 = new ArrayList < tp_1 > ( vr_20 ) ;
for ( int vr_24 = 0 ; vr_24 < vr_20 ; ++ vr_24 ) {
if ( vr_18 . fn_13 ( vr_22 [ vr_24 ] ) ) {
vr_10 . add ( vr_22 [ vr_24 ] ) ;
}
}
return vr_8 . vr_14 ( vr_10 ) ;
}
public static Collection < tp_2 > fn_6 ( final tp_2 vr_12 , final boolean vr_19 , final tp_4 vr_18 ) {
if ( vr_12 == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
if ( vr_18 == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
int vr_20 = vr_12 . vr_25 () ;
tp_2 [] vr_7 ;
do {
vr_7 = new tp_2 [ vr_20 + ( vr_20 / 2 ) + 1 ] ;
vr_20 = vr_12 . vr_23 ( vr_7 , vr_19 ) ;
} while( vr_20 >= vr_7 . length );
final List < tp_2 > vr_10 = new ArrayList < tp_2 > ( vr_20 ) ;
for( int vr_24 = 0 ; vr_24 < vr_20 ; ++ vr_24 ) {
if( vr_18 . fn_13 ( vr_7 [ vr_24 ] ) ) {
vr_10 . add ( vr_7 [ vr_24 ] ) ;
}
}
return vr_8 . vr_14 ( vr_10 ) ;
}
