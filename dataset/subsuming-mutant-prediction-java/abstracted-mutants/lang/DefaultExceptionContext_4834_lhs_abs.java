@Override
public tp_1 fn_1 ( final String vr_1 , final Object vr_2 ) {
vr_3 . add ( new vr_4 < String , Object > ( vr_1 , vr_2 ) ) ;
return this ;
}
@Override
public tp_1 fn_2 ( final String vr_1 , final Object vr_2 ) {
for ( final Iterator < vr_5 < String , Object > > vr_6 = vr_3 . iterator () ; vr_6 . hasNext () ; ) {
final vr_5 < String , Object > vr_7 = vr_6 . vr_8 () ;
if ( vr_9 . equals ( vr_1 , vr_7 . vr_10 () ) ) {
vr_6 . remove () ;
}
}
fn_1 ( vr_1 , vr_2 ) ;
return this ;
}
@Override
public List < Object > fn_3 ( final String vr_1 ) {
final List < Object > vr_11 = new ArrayList < Object > () ;
for ( final vr_5 < String , Object > vr_12 : vr_3 ) {
if ( vr_9 . equals ( vr_1 , vr_12 . vr_10 () ) ) {
vr_11 . add ( vr_12 . vr_13 () ) ;
}
}
return vr_11 ;
}
@Override
public Object fn_4 ( final String vr_1 ) {
for ( final vr_5 < String , Object > vr_12 : vr_3 ) {
if ( vr_9 . equals ( vr_1 , vr_12 . vr_10 () ) ) {
return vr_12 . vr_13 () ;
}
}
return null ;
}
@Override
public vr_14 < String > fn_5 () {
final vr_14 < String > vr_15 = new vr_16 < String > () ;
for ( final vr_5 < String , Object > vr_12 : vr_3 ) {
vr_15 . add ( vr_12 . vr_10 () ) ;
}
return vr_15 ;
}
@Override
public List < vr_5 < String , Object > > fn_6 () {
return vr_3 ;
}
@Override
public String fn_7 ( final String vr_17 ) {
final StringBuilder vr_18 = new StringBuilder ( 256 ) ;
if ( vr_17 != null ) {
vr_18 . append ( vr_17 ) ;
}
if ( vr_3 . size () > 0 ) {
if ( vr_18 . length () > 0 ) {
vr_18 . append ( '\n' ) ;
}
vr_18 . append ( lr_1 ) ;
int vr_19 = 0 ;
for ( final vr_5 < String , Object > vr_12 : vr_3 ) {
vr_18 . append ( lr_2 ) ;
vr_18 . append ( ++ vr_19 ) ;
vr_18 . append ( ':' ) ;
vr_18 . append ( vr_12 . vr_10 () ) ;
vr_18 . append ( lr_3 ) ;
final Object vr_2 = vr_12 . vr_13 () ;
if ( vr_2 == null ) { MST[NegateConditionalsMutator]MSP[]
vr_18 . append ( lr_4 ) ;
} else {
String vr_20 ;
try {
vr_20 = vr_2 . toString () ;
} catch ( final Exception vr_21 ) {
vr_20 = lr_5 + vr_22 . vr_23 ( vr_21 ) ;
}
vr_18 . append ( vr_20 ) ;
}
vr_18 . append ( lr_6 ) ;
}
vr_18 . append ( lr_7 ) ;
}
return vr_18 . toString () ;
}
