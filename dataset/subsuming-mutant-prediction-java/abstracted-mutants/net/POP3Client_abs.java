private static tp_1 fn_1 ( final String line )
{
int vr_1 , size ;
tp_2 vr_2 ;
vr_2 = new tp_2 ( line ) ;
if ( ! vr_2 . vr_3 () ) {
return null ;
}
vr_1 = size = 0 ;
try
{
vr_1 = Integer . vr_4 ( vr_2 . vr_5 () ) ;
if ( ! vr_2 . vr_3 () ) {
return null ;
}
size = Integer . vr_4 ( vr_2 . vr_5 () ) ;
}
catch ( final tp_3 vr_6 )
{
return null ;
}
return new tp_1 ( vr_1 , size ) ;
}
private static tp_1 fn_2 ( String line )
{
int vr_1 ;
tp_2 vr_2 ;
vr_2 = new tp_2 ( line ) ;
if ( ! vr_2 . vr_3 () ) {
return null ;
}
vr_1 = 0 ;
try
{
vr_1 = Integer . vr_4 ( vr_2 . vr_5 () ) ;
if ( ! vr_2 . vr_3 () ) {
return null ;
}
line = vr_2 . vr_5 () ;
}
catch ( final tp_3 vr_6 )
{
return null ;
}
return new tp_1 ( vr_1 , line ) ;
}
public boolean fn_3 () throws IOException
{
if ( fn_4 ( vr_7 . vr_8 ) == vr_9 . vr_10 ) {
fn_5 () ;
return true ;
}
return false ;
}
public boolean fn_6 ( final String vr_11 , final String vr_12 ) throws IOException
{
if ( fn_7 () != vl_1 ) {
return false ;
}
if ( fn_4 ( vr_7 . vr_13 , vr_11 ) != vr_9 . vr_10 ) {
return false ;
}
if ( fn_4 ( vr_7 . vr_14 , vr_12 ) != vr_9 . vr_10 ) {
return false ;
}
fn_8 ( vl_2 ) ;
return true ;
}
public boolean fn_6 ( final String vr_11 , String vr_15 , final String vr_16 )
throws IOException , vl_3
{
int vr_17 ;
byte [] vr_18 ;
StringBuilder vr_19 , vr_20 ;
tp_4 vr_21 ;
if ( fn_7 () != vl_1 ) {
return false ;
}
vr_21 = tp_4 . vr_22 ( lr_1 ) ;
vr_15 += vr_16 ;
vr_18 = vr_21 . vr_18 ( vr_15 . vr_23 ( fn_9 () ) ) ;
vr_20 = new StringBuilder ( 128 ) ;
for ( vr_17 = 0 ; vr_17 < vr_18 . length ; vr_17 ++ ) {
final int vr_24 = vr_18 [ vr_17 ] & 0xff ;
if ( vr_24 <= 15 ) {
vr_20 . append ( lr_2 ) ;
}
vr_20 . append ( Integer . vr_25 ( vr_24 ) ) ;
}
vr_19 = new StringBuilder ( 256 ) ;
vr_19 . append ( vr_11 ) ;
vr_19 . append ( ' ' ) ;
vr_19 . append ( vr_20 . toString () ) ;
if ( fn_4 ( vr_7 . vr_26 , vr_19 . toString () ) != vr_9 . vr_10 ) {
return false ;
}
fn_8 ( vl_2 ) ;
return true ;
}
public boolean fn_10 () throws IOException
{
if ( fn_7 () == vl_2 ) {
fn_8 ( vl_4 ) ;
}
fn_4 ( vr_7 . vr_27 ) ;
return vl_5 == vr_9 . vr_10 ;
}
public boolean fn_11 () throws IOException
{
if ( fn_7 () == vl_2 ) {
return fn_4 ( vr_7 . vr_28 ) == vr_9 . vr_10 ;
}
return false ;
}
public boolean fn_12 ( final int vr_29 ) throws IOException
{
if ( fn_7 () == vl_2 ) {
return fn_4 ( vr_7 . vr_30 , Integer . toString ( vr_29 ) )
== vr_9 . vr_10 ;
}
return false ;
}
public boolean fn_13 () throws IOException
{
if ( fn_7 () == vl_2 ) {
return fn_4 ( vr_7 . vr_31 ) == vr_9 . vr_10 ;
}
return false ;
}
public tp_1 fn_14 () throws IOException
{
if ( fn_7 () != vl_2 ) {
return null ;
}
if ( fn_4 ( vr_7 . vr_32 ) != vr_9 . vr_10 ) {
return null ;
}
return fn_1 ( vr_33 . vr_34 ( 3 ) ) ;
}
public tp_1 fn_15 ( final int vr_29 ) throws IOException
{
if ( fn_7 () != vl_2 ) {
return null ;
}
if ( fn_4 ( vr_7 . LIST , Integer . toString ( vr_29 ) )
!= vr_9 . vr_10 ) {
return null ;
}
return fn_1 ( vr_33 . vr_34 ( 3 ) ) ;
}
public tp_1 [] fn_16 () throws IOException
{
if ( fn_7 () != vl_2 ) {
return null ;
}
if ( fn_4 ( vr_7 . LIST ) != vr_9 . vr_10 ) {
return null ;
}
fn_5 () ;
final tp_1 [] vr_35 = new tp_1 [ vr_36 . size () - 2 ] ;
final vr_37 < String > vr_38 = vr_36 . vr_39 ( 1 ) ;
for ( int line = 0 ; line < vr_35 . length ; line ++ ) {
vr_35 [ line ] = fn_1 ( vr_38 . vr_40 () ) ;
}
return vr_35 ;
}
public tp_1 fn_17 ( final int vr_29 )
throws IOException
{
if ( fn_7 () != vl_2 ) {
return null ;
}
if ( fn_4 ( vr_7 . vr_41 , Integer . toString ( vr_29 ) )
!= vr_9 . vr_10 ) {
return null ;
}
return fn_2 ( vr_33 . vr_34 ( 3 ) ) ;
}
public tp_1 [] fn_18 () throws IOException
{
if ( fn_7 () != vl_2 ) {
return null ;
}
if ( fn_4 ( vr_7 . vr_41 ) != vr_9 . vr_10 ) {
return null ;
}
fn_5 () ;
final tp_1 [] vr_35 = new tp_1 [ vr_36 . size () - 2 ] ;
final vr_37 < String > vr_38 = vr_36 . vr_39 ( 1 ) ;
for ( int line = 0 ; line < vr_35 . length ; line ++ ) {
vr_35 [ line ] = fn_2 ( vr_38 . vr_40 () ) ;
}
return vr_35 ;
}
public tp_5 fn_19 ( final int vr_29 ) throws IOException
{
if ( fn_7 () != vl_2 ) {
return null ;
}
if ( fn_4 ( vr_7 . vr_42 , Integer . toString ( vr_29 ) ) != vr_9 . vr_10 ) {
return null ;
}
return new fn_20 ( vl_6 ) ;
}
public tp_5 fn_21 ( final int vr_29 , final int vr_43 )
throws IOException
{
if ( vr_43 < 0 || fn_7 () != vl_2 ) {
return null ;
}
if ( fn_4 ( vr_7 . vr_44 , Integer . toString ( vr_29 ) + lr_3 +
Integer . toString ( vr_43 ) ) != vr_9 . vr_10 ) {
return null ;
}
return new fn_20 ( vl_6 ) ;
}
