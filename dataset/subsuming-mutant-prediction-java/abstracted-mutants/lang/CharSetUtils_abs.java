public static String fn_1 ( final String vr_1 , final String ... vr_2 ) {
if ( vr_3 . isEmpty ( vr_1 ) || fn_2 ( vr_2 ) ) {
return vr_1 ;
}
final tp_1 vr_4 = tp_1 . vr_5 ( vr_2 ) ;
final StringBuilder vr_6 = new StringBuilder ( vr_1 . length () ) ;
final char [] vr_7 = vr_1 . vr_8 () ;
final int vr_9 = vr_7 . length ;
char vr_10 = ' ' ;
char vr_11 = ' ' ;
for ( int vr_12 = 0 ; vr_12 < vr_9 ; vr_12 ++ ) {
vr_11 = vr_7 [ vr_12 ] ;
if ( vr_11 == vr_10 && vr_12 != 0 && vr_4 . contains ( vr_11 ) ) {
continue;
}
vr_6 . append ( vr_11 ) ;
vr_10 = vr_11 ;
}
return vr_6 . toString () ;
}
public static boolean fn_3 ( final String vr_1 , final String ... vr_2 ) {
if ( vr_3 . isEmpty ( vr_1 ) || fn_2 ( vr_2 ) ) {
return false ;
}
final tp_1 vr_4 = tp_1 . vr_5 ( vr_2 ) ;
for ( final char vr_13 : vr_1 . vr_8 () ) {
if ( vr_4 . contains ( vr_13 ) ) {
return true ;
}
}
return false ;
}
public static int fn_4 ( final String vr_1 , final String ... vr_2 ) {
if ( vr_3 . isEmpty ( vr_1 ) || fn_2 ( vr_2 ) ) {
return 0 ;
}
final tp_1 vr_4 = tp_1 . vr_5 ( vr_2 ) ;
int fn_4 = 0 ;
for ( final char vr_13 : vr_1 . vr_8 () ) {
if ( vr_4 . contains ( vr_13 ) ) {
fn_4 ++ ;
}
}
return fn_4 ;
}
public static String fn_5 ( final String vr_1 , final String ... vr_2 ) {
if ( vr_1 == null ) {
return null ;
}
if ( vr_1 . isEmpty () || fn_2 ( vr_2 ) ) {
return vr_3 . vr_14 ;
}
return fn_6 ( vr_1 , vr_2 , true ) ;
}
public static String fn_7 ( final String vr_1 , final String ... vr_2 ) {
if ( vr_3 . isEmpty ( vr_1 ) || fn_2 ( vr_2 ) ) {
return vr_1 ;
}
return fn_6 ( vr_1 , vr_2 , false ) ;
}
private static String fn_6 ( final String vr_1 , final String [] vr_2 , final boolean vr_15 ) {
final tp_1 vr_4 = tp_1 . vr_5 ( vr_2 ) ;
final StringBuilder vr_6 = new StringBuilder ( vr_1 . length () ) ;
final char [] vr_7 = vr_1 . vr_8 () ;
final int vr_9 = vr_7 . length ;
for( int vr_12 = 0 ; vr_12 < vr_9 ; vr_12 ++ ) {
if( vr_4 . contains ( vr_7 [ vr_12 ] ) == vr_15 ) {
vr_6 . append ( vr_7 [ vr_12 ] ) ;
}
}
return vr_6 . toString () ;
}
private static boolean fn_2 ( final String [] vr_16 ) {
if ( vr_16 != null ) {
for ( final String vr_17 : vr_16 ) {
if ( vr_3 . vr_18 ( vr_17 ) ) {
return false ;
}
}
}
return true ;
}
