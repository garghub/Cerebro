private boolean fn_1 ( final char [] vr_1 ) {
for( final char vr_2 : vr_1 ) {
if ( vr_2 == vl_1 ) {
return true ;
}
}
return false ;
}
public int fn_2 ( final String vr_3 , final String vr_4 ) throws vl_2 {
return vr_5 . fn_2 ( this , vr_3 , vr_4 ) ;
}
@Override
public Object fn_3 ( final Object vr_6 ) throws vl_2 {
if ( ! ( vr_6 instanceof String ) ) {
throw new vl_2 ( lr_1 ) ;
}
return fn_4 ( ( String ) vr_6 ) ;
}
@Override
public String fn_3 ( final String vr_7 ) {
return fn_4 ( vr_7 ) ;
}
@Deprecated
public int fn_5 () {
return this . vr_8 ;
}
private char fn_6 ( final char vr_2 ) {
final int vr_9 = vr_2 - 'A' ;
if ( vr_9 < 0 || vr_9 >= this . vr_10 . length ) {
throw new IllegalArgumentException ( lr_2 + vr_2 + lr_3 + vr_9 + lr_4 ) ;
}
return this . vr_10 [ vr_9 ] ;
}
@Deprecated
public void fn_7 ( final int vr_8 ) {
this . vr_8 = vr_8 ;
}
public String fn_4 ( String vr_7 ) {
if ( vr_7 == null ) {
return null ;
}
vr_7 = vr_5 . vr_11 ( vr_7 ) ;
if ( vr_7 . length () == 0 ) {
return vr_7 ;
}
final char out [] = { '0' , '0' , '0' , '0' } ;
int vr_12 = 0 ;
final char vr_13 = vr_7 . charAt ( 0 ) ;
out [ vr_12 ++ ] = vr_13 ;
char vr_14 = fn_6 ( vr_13 ) ;
for( int vr_15 = 1 ; vr_15 < vr_7 . length () && vr_12 < out . length ; vr_15 ++ ) {
final char vr_2 = vr_7 . charAt ( vr_15 ) ;
if ( ( this . vr_16 ) && ( vr_2 == 'H' || vr_2 == 'W' ) ) {
continue;
}
final char vr_17 = fn_6 ( vr_2 ) ;
if ( vr_17 == vl_1 ) {
continue;
}
if ( vr_17 != '0' && vr_17 != vr_14 ) {
out [ vr_12 ++ ] = vr_17 ;
}
vr_14 = vr_17 ;
}
return new String ( out ) ;
}
