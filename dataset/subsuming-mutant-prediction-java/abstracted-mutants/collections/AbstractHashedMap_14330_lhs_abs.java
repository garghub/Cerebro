protected void fn_1 () {
}
@Override
public tp_1 get ( Object vr_1 ) {
vr_1 = fn_2 ( vr_1 ) ;
final int vr_2 = fn_3 ( vr_1 ) ;
vr_3 < vt_1 , tp_1 > vr_4 = vr_5 [ fn_4 ( vr_2 , vr_5 . length ) ] ;
while ( vr_4 != null ) {
if ( vr_4 . vr_2 == vr_2 && fn_5 ( vr_1 , vr_4 . vr_1 ) ) {
return vr_4 . vr_6 () ;
}
vr_4 = vr_4 . vr_7 ;
}
return null ;
}
@Override
public int size () {
return size ;
}
@Override
public boolean isEmpty () {
return size == 0 ;
}
@Override
public boolean fn_6 ( Object vr_1 ) {
vr_1 = fn_2 ( vr_1 ) ;
final int vr_2 = fn_3 ( vr_1 ) ;
vr_3 < vt_1 , tp_1 > vr_4 = vr_5 [ fn_4 ( vr_2 , vr_5 . length ) ] ;
while ( vr_4 != null ) {
if ( vr_4 . vr_2 == vr_2 && fn_5 ( vr_1 , vr_4 . vr_1 ) ) {
return true ;
}
vr_4 = vr_4 . vr_7 ;
}
return false ;
}
@Override
public boolean fn_7 ( final Object vr_8 ) {
if ( vr_8 == null ) {
for ( final vr_3 < vt_1 , tp_1 > vr_9 : vr_5 ) {
vr_3 < vt_1 , tp_1 > vr_4 = vr_9 ;
while ( vr_4 != null ) {
if ( vr_4 . vr_6 () == null ) {
return true ;
}
vr_4 = vr_4 . vr_7 ;
}
}
} else {
for ( final vr_3 < vt_1 , tp_1 > vr_9 : vr_5 ) {
vr_3 < vt_1 , tp_1 > vr_4 = vr_9 ;
while ( vr_4 != null ) {
if ( fn_8 ( vr_8 , vr_4 . vr_6 () ) ) {
return true ;
}
vr_4 = vr_4 . vr_7 ;
}
}
}
return false ;
}
@Override
public tp_1 fn_9 ( final vt_1 vr_1 , final tp_1 vr_8 ) {
final Object vr_10 = fn_2 ( vr_1 ) ;
final int vr_2 = fn_3 ( vr_10 ) ;
final int vr_11 = fn_4 ( vr_2 , vr_5 . length ) ;
vr_3 < vt_1 , tp_1 > vr_4 = vr_5 [ vr_11 ] ;
while ( vr_4 != null ) {
if ( vr_4 . vr_2 == vr_2 && fn_5 ( vr_10 , vr_4 . vr_1 ) ) {
final tp_1 vr_12 = vr_4 . vr_6 () ;
fn_10 ( vr_4 , vr_8 ) ;
return vr_12 ;
}
vr_4 = vr_4 . vr_7 ;
}
fn_11 ( vr_11 , vr_2 , vr_1 , vr_8 ) ;
return null ;
}
@Override
public void fn_12 ( final vr_13 < ? extends vt_1 , ? extends tp_1 > vr_14 ) {
fn_13 ( vr_14 ) ;
}
private void fn_13 ( final vr_13 < ? extends vt_1 , ? extends tp_1 > vr_14 ) {
final int vr_15 = vr_14 . size () ;
if ( vr_15 == 0 ) {
return;
}
final int vr_16 = (int) ( ( size + vr_15 ) / vl_1 + 1 ) ;
fn_14 ( fn_15 ( vr_16 ) ) ;
for ( final vr_13 . vr_17 < ? extends vt_1 , ? extends tp_1 > vr_4 : vr_14 . vr_18 () ) {
fn_9 ( vr_4 . vr_19 () , vr_4 . vr_6 () ) ;
}
}
@Override
public tp_1 remove ( Object vr_1 ) {
vr_1 = fn_2 ( vr_1 ) ;
final int vr_2 = fn_3 ( vr_1 ) ;
final int vr_11 = fn_4 ( vr_2 , vr_5 . length ) ;
vr_3 < vt_1 , tp_1 > vr_4 = vr_5 [ vr_11 ] ;
vr_3 < vt_1 , tp_1 > vr_20 = null ;
while ( vr_4 != null ) {
if ( vr_4 . vr_2 == vr_2 && fn_5 ( vr_1 , vr_4 . vr_1 ) ) {
final tp_1 vr_12 = vr_4 . vr_6 () ;
fn_16 ( vr_4 , vr_11 , vr_20 ) ;
return vr_12 ;
}
vr_20 = vr_4 ;
vr_4 = vr_4 . vr_7 ;
}
return null ;
}
@Override
public void clear () {
vl_2 ++ ;
final vr_3 < vt_1 , tp_1 > [] vr_5 = this . vr_5 ;
for ( int vr_21 = vr_5 . length - 1 ; vr_21 >= 0 ; vr_21 -- ) {
vr_5 [ vr_21 ] = null ;
}
size = 0 ;
}
protected Object fn_2 ( final Object vr_1 ) {
return vr_1 == null ? NULL : vr_1 ;
}
protected int fn_3 ( final Object vr_1 ) {
int vr_22 = vr_1 . vr_2 () ;
vr_22 += ~ ( vr_22 << 9 ) ;
vr_22 ^= vr_22 >>> 14 ;
vr_22 += vr_22 << 4 ;
vr_22 ^= vr_22 >>> 10 ;
return vr_22 ;
}
protected boolean fn_5 ( final Object vr_23 , final Object vr_24 ) {
return vr_23 == vr_24 || vr_23 . equals ( vr_24 ) ;
}
protected boolean fn_8 ( final Object vr_25 , final Object vr_26 ) {
return vr_25 == vr_26 || vr_25 . equals ( vr_26 ) ;
}
protected int fn_4 ( final int vr_2 , final int vr_27 ) {
return vr_2 & vr_27 - 1 ; MST[rv.AOR4Mutator]MSP[]
}
protected vr_3 < vt_1 , tp_1 > fn_17 ( Object vr_1 ) {
vr_1 = fn_2 ( vr_1 ) ;
final int vr_2 = fn_3 ( vr_1 ) ;
vr_3 < vt_1 , tp_1 > vr_4 = vr_5 [ fn_4 ( vr_2 , vr_5 . length ) ] ;
while ( vr_4 != null ) {
if ( vr_4 . vr_2 == vr_2 && fn_5 ( vr_1 , vr_4 . vr_1 ) ) {
return vr_4 ;
}
vr_4 = vr_4 . vr_7 ;
}
return null ;
}
protected void fn_10 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_1 vr_28 ) {
vr_4 . vr_29 ( vr_28 ) ;
}
protected void fn_18 ( final vr_3 < vt_1 , tp_1 > vr_4 , final int fn_4 , final int vr_2 ,
final vt_1 vr_1 , final tp_1 vr_8 ) {
vr_4 . vr_7 = vr_5 [ fn_4 ] ;
vr_4 . vr_2 = vr_2 ;
vr_4 . vr_1 = vr_1 ;
vr_4 . vr_8 = vr_8 ;
}
protected void fn_11 ( final int fn_4 , final int vr_2 , final vt_1 vr_1 , final tp_1 vr_8 ) {
vl_2 ++ ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_19 ( vr_5 [ fn_4 ] , vr_2 , vr_1 , vr_8 ) ;
fn_20 ( vr_4 , fn_4 ) ;
size ++ ;
fn_21 () ;
}
protected vr_3 < vt_1 , tp_1 > fn_19 ( final vr_3 < vt_1 , tp_1 > vr_7 , final int vr_2 , final vt_1 vr_1 , final tp_1 vr_8 ) {
return new vr_3 <> ( vr_7 , vr_2 , fn_2 ( vr_1 ) , vr_8 ) ;
}
protected void fn_20 ( final vr_3 < vt_1 , tp_1 > vr_4 , final int fn_4 ) {
vr_5 [ fn_4 ] = vr_4 ;
}
protected void fn_16 ( final vr_3 < vt_1 , tp_1 > vr_4 , final int fn_4 , final vr_3 < vt_1 , tp_1 > vr_20 ) {
vl_2 ++ ;
fn_22 ( vr_4 , fn_4 , vr_20 ) ;
size -- ;
fn_23 ( vr_4 ) ;
}
protected void fn_22 ( final vr_3 < vt_1 , tp_1 > vr_4 , final int fn_4 , final vr_3 < vt_1 , tp_1 > vr_20 ) {
if ( vr_20 == null ) {
vr_5 [ fn_4 ] = vr_4 . vr_7 ;
} else {
vr_20 . vr_7 = vr_4 . vr_7 ;
}
}
protected void fn_23 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
vr_4 . vr_7 = null ;
vr_4 . vr_1 = null ;
vr_4 . vr_8 = null ;
}
protected void fn_21 () {
if ( size >= vl_3 ) {
final int vr_30 = vr_5 . length * 2 ;
if ( vr_30 <= vl_4 ) {
fn_14 ( vr_30 ) ;
}
}
}
@SuppressWarnings ( lr_1 )
protected void fn_14 ( final int vr_30 ) {
final int vr_31 = vr_5 . length ;
if ( vr_30 <= vr_31 ) {
return;
}
if ( size == 0 ) {
vl_3 = fn_24 ( vr_30 , vl_1 ) ;
vr_5 = new vr_3 [ vr_30 ] ;
} else {
final vr_3 < vt_1 , tp_1 > vr_32 [] = vr_5 ;
final vr_3 < vt_1 , tp_1 > vr_33 [] = new vr_3 [ vr_30 ] ;
vl_2 ++ ;
for ( int vr_21 = vr_31 - 1 ; vr_21 >= 0 ; vr_21 -- ) {
vr_3 < vt_1 , tp_1 > vr_4 = vr_32 [ vr_21 ] ;
if ( vr_4 != null ) {
vr_32 [ vr_21 ] = null ;
do {
final vr_3 < vt_1 , tp_1 > vr_7 = vr_4 . vr_7 ;
final int vr_11 = fn_4 ( vr_4 . vr_2 , vr_30 ) ;
vr_4 . vr_7 = vr_33 [ vr_11 ] ;
vr_33 [ vr_11 ] = vr_4 ;
vr_4 = vr_7 ;
} while ( vr_4 != null );
}
}
vl_3 = fn_24 ( vr_30 , vl_1 ) ;
vr_5 = vr_33 ;
}
}
protected int fn_15 ( final int vr_34 ) {
int vr_30 = 1 ;
if ( vr_34 > vl_4 ) {
vr_30 = vl_4 ;
} else {
while ( vr_30 < vr_34 ) {
vr_30 <<= 1 ;
}
if ( vr_30 > vl_4 ) {
vr_30 = vl_4 ;
}
}
return vr_30 ;
}
protected int fn_24 ( final int vr_30 , final float vr_35 ) {
return (int) ( vr_30 * vr_35 ) ;
}
protected vr_3 < vt_1 , tp_1 > fn_25 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
return vr_4 . vr_7 ;
}
protected int fn_26 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
return vr_4 . vr_2 ;
}
protected vt_1 fn_27 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
return vr_4 . vr_19 () ;
}
protected tp_1 fn_28 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
return vr_4 . vr_6 () ;
}
@Override
public vr_36 < vt_1 , tp_1 > fn_29 () {
if ( size == 0 ) {
return vr_37 . <vt_1 , tp_1 > fn_30 () ;
}
return new vr_38 <> ( this ) ;
}
@Override
public vt_1 vr_7 () {
return super . vr_39 () . vr_19 () ;
}
@Override
public vt_1 vr_19 () {
final vr_3 < vt_1 , tp_1 > vr_40 = fn_31 () ;
if ( vr_40 == null ) {
throw new fn_32 ( vr_41 . vr_42 ) ;
}
return vr_40 . vr_19 () ;
}
@Override
public tp_1 vr_6 () {
final vr_3 < vt_1 , tp_1 > vr_40 = fn_31 () ;
if ( vr_40 == null ) {
throw new fn_32 ( vr_41 . vr_43 ) ;
}
return vr_40 . vr_6 () ;
}
@Override
public tp_1 vr_29 ( final tp_1 vr_8 ) {
final vr_3 < vt_1 , tp_1 > vr_40 = fn_31 () ;
if ( vr_40 == null ) {
throw new fn_32 ( vr_41 . vr_44 ) ;
}
return vr_40 . vr_29 ( vr_8 ) ;
}
@Override
public vr_45 < vr_13 . vr_17 < vt_1 , tp_1 > > vr_18 () {
if ( vr_18 == null ) {
vr_18 = new vr_46 <> ( this ) ;
}
return vr_18 ;
}
protected Iterator < vr_13 . vr_17 < vt_1 , tp_1 > > fn_33 () {
if ( size () == 0 ) {
return vr_47 . < vr_13 . vr_17 < vt_1 , tp_1 > > fn_34 () ;
}
return new vr_48 <> ( this ) ;
}
@Override
public int size () {
return vr_49 . size () ;
}
@Override
public void clear () {
vr_49 . clear () ;
}
@Override
public boolean contains ( final Object vr_4 ) {
if ( vr_4 instanceof vr_13 . vr_17 ) {
final vr_13 . vr_17 < ? , ? > vr_50 = ( vr_13 . vr_17 < ? , ? > ) vr_4 ;
final vr_17 < vt_1 , tp_1 > vr_51 = vr_49 . fn_17 ( vr_50 . vr_19 () ) ;
return vr_51 != null && vr_51 . equals ( vr_50 ) ;
}
return false ;
}
@Override
public boolean remove ( final Object vr_52 ) {
if ( vr_52 instanceof vr_13 . vr_17 == false ) {
return false ;
}
if ( contains ( vr_52 ) == false ) {
return false ;
}
final vr_13 . vr_17 < ? , ? > vr_4 = ( vr_13 . vr_17 < ? , ? > ) vr_52 ;
vr_49 . remove ( vr_4 . vr_19 () ) ;
return true ;
}
@Override
public Iterator < vr_13 . vr_17 < vt_1 , tp_1 > > iterator () {
return vr_49 . fn_33 () ;
}
@Override
public vr_13 . vr_17 < vt_1 , tp_1 > vr_7 () {
return super . vr_39 () ;
}
@Override
public vr_45 < vt_1 > fn_35 () {
if ( fn_35 == null ) {
fn_35 = new vr_53 <> ( this ) ;
}
return fn_35 ;
}
protected Iterator < vt_1 > fn_36 () {
if ( size () == 0 ) {
return vr_47 . <vt_1 > fn_34 () ;
}
return new vr_54 <> ( this ) ;
}
@Override
public int size () {
return vr_49 . size () ;
}
@Override
public void clear () {
vr_49 . clear () ;
}
@Override
public boolean contains ( final Object vr_1 ) {
return vr_49 . fn_6 ( vr_1 ) ;
}
@Override
public boolean remove ( final Object vr_1 ) {
final boolean vr_55 = vr_49 . fn_6 ( vr_1 ) ;
vr_49 . remove ( vr_1 ) ;
return vr_55 ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_49 . fn_36 () ;
}
@Override
public vt_1 vr_7 () {
return super . vr_39 () . vr_19 () ;
}
@Override
public Collection < tp_1 > fn_37 () {
if ( fn_37 == null ) {
fn_37 = new vr_56 <> ( this ) ;
}
return fn_37 ;
}
protected Iterator < tp_1 > fn_38 () {
if ( size () == 0 ) {
return vr_47 . <tp_1 > fn_34 () ;
}
return new vr_57 <> ( this ) ;
}
@Override
public int size () {
return vr_49 . size () ;
}
@Override
public void clear () {
vr_49 . clear () ;
}
@Override
public boolean contains ( final Object vr_8 ) {
return vr_49 . fn_7 ( vr_8 ) ;
}
@Override
public Iterator < tp_1 > iterator () {
return vr_49 . fn_38 () ;
}
@Override
public tp_1 vr_7 () {
return super . vr_39 () . vr_6 () ;
}
@Override
@SuppressWarnings ( lr_1 )
public vt_1 vr_19 () {
if ( vr_1 == NULL ) {
return null ;
}
return ( vt_1 ) vr_1 ;
}
@Override
@SuppressWarnings ( lr_1 )
public tp_1 vr_6 () {
return ( tp_1 ) vr_8 ;
}
@Override
@SuppressWarnings ( lr_1 )
public tp_1 vr_29 ( final tp_1 vr_8 ) {
final Object vr_58 = this . vr_8 ;
this . vr_8 = vr_8 ;
return ( tp_1 ) vr_58 ;
}
@Override
public boolean equals ( final Object vr_52 ) {
if ( vr_52 == this ) {
return true ;
}
if ( vr_52 instanceof vr_13 . vr_17 == false ) {
return false ;
}
final vr_13 . vr_17 < ? , ? > vr_59 = ( vr_13 . vr_17 < ? , ? > ) vr_52 ;
return
( vr_19 () == null ? vr_59 . vr_19 () == null : vr_19 () . equals ( vr_59 . vr_19 () ) ) &&
( vr_6 () == null ? vr_59 . vr_6 () == null : vr_6 () . equals ( vr_59 . vr_6 () ) ) ;
}
@Override
public int vr_2 () {
return ( vr_19 () == null ? 0 : vr_19 () . vr_2 () ) ^
( vr_6 () == null ? 0 : vr_6 () . vr_2 () ) ;
}
@Override
public String toString () {
return new StringBuilder () . append ( vr_19 () ) . append ( '=' ) . append ( vr_6 () ) . toString () ;
}
public boolean hasNext () {
return vr_7 != null ;
}
protected vr_3 < vt_1 , tp_1 > vr_39 () {
if ( vr_49 . vl_2 != vl_5 ) {
throw new fn_39 () ;
}
final vr_3 < vt_1 , tp_1 > vr_60 = vr_7 ;
if ( vr_60 == null ) {
throw new fn_40 ( vr_41 . vr_61 ) ;
}
final vr_3 < vt_1 , tp_1 > [] vr_5 = vr_49 . vr_5 ;
int vr_21 = fn_4 ;
vr_3 < vt_1 , tp_1 > vr_62 = vr_60 . vr_7 ;
while ( vr_62 == null && vr_21 > 0 ) {
vr_62 = vr_5 [ -- vr_21 ] ;
}
vr_7 = vr_62 ;
fn_4 = vr_21 ;
vl_6 = vr_60 ;
return vr_60 ;
}
protected vr_3 < vt_1 , tp_1 > fn_31 () {
return vl_6 ;
}
public void remove () {
if ( vl_6 == null ) {
throw new fn_32 ( vr_41 . vr_63 ) ;
}
if ( vr_49 . vl_2 != vl_5 ) {
throw new fn_39 () ;
}
vr_49 . remove ( vl_6 . vr_19 () ) ;
vl_6 = null ;
vl_5 = vr_49 . vl_2 ;
}
@Override
public String toString () {
if ( vl_6 != null ) {
return lr_2 + vl_6 . vr_19 () + lr_3 + vl_6 . vr_6 () + lr_4 ;
}
return lr_5 ;
}
protected void fn_41 ( final tp_2 out ) throws IOException {
out . vr_64 ( vl_1 ) ;
out . vr_65 ( vr_5 . length ) ;
out . vr_65 ( size ) ;
for ( final vr_36 < vt_1 , tp_1 > vr_66 = fn_29 () ; vr_66 . hasNext () ; ) {
out . vr_67 ( vr_66 . vr_7 () ) ;
out . vr_67 ( vr_66 . vr_6 () ) ;
}
}
@SuppressWarnings ( lr_1 )
protected void fn_42 ( final tp_3 vr_68 ) throws IOException , vl_7 {
vl_1 = vr_68 . vr_69 () ;
final int vr_70 = vr_68 . vr_71 () ;
final int size = vr_68 . vr_71 () ;
fn_1 () ;
vl_3 = fn_24 ( vr_70 , vl_1 ) ;
vr_5 = new vr_3 [ vr_70 ] ;
for ( int vr_21 = 0 ; vr_21 < size ; vr_21 ++ ) {
final vt_1 vr_1 = ( vt_1 ) vr_68 . vr_72 () ;
final tp_1 vr_8 = ( tp_1 ) vr_68 . vr_72 () ;
fn_9 ( vr_1 , vr_8 ) ;
}
}
@Override
@SuppressWarnings ( lr_1 )
protected vr_41 < vt_1 , tp_1 > fn_43 () {
try {
final vr_41 < vt_1 , tp_1 > vr_73 = ( vr_41 < vt_1 , tp_1 > ) super . fn_43 () ;
vr_73 . vr_5 = new vr_3 [ vr_5 . length ] ;
vr_73 . vr_18 = null ;
vr_73 . fn_35 = null ;
vr_73 . fn_37 = null ;
vr_73 . vl_2 = 0 ;
vr_73 . size = 0 ;
vr_73 . fn_1 () ;
vr_73 . fn_12 ( this ) ;
return vr_73 ;
} catch ( final tp_4 vr_74 ) {
throw new fn_44 () ;
}
}
@Override
public boolean equals ( final Object vr_52 ) {
if ( vr_52 == this ) {
return true ;
}
if ( vr_52 instanceof vr_13 == false ) {
return false ;
}
final vr_13 < ? , ? > vr_14 = ( vr_13 < ? , ? > ) vr_52 ;
if ( vr_14 . size () != size () ) {
return false ;
}
final vr_36 < ? , ? > vr_66 = fn_29 () ;
try {
while ( vr_66 . hasNext () ) {
final Object vr_1 = vr_66 . vr_7 () ;
final Object vr_8 = vr_66 . vr_6 () ;
if ( vr_8 == null ) {
if ( vr_14 . get ( vr_1 ) != null || vr_14 . fn_6 ( vr_1 ) == false ) {
return false ;
}
} else {
if ( vr_8 . equals ( vr_14 . get ( vr_1 ) ) == false ) {
return false ;
}
}
}
} catch ( final tp_5 vr_75 ) {
return false ;
} catch ( final tp_6 vr_75 ) {
return false ;
}
return true ;
}
@Override
public int vr_2 () {
int vr_76 = 0 ;
final Iterator < vr_13 . vr_17 < vt_1 , tp_1 > > vr_66 = fn_33 () ;
while ( vr_66 . hasNext () ) {
vr_76 += vr_66 . vr_7 () . vr_2 () ;
}
return vr_76 ;
}
@Override
public String toString () {
if ( size () == 0 ) {
return lr_6 ;
}
final StringBuilder vr_77 = new StringBuilder ( 32 * size () ) ;
vr_77 . append ( '{' ) ;
final vr_36 < vt_1 , tp_1 > vr_66 = fn_29 () ;
boolean hasNext = vr_66 . hasNext () ;
while ( hasNext ) {
final vt_1 vr_1 = vr_66 . vr_7 () ;
final tp_1 vr_8 = vr_66 . vr_6 () ;
vr_77 . append ( vr_1 == this ? lr_7 : vr_1 )
. append ( '=' )
. append ( vr_8 == this ? lr_7 : vr_8 ) ;
hasNext = vr_66 . hasNext () ;
if ( hasNext ) {
vr_77 . append ( ',' ) . append ( ' ' ) ;
}
}
vr_77 . append ( '}' ) ;
return vr_77 . toString () ;
}
