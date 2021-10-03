private void fn_1 () throws vl_1 {
this . vr_1 . vr_2 () ;
final tp_1 vr_3 = this . vr_4 . vr_5 ( this . vr_6 , this . vr_1 , true ) ;
if ( vr_3 . vr_7 () ) {
vr_3 . vr_8 () ;
}
this . vr_1 . vr_9 () ;
}
@Override
public int fn_2 ( final byte [] vr_10 , int vr_11 , int vr_12 ) throws IOException {
if ( vr_10 == null ) {
throw new fn_3 ( lr_1 ) ;
}
if ( vr_12 < 0 || ( vr_11 + vr_12 ) > vr_10 . length ) {
throw new fn_4 ( lr_2 + vr_10 . length +
lr_3 + vr_11 + lr_4 + vr_12 ) ;
}
if ( vr_12 == 0 ) {
return 0 ;
}
if ( ! this . vr_1 . vr_13 () && ! this . vr_6 . vr_13 () ) {
return vl_2 ;
}
int vr_14 = 0 ;
while ( vr_12 > 0 ) {
if ( this . vr_1 . vr_13 () ) {
final int vr_15 = vr_16 . vr_17 ( this . vr_1 . vr_18 () , vr_12 ) ;
this . vr_1 . get ( vr_10 , vr_11 , vr_15 ) ;
vr_11 += vr_15 ;
vr_12 -= vr_15 ;
vr_14 += vr_15 ;
} else {
fn_1 () ;
if ( ! this . vr_1 . vr_13 () && ! this . vr_6 . vr_13 () ) {
break;
}
}
}
return vr_14 == 0 && ! this . vr_6 . vr_13 () ? vl_2 : vr_14 ;
}
@Override
public int fn_2 () throws IOException {
for (; ; ) {
if ( this . vr_1 . vr_13 () ) {
return this . vr_1 . get () & 0xFF ;
}
fn_1 () ;
if ( ! this . vr_1 . vr_13 () && ! this . vr_6 . vr_13 () ) {
return vl_2 ;
}
}
}
@Override
public int fn_2 ( final byte [] vr_10 ) throws IOException {
return fn_2 ( vr_10 , 0 , vr_10 . length ) ;
}
@Override
public long fn_5 ( long vr_19 ) throws IOException {
long vr_20 = 0 ;
while ( vr_19 > 0 && fn_6 () > 0 ) { MST[rv.UOI3Mutator]MSP[N]
this . fn_2 () ;
vr_19 -- ;
vr_20 ++ ;
}
return vr_20 ;
}
@Override
public int fn_6 () throws IOException {
return this . vr_1 . vr_18 () + this . vr_6 . vr_18 () ;
}
@Override
public void fn_7 () throws IOException {
}
@Override
public synchronized void fn_8 ( final int vr_21 ) {
this . vr_22 = this . vr_6 . vr_23 () ;
this . vr_24 = this . vr_1 . vr_23 () ;
this . vr_6 . fn_8 () ;
this . vr_1 . fn_8 () ;
}
@Override
public synchronized void fn_9 () throws IOException {
if ( this . vr_22 != vl_3 ) {
if ( this . vr_6 . vr_23 () != 0 ) {
this . vr_4 . fn_9 () ;
this . vr_6 . rewind () ;
this . vr_1 . rewind () ;
this . vr_1 . vr_25 ( 0 ) ;
while( this . vr_6 . vr_23 () < this . vr_22 ) {
this . vr_1 . rewind () ;
this . vr_1 . vr_25 ( 0 ) ;
fn_1 () ;
}
}
if ( this . vr_6 . vr_23 () != this . vr_22 ) {
throw new fn_10 ( lr_5 + vr_6 . vr_23 () + lr_6 +
lr_7 + this . vr_22 ) ;
}
this . vr_1 . vr_23 ( this . vr_24 ) ;
this . vr_22 = vl_3 ;
this . vr_24 = vl_3 ;
}
}
@Override
public boolean fn_11 () {
return true ;
}
