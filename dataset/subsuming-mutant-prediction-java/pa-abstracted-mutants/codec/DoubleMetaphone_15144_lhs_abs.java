public String doubleMetaphone ( final String value ) {
return doubleMetaphone ( value , false ) ;
}
public String doubleMetaphone ( String value , final boolean alternate ) {
value = cleanInput ( value ) ;
if ( value == null ) {
return null ;
}
final boolean slavoGermanic = isSlavoGermanic ( value ) ;
int index = isSilentStart ( value ) ? 1 : 0 ;
final DoubleMetaphoneResult result = new DoubleMetaphoneResult ( this . getMaxCodeLen () ) ;
while ( ! result . isComplete () && index <= value . length () - 1 ) {
switch ( value . charAt ( index ) ) {
case 'A' :
case 'E' :
case 'I' :
case 'O' :
case 'U' :
case 'Y' :
index = handleAEIOUY ( result , index ) ;
break;
case 'B' :
result . append ( 'P' ) ;
index = charAt ( value , index + 1 ) == 'B' ? index + 2 : index + 1 ;
break;
case '\u00C7' :
result . append ( 'S' ) ;
index ++ ;
break;
case 'C' :
index = handleC ( value , result , index ) ;
break;
case 'D' :
index = handleD ( value , result , index ) ;
break;
case 'F' :
result . append ( 'F' ) ;
index = charAt ( value , index + 1 ) == 'F' ? index + 2 : index + 1 ;
break;
case 'G' :
index = handleG ( value , result , index , slavoGermanic ) ;
break;
case 'H' :
index = handleH ( value , result , index ) ;
break;
case 'J' :
index = handleJ ( value , result , index , slavoGermanic ) ;
break;
case 'K' :
result . append ( 'K' ) ;
index = charAt ( value , index + 1 ) == 'K' ? index + 2 : index + 1 ;
break;
case 'L' :
index = handleL ( value , result , index ) ;
break;
case 'M' :
result . append ( 'M' ) ;
index = conditionM0 ( value , index ) ? index + 2 : index + 1 ;
break;
case 'N' :
result . append ( 'N' ) ;
index = charAt ( value , index + 1 ) == 'N' ? index + 2 : index + 1 ;
break;
case '\u00D1' :
result . append ( 'N' ) ;
index ++ ;
break;
case 'P' :
index = handleP ( value , result , index ) ;
break;
case 'Q' :
result . append ( 'K' ) ;
index = charAt ( value , index + 1 ) == 'Q' ? index + 2 : index + 1 ;
break;
case 'R' :
index = handleR ( value , result , index , slavoGermanic ) ;
break;
case 'S' :
index = handleS ( value , result , index , slavoGermanic ) ;
break;
case 'T' :
index = handleT ( value , result , index ) ;
break;
case 'V' :
result . append ( 'F' ) ;
index = charAt ( value , index + 1 ) == 'V' ? index + 2 : index + 1 ;
break;
case 'W' :
index = handleW ( value , result , index ) ;
break;
case 'X' :
index = handleX ( value , result , index ) ;
break;
case 'Z' :
index = handleZ ( value , result , index , slavoGermanic ) ;
break;
default:
index ++ ;
break;
}
}
return alternate ? result . getAlternate () : result . getPrimary () ;
}
@Override
public Object encode ( final Object obj ) throws EncoderException {
if ( ! ( obj instanceof String ) ) { MST[rv.ROR3Mutator]MSP[]
throw new EncoderException ( lr_1 ) ;
}
return doubleMetaphone ( ( String ) obj ) ;
}
@Override
public String encode ( final String value ) {
return doubleMetaphone ( value ) ;
}
public boolean isDoubleMetaphoneEqual ( final String value1 , final String value2 ) {
return isDoubleMetaphoneEqual ( value1 , value2 , false ) ;
}
public boolean isDoubleMetaphoneEqual ( final String value1 , final String value2 , final boolean alternate ) {
return StringUtils . equals ( doubleMetaphone ( value1 , alternate ) , doubleMetaphone ( value2 , alternate ) ) ;
}
public int getMaxCodeLen () {
return this . maxCodeLen ;
}
public void setMaxCodeLen ( final int maxCodeLen ) {
this . maxCodeLen = maxCodeLen ;
}
private int handleAEIOUY ( final DoubleMetaphoneResult result , final int index ) {
if ( index == 0 ) {
result . append ( 'A' ) ;
}
return index + 1 ;
}
private int handleC ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( conditionC0 ( value , index ) ) {
result . append ( 'K' ) ;
index += 2 ;
} else if ( index == 0 && contains ( value , index , 6 , lr_2 ) ) {
result . append ( 'S' ) ;
index += 2 ;
} else if ( contains ( value , index , 2 , lr_3 ) ) {
index = handleCH ( value , result , index ) ;
} else if ( contains ( value , index , 2 , lr_4 ) &&
! contains ( value , index - 2 , 4 , lr_5 ) ) {
result . append ( 'S' , 'X' ) ;
index += 2 ;
} else if ( contains ( value , index + 1 , 3 , lr_6 ) ) {
result . append ( 'X' ) ;
index += 3 ;
} else if ( contains ( value , index , 2 , lr_7 ) &&
! ( index == 1 && charAt ( value , 0 ) == 'M' ) ) {
return handleCC ( value , result , index ) ;
} else if ( contains ( value , index , 2 , lr_8 , lr_9 , lr_10 ) ) {
result . append ( 'K' ) ;
index += 2 ;
} else if ( contains ( value , index , 2 , lr_11 , lr_12 , lr_13 ) ) {
if ( contains ( value , index , 3 , lr_14 , lr_15 , lr_6 ) ) {
result . append ( 'S' , 'X' ) ;
} else {
result . append ( 'S' ) ;
}
index += 2 ;
} else {
result . append ( 'K' ) ;
if ( contains ( value , index + 1 , 2 , lr_16 , lr_17 , lr_18 ) ) {
index += 3 ;
} else if ( contains ( value , index + 1 , 1 , lr_19 , lr_20 , lr_21 ) &&
! contains ( value , index + 1 , 2 , lr_12 , lr_11 ) ) {
index += 2 ;
} else {
index ++ ;
}
}
return index ;
}
private int handleCC ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( contains ( value , index + 2 , 1 , lr_22 , lr_23 , lr_24 ) &&
! contains ( value , index + 2 , 2 , lr_25 ) ) {
if ( ( index == 1 && charAt ( value , index - 1 ) == 'A' ) ||
contains ( value , index - 1 , 5 , lr_26 , lr_27 ) ) {
result . append ( lr_28 ) ;
} else {
result . append ( 'X' ) ;
}
index += 3 ;
} else {
result . append ( 'K' ) ;
index += 2 ;
}
return index ;
}
private int handleCH ( final String value , final DoubleMetaphoneResult result , final int index ) {
if ( index > 0 && contains ( value , index , 4 , lr_29 ) ) {
result . append ( 'K' , 'X' ) ;
return index + 2 ;
} else if ( conditionCH0 ( value , index ) ) {
result . append ( 'K' ) ;
return index + 2 ;
} else if ( conditionCH1 ( value , index ) ) {
result . append ( 'K' ) ;
return index + 2 ;
} else {
if ( index > 0 ) {
if ( contains ( value , 0 , 2 , lr_30 ) ) {
result . append ( 'K' ) ;
} else {
result . append ( 'X' , 'K' ) ;
}
} else {
result . append ( 'X' ) ;
}
return index + 2 ;
}
}
private int handleD ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( contains ( value , index , 2 , lr_31 ) ) {
if ( contains ( value , index + 2 , 1 , lr_22 , lr_23 , lr_32 ) ) {
result . append ( 'J' ) ;
index += 3 ;
} else {
result . append ( lr_33 ) ;
index += 2 ;
}
} else if ( contains ( value , index , 2 , lr_34 , lr_35 ) ) {
result . append ( 'T' ) ;
index += 2 ;
} else {
result . append ( 'T' ) ;
index ++ ;
}
return index ;
}
private int handleG ( final String value , final DoubleMetaphoneResult result , int index ,
final boolean slavoGermanic ) {
if ( charAt ( value , index + 1 ) == 'H' ) {
index = handleGH ( value , result , index ) ;
} else if ( charAt ( value , index + 1 ) == 'N' ) {
if ( index == 1 && isVowel ( charAt ( value , 0 ) ) && ! slavoGermanic ) {
result . append ( lr_36 , lr_37 ) ;
} else if ( ! contains ( value , index + 2 , 2 , lr_38 ) &&
charAt ( value , index + 1 ) != 'Y' && ! slavoGermanic ) {
result . append ( lr_37 , lr_36 ) ;
} else {
result . append ( lr_36 ) ;
}
index = index + 2 ;
} else if ( contains ( value , index + 1 , 2 , lr_39 ) && ! slavoGermanic ) {
result . append ( lr_40 , lr_41 ) ;
index += 2 ;
} else if ( index == 0 &&
( charAt ( value , index + 1 ) == 'Y' ||
contains ( value , index + 1 , 2 , ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER ) ) ) {
result . append ( 'K' , 'J' ) ;
index += 2 ;
} else if ( ( contains ( value , index + 1 , 2 , lr_42 ) ||
charAt ( value , index + 1 ) == 'Y' ) &&
! contains ( value , 0 , 6 , lr_43 , lr_44 , lr_45 ) &&
! contains ( value , index - 1 , 1 , lr_23 , lr_22 ) &&
! contains ( value , index - 1 , 3 , lr_46 , lr_47 ) ) {
result . append ( 'K' , 'J' ) ;
index += 2 ;
} else if ( contains ( value , index + 1 , 1 , lr_23 , lr_22 , lr_32 ) ||
contains ( value , index - 1 , 4 , lr_48 , lr_49 ) ) {
if ( contains ( value , 0 , 4 , lr_50 , lr_51 ) ||
contains ( value , 0 , 3 , lr_52 ) ||
contains ( value , index + 1 , 2 , lr_53 ) ) {
result . append ( 'K' ) ;
} else if ( contains ( value , index + 1 , 3 , lr_54 ) ) {
result . append ( 'J' ) ;
} else {
result . append ( 'J' , 'K' ) ;
}
index += 2 ;
} else if ( charAt ( value , index + 1 ) == 'G' ) {
index += 2 ;
result . append ( 'K' ) ;
} else {
index ++ ;
result . append ( 'K' ) ;
}
return index ;
}
private int handleGH ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( index > 0 && ! isVowel ( charAt ( value , index - 1 ) ) ) {
result . append ( 'K' ) ;
index += 2 ;
} else if ( index == 0 ) {
if ( charAt ( value , index + 2 ) == 'I' ) {
result . append ( 'J' ) ;
} else {
result . append ( 'K' ) ;
}
index += 2 ;
} else if ( ( index > 1 && contains ( value , index - 2 , 1 , lr_55 , lr_24 , lr_56 ) ) ||
( index > 2 && contains ( value , index - 3 , 1 , lr_55 , lr_24 , lr_56 ) ) ||
( index > 3 && contains ( value , index - 4 , 1 , lr_55 , lr_24 ) ) ) {
index += 2 ;
} else {
if ( index > 2 && charAt ( value , index - 1 ) == 'U' &&
contains ( value , index - 3 , 1 , lr_19 , lr_57 , lr_41 , lr_58 , lr_59 ) ) {
result . append ( 'F' ) ;
} else if ( index > 0 && charAt ( value , index - 1 ) != 'I' ) {
result . append ( 'K' ) ;
}
index += 2 ;
}
return index ;
}
private int handleH ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( ( index == 0 || isVowel ( charAt ( value , index - 1 ) ) ) &&
isVowel ( charAt ( value , index + 1 ) ) ) {
result . append ( 'H' ) ;
index += 2 ;
} else {
index ++ ;
}
return index ;
}
private int handleJ ( final String value , final DoubleMetaphoneResult result , int index ,
final boolean slavoGermanic ) {
if ( contains ( value , index , 4 , lr_60 ) || contains ( value , 0 , 4 , lr_61 ) ) {
if ( ( index == 0 && ( charAt ( value , index + 4 ) == ' ' ) ||
value . length () == 4 ) || contains ( value , 0 , 4 , lr_61 ) ) {
result . append ( 'H' ) ;
} else {
result . append ( 'J' , 'H' ) ;
}
index ++ ;
} else {
if ( index == 0 && ! contains ( value , index , 4 , lr_60 ) ) {
result . append ( 'J' , 'A' ) ;
} else if ( isVowel ( charAt ( value , index - 1 ) ) && ! slavoGermanic &&
( charAt ( value , index + 1 ) == 'A' || charAt ( value , index + 1 ) == 'O' ) ) {
result . append ( 'J' , 'H' ) ;
} else if ( index == value . length () - 1 ) {
result . append ( 'J' , ' ' ) ;
} else if ( ! contains ( value , index + 1 , 1 , L_T_K_S_N_M_B_Z ) &&
! contains ( value , index - 1 , 1 , lr_62 , lr_20 , lr_41 ) ) {
result . append ( 'J' ) ;
}
if ( charAt ( value , index + 1 ) == 'J' ) {
index += 2 ;
} else {
index ++ ;
}
}
return index ;
}
private int handleL ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( charAt ( value , index + 1 ) == 'L' ) {
if ( conditionL0 ( value , index ) ) {
result . appendPrimary ( 'L' ) ;
} else {
result . append ( 'L' ) ;
}
index += 2 ;
} else {
index ++ ;
result . append ( 'L' ) ;
}
return index ;
}
private int handleP ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( charAt ( value , index + 1 ) == 'H' ) {
result . append ( 'F' ) ;
index += 2 ;
} else {
result . append ( 'P' ) ;
index = contains ( value , index + 1 , 1 , lr_63 , lr_55 ) ? index + 2 : index + 1 ;
}
return index ;
}
private int handleR ( final String value , final DoubleMetaphoneResult result , final int index ,
final boolean slavoGermanic ) {
if ( index == value . length () - 1 && ! slavoGermanic &&
contains ( value , index - 2 , 2 , lr_64 ) &&
! contains ( value , index - 4 , 2 , lr_65 , lr_66 ) ) {
result . appendAlternate ( 'R' ) ;
} else {
result . append ( 'R' ) ;
}
return charAt ( value , index + 1 ) == 'R' ? index + 2 : index + 1 ;
}
private int handleS ( final String value , final DoubleMetaphoneResult result , int index ,
final boolean slavoGermanic ) {
if ( contains ( value , index - 1 , 3 , lr_67 , lr_68 ) ) {
index ++ ;
} else if ( index == 0 && contains ( value , index , 5 , lr_69 ) ) {
result . append ( 'X' , 'S' ) ;
index ++ ;
} else if ( contains ( value , index , 2 , lr_70 ) ) {
if ( contains ( value , index + 1 , 4 , lr_71 , lr_72 , lr_73 , lr_74 ) ) {
result . append ( 'S' ) ;
} else {
result . append ( 'X' ) ;
}
index += 2 ;
} else if ( contains ( value , index , 3 , lr_75 , lr_76 ) || contains ( value , index , 4 , lr_77 ) ) {
if ( slavoGermanic ) {
result . append ( 'S' ) ;
} else {
result . append ( 'S' , 'X' ) ;
}
index += 3 ;
} else if ( ( index == 0 && contains ( value , index + 1 , 1 , lr_78 , lr_37 , lr_41 , lr_79 ) ) ||
contains ( value , index + 1 , 1 , lr_80 ) ) {
result . append ( 'S' , 'X' ) ;
index = contains ( value , index + 1 , 1 , lr_80 ) ? index + 2 : index + 1 ;
} else if ( contains ( value , index , 2 , lr_81 ) ) {
index = handleSC ( value , result , index ) ;
} else {
if ( index == value . length () - 1 && contains ( value , index - 2 , 2 , lr_82 , lr_83 ) ) {
result . appendAlternate ( 'S' ) ;
} else {
result . append ( 'S' ) ;
}
index = contains ( value , index + 1 , 1 , lr_62 , lr_80 ) ? index + 2 : index + 1 ;
}
return index ;
}
private int handleSC ( final String value , final DoubleMetaphoneResult result , final int index ) {
if ( charAt ( value , index + 2 ) == 'H' ) {
if ( contains ( value , index + 3 , 2 , lr_84 , lr_42 , lr_85 , lr_86 , lr_87 , lr_88 ) ) {
if ( contains ( value , index + 3 , 2 , lr_42 , lr_85 ) ) {
result . append ( lr_89 , lr_90 ) ;
} else {
result . append ( lr_90 ) ;
}
} else {
if ( index == 0 && ! isVowel ( charAt ( value , 3 ) ) && charAt ( value , 3 ) != 'W' ) {
result . append ( 'X' , 'S' ) ;
} else {
result . append ( 'X' ) ;
}
}
} else if ( contains ( value , index + 2 , 1 , lr_22 , lr_23 , lr_32 ) ) {
result . append ( 'S' ) ;
} else {
result . append ( lr_90 ) ;
}
return index + 3 ;
}
private int handleT ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( contains ( value , index , 4 , lr_91 ) ) {
result . append ( 'X' ) ;
index += 3 ;
} else if ( contains ( value , index , 3 , lr_92 , lr_93 ) ) {
result . append ( 'X' ) ;
index += 3 ;
} else if ( contains ( value , index , 2 , lr_94 ) || contains ( value , index , 3 , lr_95 ) ) {
if ( contains ( value , index + 2 , 2 , lr_96 , lr_97 ) ||
contains ( value , 0 , 4 , lr_50 , lr_51 ) ||
contains ( value , 0 , 3 , lr_52 ) ) {
result . append ( 'T' ) ;
} else {
result . append ( '0' , 'T' ) ;
}
index += 2 ;
} else {
result . append ( 'T' ) ;
index = contains ( value , index + 1 , 1 , lr_59 , lr_56 ) ? index + 2 : index + 1 ;
}
return index ;
}
private int handleW ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( contains ( value , index , 2 , lr_98 ) ) {
result . append ( 'R' ) ;
index += 2 ;
} else {
if ( index == 0 && ( isVowel ( charAt ( value , index + 1 ) ) ||
contains ( value , index , 2 , lr_99 ) ) ) {
if ( isVowel ( charAt ( value , index + 1 ) ) ) {
result . append ( 'A' , 'F' ) ;
} else {
result . append ( 'A' ) ;
}
index ++ ;
} else if ( ( index == value . length () - 1 && isVowel ( charAt ( value , index - 1 ) ) ) ||
contains ( value , index - 1 , 5 , lr_100 , lr_101 , lr_102 , lr_103 ) ||
contains ( value , 0 , 3 , lr_52 ) ) {
result . appendAlternate ( 'F' ) ;
index ++ ;
} else if ( contains ( value , index , 4 , lr_5 , lr_104 ) ) {
result . append ( lr_105 , lr_106 ) ;
index += 4 ;
} else {
index ++ ;
}
}
return index ;
}
private int handleX ( final String value , final DoubleMetaphoneResult result , int index ) {
if ( index == 0 ) {
result . append ( 'S' ) ;
index ++ ;
} else {
if ( ! ( ( index == value . length () - 1 ) &&
( contains ( value , index - 3 , 3 , lr_107 , lr_108 ) ||
contains ( value , index - 2 , 2 , lr_109 , lr_110 ) ) ) ) {
result . append ( lr_28 ) ;
}
index = contains ( value , index + 1 , 1 , lr_19 , lr_89 ) ? index + 2 : index + 1 ;
}
return index ;
}
private int handleZ ( final String value , final DoubleMetaphoneResult result , int index ,
final boolean slavoGermanic ) {
if ( charAt ( value , index + 1 ) == 'H' ) {
result . append ( 'J' ) ;
index += 2 ;
} else {
if ( contains ( value , index + 1 , 2 , lr_111 , lr_112 , lr_113 ) ||
( slavoGermanic && ( index > 0 && charAt ( value , index - 1 ) != 'T' ) ) ) {
result . append ( lr_62 , lr_105 ) ;
} else {
result . append ( 'S' ) ;
}
index = charAt ( value , index + 1 ) == 'Z' ? index + 2 : index + 1 ;
}
return index ;
}
private boolean conditionC0 ( final String value , final int index ) {
if ( contains ( value , index , 4 , lr_114 ) ) {
return true ;
} else if ( index <= 1 ) {
return false ;
} else if ( isVowel ( charAt ( value , index - 2 ) ) ) {
return false ;
} else if ( ! contains ( value , index - 1 , 3 , lr_115 ) ) {
return false ;
} else {
final char c = charAt ( value , index + 2 ) ;
return ( c != 'I' && c != 'E' ) ||
contains ( value , index - 2 , 6 , lr_116 , lr_117 ) ;
}
}
private boolean conditionCH0 ( final String value , final int index ) {
if ( index != 0 ) {
return false ;
} else if ( ! contains ( value , index + 1 , 5 , lr_118 , lr_119 ) &&
! contains ( value , index + 1 , 3 , lr_120 , lr_121 , lr_122 , lr_123 ) ) {
return false ;
} else if ( contains ( value , 0 , 5 , lr_124 ) ) {
return false ;
} else {
return true ;
}
}
private boolean conditionCH1 ( final String value , final int index ) {
return ( ( contains ( value , 0 , 4 , lr_50 , lr_51 ) || contains ( value , 0 , 3 , lr_52 ) ) ||
contains ( value , index - 2 , 6 , lr_125 , lr_126 , lr_127 ) ||
contains ( value , index + 2 , 1 , lr_59 , lr_62 ) ||
( ( contains ( value , index - 1 , 1 , lr_128 , lr_129 , lr_130 , lr_23 ) || index == 0 ) &&
( contains ( value , index + 2 , 1 , L_R_N_M_B_H_F_V_W_SPACE ) || index + 1 == value . length () - 1 ) ) ) ;
}
private boolean conditionL0 ( final String value , final int index ) {
if ( index == value . length () - 3 &&
contains ( value , index - 1 , 4 , lr_131 , lr_132 , lr_133 ) ) {
return true ;
} else if ( ( contains ( value , value . length () - 2 , 2 , lr_134 , lr_135 ) ||
contains ( value , value . length () - 1 , 1 , lr_128 , lr_129 ) ) &&
contains ( value , index - 1 , 4 , lr_133 ) ) {
return true ;
} else {
return false ;
}
}
private boolean conditionM0 ( final String value , final int index ) {
if ( charAt ( value , index + 1 ) == 'M' ) {
return true ;
}
return contains ( value , index - 1 , 3 , lr_136 ) &&
( ( index + 1 ) == value . length () - 1 || contains ( value , index + 2 , 2 , lr_42 ) ) ;
}
private boolean isSlavoGermanic ( final String value ) {
return value . indexOf ( 'W' ) > - 1 || value . indexOf ( 'K' ) > - 1 ||
value . indexOf ( lr_4 ) > - 1 || value . indexOf ( lr_104 ) > - 1 ;
}
private boolean isVowel ( final char ch ) {
return VOWELS . indexOf ( ch ) != - 1 ;
}
private boolean isSilentStart ( final String value ) {
boolean result = false ;
for ( final String element : SILENT_START ) {
if ( value . startsWith ( element ) ) {
result = true ;
break;
}
}
return result ;
}
private String cleanInput ( String input ) {
if ( input == null ) {
return null ;
}
input = input . trim () ;
if ( input . length () == 0 ) {
return null ;
}
return input . toUpperCase ( java . util . Locale . ENGLISH ) ;
}
protected char charAt ( final String value , final int index ) {
if ( index < 0 || index >= value . length () ) {
return Character . MIN_VALUE ;
}
return value . charAt ( index ) ;
}
protected static boolean contains ( final String value , final int start , final int length ,
final String ... criteria ) {
boolean result = false ;
if ( start >= 0 && start + length <= value . length () ) {
final String target = value . substring ( start , start + length ) ;
for ( final String element : criteria ) {
if ( target . equals ( element ) ) {
result = true ;
break;
}
}
}
return result ;
}
public void append ( final char value ) {
appendPrimary ( value ) ;
appendAlternate ( value ) ;
}
public void append ( final char primary , final char alternate ) {
appendPrimary ( primary ) ;
appendAlternate ( alternate ) ;
}
public void appendPrimary ( final char value ) {
if ( this . primary . length () < this . maxLength ) {
this . primary . append ( value ) ;
}
}
public void appendAlternate ( final char value ) {
if ( this . alternate . length () < this . maxLength ) {
this . alternate . append ( value ) ;
}
}
public void append ( final String value ) {
appendPrimary ( value ) ;
appendAlternate ( value ) ;
}
public void append ( final String primary , final String alternate ) {
appendPrimary ( primary ) ;
appendAlternate ( alternate ) ;
}
public void appendPrimary ( final String value ) {
final int addChars = this . maxLength - this . primary . length () ;
if ( value . length () <= addChars ) {
this . primary . append ( value ) ;
} else {
this . primary . append ( value . substring ( 0 , addChars ) ) ;
}
}
public void appendAlternate ( final String value ) {
final int addChars = this . maxLength - this . alternate . length () ;
if ( value . length () <= addChars ) {
this . alternate . append ( value ) ;
} else {
this . alternate . append ( value . substring ( 0 , addChars ) ) ;
}
}
public String getPrimary () {
return this . primary . toString () ;
}
public String getAlternate () {
return this . alternate . toString () ;
}
public boolean isComplete () {
return this . primary . length () >= this . maxLength &&
this . alternate . length () >= this . maxLength ;
}
