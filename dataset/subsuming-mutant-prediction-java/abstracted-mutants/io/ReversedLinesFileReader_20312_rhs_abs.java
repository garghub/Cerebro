public String readLine () throws IOException {
String line = vr_1 . readLine () ;
while ( line == null ) {
vr_1 = vr_1 . vr_2 () ;
if ( vr_1 != null ) {
line = vr_1 . readLine () ;
} else {
break;
}
}
if( vr_3 . equals ( line ) && ! vl_1 ) {
vl_1 = true ;
line = readLine () ;
}
return line ; MST[EmptyObjectReturnValsMutator]MSP[N]
}
@Override
public void fn_1 () throws IOException {
vr_4 . fn_1 () ;
}
private tp_1 vr_2 () throws IOException {
if ( vl_2 > - 1 ) {
throw new fn_2 ( lr_1
+ lr_2 + vl_2 ) ;
}
if ( vl_3 > 1 ) {
return new tp_1 ( vl_3 - 1 , vl_4 , vl_5 ) ;
}
if ( vl_5 != null ) {
throw new fn_2 ( lr_3
+ new String ( vl_5 , vl_6 ) ) ;
}
return null ;
}
private String readLine () throws IOException {
String line = null ;
int vr_5 ;
final boolean vr_6 = vl_3 == 1 ;
int vr_7 = vl_2 ;
while ( vr_7 > - 1 ) {
if ( ! vr_6 && vr_7 < vl_7 ) {
fn_3 () ;
break;
}
if ( ( vr_5 = fn_4 ( vl_8 , vr_7 ) ) > 0 ) {
final int vr_8 = vr_7 + 1 ;
final int vr_9 = vl_2 - vr_8 + 1 ;
if ( vr_9 < 0 ) {
throw new fn_2 ( lr_4 + vr_9 ) ;
}
final byte [] vr_10 = new byte [ vr_9 ] ;
System . vr_11 ( vl_8 , vr_8 , vr_10 , 0 , vr_9 ) ;
line = new String ( vr_10 , vl_6 ) ;
vl_2 = vr_7 - vr_5 ;
break;
}
vr_7 -= vl_9 ;
if ( vr_7 < 0 ) {
fn_3 () ;
break;
}
}
if ( vr_6 && vl_5 != null ) {
line = new String ( vl_5 , vl_6 ) ;
vl_5 = null ;
}
return line ;
}
private void fn_3 () {
final int vr_9 = vl_2 + 1 ;
if ( vr_9 > 0 ) {
vl_5 = new byte [ vr_9 ] ;
System . vr_11 ( vl_8 , 0 , vl_5 , 0 , vr_9 ) ;
} else {
vl_5 = null ;
}
vl_2 = - 1 ;
}
private int fn_4 ( final byte [] vl_8 , final int vr_7 ) {
for ( final byte [] vr_12 : vl_10 ) {
boolean vr_13 = true ;
for ( int vr_14 = vr_12 . length - 1 ; vr_14 >= 0 ; vr_14 -- ) {
final int vr_15 = vr_7 + vr_14 - ( vr_12 . length - 1 ) ;
vr_13 &= vr_15 >= 0 && vl_8 [ vr_15 ] == vr_12 [ vr_14 ] ;
}
if ( vr_13 ) {
return vr_12 . length ;
}
}
return 0 ;
}
