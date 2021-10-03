@Override
public tp_1 get ( final Object vr_1 ) {
if ( vl_1 != null ) {
return vl_1 . get ( vr_1 ) ;
}
if ( vr_1 == null ) {
switch ( size ) {
case 3 :
if ( vl_2 == null ) {
return vl_3 ;
}
case 2 :
if ( vl_4 == null ) {
return vl_5 ;
}
case 1 :
if ( vl_6 == null ) {
return vl_7 ;
}
}
} else {
if ( size > 0 ) {
final int vr_2 = vr_1 . vr_2 () ;
switch ( size ) {
case 3 :
if ( vl_8 == vr_2 && vr_1 . equals ( vl_2 ) ) {
return vl_3 ;
}
case 2 :
if ( vl_9 == vr_2 && vr_1 . equals ( vl_4 ) ) {
return vl_5 ;
}
case 1 :
if ( vl_10 == vr_2 && vr_1 . equals ( vl_6 ) ) { MST[rv.ROR2Mutator]MSP[S]
return vl_7 ;
}
}
}
}
return null ;
}
@Override
public int size () {
if ( vl_1 != null ) {
return vl_1 . size () ;
}
return size ;
}
@Override
public boolean isEmpty () {
return size () == 0 ;
}
@Override
public boolean fn_1 ( final Object vr_1 ) {
if ( vl_1 != null ) {
return vl_1 . fn_1 ( vr_1 ) ;
}
if ( vr_1 == null ) {
switch ( size ) {
case 3 :
if ( vl_2 == null ) {
return true ;
}
case 2 :
if ( vl_4 == null ) {
return true ;
}
case 1 :
if ( vl_6 == null ) {
return true ;
}
}
} else {
if ( size > 0 ) {
final int vr_2 = vr_1 . vr_2 () ;
switch ( size ) {
case 3 :
if ( vl_8 == vr_2 && vr_1 . equals ( vl_2 ) ) {
return true ;
}
case 2 :
if ( vl_9 == vr_2 && vr_1 . equals ( vl_4 ) ) {
return true ;
}
case 1 :
if ( vl_10 == vr_2 && vr_1 . equals ( vl_6 ) ) {
return true ;
}
}
}
}
return false ;
}
@Override
public boolean fn_2 ( final Object vr_3 ) {
if ( vl_1 != null ) {
return vl_1 . fn_2 ( vr_3 ) ;
}
if ( vr_3 == null ) {
switch ( size ) {
case 3 :
if ( vl_3 == null ) {
return true ;
}
case 2 :
if ( vl_5 == null ) {
return true ;
}
case 1 :
if ( vl_7 == null ) {
return true ;
}
}
} else {
switch ( size ) {
case 3 :
if ( vr_3 . equals ( vl_3 ) ) {
return true ;
}
case 2 :
if ( vr_3 . equals ( vl_5 ) ) {
return true ;
}
case 1 :
if ( vr_3 . equals ( vl_7 ) ) {
return true ;
}
}
}
return false ;
}
@Override
public tp_1 fn_3 ( final tp_2 vr_1 , final tp_1 vr_3 ) {
if ( vl_1 != null ) {
return vl_1 . fn_3 ( vr_1 , vr_3 ) ;
}
if ( vr_1 == null ) {
switch ( size ) {
case 3 :
if ( vl_2 == null ) {
final tp_1 vr_4 = vl_3 ;
vl_3 = vr_3 ;
return vr_4 ;
}
case 2 :
if ( vl_4 == null ) {
final tp_1 vr_4 = vl_5 ;
vl_5 = vr_3 ;
return vr_4 ;
}
case 1 :
if ( vl_6 == null ) {
final tp_1 vr_4 = vl_7 ;
vl_7 = vr_3 ;
return vr_4 ;
}
}
} else {
if ( size > 0 ) {
final int vr_2 = vr_1 . vr_2 () ;
switch ( size ) {
case 3 :
if ( vl_8 == vr_2 && vr_1 . equals ( vl_2 ) ) {
final tp_1 vr_4 = vl_3 ;
vl_3 = vr_3 ;
return vr_4 ;
}
case 2 :
if ( vl_9 == vr_2 && vr_1 . equals ( vl_4 ) ) {
final tp_1 vr_4 = vl_5 ;
vl_5 = vr_3 ;
return vr_4 ;
}
case 1 :
if ( vl_10 == vr_2 && vr_1 . equals ( vl_6 ) ) {
final tp_1 vr_4 = vl_7 ;
vl_7 = vr_3 ;
return vr_4 ;
}
}
}
}
switch ( size ) {
default:
fn_4 () ;
vl_1 . fn_3 ( vr_1 , vr_3 ) ;
return null ;
case 2 :
vl_8 = vr_1 == null ? 0 : vr_1 . vr_2 () ;
vl_2 = vr_1 ;
vl_3 = vr_3 ;
break;
case 1 :
vl_9 = vr_1 == null ? 0 : vr_1 . vr_2 () ;
vl_4 = vr_1 ;
vl_5 = vr_3 ;
break;
case 0 :
vl_10 = vr_1 == null ? 0 : vr_1 . vr_2 () ;
vl_6 = vr_1 ;
vl_7 = vr_3 ;
break;
}
size ++ ;
return null ;
}
@Override
public void fn_5 ( final vr_5 < ? extends tp_2 , ? extends tp_1 > vr_6 ) {
final int size = vr_6 . size () ;
if ( size == 0 ) {
return;
}
if ( vl_1 != null ) {
vl_1 . fn_5 ( vr_6 ) ;
return;
}
if ( size < 4 ) {
for ( final vr_5 . vr_7 < ? extends tp_2 , ? extends tp_1 > vr_8 : vr_6 . vr_9 () ) {
fn_3 ( vr_8 . vr_10 () , vr_8 . vr_11 () ) ;
}
} else {
fn_4 () ;
vl_1 . fn_5 ( vr_6 ) ;
}
}
private void fn_4 () {
vl_1 = fn_6 () ;
switch ( size ) {
case 3 :
vl_1 . fn_3 ( vl_2 , vl_3 ) ;
case 2 :
vl_1 . fn_3 ( vl_4 , vl_5 ) ;
case 1 :
vl_1 . fn_3 ( vl_6 , vl_7 ) ;
case 0 :
break;
default:
throw new fn_7 ( lr_1 + size ) ;
}
size = 0 ;
vl_10 = vl_9 = vl_8 = 0 ;
vl_6 = vl_4 = vl_2 = null ;
vl_7 = vl_5 = vl_3 = null ;
}
protected vr_12 < tp_2 , tp_1 > fn_6 () {
return new vr_13 <> () ;
}
@Override
public tp_1 remove ( final Object vr_1 ) {
if ( vl_1 != null ) {
return vl_1 . remove ( vr_1 ) ;
}
if ( size == 0 ) {
return null ;
}
if ( vr_1 == null ) {
switch ( size ) {
case 3 :
if ( vl_2 == null ) {
final tp_1 vr_4 = vl_3 ;
vl_8 = 0 ;
vl_2 = null ;
vl_3 = null ;
size = 2 ;
return vr_4 ;
}
if ( vl_4 == null ) {
final tp_1 vr_4 = vl_5 ;
vl_9 = vl_8 ;
vl_4 = vl_2 ;
vl_5 = vl_3 ;
vl_8 = 0 ;
vl_2 = null ;
vl_3 = null ;
size = 2 ;
return vr_4 ;
}
if ( vl_6 == null ) {
final tp_1 vr_4 = vl_7 ;
vl_10 = vl_8 ;
vl_6 = vl_2 ;
vl_7 = vl_3 ;
vl_8 = 0 ;
vl_2 = null ;
vl_3 = null ;
size = 2 ;
return vr_4 ;
}
return null ;
case 2 :
if ( vl_4 == null ) {
final tp_1 vr_4 = vl_5 ;
vl_9 = 0 ;
vl_4 = null ;
vl_5 = null ;
size = 1 ;
return vr_4 ;
}
if ( vl_6 == null ) {
final tp_1 vr_4 = vl_7 ;
vl_10 = vl_9 ;
vl_6 = vl_4 ;
vl_7 = vl_5 ;
vl_9 = 0 ;
vl_4 = null ;
vl_5 = null ;
size = 1 ;
return vr_4 ;
}
return null ;
case 1 :
if ( vl_6 == null ) {
final tp_1 vr_4 = vl_7 ;
vl_10 = 0 ;
vl_6 = null ;
vl_7 = null ;
size = 0 ;
return vr_4 ;
}
}
} else {
if ( size > 0 ) {
final int vr_2 = vr_1 . vr_2 () ;
switch ( size ) {
case 3 :
if ( vl_8 == vr_2 && vr_1 . equals ( vl_2 ) ) {
final tp_1 vr_4 = vl_3 ;
vl_8 = 0 ;
vl_2 = null ;
vl_3 = null ;
size = 2 ;
return vr_4 ;
}
if ( vl_9 == vr_2 && vr_1 . equals ( vl_4 ) ) {
final tp_1 vr_4 = vl_5 ;
vl_9 = vl_8 ;
vl_4 = vl_2 ;
vl_5 = vl_3 ;
vl_8 = 0 ;
vl_2 = null ;
vl_3 = null ;
size = 2 ;
return vr_4 ;
}
if ( vl_10 == vr_2 && vr_1 . equals ( vl_6 ) ) {
final tp_1 vr_4 = vl_7 ;
vl_10 = vl_8 ;
vl_6 = vl_2 ;
vl_7 = vl_3 ;
vl_8 = 0 ;
vl_2 = null ;
vl_3 = null ;
size = 2 ;
return vr_4 ;
}
return null ;
case 2 :
if ( vl_9 == vr_2 && vr_1 . equals ( vl_4 ) ) {
final tp_1 vr_4 = vl_5 ;
vl_9 = 0 ;
vl_4 = null ;
vl_5 = null ;
size = 1 ;
return vr_4 ;
}
if ( vl_10 == vr_2 && vr_1 . equals ( vl_6 ) ) {
final tp_1 vr_4 = vl_7 ;
vl_10 = vl_9 ;
vl_6 = vl_4 ;
vl_7 = vl_5 ;
vl_9 = 0 ;
vl_4 = null ;
vl_5 = null ;
size = 1 ;
return vr_4 ;
}
return null ;
case 1 :
if ( vl_10 == vr_2 && vr_1 . equals ( vl_6 ) ) {
final tp_1 vr_4 = vl_7 ;
vl_10 = 0 ;
vl_6 = null ;
vl_7 = null ;
size = 0 ;
return vr_4 ;
}
}
}
}
return null ;
}
@Override
public void clear () {
if ( vl_1 != null ) {
vl_1 . clear () ;
vl_1 = null ;
} else {
size = 0 ;
vl_10 = vl_9 = vl_8 = 0 ;
vl_6 = vl_4 = vl_2 = null ;
vl_7 = vl_5 = vl_3 = null ;
}
}
@Override
public vr_14 < tp_2 , tp_1 > fn_8 () {
if ( vl_1 != null ) {
return vl_1 . fn_8 () ;
}
if ( size == 0 ) {
return vr_15 . <tp_2 , tp_1 > fn_9 () ;
}
return new vr_16 <> ( this ) ;
}
@Override
public boolean hasNext () {
return vl_11 < vr_17 . size ;
}
@Override
public tp_2 fn_10 () {
if ( hasNext () == false ) {
throw new fn_11 ( vr_12 . vr_18 ) ;
}
vl_12 = true ;
vl_11 ++ ;
return vr_10 () ;
}
@Override
public void remove () {
if ( vl_12 == false ) {
throw new fn_7 ( vr_12 . vr_19 ) ;
}
vr_17 . remove ( vr_10 () ) ;
vl_11 -- ;
vl_12 = false ;
}
@Override
public tp_2 vr_10 () {
if ( vl_12 == false ) {
throw new fn_7 ( vr_12 . vr_20 ) ;
}
switch ( vl_11 ) {
case 3 :
return vr_17 . vl_2 ;
case 2 :
return vr_17 . vl_4 ;
case 1 :
return vr_17 . vl_6 ;
}
throw new fn_7 ( lr_1 + vl_11 ) ;
}
@Override
public tp_1 vr_11 () {
if ( vl_12 == false ) {
throw new fn_7 ( vr_12 . vr_21 ) ;
}
switch ( vl_11 ) {
case 3 :
return vr_17 . vl_3 ;
case 2 :
return vr_17 . vl_5 ;
case 1 :
return vr_17 . vl_7 ;
}
throw new fn_7 ( lr_1 + vl_11 ) ;
}
@Override
public tp_1 fn_12 ( final tp_1 vr_3 ) {
if ( vl_12 == false ) {
throw new fn_7 ( vr_12 . vr_22 ) ;
}
final tp_1 vr_4 = vr_11 () ;
switch ( vl_11 ) {
case 3 :
vr_17 . vl_3 = vr_3 ;
break;
case 2 :
vr_17 . vl_5 = vr_3 ;
break;
case 1 :
vr_17 . vl_7 = vr_3 ;
break;
default:
throw new fn_7 ( lr_1 + vl_11 ) ;
}
return vr_4 ;
}
@Override
public void fn_13 () {
vl_11 = 0 ;
vl_12 = false ;
}
@Override
public String toString () {
if ( vl_12 ) {
return lr_2 + vr_10 () + lr_3 + vr_11 () + lr_4 ;
}
return lr_5 ;
}
@Override
public vr_23 < vr_5 . vr_7 < tp_2 , tp_1 > > vr_9 () {
if ( vl_1 != null ) {
return vl_1 . vr_9 () ;
}
return new vr_24 <> ( this ) ;
}
@Override
public int size () {
return vr_17 . size () ;
}
@Override
public void clear () {
vr_17 . clear () ;
}
@Override
public boolean remove ( final Object vr_25 ) {
if ( vr_25 instanceof vr_5 . vr_7 == false ) {
return false ;
}
final vr_5 . vr_7 < ? , ? > vr_8 = ( vr_5 . vr_7 < ? , ? > ) vr_25 ;
final Object vr_1 = vr_8 . vr_10 () ;
final boolean vr_26 = vr_17 . fn_1 ( vr_1 ) ;
vr_17 . remove ( vr_1 ) ;
return vr_26 ;
}
@Override
public Iterator < vr_5 . vr_7 < tp_2 , tp_1 > > iterator () {
if ( vr_17 . vl_1 != null ) {
return vr_17 . vl_1 . vr_9 () . iterator () ;
}
if ( vr_17 . size () == 0 ) {
return vr_27 . < vr_5 . vr_7 < tp_2 , tp_1 > > fn_14 () ;
}
return new vr_28 <> ( vr_17 ) ;
}
void fn_15 ( final boolean vr_29 ) {
this . vr_30 = vr_29 ;
}
@Override
public tp_2 vr_10 () {
if ( vr_30 ) {
throw new fn_7 ( vr_12 . vr_20 ) ;
}
switch ( vl_13 ) {
case 3 :
return vr_17 . vl_2 ;
case 2 :
return vr_17 . vl_4 ;
case 1 :
return vr_17 . vl_6 ;
}
throw new fn_7 ( lr_1 + vl_13 ) ;
}
@Override
public tp_1 vr_11 () {
if ( vr_30 ) {
throw new fn_7 ( vr_12 . vr_21 ) ;
}
switch ( vl_13 ) {
case 3 :
return vr_17 . vl_3 ;
case 2 :
return vr_17 . vl_5 ;
case 1 :
return vr_17 . vl_7 ;
}
throw new fn_7 ( lr_1 + vl_13 ) ;
}
@Override
public tp_1 fn_12 ( final tp_1 vr_3 ) {
if ( vr_30 ) {
throw new fn_7 ( vr_12 . vr_22 ) ;
}
final tp_1 vr_4 = vr_11 () ;
switch ( vl_13 ) {
case 3 :
vr_17 . vl_3 = vr_3 ;
break;
case 2 :
vr_17 . vl_5 = vr_3 ;
break;
case 1 :
vr_17 . vl_7 = vr_3 ;
break;
default:
throw new fn_7 ( lr_1 + vl_13 ) ;
}
return vr_4 ;
}
@Override
public boolean equals ( final Object vr_25 ) {
if ( vr_30 ) {
return false ;
}
if ( vr_25 instanceof vr_5 . vr_7 == false ) {
return false ;
}
final vr_5 . vr_7 < ? , ? > vr_31 = ( vr_5 . vr_7 < ? , ? > ) vr_25 ;
final Object vr_1 = vr_10 () ;
final Object vr_3 = vr_11 () ;
return ( vr_1 == null ? vr_31 . vr_10 () == null : vr_1 . equals ( vr_31 . vr_10 () ) ) &&
( vr_3 == null ? vr_31 . vr_11 () == null : vr_3 . equals ( vr_31 . vr_11 () ) ) ;
}
@Override
public int vr_2 () {
if ( vr_30 ) {
return 0 ;
}
final Object vr_1 = vr_10 () ;
final Object vr_3 = vr_11 () ;
return ( vr_1 == null ? 0 : vr_1 . vr_2 () ) ^
( vr_3 == null ? 0 : vr_3 . vr_2 () ) ;
}
@Override
public String toString () {
if ( ! vr_30 ) {
return vr_10 () + lr_3 + vr_11 () ;
}
return lr_6 ;
}
public boolean hasNext () {
return vl_11 < vr_17 . size ;
}
public vr_5 . vr_7 < tp_2 , tp_1 > fn_16 () {
if ( ! hasNext () ) {
throw new fn_11 ( vr_12 . vr_18 ) ;
}
vl_14 = new vr_32 <> ( vr_17 , ++ vl_11 ) ;
return vl_14 ;
}
public void remove () {
if ( vl_14 == null ) {
throw new fn_7 ( vr_12 . vr_19 ) ;
}
vr_17 . remove ( vl_14 . vr_10 () ) ;
vl_14 . fn_15 ( true ) ;
vl_11 -- ;
vl_14 = null ;
}
@Override
public vr_5 . vr_7 < tp_2 , tp_1 > fn_10 () {
return fn_16 () ;
}
@Override
public vr_23 < tp_2 > fn_17 () {
if ( vl_1 != null ) {
return vl_1 . fn_17 () ;
}
return new vr_33 <> ( this ) ;
}
@Override
public int size () {
return vr_17 . size () ;
}
@Override
public void clear () {
vr_17 . clear () ;
}
@Override
public boolean contains ( final Object vr_1 ) {
return vr_17 . fn_1 ( vr_1 ) ;
}
@Override
public boolean remove ( final Object vr_1 ) {
final boolean vr_26 = vr_17 . fn_1 ( vr_1 ) ;
vr_17 . remove ( vr_1 ) ;
return vr_26 ;
}
@Override
public Iterator < tp_2 > iterator () {
if ( vr_17 . vl_1 != null ) {
return vr_17 . vl_1 . fn_17 () . iterator () ;
}
if ( vr_17 . size () == 0 ) {
return vr_27 . <tp_2 > fn_14 () ;
}
return new vr_34 <> ( vr_17 ) ;
}
@Override
public tp_2 fn_10 () {
return fn_16 () . vr_10 () ;
}
@Override
public Collection < tp_1 > fn_18 () {
if ( vl_1 != null ) {
return vl_1 . fn_18 () ;
}
return new vr_35 <> ( this ) ;
}
@Override
public int size () {
return vr_17 . size () ;
}
@Override
public void clear () {
vr_17 . clear () ;
}
@Override
public boolean contains ( final Object vr_3 ) {
return vr_17 . fn_2 ( vr_3 ) ;
}
@Override
public Iterator < tp_1 > iterator () {
if ( vr_17 . vl_1 != null ) {
return vr_17 . vl_1 . fn_18 () . iterator () ;
}
if ( vr_17 . size () == 0 ) {
return vr_27 . <tp_1 > fn_14 () ;
}
return new vr_36 <> ( vr_17 ) ;
}
@Override
public tp_1 fn_10 () {
return fn_16 () . vr_11 () ;
}
private void fn_19 ( final tp_3 out ) throws IOException {
out . vr_37 () ;
out . vr_38 ( size () ) ;
for ( final vr_14 < ? , ? > vr_39 = fn_8 () ; vr_39 . hasNext () ; ) {
out . fn_19 ( vr_39 . fn_10 () ) ;
out . fn_19 ( vr_39 . vr_11 () ) ;
}
}
@SuppressWarnings ( lr_7 )
private void fn_20 ( final tp_4 vr_40 ) throws IOException , vl_15 {
vr_40 . vr_41 () ;
final int vr_42 = vr_40 . vr_43 () ;
if ( vr_42 > 3 ) {
vl_1 = fn_6 () ;
}
for ( int vr_44 = vr_42 ; vr_44 > 0 ; vr_44 -- ) {
fn_3 ( ( tp_2 ) vr_40 . fn_20 () , ( tp_1 ) vr_40 . fn_20 () ) ;
}
}
@Override
@SuppressWarnings ( lr_7 )
public vr_45 < tp_2 , tp_1 > fn_21 () {
try {
final vr_45 < tp_2 , tp_1 > vr_46 = ( vr_45 < tp_2 , tp_1 > ) super . fn_21 () ;
if ( vr_46 . vl_1 != null ) {
vr_46 . vl_1 = vr_46 . vl_1 . fn_21 () ;
}
return vr_46 ;
} catch ( final tp_5 vr_47 ) {
throw new fn_22 () ;
}
}
@Override
public boolean equals ( final Object vr_25 ) {
if ( vr_25 == this ) {
return true ;
}
if ( vl_1 != null ) {
return vl_1 . equals ( vr_25 ) ;
}
if ( vr_25 instanceof vr_5 == false ) {
return false ;
}
final vr_5 < ? , ? > vr_31 = ( vr_5 < ? , ? > ) vr_25 ;
if ( size != vr_31 . size () ) {
return false ;
}
if ( size > 0 ) {
Object vr_48 = null ;
switch ( size ) {
case 3 :
if ( vr_31 . fn_1 ( vl_2 ) == false ) {
return false ;
}
vr_48 = vr_31 . get ( vl_2 ) ;
if ( vl_3 == null ? vr_48 != null : ! vl_3 . equals ( vr_48 ) ) {
return false ;
}
case 2 :
if ( vr_31 . fn_1 ( vl_4 ) == false ) {
return false ;
}
vr_48 = vr_31 . get ( vl_4 ) ;
if ( vl_5 == null ? vr_48 != null : ! vl_5 . equals ( vr_48 ) ) {
return false ;
}
case 1 :
if ( vr_31 . fn_1 ( vl_6 ) == false ) {
return false ;
}
vr_48 = vr_31 . get ( vl_6 ) ;
if ( vl_7 == null ? vr_48 != null : ! vl_7 . equals ( vr_48 ) ) {
return false ;
}
}
}
return true ;
}
@Override
public int vr_2 () {
if ( vl_1 != null ) {
return vl_1 . vr_2 () ;
}
int vr_49 = 0 ;
switch ( size ) {
case 3 :
vr_49 += vl_8 ^ ( vl_3 == null ? 0 : vl_3 . vr_2 () ) ;
case 2 :
vr_49 += vl_9 ^ ( vl_5 == null ? 0 : vl_5 . vr_2 () ) ;
case 1 :
vr_49 += vl_10 ^ ( vl_7 == null ? 0 : vl_7 . vr_2 () ) ;
case 0 :
break;
default:
throw new fn_7 ( lr_1 + size ) ;
}
return vr_49 ;
}
@Override
public String toString () {
if ( vl_1 != null ) {
return vl_1 . toString () ;
}
if ( size == 0 ) {
return lr_8 ;
}
final StringBuilder vr_50 = new StringBuilder ( 128 ) ;
vr_50 . append ( '{' ) ;
switch ( size ) {
case 3 :
vr_50 . append ( vl_2 == this ? lr_9 : vl_2 ) ;
vr_50 . append ( '=' ) ;
vr_50 . append ( vl_3 == this ? lr_9 : vl_3 ) ;
vr_50 . append ( ',' ) ;
case 2 :
vr_50 . append ( vl_4 == this ? lr_9 : vl_4 ) ;
vr_50 . append ( '=' ) ;
vr_50 . append ( vl_5 == this ? lr_9 : vl_5 ) ;
vr_50 . append ( ',' ) ;
case 1 :
vr_50 . append ( vl_6 == this ? lr_9 : vl_6 ) ;
vr_50 . append ( '=' ) ;
vr_50 . append ( vl_7 == this ? lr_9 : vl_7 ) ;
break;
default:
throw new fn_7 ( lr_1 + size ) ;
}
vr_50 . append ( '}' ) ;
return vr_50 . toString () ;
}
