public static < vt_1 > vr_1 < vt_1 > fn_1 ( final vr_1 < vt_1 > vr_2 ) {
return new vr_3 <> ( vr_2 ) ;
}
private void fn_2 ( final tp_1 out ) throws IOException {
out . vr_4 () ;
out . fn_2 ( fn_3 () ) ;
}
@SuppressWarnings ( lr_1 )
private void fn_4 ( final tp_2 vr_5 ) throws IOException , vl_1 {
vr_5 . vr_6 () ;
fn_5 ( ( Collection < vt_1 > ) vr_5 . fn_4 () ) ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_7 ) {
final Iterator < ? > vr_8 = vr_7 . iterator () ;
while ( vr_8 . hasNext () ) {
if ( ! contains ( vr_8 . vr_9 () ) ) {
return false ;
}
}
return true ;
}
@Override
public boolean add ( final vt_1 object ) {
return add ( object , 1 ) ;
}
@Override
public boolean fn_7 ( final Collection < ? extends vt_1 > vr_7 ) {
boolean vr_10 = false ;
final Iterator < ? extends vt_1 > vr_11 = vr_7 . iterator () ;
while ( vr_11 . hasNext () ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
final boolean vr_12 = add ( vr_11 . vr_9 () , 1 ) ;
vr_10 = vr_10 || vr_12 ;
}
return vr_10 ;
}
@Override
public boolean remove ( final Object object ) {
return remove ( object , 1 ) ;
}
@Override
public boolean fn_8 ( final Collection < ? > vr_7 ) {
if ( vr_7 != null ) {
boolean vr_13 = false ;
final Iterator < ? > vr_11 = vr_7 . iterator () ;
while ( vr_11 . hasNext () ) {
final Object vr_14 = vr_11 . vr_9 () ;
final boolean vr_10 = remove ( vr_14 , fn_9 ( vr_14 ) ) ;
vr_13 = vr_13 || vr_10 ;
}
return vr_13 ;
}
return fn_3 () . fn_8 ( null ) ;
}
@Override
public boolean fn_10 ( final Collection < ? > vr_7 ) {
if ( vr_7 != null ) {
boolean vr_15 = false ;
final Iterator < vt_1 > vr_8 = iterator () ;
while ( vr_8 . hasNext () ) {
if ( ! vr_7 . contains ( vr_8 . vr_9 () ) ) {
vr_8 . remove () ;
vr_15 = true ;
}
}
return vr_15 ;
}
return fn_3 () . fn_10 ( null ) ;
}
@Override
public boolean add ( final vt_1 object , final int vr_16 ) {
fn_3 () . add ( object , vr_16 ) ;
return true ;
}
