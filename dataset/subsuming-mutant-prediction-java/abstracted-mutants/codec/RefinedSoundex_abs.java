public int fn_1 ( final String vr_1 , final String vr_2 ) throws vl_1 {
return vr_3 . fn_1 ( this , vr_1 , vr_2 ) ;
}
@Override
public Object fn_2 ( final Object vr_4 ) throws vl_1 {
if ( ! ( vr_4 instanceof String ) ) {
throw new vl_1 ( lr_1 ) ;
}
return fn_3 ( ( String ) vr_4 ) ;
}
@Override
public String fn_2 ( final String vr_5 ) {
return fn_3 ( vr_5 ) ;
}
char fn_4 ( final char vr_6 ) {
if ( ! vr_7 . vr_8 ( vr_6 ) ) {
return 0 ;
}
return this . vr_9 [ vr_7 . vr_10 ( vr_6 ) - 'A' ] ;
}
public String fn_3 ( String vr_5 ) {
if ( vr_5 == null ) {
return null ;
}
vr_5 = vr_3 . vr_11 ( vr_5 ) ;
if ( vr_5 . length () == 0 ) {
return vr_5 ;
}
final StringBuilder vr_12 = new StringBuilder () ;
vr_12 . append ( vr_5 . charAt ( 0 ) ) ;
char vr_13 , vr_14 ;
vr_13 = '*' ;
for ( int vr_15 = 0 ; vr_15 < vr_5 . length () ; vr_15 ++ ) {
vr_14 = fn_4 ( vr_5 . charAt ( vr_15 ) ) ;
if ( vr_14 == vr_13 ) {
continue;
} else if ( vr_14 != 0 ) {
vr_12 . append ( vr_14 ) ;
}
vr_13 = vr_14 ;
}
return vr_12 . toString () ;
}
