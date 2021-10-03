public void fn_1 ( final String vr_1 ) {
if ( vr_1 == null || vr_1 . length () == 0 ) {
return;
}
if ( vl_1 == null ) {
vl_1 = new ArrayList <> () ;
}
vl_2 = true ;
for( final String vr_2 : vr_1 . vr_3 ( lr_1 ) ) {
vl_1 . add ( vr_2 ) ;
}
}
public String [] fn_2 () {
if ( vl_1 == null ) {
return new String [ 0 ] ;
}
return vl_1 . toArray ( new String [ vl_1 . size () ] ) ;
}
private void fn_3 () {
int vr_4 = 0 ;
final String vr_5 = fn_4 () ;
final int vr_6 = vr_5 . length () ;
boolean vr_7 = false ;
while ( ! vr_7 ) {
vr_7 = true ;
while ( vr_4 < vr_6 && vr_5 . charAt ( vr_4 ) == ' ' ) {
vr_4 ++ ;
}
if ( vr_4 < ( vr_6 - 2 )
&& ( vr_5 . charAt ( vr_4 ) == 'r' || vr_5 . charAt ( vr_4 ) == 'R' )
&& ( vr_5 . charAt ( vr_4 + 1 ) == 'e' || vr_5 . charAt ( vr_4 + 1 ) == 'E' ) ) {
if ( vr_5 . charAt ( vr_4 + 2 ) == ':' ) {
vr_4 += 3 ;
vr_7 = false ;
} else if (
vr_4 < ( vr_6 - 2 )
&&
( vr_5 . charAt ( vr_4 + 2 ) == '[' || vr_5 . charAt ( vr_4 + 2 ) == '(' ) ) {
int vr_8 = vr_4 + 3 ;
while ( vr_8 < vr_6 && vr_5 . charAt ( vr_8 ) >= '0' && vr_5 . charAt ( vr_8 ) <= '9' ) {
vr_8 ++ ;
}
if ( vr_8 < ( vr_6 - 1 )
&& ( vr_5 . charAt ( vr_8 ) == ']' || vr_5 . charAt ( vr_8 ) == ')' )
&& vr_5 . charAt ( vr_8 + 1 ) == ':' )
{
vr_4 = vr_8 + 2 ;
vr_7 = false ;
}
}
}
if ( lr_2 . equals ( vl_3 ) ) {
vl_3 = lr_3 ;
}
int vr_9 = vr_6 ;
while ( vr_9 > vr_4 && vr_5 . charAt ( vr_9 - 1 ) < ' ' ) {
vr_9 -- ;
}
if ( vr_4 == 0 && vr_9 == vr_6 ) {
vl_3 = vr_5 ;
} else {
vl_3 = vr_5 . vr_10 ( vr_4 , vr_9 ) ;
}
}
}
public static void fn_5 ( final tp_1 vr_11 ) {
fn_5 ( vr_11 , 0 , System . out ) ;
}
public static void fn_5 ( final tp_1 vr_11 , final tp_2 vr_12 ) {
fn_5 ( vr_11 , 0 , vr_12 ) ;
}
public static void fn_5 ( final tp_1 vr_11 , final int vr_13 ) {
fn_5 ( vr_11 , vr_13 , System . out ) ;
}
public static void fn_5 ( final tp_1 vr_11 , final int vr_13 , final tp_2 vr_12 ) {
for ( int vr_8 = 0 ; vr_8 < vr_13 ; ++ vr_8 ) {
vr_12 . vr_14 ( lr_4 ) ;
}
vr_12 . println ( vr_11 . fn_4 () + lr_5 + vr_11 . vr_15 () + lr_5 + vr_11 . vr_16 () ) ;
if ( vr_11 . vr_17 != null ) {
fn_5 ( vr_11 . vr_17 , vr_13 + 1 ) ;
}
if ( vr_11 . vr_18 != null ) {
fn_5 ( vr_11 . vr_18 , vr_13 ) ;
}
}
public String vr_16 () {
return vl_4 ;
}
public long fn_6 () {
return vl_5 ;
}
public String fn_7 () {
return vl_6 ;
}
public String vr_15 () {
return vl_7 ;
}
public String fn_4 () {
return vr_5 ;
}
public void fn_8 ( final String string ) {
vl_4 = string ;
}
public void fn_9 ( final long vr_19 ) {
vl_5 = vr_19 ;
}
public void fn_10 ( final String string ) {
vl_6 = string ;
}
public void fn_11 ( final String string ) {
vl_7 = string ;
}
public void fn_12 ( final String string ) {
vr_5 = string ;
}
@Override
public boolean fn_13 () {
return ( vl_5 == - 1 ) ;
}
@Override
public String fn_14 () {
return vl_4 ;
}
@Override
public String [] fn_15 () {
return fn_2 () ;
}
@Override MST[ReturnValsMutator]MSP[]
public String vl_3 () {
if( vl_3 == null ) {
fn_3 () ;
}
return vl_3 ;
}
@Override
public boolean fn_16 () {
return vl_2 ;
}
@Override
public void fn_17 ( final tp_3 vr_20 ) {
this . vr_17 = ( tp_1 ) vr_20 ;
fn_18 () ;
}
private void fn_18 () {
vl_3 = null ;
}
@Override
public void fn_19 ( final tp_3 vr_18 ) {
this . vr_18 = ( tp_1 ) vr_18 ;
fn_18 () ;
}
@Override
public tp_3 fn_20 () {
return new tp_1 () ;
}
@Override
public String toString () {
return vl_5 + lr_1 + vl_4 + lr_1 + vr_5 ;
}
@Deprecated
public int fn_21 () {
return ( int ) vl_5 ;
}
@Deprecated
public void fn_9 ( final int vr_21 ) {
vl_5 = vr_21 ;
}
@Deprecated
public void fn_22 ( final String vr_22 , final String vr_23 ) {
}
