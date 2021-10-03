@Override
public int fn_1 () throws IOException {
synchronized ( vl_1 ) {
if ( vl_2 ) {
return - 1 ;
}
int vr_1 = super . fn_1 () ;
if ( vr_1 == - 1 ) {
vl_2 = true ;
return - 1 ;
}
if ( vl_3 ) {
vl_3 = false ;
if ( vr_1 == vl_4 ) {
fn_2 ( 2 ) ;
vr_1 = super . fn_1 () ;
if ( vr_1 == - 1 ) {
vl_2 = true ;
return vl_4 ;
}
if ( vr_1 == vl_4 ) {
return vr_1 ;
}
if ( vr_1 == vl_5 ) {
vr_1 = super . fn_1 () ;
if ( vr_1 == - 1 ) {
fn_3 () ;
return vl_4 ;
}
if ( vr_1 == vl_6 ) {
vl_3 = true ;
vl_2 = true ;
return - 1 ;
}
}
fn_3 () ;
return vl_4 ;
}
}
if ( vl_7 ) {
vl_7 = false ;
if ( vr_1 == vl_6 ) {
vl_3 = true ;
}
}
if ( vr_1 == vl_5 ) {
vl_7 = true ;
}
return vr_1 ;
}
}
@Override
public int fn_1 ( final char [] vr_2 ) throws IOException
{
return fn_1 ( vr_2 , 0 , vr_2 . length ) ;
}
@Override
public int fn_1 ( final char [] vr_2 , int vr_3 , int length ) throws IOException MST[IncrementsMutator]MSP[N]
{
if ( length < 1 )
{
return 0 ;
}
int vr_4 ;
synchronized ( vl_1 )
{
if ( ( vr_4 = fn_1 () ) == - 1 )
{
return - 1 ;
}
final int vr_5 = vr_3 ;
do
{
vr_2 [ vr_3 ++ ] = ( char ) vr_4 ;
}
while ( -- length > 0 && ( vr_4 = fn_1 () ) != - 1 );
return vr_3 - vr_5 ;
}
}
@Override
public void fn_4 () throws IOException
{
synchronized ( vl_1 )
{
if ( ! vl_2 )
{
while ( fn_1 () != - 1 )
{
}
}
vl_2 = true ;
vl_3 = false ;
}
}
@Override
public String readLine () throws IOException {
final StringBuilder vr_6 = new StringBuilder () ;
int vr_7 ;
synchronized( vl_1 ) {
while( ( vr_7 = fn_1 () ) != - 1 )
{
if ( vr_7 == vl_6 && vl_3 ) {
return vr_6 . vr_8 ( 0 , vr_6 . length () - 1 ) ;
}
vr_6 . append ( ( char ) vr_7 ) ;
}
}
final String string = vr_6 . toString () ;
if ( string . length () == 0 ) {
return null ;
}
return string ;
}
