public static tp_1 fn_1 ( final vr_1 . vr_2 vr_3 ) {
return new tp_1 ( new vr_4 . vr_5 ( lr_1 , vr_3 ) ) ;
}
public void append ( final tp_2 vr_6 ) {
for ( final vr_4 . vr_5 vr_7 : this . vr_8 ) {
vr_7 . append ( vr_6 ) ;
}
}
public void fn_2 ( final vr_4 . vr_9 vr_10 , final int vr_11 ) {
final vr_12 < vr_4 . vr_5 > vr_13 = new vr_14 <> ( vr_11 ) ;
lb_1: for ( final vr_4 . vr_5 vr_15 : this . vr_8 ) {
for ( final vr_4 . vr_5 vr_16 : vr_10 . vr_17 () ) {
final vr_2 vr_3 = vr_15 . vr_18 () . fn_3 ( vr_16 . vr_18 () ) ;
if ( ! vr_3 . isEmpty () ) {
final vr_4 . vr_5 vr_19 = new vr_5 ( vr_15 , vr_16 , vr_3 ) ;
if ( vr_13 . size () < vr_11 ) {
vr_13 . add ( vr_19 ) ;
if ( vr_13 . size () >= vr_11 ) {
break lb_1;
}
}
}
}
}
this . vr_8 . clear () ;
this . vr_8 . vr_20 ( vr_13 ) ;
}
public vr_12 < vr_4 . vr_5 > vr_17 () {
return this . vr_8 ;
}
public String fn_4 () {
final StringBuilder vr_21 = new StringBuilder () ;
for ( final vr_4 . vr_5 vr_7 : this . vr_8 ) {
if ( vr_21 . length () > 0 ) {
vr_21 . append ( lr_2 ) ;
}
vr_21 . append ( vr_7 . vr_22 () ) ;
}
return vr_21 . toString () ;
}
public int fn_5 () {
return this . vr_23 ;
}
public tp_1 fn_6 () {
return this . vr_24 ;
}
public tp_3 fn_7 () {
this . vr_25 = false ;
int vr_26 = 1 ;
final List < vr_4 > vr_27 = this . vr_28 . get ( vr_29 . vr_30 ( vr_23 , vr_23 + vr_26 ) ) ;
if ( vr_27 != null ) {
for ( final vr_4 vr_31 : vr_27 ) {
final String vr_32 = vr_31 . vr_33 () ;
vr_26 = vr_32 . length () ;
if ( vr_31 . vr_34 ( this . vr_29 , this . vr_23 ) ) {
this . vr_24 . fn_2 ( vr_31 . vr_35 () , vr_11 ) ;
this . vr_25 = true ;
break;
}
}
}
if ( ! this . vr_25 ) {
vr_26 = 1 ;
}
this . vr_23 += vr_26 ;
return this ;
}
public boolean fn_8 () {
return this . vr_25 ;
}
private static String vr_19 ( final vr_36 < String > vr_37 , final String vr_38 ) {
final StringBuilder vr_21 = new StringBuilder () ;
final Iterator < String > vr_39 = vr_37 . iterator () ;
if ( vr_39 . hasNext () ) {
vr_21 . append ( vr_39 . vr_40 () ) ;
}
while ( vr_39 . hasNext () ) {
vr_21 . append ( vr_38 ) . append ( vr_39 . vr_40 () ) ;
}
return vr_21 . toString () ;
}
private tp_1 fn_9 ( final tp_1 vr_24 ,
final vr_41 < String , List < vr_4 > > vr_28 ) {
vr_42 . vr_43 ( vr_28 , lr_3 ) ;
if ( vr_28 . isEmpty () ) {
return vr_24 ;
}
final vr_41 < vr_4 . vr_5 , vr_4 . vr_5 > vr_8 =
new vr_44 <> ( vr_4 . vr_5 . vr_45 ) ;
for ( final vr_4 . vr_5 vr_46 : vr_24 . vr_17 () ) {
tp_1 vr_47 = tp_1 . fn_1 ( vr_46 . vr_18 () ) ;
final String vr_48 = vr_46 . vr_22 () . toString () ;
for ( int vr_23 = 0 ; vr_23 < vr_48 . length () ; ) {
final tp_3 vr_49 =
new tp_3 ( vr_28 , vr_48 , vr_47 , vr_23 , vr_11 ) . fn_7 () ;
final boolean vr_25 = vr_49 . fn_8 () ;
vr_47 = vr_49 . fn_6 () ;
if ( ! vr_25 ) {
vr_47 . append ( vr_48 . vr_30 ( vr_23 , vr_23 + 1 ) ) ;
}
vr_23 = vr_49 . fn_5 () ;
}
for ( final vr_4 . vr_5 vr_50 : vr_47 . vr_17 () ) {
if ( vr_8 . vr_51 ( vr_50 ) ) {
final vr_4 . vr_5 vr_52 = vr_8 . remove ( vr_50 ) ;
final vr_4 . vr_5 vr_53 = vr_52 . vr_54 ( vr_50 . vr_18 () ) ;
vr_8 . vr_55 ( vr_53 , vr_53 ) ;
} else {
vr_8 . vr_55 ( vr_50 , vr_50 ) ;
}
}
}
return new tp_1 ( vr_8 . vr_56 () ) ;
}
public String fn_10 ( final String vr_29 ) {
final vr_1 . vr_2 vr_57 = this . vr_58 . vr_59 ( vr_29 ) ;
return fn_10 ( vr_29 , vr_57 ) ;
}
public String fn_10 ( String vr_29 , final vr_1 . vr_2 vr_57 ) {
final vr_41 < String , List < vr_4 > > vr_27 = vr_4 . vr_60 ( this . vr_61 , vr_62 . vr_63 , vr_57 ) ;
final vr_41 < String , List < vr_4 > > vr_64 = vr_4 . vr_60 ( this . vr_61 , this . vr_65 , lr_4 ) ;
final vr_41 < String , List < vr_4 > > vr_66 = vr_4 . vr_60 ( this . vr_61 , this . vr_65 , vr_57 ) ;
vr_29 = vr_29 . vr_67 ( vr_68 . vr_69 ) . fn_11 ( '-' , ' ' ) . trim () ;
if ( this . vr_61 == vr_70 . vr_71 ) {
if ( vr_29 . length () >= 2 && vr_29 . vr_72 ( 0 , 2 ) . equals ( lr_5 ) ) {
final String vr_73 = vr_29 . vr_72 ( 2 ) ;
final String vr_74 = lr_6 + vr_73 ;
return lr_7 + fn_10 ( vr_73 ) + lr_8 + fn_10 ( vr_74 ) + lr_9 ;
}
for ( final String vr_75 : vr_76 . get ( this . vr_61 ) ) {
if ( vr_29 . vr_77 ( vr_75 + lr_10 ) ) {
final String vr_73 = vr_29 . vr_72 ( vr_75 . length () + 1 ) ;
final String vr_74 = vr_75 + vr_73 ;
return lr_7 + fn_10 ( vr_73 ) + lr_8 + fn_10 ( vr_74 ) + lr_9 ;
}
}
}
final List < String > vr_78 = vr_79 . vr_80 ( vr_29 . vr_81 ( lr_11 ) ) ;
final List < String > vr_82 = new ArrayList <> () ;
switch ( this . vr_61 ) {
case vl_1 :
for ( final String vr_83 : vr_78 ) {
final String [] vr_84 = vr_83 . vr_81 ( lr_12 ) ;
final String vr_85 = vr_84 [ vr_84 . length - 1 ] ; MST[rv.AOR2Mutator]MSP[S]
vr_82 . add ( vr_85 ) ;
}
vr_82 . vr_86 ( vr_76 . get ( this . vr_61 ) ) ;
break;
case vl_2 :
vr_82 . vr_20 ( vr_78 ) ;
vr_82 . vr_86 ( vr_76 . get ( this . vr_61 ) ) ;
break;
case vr_71 :
vr_82 . vr_20 ( vr_78 ) ;
break;
default:
throw new fn_12 ( lr_13 + this . vr_61 ) ;
}
if ( this . vr_87 ) {
vr_29 = vr_19 ( vr_82 , lr_10 ) ;
} else if ( vr_82 . size () == 1 ) {
vr_29 = vr_78 . iterator () . vr_40 () ;
} else {
final StringBuilder vr_88 = new StringBuilder () ;
for ( final String vr_89 : vr_82 ) {
vr_88 . append ( lr_14 ) . append ( fn_10 ( vr_89 ) ) ;
}
return vr_88 . vr_72 ( 1 ) ;
}
tp_1 vr_24 = tp_1 . fn_1 ( vr_57 ) ;
for ( int vr_23 = 0 ; vr_23 < vr_29 . length () ; ) {
final tp_3 vr_49 =
new tp_3 ( vr_27 , vr_29 , vr_24 , vr_23 , vr_11 ) . fn_7 () ;
vr_23 = vr_49 . fn_5 () ;
vr_24 = vr_49 . fn_6 () ;
}
vr_24 = fn_9 ( vr_24 , vr_64 ) ;
vr_24 = fn_9 ( vr_24 , vr_66 ) ;
return vr_24 . fn_4 () ;
}
public tp_4 fn_13 () {
return this . vr_58 ;
}
public vr_70 fn_14 () {
return this . vr_61 ;
}
public vr_62 fn_15 () {
return this . vr_65 ;
}
public boolean fn_16 () {
return this . vr_87 ;
}
public int fn_17 () {
return this . vr_11 ;
}
