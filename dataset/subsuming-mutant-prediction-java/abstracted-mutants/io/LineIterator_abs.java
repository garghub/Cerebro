@Override
public boolean hasNext () {
if ( vl_1 != null ) {
return true ;
} else if ( vl_2 ) {
return false ;
} else {
try {
while ( true ) {
final String line = bufferedReader . readLine () ;
if ( line == null ) {
vl_2 = true ;
return false ;
} else if ( fn_1 ( line ) ) {
vl_1 = line ;
return true ;
}
}
} catch( final IOException vr_1 ) {
try {
fn_2 () ;
} catch ( final IOException vr_2 ) {
vr_1 . vr_3 ( vr_2 ) ;
}
throw new fn_3 ( vr_1 ) ;
}
}
}
protected boolean fn_1 ( final String line ) {
return true ;
}
@Override
public String fn_4 () {
return fn_5 () ;
}
public String fn_5 () {
if ( ! hasNext () ) {
throw new fn_6 ( lr_1 ) ;
}
final String vr_4 = vl_1 ;
vl_1 = null ;
return vr_4 ;
}
@Override
public void fn_2 () throws IOException {
vl_2 = true ;
vl_1 = null ;
if ( this . bufferedReader != null ) {
this . bufferedReader . fn_2 () ;
}
}
@Override
public void remove () {
throw new fn_7 ( lr_2 ) ;
}
@Deprecated
public static void fn_8 ( final tp_1 iterator ) {
try {
if ( iterator != null ) {
iterator . fn_2 () ;
}
} catch( final IOException vr_2 ) {
}
}
