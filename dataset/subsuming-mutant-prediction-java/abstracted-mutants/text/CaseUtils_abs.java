public static String fn_1 ( String vr_1 , final boolean vr_2 , final char ... vr_3 ) {
if ( vr_4 . isEmpty ( vr_1 ) ) {
return vr_1 ;
}
vr_1 = vr_1 . vr_5 () ;
final int strLen = vr_1 . length () ;
final int [] vr_6 = new int [ strLen ] ;
int vr_7 = 0 ;
final vr_8 < Integer > vr_9 = fn_2 ( vr_3 ) ;
boolean vr_10 = false ;
if ( vr_2 ) {
vr_10 = true ;
}
for ( int vr_11 = 0 ; vr_11 < strLen ; ) {
final int vr_12 = vr_1 . vr_13 ( vr_11 ) ;
if ( vr_9 . contains ( vr_12 ) ) {
vr_10 = true ;
if ( vr_7 == 0 ) {
vr_10 = false ;
}
vr_11 += vr_14 . vr_15 ( vr_12 ) ;
} else if ( vr_10 || vr_7 == 0 && vr_2 ) {
final int vr_16 = vr_14 . vr_17 ( vr_12 ) ;
vr_6 [ vr_7 ++ ] = vr_16 ;
vr_11 += vr_14 . vr_15 ( vr_16 ) ;
vr_10 = false ;
} else {
vr_6 [ vr_7 ++ ] = vr_12 ;
vr_11 += vr_14 . vr_15 ( vr_12 ) ;
}
}
if ( vr_7 != 0 ) {
return new String ( vr_6 , 0 , vr_7 ) ;
}
return vr_1 ;
}
private static vr_8 < Integer > fn_2 ( final char [] vr_3 ) {
final vr_8 < Integer > vr_18 = new vr_19 <> () ;
vr_18 . add ( vr_14 . vr_13 ( new char [] { ' ' } , 0 ) ) ;
if ( vr_3 == null || vr_3 . length == 0 ) {
return vr_18 ;
}
for ( int vr_11 = 0 ; vr_11 < vr_3 . length ; vr_11 ++ ) {
vr_18 . add ( vr_14 . vr_13 ( vr_3 , vr_11 ) ) ;
}
return vr_18 ;
}
