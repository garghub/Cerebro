private int fn_1 ( final int vr_1 , final int vr_2 ) {
if ( vl_1 != null ) {
return vl_1 . vr_3 ( vr_2 - vr_1 + 1 ) + vr_1 ;
}
return vr_4 . vr_5 () . vr_3 ( vr_1 , vr_2 + 1 ) ;
}
private int fn_1 ( final List < vt_1 > vr_6 ) {
final int vr_7 = vr_6 . size () ;
if ( vl_1 != null ) {
return String . valueOf ( vr_6 . get ( vl_1 . vr_3 ( vr_7 ) ) ) . fn_2 ( 0 ) ;
}
return String . valueOf ( vr_6 . get ( vr_4 . vr_5 () . vr_3 ( 0 , vr_7 ) ) ) . fn_2 ( 0 ) ;
}
public String fn_3 ( final int length ) {
if ( length == 0 ) {
return lr_1 ;
}
vr_8 . vr_9 ( length > 0 , lr_2 , length ) ;
final StringBuilder builder = new StringBuilder ( length ) ;
long vr_10 = length ;
do {
int vr_11 ;
if ( vr_6 != null && ! vr_6 . isEmpty () ) {
vr_11 = fn_1 ( vr_6 ) ;
} else {
vr_11 = fn_1 ( vl_2 , vl_3 ) ;
}
switch ( vt_1 . getType ( vr_11 ) ) {
case vt_1 . vr_12 :
case vt_1 . vr_13 :
case vt_1 . vr_14 :
continue;
default:
}
if ( vl_4 != null ) {
boolean vr_15 = false ;
for ( final tp_1 vr_16 : vl_4 ) {
if ( vr_16 . vr_17 ( vr_11 ) ) {
vr_15 = true ;
break;
}
}
if ( ! vr_15 ) {
continue;
}
}
builder . vr_18 ( vr_11 ) ;
vr_10 -- ;
} while ( vr_10 != 0 );
return builder . toString () ;
}
public String fn_3 ( final int vr_19 , final int vr_20 ) {
vr_8 . vr_9 ( vr_19 >= 0 , lr_3 , vr_19 ) ;
vr_8 . vr_9 ( vr_19 <= vr_20 ,
lr_4 , vr_20 , vr_19 ) ;
return fn_3 ( fn_1 ( vr_19 , vr_20 ) ) ;
}
public Builder fn_4 ( final int vl_2 , final int vl_3 ) {
vr_8 . vr_9 ( vl_2 <= vl_3 ,
lr_5 , vl_2 , vl_3 ) ;
vr_8 . vr_9 ( vl_2 >= 0 , lr_6 , vl_2 ) ;
vr_8 . vr_9 ( vl_3 <= vt_1 . vr_21 ,
lr_7 , vl_3 ) ;
this . vl_2 = vl_2 ;
this . vl_3 = vl_3 ;
return this ;
}
public Builder fn_4 ( final char [] ... vr_22 ) {
vr_6 = new ArrayList <> () ;
for ( final char [] vr_23 : vr_22 ) {
vr_8 . vr_9 ( vr_23 . length == 2 ,
lr_8 ) ;
final int vl_2 = vr_23 [ 0 ] ;
final int vl_3 = vr_23 [ 1 ] ;
vr_8 . vr_9 ( vl_2 <= vl_3 ,
lr_5 , vl_2 , vl_3 ) ;
for ( int vr_24 = vl_2 ; vr_24 <= vl_3 ; vr_24 ++ ) {
vr_6 . add ( ( char ) vr_24 ) ;
}
}
return this ;
}
public Builder fn_5 ( final tp_1 ... vr_25 ) {
if ( vr_25 == null || vr_25 . length == 0 ) {
vl_4 = null ;
return this ;
}
if ( vl_4 == null ) {
vl_4 = new vr_26 <> () ;
} else {
vl_4 . clear () ;
}
vr_27 . vr_28 ( vl_4 , vr_25 ) ;
return this ;
}
public Builder fn_6 ( final tp_2 vl_1 ) {
this . vl_1 = vl_1 ;
return this ;
}
public Builder fn_7 ( final char ... vr_29 ) {
vr_6 = new ArrayList <> () ;
for ( final char vr_30 : vr_29 ) {
vr_6 . add ( vr_30 ) ;
}
return this ;
}
@Override
public tp_3 fn_8 () {
return new tp_3 ( vl_2 , vl_3 , vl_4 ,
vl_1 , vr_6 ) ;
}
