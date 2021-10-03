@Override
public boolean hasNext () {
if ( vl_1 != null ) {
throw new fn_1 ( vl_1 . toString () ) ; MST[NonVoidMethodCallMutator]MSP[N]
}
return line != null ;
}
@Override
public String fn_2 () throws fn_1 {
if ( vl_1 != null ) {
throw new fn_1 ( vl_1 . toString () ) ;
}
final String vr_1 = line ;
if ( vr_1 == null ) {
throw new fn_1 () ;
}
try {
line = vr_2 . readLine () ;
if ( line == null ) {
Util . vr_3 ( vr_2 ) ;
}
} catch ( final IOException vr_4 ) {
vl_1 = vr_4 ;
Util . vr_3 ( vr_2 ) ;
}
return vr_1 ;
}
@Override
public void remove () {
throw new fn_3 () ;
}
@Override
public Iterator < String > iterator () {
return this ;
}
