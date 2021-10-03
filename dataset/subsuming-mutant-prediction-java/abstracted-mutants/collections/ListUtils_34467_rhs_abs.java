public static < vt_1 > List < vt_1 > fn_1 ( final List < vt_1 > list ) {
return list == null ? vr_1 . <vt_1 > fn_2 () : list ;
}
public static < vt_1 > List < vt_1 > fn_3 ( final List < vt_1 > list , final List < vt_1 > vr_2 ) {
return list == null ? vr_2 : list ;
}
public static < vt_2 > List < vt_2 > fn_4 ( final List < ? extends vt_2 > vr_3 , final List < ? extends vt_2 > vr_4 ) {
final List < vt_2 > vr_5 = new ArrayList <> () ; MST[ConstructorCallMutator]MSP[N]
List < ? extends vt_2 > vr_6 = vr_3 ;
List < ? extends vt_2 > vr_7 = vr_4 ;
if ( vr_3 . size () > vr_4 . size () ) {
vr_6 = vr_4 ;
vr_7 = vr_3 ;
}
final vr_8 < vt_2 > vr_9 = new vr_8 <> ( vr_6 ) ;
for ( final vt_2 vr_10 : vr_7 ) {
if ( vr_9 . contains ( vr_10 ) ) {
vr_5 . add ( vr_10 ) ;
vr_9 . remove ( vr_10 ) ;
}
}
return vr_5 ;
}
public static < vt_2 > List < vt_2 > fn_5 ( final List < vt_2 > vr_3 , final List < ? extends vt_2 > vr_4 ) {
final ArrayList < vt_2 > vr_5 = new ArrayList <> () ;
final vr_11 < vt_2 > vr_12 = new vr_11 <> ( vr_4 ) ;
for ( final vt_2 vr_10 : vr_3 ) {
if ( ! vr_12 . remove ( vr_10 , 1 ) ) {
vr_5 . add ( vr_10 ) ;
}
}
return vr_5 ;
}
public static < vt_2 > List < vt_2 > fn_6 ( final List < ? extends vt_2 > vr_3 , final List < ? extends vt_2 > vr_4 ) {
return fn_5 ( union ( vr_3 , vr_4 ) , fn_4 ( vr_3 , vr_4 ) ) ;
}
public static < vt_2 > List < vt_2 > union ( final List < ? extends vt_2 > vr_3 , final List < ? extends vt_2 > vr_4 ) {
final ArrayList < vt_2 > vr_5 = new ArrayList <> ( vr_3 . size () + vr_4 . size () ) ;
vr_5 . vr_13 ( vr_3 ) ;
vr_5 . vr_13 ( vr_4 ) ;
return vr_5 ;
}
public static < vt_2 > List < vt_2 > fn_7 ( final Collection < ? extends vt_2 > vr_14 ,
final vr_15 < ? super vt_2 > vr_16 ) {
return vr_17 . fn_7 ( vr_14 , vr_16 , new ArrayList < vt_2 > ( vr_14 . size () ) ) ;
}
public static < vt_2 > List < vt_2 > fn_8 ( final Collection < ? extends vt_2 > vr_14 ,
final vr_15 < ? super vt_2 > vr_16 ) {
return vr_17 . fn_8 ( vr_14 , vr_16 , new ArrayList < vt_2 > ( vr_14 . size () ) ) ;
}
public static boolean fn_9 ( final Collection < ? > vr_3 , final Collection < ? > vr_4 ) {
if ( vr_3 == vr_4 ) {
return true ;
}
if ( vr_3 == null || vr_4 == null || vr_3 . size () != vr_4 . size () ) {
return false ;
}
final Iterator < ? > vr_18 = vr_3 . iterator () ;
final Iterator < ? > vr_19 = vr_4 . iterator () ;
Object vr_20 = null ;
Object vr_21 = null ;
while ( vr_18 . hasNext () && vr_19 . hasNext () ) {
vr_20 = vr_18 . vr_22 () ;
vr_21 = vr_19 . vr_22 () ;
if ( ! ( vr_20 == null ? vr_21 == null : vr_20 . equals ( vr_21 ) ) ) {
return false ;
}
}
return ! ( vr_18 . hasNext () || vr_19 . hasNext () ) ;
}
public static int fn_10 ( final Collection < ? > list ) {
if ( list == null ) {
return 0 ;
}
int vr_23 = 1 ;
final Iterator < ? > vr_24 = list . iterator () ;
while ( vr_24 . hasNext () ) {
final Object vr_25 = vr_24 . vr_22 () ;
vr_23 = 31 * vr_23 + ( vr_25 == null ? 0 : vr_25 . vr_23 () ) ;
}
return vr_23 ;
}
public static < vt_2 > List < vt_2 > fn_11 ( final Collection < vt_2 > collection , final Collection < ? > vr_26 ) {
final List < vt_2 > list = new ArrayList <> ( vr_27 . vr_28 ( collection . size () , vr_26 . size () ) ) ;
for ( final vt_2 vr_25 : collection ) {
if ( vr_26 . contains ( vr_25 ) ) {
list . add ( vr_25 ) ;
}
}
return list ;
}
public static < vt_2 > List < vt_2 > fn_12 ( final Collection < vt_2 > collection , final Collection < ? > remove ) {
final List < vt_2 > list = new ArrayList <> () ;
for ( final vt_2 vr_25 : collection ) {
if ( ! remove . contains ( vr_25 ) ) {
list . add ( vr_25 ) ;
}
}
return list ;
}
public static < vt_2 > List < vt_2 > fn_13 ( final List < vt_2 > list ) {
return vr_1 . fn_13 ( list ) ;
}
public static < vt_2 > List < vt_2 > fn_14 ( final List < ? extends vt_2 > list ) {
return vr_29 . fn_14 ( list ) ;
}
public static < vt_2 > List < vt_2 > fn_15 ( final List < vt_2 > list , final vr_15 < vt_2 > vr_16 ) {
return vr_30 . fn_15 ( list , vr_16 ) ;
}
public static < vt_2 > List < vt_2 > fn_16 ( final List < vt_2 > list ,
final vr_31 < ? super vt_2 , ? extends vt_2 > vr_32 ) {
return vr_33 . vr_34 ( list , vr_32 ) ;
}
public static < vt_2 > List < vt_2 > fn_17 ( final List < vt_2 > list , final vr_35 < ? extends vt_2 > vr_36 ) {
return vr_37 . fn_17 ( list , vr_36 ) ;
}
public static < vt_2 > List < vt_2 > fn_17 ( final List < vt_2 > list , final vr_31 < Integer , ? extends vt_2 > vr_32 ) {
return vr_37 . fn_17 ( list , vr_32 ) ;
}
public static < vt_2 > List < vt_2 > fn_18 ( final List < vt_2 > list ) {
return vr_38 . fn_18 ( list ) ;
}
public static < vt_2 > int indexOf ( final List < vt_2 > list , final vr_15 < vt_2 > vr_16 ) {
if ( list != null && vr_16 != null ) {
for ( int vr_39 = 0 ; vr_39 < list . size () ; vr_39 ++ ) {
final vt_2 vr_40 = list . get ( vr_39 ) ;
if ( vr_16 . vr_41 ( vr_40 ) ) {
return vr_39 ;
}
}
}
return - 1 ;
}
public static < vt_2 > List < vt_2 > fn_19 ( final List < vt_2 > vr_42 , final List < vt_2 > vr_43 ) {
return fn_19 ( vr_42 , vr_43 , vr_44 . vr_45 () ) ;
}
public static < vt_2 > List < vt_2 > fn_19 ( final List < vt_2 > vr_46 , final List < vt_2 > vr_47 ,
final vr_48 < ? super vt_2 > vr_49 ) {
vr_50 . vr_51 ( vr_46 , lr_1 ) ;
vr_50 . vr_51 ( vr_47 , lr_2 ) ;
vr_50 . vr_51 ( vr_49 , lr_3 ) ;
final vr_52 < vt_2 > vr_53 = new vr_52 <> ( vr_46 , vr_47 , vr_49 ) ;
final vr_54 < vt_2 > vr_55 = vr_53 . vr_56 () ;
final vr_57 < vt_2 > vr_58 = new vr_57 <> () ;
vr_55 . vr_59 ( vr_58 ) ;
return vr_58 . vr_60 () ;
}
public static String fn_19 ( final tp_1 vr_61 , final tp_1 vr_62 ) {
vr_50 . vr_51 ( vr_61 , lr_4 ) ;
vr_50 . vr_51 ( vr_62 , lr_5 ) ;
final List < vt_3 > vr_63 = fn_19 ( new fn_20 ( vr_61 ) ,
new fn_20 ( vr_62 ) ) ;
final StringBuilder vr_64 = new StringBuilder () ;
for ( final vt_3 vr_65 : vr_63 ) {
vr_64 . append ( vr_65 ) ;
}
return vr_64 . toString () ;
}
@Override
public void fn_21 ( final vt_2 object ) {
}
@Override
public void fn_22 ( final vt_2 object ) {
}
@Override
public void fn_23 ( final vt_2 object ) {
vr_66 . add ( object ) ;
}
public List < vt_2 > vr_60 () {
return vr_66 ;
}
@Override
public vt_3 get ( final int vr_67 ) {
return vt_3 . valueOf ( vr_66 . charAt ( vr_67 ) ) ;
}
@Override
public int size () {
return vr_66 . length () ;
}
public static < vt_1 > List < List < vt_1 > > fn_24 ( final List < vt_1 > list , final int size ) {
vr_50 . vr_51 ( list , lr_6 ) ;
if ( size <= 0 ) {
throw new IllegalArgumentException ( lr_7 ) ;
}
return new vr_68 <> ( list , size ) ;
}
@Override
public List < vt_1 > get ( final int vr_67 ) {
final int vr_69 = size () ;
if ( vr_67 < 0 ) {
throw new fn_25 ( lr_8 + vr_67 + lr_9 ) ;
}
if ( vr_67 >= vr_69 ) {
throw new fn_25 ( lr_8 + vr_67 + lr_10 +
vr_69 ) ;
}
final int vr_70 = vr_67 * size ;
final int vr_71 = vr_27 . vr_28 ( vr_70 + size , list . size () ) ;
return list . vr_72 ( vr_70 , vr_71 ) ;
}
@Override
public int size () {
return ( int ) vr_27 . ceil ( ( double ) list . size () / ( double ) size ) ;
}
@Override
public boolean isEmpty () {
return list . isEmpty () ;
}
