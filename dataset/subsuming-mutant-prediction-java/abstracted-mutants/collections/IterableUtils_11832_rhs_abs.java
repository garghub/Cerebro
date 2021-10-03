@Override
public Iterator < Object > iterator () {
return vr_1 . vr_2 () ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_3 < vt_1 > fn_1 () {
return vl_1 ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_3 < vt_1 > fn_2 ( final vr_3 < ? extends vt_1 > vr_4 ,
final vr_3 < ? extends vt_1 > vr_5 ) {
return fn_2 ( new vr_3 [] { vr_4 , vr_5 } ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_3 < vt_1 > fn_2 ( final vr_3 < ? extends vt_1 > vr_4 ,
final vr_3 < ? extends vt_1 > vr_5 ,
final vr_3 < ? extends vt_1 > vr_6 ) {
return fn_2 ( new vr_3 [] { vr_4 , vr_5 , vr_6 } ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vr_3 < vt_1 > fn_2 ( final vr_3 < ? extends vt_1 > vr_4 ,
final vr_3 < ? extends vt_1 > vr_5 ,
final vr_3 < ? extends vt_1 > vr_6 ,
final vr_3 < ? extends vt_1 > vr_7 ) {
return fn_2 ( new vr_3 [] { vr_4 , vr_5 , vr_6 , vr_7 } ) ;
}
@Override
protected Iterator < ? extends vt_1 > fn_3 ( final int vr_8 ) {
if ( vr_8 > vr_9 . length ) {
return null ;
}
return vr_9 [ vr_8 - 1 ] . iterator () ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_1 . vr_10 ( null , vr_4 . iterator () , vr_5 . iterator () ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_1 . vr_10 ( vl_2 , vr_4 . iterator () , vr_5 . iterator () ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_1 . vr_11 ( fn_4 ( vl_3 ) , vl_4 ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_1 . vr_12 ( vl_3 . iterator () , vl_5 ) ;
}
@Override
protected Iterator < ? extends vt_1 > fn_3 ( final int vr_8 ) {
if ( vr_13 . isEmpty ( vl_3 ) ) {
return null ;
}
return vl_3 . iterator () ;
}
@Override
public Iterator < vt_1 > iterator () {
final List < vt_1 > list = ( vl_3 instanceof List < ? > ) ?
( List < vt_1 > ) vl_3 :
vr_1 . vr_14 ( vl_3 . iterator () ) ;
return new vr_15 <> ( list ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_1 . vr_16 ( vl_3 . iterator () , vl_6 ) ;
}
@Override
public Iterator < vt_2 > iterator () {
return vr_1 . vr_17 ( vl_3 . iterator () , vl_7 ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return new vr_18 <> ( vl_3 . iterator () ) ;
}
public static < vt_1 > vr_3 < vt_1 > fn_5 ( final vr_3 < vt_1 > vl_3 ) {
fn_6 ( vl_3 ) ;
if ( vl_3 instanceof vr_19 < ? > ) {
return vl_3 ;
}
return new vr_19 <> ( vl_3 ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_1 . vr_20 ( vr_21 . iterator () ) ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_1 . vr_22 ( vr_4 . iterator () , vr_5 . iterator () ) ;
}
@Override
public Iterator < vt_1 > iterator () {
@SuppressWarnings ( lr_1 )
final
Iterator < ? extends vt_1 > [] vr_23 = new Iterator [ vr_24 . length + 1 ] ;
vr_23 [ 0 ] = vr_25 . iterator () ;
for ( int vr_26 = 0 ; vr_26 < vr_24 . length ; vr_26 ++ ) {
vr_23 [ vr_26 + 1 ] = vr_24 [ vr_26 ] . iterator () ;
}
return vr_1 . vr_22 ( vr_23 ) ;
}
public static < vt_1 > vr_3 < vt_1 > fn_7 ( final vr_3 < vt_1 > vl_3 ) {
return vl_3 == null ? vr_13 . <vt_1 > fn_1 () : vl_3 ;
}
public static < vt_1 > void fn_8 ( final vr_3 < vt_1 > vl_3 , final vr_27 < ? super vt_1 > vr_28 ) {
vr_1 . fn_8 ( fn_4 ( vl_3 ) , vr_28 ) ;
}
public static < vt_1 > vt_1 fn_9 ( final vr_3 < vt_1 > vl_3 , final vr_27 < ? super vt_1 > vr_28 ) {
return vr_1 . fn_9 ( fn_4 ( vl_3 ) , vr_28 ) ;
}
public static < vt_1 > vt_1 fn_10 ( final vr_3 < vt_1 > vl_3 , final vr_29 < ? super vt_1 > vl_4 ) {
return vr_1 . fn_10 ( fn_4 ( vl_3 ) , vl_4 ) ;
}
public static < vt_1 > int indexOf ( final vr_3 < vt_1 > vl_3 , final vr_29 < ? super vt_1 > vl_4 ) {
return vr_1 . indexOf ( fn_4 ( vl_3 ) , vl_4 ) ;
}
public static < vt_1 > boolean fn_11 ( final vr_3 < vt_1 > vl_3 , final vr_29 < ? super vt_1 > vl_4 ) {
return vr_1 . fn_11 ( fn_4 ( vl_3 ) , vl_4 ) ;
}
public static < vt_1 > boolean fn_12 ( final vr_3 < vt_1 > vl_3 , final vr_29 < ? super vt_1 > vl_4 ) {
return vr_1 . fn_12 ( fn_4 ( vl_3 ) , vl_4 ) ;
}
public static < vt_1 > long fn_13 ( final vr_3 < vt_1 > vr_30 , final vr_29 < ? super vt_1 > vl_4 ) {
vr_31 . vr_32 ( vl_4 , lr_2 ) ;
return size ( fn_14 ( fn_7 ( vr_30 ) , vl_4 ) ) ;
}
public static boolean isEmpty ( final vr_3 < ? > vl_3 ) {
if ( vl_3 instanceof Collection < ? > ) {
return ( ( Collection < ? > ) vl_3 ) . isEmpty () ;
}
return vr_1 . isEmpty ( fn_4 ( vl_3 ) ) ;
}
public static < vt_1 > boolean contains ( final vr_3 < vt_1 > vl_3 , final Object object ) {
if ( vl_3 instanceof Collection < ? > ) {
return ( ( Collection < vt_1 > ) vl_3 ) . contains ( object ) ;
}
return vr_1 . contains ( fn_4 ( vl_3 ) , object ) ;
}
public static < vt_1 > boolean contains ( final vr_3 < ? extends vt_1 > vl_3 , final vt_1 object ,
final vr_33 < ? super vt_1 > vr_34 ) {
vr_31 . vr_32 ( vr_34 , lr_3 ) ;
return fn_12 ( vl_3 , vr_35 . vr_36 ( object , vr_34 ) ) ;
}
public static < vt_1 , vt_3 extends vt_1 > int fn_15 ( final vr_3 < vt_1 > vl_3 , final vt_3 vr_37 ) {
if ( vl_3 instanceof vr_38 < ? > ) {
return ( ( vr_38 < vt_1 > ) vl_3 ) . contains ( vr_37 ) ? 1 : 0 ;
}
if ( vl_3 instanceof vr_39 < ? > ) {
return ( ( vr_39 < vt_1 > ) vl_3 ) . fn_16 ( vr_37 ) ;
}
return size ( fn_14 ( fn_7 ( vl_3 ) , vr_35 . <vt_1 > vr_36 ( vr_37 ) ) ) ;
}
public static < vt_3 > vt_3 get ( final vr_3 < vt_3 > vl_3 , final int vr_40 ) {
vr_41 . vr_42 ( vr_40 ) ;
if ( vl_3 instanceof List < ? > ) {
return ( ( List < vt_3 > ) vl_3 ) . get ( vr_40 ) ;
}
return vr_1 . get ( fn_4 ( vl_3 ) , vr_40 ) ;
}
public static < vt_3 > vt_3 vr_25 ( final vr_3 < vt_3 > vl_3 ) {
return get ( vl_3 , 0 ) ;
}
public static int size ( final vr_3 < ? > vl_3 ) {
if ( vl_3 instanceof Collection < ? > ) {
return ( ( Collection < ? > ) vl_3 ) . size () ;
}
return vr_1 . size ( fn_4 ( vl_3 ) ) ;
}
public static < vt_2 > List < List < vt_2 > > fn_17 ( final vr_3 < ? extends vt_2 > vl_3 ,
final vr_29 < ? super vt_2 > vl_4 ) {
vr_31 . vr_32 ( vl_4 , lr_2 ) ;
@SuppressWarnings ( { lr_1 , lr_4 } )
final vr_43 < List < vt_2 > > vr_44 = vr_45 . vr_46 ( ( Class ) ArrayList . class ) ;
@SuppressWarnings ( lr_1 )
final vr_29 < ? super vt_2 > [] vr_47 = new vr_29 [] { vl_4 } ;
return fn_17 ( vl_3 , vr_44 , vr_47 ) ;
}
public static < vt_2 > List < List < vt_2 > > fn_17 ( final vr_3 < ? extends vt_2 > vl_3 ,
final vr_29 < ? super vt_2 > ... vr_47 ) {
@SuppressWarnings ( { lr_1 , lr_4 } )
final vr_43 < List < vt_2 > > vr_44 = vr_45 . vr_46 ( ( Class ) ArrayList . class ) ;
return fn_17 ( vl_3 , vr_44 , vr_47 ) ;
}
public static < vt_2 , vt_4 extends Collection < vt_2 > > List < vt_4 > fn_17 ( final vr_3 < ? extends vt_2 > vl_3 ,
final vr_43 < vt_4 > vr_48 , final vr_29 < ? super vt_2 > ... vr_47 ) {
if ( vl_3 == null ) {
final vr_3 < vt_2 > vr_49 = fn_1 () ;
return fn_17 ( vr_49 , vr_48 , vr_47 ) ;
}
vr_31 . vr_32 ( vr_47 , lr_5 ) ;
for ( final vr_29 < ? > vl_4 : vr_47 ) {
vr_31 . vr_32 ( vl_4 , lr_2 ) ;
}
if ( vr_47 . length < 1 ) {
final vt_4 vr_50 = vr_48 . vr_51 () ;
vr_41 . vr_52 ( vr_50 , vl_3 ) ;
return vr_53 . vr_54 ( vr_50 ) ;
}
final int vr_55 = vr_47 . length ;
final int vr_56 = vr_55 + 1 ;
final List < vt_4 > vr_57 = new ArrayList <> ( vr_56 ) ;
for ( int vr_26 = 0 ; vr_26 < vr_56 ; ++ vr_26 ) {
vr_57 . add ( vr_48 . vr_51 () ) ;
}
for ( final vt_2 vr_58 : vl_3 ) {
boolean vr_59 = false ;
for ( int vr_26 = 0 ; vr_26 < vr_55 ; ++ vr_26 ) {
if ( vr_47 [ vr_26 ] . fn_18 ( vr_58 ) ) {
vr_57 . get ( vr_26 ) . add ( vr_58 ) ;
vr_59 = true ;
break;
}
}
if ( ! vr_59 ) {
vr_57 . get ( vr_55 ) . add ( vr_58 ) ;
}
}
return vr_57 ;
}
public static < vt_1 > List < vt_1 > vr_14 ( final vr_3 < vt_1 > vl_3 ) {
return vr_1 . vr_14 ( fn_4 ( vl_3 ) ) ;
}
public static < vt_1 > String toString ( final vr_3 < vt_1 > vl_3 ) {
return vr_1 . toString ( fn_4 ( vl_3 ) ) ;
}
public static < vt_1 > String toString ( final vr_3 < vt_1 > vl_3 ,
final vr_60 < ? super vt_1 , String > vl_7 ) {
vr_31 . vr_32 ( vl_7 , lr_6 ) ;
return vr_1 . toString ( fn_4 ( vl_3 ) , vl_7 ) ;
}
public static < vt_1 > String toString ( final vr_3 < vt_1 > vl_3 ,
final vr_60 < ? super vt_1 , String > vl_7 ,
final String vr_61 ,
final String vr_62 ,
final String vr_63 ) {
return vr_1 . toString ( fn_4 ( vl_3 ) ,
vl_7 , vr_61 , vr_62 , vr_63 ) ;
}
static void fn_6 ( final vr_3 < ? > vl_3 ) {
vr_31 . vr_32 ( vl_3 , lr_7 ) ;
}
static void fn_6 ( final vr_3 < ? > ... vr_9 ) {
vr_31 . vr_32 ( vr_9 , lr_8 ) ;
for ( final vr_3 < ? > vl_3 : vr_9 ) { MST[rv.UOI2Mutator]MSP[S]
fn_6 ( vl_3 ) ;
}
}
private static < vt_1 > Iterator < vt_1 > fn_4 ( final vr_3 < vt_1 > vl_3 ) {
return vl_3 != null ? vl_3 . iterator () : vr_1 . <vt_1 > vr_2 () ;
}
