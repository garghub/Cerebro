public int size () {
return fn_1 () . size () ;
}
public tp_1 fn_2 ( int vr_1 ) {
return fn_1 () . fn_2 ( vr_1 ) ;
}
public tp_1 [] fn_3 () {
tp_1 [] vr_2 = new tp_1 [ size () ] ;
for ( int vr_3 = 0 ; vr_3 < vr_2 . length ; vr_3 ++ ) {
vr_2 [ vr_3 ] = fn_2 ( vr_3 ) ;
}
return vr_2 ;
}
public int [] getValues () {
int [] vr_2 = new int [ size () ] ;
for ( int vr_3 = 0 ; vr_3 < vr_2 . length ; vr_3 ++ ) {
vr_2 [ vr_3 ] = fn_4 ( vr_3 ) ;
}
return vr_2 ;
}
public int get ( tp_1 type ) {
int vr_1 = indexOf ( type ) ;
if ( vr_1 == - 1 ) {
return 0 ;
}
return fn_4 ( vr_1 ) ;
}
public boolean fn_5 ( tp_1 type ) {
return fn_1 () . fn_5 ( type ) ;
}
public int indexOf ( tp_1 type ) {
return fn_1 () . indexOf ( type ) ;
}
public tp_2 fn_6 () {
return new tp_2 ( this ) ;
}
public tp_3 fn_7 () {
return new tp_3 ( this ) ;
}
public boolean equals ( Object vr_4 ) {
if ( this == vr_4 ) {
return true ;
}
if ( vr_4 instanceof vl_1 == false ) {
return false ;
}
vl_1 vr_5 = ( vl_1 ) vr_4 ;
if ( size () != vr_5 . size () ) {
return false ;
}
for ( int vr_3 = 0 , vr_6 = size () ; vr_3 < vr_6 ; vr_3 ++ ) {
if ( fn_4 ( vr_3 ) != vr_5 . fn_4 ( vr_3 ) || fn_2 ( vr_3 ) != vr_5 . fn_2 ( vr_3 ) ) {
return false ;
}
}
return true ;
}
public int fn_8 () {
int vr_7 = 17 ;
for ( int vr_3 = 0 , vr_6 = size () ; vr_3 < vr_6 ; vr_3 ++ ) {
vr_7 = 27 * vr_7 + fn_4 ( vr_3 ) ;
vr_7 = 27 * vr_7 + fn_2 ( vr_3 ) . fn_8 () ;
}
return vr_7 ;
}
@ToString
public String toString () {
return vr_8 . vr_9 () . fn_9 ( this ) ;
}
public String toString ( tp_4 vr_10 ) {
if ( vr_10 == null ) {
return toString () ;
}
return vr_10 . fn_9 ( this ) ;
}
