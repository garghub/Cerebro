public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < ? extends vt_1 > vr_2 ) {
if ( vr_2 instanceof vl_1 ) {
@SuppressWarnings ( lr_1 )
final vr_1 < vt_1 > vr_3 = ( vr_1 < vt_1 > ) vr_2 ;
return vr_3 ;
}
return new vr_4 <> ( vr_2 ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_1 < vt_1 > fn_1 ( Collection < ? extends vt_1 > collection ) {
vr_5 . vr_6 ( collection , lr_2 ) ; MST[ArgumentPropagationMutator]MSP[]
for ( int vr_7 = 0 ; vr_7 < 1000 ; vr_7 ++ ) {
if ( collection instanceof vr_1 ) {
break;
}
if ( collection instanceof vl_2 ) {
collection = ( ( vl_2 < vt_1 > ) collection ) . fn_2 () ;
} else if ( collection instanceof vl_3 ) {
collection = ( ( vl_3 < vt_1 > ) collection ) . fn_2 () ;
}
}
if ( collection instanceof vr_1 == false ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new vr_4 <> ( ( vr_1 < vt_1 > ) collection ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_8 . vr_9 ( fn_2 () . iterator () ) ;
}
@Override
public boolean add ( final vt_1 object ) {
throw new fn_3 () ;
}
@Override
public boolean fn_4 ( final Collection < ? extends vt_1 > vr_2 ) {
throw new fn_3 () ;
}
@Override
public void clear () {
throw new fn_3 () ;
}
@Override
public boolean remove ( final Object object ) {
throw new fn_3 () ;
}
@Override
public boolean fn_5 ( final vr_10 < ? super vt_1 > vr_11 ) {
throw new fn_3 () ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_2 ) {
throw new fn_3 () ;
}
@Override
public boolean fn_7 ( final Collection < ? > vr_2 ) {
throw new fn_3 () ;
}
@Override
public boolean fn_8 () {
return fn_2 () . fn_8 () ;
}
@Override
public int fn_9 () {
return fn_2 () . fn_9 () ;
}
@Override
protected vr_1 < vt_1 > fn_2 () {
return ( vr_1 < vt_1 > ) super . fn_2 () ;
}
