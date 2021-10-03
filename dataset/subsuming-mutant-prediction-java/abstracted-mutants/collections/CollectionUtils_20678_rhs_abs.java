public final int fn_1 ( final Object vr_1 ) {
return vr_2 . fn_1 ( fn_2 ( vr_1 ) , fn_3 ( vr_1 ) ) ;
}
public final int fn_4 ( final Object vr_1 ) {
return vr_2 . fn_4 ( fn_2 ( vr_1 ) , fn_3 ( vr_1 ) ) ;
}
public int fn_2 ( final Object vr_1 ) {
return fn_5 ( vr_1 , vl_1 ) ;
}
public int fn_3 ( final Object vr_1 ) {
return fn_5 ( vr_1 , vl_2 ) ;
}
private int fn_5 ( final Object vr_1 , final vr_3 < ? , Integer > vr_4 ) {
final Integer vr_5 = vr_4 . get ( vr_1 ) ;
if ( vr_5 != null ) {
return vr_5 . vr_6 () ;
}
return 0 ;
}
@Override
public Iterator < vt_1 > iterator () {
return vr_7 . iterator () ;
}
public void fn_6 ( final vt_1 vr_1 , final int vr_5 ) {
for ( int vr_8 = 0 ; vr_8 < vr_5 ; vr_8 ++ ) {
vr_9 . add ( vr_1 ) ;
}
}
public Collection < vt_1 > list () {
return vr_9 ;
}
@SuppressWarnings ( lr_1 )
public static < vt_2 > Collection < vt_2 > fn_7 () {
return vl_3 ;
}
public static < vt_2 > Collection < vt_2 > fn_8 ( final Collection < vt_2 > collection ) {
return collection == null ? vr_10 . <vt_2 > fn_7 () : collection ;
}
public static < vt_1 > Collection < vt_1 > union ( final vr_11 < ? extends vt_1 > vr_12 , final vr_11 < ? extends vt_1 > vr_13 ) {
final vr_14 < vt_1 > vr_15 = new vr_14 <> ( vr_12 , vr_13 ) ;
for ( final vt_1 vr_1 : vr_15 ) {
vr_15 . fn_6 ( vr_1 , vr_15 . fn_1 ( vr_1 ) ) ;
}
return vr_15 . list () ;
}
public static < vt_1 > Collection < vt_1 > fn_9 ( final vr_11 < ? extends vt_1 > vr_12 , final vr_11 < ? extends vt_1 > vr_13 ) {
final vr_14 < vt_1 > vr_15 = new vr_14 <> ( vr_12 , vr_13 ) ;
for ( final vt_1 vr_1 : vr_15 ) {
vr_15 . fn_6 ( vr_1 , vr_15 . fn_4 ( vr_1 ) ) ;
}
return vr_15 . list () ;
}
public static < vt_1 > Collection < vt_1 > fn_10 ( final vr_11 < ? extends vt_1 > vr_12 , final vr_11 < ? extends vt_1 > vr_13 ) {
final vr_14 < vt_1 > vr_15 = new vr_14 <> ( vr_12 , vr_13 ) ;
for ( final vt_1 vr_1 : vr_15 ) {
vr_15 . fn_6 ( vr_1 , vr_15 . fn_1 ( vr_1 ) - vr_15 . fn_4 ( vr_1 ) ) ;
}
return vr_15 . list () ;
}
public static < vt_1 > Collection < vt_1 > fn_11 ( final vr_11 < ? extends vt_1 > vr_12 , final vr_11 < ? extends vt_1 > vr_13 ) {
final vr_16 < vt_1 > vr_17 = vr_18 . vr_19 () ;
return fn_11 ( vr_12 , vr_13 , vr_17 ) ;
}
public static < vt_1 > Collection < vt_1 > fn_11 ( final vr_11 < ? extends vt_1 > vr_12 ,
final vr_11 < ? extends vt_1 > vr_13 ,
final vr_16 < vt_1 > vr_17 ) {
final ArrayList < vt_1 > list = new ArrayList <> () ;
final vr_20 < vt_1 > vr_21 = new vr_20 <> () ;
for ( final vt_1 vr_22 : vr_13 ) {
if ( vr_17 . vr_23 ( vr_22 ) ) {
vr_21 . add ( vr_22 ) ;
}
}
for ( final vt_1 vr_22 : vr_12 ) {
if ( ! vr_21 . remove ( vr_22 , 1 ) ) {
list . add ( vr_22 ) ;
}
}
return list ;
}
public static boolean fn_12 ( final Collection < ? > vr_24 , final Collection < ? > vr_25 ) {
if ( vr_25 . isEmpty () ) {
return true ;
}
final Iterator < ? > vr_26 = vr_24 . iterator () ;
final vr_27 < Object > vr_28 = new vr_29 <> () ;
for ( final Object nextElement : vr_25 ) {
if ( vr_28 . contains ( nextElement ) ) {
continue;
}
boolean vr_30 = false ;
while ( vr_26 . hasNext () ) {
final Object vr_17 = vr_26 . vr_31 () ;
vr_28 . add ( vr_17 ) ;
if ( nextElement == null ? vr_17 == null : nextElement . equals ( vr_17 ) ) {
vr_30 = true ;
break;
}
}
if ( ! vr_30 ) {
return false ;
}
}
return true ;
}
public static < vt_2 > boolean fn_13 ( final Collection < ? > vr_24 , @SuppressWarnings ( lr_1 ) final vt_2 ... vr_25 ) {
if ( vr_24 . size () < vr_25 . length ) {
for ( final Object vr_32 : vr_24 ) {
if ( vr_33 . contains ( vr_25 , vr_32 ) ) {
return true ;
}
}
} else {
for ( final Object vr_34 : vr_25 ) {
if ( vr_24 . contains ( vr_34 ) ) {
return true ;
}
}
}
return false ;
}
public static boolean fn_13 ( final Collection < ? > vr_24 , final Collection < ? > vr_25 ) {
if ( vr_24 . size () < vr_25 . size () ) {
for ( final Object vr_32 : vr_24 ) {
if ( vr_25 . contains ( vr_32 ) ) {
return true ;
}
}
} else {
for ( final Object vr_34 : vr_25 ) {
if ( vr_24 . contains ( vr_34 ) ) {
return true ;
}
}
}
return false ;
}
public static < vt_1 > vr_3 < vt_1 , Integer > fn_14 ( final vr_11 < ? extends vt_1 > vr_35 ) {
final vr_3 < vt_1 , Integer > vr_5 = new vr_36 <> () ;
for ( final vt_1 vr_1 : vr_35 ) {
final Integer vr_37 = vr_5 . get ( vr_1 ) ;
if ( vr_37 == null ) {
vr_5 . vr_38 ( vr_1 , Integer . valueOf ( 1 ) ) ;
} else {
vr_5 . vr_38 ( vr_1 , Integer . valueOf ( vr_37 . vr_6 () + 1 ) ) ;
}
}
return vr_5 ;
}
public static boolean fn_15 ( final Collection < ? > vr_12 , final Collection < ? > vr_13 ) {
final vr_39 < Object > vr_15 = new vr_39 <> ( vr_12 , vr_13 ) ;
for ( final Object vr_1 : vr_12 ) {
if ( vr_15 . fn_2 ( vr_1 ) > vr_15 . fn_3 ( vr_1 ) ) {
return false ;
}
}
return true ;
}
public static boolean fn_16 ( final Collection < ? > vr_12 , final Collection < ? > vr_13 ) {
return vr_12 . size () < vr_13 . size () && vr_10 . fn_15 ( vr_12 , vr_13 ) ;
}
public static boolean fn_17 ( final Collection < ? > vr_12 , final Collection < ? > vr_13 ) {
if ( vr_12 . size () != vr_13 . size () ) {
return false ;
}
final vr_39 < Object > vr_15 = new vr_39 <> ( vr_12 , vr_13 ) ;
if ( vr_15 . vl_1 . size () != vr_15 . vl_2 . size () ) {
return false ;
}
for ( final Object vr_1 : vr_15 . vl_1 . vr_40 () ) {
if ( vr_15 . fn_2 ( vr_1 ) != vr_15 . fn_3 ( vr_1 ) ) {
return false ;
}
}
return true ;
}
public static < vt_3 > boolean fn_17 ( final Collection < ? extends vt_3 > vr_12 ,
final Collection < ? extends vt_3 > vr_13 ,
final vr_41 < ? super vt_3 > vr_42 ) {
vr_43 . vr_44 ( vr_42 , lr_2 ) ;
if ( vr_12 . size () != vr_13 . size () ) {
return false ;
}
@SuppressWarnings ( { lr_1 , lr_3 } )
final vr_45 < vt_3 , ? > vr_46 = vr_47 -> new fn_18 ( vr_42 , vr_47 ) ;
return fn_17 ( fn_19 ( vr_12 , vr_46 ) , fn_19 ( vr_13 , vr_46 ) ) ;
}
public vt_1 fn_20 () {
return object ;
}
@Override
public boolean equals ( final Object vr_1 ) {
if ( ! ( vr_1 instanceof fn_18 ) ) {
return false ;
}
@SuppressWarnings ( lr_1 )
final fn_18 < vt_1 > vr_48 = ( fn_18 < vt_1 > ) vr_1 ;
return vr_42 . vr_49 ( object , vr_48 . fn_20 () ) ;
}
@Override
public int fn_21 () {
return vr_42 . vr_50 ( object ) ;
}
@Deprecated
public static < vt_1 > int fn_22 ( final vt_1 vr_1 , final vr_11 < ? super vt_1 > collection ) {
return vr_51 . vr_52 ( vr_43 . vr_44 ( collection , lr_4 ) , vr_1 ) ;
}
@Deprecated
public static < vt_2 > vt_2 fn_23 ( final vr_11 < vt_2 > collection , final vr_16 < ? super vt_2 > vr_53 ) {
return vr_53 != null ? vr_51 . fn_23 ( collection , vr_53 ) : null ;
}
@Deprecated
public static < vt_2 , vt_4 extends vr_54 < ? super vt_2 > > vt_4 fn_24 ( final vr_11 < vt_2 > collection , final vt_4 vr_55 ) {
if ( vr_55 != null ) {
vr_51 . vr_56 ( collection , vr_55 ) ;
}
return vr_55 ;
}
@Deprecated
public static < vt_2 , vt_4 extends vr_54 < ? super vt_2 > > vt_4 fn_24 ( final Iterator < vt_2 > iterator , final vt_4 vr_55 ) {
if ( vr_55 != null ) {
vr_57 . vr_56 ( iterator , vr_55 ) ;
}
return vr_55 ;
}
@Deprecated
public static < vt_2 , vt_4 extends vr_54 < ? super vt_2 > > vt_2 fn_25 ( final vr_11 < vt_2 > collection ,
final vt_4 vr_55 ) {
return vr_55 != null ? vr_51 . vr_58 ( collection , vr_55 ) : null ;
}
@Deprecated
public static < vt_2 , vt_4 extends vr_54 < ? super vt_2 > > vt_2 fn_25 ( final Iterator < vt_2 > iterator , final vt_4 vr_55 ) {
return vr_55 != null ? vr_57 . vr_58 ( iterator , vr_55 ) : null ;
}
public static < vt_2 > boolean fn_26 ( final vr_11 < vt_2 > collection , final vr_16 < ? super vt_2 > vr_53 ) {
boolean vr_59 = false ;
if ( collection != null && vr_53 != null ) {
for ( final Iterator < vt_2 > vr_26 = collection . iterator () ; vr_26 . hasNext () ; ) {
if ( ! vr_53 . vr_23 ( vr_26 . vr_31 () ) ) {
vr_26 . remove () ;
vr_59 = true ;
}
}
}
return vr_59 ;
}
public static < vt_2 > boolean fn_27 ( final vr_11 < vt_2 > collection , final vr_16 < ? super vt_2 > vr_53 ) {
return fn_26 ( collection , vr_53 == null ? null : vr_60 . vr_61 ( vr_53 ) ) ;
}
public static < vt_4 > void fn_28 ( final Collection < vt_4 > collection ,
final vr_45 < ? super vt_4 , ? extends vt_4 > vr_46 ) {
if ( collection != null && vr_46 != null ) {
if ( collection instanceof List < ? > ) {
final List < vt_4 > list = ( List < vt_4 > ) collection ;
for ( final vr_62 < vt_4 > vr_26 = list . vr_63 () ; vr_26 . hasNext () ; ) {
vr_26 . vr_64 ( vr_46 . fn_28 ( vr_26 . vr_31 () ) ) ;
}
} else {
final Collection < vt_4 > vr_65 = fn_19 ( collection , vr_46 ) ;
collection . clear () ;
collection . vr_66 ( vr_65 ) ;
}
}
@Deprecated
public static < vt_4 > int fn_29 ( final vr_11 < vt_4 > vr_47 , final vr_16 < ? super vt_4 > vr_53 ) {
return vr_53 == null ? 0 : ( int ) vr_51 . fn_29 ( vr_47 , vr_53 ) ;
}
@Deprecated
public static < vt_4 > boolean fn_30 ( final vr_11 < vt_4 > vr_47 , final vr_16 < ? super vt_4 > vr_53 ) {
return vr_53 != null && vr_51 . vr_67 ( vr_47 , vr_53 ) ;
}
@Deprecated
public static < vt_4 > boolean fn_31 ( final vr_11 < vt_4 > vr_47 , final vr_16 < ? super vt_4 > vr_53 ) {
return vr_53 != null && vr_51 . fn_31 ( vr_47 , vr_53 ) ; MST[rv.CRCR2Mutator]MSP[N]
}
public static < vt_1 > Collection < vt_1 > fn_32 ( final vr_11 < ? extends vt_1 > vr_68 ,
final vr_16 < ? super vt_1 > vr_53 ) {
final Collection < vt_1 > vr_69 = vr_68 instanceof Collection < ? > ?
new ArrayList <> ( ( ( Collection < ? > ) vr_68 ) . size () ) : new ArrayList <> () ;
return fn_32 ( vr_68 , vr_53 , vr_69 ) ;
}
public static < vt_1 , vt_5 extends Collection < ? super vt_1 > > vt_5 fn_32 ( final vr_11 < ? extends vt_1 > vr_68 ,
final vr_16 < ? super vt_1 > vr_53 , final vt_5 vr_70 ) {
if ( vr_68 != null && vr_53 != null ) {
for ( final vt_1 vr_71 : vr_68 ) {
if ( vr_53 . vr_23 ( vr_71 ) ) {
vr_70 . add ( vr_71 ) ;
}
}
}
return vr_70 ;
}
public static < vt_1 , vt_5 extends Collection < ? super vt_1 > > vt_5 fn_32 ( final vr_11 < ? extends vt_1 > vr_68 ,
final vr_16 < ? super vt_1 > vr_53 , final vt_5 vr_70 , final vt_5 vr_72 ) {
if ( vr_68 != null && vr_53 != null ) {
for ( final vt_1 vr_22 : vr_68 ) {
if ( vr_53 . vr_23 ( vr_22 ) ) {
vr_70 . add ( vr_22 ) ;
} else {
vr_72 . add ( vr_22 ) ;
}
}
}
return vr_70 ;
}
public static < vt_1 > Collection < vt_1 > fn_33 ( final vr_11 < ? extends vt_1 > vr_68 ,
final vr_16 < ? super vt_1 > vr_53 ) {
final Collection < vt_1 > vr_69 = vr_68 instanceof Collection < ? > ?
new ArrayList <> ( ( ( Collection < ? > ) vr_68 ) . size () ) : new ArrayList <> () ;
return fn_33 ( vr_68 , vr_53 , vr_69 ) ;
}
public static < vt_1 , vt_5 extends Collection < ? super vt_1 > > vt_5 fn_33 ( final vr_11 < ? extends vt_1 > vr_68 ,
final vr_16 < ? super vt_1 > vr_53 , final vt_5 vr_70 ) {
if ( vr_68 != null && vr_53 != null ) {
for ( final vt_1 vr_71 : vr_68 ) {
if ( ! vr_53 . vr_23 ( vr_71 ) ) {
vr_70 . add ( vr_71 ) ;
}
}
}
return vr_70 ;
}
public static < vt_6 , vt_1 > Collection < vt_1 > fn_19 ( final vr_11 < vt_6 > vr_68 ,
final vr_45 < ? super vt_6 , ? extends vt_1 > vr_46 ) {
final Collection < vt_1 > vr_69 = vr_68 instanceof Collection < ? > ?
new ArrayList <> ( ( ( Collection < ? > ) vr_68 ) . size () ) : new ArrayList <> () ;
return fn_19 ( vr_68 , vr_46 , vr_69 ) ;
}
public static < vt_6 , vt_1 > Collection < vt_1 > fn_19 ( final Iterator < vt_6 > vr_73 ,
final vr_45 < ? super vt_6 , ? extends vt_1 > vr_46 ) {
return fn_19 ( vr_73 , vr_46 , new ArrayList < vt_1 > () ) ;
}
public static < vt_6 , vt_1 , vt_5 extends Collection < ? super vt_1 > > vt_5 fn_19 ( final vr_11 < ? extends vt_6 > vr_68 ,
final vr_45 < ? super vt_6 , ? extends vt_1 > vr_46 , final vt_5 vr_70 ) {
if ( vr_68 != null ) {
return fn_19 ( vr_68 . iterator () , vr_46 , vr_70 ) ;
}
return vr_70 ;
}
public static < vt_6 , vt_1 , vt_5 extends Collection < ? super vt_1 > > vt_5 fn_19 ( final Iterator < ? extends vt_6 > vr_73 ,
final vr_45 < ? super vt_6 , ? extends vt_1 > vr_46 , final vt_5 vr_70 ) {
if ( vr_73 != null && vr_46 != null ) {
while ( vr_73 . hasNext () ) {
final vt_6 vr_71 = vr_73 . vr_31 () ;
final vt_1 vr_74 = vr_46 . fn_28 ( vr_71 ) ;
vr_70 . add ( vr_74 ) ;
}
}
return vr_70 ;
}
public static < vt_2 > boolean fn_34 ( final Collection < vt_2 > collection , final vt_2 object ) {
vr_43 . vr_44 ( collection , lr_4 ) ;
return object != null && collection . add ( object ) ;
}
public static < vt_4 > boolean vr_66 ( final Collection < vt_4 > collection , final vr_11 < ? extends vt_4 > vr_75 ) {
if ( vr_75 instanceof Collection < ? > ) {
return collection . vr_66 ( ( Collection < ? extends vt_4 > ) vr_75 ) ;
}
return vr_66 ( collection , vr_75 . iterator () ) ;
}
public static < vt_4 > boolean vr_66 ( final Collection < vt_4 > collection , final Iterator < ? extends vt_4 > iterator ) {
boolean vr_76 = false ;
while ( iterator . hasNext () ) {
vr_76 |= collection . add ( iterator . vr_31 () ) ;
}
return vr_76 ;
}
public static < vt_4 > boolean vr_66 ( final Collection < vt_4 > collection , final Enumeration < ? extends vt_4 > enumeration ) {
boolean vr_76 = false ;
while ( enumeration . vr_77 () ) {
vr_76 |= collection . add ( enumeration . nextElement () ) ;
}
return vr_76 ;
}
public static < vt_4 > boolean vr_66 ( final Collection < vt_4 > collection , final vt_4 ... vr_7 ) {
boolean vr_76 = false ;
for ( final vt_4 vr_22 : vr_7 ) {
vr_76 |= collection . add ( vr_22 ) ;
}
return vr_76 ;
}
@Deprecated
public static < vt_2 > vt_2 get ( final Iterator < vt_2 > iterator , final int vr_78 ) {
return vr_57 . get ( iterator , vr_78 ) ;
}
static void fn_35 ( final int vr_78 ) {
if ( vr_78 < 0 ) {
throw new fn_36 ( lr_5 + vr_78 ) ;
}
}
@Deprecated
public static < vt_2 > vt_2 get ( final vr_11 < vt_2 > vr_75 , final int vr_78 ) {
return vr_51 . get ( vr_75 , vr_78 ) ;
}
public static Object get ( final Object object , final int vr_78 ) {
final int vr_8 = vr_78 ;
if ( vr_8 < 0 ) {
throw new fn_36 ( lr_5 + vr_8 ) ;
}
if ( object instanceof vr_3 < ? , ? > ) {
final vr_3 < ? , ? > vr_79 = ( vr_3 < ? , ? > ) object ;
final Iterator < ? > iterator = vr_79 . vr_80 () . iterator () ;
return vr_57 . get ( iterator , vr_8 ) ;
} else if ( object instanceof Object [] ) {
return ( ( Object [] ) object ) [ vr_8 ] ;
} else if ( object instanceof Iterator < ? > ) {
final Iterator < ? > vr_26 = ( Iterator < ? > ) object ;
return vr_57 . get ( vr_26 , vr_8 ) ;
} else if ( object instanceof vr_11 < ? > ) {
final vr_11 < ? > vr_75 = ( vr_11 < ? > ) object ;
return vr_51 . get ( vr_75 , vr_8 ) ;
} else if ( object instanceof Enumeration < ? > ) {
final Enumeration < ? > vr_26 = ( Enumeration < ? > ) object ;
return vr_81 . get ( vr_26 , vr_8 ) ;
} else if ( object == null ) {
throw new IllegalArgumentException ( lr_6 ) ;
} else {
try {
return Array . get ( object , vr_8 ) ;
} catch ( final IllegalArgumentException vr_82 ) {
throw new IllegalArgumentException ( lr_7 + object . getClass () . fn_37 () ) ;
}
}
}
public static < vt_7 , vt_8 > vr_3 . vr_83 < vt_7 , vt_8 > get ( final vr_3 < vt_7 , vt_8 > vr_79 , final int vr_78 ) {
fn_35 ( vr_78 ) ;
return get ( vr_79 . vr_80 () , vr_78 ) ;
}
public static int size ( final Object object ) {
if ( object == null ) {
return 0 ;
}
int vr_84 = 0 ;
if ( object instanceof vr_3 < ? , ? > ) {
vr_84 = ( ( vr_3 < ? , ? > ) object ) . size () ;
} else if ( object instanceof Collection < ? > ) {
vr_84 = ( ( Collection < ? > ) object ) . size () ;
} else if ( object instanceof vr_11 < ? > ) {
vr_84 = vr_51 . size ( ( vr_11 < ? > ) object ) ;
} else if ( object instanceof Object [] ) {
vr_84 = ( ( Object [] ) object ) . length ;
} else if ( object instanceof Iterator < ? > ) {
vr_84 = vr_57 . size ( ( Iterator < ? > ) object ) ;
} else if ( object instanceof Enumeration < ? > ) {
final Enumeration < ? > vr_26 = ( Enumeration < ? > ) object ;
while ( vr_26 . vr_77 () ) {
vr_84 ++ ;
vr_26 . nextElement () ;
}
}
static boolean fn_38 ( final Object object ) {
if ( object == null ) {
return true ;
} else if ( object instanceof Collection < ? > ) {
return ( ( Collection < ? > ) object ) . isEmpty () ;
} else if ( object instanceof vr_11 < ? > ) {
return vr_51 . isEmpty ( ( vr_11 < ? > ) object ) ;
} else if ( object instanceof vr_3 < ? , ? > ) {
return ( ( vr_3 < ? , ? > ) object ) . isEmpty () ;
} else if ( object instanceof Object [] ) {
return ( ( Object [] ) object ) . length == 0 ;
} else if ( object instanceof Iterator < ? > ) {
return ( ( Iterator < ? > ) object ) . hasNext () == false ;
} else if ( object instanceof Enumeration < ? > ) {
return ( ( Enumeration < ? > ) object ) . vr_77 () == false ;
} else {
try {
return Array . vr_85 ( object ) == 0 ;
} catch ( final IllegalArgumentException vr_82 ) {
throw new IllegalArgumentException ( lr_7 + object . getClass () . fn_37 () ) ;
}
}
}
public static boolean isEmpty ( final Collection < ? > vr_35 ) {
return vr_35 == null || vr_35 . isEmpty () ;
}
public static boolean fn_39 ( final Collection < ? > vr_35 ) {
return ! isEmpty ( vr_35 ) ;
}
public static void fn_40 ( final Object [] array ) {
int vr_8 = 0 ;
int vr_86 = array . length - 1 ;
Object vr_87 ;
while ( vr_86 > vr_8 ) {
vr_87 = array [ vr_86 ] ;
array [ vr_86 ] = array [ vr_8 ] ;
array [ vr_8 ] = vr_87 ;
vr_86 -- ;
vr_8 ++ ;
}
}
public static boolean fn_41 ( final Collection < ? extends Object > collection ) {
vr_43 . vr_44 ( collection , lr_4 ) ;
if ( collection instanceof vl_4 ) {
return ( ( vl_4 < ? > ) collection ) . fn_41 () ;
}
try {
final vl_4 < ? > vr_88 =
vr_89 . vr_90 ( collection ) ;
return vr_88 . fn_41 () ;
} catch ( final IllegalArgumentException vr_82 ) {
return false ;
}
}
public static int fn_42 ( final Collection < ? extends Object > collection ) {
vr_43 . vr_44 ( collection , lr_4 ) ;
if ( collection instanceof vl_4 ) {
return ( ( vl_4 < ? > ) collection ) . fn_42 () ;
}
try {
final vl_4 < ? > vr_88 =
vr_89 . vr_90 ( collection ) ;
return vr_88 . fn_42 () ;
} catch ( final IllegalArgumentException vr_82 ) {
return - 1 ;
}
}
public static < vt_1 extends vr_91 < ? super vt_1 > > List < vt_1 > fn_43 ( final vr_11 < ? extends vt_1 > vr_12 ,
final vr_11 < ? extends vt_1 > vr_13 ) {
return fn_43 ( vr_12 , vr_13 , vr_92 . <vt_1 > fn_44 () , true ) ;
}
public static < vt_1 extends vr_91 < ? super vt_1 > > List < vt_1 > fn_43 ( final vr_11 < ? extends vt_1 > vr_12 ,
final vr_11 < ? extends vt_1 > vr_13 ,
final boolean vr_93 ) {
return fn_43 ( vr_12 , vr_13 , vr_92 . <vt_1 > fn_44 () , vr_93 ) ;
}
public static < vt_1 > List < vt_1 > fn_43 ( final vr_11 < ? extends vt_1 > vr_12 , final vr_11 < ? extends vt_1 > vr_13 ,
final vr_94 < ? super vt_1 > vr_37 ) {
return fn_43 ( vr_12 , vr_13 , vr_37 , true ) ;
}
public static < vt_1 > List < vt_1 > fn_43 ( final vr_11 < ? extends vt_1 > vr_95 , final vr_11 < ? extends vt_1 > vr_96 ,
final vr_94 < ? super vt_1 > vr_97 , final boolean vr_93 ) {
vr_43 . vr_44 ( vr_95 , lr_8 ) ;
vr_43 . vr_44 ( vr_96 , lr_9 ) ;
vr_43 . vr_44 ( vr_97 , lr_10 ) ;
final int vr_98 = vr_95 instanceof Collection < ? > && vr_96 instanceof Collection < ? > ?
vr_2 . fn_1 ( 1 , ( ( Collection < ? > ) vr_95 ) . size () + ( ( Collection < ? > ) vr_96 ) . size () ) : 10 ;
final Iterator < vt_1 > iterator = new vr_99 <> ( vr_97 , vr_95 . iterator () , vr_96 . iterator () ) ;
if ( vr_93 ) {
return vr_57 . vr_100 ( iterator , vr_98 ) ;
}
final ArrayList < vt_1 > vr_101 = new ArrayList <> ( vr_98 ) ;
vt_1 vr_102 = null ;
while ( iterator . hasNext () ) {
final vt_1 vr_71 = iterator . vr_31 () ;
if ( vr_102 == null || ! vr_102 . equals ( vr_71 ) ) {
vr_101 . add ( vr_71 ) ;
}
vr_102 = vr_71 ;
}
vr_101 . vr_103 () ;
return vr_101 ;
}
public static < vt_3 > Collection < List < vt_3 > > fn_45 ( final Collection < vt_3 > collection ) {
final vr_104 < vt_3 > vr_26 = new vr_104 <> ( collection ) ;
final Collection < List < vt_3 > > vr_59 = new ArrayList <> () ;
while ( vr_26 . hasNext () ) {
vr_59 . add ( vr_26 . vr_31 () ) ;
}
return vr_59 ;
}
public static < vt_4 > Collection < vt_4 > fn_46 ( final Collection < vt_4 > collection , final Collection < ? > vr_105 ) {
return vr_106 . fn_46 ( collection , vr_105 ) ;
}
public static < vt_3 > Collection < vt_3 > fn_46 ( final vr_11 < vt_3 > collection ,
final vr_11 < ? extends vt_3 > vr_105 ,
final vr_41 < ? super vt_3 > vr_42 ) {
final vr_45 < vt_3 , fn_18 < vt_3 > > vr_46 = vr_47 -> new fn_18 <> ( vr_42 , vr_47 ) ;
final vr_27 < fn_18 < vt_3 > > vr_107 =
fn_19 ( vr_105 , vr_46 , new vr_29 < fn_18 < vt_3 > > () ) ;
final List < vt_3 > list = new ArrayList <> () ;
for ( final vt_3 vr_22 : collection ) {
if ( vr_107 . contains ( new fn_18 <> ( vr_42 , vr_22 ) ) ) {
list . add ( vr_22 ) ;
}
}
return list ;
}
public static < vt_3 > Collection < vt_3 > fn_47 ( final Collection < vt_3 > vr_47 , final int vr_108 , final int vr_109 ) {
if ( null == vr_47 ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( vr_109 < vr_108 ) {
throw new IllegalArgumentException ( lr_12 ) ;
}
if ( vr_47 . size () < vr_109 ) {
throw new fn_36 ( lr_13 ) ;
}
return vr_10 . vr_110 ( vr_47 , vr_108 , vr_109 - vr_108 ) ;
}
public static < vt_3 > Collection < vt_3 > vr_110 ( final Collection < vt_3 > vr_47 , int vr_108 , int vr_5 ) {
if ( null == vr_47 ) {
throw new IllegalArgumentException ( lr_11 ) ;
}
if ( vr_108 < 0 ) {
throw new fn_36 ( lr_14 ) ;
}
if ( vr_5 < 0 ) {
throw new fn_36 ( lr_15 ) ;
}
if ( vr_47 . size () < vr_108 + vr_5 ) {
throw new fn_36 (
lr_16 ) ;
}
final Collection < vt_3 > vr_59 = new ArrayList <> ( vr_5 ) ;
final Iterator < vt_3 > iterator = vr_47 . iterator () ;
while ( vr_5 > 0 ) {
if ( vr_108 > 0 ) {
vr_108 = vr_108 - 1 ;
iterator . vr_31 () ;
continue;
}
vr_5 = vr_5 - 1 ;
vr_59 . add ( iterator . vr_31 () ) ;
iterator . remove () ;
}
return vr_59 ;
}
public static < vt_3 > Collection < vt_3 > fn_48 ( final Collection < vt_3 > collection , final Collection < ? > remove ) {
return vr_106 . fn_48 ( collection , remove ) ;
}
public static < vt_3 > Collection < vt_3 > fn_48 ( final vr_11 < vt_3 > collection ,
final vr_11 < ? extends vt_3 > remove ,
final vr_41 < ? super vt_3 > vr_42 ) {
final vr_45 < vt_3 , fn_18 < vt_3 > > vr_46 = vr_47 -> new fn_18 <> ( vr_42 , vr_47 ) ;
final vr_27 < fn_18 < vt_3 > > vr_111 =
fn_19 ( remove , vr_46 , new vr_29 < fn_18 < vt_3 > > () ) ;
final List < vt_3 > list = new ArrayList <> () ;
for ( final vt_3 vr_22 : collection ) {
if ( ! vr_111 . contains ( new fn_18 <> ( vr_42 , vr_22 ) ) ) {
list . add ( vr_22 ) ;
}
}
return list ;
}
@Deprecated
public static < vt_4 > Collection < vt_4 > fn_49 ( final Collection < vt_4 > collection ) {
return vr_112 . fn_49 ( collection ) ;
}
@Deprecated
public static < vt_4 > Collection < vt_4 > fn_50 ( final Collection < ? extends vt_4 > collection ) {
return vr_113 . fn_50 ( collection ) ;
}
public static < vt_4 > Collection < vt_4 > fn_51 ( final Collection < vt_4 > collection ,
final vr_16 < ? super vt_4 > vr_53 ) {
return vr_114 . fn_51 ( collection , vr_53 ) ;
}
public static < vt_3 > Collection < vt_3 > fn_52 ( final Collection < vt_3 > collection ,
final vr_45 < ? super vt_3 , ? extends vt_3 > vr_46 ) {
return vr_115 . fn_52 ( collection , vr_46 ) ;
}
public static < vt_3 > vt_3 fn_53 ( final Collection < vt_3 > collection ) {
vr_43 . vr_44 ( collection , lr_4 ) ;
if ( collection . size () != 1 ) {
throw new IllegalArgumentException ( lr_17 ) ;
}
return collection . iterator () . vr_31 () ;
}
