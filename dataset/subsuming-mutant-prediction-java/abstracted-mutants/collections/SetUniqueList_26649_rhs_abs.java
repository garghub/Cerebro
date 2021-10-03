public static < vt_1 > vr_1 < vt_1 > fn_1 ( final List < vt_1 > list ) {
vr_2 . vr_3 ( list , lr_1 ) ;
if ( list . isEmpty () ) {
return new vr_1 <> ( list , new vr_4 < vt_1 > () ) ;
}
final List < vt_1 > vr_5 = new ArrayList <> ( list ) ;
list . clear () ;
final vr_1 < vt_1 > vr_6 = new vr_1 <> ( list , new vr_4 < vt_1 > () ) ;
vr_6 . vr_7 ( vr_5 ) ;
return vr_6 ;
}
public vr_8 < vt_1 > fn_2 () {
return vr_9 . vr_10 ( vl_1 ) ;
}
@Override
public boolean add ( final vt_1 object ) {
final int vr_11 = size () ;
add ( size () , object ) ;
return vr_11 != size () ;
}
@Override
public void add ( final int vr_12 , final vt_1 object ) {
if ( vl_1 . contains ( object ) == false ) {
vl_1 . add ( object ) ;
super . add ( vr_12 , object ) ;
}
}
@Override
public boolean vr_7 ( final Collection < ? extends vt_1 > vr_13 ) {
return vr_7 ( size () , vr_13 ) ;
}
@Override
public boolean vr_7 ( final int vr_12 , final Collection < ? extends vt_1 > vr_13 ) {
final List < vt_1 > vr_5 = new ArrayList <> () ;
for ( final vt_1 vr_14 : vr_13 ) {
if ( vl_1 . add ( vr_14 ) ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[N]
vr_5 . add ( vr_14 ) ;
}
}
return super . vr_7 ( vr_12 , vr_5 ) ;
}
@Override
public vt_1 vl_1 ( final int vr_12 , final vt_1 object ) {
final int vr_15 = indexOf ( object ) ;
final vt_1 vr_16 = super . vl_1 ( vr_12 , object ) ;
if ( vr_15 != - 1 && vr_15 != vr_12 ) {
super . remove ( vr_15 ) ;
}
vl_1 . remove ( vr_16 ) ;
vl_1 . add ( object ) ;
return vr_16 ;
}
@Override
public boolean remove ( final Object object ) {
final boolean vr_17 = vl_1 . remove ( object ) ;
if ( vr_17 ) {
super . remove ( object ) ;
}
return vr_17 ;
}
@Override
public vt_1 remove ( final int vr_12 ) {
final vt_1 vr_17 = super . remove ( vr_12 ) ;
vl_1 . remove ( vr_17 ) ;
return vr_17 ;
}
@Override
public boolean fn_3 ( final vr_18 < ? super vt_1 > vr_19 ) {
final boolean vr_17 = super . fn_3 ( vr_19 ) ;
vl_1 . fn_3 ( vr_19 ) ;
return vr_17 ;
}
@Override
public boolean fn_4 ( final Collection < ? > vr_13 ) {
boolean vr_17 = false ;
for ( final Object vr_20 : vr_13 ) {
vr_17 |= remove ( vr_20 ) ;
}
return vr_17 ;
}
@Override
public boolean fn_5 ( final Collection < ? > vr_13 ) {
final boolean vr_17 = vl_1 . fn_5 ( vr_13 ) ;
if ( vr_17 == false ) {
return false ;
}
if ( vl_1 . size () == 0 ) {
super . clear () ;
} else {
super . fn_5 ( vl_1 ) ;
}
return vr_17 ;
}
@Override
public void clear () {
super . clear () ;
vl_1 . clear () ;
}
@Override
public boolean contains ( final Object object ) {
return vl_1 . contains ( object ) ;
}
@Override
public boolean fn_6 ( final Collection < ? > vr_13 ) {
return vl_1 . fn_6 ( vr_13 ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return new vr_21 <> ( super . iterator () , vl_1 ) ;
}
@Override
public vr_22 < vt_1 > fn_7 () {
return new vr_23 <> ( super . fn_7 () , vl_1 ) ;
}
@Override
public vr_22 < vt_1 > fn_7 ( final int vr_12 ) {
return new vr_23 <> ( super . fn_7 ( vr_12 ) , vl_1 ) ;
}
@Override
public List < vt_1 > fn_8 ( final int vr_24 , final int vr_25 ) {
final List < vt_1 > vr_26 = super . fn_8 ( vr_24 , vr_25 ) ;
final vr_8 < vt_1 > vr_27 = fn_9 ( vl_1 , vr_26 ) ;
return vr_28 . vr_29 ( new vr_1 <> ( vr_26 , vr_27 ) ) ;
}
protected vr_8 < vt_1 > fn_9 ( final vr_8 < vt_1 > vl_1 , final List < vt_1 > list ) {
vr_8 < vt_1 > vr_27 ;
if ( vl_1 . getClass () . equals ( vr_4 . class ) ) {
vr_27 = new vr_4 <> ( list . size () ) ;
} else {
try {
vr_27 = vl_1 . getClass () . fn_10 ( vl_1 . getClass () ) . fn_11 ( vl_1 ) ;
} catch ( final tp_1
| tp_2
| tp_3
| tp_4 vr_30 ) {
vr_27 = new vr_4 <> () ;
}
}
return vr_27 ;
}
@Override
public vt_1 fn_12 () {
vl_2 = super . fn_12 () ;
return vl_2 ;
}
@Override
public void remove () {
super . remove () ;
vl_1 . remove ( vl_2 ) ;
vl_2 = null ;
}
@Override
public vt_1 fn_12 () {
vl_2 = super . fn_12 () ;
return vl_2 ;
}
@Override
public vt_1 fn_13 () {
vl_2 = super . fn_13 () ;
return vl_2 ;
}
@Override
public void remove () {
super . remove () ;
vl_1 . remove ( vl_2 ) ;
vl_2 = null ;
}
@Override
public void add ( final vt_1 object ) {
if ( vl_1 . contains ( object ) == false ) {
super . add ( object ) ;
vl_1 . add ( object ) ;
}
}
@Override
public void vl_1 ( final vt_1 object ) {
throw new fn_14 ( lr_2 ) ;
}
