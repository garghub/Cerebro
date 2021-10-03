@Override
public String fn_1 () {
return fn_1 ;
}
@Override
public final void fn_2 ( final String vr_1 ) {
if ( vl_1 == null ) {
super . fn_2 ( vr_1 ) ;
fn_1 = super . fn_1 () ;
return;
}
final ArrayList < vt_1 > vr_2 = new ArrayList < vt_1 > () ;
final ArrayList < String > vr_3 = new ArrayList < String > () ;
final StringBuilder vr_4 = new StringBuilder ( vr_1 . length () ) ;
final tp_1 vr_5 = new tp_1 ( 0 ) ;
final char [] vr_6 = vr_1 . vr_7 () ;
int vr_8 = 0 ;
while ( vr_5 . vr_9 () < vr_1 . length () ) {
switch ( vr_6 [ vr_5 . vr_9 () ] ) {
case vl_2 :
fn_3 ( vr_1 , vr_5 , vr_4 ) ;
break;
case vl_3 :
vr_8 ++ ;
fn_4 ( vr_1 , vr_5 ) ;
final int vr_10 = vr_5 . vr_9 () ;
final int vr_11 = fn_5 ( vr_1 , fn_6 ( vr_5 ) ) ;
vr_4 . append ( vl_3 ) . append ( vr_11 ) ;
fn_4 ( vr_1 , vr_5 ) ;
vt_1 vr_12 = null ;
String vr_13 = null ;
if ( vr_6 [ vr_5 . vr_9 () ] == vl_4 ) {
vr_13 = fn_7 ( vr_1 ,
fn_6 ( vr_5 ) ) ;
vr_12 = fn_8 ( vr_13 ) ;
if ( vr_12 == null ) {
vr_4 . append ( vl_4 ) . append ( vr_13 ) ;
}
}
vr_2 . add ( vr_12 ) ;
vr_3 . add ( vr_12 == null ? null : vr_13 ) ;
vr_14 . vr_15 ( vr_2 . size () == vr_8 ) ;
vr_14 . vr_15 ( vr_3 . size () == vr_8 ) ;
if ( vr_6 [ vr_5 . vr_9 () ] != vl_5 ) {
throw new IllegalArgumentException (
lr_1 + vr_10 ) ;
}
default:
vr_4 . append ( vr_6 [ vr_5 . vr_9 () ] ) ;
fn_6 ( vr_5 ) ;
}
}
super . fn_2 ( vr_4 . toString () ) ;
fn_1 = fn_9 ( super . fn_1 () , vr_3 ) ;
if ( fn_10 ( vr_2 ) ) {
final vt_1 [] vr_16 = fn_11 () ;
int vr_17 = 0 ;
for ( final Iterator < vt_1 > vr_18 = vr_2 . iterator () ; vr_18 . hasNext () ; vr_17 ++ ) {
final vt_1 vr_19 = vr_18 . fn_6 () ;
if ( vr_19 != null ) {
vr_16 [ vr_17 ] = vr_19 ;
}
}
super . vr_20 ( vr_16 ) ;
}
}
@Override
public void fn_12 ( final int vr_21 , final vt_1 vr_22 ) {
throw new fn_13 () ;
}
@Override
public void fn_14 ( final int vr_23 , final vt_1 vr_22 ) {
throw new fn_13 () ;
}
@Override
public void vr_20 ( final vt_1 [] vr_24 ) {
throw new fn_13 () ;
}
@Override
public void fn_15 ( final vt_1 [] vr_24 ) {
throw new fn_13 () ;
}
@Override
public boolean equals ( final Object vr_25 ) {
if ( vr_25 == this ) {
return true ;
}
if ( vr_25 == null ) {
return false ;
}
if ( ! super . equals ( vr_25 ) ) {
return false ;
}
if ( vr_26 . vr_27 ( getClass () , vr_25 . getClass () ) ) {
return false ;
}
final tp_2 vr_28 = ( tp_2 ) vr_25 ;
if ( vr_26 . vr_27 ( fn_1 , vr_28 . fn_1 ) ) {
return false ;
}
if ( vr_26 . vr_27 ( vl_1 , vr_28 . vl_1 ) ) {
return false ;
}
return true ;
}
@SuppressWarnings ( lr_2 )
@Override
public int fn_16 () {
int vr_29 = super . fn_16 () ;
vr_29 = vl_6 * vr_29 + vr_26 . fn_16 ( vl_1 ) ;
vr_29 = vl_6 * vr_29 + vr_26 . fn_16 ( fn_1 ) ;
return vr_29 ;
}
private vt_1 fn_8 ( final String vr_30 ) {
if ( vl_1 != null ) {
String vr_31 = vr_30 ;
String args = null ;
final int vr_17 = vr_30 . indexOf ( vl_4 ) ;
if ( vr_17 > 0 ) {
vr_31 = vr_30 . vr_32 ( 0 , vr_17 ) . trim () ;
args = vr_30 . vr_32 ( vr_17 + 1 ) . trim () ;
}
final tp_3 vr_33 = vl_1 . get ( vr_31 ) ;
if ( vr_33 != null ) {
return vr_33 . fn_8 ( vr_31 , args , fn_17 () ) ;
}
}
return null ;
}
private int fn_5 ( final String vr_1 , final tp_1 vr_5 ) {
final int vr_10 = vr_5 . vr_9 () ;
fn_4 ( vr_1 , vr_5 ) ;
final StringBuilder vr_29 = new StringBuilder () ;
boolean error = false ;
for (; ! error && vr_5 . vr_9 () < vr_1 . length () ; fn_6 ( vr_5 ) ) {
char vr_6 = vr_1 . charAt ( vr_5 . vr_9 () ) ;
if ( vr_34 . vr_35 ( vr_6 ) ) {
fn_4 ( vr_1 , vr_5 ) ;
vr_6 = vr_1 . charAt ( vr_5 . vr_9 () ) ;
if ( vr_6 != vl_4 && vr_6 != vl_5 ) {
error = true ;
continue;
}
}
if ( ( vr_6 == vl_4 || vr_6 == vl_5 ) && vr_29 . length () > 0 ) {
try {
return Integer . vr_36 ( vr_29 . toString () ) ;
} catch ( final tp_4 vr_37 ) {
}
}
error = ! vr_34 . isDigit ( vr_6 ) ;
vr_29 . append ( vr_6 ) ;
}
if ( error ) {
throw new IllegalArgumentException (
lr_3 + vr_10 + lr_4
+ vr_1 . vr_32 ( vr_10 , vr_5 . vr_9 () ) ) ;
}
throw new IllegalArgumentException (
lr_5 + vr_10 ) ;
}
private String fn_7 ( final String vr_1 , final tp_1 vr_5 ) {
final int vr_10 = vr_5 . vr_9 () ;
fn_4 ( vr_1 , vr_5 ) ;
final int vr_38 = vr_5 . vr_9 () ;
int vr_39 = 1 ;
for (; vr_5 . vr_9 () < vr_1 . length () ; fn_6 ( vr_5 ) ) {
switch ( vr_1 . charAt ( vr_5 . vr_9 () ) ) {
case vl_3 :
vr_39 ++ ;
break;
case vl_5 :
vr_39 -- ;
if ( vr_39 == 0 ) {
return vr_1 . vr_32 ( vr_38 , vr_5 . vr_9 () ) ;
}
break;
case vl_2 :
fn_18 ( vr_1 , vr_5 ) ;
break;
default:
break;
}
}
throw new IllegalArgumentException (
lr_5 + vr_10 ) ;
}
private String fn_9 ( final String vr_1 , final ArrayList < String > vr_40 ) {
if ( ! fn_10 ( vr_40 ) ) {
return vr_1 ;
}
final StringBuilder vr_41 = new StringBuilder ( vr_1 . length () * 2 ) ;
final tp_1 vr_5 = new tp_1 ( 0 ) ;
int vr_42 = - 1 ;
int vr_39 = 0 ;
while ( vr_5 . vr_9 () < vr_1 . length () ) {
final char vr_6 = vr_1 . charAt ( vr_5 . vr_9 () ) ;
switch ( vr_6 ) {
case vl_2 :
fn_3 ( vr_1 , vr_5 , vr_41 ) ;
break;
case vl_3 :
vr_39 ++ ;
vr_41 . append ( vl_3 ) . append ( fn_5 ( vr_1 , fn_6 ( vr_5 ) ) ) ;
if ( vr_39 == 1 ) {
vr_42 ++ ;
final String vr_43 = vr_40 . get ( vr_42 ) ;
if ( vr_43 != null ) {
vr_41 . append ( vl_4 ) . append ( vr_43 ) ;
}
}
break;
case vl_5 :
vr_39 -- ;
default:
vr_41 . append ( vr_6 ) ;
fn_6 ( vr_5 ) ;
}
}
return vr_41 . toString () ;
}
private void fn_4 ( final String vr_1 , final tp_1 vr_5 ) {
int vr_44 = 0 ;
final char [] vr_45 = vr_1 . vr_7 () ;
do {
vr_44 = vr_46 . vr_47 () . fn_19 ( vr_45 , vr_5 . vr_9 () ) ;
vr_5 . vr_48 ( vr_5 . vr_9 () + vr_44 ) ;
} while ( vr_44 > 0 && vr_5 . vr_9 () < vr_1 . length () );
}
private tp_1 fn_6 ( final tp_1 vr_5 ) {
vr_5 . vr_48 ( vr_5 . vr_9 () + 1 ) ;
return vr_5 ;
}
private StringBuilder fn_3 ( final String vr_1 , final tp_1 vr_5 ,
final StringBuilder vr_49 ) {
assert vr_1 . vr_7 () [ vr_5 . vr_9 () ] == vl_2 :
lr_6 ;
if( vr_49 != null ) {
vr_49 . append ( vl_2 ) ;
}
fn_6 ( vr_5 ) ;
final int vr_10 = vr_5 . vr_9 () ;
final char [] vr_6 = vr_1 . vr_7 () ;
int vr_50 = vr_10 ;
for ( int vr_17 = vr_5 . vr_9 () ; vr_17 < vr_1 . length () ; vr_17 ++ ) {
switch ( vr_6 [ vr_5 . vr_9 () ] ) {
case vl_2 :
fn_6 ( vr_5 ) ;
return vr_49 == null ? null : vr_49 . append ( vr_6 , vr_50 ,
vr_5 . vr_9 () - vr_50 ) ;
default:
fn_6 ( vr_5 ) ;
}
}
throw new IllegalArgumentException (
lr_7 + vr_10 ) ;
}
private void fn_18 ( final String vr_1 , final tp_1 vr_5 ) {
fn_3 ( vr_1 , vr_5 , null ) ;
}
private boolean fn_10 ( final Collection < ? > vr_51 ) {
if ( vr_51 == null || vr_51 . isEmpty () ) {
return false ;
}
for ( final Object vr_31 : vr_51 ) {
if ( vr_31 != null ) {
return true ;
}
}
return false ;
}
