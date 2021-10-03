public static String toString ( final Object object ) {
return toString ( object , null , false , false , null ) ;
}
public static String toString ( final Object object , final tp_1 vr_1 ) {
return toString ( object , vr_1 , false , false , null ) ;
}
public static String toString ( final Object object , final tp_1 vr_1 , final boolean vr_2 ) {
return toString ( object , vr_1 , vr_2 , false , null ) ;
}
public static String toString ( final Object object , final tp_1 vr_1 , final boolean vr_2 , final boolean vr_3 ) {
return toString ( object , vr_1 , vr_2 , vr_3 , null ) ;
}
public static < vt_1 > String toString (
final vt_1 object , final tp_1 vr_1 , final boolean vr_2 ,
final boolean vr_3 , final Class < ? super vt_1 > vr_4 ) {
return new fn_1 ( object , vr_1 , null , vr_4 , vr_2 , vr_3 )
. toString () ;
}
public static String fn_2 ( final Object object , final Collection < String > vr_5 ) {
return fn_2 ( object , fn_3 ( vr_5 ) ) ;
}
static String [] fn_3 ( final Collection < String > collection ) {
if ( collection == null ) {
return vr_6 . vr_7 ;
}
return fn_3 ( collection . toArray () ) ;
}
static String [] fn_3 ( final Object [] array ) {
final List < String > list = new ArrayList < String > ( array . length ) ;
for ( final Object vr_8 : array ) {
if ( vr_8 != null ) {
list . add ( vr_8 . toString () ) ;
}
}
return list . toArray ( new String [ list . size () ] ) ;
}
public static String fn_2 ( final Object object , final String ... vr_5 ) {
return new fn_1 ( object ) . fn_4 ( vr_5 ) . toString () ;
}
private static Object fn_5 ( final Object vr_9 ) {
if ( vr_9 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return vr_9 ;
}
protected boolean fn_6 ( final tp_2 vr_10 ) {
if ( vr_10 . vr_11 () . indexOf ( vr_12 . vr_13 ) != - 1 ) {
return false ;
}
if ( vr_14 . vr_15 ( vr_10 . vr_16 () ) && ! this . vr_17 () ) {
return false ;
}
if ( vr_14 . vr_18 ( vr_10 . vr_16 () ) && ! this . vr_19 () ) {
return false ;
}
if ( this . vr_5 != null
&& vr_20 . vr_21 ( this . vr_5 , vr_10 . vr_11 () ) >= 0 ) {
return false ;
}
if( vr_10 . vr_22 ( vr_23 . class ) ) {
return false ;
}
return true ;
}
protected void fn_7 ( final Class < ? > vr_24 ) {
if ( vr_24 . vr_25 () ) {
this . vr_26 ( this . vr_27 () ) ;
return;
}
final tp_2 [] vr_28 = vr_24 . vr_29 () ;
vr_30 . vr_31 ( vr_28 , true ) ;
for ( final tp_2 vr_10 : vr_28 ) {
final String vr_32 = vr_10 . vr_11 () ;
if ( this . fn_6 ( vr_10 ) ) {
try {
final Object vr_33 = this . vr_34 ( vr_10 ) ;
this . append ( vr_32 , vr_33 ) ;
} catch ( final tp_3 vr_35 ) {
throw new fn_8 ( lr_2 + vr_35 . vr_36 () ) ;
}
}
}
}
public String [] fn_9 () {
return this . vr_5 . vr_37 () ;
}
public Class < ? > fn_10 () {
return this . vr_38 ;
}
protected Object vr_34 ( final tp_2 vr_10 ) throws IllegalArgumentException , tp_3 {
return vr_10 . get ( this . vr_27 () ) ;
}
public boolean vr_19 () {
return this . vr_39 ;
}
public boolean vr_17 () {
return this . vr_40 ;
}
public fn_1 vr_26 ( final Object array ) {
this . vr_41 () . fn_11 ( this . vr_42 () , null , array ) ;
return this ;
}
public void fn_12 ( final boolean vr_39 ) {
this . vr_39 = vr_39 ;
}
public void fn_13 ( final boolean vr_40 ) {
this . vr_40 = vr_40 ;
}
public fn_1 fn_4 ( final String ... vr_43 ) {
if ( vr_43 == null ) {
this . vr_5 = null ;
} else {
this . vr_5 = fn_3 ( vr_43 ) ;
vr_20 . vr_44 ( this . vr_5 ) ;
}
return this ;
}
public void fn_14 ( final Class < ? > vr_24 ) {
if ( vr_24 != null ) {
final Object object = vr_27 () ;
if ( object != null && vr_24 . vr_45 ( object ) == false ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
}
this . vr_38 = vr_24 ;
}
@Override
public String toString () {
if ( this . vr_27 () == null ) {
return this . vr_41 () . fn_15 () ;
}
Class < ? > vr_24 = this . vr_27 () . getClass () ;
this . fn_7 ( vr_24 ) ;
while ( vr_24 . vr_46 () != null && vr_24 != this . fn_10 () ) {
vr_24 = vr_24 . vr_46 () ;
this . fn_7 ( vr_24 ) ;
}
return super . toString () ;
}
