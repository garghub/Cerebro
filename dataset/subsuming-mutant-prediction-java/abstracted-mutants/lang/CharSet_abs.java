public static tp_1 fn_1 ( final String ... vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
if ( vr_1 . length == 1 ) {
final tp_1 vr_2 = vr_3 . get ( vr_1 [ 0 ] ) ;
if ( vr_2 != null ) {
return vr_2 ;
}
}
return new tp_1 ( vr_1 ) ;
}
protected void add ( final String vr_4 ) {
if ( vr_4 == null ) {
return;
}
final int vr_5 = vr_4 . length () ;
int vr_6 = 0 ;
while ( vr_6 < vr_5 ) {
final int vr_7 = vr_5 - vr_6 ;
if ( vr_7 >= 4 && vr_4 . charAt ( vr_6 ) == '^' && vr_4 . charAt ( vr_6 + 2 ) == '-' ) {
vr_8 . add ( vr_9 . vr_10 ( vr_4 . charAt ( vr_6 + 1 ) , vr_4 . charAt ( vr_6 + 3 ) ) ) ;
vr_6 += 4 ;
} else if ( vr_7 >= 3 && vr_4 . charAt ( vr_6 + 1 ) == '-' ) {
vr_8 . add ( vr_9 . vr_11 ( vr_4 . charAt ( vr_6 ) , vr_4 . charAt ( vr_6 + 2 ) ) ) ;
vr_6 += 3 ;
} else if ( vr_7 >= 2 && vr_4 . charAt ( vr_6 ) == '^' ) {
vr_8 . add ( vr_9 . vr_12 ( vr_4 . charAt ( vr_6 + 1 ) ) ) ;
vr_6 += 2 ;
} else {
vr_8 . add ( vr_9 . vr_13 ( vr_4 . charAt ( vr_6 ) ) ) ;
vr_6 += 1 ;
}
}
}
vr_9 [] fn_2 () {
return vr_8 . toArray ( new vr_9 [ vr_8 . size () ] ) ;
}
public boolean contains ( final char vr_14 ) {
for ( final vr_9 vr_15 : vr_8 ) {
if ( vr_15 . contains ( vr_14 ) ) {
return true ;
}
}
return false ;
}
@Override
public boolean equals ( final Object vr_16 ) {
if ( vr_16 == this ) {
return true ;
}
if ( vr_16 instanceof tp_1 == false ) {
return false ;
}
final tp_1 vr_17 = ( tp_1 ) vr_16 ;
return vr_8 . equals ( vr_17 . vr_8 ) ;
}
@Override
public int fn_3 () {
return 89 + vr_8 . fn_3 () ;
}
@Override
public String toString () {
return vr_8 . toString () ;
}
