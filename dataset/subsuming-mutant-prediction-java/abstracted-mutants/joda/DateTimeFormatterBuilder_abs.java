public tp_1 fn_1 () {
Object vr_1 = fn_2 () ;
tp_2 vr_2 = null ;
if ( fn_3 ( vr_1 ) ) {
vr_2 = ( tp_2 ) vr_1 ;
}
tp_3 vr_3 = null ;
if ( fn_4 ( vr_1 ) ) {
vr_3 = ( tp_3 ) vr_1 ;
}
if ( vr_2 != null || vr_3 != null ) {
return new tp_1 ( vr_2 , vr_3 ) ;
}
throw new fn_5 ( lr_1 ) ;
}
public tp_4 fn_6 () {
Object vr_1 = fn_2 () ;
if ( fn_3 ( vr_1 ) ) {
tp_2 vr_4 = ( tp_2 ) vr_1 ;
return vr_5 . vr_6 ( vr_4 ) ;
}
throw new fn_5 ( lr_2 ) ;
}
public tp_5 fn_7 () {
Object vr_1 = fn_2 () ;
if ( fn_4 ( vr_1 ) ) {
tp_3 vr_4 = ( tp_3 ) vr_1 ;
return vr_7 . vr_6 ( vr_4 ) ;
}
throw new fn_5 ( lr_3 ) ;
}
public boolean fn_8 () {
return fn_9 ( fn_2 () ) ;
}
public boolean fn_10 () {
return fn_3 ( fn_2 () ) ;
}
public boolean fn_11 () {
return fn_4 ( fn_2 () ) ;
}
public void clear () {
vl_1 = null ;
vr_8 . clear () ;
}
public tp_6 append ( tp_1 vr_9 ) {
if ( vr_9 == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
return fn_12 ( vr_9 . vr_10 () , vr_9 . vr_11 () ) ;
}
public tp_6 append ( tp_4 vr_2 ) {
fn_13 ( vr_2 ) ;
return fn_12 ( vr_12 . vr_6 ( vr_2 ) , null ) ;
}
public tp_6 append ( tp_5 vr_3 ) {
fn_14 ( vr_3 ) ;
return fn_12 ( null , vr_13 . vr_6 ( vr_3 ) ) ;
}
public tp_6 append ( tp_4 vr_2 , tp_5 vr_3 ) {
fn_13 ( vr_2 ) ;
fn_14 ( vr_3 ) ;
return fn_12 ( vr_12 . vr_6 ( vr_2 ) , vr_13 . vr_6 ( vr_3 ) ) ;
}
public tp_6 append ( tp_4 vr_2 , tp_5 [] vr_14 ) {
if ( vr_2 != null ) {
fn_13 ( vr_2 ) ;
}
if ( vr_14 == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
int length = vr_14 . length ;
if ( length == 1 ) {
if ( vr_14 [ 0 ] == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
return fn_12 ( vr_12 . vr_6 ( vr_2 ) , vr_13 . vr_6 ( vr_14 [ 0 ] ) ) ;
}
tp_3 [] vr_15 = new tp_3 [ length ] ;
int vr_16 ;
for ( vr_16 = 0 ; vr_16 < length - 1 ; vr_16 ++ ) {
if ( ( vr_15 [ vr_16 ] = vr_13 . vr_6 ( vr_14 [ vr_16 ] ) ) == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
}
vr_15 [ vr_16 ] = vr_13 . vr_6 ( vr_14 [ vr_16 ] ) ;
return fn_12 ( vr_12 . vr_6 ( vr_2 ) , new fn_15 ( vr_15 ) ) ;
}
public tp_6 fn_16 ( tp_5 vr_3 ) {
fn_14 ( vr_3 ) ;
tp_3 [] vr_14 = new tp_3 [] { vr_13 . vr_6 ( vr_3 ) , null } ;
return fn_12 ( null , new fn_15 ( vr_14 ) ) ;
}
private void fn_14 ( tp_5 vr_3 ) {
if ( vr_3 == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
}
private void fn_13 ( tp_4 vr_2 ) {
if ( vr_2 == null ) {
throw new IllegalArgumentException ( lr_8 ) ;
}
}
private tp_6 fn_12 ( Object vr_17 ) {
vl_1 = null ;
vr_8 . add ( vr_17 ) ;
vr_8 . add ( vr_17 ) ;
return this ;
}
private tp_6 fn_12 (
tp_2 vr_2 , tp_3 vr_3 ) {
vl_1 = null ;
vr_8 . add ( vr_2 ) ;
vr_8 . add ( vr_3 ) ;
return this ;
}
public tp_6 fn_17 ( char vr_18 ) {
return fn_12 ( new fn_18 ( vr_18 ) ) ;
}
public tp_6 fn_17 ( String vr_19 ) {
if ( vr_19 == null ) {
throw new IllegalArgumentException ( lr_9 ) ;
}
switch ( vr_19 . length () ) {
case 0 :
return this ;
case 1 :
return fn_12 ( new fn_18 ( vr_19 . charAt ( 0 ) ) ) ;
default:
return fn_12 ( new fn_19 ( vr_19 ) ) ;
}
}
public tp_6 fn_20 (
tp_7 vr_20 , int vr_21 , int vr_22 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( vr_22 < vr_21 ) {
vr_22 = vr_21 ;
}
if ( vr_21 < 0 || vr_22 <= 0 ) {
throw new IllegalArgumentException () ;
}
if ( vr_21 <= 1 ) {
return fn_12 ( new fn_21 ( vr_20 , vr_22 , false ) ) ;
} else {
return fn_12 ( new fn_22 ( vr_20 , vr_22 , false , vr_21 ) ) ;
}
}
public tp_6 fn_23 (
tp_7 vr_20 , int vr_23 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( vr_23 <= 0 ) {
throw new IllegalArgumentException ( lr_11 + vr_23 ) ;
}
return fn_12 ( new fn_24 ( vr_20 , vr_23 , false ) ) ;
}
public tp_6 fn_25 (
tp_7 vr_20 , int vr_21 , int vr_22 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( vr_22 < vr_21 ) {
vr_22 = vr_21 ;
}
if ( vr_21 < 0 || vr_22 <= 0 ) {
throw new IllegalArgumentException () ;
}
if ( vr_21 <= 1 ) {
return fn_12 ( new fn_21 ( vr_20 , vr_22 , true ) ) ;
} else {
return fn_12 ( new fn_22 ( vr_20 , vr_22 , true , vr_21 ) ) ;
}
}
public tp_6 fn_26 (
tp_7 vr_20 , int vr_23 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( vr_23 <= 0 ) {
throw new IllegalArgumentException ( lr_11 + vr_23 ) ;
}
return fn_12 ( new fn_24 ( vr_20 , vr_23 , true ) ) ;
}
public tp_6 fn_27 ( tp_7 vr_20 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
return fn_12 ( new fn_28 ( vr_20 , false ) ) ;
}
public tp_6 fn_29 ( tp_7 vr_20 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
return fn_12 ( new fn_28 ( vr_20 , true ) ) ;
}
public tp_6 fn_30 (
tp_7 vr_20 , int vr_21 , int vr_22 ) {
if ( vr_20 == null ) {
throw new IllegalArgumentException ( lr_10 ) ;
}
if ( vr_22 < vr_21 ) {
vr_22 = vr_21 ;
}
if ( vr_21 < 0 || vr_22 <= 0 ) {
throw new IllegalArgumentException () ;
}
return fn_12 ( new fn_31 ( vr_20 , vr_21 , vr_22 ) ) ;
}
public tp_6 fn_32 ( int vr_21 , int vr_22 ) {
return fn_30 ( tp_7 . vr_24 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_33 ( int vr_21 , int vr_22 ) {
return fn_30 ( tp_7 . vr_25 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_34 ( int vr_21 , int vr_22 ) {
return fn_30 ( tp_7 . vr_26 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_35 ( int vr_21 , int vr_22 ) {
return fn_30 ( tp_7 . vr_27 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_36 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_28 () , vr_21 , 3 ) ;
}
public tp_6 fn_37 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_29 () , vr_21 , 8 ) ;
}
public tp_6 fn_38 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_30 () , vr_21 , 2 ) ;
}
public tp_6 fn_39 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_24 () , vr_21 , 5 ) ;
}
public tp_6 fn_40 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_31 () , vr_21 , 2 ) ;
}
public tp_6 fn_41 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_25 () , vr_21 , 4 ) ;
}
public tp_6 fn_42 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_26 () , vr_21 , 2 ) ;
}
public tp_6 fn_43 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_32 () , vr_21 , 2 ) ;
}
public tp_6 fn_44 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_33 () , vr_21 , 2 ) ;
}
public tp_6 fn_45 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_34 () , vr_21 , 2 ) ;
}
public tp_6 fn_46 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_35 () , vr_21 , 1 ) ;
}
public tp_6 fn_47 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_36 () , vr_21 , 2 ) ;
}
public tp_6 fn_48 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_27 () , vr_21 , 3 ) ;
}
public tp_6 fn_49 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_37 () , vr_21 , 2 ) ;
}
public tp_6 fn_50 ( int vr_21 , int vr_22 ) {
return fn_25 ( tp_7 . vr_38 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_51 ( int vr_21 ) {
return fn_20 ( tp_7 . vr_39 () , vr_21 , 2 ) ;
}
public tp_6 fn_52 ( int vr_21 , int vr_22 ) {
return fn_25 ( tp_7 . vr_40 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_53 ( int vr_41 ) {
return fn_53 ( vr_41 , false ) ;
}
public tp_6 fn_53 ( int vr_41 , boolean vr_42 ) {
return fn_12 ( new fn_54 ( tp_7 . vr_40 () , vr_41 , vr_42 ) ) ;
}
public tp_6 fn_55 ( int vr_41 ) {
return fn_55 ( vr_41 , false ) ;
}
public tp_6 fn_55 ( int vr_41 , boolean vr_42 ) {
return fn_12 ( new fn_54 ( tp_7 . vr_38 () , vr_41 , vr_42 ) ) ;
}
public tp_6 fn_56 ( int vr_21 , int vr_22 ) {
return fn_20 ( tp_7 . vr_43 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_57 ( int vr_21 , int vr_22 ) {
return fn_20 ( tp_7 . vr_44 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_58 ( int vr_21 , int vr_22 ) {
return fn_25 ( tp_7 . vr_45 () , vr_21 , vr_22 ) ;
}
public tp_6 fn_59 () {
return fn_27 ( tp_7 . vr_46 () ) ;
}
public tp_6 fn_60 () {
return fn_27 ( tp_7 . vr_35 () ) ;
}
public tp_6 fn_61 () {
return fn_29 ( tp_7 . vr_35 () ) ;
}
public tp_6 fn_62 () {
return fn_27 ( tp_7 . vr_39 () ) ;
}
public tp_6 fn_63 () {
return fn_29 ( tp_7 . vr_39 () ) ;
}
public tp_6 fn_64 () {
return fn_27 ( tp_7 . vr_47 () ) ;
}
public tp_6 fn_65 () {
return fn_12 ( new fn_66 ( fn_66 . vr_48 , null ) , null ) ;
}
public tp_6 fn_65 ( vr_49 < String , vt_1 > vr_50 ) {
fn_66 vr_51 = new fn_66 ( fn_66 . vr_48 , vr_50 ) ;
return fn_12 ( vr_51 , vr_51 ) ;
}
public tp_6 fn_67 () {
return fn_12 ( new fn_66 ( fn_66 . vr_52 , null ) , null ) ;
}
public tp_6 fn_67 ( vr_49 < String , vt_1 > vr_50 ) {
fn_66 vr_51 = new fn_66 ( fn_66 . vr_52 , vr_50 ) ;
return fn_12 ( vr_51 , vr_51 ) ;
}
public tp_6 fn_68 () {
return fn_12 ( vr_53 . vr_54 , vr_53 . vr_54 ) ;
}
public tp_6 fn_69 (
String vr_55 , boolean vr_56 ,
int vr_57 , int vr_58 ) {
return fn_12 ( new fn_70
( vr_55 , vr_55 , vr_56 , vr_57 , vr_58 ) ) ;
}
public tp_6 fn_69 (
String vr_59 , String vr_60 , boolean vr_56 ,
int vr_57 , int vr_58 ) {
return fn_12 ( new fn_70
( vr_59 , vr_60 , vr_56 , vr_57 , vr_58 ) ) ;
}
public tp_6 fn_71 ( String vr_61 ) {
vr_62 . vr_63 ( this , vr_61 ) ;
return this ;
}
private Object fn_2 () {
Object vr_1 = vl_1 ;
if ( vr_1 == null ) {
if ( vr_8 . size () == 2 ) {
Object vr_2 = vr_8 . get ( 0 ) ;
Object vr_3 = vr_8 . get ( 1 ) ;
if ( vr_2 != null ) {
if ( vr_2 == vr_3 || vr_3 == null ) {
vr_1 = vr_2 ;
}
} else {
vr_1 = vr_3 ;
}
}
if ( vr_1 == null ) {
vr_1 = new fn_72 ( vr_8 ) ;
}
vl_1 = vr_1 ;
}
return vr_1 ;
}
private boolean fn_3 ( Object vr_1 ) {
if ( vr_1 instanceof tp_2 ) {
if ( vr_1 instanceof fn_72 ) {
return ( ( fn_72 ) vr_1 ) . fn_3 () ;
}
return true ;
}
return false ;
}
private boolean fn_4 ( Object vr_1 ) {
if ( vr_1 instanceof tp_3 ) {
if ( vr_1 instanceof fn_72 ) {
return ( ( fn_72 ) vr_1 ) . fn_4 () ;
}
return true ;
}
return false ;
}
private boolean fn_9 ( Object vr_1 ) {
return ( fn_3 ( vr_1 ) || fn_4 ( vr_1 ) ) ;
}
static void fn_73 ( tp_8 vr_64 , int vr_65 ) throws IOException {
for ( int vr_16 = vr_65 ; -- vr_16 >= 0 ; ) {
vr_64 . append ( '\ufffd' ) ;
}
}
public int fn_74 () {
return 1 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
vr_64 . append ( vl_2 ) ;
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
vr_64 . append ( vl_2 ) ;
}
public int fn_76 () {
return 1 ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
if ( vr_73 >= vr_19 . length () ) {
return ~ vr_73 ;
}
char vr_74 = vr_19 . charAt ( vr_73 ) ;
char vr_75 = vl_2 ;
if ( vr_74 != vr_75 ) {
vr_74 = vr_76 . vr_77 ( vr_74 ) ;
vr_75 = vr_76 . vr_77 ( vr_75 ) ;
if ( vr_74 != vr_75 ) {
vr_74 = vr_76 . vr_78 ( vr_74 ) ;
vr_75 = vr_76 . vr_78 ( vr_75 ) ;
if ( vr_74 != vr_75 ) {
return ~ vr_73 ;
}
}
}
return vr_73 + 1 ;
}
public int fn_74 () {
return vl_2 . length () ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
vr_64 . append ( vl_2 ) ;
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
vr_64 . append ( vl_2 ) ;
}
public int fn_76 () {
return vl_2 . length () ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
if ( fn_78 ( vr_19 , vr_73 , vl_2 ) ) {
return vr_73 + vl_2 . length () ;
}
return ~ vr_73 ;
}
public int fn_76 () {
return vl_3 ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
int vr_79 = vr_80 . vr_81 ( vl_3 , vr_19 . length () - vr_73 ) ;
boolean vr_82 = false ;
boolean vr_83 = false ;
int length = 0 ;
while ( length < vr_79 ) {
char vr_18 = vr_19 . charAt ( vr_73 + length ) ;
if ( length == 0 && ( vr_18 == '-' || vr_18 == '+' ) && vl_4 ) {
vr_82 = vr_18 == '-' ;
vr_83 = vr_18 == '+' ;
if ( length + 1 >= vr_79 ||
( vr_18 = vr_19 . charAt ( vr_73 + length + 1 ) ) < '0' || vr_18 > '9' ) {
break;
}
length ++ ;
vr_79 = vr_80 . vr_81 ( vr_79 + 1 , vr_19 . length () - vr_73 ) ;
continue;
}
if ( vr_18 < '0' || vr_18 > '9' ) {
break;
}
length ++ ;
}
if ( length == 0 ) {
return ~ vr_73 ;
}
int vr_84 ;
if ( length >= 9 ) {
if ( vr_83 ) {
vr_84 = Integer . vr_85 ( vr_19 . vr_86 ( vr_73 + 1 , vr_73 += length ) . toString () ) ;
} else {
vr_84 = Integer . vr_85 ( vr_19 . vr_86 ( vr_73 , vr_73 += length ) . toString () ) ;
}
} else {
int vr_16 = vr_73 ;
if ( vr_82 || vr_83 ) {
vr_16 ++ ;
}
try {
vr_84 = vr_19 . charAt ( vr_16 ++ ) - '0' ;
} catch ( tp_14 vr_87 ) {
return ~ vr_73 ;
}
vr_73 += length ;
while ( vr_16 < vr_73 ) {
vr_84 = ( ( vr_84 << 3 ) + ( vr_84 << 1 ) ) + vr_19 . charAt ( vr_16 ++ ) - '0' ;
}
if ( vr_82 ) {
vr_84 = - vr_84 ;
}
}
vr_72 . vr_88 ( vl_5 , vr_84 ) ;
return vr_73 ;
}
public int fn_74 () {
return vl_3 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
try {
tp_15 vr_89 = vl_5 . vr_90 ( vr_67 ) ;
vr_91 . vr_92 ( vr_64 , vr_89 . get ( vr_66 ) ) ;
} catch ( tp_16 vr_87 ) {
vr_64 . append ( '\ufffd' ) ;
}
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
if ( vr_71 . vr_93 ( vl_5 ) ) {
try {
vr_91 . vr_92 ( vr_64 , vr_71 . get ( vl_5 ) ) ;
} catch ( tp_16 vr_87 ) {
vr_64 . append ( '\ufffd' ) ;
}
} else {
vr_64 . append ( '\ufffd' ) ;
}
}
public int fn_74 () {
return vl_3 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
try {
tp_15 vr_89 = vl_5 . vr_90 ( vr_67 ) ;
vr_91 . vr_94 ( vr_64 , vr_89 . get ( vr_66 ) , vl_6 ) ;
} catch ( tp_16 vr_87 ) {
fn_73 ( vr_64 , vl_6 ) ;
}
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
if ( vr_71 . vr_93 ( vl_5 ) ) {
try {
vr_91 . vr_94 ( vr_64 , vr_71 . get ( vl_5 ) , vl_6 ) ;
} catch ( tp_16 vr_87 ) {
fn_73 ( vr_64 , vl_6 ) ;
}
} else {
fn_73 ( vr_64 , vl_6 ) ;
}
}
@Override
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
int vr_95 = super . fn_77 ( vr_72 , vr_19 , vr_73 ) ;
if ( vr_95 < 0 ) {
return vr_95 ;
}
int vr_96 = vr_73 + vl_3 ;
if ( vr_95 != vr_96 ) {
if ( vl_4 ) {
char vr_18 = vr_19 . charAt ( vr_73 ) ;
if ( vr_18 == '-' || vr_18 == '+' ) {
vr_96 ++ ;
}
}
if ( vr_95 > vr_96 ) {
return ~ ( vr_96 + 1 ) ;
} else if ( vr_95 < vr_96 ) {
return ~ vr_95 ;
}
}
return vr_95 ;
}
public int fn_76 () {
return vl_7 ? 4 : 2 ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
int vr_79 = vr_19 . length () - vr_73 ;
if ( ! vl_7 ) {
vr_79 = vr_80 . vr_81 ( 2 , vr_79 ) ;
if ( vr_79 < 2 ) {
return ~ vr_73 ;
}
} else {
boolean vr_97 = false ;
boolean vr_82 = false ;
int length = 0 ;
while ( length < vr_79 ) {
char vr_18 = vr_19 . charAt ( vr_73 + length ) ;
if ( length == 0 && ( vr_18 == '-' || vr_18 == '+' ) ) {
vr_97 = true ;
vr_82 = vr_18 == '-' ;
if ( vr_82 ) {
length ++ ;
} else {
vr_73 ++ ;
vr_79 -- ;
}
continue;
}
if ( vr_18 < '0' || vr_18 > '9' ) {
break;
}
length ++ ;
}
if ( length == 0 ) {
return ~ vr_73 ;
}
if ( vr_97 || length != 2 ) {
int vr_84 ;
if ( length >= 9 ) {
vr_84 = Integer . vr_85 ( vr_19 . vr_86 ( vr_73 , vr_73 += length ) . toString () ) ;
} else {
int vr_16 = vr_73 ;
if ( vr_82 ) {
vr_16 ++ ;
}
try {
vr_84 = vr_19 . charAt ( vr_16 ++ ) - '0' ;
} catch ( tp_14 vr_87 ) {
return ~ vr_73 ;
}
vr_73 += length ;
while ( vr_16 < vr_73 ) {
vr_84 = ( ( vr_84 << 3 ) + ( vr_84 << 1 ) ) + vr_19 . charAt ( vr_16 ++ ) - '0' ;
}
if ( vr_82 ) {
vr_84 = - vr_84 ;
}
}
vr_72 . vr_88 ( vl_8 , vr_84 ) ;
return vr_73 ;
}
}
int vr_40 ;
char vr_18 = vr_19 . charAt ( vr_73 ) ;
if ( vr_18 < '0' || vr_18 > '9' ) {
return ~ vr_73 ;
}
vr_40 = vr_18 - '0' ;
vr_18 = vr_19 . charAt ( vr_73 + 1 ) ;
if ( vr_18 < '0' || vr_18 > '9' ) {
return ~ vr_73 ;
}
vr_40 = ( ( vr_40 << 3 ) + ( vr_40 << 1 ) ) + vr_18 - '0' ;
int vr_41 = vl_9 ;
if ( vr_72 . vr_98 () != null ) {
vr_41 = vr_72 . vr_98 () . fn_79 () ;
}
int vr_99 = vr_41 - 50 ;
int vr_100 ;
if ( vr_99 >= 0 ) {
vr_100 = vr_99 % 100 ;
} else {
vr_100 = 99 + ( ( vr_99 + 1 ) % 100 ) ;
}
vr_40 += vr_99 + ( ( vr_40 < vr_100 ) ? 100 : 0 ) - vr_100 ;
vr_72 . vr_88 ( vl_8 , vr_40 ) ;
return vr_73 + 2 ;
}
public int fn_74 () {
return 2 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
int vr_40 = fn_80 ( vr_66 , vr_67 ) ;
if ( vr_40 < 0 ) {
vr_64 . append ( '\ufffd' ) ;
vr_64 . append ( '\ufffd' ) ;
} else {
vr_91 . vr_94 ( vr_64 , vr_40 , 2 ) ;
}
}
private int fn_80 ( long vr_66 , tp_9 vr_67 ) {
try {
int vr_40 = vl_8 . vr_90 ( vr_67 ) . get ( vr_66 ) ;
if ( vr_40 < 0 ) {
vr_40 = - vr_40 ;
}
return vr_40 % 100 ;
} catch ( tp_16 vr_87 ) {
return - 1 ;
}
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
int vr_40 = fn_80 ( vr_71 ) ;
if ( vr_40 < 0 ) {
vr_64 . append ( '\ufffd' ) ;
vr_64 . append ( '\ufffd' ) ;
} else {
vr_91 . vr_94 ( vr_64 , vr_40 , 2 ) ;
}
}
private int fn_80 ( tp_11 vr_71 ) {
if ( vr_71 . vr_93 ( vl_8 ) ) {
try {
int vr_40 = vr_71 . get ( vl_8 ) ;
if ( vr_40 < 0 ) {
vr_40 = - vr_40 ;
}
return vr_40 % 100 ;
} catch ( tp_16 vr_87 ) {}
}
return - 1 ;
}
public int fn_74 () {
return vl_10 ? 6 : 20 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
try {
vr_64 . append ( fn_81 ( vr_66 , vr_67 , vr_70 ) ) ;
} catch ( tp_16 vr_87 ) {
vr_64 . append ( '\ufffd' ) ;
}
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
try {
vr_64 . append ( fn_81 ( vr_71 , vr_70 ) ) ;
} catch ( tp_16 vr_87 ) {
vr_64 . append ( '\ufffd' ) ;
}
}
private String fn_81 ( long vr_66 , tp_9 vr_67 , tp_10 vr_70 ) {
tp_15 vr_89 = vl_5 . vr_90 ( vr_67 ) ;
if ( vl_10 ) {
return vr_89 . vr_101 ( vr_66 , vr_70 ) ;
} else {
return vr_89 . vr_102 ( vr_66 , vr_70 ) ;
}
}
private String fn_81 ( tp_11 vr_71 , tp_10 vr_70 ) {
if ( vr_71 . vr_93 ( vl_5 ) ) {
tp_15 vr_89 = vl_5 . vr_90 ( vr_71 . vr_103 () ) ;
if ( vl_10 ) {
return vr_89 . vr_101 ( vr_71 , vr_70 ) ;
} else {
return vr_89 . vr_102 ( vr_71 , vr_70 ) ;
}
} else {
return lr_12 ;
}
}
public int fn_76 () {
return fn_74 () ;
}
@SuppressWarnings ( lr_13 )
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
tp_10 vr_70 = vr_72 . vr_104 () ;
vr_49 < String , Boolean > vr_105 = null ;
int vr_106 = 0 ;
vr_49 < tp_7 , Object [] > vr_107 = vr_108 . get ( vr_70 ) ;
if ( vr_107 == null ) {
vr_107 = new vr_109 < tp_7 , Object [] > () ;
vr_108 . vr_110 ( vr_70 , vr_107 ) ;
}
Object [] array = vr_107 . get ( vl_5 ) ;
if ( array == null ) {
vr_105 = new vr_109 < String , Boolean > ( 32 ) ;
tp_17 vr_111 = new tp_17 ( 0L , vt_1 . vr_112 ) ;
tp_18 vr_113 = vr_111 . vr_113 ( vl_5 ) ;
int vr_81 = vr_113 . vr_114 () ;
int vr_115 = vr_113 . vr_116 () ;
if ( vr_115 - vr_81 > 32 ) {
return ~ vr_73 ;
}
vr_106 = vr_113 . vr_117 ( vr_70 ) ;
for ( int vr_16 = vr_81 ; vr_16 <= vr_115 ; vr_16 ++ ) {
vr_113 . vr_118 ( vr_16 ) ;
vr_105 . vr_110 ( vr_113 . vr_101 ( vr_70 ) , Boolean . TRUE ) ;
vr_105 . vr_110 ( vr_113 . vr_101 ( vr_70 ) . vr_78 ( vr_70 ) , Boolean . TRUE ) ;
vr_105 . vr_110 ( vr_113 . vr_101 ( vr_70 ) . vr_77 ( vr_70 ) , Boolean . TRUE ) ;
vr_105 . vr_110 ( vr_113 . vr_102 ( vr_70 ) , Boolean . TRUE ) ;
vr_105 . vr_110 ( vr_113 . vr_102 ( vr_70 ) . vr_78 ( vr_70 ) , Boolean . TRUE ) ;
vr_105 . vr_110 ( vr_113 . vr_102 ( vr_70 ) . vr_77 ( vr_70 ) , Boolean . TRUE ) ;
}
if ( lr_14 . equals ( vr_70 . vr_119 () ) && vl_5 == tp_7 . vr_47 () ) {
vr_105 . vr_110 ( lr_15 , Boolean . TRUE ) ;
vr_105 . vr_110 ( lr_16 , Boolean . TRUE ) ;
vr_105 . vr_110 ( lr_17 , Boolean . TRUE ) ;
vr_105 . vr_110 ( lr_18 , Boolean . TRUE ) ;
vr_106 = 3 ;
}
array = new Object [] { vr_105 , Integer . valueOf ( vr_106 ) } ;
vr_107 . vr_110 ( vl_5 , array ) ;
} else {
vr_105 = ( vr_49 < String , Boolean > ) array [ 0 ] ;
vr_106 = ( ( Integer ) array [ 1 ] ) . fn_79 () ;
}
int vr_79 = vr_80 . vr_81 ( vr_19 . length () , vr_73 + vr_106 ) ;
for ( int vr_16 = vr_79 ; vr_16 > vr_73 ; vr_16 -- ) {
String vr_120 = vr_19 . vr_86 ( vr_73 , vr_16 ) . toString () ;
if ( vr_105 . vr_121 ( vr_120 ) ) {
vr_72 . vr_88 ( vl_5 , vr_120 , vr_70 ) ;
return vr_16 ;
}
}
return ~ vr_73 ;
}
public int fn_74 () {
return vl_11 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
fn_75 ( vr_64 , vr_66 , vr_67 ) ;
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
long vr_122 = vr_71 . vr_103 () . vr_118 ( vr_71 , 0L ) ;
fn_75 ( vr_64 , vr_122 , vr_71 . vr_103 () ) ;
}
protected void fn_75 ( tp_8 vr_64 , long vr_66 , tp_9 vr_67 )
throws IOException
{
tp_15 vr_89 = vl_5 . vr_90 ( vr_67 ) ;
int vr_21 = vl_12 ;
long vr_123 ;
try {
vr_123 = vr_89 . vr_124 ( vr_66 ) ;
} catch ( tp_16 vr_87 ) {
fn_73 ( vr_64 , vr_21 ) ;
return;
}
if ( vr_123 == 0 ) {
while ( -- vr_21 >= 0 ) {
vr_64 . append ( '0' ) ;
}
return;
}
String vr_125 ;
long [] vr_126 = fn_82 ( vr_123 , vr_89 ) ;
long vr_127 = vr_126 [ 0 ] ;
int vr_22 = ( int ) vr_126 [ 1 ] ;
if ( ( vr_127 & 0x7fffffff ) == vr_127 ) {
vr_125 = Integer . toString ( ( int ) vr_127 ) ;
} else {
vr_125 = Long . toString ( vr_127 ) ;
}
int length = vr_125 . length () ;
int vr_128 = vr_22 ;
while ( length < vr_128 ) {
vr_64 . append ( '0' ) ;
vr_21 -- ;
vr_128 -- ;
}
if ( vr_21 < vr_128 ) {
while ( vr_21 < vr_128 ) {
if ( length <= 1 || vr_125 . charAt ( length - 1 ) != '0' ) {
break;
}
vr_128 -- ;
length -- ;
}
if ( length < vr_125 . length () ) {
for ( int vr_16 = 0 ; vr_16 < length ; vr_16 ++ ) {
vr_64 . append ( vr_125 . charAt ( vr_16 ) ) ;
}
return;
}
}
vr_64 . append ( vr_125 ) ;
}
private long [] fn_82 ( long vr_123 , tp_15 vr_89 ) {
long vr_129 = vr_89 . vr_130 () . fn_83 () ;
long vr_131 ;
int vr_22 = vl_11 ;
while ( true ) {
switch ( vr_22 ) {
default: vr_131 = 1L ; break;
case 1 : vr_131 = 10L ; break;
case 2 : vr_131 = 100L ; break;
case 3 : vr_131 = 1000L ; break;
case 4 : vr_131 = 10000L ; break;
case 5 : vr_131 = 100000L ; break;
case 6 : vr_131 = 1000000L ; break;
case 7 : vr_131 = 10000000L ; break;
case 8 : vr_131 = 100000000L ; break;
case 9 : vr_131 = 1000000000L ; break;
case 10 : vr_131 = 10000000000L ; break;
case 11 : vr_131 = 100000000000L ; break;
case 12 : vr_131 = 1000000000000L ; break;
case 13 : vr_131 = 10000000000000L ; break;
case 14 : vr_131 = 100000000000000L ; break;
case 15 : vr_131 = 1000000000000000L ; break;
case 16 : vr_131 = 10000000000000000L ; break;
case 17 : vr_131 = 100000000000000000L ; break;
case 18 : vr_131 = 1000000000000000000L ; break;
}
if ( ( ( vr_129 * vr_131 ) / vr_131 ) == vr_129 ) {
break;
}
vr_22 -- ;
}
return new long [] { vr_123 * vr_131 / vr_129 , vr_22 } ;
}
public int fn_76 () {
return vl_11 ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
tp_15 vr_89 = vl_5 . vr_90 ( vr_72 . vr_103 () ) ;
int vr_79 = vr_80 . vr_81 ( vl_11 , vr_19 . length () - vr_73 ) ;
long vr_84 = 0 ;
long vr_132 = vr_89 . vr_130 () . fn_83 () * 10 ;
int length = 0 ;
while ( length < vr_79 ) {
char vr_18 = vr_19 . charAt ( vr_73 + length ) ;
if ( vr_18 < '0' || vr_18 > '9' ) {
break;
}
length ++ ;
long vr_133 = vr_132 / 10 ;
vr_84 += ( vr_18 - '0' ) * vr_133 ;
vr_132 = vr_133 ;
}
vr_84 /= 10 ;
if ( length == 0 ) {
return ~ vr_73 ;
}
if ( vr_84 > Integer . vr_134 ) {
return ~ vr_73 ;
}
tp_15 vr_135 = new fn_84 (
tp_7 . vr_28 () ,
vr_136 . vr_54 ,
vr_89 . vr_130 () ) ;
vr_72 . vr_88 ( vr_135 , ( int ) vr_84 ) ;
return vr_73 + length ;
}
public int fn_74 () {
int vr_137 = 1 + vl_13 << 1 ;
if ( vl_14 ) {
vr_137 += vl_13 - 1 ;
}
if ( vl_15 != null && vl_15 . length () > vr_137 ) {
vr_137 = vl_15 . length () ;
}
return vr_137 ;
}
public void fn_75 (
tp_8 vr_138 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
if ( vr_69 == null ) {
return;
}
if ( vr_68 == 0 && vl_15 != null ) {
vr_138 . append ( vl_15 ) ;
return;
}
if ( vr_68 >= 0 ) {
vr_138 . append ( '+' ) ;
} else {
vr_138 . append ( '-' ) ;
vr_68 = - vr_68 ;
}
int vr_139 = vr_68 / vr_140 . vr_141 ;
vr_91 . vr_94 ( vr_138 , vr_139 , 2 ) ;
if ( vl_16 == 1 ) {
return;
}
vr_68 -= vr_139 * ( int ) vr_140 . vr_141 ;
if ( vr_68 == 0 && vl_13 <= 1 ) {
return;
}
int vr_142 = vr_68 / vr_140 . vr_143 ;
if ( vl_14 ) {
vr_138 . append ( ':' ) ;
}
vr_91 . vr_94 ( vr_138 , vr_142 , 2 ) ;
if ( vl_16 == 2 ) {
return;
}
vr_68 -= vr_142 * vr_140 . vr_143 ;
if ( vr_68 == 0 && vl_13 <= 2 ) {
return;
}
int vr_144 = vr_68 / vr_140 . vr_145 ;
if ( vl_14 ) {
vr_138 . append ( ':' ) ;
}
vr_91 . vr_94 ( vr_138 , vr_144 , 2 ) ;
if ( vl_16 == 3 ) {
return;
}
vr_68 -= vr_144 * vr_140 . vr_145 ;
if ( vr_68 == 0 && vl_13 <= 3 ) {
return;
}
if ( vl_14 ) {
vr_138 . append ( '.' ) ;
}
vr_91 . vr_94 ( vr_138 , vr_68 , 3 ) ;
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
}
public int fn_76 () {
return fn_74 () ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
int vr_79 = vr_19 . length () - vr_73 ;
lb_1:
if ( vl_17 != null ) {
if ( vl_17 . length () == 0 ) {
if ( vr_79 > 0 ) {
char vr_18 = vr_19 . charAt ( vr_73 ) ;
if ( vr_18 == '-' || vr_18 == '+' ) {
break lb_1;
}
}
vr_72 . vr_146 ( Integer . valueOf ( 0 ) ) ;
return vr_73 ;
}
if ( fn_78 ( vr_19 , vr_73 , vl_17 ) ) {
vr_72 . vr_146 ( Integer . valueOf ( 0 ) ) ;
return vr_73 + vl_17 . length () ;
}
}
if ( vr_79 <= 1 ) {
return ~ vr_73 ;
}
boolean vr_82 ;
char vr_18 = vr_19 . charAt ( vr_73 ) ;
if ( vr_18 == '-' ) {
vr_82 = true ;
} else if ( vr_18 == '+' ) {
vr_82 = false ;
} else {
return ~ vr_73 ;
}
vr_79 -- ;
vr_73 ++ ;
if ( fn_85 ( vr_19 , vr_73 , 2 ) < 2 ) {
return ~ vr_73 ;
}
int vr_147 ;
int vr_139 = vr_91 . vr_148 ( vr_19 , vr_73 ) ;
if ( vr_139 > 23 ) {
return ~ vr_73 ;
}
vr_147 = vr_139 * vr_140 . vr_141 ;
vr_79 -= 2 ;
vr_73 += 2 ;
lb_2: {
if ( vr_79 <= 0 ) {
break lb_2;
}
boolean vr_149 ;
vr_18 = vr_19 . charAt ( vr_73 ) ;
if ( vr_18 == ':' ) {
vr_149 = true ;
vr_79 -- ;
vr_73 ++ ;
} else if ( vr_18 >= '0' && vr_18 <= '9' ) {
vr_149 = false ;
} else {
break lb_2;
}
int vr_150 = fn_85 ( vr_19 , vr_73 , 2 ) ;
if ( vr_150 == 0 && ! vr_149 ) {
break lb_2;
} else if ( vr_150 < 2 ) {
return ~ vr_73 ;
}
int vr_142 = vr_91 . vr_148 ( vr_19 , vr_73 ) ;
if ( vr_142 > 59 ) {
return ~ vr_73 ;
}
vr_147 += vr_142 * vr_140 . vr_143 ;
vr_79 -= 2 ;
vr_73 += 2 ;
if ( vr_79 <= 0 ) {
break lb_2;
}
if ( vr_149 ) {
if ( vr_19 . charAt ( vr_73 ) != ':' ) {
break lb_2;
}
vr_79 -- ;
vr_73 ++ ;
}
vr_150 = fn_85 ( vr_19 , vr_73 , 2 ) ;
if ( vr_150 == 0 && ! vr_149 ) {
break lb_2;
} else if ( vr_150 < 2 ) {
return ~ vr_73 ;
}
int vr_144 = vr_91 . vr_148 ( vr_19 , vr_73 ) ;
if ( vr_144 > 59 ) {
return ~ vr_73 ;
}
vr_147 += vr_144 * vr_140 . vr_145 ;
vr_79 -= 2 ;
vr_73 += 2 ;
if ( vr_79 <= 0 ) {
break lb_2;
}
if ( vr_149 ) {
if ( vr_19 . charAt ( vr_73 ) != '.' && vr_19 . charAt ( vr_73 ) != ',' ) {
break lb_2;
}
vr_79 -- ;
vr_73 ++ ;
}
vr_150 = fn_85 ( vr_19 , vr_73 , 3 ) ;
if ( vr_150 == 0 && ! vr_149 ) {
break lb_2;
} else if ( vr_150 < 1 ) {
return ~ vr_73 ;
}
vr_147 += ( vr_19 . charAt ( vr_73 ++ ) - '0' ) * 100 ;
if ( vr_150 > 1 ) {
vr_147 += ( vr_19 . charAt ( vr_73 ++ ) - '0' ) * 10 ;
if ( vr_150 > 2 ) {
vr_147 += vr_19 . charAt ( vr_73 ++ ) - '0' ;
}
}
}
vr_72 . vr_146 ( Integer . valueOf ( vr_82 ? - vr_147 : vr_147 ) ) ;
return vr_73 ;
}
private int fn_85 ( tp_13 vr_19 , int vr_73 , int vr_151 ) {
int vr_79 = vr_80 . vr_81 ( vr_19 . length () - vr_73 , vr_151 ) ;
vr_151 = 0 ;
for (; vr_79 > 0 ; vr_79 -- ) {
char vr_18 = vr_19 . charAt ( vr_73 + vr_151 ) ;
if ( vr_18 < '0' || vr_18 > '9' ) {
break;
}
vr_151 ++ ;
}
return vr_151 ;
}
public int fn_74 () {
return ( vl_8 == vr_52 ? 4 : 20 ) ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
vr_64 . append ( fn_81 ( vr_66 - vr_68 , vr_69 , vr_70 ) ) ;
}
private String fn_81 ( long vr_66 , vt_1 vr_69 , tp_10 vr_70 ) {
if ( vr_69 == null ) {
return lr_19 ;
}
switch ( vl_8 ) {
case vr_48 :
return vr_69 . vr_152 ( vr_66 , vr_70 ) ;
case vr_52 :
return vr_69 . vr_153 ( vr_66 , vr_70 ) ;
}
return lr_19 ;
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
}
public int fn_76 () {
return ( vl_8 == vr_52 ? 4 : 20 ) ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
vr_49 < String , vt_1 > vr_50 = vl_18 ;
vr_50 = ( vr_50 != null ? vr_50 : vr_154 . vr_155 () ) ;
String vr_156 = null ;
for ( String vr_157 : vr_50 . vr_158 () ) {
if ( fn_86 ( vr_19 , vr_73 , vr_157 ) ) {
if ( vr_156 == null || vr_157 . length () > vr_156 . length () ) {
vr_156 = vr_157 ;
}
}
}
if ( vr_156 != null ) {
vr_72 . vr_159 ( vr_50 . get ( vr_156 ) ) ;
return vr_73 + vr_156 . length () ;
}
return ~ vr_73 ;
}
public int fn_74 () {
return vl_19 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
vr_64 . append ( vr_69 != null ? vr_69 . vr_160 () : lr_19 ) ;
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
}
public int fn_76 () {
return vl_19 ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
List < String > vr_161 = vl_20 ;
int vr_162 = vr_19 . length () ;
int vr_163 = vr_80 . vr_81 ( vr_162 , vr_73 + vl_21 ) ;
int vr_164 = vr_73 ;
String vr_165 = lr_19 ;
for ( int vr_16 = vr_164 ; vr_16 < vr_163 ; vr_16 ++ ) {
if ( vr_19 . charAt ( vr_16 ) == '/' ) {
vr_165 = vr_19 . vr_86 ( vr_164 , vr_16 + 1 ) . toString () ;
vr_164 += vr_165 . length () ;
String vr_166 = vr_165 ;
if ( vr_16 < vr_162 ) {
vr_166 += vr_19 . charAt ( vr_16 + 1 ) ;
}
vr_161 = vr_167 . get ( vr_166 ) ;
if ( vr_161 == null ) {
return ~ vr_73 ;
}
break;
}
}
String vr_168 = null ;
for ( int vr_16 = 0 ; vr_16 < vr_161 . size () ; vr_16 ++ ) {
String vr_169 = vr_161 . get ( vr_16 ) ;
if ( fn_86 ( vr_19 , vr_164 , vr_169 ) ) {
if ( vr_168 == null || vr_169 . length () > vr_168 . length () ) {
vr_168 = vr_169 ;
}
}
}
if ( vr_168 != null ) {
vr_72 . vr_159 ( vt_1 . vr_170 ( vr_165 + vr_168 ) ) ;
return vr_164 + vr_168 . length () ;
}
return ~ vr_73 ;
}
public int fn_74 () {
return vl_22 ;
}
public void fn_75 (
tp_8 vr_64 , long vr_66 , tp_9 vr_67 ,
int vr_68 , vt_1 vr_69 , tp_10 vr_70 ) throws IOException {
tp_2 [] vr_171 = vl_23 ;
if ( vr_171 == null ) {
throw new fn_5 () ;
}
if ( vr_70 == null ) {
vr_70 = tp_10 . vr_172 () ;
}
int vr_65 = vr_171 . length ;
for ( int vr_16 = 0 ; vr_16 < vr_65 ; vr_16 ++ ) {
vr_171 [ vr_16 ] . fn_75 ( vr_64 , vr_66 , vr_67 , vr_68 , vr_69 , vr_70 ) ;
}
}
public void fn_75 ( tp_8 vr_64 , tp_11 vr_71 , tp_10 vr_70 ) throws IOException {
tp_2 [] vr_171 = vl_23 ;
if ( vr_171 == null ) {
throw new fn_5 () ;
}
if ( vr_70 == null ) {
vr_70 = tp_10 . vr_172 () ;
}
int vr_65 = vr_171 . length ;
for ( int vr_16 = 0 ; vr_16 < vr_65 ; vr_16 ++ ) {
vr_171 [ vr_16 ] . fn_75 ( vr_64 , vr_71 , vr_70 ) ;
}
}
public int fn_76 () {
return vl_24 ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
tp_3 [] vr_171 = vl_25 ;
if ( vr_171 == null ) {
throw new fn_5 () ;
}
int vr_65 = vr_171 . length ;
for ( int vr_16 = 0 ; vr_16 < vr_65 && vr_73 >= 0 ; vr_16 ++ ) {
vr_73 = vr_171 [ vr_16 ] . fn_77 ( vr_72 , vr_19 , vr_73 ) ;
}
return vr_73 ;
}
boolean fn_3 () {
return vl_23 != null ;
}
boolean fn_4 () {
return vl_25 != null ;
}
private void fn_87 ( List < Object > vr_173 , List < Object > vr_174 , List < Object > vr_175 ) {
int size = vr_173 . size () ;
for ( int vr_16 = 0 ; vr_16 < size ; vr_16 += 2 ) {
Object vr_17 = vr_173 . get ( vr_16 ) ;
if ( vr_17 instanceof fn_72 ) {
fn_88 ( vr_174 , ( ( fn_72 ) vr_17 ) . vl_23 ) ;
} else {
vr_174 . add ( vr_17 ) ;
}
vr_17 = vr_173 . get ( vr_16 + 1 ) ;
if ( vr_17 instanceof fn_72 ) {
fn_88 ( vr_175 , ( ( fn_72 ) vr_17 ) . vl_25 ) ;
} else {
vr_175 . add ( vr_17 ) ;
}
}
}
private void fn_88 ( List < Object > list , Object [] array ) {
if ( array != null ) {
for ( int vr_16 = 0 ; vr_16 < array . length ; vr_16 ++ ) {
list . add ( array [ vr_16 ] ) ;
}
}
}
public int fn_76 () {
return vl_24 ;
}
public int fn_77 ( tp_12 vr_72 , tp_13 vr_19 , int vr_73 ) {
tp_3 [] vr_14 = vl_25 ;
int length = vr_14 . length ;
final Object vr_176 = vr_72 . vr_177 () ;
boolean vr_178 = false ;
int vr_179 = vr_73 ;
Object vr_180 = null ;
int vr_181 = vr_73 ;
for ( int vr_16 = 0 ; vr_16 < length ; vr_16 ++ ) {
tp_3 vr_3 = vr_14 [ vr_16 ] ;
if ( vr_3 == null ) {
if ( vr_179 <= vr_73 ) {
return vr_73 ;
}
vr_178 = true ;
break;
}
int vr_182 = vr_3 . fn_77 ( vr_72 , vr_19 , vr_73 ) ;
if ( vr_182 >= vr_73 ) {
if ( vr_182 > vr_179 ) {
if ( vr_182 >= vr_19 . length () ||
( vr_16 + 1 ) >= length || vr_14 [ vr_16 + 1 ] == null ) {
return vr_182 ;
}
vr_179 = vr_182 ;
vr_180 = vr_72 . vr_177 () ;
}
} else {
if ( vr_182 < 0 ) {
vr_182 = ~ vr_182 ;
if ( vr_182 > vr_181 ) {
vr_181 = vr_182 ;
}
}
}
vr_72 . vr_183 ( vr_176 ) ;
}
if ( vr_179 > vr_73 || ( vr_179 == vr_73 && vr_178 ) ) {
if ( vr_180 != null ) {
vr_72 . vr_183 ( vr_180 ) ;
}
return vr_179 ;
}
return ~ vr_181 ;
}
static boolean fn_86 ( tp_13 vr_19 , int vr_73 , String vr_184 ) {
int vr_185 = vr_184 . length () ;
if ( ( vr_19 . length () - vr_73 ) < vr_185 ) {
return false ;
}
for ( int vr_16 = 0 ; vr_16 < vr_185 ; vr_16 ++ ) {
if ( vr_19 . charAt ( vr_73 + vr_16 ) != vr_184 . charAt ( vr_16 ) ) {
return false ;
}
}
return true ;
}
static boolean fn_78 ( tp_13 vr_19 , int vr_73 , String vr_184 ) {
int vr_185 = vr_184 . length () ;
if ( ( vr_19 . length () - vr_73 ) < vr_185 ) {
return false ;
}
for ( int vr_16 = 0 ; vr_16 < vr_185 ; vr_16 ++ ) {
char vr_186 = vr_19 . charAt ( vr_73 + vr_16 ) ;
char vr_187 = vr_184 . charAt ( vr_16 ) ;
if ( vr_186 != vr_187 ) {
char vr_188 = vr_76 . vr_77 ( vr_186 ) ;
char vr_189 = vr_76 . vr_77 ( vr_187 ) ;
if ( vr_188 != vr_189 && vr_76 . vr_78 ( vr_188 ) != vr_76 . vr_78 ( vr_189 ) ) {
return false ;
}
}
}
return true ;
}
