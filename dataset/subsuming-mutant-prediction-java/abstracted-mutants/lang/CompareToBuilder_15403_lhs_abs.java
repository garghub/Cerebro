public static int fn_1 ( final Object vr_1 , final Object vr_2 ) {
return fn_1 ( vr_1 , vr_2 , false , null ) ;
}
public static int fn_1 ( final Object vr_1 , final Object vr_2 , final boolean vr_3 ) {
return fn_1 ( vr_1 , vr_2 , vr_3 , null ) ;
}
public static int fn_1 ( final Object vr_1 , final Object vr_2 , final Collection < String > vr_4 ) {
return fn_1 ( vr_1 , vr_2 , vr_5 . vr_6 ( vr_4 ) ) ;
}
public static int fn_1 ( final Object vr_1 , final Object vr_2 , final String ... vr_4 ) {
return fn_1 ( vr_1 , vr_2 , false , null , vr_4 ) ;
}
public static int fn_1 (
final Object vr_1 ,
final Object vr_2 ,
final boolean vr_3 ,
final Class < ? > vr_7 ,
final String ... vr_4 ) {
if ( vr_1 == vr_2 ) {
return 0 ;
}
if ( vr_1 == null || vr_2 == null ) {
throw new fn_2 () ;
}
Class < ? > vr_8 = vr_1 . getClass () ;
if ( ! vr_8 . vr_9 ( vr_2 ) ) {
throw new fn_3 () ;
}
final tp_1 vr_10 = new tp_1 () ;
fn_4 ( vr_1 , vr_2 , vr_8 , vr_10 , vr_3 , vr_4 ) ;
while ( vr_8 . vr_11 () != null && vr_8 != vr_7 ) {
vr_8 = vr_8 . vr_11 () ;
fn_4 ( vr_1 , vr_2 , vr_8 , vr_10 , vr_3 , vr_4 ) ;
}
return vr_10 . vr_12 () ;
}
private static void fn_4 (
final Object vr_1 ,
final Object vr_2 ,
final Class < ? > vr_13 ,
final tp_1 builder ,
final boolean vr_14 ,
final String [] vr_4 ) {
final vr_15 [] vr_16 = vr_13 . vr_17 () ;
vr_18 . vr_19 ( vr_16 , true ) ;
for ( int vr_20 = 0 ; vr_20 < vr_16 . length && builder . vr_21 == 0 ; vr_20 ++ ) {
final vr_15 vr_22 = vr_16 [ vr_20 ] ;
if ( ! vr_23 . contains ( vr_4 , vr_22 . vr_24 () )
&& ( ! vr_22 . vr_24 () . contains ( lr_1 ) )
&& ( vr_14 || ! vr_25 . vr_26 ( vr_22 . vr_27 () ) )
&& ( ! vr_25 . vr_28 ( vr_22 . vr_27 () ) ) ) {
try {
builder . append ( vr_22 . get ( vr_1 ) , vr_22 . get ( vr_2 ) ) ;
} catch ( final tp_2 vr_29 ) {
throw new fn_5 ( lr_2 ) ;
}
}
}
}
public tp_1 fn_6 ( final int vr_30 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = vr_30 ;
return this ;
}
public tp_1 append ( final Object vr_1 , final Object vr_2 ) {
return append ( vr_1 , vr_2 , null ) ;
}
public tp_1 append ( final Object vr_1 , final Object vr_2 , final vr_31 < ? > vr_32 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . getClass () . fn_7 () ) {
if ( vr_1 instanceof long [] ) {
append ( ( long [] ) vr_1 , ( long [] ) vr_2 ) ;
} else if ( vr_1 instanceof int [] ) {
append ( ( int [] ) vr_1 , ( int [] ) vr_2 ) ;
} else if ( vr_1 instanceof short [] ) {
append ( ( short [] ) vr_1 , ( short [] ) vr_2 ) ;
} else if ( vr_1 instanceof char [] ) {
append ( ( char [] ) vr_1 , ( char [] ) vr_2 ) ;
} else if ( vr_1 instanceof byte [] ) {
append ( ( byte [] ) vr_1 , ( byte [] ) vr_2 ) ;
} else if ( vr_1 instanceof double [] ) {
append ( ( double [] ) vr_1 , ( double [] ) vr_2 ) ;
} else if ( vr_1 instanceof float [] ) {
append ( ( float [] ) vr_1 , ( float [] ) vr_2 ) ;
} else if ( vr_1 instanceof boolean [] ) {
append ( ( boolean [] ) vr_1 , ( boolean [] ) vr_2 ) ;
} else {
append ( ( Object [] ) vr_1 , ( Object [] ) vr_2 , vr_32 ) ;
}
} else {
if ( vr_32 == null ) {
@SuppressWarnings ( lr_3 )
final vr_33 < Object > vr_34 = ( vr_33 < Object > ) vr_1 ;
vr_21 = vr_34 . vr_35 ( vr_2 ) ;
} else {
@SuppressWarnings ( lr_3 )
final vr_31 < Object > vr_36 = ( vr_31 < Object > ) vr_32 ;
vr_21 = vr_36 . vr_37 ( vr_1 , vr_2 ) ;
}
}
return this ;
}
public tp_1 append ( final long vr_1 , final long vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = ( ( vr_1 < vr_2 ) ? - 1 : ( ( vr_1 > vr_2 ) ? 1 : 0 ) ) ;
return this ;
}
public tp_1 append ( final int vr_1 , final int vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = ( ( vr_1 < vr_2 ) ? - 1 : ( ( vr_1 > vr_2 ) ? 1 : 0 ) ) ;
return this ;
}
public tp_1 append ( final short vr_1 , final short vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = ( ( vr_1 < vr_2 ) ? - 1 : ( ( vr_1 > vr_2 ) ? 1 : 0 ) ) ;
return this ;
}
public tp_1 append ( final char vr_1 , final char vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = ( ( vr_1 < vr_2 ) ? - 1 : ( ( vr_1 > vr_2 ) ? 1 : 0 ) ) ;
return this ;
}
public tp_1 append ( final byte vr_1 , final byte vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = ( ( vr_1 < vr_2 ) ? - 1 : ( ( vr_1 > vr_2 ) ? 1 : 0 ) ) ;
return this ;
}
public tp_1 append ( final double vr_1 , final double vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = Double . vr_37 ( vr_1 , vr_2 ) ;
return this ;
}
public tp_1 append ( final float vr_1 , final float vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
vr_21 = Float . vr_37 ( vr_1 , vr_2 ) ;
return this ;
}
public tp_1 append ( final boolean vr_1 , final boolean vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == false ) {
vr_21 = - 1 ;
} else {
vr_21 = + 1 ;
}
return this ;
}
public tp_1 append ( final Object [] vr_1 , final Object [] vr_2 ) {
return append ( vr_1 , vr_2 , null ) ;
}
public tp_1 append ( final Object [] vr_1 , final Object [] vr_2 , final vr_31 < ? > vr_32 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] , vr_32 ) ;
}
return this ;
}
public tp_1 append ( final long [] vr_1 , final long [] vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public tp_1 append ( final int [] vr_1 , final int [] vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public tp_1 append ( final short [] vr_1 , final short [] vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public tp_1 append ( final char [] vr_1 , final char [] vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public tp_1 append ( final byte [] vr_1 , final byte [] vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public tp_1 append ( final double [] vr_1 , final double [] vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public tp_1 append ( final float [] vr_1 , final float [] vr_2 ) {
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public tp_1 append ( final boolean [] vr_1 , final boolean [] vr_2 ) { MST[NullReturnValsMutator]MSP[]
if ( vr_21 != 0 ) {
return this ;
}
if ( vr_1 == vr_2 ) {
return this ;
}
if ( vr_1 == null ) {
vr_21 = - 1 ;
return this ;
}
if ( vr_2 == null ) {
vr_21 = + 1 ;
return this ;
}
if ( vr_1 . length != vr_2 . length ) {
vr_21 = ( vr_1 . length < vr_2 . length ) ? - 1 : + 1 ;
return this ;
}
for ( int vr_20 = 0 ; vr_20 < vr_1 . length && vr_21 == 0 ; vr_20 ++ ) {
append ( vr_1 [ vr_20 ] , vr_2 [ vr_20 ] ) ;
}
return this ;
}
public int vr_12 () {
return vr_21 ;
}
@Override
public Integer fn_8 () {
return Integer . valueOf ( vr_12 () ) ;
}
