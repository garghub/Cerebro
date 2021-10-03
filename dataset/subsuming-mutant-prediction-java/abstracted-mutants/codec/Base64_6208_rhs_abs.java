public static byte [] fn_1 ( final byte [] vr_1 ) {
return new fn_2 () . fn_3 ( vr_1 ) ;
}
public static byte [] fn_1 ( final String vr_2 ) {
return new fn_2 () . fn_3 ( vr_2 ) ;
}
public static tp_1 fn_4 ( final byte [] vr_3 ) {
return new tp_1 ( 1 , fn_1 ( vr_3 ) ) ;
}
public static byte [] fn_5 ( final byte [] vr_4 ) {
return fn_5 ( vr_4 , false ) ;
}
public static byte [] fn_5 ( final byte [] vr_4 , final boolean vr_5 ) {
return fn_5 ( vr_4 , vr_5 , false ) ;
}
public static byte [] fn_5 ( final byte [] vr_4 , final boolean vr_5 , final boolean vr_6 ) {
return fn_5 ( vr_4 , vr_5 , vr_6 , Integer . vr_7 ) ;
}
public static byte [] fn_5 ( final byte [] vr_4 , final boolean vr_5 ,
final boolean vr_6 , final int vr_8 ) {
if ( vr_4 == null || vr_4 . length == 0 ) {
return vr_4 ;
}
final fn_2 vr_9 = vr_5 ? new fn_2 ( vr_6 ) : new fn_2 ( 0 , vl_1 , vr_6 ) ;
final long vr_10 = vr_9 . vr_11 ( vr_4 ) ;
if ( vr_10 > vr_8 ) {
throw new IllegalArgumentException ( lr_1 +
vr_10 +
lr_2 +
vr_8 ) ;
}
return vr_9 . vr_12 ( vr_4 ) ;
}
public static byte [] fn_6 ( final byte [] vr_4 ) {
return fn_5 ( vr_4 , true ) ;
}
public static String fn_7 ( final byte [] vr_4 ) {
return vr_13 . vr_14 ( fn_5 ( vr_4 , false ) ) ;
}
public static byte [] fn_8 ( final byte [] vr_4 ) {
return fn_5 ( vr_4 , false , true ) ;
}
public static String fn_9 ( final byte [] vr_4 ) {
return vr_13 . vr_14 ( fn_5 ( vr_4 , false , true ) ) ;
}
public static byte [] fn_10 ( final tp_1 vr_15 ) {
vr_16 . vr_17 ( vr_15 , lr_3 ) ;
return fn_5 ( fn_11 ( vr_15 ) , false ) ;
}
@Deprecated
public static boolean fn_12 ( final byte [] vr_18 ) {
return fn_13 ( vr_18 ) ;
}
public static boolean fn_13 ( final byte vr_19 ) {
return vr_19 == vl_2 || ( vr_19 >= 0 && vr_19 < vr_20 . length && vr_20 [ vr_19 ] != - 1 ) ;
}
public static boolean fn_13 ( final byte [] vr_18 ) {
for ( int vr_21 = 0 ; vr_21 < vr_18 . length ; vr_21 ++ ) {
if ( ! fn_13 ( vr_18 [ vr_21 ] ) && ! fn_14 ( vr_18 [ vr_21 ] ) ) {
return false ;
}
}
return true ;
}
public static boolean fn_13 ( final String vr_22 ) {
return fn_13 ( vr_13 . vr_23 ( vr_22 ) ) ;
}
static byte [] fn_11 ( final tp_1 vr_24 ) {
int vr_25 = vr_24 . vr_26 () ;
vr_25 = ( ( vr_25 + 7 ) >> 3 ) << 3 ;
final byte [] vr_27 = vr_24 . vr_28 () ;
if ( ( ( vr_24 . vr_26 () % 8 ) != 0 ) && ( ( ( vr_24 . vr_26 () / 8 ) + 1 ) == ( vr_25 / 8 ) ) ) {
return vr_27 ;
}
int vr_29 = 0 ;
int vr_10 = vr_27 . length ;
if ( ( vr_24 . vr_26 () % 8 ) == 0 ) {
vr_29 = 1 ;
vr_10 -- ;
}
final int vr_30 = vr_25 / 8 - vr_10 ;
final byte [] vr_31 = new byte [ vr_25 / 8 ] ;
System . vr_32 ( vr_27 , vr_29 , vr_31 , vr_30 , vr_10 ) ;
return vr_31 ;
}
@Override
void fn_3 ( final byte [] vr_33 , int vr_34 , final int vr_35 , final tp_2 vr_36 ) {
if ( vr_36 . vr_37 ) {
return;
}
if ( vr_35 < 0 ) {
vr_36 . vr_37 = true ;
}
for ( int vr_21 = 0 ; vr_21 < vr_35 ; vr_21 ++ ) {
final byte [] vr_38 = fn_15 ( vl_3 , vr_36 ) ;
final byte vr_39 = vr_33 [ vr_34 ++ ] ;
if ( vr_39 == vl_4 ) {
vr_36 . vr_37 = true ;
break;
}
if ( vr_39 >= 0 && vr_39 < vr_20 . length ) {
final int vr_40 = vr_20 [ vr_39 ] ;
if ( vr_40 >= 0 ) {
vr_36 . vr_41 = ( vr_36 . vr_41 + 1 ) % vl_5 ;
vr_36 . vr_42 = ( vr_36 . vr_42 << vl_6 ) + vr_40 ;
if ( vr_36 . vr_41 == 0 ) {
vr_38 [ vr_36 . vr_43 ++ ] = (byte) ( ( vr_36 . vr_42 >> 16 ) & vl_7 ) ;
vr_38 [ vr_36 . vr_43 ++ ] = (byte) ( ( vr_36 . vr_42 >> 8 ) & vl_7 ) ;
vr_38 [ vr_36 . vr_43 ++ ] = (byte) ( vr_36 . vr_42 & vl_7 ) ;
}
}
}
}
if ( vr_36 . vr_37 && vr_36 . vr_41 != 0 ) {
final byte [] vr_38 = fn_15 ( vl_3 , vr_36 ) ;
switch ( vr_36 . vr_41 ) {
case 1 :
fn_16 () ;
break;
case 2 :
fn_17 ( vl_8 , vr_36 ) ;
vr_36 . vr_42 = vr_36 . vr_42 >> 4 ;
vr_38 [ vr_36 . vr_43 ++ ] = (byte) ( ( vr_36 . vr_42 ) & vl_7 ) ;
break;
case 3 :
fn_17 ( vl_9 , vr_36 ) ;
vr_36 . vr_42 = vr_36 . vr_42 >> 2 ;
vr_38 [ vr_36 . vr_43 ++ ] = (byte) ( ( vr_36 . vr_42 >> 8 ) & vl_7 ) ;
vr_38 [ vr_36 . vr_43 ++ ] = (byte) ( ( vr_36 . vr_42 ) & vl_7 ) ;
break;
default:
throw new fn_18 ( lr_4 + vr_36 . vr_41 ) ;
}
}
}
@Override
void vr_12 ( final byte [] vr_33 , int vr_34 , final int vr_35 , final tp_2 vr_36 ) {
if ( vr_36 . vr_37 ) {
return;
}
if ( vr_35 < 0 ) {
vr_36 . vr_37 = true ;
if ( 0 == vr_36 . vr_41 && vl_10 == 0 ) {
return;
}
final byte [] vr_38 = fn_15 ( vl_11 , vr_36 ) ;
final int vr_44 = vr_36 . vr_43 ;
switch ( vr_36 . vr_41 ) {
case 0 :
break;
case 1 :
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 >> 2 ) & vl_12 ] ;
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 << 4 ) & vl_12 ] ; MST[InlineConstantMutator]MSP[N]
if ( vr_45 == vl_13 ) {
vr_38 [ vr_36 . vr_43 ++ ] = vl_4 ;
vr_38 [ vr_36 . vr_43 ++ ] = vl_4 ;
}
break;
case 2 :
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 >> 10 ) & vl_12 ] ;
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 >> 4 ) & vl_12 ] ;
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 << 2 ) & vl_12 ] ;
if ( vr_45 == vl_13 ) {
vr_38 [ vr_36 . vr_43 ++ ] = vl_4 ;
}
break;
default:
throw new fn_18 ( lr_4 + vr_36 . vr_41 ) ;
}
vr_36 . vr_46 += vr_36 . vr_43 - vr_44 ;
if ( vl_10 > 0 && vr_36 . vr_46 > 0 ) {
System . vr_32 ( vl_14 , 0 , vr_38 , vr_36 . vr_43 , vl_14 . length ) ;
vr_36 . vr_43 += vl_14 . length ;
}
} else {
for ( int vr_21 = 0 ; vr_21 < vr_35 ; vr_21 ++ ) {
final byte [] vr_38 = fn_15 ( vl_11 , vr_36 ) ;
vr_36 . vr_41 = ( vr_36 . vr_41 + 1 ) % vl_15 ;
int vr_39 = vr_33 [ vr_34 ++ ] ;
if ( vr_39 < 0 ) {
vr_39 += 256 ;
}
vr_36 . vr_42 = ( vr_36 . vr_42 << 8 ) + vr_39 ;
if ( 0 == vr_36 . vr_41 ) {
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 >> 18 ) & vl_12 ] ;
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 >> 12 ) & vl_12 ] ;
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ ( vr_36 . vr_42 >> 6 ) & vl_12 ] ;
vr_38 [ vr_36 . vr_43 ++ ] = vr_45 [ vr_36 . vr_42 & vl_12 ] ;
vr_36 . vr_46 += vl_5 ;
if ( vl_10 > 0 && vl_10 <= vr_36 . vr_46 ) {
System . vr_32 ( vl_14 , 0 , vr_38 , vr_36 . vr_43 , vl_14 . length ) ;
vr_36 . vr_43 += vl_14 . length ;
vr_36 . vr_46 = 0 ;
}
}
}
}
}
@Override
protected boolean fn_19 ( final byte vr_19 ) {
return vr_19 >= 0 && vr_19 < vr_47 . length && vr_47 [ vr_19 ] != - 1 ;
}
public boolean fn_20 () {
return this . vr_45 == vl_16 ;
}
private void fn_17 ( final int vr_48 , final tp_2 vr_36 ) {
if ( fn_21 () && ( vr_36 . vr_42 & vr_48 ) != 0 ) {
throw new IllegalArgumentException (
lr_5 +
lr_6 +
lr_7 ) ;
}
}
private void fn_16 () {
if ( fn_21 () ) {
throw new IllegalArgumentException (
lr_5 +
lr_6 +
lr_8 ) ;
}
}
