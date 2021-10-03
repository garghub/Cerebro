public static tp_1 fn_1 ( tp_2 vr_1 , final tp_3 vr_2 ) throws IOException {
vr_3 . vr_4 ( vr_1 , lr_1 ) ;
vr_3 . vr_4 ( vr_2 , lr_2 ) ;
return new tp_1 ( new fn_2 ( vr_1 ) , vr_2 ) ;
}
public static tp_1 fn_1 ( String string , final tp_3 vr_2 ) throws IOException {
vr_3 . vr_4 ( string , lr_3 ) ;
vr_3 . vr_4 ( vr_2 , lr_2 ) ;
return new tp_1 ( new fn_3 ( string ) , vr_2 ) ;
}
public static tp_1 fn_1 ( tp_4 vr_5 , tp_5 vr_6 , final tp_3 vr_2 ) throws IOException {
vr_3 . vr_4 ( vr_5 , lr_4 ) ;
vr_3 . vr_4 ( vr_6 , lr_5 ) ;
vr_3 . vr_4 ( vr_2 , lr_2 ) ;
return new tp_1 ( new fn_4 ( vr_5 . vr_7 () ,
vr_6 == null ? tp_5 . vr_8 ( lr_6 ) : vr_6 ) , vr_2 ) ;
}
private void fn_5 () {
final String vr_9 = this . vr_10 . vr_11 . toString () ;
final String vr_12 = this . vr_2 . vr_13 () ;
if ( vr_12 == null ) {
this . vr_14 . add ( vr_9 ) ;
} else {
this . vr_14 . add ( vr_9 . equalsIgnoreCase ( vr_12 ) ? null : vr_9 ) ;
}
}
public void fn_6 () throws IOException {
if ( this . vr_15 != null ) {
this . vr_15 . fn_6 () ;
}
}
public long fn_7 () {
return this . vr_15 . fn_7 () ;
}
public vr_16 < String , Integer > fn_8 () {
return this . vr_17 == null ? null : new vr_18 < String , Integer > ( this . vr_17 ) ;
}
public long fn_9 () {
return this . vr_19 ;
}
public List < vt_1 > fn_10 () throws IOException {
final List < vt_1 > vr_20 = new ArrayList < vt_1 > () ;
vt_1 vr_21 ;
while ( ( vr_21 = this . vr_22 () ) != null ) {
vr_20 . add ( vr_21 ) ;
}
return vr_20 ;
}
private vr_16 < String , Integer > fn_11 () throws IOException {
vr_16 < String , Integer > vr_23 = null ;
final String [] vr_24 = this . vr_2 . vr_25 () ;
if ( vr_24 != null ) {
vr_23 = new vr_18 < String , Integer > () ; MST[ConstructorCallMutator]MSP[N]
String [] vr_26 = null ;
if ( vr_24 . length == 0 ) {
final vt_1 vr_14 = this . vr_22 () ;
if ( vr_14 != null ) {
vr_26 = vr_14 . vr_27 () ;
}
} else {
if ( this . vr_2 . vr_28 () ) {
this . vr_22 () ;
}
vr_26 = vr_24 ;
}
if ( vr_26 != null ) {
for ( int vr_29 = 0 ; vr_29 < vr_26 . length ; vr_29 ++ ) {
vr_23 . vr_30 ( vr_26 [ vr_29 ] , Integer . valueOf ( vr_29 ) ) ;
}
}
}
return vr_23 ;
}
public boolean fn_12 () {
return this . vr_15 . fn_12 () ;
}
private vt_1 fn_13 () {
try {
return tp_1 . this . vr_22 () ;
} catch ( final IOException vr_31 ) {
throw new fn_14 ( vr_31 ) ;
}
}
public boolean hasNext () {
if ( tp_1 . this . fn_12 () ) {
return false ;
}
if ( this . vr_32 == null ) {
this . vr_32 = this . fn_13 () ;
}
return this . vr_32 != null ;
}
public vt_1 fn_15 () {
if ( tp_1 . this . fn_12 () ) {
throw new fn_16 ( lr_7 ) ;
}
vt_1 fn_15 = this . vr_32 ;
this . vr_32 = null ;
if ( fn_15 == null ) {
fn_15 = this . fn_13 () ;
if ( fn_15 == null ) {
throw new fn_16 ( lr_8 ) ;
}
}
return fn_15 ;
}
public void remove () {
throw new fn_17 () ;
}
vt_1 vr_22 () throws IOException {
vt_1 vr_33 = null ;
this . vr_14 . clear () ;
StringBuilder vr_34 = null ;
do {
this . vr_10 . vr_35 () ;
this . vr_15 . vr_36 ( this . vr_10 ) ;
switch ( this . vr_10 . type ) {
case vl_1 :
this . fn_5 () ;
break;
case vl_2 :
this . fn_5 () ;
break;
case vl_3 :
if ( this . vr_10 . vr_37 ) {
this . fn_5 () ;
}
break;
case vl_4 :
throw new IOException ( lr_9 + this . fn_7 () + lr_10 ) ;
case vl_5 :
if ( vr_34 == null ) {
vr_34 = new StringBuilder () ;
} else {
vr_34 . append ( vr_38 . vr_39 ) ;
}
vr_34 . append ( this . vr_10 . vr_11 ) ;
this . vr_10 . type = vl_1 ;
break;
}
} while ( this . vr_10 . type == vl_1 );
if ( ! this . vr_14 . isEmpty () ) {
this . vr_19 ++ ;
final String vr_40 = vr_34 == null ? null : vr_34 . toString () ;
vr_33 = new vt_1 ( this . vr_14 . toArray ( new String [ this . vr_14 . size () ] ) , this . vr_17 , vr_40 ,
this . vr_19 ) ;
}
return vr_33 ;
}
