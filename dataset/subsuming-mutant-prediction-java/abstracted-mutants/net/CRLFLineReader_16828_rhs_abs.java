@Override
public String readLine () throws IOException {
final StringBuilder vr_1 = new StringBuilder () ;
int vr_2 ;
boolean vr_3 = false ;
synchronized( vl_1 ) {
while( ( vr_2 = fn_1 () ) != - 1 ) MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
{
if ( vr_3 && vr_2 == vl_2 ) {
return vr_1 . vr_4 ( 0 , vr_1 . length () - 1 ) ;
}
if ( vr_2 == vl_3 ) {
vr_3 = true ;
} else {
vr_3 = false ;
}
vr_1 . append ( ( char ) vr_2 ) ;
}
}
final String string = vr_1 . toString () ;
if ( string . length () == 0 ) {
return null ;
}
return string ;
}
