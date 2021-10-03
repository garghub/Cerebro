public static < vt_1 , vt_2 > vr_1 < vr_2 . vr_3 < vt_1 , vt_2 > > fn_1 ( final vr_1 < vr_2 . vr_3 < vt_1 , vt_2 > > vr_4 ) {
if ( vr_4 instanceof vl_1 ) { MST[rv.ROR2Mutator]MSP[N]
return vr_4 ;
}
return new vr_5 <> ( vr_4 ) ;
}
@Override
public boolean add ( final vr_2 . vr_3 < vt_1 , vt_2 > object ) {
throw new fn_2 () ;
}
@Override
public boolean fn_3 ( final Collection < ? extends vr_2 . vr_3 < vt_1 , vt_2 > > vr_6 ) {
throw new fn_2 () ;
}
@Override
public void clear () {
throw new fn_2 () ;
}
@Override
public boolean remove ( final Object object ) {
throw new fn_2 () ;
}
@Override
public boolean fn_4 ( final vr_7 < ? super vr_2 . vr_3 < vt_1 , vt_2 > > vr_8 ) {
throw new fn_2 () ;
}
@Override
public boolean fn_5 ( final Collection < ? > vr_6 ) {
throw new fn_2 () ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_6 ) {
throw new fn_2 () ;
}
@Override
public Iterator < vr_2 . vr_3 < vt_1 , vt_2 > > iterator () {
return new fn_7 ( fn_8 () . iterator () ) ;
}
@Override
@SuppressWarnings ( lr_1 )
public Object [] toArray () {
final Object [] array = fn_8 () . toArray () ;
for ( int vr_9 = 0 ; vr_9 < array . length ; vr_9 ++ ) {
array [ vr_9 ] = new fn_9 ( ( vr_2 . vr_3 < vt_1 , vt_2 > ) array [ vr_9 ] ) ;
}
return array ;
}
@Override
@SuppressWarnings ( lr_1 )
public < vt_3 > vt_3 [] toArray ( final vt_3 [] array ) {
Object [] vr_10 = array ;
if ( array . length > 0 ) {
vr_10 = ( Object [] ) Array . vr_11 ( array . getClass () . fn_10 () , 0 ) ;
}
vr_10 = fn_8 () . toArray ( vr_10 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_10 . length ; vr_9 ++ ) {
vr_10 [ vr_9 ] = new fn_9 ( ( vr_2 . vr_3 < vt_1 , vt_2 > ) vr_10 [ vr_9 ] ) ;
}
if ( vr_10 . length > array . length ) {
return ( vt_3 [] ) vr_10 ;
}
System . vr_12 ( vr_10 , 0 , array , 0 , vr_10 . length ) ;
if ( array . length > vr_10 . length ) {
array [ vr_10 . length ] = null ;
}
return array ;
}
@Override
public vr_2 . vr_3 < vt_1 , vt_2 > fn_11 () {
return new fn_9 ( fn_12 () . fn_11 () ) ;
}
@Override
public void remove () {
throw new fn_2 () ;
}
@Override
public vt_2 fn_13 ( final vt_2 vr_13 ) {
throw new fn_2 () ;
}
