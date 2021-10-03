public String fn_1 ( final String vr_1 ) {
boolean vr_2 = false ;
int vr_3 ;
if ( vr_1 == null || ( vr_3 = vr_1 . length () ) == 0 ) {
return lr_1 ;
}
if ( vr_3 == 1 ) {
return vr_1 . vr_4 ( vr_5 . util . vr_6 . vr_7 ) ;
}
final char [] vr_8 = vr_1 . vr_4 ( vr_5 . util . vr_6 . vr_7 ) . fn_2 () ;
final StringBuilder vr_9 = new StringBuilder ( 40 ) ;
final StringBuilder vr_10 = new StringBuilder ( 10 ) ;
switch( vr_8 [ 0 ] ) {
case 'K' :
case 'G' :
case 'P' :
if ( vr_8 [ 1 ] == 'N' ) {
vr_9 . append ( vr_8 , 1 , vr_8 . length - 1 ) ;
} else {
vr_9 . append ( vr_8 ) ;
}
break;
case 'A' :
if ( vr_8 [ 1 ] == 'E' ) {
vr_9 . append ( vr_8 , 1 , vr_8 . length - 1 ) ;
} else {
vr_9 . append ( vr_8 ) ;
}
break;
case 'W' :
if ( vr_8 [ 1 ] == 'R' ) {
vr_9 . append ( vr_8 , 1 , vr_8 . length - 1 ) ;
break;
}
if ( vr_8 [ 1 ] == 'H' ) {
vr_9 . append ( vr_8 , 1 , vr_8 . length - 1 ) ;
vr_9 . vr_11 ( 0 , 'W' ) ;
} else {
vr_9 . append ( vr_8 ) ;
}
break;
case 'X' :
vr_8 [ 0 ] = 'S' ;
vr_9 . append ( vr_8 ) ;
break;
default:
vr_9 . append ( vr_8 ) ;
}
final int vr_12 = vr_9 . length () ;
int vr_13 = 0 ;
while ( vr_10 . length () < this . vr_14 () &&
vr_13 < vr_12 ) {
final char vr_15 = vr_9 . charAt ( vr_13 ) ;
if ( vr_15 != 'C' && fn_3 ( vr_9 , vr_13 , vr_15 ) ) {
vr_13 ++ ;
} else {
switch( vr_15 ) {
case 'A' :
case 'E' :
case 'I' :
case 'O' :
case 'U' :
if ( vr_13 == 0 ) {
vr_10 . append ( vr_15 ) ;
}
break;
case 'B' :
if ( fn_3 ( vr_9 , vr_13 , 'M' ) &&
fn_4 ( vr_12 , vr_13 ) ) {
break;
}
vr_10 . append ( vr_15 ) ;
break;
case 'C' :
if ( fn_3 ( vr_9 , vr_13 , 'S' ) &&
! fn_4 ( vr_12 , vr_13 ) &&
vr_16 . indexOf ( vr_9 . charAt ( vr_13 + 1 ) ) >= 0 ) {
break;
}
if ( fn_5 ( vr_9 , vr_13 , lr_2 ) ) {
vr_10 . append ( 'X' ) ;
break;
}
if ( ! fn_4 ( vr_12 , vr_13 ) &&
vr_16 . indexOf ( vr_9 . charAt ( vr_13 + 1 ) ) >= 0 ) {
vr_10 . append ( 'S' ) ;
break;
}
if ( fn_3 ( vr_9 , vr_13 , 'S' ) &&
fn_6 ( vr_9 , vr_13 , 'H' ) ) {
vr_10 . append ( 'K' ) ;
break;
}
if ( fn_6 ( vr_9 , vr_13 , 'H' ) ) {
if ( vr_13 == 0 &&
vr_12 >= 3 &&
fn_7 ( vr_9 , 2 ) ) {
vr_10 . append ( 'K' ) ;
} else {
vr_10 . append ( 'X' ) ;
}
} else {
vr_10 . append ( 'K' ) ;
}
break;
case 'D' :
if ( ! fn_4 ( vr_12 , vr_13 + 1 ) &&
fn_6 ( vr_9 , vr_13 , 'G' ) &&
vr_16 . indexOf ( vr_9 . charAt ( vr_13 + 2 ) ) >= 0 ) {
vr_10 . append ( 'J' ) ; vr_13 += 2 ;
} else {
vr_10 . append ( 'T' ) ;
}
break;
case 'G' :
if ( fn_4 ( vr_12 , vr_13 + 1 ) &&
fn_6 ( vr_9 , vr_13 , 'H' ) ) {
break;
}
if ( ! fn_4 ( vr_12 , vr_13 + 1 ) &&
fn_6 ( vr_9 , vr_13 , 'H' ) &&
! fn_7 ( vr_9 , vr_13 + 2 ) ) {
break;
}
if ( vr_13 > 0 &&
( fn_5 ( vr_9 , vr_13 , lr_3 ) ||
fn_5 ( vr_9 , vr_13 , lr_4 ) ) ) {
break;
}
if ( fn_3 ( vr_9 , vr_13 , 'G' ) ) {
vr_2 = true ;
} else {
vr_2 = false ;
}
if ( ! fn_4 ( vr_12 , vr_13 ) &&
vr_16 . indexOf ( vr_9 . charAt ( vr_13 + 1 ) ) >= 0 &&
! vr_2 ) {
vr_10 . append ( 'J' ) ;
} else {
vr_10 . append ( 'K' ) ;
}
break;
case 'H' :
if ( fn_4 ( vr_12 , vr_13 ) ) {
break;
}
if ( vr_13 > 0 &&
vr_17 . indexOf ( vr_9 . charAt ( vr_13 - 1 ) ) >= 0 ) {
break;
}
if ( fn_7 ( vr_9 , vr_13 + 1 ) ) {
vr_10 . append ( 'H' ) ;
}
break;
case 'F' :
case 'J' :
case 'L' :
case 'M' :
case 'N' :
case 'R' :
vr_10 . append ( vr_15 ) ;
break;
case 'K' :
if ( vr_13 > 0 ) {
if ( ! fn_3 ( vr_9 , vr_13 , 'C' ) ) {
vr_10 . append ( vr_15 ) ;
}
} else {
vr_10 . append ( vr_15 ) ;
}
break;
case 'P' :
if ( fn_6 ( vr_9 , vr_13 , 'H' ) ) {
vr_10 . append ( 'F' ) ;
} else {
vr_10 . append ( vr_15 ) ;
}
break;
case 'Q' :
vr_10 . append ( 'K' ) ;
break;
case 'S' :
if ( fn_5 ( vr_9 , vr_13 , lr_5 ) ||
fn_5 ( vr_9 , vr_13 , lr_6 ) ||
fn_5 ( vr_9 , vr_13 , lr_7 ) ) {
vr_10 . append ( 'X' ) ;
} else {
vr_10 . append ( 'S' ) ;
}
break;
case 'T' :
if ( fn_5 ( vr_9 , vr_13 , lr_8 ) ||
fn_5 ( vr_9 , vr_13 , lr_9 ) ) {
vr_10 . append ( 'X' ) ;
break;
}
if ( fn_5 ( vr_9 , vr_13 , lr_10 ) ) {
break;
}
if ( fn_5 ( vr_9 , vr_13 , lr_11 ) ) {
vr_10 . append ( '0' ) ;
} else {
vr_10 . append ( 'T' ) ;
}
break;
case 'V' :
vr_10 . append ( 'F' ) ; break;
case 'W' :
case 'Y' :
if ( ! fn_4 ( vr_12 , vr_13 ) &&
fn_7 ( vr_9 , vr_13 + 1 ) ) {
vr_10 . append ( vr_15 ) ;
}
break;
case 'X' :
vr_10 . append ( 'K' ) ;
vr_10 . append ( 'S' ) ;
break;
case 'Z' :
vr_10 . append ( 'S' ) ;
break;
default:
break;
}
vr_13 ++ ;
}
if ( vr_10 . length () > this . vr_14 () ) {
vr_10 . vr_18 ( this . vr_14 () ) ;
}
}
return vr_10 . toString () ;
}
private boolean fn_7 ( final StringBuilder string , final int vr_19 ) {
return vr_20 . indexOf ( string . charAt ( vr_19 ) ) >= 0 ;
}
private boolean fn_3 ( final StringBuilder string , final int vr_19 , final char vr_21 ) {
boolean vr_22 = false ;
if( vr_19 > 0 &&
vr_19 < string . length () ) {
vr_22 = string . charAt ( vr_19 - 1 ) == vr_21 ;
}
return vr_22 ;
}
private boolean fn_6 ( final StringBuilder string , final int vr_19 , final char vr_21 ) {
boolean vr_22 = false ;
if( vr_19 >= 0 &&
vr_19 < string . length () - 1 ) {
vr_22 = string . charAt ( vr_19 + 1 ) == vr_21 ;
}
return vr_22 ;
}
private boolean fn_5 ( final StringBuilder string , final int vr_19 , final String vr_23 ) {
boolean vr_22 = false ;
if( vr_19 >= 0 &&
vr_19 + vr_23 . length () - 1 < string . length () ) {
final String vr_24 = string . vr_24 ( vr_19 , vr_19 + vr_23 . length () ) ;
vr_22 = vr_24 . equals ( vr_23 ) ;
}
return vr_22 ;
}
private boolean fn_4 ( final int vr_12 , final int vr_13 ) {
return vr_13 + 1 == vr_12 ;
}
@Override
public Object fn_8 ( final Object vr_25 ) throws vl_1 {
if ( ! ( vr_25 instanceof String ) ) { MST[NegateConditionalsMutator]MSP[]
throw new vl_1 ( lr_12 ) ;
}
return fn_1 ( ( String ) vr_25 ) ;
}
@Override
public String fn_8 ( final String vr_26 ) {
return fn_1 ( vr_26 ) ;
}
public boolean fn_9 ( final String vr_27 , final String vr_28 ) {
return fn_1 ( vr_27 ) . equals ( fn_1 ( vr_28 ) ) ;
}
public int vr_14 () { return this . vr_29 ; }
public void fn_10 ( final int vr_29 ) { this . vr_29 = vr_29 ; }
