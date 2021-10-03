tp_1 fn_1 ( final tp_1 vr_1 ) throws IOException {
int vr_2 = vr_3 . vr_4 () ;
int vr_5 = vr_3 . vr_6 () ;
boolean vr_7 = fn_2 ( vr_5 ) ;
if ( vl_1 ) {
while ( vr_7 && fn_3 ( vr_2 ) ) {
vr_2 = vr_5 ;
vr_5 = vr_3 . vr_6 () ;
vr_7 = fn_2 ( vr_5 ) ;
if ( fn_4 ( vr_5 ) ) {
vr_1 . type = vl_2 ;
return vr_1 ;
}
}
}
if ( fn_4 ( vr_2 ) || ( ! fn_5 ( vr_2 ) && fn_4 ( vr_5 ) ) ) {
vr_1 . type = vl_2 ;
return vr_1 ;
}
if ( fn_3 ( vr_2 ) && fn_6 ( vr_5 ) ) {
final String line = vr_3 . readLine () ;
if ( line == null ) {
vr_1 . type = vl_2 ;
return vr_1 ;
}
final String vr_8 = line . trim () ;
vr_1 . vr_9 . append ( vr_8 ) ;
vr_1 . type = vl_3 ;
return vr_1 ;
}
while ( vr_1 . type == vl_4 ) {
if ( vl_5 ) {
while ( fn_7 ( vr_5 ) && ! vr_7 ) {
vr_5 = vr_3 . vr_6 () ;
vr_7 = fn_2 ( vr_5 ) ;
}
}
if ( fn_5 ( vr_5 ) ) {
vr_1 . type = vl_6 ;
} else if ( vr_7 ) {
vr_1 . type = vl_7 ;
} else if ( fn_8 ( vr_5 ) ) {
fn_9 ( vr_1 ) ;
} else if ( fn_4 ( vr_5 ) ) {
vr_1 . type = vl_2 ;
vr_1 . vr_10 = true ;
} else {
fn_10 ( vr_1 , vr_5 ) ;
}
}
return vr_1 ;
}
private tp_1 fn_10 ( final tp_1 vr_1 , int vr_11 ) throws IOException {
while ( true ) {
if ( fn_2 ( vr_11 ) ) {
vr_1 . type = vl_7 ;
break;
} else if ( fn_4 ( vr_11 ) ) {
vr_1 . type = vl_2 ;
vr_1 . vr_10 = true ;
break;
} else if ( fn_5 ( vr_11 ) ) {
vr_1 . type = vl_6 ;
break;
} else if ( fn_11 ( vr_11 ) ) {
final int vr_12 = fn_12 () ;
if ( vr_12 == vr_13 . vr_14 ) {
vr_1 . vr_9 . append ( ( char ) vr_11 ) . append ( ( char ) vr_3 . vr_4 () ) ;
} else {
vr_1 . vr_9 . append ( ( char ) vr_12 ) ;
}
vr_11 = vr_3 . vr_6 () ;
} else {
vr_1 . vr_9 . append ( ( char ) vr_11 ) ;
vr_11 = vr_3 . vr_6 () ;
}
}
if ( vl_5 ) {
fn_13 ( vr_1 . vr_9 ) ;
}
return vr_1 ;
}
private tp_1 fn_9 ( final tp_1 vr_1 ) throws IOException {
final long vr_15 = fn_14 () ;
int vr_5 ;
while ( true ) {
vr_5 = vr_3 . vr_6 () ;
if ( fn_11 ( vr_5 ) ) {
final int vr_12 = fn_12 () ;
if ( vr_12 == vr_13 . vr_14 ) {
vr_1 . vr_9 . append ( ( char ) vr_5 ) . append ( ( char ) vr_3 . vr_4 () ) ;
} else {
vr_1 . vr_9 . append ( ( char ) vr_12 ) ;
}
} else if ( fn_8 ( vr_5 ) ) {
if ( fn_8 ( vr_3 . vr_16 () ) ) {
vr_5 = vr_3 . vr_6 () ;
vr_1 . vr_9 . append ( ( char ) vr_5 ) ;
} else {
while ( true ) {
vr_5 = vr_3 . vr_6 () ;
if ( fn_5 ( vr_5 ) ) {
vr_1 . type = vl_6 ;
return vr_1 ;
} else if ( fn_4 ( vr_5 ) ) {
vr_1 . type = vl_2 ;
vr_1 . vr_10 = true ;
return vr_1 ;
} else if ( fn_2 ( vr_5 ) ) {
vr_1 . type = vl_7 ;
return vr_1 ;
} else if ( ! fn_7 ( vr_5 ) ) {
throw new IOException ( lr_1 + fn_14 () +
lr_2 ) ;
}
}
}
} else if ( fn_4 ( vr_5 ) ) {
throw new IOException ( lr_3 + vr_15 +
lr_4 ) ;
} else {
vr_1 . vr_9 . append ( ( char ) vr_5 ) ;
}
}
}
private char fn_15 ( final tp_2 vr_5 ) {
return vr_5 == null ? vl_8 : vr_5 . vr_17 () ;
}
long fn_14 () {
return vr_3 . fn_14 () ;
}
int fn_12 () throws IOException {
final int vr_11 = vr_3 . vr_6 () ;
switch ( vr_11 ) {
case 'r' :
return vl_9 ;
case 'n' :
return vl_10 ;
case 't' :
return vl_11 ;
case 'b' :
return vl_12 ;
case 'f' :
return vl_13 ;
case vl_9 :
case vl_10 :
case vl_13 :
case vl_11 :
case vl_12 :
return vr_11 ;
case vr_14 :
throw new IOException ( lr_5 ) ;
default:
if ( fn_16 ( vr_11 ) ) { MST[rv.ROR5Mutator]MSP[N]
return vr_11 ;
}
return vr_14 ;
}
}
void fn_13 ( final StringBuilder vr_18 ) {
int length = vr_18 . length () ;
while ( length > 0 && tp_2 . fn_7 ( vr_18 . charAt ( length - 1 ) ) ) {
length = length - 1 ;
}
if ( length != vr_18 . length () ) {
vr_18 . vr_19 ( length ) ;
}
}
boolean fn_2 ( int vr_11 ) throws IOException {
if ( vr_11 == vl_9 && vr_3 . vr_16 () == vl_10 ) {
vr_11 = vr_3 . vr_6 () ;
}
return vr_11 == vl_10 || vr_11 == vl_9 ;
}
boolean fn_17 () {
return vr_3 . fn_17 () ;
}
boolean fn_7 ( final int vr_11 ) {
return ! fn_5 ( vr_11 ) && tp_2 . fn_7 ( ( char ) vr_11 ) ;
}
boolean fn_3 ( final int vr_11 ) {
return vr_11 == vl_10 || vr_11 == vl_9 || vr_11 == vl_14 ;
}
boolean fn_4 ( final int vr_11 ) {
return vr_11 == vr_14 ;
}
boolean fn_5 ( final int vr_11 ) {
return vr_11 == vl_15 ;
}
boolean fn_11 ( final int vr_11 ) {
return vr_11 == vl_16 ;
}
boolean fn_8 ( final int vr_11 ) {
return vr_11 == vl_17 ;
}
boolean fn_6 ( final int vr_11 ) {
return vr_11 == vl_18 ;
}
private boolean fn_16 ( final int vr_11 ) {
return vr_11 == vl_15 ||
vr_11 == vl_16 ||
vr_11 == vl_17 ||
vr_11 == vl_18 ;
}
void fn_18 () throws IOException {
vr_3 . fn_18 () ;
}
