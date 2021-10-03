@Override
public boolean fn_1 ( final tp_1 vr_1 ) {
return true ;
}
private void fn_2 () throws IOException
{
fn_2 ( true ) ;
}
private void fn_2 ( final boolean vr_2 ) throws IOException
{
vr_3 . clear () ;
String line = vr_4 . readLine () ;
if ( line == null ) {
throw new fn_3 ( lr_1 ) ;
}
vr_3 . add ( line ) ;
if ( vr_2 ) {
while( vr_5 . vr_6 ( line ) ) {
int vr_7 = vr_5 . vr_7 ( line ) ;
final boolean vr_8 = vr_7 >= 0 ;
while ( vr_7 >= 0 ) {
line = vr_4 . readLine () ;
if ( line == null ) {
throw new fn_3 ( lr_1 ) ;
}
vr_3 . add ( line ) ;
vr_7 -= line . length () + 2 ;
}
if ( vr_8 ) {
final tp_2 vr_9 = vl_1 ;
if ( vr_9 != null ) {
final boolean clear = vr_9 . fn_1 ( this ) ;
if ( clear ) {
fn_4 ( vr_5 . vr_10 , fn_5 () ) ;
vr_3 . clear () ;
}
}
}
line = vr_4 . readLine () ;
if ( line == null ) {
throw new fn_3 ( lr_1 ) ;
}
vr_3 . add ( line ) ;
}
vl_2 = vr_5 . vr_11 ( line ) ;
} else {
vl_2 = vr_5 . vr_12 ( line ) ;
}
fn_4 ( vl_2 , fn_5 () ) ;
}
@Override
protected void fn_4 ( final int vl_2 , final String vr_13 ) {
if ( fn_6 () . fn_7 () > 0 ) {
fn_6 () . fn_4 ( vl_2 , fn_5 () ) ;
}
}
@Override
protected void fn_8 () throws IOException
{
super . fn_8 () ;
vr_4 =
new fn_9 ( new fn_10 ( vl_3 ,
vl_4 ) ) ;
vl_5 =
new fn_11 ( new fn_12 ( vl_6 ,
vl_4 ) ) ;
final int vr_14 = fn_13 () ;
if ( vr_14 <= 0 ) {
fn_14 ( vl_7 ) ;
}
fn_2 ( false ) ;
if ( vr_14 <= 0 ) {
fn_14 ( vr_14 ) ;
}
fn_15 ( vr_15 . vr_16 ) ;
}
protected void fn_15 ( final tp_1 . vr_15 vr_17 )
{
this . vr_17 = vr_17 ;
}
public tp_1 . vr_15 fn_16 ()
{
return vr_17 ;
}
@Override
public void fn_17 () throws IOException
{
super . fn_17 () ;
vr_4 = null ;
vl_5 = null ;
vr_3 . clear () ;
fn_15 ( vr_15 . vr_18 ) ;
}
private int fn_18 ( final String vr_19 , final String vr_20 , final String args ) throws IOException
{
final StringBuilder vr_21 = new StringBuilder () ;
if ( vr_19 != null )
{
vr_21 . append ( vr_19 ) ;
vr_21 . append ( ' ' ) ;
}
vr_21 . append ( vr_20 ) ;
if ( args != null )
{
vr_21 . append ( ' ' ) ;
vr_21 . append ( args ) ;
}
vr_21 . append ( vr_22 . vr_23 ) ;
final String vr_24 = vr_21 . toString () ;
vl_5 . vr_25 ( vr_24 ) ;
vl_5 . vr_26 () ;
fn_19 ( vr_20 , vr_24 ) ;
fn_2 () ;
return vl_2 ;
}
public int fn_20 ( final String vr_20 , final String args ) throws IOException
{
return fn_18 ( fn_21 () , vr_20 , args ) ;
}
public int fn_20 ( final String vr_20 ) throws IOException
{
return fn_20 ( vr_20 , null ) ;
}
public int fn_20 ( final tp_3 vr_20 , final String args ) throws IOException
{
return fn_20 ( vr_20 . vr_27 () , args ) ;
}
public boolean fn_22 ( final tp_3 vr_20 , final String args ) throws IOException
{
return vr_5 . vr_28 ( fn_20 ( vr_20 , args ) ) ;
}
public int fn_20 ( final tp_3 vr_20 ) throws IOException
{
return fn_20 ( vr_20 , null ) ;
}
public boolean fn_22 ( final tp_3 vr_20 ) throws IOException
{
return vr_5 . vr_28 ( fn_20 ( vr_20 ) ) ;
}
public int fn_23 ( final String vr_20 ) throws IOException
{
return fn_18 ( null , vr_20 , null ) ;
}
public String [] fn_24 ()
{
return vr_3 . toArray ( new String [ vr_3 . size () ] ) ;
}
public String fn_5 ()
{
final StringBuilder vr_29 = new StringBuilder ( 256 ) ;
for ( final String vr_30 : vr_3 )
{
vr_29 . append ( vr_30 ) ;
vr_29 . append ( vr_22 . vr_23 ) ;
}
return vr_29 . toString () ;
}
public void fn_25 ( final tp_2 vr_31 ) {
vl_1 = vr_31 ;
}
protected String fn_21 ()
{
final String vr_32 = new String ( vl_8 ) ; MST[rv.UOI3Mutator]MSP[]
boolean vr_33 = true ;
for ( int vr_34 = vl_8 . length - 1 ; vr_33 && vr_34 >= 0 ; vr_34 -- )
{
if ( vl_8 [ vr_34 ] == 'Z' )
{
vl_8 [ vr_34 ] = 'A' ;
}
else
{
vl_8 [ vr_34 ] ++ ;
vr_33 = false ;
}
}
return vr_32 ;
}
static String fn_26 ( final String vr_35 ) {
if ( vr_35 == null ) {
return null ;
}
if ( vr_35 . isEmpty () ) {
return lr_2 ;
}
if ( vr_35 . length () > 1 && vr_35 . vr_36 ( lr_3 ) && vr_35 . vr_37 ( lr_3 ) ) {
return vr_35 ;
}
if ( vr_35 . contains ( lr_4 ) ) {
return lr_3 + vr_35 . vr_38 ( lr_5 , lr_6 ) + lr_3 ;
}
return vr_35 ;
}
