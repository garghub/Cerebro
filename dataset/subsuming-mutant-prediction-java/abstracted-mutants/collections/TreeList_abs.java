@Override
public tp_1 get ( final int vr_1 ) {
fn_1 ( vr_1 , 0 , size () - 1 ) ;
return vr_2 . get ( vr_1 ) . fn_2 () ;
}
@Override
public int size () {
return size ;
}
@Override
public Iterator < tp_1 > iterator () {
return fn_3 ( 0 ) ;
}
@Override
public vr_3 < tp_1 > fn_3 () {
return fn_3 ( 0 ) ;
}
@Override
public vr_3 < tp_1 > fn_3 ( final int vr_4 ) {
fn_1 ( vr_4 , 0 , size () ) ;
return new vr_5 <> ( this , vr_4 ) ;
}
@Override
public int indexOf ( final Object object ) {
if ( vr_2 == null ) {
return - 1 ;
}
return vr_2 . indexOf ( object , vr_2 . vr_6 ) ;
}
@Override
public boolean contains ( final Object object ) {
return indexOf ( object ) >= 0 ;
}
@Override
public Object [] toArray () {
final Object [] array = new Object [ size () ] ;
if ( vr_2 != null ) {
vr_2 . toArray ( array , vr_2 . vr_6 ) ;
}
return array ;
}
@Override
public void add ( final int vr_1 , final tp_1 vr_7 ) {
vl_1 ++ ;
fn_1 ( vr_1 , 0 , size () ) ;
if ( vr_2 == null ) {
vr_2 = new vr_8 <> ( vr_1 , vr_7 , null , null ) ;
} else {
vr_2 = vr_2 . vr_9 ( vr_1 , vr_7 ) ;
}
size ++ ;
}
@Override
public boolean fn_4 ( final Collection < ? extends tp_1 > vr_10 ) {
if ( vr_10 . isEmpty () ) {
return false ;
}
vl_1 += vr_10 . size () ;
final vr_8 < tp_1 > vr_11 = new vr_8 <> ( vr_10 ) ;
vr_2 = vr_2 == null ? vr_11 : vr_2 . fn_4 ( vr_11 , size ) ;
size += vr_10 . size () ;
return true ;
}
@Override
public tp_1 fn_5 ( final int vr_1 , final tp_1 vr_7 ) {
fn_1 ( vr_1 , 0 , size () - 1 ) ;
final vr_8 < tp_1 > vr_12 = vr_2 . get ( vr_1 ) ;
final tp_1 vr_13 = vr_12 . vr_14 ;
vr_12 . vr_15 ( vr_7 ) ;
return vr_13 ;
}
@Override
public tp_1 remove ( final int vr_1 ) {
vl_1 ++ ;
fn_1 ( vr_1 , 0 , size () - 1 ) ;
final tp_1 vr_13 = get ( vr_1 ) ;
vr_2 = vr_2 . remove ( vr_1 ) ;
size -- ;
return vr_13 ;
}
@Override
public void clear () {
vl_1 ++ ;
vr_2 = null ;
size = 0 ;
}
private void fn_1 ( final int vr_1 , final int vr_16 , final int vr_17 ) {
if ( vr_1 < vr_16 || vr_1 > vr_17 ) {
throw new fn_6 ( lr_1 + vr_1 + lr_2 + size () ) ;
}
}
tp_1 fn_2 () {
return vr_14 ;
}
void vr_15 ( final tp_1 vr_7 ) {
this . vr_14 = vr_7 ;
}
vr_8 < tp_1 > get ( final int vr_1 ) {
final int vr_18 = vr_1 - vr_6 ;
if ( vr_18 == 0 ) {
return this ;
}
final vr_8 < tp_1 > vr_19 = vr_18 < 0 ? fn_7 () : fn_8 () ;
if ( vr_19 == null ) {
return null ;
}
return vr_19 . get ( vr_18 ) ;
}
int indexOf ( final Object object , final int vr_1 ) {
if ( fn_7 () != null ) {
final int vr_13 = vr_20 . indexOf ( object , vr_1 + vr_20 . vr_6 ) ;
if ( vr_13 != - 1 ) {
return vr_13 ;
}
}
if ( vr_21 . equals ( vr_14 , object ) ) {
return vr_1 ;
}
if ( fn_8 () != null ) {
return vr_22 . indexOf ( object , vr_1 + vr_22 . vr_6 ) ;
}
return - 1 ;
}
void toArray ( final Object [] array , final int vr_1 ) {
array [ vr_1 ] = vr_14 ;
if ( fn_7 () != null ) {
vr_20 . toArray ( array , vr_1 + vr_20 . vr_6 ) ;
}
if ( fn_8 () != null ) {
vr_22 . toArray ( array , vr_1 + vr_22 . vr_6 ) ;
}
}
vr_8 < tp_1 > fn_9 () {
if ( vl_2 || vr_22 == null ) {
return vr_22 ;
}
return vr_22 . vr_23 () ;
}
vr_8 < tp_1 > fn_10 () {
if ( vl_3 || vr_20 == null ) {
return vr_20 ;
}
return vr_20 . vr_24 () ;
}
vr_8 < tp_1 > vr_9 ( final int vr_1 , final tp_1 vr_7 ) {
final int vr_18 = vr_1 - vr_6 ;
if ( vr_18 <= 0 ) {
return fn_11 ( vr_18 , vr_7 ) ;
}
return fn_12 ( vr_18 , vr_7 ) ;
}
private vr_8 < tp_1 > fn_11 ( final int vr_18 , final tp_1 vr_7 ) {
if ( fn_7 () == null ) {
fn_13 ( new vr_8 <> ( - 1 , vr_7 , this , vr_20 ) , null ) ;
} else {
fn_13 ( vr_20 . vr_9 ( vr_18 , vr_7 ) , null ) ;
}
if ( vr_6 >= 0 ) {
vr_6 ++ ;
}
final vr_8 < tp_1 > vr_25 = fn_14 () ;
fn_15 () ;
return vr_25 ;
}
private vr_8 < tp_1 > fn_12 ( final int vr_18 , final tp_1 vr_7 ) {
if ( fn_8 () == null ) {
fn_16 ( new vr_8 <> ( + 1 , vr_7 , vr_22 , this ) , null ) ;
} else {
fn_16 ( vr_22 . vr_9 ( vr_18 , vr_7 ) , null ) ;
}
if ( vr_6 < 0 ) {
vr_6 -- ;
}
final vr_8 < tp_1 > vr_25 = fn_14 () ;
fn_15 () ;
return vr_25 ;
}
private vr_8 < tp_1 > fn_7 () {
return vl_3 ? null : vr_20 ;
}
private vr_8 < tp_1 > fn_8 () {
return vl_2 ? null : vr_22 ;
}
private vr_8 < tp_1 > vr_24 () {
return fn_8 () == null ? this : vr_22 . vr_24 () ;
}
private vr_8 < tp_1 > vr_23 () {
return fn_7 () == null ? this : vr_20 . vr_23 () ;
}
vr_8 < tp_1 > remove ( final int vr_1 ) {
final int vr_18 = vr_1 - vr_6 ;
if ( vr_18 == 0 ) {
return fn_17 () ;
}
if ( vr_18 > 0 ) {
fn_16 ( vr_22 . remove ( vr_18 ) , vr_22 . vr_22 ) ;
if ( vr_6 < 0 ) {
vr_6 ++ ;
}
} else {
fn_13 ( vr_20 . remove ( vr_18 ) , vr_20 . vr_20 ) ;
if ( vr_6 > 0 ) {
vr_6 -- ;
}
}
fn_15 () ;
return fn_14 () ;
}
private vr_8 < tp_1 > fn_18 () {
if ( fn_8 () == null ) {
return fn_17 () ;
}
fn_16 ( vr_22 . fn_18 () , vr_22 . vr_22 ) ;
if ( vr_6 < 0 ) {
vr_6 ++ ;
}
fn_15 () ;
return fn_14 () ;
}
private vr_8 < tp_1 > fn_19 () {
if ( fn_7 () == null ) {
return fn_17 () ;
}
fn_13 ( vr_20 . fn_19 () , vr_20 . vr_20 ) ;
if ( vr_6 > 0 ) {
vr_6 -- ;
}
fn_15 () ;
return fn_14 () ;
}
private vr_8 < tp_1 > fn_17 () {
if ( fn_8 () == null && fn_7 () == null ) {
return null ;
}
if ( fn_8 () == null ) {
if ( vr_6 > 0 ) {
vr_20 . vr_6 += vr_6 ;
}
vr_20 . vr_24 () . fn_16 ( null , vr_22 ) ;
return vr_20 ;
}
if ( fn_7 () == null ) {
vr_22 . vr_6 += vr_6 - ( vr_6 < 0 ? 0 : 1 ) ;
vr_22 . vr_23 () . fn_13 ( null , vr_20 ) ;
return vr_22 ;
}
if ( fn_20 () > 0 ) {
final vr_8 < tp_1 > vr_26 = vr_22 . vr_23 () ;
vr_14 = vr_26 . vr_14 ;
if ( vl_3 ) {
vr_20 = vr_26 . vr_20 ;
}
vr_22 = vr_22 . fn_19 () ;
if ( vr_6 < 0 ) {
vr_6 ++ ;
}
} else {
final vr_8 < tp_1 > vr_27 = vr_20 . vr_24 () ;
vr_14 = vr_27 . vr_14 ;
if ( vl_2 ) {
vr_22 = vr_27 . vr_22 ;
}
final vr_8 < tp_1 > vr_28 = vr_20 . vr_20 ;
vr_20 = vr_20 . fn_18 () ;
if ( vr_20 == null ) {
vr_20 = vr_28 ;
vl_3 = true ;
}
if ( vr_6 > 0 ) {
vr_6 -- ;
}
}
fn_15 () ;
return this ;
}
private vr_8 < tp_1 > fn_14 () {
switch ( fn_20 () ) {
case 1 :
case 0 :
case - 1 :
return this ;
case - 2 :
if ( vr_20 . fn_20 () > 0 ) {
fn_13 ( vr_20 . vr_29 () , null ) ;
}
return fn_21 () ;
case 2 :
if ( vr_22 . fn_20 () < 0 ) {
fn_16 ( vr_22 . fn_21 () , null ) ;
}
return vr_29 () ;
default :
throw new fn_22 ( lr_3 ) ;
}
}
private int fn_23 ( final vr_8 < tp_1 > vr_12 ) {
if ( vr_12 == null ) {
return 0 ;
}
return vr_12 . vr_6 ;
}
private int fn_24 ( final vr_8 < tp_1 > vr_12 , final int vr_30 ) {
if ( vr_12 == null ) {
return 0 ;
}
final int vr_31 = fn_23 ( vr_12 ) ;
vr_12 . vr_6 = vr_30 ;
return vr_31 ;
}
private void fn_15 () {
vl_4 = vr_32 . vr_24 (
fn_7 () == null ? - 1 : fn_7 () . vl_4 ,
fn_8 () == null ? - 1 : fn_8 () . vl_4 ) + 1 ;
}
private int getHeight ( final vr_8 < tp_1 > vr_12 ) {
return vr_12 == null ? - 1 : vr_12 . vl_4 ;
}
private int fn_20 () {
return getHeight ( fn_8 () ) - getHeight ( fn_7 () ) ;
}
private vr_8 < tp_1 > vr_29 () {
final vr_8 < tp_1 > vr_33 = vr_22 ;
final vr_8 < tp_1 > vr_34 = fn_8 () . fn_7 () ;
final int vr_35 = vr_6 + fn_23 ( vr_33 ) ;
final int vr_36 = - vr_33 . vr_6 ;
final int vr_37 = fn_23 ( vr_33 ) + fn_23 ( vr_34 ) ;
fn_16 ( vr_34 , vr_33 ) ;
vr_33 . fn_13 ( this , null ) ;
fn_24 ( vr_33 , vr_35 ) ;
fn_24 ( this , vr_36 ) ;
fn_24 ( vr_34 , vr_37 ) ;
return vr_33 ;
}
private vr_8 < tp_1 > fn_21 () {
final vr_8 < tp_1 > vr_33 = vr_20 ;
final vr_8 < tp_1 > vr_34 = fn_7 () . fn_8 () ;
final int vr_35 = vr_6 + fn_23 ( vr_33 ) ;
final int vr_36 = - vr_33 . vr_6 ;
final int vr_37 = fn_23 ( vr_33 ) + fn_23 ( vr_34 ) ;
fn_13 ( vr_34 , vr_33 ) ;
vr_33 . fn_16 ( this , null ) ;
fn_24 ( vr_33 , vr_35 ) ;
fn_24 ( this , vr_36 ) ;
fn_24 ( vr_34 , vr_37 ) ;
return vr_33 ;
}
private void fn_13 ( final vr_8 < tp_1 > vr_12 , final vr_8 < tp_1 > fn_10 ) {
vl_3 = vr_12 == null ;
vr_20 = vl_3 ? fn_10 : vr_12 ;
fn_15 () ;
}
private void fn_16 ( final vr_8 < tp_1 > vr_12 , final vr_8 < tp_1 > fn_9 ) {
vl_2 = vr_12 == null ;
vr_22 = vl_2 ? fn_9 : vr_12 ;
fn_15 () ;
}
private vr_8 < tp_1 > fn_4 ( vr_8 < tp_1 > vr_38 , final int vr_39 ) {
final vr_8 < tp_1 > vr_40 = vr_24 () ;
final vr_8 < tp_1 > vr_41 = vr_38 . vr_23 () ;
if ( vr_38 . vl_4 > vl_4 ) {
final vr_8 < tp_1 > vr_42 = fn_18 () ;
final vr_43 < vr_8 < tp_1 > > vr_44 = new vr_45 <> () ;
vr_8 < tp_1 > vr_46 = vr_38 ;
int vr_47 = vr_46 . vr_6 + vr_39 ;
int vr_48 = 0 ;
while ( vr_46 != null && vr_46 . vl_4 > getHeight ( vr_42 ) ) {
vr_48 = vr_47 ;
vr_44 . vr_49 ( vr_46 ) ;
vr_46 = vr_46 . vr_20 ;
if ( vr_46 != null ) {
vr_47 += vr_46 . vr_6 ;
}
}
vr_40 . fn_13 ( vr_42 , null ) ;
vr_40 . fn_16 ( vr_46 , vr_41 ) ;
if ( vr_42 != null ) {
vr_42 . vr_24 () . fn_16 ( null , vr_40 ) ;
vr_42 . vr_6 -= vr_39 - 1 ;
}
if ( vr_46 != null ) {
vr_46 . vr_23 () . fn_13 ( null , vr_40 ) ;
vr_46 . vr_6 = vr_47 - vr_39 + 1 ;
}
vr_40 . vr_6 = vr_39 - 1 - vr_48 ;
vr_38 . vr_6 += vr_39 ;
vr_46 = vr_40 ;
while ( ! vr_44 . isEmpty () ) {
final vr_8 < tp_1 > vr_50 = vr_44 . vr_51 () ;
vr_50 . fn_13 ( vr_46 , null ) ;
vr_46 = vr_50 . fn_14 () ;
}
return vr_46 ;
}
vr_38 = vr_38 . fn_19 () ;
final vr_43 < vr_8 < tp_1 > > vr_44 = new vr_45 <> () ;
vr_8 < tp_1 > vr_46 = this ;
int vr_47 = vr_46 . vr_6 ;
int vr_48 = 0 ;
while ( vr_46 != null && vr_46 . vl_4 > getHeight ( vr_38 ) ) {
vr_48 = vr_47 ;
vr_44 . vr_49 ( vr_46 ) ;
vr_46 = vr_46 . vr_22 ;
if ( vr_46 != null ) {
vr_47 += vr_46 . vr_6 ;
}
}
vr_41 . fn_16 ( vr_38 , null ) ;
vr_41 . fn_13 ( vr_46 , vr_40 ) ;
if ( vr_38 != null ) {
vr_38 . vr_23 () . fn_13 ( null , vr_41 ) ;
vr_38 . vr_6 ++ ;
}
if ( vr_46 != null ) {
vr_46 . vr_24 () . fn_16 ( null , vr_41 ) ;
vr_46 . vr_6 = vr_47 - vr_39 ;
}
vr_41 . vr_6 = vr_39 - vr_48 ;
vr_46 = vr_41 ;
while ( ! vr_44 . isEmpty () ) {
final vr_8 < tp_1 > vr_50 = vr_44 . vr_51 () ;
vr_50 . fn_16 ( vr_46 , null ) ;
vr_46 = vr_50 . fn_14 () ;
}
return vr_46 ;
}
@Override
public String toString () {
return new StringBuilder ()
. append ( lr_4 )
. append ( vr_6 )
. append ( ',' )
. append ( vr_20 != null )
. append ( ',' )
. append ( vr_14 )
. append ( ',' )
. append ( fn_8 () != null )
. append ( lr_5 )
. append ( vl_2 )
. append ( lr_6 )
. toString () ;
}
protected void fn_25 () {
if ( vr_52 . vl_1 != vl_5 ) {
throw new fn_26 () ;
}
}
@Override
public boolean hasNext () {
return vl_6 < vr_52 . size () ;
}
@Override
public tp_1 fn_9 () {
fn_25 () ;
if ( ! hasNext () ) {
throw new fn_27 ( lr_7 + vl_6 + lr_8 ) ;
}
if ( fn_9 == null ) {
fn_9 = vr_52 . vr_2 . get ( vl_6 ) ;
}
final tp_1 vr_14 = fn_9 . fn_2 () ;
vl_7 = fn_9 ;
vl_8 = vl_6 ++ ;
fn_9 = fn_9 . fn_9 () ;
return vr_14 ;
}
@Override
public boolean fn_28 () {
return vl_6 > 0 ;
}
@Override
public tp_1 fn_10 () {
fn_25 () ;
if ( ! fn_28 () ) {
throw new fn_27 ( lr_9 ) ;
}
if ( fn_9 == null ) {
fn_9 = vr_52 . vr_2 . get ( vl_6 - 1 ) ;
} else {
fn_9 = fn_9 . fn_10 () ;
}
final tp_1 vr_14 = fn_9 . fn_2 () ;
vl_7 = fn_9 ;
vl_8 = -- vl_6 ;
return vr_14 ;
}
@Override
public int vl_6 () {
return vl_6 ;
}
@Override
public int fn_29 () {
return vl_6 () - 1 ;
}
@Override
public void remove () {
fn_25 () ;
if ( vl_8 == - 1 ) {
throw new fn_30 () ;
}
vr_52 . remove ( vl_8 ) ;
if ( vl_6 != vl_8 ) {
vl_6 -- ;
}
fn_9 = null ;
vl_7 = null ;
vl_8 = - 1 ;
vl_5 ++ ;
}
@Override
public void fn_5 ( final tp_1 vr_7 ) {
fn_25 () ;
if ( vl_7 == null ) {
throw new fn_30 () ;
}
vl_7 . vr_15 ( vr_7 ) ;
}
@Override
public void add ( final tp_1 vr_7 ) {
fn_25 () ;
vr_52 . add ( vl_6 , vr_7 ) ;
vl_7 = null ;
vl_8 = - 1 ;
vl_6 ++ ;
vl_5 ++ ;
}
