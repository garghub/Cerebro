public void println () throws IOException {
out . append ( vr_1 . vr_2 () ) ;
vl_1 = true ;
}
public void fn_1 () throws IOException {
if ( out instanceof vl_2 ) {
( ( vl_2 ) out ) . fn_1 () ;
}
}
public void fn_2 ( final Object ... vr_3 ) throws IOException {
for ( final Object vr_4 : vr_3 ) {
fn_3 ( vr_4 ) ;
}
println () ;
}
public void fn_2 ( final vr_5 < ? > vr_3 ) throws IOException {
for ( final Object vr_4 : vr_3 ) {
fn_3 ( vr_4 ) ;
}
println () ;
}
public void fn_4 ( final String vr_6 ) throws IOException {
if ( ! vr_1 . vr_7 () ) {
return;
}
if ( ! vl_1 ) {
println () ;
}
out . append ( vr_1 . vr_8 () . fn_5 () ) ;
out . append ( vl_3 ) ;
for ( int vr_9 = 0 ; vr_9 < vr_6 . length () ; vr_9 ++ ) {
final char vr_10 = vr_6 . charAt ( vr_9 ) ;
switch ( vr_10 ) {
case vl_4 :
if ( vr_9 + 1 < vr_6 . length () && vr_6 . charAt ( vr_9 + 1 ) == vl_5 ) {
vr_9 ++ ;
}
case vl_5 :
println () ;
out . append ( vr_1 . vr_8 () . fn_5 () ) ;
out . append ( vl_3 ) ;
break;
default:
out . append ( vr_10 ) ;
break;
}
}
println () ;
}
private void fn_3 ( final Object object , final tp_1 vr_4 ,
final int vr_11 , final int vr_12 ) throws IOException {
if ( ! vl_1 ) {
out . append ( vr_1 . vr_13 () ) ;
}
if ( vr_1 . vr_14 () ) {
fn_6 ( object , vr_4 , vr_11 , vr_12 ) ;
} else if ( vr_1 . vr_15 () ) {
fn_7 ( vr_4 , vr_11 , vr_12 ) ;
} else {
out . append ( vr_4 , vr_11 , vr_11 + vr_12 ) ;
}
vl_1 = false ;
}
private void fn_7 ( final tp_1 vr_4 , final int vr_11 , final int vr_12 ) throws IOException {
int vr_16 = vr_11 ;
int vr_17 = vr_11 ;
final int vr_18 = vr_11 + vr_12 ;
final char vr_19 = vr_1 . vr_13 () ;
final char vr_20 = vr_1 . vr_21 () . fn_5 () ;
while ( vr_17 < vr_18 ) {
char vr_10 = vr_4 . charAt ( vr_17 ) ;
if ( vr_10 == vl_4 || vr_10 == vl_5 || vr_10 == vr_19 || vr_10 == vr_20 ) { MST[NegateConditionalsMutator]MSP[]
if ( vr_17 > vr_16 ) {
out . append ( vr_4 , vr_16 , vr_17 ) ;
}
if ( vr_10 == vl_5 ) {
vr_10 = 'n' ;
} else if ( vr_10 == vl_4 ) {
vr_10 = 'r' ;
}
out . append ( vr_20 ) ;
out . append ( vr_10 ) ;
vr_16 = vr_17 + 1 ;
}
vr_17 ++ ;
}
if ( vr_17 > vr_16 ) {
out . append ( vr_4 , vr_16 , vr_17 ) ;
}
}
private void fn_6 ( final Object object , final tp_1 vr_4 ,
final int vr_11 , final int vr_12 ) throws IOException {
boolean vr_22 = false ;
int vr_16 = vr_11 ;
int vr_17 = vr_11 ;
final int vr_18 = vr_11 + vr_12 ;
final char vr_23 = vr_1 . vr_13 () ;
final char vr_24 = vr_1 . vr_25 () . fn_5 () ;
tp_2 vr_26 = vr_1 . vr_27 () ;
if ( vr_26 == null ) {
vr_26 = tp_2 . vr_28 ;
}
switch ( vr_26 ) {
case vl_6 :
vr_22 = true ;
break;
case vl_7 :
vr_22 = ! ( object instanceof vl_8 ) ;
break;
case vl_9 :
fn_7 ( vr_4 , vr_11 , vr_12 ) ;
return;
case vr_28 :
if ( vr_12 <= 0 ) {
if ( vl_1 ) {
vr_22 = true ;
}
} else {
char vr_10 = vr_4 . charAt ( vr_17 ) ;
if ( vl_1 && ( vr_10 < '0' || ( vr_10 > '9' && vr_10 < 'A' ) || ( vr_10 > 'Z' && vr_10 < 'a' ) || ( vr_10 > 'z' ) ) ) {
vr_22 = true ;
} else if ( vr_10 <= vl_10 ) {
vr_22 = true ;
} else {
while ( vr_17 < vr_18 ) {
vr_10 = vr_4 . charAt ( vr_17 ) ;
if ( vr_10 == vl_5 || vr_10 == vl_4 || vr_10 == vr_24 || vr_10 == vr_23 ) {
vr_22 = true ;
break;
}
vr_17 ++ ;
}
if ( ! vr_22 ) {
vr_17 = vr_18 - 1 ;
vr_10 = vr_4 . charAt ( vr_17 ) ;
if ( vr_10 <= vl_3 ) {
vr_22 = true ;
}
}
}
}
if ( ! vr_22 ) {
out . append ( vr_4 , vr_16 , vr_18 ) ;
return;
}
break;
}
if ( ! vr_22 ) {
out . append ( vr_4 , vr_16 , vr_18 ) ;
return;
}
out . append ( vr_24 ) ;
while ( vr_17 < vr_18 ) {
final char vr_10 = vr_4 . charAt ( vr_17 ) ;
if ( vr_10 == vr_24 ) {
out . append ( vr_4 , vr_16 , vr_17 + 1 ) ;
vr_16 = vr_17 ;
}
vr_17 ++ ;
}
out . append ( vr_4 , vr_16 , vr_17 ) ;
out . append ( vr_24 ) ;
}
public void fn_3 ( final Object vr_4 ) throws IOException {
String vr_29 ;
if ( vr_4 == null ) {
final String vr_30 = vr_1 . vr_31 () ;
vr_29 = vr_30 == null ? vr_32 . vr_33 : vr_30 ;
} else {
vr_29 = vr_4 . toString () ;
}
this . fn_3 ( vr_4 , vr_29 , 0 , vr_29 . length () ) ;
}
public void fn_8 ( final Object [] vr_3 ) throws IOException {
for ( final Object vr_4 : vr_3 ) {
if ( vr_4 instanceof Object [] ) {
this . fn_2 ( ( Object [] ) vr_4 ) ;
} else if ( vr_4 instanceof vr_5 ) {
this . fn_2 ( ( vr_5 < ? > ) vr_4 ) ;
} else {
this . fn_2 ( vr_4 ) ;
}
}
}
public void fn_8 ( final vr_5 < ? > vr_3 ) throws IOException {
for ( final Object vr_4 : vr_3 ) {
if ( vr_4 instanceof Object [] ) {
this . fn_2 ( ( Object [] ) vr_4 ) ;
} else if ( vr_4 instanceof vr_5 ) {
this . fn_2 ( ( vr_5 < ? > ) vr_4 ) ;
} else {
this . fn_2 ( vr_4 ) ;
}
}
}
public void fn_8 ( final tp_3 vr_34 ) throws vl_11 , IOException {
final int vr_35 = vr_34 . vr_36 () . fn_9 () ;
while ( vr_34 . vr_37 () ) {
for ( int vr_9 = 1 ; vr_9 <= vr_35 ; vr_9 ++ ) {
fn_3 ( vr_34 . vr_38 ( vr_9 ) ) ;
}
println () ;
}
}
public void fn_10 () throws IOException {
if ( out instanceof vl_12 ) {
( ( vl_12 ) out ) . fn_10 () ;
}
}
