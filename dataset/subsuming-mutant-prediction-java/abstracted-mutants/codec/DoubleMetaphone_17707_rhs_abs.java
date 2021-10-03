public String fn_1 ( final String vr_1 ) {
return fn_1 ( vr_1 , false ) ;
}
public String fn_1 ( String vr_1 , final boolean vr_2 ) {
vr_1 = fn_2 ( vr_1 ) ;
if ( vr_1 == null ) {
return null ;
}
final boolean vr_3 = fn_3 ( vr_1 ) ;
int vr_4 = fn_4 ( vr_1 ) ? 1 : 0 ;
final tp_1 vr_5 = new tp_1 ( this . vr_6 () ) ;
while ( ! vr_5 . vr_7 () && vr_4 <= vr_1 . length () - 1 ) {
switch ( vr_1 . charAt ( vr_4 ) ) {
case 'A' :
case 'E' :
case 'I' :
case 'O' :
case 'U' :
case 'Y' :
vr_4 = fn_5 ( vr_5 , vr_4 ) ;
break;
case 'B' :
vr_5 . append ( 'P' ) ;
vr_4 = charAt ( vr_1 , vr_4 + 1 ) == 'B' ? vr_4 + 2 : vr_4 + 1 ;
break;
case '\u00C7' :
vr_5 . append ( 'S' ) ;
vr_4 ++ ;
break;
case 'C' :
vr_4 = fn_6 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'D' :
vr_4 = fn_7 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'F' :
vr_5 . append ( 'F' ) ;
vr_4 = charAt ( vr_1 , vr_4 + 1 ) == 'F' ? vr_4 + 2 : vr_4 + 1 ;
break;
case 'G' :
vr_4 = fn_8 ( vr_1 , vr_5 , vr_4 , vr_3 ) ;
break;
case 'H' :
vr_4 = fn_9 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'J' :
vr_4 = fn_10 ( vr_1 , vr_5 , vr_4 , vr_3 ) ;
break;
case 'K' :
vr_5 . append ( 'K' ) ;
vr_4 = charAt ( vr_1 , vr_4 + 1 ) == 'K' ? vr_4 + 2 : vr_4 + 1 ;
break;
case 'L' :
vr_4 = fn_11 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'M' :
vr_5 . append ( 'M' ) ;
vr_4 = fn_12 ( vr_1 , vr_4 ) ? vr_4 + 2 : vr_4 + 1 ;
break;
case 'N' :
vr_5 . append ( 'N' ) ;
vr_4 = charAt ( vr_1 , vr_4 + 1 ) == 'N' ? vr_4 + 2 : vr_4 + 1 ;
break;
case '\u00D1' :
vr_5 . append ( 'N' ) ;
vr_4 ++ ;
break;
case 'P' :
vr_4 = fn_13 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'Q' :
vr_5 . append ( 'K' ) ;
vr_4 = charAt ( vr_1 , vr_4 + 1 ) == 'Q' ? vr_4 + 2 : vr_4 + 1 ;
break;
case 'R' :
vr_4 = fn_14 ( vr_1 , vr_5 , vr_4 , vr_3 ) ;
break;
case 'S' :
vr_4 = fn_15 ( vr_1 , vr_5 , vr_4 , vr_3 ) ;
break;
case 'T' :
vr_4 = fn_16 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'V' :
vr_5 . append ( 'F' ) ;
vr_4 = charAt ( vr_1 , vr_4 + 1 ) == 'V' ? vr_4 + 2 : vr_4 + 1 ;
break;
case 'W' :
vr_4 = fn_17 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'X' :
vr_4 = fn_18 ( vr_1 , vr_5 , vr_4 ) ;
break;
case 'Z' :
vr_4 = fn_19 ( vr_1 , vr_5 , vr_4 , vr_3 ) ;
break;
default:
vr_4 ++ ;
break;
}
}
return vr_2 ? vr_5 . vr_8 () : vr_5 . vr_9 () ;
}
@Override
public Object fn_20 ( final Object vr_10 ) throws vl_1 {
if ( ! ( vr_10 instanceof String ) ) {
throw new vl_1 ( lr_1 ) ;
}
return fn_1 ( ( String ) vr_10 ) ;
}
@Override
public String fn_20 ( final String vr_1 ) {
return fn_1 ( vr_1 ) ;
}
public boolean fn_21 ( final String vr_11 , final String vr_12 ) {
return fn_21 ( vr_11 , vr_12 , false ) ;
}
public boolean fn_21 ( final String vr_11 , final String vr_12 , final boolean vr_2 ) {
return vr_13 . equals ( fn_1 ( vr_11 , vr_2 ) , fn_1 ( vr_12 , vr_2 ) ) ;
}
public int vr_6 () {
return this . vr_14 ;
}
public void fn_22 ( final int vr_14 ) {
this . vr_14 = vr_14 ;
}
private int fn_5 ( final tp_1 vr_5 , final int vr_4 ) {
if ( vr_4 == 0 ) {
vr_5 . append ( 'A' ) ;
}
return vr_4 + 1 ;
}
private int fn_6 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( fn_23 ( vr_1 , vr_4 ) ) {
vr_5 . append ( 'K' ) ;
vr_4 += 2 ;
} else if ( vr_4 == 0 && contains ( vr_1 , vr_4 , 6 , lr_2 ) ) {
vr_5 . append ( 'S' ) ;
vr_4 += 2 ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_3 ) ) {
vr_4 = fn_24 ( vr_1 , vr_5 , vr_4 ) ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_4 ) &&
! contains ( vr_1 , vr_4 - 2 , 4 , lr_5 ) ) {
vr_5 . append ( 'S' , 'X' ) ;
vr_4 += 2 ;
} else if ( contains ( vr_1 , vr_4 + 1 , 3 , lr_6 ) ) {
vr_5 . append ( 'X' ) ;
vr_4 += 3 ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_7 ) &&
! ( vr_4 == 1 && charAt ( vr_1 , 0 ) == 'M' ) ) {
return fn_25 ( vr_1 , vr_5 , vr_4 ) ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_8 , lr_9 , lr_10 ) ) {
vr_5 . append ( 'K' ) ;
vr_4 += 2 ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_11 , lr_12 , lr_13 ) ) {
if ( contains ( vr_1 , vr_4 , 3 , lr_14 , lr_15 , lr_6 ) ) {
vr_5 . append ( 'S' , 'X' ) ;
} else {
vr_5 . append ( 'S' ) ;
}
vr_4 += 2 ;
} else {
vr_5 . append ( 'K' ) ;
if ( contains ( vr_1 , vr_4 + 1 , 2 , lr_16 , lr_17 , lr_18 ) ) {
vr_4 += 3 ;
} else if ( contains ( vr_1 , vr_4 + 1 , 1 , lr_19 , lr_20 , lr_21 ) &&
! contains ( vr_1 , vr_4 + 1 , 2 , lr_12 , lr_11 ) ) {
vr_4 += 2 ;
} else {
vr_4 ++ ;
}
}
return vr_4 ;
}
private int fn_25 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( contains ( vr_1 , vr_4 + 2 , 1 , lr_22 , lr_23 , lr_24 ) &&
! contains ( vr_1 , vr_4 + 2 , 2 , lr_25 ) ) {
if ( ( vr_4 == 1 && charAt ( vr_1 , vr_4 - 1 ) == 'A' ) ||
contains ( vr_1 , vr_4 - 1 , 5 , lr_26 , lr_27 ) ) {
vr_5 . append ( lr_28 ) ;
} else {
vr_5 . append ( 'X' ) ;
}
vr_4 += 3 ;
} else {
vr_5 . append ( 'K' ) ;
vr_4 += 2 ;
}
return vr_4 ;
}
private int fn_24 ( final String vr_1 , final tp_1 vr_5 , final int vr_4 ) {
if ( vr_4 > 0 && contains ( vr_1 , vr_4 , 4 , lr_29 ) ) {
vr_5 . append ( 'K' , 'X' ) ;
return vr_4 + 2 ;
} else if ( fn_26 ( vr_1 , vr_4 ) ) {
vr_5 . append ( 'K' ) ;
return vr_4 + 2 ;
} else if ( fn_27 ( vr_1 , vr_4 ) ) {
vr_5 . append ( 'K' ) ;
return vr_4 + 2 ;
} else {
if ( vr_4 > 0 ) {
if ( contains ( vr_1 , 0 , 2 , lr_30 ) ) {
vr_5 . append ( 'K' ) ;
} else {
vr_5 . append ( 'X' , 'K' ) ;
}
} else {
vr_5 . append ( 'X' ) ;
}
return vr_4 + 2 ;
}
}
private int fn_7 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( contains ( vr_1 , vr_4 , 2 , lr_31 ) ) {
if ( contains ( vr_1 , vr_4 + 2 , 1 , lr_22 , lr_23 , lr_32 ) ) {
vr_5 . append ( 'J' ) ;
vr_4 += 3 ;
} else {
vr_5 . append ( lr_33 ) ;
vr_4 += 2 ;
}
} else if ( contains ( vr_1 , vr_4 , 2 , lr_34 , lr_35 ) ) {
vr_5 . append ( 'T' ) ;
vr_4 += 2 ;
} else {
vr_5 . append ( 'T' ) ;
vr_4 ++ ;
}
return vr_4 ;
}
private int fn_8 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ,
final boolean vr_3 ) {
if ( charAt ( vr_1 , vr_4 + 1 ) == 'H' ) {
vr_4 = fn_28 ( vr_1 , vr_5 , vr_4 ) ;
} else if ( charAt ( vr_1 , vr_4 + 1 ) == 'N' ) {
if ( vr_4 == 1 && fn_29 ( charAt ( vr_1 , 0 ) ) && ! vr_3 ) {
vr_5 . append ( lr_36 , lr_37 ) ;
} else if ( ! contains ( vr_1 , vr_4 + 2 , 2 , lr_38 ) &&
charAt ( vr_1 , vr_4 + 1 ) != 'Y' && ! vr_3 ) {
vr_5 . append ( lr_37 , lr_36 ) ;
} else {
vr_5 . append ( lr_36 ) ;
}
vr_4 = vr_4 + 2 ;
} else if ( contains ( vr_1 , vr_4 + 1 , 2 , lr_39 ) && ! vr_3 ) {
vr_5 . append ( lr_40 , lr_41 ) ;
vr_4 += 2 ;
} else if ( vr_4 == 0 &&
( charAt ( vr_1 , vr_4 + 1 ) == 'Y' ||
contains ( vr_1 , vr_4 + 1 , 2 , vl_2 ) ) ) {
vr_5 . append ( 'K' , 'J' ) ;
vr_4 += 2 ;
} else if ( ( contains ( vr_1 , vr_4 + 1 , 2 , lr_42 ) ||
charAt ( vr_1 , vr_4 + 1 ) == 'Y' ) &&
! contains ( vr_1 , 0 , 6 , lr_43 , lr_44 , lr_45 ) &&
! contains ( vr_1 , vr_4 - 1 , 1 , lr_23 , lr_22 ) &&
! contains ( vr_1 , vr_4 - 1 , 3 , lr_46 , lr_47 ) ) {
vr_5 . append ( 'K' , 'J' ) ;
vr_4 += 2 ;
} else if ( contains ( vr_1 , vr_4 + 1 , 1 , lr_23 , lr_22 , lr_32 ) ||
contains ( vr_1 , vr_4 - 1 , 4 , lr_48 , lr_49 ) ) {
if ( contains ( vr_1 , 0 , 4 , lr_50 , lr_51 ) ||
contains ( vr_1 , 0 , 3 , lr_52 ) ||
contains ( vr_1 , vr_4 + 1 , 2 , lr_53 ) ) {
vr_5 . append ( 'K' ) ;
} else if ( contains ( vr_1 , vr_4 + 1 , 3 , lr_54 ) ) {
vr_5 . append ( 'J' ) ;
} else {
vr_5 . append ( 'J' , 'K' ) ;
}
vr_4 += 2 ;
} else if ( charAt ( vr_1 , vr_4 + 1 ) == 'G' ) {
vr_4 += 2 ;
vr_5 . append ( 'K' ) ;
} else {
vr_4 ++ ;
vr_5 . append ( 'K' ) ;
}
return vr_4 ;
}
private int fn_28 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( vr_4 > 0 && ! fn_29 ( charAt ( vr_1 , vr_4 - 1 ) ) ) {
vr_5 . append ( 'K' ) ;
vr_4 += 2 ;
} else if ( vr_4 == 0 ) {
if ( charAt ( vr_1 , vr_4 + 2 ) == 'I' ) {
vr_5 . append ( 'J' ) ;
} else {
vr_5 . append ( 'K' ) ;
}
vr_4 += 2 ;
} else if ( ( vr_4 > 1 && contains ( vr_1 , vr_4 - 2 , 1 , lr_55 , lr_24 , lr_56 ) ) ||
( vr_4 > 2 && contains ( vr_1 , vr_4 - 3 , 1 , lr_55 , lr_24 , lr_56 ) ) ||
( vr_4 > 3 && contains ( vr_1 , vr_4 - 4 , 1 , lr_55 , lr_24 ) ) ) {
vr_4 += 2 ;
} else {
if ( vr_4 > 2 && charAt ( vr_1 , vr_4 - 1 ) == 'U' &&
contains ( vr_1 , vr_4 - 3 , 1 , lr_19 , lr_57 , lr_41 , lr_58 , lr_59 ) ) {
vr_5 . append ( 'F' ) ;
} else if ( vr_4 > 0 && charAt ( vr_1 , vr_4 - 1 ) != 'I' ) {
vr_5 . append ( 'K' ) ;
}
vr_4 += 2 ;
}
return vr_4 ;
}
private int fn_9 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( ( vr_4 == 0 || fn_29 ( charAt ( vr_1 , vr_4 - 1 ) ) ) &&
fn_29 ( charAt ( vr_1 , vr_4 + 1 ) ) ) {
vr_5 . append ( 'H' ) ;
vr_4 += 2 ;
} else {
vr_4 ++ ;
}
return vr_4 ;
}
private int fn_10 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ,
final boolean vr_3 ) {
if ( contains ( vr_1 , vr_4 , 4 , lr_60 ) || contains ( vr_1 , 0 , 4 , lr_61 ) ) {
if ( ( vr_4 == 0 && ( charAt ( vr_1 , vr_4 + 4 ) == ' ' ) ||
vr_1 . length () == 4 ) || contains ( vr_1 , 0 , 4 , lr_61 ) ) {
vr_5 . append ( 'H' ) ;
} else {
vr_5 . append ( 'J' , 'H' ) ;
}
vr_4 ++ ;
} else {
if ( vr_4 == 0 && ! contains ( vr_1 , vr_4 , 4 , lr_60 ) ) {
vr_5 . append ( 'J' , 'A' ) ;
} else if ( fn_29 ( charAt ( vr_1 , vr_4 - 1 ) ) && ! vr_3 &&
( charAt ( vr_1 , vr_4 + 1 ) == 'A' || charAt ( vr_1 , vr_4 + 1 ) == 'O' ) ) {
vr_5 . append ( 'J' , 'H' ) ;
} else if ( vr_4 == vr_1 . length () - 1 ) {
vr_5 . append ( 'J' , ' ' ) ;
} else if ( ! contains ( vr_1 , vr_4 + 1 , 1 , vl_3 ) &&
! contains ( vr_1 , vr_4 - 1 , 1 , lr_62 , lr_20 , lr_41 ) ) {
vr_5 . append ( 'J' ) ;
}
if ( charAt ( vr_1 , vr_4 + 1 ) == 'J' ) {
vr_4 += 2 ;
} else {
vr_4 ++ ;
}
}
return vr_4 ;
}
private int fn_11 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( charAt ( vr_1 , vr_4 + 1 ) == 'L' ) {
if ( fn_30 ( vr_1 , vr_4 ) ) {
vr_5 . vr_15 ( 'L' ) ;
} else {
vr_5 . append ( 'L' ) ;
}
vr_4 += 2 ;
} else {
vr_4 ++ ;
vr_5 . append ( 'L' ) ;
}
return vr_4 ;
}
private int fn_13 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( charAt ( vr_1 , vr_4 + 1 ) == 'H' ) {
vr_5 . append ( 'F' ) ;
vr_4 += 2 ;
} else {
vr_5 . append ( 'P' ) ;
vr_4 = contains ( vr_1 , vr_4 + 1 , 1 , lr_63 , lr_55 ) ? vr_4 + 2 : vr_4 + 1 ;
}
return vr_4 ;
}
private int fn_14 ( final String vr_1 , final tp_1 vr_5 , final int vr_4 ,
final boolean vr_3 ) {
if ( vr_4 == vr_1 . length () - 1 && ! vr_3 &&
contains ( vr_1 , vr_4 - 2 , 2 , lr_64 ) &&
! contains ( vr_1 , vr_4 - 4 , 2 , lr_65 , lr_66 ) ) {
vr_5 . vr_16 ( 'R' ) ;
} else {
vr_5 . append ( 'R' ) ;
}
return charAt ( vr_1 , vr_4 + 1 ) == 'R' ? vr_4 + 2 : vr_4 + 1 ;
}
private int fn_15 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ,
final boolean vr_3 ) {
if ( contains ( vr_1 , vr_4 - 1 , 3 , lr_67 , lr_68 ) ) {
vr_4 ++ ;
} else if ( vr_4 == 0 && contains ( vr_1 , vr_4 , 5 , lr_69 ) ) {
vr_5 . append ( 'X' , 'S' ) ;
vr_4 ++ ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_70 ) ) { MST[NonVoidMethodCallMutator]MSP[N]
if ( contains ( vr_1 , vr_4 + 1 , 4 , lr_71 , lr_72 , lr_73 , lr_74 ) ) {
vr_5 . append ( 'S' ) ;
} else {
vr_5 . append ( 'X' ) ;
}
vr_4 += 2 ;
} else if ( contains ( vr_1 , vr_4 , 3 , lr_75 , lr_76 ) || contains ( vr_1 , vr_4 , 4 , lr_77 ) ) {
if ( vr_3 ) {
vr_5 . append ( 'S' ) ;
} else {
vr_5 . append ( 'S' , 'X' ) ;
}
vr_4 += 3 ;
} else if ( ( vr_4 == 0 && contains ( vr_1 , vr_4 + 1 , 1 , lr_78 , lr_37 , lr_41 , lr_79 ) ) ||
contains ( vr_1 , vr_4 + 1 , 1 , lr_80 ) ) {
vr_5 . append ( 'S' , 'X' ) ;
vr_4 = contains ( vr_1 , vr_4 + 1 , 1 , lr_80 ) ? vr_4 + 2 : vr_4 + 1 ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_81 ) ) {
vr_4 = fn_31 ( vr_1 , vr_5 , vr_4 ) ;
} else {
if ( vr_4 == vr_1 . length () - 1 && contains ( vr_1 , vr_4 - 2 , 2 , lr_82 , lr_83 ) ) {
vr_5 . vr_16 ( 'S' ) ;
} else {
vr_5 . append ( 'S' ) ;
}
vr_4 = contains ( vr_1 , vr_4 + 1 , 1 , lr_62 , lr_80 ) ? vr_4 + 2 : vr_4 + 1 ;
}
return vr_4 ;
}
private int fn_31 ( final String vr_1 , final tp_1 vr_5 , final int vr_4 ) {
if ( charAt ( vr_1 , vr_4 + 2 ) == 'H' ) {
if ( contains ( vr_1 , vr_4 + 3 , 2 , lr_84 , lr_42 , lr_85 , lr_86 , lr_87 , lr_88 ) ) {
if ( contains ( vr_1 , vr_4 + 3 , 2 , lr_42 , lr_85 ) ) {
vr_5 . append ( lr_89 , lr_90 ) ;
} else {
vr_5 . append ( lr_90 ) ;
}
} else {
if ( vr_4 == 0 && ! fn_29 ( charAt ( vr_1 , 3 ) ) && charAt ( vr_1 , 3 ) != 'W' ) {
vr_5 . append ( 'X' , 'S' ) ;
} else {
vr_5 . append ( 'X' ) ;
}
}
} else if ( contains ( vr_1 , vr_4 + 2 , 1 , lr_22 , lr_23 , lr_32 ) ) {
vr_5 . append ( 'S' ) ;
} else {
vr_5 . append ( lr_90 ) ;
}
return vr_4 + 3 ;
}
private int fn_16 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( contains ( vr_1 , vr_4 , 4 , lr_91 ) ) {
vr_5 . append ( 'X' ) ;
vr_4 += 3 ;
} else if ( contains ( vr_1 , vr_4 , 3 , lr_92 , lr_93 ) ) {
vr_5 . append ( 'X' ) ;
vr_4 += 3 ;
} else if ( contains ( vr_1 , vr_4 , 2 , lr_94 ) || contains ( vr_1 , vr_4 , 3 , lr_95 ) ) {
if ( contains ( vr_1 , vr_4 + 2 , 2 , lr_96 , lr_97 ) ||
contains ( vr_1 , 0 , 4 , lr_50 , lr_51 ) ||
contains ( vr_1 , 0 , 3 , lr_52 ) ) {
vr_5 . append ( 'T' ) ;
} else {
vr_5 . append ( '0' , 'T' ) ;
}
vr_4 += 2 ;
} else {
vr_5 . append ( 'T' ) ;
vr_4 = contains ( vr_1 , vr_4 + 1 , 1 , lr_59 , lr_56 ) ? vr_4 + 2 : vr_4 + 1 ;
}
return vr_4 ;
}
private int fn_17 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( contains ( vr_1 , vr_4 , 2 , lr_98 ) ) {
vr_5 . append ( 'R' ) ;
vr_4 += 2 ;
} else {
if ( vr_4 == 0 && ( fn_29 ( charAt ( vr_1 , vr_4 + 1 ) ) ||
contains ( vr_1 , vr_4 , 2 , lr_99 ) ) ) {
if ( fn_29 ( charAt ( vr_1 , vr_4 + 1 ) ) ) {
vr_5 . append ( 'A' , 'F' ) ;
} else {
vr_5 . append ( 'A' ) ;
}
vr_4 ++ ;
} else if ( ( vr_4 == vr_1 . length () - 1 && fn_29 ( charAt ( vr_1 , vr_4 - 1 ) ) ) ||
contains ( vr_1 , vr_4 - 1 , 5 , lr_100 , lr_101 , lr_102 , lr_103 ) ||
contains ( vr_1 , 0 , 3 , lr_52 ) ) {
vr_5 . vr_16 ( 'F' ) ;
vr_4 ++ ;
} else if ( contains ( vr_1 , vr_4 , 4 , lr_5 , lr_104 ) ) {
vr_5 . append ( lr_105 , lr_106 ) ;
vr_4 += 4 ;
} else {
vr_4 ++ ;
}
}
return vr_4 ;
}
private int fn_18 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ) {
if ( vr_4 == 0 ) {
vr_5 . append ( 'S' ) ;
vr_4 ++ ;
} else {
if ( ! ( ( vr_4 == vr_1 . length () - 1 ) &&
( contains ( vr_1 , vr_4 - 3 , 3 , lr_107 , lr_108 ) ||
contains ( vr_1 , vr_4 - 2 , 2 , lr_109 , lr_110 ) ) ) ) {
vr_5 . append ( lr_28 ) ;
}
vr_4 = contains ( vr_1 , vr_4 + 1 , 1 , lr_19 , lr_89 ) ? vr_4 + 2 : vr_4 + 1 ;
}
return vr_4 ;
}
private int fn_19 ( final String vr_1 , final tp_1 vr_5 , int vr_4 ,
final boolean vr_3 ) {
if ( charAt ( vr_1 , vr_4 + 1 ) == 'H' ) {
vr_5 . append ( 'J' ) ;
vr_4 += 2 ;
} else {
if ( contains ( vr_1 , vr_4 + 1 , 2 , lr_111 , lr_112 , lr_113 ) ||
( vr_3 && ( vr_4 > 0 && charAt ( vr_1 , vr_4 - 1 ) != 'T' ) ) ) {
vr_5 . append ( lr_62 , lr_105 ) ;
} else {
vr_5 . append ( 'S' ) ;
}
vr_4 = charAt ( vr_1 , vr_4 + 1 ) == 'Z' ? vr_4 + 2 : vr_4 + 1 ;
}
return vr_4 ;
}
private boolean fn_23 ( final String vr_1 , final int vr_4 ) {
if ( contains ( vr_1 , vr_4 , 4 , lr_114 ) ) {
return true ;
} else if ( vr_4 <= 1 ) {
return false ;
} else if ( fn_29 ( charAt ( vr_1 , vr_4 - 2 ) ) ) {
return false ;
} else if ( ! contains ( vr_1 , vr_4 - 1 , 3 , lr_115 ) ) {
return false ;
} else {
final char vr_17 = charAt ( vr_1 , vr_4 + 2 ) ;
return ( vr_17 != 'I' && vr_17 != 'E' ) ||
contains ( vr_1 , vr_4 - 2 , 6 , lr_116 , lr_117 ) ;
}
}
private boolean fn_26 ( final String vr_1 , final int vr_4 ) {
if ( vr_4 != 0 ) {
return false ;
} else if ( ! contains ( vr_1 , vr_4 + 1 , 5 , lr_118 , lr_119 ) &&
! contains ( vr_1 , vr_4 + 1 , 3 , lr_120 , lr_121 , lr_122 , lr_123 ) ) {
return false ;
} else if ( contains ( vr_1 , 0 , 5 , lr_124 ) ) {
return false ;
} else {
return true ;
}
}
private boolean fn_27 ( final String vr_1 , final int vr_4 ) {
return ( ( contains ( vr_1 , 0 , 4 , lr_50 , lr_51 ) || contains ( vr_1 , 0 , 3 , lr_52 ) ) ||
contains ( vr_1 , vr_4 - 2 , 6 , lr_125 , lr_126 , lr_127 ) ||
contains ( vr_1 , vr_4 + 2 , 1 , lr_59 , lr_62 ) ||
( ( contains ( vr_1 , vr_4 - 1 , 1 , lr_128 , lr_129 , lr_130 , lr_23 ) || vr_4 == 0 ) &&
( contains ( vr_1 , vr_4 + 2 , 1 , vl_4 ) || vr_4 + 1 == vr_1 . length () - 1 ) ) ) ;
}
private boolean fn_30 ( final String vr_1 , final int vr_4 ) {
if ( vr_4 == vr_1 . length () - 3 &&
contains ( vr_1 , vr_4 - 1 , 4 , lr_131 , lr_132 , lr_133 ) ) {
return true ;
} else if ( ( contains ( vr_1 , vr_1 . length () - 2 , 2 , lr_134 , lr_135 ) ||
contains ( vr_1 , vr_1 . length () - 1 , 1 , lr_128 , lr_129 ) ) &&
contains ( vr_1 , vr_4 - 1 , 4 , lr_133 ) ) {
return true ;
} else {
return false ;
}
}
private boolean fn_12 ( final String vr_1 , final int vr_4 ) {
if ( charAt ( vr_1 , vr_4 + 1 ) == 'M' ) {
return true ;
}
return contains ( vr_1 , vr_4 - 1 , 3 , lr_136 ) &&
( ( vr_4 + 1 ) == vr_1 . length () - 1 || contains ( vr_1 , vr_4 + 2 , 2 , lr_42 ) ) ;
}
private boolean fn_3 ( final String vr_1 ) {
return vr_1 . indexOf ( 'W' ) > - 1 || vr_1 . indexOf ( 'K' ) > - 1 ||
vr_1 . indexOf ( lr_4 ) > - 1 || vr_1 . indexOf ( lr_104 ) > - 1 ;
}
private boolean fn_29 ( final char vr_18 ) {
return vr_19 . indexOf ( vr_18 ) != - 1 ;
}
private boolean fn_4 ( final String vr_1 ) {
boolean vr_5 = false ;
for ( final String vr_20 : vl_5 ) {
if ( vr_1 . vr_21 ( vr_20 ) ) {
vr_5 = true ;
break;
}
}
return vr_5 ;
}
private String fn_2 ( String vr_22 ) {
if ( vr_22 == null ) {
return null ;
}
vr_22 = vr_22 . trim () ;
if ( vr_22 . length () == 0 ) {
return null ;
}
return vr_22 . vr_23 ( vr_24 . util . vr_25 . vr_26 ) ;
}
protected char charAt ( final String vr_1 , final int vr_4 ) {
if ( vr_4 < 0 || vr_4 >= vr_1 . length () ) {
return vr_27 . vr_28 ;
}
return vr_1 . charAt ( vr_4 ) ;
}
protected static boolean contains ( final String vr_1 , final int vr_29 , final int length ,
final String ... vr_30 ) {
boolean vr_5 = false ;
if ( vr_29 >= 0 && vr_29 + length <= vr_1 . length () ) {
final String vr_31 = vr_1 . vr_32 ( vr_29 , vr_29 + length ) ;
for ( final String vr_20 : vr_30 ) {
if ( vr_31 . equals ( vr_20 ) ) {
vr_5 = true ;
break;
}
}
}
return vr_5 ;
}
public void append ( final char vr_1 ) {
vr_15 ( vr_1 ) ;
vr_16 ( vr_1 ) ;
}
public void append ( final char vr_33 , final char vr_2 ) {
vr_15 ( vr_33 ) ;
vr_16 ( vr_2 ) ;
}
public void vr_15 ( final char vr_1 ) {
if ( this . vr_33 . length () < this . vr_34 ) {
this . vr_33 . append ( vr_1 ) ;
}
}
public void vr_16 ( final char vr_1 ) {
if ( this . vr_2 . length () < this . vr_34 ) {
this . vr_2 . append ( vr_1 ) ;
}
}
public void append ( final String vr_1 ) {
vr_15 ( vr_1 ) ;
vr_16 ( vr_1 ) ;
}
public void append ( final String vr_33 , final String vr_2 ) {
vr_15 ( vr_33 ) ;
vr_16 ( vr_2 ) ;
}
public void vr_15 ( final String vr_1 ) {
final int vr_35 = this . vr_34 - this . vr_33 . length () ;
if ( vr_1 . length () <= vr_35 ) {
this . vr_33 . append ( vr_1 ) ;
} else {
this . vr_33 . append ( vr_1 . vr_32 ( 0 , vr_35 ) ) ;
}
}
public void vr_16 ( final String vr_1 ) {
final int vr_35 = this . vr_34 - this . vr_2 . length () ;
if ( vr_1 . length () <= vr_35 ) {
this . vr_2 . append ( vr_1 ) ;
} else {
this . vr_2 . append ( vr_1 . vr_32 ( 0 , vr_35 ) ) ;
}
}
public String vr_9 () {
return this . vr_33 . toString () ;
}
public String vr_8 () {
return this . vr_2 . toString () ;
}
public boolean vr_7 () {
return this . vr_33 . length () >= this . vr_34 &&
this . vr_2 . length () >= this . vr_34 ;
}
