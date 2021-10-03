protected List < vt_1 > fn_1 () {
if ( vl_1 == vl_2 ) {
vl_1 = new fn_2 ( this , 4 ) ;
}
return vl_1 ;
}
@Override
protected boolean fn_3 () {
return vl_3 != null ;
}
@Override
public tp_1 vl_3 () {
if ( ! fn_3 () )
vl_3 = new tp_1 () ;
return vl_3 ;
}
@Override
public String fn_4 () {
return fn_5 ( this , vl_4 ) ;
}
private static String fn_5 ( final tp_2 vr_1 , final String vr_2 ) {
tp_2 vr_3 = vr_1 ;
while ( vr_3 != null ) {
if ( vr_3 . fn_3 () && vr_3 . vl_3 . vr_4 ( vr_2 ) )
return vr_3 . vl_3 . get ( vr_2 ) ;
vr_3 = vr_3 . vr_5 () ;
}
return lr_1 ;
}
@Override
protected void fn_6 ( String fn_4 ) {
vl_3 () . fn_7 ( vl_4 , fn_4 ) ;
}
@Override
public int fn_8 () {
return vl_1 . size () ;
}
@Override
public String fn_9 () {
return vr_6 . vr_7 () ;
}
public String fn_10 () {
return vr_6 . vr_7 () ;
}
public String fn_11 () {
return vr_6 . fn_11 () ;
}
public tp_2 fn_10 ( String fn_10 ) {
vr_8 . vr_9 ( fn_10 , lr_2 ) ;
vr_6 = vr_10 . valueOf ( fn_10 , vr_11 . vr_12 ( this ) . fn_12 () ) ;
return this ;
}
public vr_10 vr_6 () {
return vr_6 ;
}
public boolean fn_13 () {
return vr_6 . fn_13 () ;
}
public String fn_14 () {
return fn_3 () ? vl_3 . vr_13 ( lr_3 ) : lr_1 ;
}
public tp_2 fn_15 ( String vr_14 , String vr_15 ) {
super . fn_15 ( vr_14 , vr_15 ) ;
return this ;
}
public tp_2 fn_15 ( String vr_14 , boolean vr_15 ) {
vl_3 () . fn_7 ( vr_14 , vr_15 ) ;
return this ;
}
public vr_16 < String , String > fn_16 () {
return vl_3 () . fn_16 () ;
}
@Override
public final tp_2 vr_5 () {
return ( tp_2 ) vl_5 ;
}
public tp_3 fn_17 () {
tp_3 fn_17 = new tp_3 () ;
fn_18 ( this , fn_17 ) ;
return fn_17 ;
}
private static void fn_18 ( tp_2 vr_3 , tp_3 fn_17 ) {
tp_2 vr_5 = vr_3 . vr_5 () ;
if ( vr_5 != null && ! vr_5 . fn_10 () . equals ( lr_4 ) ) {
fn_17 . add ( vr_5 ) ;
fn_18 ( vr_5 , fn_17 ) ;
}
}
public tp_2 fn_19 ( int vr_17 ) {
return fn_20 () . get ( vr_17 ) ;
}
public int fn_21 () {
return fn_20 () . size () ;
}
public tp_3 fn_22 () {
return new tp_3 ( fn_20 () ) ;
}
private List < tp_2 > fn_20 () {
List < tp_2 > fn_22 ;
if ( vl_6 == null || ( fn_22 = vl_6 . get () ) == null ) {
final int size = vl_1 . size () ;
fn_22 = new ArrayList <> ( size ) ;
for ( int vr_18 = 0 ; vr_18 < size ; vr_18 ++ ) {
final vt_1 vr_19 = vl_1 . get ( vr_18 ) ;
if ( vr_19 instanceof tp_2 )
fn_22 . add ( ( tp_2 ) vr_19 ) ;
}
vl_6 = new vr_20 <> ( fn_22 ) ;
}
return fn_22 ;
}
@Override
void fn_23 () {
super . fn_23 () ;
vl_6 = null ;
}
public List < vt_2 > fn_24 () {
List < vt_2 > fn_24 = new ArrayList <> () ;
for ( vt_1 vr_19 : vl_1 ) {
if ( vr_19 instanceof vt_2 )
fn_24 . add ( ( vt_2 ) vr_19 ) ;
}
return vr_21 . vr_22 ( fn_24 ) ;
}
public List < vt_3 > fn_25 () {
List < vt_3 > fn_25 = new ArrayList <> () ;
for ( vt_1 vr_19 : vl_1 ) {
if ( vr_19 instanceof vt_3 )
fn_25 . add ( ( vt_3 ) vr_19 ) ;
}
return vr_21 . vr_22 ( fn_25 ) ;
}
public tp_3 fn_26 ( String vr_23 ) {
return vr_24 . fn_26 ( vr_23 , this ) ;
}
public tp_2 fn_27 ( String vr_23 ) {
return vr_24 . fn_27 ( vr_23 , this ) ;
}
public boolean fn_28 ( String vr_23 ) {
return fn_28 ( vr_25 . vr_26 ( vr_23 ) ) ;
}
public boolean fn_28 ( tp_4 vr_27 ) {
return vr_27 . vr_28 ( ( tp_2 ) this . vr_29 () , this ) ;
}
public tp_2 fn_29 ( vt_1 fn_19 ) {
vr_8 . vr_30 ( fn_19 ) ;
fn_30 ( fn_19 ) ;
fn_1 () ;
vl_1 . add ( fn_19 ) ;
fn_19 . vr_31 ( vl_1 . size () - 1 ) ;
return this ;
}
public tp_2 fn_31 ( tp_2 vr_5 ) {
vr_8 . vr_30 ( vr_5 ) ;
vr_5 . fn_29 ( this ) ;
return this ;
}
public tp_2 fn_32 ( vt_1 fn_19 ) {
vr_8 . vr_30 ( fn_19 ) ;
fn_33 ( 0 , fn_19 ) ;
return this ;
}
public tp_2 fn_34 ( int vr_17 , Collection < ? extends vt_1 > fn_22 ) {
vr_8 . vr_30 ( fn_22 , lr_5 ) ;
int vr_32 = fn_8 () ;
if ( vr_17 < 0 ) vr_17 += vr_32 + 1 ;
vr_8 . vr_33 ( vr_17 >= 0 && vr_17 <= vr_32 , lr_6 ) ;
ArrayList < vt_1 > vr_34 = new ArrayList <> ( fn_22 ) ;
vt_1 [] vr_35 = vr_34 . toArray ( new vt_1 [ 0 ] ) ;
fn_33 ( vr_17 , vr_35 ) ;
return this ;
}
public tp_2 fn_34 ( int vr_17 , vt_1 ... fn_22 ) {
vr_8 . vr_30 ( fn_22 , lr_5 ) ;
int vr_32 = fn_8 () ;
if ( vr_17 < 0 ) vr_17 += vr_32 + 1 ;
vr_8 . vr_33 ( vr_17 >= 0 && vr_17 <= vr_32 , lr_6 ) ;
fn_33 ( vr_17 , fn_22 ) ;
return this ;
}
public tp_2 fn_35 ( String fn_10 ) {
tp_2 fn_19 = new tp_2 ( vr_10 . valueOf ( fn_10 , vr_11 . vr_12 ( this ) . fn_12 () ) , fn_4 () ) ;
fn_29 ( fn_19 ) ;
return fn_19 ;
}
public tp_2 fn_36 ( String fn_10 ) {
tp_2 fn_19 = new tp_2 ( vr_10 . valueOf ( fn_10 , vr_11 . vr_12 ( this ) . fn_12 () ) , fn_4 () ) ;
fn_32 ( fn_19 ) ;
return fn_19 ;
}
public tp_2 fn_37 ( String vr_36 ) {
vr_8 . vr_30 ( vr_36 ) ;
vt_2 vr_19 = new vt_2 ( vr_36 ) ;
fn_29 ( vr_19 ) ;
return this ;
}
public tp_2 fn_38 ( String vr_36 ) {
vr_8 . vr_30 ( vr_36 ) ;
vt_2 vr_19 = new vt_2 ( vr_36 ) ;
fn_32 ( vr_19 ) ;
return this ;
}
public tp_2 append ( String vr_37 ) {
vr_8 . vr_30 ( vr_37 ) ;
List < vt_1 > vr_34 = vr_11 . vr_12 ( this ) . fn_39 ( vr_37 , this , fn_4 () ) ;
fn_33 ( vr_34 . toArray ( new vt_1 [ 0 ] ) ) ;
return this ;
}
public tp_2 fn_40 ( String vr_37 ) {
vr_8 . vr_30 ( vr_37 ) ;
List < vt_1 > vr_34 = vr_11 . vr_12 ( this ) . fn_39 ( vr_37 , this , fn_4 () ) ;
fn_33 ( 0 , vr_34 . toArray ( new vt_1 [ 0 ] ) ) ;
return this ;
}
@Override
public tp_2 fn_41 ( String vr_37 ) {
return ( tp_2 ) super . fn_41 ( vr_37 ) ;
}
@Override
public tp_2 fn_41 ( vt_1 vr_19 ) {
return ( tp_2 ) super . fn_41 ( vr_19 ) ;
}
@Override
public tp_2 fn_42 ( String vr_37 ) {
return ( tp_2 ) super . fn_42 ( vr_37 ) ;
}
@Override
public tp_2 fn_42 ( vt_1 vr_19 ) {
return ( tp_2 ) super . fn_42 ( vr_19 ) ;
}
@Override
public tp_2 fn_43 () {
vl_1 . clear () ;
return this ;
}
@Override
public tp_2 fn_44 ( String vr_37 ) {
return ( tp_2 ) super . fn_44 ( vr_37 ) ;
}
public String fn_45 () {
if ( fn_14 () . length () > 0 )
return lr_7 + fn_14 () ;
String fn_10 = fn_10 () . fn_46 ( ':' , '|' ) ;
StringBuilder vr_38 = new StringBuilder ( fn_10 ) ;
String vr_39 = vr_40 . vr_41 ( fn_47 () , lr_8 ) ;
if ( vr_39 . length () > 0 )
vr_38 . append ( '.' ) . append ( vr_39 ) ;
if ( vr_5 () == null || vr_5 () instanceof vl_7 )
return vr_38 . toString () ;
vr_38 . vr_42 ( 0 , lr_9 ) ;
if ( vr_5 () . fn_26 ( vr_38 . toString () ) . size () > 1 )
vr_38 . append ( String . vr_43 (
lr_10 , fn_48 () + 1 ) ) ;
return vr_5 () . fn_45 () + vr_38 . toString () ;
}
public tp_3 fn_49 () {
if ( vl_5 == null )
return new tp_3 ( 0 ) ;
List < tp_2 > vr_44 = vr_5 () . fn_20 () ;
tp_3 vr_45 = new tp_3 ( vr_44 . size () - 1 ) ;
for ( tp_2 vr_3 : vr_44 )
if ( vr_3 != this )
vr_45 . add ( vr_3 ) ;
return vr_45 ;
}
public tp_2 fn_50 () {
if ( vl_5 == null ) return null ;
List < tp_2 > vr_45 = vr_5 () . fn_20 () ;
int vr_17 = fn_51 ( this , vr_45 ) ;
if ( vr_45 . size () > vr_17 + 1 )
return vr_45 . get ( vr_17 + 1 ) ;
else
return null ;
}
public tp_3 fn_52 () {
return fn_52 ( true ) ;
}
public tp_2 fn_53 () {
if ( vl_5 == null ) return null ;
List < tp_2 > vr_45 = vr_5 () . fn_20 () ;
int vr_17 = fn_51 ( this , vr_45 ) ;
if ( vr_17 > 0 )
return vr_45 . get ( vr_17 - 1 ) ;
else
return null ;
}
public tp_3 fn_54 () {
return fn_52 ( false ) ;
}
private tp_3 fn_52 ( boolean vr_46 ) {
tp_3 vr_47 = new tp_3 () ;
if ( vl_5 == null )
return vr_47 ;
vr_47 . add ( this ) ;
return vr_46 ? vr_47 . vr_48 () : vr_47 . vr_49 () ;
}
public tp_2 fn_55 () {
List < tp_2 > vr_45 = vr_5 () . fn_20 () ;
return vr_45 . size () > 1 ? vr_45 . get ( 0 ) : null ;
}
public int fn_48 () {
if ( vr_5 () == null ) return 0 ;
return fn_51 ( this , vr_5 () . fn_20 () ) ;
}
public tp_2 fn_56 () {
List < tp_2 > vr_45 = vr_5 () . fn_20 () ;
return vr_45 . size () > 1 ? vr_45 . get ( vr_45 . size () - 1 ) : null ;
}
private static < vt_4 extends tp_2 > int fn_51 ( tp_2 vr_50 , List < vt_4 > vr_44 ) {
final int size = vr_44 . size () ;
for ( int vr_18 = 0 ; vr_18 < size ; vr_18 ++ ) {
if ( vr_44 . get ( vr_18 ) == vr_50 )
return vr_18 ;
}
return 0 ;
}
public tp_3 fn_57 ( String fn_10 ) {
vr_8 . vr_9 ( fn_10 ) ;
fn_10 = fn_58 ( fn_10 ) ;
return vr_51 . vr_52 ( new tp_4 . vr_10 ( fn_10 ) , this ) ;
}
public tp_2 fn_59 ( String fn_14 ) {
vr_8 . vr_9 ( fn_14 ) ;
tp_3 vr_44 = vr_51 . vr_52 ( new tp_4 . vr_53 ( fn_14 ) , this ) ;
if ( vr_44 . size () > 0 )
return vr_44 . get ( 0 ) ;
else
return null ;
}
public tp_3 fn_60 ( String vr_54 ) {
vr_8 . vr_9 ( vr_54 ) ;
return vr_51 . vr_52 ( new tp_4 . Class ( vr_54 ) , this ) ;
}
public tp_3 fn_61 ( String vr_2 ) {
vr_8 . vr_9 ( vr_2 ) ;
vr_2 = vr_2 . trim () ;
return vr_51 . vr_52 ( new tp_4 . vr_55 ( vr_2 ) , this ) ;
}
public tp_3 fn_62 ( String vr_56 ) {
vr_8 . vr_9 ( vr_56 ) ;
vr_56 = vr_56 . trim () ;
return vr_51 . vr_52 ( new tp_4 . vr_57 ( vr_56 ) , this ) ;
}
public tp_3 fn_63 ( String vr_2 , String vr_58 ) {
return vr_51 . vr_52 ( new tp_4 . vr_59 ( vr_2 , vr_58 ) , this ) ;
}
public tp_3 fn_64 ( String vr_2 , String vr_58 ) {
return vr_51 . vr_52 ( new tp_4 . vr_60 ( vr_2 , vr_58 ) , this ) ;
}
public tp_3 fn_65 ( String vr_2 , String vr_61 ) {
return vr_51 . vr_52 ( new tp_4 . vr_62 ( vr_2 , vr_61 ) , this ) ;
}
public tp_3 fn_66 ( String vr_2 , String vr_63 ) {
return vr_51 . vr_52 ( new tp_4 . vr_64 ( vr_2 , vr_63 ) , this ) ;
}
public tp_3 fn_67 ( String vr_2 , String vr_65 ) {
return vr_51 . vr_52 ( new tp_4 . vr_66 ( vr_2 , vr_65 ) , this ) ;
}
public tp_3 fn_68 ( String vr_2 , tp_5 vr_67 ) {
return vr_51 . vr_52 ( new tp_4 . vr_68 ( vr_2 , vr_67 ) , this ) ;
}
public tp_3 fn_68 ( String vr_2 , String vr_69 ) {
tp_5 vr_67 ;
try {
vr_67 = tp_5 . vr_70 ( vr_69 ) ;
} catch ( tp_6 vr_71 ) {
throw new IllegalArgumentException ( lr_11 + vr_69 , vr_71 ) ;
}
return fn_68 ( vr_2 , vr_67 ) ;
}
public tp_3 fn_69 ( int vr_17 ) {
return vr_51 . vr_52 ( new tp_4 . vr_72 ( vr_17 ) , this ) ;
}
public tp_3 fn_70 ( int vr_17 ) {
return vr_51 . vr_52 ( new tp_4 . vr_73 ( vr_17 ) , this ) ;
}
public tp_3 fn_71 ( int vr_17 ) {
return vr_51 . vr_52 ( new tp_4 . vr_74 ( vr_17 ) , this ) ;
}
public tp_3 fn_72 ( String vr_75 ) {
return vr_51 . vr_52 ( new tp_4 . vr_76 ( vr_75 ) , this ) ;
}
public tp_3 fn_73 ( String vr_75 ) {
return vr_51 . vr_52 ( new tp_4 . vr_77 ( vr_75 ) , this ) ;
}
public tp_3 fn_74 ( tp_5 vr_67 ) {
return vr_51 . vr_52 ( new tp_4 . vr_78 ( vr_67 ) , this ) ;
}
public tp_3 fn_74 ( String vr_69 ) {
tp_5 vr_67 ;
try {
vr_67 = tp_5 . vr_70 ( vr_69 ) ;
} catch ( tp_6 vr_71 ) {
throw new IllegalArgumentException ( lr_11 + vr_69 , vr_71 ) ;
}
return fn_74 ( vr_67 ) ;
}
public tp_3 fn_75 ( tp_5 vr_67 ) {
return vr_51 . vr_52 ( new tp_4 . vr_79 ( vr_67 ) , this ) ;
}
public tp_3 fn_75 ( String vr_69 ) {
tp_5 vr_67 ;
try {
vr_67 = tp_5 . vr_70 ( vr_69 ) ;
} catch ( tp_6 vr_71 ) {
throw new IllegalArgumentException ( lr_11 + vr_69 , vr_71 ) ;
}
return fn_75 ( vr_67 ) ;
}
public tp_3 fn_76 () {
return vr_51 . vr_52 ( new tp_4 . vr_80 () , this ) ;
}
public void fn_77 ( vt_1 vr_19 , int vr_81 ) {
if ( vr_19 instanceof vt_2 ) {
vt_2 vr_82 = ( vt_2 ) vr_19 ;
fn_78 ( vl_8 , vr_82 ) ;
} else if ( vr_19 instanceof tp_2 ) {
tp_2 vr_83 = ( tp_2 ) vr_19 ;
if ( vl_8 . length () > 0 &&
( vr_83 . fn_13 () || vr_83 . vr_6 . vr_7 () . equals ( lr_12 ) ) &&
! vt_2 . vr_84 ( vl_8 ) )
vl_8 . append ( ' ' ) ;
}
}
public void fn_79 ( vt_1 vr_19 , int vr_81 ) {
if ( vr_19 instanceof tp_2 ) {
tp_2 vr_83 = ( tp_2 ) vr_19 ;
if ( vr_83 . fn_13 () && ( vr_19 . vr_85 () instanceof vt_2 ) && ! vt_2 . vr_84 ( vl_8 ) )
vl_8 . append ( ' ' ) ;
}
}
public void fn_77 ( vt_1 vr_19 , int vr_81 ) {
if ( vr_19 instanceof vt_2 ) {
vt_2 vr_82 = ( vt_2 ) vr_19 ;
vl_8 . append ( vr_82 . vr_86 () ) ;
}
}
public void fn_79 ( vt_1 vr_19 , int vr_81 ) {
}
public String fn_80 () {
StringBuilder vr_87 = vr_40 . vr_88 () ;
fn_80 ( vr_87 ) ;
return vr_40 . vr_89 ( vr_87 ) . trim () ;
}
private void fn_80 ( StringBuilder vl_8 ) {
for ( vt_1 fn_19 : vl_1 ) {
if ( fn_19 instanceof vt_2 ) {
vt_2 vr_82 = ( vt_2 ) fn_19 ;
fn_78 ( vl_8 , vr_82 ) ;
} else if ( fn_19 instanceof tp_2 ) {
fn_81 ( ( tp_2 ) fn_19 , vl_8 ) ;
}
}
}
private static void fn_78 ( StringBuilder vl_8 , vt_2 vr_82 ) {
String vr_36 = vr_82 . vr_86 () ;
if ( fn_82 ( vr_82 . vl_5 ) || vr_82 instanceof vl_9 )
vl_8 . append ( vr_36 ) ;
else
vr_40 . vr_90 ( vl_8 , vr_36 , vt_2 . vr_84 ( vl_8 ) ) ;
}
private static void fn_81 ( tp_2 vr_83 , StringBuilder vl_8 ) {
if ( vr_83 . vr_6 . vr_7 () . equals ( lr_12 ) && ! vt_2 . vr_84 ( vl_8 ) )
vl_8 . append ( lr_13 ) ;
}
static boolean fn_82 ( vt_1 vr_19 ) {
if ( vr_19 instanceof tp_2 ) {
tp_2 vr_3 = ( tp_2 ) vr_19 ;
int vr_18 = 0 ;
do {
if ( vr_3 . vr_6 . fn_82 () )
return true ;
vr_3 = vr_3 . vr_5 () ;
vr_18 ++ ;
} while ( vr_18 < 6 && vr_3 != null );
}
return false ;
}
public tp_2 vr_36 ( String vr_36 ) {
vr_8 . vr_30 ( vr_36 ) ;
fn_43 () ;
vt_2 vr_82 = new vt_2 ( vr_36 ) ;
fn_29 ( vr_82 ) ;
return this ;
}
public boolean fn_83 () {
for ( vt_1 fn_19 : vl_1 ) {
if ( fn_19 instanceof vt_2 ) {
vt_2 vr_82 = ( vt_2 ) fn_19 ;
if ( ! vr_82 . vr_91 () )
return true ;
} else if ( fn_19 instanceof tp_2 ) {
tp_2 vr_3 = ( tp_2 ) fn_19 ;
if ( vr_3 . fn_83 () )
return true ;
}
}
return false ;
}
public String fn_84 () {
StringBuilder vr_87 = vr_40 . vr_88 () ;
for ( vt_1 vr_92 : vl_1 ) {
if ( vr_92 instanceof vt_3 ) {
vt_3 fn_84 = ( vt_3 ) vr_92 ;
vr_87 . append ( fn_84 . vr_93 () ) ;
} else if ( vr_92 instanceof vl_10 ) {
vl_10 vr_94 = ( vl_10 ) vr_92 ;
vr_87 . append ( vr_94 . vr_95 () ) ;
} else if ( vr_92 instanceof tp_2 ) {
tp_2 vr_83 = ( tp_2 ) vr_92 ;
String vr_96 = vr_83 . fn_84 () ;
vr_87 . append ( vr_96 ) ;
} else if ( vr_92 instanceof vl_9 ) {
vl_9 vr_97 = ( vl_9 ) vr_92 ;
vr_87 . append ( vr_97 . vr_86 () ) ;
}
}
return vr_40 . vr_89 ( vr_87 ) ;
}
public String vr_54 () {
return fn_15 ( lr_14 ) . trim () ;
}
public vr_98 < String > fn_47 () {
String [] vr_99 = vr_100 . vr_101 ( vr_54 () ) ;
vr_98 < String > fn_47 = new vr_102 <> ( vr_103 . vr_104 ( vr_99 ) ) ;
fn_47 . remove ( lr_1 ) ;
return fn_47 ;
}
public tp_2 fn_47 ( vr_98 < String > fn_47 ) {
vr_8 . vr_30 ( fn_47 ) ;
if ( fn_47 . isEmpty () ) {
vl_3 () . remove ( lr_14 ) ;
} else {
vl_3 () . fn_7 ( lr_14 , vr_40 . vr_41 ( fn_47 , lr_13 ) ) ;
}
return this ;
}
public boolean fn_85 ( String vr_54 ) {
if ( ! fn_3 () )
return false ;
final String vr_105 = vl_3 . vr_13 ( lr_14 ) ;
final int vr_106 = vr_105 . length () ;
final int vr_107 = vr_54 . length () ;
if ( vr_106 == 0 || vr_106 < vr_107 ) {
return false ;
}
if ( vr_106 == vr_107 ) {
return vr_54 . equalsIgnoreCase ( vr_105 ) ;
}
boolean vr_108 = false ;
int vr_1 = 0 ;
for ( int vr_18 = 0 ; vr_18 < vr_106 ; vr_18 ++ ) {
if ( vr_109 . vr_110 ( vr_105 . charAt ( vr_18 ) ) ) {
if ( vr_108 ) {
if ( vr_18 - vr_1 == vr_107 && vr_105 . vr_111 ( true , vr_1 , vr_54 , 0 , vr_107 ) ) {
return true ;
}
vr_108 = false ;
}
} else {
if ( ! vr_108 ) {
vr_108 = true ;
vr_1 = vr_18 ;
}
}
}
if ( vr_108 && vr_106 - vr_1 == vr_107 ) {
return vr_105 . vr_111 ( true , vr_1 , vr_54 , 0 , vr_107 ) ;
}
return false ;
}
public tp_2 fn_86 ( String vr_54 ) {
vr_8 . vr_30 ( vr_54 ) ;
vr_98 < String > vr_39 = fn_47 () ;
vr_39 . add ( vr_54 ) ;
fn_47 ( vr_39 ) ;
return this ;
}
public tp_2 fn_87 ( String vr_54 ) {
vr_8 . vr_30 ( vr_54 ) ;
vr_98 < String > vr_39 = fn_47 () ;
vr_39 . remove ( vr_54 ) ;
fn_47 ( vr_39 ) ;
return this ;
}
public tp_2 fn_88 ( String vr_54 ) {
vr_8 . vr_30 ( vr_54 ) ;
vr_98 < String > vr_39 = fn_47 () ;
if ( vr_39 . contains ( vr_54 ) )
vr_39 . remove ( vr_54 ) ;
else
vr_39 . add ( vr_54 ) ;
fn_47 ( vr_39 ) ;
return this ;
}
public String fn_89 () {
if ( fn_10 () . equals ( lr_15 ) )
return vr_36 () ;
else
return fn_15 ( lr_16 ) ;
}
public tp_2 fn_89 ( String vr_58 ) {
if ( fn_10 () . equals ( lr_15 ) )
vr_36 ( vr_58 ) ;
else
fn_15 ( lr_16 , vr_58 ) ;
return this ;
}
void fn_90 ( final tp_7 vl_8 , int vr_81 , final vl_7 . vr_112 out ) throws IOException {
if ( out . vr_113 () && fn_91 ( out ) && ! fn_92 ( out ) ) {
if ( vl_8 instanceof StringBuilder ) {
if ( ( ( StringBuilder ) vl_8 ) . length () > 0 )
fn_93 ( vl_8 , vr_81 , out ) ;
} else {
fn_93 ( vl_8 , vr_81 , out ) ;
}
}
vl_8 . append ( '<' ) . append ( fn_10 () ) ;
if ( vl_3 != null ) vl_3 . vr_37 ( vl_8 , out ) ;
if ( vl_1 . isEmpty () && vr_6 . vr_114 () ) {
if ( out . vr_115 () == vl_7 . vr_112 . vr_116 . vr_37 && vr_6 . isEmpty () )
vl_8 . append ( '>' ) ;
else
vl_8 . append ( lr_17 ) ;
}
else
vl_8 . append ( '>' ) ;
}
void fn_94 ( tp_7 vl_8 , int vr_81 , vl_7 . vr_112 out ) throws IOException {
if ( ! ( vl_1 . isEmpty () && vr_6 . vr_114 () ) ) {
if ( out . vr_113 () && ( ! vl_1 . isEmpty () && (
vr_6 . vr_117 () || ( out . vr_118 () && ( vl_1 . size () > 1 || ( vl_1 . size () == 1 && ! ( vl_1 . get ( 0 ) instanceof vt_2 ) ) ) )
) ) )
fn_93 ( vl_8 , vr_81 , out ) ;
vl_8 . append ( lr_18 ) . append ( fn_10 () ) . append ( '>' ) ;
}
}
public String vr_37 () {
StringBuilder vl_8 = vr_40 . vr_88 () ;
vr_37 ( vl_8 ) ;
String vr_37 = vr_40 . vr_89 ( vl_8 ) ;
return vr_11 . vr_119 ( this ) . vr_113 () ? vr_37 . trim () : vr_37 ;
}
@Override
public < vt_5 extends tp_7 > vt_5 vr_37 ( vt_5 vr_120 ) {
final int size = vl_1 . size () ;
for ( int vr_18 = 0 ; vr_18 < size ; vr_18 ++ )
vl_1 . get ( vr_18 ) . fn_95 ( vr_120 ) ;
return vr_120 ;
}
public tp_2 vr_37 ( String vr_37 ) {
fn_43 () ;
append ( vr_37 ) ;
return this ;
}
@Override
public tp_2 fn_96 () {
return ( tp_2 ) super . fn_96 () ;
}
@Override
public tp_2 fn_97 () {
return new tp_2 ( vr_6 , fn_4 () , vl_3 == null ? null : vl_3 . fn_96 () ) ;
}
@Override
protected tp_2 fn_98 ( vt_1 vr_5 ) {
tp_2 fn_96 = ( tp_2 ) super . fn_98 ( vr_5 ) ;
fn_96 . vl_3 = vl_3 != null ? vl_3 . fn_96 () : null ;
fn_96 . vl_1 = new fn_2 ( fn_96 , vl_1 . size () ) ;
fn_96 . vl_1 . vr_121 ( vl_1 ) ;
fn_96 . vr_122 ( fn_4 () ) ;
return fn_96 ;
}
@Override
public tp_2 fn_99 () {
if ( vl_3 != null ) {
super . fn_99 () ;
vl_3 = null ;
}
return this ;
}
@Override
public tp_2 fn_100 ( String vr_14 ) {
return ( tp_2 ) super . fn_100 ( vr_14 ) ;
}
@Override
public tp_2 vr_29 () {
return ( tp_2 ) super . vr_29 () ;
}
@Override
public tp_2 fn_101 ( tp_8 vr_123 ) {
return ( tp_2 ) super . fn_101 ( vr_123 ) ;
}
@Override
public tp_2 fn_102 ( tp_9 vr_124 ) {
return ( tp_2 ) super . fn_102 ( vr_124 ) ;
}
public void fn_103 () {
vr_125 . fn_23 () ;
}
private boolean fn_91 ( vl_7 . vr_112 out ) {
return vr_6 . vr_117 () || ( vr_5 () != null && vr_5 () . vr_6 () . vr_117 () ) || out . vr_118 () ;
}
private boolean fn_92 ( vl_7 . vr_112 out ) {
return vr_6 () . fn_104 ()
&& ! vr_6 () . isEmpty ()
&& vr_5 () . fn_13 ()
&& fn_105 () != null
&& ! out . vr_118 () ;
}
