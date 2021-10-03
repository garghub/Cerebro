@Override
public String fn_1 () {
return lr_1 ;
}
@Override
public String fn_2 () {
return fn_3 () ;
}
@Override
void fn_4 ( tp_1 vr_1 , int vr_2 , vr_3 . vr_4 out ) throws IOException {
vr_1
. append ( lr_2 )
. append ( fn_3 () ) ;
}
@Override
void fn_5 ( tp_1 vr_1 , int vr_2 , vr_3 . vr_4 out ) {
try {
vr_1 . append ( lr_3 ) ;
} catch ( IOException vr_5 ) {
throw new fn_6 ( vr_5 ) ;
}
}
@Override
public tp_2 fn_7 () {
return ( tp_2 ) super . fn_7 () ;
}
