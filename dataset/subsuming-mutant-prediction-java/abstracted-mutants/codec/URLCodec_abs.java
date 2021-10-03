public static final byte [] fn_1 ( tp_1 vr_1 , final byte [] vr_2 ) {
if ( vr_2 == null ) {
return null ;
}
if ( vr_1 == null ) {
vr_1 = vl_1 ;
}
final tp_2 vr_3 = new tp_2 () ;
for ( final byte vr_4 : vr_2 ) {
int vr_5 = vr_4 ;
if ( vr_5 < 0 ) {
vr_5 = 256 + vr_5 ;
}
if ( vr_1 . get ( vr_5 ) ) {
if ( vr_5 == ' ' ) {
vr_5 = '+' ;
}
vr_3 . vr_6 ( vr_5 ) ;
} else {
vr_3 . vr_6 ( vl_2 ) ;
final char vr_7 = vr_8 . vr_9 ( vr_5 >> 4 ) ;
final char vr_10 = vr_8 . vr_9 ( vr_5 ) ;
vr_3 . vr_6 ( vr_7 ) ;
vr_3 . vr_6 ( vr_10 ) ;
}
}
return vr_3 . vr_11 () ;
}
public static final byte [] fn_2 ( final byte [] vr_2 ) throws vl_3 {
if ( vr_2 == null ) {
return null ;
}
final tp_2 vr_3 = new tp_2 () ;
for ( int vr_12 = 0 ; vr_12 < vr_2 . length ; vr_12 ++ ) {
final int vr_5 = vr_2 [ vr_12 ] ;
if ( vr_5 == '+' ) {
vr_3 . vr_6 ( ' ' ) ;
} else if ( vr_5 == vl_2 ) {
try {
final int vr_13 = vr_8 . vr_14 ( vr_2 [ ++ vr_12 ] ) ;
final int vr_15 = vr_8 . vr_14 ( vr_2 [ ++ vr_12 ] ) ;
vr_3 . vr_6 ( (char) ( ( vr_13 << 4 ) + vr_15 ) ) ;
} catch ( final tp_3 vr_16 ) {
throw new vl_3 ( lr_1 , vr_16 ) ;
}
} else {
vr_3 . vr_6 ( vr_5 ) ;
}
}
return vr_3 . vr_11 () ;
}
@Override
public byte [] fn_3 ( final byte [] vr_2 ) {
return fn_1 ( vl_1 , vr_2 ) ;
}
@Override
public byte [] fn_4 ( final byte [] vr_2 ) throws vl_3 {
return fn_2 ( vr_2 ) ;
}
public String fn_3 ( final String vr_17 , final String vr_18 ) throws vl_4 {
if ( vr_17 == null ) {
return null ;
}
return vr_19 . vr_20 ( fn_3 ( vr_17 . vr_21 ( vr_18 ) ) ) ;
}
@Override
public String fn_3 ( final String vr_17 ) throws vl_5 {
if ( vr_17 == null ) {
return null ;
}
try {
return fn_3 ( vr_17 , fn_5 () ) ;
} catch ( final vl_4 vr_16 ) {
throw new vl_5 ( vr_16 . vr_22 () , vr_16 ) ;
}
}
public String fn_4 ( final String vr_17 , final String vr_18 )
throws vl_3 , vl_4 {
if ( vr_17 == null ) {
return null ;
}
return new String ( fn_4 ( vr_19 . vr_23 ( vr_17 ) ) , vr_18 ) ;
}
@Override
public String fn_4 ( final String vr_17 ) throws vl_3 {
if ( vr_17 == null ) {
return null ;
}
try {
return fn_4 ( vr_17 , fn_5 () ) ;
} catch ( final vl_4 vr_16 ) {
throw new vl_3 ( vr_16 . vr_22 () , vr_16 ) ;
}
}
@Override
public Object fn_3 ( final Object vr_24 ) throws vl_5 {
if ( vr_24 == null ) {
return null ;
} else if ( vr_24 instanceof byte [] ) {
return fn_3 ( ( byte [] ) vr_24 ) ;
} else if ( vr_24 instanceof String ) {
return fn_3 ( ( String ) vr_24 ) ;
} else {
throw new vl_5 ( lr_2 + vr_24 . getClass () . fn_6 () + lr_3 ) ;
}
}
@Override
public Object fn_4 ( final Object vr_24 ) throws vl_3 {
if ( vr_24 == null ) {
return null ;
} else if ( vr_24 instanceof byte [] ) {
return fn_4 ( ( byte [] ) vr_24 ) ;
} else if ( vr_24 instanceof String ) {
return fn_4 ( ( String ) vr_24 ) ;
} else {
throw new vl_3 ( lr_2 + vr_24 . getClass () . fn_6 () + lr_4 ) ;
}
}
public String fn_5 () {
return this . vr_25 ;
}
@Deprecated
public String fn_7 () {
return this . vr_25 ;
}
