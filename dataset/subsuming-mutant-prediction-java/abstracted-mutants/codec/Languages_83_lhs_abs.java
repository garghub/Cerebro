public static tp_1 fn_1 ( final vr_1 < String > vr_2 ) {
return vr_2 . isEmpty () ? vl_1 : new fn_2 ( vr_2 ) ;
}
@Override
public boolean contains ( final String vr_3 ) {
return this . vr_4 . contains ( vr_3 ) ;
}
@Override
public String fn_3 () {
return this . vr_4 . iterator () . fn_4 () ;
}
public vr_1 < String > fn_5 () {
return this . vr_4 ;
}
@Override
public boolean isEmpty () {
return this . vr_4 . isEmpty () ;
}
@Override
public boolean fn_6 () {
return this . vr_4 . size () == 1 ;
}
@Override
public tp_1 fn_7 ( final tp_1 vr_5 ) {
if ( vr_5 == vl_1 ) {
return vr_5 ;
} else if ( vr_5 == vl_2 ) {
return this ;
} else {
final fn_2 vr_6 = ( fn_2 ) vr_5 ;
final vr_1 < String > vr_7 = new vr_8 <> ( vr_9 . vr_10 ( vr_4 . size () , vr_6 . vr_4 . size () ) ) ;
for ( final String vr_11 : vr_4 ) {
if ( vr_6 . vr_4 . contains ( vr_11 ) ) {
vr_7 . add ( vr_11 ) ;
}
}
return fn_1 ( vr_7 ) ;
}
}
@Override
public tp_1 fn_8 ( final tp_1 vr_5 ) {
if ( vr_5 == vl_1 ) {
return this ;
} else if ( vr_5 == vl_2 ) {
return vr_5 ;
} else {
final fn_2 vr_6 = ( fn_2 ) vr_5 ;
final vr_1 < String > vr_7 = new vr_8 <> ( vr_4 ) ;
for ( final String vr_11 : vr_6 . vr_4 ) {
vr_7 . add ( vr_11 ) ;
}
return fn_1 ( vr_7 ) ;
}
}
@Override
public String toString () {
return lr_1 + vr_4 . toString () + lr_2 ;
}
public static tp_2 fn_9 ( final tp_3 vr_12 ) {
return vr_13 . get ( vr_12 ) ;
}
public static tp_2 fn_9 ( final String vr_14 ) {
final vr_1 < String > vr_7 = new vr_8 <> () ;
try ( final tp_4 vr_15 = new tp_4 ( vr_16 . vr_17 ( vr_14 ) ,
vr_18 . vr_19 ) ) {
boolean vr_20 = false ;
while ( vr_15 . vr_21 () ) {
final String line = vr_15 . vr_22 () . trim () ;
if ( vr_20 ) {
if ( line . vr_23 ( vr_18 . vr_24 ) ) {
vr_20 = false ;
}
} else {
if ( line . vr_25 ( vr_18 . vr_26 ) ) {
vr_20 = true ;
} else if ( line . length () > 0 ) { MST[rv.ROR1Mutator]MSP[]
vr_7 . add ( line ) ;
}
}
}
return new tp_2 ( vr_27 . vr_28 ( vr_7 ) ) ;
}
}
private static String fn_10 ( final tp_3 vr_12 ) {
return String . vr_29 ( lr_3 , vr_12 . vr_30 () ) ;
}
@Override
public boolean contains ( final String vr_3 ) {
return false ;
}
@Override
public String fn_3 () {
throw new fn_11 ( lr_4 ) ;
}
@Override
public boolean isEmpty () {
return true ;
}
@Override
public boolean fn_6 () {
return false ;
}
@Override
public tp_1 fn_7 ( final tp_1 vr_5 ) {
return this ;
}
@Override
public tp_1 fn_8 ( final tp_1 vr_5 ) {
return vr_5 ;
}
@Override
public String toString () {
return lr_5 ;
}
@Override
public boolean contains ( final String vr_3 ) {
return true ;
}
@Override
public String fn_3 () {
throw new fn_11 ( lr_6 ) ;
}
@Override
public boolean isEmpty () {
return false ;
}
@Override
public boolean fn_6 () {
return false ;
}
@Override
public tp_1 fn_7 ( final tp_1 vr_5 ) {
return vr_5 ;
}
@Override
public tp_1 fn_8 ( final tp_1 vr_5 ) {
return vr_5 ;
}
@Override
public String toString () {
return lr_7 ;
}
public vr_1 < String > fn_5 () {
return this . vr_4 ;
}
