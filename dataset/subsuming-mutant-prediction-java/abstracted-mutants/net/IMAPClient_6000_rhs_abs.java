public boolean fn_1 () throws IOException
{
return fn_2 ( vr_1 . vr_2 ) ;
}
public boolean fn_3 () throws IOException
{
return fn_2 ( vr_1 . vr_3 ) ;
}
public boolean fn_4 () throws IOException
{
return fn_2 ( vr_1 . vr_4 ) ;
}
public boolean fn_5 ( final String vr_5 , final String vr_6 ) throws IOException
{
if ( fn_6 () != vr_7 . vr_8 . vr_9 )
{
return false ;
}
if ( ! fn_2 ( vr_1 . vr_10 , vr_5 + lr_1 + vr_6 ) )
{
return false ;
}
fn_7 ( vr_7 . vr_8 . vr_11 ) ;
return true ;
}
public boolean fn_8 ( final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_13 , fn_9 ( vr_12 ) ) ;
}
public boolean fn_10 ( final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_14 , fn_9 ( vr_12 ) ) ;
}
public boolean fn_11 ( final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_15 , fn_9 ( vr_12 ) ) ;
}
public boolean fn_12 ( final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_16 , fn_9 ( vr_12 ) ) ;
}
public boolean rename ( final String vr_17 , final String vr_18 ) throws IOException
{
return fn_2 ( vr_1 . RENAME , fn_9 ( vr_17 ) + lr_1 + fn_9 ( vr_18 ) ) ;
}
public boolean fn_13 ( final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_19 , fn_9 ( vr_12 ) ) ;
}
public boolean fn_14 ( final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_20 , fn_9 ( vr_12 ) ) ;
}
public boolean list ( final String vr_21 , final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . LIST , fn_9 ( vr_21 ) + lr_1 + fn_9 ( vr_12 ) ) ;
}
public boolean fn_15 ( final String vr_21 , final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_22 , fn_9 ( vr_21 ) + lr_1 + fn_9 ( vr_12 ) ) ;
}
public boolean fn_16 ( final String vr_12 , final String [] vr_23 ) throws IOException
{
if ( vr_23 == null || vr_23 . length < 1 ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
final StringBuilder vr_24 = new StringBuilder () ;
vr_24 . append ( fn_9 ( vr_12 ) ) ;
vr_24 . append ( lr_3 ) ;
for ( int vr_25 = 0 ; vr_25 < vr_23 . length ; vr_25 ++ )
{
if ( vr_25 > 0 ) {
vr_24 . append ( lr_1 ) ;
}
vr_24 . append ( vr_23 [ vr_25 ] ) ;
}
vr_24 . append ( lr_4 ) ;
return fn_2 ( vr_1 . vr_26 , vr_24 . toString () ) ;
}
public boolean append ( final String vr_12 , final String vr_27 , final String vr_28 , final String vr_29 )
throws IOException {
final StringBuilder args = new StringBuilder ( fn_9 ( vr_12 ) ) ;
if ( vr_27 != null ) {
args . append ( lr_1 ) . append ( vr_27 ) ;
}
if ( vr_28 != null ) {
args . append ( lr_1 ) ;
if ( vr_28 . charAt ( 0 ) == vl_1 ) {
args . append ( vr_28 ) ;
} else {
args . append ( vl_1 ) . append ( vr_28 ) . append ( vl_1 ) ;
}
}
args . append ( lr_1 ) ;
if ( vr_29 . vr_30 ( vl_2 ) && vr_29 . vr_31 ( vl_2 ) ) {
args . append ( vr_29 ) ;
return fn_2 ( vr_1 . APPEND , args . toString () ) ;
}
args . append ( '{' ) . append ( vr_29 . vr_32 ( vr_7 . vr_33 ) . length ) . append ( '}' ) ;
final int fn_16 = fn_17 ( vr_1 . APPEND , args . toString () ) ;
return vr_34 . vr_35 ( fn_16 )
&& vr_34 . vr_36 ( fn_18 ( vr_29 ) ) ;
}
@Deprecated
public boolean append ( final String vr_12 , final String vr_27 , final String vr_28 ) throws IOException
{
String args = vr_12 ;
if ( vr_27 != null ) {
args += lr_1 + vr_27 ;
}
if ( vr_28 != null ) {
if ( vr_28 . charAt ( 0 ) == '{' ) {
args += lr_1 + vr_28 ;
} else {
args += lr_5 + vr_28 + lr_6 ;
}
}
return fn_2 ( vr_1 . APPEND , args ) ;
}
@Deprecated
public boolean append ( final String vr_12 ) throws IOException
{
return append ( vr_12 , null , null ) ;
}
public boolean fn_19 () throws IOException
{
return fn_2 ( vr_1 . vr_37 ) ;
}
public boolean fn_20 () throws IOException
{
return fn_2 ( vr_1 . vr_38 ) ;
}
public boolean fn_21 () throws IOException
{
return fn_2 ( vr_1 . vr_39 ) ;
}
public boolean fn_22 ( final String vr_40 , final String vr_41 ) throws IOException
{
String args = lr_7 ;
if ( vr_40 != null ) {
args += lr_8 + vr_40 ;
}
args += vr_41 ;
return fn_2 ( vr_1 . vr_42 , args ) ;
}
public boolean fn_22 ( final String vr_41 ) throws IOException MST[NonVoidMethodCallMutator]MSP[S]
{
return fn_22 ( null , vr_41 ) ;
}
public boolean fn_23 ( final String vr_43 , final String vr_23 ) throws IOException
{
return fn_2 ( vr_1 . vr_44 , vr_43 + lr_1 + vr_23 ) ;
}
public boolean fn_24 ( final String vr_43 , final String vr_23 , final String vr_45 )
throws IOException
{
return fn_2 ( vr_1 . vr_46 , vr_43 + lr_1 + vr_23 + lr_1 + vr_45 ) ;
}
public boolean fn_25 ( final String vr_43 , final String vr_12 ) throws IOException
{
return fn_2 ( vr_1 . vr_47 , vr_43 + lr_1 + fn_9 ( vr_12 ) ) ;
}
public boolean fn_26 ( final String vr_48 , final String vr_49 ) throws IOException
{
return fn_2 ( vr_1 . vr_50 , vr_48 + lr_1 + vr_49 ) ;
}
