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
final ArrayList < vt_1 > vr_2 = new ArrayList <> () ;
final ArrayList < String > vr_3 = new ArrayList <> () ;
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
if ( vr_2 . size () != vr_8 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_3 . size () != vr_8 ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_6 [ vr_5 . vr_9 () ] != vl_5 ) {
throw new IllegalArgumentException (
lr_2 + vr_10 ) ;
}
default:
vr_4 . append ( vr_6 [ vr_5 . vr_9 () ] ) ;
fn_6 ( vr_5 ) ;
}
}
super . fn_2 ( vr_4 . toString () ) ;
fn_1 = fn_9 ( super . fn_1 () , vr_3 ) ;
if ( fn_10 ( vr_2 ) ) {
final vt_1 [] vr_14 = fn_11 () ;
int vr_15 = 0 ;
for ( final Iterator < vt_1 > vr_16 = vr_2 . iterator () ; vr_16 . hasNext () ; vr_15 ++ ) {
final vt_1 vr_17 = vr_16 . fn_6 () ;
if ( vr_17 != null ) {
vr_14 [ vr_15 ] = vr_17 ;
}
}
super . vr_18 ( vr_14 ) ;
}
}
@Override
public void fn_12 ( final int vr_19 , final vt_1 vr_20 ) {
throw new fn_13 () ;
}
@Override
public void fn_14 ( final int vr_21 ,
final vt_1 vr_20 ) {
throw new fn_13 () ;
}
@Override
public void vr_18 ( final vt_1 [] vr_22 ) {
throw new fn_13 () ;
}
@Override
public void fn_15 ( final vt_1 [] vr_22 ) {
throw new fn_13 () ;
}
@Override
public boolean equals ( final Object vr_23 ) {
if ( vr_23 == this ) {
return true ;
}
if ( vr_23 == null ) {
return false ;
}
if ( ! vr_24 . equals ( getClass () , vr_23 . getClass () ) ) {
return false ;
}
final tp_2 vr_25 = ( tp_2 ) vr_23 ;
if ( ! vr_24 . equals ( fn_1 , vr_25 . fn_1 ) ) {
return false ;
}
if ( ! super . equals ( vr_23 ) ) {
return false ;
}
return vr_24 . equals ( vl_1 , vr_25 . vl_1 ) ;
}
@Override
public int fn_16 () {
int vr_26 = super . fn_16 () ;
vr_26 = vl_6 * vr_26 + vr_24 . fn_16 ( vl_1 ) ;
vr_26 = vl_6 * vr_26 + vr_24 . fn_16 ( fn_1 ) ;
return vr_26 ;
}
private vt_1 fn_8 ( final String vr_27 ) {
if ( vl_1 != null ) {
String vr_28 = vr_27 ;
String args = null ;
final int vr_15 = vr_27 . indexOf ( vl_4 ) ;
if ( vr_15 > 0 ) {
vr_28 = vr_27 . vr_29 ( 0 , vr_15 ) . trim () ;
args = vr_27 . vr_29 ( vr_15 + 1 ) . trim () ;
}
final tp_3 vr_30 = vl_1 . get ( vr_28 ) ;
if ( vr_30 != null ) {
return vr_30 . fn_8 ( vr_28 , args , fn_17 () ) ;
}
}
return null ;
}
private int fn_5 ( final String vr_1 , final tp_1 vr_5 ) {
final int vr_10 = vr_5 . vr_9 () ;
fn_4 ( vr_1 , vr_5 ) ;
final StringBuilder vr_26 = new StringBuilder () ;
boolean error = false ;
for (; ! error && vr_5 . vr_9 () < vr_1 . length () ; fn_6 ( vr_5 ) ) {
char vr_6 = vr_1 . charAt ( vr_5 . vr_9 () ) ;
if ( vr_31 . vr_32 ( vr_6 ) ) {
fn_4 ( vr_1 , vr_5 ) ;
vr_6 = vr_1 . charAt ( vr_5 . vr_9 () ) ;
if ( vr_6 != vl_4 && vr_6 != vl_5 ) {
error = true ;
continue;
}
}
if ( ( vr_6 == vl_4 || vr_6 == vl_5 ) && vr_26 . length () > 0 ) {
try {
return Integer . vr_33 ( vr_26 . toString () ) ;
} catch ( final tp_4 vr_34 ) {
}
}
error = ! vr_31 . isDigit ( vr_6 ) ;
vr_26 . append ( vr_6 ) ;
}
if ( error ) {
throw new IllegalArgumentException (
lr_3 + vr_10 + lr_4
+ vr_1 . vr_29 ( vr_10 , vr_5 . vr_9 () ) ) ;
}
throw new IllegalArgumentException (
lr_5 + vr_10 ) ;
}
private String fn_7 ( final String vr_1 , final tp_1 vr_5 ) {
final int vr_10 = vr_5 . vr_9 () ;
fn_4 ( vr_1 , vr_5 ) ;
final int vr_35 = vr_5 . vr_9 () ;
int vr_36 = 1 ;
while ( vr_5 . vr_9 () < vr_1 . length () ) {
switch ( vr_1 . charAt ( vr_5 . vr_9 () ) ) {
case vl_3 :
vr_36 ++ ;
fn_6 ( vr_5 ) ;
break;
case vl_5 :
vr_36 -- ;
if ( vr_36 == 0 ) {
return vr_1 . vr_29 ( vr_35 , vr_5 . vr_9 () ) ;
}
fn_6 ( vr_5 ) ;
break;
case vl_2 :
fn_18 ( vr_1 , vr_5 ) ;
break;
default:
fn_6 ( vr_5 ) ;
break;
}
}
throw new IllegalArgumentException (
lr_5 + vr_10 ) ;
}
private String fn_9 ( final String vr_1 , final ArrayList < String > vr_37 ) {
if ( ! fn_10 ( vr_37 ) ) {
return vr_1 ;
}
final StringBuilder vr_38 = new StringBuilder ( vr_1 . length () * 2 ) ;
final tp_1 vr_5 = new tp_1 ( 0 ) ;
int vr_39 = - 1 ;
int vr_36 = 0 ;
while ( vr_5 . vr_9 () < vr_1 . length () ) {
final char vr_6 = vr_1 . charAt ( vr_5 . vr_9 () ) ;
switch ( vr_6 ) {
case vl_2 :
fn_3 ( vr_1 , vr_5 , vr_38 ) ;
break;
case vl_3 :
vr_36 ++ ;
vr_38 . append ( vl_3 ) . append ( fn_5 ( vr_1 , fn_6 ( vr_5 ) ) ) ;
if ( vr_36 == 1 ) {
vr_39 ++ ;
final String vr_40 = vr_37 . get ( vr_39 ) ;
if ( vr_40 != null ) {
vr_38 . append ( vl_4 ) . append ( vr_40 ) ;
}
}
break;
case vl_5 :
vr_36 -- ;
default:
vr_38 . append ( vr_6 ) ;
fn_6 ( vr_5 ) ;
}
}
return vr_38 . toString () ;
}
private void fn_4 ( final String vr_1 , final tp_1 vr_5 ) {
int vr_41 = 0 ;
final char [] vr_42 = vr_1 . vr_7 () ;
do {
vr_41 = vr_43 . vr_44 . vr_45 () . fn_19 ( vr_42 , vr_5 . vr_9 () , 0 , vr_42 . length ) ;
vr_5 . vr_46 ( vr_5 . vr_9 () + vr_41 ) ;
} while ( vr_41 > 0 && vr_5 . vr_9 () < vr_1 . length () );
}
private tp_1 fn_6 ( final tp_1 vr_5 ) {
vr_5 . vr_46 ( vr_5 . vr_9 () + 1 ) ;
return vr_5 ;
}
private StringBuilder fn_3 ( final String vr_1 , final tp_1 vr_5 ,
final StringBuilder vr_47 ) {
assert vr_1 . vr_7 () [ vr_5 . vr_9 () ] == vl_2
: lr_6 ;
if ( vr_47 != null ) {
vr_47 . append ( vl_2 ) ;
}
fn_6 ( vr_5 ) ;
final int vr_10 = vr_5 . vr_9 () ;
final char [] vr_6 = vr_1 . vr_7 () ;
final int vr_48 = vr_10 ;
for ( int vr_15 = vr_5 . vr_9 () ; vr_15 < vr_1 . length () ; vr_15 ++ ) {
switch ( vr_6 [ vr_5 . vr_9 () ] ) {
case vl_2 :
fn_6 ( vr_5 ) ;
return vr_47 == null ? null : vr_47 . append ( vr_6 , vr_48 ,
vr_5 . vr_9 () - vr_48 ) ;
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
private boolean fn_10 ( final Collection < ? > vr_49 ) {
if ( vr_49 == null || vr_49 . isEmpty () ) {
return false ;
}
for ( final Object vr_28 : vr_49 ) {
if ( vr_28 != null ) {
return true ;
}
}
return false ;
}
