private int fn_1 ( final String vr_1 , final String args , final boolean vr_2 )
throws IOException
{
final StringBuilder vr_3 = new StringBuilder () ;
vr_3 . append ( vr_1 ) ;
if ( args != null )
{
if ( vr_2 ) {
vr_3 . append ( ' ' ) ;
}
vr_3 . append ( args ) ;
}
vr_3 . append ( vr_4 . vr_5 ) ;
final String vr_6 = vr_3 . toString () ;
vr_7 . vr_8 ( vr_6 ) ;
vr_7 . vr_9 () ;
fn_2 ( vr_1 , vr_6 ) ;
fn_3 () ;
return vl_1 ;
}
private int fn_1 ( final int vr_1 , final String args , final boolean vr_2 )
throws IOException
{
return fn_1 ( vr_10 . vr_11 ( vr_1 ) , args , vr_2 ) ;
}
private void fn_3 () throws IOException
{
int length ;
vl_2 = true ;
vr_12 . clear () ;
String line = vr_13 . readLine () ;
if ( line == null ) {
throw new fn_4 (
lr_1 ) ;
}
length = line . length () ;
if ( length < 3 ) {
throw new fn_5 (
lr_2 + line ) ;
}
try
{
final String vr_14 = line . vr_15 ( 0 , 3 ) ;
vl_1 = Integer . vr_16 ( vr_14 ) ;
}
catch ( final tp_1 vr_17 )
{
throw new fn_5 (
lr_3 + line ) ;
}
vr_12 . add ( line ) ;
if ( length > 3 && line . charAt ( 3 ) == '-' )
{
do
{
line = vr_13 . readLine () ;
if ( line == null ) {
throw new fn_4 (
lr_1 ) ;
}
vr_12 . add ( line ) ;
}
while ( ! ( line . length () >= 4 && line . charAt ( 3 ) != '-' &&
vr_18 . isDigit ( line . charAt ( 0 ) ) ) );
}
fn_6 ( vl_1 , fn_7 () ) ;
if ( vl_1 == vr_19 . vr_20 ) {
throw new fn_4 (
lr_4 ) ;
}
}
@Override
protected void fn_8 () throws IOException
{
super . fn_8 () ;
vr_13 =
new fn_9 ( new fn_10 ( vl_3 ,
vl_4 ) ) ;
vr_7 =
new fn_11 ( new fn_12 ( vl_5 ,
vl_4 ) ) ;
fn_3 () ;
}
@Override
public void fn_13 () throws IOException
{
super . fn_13 () ;
vr_13 = null ;
vr_7 = null ;
vl_6 = null ;
vr_12 . clear () ;
vl_2 = false ;
}
public int fn_14 ( final String vr_1 , final String args ) throws IOException
{
return fn_1 ( vr_1 , args , true ) ;
}
public int fn_14 ( final int vr_1 , final String args ) throws IOException
{
return fn_14 ( vr_10 . vr_11 ( vr_1 ) , args ) ;
}
public int fn_14 ( final String vr_1 ) throws IOException
{
return fn_14 ( vr_1 , null ) ;
}
public int fn_14 ( final int vr_1 ) throws IOException
{
return fn_14 ( vr_1 , null ) ;
}
public int fn_15 ()
{
return vl_1 ;
}
public int fn_16 () throws IOException
{
fn_3 () ;
return vl_1 ;
}
public String [] fn_17 ()
{
return vr_12 . toArray ( new String [ vr_12 . size () ] ) ;
}
public String fn_7 ()
{
StringBuilder vr_21 ;
if ( ! vl_2 ) {
return vl_6 ;
}
vr_21 = new StringBuilder () ;
for ( final String line : vr_12 )
{
vr_21 . append ( line ) ;
vr_21 . append ( vr_4 . vr_5 ) ;
}
vl_2 = false ;
vl_6 = vr_21 . toString () ;
return vl_6 ;
}
public int fn_18 ( final String vr_22 ) throws IOException
{
return fn_14 ( vr_10 . vr_23 , vr_22 ) ;
}
public int fn_19 ( final String vr_24 ) throws IOException MST[ArgumentPropagationMutator]MSP[]
{
return fn_1 ( vr_10 . vr_25 , vr_24 , false ) ;
}
public int fn_20 ( final String vr_26 ) throws IOException
{
return fn_1 ( vr_10 . vr_27 , vr_26 , false ) ;
}
public int fn_21 () throws IOException
{
return fn_14 ( vr_10 . vr_28 ) ;
}
public int fn_22 ( final String vr_24 ) throws IOException
{
return fn_14 ( vr_10 . vr_29 , vr_24 ) ;
}
public int fn_23 ( final String vr_24 ) throws IOException
{
return fn_14 ( vr_10 . vr_30 , vr_24 ) ;
}
public int fn_24 ( final String vr_24 ) throws IOException
{
return fn_14 ( vr_10 . vr_31 , vr_24 ) ;
}
public int fn_25 () throws IOException
{
return fn_14 ( vr_10 . vr_32 ) ;
}
public int fn_26 ( final String vr_33 ) throws IOException
{
return fn_14 ( vr_10 . vr_34 , vr_33 ) ;
}
public int fn_27 ( final String vr_35 ) throws IOException
{
return fn_14 ( vr_10 . vr_36 , vr_35 ) ;
}
public int fn_28 () throws IOException
{
return fn_14 ( vr_10 . vr_37 ) ;
}
public int fn_28 ( final String vr_1 ) throws IOException
{
return fn_14 ( vr_10 . vr_37 , vr_1 ) ;
}
public int fn_29 () throws IOException
{
return fn_14 ( vr_10 . vr_38 ) ;
}
public int fn_30 () throws IOException
{
return fn_14 ( vr_10 . vr_39 ) ;
}
public int fn_31 () throws IOException
{
return fn_14 ( vr_10 . vr_40 ) ;
}
public void fn_32 ( final vr_41 . vr_42 . vr_43 . vr_44 . vr_45 vr_46 ) {
fn_33 ( vr_46 ) ;
}
@Override
protected tp_2 fn_34 () {
return vl_7 ;
}
