public static < vt_1 > vt_1 fn_1 ( final Class < vt_1 > vr_1 , Object ... args )
throws vl_1 , vl_2 , vl_3 ,
vl_4 {
args = vr_2 . vr_3 ( args ) ;
final Class < ? > vr_4 [] = vr_5 . vr_6 ( args ) ;
return fn_1 ( vr_1 , args , vr_4 ) ;
}
public static < vt_1 > vt_1 fn_1 ( final Class < vt_1 > vr_1 , Object [] args , Class < ? > [] vr_4 )
throws vl_1 , vl_2 , vl_3 ,
vl_4 {
args = vr_2 . vr_3 ( args ) ;
vr_4 = vr_2 . vr_3 ( vr_4 ) ;
final vr_7 < vt_1 > vr_8 = fn_2 ( vr_1 , vr_4 ) ;
if ( vr_8 == null ) {
throw new vl_1 (
lr_1 + vr_1 . vr_9 () ) ;
}
return vr_8 . vr_10 ( args ) ;
}
public static < vt_1 > vt_1 fn_3 ( final Class < vt_1 > vr_1 , Object ... args )
throws vl_1 , vl_2 , vl_3 ,
vl_4 {
args = vr_2 . vr_3 ( args ) ;
final Class < ? > vr_4 [] = vr_5 . vr_6 ( args ) ;
return fn_3 ( vr_1 , args , vr_4 ) ;
}
public static < vt_1 > vt_1 fn_3 ( final Class < vt_1 > vr_1 , Object [] args ,
Class < ? > [] vr_4 ) throws vl_1 , vl_2 ,
vl_3 , vl_4 {
args = vr_2 . vr_3 ( args ) ;
vr_4 = vr_2 . vr_3 ( vr_4 ) ;
final vr_7 < vt_1 > vr_8 = fn_4 ( vr_1 , vr_4 ) ;
if ( vr_8 == null ) {
throw new vl_1 (
lr_1 + vr_1 . vr_9 () ) ;
}
return vr_8 . vr_10 ( args ) ;
}
public static < vt_1 > vr_7 < vt_1 > fn_4 ( final Class < vt_1 > vr_1 ,
final Class < ? > ... vr_4 ) {
vr_11 . vr_12 ( vr_1 , lr_2 ) ;
try {
return fn_4 ( vr_1 . vr_13 ( vr_4 ) ) ;
} catch ( final vl_1 vr_14 ) {
return null ;
}
}
public static < vt_1 > vr_7 < vt_1 > fn_4 ( final vr_7 < vt_1 > vr_8 ) {
vr_11 . vr_12 ( vr_8 , lr_3 ) ;
return vr_15 . vr_16 ( vr_8 )
&& vr_16 ( vr_8 . vr_17 () ) ? vr_8 : null ;
}
public static < vt_1 > vr_7 < vt_1 > fn_2 ( final Class < vt_1 > vr_1 ,
final Class < ? > ... vr_4 ) {
vr_11 . vr_12 ( vr_1 , lr_2 ) ;
try {
final vr_7 < vt_1 > vr_8 = vr_1 . vr_13 ( vr_4 ) ;
vr_15 . vr_18 ( vr_8 ) ;
return vr_8 ;
} catch ( final vl_1 vr_14 ) {
}
vr_7 < vt_1 > vr_19 = null ;
final vr_7 < ? > [] vr_20 = vr_1 . vr_21 () ;
for ( vr_7 < ? > vr_8 : vr_20 ) {
if ( vr_5 . vr_22 ( vr_4 , vr_8 . vr_23 () , true ) ) {
vr_8 = fn_4 ( vr_8 ) ;
if ( vr_8 != null ) {
vr_15 . vr_18 ( vr_8 ) ;
if ( vr_19 == null
|| vr_15 . vr_24 ( vr_8 . vr_23 () , vr_19
. vr_23 () , vr_4 ) < 0 ) {
@SuppressWarnings ( lr_4 )
final
vr_7 < vt_1 > vr_25 = ( vr_7 < vt_1 > ) vr_8 ;
vr_19 = vr_25 ;
}
}
}
}
return vr_19 ;
}
private static boolean vr_16 ( final Class < ? > type ) {
Class < ? > vr_1 = type ;
while ( vr_1 != null ) {
if ( ! vr_26 . vr_27 ( vr_1 . vr_28 () ) ) {
return false ;
}
vr_1 = vr_1 . vr_29 () ;
}
return true ;
}
