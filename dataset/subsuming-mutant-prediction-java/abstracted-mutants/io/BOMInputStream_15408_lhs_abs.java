@Override
public int fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
final int vr_3 = vr_1 . length () ;
final int vr_4 = vr_2 . length () ;
if ( vr_3 > vr_4 ) {
return vl_1 ;
}
if ( vr_4 > vr_3 ) {
return 1 ;
}
return 0 ;
}
public boolean fn_2 () throws IOException {
return fn_3 () != null ;
}
public boolean fn_2 ( final tp_1 vr_5 ) throws IOException {
if ( ! vr_6 . contains ( vr_5 ) ) {
throw new IllegalArgumentException ( lr_1 + vr_5 ) ;
}
fn_3 () ;
return vl_2 != null && vl_2 . equals ( vr_5 ) ;
}
public tp_1 fn_3 () throws IOException {
if ( vl_3 == null ) {
vl_4 = 0 ;
final int vr_7 = vr_6 . get ( 0 ) . length () ;
vl_3 = new int [ vr_7 ] ;
for ( int vr_8 = 0 ; vr_8 < vl_3 . length ; vr_8 ++ ) {
vl_3 [ vr_8 ] = vr_9 . vr_10 () ;
vl_4 ++ ;
if ( vl_3 [ vr_8 ] < 0 ) {
break;
}
}
vl_2 = fn_4 () ;
if ( vl_2 != null ) {
if ( ! include ) {
if ( vl_2 . length () < vl_3 . length ) {
vl_5 = vl_2 . length () ;
} else {
vl_4 = 0 ;
}
}
}
}
return vl_2 ;
}
public String fn_5 () throws IOException {
fn_3 () ;
return vl_2 == null ? null : vl_2 . vr_11 () ;
}
private int fn_6 () throws IOException {
fn_3 () ;
return vl_5 < vl_4 ? vl_3 [ vl_5 ++ ] : vl_1 ;
}
private tp_1 fn_4 () {
for ( final tp_1 vr_5 : vr_6 ) {
if ( fn_7 ( vr_5 ) ) {
return vr_5 ;
}
}
return null ;
}
private boolean fn_7 ( final tp_1 vr_5 ) {
for ( int vr_8 = 0 ; vr_8 < vr_5 . length () ; vr_8 ++ ) {
if ( vr_5 . get ( vr_8 ) != vl_3 [ vr_8 ] ) {
return false ;
}
}
return true ;
}
@Override
public int vr_10 () throws IOException {
final int vr_12 = fn_6 () ;
return vr_12 >= 0 ? vr_12 : vr_9 . vr_10 () ;
}
@Override
public int vr_10 ( final byte [] vr_13 , int vr_14 , int vr_15 ) throws IOException {
int vr_16 = 0 ;
int vr_12 = 0 ;
while ( vr_15 > 0 && vr_12 >= 0 ) {
vr_12 = fn_6 () ;
if ( vr_12 >= 0 ) {
vr_13 [ vr_14 ++ ] = (byte) ( vr_12 & 0xFF ) ;
vr_15 -- ;
vr_16 ++ ;
}
}
final int vr_17 = vr_9 . vr_10 ( vr_13 , vr_14 , vr_15 ) ;
return vr_17 < 0 ? vr_16 > 0 ? vr_16 : vl_1 : vr_16 + vr_17 ; MST[rv.ROR3Mutator]MSP[]
}
@Override
public int vr_10 ( final byte [] vr_13 ) throws IOException {
return vr_10 ( vr_13 , 0 , vr_13 . length ) ;
}
@Override
public synchronized void fn_8 ( final int vr_18 ) {
vl_6 = vl_5 ;
vl_7 = vl_3 == null ;
vr_9 . fn_8 ( vr_18 ) ;
}
@Override
public synchronized void fn_9 () throws IOException {
vl_5 = vl_6 ;
if ( vl_7 ) {
vl_3 = null ;
}
vr_9 . fn_9 () ;
}
@Override
public long fn_10 ( final long vr_19 ) throws IOException {
int vr_20 = 0 ;
while ( ( vr_19 > vr_20 ) && ( fn_6 () >= 0 ) ) {
vr_20 ++ ;
}
return vr_9 . fn_10 ( vr_19 - vr_20 ) + vr_20 ;
}
