private void fn_1 ( final int vr_1 ) {
if ( vl_1 < vr_2 . size () - 1 ) {
vl_2 += vr_3 . length ;
vl_1 ++ ;
vr_3 = vr_2 . get ( vl_1 ) ;
} else {
int vr_4 ;
if ( vr_3 == null ) {
vr_4 = vr_1 ;
vl_2 = 0 ;
} else {
vr_4 = vr_5 . vr_6 (
vr_3 . length << 1 ,
vr_1 - vl_2 ) ;
vl_2 += vr_3 . length ;
}
vl_1 ++ ;
vr_3 = new byte [ vr_4 ] ;
vr_2 . add ( vr_3 ) ;
}
}
@Override
public void fn_2 ( final byte [] vr_7 , final int vr_8 , final int vr_9 ) {
if ( ( vr_8 < 0 )
|| ( vr_8 > vr_7 . length )
|| ( vr_9 < 0 )
|| ( ( vr_8 + vr_9 ) > vr_7 . length )
|| ( ( vr_8 + vr_9 ) < 0 ) ) {
throw new fn_3 () ;
} else if ( vr_9 == 0 ) {
return;
}
synchronized ( this ) {
final int vr_1 = vl_3 + vr_9 ;
int vr_10 = vr_9 ;
int vr_11 = vl_3 - vl_2 ;
while ( vr_10 > 0 ) {
final int vr_12 = vr_5 . vr_13 ( vr_10 , vr_3 . length - vr_11 ) ;
System . vr_14 ( vr_7 , vr_8 + vr_9 - vr_10 , vr_3 , vr_11 , vr_12 ) ;
vr_10 -= vr_12 ;
if ( vr_10 > 0 ) {
fn_1 ( vr_1 ) ;
vr_11 = 0 ;
}
}
vl_3 = vr_1 ;
}
}
@Override
public synchronized void fn_2 ( final int vr_7 ) {
int vr_11 = vl_3 - vl_2 ;
if ( vr_11 == vr_3 . length ) {
fn_1 ( vl_3 + 1 ) ;
vr_11 = 0 ;
}
vr_3 [ vr_11 ] = ( byte ) vr_7 ;
vl_3 ++ ;
}
public synchronized int fn_2 ( final tp_1 vr_15 ) throws IOException {
int vr_16 = 0 ;
int vr_11 = vl_3 - vl_2 ;
int vr_17 = vr_15 . vr_18 ( vr_3 , vr_11 , vr_3 . length - vr_11 ) ;
while ( vr_17 != vl_4 ) {
vr_16 += vr_17 ;
vr_11 += vr_17 ;
vl_3 += vr_17 ;
if ( vr_11 == vr_3 . length ) {
fn_1 ( vr_3 . length ) ;
vr_11 = 0 ;
}
vr_17 = vr_15 . vr_18 ( vr_3 , vr_11 , vr_3 . length - vr_11 ) ;
}
return vr_16 ;
}
public synchronized int size () {
return vl_3 ;
}
@Override
public void fn_4 () throws IOException {
}
public synchronized void fn_5 () {
vl_3 = 0 ;
vl_2 = 0 ;
vl_1 = 0 ;
if ( vl_5 ) {
vr_3 = vr_2 . get ( vl_1 ) ;
} else {
vr_3 = null ;
final int size = vr_2 . get ( 0 ) . length ;
vr_2 . clear () ;
fn_1 ( size ) ;
vl_5 = true ;
}
}
public synchronized void fn_6 ( final tp_2 out ) throws IOException {
int vr_10 = vl_3 ;
for ( final byte [] vr_19 : vr_2 ) {
final int vr_20 = vr_5 . vr_13 ( vr_19 . length , vr_10 ) ;
out . fn_2 ( vr_19 , 0 , vr_20 ) ;
vr_10 -= vr_20 ;
if ( vr_10 == 0 ) {
break;
}
}
}
public static tp_1 fn_7 ( final tp_1 vr_21 )
throws IOException {
return fn_7 ( vr_21 , 1024 ) ;
}
public static tp_1 fn_7 ( final tp_1 vr_21 , final int size )
throws IOException {
@SuppressWarnings ( lr_1 )
final tp_3 vr_22 = new tp_3 ( size ) ;
vr_22 . fn_2 ( vr_21 ) ;
return vr_22 . vr_23 () ;
}
public synchronized tp_1 vr_23 () {
int vr_10 = vl_3 ;
if ( vr_10 == 0 ) {
return new fn_8 () ;
}
final List < vt_1 > list = new ArrayList <> ( vr_2 . size () ) ;
for ( final byte [] vr_19 : vr_2 ) {
final int vr_20 = vr_5 . vr_13 ( vr_19 . length , vr_10 ) ;
list . add ( new vt_1 ( vr_19 , 0 , vr_20 ) ) ;
vr_10 -= vr_20 ;
if ( vr_10 == 0 ) {
break;
}
}
vl_5 = false ;
return new fn_9 ( vr_24 . enumeration ( list ) ) ;
}
public synchronized byte [] fn_10 () {
int vr_10 = vl_3 ;
if ( vr_10 == 0 ) {
return vl_6 ;
}
final byte vr_25 [] = new byte [ vr_10 ] ;
int vr_26 = 0 ;
for ( final byte [] vr_19 : vr_2 ) {
final int vr_20 = vr_5 . vr_13 ( vr_19 . length , vr_10 ) ;
System . vr_14 ( vr_19 , 0 , vr_25 , vr_26 , vr_20 ) ;
vr_26 += vr_20 ;
vr_10 -= vr_20 ;
if ( vr_10 == 0 ) {
break;
}
}
return vr_25 ;
}
@Override
@Deprecated
public String toString () {
return new String ( fn_10 () , vr_27 . vr_28 () ) ;
}
public String toString ( final String vr_29 ) throws vl_7 {
return new String ( fn_10 () , vr_29 ) ;
}
public String toString ( final vr_27 vr_30 ) {
return new String ( fn_10 () , vr_30 ) ;
}
