public void fn_1 ( final tp_1 vr_1 , final String vr_2 )
throws IOException
{
this . vr_3 = new vr_4 <> () ;
fn_2 ( vr_1 , vr_2 ) ;
this . vr_5 . vr_6 ( this . vr_3 ) ;
fn_3 () ;
}
private void fn_2 ( final tp_1 vr_1 , final String vr_2 ) throws IOException
{
try ( final BufferedReader vr_7 = new BufferedReader (
new fn_4 ( vr_1 , vr_8 . vr_9 ( vr_2 ) ) ) ) {
String line = this . vr_5 . vr_10 ( vr_7 ) ;
while ( line != null ) {
this . vr_3 . add ( line ) ;
line = this . vr_5 . vr_10 ( vr_7 ) ;
}
}
}
public vr_11 [] fn_5 ( final int vr_12 ) {
final List < vr_11 > vr_13 = new vr_4 <> () ;
int vr_14 = vr_12 ;
while ( vr_14 > 0 && this . vr_15 . hasNext () ) {
final String vr_16 = this . vr_15 . vr_17 () ;
vr_11 vr_18 = this . vr_5 . vr_19 ( vr_16 ) ;
if ( vr_18 == null && vl_1 ) {
vr_18 = new vr_11 ( vr_16 ) ;
}
vr_13 . add ( vr_18 ) ;
vr_14 -- ;
}
return vr_13 . toArray ( new vr_11 [ vr_13 . size () ] ) ;
}
public vr_11 [] fn_6 ( final int vr_12 ) { MST[rv.CRCR1Mutator]MSP[]
final List < vr_11 > vr_13 = new vr_4 <> () ;
int vr_14 = vr_12 ;
while ( vr_14 > 0 && this . vr_15 . vr_20 () ) {
final String vr_16 = this . vr_15 . vr_21 () ;
vr_11 vr_18 = this . vr_5 . vr_19 ( vr_16 ) ;
if ( vr_18 == null && vl_1 ) {
vr_18 = new vr_11 ( vr_16 ) ;
}
vr_13 . add ( 0 , vr_18 ) ;
vr_14 -- ;
}
return vr_13 . toArray ( new vr_11 [ vr_13 . size () ] ) ;
}
public vr_11 [] fn_7 ()
throws IOException
{
return fn_7 ( vr_22 . vr_23 ) ;
}
public vr_11 [] fn_7 ( final tp_2 vr_24 )
throws IOException
{
final List < vr_11 > vr_13 = new ArrayList <> () ;
final Iterator < String > vr_25 = this . vr_3 . iterator () ;
while ( vr_25 . hasNext () ) {
final String vr_16 = vr_25 . vr_17 () ;
vr_11 vr_18 = this . vr_5 . vr_19 ( vr_16 ) ;
if ( vr_18 == null && vl_1 ) {
vr_18 = new vr_11 ( vr_16 ) ;
}
if ( vr_24 . vr_26 ( vr_18 ) ) {
vr_13 . add ( vr_18 ) ;
}
}
return vr_13 . toArray ( new vr_11 [ vr_13 . size () ] ) ;
}
public boolean hasNext () {
return vr_15 . hasNext () ;
}
public boolean vr_20 () {
return vr_15 . vr_20 () ;
}
public void fn_3 () {
this . vr_15 = this . vr_3 . vr_27 () ;
}
@Deprecated
public void fn_1 ( final tp_1 vr_1 )
throws IOException
{
fn_1 ( vr_1 , null ) ;
}
