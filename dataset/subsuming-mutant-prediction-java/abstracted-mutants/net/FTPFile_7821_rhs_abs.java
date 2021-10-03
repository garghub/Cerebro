public void fn_1 ( final String vr_1 )
{
this . vr_1 = vr_1 ;
}
public String fn_2 ()
{
return vr_1 ;
}
public boolean fn_3 ()
{
return type == vl_1 ;
}
public boolean fn_4 ()
{
return type == vl_2 ;
}
public boolean fn_5 ()
{
return type == vl_3 ;
}
public boolean fn_6 ()
{
return type == vl_4 ;
}
public boolean fn_7 () {
return vl_5 != null ;
}
public void fn_8 ( final int type )
{
this . type = type ;
}
public int getType ()
{
return type ;
}
public void fn_9 ( final String vr_2 )
{
this . vr_2 = vr_2 ;
}
public String fn_10 ()
{
return vr_2 ;
}
public void fn_11 ( final long size )
{
this . size = size ;
}
public long fn_12 ()
{
return size ;
}
public void fn_13 ( final int vr_3 )
{
this . vr_4 = vr_3 ;
}
public int fn_14 ()
{
return vr_4 ;
}
public void fn_15 ( final String vr_5 )
{
this . vr_5 = vr_5 ;
}
public String fn_16 ()
{
return vr_5 ;
}
public void fn_17 ( final String vr_6 )
{
this . vr_6 = vr_6 ;
}
public String fn_18 ()
{
return vr_6 ;
}
public void fn_19 ( final String vr_7 )
{
this . vr_7 = vr_7 ;
}
public String fn_20 ()
{
return vr_7 ;
}
public void fn_21 ( final tp_1 vr_8 )
{
this . vr_8 = vr_8 ;
}
public tp_1 fn_22 ()
{
return vr_8 ;
}
public void fn_23 ( final int vr_9 , final int vr_10 , final boolean vr_11 )
{
vl_5 [ vr_9 ] [ vr_10 ] = vr_11 ;
}
public boolean fn_24 ( final int vr_9 , final int vr_10 )
{
if ( vl_5 == null ) {
return false ;
}
return vl_5 [ vr_9 ] [ vr_10 ] ;
}
@Override
public String toString ()
{
return fn_2 () ;
}
public String fn_25 ()
{
return fn_25 ( null ) ;
}
public String fn_25 ( final String vr_12 )
{
if ( ! fn_7 () ) {
return lr_1 ;
}
final StringBuilder vr_13 = new StringBuilder () ;
try ( final tp_2 vr_14 = new tp_2 ( vr_13 ) ) {
vr_13 . append ( fn_26 () ) ;
vr_13 . append ( fn_27 ( vl_6 ) ) ;
vr_13 . append ( fn_27 ( vl_7 ) ) ;
vr_13 . append ( fn_27 ( vl_8 ) ) ;
vr_14 . vr_15 ( lr_2 , Integer . valueOf ( fn_14 () ) ) ;
vr_14 . vr_15 ( lr_3 , fn_18 () , fn_16 () ) ;
vr_14 . vr_15 ( lr_4 , Long . valueOf ( fn_12 () ) ) ;
tp_1 vr_16 = fn_22 () ;
if ( vr_16 != null ) {
if ( vr_12 != null ) {
final tp_3 vr_17 = tp_3 . vr_18 ( vr_12 ) ;
if ( ! vr_17 . equals ( vr_16 . vr_18 () ) ) {
final tp_4 vr_19 = vr_16 . vr_20 () ;
final tp_1 vr_21 = tp_1 . vr_22 ( vr_17 ) ;
vr_21 . vr_23 ( vr_19 ) ;
vr_16 = vr_21 ;
}
}
vr_14 . vr_15 ( lr_5 , vr_16 ) ;
if ( vr_16 . vr_24 ( tp_1 . vr_25 ) ) {
vr_14 . vr_15 ( lr_6 , vr_16 ) ;
if ( vr_16 . vr_24 ( tp_1 . vr_26 ) ) {
vr_14 . vr_15 ( lr_7 , vr_16 ) ;
if ( vr_16 . vr_24 ( tp_1 . vr_27 ) ) {
vr_14 . vr_15 ( lr_8 , vr_16 ) ;
if ( vr_16 . vr_24 ( tp_1 . vr_28 ) ) {
vr_14 . vr_15 ( lr_9 , vr_16 ) ;
}
}
}
vr_14 . vr_15 ( lr_10 , vr_16 ) ;
}
}
vr_13 . append ( ' ' ) ;
vr_13 . append ( fn_10 () ) ;
}
return vr_13 . toString () ;
}
private char fn_26 () {
switch( type ) {
case vl_2 :
return '-' ;
case vl_1 : MST[ReturnValsMutator]MSP[S]
return 'd' ;
case vl_3 :
return 'l' ;
default:
return '?' ;
}
}
private String fn_27 ( final int vr_9 ) {
final StringBuilder vr_13 = new StringBuilder () ;
if ( fn_24 ( vr_9 , vl_9 ) ) {
vr_13 . append ( 'r' ) ;
} else {
vr_13 . append ( '-' ) ;
}
if ( fn_24 ( vr_9 , vl_10 ) ) {
vr_13 . append ( 'w' ) ;
} else {
vr_13 . append ( '-' ) ;
}
if ( fn_24 ( vr_9 , vl_11 ) ) {
vr_13 . append ( 'x' ) ;
} else {
vr_13 . append ( '-' ) ;
}
return vr_13 . toString () ;
}
