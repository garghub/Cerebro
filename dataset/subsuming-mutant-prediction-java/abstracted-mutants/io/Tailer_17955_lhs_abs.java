public static tp_1 fn_1 ( final tp_2 vr_1 , final tp_3 vr_2 , final long vr_3 ,
final boolean vr_4 , final int vr_5 ) {
return fn_1 ( vr_1 , vr_2 , vr_3 , vr_4 , false , vr_5 ) ;
}
public static tp_1 fn_1 ( final tp_2 vr_1 , final tp_3 vr_2 , final long vr_3 ,
final boolean vr_4 , final boolean vr_6 ,
final int vr_5 ) {
return fn_1 ( vr_1 , vl_1 , vr_2 , vr_3 , vr_4 , vr_6 , vr_5 ) ;
}
public static tp_1 fn_1 ( final tp_2 vr_1 , final tp_4 vr_7 , final tp_3 vr_2 ,
final long vr_3 , final boolean vr_4 , final boolean vr_6
, final int vr_5 ) {
final tp_1 vr_8 = new tp_1 ( vr_1 , vr_7 , vr_2 , vr_3 , vr_4 , vr_6 , vr_5 ) ;
final tp_5 vr_9 = new tp_5 ( vr_8 ) ;
vr_9 . vr_10 ( true ) ;
vr_9 . vr_11 () ;
return vr_8 ;
}
public static tp_1 fn_1 ( final tp_2 vr_1 , final tp_3 vr_2 , final long vr_3 ,
final boolean vr_4 ) {
return fn_1 ( vr_1 , vr_2 , vr_3 , vr_4 , vl_2 ) ;
}
public static tp_1 fn_1 ( final tp_2 vr_1 , final tp_3 vr_2 , final long vr_3 ,
final boolean vr_4 , final boolean vr_6 ) {
return fn_1 ( vr_1 , vr_2 , vr_3 , vr_4 , vr_6 , vl_2 ) ;
}
public static tp_1 fn_1 ( final tp_2 vr_1 , final tp_3 vr_2 , final long vr_3 ) {
return fn_1 ( vr_1 , vr_2 , vr_3 , false ) ;
}
public static tp_1 fn_1 ( final tp_2 vr_1 , final tp_3 vr_2 ) {
return fn_1 ( vr_1 , vr_2 , vl_3 , false ) ;
}
public tp_2 fn_2 () {
return vr_1 ;
}
protected boolean fn_3 () {
return vl_4 ;
}
public long fn_4 () {
return vr_3 ;
}
@Override
public void vl_4 () {
tp_6 vr_12 = null ;
try {
long vr_13 = 0 ;
long vr_14 = 0 ;
while ( fn_3 () && vr_12 == null ) {
try {
vr_12 = new tp_6 ( vr_1 , vl_5 ) ;
} catch ( final tp_7 vr_15 ) {
vr_2 . vr_16 () ;
}
if ( vr_12 == null ) {
tp_5 . vr_17 ( vr_3 ) ;
} else {
vr_14 = vr_4 ? vr_1 . length () : 0 ; MST[rv.ROR2Mutator]MSP[]
vr_13 = vr_1 . vr_18 () ;
vr_12 . vr_19 ( vr_14 ) ;
}
}
while ( fn_3 () ) {
final boolean vr_20 = vr_21 . vr_22 ( vr_1 , vr_13 ) ;
final long length = vr_1 . length () ;
if ( length < vr_14 ) {
vr_2 . vr_23 () ;
try ( tp_6 vr_24 = vr_12 ) {
vr_12 = new tp_6 ( vr_1 , vl_5 ) ;
try {
fn_5 ( vr_24 ) ;
} catch ( final IOException vr_25 ) {
vr_2 . vr_26 ( vr_25 ) ;
}
vr_14 = 0 ;
} catch ( final tp_7 vr_15 ) {
vr_2 . vr_16 () ;
tp_5 . vr_17 ( vr_3 ) ;
}
continue;
}
if ( length > vr_14 ) {
vr_14 = fn_5 ( vr_12 ) ;
vr_13 = vr_1 . vr_18 () ;
} else if ( vr_20 ) {
vr_14 = 0 ;
vr_12 . vr_19 ( vr_14 ) ;
vr_14 = fn_5 ( vr_12 ) ;
vr_13 = vr_1 . vr_18 () ;
}
if ( vr_6 && vr_12 != null ) {
vr_12 . vr_27 () ;
}
tp_5 . vr_17 ( vr_3 ) ;
if ( fn_3 () && vr_6 ) {
vr_12 = new tp_6 ( vr_1 , vl_5 ) ;
vr_12 . vr_19 ( vr_14 ) ;
}
}
} catch ( final tp_8 vr_15 ) {
tp_5 . vr_28 () . fn_6 () ;
vr_2 . vr_26 ( vr_15 ) ;
} catch ( final Exception vr_15 ) {
vr_2 . vr_26 ( vr_15 ) ;
} finally {
try {
if ( vr_12 != null ) {
vr_12 . vr_27 () ;
}
}
catch ( final IOException vr_15 ) {
vr_2 . vr_26 ( vr_15 ) ;
}
fn_7 () ;
}
}
public void fn_7 () {
this . vl_4 = false ;
}
private long fn_5 ( final tp_6 vr_12 ) throws IOException {
try ( tp_9 vr_29 = new tp_9 ( 64 ) ) {
long vr_30 = vr_12 . vr_31 () ;
long vr_32 = vr_30 ;
int vr_33 ;
boolean vr_34 = false ;
while ( fn_3 () && ( ( vr_33 = vr_12 . vr_35 ( vl_6 ) ) != vl_7 ) ) {
for ( int vr_36 = 0 ; vr_36 < vr_33 ; vr_36 ++ ) {
final byte vr_37 = vl_6 [ vr_36 ] ;
switch ( vr_37 ) {
case '\n' :
vr_34 = false ;
vr_2 . vr_26 ( new String ( vr_29 . vr_38 () , vr_7 ) ) ;
vr_29 . vr_39 () ;
vr_32 = vr_30 + vr_36 + 1 ;
break;
case '\r' :
if ( vr_34 ) {
vr_29 . vr_40 ( '\r' ) ;
}
vr_34 = true ;
break;
default:
if ( vr_34 ) {
vr_34 = false ;
vr_2 . vr_26 ( new String ( vr_29 . vr_38 () , vr_7 ) ) ;
vr_29 . vr_39 () ;
vr_32 = vr_30 + vr_36 + 1 ;
}
vr_29 . vr_40 ( vr_37 ) ;
}
}
vr_30 = vr_12 . vr_31 () ;
}
vr_12 . vr_19 ( vr_32 ) ;
if ( vr_2 instanceof vl_8 ) {
( ( vl_8 ) vr_2 ) . fn_8 () ;
}
return vr_32 ;
}
}
