public byte fn_1 () {
if ( vl_1 <= 0 ) {
throw new fn_2 ( lr_1 ) ;
}
final byte vr_1 = vr_2 [ vl_2 ] ;
-- vl_1 ;
if ( ++ vl_2 == vr_2 . length ) {
vl_2 = 0 ;
}
return vr_1 ;
}
public void fn_1 ( final byte [] vr_3 , final int vr_4 , final int vr_5 ) {
vr_6 . vr_7 ( vr_3 ) ;
if ( vr_4 < 0 || vr_4 >= vr_3 . length ) {
throw new IllegalArgumentException ( lr_2 + vr_4 ) ;
}
if ( vr_5 < 0 || vr_5 > vr_2 . length ) {
throw new IllegalArgumentException ( lr_3 + vr_5 ) ;
}
if ( vr_4 + vr_5 > vr_3 . length ) {
throw new IllegalArgumentException ( lr_4
+ vr_3 . length + lr_5
+ ( vr_4 + vr_5 - 1 ) ) ;
}
if ( vl_1 < vr_5 ) {
throw new fn_2 ( lr_6 + vl_1
+ lr_7 + vr_5 ) ;
}
int vr_8 = vr_4 ;
for ( int vr_9 = 0 ; vr_9 < vr_5 ; vr_9 ++ ) {
vr_3 [ vr_8 ++ ] = vr_2 [ vl_2 ] ;
-- vl_1 ;
if ( ++ vl_2 == vr_2 . length ) {
vl_2 = 0 ;
}
}
}
public void add ( final byte vr_10 ) {
if ( vl_1 >= vr_2 . length ) {
throw new fn_2 ( lr_8 ) ;
}
vr_2 [ vl_3 ] = vr_10 ;
++ vl_1 ;
if ( ++ vl_3 == vr_2 . length ) {
vl_3 = 0 ;
}
}
public boolean fn_3 ( final byte [] vr_3 , final int vr_4 , final int vr_5 ) {
vr_6 . vr_7 ( vr_3 , lr_9 ) ;
if ( vr_4 < 0 || vr_4 >= vr_3 . length ) {
throw new IllegalArgumentException ( lr_2 + vr_4 ) ;
}
if ( vr_5 < 0 || vr_5 > vr_2 . length ) {
throw new IllegalArgumentException ( lr_3 + vr_5 ) ;
}
if ( vr_5 < vl_1 ) {
return false ;
}
int vr_8 = vl_2 ;
for ( int vr_9 = 0 ; vr_9 < vr_5 ; vr_9 ++ ) {
if ( vr_2 [ vr_8 ] != vr_3 [ vr_9 + vr_4 ] ) {
return false ;
}
if ( ++ vr_8 == vr_2 . length ) {
vr_8 = 0 ;
}
}
return true ;
}
public void add ( final byte [] vr_3 , final int vr_4 , final int vr_5 ) {
vr_6 . vr_7 ( vr_3 , lr_9 ) ;
if ( vr_4 < 0 || vr_4 >= vr_3 . length ) {
throw new IllegalArgumentException ( lr_2 + vr_4 ) ;
}
if ( vr_5 < 0 ) {
throw new IllegalArgumentException ( lr_3 + vr_5 ) ;
}
if ( vl_1 + vr_5 > vr_2 . length ) {
throw new fn_2 ( lr_8 ) ;
}
for ( int vr_9 = 0 ; vr_9 < vr_5 ; vr_9 ++ ) {
vr_2 [ vl_3 ] = vr_3 [ vr_4 + vr_9 ] ;
if ( ++ vl_3 == vr_2 . length ) {
vl_3 = 0 ;
}
}
vl_1 += vr_5 ;
}
public boolean fn_4 () {
return vl_1 < vr_2 . length ;
}
public boolean fn_4 ( final int vr_11 ) {
return vl_1 + vr_11 <= vr_2 . length ;
}
public boolean fn_5 () {
return vl_1 > 0 ;
}
public int fn_6 () {
return vr_2 . length - vl_1 ;
}
public int fn_7 () {
return vl_1 ;
}
public void clear () {
vl_2 = 0 ;
vl_3 = 0 ;
vl_1 = 0 ;
}
