private static boolean fn_1 ( final char vr_1 ) {
return vr_1 == 'A' || vr_1 == 'E' || vr_1 == 'I' || vr_1 == 'O' || vr_1 == 'U' ;
}
private static char [] fn_2 ( final char vr_2 , final char vr_3 , final char vr_4 , final char vr_5 ) {
if ( vr_3 == 'E' && vr_4 == 'V' ) {
return vl_1 ;
}
if ( fn_1 ( vr_3 ) ) {
return vl_2 ;
}
if ( vr_3 == 'Q' ) {
return vl_3 ;
} else if ( vr_3 == 'Z' ) {
return vl_4 ;
} else if ( vr_3 == 'M' ) {
return vl_5 ;
}
if ( vr_3 == 'K' ) {
if ( vr_4 == 'N' ) {
return vl_6 ;
}
return vl_7 ;
}
if ( vr_3 == 'S' && vr_4 == 'C' && vr_5 == 'H' ) {
return vl_8 ;
}
if ( vr_3 == 'P' && vr_4 == 'H' ) {
return vl_9 ;
}
if ( vr_3 == 'H' && ( ! fn_1 ( vr_2 ) || ! fn_1 ( vr_4 ) ) ) {
return new char [] { vr_2 } ;
}
if ( vr_3 == 'W' && fn_1 ( vr_2 ) ) {
return new char [] { vr_2 } ;
}
return new char [] { vr_3 } ;
}
@Override
public Object fn_3 ( final Object vr_6 ) throws vl_10 {
if ( ! ( vr_6 instanceof String ) ) {
throw new vl_10 ( lr_1 ) ;
}
return this . vr_7 ( ( String ) vr_6 ) ;
}
@Override
public String fn_3 ( final String vr_8 ) {
return this . vr_7 ( vr_8 ) ;
}
public boolean fn_4 () {
return this . vr_9 ;
}
public String vr_7 ( String vr_8 ) {
if ( vr_8 == null ) {
return null ;
}
vr_8 = vr_10 . vr_11 ( vr_8 ) ;
if ( vr_8 . length () == 0 ) {
return vr_8 ;
}
vr_8 = vr_12 . vr_13 ( vr_8 ) . fn_5 ( lr_2 ) ;
vr_8 = vr_14 . vr_13 ( vr_8 ) . fn_5 ( lr_3 ) ;
vr_8 = vr_15 . vr_13 ( vr_8 ) . fn_5 ( lr_4 ) ;
vr_8 = vr_16 . vr_13 ( vr_8 ) . fn_5 ( lr_5 ) ;
vr_8 = vr_17 . vr_13 ( vr_8 ) . fn_5 ( lr_6 ) ;
vr_8 = vr_18 . vr_13 ( vr_8 ) . fn_5 ( lr_7 ) ;
vr_8 = vr_19 . vr_13 ( vr_8 ) . fn_5 ( lr_8 ) ;
final StringBuilder vr_20 = new StringBuilder ( vr_8 . length () ) ;
vr_20 . append ( vr_8 . charAt ( 0 ) ) ;
final char [] vr_21 = vr_8 . vr_22 () ;
final int vr_23 = vr_21 . length ;
for ( int vr_24 = 1 ; vr_24 < vr_23 ; vr_24 ++ ) {
final char vr_4 = vr_24 < vr_23 - 1 ? vr_21 [ vr_24 + 1 ] : vl_11 ;
final char vr_5 = vr_24 < vr_23 - 2 ? vr_21 [ vr_24 + 2 ] : vl_11 ;
final char [] vr_25 = fn_2 ( vr_21 [ vr_24 - 1 ] , vr_21 [ vr_24 ] , vr_4 , vr_5 ) ;
System . vr_26 ( vr_25 , 0 , vr_21 , vr_24 , vr_25 . length ) ;
if ( vr_21 [ vr_24 ] != vr_21 [ vr_24 - 1 ] ) {
vr_20 . append ( vr_21 [ vr_24 ] ) ;
}
}
if ( vr_20 . length () > 1 ) {
char vr_27 = vr_20 . charAt ( vr_20 . length () - 1 ) ;
if ( vr_27 == 'S' ) {
vr_20 . vr_28 ( vr_20 . length () - 1 ) ;
vr_27 = vr_20 . charAt ( vr_20 . length () - 1 ) ;
}
if ( vr_20 . length () > 2 ) {
final char vr_29 = vr_20 . charAt ( vr_20 . length () - 2 ) ;
if ( vr_29 == 'A' && vr_27 == 'Y' ) { MST[rv.CRCR5Mutator]MSP[S]
vr_20 . vr_28 ( vr_20 . length () - 2 ) ;
}
}
if ( vr_27 == 'A' ) {
vr_20 . vr_28 ( vr_20 . length () - 1 ) ;
}
}
final String string = vr_20 . toString () ;
return this . fn_4 () ? string . vr_30 ( 0 , vr_31 . vr_32 ( vl_12 , string . length () ) ) : string ;
}
