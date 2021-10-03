protected vr_1 < vt_1 , ? extends Collection < vt_2 > > fn_1 () {
return vl_1 ;
}
@SuppressWarnings ( lr_1 )
protected void fn_2 ( final vr_1 < vt_1 , ? extends Collection < vt_2 > > vl_1 ) {
this . vl_1 = ( vr_1 < vt_1 , Collection < vt_2 > > ) vl_1 ;
}
@Override
public boolean fn_3 ( final Object vr_2 ) {
return fn_1 () . fn_3 ( vr_2 ) ;
}
@Override
public boolean fn_4 ( final Object vr_3 ) {
return fn_5 () . contains ( vr_3 ) ;
}
@Override
public boolean fn_6 ( final Object vr_2 , final Object vr_3 ) {
final Collection < vt_2 > vr_4 = fn_1 () . get ( vr_2 ) ;
return vr_4 != null && vr_4 . contains ( vr_3 ) ;
}
@Override
public Collection < vr_5 < vt_1 , vt_2 > > fn_7 () {
return vl_2 != null ? vl_2 : ( vl_2 = new fn_8 () ) ;
}
@Override
public Collection < vt_2 > get ( final vt_1 vr_2 ) {
return fn_9 ( vr_2 ) ;
}
Collection < vt_2 > fn_9 ( final vt_1 vr_2 ) {
return new fn_10 ( vr_2 ) ;
}
@Override
public Collection < vt_2 > remove ( final Object vr_2 ) {
return vr_6 . vr_7 ( fn_1 () . remove ( vr_2 ) ) ;
}
@Override
public boolean fn_11 ( final Object vr_2 , final Object vr_3 ) {
final Collection < vt_2 > vr_4 = fn_1 () . get ( vr_2 ) ;
if ( vr_4 == null ) {
return false ;
}
final boolean vr_8 = vr_4 . remove ( vr_3 ) ;
if ( vr_4 . isEmpty () ) {
fn_1 () . remove ( vr_2 ) ;
}
return vr_8 ;
}
@Override
public boolean isEmpty () {
return fn_1 () . isEmpty () ;
}
@Override
public vr_9 < vt_1 > fn_12 () {
return fn_1 () . fn_12 () ;
}
@Override
public int size () {
int size = 0 ;
for ( final Collection < vt_2 > vr_10 : fn_1 () . fn_5 () ) {
size += vr_10 . size () ;
}
return size ;
}
@Override
public Collection < vt_2 > fn_5 () {
final Collection < vt_2 > vr_11 = vl_3 ;
return vr_11 != null ? vr_11 : ( vl_3 = new fn_13 () ) ;
}
@Override
public void clear () {
fn_1 () . clear () ;
}
@Override
public boolean fn_14 ( final vt_1 vr_2 , final vt_2 vr_3 ) {
Collection < vt_2 > vr_4 = fn_1 () . get ( vr_2 ) ;
if ( vr_4 == null ) {
vr_4 = fn_15 () ;
if ( vr_4 . add ( vr_3 ) ) {
vl_1 . fn_14 ( vr_2 , vr_4 ) ;
return true ;
}
return false ;
}
return vr_4 . add ( vr_3 ) ;
}
@Override
public boolean fn_16 ( final vr_1 < ? extends vt_1 , ? extends vt_2 > vl_1 ) {
vr_12 . vr_13 ( vl_1 , lr_2 ) ;
boolean vr_8 = false ;
for ( final vr_1 . vr_5 < ? extends vt_1 , ? extends vt_2 > vr_14 : vl_1 . vr_15 () ) {
vr_8 |= fn_14 ( vr_14 . vr_16 () , vr_14 . vr_17 () ) ;
}
return vr_8 ;
}
@Override
public boolean fn_16 ( final vr_18 < ? extends vt_1 , ? extends vt_2 > vl_1 ) {
vr_12 . vr_13 ( vl_1 , lr_2 ) ;
boolean vr_8 = false ;
for ( final vr_1 . vr_5 < ? extends vt_1 , ? extends vt_2 > vr_14 : vl_1 . fn_7 () ) {
vr_8 |= fn_14 ( vr_14 . vr_16 () , vr_14 . vr_17 () ) ;
}
return vr_8 ; MST[rv.UOI3Mutator]MSP[]
}
@Override
public vr_19 < vt_1 > fn_17 () {
if ( vl_4 == null ) {
vl_4 = vr_20 . vr_21 ( new fn_18 () ) ;
}
return vl_4 ;
}
@Override
public vr_1 < vt_1 , Collection < vt_2 > > fn_19 () {
return vl_5 != null ? vl_5 : ( vl_5 = new fn_20 ( vl_1 ) ) ;
}
@Override
public boolean fn_16 ( final vt_1 vr_2 , final vr_22 < ? extends vt_2 > fn_5 ) {
vr_12 . vr_13 ( fn_5 , lr_3 ) ;
if ( fn_5 instanceof Collection < ? > ) {
final Collection < ? extends vt_2 > vr_23 = ( Collection < ? extends vt_2 > ) fn_5 ;
return ! vr_23 . isEmpty () && get ( vr_2 ) . fn_21 ( vr_23 ) ;
}
final Iterator < ? extends vt_2 > vr_24 = fn_5 . iterator () ;
return vr_24 . hasNext () && vr_6 . fn_21 ( get ( vr_2 ) , vr_24 ) ;
}
@Override
public vr_25 < vt_1 , vt_2 > fn_22 () {
if ( size () == 0 ) {
return vr_26 . vr_27 () ;
}
return new fn_23 () ;
}
@Override
public boolean equals ( final Object vr_28 ) {
if ( this == vr_28 ) {
return true ;
}
if ( vr_28 instanceof vr_18 ) {
return fn_19 () . equals ( ( ( vr_18 < ? , ? > ) vr_28 ) . fn_19 () ) ;
}
return false ;
}
@Override
public int fn_24 () {
return fn_1 () . fn_24 () ;
}
@Override
public String toString () {
return fn_1 () . toString () ;
}
protected Collection < vt_2 > fn_25 () {
return fn_1 () . get ( vr_2 ) ;
}
@Override
public boolean add ( final vt_2 vr_3 ) {
Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
vr_4 = fn_15 () ;
vr_29 . this . vl_1 . fn_14 ( vr_2 , vr_4 ) ;
}
return vr_4 . add ( vr_3 ) ;
}
@Override
public boolean fn_21 ( final Collection < ? extends vt_2 > vr_30 ) {
Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
vr_4 = fn_15 () ;
vr_29 . this . vl_1 . fn_14 ( vr_2 , vr_4 ) ;
}
return vr_4 . fn_21 ( vr_30 ) ;
}
@Override
public void clear () {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 != null ) {
vr_4 . clear () ;
vr_29 . this . remove ( vr_2 ) ;
}
}
@Override
public Iterator < vt_2 > iterator () {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
return vr_31 . vr_32 ;
}
return new fn_26 ( vr_2 ) ;
}
@Override
public int size () {
final Collection < vt_2 > vr_4 = fn_25 () ;
return vr_4 == null ? 0 : vr_4 . size () ;
}
@Override
public boolean contains ( final Object vr_28 ) {
final Collection < vt_2 > vr_4 = fn_25 () ;
return vr_4 != null && vr_4 . contains ( vr_28 ) ;
}
@Override
public boolean fn_27 ( final Collection < ? > vr_30 ) {
final Collection < vt_2 > vr_4 = fn_25 () ;
return vr_4 != null && vr_4 . fn_27 ( vr_30 ) ;
}
@Override
public boolean isEmpty () {
final Collection < vt_2 > vr_4 = fn_25 () ;
return vr_4 == null || vr_4 . isEmpty () ;
}
@Override
public boolean remove ( final Object vr_33 ) {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
return false ;
}
final boolean vr_34 = vr_4 . remove ( vr_33 ) ;
if ( vr_4 . isEmpty () ) {
vr_29 . this . remove ( vr_2 ) ;
}
return vr_34 ;
}
@Override
public boolean fn_28 ( final Collection < ? > vr_35 ) {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
return false ;
}
final boolean vr_34 = vr_4 . fn_28 ( vr_35 ) ;
if ( vr_4 . isEmpty () ) {
vr_29 . this . remove ( vr_2 ) ;
}
return vr_34 ;
}
@Override
public boolean fn_29 ( final Collection < ? > vr_35 ) {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
return false ;
}
final boolean vr_34 = vr_4 . fn_29 ( vr_35 ) ;
if ( vr_4 . isEmpty () ) {
vr_29 . this . remove ( vr_2 ) ;
}
return vr_34 ;
}
@Override
public Object [] toArray () {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
return vr_6 . vr_36 . toArray () ;
}
return vr_4 . toArray () ;
}
@Override
@SuppressWarnings ( lr_1 )
public < vt_3 > vt_3 [] toArray ( final vt_3 [] vr_37 ) {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
return ( vt_3 [] ) vr_6 . vr_36 . toArray ( vr_37 ) ;
}
return vr_4 . toArray ( vr_37 ) ;
}
@Override
public String toString () {
final Collection < vt_2 > vr_4 = fn_25 () ;
if ( vr_4 == null ) {
return vr_6 . vr_36 . toString () ;
}
return vr_4 . toString () ;
}
@Override
public boolean contains ( final Object vr_38 ) {
return fn_1 () . fn_3 ( vr_38 ) ;
}
@Override
public boolean isEmpty () {
return fn_1 () . isEmpty () ;
}
@Override
public int size () {
return vr_29 . this . size () ;
}
@Override
protected int fn_30 () {
return fn_1 () . size () ;
}
@Override
public int fn_31 ( final Object object ) {
int vr_39 = 0 ;
final Collection < vt_2 > vr_10 = vr_29 . this . fn_1 () . get ( object ) ;
if ( vr_10 != null ) {
vr_39 = vr_10 . size () ;
}
return vr_39 ;
}
@Override
protected Iterator < vr_19 . vr_5 < vt_1 > > fn_32 () {
final tp_1 vr_40 = new tp_1 () ;
return vr_31 . vr_41 ( vl_1 . vr_15 () . iterator () , vr_40 ) ;
}
@Override
public vt_1 fn_33 () {
return vr_42 . vr_16 () ;
}
@Override
public int fn_31 () {
return vr_42 . vr_17 () . size () ;
}
@Override
protected Iterator < ? extends vr_5 < vt_1 , vt_2 > > fn_34 ( final int vr_39 ) {
if ( ! vr_43 . hasNext () ) {
return null ;
}
final vt_1 vr_2 = vr_43 . vr_44 () ;
final vr_45 < vt_2 , vr_5 < vt_1 , vt_2 > > vr_46 = vr_47 -> new fn_35 ( vr_2 , vr_47 ) ;
return new vr_48 <> ( new fn_26 ( vr_2 ) , vr_46 ) ;
}
@Override
public int size () {
return vr_29 . this . size () ;
}
@Override
public vt_2 fn_36 ( final vt_2 vr_3 ) {
throw new fn_37 () ;
}
@Override
public boolean hasNext () {
return vr_24 . hasNext () ;
}
@Override
public vt_1 vr_44 () {
vl_6 = vr_24 . vr_44 () ;
return vl_6 . vr_16 () ;
}
@Override
public vt_1 vr_16 () {
if ( vl_6 == null ) {
throw new fn_38 () ;
}
return vl_6 . vr_16 () ;
}
@Override
public vt_2 vr_17 () {
if ( vl_6 == null ) {
throw new fn_38 () ;
}
return vl_6 . vr_17 () ;
}
@Override
public void remove () {
vr_24 . remove () ;
}
@Override
public vt_2 fn_36 ( final vt_2 vr_3 ) {
if ( vl_6 == null ) {
throw new fn_38 () ;
}
return vl_6 . fn_36 ( vr_3 ) ;
}
@Override
public Iterator < vt_2 > iterator () {
final vr_49 < vt_2 > vr_50 = new vr_49 <> () ;
for ( final vt_1 vr_51 : fn_12 () ) {
vr_50 . vr_52 ( new fn_26 ( vr_51 ) ) ;
}
return vr_50 ;
}
@Override
public int size () {
return vr_29 . this . size () ;
}
@Override
public void clear () {
vr_29 . this . clear () ;
}
@Override
public void remove () {
iterator . remove () ;
if ( fn_5 . isEmpty () ) {
vr_29 . this . remove ( vr_2 ) ;
}
}
@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public vt_2 vr_44 () {
return iterator . vr_44 () ;
}
@Override
public vr_9 < vr_1 . vr_5 < vt_1 , Collection < vt_2 > > > vr_15 () {
return new fn_39 () ;
}
@Override
public boolean fn_3 ( final Object vr_2 ) {
return vr_53 . fn_3 ( vr_2 ) ;
}
@Override
public Collection < vt_2 > get ( final Object vr_2 ) {
final Collection < vt_2 > collection = vr_53 . get ( vr_2 ) ;
if ( collection == null ) {
return null ;
}
@SuppressWarnings ( lr_1 )
final vt_1 vr_51 = ( vt_1 ) vr_2 ;
return fn_9 ( vr_51 ) ;
}
@Override
public vr_9 < vt_1 > fn_12 () {
return vr_29 . this . fn_12 () ;
}
@Override
public int size () {
return vr_53 . size () ;
}
@Override
public Collection < vt_2 > remove ( final Object vr_2 ) {
final Collection < vt_2 > collection = vr_53 . remove ( vr_2 ) ;
if ( collection == null ) {
return null ;
}
final Collection < vt_2 > vr_54 = fn_15 () ;
vr_54 . fn_21 ( collection ) ;
collection . clear () ;
return vr_54 ;
}
@Override
public boolean equals ( final Object object ) {
return this == object || vr_53 . equals ( object ) ;
}
@Override
public int fn_24 () {
return vr_53 . fn_24 () ;
}
@Override
public String toString () {
return vr_53 . toString () ;
}
@Override
public void clear () {
vr_29 . this . clear () ;
}
@Override
public Iterator < vr_1 . vr_5 < vt_1 , Collection < vt_2 > > > iterator () {
return new fn_40 ( vr_53 . vr_15 () . iterator () ) ;
}
@Override
public int size () {
return fn_20 . this . size () ;
}
@Override
public void clear () {
fn_20 . this . clear () ;
}
@Override
public boolean contains ( final Object vr_38 ) {
return vr_53 . vr_15 () . contains ( vr_38 ) ;
}
@Override
public boolean remove ( final Object vr_38 ) {
if ( ! contains ( vr_38 ) ) {
return false ;
}
final vr_1 . vr_5 < ? , ? > vr_14 = ( vr_1 . vr_5 < ? , ? > ) vr_38 ;
vr_29 . this . remove ( vr_14 . vr_16 () ) ;
return true ;
}
@Override
public vr_1 . vr_5 < vt_1 , Collection < vt_2 > > vr_44 () {
final vr_1 . vr_5 < vt_1 , Collection < vt_2 > > vr_14 = super . vr_44 () ;
final vt_1 vr_2 = vr_14 . vr_16 () ;
return new vr_55 <> ( vr_2 , fn_9 ( vr_2 ) ) ;
}
protected void fn_41 ( final tp_2 out ) throws IOException {
out . vr_56 ( vl_1 . size () ) ;
for ( final vr_1 . vr_5 < vt_1 , Collection < vt_2 > > vr_14 : vl_1 . vr_15 () ) {
out . vr_57 ( vr_14 . vr_16 () ) ;
out . vr_56 ( vr_14 . vr_17 () . size () ) ;
for ( final vt_2 vr_3 : vr_14 . vr_17 () ) {
out . vr_57 ( vr_3 ) ;
}
}
}
protected void fn_42 ( final tp_3 vr_58 )
throws IOException , vl_7 {
final int vr_59 = vr_58 . vr_60 () ;
for ( int vr_61 = 0 ; vr_61 < vr_59 ; vr_61 ++ ) {
@SuppressWarnings ( lr_1 )
final vt_1 vr_2 = ( vt_1 ) vr_58 . vr_62 () ;
final Collection < vt_2 > fn_5 = get ( vr_2 ) ;
final int vr_63 = vr_58 . vr_60 () ;
for ( int vr_64 = 0 ; vr_64 < vr_63 ; vr_64 ++ ) {
@SuppressWarnings ( lr_1 )
final vt_2 vr_3 = ( vt_2 ) vr_58 . vr_62 () ;
fn_5 . add ( vr_3 ) ;
}
}
}
