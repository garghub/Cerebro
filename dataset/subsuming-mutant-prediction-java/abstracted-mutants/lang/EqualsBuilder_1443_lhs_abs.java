static vr_1 < vr_2 < vt_1 , vt_1 > > fn_1 () {
return vr_3 . get () ;
}
static vr_2 < vt_1 , vt_1 > fn_2 ( final Object vr_4 , final Object vr_5 ) {
final vt_1 vr_6 = new vt_1 ( vr_4 ) ;
final vt_1 vr_7 = new vt_1 ( vr_5 ) ;
return vr_2 . vr_8 ( vr_6 , vr_7 ) ;
}
static boolean fn_3 ( final Object vr_4 , final Object vr_5 ) {
final vr_1 < vr_2 < vt_1 , vt_1 > > vr_9 = fn_1 () ;
final vr_2 < vt_1 , vt_1 > vr_10 = fn_2 ( vr_4 , vr_5 ) ;
final vr_2 < vt_1 , vt_1 > vr_11 = vr_2 . vr_8 ( vr_10 . vr_12 () , vr_10 . vr_13 () ) ;
return vr_9 != null
&& ( vr_9 . contains ( vr_10 ) || vr_9 . contains ( vr_11 ) ) ;
}
static void register ( final Object vr_4 , final Object vr_5 ) {
synchronized ( vr_14 . class ) {
if ( fn_1 () == null ) {
vr_3 . vr_15 ( new vr_16 < vr_2 < vt_1 , vt_1 > > () ) ;
}
}
final vr_1 < vr_2 < vt_1 , vt_1 > > vr_9 = fn_1 () ;
final vr_2 < vt_1 , vt_1 > vr_10 = fn_2 ( vr_4 , vr_5 ) ;
vr_9 . add ( vr_10 ) ;
}
static void fn_4 ( final Object vr_4 , final Object vr_5 ) {
vr_1 < vr_2 < vt_1 , vt_1 > > vr_9 = fn_1 () ;
if ( vr_9 != null ) {
final vr_2 < vt_1 , vt_1 > vr_10 = fn_2 ( vr_4 , vr_5 ) ;
vr_9 . remove ( vr_10 ) ;
synchronized ( vr_14 . class ) {
vr_9 = fn_1 () ;
if ( vr_9 != null && vr_9 . isEmpty () ) {
vr_3 . remove () ;
}
}
}
}
public static boolean fn_5 ( final Object vr_4 , final Object vr_5 , final Collection < String > vr_17 ) {
return fn_5 ( vr_4 , vr_5 , vr_18 . vr_19 ( vr_17 ) ) ;
}
public static boolean fn_5 ( final Object vr_4 , final Object vr_5 , final String ... vr_17 ) {
return fn_5 ( vr_4 , vr_5 , false , null , vr_17 ) ;
}
public static boolean fn_5 ( final Object vr_4 , final Object vr_5 , final boolean vr_20 ) {
return fn_5 ( vr_4 , vr_5 , vr_20 , null ) ;
}
public static boolean fn_5 ( final Object vr_4 , final Object vr_5 , final boolean vr_20 , final Class < ? > vr_21 ,
final String ... vr_17 ) {
if ( vr_4 == vr_5 ) {
return true ;
}
if ( vr_4 == null || vr_5 == null ) {
return false ;
}
final Class < ? > vr_22 = vr_4 . getClass () ;
final Class < ? > vr_23 = vr_5 . getClass () ;
Class < ? > vr_24 ;
if ( vr_22 . vr_25 ( vr_5 ) ) {
vr_24 = vr_22 ;
if ( ! vr_23 . vr_25 ( vr_4 ) ) {
vr_24 = vr_23 ;
}
} else if ( vr_23 . vr_25 ( vr_4 ) ) {
vr_24 = vr_23 ;
if ( ! vr_22 . vr_25 ( vr_5 ) ) {
vr_24 = vr_22 ;
}
} else {
return false ;
}
final vr_14 vr_26 = new vr_14 () ;
try {
if ( vr_24 . vr_27 () ) {
vr_26 . append ( vr_4 , vr_5 ) ;
} else {
fn_6 ( vr_4 , vr_5 , vr_24 , vr_26 , vr_20 , vr_17 ) ;
while ( vr_24 . vr_28 () != null && vr_24 != vr_21 ) {
vr_24 = vr_24 . vr_28 () ;
fn_6 ( vr_4 , vr_5 , vr_24 , vr_26 , vr_20 , vr_17 ) ;
}
}
} catch ( final IllegalArgumentException vr_29 ) {
return false ;
}
return vr_26 . vr_30 () ;
}
private static void fn_6 (
final Object vr_4 ,
final Object vr_5 ,
final Class < ? > vr_31 ,
final vr_14 builder ,
final boolean vr_32 ,
final String [] vr_17 ) {
if ( fn_3 ( vr_4 , vr_5 ) ) {
return;
}
try {
register ( vr_4 , vr_5 ) ;
final vr_33 [] vr_34 = vr_31 . vr_35 () ;
vr_36 . vr_37 ( vr_34 , true ) ;
for ( int vr_38 = 0 ; vr_38 < vr_34 . length && builder . vr_30 ; vr_38 ++ ) {
final vr_33 vr_39 = vr_34 [ vr_38 ] ;
if ( ! vr_40 . contains ( vr_17 , vr_39 . vr_41 () )
&& ! vr_39 . vr_41 () . contains ( lr_1 )
&& ( vr_32 || ! vr_42 . vr_43 ( vr_39 . vr_44 () ) )
&& ( ! vr_42 . vr_45 ( vr_39 . vr_44 () ) )
&& ( ! vr_39 . vr_46 ( vr_47 . class ) ) ) {
try {
builder . append ( vr_39 . get ( vr_4 ) , vr_39 . get ( vr_5 ) ) ;
} catch ( final tp_1 vr_29 ) {
throw new fn_7 ( lr_2 ) ;
}
}
}
} finally {
fn_4 ( vr_4 , vr_5 ) ;
}
}
public vr_14 fn_8 ( final boolean vr_48 ) {
if ( ! vr_30 ) {
return this ;
}
vr_30 = vr_48 ;
return this ;
}
public vr_14 append ( final Object vr_4 , final Object vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
final Class < ? > vr_22 = vr_4 . getClass () ;
if ( ! vr_22 . vr_27 () ) {
vr_30 = vr_4 . equals ( vr_5 ) ;
} else if ( vr_4 . getClass () != vr_5 . getClass () ) {
this . vr_49 ( false ) ;
}
else if ( vr_4 instanceof long [] ) {
append ( ( long [] ) vr_4 , ( long [] ) vr_5 ) ;
} else if ( vr_4 instanceof int [] ) {
append ( ( int [] ) vr_4 , ( int [] ) vr_5 ) ;
} else if ( vr_4 instanceof short [] ) {
append ( ( short [] ) vr_4 , ( short [] ) vr_5 ) ;
} else if ( vr_4 instanceof char [] ) {
append ( ( char [] ) vr_4 , ( char [] ) vr_5 ) ;
} else if ( vr_4 instanceof byte [] ) {
append ( ( byte [] ) vr_4 , ( byte [] ) vr_5 ) ;
} else if ( vr_4 instanceof double [] ) {
append ( ( double [] ) vr_4 , ( double [] ) vr_5 ) ;
} else if ( vr_4 instanceof float [] ) {
append ( ( float [] ) vr_4 , ( float [] ) vr_5 ) ;
} else if ( vr_4 instanceof boolean [] ) {
append ( ( boolean [] ) vr_4 , ( boolean [] ) vr_5 ) ;
} else {
append ( ( Object [] ) vr_4 , ( Object [] ) vr_5 ) ;
}
return this ;
}
public vr_14 append ( final long vr_4 , final long vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
vr_30 = vr_4 == vr_5 ;
return this ;
}
public vr_14 append ( final int vr_4 , final int vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
vr_30 = vr_4 == vr_5 ;
return this ;
}
public vr_14 append ( final short vr_4 , final short vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
vr_30 = vr_4 == vr_5 ;
return this ;
}
public vr_14 append ( final char vr_4 , final char vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
vr_30 = vr_4 == vr_5 ;
return this ;
}
public vr_14 append ( final byte vr_4 , final byte vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
vr_30 = vr_4 == vr_5 ;
return this ;
}
public vr_14 append ( final double vr_4 , final double vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
return append ( Double . vr_50 ( vr_4 ) , Double . vr_50 ( vr_5 ) ) ;
}
public vr_14 append ( final float vr_4 , final float vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
return append ( Float . vr_51 ( vr_4 ) , Float . vr_51 ( vr_5 ) ) ;
}
public vr_14 append ( final boolean vr_4 , final boolean vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
vr_30 = vr_4 == vr_5 ;
return this ;
}
public vr_14 append ( final Object [] vr_4 , final Object [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final long [] vr_4 , final long [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final int [] vr_4 , final int [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final short [] vr_4 , final short [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final char [] vr_4 , final char [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final byte [] vr_4 , final byte [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final double [] vr_4 , final double [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final float [] vr_4 , final float [] vr_5 ) {
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public vr_14 append ( final boolean [] vr_4 , final boolean [] vr_5 ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
if ( ! vr_30 ) {
return this ;
}
if ( vr_4 == vr_5 ) {
return this ;
}
if ( vr_4 == null || vr_5 == null ) {
this . vr_49 ( false ) ;
return this ;
}
if ( vr_4 . length != vr_5 . length ) {
this . vr_49 ( false ) ;
return this ;
}
for ( int vr_38 = 0 ; vr_38 < vr_4 . length && vr_30 ; ++ vr_38 ) {
append ( vr_4 [ vr_38 ] , vr_5 [ vr_38 ] ) ;
}
return this ;
}
public boolean vr_30 () {
return this . vr_30 ;
}
@Override
public Boolean fn_9 () {
return Boolean . valueOf ( vr_30 () ) ;
}
protected void vr_49 ( final boolean vr_30 ) {
this . vr_30 = vr_30 ;
}
public void fn_10 () {
this . vr_30 = true ;
}
