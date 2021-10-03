private void fn_1 () throws IOException
{
vl_1 = vr_1 . readLine () ;
if ( vl_1 == null ) {
throw new fn_2 (
lr_1 ) ;
}
if ( vl_1 . length () < 3 ) {
throw new fn_3 (
lr_2 + vl_1 ) ;
}
try
{
vl_2 = Integer . vr_2 ( vl_1 . vr_3 ( 0 , 3 ) ) ;
}
catch ( final tp_1 vr_4 )
{
throw new fn_3 (
lr_3 + vl_1 ) ;
}
fn_4 ( vl_2 , vl_1 + vr_5 . vr_6 ) ;
if ( vl_2 == vr_7 . vr_8 ) {
throw new fn_2 (
lr_4 ) ;
}
}
@Override
protected void fn_5 () throws IOException
{
super . fn_5 () ;
vr_1 =
new fn_6 ( new fn_7 ( vl_3 ,
vl_4 ) ) ;
vl_5 =
new fn_8 ( new fn_9 ( vl_6 ,
vl_4 ) ) ;
fn_1 () ;
vl_7 = vl_2 == vr_7 . vr_9 ;
}
@Override
public void fn_10 () throws IOException
{
super . fn_10 () ;
vr_1 = null ;
vl_5 = null ;
vl_1 = null ;
vl_7 = false ;
}
public boolean fn_11 ()
{
return vl_7 ;
}
public int fn_12 ( final String vr_10 , final String args ) throws IOException
{
final StringBuilder vr_11 = new StringBuilder () ;
vr_11 . append ( vr_10 ) ;
if ( args != null )
{
vr_11 . append ( ' ' ) ;
vr_11 . append ( args ) ;
}
vr_11 . append ( vr_5 . vr_6 ) ;
String vr_12 ;
vl_5 . vr_13 ( vr_12 = vr_11 . toString () ) ;
vl_5 . vr_14 () ;
fn_13 ( vr_10 , vr_12 ) ;
fn_1 () ;
return vl_2 ;
}
public int fn_12 ( final int vr_10 , final String args ) throws IOException
{
return fn_12 ( vr_15 . vr_16 ( vr_10 ) , args ) ;
}
public int fn_12 ( final String vr_10 ) throws IOException
{
return fn_12 ( vr_10 , null ) ;
}
public int fn_12 ( final int vr_10 ) throws IOException
{
return fn_12 ( vr_10 , null ) ;
}
public int fn_14 ()
{
return vl_2 ;
}
public int fn_15 () throws IOException
{
fn_1 () ;
return vl_2 ;
}
public String fn_16 ()
{
return vl_1 ;
}
public int fn_17 ( final String vr_17 ) throws IOException
{
return fn_12 ( vr_15 . vr_18 , vr_17 ) ;
}
public int fn_17 ( final long vr_19 ) throws IOException
{
return fn_12 ( vr_15 . vr_18 , Long . toString ( vr_19 ) ) ;
}
public int fn_17 () throws IOException
{
return fn_12 ( vr_15 . vr_18 ) ;
}
public int fn_18 ( final String vr_17 ) throws IOException
{
return fn_12 ( vr_15 . vr_20 , vr_17 ) ;
}
public int fn_18 ( final long vr_19 ) throws IOException
{
return fn_12 ( vr_15 . vr_20 , Long . toString ( vr_19 ) ) ;
}
public int fn_18 () throws IOException
{
return fn_12 ( vr_15 . vr_20 ) ;
}
public int fn_19 ( final String vr_17 ) throws IOException
{
return fn_12 ( vr_15 . vr_21 , vr_17 ) ;
}
public int fn_19 ( final long vr_19 ) throws IOException
{
return fn_12 ( vr_15 . vr_21 , Long . toString ( vr_19 ) ) ;
}
public int fn_19 () throws IOException
{
return fn_12 ( vr_15 . vr_21 ) ;
}
public int fn_20 ( final String vr_17 ) throws IOException
{
return fn_12 ( vr_15 . vr_22 , vr_17 ) ;
}
public int fn_20 ( final long vr_19 ) throws IOException
{
return fn_12 ( vr_15 . vr_22 , Long . toString ( vr_19 ) ) ;
}
public int fn_20 () throws IOException
{
return fn_12 ( vr_15 . vr_22 ) ;
}
public int fn_21 ( final String vr_23 ) throws IOException
{
return fn_12 ( vr_15 . vr_24 , vr_23 ) ;
}
public int fn_22 () throws IOException
{
return fn_12 ( vr_15 . vr_25 ) ;
}
public int fn_23 ( final String vr_17 ) throws IOException
{
return fn_12 ( vr_15 . vr_26 , vr_17 ) ;
}
public int fn_24 () throws IOException
{
return fn_12 ( vr_15 . vr_27 ) ;
}
public int list () throws IOException
{
return fn_12 ( vr_15 . LIST ) ;
}
public int fn_25 () throws IOException
{
return fn_12 ( vr_15 . vr_28 ) ;
}
public int fn_26 ( final String vr_29 , final String time , final boolean vr_30 ,
final String vr_31 ) throws IOException
{
final StringBuilder vr_32 = new StringBuilder () ;
vr_32 . append ( vr_29 ) ;
vr_32 . append ( ' ' ) ;
vr_32 . append ( time ) ;
if ( vr_30 )
{
vr_32 . append ( ' ' ) ;
vr_32 . append ( lr_5 ) ;
}
if ( vr_31 != null )
{
vr_32 . append ( lr_6 ) ;
vr_32 . append ( vr_31 ) ;
vr_32 . append ( '>' ) ;
}
return fn_12 ( vr_15 . vr_33 , vr_32 . toString () ) ;
}
public int fn_27 ( final String vr_34 , final String vr_29 , final String time , final boolean vr_30 ,
final String vr_31 ) throws IOException
{
final StringBuilder vr_32 = new StringBuilder () ;
vr_32 . append ( vr_34 ) ;
vr_32 . append ( ' ' ) ;
vr_32 . append ( vr_29 ) ;
vr_32 . append ( ' ' ) ;
vr_32 . append ( time ) ;
if ( vr_30 )
{
vr_32 . append ( ' ' ) ;
vr_32 . append ( lr_5 ) ;
}
if ( vr_31 != null )
{
vr_32 . append ( lr_6 ) ;
vr_32 . append ( vr_31 ) ;
vr_32 . append ( '>' ) ;
}
return fn_12 ( vr_15 . vr_35 , vr_32 . toString () ) ;
}
public int fn_28 () throws IOException
{
return fn_12 ( vr_15 . vr_36 ) ; MST[rv.CRCR6Mutator]MSP[N]
}
public int fn_29 () throws IOException
{
return fn_12 ( vr_15 . vr_37 ) ;
}
public int fn_30 ( final String vr_38 ) throws IOException {
final String vr_39 = lr_7 + vr_38 ;
return fn_12 ( vr_15 . vr_40 , vr_39 ) ;
}
public int fn_31 ( final String vr_41 ) throws IOException {
final String vr_42 = lr_8 + vr_41 ;
return fn_12 ( vr_15 . vr_40 , vr_42 ) ;
}
public int fn_32 ( final String vr_43 ) throws IOException {
return fn_12 ( vr_15 . vr_44 , vr_43 ) ;
}
public int fn_33 ( final String vr_45 , final String vr_43 ) throws IOException {
final StringBuilder vr_10 = new StringBuilder ( vr_45 ) ;
vr_10 . append ( lr_9 ) ;
vr_10 . append ( vr_43 ) ;
return fn_12 ( vr_15 . vr_46 , vr_10 . toString () ) ;
}
public int fn_34 ( final String vr_47 ) throws IOException {
final StringBuilder vr_10 = new StringBuilder ( lr_10 ) ;
vr_10 . append ( vr_47 ) ;
return fn_12 ( vr_15 . LIST , vr_10 . toString () ) ;
}
@Deprecated
public int fn_17 ( final int vr_48 ) throws IOException
{
return fn_17 ( ( long ) vr_48 ) ;
}
@Deprecated
public int fn_18 ( final int vr_48 ) throws IOException
{
return fn_18 ( ( long ) vr_48 ) ;
}
@Deprecated
public int fn_19 ( final int vr_48 ) throws IOException
{
return fn_19 ( ( long ) vr_48 ) ;
}
@Deprecated
public int fn_20 ( final int vr_48 ) throws IOException
{
return fn_20 ( ( long ) vr_48 ) ;
}
@Override
protected tp_2 fn_35 () {
return vl_8 ;
}
