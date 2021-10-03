protected boolean fn_1 () {
return true ;
}
@Override
public vr_1 < vr_2 . vr_3 < vt_1 , vt_2 > > fn_2 () {
if ( fn_1 () ) {
return new fn_3 ( vr_4 . fn_2 () , this ) ;
}
return vr_4 . fn_2 () ; MST[NonVoidMethodCallMutator]MSP[N]
}
@Override
public Iterator < vr_2 . vr_3 < vt_1 , vt_2 > > iterator () {
return new fn_4 ( this . vr_5 () . iterator () , vl_1 ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public Object [] toArray () {
final Object [] array = this . vr_5 () . toArray () ;
for ( int vr_6 = 0 ; vr_6 < array . length ; vr_6 ++ ) {
array [ vr_6 ] = new fn_5 ( ( vr_2 . vr_3 < vt_1 , vt_2 > ) array [ vr_6 ] , vl_1 ) ;
}
return array ;
}
@Override
@SuppressWarnings ( lr_1 )
public < vt_3 > vt_3 [] toArray ( final vt_3 [] array ) {
Object [] vr_7 = array ;
if ( array . length > 0 ) {
vr_7 = ( Object [] ) Array . vr_8 ( array . getClass () . fn_6 () , 0 ) ;
}
vr_7 = this . vr_5 () . toArray ( vr_7 ) ;
for ( int vr_6 = 0 ; vr_6 < vr_7 . length ; vr_6 ++ ) {
vr_7 [ vr_6 ] = new fn_5 ( ( vr_2 . vr_3 < vt_1 , vt_2 > ) vr_7 [ vr_6 ] , vl_1 ) ;
}
if ( vr_7 . length > array . length ) {
return ( vt_3 [] ) vr_7 ;
}
System . vr_9 ( vr_7 , 0 , array , 0 , vr_7 . length ) ;
if ( array . length > vr_7 . length ) {
array [ vr_7 . length ] = null ;
}
return array ;
}
@Override
public vr_2 . vr_3 < vt_1 , vt_2 > fn_7 () {
final vr_2 . vr_3 < vt_1 , vt_2 > vr_10 = fn_8 () . fn_7 () ;
return new fn_5 ( vr_10 , vl_1 ) ;
}
@Override
public vt_2 fn_9 ( vt_2 vr_11 ) {
vr_11 = vl_1 . vr_12 ( vr_11 ) ;
return fn_10 () . fn_9 ( vr_11 ) ;
}
