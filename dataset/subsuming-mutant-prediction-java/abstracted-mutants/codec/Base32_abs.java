@Override
void fn_1 ( final byte [] vr_1 , int vr_2 , final int vr_3 , final tp_1 vr_4 ) {
if ( vr_4 . vr_5 ) {
return;
}
if ( vr_3 < 0 ) {
vr_4 . vr_5 = true ;
}
for ( int vr_6 = 0 ; vr_6 < vr_3 ; vr_6 ++ ) {
final byte vr_7 = vr_1 [ vr_2 ++ ] ;
if ( vr_7 == vl_1 ) {
vr_4 . vr_5 = true ;
break;
}
final byte [] vr_8 = fn_2 ( vl_2 , vr_4 ) ;
if ( vr_7 >= 0 && vr_7 < this . vr_9 . length ) {
final int vr_10 = this . vr_9 [ vr_7 ] ;
if ( vr_10 >= 0 ) {
vr_4 . vr_11 = ( vr_4 . vr_11 + 1 ) % vl_3 ;
vr_4 . vr_12 = ( vr_4 . vr_12 << vl_4 ) + vr_10 ;
if ( vr_4 . vr_11 == 0 ) {
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 32 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 24 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 16 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 8 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( vr_4 . vr_12 & vl_5 ) ;
}
}
}
}
if ( vr_4 . vr_5 && vr_4 . vr_11 > 0 ) {
final byte [] vr_8 = fn_2 ( vl_2 , vr_4 ) ;
switch ( vr_4 . vr_11 ) {
case 1 :
fn_3 () ;
case 2 :
fn_4 ( vl_6 , vr_4 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 2 ) & vl_5 ) ;
break;
case 3 :
fn_3 () ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 7 ) & vl_5 ) ;
break;
case 4 :
fn_4 ( vl_7 , vr_4 ) ;
vr_4 . vr_12 = vr_4 . vr_12 >> 4 ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 8 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 ) & vl_5 ) ;
break;
case 5 :
fn_4 ( vl_8 , vr_4 ) ;
vr_4 . vr_12 = vr_4 . vr_12 >> 1 ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 16 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 8 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 ) & vl_5 ) ;
break;
case 6 :
fn_3 () ;
vr_4 . vr_12 = vr_4 . vr_12 >> 6 ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 16 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 8 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 ) & vl_5 ) ;
break;
case 7 :
fn_4 ( vl_9 , vr_4 ) ;
vr_4 . vr_12 = vr_4 . vr_12 >> 3 ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 24 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 16 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 >> 8 ) & vl_5 ) ;
vr_8 [ vr_4 . vr_13 ++ ] = (byte) ( ( vr_4 . vr_12 ) & vl_5 ) ;
break;
default:
throw new fn_5 ( lr_1 + vr_4 . vr_11 ) ;
}
}
}
@Override
void fn_6 ( final byte [] vr_1 , int vr_2 , final int vr_3 , final tp_1 vr_4 ) {
if ( vr_4 . vr_5 ) {
return;
}
if ( vr_3 < 0 ) {
vr_4 . vr_5 = true ;
if ( 0 == vr_4 . vr_11 && vl_10 == 0 ) {
return;
}
final byte [] vr_8 = fn_2 ( vl_11 , vr_4 ) ;
final int vr_14 = vr_4 . vr_13 ;
switch ( vr_4 . vr_11 ) {
case 0 :
break;
case 1 :
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 3 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 << 2 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
break;
case 2 :
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 11 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 6 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 1 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 << 4 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
break;
case 3 :
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 19 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 14 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 9 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 4 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 << 1 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
break;
case 4 :
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 27 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 22 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 17 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 12 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 7 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 2 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 << 3 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vl_1 ;
break;
default:
throw new fn_5 ( lr_1 + vr_4 . vr_11 ) ;
}
vr_4 . vr_16 += vr_4 . vr_13 - vr_14 ;
if ( vl_10 > 0 && vr_4 . vr_16 > 0 ) {
System . vr_17 ( vl_13 , 0 , vr_8 , vr_4 . vr_13 , vl_13 . length ) ;
vr_4 . vr_13 += vl_13 . length ;
}
} else {
for ( int vr_6 = 0 ; vr_6 < vr_3 ; vr_6 ++ ) {
final byte [] vr_8 = fn_2 ( vl_11 , vr_4 ) ;
vr_4 . vr_11 = ( vr_4 . vr_11 + 1 ) % vl_14 ;
int vr_7 = vr_1 [ vr_2 ++ ] ;
if ( vr_7 < 0 ) {
vr_7 += 256 ;
}
vr_4 . vr_12 = ( vr_4 . vr_12 << 8 ) + vr_7 ;
if ( 0 == vr_4 . vr_11 ) {
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 35 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 30 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 25 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 20 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 15 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 10 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ (int)( vr_4 . vr_12 >> 5 ) & vl_12 ] ;
vr_8 [ vr_4 . vr_13 ++ ] = vr_15 [ ( int ) vr_4 . vr_12 & vl_12 ] ;
vr_4 . vr_16 += vl_3 ;
if ( vl_10 > 0 && vl_10 <= vr_4 . vr_16 ) {
System . vr_17 ( vl_13 , 0 , vr_8 , vr_4 . vr_13 , vl_13 . length ) ;
vr_4 . vr_13 += vl_13 . length ;
vr_4 . vr_16 = 0 ;
}
}
}
}
}
@Override
public boolean fn_7 ( final byte vr_18 ) {
return vr_18 >= 0 && vr_18 < vr_9 . length && vr_9 [ vr_18 ] != - 1 ;
}
private void fn_4 ( final long vr_19 , final tp_1 vr_4 ) {
if ( fn_8 () && ( vr_4 . vr_12 & vr_19 ) != 0 ) {
throw new IllegalArgumentException (
lr_2 +
lr_3 +
lr_4 ) ;
}
}
private void fn_3 () {
if ( fn_8 () ) {
throw new IllegalArgumentException (
lr_5 +
lr_3 +
lr_6 ) ;
}
}
