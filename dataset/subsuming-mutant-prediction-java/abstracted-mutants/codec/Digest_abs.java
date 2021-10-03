public static void main ( final String [] args ) throws IOException {
new fn_1 ( args ) . fn_2 () ;
}
private void println ( final String vr_1 , final byte [] vr_2 ) {
println ( vr_1 , vr_2 , null ) ;
}
private void println ( final String vr_1 , final byte [] vr_2 , final String vr_3 ) {
System . out . println ( vr_1 + vr_4 . vr_5 ( vr_2 ) + ( vr_3 != null ? lr_1 + vr_3 : lr_2 ) ) ;
}
private void fn_2 () throws IOException {
if ( vr_6 . equalsIgnoreCase ( lr_3 ) || vr_6 . equals ( lr_4 ) ) {
fn_2 ( vr_7 . vr_8 () ) ;
return;
}
final tp_1 vr_9 = vr_10 . vr_11 ( vr_6 , null ) ;
if ( vr_9 != null ) {
fn_2 ( lr_2 , vr_9 ) ;
} else {
fn_2 ( lr_2 , vr_10 . vr_11 ( vr_6 . vr_12 ( vr_13 . vr_14 ) ) ) ;
}
}
private void fn_2 ( final String [] vr_15 ) throws IOException {
for ( final String vr_16 : vr_15 ) {
if ( vr_10 . vr_17 ( vr_16 ) ) {
fn_2 ( vr_16 + lr_5 , vr_16 ) ;
}
}
}
private void fn_2 ( final String vr_1 , final tp_1 vr_9 ) throws IOException {
if ( vl_1 == null ) {
println ( vr_1 , vr_10 . vr_2 ( vr_9 , System . vr_18 ) ) ;
return;
}
for ( final String vr_19 : vl_1 ) {
final tp_2 vr_20 = new tp_2 ( vr_19 ) ;
if ( vr_20 . vr_21 () ) {
println ( vr_1 , vr_10 . vr_2 ( vr_9 , vr_20 ) , vr_19 ) ;
} else if ( vr_20 . vr_22 () ) {
final tp_2 [] vr_23 = vr_20 . vr_23 () ;
if ( vr_23 != null ) {
fn_2 ( vr_1 , vr_9 , vr_23 ) ;
}
} else {
final byte [] vr_24 = vr_19 . vr_25 ( vr_26 . vr_27 () ) ;
println ( vr_1 , vr_10 . vr_2 ( vr_9 , vr_24 ) ) ;
}
}
}
private void fn_2 ( final String vr_1 , final tp_1 vr_9 , final tp_2 [] vr_28 ) throws IOException {
for ( final tp_2 vr_20 : vr_28 ) {
if ( vr_20 . vr_21 () ) {
println ( vr_1 , vr_10 . vr_2 ( vr_9 , vr_20 ) , vr_20 . vr_29 () ) ;
}
}
}
private void fn_2 ( final String vr_1 , final String vr_16 ) throws IOException {
fn_2 ( vr_1 , vr_10 . vr_11 ( vr_16 ) ) ;
}
@Override
public String toString () {
return String . vr_30 ( lr_6 , super . toString () , vr_31 . toString ( args ) ) ;
}
