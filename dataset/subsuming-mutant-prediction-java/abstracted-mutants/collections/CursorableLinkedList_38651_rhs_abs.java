@Override
protected void fn_1 () {
super . fn_1 () ;
vl_1 = new ArrayList <> () ;
}
@Override
public Iterator < vt_1 > iterator () {
return super . vr_1 ( 0 ) ;
}
@Override
public vr_2 < vt_1 > vr_1 () {
return fn_2 ( 0 ) ;
}
@Override
public vr_2 < vt_1 > vr_1 ( final int vr_3 ) {
return fn_2 ( vr_3 ) ;
}
public vr_4 . vr_5 < vt_1 > fn_2 () {
return fn_2 ( 0 ) ;
}
public vr_4 . vr_5 < vt_1 > fn_2 ( final int vr_3 ) {
final vr_5 < vt_1 > fn_2 = new vr_5 <> ( this , vr_3 ) ;
fn_3 ( fn_2 ) ;
return fn_2 ;
}
@Override
protected void fn_4 ( final vr_6 < vt_1 > vr_7 , final vt_1 vr_8 ) {
super . fn_4 ( vr_7 , vr_8 ) ;
fn_5 ( vr_7 ) ;
}
@Override
protected void fn_6 ( final vr_6 < vt_1 > vr_9 , final vr_6 < vt_1 > vr_10 ) {
super . fn_6 ( vr_9 , vr_10 ) ;
fn_7 ( vr_9 ) ;
}
@Override
protected void fn_8 ( final vr_6 < vt_1 > vr_7 ) {
super . fn_8 ( vr_7 ) ;
fn_9 ( vr_7 ) ;
}
@Override
protected void fn_10 () {
if ( size () > 0 ) {
final Iterator < vt_1 > vr_11 = iterator () ;
while ( vr_11 . hasNext () ) {
vr_11 . vr_12 () ;
vr_11 . remove () ;
}
}
}
protected void fn_3 ( final vr_5 < vt_1 > fn_2 ) {
vl_1 . vr_13 ( vr_14 -> vr_14 . get () == null ) ;
vl_1 . add ( new vr_15 <> ( fn_2 ) ) ;
}
protected void fn_11 ( final vr_5 < vt_1 > fn_2 ) {
for ( final Iterator < vr_15 < vr_5 < vt_1 > > > vr_11 = vl_1 . iterator () ; vr_11 . hasNext () ; ) {
final vr_15 < vr_5 < vt_1 > > vr_14 = vr_11 . vr_12 () ;
final vr_5 < vt_1 > vr_16 = vr_14 . get () ;
if ( vr_16 == null ) {
vr_11 . remove () ;
} else if ( vr_16 == fn_2 ) {
vr_14 . clear () ;
vr_11 . remove () ;
break;
}
}
}
protected void fn_5 ( final vr_6 < vt_1 > vr_7 ) {
final Iterator < vr_15 < vr_5 < vt_1 > > > vr_11 = vl_1 . iterator () ;
while ( vr_11 . hasNext () ) {
final vr_15 < vr_5 < vt_1 > > vr_14 = vr_11 . vr_12 () ;
final vr_5 < vt_1 > fn_2 = vr_14 . get () ;
if ( fn_2 == null ) {
vr_11 . remove () ;
} else {
fn_2 . vr_17 ( vr_7 ) ;
}
}
}
protected void fn_9 ( final vr_6 < vt_1 > vr_7 ) {
final Iterator < vr_15 < vr_5 < vt_1 > > > vr_11 = vl_1 . iterator () ;
while ( vr_11 . hasNext () ) {
final vr_15 < vr_5 < vt_1 > > vr_14 = vr_11 . vr_12 () ;
final vr_5 < vt_1 > fn_2 = vr_14 . get () ;
if ( fn_2 == null ) {
vr_11 . remove () ;
} else {
fn_2 . vr_18 ( vr_7 ) ;
}
}
}
protected void fn_7 ( final vr_6 < vt_1 > vr_7 ) {
final Iterator < vr_15 < vr_5 < vt_1 > > > vr_11 = vl_1 . iterator () ;
while ( vr_11 . hasNext () ) {
final vr_15 < vr_5 < vt_1 > > vr_14 = vr_11 . vr_12 () ;
final vr_5 < vt_1 > fn_2 = vr_14 . get () ;
if ( fn_2 == null ) {
vr_11 . remove () ;
} else {
fn_2 . vr_19 ( vr_7 ) ;
}
}
}
private void fn_12 ( final tp_1 out ) throws IOException {
out . vr_20 () ;
fn_13 ( out ) ;
}
private void fn_14 ( final tp_2 vr_21 ) throws IOException , vl_2 {
vr_21 . vr_22 () ;
fn_15 ( vr_21 ) ;
}
@Override
protected vr_2 < vt_1 > fn_16 ( final vr_23 < vt_1 > vr_24 , final int vr_3 ) {
final vr_25 < vt_1 > fn_2 = new vr_25 <> ( vr_24 , vr_3 ) ;
fn_3 ( fn_2 ) ;
return fn_2 ;
}
@Override
public void remove () {
if ( vl_3 == null && vl_4 ) {
} else {
fn_17 () ;
vr_26 . fn_8 ( fn_18 () ) ;
}
vl_4 = false ;
}
@Override
public void add ( final vt_1 vr_27 ) {
super . add ( vr_27 ) ;
vr_12 = vr_12 . vr_12 ;
}
@Override
public int fn_19 () {
if ( vl_5 == false ) {
if ( vr_12 == vr_26 . vr_28 ) {
fn_19 = vr_26 . size () ;
} else {
int vr_29 = 0 ;
vr_6 < vt_1 > vr_30 = vr_26 . vr_28 . vr_12 ;
while ( vr_30 != vr_12 ) {
vr_29 ++ ;
vr_30 = vr_30 . vr_12 ;
}
fn_19 = vr_29 ;
}
vl_5 = true ;
}
return fn_19 ;
}
protected void vr_17 ( final vr_6 < vt_1 > vr_7 ) {
}
protected void vr_18 ( final vr_6 < vt_1 > vr_7 ) {
if ( vr_7 == vr_12 && vr_7 == vl_3 ) {
vr_12 = vr_7 . vr_12 ;
vl_3 = null ;
vl_4 = true ;
} else if ( vr_7 == vr_12 ) {
vr_12 = vr_7 . vr_12 ;
vl_4 = false ;
} else if ( vr_7 == vl_3 ) {
vl_3 = null ;
vl_4 = true ;
fn_19 -- ;
} else {
vl_5 = false ;
vl_4 = false ;
}
}
protected void vr_19 ( final vr_6 < vt_1 > vr_7 ) {
if ( vr_7 . vr_31 == vl_3 ) {
vr_12 = vr_7 ;
} else if ( vr_12 . vr_31 == vr_7 ) {
vr_12 = vr_7 ;
} else {
vl_5 = false ;
}
}
@Override
protected void fn_17 () {
if ( ! vl_6 ) {
throw new fn_20 ( lr_1 ) ;
}
}
public void fn_21 () {
if ( vl_6 ) {
( ( vr_4 < vt_1 > ) vr_26 ) . fn_11 ( this ) ;
vl_6 = false ;
}
}
@Override
public boolean hasNext () {
return fn_19 () < vr_32 . size ; MST[rv.CRCR5Mutator]MSP[S]
}
@Override
public boolean fn_22 () {
return fn_23 () >= 0 ;
}
@Override
public int fn_19 () {
return super . fn_19 () - vr_32 . vr_33 ;
}
@Override
public void add ( final vt_1 vr_27 ) {
super . add ( vr_27 ) ;
vr_32 . vr_34 = vr_26 . vr_35 ;
vr_32 . size ++ ;
}
@Override
public void remove () {
super . remove () ;
vr_32 . vr_34 = vr_26 . vr_35 ;
vr_32 . size -- ;
}
