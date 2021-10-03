@Override
public int fn_1 ( final tp_1 vr_1 , final int vr_2 , final tp_2 out ) throws IOException {
if ( vr_2 != 0 ) {
throw new fn_2 ( lr_1 ) ;
}
final String vr_3 = vr_1 . toString () ;
int vr_4 = 0 ;
int vr_5 = 0 ;
while ( true ) {
final int vr_6 = vr_3 . indexOf ( vl_1 , vr_5 ) ;
if ( vr_6 == - 1 ) {
if ( vr_4 < vr_3 . length () ) {
out . vr_7 ( vr_3 . vr_8 ( vr_4 ) ) ;
}
break;
}
if ( vr_6 > vr_4 ) {
out . vr_7 ( vr_3 . vr_8 ( vr_4 , vr_6 ) ) ;
}
vr_4 = vr_6 + 1 ;
vr_5 = vr_6 + 2 ;
}
return vr_9 . vr_10 ( vr_1 , 0 , vr_1 . length () ) ;
}
public Builder fn_3 ( final String vr_1 ) {
vr_11 . append ( vr_12 . fn_1 ( vr_1 ) ) ;
return this ; MST[ReturnValsMutator]MSP[S]
}
public Builder append ( final String vr_1 ) {
vr_11 . append ( vr_1 ) ;
return this ;
}
@Override
public String toString () {
return vr_11 . toString () ;
}
public static vr_13 . Builder builder ( final tp_3 vr_12 ) {
return new Builder ( vr_12 ) ;
}
public static final String fn_4 ( final String vr_1 ) {
return vr_14 . fn_1 ( vr_1 ) ;
}
public static final String fn_5 ( final String vr_1 ) {
return vr_15 . fn_1 ( vr_1 ) ;
}
public static final String fn_6 ( final String vr_1 ) {
return vr_16 . fn_1 ( vr_1 ) ;
}
public static final String fn_7 ( final String vr_1 ) {
return vr_17 . fn_1 ( vr_1 ) ;
}
public static final String fn_8 ( final String vr_1 ) {
return vr_18 . fn_1 ( vr_1 ) ;
}
public static final String fn_9 ( final String vr_1 ) {
return vr_19 . fn_1 ( vr_1 ) ;
}
public static final String fn_10 ( final String vr_1 ) {
return vr_20 . fn_1 ( vr_1 ) ;
}
public static final String fn_11 ( final String vr_1 ) {
return vr_21 . fn_1 ( vr_1 ) ;
}
public static final String fn_12 ( final String vr_1 ) {
return vr_22 . fn_1 ( vr_1 ) ;
}
public static final String fn_13 ( final String vr_1 ) {
return vr_23 . fn_1 ( vr_1 ) ;
}
public static String fn_14 ( final String vr_1 ) {
return vr_24 . fn_1 ( vr_1 ) ;
}
public static String fn_15 ( final String vr_1 ) {
return vr_25 . fn_1 ( vr_1 ) ;
}
public static final String fn_16 ( final String vr_1 ) {
return vr_26 . fn_1 ( vr_1 ) ;
}
public static final String fn_17 ( final String vr_1 ) {
return vr_27 . fn_1 ( vr_1 ) ;
}
public static final String fn_18 ( final String vr_1 ) {
return vr_28 . fn_1 ( vr_1 ) ;
}
public static final String fn_19 ( final String vr_1 ) {
return vr_29 . fn_1 ( vr_1 ) ;
}
public static final String fn_20 ( final String vr_1 ) {
return vr_30 . fn_1 ( vr_1 ) ;
}
