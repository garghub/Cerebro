private void fn_1 () {
if ( vl_1 )
return;
final int vr_1 = vl_2 ;
if ( vr_1 < vl_3 )
return;
try {
final long vr_2 = vr_3 . vr_4 ( vr_1 ) ;
vr_3 . vr_5 ( vl_4 ) ;
int vr_6 = 0 ;
while ( vr_6 <= vl_5 ) {
int vr_7 = vr_3 . vr_6 ( vl_6 , vr_6 , vl_6 . length - vr_6 ) ;
if ( vr_7 == - 1 )
vl_1 = true ;
if ( vr_7 <= 0 )
break;
vr_6 += vr_7 ;
}
vr_3 . vr_8 () ;
if ( vr_6 > 0 ) {
vr_9 . vr_10 ( vr_2 == vr_1 ) ;
vl_7 = vr_6 ;
vl_8 += vr_1 ;
vl_2 = 0 ;
vl_9 = - 1 ;
vl_3 = vl_7 > vl_10 ? vl_10 : vl_7 ;
}
} catch ( IOException vr_11 ) {
throw new fn_2 ( vr_11 ) ;
}
}
public int vr_1 () {
return vl_8 + vl_2 ;
}
public boolean isEmpty () {
fn_1 () ;
return vl_2 >= vl_7 ;
}
private boolean fn_3 () {
return vl_2 >= vl_7 ;
}
public char fn_4 () {
fn_1 () ;
return fn_3 () ? vl_11 : vl_6 [ vl_2 ] ;
}
char fn_5 () {
fn_1 () ;
char vr_12 = fn_3 () ? vl_11 : vl_6 [ vl_2 ] ;
vl_2 ++ ;
return vr_12 ;
}
void fn_6 () {
if ( vl_2 < 1 )
throw new fn_2 ( new IOException ( lr_1 ) ) ;
vl_2 -- ;
}
public void fn_7 () {
vl_2 ++ ;
}
void vr_5 () {
if ( vl_7 - vl_2 < vl_5 )
vl_3 = 0 ;
fn_1 () ;
vl_9 = vl_2 ;
}
void fn_8 () {
vl_9 = - 1 ;
}
void fn_9 () {
if ( vl_9 == - 1 )
throw new fn_2 ( new IOException ( lr_2 ) ) ;
vl_2 = vl_9 ;
fn_8 () ;
}
int fn_10 ( char vr_13 ) {
fn_1 () ;
for ( int vr_14 = vl_2 ; vr_14 < vl_7 ; vr_14 ++ ) {
if ( vr_13 == vl_6 [ vr_14 ] )
return vr_14 - vl_2 ;
}
return - 1 ;
}
int fn_10 ( tp_1 vr_15 ) {
fn_1 () ;
char vr_16 = vr_15 . charAt ( 0 ) ;
for ( int vr_17 = vl_2 ; vr_17 < vl_7 ; vr_17 ++ ) {
if ( vr_16 != vl_6 [ vr_17 ] )
while( ++ vr_17 < vl_7 && vr_16 != vl_6 [ vr_17 ] ) { }
int vr_14 = vr_17 + 1 ; MST[rv.CRCR5Mutator]MSP[N]
int vr_18 = vr_14 + vr_15 . length () - 1 ;
if ( vr_17 < vl_7 && vr_18 <= vl_7 ) {
for ( int vr_19 = 1 ; vr_14 < vr_18 && vr_15 . charAt ( vr_19 ) == vl_6 [ vr_14 ] ; vr_14 ++ , vr_19 ++ ) { }
if ( vr_14 == vr_18 )
return vr_17 - vl_2 ;
}
}
return - 1 ;
}
public String fn_11 ( char vr_13 ) {
int vr_17 = fn_10 ( vr_13 ) ;
if ( vr_17 != - 1 ) {
String vr_20 = fn_12 ( vl_6 , vl_12 , vl_2 , vr_17 ) ;
vl_2 += vr_17 ;
return vr_20 ;
} else {
return fn_13 () ;
}
}
String fn_11 ( String vr_15 ) {
int vr_17 = fn_10 ( vr_15 ) ;
if ( vr_17 != - 1 ) {
String vr_20 = fn_12 ( vl_6 , vl_12 , vl_2 , vr_17 ) ;
vl_2 += vr_17 ;
return vr_20 ;
} else if ( vl_7 - vl_2 < vr_15 . length () ) {
return fn_13 () ;
} else {
int vr_21 = vl_7 - vr_15 . length () + 1 ;
String vr_20 = fn_12 ( vl_6 , vl_12 , vl_2 , vr_21 - vl_2 ) ;
vl_2 = vr_21 ;
return vr_20 ;
}
}
public String fn_14 ( final char ... vr_22 ) {
fn_1 () ;
int vr_1 = vl_2 ;
final int vr_23 = vr_1 ;
final int vr_24 = vl_7 ;
final char [] vr_12 = vl_6 ;
final int vr_25 = vr_22 . length ;
int vr_14 ;
lb_1: while ( vr_1 < vr_24 ) {
for ( vr_14 = 0 ; vr_14 < vr_25 ; vr_14 ++ ) {
if ( vr_12 [ vr_1 ] == vr_22 [ vr_14 ] )
break lb_1;
}
vr_1 ++ ;
}
vl_2 = vr_1 ;
return vr_1 > vr_23 ? fn_12 ( vl_6 , vl_12 , vr_23 , vr_1 - vr_23 ) : lr_3 ;
}
String fn_15 ( final char ... vr_22 ) {
fn_1 () ;
int vr_1 = vl_2 ;
final int vr_23 = vr_1 ;
final int vr_24 = vl_7 ;
final char [] vr_12 = vl_6 ;
while ( vr_1 < vr_24 ) {
if ( vr_26 . vr_27 ( vr_22 , vr_12 [ vr_1 ] ) >= 0 )
break;
vr_1 ++ ;
}
vl_2 = vr_1 ;
return vl_2 > vr_23 ? fn_12 ( vl_6 , vl_12 , vr_23 , vr_1 - vr_23 ) : lr_3 ;
}
String fn_16 () {
int vr_1 = vl_2 ;
final int vr_23 = vr_1 ;
final int vr_24 = vl_7 ;
final char [] vr_12 = vl_6 ;
lb_1: while ( vr_1 < vr_24 ) {
switch ( vr_12 [ vr_1 ] ) {
case '&' :
case '<' :
case vr_28 . vr_29 :
break lb_1;
default:
vr_1 ++ ;
}
}
vl_2 = vr_1 ;
return vr_1 > vr_23 ? fn_12 ( vl_6 , vl_12 , vr_23 , vr_1 - vr_23 ) : lr_3 ;
}
String fn_17 () {
int vr_1 = vl_2 ;
final int vr_23 = vr_1 ;
final int vr_24 = vl_7 ;
final char [] vr_12 = vl_6 ;
lb_1: while ( vr_1 < vr_24 ) {
switch ( vr_12 [ vr_1 ] ) {
case '<' :
case vr_28 . vr_29 :
break lb_1;
default:
vr_1 ++ ;
}
}
vl_2 = vr_1 ;
return vr_1 > vr_23 ? fn_12 ( vl_6 , vl_12 , vr_23 , vr_1 - vr_23 ) : lr_3 ;
}
String fn_18 () {
fn_1 () ;
int vr_1 = vl_2 ;
final int vr_23 = vr_1 ;
final int vr_24 = vl_7 ;
final char [] vr_12 = vl_6 ;
lb_1: while ( vr_1 < vr_24 ) {
switch ( vr_12 [ vr_1 ] ) {
case '\t' :
case '\n' :
case '\r' :
case '\f' :
case ' ' :
case '/' :
case '>' :
case '<' :
case vr_28 . vr_29 :
break lb_1;
}
vr_1 ++ ;
}
vl_2 = vr_1 ;
return vr_1 > vr_23 ? fn_12 ( vl_6 , vl_12 , vr_23 , vr_1 - vr_23 ) : lr_3 ;
}
String fn_13 () {
fn_1 () ;
String vr_30 = fn_12 ( vl_6 , vl_12 , vl_2 , vl_7 - vl_2 ) ;
vl_2 = vl_7 ;
return vr_30 ;
}
String fn_19 () {
fn_1 () ;
int vr_23 = vl_2 ;
while ( vl_2 < vl_7 ) {
char vr_13 = vl_6 [ vl_2 ] ;
if ( ( vr_13 >= 'A' && vr_13 <= 'Z' ) || ( vr_13 >= 'a' && vr_13 <= 'z' ) || vr_31 . vr_32 ( vr_13 ) )
vl_2 ++ ;
else
break;
}
return fn_12 ( vl_6 , vl_12 , vr_23 , vl_2 - vr_23 ) ;
}
String fn_20 () {
fn_1 () ;
int vr_23 = vl_2 ;
while ( vl_2 < vl_7 ) {
char vr_13 = vl_6 [ vl_2 ] ;
if ( ( vr_13 >= 'A' && vr_13 <= 'Z' ) || ( vr_13 >= 'a' && vr_13 <= 'z' ) || vr_31 . vr_32 ( vr_13 ) )
vl_2 ++ ;
else
break;
}
while ( ! fn_3 () ) {
char vr_13 = vl_6 [ vl_2 ] ;
if ( vr_13 >= '0' && vr_13 <= '9' )
vl_2 ++ ;
else
break;
}
return fn_12 ( vl_6 , vl_12 , vr_23 , vl_2 - vr_23 ) ;
}
String fn_21 () {
fn_1 () ;
int vr_23 = vl_2 ;
while ( vl_2 < vl_7 ) {
char vr_13 = vl_6 [ vl_2 ] ;
if ( ( vr_13 >= '0' && vr_13 <= '9' ) || ( vr_13 >= 'A' && vr_13 <= 'F' ) || ( vr_13 >= 'a' && vr_13 <= 'f' ) )
vl_2 ++ ;
else
break;
}
return fn_12 ( vl_6 , vl_12 , vr_23 , vl_2 - vr_23 ) ;
}
String fn_22 () {
fn_1 () ;
int vr_23 = vl_2 ;
while ( vl_2 < vl_7 ) {
char vr_13 = vl_6 [ vl_2 ] ;
if ( vr_13 >= '0' && vr_13 <= '9' )
vl_2 ++ ;
else
break;
}
return fn_12 ( vl_6 , vl_12 , vr_23 , vl_2 - vr_23 ) ;
}
boolean fn_23 ( char vr_13 ) {
return ! isEmpty () && vl_6 [ vl_2 ] == vr_13 ;
}
boolean fn_23 ( String vr_15 ) {
fn_1 () ;
int vr_33 = vr_15 . length () ;
if ( vr_33 > vl_7 - vl_2 )
return false ;
for ( int vr_17 = 0 ; vr_17 < vr_33 ; vr_17 ++ )
if ( vr_15 . charAt ( vr_17 ) != vl_6 [ vl_2 + vr_17 ] )
return false ;
return true ;
}
boolean fn_24 ( String vr_15 ) {
fn_1 () ;
int vr_33 = vr_15 . length () ;
if ( vr_33 > vl_7 - vl_2 )
return false ;
for ( int vr_17 = 0 ; vr_17 < vr_33 ; vr_17 ++ ) {
char vr_34 = vr_31 . vr_35 ( vr_15 . charAt ( vr_17 ) ) ;
char vr_36 = vr_31 . vr_35 ( vl_6 [ vl_2 + vr_17 ] ) ;
if ( vr_34 != vr_36 )
return false ;
}
return true ;
}
boolean fn_25 ( char ... vr_15 ) {
if ( isEmpty () )
return false ;
fn_1 () ;
char vr_13 = vl_6 [ vl_2 ] ;
for ( char vr_37 : vr_15 ) {
if ( vr_37 == vr_13 )
return true ;
}
return false ;
}
boolean fn_26 ( char [] vr_15 ) {
fn_1 () ;
return ! isEmpty () && vr_26 . vr_27 ( vr_15 , vl_6 [ vl_2 ] ) >= 0 ;
}
boolean fn_27 () {
if ( isEmpty () )
return false ;
char vr_13 = vl_6 [ vl_2 ] ;
return ( vr_13 >= 'A' && vr_13 <= 'Z' ) || ( vr_13 >= 'a' && vr_13 <= 'z' ) || vr_31 . vr_32 ( vr_13 ) ;
}
boolean fn_28 () {
if ( isEmpty () )
return false ;
char vr_13 = vl_6 [ vl_2 ] ;
return ( vr_13 >= '0' && vr_13 <= '9' ) ;
}
boolean fn_29 ( String vr_15 ) {
fn_1 () ;
if ( fn_23 ( vr_15 ) ) {
vl_2 += vr_15 . length () ;
return true ;
} else {
return false ;
}
}
boolean fn_30 ( String vr_15 ) {
if ( fn_24 ( vr_15 ) ) {
vl_2 += vr_15 . length () ;
return true ;
} else {
return false ;
}
}
boolean fn_31 ( String vr_15 ) {
String vr_38 = vr_15 . vr_39 ( vr_40 . vr_41 ) ;
String vr_42 = vr_15 . vr_35 ( vr_40 . vr_41 ) ;
return ( fn_10 ( vr_38 ) > - 1 ) || ( fn_10 ( vr_42 ) > - 1 ) ;
}
@Override
public String toString () {
return new String ( vl_6 , vl_2 , vl_7 - vl_2 ) ;
}
private static String fn_12 ( final char [] vl_6 , final String [] vl_12 , final int vr_23 , final int vr_43 ) {
if ( vr_43 > vl_13 )
return new String ( vl_6 , vr_23 , vr_43 ) ;
if ( vr_43 < 1 )
return lr_3 ;
int vr_44 = 0 ;
int vr_17 = vr_23 ;
for ( int vr_14 = 0 ; vr_14 < vr_43 ; vr_14 ++ ) {
vr_44 = 31 * vr_44 + vl_6 [ vr_17 ++ ] ;
}
final int vr_45 = vr_44 & vl_12 . length - 1 ;
String vr_46 = vl_12 [ vr_45 ] ;
if ( vr_46 == null ) {
vr_46 = new String ( vl_6 , vr_23 , vr_43 ) ;
vl_12 [ vr_45 ] = vr_46 ;
} else {
if ( fn_32 ( vl_6 , vr_23 , vr_43 , vr_46 ) ) {
return vr_46 ;
} else {
vr_46 = new String ( vl_6 , vr_23 , vr_43 ) ;
vl_12 [ vr_45 ] = vr_46 ;
}
}
return vr_46 ;
}
static boolean fn_32 ( final char [] vl_6 , final int vr_23 , int vr_43 , final String vr_46 ) {
if ( vr_43 == vr_46 . length () ) {
int vr_14 = vr_23 ;
int vr_19 = 0 ;
while ( vr_43 -- != 0 ) {
if ( vl_6 [ vr_14 ++ ] != vr_46 . charAt ( vr_19 ++ ) )
return false ;
}
return true ;
}
return false ;
}
boolean fn_32 ( final int vr_23 , final int vr_43 , final String vr_46 ) {
return fn_32 ( vl_6 , vr_23 , vr_43 , vr_46 ) ;
}
