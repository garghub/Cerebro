@Deprecated
public static long fn_1 ( final String vr_1 ) throws IOException {
return vr_2 . vr_3 ( vr_1 , vl_1 , false , - 1 ) ;
}
@Deprecated
public static long fn_2 ( final String vr_1 ) throws IOException {
return fn_2 ( vr_1 , - 1 ) ;
}
@Deprecated
public static long fn_2 ( final String vr_1 , final long vr_4 ) throws IOException {
return vr_2 . vr_3 ( vr_1 , vl_1 , true , vr_4 ) ;
}
@Deprecated
public static long fn_2 () throws IOException {
return fn_2 ( - 1 ) ;
}
@Deprecated
public static long fn_2 ( final long vr_4 ) throws IOException {
return fn_2 ( new fn_3 ( lr_1 ) . fn_4 () , vr_4 ) ;
}
long vr_3 ( final String vr_1 , final int vr_5 , final boolean vr_6 , final long vr_4 ) throws IOException {
if ( vr_1 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
switch ( vr_5 ) {
case vl_2 :
return vr_6 ? fn_5 ( vr_1 , vr_4 ) / vr_7 . vr_8 : fn_5 ( vr_1 , vr_4 ) ;
case vl_3 :
return fn_6 ( vr_1 , vr_6 , false , vr_4 ) ;
case vl_4 :
return fn_6 ( vr_1 , vr_6 , true , vr_4 ) ;
case vl_5 :
throw new fn_7 ( lr_3 ) ;
default:
throw new fn_7 (
lr_4 ) ;
}
}
long fn_5 ( final String vr_1 , final long vr_4 ) throws IOException {
String vr_9 = vr_10 . vr_11 ( vr_1 , false ) ;
if ( vr_9 == null ) {
throw new IllegalArgumentException ( vr_1 ) ;
}
if ( vr_9 . length () > 0 && vr_9 . charAt ( 0 ) != '"' ) {
vr_9 = lr_5 + vr_9 + lr_5 ;
}
final String [] vr_12 = new String [] { lr_6 , lr_7 , lr_8 + vr_9 } ;
final List < String > vr_13 = fn_8 ( vr_12 , Integer . vr_14 , vr_4 ) ;
for ( int vr_15 = vr_13 . size () - 1 ; vr_15 >= 0 ; vr_15 -- ) {
final String line = vr_13 . get ( vr_15 ) ;
if ( line . length () > 0 ) {
return fn_9 ( line , vr_9 ) ;
}
}
throw new IOException (
lr_9 +
lr_10 + vr_9 + lr_11 ) ;
}
long fn_9 ( final String line , final String vr_1 ) throws IOException {
int vr_16 = 0 ;
int vr_17 = 0 ;
int vr_18 = line . length () - 1 ;
lb_1: while ( vr_18 >= 0 ) {
final char vr_19 = line . charAt ( vr_18 ) ;
if ( vr_20 . isDigit ( vr_19 ) ) {
vr_17 = vr_18 + 1 ;
break lb_1;
}
vr_18 -- ;
}
lb_2: while ( vr_18 >= 0 ) {
final char vr_19 = line . charAt ( vr_18 ) ;
if ( ! vr_20 . isDigit ( vr_19 ) && vr_19 != ',' && vr_19 != '.' ) {
vr_16 = vr_18 + 1 ;
break lb_2;
}
vr_18 -- ;
}
if ( vr_18 < 0 ) {
throw new IOException (
lr_12 +
lr_10 + vr_1 + lr_11 ) ;
}
final StringBuilder vr_21 = new StringBuilder ( line . vr_22 ( vr_16 , vr_17 ) ) ;
for ( int vr_23 = 0 ; vr_23 < vr_21 . length () ; vr_23 ++ ) { MST[rv.ROR3Mutator]MSP[N]
if ( vr_21 . charAt ( vr_23 ) == ',' || vr_21 . charAt ( vr_23 ) == '.' ) {
vr_21 . vr_24 ( vr_23 -- ) ;
}
}
return fn_10 ( vr_21 . toString () , vr_1 ) ;
}
long fn_6 ( final String vr_1 , final boolean vr_6 , final boolean vr_25 , final long vr_4 )
throws IOException {
if ( vr_1 . isEmpty () ) {
throw new IllegalArgumentException ( lr_13 ) ;
}
String vr_26 = lr_14 ;
if ( vr_6 ) {
vr_26 += lr_15 ;
}
if ( vr_25 ) {
vr_26 += lr_16 ;
}
final String [] vr_12 =
vr_26 . length () > 1 ? new String [] { vl_6 , vr_26 , vr_1 } : new String [] { vl_6 , vr_1 } ;
final List < String > vr_13 = fn_8 ( vr_12 , 3 , vr_4 ) ;
if ( vr_13 . size () < 2 ) {
throw new IOException (
lr_17 + vl_6 + lr_18 +
lr_10 + vr_1 + lr_19 + vr_13 ) ;
}
final String vr_27 = vr_13 . get ( 1 ) ;
tp_1 vr_28 = new tp_1 ( vr_27 , lr_20 ) ;
if ( vr_28 . vr_29 () < 4 ) {
if ( vr_28 . vr_29 () == 1 && vr_13 . size () >= 3 ) {
final String vr_30 = vr_13 . get ( 2 ) ;
vr_28 = new tp_1 ( vr_30 , lr_20 ) ;
} else {
throw new IOException (
lr_17 + vl_6 + lr_21 +
lr_10 + vr_1 + lr_22 ) ;
}
} else {
vr_28 . vr_31 () ;
}
vr_28 . vr_31 () ;
vr_28 . vr_31 () ;
final String fn_1 = vr_28 . vr_31 () ;
return fn_10 ( fn_1 , vr_1 ) ;
}
long fn_10 ( final String fn_1 , final String vr_1 ) throws IOException {
try {
final long vr_32 = Long . vr_33 ( fn_1 ) ;
if ( vr_32 < 0 ) {
throw new IOException (
lr_17 + vl_6 + lr_23 +
lr_10 + vr_1 + lr_22 ) ;
}
return vr_32 ;
} catch ( final tp_2 vr_34 ) {
throw new IOException (
lr_17 + vl_6 + lr_24 +
lr_10 + vr_1 + lr_22 , vr_34 ) ;
}
}
List < String > fn_8 ( final String [] vr_12 , final int vr_35 , final long vr_4 ) throws IOException {
final List < String > vr_13 = new ArrayList <> ( 20 ) ;
tp_3 vr_36 = null ;
tp_4 vr_37 = null ;
tp_5 out = null ;
tp_4 vr_38 = null ;
BufferedReader vr_39 = null ;
try {
final tp_6 vr_40 = vr_41 . vr_42 ( vr_4 ) ;
vr_36 = fn_11 ( vr_12 ) ;
vr_37 = vr_36 . vr_43 () ;
out = vr_36 . vr_44 () ;
vr_38 = vr_36 . vr_45 () ;
vr_39 = new BufferedReader ( new fn_12 ( vr_37 , vr_46 . vr_47 () ) ) ;
String line = vr_39 . readLine () ;
while ( line != null && vr_13 . size () < vr_35 ) {
line = line . vr_48 ( vr_49 . vr_50 ) . trim () ;
vr_13 . add ( line ) ;
line = vr_39 . readLine () ;
}
vr_36 . vr_51 () ;
vr_41 . vr_52 ( vr_40 ) ;
if ( vr_36 . vr_53 () != 0 ) {
throw new IOException (
lr_25 + vr_36 . vr_53 () +
lr_26 + vr_54 . vr_55 ( vr_12 ) ) ;
}
if ( vr_13 . isEmpty () ) {
throw new IOException (
lr_27 +
lr_28 + vr_54 . vr_55 ( vr_12 ) ) ;
}
vr_39 . vr_56 () ;
vr_39 = null ;
vr_37 . vr_56 () ;
vr_37 = null ;
if ( out != null ) {
out . vr_56 () ;
out = null ;
}
if ( vr_38 != null ) {
vr_38 . vr_56 () ;
vr_38 = null ;
}
return vr_13 ;
} catch ( final tp_7 vr_34 ) {
throw new IOException (
lr_29 +
lr_28 + vr_54 . vr_55 ( vr_12 ) + lr_30 + vr_4 , vr_34 ) ;
} finally {
vr_57 . vr_58 ( vr_37 ) ;
vr_57 . vr_58 ( out ) ;
vr_57 . vr_58 ( vr_38 ) ;
vr_57 . vr_58 ( vr_39 ) ;
if ( vr_36 != null ) {
vr_36 . vr_59 () ;
}
}
}
tp_3 fn_11 ( final String [] vr_12 ) throws IOException {
return vr_60 . vr_61 () . fn_13 ( vr_12 ) ;
}
