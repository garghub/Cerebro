public final String fn_1 ( final tp_1 vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
try {
final tp_2 vr_2 = new tp_2 ( vr_1 . length () * 2 ) ;
fn_1 ( vr_1 , vr_2 ) ;
return vr_2 . toString () ;
} catch ( final IOException vr_3 ) {
throw new fn_2 ( vr_3 ) ;
}
}
public final void fn_1 ( final tp_1 vr_1 , final tp_3 out ) throws IOException {
if ( out == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_1 == null ) {
return;
}
int vr_4 = 0 ;
final int vr_5 = vr_1 . length () ;
while ( vr_4 < vr_5 ) {
final int vr_6 = fn_1 ( vr_1 , vr_4 , out ) ;
if ( vr_6 == 0 ) {
char vr_7 = vr_1 . charAt ( vr_4 ) ;
out . vr_8 ( vr_7 ) ;
vr_4 ++ ;
if ( vr_9 . vr_10 ( vr_7 ) && vr_4 < vr_5 ) {
char vr_11 = vr_1 . charAt ( vr_4 ) ;
if ( vr_9 . vr_12 ( vr_11 ) ) {
out . vr_8 ( vr_11 ) ;
vr_4 ++ ;
}
}
continue;
}
for ( int vr_13 = 0 ; vr_13 < vr_6 ; vr_13 ++ ) {
vr_4 += vr_9 . vr_14 ( vr_9 . vr_15 ( vr_1 , vr_4 ) ) ;
}
}
}
public final tp_4 fn_3 ( final tp_4 ... vr_16 ) {
final tp_4 [] vr_17 = new tp_4 [ vr_16 . length + 1 ] ;
vr_17 [ 0 ] = this ;
System . vr_18 ( vr_16 , 0 , vr_17 , 1 , vr_16 . length ) ;
return new fn_4 ( vr_17 ) ;
}
public static String fn_5 ( final int vr_19 ) {
return Integer . vr_20 ( vr_19 ) . fn_6 ( vr_21 . vr_22 ) ;
}
