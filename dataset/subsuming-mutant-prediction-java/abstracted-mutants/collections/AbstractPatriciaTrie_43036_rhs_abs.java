@Override
public void clear () {
vr_1 . vr_2 = null ;
vr_1 . vr_3 = - 1 ;
vr_1 . vr_4 = null ;
vr_1 . vr_5 = null ;
vr_1 . vr_6 = vr_1 ;
vr_1 . vr_7 = null ;
vr_1 . vr_8 = vr_1 ;
size = 0 ;
fn_1 () ;
}
@Override
public int size () {
return size ;
}
void fn_2 () {
size ++ ;
fn_1 () ;
}
void fn_3 () {
size -- ;
fn_1 () ;
}
private void fn_1 () {
++ vl_1 ;
}
@Override
public tp_1 fn_4 ( final tp_2 vr_2 , final tp_1 vr_4 ) {
vr_9 . vr_10 ( vr_2 , lr_1 ) ;
final int vr_11 = vr_11 ( vr_2 ) ;
if ( vr_11 == 0 ) {
if ( vr_1 . isEmpty () ) {
fn_2 () ;
} else {
fn_1 () ;
}
return vr_1 . vr_12 ( vr_2 , vr_4 ) ;
}
final vr_13 < tp_2 , tp_1 > vr_14 = fn_5 ( vr_2 , vr_11 ) ;
if ( fn_6 ( vr_2 , vr_14 . vr_2 ) ) {
if ( vr_14 . isEmpty () ) {
fn_2 () ;
} else {
fn_1 () ;
}
return vr_14 . vr_12 ( vr_2 , vr_4 ) ;
}
final int vr_3 = vr_3 ( vr_2 , vr_14 . vr_2 ) ;
if ( ! vr_15 . vr_16 ( vr_3 ) ) {
if ( vr_15 . vr_17 ( vr_3 ) ) {
final vr_13 < tp_2 , tp_1 > vr_18 = new vr_13 <> ( vr_2 , vr_4 , vr_3 ) ;
fn_7 ( vr_18 , vr_11 ) ;
fn_2 () ;
return null ;
} else if ( vr_15 . vr_19 ( vr_3 ) ) {
if ( vr_1 . isEmpty () ) {
fn_2 () ;
} else {
fn_1 () ;
}
return vr_1 . vr_12 ( vr_2 , vr_4 ) ;
} else if ( vr_15 . vr_20 ( vr_3 ) ) {
if ( vr_14 != vr_1 ) {
fn_1 () ;
return vr_14 . vr_12 ( vr_2 , vr_4 ) ;
}
}
}
throw new IllegalArgumentException ( lr_2 + vr_2 + lr_3 + vr_4 + lr_4 + vr_3 ) ;
}
vr_13 < tp_2 , tp_1 > fn_7 ( final vr_13 < tp_2 , tp_1 > vr_21 , final int vr_11 ) {
vr_13 < tp_2 , tp_1 > vr_22 = vr_1 . vr_6 ;
vr_13 < tp_2 , tp_1 > vr_23 = vr_1 ;
while ( true ) {
if ( vr_22 . vr_3 >= vr_21 . vr_3
|| vr_22 . vr_3 <= vr_23 . vr_3 ) {
vr_21 . vr_8 = vr_21 ;
if ( ! fn_8 ( vr_21 . vr_2 , vr_21 . vr_3 , vr_11 ) ) {
vr_21 . vr_6 = vr_21 ;
vr_21 . vr_7 = vr_22 ;
} else {
vr_21 . vr_6 = vr_22 ;
vr_21 . vr_7 = vr_21 ;
}
vr_21 . vr_5 = vr_23 ;
if ( vr_22 . vr_3 >= vr_21 . vr_3 ) {
vr_22 . vr_5 = vr_21 ;
}
if ( vr_22 . vr_3 <= vr_23 . vr_3 ) {
vr_22 . vr_8 = vr_21 ;
}
if ( vr_23 == vr_1 || ! fn_8 ( vr_21 . vr_2 , vr_23 . vr_3 , vr_11 ) ) {
vr_23 . vr_6 = vr_21 ;
} else {
vr_23 . vr_7 = vr_21 ;
}
return vr_21 ;
}
vr_23 = vr_22 ;
if ( ! fn_8 ( vr_21 . vr_2 , vr_22 . vr_3 , vr_11 ) ) {
vr_22 = vr_22 . vr_6 ;
} else {
vr_22 = vr_22 . vr_7 ;
}
}
}
@Override
public tp_1 get ( final Object vr_24 ) {
final vr_13 < tp_2 , tp_1 > vr_21 = fn_9 ( vr_24 ) ;
return vr_21 != null ? vr_21 . vr_25 () : null ;
}
vr_13 < tp_2 , tp_1 > fn_9 ( final Object vr_24 ) {
final tp_2 vr_2 = fn_10 ( vr_24 ) ;
if ( vr_2 == null ) {
return null ;
}
final int vr_11 = vr_11 ( vr_2 ) ;
final vr_13 < tp_2 , tp_1 > vr_21 = fn_5 ( vr_2 , vr_11 ) ;
return ! vr_21 . isEmpty () && fn_6 ( vr_2 , vr_21 . vr_2 ) ? vr_21 : null ;
}
public vr_26 . vr_27 < tp_2 , tp_1 > fn_11 ( final tp_2 vr_2 ) {
final int vr_11 = vr_11 ( vr_2 ) ;
final vr_28 < vr_26 . vr_27 < tp_2 , tp_1 > > vr_29 = new vr_28 <> () ;
if ( ! fn_12 ( vr_1 . vr_6 , - 1 , vr_2 , vr_11 , vr_29 ) ) {
return vr_29 . get () ;
}
return null ;
}
public tp_2 fn_13 ( final tp_2 vr_2 ) {
final vr_26 . vr_27 < tp_2 , tp_1 > vr_21 = fn_11 ( vr_2 ) ;
if ( vr_21 == null ) {
return null ;
}
return vr_21 . vr_30 () ;
}
public tp_1 fn_14 ( final tp_2 vr_2 ) {
final vr_26 . vr_27 < tp_2 , tp_1 > vr_21 = fn_11 ( vr_2 ) ;
if ( vr_21 == null ) {
return null ;
}
return vr_21 . vr_25 () ;
}
private boolean fn_12 ( final vr_13 < tp_2 , tp_1 > vr_31 , final int vr_3 ,
final tp_2 vr_2 , final int vr_11 ,
final vr_28 < vr_26 . vr_27 < tp_2 , tp_1 > > vr_29 ) {
if ( vr_31 . vr_3 <= vr_3 ) {
if ( ! vr_31 . isEmpty () ) {
vr_29 . vr_32 ( vr_31 ) ;
return false ;
}
return true ;
}
if ( ! fn_8 ( vr_2 , vr_31 . vr_3 , vr_11 ) ) {
if ( fn_12 ( vr_31 . vr_6 , vr_31 . vr_3 , vr_2 , vr_11 , vr_29 ) ) {
return fn_12 ( vr_31 . vr_7 , vr_31 . vr_3 , vr_2 , vr_11 , vr_29 ) ;
}
} else {
if ( fn_12 ( vr_31 . vr_7 , vr_31 . vr_3 , vr_2 , vr_11 , vr_29 ) ) {
return fn_12 ( vr_31 . vr_6 , vr_31 . vr_3 , vr_2 , vr_11 , vr_29 ) ;
}
}
return false ;
}
@Override
public boolean fn_15 ( final Object vr_24 ) {
if ( vr_24 == null ) {
return false ;
}
final tp_2 vr_2 = fn_10 ( vr_24 ) ;
final int vr_11 = vr_11 ( vr_2 ) ;
final vr_13 < tp_2 , tp_1 > vr_21 = fn_5 ( vr_2 , vr_11 ) ;
return ! vr_21 . isEmpty () && fn_6 ( vr_2 , vr_21 . vr_2 ) ;
}
@Override
public vr_33 < vr_26 . vr_27 < tp_2 , tp_1 > > fn_16 () {
if ( fn_16 == null ) {
fn_16 = new fn_17 () ;
}
return fn_16 ;
}
@Override
public vr_33 < tp_2 > fn_18 () {
if ( fn_18 == null ) {
fn_18 = new fn_19 () ;
}
return fn_18 ;
}
@Override
public Collection < tp_1 > fn_20 () {
if ( fn_20 == null ) {
fn_20 = new fn_21 () ;
}
return fn_20 ;
}
@Override
public tp_1 remove ( final Object vr_24 ) {
if ( vr_24 == null ) {
return null ;
}
final tp_2 vr_2 = fn_10 ( vr_24 ) ;
final int vr_11 = vr_11 ( vr_2 ) ;
vr_13 < tp_2 , tp_1 > vr_22 = vr_1 . vr_6 ;
vr_13 < tp_2 , tp_1 > vr_23 = vr_1 ;
while ( true ) {
if ( vr_22 . vr_3 <= vr_23 . vr_3 ) {
if ( ! vr_22 . isEmpty () && fn_6 ( vr_2 , vr_22 . vr_2 ) ) {
return fn_22 ( vr_22 ) ;
}
return null ;
}
vr_23 = vr_22 ;
if ( ! fn_8 ( vr_2 , vr_22 . vr_3 , vr_11 ) ) {
vr_22 = vr_22 . vr_6 ;
} else {
vr_22 = vr_22 . vr_7 ;
}
}
}
vr_13 < tp_2 , tp_1 > fn_5 ( final tp_2 vr_2 , final int vr_11 ) {
vr_13 < tp_2 , tp_1 > vr_22 = vr_1 . vr_6 ;
vr_13 < tp_2 , tp_1 > vr_23 = vr_1 ;
while ( true ) {
if ( vr_22 . vr_3 <= vr_23 . vr_3 ) {
return vr_22 ;
}
vr_23 = vr_22 ;
if ( ! fn_8 ( vr_2 , vr_22 . vr_3 , vr_11 ) ) {
vr_22 = vr_22 . vr_6 ;
} else {
vr_22 = vr_22 . vr_7 ;
}
}
}
tp_1 fn_22 ( final vr_13 < tp_2 , tp_1 > vr_31 ) {
if ( vr_31 != vr_1 ) {
if ( vr_31 . vr_34 () ) {
fn_23 ( vr_31 ) ;
} else {
fn_24 ( vr_31 ) ;
}
}
fn_3 () ;
return vr_31 . vr_12 ( null , null ) ;
}
private void fn_24 ( final vr_13 < tp_2 , tp_1 > vr_31 ) {
if ( vr_31 == vr_1 ) {
throw new IllegalArgumentException ( lr_5 ) ;
} else if ( ! vr_31 . vr_35 () ) {
throw new IllegalArgumentException ( vr_31 + lr_6 ) ;
}
final vr_13 < tp_2 , tp_1 > vr_5 = vr_31 . vr_5 ;
final vr_13 < tp_2 , tp_1 > vr_36 = vr_31 . vr_6 == vr_31 ? vr_31 . vr_7 : vr_31 . vr_6 ;
if ( vr_5 . vr_6 == vr_31 ) {
vr_5 . vr_6 = vr_36 ;
} else {
vr_5 . vr_7 = vr_36 ;
}
if ( vr_36 . vr_3 > vr_5 . vr_3 ) {
vr_36 . vr_5 = vr_5 ;
} else {
vr_36 . vr_8 = vr_5 ;
}
}
private void fn_23 ( final vr_13 < tp_2 , tp_1 > vr_31 ) {
if ( vr_31 == vr_1 ) {
throw new IllegalArgumentException ( lr_5 ) ;
} else if ( ! vr_31 . vr_34 () ) {
throw new IllegalArgumentException ( vr_31 + lr_7 ) ;
}
final vr_13 < tp_2 , tp_1 > vr_37 = vr_31 . vr_8 ;
vr_37 . vr_3 = vr_31 . vr_3 ;
{
final vr_13 < tp_2 , tp_1 > vr_5 = vr_37 . vr_5 ;
final vr_13 < tp_2 , tp_1 > vr_36 = vr_37 . vr_6 == vr_31 ? vr_37 . vr_7 : vr_37 . vr_6 ;
if ( vr_37 . vr_8 == vr_37 && vr_37 . vr_5 != vr_31 ) {
vr_37 . vr_8 = vr_37 . vr_5 ;
}
if ( vr_5 . vr_6 == vr_37 ) {
vr_5 . vr_6 = vr_36 ;
} else {
vr_5 . vr_7 = vr_36 ;
}
if ( vr_36 . vr_3 > vr_5 . vr_3 ) {
vr_36 . vr_5 = vr_5 ;
}
}
{
if ( vr_31 . vr_6 . vr_5 == vr_31 ) {
vr_31 . vr_6 . vr_5 = vr_37 ;
}
if ( vr_31 . vr_7 . vr_5 == vr_31 ) {
vr_31 . vr_7 . vr_5 = vr_37 ;
}
if ( vr_31 . vr_5 . vr_6 == vr_31 ) {
vr_31 . vr_5 . vr_6 = vr_37 ;
} else {
vr_31 . vr_5 . vr_7 = vr_37 ;
}
}
vr_37 . vr_5 = vr_31 . vr_5 ;
vr_37 . vr_6 = vr_31 . vr_6 ;
vr_37 . vr_7 = vr_31 . vr_7 ;
if ( fn_25 ( vr_37 . vr_6 , vr_37 ) ) {
vr_37 . vr_6 . vr_8 = vr_37 ;
}
if ( fn_25 ( vr_37 . vr_7 , vr_37 ) ) {
vr_37 . vr_7 . vr_8 = vr_37 ;
}
}
vr_13 < tp_2 , tp_1 > fn_26 ( final vr_13 < tp_2 , tp_1 > vr_38 ) {
if ( vr_38 == null ) {
return fn_27 () ;
}
return fn_28 ( vr_38 . vr_8 , vr_38 , null ) ;
}
vr_13 < tp_2 , tp_1 > fn_28 ( final vr_13 < tp_2 , tp_1 > vr_39 ,
final vr_13 < tp_2 , tp_1 > vr_40 , final vr_13 < tp_2 , tp_1 > vr_41 ) {
vr_13 < tp_2 , tp_1 > vr_22 = vr_39 ;
if ( vr_40 == null || vr_39 != vr_40 . vr_8 ) {
while ( ! vr_22 . vr_6 . isEmpty () ) {
if ( vr_40 == vr_22 . vr_6 ) {
break;
}
if ( fn_25 ( vr_22 . vr_6 , vr_22 ) ) {
return vr_22 . vr_6 ;
}
vr_22 = vr_22 . vr_6 ;
}
}
if ( vr_22 . isEmpty () ) {
return null ;
}
if ( vr_22 . vr_7 == null ) {
return null ;
}
if ( vr_40 != vr_22 . vr_7 ) {
if ( fn_25 ( vr_22 . vr_7 , vr_22 ) ) {
return vr_22 . vr_7 ;
}
return fn_28 ( vr_22 . vr_7 , vr_40 , vr_41 ) ;
}
while ( vr_22 == vr_22 . vr_5 . vr_7 ) {
if ( vr_22 == vr_41 ) {
return null ;
}
vr_22 = vr_22 . vr_5 ;
}
if ( vr_22 == vr_41 ) {
return null ;
}
if ( vr_22 . vr_5 . vr_7 == null ) {
return null ;
}
if ( vr_40 != vr_22 . vr_5 . vr_7
&& fn_25 ( vr_22 . vr_5 . vr_7 , vr_22 . vr_5 ) ) {
return vr_22 . vr_5 . vr_7 ;
}
if ( vr_22 . vr_5 . vr_7 == vr_22 . vr_5 ) {
return null ;
}
return fn_28 ( vr_22 . vr_5 . vr_7 , vr_40 , vr_41 ) ;
}
vr_13 < tp_2 , tp_1 > fn_27 () {
if ( isEmpty () ) {
return null ;
}
return fn_29 ( vr_1 ) ;
}
vr_13 < tp_2 , tp_1 > fn_29 ( vr_13 < tp_2 , tp_1 > vr_38 ) {
while ( true ) {
vr_13 < tp_2 , tp_1 > vr_36 = vr_38 . vr_6 ;
if ( vr_36 . isEmpty () ) {
vr_36 = vr_38 . vr_7 ;
}
if ( vr_36 . vr_3 <= vr_38 . vr_3 ) { MST[rv.ROR5Mutator]MSP[N]
return vr_36 ;
}
vr_38 = vr_36 ;
}
}
@Override
public vr_42 < ? super tp_2 > fn_30 () {
return fn_31 () ;
}
@Override
public tp_2 fn_32 () {
if ( size () == 0 ) {
throw new fn_33 () ;
}
return fn_27 () . vr_30 () ;
}
@Override
public tp_2 fn_34 () {
final vr_13 < tp_2 , tp_1 > vr_21 = fn_35 () ;
if ( vr_21 != null ) {
return vr_21 . vr_30 () ;
}
throw new fn_33 () ;
}
@Override
public tp_2 fn_36 ( final tp_2 vr_2 ) {
vr_9 . vr_10 ( vr_2 , lr_1 ) ;
final vr_13 < tp_2 , tp_1 > vr_21 = fn_9 ( vr_2 ) ;
if ( vr_21 != null ) {
final vr_13 < tp_2 , tp_1 > fn_26 = fn_26 ( vr_21 ) ;
return fn_26 != null ? fn_26 . vr_30 () : null ;
}
return null ;
}
@Override
public tp_2 fn_37 ( final tp_2 vr_2 ) {
vr_9 . vr_10 ( vr_2 , lr_1 ) ;
final vr_13 < tp_2 , tp_1 > vr_21 = fn_9 ( vr_2 ) ;
if ( vr_21 != null ) {
final vr_13 < tp_2 , tp_1 > vr_43 = fn_38 ( vr_21 ) ;
return vr_43 != null ? vr_43 . vr_30 () : null ;
}
return null ;
}
@Override
public vr_44 < tp_2 , tp_1 > fn_39 () {
return new fn_40 () ;
}
@Override
public vr_45 < tp_2 , tp_1 > fn_41 ( final tp_2 vr_2 ) {
return fn_42 ( vr_2 , 0 , vr_11 ( vr_2 ) ) ;
}
private vr_45 < tp_2 , tp_1 > fn_42 ( final tp_2 vr_2 , final int vr_46 , final int vr_11 ) {
final int vr_47 = vr_46 + vr_11 ;
if ( vr_47 > vr_11 ( vr_2 ) ) {
throw new IllegalArgumentException ( vr_46 + lr_8
+ vr_11 + lr_9 + vr_11 ( vr_2 ) ) ;
}
if ( vr_47 == 0 ) {
return this ;
}
return new fn_43 ( vr_2 , vr_46 , vr_11 ) ;
}
@Override
public vr_45 < tp_2 , tp_1 > fn_44 ( final tp_2 vr_48 ) {
return new fn_45 ( null , vr_48 ) ;
}
@Override
public vr_45 < tp_2 , tp_1 > fn_46 ( final tp_2 vr_49 , final tp_2 vr_48 ) {
return new fn_45 ( vr_49 , vr_48 ) ;
}
@Override
public vr_45 < tp_2 , tp_1 > fn_47 ( final tp_2 vr_49 ) {
return new fn_45 ( vr_49 , null ) ;
}
vr_13 < tp_2 , tp_1 > fn_48 ( final tp_2 vr_2 ) {
final int vr_11 = vr_11 ( vr_2 ) ;
if ( vr_11 == 0 ) {
if ( ! vr_1 . isEmpty () ) {
if ( size () > 1 ) {
return fn_26 ( vr_1 ) ;
}
return null ;
}
return fn_27 () ;
}
final vr_13 < tp_2 , tp_1 > vr_14 = fn_5 ( vr_2 , vr_11 ) ;
if ( fn_6 ( vr_2 , vr_14 . vr_2 ) ) {
return fn_26 ( vr_14 ) ;
}
final int vr_3 = vr_3 ( vr_2 , vr_14 . vr_2 ) ;
if ( vr_15 . vr_17 ( vr_3 ) ) {
final vr_13 < tp_2 , tp_1 > vr_50 = new vr_13 <> ( vr_2 , null , vr_3 ) ;
fn_7 ( vr_50 , vr_11 ) ;
fn_2 () ;
final vr_13 < tp_2 , tp_1 > ceil = fn_26 ( vr_50 ) ;
fn_22 ( vr_50 ) ;
vl_1 -= 2 ;
return ceil ;
} else if ( vr_15 . vr_19 ( vr_3 ) ) {
if ( ! vr_1 . isEmpty () ) {
return fn_27 () ;
} else if ( size () > 1 ) {
return fn_26 ( fn_27 () ) ;
} else {
return null ;
}
} else if ( vr_15 . vr_20 ( vr_3 ) ) {
return fn_26 ( vr_14 ) ;
}
throw new fn_49 ( lr_10 + vr_2 ) ;
}
vr_13 < tp_2 , tp_1 > fn_50 ( final tp_2 vr_2 ) {
final int vr_11 = vr_11 ( vr_2 ) ;
if ( vr_11 == 0 ) {
if ( ! vr_1 . isEmpty () ) {
return vr_1 ;
}
return fn_27 () ;
}
final vr_13 < tp_2 , tp_1 > vr_14 = fn_5 ( vr_2 , vr_11 ) ;
if ( fn_6 ( vr_2 , vr_14 . vr_2 ) ) {
return vr_14 ;
}
final int vr_3 = vr_3 ( vr_2 , vr_14 . vr_2 ) ;
if ( vr_15 . vr_17 ( vr_3 ) ) {
final vr_13 < tp_2 , tp_1 > vr_50 = new vr_13 <> ( vr_2 , null , vr_3 ) ;
fn_7 ( vr_50 , vr_11 ) ;
fn_2 () ;
final vr_13 < tp_2 , tp_1 > ceil = fn_26 ( vr_50 ) ;
fn_22 ( vr_50 ) ;
vl_1 -= 2 ;
return ceil ;
} else if ( vr_15 . vr_19 ( vr_3 ) ) {
if ( ! vr_1 . isEmpty () ) {
return vr_1 ;
}
return fn_27 () ;
} else if ( vr_15 . vr_20 ( vr_3 ) ) {
return vr_14 ;
}
throw new fn_49 ( lr_10 + vr_2 ) ;
}
vr_13 < tp_2 , tp_1 > fn_51 ( final tp_2 vr_2 ) {
final int vr_11 = vr_11 ( vr_2 ) ;
if ( vr_11 == 0 ) {
return null ;
}
final vr_13 < tp_2 , tp_1 > vr_14 = fn_5 ( vr_2 , vr_11 ) ;
if ( fn_6 ( vr_2 , vr_14 . vr_2 ) ) {
return fn_38 ( vr_14 ) ;
}
final int vr_3 = vr_3 ( vr_2 , vr_14 . vr_2 ) ;
if ( vr_15 . vr_17 ( vr_3 ) ) {
final vr_13 < tp_2 , tp_1 > vr_50 = new vr_13 <> ( vr_2 , null , vr_3 ) ;
fn_7 ( vr_50 , vr_11 ) ;
fn_2 () ;
final vr_13 < tp_2 , tp_1 > vr_51 = fn_38 ( vr_50 ) ;
fn_22 ( vr_50 ) ;
vl_1 -= 2 ;
return vr_51 ;
} else if ( vr_15 . vr_19 ( vr_3 ) ) {
return null ;
} else if ( vr_15 . vr_20 ( vr_3 ) ) {
return fn_38 ( vr_14 ) ;
}
throw new fn_49 ( lr_10 + vr_2 ) ;
}
vr_13 < tp_2 , tp_1 > fn_52 ( final tp_2 vr_2 ) {
final int vr_11 = vr_11 ( vr_2 ) ;
if ( vr_11 == 0 ) {
if ( ! vr_1 . isEmpty () ) {
return vr_1 ;
}
return null ;
}
final vr_13 < tp_2 , tp_1 > vr_14 = fn_5 ( vr_2 , vr_11 ) ;
if ( fn_6 ( vr_2 , vr_14 . vr_2 ) ) {
return vr_14 ;
}
final int vr_3 = vr_3 ( vr_2 , vr_14 . vr_2 ) ;
if ( vr_15 . vr_17 ( vr_3 ) ) {
final vr_13 < tp_2 , tp_1 > vr_50 = new vr_13 <> ( vr_2 , null , vr_3 ) ;
fn_7 ( vr_50 , vr_11 ) ;
fn_2 () ;
final vr_13 < tp_2 , tp_1 > floor = fn_38 ( vr_50 ) ;
fn_22 ( vr_50 ) ;
vl_1 -= 2 ;
return floor ;
} else if ( vr_15 . vr_19 ( vr_3 ) ) {
if ( ! vr_1 . isEmpty () ) {
return vr_1 ;
}
return null ;
} else if ( vr_15 . vr_20 ( vr_3 ) ) {
return vr_14 ;
}
throw new fn_49 ( lr_10 + vr_2 ) ;
}
vr_13 < tp_2 , tp_1 > fn_53 ( final tp_2 vr_52 , final int vr_46 , final int vr_11 ) {
vr_13 < tp_2 , tp_1 > vr_22 = vr_1 . vr_6 ;
vr_13 < tp_2 , tp_1 > vr_23 = vr_1 ;
while ( true ) {
if ( vr_22 . vr_3 <= vr_23 . vr_3 || vr_11 <= vr_22 . vr_3 ) {
break;
}
vr_23 = vr_22 ;
if ( ! fn_8 ( vr_52 , vr_46 + vr_22 . vr_3 , vr_46 + vr_11 ) ) {
vr_22 = vr_22 . vr_6 ;
} else {
vr_22 = vr_22 . vr_7 ;
}
}
final vr_13 < tp_2 , tp_1 > vr_21 = vr_22 . isEmpty () ? vr_23 : vr_22 ;
if ( vr_21 . isEmpty () ) {
return null ;
}
final int vr_53 = vr_46 + vr_11 ;
if ( vr_21 == vr_1 && vr_11 ( vr_21 . vr_30 () ) < vr_53 ) {
return null ;
}
if ( fn_8 ( vr_52 , vr_53 - 1 , vr_53 )
!= fn_8 ( vr_21 . vr_2 , vr_11 - 1 , vr_11 ( vr_21 . vr_2 ) ) ) {
return null ;
}
final int vr_3 = fn_31 () . vr_3 ( vr_52 , vr_46 , vr_11 ,
vr_21 . vr_2 , 0 , vr_11 ( vr_21 . vr_30 () ) ) ;
if ( vr_3 >= 0 && vr_3 < vr_11 ) {
return null ;
}
return vr_21 ;
}
vr_13 < tp_2 , tp_1 > fn_35 () {
return fn_54 ( vr_1 . vr_6 ) ;
}
vr_13 < tp_2 , tp_1 > fn_54 ( vr_13 < tp_2 , tp_1 > vr_38 ) {
if ( vr_38 . vr_7 == null ) {
return null ;
}
while ( vr_38 . vr_7 . vr_3 > vr_38 . vr_3 ) {
vr_38 = vr_38 . vr_7 ;
}
return vr_38 . vr_7 ;
}
vr_13 < tp_2 , tp_1 > fn_38 ( final vr_13 < tp_2 , tp_1 > vr_39 ) {
if ( vr_39 . vr_8 == null ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( vr_39 . vr_8 . vr_7 == vr_39 ) {
if ( fn_25 ( vr_39 . vr_8 . vr_6 , vr_39 . vr_8 ) ) {
return vr_39 . vr_8 . vr_6 ;
}
return fn_54 ( vr_39 . vr_8 . vr_6 ) ;
}
vr_13 < tp_2 , tp_1 > vr_38 = vr_39 . vr_8 ;
while ( vr_38 . vr_5 != null && vr_38 == vr_38 . vr_5 . vr_6 ) {
vr_38 = vr_38 . vr_5 ;
}
if ( vr_38 . vr_5 == null ) {
return null ;
}
if ( fn_25 ( vr_38 . vr_5 . vr_6 , vr_38 . vr_5 ) ) {
if ( vr_38 . vr_5 . vr_6 == vr_1 ) {
if ( vr_1 . isEmpty () ) {
return null ;
}
return vr_1 ;
}
return vr_38 . vr_5 . vr_6 ;
}
return fn_54 ( vr_38 . vr_5 . vr_6 ) ;
}
vr_13 < tp_2 , tp_1 > fn_55 ( final vr_13 < tp_2 , tp_1 > vr_38 ,
final vr_13 < tp_2 , tp_1 > vr_54 ) {
if ( vr_38 == null ) {
return fn_27 () ;
}
return fn_28 ( vr_38 . vr_8 , vr_38 , vr_54 ) ;
}
static boolean fn_25 ( final vr_13 < ? , ? > vr_55 , final vr_13 < ? , ? > vr_56 ) {
return vr_55 != null && vr_55 . vr_3 <= vr_56 . vr_3 && ! vr_55 . isEmpty () ;
}
public void vr_32 ( final tp_3 vr_57 ) {
this . vr_57 = vr_57 ;
}
public tp_3 get () {
return vr_57 ;
}
public boolean isEmpty () {
return vr_2 == null ;
}
public boolean vr_34 () {
return vr_6 != this && vr_7 != this ;
}
public boolean vr_35 () {
return ! vr_34 () ;
}
@Override
public String toString () {
final StringBuilder vr_58 = new StringBuilder () ;
if ( vr_3 == - 1 ) {
vr_58 . append ( lr_12 ) ;
} else {
vr_58 . append ( lr_13 ) ;
}
vr_58 . append ( lr_14 ) . append ( vr_30 () ) . append ( lr_15 ) . append ( vr_3 ) . append ( lr_16 ) ;
vr_58 . append ( lr_17 ) . append ( vr_25 () ) . append ( lr_4 ) ;
if ( vr_5 != null ) {
if ( vr_5 . vr_3 == - 1 ) {
vr_58 . append ( lr_18 ) . append ( lr_19 ) ;
} else {
vr_58 . append ( lr_18 ) . append ( vr_5 . vr_30 () ) . append ( lr_15 ) . append ( vr_5 . vr_3 ) . append ( lr_20 ) ;
}
} else {
vr_58 . append ( lr_18 ) . append ( lr_21 ) ;
}
vr_58 . append ( lr_4 ) ;
if ( vr_6 != null ) {
if ( vr_6 . vr_3 == - 1 ) {
vr_58 . append ( lr_22 ) . append ( lr_19 ) ;
} else {
vr_58 . append ( lr_22 ) . append ( vr_6 . vr_30 () ) . append ( lr_15 ) . append ( vr_6 . vr_3 ) . append ( lr_20 ) ;
}
} else {
vr_58 . append ( lr_22 ) . append ( lr_21 ) ;
}
vr_58 . append ( lr_4 ) ;
if ( vr_7 != null ) {
if ( vr_7 . vr_3 == - 1 ) {
vr_58 . append ( lr_23 ) . append ( lr_19 ) ;
} else {
vr_58 . append ( lr_23 ) . append ( vr_7 . vr_30 () ) . append ( lr_15 ) . append ( vr_7 . vr_3 ) . append ( lr_20 ) ;
}
} else {
vr_58 . append ( lr_23 ) . append ( lr_21 ) ;
}
vr_58 . append ( lr_4 ) ;
if ( vr_8 != null ) {
if ( vr_8 . vr_3 == - 1 ) {
vr_58 . append ( lr_24 ) . append ( lr_19 ) ;
} else {
vr_58 . append ( lr_24 ) . append ( vr_8 . vr_30 () ) . append ( lr_15 ) .
append ( vr_8 . vr_3 ) . append ( lr_20 ) ;
}
}
vr_58 . append ( lr_25 ) ;
return vr_58 . toString () ;
}
@Override
public Iterator < vr_26 . vr_27 < tp_2 , tp_1 > > iterator () {
return new fn_56 () ;
}
@Override
public boolean contains ( final Object vr_59 ) {
if ( ! ( vr_59 instanceof vr_26 . vr_27 ) ) {
return false ;
}
final vr_13 < tp_2 , tp_1 > vr_60 = fn_9 ( ( ( vr_26 . vr_27 < ? , ? > ) vr_59 ) . vr_30 () ) ;
return vr_60 != null && vr_60 . equals ( vr_59 ) ;
}
@Override
public boolean remove ( final Object vr_61 ) {
if ( vr_61 instanceof vr_26 . vr_27 == false ) {
return false ;
}
if ( contains ( vr_61 ) == false ) {
return false ;
}
final vr_26 . vr_27 < ? , ? > vr_21 = ( vr_26 . vr_27 < ? , ? > ) vr_61 ;
vr_62 . this . remove ( vr_21 . vr_30 () ) ;
return true ;
}
@Override
public int size () {
return vr_62 . this . size () ;
}
@Override
public void clear () {
vr_62 . this . clear () ;
}
@Override
public vr_26 . vr_27 < tp_2 , tp_1 > vr_55 () {
return fn_26 () ;
}
@Override
public Iterator < tp_2 > iterator () {
return new fn_57 () ;
}
@Override
public int size () {
return vr_62 . this . size () ;
}
@Override
public boolean contains ( final Object vr_59 ) {
return fn_15 ( vr_59 ) ;
}
@Override
public boolean remove ( final Object vr_59 ) {
final int size = size () ;
vr_62 . this . remove ( vr_59 ) ;
return size != size () ;
}
@Override
public void clear () {
vr_62 . this . clear () ;
}
@Override
public tp_2 vr_55 () {
return fn_26 () . vr_30 () ;
}
@Override
public Iterator < tp_1 > iterator () {
return new fn_58 () ;
}
@Override
public int size () {
return vr_62 . this . size () ;
}
@Override
public boolean contains ( final Object vr_59 ) {
return fn_59 ( vr_59 ) ;
}
@Override
public void clear () {
vr_62 . this . clear () ;
}
@Override
public boolean remove ( final Object vr_59 ) {
for ( final Iterator < tp_1 > vr_63 = iterator () ; vr_63 . hasNext () ; ) {
final tp_1 vr_4 = vr_63 . vr_55 () ;
if ( fn_60 ( vr_4 , vr_59 ) ) {
vr_63 . remove () ;
return true ;
}
}
return false ;
}
@Override
public tp_1 vr_55 () {
return fn_26 () . vr_25 () ;
}
protected vr_13 < tp_2 , tp_1 > fn_26 () {
if ( vl_2 != vr_62 . this . vl_1 ) {
throw new fn_61 () ;
}
final vr_13 < tp_2 , tp_1 > vr_64 = vr_55 ;
if ( vr_64 == null ) {
throw new fn_33 () ;
}
vr_55 = fn_62 ( vr_64 ) ;
vr_22 = vr_64 ;
return vr_64 ;
}
protected vr_13 < tp_2 , tp_1 > fn_62 ( final vr_13 < tp_2 , tp_1 > vr_51 ) {
return vr_62 . this . fn_26 ( vr_51 ) ;
}
@Override
public boolean hasNext () {
return vr_55 != null ;
}
@Override
public void remove () {
if ( vr_22 == null ) {
throw new fn_49 () ;
}
if ( vl_2 != vr_62 . this . vl_1 ) {
throw new fn_61 () ;
}
final vr_13 < tp_2 , tp_1 > vr_38 = vr_22 ;
vr_22 = null ;
vr_62 . this . fn_22 ( vr_38 ) ;
vl_2 = vr_62 . this . vl_1 ;
}
@Override
public tp_2 vr_55 () {
return fn_26 () . vr_30 () ;
}
@Override
public tp_2 vr_30 () {
if ( vr_22 == null ) {
throw new fn_49 () ;
}
return vr_22 . vr_30 () ;
}
@Override
public tp_1 vr_25 () {
if ( vr_22 == null ) {
throw new fn_49 () ;
}
return vr_22 . vr_25 () ;
}
@Override
public tp_1 fn_63 ( final tp_1 vr_4 ) {
if ( vr_22 == null ) {
throw new fn_49 () ;
}
return vr_22 . fn_63 ( vr_4 ) ;
}
@Override
public boolean fn_64 () {
return vr_40 != null ;
}
@Override
public tp_2 vr_40 () {
return fn_38 () . vr_30 () ;
}
@Override
protected vr_13 < tp_2 , tp_1 > fn_26 () {
final vr_13 < tp_2 , tp_1 > fn_26 = super . fn_26 () ;
vr_40 = fn_26 ;
return fn_26 ;
}
protected vr_13 < tp_2 , tp_1 > fn_38 () {
if ( vl_2 != vr_62 . this . vl_1 ) {
throw new fn_61 () ;
}
final vr_13 < tp_2 , tp_1 > vr_64 = vr_40 ;
if ( vr_64 == null ) {
throw new fn_33 () ;
}
vr_40 = vr_62 . this . fn_38 ( vr_64 ) ;
vr_55 = vr_22 ;
vr_22 = vr_64 ;
return vr_22 ;
}
@Override
public vr_42 < ? super tp_2 > fn_30 () {
return vr_62 . this . fn_30 () ;
}
@Override
public boolean fn_15 ( final Object vr_2 ) {
if ( ! fn_65 ( fn_10 ( vr_2 ) ) ) {
return false ;
}
return vr_62 . this . fn_15 ( vr_2 ) ;
}
@Override
public tp_1 remove ( final Object vr_2 ) {
if ( ! fn_65 ( fn_10 ( vr_2 ) ) ) {
return null ;
}
return vr_62 . this . remove ( vr_2 ) ;
}
@Override
public tp_1 get ( final Object vr_2 ) {
if ( ! fn_65 ( fn_10 ( vr_2 ) ) ) {
return null ;
}
return vr_62 . this . get ( vr_2 ) ;
}
@Override
public tp_1 fn_4 ( final tp_2 vr_2 , final tp_1 vr_4 ) {
if ( ! fn_65 ( vr_2 ) ) {
throw new IllegalArgumentException ( lr_26 + vr_2 ) ;
}
return vr_62 . this . fn_4 ( vr_2 , vr_4 ) ;
}
@Override
public vr_33 < vr_26 . vr_27 < tp_2 , tp_1 > > fn_16 () {
if ( fn_16 == null ) {
fn_16 = fn_66 () ;
}
return fn_16 ;
}
@Override
public vr_45 < tp_2 , tp_1 > fn_46 ( final tp_2 vr_49 , final tp_2 vr_48 ) {
if ( ! fn_67 ( vr_49 ) ) {
throw new IllegalArgumentException ( lr_27 + vr_49 ) ;
}
if ( ! fn_67 ( vr_48 ) ) {
throw new IllegalArgumentException ( lr_28 + vr_48 ) ;
}
return fn_68 ( vr_49 , fn_69 () , vr_48 , fn_70 () ) ;
}
@Override
public vr_45 < tp_2 , tp_1 > fn_44 ( final tp_2 vr_48 ) {
if ( ! fn_67 ( vr_48 ) ) {
throw new IllegalArgumentException ( lr_28 + vr_48 ) ;
}
return fn_68 ( fn_71 () , fn_69 () , vr_48 , fn_70 () ) ;
}
@Override
public vr_45 < tp_2 , tp_1 > fn_47 ( final tp_2 vr_49 ) {
if ( ! fn_67 ( vr_49 ) ) {
throw new IllegalArgumentException ( lr_27 + vr_49 ) ;
}
return fn_68 ( vr_49 , fn_69 () , fn_72 () , fn_70 () ) ;
}
protected boolean fn_65 ( final tp_2 vr_2 ) {
final tp_2 vr_49 = fn_71 () ;
final tp_2 vr_48 = fn_72 () ;
return ( vr_49 == null || fn_73 ( vr_2 , false ) ) && ( vr_48 == null || fn_74 ( vr_2 , false ) ) ;
}
protected boolean fn_67 ( final tp_2 vr_2 ) {
final tp_2 vr_49 = fn_71 () ;
final tp_2 vr_48 = fn_72 () ;
return ( vr_49 == null || fn_73 ( vr_2 , false ) ) && ( vr_48 == null || fn_74 ( vr_2 , true ) ) ;
}
protected boolean fn_73 ( final tp_2 vr_2 , final boolean vr_65 ) {
final tp_2 vr_49 = fn_71 () ;
final boolean vr_66 = fn_69 () ;
final int vr_67 = fn_31 () . fn_60 ( vr_2 , vr_49 ) ;
if ( vr_66 || vr_65 ) {
return vr_67 >= 0 ;
}
return vr_67 > 0 ;
}
protected boolean fn_74 ( final tp_2 vr_2 , final boolean vr_65 ) {
final tp_2 vr_48 = fn_72 () ;
final boolean vr_68 = fn_70 () ;
final int vr_67 = fn_31 () . fn_60 ( vr_2 , vr_48 ) ;
if ( vr_68 || vr_65 ) {
return vr_67 <= 0 ;
}
return vr_67 < 0 ;
}
@Override
public tp_2 fn_32 () {
vr_26 . vr_27 < tp_2 , tp_1 > vr_64 = null ;
if ( vr_49 == null ) {
vr_64 = fn_27 () ;
} else {
if ( vr_66 ) {
vr_64 = fn_50 ( vr_49 ) ;
} else {
vr_64 = fn_48 ( vr_49 ) ;
}
}
final tp_2 vr_69 = vr_64 != null ? vr_64 . vr_30 () : null ;
if ( vr_64 == null || vr_48 != null && ! fn_74 ( vr_69 , false ) ) {
throw new fn_33 () ;
}
return vr_69 ;
}
@Override
public tp_2 fn_34 () {
vr_26 . vr_27 < tp_2 , tp_1 > vr_64 ;
if ( vr_48 == null ) {
vr_64 = fn_35 () ;
} else {
if ( vr_68 ) {
vr_64 = fn_52 ( vr_48 ) ;
} else {
vr_64 = fn_51 ( vr_48 ) ;
}
}
final tp_2 vr_70 = vr_64 != null ? vr_64 . vr_30 () : null ;
if ( vr_64 == null || vr_49 != null && ! fn_73 ( vr_70 , false ) ) {
throw new fn_33 () ;
}
return vr_70 ;
}
@Override
protected vr_33 < vr_27 < tp_2 , tp_1 > > fn_66 () {
return new fn_75 ( this ) ;
}
@Override
public tp_2 fn_71 () {
return vr_49 ;
}
@Override
public tp_2 fn_72 () {
return vr_48 ;
}
@Override
public boolean fn_69 () {
return vr_66 ;
}
@Override
public boolean fn_70 () {
return vr_68 ;
}
@Override
protected vr_45 < tp_2 , tp_1 > fn_68 ( final tp_2 vr_49 , final boolean vr_66 ,
final tp_2 vr_48 , final boolean vr_68 ) {
return new fn_45 ( vr_49 , vr_66 , vr_48 , vr_68 ) ;
}
@Override
public Iterator < vr_26 . vr_27 < tp_2 , tp_1 > > iterator () {
final tp_2 vr_49 = vr_71 . fn_71 () ;
final tp_2 vr_48 = vr_71 . fn_72 () ;
vr_13 < tp_2 , tp_1 > vr_69 = null ;
if ( vr_49 == null ) {
vr_69 = fn_27 () ;
} else {
vr_69 = fn_50 ( vr_49 ) ;
}
vr_13 < tp_2 , tp_1 > vr_70 = null ;
if ( vr_48 != null ) {
vr_70 = fn_50 ( vr_48 ) ;
}
return new fn_56 ( vr_69 , vr_70 ) ;
}
@Override
public int size () {
if ( size == - 1 || vl_2 != vr_62 . this . vl_1 ) {
size = 0 ;
for ( final Iterator < ? > vr_63 = iterator () ; vr_63 . hasNext () ; vr_63 . vr_55 () ) {
++ size ;
}
vl_2 = vr_62 . this . vl_1 ;
}
return size ;
}
@Override
public boolean isEmpty () {
return ! iterator () . hasNext () ;
}
@SuppressWarnings ( lr_29 )
@Override
public boolean contains ( final Object vr_59 ) {
if ( ! ( vr_59 instanceof vr_26 . vr_27 ) ) {
return false ;
}
final vr_26 . vr_27 < tp_2 , tp_1 > vr_21 = ( vr_26 . vr_27 < tp_2 , tp_1 > ) vr_59 ;
final tp_2 vr_2 = vr_21 . vr_30 () ;
if ( ! vr_71 . fn_65 ( vr_2 ) ) {
return false ;
}
final vr_13 < tp_2 , tp_1 > vr_38 = fn_9 ( vr_2 ) ;
return vr_38 != null && fn_60 ( vr_38 . vr_25 () , vr_21 . vr_25 () ) ;
}
@SuppressWarnings ( lr_29 )
@Override
public boolean remove ( final Object vr_59 ) {
if ( ! ( vr_59 instanceof vr_26 . vr_27 ) ) {
return false ;
}
final vr_26 . vr_27 < tp_2 , tp_1 > vr_21 = ( vr_26 . vr_27 < tp_2 , tp_1 > ) vr_59 ;
final tp_2 vr_2 = vr_21 . vr_30 () ;
if ( ! vr_71 . fn_65 ( vr_2 ) ) {
return false ;
}
final vr_13 < tp_2 , tp_1 > vr_38 = fn_9 ( vr_2 ) ;
if ( vr_38 != null && fn_60 ( vr_38 . vr_25 () , vr_21 . vr_25 () ) ) {
fn_22 ( vr_38 ) ;
return true ;
}
return false ;
}
@Override
public boolean hasNext () {
return vr_55 != null && ! fn_60 ( vr_55 . vr_2 , vl_3 ) ;
}
@Override
public vr_26 . vr_27 < tp_2 , tp_1 > vr_55 () {
if ( vr_55 == null || fn_60 ( vr_55 . vr_2 , vl_3 ) ) {
throw new fn_33 () ;
}
return fn_26 () ;
}
private int fn_76 () {
if ( size == - 1 || vr_62 . this . vl_1 != vl_2 ) {
final Iterator < vr_26 . vr_27 < tp_2 , tp_1 > > vr_63 = super . fn_16 () . iterator () ;
size = 0 ;
vr_26 . vr_27 < tp_2 , tp_1 > vr_21 = null ;
if ( vr_63 . hasNext () ) {
vr_21 = vr_63 . vr_55 () ;
size = 1 ;
}
vr_49 = vr_21 == null ? null : vr_21 . vr_30 () ;
if ( vr_49 != null ) {
final vr_13 < tp_2 , tp_1 > vr_51 = fn_38 ( ( vr_13 < tp_2 , tp_1 > ) vr_21 ) ;
vr_49 = vr_51 == null ? null : vr_51 . vr_30 () ;
}
vr_48 = vr_49 ;
while ( vr_63 . hasNext () ) {
++ size ;
vr_21 = vr_63 . vr_55 () ;
}
vr_48 = vr_21 == null ? null : vr_21 . vr_30 () ;
if ( vr_48 != null ) {
vr_21 = fn_26 ( ( vr_13 < tp_2 , tp_1 > ) vr_21 ) ;
vr_48 = vr_21 == null ? null : vr_21 . vr_30 () ;
}
vl_2 = vr_62 . this . vl_1 ;
}
return size ;
}
@Override
public tp_2 fn_32 () {
fn_76 () ;
vr_26 . vr_27 < tp_2 , tp_1 > vr_64 = null ;
if ( vr_49 == null ) {
vr_64 = fn_27 () ;
} else {
vr_64 = fn_48 ( vr_49 ) ;
}
final tp_2 vr_69 = vr_64 != null ? vr_64 . vr_30 () : null ;
if ( vr_64 == null || ! fn_31 () . fn_77 ( vr_52 , vr_46 , vr_11 , vr_69 ) ) {
throw new fn_33 () ;
}
return vr_69 ;
}
@Override
public tp_2 fn_34 () {
fn_76 () ;
vr_26 . vr_27 < tp_2 , tp_1 > vr_64 = null ;
if ( vr_48 == null ) {
vr_64 = fn_35 () ;
} else {
vr_64 = fn_51 ( vr_48 ) ;
}
final tp_2 vr_70 = vr_64 != null ? vr_64 . vr_30 () : null ;
if ( vr_64 == null || ! fn_31 () . fn_77 ( vr_52 , vr_46 , vr_11 , vr_70 ) ) {
throw new fn_33 () ;
}
return vr_70 ;
}
@Override
protected boolean fn_65 ( final tp_2 vr_2 ) {
return fn_31 () . fn_77 ( vr_52 , vr_46 , vr_11 , vr_2 ) ;
}
@Override
protected boolean fn_67 ( final tp_2 vr_2 ) {
return fn_65 ( vr_2 ) ;
}
@Override
protected boolean fn_73 ( final tp_2 vr_2 , final boolean vr_65 ) {
return fn_31 () . fn_77 ( vr_52 , vr_46 , vr_11 , vr_2 ) ;
}
@Override
protected boolean fn_74 ( final tp_2 vr_2 , final boolean vr_65 ) {
return fn_31 () . fn_77 ( vr_52 , vr_46 , vr_11 , vr_2 ) ;
}
@Override
protected vr_33 < vr_26 . vr_27 < tp_2 , tp_1 > > fn_66 () {
return new fn_78 ( this ) ;
}
@Override
public tp_2 fn_71 () {
return vr_49 ;
}
@Override
public tp_2 fn_72 () {
return vr_48 ;
}
@Override
public boolean fn_69 () {
return false ;
}
@Override
public boolean fn_70 () {
return false ;
}
@Override
protected vr_45 < tp_2 , tp_1 > fn_68 ( final tp_2 vr_49 , final boolean vr_66 ,
final tp_2 vr_48 , final boolean vr_68 ) {
return new fn_45 ( vr_49 , vr_66 , vr_48 , vr_68 ) ;
}
@Override
public void clear () {
final Iterator < vr_26 . vr_27 < tp_2 , tp_1 > > vr_63 = vr_62 . this . fn_16 () . iterator () ;
final vr_33 < tp_2 > vr_72 = fn_18 () ;
while ( vr_63 . hasNext () ) {
if ( vr_72 . contains ( vr_63 . vr_55 () . vr_30 () ) ) {
vr_63 . remove () ;
}
}
}
@Override
public int size () {
return vr_71 . fn_76 () ;
}
@Override
public Iterator < vr_26 . vr_27 < tp_2 , tp_1 > > iterator () {
if ( vr_62 . this . vl_1 != vl_2 ) {
vl_4 = fn_53 ( vr_71 . vr_52 , vr_71 . vr_46 , vr_71 . vr_11 ) ;
vl_2 = vr_62 . this . vl_1 ;
}
if ( vl_4 == null ) {
final vr_33 < vr_26 . vr_27 < tp_2 , tp_1 > > vr_73 = vr_74 . vr_75 () ;
return vr_73 . iterator () ;
} else if ( vr_71 . vr_11 > vl_4 . vr_3 ) {
return new fn_79 ( vl_4 ) ;
} else {
return new fn_56 ( vl_4 , vr_71 . vr_52 , vr_71 . vr_46 , vr_71 . vr_11 ) ;
}
}
@Override
public boolean hasNext () {
return vl_5 == 0 ;
}
@Override
public vr_26 . vr_27 < tp_2 , tp_1 > vr_55 () {
if ( vl_5 != 0 ) {
throw new fn_33 () ;
}
++ vl_5 ;
return vr_21 ;
}
@Override
public void remove () {
if ( vl_5 != 1 ) {
throw new fn_49 () ;
}
++ vl_5 ;
vr_62 . this . fn_22 ( vr_21 ) ;
}
@Override
public vr_26 . vr_27 < tp_2 , tp_1 > vr_55 () {
final vr_26 . vr_27 < tp_2 , tp_1 > vr_21 = fn_26 () ;
if ( vl_6 ) {
vr_55 = null ;
}
return vr_21 ;
}
@Override
protected vr_13 < tp_2 , tp_1 > fn_62 ( final vr_13 < tp_2 , tp_1 > vr_51 ) {
return vr_62 . this . fn_55 ( vr_51 , fn_53 ) ;
}
@Override
public void remove () {
boolean vr_76 = false ;
final int vr_77 = fn_53 . vr_3 ;
if ( vr_22 == fn_53 ) {
vr_76 = true ;
}
super . remove () ;
if ( vr_77 != fn_53 . vr_3 || vr_76 ) {
fn_53 = fn_53 ( vr_52 , vl_7 , vr_11 ) ;
}
if ( vr_11 >= fn_53 . vr_3 ) {
vl_6 = true ;
}
}
@SuppressWarnings ( lr_29 )
private void fn_80 ( final tp_4 vr_78 ) throws IOException , vl_8 {
vr_78 . vr_79 () ;
vr_1 = new vr_13 <> ( null , null , - 1 ) ;
final int size = vr_78 . vr_80 () ;
for ( int vr_81 = 0 ; vr_81 < size ; vr_81 ++ ) {
final tp_2 vr_24 = ( tp_2 ) vr_78 . fn_80 () ;
final tp_1 vr_82 = ( tp_1 ) vr_78 . fn_80 () ;
fn_4 ( vr_24 , vr_82 ) ;
}
}
private void fn_81 ( final tp_5 vr_78 ) throws IOException {
vr_78 . vr_83 () ;
vr_78 . vr_84 ( this . size () ) ;
for ( final vr_27 < tp_2 , tp_1 > vr_21 : fn_16 () ) {
vr_78 . fn_81 ( vr_21 . vr_30 () ) ;
vr_78 . fn_81 ( vr_21 . vr_25 () ) ;
}
}
