public String fn_1 ( final String vr_1 )
throws vl_1 {
if ( vr_1 == null ) {
return null ;
}
final StringBuilder vr_2 = new StringBuilder () ;
for ( int vr_3 = 0 ; vr_3 < vr_1 . length () ; ) {
final int vr_4 = vr_1 . vr_5 ( vr_3 ) ;
final String vr_6 = vr_7 . get ( vr_4 ) ;
if ( vr_6 == null ) {
throw new vl_1 (
lr_1
+ fn_2 ( vr_4 )
+ lr_2
+ vr_1
) ;
}
vr_2 . append ( vr_6 ) ;
vr_3 += vr_8 . vr_9 ( vr_4 ) ;
}
return vr_2 . toString () ;
}
public String fn_3 ( final String vr_10 )
throws vl_1 {
if ( vr_10 == null ) {
return null ;
}
final StringBuilder vr_11 = new StringBuilder () ;
for ( int vr_12 = 0 ; vr_12 < vr_10 . length () ; ) {
final Integer vr_3 = vr_10 . vr_5 ( vr_12 ) ;
final String vr_13 = fn_2 ( vr_3 ) ;
if ( vr_13 . equals ( vr_7 . get ( vr_3 ) ) ) {
vr_11 . append ( vr_13 ) ;
vr_12 ++ ;
} else {
if ( vr_12 + vl_2 > vr_10 . length () ) {
throw new vl_1 ( lr_3
+ lr_4 + vr_10 ) ;
}
final String vr_14 = vr_10 . vr_15 ( vr_12 ,
vr_12 + vl_2 ) ;
final String vr_16 = vr_17 . get ( vr_14 ) ;
if ( vr_16 == null ) {
throw new vl_1 (
lr_5
+ vr_14 + lr_6 + vr_10 ) ;
}
vr_11 . append ( vr_16 ) ;
vr_12 += vl_2 ;
}
}
return vr_11 . toString () ;
}
public int fn_4 () {
return vl_2 ;
}
public vr_18 < Integer , String > fn_5 () {
return vr_19 . vr_20 ( vr_7 ) ;
}
@SuppressWarnings ( lr_7 )
private void fn_6 ( final int vr_21 ,
final String vr_22 ,
final Collection < Integer > vr_23 ,
final Iterator < Integer > vr_24 ,
final vr_18 < Integer , String > vr_25 ) {
if ( vr_21 > 0 ) {
for ( final int vr_26 : vr_23 ) {
if ( vr_24 . hasNext () ) {
if ( vr_21 != vl_2
|| ! vr_25 . vr_27 ( vr_26 ) ) {
fn_6 ( vr_21 - 1 ,
vr_22
+ fn_2 ( vr_26 ) ,
vr_23 ,
vr_24 ,
vr_25
) ;
}
} else {
return;
}
}
} else {
Integer vr_16 = vr_24 . vr_16 () ;
while ( vr_25 . vr_27 ( vr_16 ) ) {
final String vr_28 = fn_2 ( vr_16 ) ;
vr_7 . vr_29 ( vr_16 , vr_28 ) ;
vr_17 . vr_29 ( vr_28 ,
vr_28 ) ;
if ( ! vr_24 . hasNext () ) {
return;
}
vr_16 = vr_24 . vr_16 () ;
}
final String vr_28 = fn_2 ( vr_16 ) ;
vr_7 . vr_29 ( vr_16 , vr_22 ) ;
vr_17 . vr_29 ( vr_22 , vr_28 ) ;
}
}
@Override
public String toString () {
final StringBuilder vr_2 = new StringBuilder () ;
for ( final vr_30 < Integer , String > vr_31
: vr_7 . vr_32 () ) {
vr_2 . append ( fn_2 ( vr_31 . vr_33 () ) )
. append ( vl_3 )
. append ( vr_31 . vr_34 () ) . append ( System . vr_35 () ) ;
}
return vr_2 . toString () ;
}
@Override
public boolean equals ( final Object vr_36 ) {
if ( vr_36 == null ) {
return false ;
}
if ( vr_36 == this ) {
return true ;
}
if ( ! ( vr_36 instanceof vl_4 ) ) {
return false ;
}
final vl_4 vr_37 = ( vl_4 ) vr_36 ;
return vr_7 . equals ( vr_37 . vr_7 )
&& vr_17 . equals ( vr_37 . vr_17 )
&& vl_2 == vr_37 . vl_2 ;
}
@Override
public int fn_7 () {
return vr_38 . vr_39 ( vr_7 ,
vr_17 ,
vl_2 ) ;
}
public static vl_4 fn_8 (
final vr_18 < Integer , String > vr_7 ) {
final vr_18 < Integer , String > vr_40 =
vr_19 . vr_20 ( vr_7 ) ;
final vr_18 < String , String > vr_17 = new vr_41 <> () ;
int vl_2 = 1 ;
for ( final vr_30 < Integer , String > vr_42
: vr_40 . vr_32 () ) {
final String vr_43 = fn_2 ( vr_42 . vr_33 () ) ;
vr_17 . vr_29 ( vr_42 . vr_34 () , vr_43 ) ;
if ( vr_42 . vr_34 () . length () > vl_2 ) {
vl_2 = vr_42 . vr_34 () . length () ;
}
}
return new vl_4 ( vr_40 ,
vr_17 ,
vl_2 ) ;
}
public static vl_4 fn_9 (
final vr_8 [] vr_1 ,
final vr_8 [] vr_23 ,
final vr_8 [] vr_44 ) {
return vl_4 . vr_45 (
fn_10 ( vr_1 ) ,
fn_10 ( vr_23 ) ,
fn_10 ( vr_44 ) ) ;
}
private static Integer [] fn_10 ( final vr_8 [] vr_46 ) {
if ( vr_46 == null || vr_46 . length == 0 ) {
return new Integer [ 0 ] ;
}
final Integer [] vr_47 = new Integer [ vr_46 . length ] ;
for ( int vr_3 = 0 ; vr_3 < vr_46 . length ; vr_3 ++ ) {
vr_47 [ vr_3 ] = ( int ) vr_46 [ vr_3 ] ;
}
return vr_47 ;
}
public static vl_4 vr_45 (
final Integer [] vr_1 ,
final Integer [] vr_23 ,
final Integer [] vr_44 ) {
final vr_48 < Integer > vr_49 = new vr_50 <> ( vr_51 . <Integer > fn_11 ( vr_1 ) ) ;
final vr_48 < Integer > vr_52 = new vr_50 <> ( vr_51 . <Integer > fn_11 ( vr_23 ) ) ;
final vr_48 < Integer > vr_53 = new vr_50 <> ( vr_51 . <Integer > fn_11 ( vr_44 ) ) ;
final vr_18 < Integer , String > vr_7 = new vr_41 <> () ;
final vr_18 < String , String > vr_17 = new vr_41 <> () ;
final vr_18 < Integer , String > vr_25 = new vr_54 <> () ;
int vl_2 ;
for ( final int vr_3 : vr_53 ) {
if ( ! vr_49 . contains ( vr_3 ) ) {
throw new IllegalArgumentException (
lr_8
+ lr_9
+ fn_2 ( vr_3 ) + lr_10 ) ;
}
if ( ! vr_52 . contains ( vr_3 ) ) {
throw new IllegalArgumentException (
lr_11
+ fn_2 ( vr_3 ) + lr_10 ) ;
}
vr_25 . vr_29 ( vr_3 , fn_2 ( vr_3 ) ) ;
}
if ( vr_52 . size () >= vr_49 . size () ) {
vl_2 = 1 ;
final Iterator < Integer > vr_55 = vr_52 . iterator () ;
for ( final int vr_56 : vr_49 ) {
final String vr_28 =
fn_2 ( vr_56 ) ;
if ( vr_25 . vr_27 ( vr_56 ) ) {
vr_7 . vr_29 ( vr_56 ,
vr_28 ) ;
vr_17 . vr_29 ( vr_28 ,
vr_28 ) ;
} else {
Integer vr_16 = vr_55 . vr_16 () ;
while ( vr_53 . contains ( vr_16 ) ) {
vr_16 = vr_55 . vr_16 () ;
}
final String vr_57 = fn_2 ( vr_16 ) ;
vr_7 . vr_29 ( vr_56 , vr_57 ) ;
vr_17 . vr_29 ( vr_57 ,
vr_28 ) ;
}
}
return new vl_4 ( vr_7 ,
vr_17 ,
vl_2 ) ;
} else if ( vr_52 . size () - vr_53 . size () < 2 ) {
throw new IllegalArgumentException (
lr_12
+ lr_13
+ ( vr_52 . size () - vr_53 . size () ) ) ;
} else {
int vr_58 = 1 ;
int vr_59 = ( vr_49 . size () - vr_53 . size () )
/ ( vr_52 . size () - vr_53 . size () ) ;
while ( vr_59 / vr_52 . size () >= 1 ) {
vr_59 = vr_59 / vr_52 . size () ;
vr_58 ++ ;
}
vl_2 = vr_58 + 1 ;
final vl_4 vr_60 =
new vl_4 ( vr_7 ,
vr_17 ,
vl_2 ) ;
vr_60 . fn_6 ( vl_2 ,
lr_14 ,
vr_52 ,
vr_49 . iterator () ,
vr_25 ) ;
return vr_60 ;
}
}
private static String fn_2 ( final int vr_3 ) {
if ( vr_8 . vr_9 ( vr_3 ) == 1 ) {
return String . valueOf ( ( char ) vr_3 ) ;
}
return new String ( vr_8 . vr_61 ( vr_3 ) ) ;
}
