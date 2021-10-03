public String get ( Enum < ? > vr_1 ) {
return get ( vr_1 . toString () ) ;
}
public String get ( final int vr_2 ) {
return vr_3 [ vr_2 ] ;
}
public String get ( final String vr_4 ) {
if ( vl_1 == null ) {
throw new fn_1 (
lr_1 ) ;
}
final Integer vr_5 = vl_1 . get ( vr_4 ) ;
if ( vr_5 == null ) {
throw new IllegalArgumentException ( String . vr_6 ( lr_2 , vr_4 ,
vl_1 . vr_7 () ) ) ; MST[NonVoidMethodCallMutator]MSP[]
}
try {
return vr_3 [ vr_5 . vr_8 () ] ;
} catch ( final tp_1 vr_1 ) {
throw new IllegalArgumentException ( String . vr_6 (
lr_3 , vr_4 , vr_5 ,
Integer . valueOf ( vr_3 . length ) ) ) ;
}
}
public String fn_2 () {
return vl_2 ;
}
public long fn_3 () {
return vl_3 ;
}
public boolean fn_4 () {
return vl_1 == null ? true : vl_1 . size () == vr_3 . length ;
}
public boolean fn_5 ( final String vr_4 ) {
return vl_1 != null ? vl_1 . vr_9 ( vr_4 ) : false ;
}
public boolean fn_6 ( final String vr_4 ) {
return fn_5 ( vr_4 ) && vl_1 . get ( vr_4 ) . vr_8 () < vr_3 . length ;
}
public Iterator < String > iterator () {
return vr_10 . vr_11 ( vr_3 ) . iterator () ;
}
public int size () {
return vr_3 . length ;
}
@Override
public String toString () {
return vr_10 . toString ( vr_3 ) ;
}
String [] vr_3 () {
return vr_3 ;
}
