tp_1 fn_1 () {
return tp_1 . vr_1 ;
}
@Override
protected void fn_2 ( tp_2 vr_2 , String vr_3 , tp_3 vr_4 ) {
super . fn_2 ( vr_2 , vr_3 , vr_4 ) ;
vl_1 = vr_5 . vr_6 ;
vl_2 = null ;
vl_3 = false ;
vl_4 = null ;
vl_5 = null ;
vl_6 = null ;
vl_7 = new ArrayList <> () ;
vl_8 = new ArrayList <> () ;
vl_9 = new vr_7 . vr_8 () ;
vl_10 = true ;
vl_11 = false ;
vl_12 = false ;
}
List < vt_1 > fn_3 ( String vr_9 , tp_4 vr_10 , String vr_3 , tp_3 vr_4 ) {
vl_1 = vr_5 . vr_6 ;
fn_2 ( new fn_4 ( vr_9 ) , vr_3 , vr_4 ) ;
vl_6 = vr_10 ;
vl_12 = true ;
tp_4 vr_11 = null ;
if ( vr_10 != null ) {
if ( vr_10 . vr_12 () != null )
vr_13 . vr_14 ( vr_10 . vr_12 () . vr_14 () ) ;
String vr_15 = vr_10 . vr_16 () ;
if ( vr_17 . vr_18 ( vr_15 , lr_1 , lr_2 ) )
vr_19 . vr_20 ( vr_21 . vr_22 ) ;
else if ( vr_17 . vr_18 ( vr_15 , lr_3 , lr_4 , lr_5 , lr_6 , lr_7 ) )
vr_19 . vr_20 ( vr_21 . vr_23 ) ;
else if ( vr_15 . equals ( lr_8 ) )
vr_19 . vr_20 ( vr_21 . vr_24 ) ;
else if ( vr_15 . equals ( ( lr_9 ) ) )
vr_19 . vr_20 ( vr_21 . vr_25 ) ;
else if ( vr_15 . equals ( lr_10 ) )
vr_19 . vr_20 ( vr_21 . vr_25 ) ;
else
vr_19 . vr_20 ( vr_21 . vr_25 ) ;
vr_11 = new tp_4 ( vr_26 . valueOf ( lr_11 , vl_13 ) , vr_3 ) ;
vr_13 . vr_27 ( vr_11 ) ;
vr_28 . add ( vr_11 ) ;
fn_5 () ;
tp_5 vr_29 = vr_10 . vr_30 () ;
vr_29 . add ( 0 , vr_10 ) ;
for ( tp_4 vr_31 : vr_29 ) {
if ( vr_31 instanceof vl_14 ) {
vl_5 = ( vl_14 ) vr_31 ;
break;
}
}
}
fn_6 () ;
if ( vr_10 != null )
return vr_11 . vr_32 () ;
else
return vr_13 . vr_32 () ;
}
@Override
protected boolean fn_7 ( vr_7 vr_33 ) {
vl_15 = vr_33 ;
return this . vl_1 . fn_7 ( vr_33 , this ) ;
}
boolean fn_7 ( vr_7 vr_33 , vr_5 vl_1 ) {
vl_15 = vr_33 ;
return vl_1 . fn_7 ( vr_33 , this ) ;
}
void vr_20 ( vr_5 vl_1 ) {
this . vl_1 = vl_1 ;
}
vr_5 vl_1 () {
return vl_1 ;
}
void fn_8 () {
vl_2 = vl_1 ;
}
vr_5 vl_2 () {
return vl_2 ;
}
void vl_10 ( boolean vl_10 ) {
this . vl_10 = vl_10 ;
}
boolean vl_10 () {
return vl_10 ;
}
tp_6 fn_9 () {
return vr_13 ;
}
String fn_10 () {
return vr_3 ;
}
void fn_11 ( tp_4 vr_34 ) {
if ( vl_3 )
return;
String vr_35 = vr_34 . vr_36 ( lr_12 ) ;
if ( vr_35 . length () != 0 ) {
vr_3 = vr_35 ;
vl_3 = true ;
vr_13 . vr_37 ( vr_35 ) ;
}
}
boolean fn_12 () {
return vl_12 ;
}
void error ( vr_5 vl_1 ) {
if ( vr_4 . vr_38 () . fn_13 () )
vr_4 . vr_38 () . add ( new fn_14 ( vr_39 . vr_40 () , lr_13 , vl_15 . vr_41 () , vl_1 ) ) ;
}
tp_4 fn_15 ( final vr_7 . vr_42 vr_43 ) {
if ( vr_43 . vr_44 != null && ! vr_43 . vr_44 . isEmpty () ) {
int vr_45 = vr_43 . vr_44 . vr_46 ( vl_13 ) ;
if ( vr_45 > 0 ) {
error ( lr_14 ) ;
}
}
if ( vr_43 . vr_47 () ) {
tp_4 vr_48 = fn_16 ( vr_43 ) ;
vr_28 . add ( vr_48 ) ;
vr_19 . vr_20 ( vr_21 . vr_25 ) ;
vr_19 . vr_49 ( vl_9 . vr_50 () . fn_17 ( vr_48 . vr_16 () ) ) ;
return vr_48 ;
}
tp_4 vr_48 = new tp_4 ( vr_26 . valueOf ( vr_43 . fn_17 () , vl_13 ) , null , vl_13 . vr_51 ( vr_43 . vr_44 ) ) ;
fn_15 ( vr_48 ) ;
return vr_48 ;
}
tp_4 fn_18 ( String vr_52 ) {
tp_4 vr_48 = new tp_4 ( vr_26 . valueOf ( vr_52 , vl_13 ) , null ) ;
fn_15 ( vr_48 ) ;
return vr_48 ;
}
void fn_15 ( tp_4 vr_48 ) {
fn_19 ( vr_48 ) ;
vr_28 . add ( vr_48 ) ;
}
tp_4 fn_16 ( vr_7 . vr_42 vr_43 ) {
vr_26 vr_53 = vr_26 . valueOf ( vr_43 . fn_17 () , vl_13 ) ;
tp_4 vr_48 = new tp_4 ( vr_53 , null , vr_43 . vr_44 ) ;
fn_19 ( vr_48 ) ;
if ( vr_43 . vr_47 () ) {
if ( vr_53 . vr_54 () ) {
if ( ! vr_53 . isEmpty () )
vr_19 . error ( lr_15 ) ;
}
else
vr_53 . vr_55 () ;
}
return vr_48 ;
}
vl_14 fn_20 ( vr_7 . vr_42 vr_43 , boolean vr_56 ) {
vr_26 vr_53 = vr_26 . valueOf ( vr_43 . fn_17 () , vl_13 ) ;
vl_14 vr_48 = new vl_14 ( vr_53 , null , vr_43 . vr_44 ) ;
fn_21 ( vr_48 ) ;
fn_19 ( vr_48 ) ;
if ( vr_56 )
vr_28 . add ( vr_48 ) ;
return vr_48 ;
}
void fn_15 ( vr_7 . vr_57 vr_58 ) {
vr_57 vr_59 = new vr_57 ( vr_58 . vr_60 () ) ;
fn_19 ( vr_59 ) ;
}
void fn_15 ( vr_7 . vr_61 vr_62 ) {
final vt_1 vr_63 ;
final tp_4 vr_48 = fn_22 () ;
final String vr_16 = vr_48 . vr_16 () ;
final String vr_64 = vr_62 . vr_60 () ;
if ( vr_62 . vr_65 () )
vr_63 = new fn_23 ( vr_64 ) ;
else if ( vr_16 . equals ( lr_8 ) || vr_16 . equals ( lr_6 ) )
vr_63 = new fn_24 ( vr_64 ) ;
else
vr_63 = new fn_25 ( vr_64 ) ;
vr_48 . vr_27 ( vr_63 ) ;
}
private void fn_19 ( vt_1 vr_63 ) {
if ( vr_28 . isEmpty () )
vr_13 . vr_27 ( vr_63 ) ;
else if ( fn_26 () )
fn_27 ( vr_63 ) ;
else
fn_22 () . vr_27 ( vr_63 ) ;
if ( vr_63 instanceof tp_4 && ( ( tp_4 ) vr_63 ) . vr_53 () . fn_28 () ) {
if ( vl_5 != null )
vl_5 . vr_66 ( ( tp_4 ) vr_63 ) ;
}
}
tp_4 fn_29 () {
int size = vr_28 . size () ;
return vr_28 . remove ( size - 1 ) ;
}
void fn_30 ( tp_4 vr_67 ) {
vr_28 . add ( vr_67 ) ;
}
ArrayList < tp_4 > fn_31 () {
return vr_28 ;
}
boolean vr_56 ( tp_4 vr_48 ) {
return fn_32 ( vr_28 , vr_48 ) ;
}
private boolean fn_32 ( ArrayList < tp_4 > vr_68 , tp_4 vr_67 ) {
for ( int vr_40 = vr_68 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_68 . get ( vr_40 ) ;
if ( vr_69 == vr_67 ) {
return true ;
}
}
return false ;
}
tp_4 fn_33 ( String vr_70 ) {
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_28 . get ( vr_40 ) ;
if ( vr_69 . vr_71 () . equals ( vr_70 ) ) {
return vr_69 ;
}
}
return null ;
}
boolean fn_34 ( tp_4 vr_48 ) {
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_28 . get ( vr_40 ) ;
if ( vr_69 == vr_48 ) {
vr_28 . remove ( vr_40 ) ;
return true ;
}
}
return false ;
}
void fn_35 ( String vr_70 ) {
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_28 . get ( vr_40 ) ;
vr_28 . remove ( vr_40 ) ;
if ( vr_69 . vr_71 () . equals ( vr_70 ) )
break;
}
}
void fn_35 ( String ... vr_72 ) {
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_28 . get ( vr_40 ) ;
vr_28 . remove ( vr_40 ) ;
if ( fn_36 ( vr_69 . vr_71 () , vr_72 ) )
break;
}
}
void fn_37 ( String vr_70 ) {
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_28 . get ( vr_40 ) ;
if ( vr_69 . vr_71 () . equals ( vr_70 ) ) {
break;
} else {
vr_28 . remove ( vr_40 ) ;
}
}
}
void fn_38 () {
fn_39 ( lr_16 ) ;
}
void fn_40 () {
fn_39 ( lr_17 , lr_18 , lr_19 , lr_20 ) ;
}
void fn_41 () {
fn_39 ( lr_21 , lr_20 ) ;
}
private void fn_39 ( String ... vr_73 ) {
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_28 . get ( vr_40 ) ;
if ( vr_17 . vr_18 ( vr_69 . vr_71 () , vr_73 ) || vr_69 . vr_71 () . equals ( lr_11 ) )
break;
else
vr_28 . remove ( vr_40 ) ;
}
}
tp_4 fn_42 ( tp_4 vr_48 ) {
assert vr_56 ( vr_48 ) ;
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vr_28 . get ( vr_40 ) ;
if ( vr_69 == vr_48 ) {
return vr_28 . get ( vr_40 - 1 ) ;
}
}
return null ;
}
void fn_43 ( tp_4 vr_74 , tp_4 vr_18 ) {
int vr_75 = vr_28 . vr_76 ( vr_74 ) ;
vr_77 . vr_78 ( vr_75 != - 1 ) ;
vr_28 . add ( vr_75 + 1 , vr_18 ) ;
}
void fn_44 ( tp_4 out , tp_4 vr_18 ) {
fn_45 ( vr_28 , out , vr_18 ) ;
}
private void fn_45 ( ArrayList < tp_4 > vr_68 , tp_4 out , tp_4 vr_18 ) {
int vr_75 = vr_68 . vr_76 ( out ) ;
vr_77 . vr_78 ( vr_75 != - 1 ) ;
vr_68 . vr_79 ( vr_75 , vr_18 ) ;
}
void fn_5 () {
boolean vr_80 = false ;
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_63 = vr_28 . get ( vr_40 ) ;
if ( vr_40 == 0 ) {
vr_80 = true ;
vr_63 = vl_6 ;
}
String fn_17 = vr_63 . vr_71 () ;
if ( lr_22 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_81 ) ;
break;
} else if ( ( lr_23 . equals ( fn_17 ) || lr_24 . equals ( fn_17 ) && ! vr_80 ) ) {
vr_20 ( vr_5 . vr_82 ) ;
break;
} else if ( lr_21 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_83 ) ;
break;
} else if ( lr_17 . equals ( fn_17 ) || lr_19 . equals ( fn_17 ) || lr_18 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_84 ) ;
break;
} else if ( lr_25 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_85 ) ;
break;
} else if ( lr_26 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_86 ) ;
break;
} else if ( lr_16 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_87 ) ;
break;
} else if ( lr_27 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_88 ) ;
break;
} else if ( lr_28 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_88 ) ;
break;
} else if ( lr_29 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_89 ) ;
break;
} else if ( lr_11 . equals ( fn_17 ) ) {
vr_20 ( vr_5 . vr_90 ) ;
break;
} else if ( vr_80 ) {
vr_20 ( vr_5 . vr_88 ) ;
break;
}
}
}
private boolean fn_46 ( String vr_91 , String [] vr_92 , String [] vr_93 ) {
vr_94 [ 0 ] = vr_91 ;
return fn_46 ( vr_94 , vr_92 , vr_93 ) ;
}
private boolean fn_46 ( String [] vr_95 , String [] vr_92 , String [] vr_93 ) {
final int vr_96 = vr_28 . size () - 1 ;
final int vr_97 = vr_96 > vl_16 ? vr_96 - vl_16 : 0 ;
for ( int vr_40 = vr_96 ; vr_40 >= vr_97 ; vr_40 -- ) {
final String vr_70 = vr_28 . get ( vr_40 ) . vr_71 () ;
if ( fn_36 ( vr_70 , vr_95 ) )
return true ;
if ( fn_36 ( vr_70 , vr_92 ) )
return false ;
if ( vr_93 != null && fn_36 ( vr_70 , vr_93 ) )
return false ;
}
return false ;
}
boolean fn_47 ( String [] vr_95 ) {
return fn_46 ( vr_95 , vl_17 , null ) ;
}
boolean fn_47 ( String vr_91 ) {
return fn_47 ( vr_91 , null ) ;
}
boolean fn_47 ( String vr_91 , String [] vr_98 ) {
return fn_46 ( vr_91 , vl_17 , vr_98 ) ;
}
boolean fn_48 ( String vr_91 ) {
return fn_47 ( vr_91 , vl_18 ) ;
}
boolean fn_49 ( String vr_91 ) {
return fn_47 ( vr_91 , vl_19 ) ;
}
boolean fn_50 ( String vr_91 ) {
return fn_46 ( vr_91 , vl_20 , null ) ;
}
boolean fn_51 ( String vr_91 ) {
for ( int vr_40 = vr_28 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_48 = vr_28 . get ( vr_40 ) ;
String vr_70 = vr_48 . vr_71 () ;
if ( vr_70 . equals ( vr_91 ) )
return true ;
if ( ! fn_36 ( vr_70 , vl_21 ) )
return false ;
}
vr_77 . vr_99 ( lr_30 ) ;
return false ;
}
void fn_52 ( tp_4 vl_4 ) {
this . vl_4 = vl_4 ;
}
tp_4 fn_53 () {
return vl_4 ;
}
boolean fn_26 () {
return vl_11 ;
}
void fn_54 ( boolean vl_11 ) {
this . vl_11 = vl_11 ;
}
vl_14 fn_55 () {
return vl_5 ;
}
void fn_21 ( vl_14 vl_5 ) {
this . vl_5 = vl_5 ;
}
void fn_56 () {
vl_8 = new ArrayList <> () ;
}
List < String > fn_57 () {
return vl_8 ;
}
void fn_58 ( String vr_100 ) {
while ( ( vr_100 != null && ! fn_22 () . vr_71 () . equals ( vr_100 ) ) &&
fn_36 ( fn_22 () . vr_71 () , vl_22 ) )
fn_29 () ;
}
void fn_58 () {
fn_58 ( null ) ;
}
boolean fn_59 ( tp_4 vr_48 ) {
String fn_17 = vr_48 . vr_71 () ;
return fn_36 ( fn_17 , vl_23 ) ;
}
tp_4 fn_60 () {
return vl_7 . size () > 0 ? vl_7 . get ( vl_7 . size () - 1 ) : null ;
}
tp_4 fn_61 () {
int size = vl_7 . size () ;
if ( size > 0 )
return vl_7 . remove ( size - 1 ) ;
else
return null ;
}
void fn_62 ( tp_4 vr_18 ) {
int vr_101 = 0 ;
for ( int vr_40 = vl_7 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_48 = vl_7 . get ( vr_40 ) ;
if ( vr_48 == null )
break;
if ( fn_63 ( vr_18 , vr_48 ) )
vr_101 ++ ;
if ( vr_101 == 3 ) {
vl_7 . remove ( vr_40 ) ;
break;
}
}
vl_7 . add ( vr_18 ) ;
}
private boolean fn_63 ( tp_4 vr_102 , tp_4 vr_103 ) {
return vr_102 . vr_71 () . equals ( vr_103 . vr_71 () ) &&
vr_102 . vr_44 () . equals ( vr_103 . vr_44 () ) ;
}
void fn_64 () {
tp_4 vr_80 = fn_60 () ;
if ( vr_80 == null || vr_56 ( vr_80 ) )
return;
tp_4 vr_104 = vr_80 ;
int size = vl_7 . size () ;
int vr_40 = size - 1 ;
boolean vr_105 = false ;
while ( true ) {
if ( vr_40 == 0 ) {
vr_105 = true ;
break;
}
vr_104 = vl_7 . get ( -- vr_40 ) ;
if ( vr_104 == null || vr_56 ( vr_104 ) )
break;
}
while( true ) {
if ( ! vr_105 )
vr_104 = vl_7 . get ( ++ vr_40 ) ;
vr_77 . vr_106 ( vr_104 ) ;
vr_105 = false ;
tp_4 vr_107 = fn_18 ( vr_104 . vr_71 () ) ;
vr_107 . vr_44 () . fn_65 ( vr_104 . vr_44 () ) ;
vl_7 . vr_79 ( vr_40 , vr_107 ) ;
if ( vr_40 == size - 1 )
break;
}
}
void fn_66 () {
while ( ! vl_7 . isEmpty () ) {
tp_4 vr_48 = fn_61 () ;
if ( vr_48 == null )
break;
}
}
void fn_67 ( tp_4 vr_48 ) {
for ( int vr_40 = vl_7 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vl_7 . get ( vr_40 ) ;
if ( vr_69 == vr_48 ) {
vl_7 . remove ( vr_40 ) ;
break;
}
}
}
boolean fn_68 ( tp_4 vr_48 ) {
return fn_32 ( vl_7 , vr_48 ) ;
}
tp_4 fn_69 ( String vr_108 ) {
for ( int vr_40 = vl_7 . size () - 1 ; vr_40 >= 0 ; vr_40 -- ) {
tp_4 vr_69 = vl_7 . get ( vr_40 ) ;
if ( vr_69 == null )
break;
else if ( vr_69 . vr_71 () . equals ( vr_108 ) )
return vr_69 ;
}
return null ;
}
void fn_70 ( tp_4 out , tp_4 vr_18 ) {
fn_45 ( vl_7 , out , vr_18 ) ;
}
void fn_71 () {
vl_7 . add ( null ) ;
}
void fn_27 ( vt_1 vr_18 ) {
tp_4 vr_109 ;
tp_4 vr_110 = fn_33 ( lr_16 ) ;
boolean vr_111 = false ;
if ( vr_110 != null ) {
if ( vr_110 . vr_31 () != null ) {
vr_109 = vr_110 . vr_31 () ;
vr_111 = true ;
} else
vr_109 = fn_42 ( vr_110 ) ;
} else {
vr_109 = vr_28 . get ( 0 ) ;
}
if ( vr_111 ) {
vr_77 . vr_106 ( vr_110 ) ;
vr_110 . vr_112 ( vr_18 ) ;
}
else
vr_109 . vr_27 ( vr_18 ) ;
}
@Override
public String toString () {
return lr_31 +
lr_32 + vl_15 +
lr_33 + vl_1 +
lr_34 + fn_22 () +
'}' ;
}
