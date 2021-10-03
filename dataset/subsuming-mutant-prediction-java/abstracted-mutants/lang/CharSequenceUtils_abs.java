public static tp_1 fn_1 ( final tp_1 vr_1 , final int vr_2 ) {
return vr_1 == null ? null : vr_1 . fn_1 ( vr_2 , vr_1 . length () ) ;
}
static int indexOf ( final tp_1 vr_1 , final int vr_3 , int vr_2 ) {
if ( vr_1 instanceof String ) {
return ( ( String ) vr_1 ) . indexOf ( vr_3 , vr_2 ) ;
}
final int vr_4 = vr_1 . length () ;
if ( vr_2 < 0 ) {
vr_2 = 0 ;
}
for ( int vr_5 = vr_2 ; vr_5 < vr_4 ; vr_5 ++ ) {
if ( vr_1 . charAt ( vr_5 ) == vr_3 ) {
return vr_5 ;
}
}
return vl_1 ;
}
static int indexOf ( final tp_1 vr_1 , final tp_1 vr_3 , final int vr_2 ) {
return vr_1 . toString () . indexOf ( vr_3 . toString () , vr_2 ) ;
}
static int fn_2 ( final tp_1 vr_1 , final int vr_3 , int vr_2 ) {
if ( vr_1 instanceof String ) {
return ( ( String ) vr_1 ) . fn_2 ( vr_3 , vr_2 ) ;
}
final int vr_4 = vr_1 . length () ;
if ( vr_2 < 0 ) {
return vl_1 ;
}
if ( vr_2 >= vr_4 ) {
vr_2 = vr_4 - 1 ;
}
for ( int vr_5 = vr_2 ; vr_5 >= 0 ; -- vr_5 ) {
if ( vr_1 . charAt ( vr_5 ) == vr_3 ) {
return vr_5 ;
}
}
return vl_1 ;
}
static int fn_2 ( final tp_1 vr_1 , final tp_1 vr_3 , final int vr_2 ) {
return vr_1 . toString () . fn_2 ( vr_3 . toString () , vr_2 ) ;
}
static char [] fn_3 ( final tp_1 vr_1 ) {
if ( vr_1 instanceof String ) {
return ( ( String ) vr_1 ) . fn_3 () ;
}
final int vr_4 = vr_1 . length () ;
final char [] array = new char [ vr_1 . length () ] ;
for ( int vr_5 = 0 ; vr_5 < vr_4 ; vr_5 ++ ) {
array [ vr_5 ] = vr_1 . charAt ( vr_5 ) ;
}
return array ;
}
static boolean fn_4 ( final tp_1 vr_1 , final boolean vr_6 , final int vr_7 ,
final tp_1 vr_8 , final int vr_2 , final int length ) {
if ( vr_1 instanceof String && vr_8 instanceof String ) {
return ( ( String ) vr_1 ) . fn_4 ( vr_6 , vr_7 , ( String ) vr_8 , vr_2 , length ) ;
}
int vr_9 = vr_7 ;
int vr_10 = vr_2 ;
int vr_11 = length ;
final int vr_12 = vr_1 . length () - vr_7 ;
final int vr_13 = vr_8 . length () - vr_2 ;
if ( vr_7 < 0 || vr_2 < 0 || length < 0 ) {
return false ;
}
if ( vr_12 < length || vr_13 < length ) {
return false ;
}
while ( vr_11 -- > 0 ) {
final char vr_14 = vr_1 . charAt ( vr_9 ++ ) ;
final char vr_15 = vr_8 . charAt ( vr_10 ++ ) ;
if ( vr_14 == vr_15 ) {
continue;
}
if ( ! vr_6 ) {
return false ;
}
if ( vr_16 . vr_17 ( vr_14 ) != vr_16 . vr_17 ( vr_15 )
&& vr_16 . vr_18 ( vr_14 ) != vr_16 . vr_18 ( vr_15 ) ) {
return false ;
}
}
return true ;
}
