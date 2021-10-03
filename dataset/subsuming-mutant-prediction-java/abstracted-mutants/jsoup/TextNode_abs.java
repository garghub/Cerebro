public String fn_1 () {
return lr_1 ;
}
public String fn_2 () {
return vr_1 . vr_2 ( fn_3 () ) ;
}
public tp_1 fn_2 ( String fn_2 ) {
fn_4 ( fn_2 ) ;
return this ;
}
public String fn_3 () {
return fn_4 () ;
}
public boolean fn_5 () {
return vr_1 . fn_5 ( fn_4 () ) ;
}
public tp_1 fn_6 ( int vr_3 ) {
final String fn_2 = fn_4 () ;
vr_4 . vr_5 ( vr_3 >= 0 , lr_2 ) ;
vr_4 . vr_5 ( vr_3 < fn_2 . length () , lr_3 ) ;
String vr_6 = fn_2 . vr_7 ( 0 , vr_3 ) ;
String vr_8 = fn_2 . vr_7 ( vr_3 ) ;
fn_2 ( vr_6 ) ;
tp_1 vr_9 = new tp_1 ( vr_8 ) ;
if ( fn_7 () != null )
fn_7 () . fn_8 ( fn_9 () + 1 , vr_9 ) ;
return vr_9 ;
}
void fn_10 ( tp_2 vr_10 , int vr_11 , vr_12 . vr_13 out ) throws IOException {
if ( out . vr_14 () && ( ( fn_9 () == 0 && vl_1 instanceof vl_2 && ( ( vl_2 ) vl_1 ) . fn_11 () . fn_12 () && ! fn_5 () ) || ( out . vr_15 () && fn_13 () . size () > 0 && ! fn_5 () ) ) )
fn_14 ( vr_10 , vr_11 , out ) ;
boolean vr_16 = out . vr_14 () && ! vl_2 . vr_17 ( fn_7 () ) ;
vr_18 . vr_19 ( vr_10 , fn_4 () , out , false , vr_16 , false ) ;
}
void fn_15 ( tp_2 vr_10 , int vr_11 , vr_12 . vr_13 out ) {}
@Override
public String toString () {
return fn_16 () ;
}
@Override
public tp_1 fn_17 () {
return ( tp_1 ) super . fn_17 () ;
}
public static tp_1 fn_18 ( String vr_20 ) {
String fn_2 = vr_18 . vr_21 ( vr_20 ) ;
return new tp_1 ( fn_2 ) ;
}
static String vr_2 ( String fn_2 ) {
fn_2 = vr_1 . vr_2 ( fn_2 ) ;
return fn_2 ;
}
static String fn_19 ( String fn_2 ) {
return fn_2 . vr_22 ( lr_4 , lr_5 ) ;
}
static boolean fn_20 ( StringBuilder vr_23 ) {
return vr_23 . length () != 0 && vr_23 . charAt ( vr_23 . length () - 1 ) == ' ' ;
}
