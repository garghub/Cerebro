public static tp_1 fn_1 ( String vr_1 ) {
try {
tp_2 vr_2 = new tp_2 ( vr_1 ) ;
return vr_2 . fn_1 () ;
} catch ( IllegalArgumentException vr_3 ) {
throw new vr_4 . vr_5 ( vr_3 . vr_6 () ) ;
}
}
tp_1 fn_1 () {
vr_7 . vr_8 () ;
if ( vr_7 . vr_9 ( vl_1 ) ) {
vr_10 . add ( new vr_11 . vr_12 () ) ;
fn_2 ( vr_7 . vr_13 () ) ;
} else {
fn_3 () ;
}
while ( ! vr_7 . isEmpty () ) {
boolean vr_14 = vr_7 . vr_8 () ;
if ( vr_7 . vr_9 ( vl_1 ) ) {
fn_2 ( vr_7 . vr_13 () ) ;
} else if ( vr_14 ) {
fn_2 ( ' ' ) ;
} else {
fn_3 () ;
}
}
if ( vr_10 . size () == 1 )
return vr_10 . get ( 0 ) ;
return new vr_15 . vr_16 ( vr_10 ) ;
}
private void fn_2 ( char fn_2 ) {
vr_7 . vr_8 () ;
String vr_17 = fn_4 () ;
tp_1 vr_18 ;
tp_1 vr_19 ;
tp_1 vr_20 = fn_1 ( vr_17 ) ;
boolean vr_21 = false ;
if ( vr_10 . size () == 1 ) {
vr_18 = vr_19 = vr_10 . get ( 0 ) ;
if ( vr_18 instanceof vr_15 . vr_22 && fn_2 != ',' ) {
vr_19 = ( ( vr_15 . vr_22 ) vr_19 ) . fn_5 () ;
vr_21 = true ;
}
}
else {
vr_18 = vr_19 = new vr_15 . vr_16 ( vr_10 ) ;
}
vr_10 . clear () ;
if ( fn_2 == '>' )
vr_19 = new vr_15 . vr_16 ( vr_20 , new vr_11 . vr_23 ( vr_19 ) ) ;
else if ( fn_2 == ' ' )
vr_19 = new vr_15 . vr_16 ( vr_20 , new vr_11 . vr_24 ( vr_19 ) ) ;
else if ( fn_2 == '+' )
vr_19 = new vr_15 . vr_16 ( vr_20 , new vr_11 . vr_25 ( vr_19 ) ) ;
else if ( fn_2 == '~' )
vr_19 = new vr_15 . vr_16 ( vr_20 , new vr_11 . vr_26 ( vr_19 ) ) ;
else if ( fn_2 == ',' ) {
vr_15 . vr_22 vr_27 ;
if ( vr_19 instanceof vr_15 . vr_22 ) {
vr_27 = ( vr_15 . vr_22 ) vr_19 ;
vr_27 . add ( vr_20 ) ;
} else {
vr_27 = new vr_15 . vr_22 () ;
vr_27 . add ( vr_19 ) ;
vr_27 . add ( vr_20 ) ;
}
vr_19 = vr_27 ;
}
else
throw new vr_4 . vr_5 ( lr_1 + fn_2 ) ;
if ( vr_21 )
( ( vr_15 . vr_22 ) vr_18 ) . fn_6 ( vr_19 ) ;
else vr_18 = vr_19 ;
vr_10 . add ( vr_18 ) ;
}
private String fn_4 () {
StringBuilder vr_28 = vr_29 . vr_30 () ;
while ( ! vr_7 . isEmpty () ) {
if ( vr_7 . vr_31 ( lr_2 ) )
vr_28 . append ( lr_2 ) . append ( vr_7 . vr_32 ( '(' , ')' ) ) . append ( lr_3 ) ;
else if ( vr_7 . vr_31 ( lr_4 ) )
vr_28 . append ( lr_4 ) . append ( vr_7 . vr_32 ( '[' , ']' ) ) . append ( lr_5 ) ;
else if ( vr_7 . vr_9 ( vl_1 ) )
break;
else
vr_28 . append ( vr_7 . vr_13 () ) ;
}
return vr_29 . vr_33 ( vr_28 ) ;
}
private void fn_3 () {
if ( vr_7 . vr_34 ( lr_6 ) )
fn_7 () ;
else if ( vr_7 . vr_34 ( lr_7 ) )
fn_8 () ;
else if ( vr_7 . vr_35 () || vr_7 . vr_31 ( lr_8 ) )
fn_9 () ;
else if ( vr_7 . vr_31 ( lr_4 ) )
fn_10 () ;
else if ( vr_7 . vr_34 ( lr_9 ) )
fn_11 () ;
else if ( vr_7 . vr_34 ( lr_10 ) )
fn_12 () ;
else if ( vr_7 . vr_34 ( lr_11 ) )
fn_13 () ;
else if ( vr_7 . vr_34 ( lr_12 ) )
fn_14 () ;
else if ( vr_7 . vr_31 ( lr_13 ) )
fn_15 () ;
else if ( vr_7 . vr_31 ( lr_14 ) )
contains ( false ) ;
else if ( vr_7 . vr_31 ( lr_15 ) )
contains ( true ) ;
else if ( vr_7 . vr_31 ( lr_16 ) )
fn_16 () ;
else if ( vr_7 . vr_31 ( lr_17 ) )
vr_31 ( false ) ;
else if ( vr_7 . vr_31 ( lr_18 ) )
vr_31 ( true ) ;
else if ( vr_7 . vr_31 ( lr_19 ) )
fn_17 () ;
else if ( vr_7 . vr_34 ( lr_20 ) )
fn_18 ( false , false ) ;
else if ( vr_7 . vr_34 ( lr_21 ) )
fn_18 ( true , false ) ;
else if ( vr_7 . vr_34 ( lr_22 ) )
fn_18 ( false , true ) ;
else if ( vr_7 . vr_34 ( lr_23 ) )
fn_18 ( true , true ) ;
else if ( vr_7 . vr_34 ( lr_24 ) )
vr_10 . add ( new tp_1 . vr_36 () ) ;
else if ( vr_7 . vr_34 ( lr_25 ) )
vr_10 . add ( new tp_1 . vr_37 () ) ;
else if ( vr_7 . vr_34 ( lr_26 ) )
vr_10 . add ( new tp_1 . vr_38 () ) ;
else if ( vr_7 . vr_34 ( lr_27 ) )
vr_10 . add ( new tp_1 . vr_39 () ) ;
else if ( vr_7 . vr_34 ( lr_28 ) )
vr_10 . add ( new tp_1 . vr_40 () ) ;
else if ( vr_7 . vr_34 ( lr_29 ) )
vr_10 . add ( new tp_1 . vr_41 () ) ;
else if ( vr_7 . vr_34 ( lr_30 ) )
vr_10 . add ( new tp_1 . IsEmpty () ) ;
else if ( vr_7 . vr_34 ( lr_31 ) )
vr_10 . add ( new tp_1 . vr_42 () ) ;
else if ( vr_7 . vr_34 ( lr_32 ) )
vr_10 . add ( new tp_1 . vr_43 () ) ;
else
throw new vr_4 . vr_5 ( lr_33 , vr_1 , vr_7 . vr_44 () ) ;
}
private void fn_7 () {
String vr_45 = vr_7 . vr_46 () ;
vr_47 . vr_48 ( vr_45 ) ;
vr_10 . add ( new tp_1 . vr_49 ( vr_45 ) ) ;
}
private void fn_8 () {
String vr_50 = vr_7 . vr_46 () ;
vr_47 . vr_48 ( vr_50 ) ;
vr_10 . add ( new tp_1 . Class ( vr_50 . trim () ) ) ;
}
private void fn_9 () {
String vr_51 = fn_19 ( vr_7 . vr_52 () ) ;
vr_47 . vr_48 ( vr_51 ) ;
if ( vr_51 . vr_53 ( lr_8 ) ) {
vr_10 . add ( new vr_15 . vr_22 ( new tp_1 . vr_54 ( vr_51 ) , new tp_1 . vr_55 ( vr_51 . vr_56 ( lr_8 , lr_34 ) ) ) ) ;
} else {
if ( vr_51 . contains ( lr_35 ) )
vr_51 = vr_51 . vr_56 ( lr_35 , lr_34 ) ;
vr_10 . add ( new tp_1 . vr_54 ( vr_51 ) ) ;
}
}
private void fn_10 () {
tp_3 vr_57 = new tp_3 ( vr_7 . vr_32 ( '[' , ']' ) ) ;
String vr_58 = vr_57 . vr_59 ( vl_2 ) ;
vr_47 . vr_48 ( vr_58 ) ;
vr_57 . vr_8 () ;
if ( vr_57 . isEmpty () ) {
if ( vr_58 . vr_53 ( lr_36 ) )
vr_10 . add ( new tp_1 . vr_60 ( vr_58 . vr_61 ( 1 ) ) ) ;
else
vr_10 . add ( new tp_1 . vr_62 ( vr_58 ) ) ;
} else {
if ( vr_57 . vr_34 ( lr_37 ) )
vr_10 . add ( new tp_1 . vr_63 ( vr_58 , vr_57 . vr_44 () ) ) ;
else if ( vr_57 . vr_34 ( lr_38 ) )
vr_10 . add ( new tp_1 . vr_64 ( vr_58 , vr_57 . vr_44 () ) ) ;
else if ( vr_57 . vr_34 ( lr_39 ) )
vr_10 . add ( new tp_1 . vr_65 ( vr_58 , vr_57 . vr_44 () ) ) ;
else if ( vr_57 . vr_34 ( lr_40 ) )
vr_10 . add ( new tp_1 . vr_66 ( vr_58 , vr_57 . vr_44 () ) ) ;
else if ( vr_57 . vr_34 ( lr_41 ) )
vr_10 . add ( new tp_1 . vr_67 ( vr_58 , vr_57 . vr_44 () ) ) ;
else if ( vr_57 . vr_34 ( lr_42 ) )
vr_10 . add ( new tp_1 . vr_68 ( vr_58 , vr_69 . vr_70 ( vr_57 . vr_44 () ) ) ) ;
else
throw new vr_4 . vr_5 ( lr_43 , vr_1 , vr_57 . vr_44 () ) ;
}
}
private void fn_11 () {
vr_10 . add ( new tp_1 . vr_71 () ) ;
}
private void fn_12 () {
vr_10 . add ( new tp_1 . vr_72 ( fn_20 () ) ) ;
}
private void fn_13 () {
vr_10 . add ( new tp_1 . vr_73 ( fn_20 () ) ) ;
}
private void fn_14 () {
vr_10 . add ( new tp_1 . vr_74 ( fn_20 () ) ) ;
}
private void fn_18 ( boolean vr_75 , boolean vr_76 ) {
String argS = fn_19 ( vr_7 . vr_77 ( lr_3 ) ) ;
tp_4 vr_78 = vr_79 . vr_80 ( argS ) ;
tp_4 vr_81 = vr_82 . vr_80 ( argS ) ;
final int vr_83 , vr_84 ;
if ( lr_44 . equals ( argS ) ) {
vr_83 = 2 ;
vr_84 = 1 ;
} else if ( lr_45 . equals ( argS ) ) {
vr_83 = 2 ;
vr_84 = 0 ;
} else if ( vr_78 . vr_31 () ) {
vr_83 = vr_78 . vr_85 ( 3 ) != null ? Integer . vr_86 ( vr_78 . vr_85 ( 1 ) . fn_21 ( lr_46 , lr_47 ) ) : 1 ;
vr_84 = vr_78 . vr_85 ( 4 ) != null ? Integer . vr_86 ( vr_78 . vr_85 ( 4 ) . fn_21 ( lr_46 , lr_47 ) ) : 0 ;
} else if ( vr_81 . vr_31 () ) {
vr_83 = 0 ;
vr_84 = Integer . vr_86 ( vr_81 . vr_85 () . fn_21 ( lr_46 , lr_47 ) ) ;
} else {
throw new vr_4 . vr_5 ( lr_48 , argS ) ;
}
if ( vr_76 )
if ( vr_75 )
vr_10 . add ( new tp_1 . vr_87 ( vr_83 , vr_84 ) ) ;
else
vr_10 . add ( new tp_1 . vr_88 ( vr_83 , vr_84 ) ) ;
else {
if ( vr_75 )
vr_10 . add ( new tp_1 . vr_89 ( vr_83 , vr_84 ) ) ;
else
vr_10 . add ( new tp_1 . vr_90 ( vr_83 , vr_84 ) ) ;
}
}
private int fn_20 () {
String vr_91 = vr_7 . vr_77 ( lr_3 ) . trim () ;
vr_47 . vr_92 ( vr_29 . vr_93 ( vr_91 ) , lr_49 ) ;
return Integer . vr_86 ( vr_91 ) ;
}
private void fn_15 () {
vr_7 . vr_13 ( lr_50 ) ;
String vr_17 = vr_7 . vr_32 ( '(' , ')' ) ;
vr_47 . vr_48 ( vr_17 , lr_51 ) ;
vr_10 . add ( new vr_11 . vr_94 ( fn_1 ( vr_17 ) ) ) ;
}
private void contains ( boolean vr_95 ) {
vr_7 . vr_13 ( vr_95 ? lr_52 : lr_53 ) ;
String vr_96 = tp_3 . vr_97 ( vr_7 . vr_32 ( '(' , ')' ) ) ;
vr_47 . vr_48 ( vr_96 , lr_54 ) ;
if ( vr_95 )
vr_10 . add ( new tp_1 . vr_98 ( vr_96 ) ) ;
else
vr_10 . add ( new tp_1 . vr_99 ( vr_96 ) ) ;
}
private void fn_16 () {
vr_7 . vr_13 ( lr_55 ) ;
String vr_96 = tp_3 . vr_97 ( vr_7 . vr_32 ( '(' , ')' ) ) ;
vr_47 . vr_48 ( vr_96 , lr_56 ) ;
vr_10 . add ( new tp_1 . vr_100 ( vr_96 ) ) ;
}
private void vr_31 ( boolean vr_95 ) {
vr_7 . vr_13 ( vr_95 ? lr_57 : lr_58 ) ;
String vr_101 = vr_7 . vr_32 ( '(' , ')' ) ;
vr_47 . vr_48 ( vr_101 , lr_59 ) ;
if ( vr_95 )
vr_10 . add ( new tp_1 . vr_102 ( vr_69 . vr_70 ( vr_101 ) ) ) ;
else
vr_10 . add ( new tp_1 . vr_103 ( vr_69 . vr_70 ( vr_101 ) ) ) ;
}
private void fn_17 () {
vr_7 . vr_13 ( lr_60 ) ;
String vr_17 = vr_7 . vr_32 ( '(' , ')' ) ;
vr_47 . vr_48 ( vr_17 , lr_61 ) ;
vr_10 . add ( new vr_11 . vr_104 ( fn_1 ( vr_17 ) ) ) ;
}
