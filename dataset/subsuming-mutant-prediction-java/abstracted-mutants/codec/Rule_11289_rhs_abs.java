@Override
public int fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
for ( int vr_3 = 0 ; vr_3 < vr_1 . vr_4 . length () ; vr_3 ++ ) {
if ( vr_3 >= vr_2 . vr_4 . length () ) {
return + 1 ;
}
final int vr_5 = vr_1 . vr_4 . charAt ( vr_3 ) - vr_2 . vr_4 . charAt ( vr_3 ) ;
if ( vr_5 != 0 ) {
return vr_5 ;
}
}
if ( vr_1 . vr_4 . length () < vr_2 . vr_4 . length () ) {
return - 1 ;
}
return 0 ;
}
public tp_1 append ( final tp_2 vr_6 ) {
this . vr_4 . append ( vr_6 ) ;
return this ;
}
public vr_7 . vr_8 fn_2 () {
return this . vr_9 ;
}
@Override
public vr_10 < tp_1 > fn_3 () {
return vr_11 . vr_12 ( this ) ;
}
public tp_2 fn_4 () {
return this . vr_4 ;
}
@Deprecated
public tp_1 fn_5 ( final tp_1 vr_13 ) {
return new tp_1 ( this . vr_4 . toString () + vr_13 . vr_4 . toString () ,
this . vr_9 . vr_14 ( vr_13 . vr_9 ) ) ;
}
public tp_1 fn_6 ( final vr_8 vr_15 ) {
return new tp_1 ( this . vr_4 . toString () , this . vr_9 . vr_16 ( vr_15 ) ) ;
}
@Override
public String toString () {
return vr_4 . toString () + lr_1 + vr_9 + lr_2 ;
}
@Override
public List < tp_1 > fn_3 () {
return this . vr_17 ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return true ;
}
private static boolean contains ( final tp_2 vr_19 , final char vr_18 ) {
for ( int vr_3 = 0 ; vr_3 < vr_19 . length () ; vr_3 ++ ) {
if ( vr_19 . charAt ( vr_3 ) == vr_18 ) {
return true ;
}
}
return false ;
}
private static String fn_8 ( final tp_3 vr_20 , final tp_4 vr_21 , final String vr_15 ) {
return String . vr_22 ( lr_3 ,
vr_20 . vr_23 () , vr_21 . vr_23 () , vr_15 ) ;
}
private static tp_5 fn_9 ( final tp_3 vr_20 , final tp_4 vr_21 , final String vr_15 ) {
final String vr_24 = fn_8 ( vr_20 , vr_21 , vr_15 ) ;
return new tp_5 ( vr_25 . vr_26 ( vr_24 ) , vr_27 . vr_28 ) ;
}
private static tp_5 fn_9 ( final String vr_15 ) {
final String vr_24 = String . vr_22 ( lr_4 , vr_15 ) ;
return new tp_5 ( vr_25 . vr_26 ( vr_24 ) , vr_27 . vr_28 ) ;
}
private static boolean fn_10 ( final tp_2 vr_18 , final tp_2 vr_29 ) {
if ( vr_29 . length () > vr_18 . length () ) {
return false ;
}
for ( int vr_3 = vr_18 . length () - 1 , vr_30 = vr_29 . length () - 1 ; vr_30 >= 0 ; vr_3 -- , vr_30 -- ) {
if ( vr_18 . charAt ( vr_3 ) != vr_29 . charAt ( vr_30 ) ) {
return false ;
}
}
return true ;
}
public static List < vt_1 > fn_11 ( final tp_3 vr_20 , final tp_4 vr_21 ,
final vr_7 . vr_8 vr_31 ) {
final vr_32 < String , List < vt_1 > > vr_33 = fn_12 ( vr_20 , vr_21 , vr_31 ) ;
final List < vt_1 > vr_34 = new ArrayList <> () ;
for ( final List < vt_1 > vr_35 : vr_33 . vr_36 () ) {
vr_34 . vr_37 ( vr_35 ) ;
}
return vr_34 ;
}
public static List < vt_1 > fn_11 ( final tp_3 vr_20 , final tp_4 vr_21 , final String vr_15 ) {
return fn_11 ( vr_20 , vr_21 , vr_8 . vr_38 ( new vr_39 <> ( vr_40 . vr_41 ( vr_15 ) ) ) ) ;
}
public static vr_32 < String , List < vt_1 > > fn_12 ( final tp_3 vr_20 , final tp_4 vr_21 ,
final vr_7 . vr_8 vr_31 ) {
return vr_31 . vr_42 () ? fn_12 ( vr_20 , vr_21 , vr_31 . vr_43 () ) :
fn_12 ( vr_20 , vr_21 , vr_7 . vr_44 ) ;
}
public static vr_32 < String , List < vt_1 > > fn_12 ( final tp_3 vr_20 , final tp_4 vr_21 ,
final String vr_15 ) {
final vr_32 < String , List < vt_1 > > vr_35 = vr_45 . get ( vr_20 ) . get ( vr_21 ) . get ( vr_15 ) ;
if ( vr_35 == null ) {
throw new IllegalArgumentException ( String . vr_22 ( lr_5 ,
vr_20 . vr_23 () , vr_21 . vr_23 () , vr_15 ) ) ;
}
return vr_35 ;
}
private static tp_1 fn_13 ( final String vr_46 ) {
final int vr_47 = vr_46 . indexOf ( lr_1 ) ;
if ( vr_47 >= 0 ) {
if ( ! vr_46 . fn_10 ( lr_2 ) ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
final String vr_48 = vr_46 . vr_49 ( 0 , vr_47 ) ;
final String vr_50 = vr_46 . vr_49 ( vr_47 + 1 , vr_46 . length () - 1 ) ;
final vr_51 < String > vr_31 = new vr_39 <> ( vr_40 . vr_41 ( vr_50 . vr_52 ( lr_7 ) ) ) ;
return new tp_1 ( vr_48 , vr_7 . vr_8 . vr_38 ( vr_31 ) ) ;
}
return new tp_1 ( vr_46 , vr_7 . vr_53 ) ;
}
private static tp_6 fn_14 ( final String vr_46 ) {
if ( vr_46 . vr_54 ( lr_8 ) ) { MST[rv.ROR1Mutator]MSP[N]
if ( ! vr_46 . fn_10 ( lr_9 ) ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
final List < tp_1 > vr_55 = new ArrayList <> () ;
final String vr_56 = vr_46 . vr_49 ( 1 , vr_46 . length () - 1 ) ;
for ( final String vr_57 : vr_56 . vr_52 ( lr_11 ) ) {
vr_55 . add ( fn_13 ( vr_57 ) ) ;
}
if ( vr_56 . vr_54 ( lr_12 ) || vr_56 . fn_10 ( lr_12 ) ) {
vr_55 . add ( new tp_1 ( lr_13 , vr_7 . vr_53 ) ) ;
}
return new fn_15 ( vr_55 ) ;
}
return fn_13 ( vr_46 ) ;
}
@Override
public String toString () {
final StringBuilder vr_58 = new StringBuilder () ;
vr_58 . append ( lr_14 ) ;
vr_58 . append ( lr_15 ) . append ( vl_1 ) ;
vr_58 . append ( lr_16 ) . append ( vl_2 ) . append ( '\'' ) ;
vr_58 . append ( lr_17 ) . append ( vl_3 ) . append ( '\'' ) ;
vr_58 . append ( lr_18 ) . append ( vl_4 ) . append ( '\'' ) ;
vr_58 . append ( lr_19 ) . append ( vl_5 ) . append ( '\'' ) ;
vr_58 . append ( '}' ) ;
return vr_58 . toString () ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return vr_18 . length () == 0 ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return vr_18 . equals ( vl_6 ) ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return vr_54 ( vr_18 , vl_6 ) ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return fn_10 ( vr_18 , vl_6 ) ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return vr_18 . length () == 1 && contains ( vl_7 , vr_18 . charAt ( 0 ) ) == vl_8 ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return vr_18 . length () > 0 && contains ( vl_7 , vr_18 . charAt ( 0 ) ) == vl_8 ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
return vr_18 . length () > 0 &&
contains ( vl_7 , vr_18 . charAt ( vr_18 . length () - 1 ) ) == vl_8 ;
}
@Override
public boolean fn_7 ( final tp_2 vr_18 ) {
final tp_7 vr_59 = vr_60 . vr_59 ( vr_18 ) ;
return vr_59 . vr_61 () ;
}
private static boolean vr_54 ( final tp_2 vr_18 , final tp_2 vr_62 ) {
if ( vr_62 . length () > vr_18 . length () ) {
return false ;
}
for ( int vr_3 = 0 ; vr_3 < vr_62 . length () ; vr_3 ++ ) {
if ( vr_18 . charAt ( vr_3 ) != vr_62 . charAt ( vr_3 ) ) {
return false ;
}
}
return true ;
}
private static String fn_16 ( String vr_6 ) {
if ( vr_6 . vr_54 ( vl_9 ) ) {
vr_6 = vr_6 . vr_49 ( 1 ) ;
}
if ( vr_6 . fn_10 ( vl_9 ) ) {
vr_6 = vr_6 . vr_49 ( 0 , vr_6 . length () - 1 ) ;
}
return vr_6 ;
}
public tp_8 fn_17 () {
return this . vr_63 ;
}
public String fn_18 () {
return this . vr_60 ;
}
public tp_6 fn_19 () {
return this . vr_64 ;
}
public tp_8 fn_20 () {
return this . vr_65 ;
}
public boolean fn_21 ( final tp_2 vr_18 , final int vr_3 ) {
if ( vr_3 < 0 ) {
throw new fn_22 ( lr_20 ) ;
}
final int vr_66 = this . vr_60 . length () ;
final int vr_67 = vr_3 + vr_66 ;
if ( vr_67 > vr_18 . length () ) {
return false ;
}
if ( ! vr_18 . vr_68 ( vr_3 , vr_67 ) . equals ( this . vr_60 ) ) {
return false ;
} else if ( ! this . vr_65 . fn_7 ( vr_18 . vr_68 ( vr_67 , vr_18 . length () ) ) ) {
return false ;
}
return this . vr_63 . fn_7 ( vr_18 . vr_68 ( 0 , vr_3 ) ) ;
}
