public static void main ( final String [] args ) throws vl_1
{
boolean vr_1 = false , vr_2 = false , error = false , vr_3 = false , vr_4 = false , vr_5 = false ;
boolean vr_6 = false , vr_7 = false , vr_8 = false , vr_9 = false ;
boolean vr_10 = false , vr_11 = false , vr_12 = false , vr_13 = false ;
boolean size = false ;
boolean vr_14 = false ;
long vr_15 = - 1 ;
int vr_16 = - 1 ;
int vr_17 = 5 ;
String vr_18 = null ;
String vr_19 = null ;
String vr_20 = null ;
String vr_21 = null ;
int vr_22 = 80 ;
String vr_23 = null ;
String vr_24 = null ;
String vr_25 = null ;
String vr_26 = null ;
String vr_27 = null ;
String vr_28 = null ;
String vr_29 = null ;
String vr_30 = null ;
String vr_31 = null ;
String vr_32 = null ;
int vr_33 = 0 ;
for ( vr_33 = 0 ; vr_33 < args . length ; vr_33 ++ )
{
if ( args [ vr_33 ] . equals ( lr_1 ) ) {
vr_1 = true ;
}
else if ( args [ vr_33 ] . equals ( lr_2 ) ) {
vr_6 = true ;
}
else if ( args [ vr_33 ] . equals ( lr_3 ) ) {
vr_25 = lr_4 ;
vr_26 = System . getProperty ( lr_5 ) + lr_6 + vr_34 . vr_35 () . fn_1 () ;
}
else if ( args [ vr_33 ] . equals ( lr_7 ) ) {
vr_2 = true ;
}
else if ( args [ vr_33 ] . equals ( lr_8 ) ) {
vr_19 = args [ ++ vr_33 ] ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_9 ) ) {
vr_11 = true ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_10 ) ) {
vr_7 = true ;
}
else if ( args [ vr_33 ] . equals ( lr_11 ) ) {
vr_27 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_12 ) ) { MST[rv.UOI1Mutator]MSP[]
vr_8 = true ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_13 ) ) {
vr_5 = true ;
}
else if ( args [ vr_33 ] . equals ( lr_14 ) ) {
size = true ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_15 ) ) {
vr_15 = Long . vr_36 ( args [ ++ vr_33 ] ) ;
}
else if ( args [ vr_33 ] . equals ( lr_16 ) ) {
vr_3 = true ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_17 ) ) {
vr_12 = true ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_18 ) ) {
vr_14 = true ;
}
else if ( args [ vr_33 ] . equals ( lr_19 ) ) {
vr_4 = true ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_20 ) ) {
vr_18 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_21 ) ) {
vr_30 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_22 ) ) {
vr_10 = true ;
vr_17 = 3 ;
}
else if ( args [ vr_33 ] . equals ( lr_23 ) ) {
vr_13 = true ;
}
else if ( args [ vr_33 ] . equals ( lr_24 ) ) {
vr_16 = Integer . vr_37 ( args [ ++ vr_33 ] ) ;
}
else if ( args [ vr_33 ] . equals ( lr_25 ) ) {
vr_20 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_26 ) ) {
vr_31 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_27 ) ) {
vr_32 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_28 ) ) {
vr_28 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_29 ) ) {
vr_29 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_30 ) ) {
vr_21 = args [ ++ vr_33 ] ;
final String vr_38 [] = vr_21 . vr_39 ( lr_31 ) ;
if ( vr_38 . length == 2 ) {
vr_21 = vr_38 [ 0 ] ;
vr_22 = Integer . vr_37 ( vr_38 [ 1 ] ) ;
}
}
else if ( args [ vr_33 ] . equals ( lr_32 ) ) {
vr_23 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_33 ) ) {
vr_24 = args [ ++ vr_33 ] ;
}
else if ( args [ vr_33 ] . equals ( lr_34 ) ) {
vr_9 = true ;
}
else {
break;
}
}
final int vr_40 = args . length - vr_33 ;
if ( vr_25 != null ) {
vr_17 -= 2 ;
}
if ( vr_40 < vr_17 )
{
if ( args . length > 0 ) {
System . vr_41 . println ( lr_35 + vr_42 . toString ( args ) ) ;
}
System . vr_41 . println ( vl_2 ) ;
System . exit ( 1 ) ;
}
String vr_43 = args [ vr_33 ++ ] ;
int vr_44 = 0 ;
final String vr_38 [] = vr_43 . vr_39 ( lr_31 ) ;
if ( vr_38 . length == 2 ) {
vr_43 = vr_38 [ 0 ] ;
vr_44 = Integer . vr_37 ( vr_38 [ 1 ] ) ;
}
if ( vr_25 == null ) {
vr_25 = args [ vr_33 ++ ] ;
vr_26 = args [ vr_33 ++ ] ;
}
String vr_45 = null ;
if ( args . length - vr_33 > 0 ) {
vr_45 = args [ vr_33 ++ ] ;
}
String vr_46 = null ;
if ( args . length - vr_33 > 0 ) {
vr_46 = args [ vr_33 ++ ] ;
}
final tp_1 vr_47 ;
if ( vr_18 == null ) {
if( vr_21 != null ) {
System . out . println ( lr_36 + vr_21 ) ;
vr_47 = new fn_2 ( vr_21 , vr_22 , vr_23 , vr_24 ) ;
}
else {
vr_47 = new tp_1 () ;
}
} else {
tp_2 vr_48 ;
if ( vr_18 . equals ( lr_37 ) ) {
vr_48 = new tp_2 ( true ) ;
} else if ( vr_18 . equals ( lr_38 ) ) {
vr_48 = new tp_2 ( false ) ;
} else {
final String vr_49 [] = vr_18 . vr_39 ( lr_39 ) ;
if ( vr_49 . length == 1 ) {
vr_48 = new tp_2 ( vr_18 ) ;
} else {
vr_48 = new tp_2 ( vr_49 [ 0 ] , Boolean . vr_50 ( vr_49 [ 1 ] ) ) ;
}
}
vr_47 = vr_48 ;
if ( lr_40 . equals ( vr_20 ) ) {
vr_48 . vr_51 ( vr_52 . vr_53 () ) ;
} else if ( lr_41 . equals ( vr_20 ) ) {
vr_48 . vr_51 ( vr_52 . vr_54 () ) ;
} else if ( lr_42 . equals ( vr_20 ) ) {
vr_48 . vr_51 ( null ) ;
}
}
if ( vr_9 ) {
vr_47 . vr_55 ( fn_3 () ) ;
}
if ( vr_15 >= 0 ) {
vr_47 . vr_56 ( vr_15 ) ;
}
if ( vr_16 >= 0 ) {
vr_47 . vr_57 ( vr_16 ) ;
}
if ( vr_27 != null ) {
vr_47 . vr_58 ( vr_27 ) ;
}
vr_47 . vr_59 ( vr_5 ) ;
vr_47 . vr_60 ( new fn_4 ( new PrintWriter ( System . out ) , true ) ) ;
final tp_3 vr_61 ;
if ( vr_30 != null ) {
vr_61 = new tp_3 ( vr_30 ) ;
} else {
vr_61 = new tp_3 () ;
}
vr_61 . vr_62 ( vr_13 ) ;
if ( vr_31 != null ) {
vr_61 . vr_63 ( vr_31 ) ;
}
if ( vr_32 != null ) {
vr_61 . vr_64 ( vr_32 ) ;
}
vr_47 . vr_65 ( vr_61 ) ;
try
{
int vr_66 ;
if ( vr_44 > 0 ) {
vr_47 . vr_67 ( vr_43 , vr_44 ) ;
} else {
vr_47 . vr_67 ( vr_43 ) ;
}
System . out . println ( lr_43 + vr_43 + lr_44 + ( vr_44 > 0 ? vr_44 : vr_47 . vr_68 () ) ) ;
vr_66 = vr_47 . vr_69 () ;
if ( ! vr_70 . vr_71 ( vr_66 ) )
{
vr_47 . vr_72 () ;
System . vr_41 . println ( lr_45 ) ;
System . exit ( 1 ) ;
}
}
catch ( final IOException vr_73 )
{
if ( vr_47 . vr_74 () )
{
try
{
vr_47 . vr_72 () ;
}
catch ( final IOException vr_75 )
{
}
}
System . vr_41 . println ( lr_46 ) ;
vr_73 . vr_76 () ;
System . exit ( 1 ) ;
}
lb_1:
try
{
if ( ! vr_47 . vr_77 ( vr_25 , vr_26 ) )
{
vr_47 . vr_78 () ;
error = true ;
break lb_1;
}
System . out . println ( lr_47 + vr_47 . vr_79 () ) ;
if ( vr_2 ) {
vr_47 . vr_80 ( vr_81 . vr_82 ) ;
} else {
vr_47 . vr_80 ( vr_81 . vr_83 ) ;
}
if ( vr_6 ) {
vr_47 . vr_84 () ;
} else {
vr_47 . vr_85 () ;
}
vr_47 . vr_86 ( vr_7 ) ;
if ( vr_1 )
{
try ( tp_4 vr_87 = new fn_5 ( vr_46 ) ) {
vr_47 . vr_1 ( vr_45 , vr_87 ) ;
}
if ( vr_15 > 0 ) {
fn_6 ( vr_47 ) ;
}
}
else if ( vr_3 || vr_11 || vr_12 || vr_10 || vr_4 || size )
{
if ( vr_11 ) {
for ( final tp_5 vr_75 : vr_47 . vr_88 ( vr_45 ) ) {
System . out . println ( vr_75 . vr_89 () ) ;
System . out . println ( vr_75 . vr_90 ( vr_29 ) ) ;
}
}
if ( vr_12 ) {
final tp_5 vr_75 = vr_47 . vr_91 ( vr_45 ) ;
if ( vr_75 != null ) {
System . out . println ( vr_75 . vr_89 () ) ;
System . out . println ( vr_75 . vr_90 ( vr_29 ) ) ;
} else {
System . out . println ( lr_48 ) ;
}
}
if ( vr_10 ) {
final tp_5 vr_75 = vr_47 . vr_92 ( vr_45 ) ;
if ( vr_75 != null ) {
System . out . println ( vr_75 . vr_90 ( vr_29 ) ) ;
}
}
if ( vr_4 ) {
for ( final String vr_93 : vr_47 . vr_4 ( vr_45 ) ) {
System . out . println ( vr_93 ) ;
}
}
if ( size ) {
System . out . println ( lr_49 + vr_47 . vr_94 ( vr_45 ) ) ;
}
if ( vr_3 ) {
if ( vr_14 || vr_28 != null ) {
vr_61 . vr_95 ( vr_14 ) ;
if ( vr_28 != null ) {
vr_61 . vr_96 ( vr_28 ) ;
}
vr_47 . vr_65 ( vr_61 ) ;
}
for ( final tp_5 vr_75 : vr_47 . vr_3 ( vr_45 ) ) {
System . out . println ( vr_75 . vr_89 () ) ;
System . out . println ( vr_75 . vr_90 ( vr_29 ) ) ;
}
}
}
else if ( vr_8 )
{
if ( vr_45 != null ) {
if ( vr_47 . vr_97 ( vr_45 ) ) {
System . out . println ( lr_50 + vr_45 ) ;
} else {
if ( vr_70 . vr_71 ( vr_47 . vr_69 () ) ) {
System . out . println ( lr_51 + vr_45 + lr_52 ) ;
} else {
System . out . println ( lr_53 + vr_47 . vr_98 () ) ;
}
}
final String [] vr_99 = vr_47 . vr_100 ( vr_45 ) ;
if ( vr_99 != null ) {
for( final String vr_75 : vr_99 ) {
System . out . println ( lr_51 + vr_45 + lr_54 + vr_75 + lr_55 ) ;
}
} else {
if ( vr_70 . vr_71 ( vr_47 . vr_69 () ) ) {
System . out . println ( lr_51 + vr_45 + lr_56 ) ;
} else {
System . out . println ( lr_53 + vr_47 . vr_98 () ) ;
}
}
} else {
if ( vr_47 . vr_99 () ) {
} else {
System . out . println ( lr_57 + vr_47 . vr_98 () ) ;
}
}
}
else if ( vr_19 != null )
{
if ( vr_47 . vr_19 ( vr_19 , vr_45 ) ) {
} else {
System . out . println ( lr_57 + vr_47 . vr_98 () ) ;
}
}
else
{
try ( tp_6 vr_101 = new fn_7 ( vr_46 ) ) {
vr_47 . vr_102 ( vr_45 , vr_101 ) ;
}
if ( vr_15 > 0 ) {
fn_6 ( vr_47 ) ;
}
}
vr_47 . vr_103 () ;
vr_47 . vr_78 () ;
}
catch ( final tp_7 vr_73 )
{
error = true ;
System . vr_41 . println ( lr_58 ) ;
vr_73 . vr_76 () ;
}
catch ( final IOException vr_73 )
{
error = true ;
vr_73 . vr_76 () ;
}
finally
{
if ( vr_47 . vr_74 () )
{
try
{
vr_47 . vr_72 () ;
}
catch ( final IOException vr_75 )
{
}
}
}
System . exit ( error ? 1 : 0 ) ;
}
private static void fn_6 ( final tp_1 vr_47 ) {
@SuppressWarnings ( lr_59 )
final
int [] vr_104 = vr_47 . vr_105 () ;
System . out . println ( lr_60 + vr_42 . toString ( vr_104 ) ) ;
}
@Override
public void fn_8 ( final tp_8 vr_106 ) {
fn_8 ( vr_106 . vr_107 () , vr_106 . vr_108 () , vr_106 . vr_109 () ) ;
}
@Override
public void fn_8 ( final long vr_110 ,
final int fn_8 , final long vr_111 ) {
final long vr_112 = vr_110 / 1000000 ;
for ( long vr_113 = vl_3 ; vr_113 < vr_112 ; vr_113 ++ ) {
System . vr_41 . vr_114 ( lr_61 ) ;
}
vl_3 = vr_112 ;
}
