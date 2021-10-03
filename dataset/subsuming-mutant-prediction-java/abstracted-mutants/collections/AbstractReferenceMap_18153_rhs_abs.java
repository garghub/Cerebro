public static tp_1 fn_1 ( final int vr_1 ) {
switch ( vr_1 ) {
case 0 :
return vl_1 ;
case 1 :
return vl_2 ;
case 2 :
return vl_3 ;
default:
throw new IllegalArgumentException () ;
}
}
@Override
protected void fn_2 () {
vl_4 = new vr_2 <> () ;
}
@Override
public int size () {
fn_3 () ; MST[VoidMethodCallMutator]MSP[N]
return super . size () ;
}
@Override
public boolean isEmpty () {
fn_3 () ;
return super . isEmpty () ;
}
@Override
public boolean fn_4 ( final Object vr_3 ) {
fn_3 () ;
final vr_4 < vt_1 , vt_2 > vr_5 = fn_5 ( vr_3 ) ;
if ( vr_5 == null ) {
return false ;
}
return vr_5 . vr_6 () != null ;
}
@Override
public boolean fn_6 ( final Object vr_1 ) {
fn_3 () ;
if ( vr_1 == null ) {
return false ;
}
return super . fn_6 ( vr_1 ) ;
}
@Override
public vt_2 get ( final Object vr_3 ) {
fn_3 () ;
final vr_4 < vt_1 , vt_2 > vr_5 = fn_5 ( vr_3 ) ;
if ( vr_5 == null ) {
return null ;
}
return vr_5 . vr_6 () ;
}
@Override
public vt_2 fn_7 ( final vt_1 vr_3 , final vt_2 vr_1 ) {
vr_7 . vr_8 ( vr_3 , lr_1 ) ;
vr_7 . vr_8 ( vr_1 , lr_2 ) ;
fn_8 () ;
return super . fn_7 ( vr_3 , vr_1 ) ;
}
@Override
public vt_2 remove ( final Object vr_3 ) {
if ( vr_3 == null ) {
return null ;
}
fn_8 () ;
return super . remove ( vr_3 ) ;
}
@Override
public void clear () {
super . clear () ;
while ( vl_4 . vr_9 () != null ) {
}
}
@Override
public vr_10 < vt_1 , vt_2 > fn_9 () {
return new vr_11 <> ( this ) ;
}
@Override
public vr_12 < vr_13 . vr_4 < vt_1 , vt_2 > > fn_10 () {
if ( fn_10 == null ) {
fn_10 = new vr_14 <> ( this ) ;
}
return fn_10 ;
}
@Override
public vr_12 < vt_1 > fn_11 () {
if ( fn_11 == null ) {
fn_11 = new vr_15 <> ( this ) ;
}
return fn_11 ;
}
@Override
public Collection < vt_2 > fn_12 () {
if ( fn_12 == null ) {
fn_12 = new vr_16 <> ( this ) ;
}
return fn_12 ;
}
protected void fn_3 () {
fn_13 () ;
}
protected void fn_8 () {
fn_13 () ;
}
protected void fn_13 () {
vr_17 < ? > vr_18 = vl_4 . vr_9 () ;
while ( vr_18 != null ) {
fn_13 ( vr_18 ) ;
vr_18 = vl_4 . vr_9 () ;
}
}
protected void fn_13 ( final vr_17 < ? > vr_18 ) {
final int vr_19 = vr_18 . vr_20 () ;
final int vr_21 = fn_14 ( vr_19 , vr_22 . length ) ;
vr_23 < vt_1 , vt_2 > vr_24 = null ;
vr_23 < vt_1 , vt_2 > vr_5 = vr_22 [ vr_21 ] ;
while ( vr_5 != null ) {
final vr_25 < vt_1 , vt_2 > vr_26 = ( vr_25 < vt_1 , vt_2 > ) vr_5 ;
if ( vr_26 . fn_13 ( vr_18 ) ) {
if ( vr_24 == null ) {
vr_22 [ vr_21 ] = vr_5 . vr_27 ;
} else {
vr_24 . vr_27 = vr_5 . vr_27 ;
}
this . size -- ;
vr_26 . vr_28 () ;
return;
}
vr_24 = vr_5 ;
vr_5 = vr_5 . vr_27 ;
}
}
@Override
protected vr_23 < vt_1 , vt_2 > fn_5 ( final Object vr_3 ) {
if ( vr_3 == null ) {
return null ;
}
return super . fn_5 ( vr_3 ) ;
}
protected int fn_15 ( final Object vr_3 , final Object vr_1 ) {
return ( vr_3 == null ? 0 : vr_3 . vr_20 () ) ^
( vr_1 == null ? 0 : vr_1 . vr_20 () ) ;
}
@Override
@SuppressWarnings ( lr_3 )
protected boolean fn_16 ( final Object vr_29 , Object vr_30 ) {
vr_30 = vl_5 == tp_1 . vl_1 ? vr_30 : ( ( vr_17 < vt_1 > ) vr_30 ) . get () ;
return vr_29 == vr_30 || vr_29 . equals ( vr_30 ) ;
}
@Override
protected vr_25 < vt_1 , vt_2 > fn_17 ( final vr_23 < vt_1 , vt_2 > vr_27 , final int vr_20 ,
final vt_1 vr_3 , final vt_2 vr_1 ) {
return new vr_25 <> ( this , vr_27 , vr_20 , vr_3 , vr_1 ) ;
}
@Override
protected Iterator < vr_13 . vr_4 < vt_1 , vt_2 > > fn_18 () {
return new vr_31 <> ( this ) ;
}
@Override
protected Iterator < vt_1 > fn_19 () {
return new vr_32 <> ( this ) ;
}
@Override
protected Iterator < vt_2 > fn_20 () {
return new vr_33 <> ( this ) ;
}
@Override
public Object [] toArray () {
return toArray ( new Object [ size () ] ) ;
}
@Override
public < vt_3 > vt_3 [] toArray ( final vt_3 [] vr_34 ) {
final ArrayList < vr_13 . vr_4 < vt_1 , vt_2 > > list = new ArrayList <> ( size () ) ;
for ( final vr_13 . vr_4 < vt_1 , vt_2 > vr_5 : this ) {
list . add ( new vr_35 <> ( vr_5 ) ) ;
}
return list . toArray ( vr_34 ) ;
}
@Override
public Object [] toArray () {
return toArray ( new Object [ size () ] ) ;
}
@Override
public < vt_3 > vt_3 [] toArray ( final vt_3 [] vr_34 ) {
final List < vt_1 > list = new ArrayList <> ( size () ) ;
for ( final vt_1 vr_3 : this ) {
list . add ( vr_3 ) ;
}
return list . toArray ( vr_34 ) ;
}
@Override
public Object [] toArray () {
return toArray ( new Object [ size () ] ) ;
}
@Override
public < vt_3 > vt_3 [] toArray ( final vt_3 [] vr_34 ) {
final List < vt_2 > list = new ArrayList <> ( size () ) ;
for ( final vt_2 vr_1 : this ) {
list . add ( vr_1 ) ;
}
return list . toArray ( vr_34 ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public vt_1 fn_21 () {
return (vt_1) ( vr_36 . vl_5 == tp_1 . vl_1 ? vr_3 : ( ( vr_17 < vt_1 > ) vr_3 ) . get () ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public vt_2 vr_6 () {
return (vt_2) ( vr_36 . vr_37 == tp_1 . vl_1 ? vr_1 : ( ( vr_17 < vt_2 > ) vr_1 ) . get () ) ;
}
@Override
@SuppressWarnings ( lr_3 )
public vt_2 fn_22 ( final vt_2 vr_38 ) {
final vt_2 vr_39 = vr_6 () ;
if ( vr_36 . vr_37 != tp_1 . vl_1 ) {
( ( vr_17 < vt_2 > ) vr_1 ) . clear () ;
}
vr_1 = fn_23 ( vr_36 . vr_37 , vr_38 , vr_20 ) ;
return vr_39 ;
}
@Override
public boolean equals ( final Object vr_38 ) {
if ( vr_38 == this ) {
return true ;
}
if ( vr_38 instanceof vr_13 . vr_4 == false ) {
return false ;
}
final vr_13 . vr_4 < ? , ? > vr_5 = ( vr_13 . vr_4 < ? , ? > ) vr_38 ;
final Object vr_40 = vr_5 . fn_21 () ;
final Object vr_41 = vr_5 . vr_6 () ;
if ( vr_40 == null || vr_41 == null ) {
return false ;
}
return vr_36 . fn_16 ( vr_40 , vr_3 ) &&
vr_36 . vr_42 ( vr_41 , vr_6 () ) ;
}
@Override
public int vr_20 () {
return vr_36 . fn_15 ( fn_21 () , vr_6 () ) ;
}
protected < vt_3 > Object fn_23 ( final tp_1 type , final vt_3 vr_43 , final int vr_19 ) {
if ( type == tp_1 . vl_1 ) {
return vr_43 ;
}
if ( type == tp_1 . vl_2 ) {
return new vr_44 <> ( vr_19 , vr_43 , vr_36 . vl_4 ) ;
}
if ( type == tp_1 . vl_3 ) {
return new vr_45 <> ( vr_19 , vr_43 , vr_36 . vl_4 ) ;
}
throw new Error () ;
}
protected void vr_28 () {
}
protected boolean fn_13 ( final vr_17 < ? > vr_18 ) {
boolean vr_46 = vr_36 . vl_5 != tp_1 . vl_1 && vr_3 == vr_18 ;
vr_46 = vr_46 || vr_36 . vr_37 != tp_1 . vl_1 && vr_1 == vr_18 ;
if ( vr_46 ) {
if ( vr_36 . vl_5 != tp_1 . vl_1 ) {
( ( vr_17 < ? > ) vr_3 ) . clear () ;
}
if ( vr_36 . vr_37 != tp_1 . vl_1 ) {
( ( vr_17 < ? > ) vr_1 ) . clear () ;
} else if ( vr_36 . vr_47 ) {
fn_24 () ;
}
}
return vr_46 ;
}
protected vr_25 < vt_1 , vt_2 > vr_27 () {
return ( vr_25 < vt_1 , vt_2 > ) vr_27 ;
}
protected void fn_24 () {
vr_1 = null ;
}
public boolean hasNext () {
fn_25 () ;
while ( fn_26 () ) {
vr_25 < vt_1 , vt_2 > vr_48 = vr_5 ;
int vr_49 = vr_21 ;
while ( vr_48 == null && vr_49 > 0 ) {
vr_49 -- ;
vr_48 = ( vr_25 < vt_1 , vt_2 > ) vr_36 . vr_22 [ vr_49 ] ;
}
vr_5 = vr_48 ;
vr_21 = vr_49 ;
if ( vr_48 == null ) {
vl_6 = null ;
vl_7 = null ;
return false ;
}
vl_8 = vr_48 . fn_21 () ;
vl_9 = vr_48 . vr_6 () ;
if ( fn_26 () ) {
vr_5 = vr_5 . vr_27 () ;
}
}
return true ;
}
private void fn_25 () {
if ( vr_36 . vr_50 != vl_10 ) {
throw new fn_27 () ;
}
}
private boolean fn_26 () {
return vl_8 == null || vl_9 == null ;
}
protected vr_25 < vt_1 , vt_2 > fn_28 () {
fn_25 () ;
if ( fn_26 () && ! hasNext () ) {
throw new fn_29 () ;
}
vr_24 = vr_5 ;
vr_5 = vr_5 . vr_27 () ;
vl_6 = vl_8 ;
vl_7 = vl_9 ;
vl_8 = null ;
vl_9 = null ;
return vr_24 ;
}
protected vr_25 < vt_1 , vt_2 > fn_30 () {
fn_25 () ;
return vr_24 ;
}
public void remove () {
fn_25 () ;
if ( vr_24 == null ) {
throw new fn_31 () ;
}
vr_36 . remove ( vl_6 ) ;
vr_24 = null ;
vl_6 = null ;
vl_7 = null ;
vl_10 = vr_36 . vr_50 ;
}
@Override
public vr_13 . vr_4 < vt_1 , vt_2 > vr_27 () {
return fn_28 () ;
}
@Override
public vt_1 vr_27 () {
return fn_28 () . fn_21 () ;
}
@Override
public vt_2 vr_27 () {
return fn_28 () . vr_6 () ;
}
@Override
public vt_1 vr_27 () {
return fn_28 () . fn_21 () ;
}
@Override
public vt_1 fn_21 () {
final vr_23 < vt_1 , vt_2 > vr_51 = fn_30 () ;
if ( vr_51 == null ) {
throw new fn_31 ( vr_52 . vr_53 ) ;
}
return vr_51 . fn_21 () ;
}
@Override
public vt_2 vr_6 () {
final vr_23 < vt_1 , vt_2 > vr_51 = fn_30 () ;
if ( vr_51 == null ) {
throw new fn_31 ( vr_52 . vr_54 ) ;
}
return vr_51 . vr_6 () ;
}
@Override
public vt_2 fn_22 ( final vt_2 vr_1 ) {
final vr_23 < vt_1 , vt_2 > vr_51 = fn_30 () ;
if ( vr_51 == null ) {
throw new fn_31 ( vr_52 . vr_55 ) ;
}
return vr_51 . fn_22 ( vr_1 ) ;
}
@Override
public int vr_20 () {
return vr_19 ;
}
@Override
public int vr_20 () {
return vr_19 ;
}
@Override
protected void fn_32 ( final tp_2 out ) throws IOException {
out . vr_56 ( vl_5 . vr_1 ) ;
out . vr_56 ( vr_37 . vr_1 ) ;
out . vr_57 ( vr_47 ) ;
out . vr_58 ( vl_11 ) ;
out . vr_56 ( vr_22 . length ) ;
for ( final vr_10 < vt_1 , vt_2 > vr_59 = fn_9 () ; vr_59 . hasNext () ; ) {
out . vr_60 ( vr_59 . vr_27 () ) ;
out . vr_60 ( vr_59 . vr_6 () ) ;
}
out . vr_60 ( null ) ;
}
@Override
@SuppressWarnings ( lr_3 )
protected void fn_33 ( final tp_3 vr_61 ) throws IOException , vl_12 {
this . vl_5 = tp_1 . fn_1 ( vr_61 . vr_62 () ) ;
this . vr_37 = tp_1 . fn_1 ( vr_61 . vr_62 () ) ;
this . vr_47 = vr_61 . vr_63 () ;
this . vl_11 = vr_61 . vr_64 () ;
final int vr_65 = vr_61 . vr_62 () ;
fn_2 () ;
vr_22 = new vr_23 [ vr_65 ] ;
vl_13 = fn_34 ( vr_22 . length , vl_11 ) ;
while ( true ) {
final vt_1 vr_3 = ( vt_1 ) vr_61 . vr_66 () ;
if ( vr_3 == null ) {
break;
}
final vt_2 vr_1 = ( vt_2 ) vr_61 . vr_66 () ;
fn_7 ( vr_3 , vr_1 ) ;
}
}
protected boolean fn_35 ( final tp_1 type ) {
return this . vl_5 == type ;
}
protected boolean fn_36 ( final tp_1 type ) {
return this . vr_37 == type ;
}
