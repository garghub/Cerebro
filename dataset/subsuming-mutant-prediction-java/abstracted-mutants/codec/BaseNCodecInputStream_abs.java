@Override
public int fn_1 () throws IOException {
return vr_1 . vr_2 ? 0 : 1 ;
}
public boolean fn_2 () {
return vr_3 . fn_2 () ;
}
@Override
public synchronized void fn_3 ( final int vr_4 ) {
}
@Override
public boolean fn_4 () {
return false ;
}
@Override
public int fn_5 () throws IOException {
int vr_5 = fn_5 ( vl_1 , 0 , 1 ) ;
while ( vr_5 == 0 ) {
vr_5 = fn_5 ( vl_1 , 0 , 1 ) ;
}
if ( vr_5 > 0 ) {
final byte vr_6 = vl_1 [ 0 ] ;
return vr_6 < 0 ? 256 + vr_6 : vr_6 ;
}
return vl_2 ;
}
@Override
public int fn_5 ( final byte array [] , final int vr_7 , final int vr_8 ) throws IOException {
vr_9 . vr_10 ( array , lr_1 ) ;
if ( vr_7 < 0 || vr_8 < 0 ) {
throw new fn_6 () ;
} else if ( vr_7 > array . length || vr_7 + vr_8 > array . length ) {
throw new fn_6 () ;
} else if ( vr_8 == 0 ) {
return 0 ;
} else {
int vr_11 = 0 ;
while ( vr_11 == 0 ) {
if ( ! vr_3 . vr_12 ( vr_1 ) ) {
final byte [] vr_13 = new byte [ vl_3 ? 4096 : 8192 ] ;
final int vr_14 = vr_15 . fn_5 ( vr_13 ) ;
if ( vl_3 ) {
vr_3 . vr_16 ( vr_13 , 0 , vr_14 , vr_1 ) ;
} else {
vr_3 . vr_17 ( vr_13 , 0 , vr_14 , vr_1 ) ;
}
}
vr_11 = vr_3 . vr_18 ( array , vr_7 , vr_8 , vr_1 ) ;
}
return vr_11 ;
}
}
@Override
public synchronized void fn_7 () throws IOException {
throw new IOException ( lr_2 ) ;
}
@Override
public long fn_8 ( final long vr_19 ) throws IOException {
if ( vr_19 < 0 ) {
throw new IllegalArgumentException ( lr_3 + vr_19 ) ;
}
final byte [] vr_6 = new byte [ 512 ] ;
long vr_20 = vr_19 ;
while ( vr_20 > 0 ) {
int vr_8 = ( int ) vr_21 . vr_22 ( vr_6 . length , vr_20 ) ;
vr_8 = this . fn_5 ( vr_6 , 0 , vr_8 ) ;
if ( vr_8 == vl_2 ) {
break;
}
vr_20 -= vr_8 ;
}
return vr_19 - vr_20 ;
}
