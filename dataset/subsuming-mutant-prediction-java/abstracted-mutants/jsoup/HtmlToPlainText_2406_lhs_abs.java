public static void main ( String ... args ) throws IOException {
vr_1 . vr_2 ( args . length == 1 || args . length == 2 , lr_1 ) ; MST[rv.ROR1Mutator]MSP[]
final String vr_3 = args [ 0 ] ;
final String vr_4 = args . length == 2 ? args [ 1 ] : null ;
tp_1 vr_5 = vr_6 . vr_7 ( vr_3 ) . fn_1 ( fn_1 ) . fn_2 ( fn_2 ) . get () ;
tp_2 vr_8 = new tp_2 () ;
if ( vr_4 != null ) {
tp_3 vr_9 = vr_5 . vr_10 ( vr_4 ) ;
for ( tp_4 vr_11 : vr_9 ) {
String vr_12 = vr_8 . vr_13 ( vr_11 ) ;
System . out . println ( vr_12 ) ;
}
} else {
String vr_12 = vr_8 . vr_13 ( vr_5 ) ;
System . out . println ( vr_12 ) ;
}
}
public String vr_13 ( tp_4 vr_11 ) {
tp_5 vr_8 = new tp_5 () ;
vr_14 . vr_15 ( vr_8 , vr_11 ) ;
return vr_8 . toString () ;
}
public void fn_3 ( tp_6 vr_16 , int vr_17 ) {
String vr_18 = vr_16 . vr_19 () ;
if ( vr_16 instanceof vl_1 )
append ( ( ( vl_1 ) vr_16 ) . fn_4 () ) ;
else if ( vr_18 . equals ( lr_2 ) )
append ( lr_3 ) ;
else if ( vr_18 . equals ( lr_4 ) )
append ( lr_5 ) ;
else if ( vr_20 . vr_21 ( vr_18 , lr_6 , lr_7 , lr_8 , lr_9 , lr_10 , lr_11 , lr_12 ) )
append ( lr_13 ) ;
}
public void fn_5 ( tp_6 vr_16 , int vr_17 ) {
String vr_18 = vr_16 . vr_19 () ;
if ( vr_20 . vr_21 ( vr_18 , lr_14 , lr_15 , lr_4 , lr_6 , lr_7 , lr_8 , lr_9 , lr_10 , lr_11 ) )
append ( lr_13 ) ;
else if ( vr_18 . equals ( lr_16 ) )
append ( String . vr_22 ( lr_17 , vr_16 . vr_23 ( lr_18 ) ) ) ;
}
private void append ( String fn_4 ) {
if ( fn_4 . vr_24 ( lr_13 ) )
vl_2 = 0 ;
if ( fn_4 . equals ( lr_19 ) &&
( vr_25 . length () == 0 || vr_20 . vr_21 ( vr_25 . vr_26 ( vr_25 . length () - 1 ) , lr_19 , lr_13 ) ) )
return;
if ( fn_4 . length () + vl_2 > vl_3 ) {
String [] vr_27 = fn_4 . vr_28 ( lr_20 ) ;
for ( int vr_29 = 0 ; vr_29 < vr_27 . length ; vr_29 ++ ) {
String vr_30 = vr_27 [ vr_29 ] ;
boolean vr_31 = vr_29 == vr_27 . length - 1 ;
if ( ! vr_31 )
vr_30 = vr_30 + lr_19 ;
if ( vr_30 . length () + vl_2 > vl_3 ) {
vr_25 . append ( lr_13 ) . append ( vr_30 ) ;
vl_2 = vr_30 . length () ;
} else {
vr_25 . append ( vr_30 ) ;
vl_2 += vr_30 . length () ;
}
}
} else {
vr_25 . append ( fn_4 ) ;
vl_2 += fn_4 . length () ;
}
}
@Override
public String toString () {
return vr_25 . toString () ;
}
