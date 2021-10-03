public static < vt_1 > String fn_1 ( final Object vr_1 , final vr_2 < String , vt_1 > vr_3 ) {
return new fn_2 ( vr_3 ) . fn_1 ( vr_1 ) ;
}
public static < vt_1 > String fn_1 ( final Object vr_1 , final vr_2 < String , vt_1 > vr_3 , final String vr_4 , final String vr_5 ) {
return new fn_2 ( vr_3 , vr_4 , vr_5 ) . fn_1 ( vr_1 ) ;
}
public static String fn_1 ( final Object vr_1 , final Properties vr_6 ) {
if ( vr_6 == null ) {
return vr_1 . toString () ;
}
final vr_2 < String , String > vr_3 = new vr_7 < String , String > () ;
final Enumeration < ? > vr_8 = vr_6 . propertyNames () ;
while ( vr_8 . vr_9 () ) {
final String vr_10 = ( String ) vr_8 . nextElement () ;
final String vr_11 = vr_6 . getProperty ( vr_10 ) ;
vr_3 . vr_12 ( vr_10 , vr_11 ) ;
}
return fn_2 . fn_1 ( vr_1 , vr_3 ) ;
}
public static String fn_3 ( final Object vr_1 ) {
return new fn_2 ( vr_13 . vr_14 () ) . fn_1 ( vr_1 ) ;
}
public String fn_1 ( final String vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( vr_1 ) ;
if ( fn_4 ( vr_15 , 0 , vr_1 . length () ) == false ) {
return vr_1 ;
}
return vr_15 . toString () ;
}
public String fn_1 ( final String vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( length ) . append ( vr_1 , vr_16 , length ) ;
if ( fn_4 ( vr_15 , 0 , length ) == false ) {
return vr_1 . vr_17 ( vr_16 , vr_16 + length ) ;
}
return vr_15 . toString () ;
}
public String fn_1 ( final char [] vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( vr_1 . length ) . append ( vr_1 ) ;
fn_4 ( vr_15 , 0 , vr_1 . length ) ;
return vr_15 . toString () ;
}
public String fn_1 ( final char [] vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( length ) . append ( vr_1 , vr_16 , length ) ;
fn_4 ( vr_15 , 0 , length ) ;
return vr_15 . toString () ;
}
public String fn_1 ( final tp_2 vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( vr_1 . length () ) . append ( vr_1 ) ;
fn_4 ( vr_15 , 0 , vr_15 . length () ) ;
return vr_15 . toString () ;
}
public String fn_1 ( final tp_2 vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( length ) . append ( vr_1 , vr_16 , length ) ;
fn_4 ( vr_15 , 0 , length ) ;
return vr_15 . toString () ;
}
public String fn_1 ( final tp_3 vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
return fn_1 ( vr_1 , 0 , vr_1 . length () ) ;
}
public String fn_1 ( final tp_3 vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( length ) . append ( vr_1 , vr_16 , length ) ;
fn_4 ( vr_15 , 0 , length ) ;
return vr_15 . toString () ;
}
public String fn_1 ( final tp_1 vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( vr_1 . length () ) . append ( vr_1 ) ;
fn_4 ( vr_15 , 0 , vr_15 . length () ) ;
return vr_15 . toString () ;
}
public String fn_1 ( final tp_1 vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 ( length ) . append ( vr_1 , vr_16 , length ) ;
fn_4 ( vr_15 , 0 , length ) ;
return vr_15 . toString () ;
}
public String fn_1 ( final Object vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
final tp_1 vr_15 = new tp_1 () . append ( vr_1 ) ;
fn_4 ( vr_15 , 0 , vr_15 . length () ) ;
return vr_15 . toString () ;
}
public boolean fn_5 ( final tp_2 vr_1 ) {
if ( vr_1 == null ) {
return false ;
}
return fn_5 ( vr_1 , 0 , vr_1 . length () ) ;
}
public boolean fn_5 ( final tp_2 vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return false ;
}
final tp_1 vr_15 = new tp_1 ( length ) . append ( vr_1 , vr_16 , length ) ;
if ( fn_4 ( vr_15 , 0 , length ) == false ) {
return false ;
}
vr_1 . fn_1 ( vr_16 , vr_16 + length , vr_15 . toString () ) ;
return true ;
}
public boolean fn_5 ( final StringBuilder vr_1 ) {
if ( vr_1 == null ) {
return false ;
}
return fn_5 ( vr_1 , 0 , vr_1 . length () ) ;
}
public boolean fn_5 ( final StringBuilder vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return false ;
}
final tp_1 vr_15 = new tp_1 ( length ) . append ( vr_1 , vr_16 , length ) ;
if ( fn_4 ( vr_15 , 0 , length ) == false ) {
return false ;
}
vr_1 . fn_1 ( vr_16 , vr_16 + length , vr_15 . toString () ) ;
return true ;
}
public boolean fn_5 ( final tp_1 vr_1 ) {
if ( vr_1 == null ) {
return false ;
}
return fn_4 ( vr_1 , 0 , vr_1 . length () ) ;
}
public boolean fn_5 ( final tp_1 vr_1 , final int vr_16 , final int length ) {
if ( vr_1 == null ) {
return false ;
}
return fn_4 ( vr_1 , vr_16 , length ) ;
}
protected boolean fn_4 ( final tp_1 vr_15 , final int vr_16 , final int length ) {
return fn_4 ( vr_15 , vr_16 , length , null ) > 0 ;
}
private int fn_4 ( final tp_1 vr_15 , final int vr_16 , final int length , List < String > vr_18 ) {
final tp_4 vr_19 = fn_6 () ;
final tp_4 vr_20 = fn_7 () ;
final char vr_21 = fn_8 () ;
final tp_4 vr_22 = fn_9 () ;
final boolean vr_23 = fn_10 () ;
final boolean vr_24 = vr_18 == null ;
boolean vr_25 = false ;
int vr_26 = 0 ;
char [] vr_27 = vr_15 . vr_28 ;
int vr_29 = vr_16 + length ;
int vr_30 = vr_16 ;
while ( vr_30 < vr_29 ) {
final int vr_31 = vr_19 . vr_32 ( vr_27 , vr_30 , vr_16 ,
vr_29 ) ;
if ( vr_31 == 0 ) {
vr_30 ++ ;
} else {
if ( vr_30 > vr_16 && vr_27 [ vr_30 - 1 ] == vr_21 ) {
vr_15 . vr_33 ( vr_30 - 1 ) ;
vr_27 = vr_15 . vr_28 ;
vr_26 -- ;
vr_25 = true ;
vr_29 -- ;
} else {
final int vr_34 = vr_30 ;
vr_30 += vr_31 ;
int vr_35 = 0 ;
int vr_36 = 0 ;
while ( vr_30 < vr_29 ) {
if ( vr_23
&& ( vr_35 = vr_19 . vr_32 ( vr_27 ,
vr_30 , vr_16 , vr_29 ) ) != 0 ) {
vr_36 ++ ;
vr_30 += vr_35 ;
continue;
}
vr_35 = vr_20 . vr_32 ( vr_27 , vr_30 , vr_16 ,
vr_29 ) ;
if ( vr_35 == 0 ) {
vr_30 ++ ;
} else {
if ( vr_36 == 0 ) {
String vr_37 = new String ( vr_27 , vr_34
+ vr_31 , vr_30 - vr_34
- vr_31 ) ;
if ( vr_23 ) {
final tp_1 vr_38 = new tp_1 ( vr_37 ) ;
fn_4 ( vr_38 , 0 , vr_38 . length () ) ;
vr_37 = vr_38 . toString () ;
}
vr_30 += vr_35 ;
final int vr_39 = vr_30 ;
String vr_40 = vr_37 ;
String vr_41 = null ;
if ( vr_22 != null ) {
final char [] vr_42 = vr_37 . vr_43 () ;
int vr_44 = 0 ;
for ( int vr_45 = 0 ; vr_45 < vr_42 . length ; vr_45 ++ ) {
if ( ! vr_23
&& vr_19 . vr_32 ( vr_42 , vr_45 , vr_45 , vr_42 . length ) != 0 ) {
break;
}
if ( ( vr_44 = vr_22 . vr_32 ( vr_42 , vr_45 ) ) != 0 ) {
vr_40 = vr_37 . vr_17 ( 0 , vr_45 ) ;
vr_41 = vr_37 . vr_17 ( vr_45 + vr_44 ) ;
break;
}
}
}
if ( vr_18 == null ) {
vr_18 = new ArrayList < String > () ;
vr_18 . add ( new String ( vr_27 ,
vr_16 , length ) ) ;
}
fn_11 ( vr_40 , vr_18 ) ;
vr_18 . add ( vr_40 ) ;
String vr_46 = fn_12 ( vr_40 , vr_15 ,
vr_34 , vr_39 ) ;
if ( vr_46 == null ) {
vr_46 = vr_41 ;
}
if ( vr_46 != null ) {
final int vr_47 = vr_46 . length () ;
vr_15 . fn_1 ( vr_34 , vr_39 , vr_46 ) ;
vr_25 = true ;
int vr_48 = fn_4 ( vr_15 , vr_34 ,
vr_47 , vr_18 ) ;
vr_48 = vr_48
+ vr_47 - ( vr_39 - vr_34 ) ;
vr_30 += vr_48 ;
vr_29 += vr_48 ;
vr_26 += vr_48 ;
vr_27 = vr_15 . vr_28 ;
}
vr_18
. remove ( vr_18 . size () - 1 ) ;
break;
}
vr_36 -- ;
vr_30 += vr_35 ;
}
}
}
}
}
if ( vr_24 ) {
return vr_25 ? 1 : 0 ;
}
return vr_26 ;
}
private void fn_11 ( final String vr_40 , final List < String > vr_18 ) {
if ( vr_18 . contains ( vr_40 ) == false ) {
return;
}
final tp_1 vr_15 = new tp_1 ( 256 ) ;
vr_15 . append ( lr_1 ) ;
vr_15 . append ( vr_18 . remove ( 0 ) ) ;
vr_15 . append ( lr_2 ) ;
vr_15 . vr_49 ( vr_18 , lr_3 ) ;
throw new fn_13 ( vr_15 . toString () ) ;
}
protected String fn_12 ( final String vr_50 , final tp_1 vr_15 , final int vr_34 , final int vr_39 ) {
final vr_13 < ? > vr_51 = fn_14 () ;
if ( vr_51 == null ) {
return null ;
}
return vr_51 . vr_52 ( vr_50 ) ;
}
public char fn_8 () {
return this . vr_53 ;
}
public void fn_15 ( final char vr_54 ) {
this . vr_53 = vr_54 ;
}
public tp_4 fn_6 () {
return vl_1 ;
}
public fn_2 fn_16 ( final tp_4 vl_1 ) {
if ( vl_1 == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
this . vl_1 = vl_1 ;
return this ;
}
public fn_2 fn_17 ( final char vr_4 ) {
return fn_16 ( tp_4 . vr_55 ( vr_4 ) ) ;
}
public fn_2 fn_17 ( final String vr_4 ) {
if ( vr_4 == null ) {
throw new IllegalArgumentException ( lr_5 ) ;
}
return fn_16 ( tp_4 . vr_56 ( vr_4 ) ) ;
}
public tp_4 fn_7 () {
return vl_2 ;
}
public fn_2 fn_18 ( final tp_4 vl_2 ) {
if ( vl_2 == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
}
this . vl_2 = vl_2 ;
return this ;
}
public fn_2 fn_19 ( final char vr_5 ) {
return fn_18 ( tp_4 . vr_55 ( vr_5 ) ) ;
}
public fn_2 fn_19 ( final String vr_5 ) {
if ( vr_5 == null ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
return fn_18 ( tp_4 . vr_56 ( vr_5 ) ) ;
}
public tp_4 fn_9 () {
return vl_3 ;
}
public fn_2 fn_20 ( final tp_4 vl_3 ) {
this . vl_3 = vl_3 ;
return this ;
}
public fn_2 fn_21 ( final char vr_57 ) {
return fn_20 ( tp_4 . vr_55 ( vr_57 ) ) ;
}
public fn_2 fn_21 ( final String vr_57 ) {
if ( vr_58 . isEmpty ( vr_57 ) ) {
fn_20 ( null ) ;
return this ;
}
return fn_20 ( tp_4 . vr_56 ( vr_57 ) ) ;
}
public vr_13 < ? > fn_14 () {
return this . vr_59 ;
}
public void fn_22 ( final vr_13 < ? > vr_59 ) {
this . vr_59 = vr_59 ;
}
public boolean fn_10 () {
return vl_4 ;
}
public void fn_23 (
final boolean vl_4 ) {
this . vl_4 = vl_4 ;
}
