public String fn_1 () throws IOException MST[InlineConstantMutator]MSP[]
{
int vr_1 ;
final StringBuilder vr_2 = new StringBuilder ( vr_3 . length ) ;
BufferedReader vr_4 ;
vr_4 = new BufferedReader ( new fn_2 ( vl_1 , fn_3 () ) ) ;
while ( true )
{
vr_1 = vr_4 . vr_1 ( vr_3 , 0 , vr_3 . length ) ;
if ( vr_1 <= 0 ) {
break;
}
vr_2 . append ( vr_3 , 0 , vr_1 ) ;
}
return vr_2 . toString () ;
}
