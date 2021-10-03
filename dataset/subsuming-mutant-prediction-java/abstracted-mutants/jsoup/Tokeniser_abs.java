tp_1 fn_1 () {
int vr_1 = vr_2 . vr_1 () ;
int vr_3 = 0 ;
while ( ! vl_1 ) {
vr_4 . fn_1 ( this , vr_2 ) ;
if ( vr_2 . vr_1 () <= vr_1 ) {
vr_3 ++ ;
}
vr_5 . vr_6 ( vr_3 < 10 ,
lr_1 + this . vr_4 . vr_7 () + lr_2 + vr_2 . vr_8 () ) ;
}
if ( vr_9 . length () > 0 ) {
String vr_10 = vr_9 . toString () ;
vr_9 . vr_11 ( 0 , vr_9 . length () ) ;
vl_2 = null ;
return vr_12 . vr_13 ( vr_10 ) ;
} else if ( vl_2 != null ) {
tp_1 vr_14 = vr_12 . vr_13 ( vl_2 ) ;
vl_2 = null ;
return vr_14 ;
} else {
vl_1 = false ;
return vl_3 ;
}
}
void fn_2 ( tp_1 vr_14 ) {
vr_5 . vr_15 ( vl_1 , lr_3 ) ;
vl_3 = vr_14 ;
vl_1 = true ;
if ( vr_14 . type == tp_1 . vr_16 . vr_17 ) {
tp_1 . vr_17 vr_18 = ( tp_1 . vr_17 ) vr_14 ;
vl_4 = vr_18 . vr_19 ;
} else if ( vr_14 . type == tp_1 . vr_16 . vr_20 ) {
tp_1 . vr_20 vr_21 = ( tp_1 . vr_20 ) vr_14 ;
if ( vr_21 . vr_22 != null )
error ( lr_4 ) ;
}
}
void fn_2 ( final String vr_10 ) {
if ( vl_2 == null ) {
vl_2 = vr_10 ;
}
else {
if ( vr_9 . length () == 0 ) {
vr_9 . append ( vl_2 ) ;
}
vr_9 . append ( vr_10 ) ;
}
}
void fn_2 ( char [] vr_23 ) {
fn_2 ( String . valueOf ( vr_23 ) ) ;
}
void fn_2 ( int [] vr_24 ) {
fn_2 ( new String ( vr_24 , 0 , vr_24 . length ) ) ;
}
void fn_2 ( char vr_25 ) {
fn_2 ( String . valueOf ( vr_25 ) ) ;
}
tp_2 fn_3 () {
return vr_4 ;
}
void fn_4 ( tp_2 vr_4 ) {
this . vr_4 = vr_4 ;
}
void fn_5 ( tp_2 vr_4 ) {
vr_2 . vr_26 () ;
this . vr_4 = vr_4 ;
}
int [] fn_6 ( tp_3 vr_27 , boolean vr_28 ) {
if ( vr_2 . isEmpty () )
return null ;
if ( vr_27 != null && vr_27 == vr_2 . vr_8 () )
return null ;
if ( vr_2 . vr_29 ( vl_5 ) )
return null ;
final int [] vr_30 = vl_6 ;
vr_2 . vr_31 () ;
if ( vr_2 . vr_32 ( lr_5 ) ) {
boolean vr_33 = vr_2 . vr_34 ( lr_6 ) ;
String vr_35 = vr_33 ? vr_2 . vr_36 () : vr_2 . vr_37 () ;
if ( vr_35 . length () == 0 ) {
fn_7 ( lr_7 ) ;
vr_2 . vr_38 () ;
return null ;
}
vr_2 . vr_39 () ;
if ( ! vr_2 . vr_32 ( lr_8 ) )
fn_7 ( lr_9 ) ;
int vr_40 = - 1 ;
try {
int vr_41 = vr_33 ? 16 : 10 ;
vr_40 = Integer . valueOf ( vr_35 , vr_41 ) ;
} catch ( tp_4 vr_42 ) {
}
if ( vr_40 == - 1 || ( vr_40 >= 0xD800 && vr_40 <= 0xDFFF ) || vr_40 > 0x10FFFF ) {
fn_7 ( lr_10 ) ;
vr_30 [ 0 ] = vl_7 ;
return vr_30 ;
} else {
if ( vr_40 >= vl_8 && vr_40 < vl_8 + vr_43 . length ) {
fn_7 ( lr_11 ) ;
vr_40 = vr_43 [ vr_40 - vl_8 ] ;
}
vr_30 [ 0 ] = vr_40 ;
return vr_30 ;
}
} else {
String vr_44 = vr_2 . vr_45 () ;
boolean vr_46 = vr_2 . vr_47 ( ';' ) ;
boolean vr_48 = ( vr_49 . vr_50 ( vr_44 ) || ( vr_49 . vr_51 ( vr_44 ) && vr_46 ) ) ;
if ( ! vr_48 ) {
vr_2 . vr_38 () ;
if ( vr_46 )
fn_7 ( String . vr_52 ( lr_12 , vr_44 ) ) ;
return null ;
}
if ( vr_28 && ( vr_2 . vr_53 () || vr_2 . vr_54 () || vr_2 . vr_55 ( '=' , '-' , '_' ) ) ) {
vr_2 . vr_38 () ;
return null ;
}
vr_2 . vr_39 () ;
if ( ! vr_2 . vr_32 ( lr_8 ) )
fn_7 ( lr_9 ) ;
int vr_56 = vr_49 . vr_57 ( vr_44 , vl_9 ) ;
if ( vr_56 == 1 ) {
vr_30 [ 0 ] = vl_9 [ 0 ] ;
return vr_30 ;
} else if ( vr_56 == 2 ) {
return vl_9 ;
} else {
vr_5 . vr_58 ( lr_13 + vr_44 ) ;
return vl_9 ;
}
}
}
tp_1 . vr_59 fn_8 ( boolean vr_60 ) {
vl_10 = vr_60 ? vr_61 . vr_62 () : vr_63 . vr_62 () ;
return vl_10 ;
}
void fn_9 () {
vl_10 . vr_64 () ;
fn_2 ( vl_10 ) ;
}
void fn_10 () {
vr_65 . vr_62 () ;
}
void fn_11 () {
fn_2 ( vr_65 ) ;
}
void fn_12 () {
vr_65 . vr_62 () ;
vr_65 . vr_66 = true ;
}
void fn_13 () {
vr_67 . vr_62 () ;
}
void fn_14 () {
fn_2 ( vr_67 ) ;
}
void fn_15 () {
tp_1 . vr_62 ( vl_11 ) ;
}
boolean fn_16 () {
return vl_4 != null && vl_10 . vr_7 () . equalsIgnoreCase ( vl_4 ) ;
}
String fn_17 () {
return vl_4 ;
}
void error ( tp_2 vr_4 ) {
if ( vr_68 . vr_69 () )
vr_68 . add ( new fn_18 ( vr_2 . vr_1 () , lr_14 , vr_2 . vr_8 () , vr_4 ) ) ;
}
void fn_19 ( tp_2 vr_4 ) {
if ( vr_68 . vr_69 () )
vr_68 . add ( new fn_18 ( vr_2 . vr_1 () , lr_15 , vr_4 ) ) ;
}
private void fn_7 ( String vr_70 ) {
if ( vr_68 . vr_69 () )
vr_68 . add ( new fn_18 ( vr_2 . vr_1 () , lr_16 , vr_70 ) ) ;
}
void error ( String vr_71 ) {
if ( vr_68 . vr_69 () )
vr_68 . add ( new fn_18 ( vr_2 . vr_1 () , vr_71 ) ) ;
}
boolean fn_20 () {
return true ;
}
String fn_21 ( boolean vr_28 ) {
StringBuilder builder = vr_72 . vr_73 () ;
while ( ! vr_2 . isEmpty () ) {
builder . append ( vr_2 . vr_74 ( '&' ) ) ;
if ( vr_2 . vr_47 ( '&' ) ) {
vr_2 . vr_75 () ;
int [] vr_25 = fn_6 ( null , vr_28 ) ;
if ( vr_25 == null || vr_25 . length == 0 )
builder . append ( '&' ) ;
else {
builder . vr_76 ( vr_25 [ 0 ] ) ;
if ( vr_25 . length == 2 )
builder . vr_76 ( vr_25 [ 1 ] ) ;
}
}
}
return vr_72 . vr_77 ( builder ) ;
}
