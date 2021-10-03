private static long fn_1 ( long vr_1 , tp_1 vr_2 , tp_1 vr_3 ) {
return vr_3 . vr_4
( vr_2 . vr_5 () . get ( vr_1 ) ,
vr_2 . vr_6 () . get ( vr_1 ) ,
vr_2 . vr_7 () . get ( vr_1 ) ,
vr_2 . vr_8 () . get ( vr_1 ) ) ;
}
private static long fn_2 ( final long vr_1 , tp_1 vr_2 , tp_1 vr_3 ) {
long vr_9 ;
vr_9 = vr_3 . vr_10 () . fn_3 ( 0 , vr_2 . vr_10 () . get ( vr_1 ) ) ;
vr_9 = vr_3 . vr_11 () . fn_3 ( vr_9 , vr_2 . vr_11 () . get ( vr_1 ) ) ;
vr_9 = vr_3 . vr_12 () . fn_3 ( vr_9 , vr_2 . vr_12 () . get ( vr_1 ) ) ;
vr_9 = vr_3 . vr_8 () . fn_3 ( vr_9 , vr_2 . vr_8 () . get ( vr_1 ) ) ;
return vr_9 ;
}
public static tp_2 fn_4 () {
return fn_5 ( vr_13 . vr_14 , vl_1 , 4 ) ;
}
public static tp_2 fn_5 () {
return fn_5 ( vr_13 . vr_15 () , vl_1 , 4 ) ;
}
public static tp_2 fn_5 ( vr_13 vr_16 ) {
return fn_5 ( vr_16 , vl_1 , 4 ) ;
}
public static tp_2 fn_5 (
vr_13 vr_16 ,
tp_3 vr_17 ) {
return fn_5 ( vr_16 , vr_17 , 4 ) ;
}
public static tp_2 fn_5 (
vr_13 vr_16 ,
tp_3 vr_17 ,
int vr_18 ) {
vr_16 = vr_19 . vr_20 ( vr_16 ) ;
tp_4 vr_21 ;
if ( vr_17 == null ) {
vr_21 = vl_1 ;
} else {
vr_21 = vr_17 . vr_22 () ;
tp_5 vr_23 = new tp_5 ( vr_21 . vr_24 () , vr_25 . fn_5 ( vr_16 ) ) ;
if ( vr_23 . vr_26 () <= 0 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
}
tp_6 vr_27 = new tp_6 ( vr_16 , vr_21 , vr_18 ) ;
tp_2 vr_28 = vr_29 . get ( vr_27 ) ;
if ( vr_28 == null ) {
if ( vr_16 == vr_13 . vr_14 ) {
vr_28 = new tp_2
( vr_30 . fn_5 ( vr_16 , vr_18 ) ,
vr_25 . fn_5 ( vr_16 , vr_18 ) ,
vr_21 ) ;
} else {
vr_28 = fn_5 ( vr_13 . vr_14 , vr_21 , vr_18 ) ;
vr_28 = new tp_2
( vr_31 . fn_5 ( vr_28 , vr_16 ) ,
vr_28 . vr_32 ,
vr_28 . vr_33 ,
vr_28 . vr_34 ) ;
}
tp_2 vr_35 = vr_29 . vr_36 ( vr_27 , vr_28 ) ;
if ( vr_35 != null ) {
vr_28 = vr_35 ;
}
}
return vr_28 ;
}
public static tp_2 fn_5 (
vr_13 vr_16 ,
long vr_17 ,
int vr_18 ) {
tp_4 vr_21 ;
if ( vr_17 == vl_1 . vr_24 () ) {
vr_21 = null ;
} else {
vr_21 = new tp_4 ( vr_17 ) ;
}
return fn_5 ( vr_16 , vr_21 , vr_18 ) ;
}
private Object fn_6 () {
return fn_5 ( vr_20 () , vr_34 , fn_7 () ) ;
}
public vr_13 vr_20 () {
tp_1 vr_37 ;
if ( ( vr_37 = fn_8 () ) != null ) {
return vr_37 . vr_20 () ;
}
return vr_13 . vr_14 ;
}
public tp_1 fn_9 () {
return fn_10 ( vr_13 . vr_14 ) ;
}
public tp_1 fn_10 ( vr_13 vr_16 ) {
if ( vr_16 == null ) {
vr_16 = vr_13 . vr_15 () ;
}
if ( vr_16 == vr_20 () ) {
return this ;
}
return fn_5 ( vr_16 , vr_34 , fn_7 () ) ;
}
public long vr_4 ( int vr_5 , int vr_6 , int vr_7 ,
int vr_8 )
throws IllegalArgumentException
{
tp_1 vr_37 ;
if ( ( vr_37 = fn_8 () ) != null ) {
return vr_37 . vr_4 ( vr_5 , vr_6 , vr_7 , vr_8 ) ;
}
long vr_1 = vr_33 . vr_4
( vr_5 , vr_6 , vr_7 , vr_8 ) ;
if ( vr_1 < vl_2 ) {
vr_1 = vr_32 . vr_4
( vr_5 , vr_6 , vr_7 , vr_8 ) ;
if ( vr_1 >= vl_2 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
return vr_1 ;
}
public long vr_4 ( int vr_5 , int vr_6 , int vr_7 ,
int vr_38 , int vr_39 ,
int vr_40 , int vr_41 )
throws IllegalArgumentException
{
tp_1 vr_37 ;
if ( ( vr_37 = fn_8 () ) != null ) {
return vr_37 . vr_4
( vr_5 , vr_6 , vr_7 ,
vr_38 , vr_39 , vr_40 , vr_41 ) ;
}
long vr_1 ;
try {
vr_1 = vr_33 . vr_4
( vr_5 , vr_6 , vr_7 ,
vr_38 , vr_39 , vr_40 , vr_41 ) ;
} catch ( tp_7 vr_42 ) {
if ( vr_6 != 2 || vr_7 != 29 ) {
throw vr_42 ;
}
vr_1 = vr_33 . vr_4
( vr_5 , vr_6 , 28 ,
vr_38 , vr_39 , vr_40 , vr_41 ) ;
if ( vr_1 >= vl_2 ) {
throw vr_42 ;
}
}
if ( vr_1 < vl_2 ) {
vr_1 = vr_32 . vr_4
( vr_5 , vr_6 , vr_7 ,
vr_38 , vr_39 , vr_40 , vr_41 ) ;
if ( vr_1 >= vl_2 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
}
return vr_1 ;
}
public tp_4 fn_11 () {
return vr_34 ;
}
public int fn_7 () {
return vr_33 . fn_7 () ;
}
public boolean equals ( Object vr_43 ) {
if ( this == vr_43 ) {
return true ;
}
if ( vr_43 instanceof tp_2 ) {
tp_2 vr_28 = ( tp_2 ) vr_43 ;
return vl_2 == vr_28 . vl_2 &&
fn_7 () == vr_28 . fn_7 () &&
vr_20 () . equals ( vr_28 . vr_20 () ) ;
}
return false ;
}
public int fn_12 () {
return lr_3 . fn_12 () * 11 + vr_20 () . fn_12 () +
fn_7 () + vr_34 . fn_12 () ;
}
public String toString () {
tp_8 vr_44 = new tp_8 ( 60 ) ;
vr_44 . append ( lr_4 ) ;
vr_44 . append ( '[' ) ;
vr_44 . append ( vr_20 () . fn_13 () ) ;
if ( vl_2 != vl_1 . vr_24 () ) {
vr_44 . append ( lr_5 ) ;
tp_9 vr_45 ;
if ( fn_9 () . fn_14 () . fn_15 ( vl_2 ) == 0 ) {
vr_45 = vr_46 . vr_47 () ;
} else {
vr_45 = vr_46 . vr_48 () ;
}
vr_45 . vr_49 ( fn_9 () ) . fn_16 ( vr_44 , vl_2 ) ;
}
if ( fn_7 () != 4 ) {
vr_44 . append ( lr_6 ) ;
vr_44 . append ( fn_7 () ) ;
}
vr_44 . append ( ']' ) ;
return vr_44 . toString () ;
}
protected void fn_17 ( tp_10 vr_50 ) {
Object [] vr_51 = ( Object [] ) fn_18 () ;
vr_30 vr_52 = ( vr_30 ) vr_51 [ 0 ] ;
vr_25 vr_53 = ( vr_25 ) vr_51 [ 1 ] ;
tp_4 vr_21 = ( tp_4 ) vr_51 [ 2 ] ;
vl_2 = vr_21 . vr_24 () ;
vr_32 = vr_52 ;
vr_33 = vr_53 ;
vr_34 = vr_21 ;
if ( fn_8 () != null ) {
return;
}
if ( vr_52 . fn_7 () != vr_53 . fn_7 () ) {
throw new IllegalArgumentException () ;
}
vl_3 = vl_2 - fn_19 ( vl_2 ) ;
vr_50 . vr_54 ( vr_53 ) ;
if ( vr_53 . vr_8 () . get ( vl_2 ) == 0 ) {
vr_50 . vr_41 = new fn_20 ( vr_52 . vr_41 () , vr_50 . vr_41 , vl_2 ) ;
vr_50 . vr_8 = new fn_20 ( vr_52 . vr_8 () , vr_50 . vr_8 , vl_2 ) ;
vr_50 . vr_40 = new fn_20 ( vr_52 . vr_40 () , vr_50 . vr_40 , vl_2 ) ;
vr_50 . vr_55 = new fn_20 ( vr_52 . vr_55 () , vr_50 . vr_55 , vl_2 ) ;
vr_50 . vr_39 = new fn_20 ( vr_52 . vr_39 () , vr_50 . vr_39 , vl_2 ) ;
vr_50 . vr_56 = new fn_20 ( vr_52 . vr_56 () , vr_50 . vr_56 , vl_2 ) ;
vr_50 . vr_38 = new fn_20 ( vr_52 . vr_38 () , vr_50 . vr_38 , vl_2 ) ;
vr_50 . vr_57 = new fn_20 ( vr_52 . vr_57 () , vr_50 . vr_57 , vl_2 ) ;
vr_50 . vr_58 = new fn_20 ( vr_52 . vr_58 () , vr_50 . vr_58 , vl_2 ) ;
vr_50 . vr_59 = new fn_20 ( vr_52 . vr_59 () ,
vr_50 . vr_59 , vl_2 ) ;
vr_50 . vr_60 = new fn_20 ( vr_52 . vr_60 () , vr_50 . vr_60 , vl_2 ) ;
}
{
vr_50 . vr_61 = new fn_20 ( vr_52 . vr_61 () , vr_50 . vr_61 , vl_2 ) ;
}
{
vr_50 . vr_5 = new fn_21 (
vr_52 . vr_5 () , vr_50 . vr_5 , vl_2 ) ;
vr_50 . vr_62 = vr_50 . vr_5 . vr_63 () ;
vr_50 . vr_64 = new fn_21 (
vr_52 . vr_64 () , vr_50 . vr_64 , vr_50 . vr_62 , vl_2 ) ;
vr_50 . vr_65 = new fn_21 (
vr_52 . vr_65 () , vr_50 . vr_65 , vl_2 ) ;
vr_50 . vr_66 = vr_50 . vr_65 . vr_63 () ;
vr_50 . vr_67 = new fn_21 (
vr_52 . vr_67 () , vr_50 . vr_67 , vr_50 . vr_62 , vr_50 . vr_66 , vl_2 ) ;
vr_50 . vr_6 = new fn_21 (
vr_52 . vr_6 () , vr_50 . vr_6 , null , vr_50 . vr_62 , vl_2 ) ;
vr_50 . vr_68 = vr_50 . vr_6 . vr_63 () ;
vr_50 . vr_10 = new fn_21 (
vr_52 . vr_10 () , vr_50 . vr_10 , null , vl_2 , true ) ;
vr_50 . vr_69 = vr_50 . vr_10 . vr_63 () ;
vr_50 . vr_70 = new fn_21 (
vr_52 . vr_70 () , vr_50 . vr_70 , vr_50 . vr_69 , vr_50 . vr_66 , vl_2 ) ;
}
{
long vr_71 = vr_53 . vr_5 () . fn_22 ( vl_2 ) ;
vr_50 . fn_14 = new fn_20 (
vr_52 . fn_14 () , vr_50 . fn_14 , vr_50 . vr_62 , vr_71 , false ) ;
}
{
long vr_71 = vr_53 . vr_10 () . fn_22 ( vl_2 ) ;
vr_50 . vr_11 = new fn_20 (
vr_52 . vr_11 () , vr_50 . vr_11 , vr_50 . vr_69 , vr_71 , true ) ;
}
{
fn_20 vr_72 = new fn_20
( vr_52 . vr_7 () , vr_50 . vr_7 , vl_2 ) ;
vr_72 . vr_73 = vr_50 . vr_68 ;
vr_50 . vr_7 = vr_72 ;
}
}
long fn_19 ( long vr_1 ) {
return fn_1 ( vr_1 , vr_32 , vr_33 ) ;
}
long fn_23 ( long vr_1 ) {
return fn_1 ( vr_1 , vr_33 , vr_32 ) ;
}
long fn_24 ( long vr_1 ) {
return fn_2 ( vr_1 , vr_32 , vr_33 ) ;
}
long fn_25 ( long vr_1 ) {
return fn_2 ( vr_1 , vr_33 , vr_32 ) ;
}
public boolean fn_26 () {
return false ;
}
public int get ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . get ( vr_1 ) ;
} else {
return vr_75 . get ( vr_1 ) ;
}
}
public String fn_27 ( long vr_1 , tp_11 vr_76 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . fn_27 ( vr_1 , vr_76 ) ;
} else {
return vr_75 . fn_27 ( vr_1 , vr_76 ) ;
}
}
public String fn_27 ( int vr_77 , tp_11 vr_76 ) {
return vr_74 . fn_27 ( vr_77 , vr_76 ) ;
}
public String fn_28 ( long vr_1 , tp_11 vr_76 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . fn_28 ( vr_1 , vr_76 ) ;
} else {
return vr_75 . fn_28 ( vr_1 , vr_76 ) ;
}
}
public String fn_28 ( int vr_77 , tp_11 vr_76 ) {
return vr_74 . fn_28 ( vr_77 , vr_76 ) ;
}
public long add ( long vr_1 , int vr_78 ) {
return vr_74 . add ( vr_1 , vr_78 ) ;
}
public long add ( long vr_1 , long vr_78 ) {
return vr_74 . add ( vr_1 , vr_78 ) ;
}
public int [] add ( tp_12 vr_79 , int vr_80 , int [] vr_81 , int vr_82 ) {
if ( vr_82 == 0 ) {
return vr_81 ;
}
if ( vr_19 . vr_83 ( vr_79 ) ) {
long vr_1 = 0L ;
for ( int vr_84 = 0 , vr_85 = vr_79 . size () ; vr_84 < vr_85 ; vr_84 ++ ) {
vr_1 = vr_79 . vr_86 ( vr_84 ) . fn_29 ( tp_2 . this ) . fn_3 ( vr_1 , vr_81 [ vr_84 ] ) ;
}
vr_1 = add ( vr_1 , vr_82 ) ;
return tp_2 . this . get ( vr_79 , vr_1 ) ;
} else {
return super . add ( vr_79 , vr_80 , vr_81 , vr_82 ) ;
}
}
public int fn_30 ( long vr_87 , long vr_88 ) {
return vr_74 . fn_30 ( vr_87 , vr_88 ) ;
}
public long fn_31 ( long vr_87 , long vr_88 ) {
return vr_74 . fn_31 ( vr_87 , vr_88 ) ;
}
public long fn_3 ( long vr_1 , int vr_78 ) {
if ( vr_1 >= vl_4 ) {
vr_1 = vr_74 . fn_3 ( vr_1 , vr_78 ) ;
if ( vr_1 < vl_4 ) {
if ( vr_1 + vl_3 < vl_4 ) {
vr_1 = fn_32 ( vr_1 ) ;
}
if ( get ( vr_1 ) != vr_78 ) {
throw new tp_7
( vr_74 . getType () , Integer . valueOf ( vr_78 ) , null , null ) ;
}
}
} else {
vr_1 = vr_75 . fn_3 ( vr_1 , vr_78 ) ;
if ( vr_1 >= vl_4 ) {
if ( vr_1 - vl_3 >= vl_4 ) {
vr_1 = fn_33 ( vr_1 ) ;
}
if ( get ( vr_1 ) != vr_78 ) {
throw new tp_7
( vr_75 . getType () , Integer . valueOf ( vr_78 ) , null , null ) ;
}
}
}
return vr_1 ;
}
public long fn_3 ( long vr_1 , String vr_89 , tp_11 vr_76 ) {
if ( vr_1 >= vl_4 ) {
vr_1 = vr_74 . fn_3 ( vr_1 , vr_89 , vr_76 ) ;
if ( vr_1 < vl_4 ) {
if ( vr_1 + vl_3 < vl_4 ) {
vr_1 = fn_32 ( vr_1 ) ;
}
}
} else {
vr_1 = vr_75 . fn_3 ( vr_1 , vr_89 , vr_76 ) ;
if ( vr_1 >= vl_4 ) {
if ( vr_1 - vl_3 >= vl_4 ) {
vr_1 = fn_33 ( vr_1 ) ;
}
}
}
return vr_1 ;
}
public tp_13 vr_63 () {
return vl_5 ;
}
public tp_13 fn_34 () {
return vr_73 ;
}
public boolean fn_35 ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . fn_35 ( vr_1 ) ;
} else {
return vr_75 . fn_35 ( vr_1 ) ;
}
}
public int fn_36 ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . fn_36 ( vr_1 ) ;
} else {
return vr_75 . fn_36 ( vr_1 ) ;
}
}
public tp_13 fn_37 () {
return vr_74 . fn_37 () ;
}
public int fn_38 () {
return vr_75 . fn_38 () ;
}
public int fn_38 ( tp_12 vr_79 ) {
return vr_75 . fn_38 ( vr_79 ) ;
}
public int fn_38 ( tp_12 vr_79 , int [] vr_81 ) {
return vr_75 . fn_38 ( vr_79 , vr_81 ) ;
}
public int fn_38 ( long vr_1 ) {
if ( vr_1 < vl_4 ) {
return vr_75 . fn_38 ( vr_1 ) ;
}
int vr_90 = vr_74 . fn_38 ( vr_1 ) ;
vr_1 = vr_74 . fn_3 ( vr_1 , vr_90 ) ;
if ( vr_1 < vl_4 ) {
vr_90 = vr_74 . get ( vl_4 ) ;
}
return vr_90 ;
}
public int fn_39 () {
return vr_74 . fn_39 () ;
}
public int fn_39 ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . fn_39 ( vr_1 ) ;
}
int vr_91 = vr_75 . fn_39 ( vr_1 ) ;
vr_1 = vr_75 . fn_3 ( vr_1 , vr_91 ) ;
if ( vr_1 >= vl_4 ) {
vr_91 = vr_75 . get ( vr_75 . add ( vl_4 , - 1 ) ) ;
}
return vr_91 ;
}
public int fn_39 ( tp_12 vr_79 ) {
long vr_1 = tp_2 . fn_4 () . fn_3 ( vr_79 , 0L ) ;
return fn_39 ( vr_1 ) ;
}
public int fn_39 ( tp_12 vr_79 , int [] vr_81 ) {
tp_1 vr_28 = tp_2 . fn_4 () ;
long vr_1 = 0L ;
for ( int vr_84 = 0 , vr_85 = vr_79 . size () ; vr_84 < vr_85 ; vr_84 ++ ) {
tp_14 vr_92 = vr_79 . vr_86 ( vr_84 ) . fn_29 ( vr_28 ) ;
if ( vr_81 [ vr_84 ] <= vr_92 . fn_39 ( vr_1 ) ) {
vr_1 = vr_92 . fn_3 ( vr_1 , vr_81 [ vr_84 ] ) ;
}
}
return fn_39 ( vr_1 ) ;
}
public long fn_40 ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
vr_1 = vr_74 . fn_40 ( vr_1 ) ;
if ( vr_1 < vl_4 ) {
if ( vr_1 + vl_3 < vl_4 ) {
vr_1 = fn_32 ( vr_1 ) ;
}
}
} else {
vr_1 = vr_75 . fn_40 ( vr_1 ) ;
}
return vr_1 ;
}
public long fn_22 ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
vr_1 = vr_74 . fn_22 ( vr_1 ) ;
} else {
vr_1 = vr_75 . fn_22 ( vr_1 ) ;
if ( vr_1 >= vl_4 ) {
if ( vr_1 - vl_3 >= vl_4 ) {
vr_1 = fn_33 ( vr_1 ) ;
}
}
}
return vr_1 ;
}
public int fn_41 ( tp_11 vr_76 ) {
return vr_93 . vr_91 ( vr_75 . fn_41 ( vr_76 ) ,
vr_74 . fn_41 ( vr_76 ) ) ;
}
public int fn_42 ( tp_11 vr_76 ) {
return vr_93 . vr_91 ( vr_75 . fn_42 ( vr_76 ) ,
vr_74 . fn_42 ( vr_76 ) ) ;
}
protected long fn_33 ( long vr_1 ) {
if ( vl_6 ) {
return fn_24 ( vr_1 ) ;
} else {
return fn_19 ( vr_1 ) ;
}
}
protected long fn_32 ( long vr_1 ) {
if ( vl_6 ) {
return fn_25 ( vr_1 ) ;
} else {
return fn_23 ( vr_1 ) ;
}
}
public long add ( long vr_1 , int vr_78 ) {
if ( vr_1 >= vl_4 ) {
vr_1 = vr_74 . add ( vr_1 , vr_78 ) ;
if ( vr_1 < vl_4 ) {
if ( vr_1 + vl_3 < vl_4 ) {
if ( vl_6 ) {
int vr_94 = vr_33 . vr_10 () . get ( vr_1 ) ;
if ( vr_94 <= 0 ) {
vr_1 = vr_33 . vr_10 () . add ( vr_1 , - 1 ) ;
}
} else {
int vr_5 = vr_33 . vr_5 () . get ( vr_1 ) ;
if ( vr_5 <= 0 ) {
vr_1 = vr_33 . vr_5 () . add ( vr_1 , - 1 ) ;
}
}
vr_1 = fn_32 ( vr_1 ) ;
}
}
} else {
vr_1 = vr_75 . add ( vr_1 , vr_78 ) ;
if ( vr_1 >= vl_4 ) {
if ( vr_1 - vl_3 >= vl_4 ) {
vr_1 = fn_33 ( vr_1 ) ;
}
}
}
return vr_1 ;
}
public long add ( long vr_1 , long vr_78 ) {
if ( vr_1 >= vl_4 ) {
vr_1 = vr_74 . add ( vr_1 , vr_78 ) ;
if ( vr_1 < vl_4 ) {
if ( vr_1 + vl_3 < vl_4 ) {
if ( vl_6 ) {
int vr_94 = vr_33 . vr_10 () . get ( vr_1 ) ;
if ( vr_94 <= 0 ) {
vr_1 = vr_33 . vr_10 () . add ( vr_1 , - 1 ) ;
}
} else {
int vr_5 = vr_33 . vr_5 () . get ( vr_1 ) ;
if ( vr_5 <= 0 ) {
vr_1 = vr_33 . vr_5 () . add ( vr_1 , - 1 ) ;
}
}
vr_1 = fn_32 ( vr_1 ) ;
}
}
} else {
vr_1 = vr_75 . add ( vr_1 , vr_78 ) ;
if ( vr_1 >= vl_4 ) {
if ( vr_1 - vl_3 >= vl_4 ) {
vr_1 = fn_33 ( vr_1 ) ;
}
}
}
return vr_1 ;
}
public int fn_30 ( long vr_87 , long vr_88 ) {
if ( vr_87 >= vl_4 ) {
if ( vr_88 >= vl_4 ) {
return vr_74 . fn_30 ( vr_87 , vr_88 ) ;
}
vr_87 = fn_32 ( vr_87 ) ;
return vr_75 . fn_30 ( vr_87 , vr_88 ) ;
} else {
if ( vr_88 < vl_4 ) {
return vr_75 . fn_30 ( vr_87 , vr_88 ) ;
}
vr_87 = fn_33 ( vr_87 ) ;
return vr_74 . fn_30 ( vr_87 , vr_88 ) ;
}
}
public long fn_31 ( long vr_87 , long vr_88 ) {
if ( vr_87 >= vl_4 ) {
if ( vr_88 >= vl_4 ) {
return vr_74 . fn_31 ( vr_87 , vr_88 ) ;
}
vr_87 = fn_32 ( vr_87 ) ;
return vr_75 . fn_31 ( vr_87 , vr_88 ) ;
} else {
if ( vr_88 < vl_4 ) {
return vr_75 . fn_31 ( vr_87 , vr_88 ) ;
}
vr_87 = fn_33 ( vr_87 ) ;
return vr_74 . fn_31 ( vr_87 , vr_88 ) ;
}
}
public int fn_38 ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . fn_38 ( vr_1 ) ;
} else {
return vr_75 . fn_38 ( vr_1 ) ;
}
}
public int fn_39 ( long vr_1 ) {
if ( vr_1 >= vl_4 ) {
return vr_74 . fn_39 ( vr_1 ) ;
} else {
return vr_75 . fn_39 ( vr_1 ) ;
}
}
public long add ( long vr_1 , int vr_78 ) {
return vr_95 . add ( vr_1 , vr_78 ) ;
}
public long add ( long vr_1 , long vr_78 ) {
return vr_95 . add ( vr_1 , vr_78 ) ;
}
public int fn_30 ( long vr_87 , long vr_88 ) {
return vr_95 . fn_30 ( vr_87 , vr_88 ) ; MST[PrimitiveReturnsMutator]MSP[N]
}
public long fn_31 ( long vr_87 , long vr_88 ) {
return vr_95 . fn_31 ( vr_87 , vr_88 ) ;
}
