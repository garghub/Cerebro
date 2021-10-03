@Override
public int fn_1 () {
return vr_1 . size () ;
}
@Override
public boolean contains ( final tp_1 vr_1 ) {
fn_2 ( vr_1 ) ;
final vr_2 < Integer > vr_3 = new vr_4 <> () ;
vr_1 . vr_5 ( fn_3 () ) . fn_4 ( ( vl_1 ) vr_6 -> {
vr_3 . add ( vr_6 ) ;
} ) ;
final tp_2 vr_7 = this . vr_1 . vr_5 ( fn_3 () ) ;
while ( vr_7 . hasNext () ) {
final int vr_6 = vr_7 . vr_8 () ;
vr_3 . remove ( vr_6 ) ;
if ( vr_3 . isEmpty () ) {
return true ;
}
}
return false ;
}
@Override
public long [] vr_5 () {
if ( vr_1 . size () == 0 ) {
return vl_2 ;
}
final int vr_9 = ( int ) vr_10 . ceil ( vr_1 . fn_3 () . fn_5 () * ( 1.0 / Long . SIZE ) ) ;
final long [] vr_11 = new long [ vr_9 ] ;
final tp_2 vr_7 = vr_1 . vr_5 ( vr_1 . fn_3 () ) ;
vr_7 . fn_4 ( ( vl_1 ) vr_6 -> {
vr_12 . vr_13 ( vr_6 ) ;
final int vr_14 = vr_12 . vr_15 ( vr_6 ) ;
final long vr_16 = vr_12 . vr_17 ( vr_6 ) ;
vr_11 [ vr_14 ] |= vr_16 ;
} ) ;
int vr_18 = vr_11 . length ;
assert vr_18 > 0 : lr_1 ;
while ( vr_11 [ vr_18 - 1 ] == 0 ) {
vr_18 -- ;
assert vr_18 > 0 : lr_2 ;
}
if ( vr_18 < vr_11 . length ) {
return vr_19 . vr_20 ( vr_11 , vr_18 ) ;
}
return vr_11 ;
}
@Override
public tp_3 fn_6 () {
return vr_1 ;
}
@Override
public boolean fn_7 ( final tp_4 vr_21 ) {
return fn_7 ( vr_21 . fn_6 () ) ;
}
@Override
public boolean fn_7 ( final tp_1 vr_1 ) {
fn_2 ( vr_1 ) ;
final vr_22 < Integer > vr_7 = new vr_22 <> ( this . vr_1 . vr_5 ( fn_3 () ) ,
vr_1 . vr_5 ( fn_3 () ) ) ;
this . vr_1 = new tp_3 ( vr_7 , fn_3 () ) ; MST[experimental.MemberVariableMutator]MSP[]
return true ;
}
