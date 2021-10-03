@Override
protected String fn_1 () {
return lr_1 ;
}
@Override
protected byte [] fn_2 ( final byte [] vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
final byte [] vr_2 = vr_3 . vr_4 ( vl_1 , vr_1 ) ;
if ( this . vr_5 ) {
for ( int vr_6 = 0 ; vr_6 < vr_2 . length ; vr_6 ++ ) {
if ( vr_2 [ vr_6 ] == vl_2 ) {
vr_2 [ vr_6 ] = vl_3 ;
}
}
}
return vr_2 ;
}
@Override
protected byte [] fn_3 ( final byte [] vr_1 ) throws vl_4 {
if ( vr_1 == null ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
return null ;
}
boolean vr_7 = false ;
for ( final byte vr_8 : vr_1 ) {
if ( vr_8 == vl_3 ) {
vr_7 = true ;
break;
}
}
if ( vr_7 ) {
final byte [] vr_9 = new byte [ vr_1 . length ] ;
for ( int vr_6 = 0 ; vr_6 < vr_1 . length ; vr_6 ++ ) {
final byte vr_8 = vr_1 [ vr_6 ] ;
if ( vr_8 != vl_3 ) {
vr_9 [ vr_6 ] = vr_8 ;
} else {
vr_9 [ vr_6 ] = vl_2 ;
}
}
return vr_3 . vr_10 ( vr_9 ) ;
}
return vr_3 . vr_10 ( vr_1 ) ;
}
public String fn_4 ( final String vr_11 , final tp_1 vr_12 ) throws vl_5 {
if ( vr_11 == null ) {
return null ;
}
return fn_5 ( vr_11 , vr_12 ) ;
}
public String fn_4 ( final String vr_11 , final String vr_12 ) throws vl_5 {
if ( vr_11 == null ) {
return null ;
}
try {
return fn_5 ( vr_11 , vr_12 ) ;
} catch ( final tp_2 vr_13 ) {
throw new vl_5 ( vr_13 . vr_14 () , vr_13 ) ;
}
}
@Override
public String fn_4 ( final String vr_11 ) throws vl_5 {
if ( vr_11 == null ) {
return null ;
}
return fn_4 ( vr_11 , fn_6 () ) ;
}
@Override
public String fn_7 ( final String vr_15 ) throws vl_4 {
if ( vr_15 == null ) {
return null ;
}
try {
return fn_8 ( vr_15 ) ;
} catch ( final tp_2 vr_13 ) {
throw new vl_4 ( vr_13 . vr_14 () , vr_13 ) ;
}
}
@Override
public Object fn_4 ( final Object vr_16 ) throws vl_5 {
if ( vr_16 == null ) {
return null ;
} else if ( vr_16 instanceof String ) {
return fn_4 ( ( String ) vr_16 ) ;
} else {
throw new vl_5 ( lr_2 +
vr_16 . getClass () . fn_9 () +
lr_3 ) ;
}
}
@Override
public Object fn_7 ( final Object vr_16 ) throws vl_4 {
if ( vr_16 == null ) {
return null ;
} else if ( vr_16 instanceof String ) {
return fn_7 ( ( String ) vr_16 ) ;
} else {
throw new vl_4 ( lr_2 +
vr_16 . getClass () . fn_9 () +
lr_4 ) ;
}
}
public tp_1 fn_6 () {
return this . vr_17 ;
}
public String fn_10 () {
return this . vr_17 . vr_18 () ;
}
public boolean fn_11 () {
return this . vr_5 ;
}
public void fn_12 ( final boolean vr_8 ) {
this . vr_5 = vr_8 ;
}
