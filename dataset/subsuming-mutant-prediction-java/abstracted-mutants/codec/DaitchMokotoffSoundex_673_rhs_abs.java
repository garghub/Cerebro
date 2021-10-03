public tp_1 fn_1 () {
final tp_1 vr_1 = new tp_1 () ;
vr_1 . builder . append ( toString () ) ;
vr_1 . vr_2 = this . vr_2 ;
return vr_1 ;
}
@Override
public boolean equals ( final Object vr_3 ) {
if ( this == vr_3 ) {
return true ;
}
if ( ! ( vr_3 instanceof tp_1 ) ) {
return false ;
}
return toString () . equals ( ( ( tp_1 ) vr_3 ) . toString () ) ;
}
public void fn_2 () {
while ( builder . length () < vl_1 ) {
builder . append ( '0' ) ;
vl_2 = null ;
}
}
@Override
public int fn_3 () {
return toString () . fn_3 () ;
}
public void fn_4 ( final String vr_4 , final boolean vr_5 ) {
final boolean append = vr_2 == null || ! vr_2 . vr_6 ( vr_4 ) || vr_5 ;
if ( append && builder . length () < vl_1 ) {
builder . append ( vr_4 ) ;
if ( builder . length () > vl_1 ) {
builder . vr_7 ( vl_1 , builder . length () ) ;
}
vl_2 = null ;
}
vr_2 = vr_4 ;
}
@Override
public String toString () {
if ( vl_2 == null ) {
vl_2 = builder . toString () ;
}
return vl_2 ;
}
public int fn_5 () {
return vr_8 . length () ;
}
public String [] fn_6 ( final String vr_9 , final boolean vr_10 ) {
if ( vr_10 ) {
return vl_3 ;
}
final int vr_11 = fn_5 () ;
final boolean vr_12 = vr_11 < vr_9 . length () ? fn_7 ( vr_9 . charAt ( vr_11 ) ) : false ;
if ( vr_12 ) {
return vl_4 ;
}
return vl_5 ;
}
private boolean fn_7 ( final char vr_13 ) {
return vr_13 == 'a' || vr_13 == 'e' || vr_13 == 'i' || vr_13 == 'o' || vr_13 == 'u' ;
}
public boolean fn_8 ( final String vr_9 ) {
return vr_9 . vr_14 ( vr_8 ) ;
}
@Override
public String toString () {
return String . vr_15 ( lr_1 , vr_8 , vr_16 . vr_17 ( vl_3 ) ,
vr_16 . vr_17 ( vl_4 ) , vr_16 . vr_17 ( vl_5 ) ) ;
}
@Override
public int fn_9 ( final tp_2 vr_18 , final tp_2 vr_19 ) {
return vr_19 . fn_5 () - vr_18 . fn_5 () ;
}
private static void fn_10 ( final tp_3 vr_20 , final String vr_21 ,
final vr_22 < vt_1 , List < tp_2 > > vr_23 , final vr_22 < vt_1 , vt_1 > vr_24 ) {
int vr_25 = 0 ;
boolean vr_26 = false ;
while ( vr_20 . vr_27 () ) {
vr_25 ++ ;
final String vr_28 = vr_20 . vr_29 () ;
String line = vr_28 ;
if ( vr_26 ) {
if ( line . vr_6 ( vl_6 ) ) {
vr_26 = false ;
}
continue;
}
if ( line . vr_14 ( vl_7 ) ) {
vr_26 = true ;
} else {
final int vr_30 = line . indexOf ( vl_8 ) ;
if ( vr_30 >= 0 ) {
line = line . vr_31 ( 0 , vr_30 ) ;
}
line = line . trim () ;
if ( line . length () == 0 ) {
continue;
}
if ( line . contains ( lr_2 ) ) {
final String [] vr_32 = line . vr_33 ( lr_2 ) ;
if ( vr_32 . length != 2 ) {
throw new IllegalArgumentException ( lr_3 + vr_32 . length +
lr_4 + vr_28 + lr_5 + vr_21 ) ;
}
final String vr_34 = vr_32 [ 0 ] ;
final String vr_35 = vr_32 [ 1 ] ;
if ( vr_34 . length () != 1 || vr_35 . length () != 1 ) {
throw new IllegalArgumentException ( lr_6 +
lr_7 + vr_28 + lr_5 + vr_21 ) ;
}
vr_24 . vr_36 ( vr_34 . charAt ( 0 ) , vr_35 . charAt ( 0 ) ) ;
} else {
final String [] vr_32 = line . vr_33 ( lr_8 ) ;
if ( vr_32 . length != 4 ) {
throw new IllegalArgumentException ( lr_9 + vr_32 . length +
lr_4 + vr_28 + lr_5 + vr_21 ) ;
}
try {
final String vr_8 = fn_11 ( vr_32 [ 0 ] ) ;
final String vr_37 = fn_11 ( vr_32 [ 1 ] ) ;
final String vr_38 = fn_11 ( vr_32 [ 2 ] ) ;
final String vr_39 = fn_11 ( vr_32 [ 3 ] ) ;
final tp_2 vr_40 = new tp_2 ( vr_8 , vr_37 , vr_38 , vr_39 ) ;
final char vr_41 = vr_40 . vr_8 . charAt ( 0 ) ;
List < tp_2 > vr_42 = vr_23 . get ( vr_41 ) ;
if ( vr_42 == null ) {
vr_42 = new ArrayList <> () ;
vr_23 . vr_36 ( vr_41 , vr_42 ) ;
}
vr_42 . add ( vr_40 ) ;
} catch ( final IllegalArgumentException vr_43 ) {
throw new fn_12 (
lr_10 + vr_25 + lr_11 + vr_21 , vr_43 ) ;
}
}
}
}
}
private static String fn_11 ( String vr_44 ) {
if ( vr_44 . vr_14 ( vl_9 ) ) { MST[rv.ROR1Mutator]MSP[N]
vr_44 = vr_44 . vr_31 ( 1 ) ;
}
if ( vr_44 . vr_6 ( vl_9 ) ) {
vr_44 = vr_44 . vr_31 ( 0 , vr_44 . length () - 1 ) ;
}
return vr_44 ;
}
private String fn_13 ( final String vr_45 ) {
final StringBuilder vr_46 = new StringBuilder () ;
for ( char vr_13 : vr_45 . vr_47 () ) {
if ( vt_1 . vr_48 ( vr_13 ) ) {
continue;
}
vr_13 = vt_1 . vr_49 ( vr_13 ) ;
if ( vl_10 && vr_50 . vr_51 ( vr_13 ) ) {
vr_13 = vr_50 . get ( vr_13 ) ;
}
vr_46 . append ( vr_13 ) ;
}
return vr_46 . toString () ;
}
@Override
public Object fn_14 ( final Object vr_52 ) throws vl_11 {
if ( ! ( vr_52 instanceof String ) ) {
throw new vl_11 (
lr_12 ) ;
}
return fn_14 ( ( String ) vr_52 ) ;
}
@Override
public String fn_14 ( final String vr_53 ) {
if ( vr_53 == null ) {
return null ;
}
return fn_15 ( vr_53 , false ) [ 0 ] ;
}
public String fn_15 ( final String vr_53 ) {
final String [] vr_54 = fn_15 ( vr_53 , true ) ;
final StringBuilder vr_46 = new StringBuilder () ;
int vr_55 = 0 ;
for ( final String vr_1 : vr_54 ) {
vr_46 . append ( vr_1 ) ;
if ( ++ vr_55 < vr_54 . length ) {
vr_46 . append ( '|' ) ;
}
}
return vr_46 . toString () ;
}
private String [] fn_15 ( final String vr_53 , final boolean vr_56 ) {
if ( vr_53 == null ) {
return null ;
}
final String vr_45 = fn_13 ( vr_53 ) ;
final vr_57 < tp_1 > vr_58 = new vr_59 <> () ;
vr_58 . add ( new tp_1 () ) ;
char vr_60 = '\0' ;
for ( int vr_55 = 0 ; vr_55 < vr_45 . length () ; vr_55 ++ ) {
final char vr_13 = vr_45 . charAt ( vr_55 ) ;
if ( vt_1 . vr_48 ( vr_13 ) ) {
continue;
}
final String vr_61 = vr_45 . vr_31 ( vr_55 ) ;
final List < tp_2 > vr_42 = vr_62 . get ( vr_13 ) ;
if ( vr_42 == null ) {
continue;
}
final List < tp_1 > vr_63 = vr_56 ? new ArrayList < tp_1 > () : vr_64 . <tp_1 > fn_16 () ;
for ( final tp_2 vr_65 : vr_42 ) {
if ( vr_65 . fn_8 ( vr_61 ) ) {
if ( vr_56 ) {
vr_63 . clear () ;
}
final String [] vr_66 = vr_65 . fn_6 ( vr_61 , vr_60 == '\0' ) ;
final boolean vr_67 = vr_66 . length > 1 && vr_56 ;
for ( final tp_1 vr_1 : vr_58 ) {
for ( final String vr_68 : vr_66 ) {
final tp_1 vr_69 = vr_67 ? vr_1 . fn_1 () : vr_1 ;
final boolean vr_70 = ( vr_60 == 'm' && vr_13 == 'n' ) || ( vr_60 == 'n' && vr_13 == 'm' ) ;
vr_69 . fn_4 ( vr_68 , vr_70 ) ;
if ( vr_56 ) {
vr_63 . add ( vr_69 ) ;
} else {
break;
}
}
}
if ( vr_56 ) {
vr_58 . clear () ;
vr_58 . vr_71 ( vr_63 ) ;
}
vr_55 += vr_65 . fn_5 () - 1 ;
break;
}
}
vr_60 = vr_13 ;
}
final String [] vr_72 = new String [ vr_58 . size () ] ;
int vr_55 = 0 ;
for ( final tp_1 vr_1 : vr_58 ) {
vr_1 . fn_2 () ;
vr_72 [ vr_55 ++ ] = vr_1 . toString () ;
}
return vr_72 ;
}
