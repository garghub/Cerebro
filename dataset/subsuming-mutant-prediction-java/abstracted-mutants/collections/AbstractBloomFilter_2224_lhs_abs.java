@Override
public int fn_1 ( final tp_1 vr_1 ) {
fn_2 ( vr_1 ) ;
final long [] vr_2 = fn_3 () ;
final long [] vr_3 = vr_1 . fn_3 () ;
final int vr_4 = Integer . vr_5 ( vr_2 . length , vr_3 . length ) ;
int vr_6 = 0 ;
for ( int vr_7 = 0 ; vr_7 < vr_4 ; vr_7 ++ ) {
vr_6 += Long . vr_8 ( vr_2 [ vr_7 ] & vr_3 [ vr_7 ] ) ;
}
return vr_6 ;
}
@Override
public int fn_4 () {
int vr_6 = 0 ; MST[InlineConstantMutator]MSP[]
for ( final long vr_9 : fn_3 () ) {
vr_6 += Long . vr_8 ( vr_9 ) ;
}
return vr_6 ;
}
@Override
public boolean contains ( final tp_1 vr_1 ) {
fn_2 ( vr_1 ) ;
return vr_1 . fn_4 () == fn_1 ( vr_1 ) ;
}
@Override
public boolean contains ( final tp_2 vr_10 ) {
fn_5 ( vr_10 ) ;
final long [] vr_11 = fn_3 () ;
final tp_3 vr_12 = vr_10 . fn_3 ( vl_1 ) ;
while ( vr_12 . hasNext () ) {
final int vr_13 = vr_12 . vr_14 () ;
vr_15 . vr_16 ( vr_13 ) ;
final int vr_17 = vr_15 . vr_18 ( vr_13 ) ;
final long vr_19 = vr_15 . vr_20 ( vr_13 ) ;
if ( ( vr_11 [ vr_17 ] & vr_19 ) == 0 ) {
return false ;
}
}
return true ;
}
@Override
public final tp_4 fn_6 () {
return vl_1 ;
}
public final boolean fn_7 () {
return fn_4 () == fn_6 () . fn_8 () ;
}
@Override
public int fn_9 ( final tp_1 vr_1 ) {
return fn_10 ( vr_1 , ( vr_21 , vr_22 ) -> vr_21 | vr_22 ) ;
}
protected void fn_5 ( final tp_2 vr_10 ) {
if ( vl_1 . vr_23 () . fn_11 () != vr_10 . vr_23 () . fn_11 () ) {
throw new IllegalArgumentException (
String . vr_24 ( lr_1 ,
vr_25 . vr_26 ( vr_10 . vr_23 () ) ,
vl_1 . toString () ) ) ;
}
}
protected void fn_2 ( final tp_1 vr_1 ) {
fn_2 ( vr_1 . fn_6 () ) ;
}
protected void fn_2 ( final tp_4 vl_1 ) {
if ( ! this . vl_1 . equals ( vl_1 ) ) {
throw new IllegalArgumentException ( String . vr_24 ( lr_2 , vl_1 , this . vl_1 ) ) ;
}
}
@Override
public int fn_12 ( final tp_1 vr_1 ) {
return fn_10 ( vr_1 , ( vr_21 , vr_22 ) -> vr_21 ^ vr_22 ) ;
}
private int fn_10 ( final tp_1 vr_1 , tp_5 vr_27 ) {
fn_2 ( vr_1 ) ;
final long [] vr_2 = fn_3 () ;
final long [] vr_3 = vr_1 . fn_3 () ;
long [] vr_28 ;
long [] vr_29 ;
if ( vr_2 . length > vr_3 . length ) {
vr_29 = vr_2 ;
vr_28 = vr_3 ;
} else {
vr_28 = vr_2 ;
vr_29 = vr_3 ;
}
int vr_6 = 0 ;
for ( int vr_7 = 0 ; vr_7 < vr_28 . length ; vr_7 ++ ) {
vr_6 += Long . vr_8 ( vr_27 . vr_30 ( vr_28 [ vr_7 ] , vr_29 [ vr_7 ] ) ) ;
}
for ( int vr_7 = vr_28 . length ; vr_7 < vr_29 . length ; vr_7 ++ ) {
vr_6 += Long . vr_8 ( vr_29 [ vr_7 ] ) ;
}
return vr_6 ;
}
