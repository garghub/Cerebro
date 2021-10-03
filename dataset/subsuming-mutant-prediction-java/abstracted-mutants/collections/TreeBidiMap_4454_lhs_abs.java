@Override
public String toString () {
return vl_1 ;
}
@Override
public int size () {
return vl_2 ;
}
@Override
public boolean isEmpty () {
return vl_2 == 0 ;
}
@Override
public boolean fn_1 ( final Object vr_1 ) {
fn_2 ( vr_1 ) ;
return fn_3 ( vr_1 ) != null ;
}
@Override
public boolean fn_4 ( final Object vr_2 ) {
fn_5 ( vr_2 ) ;
return fn_6 ( vr_2 ) != null ;
}
@Override
public tp_1 get ( final Object vr_1 ) {
fn_2 ( vr_1 ) ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_3 ( vr_1 ) ;
return vr_4 == null ? null : vr_4 . vr_5 () ;
}
@Override
public tp_1 fn_7 ( final vt_1 vr_1 , final tp_1 vr_2 ) {
final tp_1 vr_6 = get ( vr_1 ) ;
fn_8 ( vr_1 , vr_2 ) ;
return vr_6 ;
}
@Override
public void fn_9 ( final vr_7 < ? extends vt_1 , ? extends tp_1 > vr_8 ) {
for ( final vr_7 . vr_9 < ? extends vt_1 , ? extends tp_1 > vr_10 : vr_8 . vr_11 () ) {
fn_7 ( vr_10 . vr_12 () , vr_10 . vr_5 () ) ;
}
}
@Override
public tp_1 remove ( final Object vr_1 ) {
return fn_10 ( vr_1 ) ;
}
@Override
public void clear () {
fn_11 () ;
vl_2 = 0 ;
vr_13 [ vr_14 . vr_15 () ] = null ;
vr_13 [ vr_16 . vr_15 () ] = null ;
}
@Override
public vt_1 vr_12 ( final Object vr_2 ) {
fn_5 ( vr_2 ) ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_6 ( vr_2 ) ;
return vr_4 == null ? null : vr_4 . vr_12 () ;
}
@Override
public vt_1 fn_12 ( final Object vr_2 ) {
return fn_13 ( vr_2 ) ;
}
@Override
public vt_1 fn_14 () {
if ( vl_2 == 0 ) {
throw new fn_15 ( lr_1 ) ;
}
return fn_16 ( vr_13 [ vr_14 . vr_15 () ] , vr_14 ) . vr_12 () ;
}
@Override
public vt_1 fn_17 () {
if ( vl_2 == 0 ) {
throw new fn_15 ( lr_1 ) ;
}
return fn_18 ( vr_13 [ vr_14 . vr_15 () ] , vr_14 ) . vr_12 () ;
}
@Override
public vt_1 fn_19 ( final vt_1 vr_1 ) {
fn_2 ( vr_1 ) ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_20 ( fn_3 ( vr_1 ) , vr_14 ) ;
return vr_4 == null ? null : vr_4 . vr_12 () ;
}
@Override
public vt_1 fn_21 ( final vt_1 vr_1 ) {
fn_2 ( vr_1 ) ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_22 ( fn_3 ( vr_1 ) , vr_14 ) ;
return vr_4 == null ? null : vr_4 . vr_12 () ;
}
@Override
public vr_17 < vt_1 > fn_23 () {
if ( fn_23 == null ) {
fn_23 = new fn_24 ( vr_14 ) ;
}
return fn_23 ;
}
@Override
public vr_17 < tp_1 > fn_25 () {
if ( vl_3 == null ) {
vl_3 = new fn_26 ( vr_14 ) ;
}
return vl_3 ;
}
@Override
public vr_17 < vr_7 . vr_9 < vt_1 , tp_1 > > vr_11 () {
if ( vr_11 == null ) {
vr_11 = new fn_27 () ;
}
return vr_11 ;
}
@Override
public vr_18 < vt_1 , tp_1 > fn_28 () {
if ( isEmpty () ) {
return vr_19 . <vt_1 , tp_1 > fn_29 () ;
}
return new fn_30 ( vr_14 ) ;
}
@Override
public vr_20 < tp_1 , vt_1 > fn_31 () {
if ( vl_4 == null ) {
vl_4 = new fn_32 () ;
}
return vl_4 ;
}
@Override
public boolean equals ( final Object vr_21 ) {
return this . vr_22 ( vr_21 , vr_14 ) ;
}
@Override
public int fn_33 () {
return this . vr_23 ( vr_14 ) ;
}
@Override
public String toString () {
return this . vr_24 ( vr_14 ) ;
}
private void fn_8 ( final vt_1 vr_1 , final tp_1 vr_2 ) {
fn_34 ( vr_1 , vr_2 ) ;
fn_10 ( vr_1 ) ;
fn_13 ( vr_2 ) ;
vr_3 < vt_1 , tp_1 > vr_4 = vr_13 [ vr_14 . vr_15 () ] ;
if ( vr_4 == null ) {
final vr_3 < vt_1 , tp_1 > vr_25 = new vr_3 <> ( vr_1 , vr_2 ) ;
vr_13 [ vr_14 . vr_15 () ] = vr_25 ;
vr_13 [ vr_16 . vr_15 () ] = vr_25 ;
fn_35 () ;
} else {
while ( true ) {
final int vr_26 = fn_36 ( vr_1 , vr_4 . vr_12 () ) ;
if ( vr_26 == 0 ) {
throw new IllegalArgumentException ( lr_2 + vr_1 + lr_3 ) ;
} else if ( vr_26 < 0 ) { MST[ConditionalsBoundaryMutator]MSP[]
if ( vr_4 . vr_27 ( vr_14 ) != null ) {
vr_4 = vr_4 . vr_27 ( vr_14 ) ;
} else {
final vr_3 < vt_1 , tp_1 > vr_28 = new vr_3 <> ( vr_1 , vr_2 ) ;
fn_37 ( vr_28 ) ;
vr_4 . vr_29 ( vr_28 , vr_14 ) ;
vr_28 . vr_30 ( vr_4 , vr_14 ) ;
fn_38 ( vr_28 , vr_14 ) ;
fn_35 () ;
break;
}
} else {
if ( vr_4 . vr_31 ( vr_14 ) != null ) {
vr_4 = vr_4 . vr_31 ( vr_14 ) ;
} else {
final vr_3 < vt_1 , tp_1 > vr_28 = new vr_3 <> ( vr_1 , vr_2 ) ;
fn_37 ( vr_28 ) ;
vr_4 . vr_32 ( vr_28 , vr_14 ) ;
vr_28 . vr_30 ( vr_4 , vr_14 ) ;
fn_38 ( vr_28 , vr_14 ) ;
fn_35 () ;
break;
}
}
}
}
}
private tp_1 fn_10 ( final Object vr_1 ) {
final vr_3 < vt_1 , tp_1 > vr_4 = fn_3 ( vr_1 ) ;
if ( vr_4 == null ) {
return null ;
}
fn_39 ( vr_4 ) ;
return vr_4 . vr_5 () ;
}
private vt_1 fn_13 ( final Object vr_2 ) {
final vr_3 < vt_1 , tp_1 > vr_4 = fn_6 ( vr_2 ) ;
if ( vr_4 == null ) {
return null ;
}
fn_39 ( vr_4 ) ;
return vr_4 . vr_12 () ;
}
@SuppressWarnings ( lr_4 )
private < vt_2 extends vr_33 < vt_2 > > vr_3 < vt_1 , tp_1 > fn_40 ( final Object vr_34 , final tp_2 vr_35 ) {
vr_3 < vt_1 , tp_1 > vr_36 = null ;
vr_3 < vt_1 , tp_1 > vr_4 = vr_13 [ vr_35 . vr_15 () ] ;
while ( vr_4 != null ) {
final int vr_26 = fn_36 ( ( vt_2 ) vr_34 , ( vt_2 ) vr_4 . vr_37 ( vr_35 ) ) ;
if ( vr_26 == 0 ) {
vr_36 = vr_4 ;
break;
}
vr_4 = vr_26 < 0 ? vr_4 . vr_27 ( vr_35 ) : vr_4 . vr_31 ( vr_35 ) ;
}
return vr_36 ;
}
private vr_3 < vt_1 , tp_1 > fn_3 ( final Object vr_1 ) {
return this . <vt_1 > fn_40 ( vr_1 , vr_14 ) ;
}
private vr_3 < vt_1 , tp_1 > fn_6 ( final Object vr_2 ) {
return this . <tp_1 > fn_40 ( vr_2 , vr_16 ) ;
}
private vr_3 < vt_1 , tp_1 > fn_20 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_3 < vt_1 , tp_1 > vr_36 ;
if ( vr_4 == null ) {
vr_36 = null ;
} else if ( vr_4 . vr_31 ( vr_35 ) != null ) {
vr_36 = fn_16 ( vr_4 . vr_31 ( vr_35 ) , vr_35 ) ;
} else {
vr_3 < vt_1 , tp_1 > vr_38 = vr_4 . vr_39 ( vr_35 ) ;
vr_3 < vt_1 , tp_1 > vr_40 = vr_4 ;
while ( vr_38 != null && vr_40 == vr_38 . vr_31 ( vr_35 ) ) {
vr_40 = vr_38 ;
vr_38 = vr_38 . vr_39 ( vr_35 ) ;
}
vr_36 = vr_38 ;
}
return vr_36 ;
}
private vr_3 < vt_1 , tp_1 > fn_22 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_3 < vt_1 , tp_1 > vr_36 ;
if ( vr_4 == null ) {
vr_36 = null ;
} else if ( vr_4 . vr_27 ( vr_35 ) != null ) {
vr_36 = fn_18 ( vr_4 . vr_27 ( vr_35 ) , vr_35 ) ;
} else {
vr_3 < vt_1 , tp_1 > vr_38 = vr_4 . vr_39 ( vr_35 ) ;
vr_3 < vt_1 , tp_1 > vr_40 = vr_4 ;
while ( vr_38 != null && vr_40 == vr_38 . vr_27 ( vr_35 ) ) {
vr_40 = vr_38 ;
vr_38 = vr_38 . vr_39 ( vr_35 ) ;
}
vr_36 = vr_38 ;
}
return vr_36 ;
}
private static < vt_2 extends vr_33 < vt_2 > > int fn_36 ( final vt_2 vr_41 , final vt_2 vr_42 ) {
return vr_41 . vr_43 ( vr_42 ) ;
}
private vr_3 < vt_1 , tp_1 > fn_16 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_3 < vt_1 , tp_1 > vr_36 = vr_4 ;
if ( vr_36 != null ) {
while ( vr_36 . vr_27 ( vr_35 ) != null ) {
vr_36 = vr_36 . vr_27 ( vr_35 ) ;
}
}
return vr_36 ;
}
private vr_3 < vt_1 , tp_1 > fn_18 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_3 < vt_1 , tp_1 > vr_36 = vr_4 ;
if ( vr_36 != null ) {
while ( vr_36 . vr_31 ( vr_35 ) != null ) {
vr_36 = vr_36 . vr_31 ( vr_35 ) ;
}
}
return vr_36 ;
}
private void fn_41 ( final vr_3 < vt_1 , tp_1 > vr_44 , final vr_3 < vt_1 , tp_1 > vr_45 , final tp_2 vr_35 ) {
if ( vr_45 != null ) {
if ( vr_44 == null ) {
vr_45 . vr_46 ( vr_35 ) ;
} else {
vr_45 . fn_41 ( vr_44 , vr_35 ) ;
}
}
}
private static boolean fn_42 ( final vr_3 < ? , ? > vr_4 , final tp_2 vr_35 ) {
return vr_4 != null && vr_4 . fn_42 ( vr_35 ) ;
}
private static boolean fn_43 ( final vr_3 < ? , ? > vr_4 , final tp_2 vr_35 ) {
return vr_4 == null || vr_4 . fn_43 ( vr_35 ) ;
}
private static void fn_44 ( final vr_3 < ? , ? > vr_4 , final tp_2 vr_35 ) {
if ( vr_4 != null ) {
vr_4 . vr_47 ( vr_35 ) ;
}
}
private static void fn_45 ( final vr_3 < ? , ? > vr_4 , final tp_2 vr_35 ) {
if ( vr_4 != null ) {
vr_4 . vr_46 ( vr_35 ) ;
}
}
private vr_3 < vt_1 , tp_1 > fn_46 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
return vr_39 ( vr_39 ( vr_4 , vr_35 ) , vr_35 ) ;
}
private vr_3 < vt_1 , tp_1 > vr_39 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
return vr_4 == null ? null : vr_4 . vr_39 ( vr_35 ) ;
}
private vr_3 < vt_1 , tp_1 > fn_47 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
return vr_4 == null ? null : vr_4 . vr_31 ( vr_35 ) ;
}
private vr_3 < vt_1 , tp_1 > fn_48 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
return vr_4 == null ? null : vr_4 . vr_27 ( vr_35 ) ;
}
private void fn_49 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
final vr_3 < vt_1 , tp_1 > vr_48 = vr_4 . vr_31 ( vr_35 ) ;
vr_4 . vr_32 ( vr_48 . vr_27 ( vr_35 ) , vr_35 ) ;
if ( vr_48 . vr_27 ( vr_35 ) != null ) {
vr_48 . vr_27 ( vr_35 ) . vr_30 ( vr_4 , vr_35 ) ;
}
vr_48 . vr_30 ( vr_4 . vr_39 ( vr_35 ) , vr_35 ) ;
if ( vr_4 . vr_39 ( vr_35 ) == null ) {
vr_13 [ vr_35 . vr_15 () ] = vr_48 ;
} else if ( vr_4 . vr_39 ( vr_35 ) . vr_27 ( vr_35 ) == vr_4 ) {
vr_4 . vr_39 ( vr_35 ) . vr_29 ( vr_48 , vr_35 ) ;
} else {
vr_4 . vr_39 ( vr_35 ) . vr_32 ( vr_48 , vr_35 ) ;
}
vr_48 . vr_29 ( vr_4 , vr_35 ) ;
vr_4 . vr_30 ( vr_48 , vr_35 ) ;
}
private void fn_50 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
final vr_3 < vt_1 , tp_1 > vr_49 = vr_4 . vr_27 ( vr_35 ) ;
vr_4 . vr_29 ( vr_49 . vr_31 ( vr_35 ) , vr_35 ) ;
if ( vr_49 . vr_31 ( vr_35 ) != null ) {
vr_49 . vr_31 ( vr_35 ) . vr_30 ( vr_4 , vr_35 ) ;
}
vr_49 . vr_30 ( vr_4 . vr_39 ( vr_35 ) , vr_35 ) ;
if ( vr_4 . vr_39 ( vr_35 ) == null ) {
vr_13 [ vr_35 . vr_15 () ] = vr_49 ;
} else if ( vr_4 . vr_39 ( vr_35 ) . vr_31 ( vr_35 ) == vr_4 ) {
vr_4 . vr_39 ( vr_35 ) . vr_32 ( vr_49 , vr_35 ) ;
} else {
vr_4 . vr_39 ( vr_35 ) . vr_29 ( vr_49 , vr_35 ) ;
}
vr_49 . vr_32 ( vr_4 , vr_35 ) ;
vr_4 . vr_30 ( vr_49 , vr_35 ) ;
}
private void fn_38 ( final vr_3 < vt_1 , tp_1 > vr_50 , final tp_2 vr_35 ) {
vr_3 < vt_1 , tp_1 > vr_51 = vr_50 ;
fn_44 ( vr_51 , vr_35 ) ;
while ( vr_51 != null
&& vr_51 != vr_13 [ vr_35 . vr_15 () ]
&& fn_42 ( vr_51 . vr_39 ( vr_35 ) , vr_35 ) ) {
if ( vr_51 . vr_52 ( vr_35 ) ) {
final vr_3 < vt_1 , tp_1 > vr_53 = fn_47 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
if ( fn_42 ( vr_53 , vr_35 ) ) {
fn_45 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_45 ( vr_53 , vr_35 ) ;
fn_44 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
vr_51 = fn_46 ( vr_51 , vr_35 ) ;
} else {
if ( vr_51 . vr_54 ( vr_35 ) ) {
vr_51 = vr_39 ( vr_51 , vr_35 ) ;
fn_49 ( vr_51 , vr_35 ) ;
}
fn_45 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_44 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
if ( fn_46 ( vr_51 , vr_35 ) != null ) {
fn_50 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
}
}
} else {
final vr_3 < vt_1 , tp_1 > vr_53 = fn_48 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
if ( fn_42 ( vr_53 , vr_35 ) ) {
fn_45 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_45 ( vr_53 , vr_35 ) ;
fn_44 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
vr_51 = fn_46 ( vr_51 , vr_35 ) ;
} else {
if ( vr_51 . vr_52 ( vr_35 ) ) {
vr_51 = vr_39 ( vr_51 , vr_35 ) ;
fn_50 ( vr_51 , vr_35 ) ;
}
fn_45 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_44 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
if ( fn_46 ( vr_51 , vr_35 ) != null ) {
fn_49 ( fn_46 ( vr_51 , vr_35 ) , vr_35 ) ;
}
}
}
}
fn_45 ( vr_13 [ vr_35 . vr_15 () ] , vr_35 ) ;
}
private void fn_39 ( final vr_3 < vt_1 , tp_1 > vr_55 ) {
for ( final tp_2 vr_35 : tp_2 . fn_25 () ) {
if ( vr_55 . vr_27 ( vr_35 ) != null && vr_55 . vr_31 ( vr_35 ) != null ) {
fn_51 ( fn_20 ( vr_55 , vr_35 ) , vr_55 , vr_35 ) ;
}
final vr_3 < vt_1 , tp_1 > vr_56 = vr_55 . vr_27 ( vr_35 ) != null ?
vr_55 . vr_27 ( vr_35 ) : vr_55 . vr_31 ( vr_35 ) ;
if ( vr_56 != null ) {
vr_56 . vr_30 ( vr_55 . vr_39 ( vr_35 ) , vr_35 ) ;
if ( vr_55 . vr_39 ( vr_35 ) == null ) {
vr_13 [ vr_35 . vr_15 () ] = vr_56 ;
} else if ( vr_55 == vr_55 . vr_39 ( vr_35 ) . vr_27 ( vr_35 ) ) {
vr_55 . vr_39 ( vr_35 ) . vr_29 ( vr_56 , vr_35 ) ;
} else {
vr_55 . vr_39 ( vr_35 ) . vr_32 ( vr_56 , vr_35 ) ;
}
vr_55 . vr_29 ( null , vr_35 ) ;
vr_55 . vr_32 ( null , vr_35 ) ;
vr_55 . vr_30 ( null , vr_35 ) ;
if ( fn_43 ( vr_55 , vr_35 ) ) {
fn_52 ( vr_56 , vr_35 ) ;
}
} else {
if ( vr_55 . vr_39 ( vr_35 ) == null ) {
vr_13 [ vr_35 . vr_15 () ] = null ;
} else {
if ( fn_43 ( vr_55 , vr_35 ) ) {
fn_52 ( vr_55 , vr_35 ) ;
}
if ( vr_55 . vr_39 ( vr_35 ) != null ) {
if ( vr_55 == vr_55 . vr_39 ( vr_35 ) . vr_27 ( vr_35 ) ) {
vr_55 . vr_39 ( vr_35 ) . vr_29 ( null , vr_35 ) ;
} else {
vr_55 . vr_39 ( vr_35 ) . vr_32 ( null , vr_35 ) ;
}
vr_55 . vr_30 ( null , vr_35 ) ;
}
}
}
}
fn_53 () ;
}
private void fn_52 ( final vr_3 < vt_1 , tp_1 > vr_57 , final tp_2 vr_35 ) {
vr_3 < vt_1 , tp_1 > vr_51 = vr_57 ;
while ( vr_51 != vr_13 [ vr_35 . vr_15 () ] && fn_43 ( vr_51 , vr_35 ) ) {
if ( vr_51 . vr_52 ( vr_35 ) ) {
vr_3 < vt_1 , tp_1 > vr_58 = fn_47 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
if ( fn_42 ( vr_58 , vr_35 ) ) {
fn_45 ( vr_58 , vr_35 ) ;
fn_44 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_49 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
vr_58 = fn_47 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
}
if ( fn_43 ( fn_48 ( vr_58 , vr_35 ) , vr_35 )
&& fn_43 ( fn_47 ( vr_58 , vr_35 ) , vr_35 ) ) {
fn_44 ( vr_58 , vr_35 ) ;
vr_51 = vr_39 ( vr_51 , vr_35 ) ;
} else {
if ( fn_43 ( fn_47 ( vr_58 , vr_35 ) , vr_35 ) ) {
fn_45 ( fn_48 ( vr_58 , vr_35 ) , vr_35 ) ;
fn_44 ( vr_58 , vr_35 ) ;
fn_50 ( vr_58 , vr_35 ) ;
vr_58 = fn_47 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
}
fn_41 ( vr_39 ( vr_51 , vr_35 ) , vr_58 , vr_35 ) ;
fn_45 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_45 ( fn_47 ( vr_58 , vr_35 ) , vr_35 ) ;
fn_49 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
vr_51 = vr_13 [ vr_35 . vr_15 () ] ;
}
} else {
vr_3 < vt_1 , tp_1 > vr_58 = fn_48 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
if ( fn_42 ( vr_58 , vr_35 ) ) {
fn_45 ( vr_58 , vr_35 ) ;
fn_44 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_50 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
vr_58 = fn_48 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
}
if ( fn_43 ( fn_47 ( vr_58 , vr_35 ) , vr_35 )
&& fn_43 ( fn_48 ( vr_58 , vr_35 ) , vr_35 ) ) {
fn_44 ( vr_58 , vr_35 ) ;
vr_51 = vr_39 ( vr_51 , vr_35 ) ;
} else {
if ( fn_43 ( fn_48 ( vr_58 , vr_35 ) , vr_35 ) ) {
fn_45 ( fn_47 ( vr_58 , vr_35 ) , vr_35 ) ;
fn_44 ( vr_58 , vr_35 ) ;
fn_49 ( vr_58 , vr_35 ) ;
vr_58 = fn_48 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
}
fn_41 ( vr_39 ( vr_51 , vr_35 ) , vr_58 , vr_35 ) ;
fn_45 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
fn_45 ( fn_48 ( vr_58 , vr_35 ) , vr_35 ) ;
fn_50 ( vr_39 ( vr_51 , vr_35 ) , vr_35 ) ;
vr_51 = vr_13 [ vr_35 . vr_15 () ] ;
}
}
}
fn_45 ( vr_51 , vr_35 ) ;
}
private void fn_51 ( final vr_3 < vt_1 , tp_1 > vr_59 , final vr_3 < vt_1 , tp_1 > vr_53 , final tp_2 vr_35 ) {
final vr_3 < vt_1 , tp_1 > vr_60 = vr_59 . vr_39 ( vr_35 ) ;
final vr_3 < vt_1 , tp_1 > vr_61 = vr_59 . vr_27 ( vr_35 ) ;
final vr_3 < vt_1 , tp_1 > vr_62 = vr_59 . vr_31 ( vr_35 ) ;
final vr_3 < vt_1 , tp_1 > vr_63 = vr_53 . vr_39 ( vr_35 ) ;
final vr_3 < vt_1 , tp_1 > vr_64 = vr_53 . vr_27 ( vr_35 ) ;
final vr_3 < vt_1 , tp_1 > vr_65 = vr_53 . vr_31 ( vr_35 ) ;
final boolean vr_66 =
vr_59 . vr_39 ( vr_35 ) != null && vr_59 == vr_59 . vr_39 ( vr_35 ) . vr_27 ( vr_35 ) ;
final boolean vr_67 =
vr_53 . vr_39 ( vr_35 ) != null && vr_53 == vr_53 . vr_39 ( vr_35 ) . vr_27 ( vr_35 ) ;
if ( vr_59 == vr_63 ) {
vr_59 . vr_30 ( vr_53 , vr_35 ) ;
if ( vr_67 ) {
vr_53 . vr_29 ( vr_59 , vr_35 ) ;
vr_53 . vr_32 ( vr_62 , vr_35 ) ;
} else {
vr_53 . vr_32 ( vr_59 , vr_35 ) ;
vr_53 . vr_29 ( vr_61 , vr_35 ) ;
}
} else {
vr_59 . vr_30 ( vr_63 , vr_35 ) ;
if ( vr_63 != null ) {
if ( vr_67 ) {
vr_63 . vr_29 ( vr_59 , vr_35 ) ;
} else {
vr_63 . vr_32 ( vr_59 , vr_35 ) ;
}
}
vr_53 . vr_29 ( vr_61 , vr_35 ) ;
vr_53 . vr_32 ( vr_62 , vr_35 ) ;
}
if ( vr_53 == vr_60 ) {
vr_53 . vr_30 ( vr_59 , vr_35 ) ;
if ( vr_66 ) {
vr_59 . vr_29 ( vr_53 , vr_35 ) ;
vr_59 . vr_32 ( vr_65 , vr_35 ) ;
} else {
vr_59 . vr_32 ( vr_53 , vr_35 ) ;
vr_59 . vr_29 ( vr_64 , vr_35 ) ;
}
} else {
vr_53 . vr_30 ( vr_60 , vr_35 ) ;
if ( vr_60 != null ) {
if ( vr_66 ) {
vr_60 . vr_29 ( vr_53 , vr_35 ) ;
} else {
vr_60 . vr_32 ( vr_53 , vr_35 ) ;
}
}
vr_59 . vr_29 ( vr_64 , vr_35 ) ;
vr_59 . vr_32 ( vr_65 , vr_35 ) ;
}
if ( vr_59 . vr_27 ( vr_35 ) != null ) {
vr_59 . vr_27 ( vr_35 ) . vr_30 ( vr_59 , vr_35 ) ;
}
if ( vr_59 . vr_31 ( vr_35 ) != null ) {
vr_59 . vr_31 ( vr_35 ) . vr_30 ( vr_59 , vr_35 ) ;
}
if ( vr_53 . vr_27 ( vr_35 ) != null ) {
vr_53 . vr_27 ( vr_35 ) . vr_30 ( vr_53 , vr_35 ) ;
}
if ( vr_53 . vr_31 ( vr_35 ) != null ) {
vr_53 . vr_31 ( vr_35 ) . vr_30 ( vr_53 , vr_35 ) ;
}
vr_59 . vr_68 ( vr_53 , vr_35 ) ;
if ( vr_13 [ vr_35 . vr_15 () ] == vr_59 ) {
vr_13 [ vr_35 . vr_15 () ] = vr_53 ;
} else if ( vr_13 [ vr_35 . vr_15 () ] == vr_53 ) {
vr_13 [ vr_35 . vr_15 () ] = vr_59 ;
}
}
private static void fn_54 ( final Object vr_21 , final tp_2 vr_35 ) {
vr_69 . vr_70 ( vr_21 , vr_69 . toString ( vr_35 ) ) ;
if ( ! ( vr_21 instanceof vr_33 ) ) {
throw new fn_55 ( vr_35 + lr_5 ) ;
}
}
private static void fn_2 ( final Object vr_1 ) {
fn_54 ( vr_1 , vr_14 ) ;
}
private static void fn_5 ( final Object vr_2 ) {
fn_54 ( vr_2 , vr_16 ) ;
}
private static void fn_34 ( final Object vr_1 , final Object vr_2 ) {
fn_2 ( vr_1 ) ;
fn_5 ( vr_2 ) ;
}
private void fn_11 () {
vl_5 ++ ;
}
private void fn_35 () {
fn_11 () ;
vl_2 ++ ;
}
private void fn_53 () {
fn_11 () ;
vl_2 -- ;
}
private void fn_37 ( final vr_3 < vt_1 , tp_1 > vr_28 ) throws IllegalArgumentException {
vr_3 < vt_1 , tp_1 > vr_4 = vr_13 [ vr_16 . vr_15 () ] ;
while ( true ) {
final int vr_26 = fn_36 ( vr_28 . vr_5 () , vr_4 . vr_5 () ) ;
if ( vr_26 == 0 ) {
throw new IllegalArgumentException (
lr_6 + vr_28 . vr_37 ( vr_16 ) + lr_3 ) ;
} else if ( vr_26 < 0 ) {
if ( vr_4 . vr_27 ( vr_16 ) != null ) {
vr_4 = vr_4 . vr_27 ( vr_16 ) ;
} else {
vr_4 . vr_29 ( vr_28 , vr_16 ) ;
vr_28 . vr_30 ( vr_4 , vr_16 ) ;
fn_38 ( vr_28 , vr_16 ) ;
break;
}
} else {
if ( vr_4 . vr_31 ( vr_16 ) != null ) {
vr_4 = vr_4 . vr_31 ( vr_16 ) ;
} else {
vr_4 . vr_32 ( vr_28 , vr_16 ) ;
vr_28 . vr_30 ( vr_4 , vr_16 ) ;
fn_38 ( vr_28 , vr_16 ) ;
break;
}
}
}
}
private boolean vr_22 ( final Object vr_21 , final tp_2 vr_35 ) {
if ( vr_21 == this ) {
return true ;
}
if ( vr_21 instanceof vr_7 == false ) {
return false ;
}
final vr_7 < ? , ? > vr_71 = ( vr_7 < ? , ? > ) vr_21 ;
if ( vr_71 . size () != size () ) {
return false ;
}
if ( vl_2 > 0 ) {
try {
for ( final vr_72 < ? , ? > vr_73 = fn_56 ( vr_35 ) ; vr_73 . hasNext () ; ) {
final Object vr_1 = vr_73 . vr_74 () ;
final Object vr_2 = vr_73 . vr_5 () ;
if ( vr_2 . equals ( vr_71 . get ( vr_1 ) ) == false ) {
return false ;
}
}
} catch ( final fn_55 vr_75 ) {
return false ;
} catch ( final tp_3 vr_75 ) {
return false ;
}
}
return true ;
}
private int vr_23 ( final tp_2 vr_35 ) {
int vr_76 = 0 ;
if ( vl_2 > 0 ) {
for ( final vr_72 < ? , ? > vr_73 = fn_56 ( vr_35 ) ; vr_73 . hasNext () ; ) {
final Object vr_1 = vr_73 . vr_74 () ;
final Object vr_2 = vr_73 . vr_5 () ;
vr_76 += vr_1 . fn_33 () ^ vr_2 . fn_33 () ;
}
}
return vr_76 ;
}
private String vr_24 ( final tp_2 vr_35 ) {
if ( vl_2 == 0 ) {
return lr_7 ;
}
final StringBuilder vr_77 = new StringBuilder ( vl_2 * 32 ) ;
vr_77 . append ( '{' ) ;
final vr_72 < ? , ? > vr_73 = fn_56 ( vr_35 ) ;
boolean hasNext = vr_73 . hasNext () ;
while ( hasNext ) {
final Object vr_1 = vr_73 . vr_74 () ;
final Object vr_2 = vr_73 . vr_5 () ;
vr_77 . append ( vr_1 == this ? lr_8 : vr_1 )
. append ( '=' )
. append ( vr_2 == this ? lr_8 : vr_2 ) ;
hasNext = vr_73 . hasNext () ;
if ( hasNext ) {
vr_77 . append ( lr_9 ) ;
}
}
vr_77 . append ( '}' ) ;
return vr_77 . toString () ;
}
private vr_72 < ? , ? > fn_56 ( final tp_2 vr_35 ) {
switch ( vr_35 ) {
case vr_14 :
return new fn_30 ( vr_14 ) ;
case vr_16 :
return new fn_57 ( vr_16 ) ;
default:
throw new IllegalArgumentException () ;
}
}
@SuppressWarnings ( lr_4 )
private void fn_58 ( final tp_4 vr_78 ) throws IOException , vl_6 {
vr_78 . vr_79 () ;
vr_13 = new vr_3 [ 2 ] ;
final int size = vr_78 . vr_80 () ;
for ( int vr_81 = 0 ; vr_81 < size ; vr_81 ++ ) {
final vt_1 vr_82 = ( vt_1 ) vr_78 . fn_58 () ;
final tp_1 vr_83 = ( tp_1 ) vr_78 . fn_58 () ;
fn_7 ( vr_82 , vr_83 ) ;
}
}
private void fn_59 ( final tp_5 vr_78 ) throws IOException {
vr_78 . vr_84 () ;
vr_78 . vr_85 ( this . size () ) ;
for ( final vr_9 < vt_1 , tp_1 > vr_86 : vr_11 () ) {
vr_78 . fn_59 ( vr_86 . vr_12 () ) ;
vr_78 . fn_59 ( vr_86 . vr_5 () ) ;
}
}
@Override
public int size () {
return vr_87 . this . size () ;
}
@Override
public void clear () {
vr_87 . this . clear () ;
}
@Override
public Iterator < vt_1 > iterator () {
return new fn_30 ( vl_7 ) ;
}
@Override
public boolean contains ( final Object vr_21 ) {
fn_54 ( vr_21 , vr_14 ) ;
return fn_3 ( vr_21 ) != null ;
}
@Override
public boolean remove ( final Object vr_88 ) {
return fn_10 ( vr_88 ) != null ;
}
@Override
public Iterator < tp_1 > iterator () {
return new fn_57 ( vl_7 ) ;
}
@Override
public boolean contains ( final Object vr_21 ) {
fn_54 ( vr_21 , vr_16 ) ;
return fn_6 ( vr_21 ) != null ;
}
@Override
public boolean remove ( final Object vr_88 ) {
return fn_13 ( vr_88 ) != null ;
}
@Override
public boolean contains ( final Object vr_21 ) {
if ( vr_21 instanceof vr_7 . vr_9 == false ) {
return false ;
}
final vr_7 . vr_9 < ? , ? > vr_86 = ( vr_7 . vr_9 < ? , ? > ) vr_21 ;
final Object vr_2 = vr_86 . vr_5 () ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_3 ( vr_86 . vr_12 () ) ;
return vr_4 != null && vr_4 . vr_5 () . equals ( vr_2 ) ;
}
@Override
public boolean remove ( final Object vr_21 ) {
if ( vr_21 instanceof vr_7 . vr_9 == false ) {
return false ;
}
final vr_7 . vr_9 < ? , ? > vr_86 = ( vr_7 . vr_9 < ? , ? > ) vr_21 ;
final Object vr_2 = vr_86 . vr_5 () ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_3 ( vr_86 . vr_12 () ) ;
if ( vr_4 != null && vr_4 . vr_5 () . equals ( vr_2 ) ) {
fn_39 ( vr_4 ) ;
return true ;
}
return false ;
}
@Override
public Iterator < vr_7 . vr_9 < vt_1 , tp_1 > > iterator () {
return new fn_60 () ;
}
@Override
public boolean contains ( final Object vr_21 ) {
if ( vr_21 instanceof vr_7 . vr_9 == false ) {
return false ;
}
final vr_7 . vr_9 < ? , ? > vr_86 = ( vr_7 . vr_9 < ? , ? > ) vr_21 ;
final Object vr_2 = vr_86 . vr_5 () ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_6 ( vr_86 . vr_12 () ) ;
return vr_4 != null && vr_4 . vr_12 () . equals ( vr_2 ) ;
}
@Override
public boolean remove ( final Object vr_21 ) {
if ( vr_21 instanceof vr_7 . vr_9 == false ) {
return false ;
}
final vr_7 . vr_9 < ? , ? > vr_86 = ( vr_7 . vr_9 < ? , ? > ) vr_21 ;
final Object vr_2 = vr_86 . vr_5 () ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_6 ( vr_86 . vr_12 () ) ;
if ( vr_4 != null && vr_4 . vr_12 () . equals ( vr_2 ) ) {
fn_39 ( vr_4 ) ;
return true ;
}
return false ;
}
@Override
public Iterator < vr_7 . vr_9 < tp_1 , vt_1 > > iterator () {
return new fn_61 () ;
}
public final boolean hasNext () {
return vl_8 != null ;
}
protected vr_3 < vt_1 , tp_1 > fn_62 () {
if ( vl_8 == null ) {
throw new fn_15 () ;
}
if ( vl_5 != vl_9 ) {
throw new fn_63 () ;
}
vl_10 = vl_8 ;
vl_11 = vl_8 ;
vl_8 = fn_20 ( vl_8 , vl_7 ) ;
return vl_10 ;
}
public boolean fn_64 () {
return vl_11 != null ;
}
protected vr_3 < vt_1 , tp_1 > fn_65 () {
if ( vl_11 == null ) {
throw new fn_15 () ;
}
if ( vl_5 != vl_9 ) {
throw new fn_63 () ;
}
vl_8 = vl_10 ;
if ( vl_8 == null ) {
vl_8 = fn_20 ( vl_11 , vl_7 ) ;
}
vl_10 = vl_11 ;
vl_11 = fn_22 ( vl_11 , vl_7 ) ;
return vl_10 ;
}
public final void remove () {
if ( vl_10 == null ) {
throw new fn_66 () ;
}
if ( vl_5 != vl_9 ) {
throw new fn_63 () ;
}
fn_39 ( vl_10 ) ;
vl_9 ++ ;
vl_10 = null ;
if ( vl_8 == null ) {
vl_11 = fn_18 ( vr_13 [ vl_7 . vr_15 () ] , vl_7 ) ;
} else {
vl_11 = fn_22 ( vl_8 , vl_7 ) ;
}
}
@Override
public vt_1 vr_12 () {
if ( vl_10 == null ) {
throw new fn_66 (
lr_10 ) ;
}
return vl_10 . vr_12 () ;
}
@Override
public tp_1 vr_5 () {
if ( vl_10 == null ) {
throw new fn_66 (
lr_11 ) ;
}
return vl_10 . vr_5 () ;
}
@Override
public tp_1 fn_67 ( final tp_1 vr_21 ) {
throw new fn_68 () ;
}
@Override
public vt_1 vr_74 () {
return fn_62 () . vr_12 () ;
}
@Override
public vt_1 fn_69 () {
return fn_65 () . vr_12 () ;
}
@Override
public tp_1 vr_12 () {
if ( vl_10 == null ) {
throw new fn_66 (
lr_10 ) ;
}
return vl_10 . vr_5 () ;
}
@Override
public vt_1 vr_5 () {
if ( vl_10 == null ) {
throw new fn_66 (
lr_11 ) ;
}
return vl_10 . vr_12 () ;
}
@Override
public vt_1 fn_67 ( final vt_1 vr_21 ) {
throw new fn_68 () ;
}
@Override
public tp_1 vr_74 () {
return fn_62 () . vr_5 () ;
}
@Override
public tp_1 fn_69 () {
return fn_65 () . vr_5 () ;
}
@Override
public vr_7 . vr_9 < vt_1 , tp_1 > vr_74 () {
return fn_62 () ;
}
@Override
public vr_7 . vr_9 < vt_1 , tp_1 > fn_69 () {
return fn_65 () ;
}
@Override
public vr_7 . vr_9 < tp_1 , vt_1 > vr_74 () {
return fn_70 ( fn_62 () ) ;
}
@Override
public vr_7 . vr_9 < tp_1 , vt_1 > fn_69 () {
return fn_70 ( fn_65 () ) ;
}
private vr_7 . vr_9 < tp_1 , vt_1 > fn_70 ( final vr_3 < vt_1 , tp_1 > vr_4 ) {
return new vr_89 <> ( vr_4 . vr_5 () , vr_4 . vr_12 () ) ;
}
private Object vr_37 ( final tp_2 vr_35 ) {
switch ( vr_35 ) {
case vr_14 :
return vr_12 () ;
case vr_16 :
return vr_5 () ;
default:
throw new IllegalArgumentException () ;
}
}
private void vr_29 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_90 [ vr_35 . vr_15 () ] = vr_4 ;
}
private vr_3 < vt_1 , tp_1 > vr_27 ( final tp_2 vr_35 ) {
return vr_90 [ vr_35 . vr_15 () ] ;
}
private void vr_32 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_91 [ vr_35 . vr_15 () ] = vr_4 ;
}
private vr_3 < vt_1 , tp_1 > vr_31 ( final tp_2 vr_35 ) {
return vr_91 [ vr_35 . vr_15 () ] ;
}
private void vr_30 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_92 [ vr_35 . vr_15 () ] = vr_4 ;
}
private vr_3 < vt_1 , tp_1 > vr_39 ( final tp_2 vr_35 ) {
return vr_92 [ vr_35 . vr_15 () ] ;
}
private void vr_68 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_93 [ vr_35 . vr_15 () ] ^= vr_4 . vr_93 [ vr_35 . vr_15 () ] ;
vr_4 . vr_93 [ vr_35 . vr_15 () ] ^= vr_93 [ vr_35 . vr_15 () ] ;
vr_93 [ vr_35 . vr_15 () ] ^= vr_4 . vr_93 [ vr_35 . vr_15 () ] ;
}
private boolean fn_43 ( final tp_2 vr_35 ) {
return vr_93 [ vr_35 . vr_15 () ] ;
}
private boolean fn_42 ( final tp_2 vr_35 ) {
return ! vr_93 [ vr_35 . vr_15 () ] ;
}
private void vr_46 ( final tp_2 vr_35 ) {
vr_93 [ vr_35 . vr_15 () ] = true ;
}
private void vr_47 ( final tp_2 vr_35 ) {
vr_93 [ vr_35 . vr_15 () ] = false ;
}
private void fn_41 ( final vr_3 < vt_1 , tp_1 > vr_4 , final tp_2 vr_35 ) {
vr_93 [ vr_35 . vr_15 () ] = vr_4 . vr_93 [ vr_35 . vr_15 () ] ;
}
private boolean vr_52 ( final tp_2 vr_35 ) {
return vr_92 [ vr_35 . vr_15 () ] != null
&& vr_92 [ vr_35 . vr_15 () ] . vr_90 [ vr_35 . vr_15 () ] == this ;
}
private boolean vr_54 ( final tp_2 vr_35 ) {
return vr_92 [ vr_35 . vr_15 () ] != null
&& vr_92 [ vr_35 . vr_15 () ] . vr_91 [ vr_35 . vr_15 () ] == this ;
}
@Override
public vt_1 vr_12 () {
return vr_1 ;
}
@Override
public tp_1 vr_5 () {
return vr_2 ;
}
@Override
public tp_1 fn_67 ( final tp_1 vr_94 ) throws fn_68 {
throw new fn_68 ( lr_12 ) ;
}
@Override
public boolean equals ( final Object vr_21 ) {
if ( vr_21 == this ) {
return true ;
}
if ( ! ( vr_21 instanceof vr_7 . vr_9 ) ) {
return false ;
}
final vr_7 . vr_9 < ? , ? > vr_10 = ( vr_7 . vr_9 < ? , ? > ) vr_21 ;
return vr_12 () . equals ( vr_10 . vr_12 () ) && vr_5 () . equals ( vr_10 . vr_5 () ) ;
}
@Override
public int fn_33 () {
if ( ! vl_12 ) {
vl_13 = vr_12 () . fn_33 () ^ vr_5 () . fn_33 () ;
vl_12 = true ;
}
return vl_13 ;
}
@Override
public int size () {
return vr_87 . this . size () ;
}
@Override
public boolean isEmpty () {
return vr_87 . this . isEmpty () ;
}
@Override
public vt_1 get ( final Object vr_1 ) {
return vr_87 . this . vr_12 ( vr_1 ) ;
}
@Override
public tp_1 vr_12 ( final Object vr_2 ) {
return vr_87 . this . get ( vr_2 ) ;
}
@Override
public boolean fn_1 ( final Object vr_1 ) {
return vr_87 . this . fn_4 ( vr_1 ) ;
}
@Override
public boolean fn_4 ( final Object vr_2 ) {
return vr_87 . this . fn_1 ( vr_2 ) ;
}
@Override
public tp_1 fn_14 () {
if ( vr_87 . this . vl_2 == 0 ) {
throw new fn_15 ( lr_1 ) ;
}
return fn_16 ( vr_87 . this . vr_13 [ vr_16 . vr_15 () ] , vr_16 ) . vr_5 () ;
}
@Override
public tp_1 fn_17 () {
if ( vr_87 . this . vl_2 == 0 ) {
throw new fn_15 ( lr_1 ) ;
}
return fn_18 ( vr_87 . this . vr_13 [ vr_16 . vr_15 () ] , vr_16 ) . vr_5 () ;
}
@Override
public tp_1 fn_19 ( final tp_1 vr_1 ) {
fn_2 ( vr_1 ) ;
final vr_3 < vt_1 , tp_1 > vr_4 = fn_20 ( vr_87 . this . <tp_1 > fn_40 ( vr_1 , vr_16 ) , vr_16 ) ;
return vr_4 == null ? null : vr_4 . vr_5 () ;
}
@Override
public tp_1 fn_21 ( final tp_1 vr_1 ) {
fn_2 ( vr_1 ) ;
final vr_3 < vt_1 , tp_1 > vr_4 = vr_87 . this . fn_22 ( vr_87 . this . <tp_1 > fn_40 ( vr_1 , vr_16 ) , vr_16 ) ;
return vr_4 == null ? null : vr_4 . vr_5 () ;
}
@Override
public vt_1 fn_7 ( final tp_1 vr_1 , final vt_1 vr_2 ) {
final vt_1 vr_6 = get ( vr_1 ) ;
vr_87 . this . fn_8 ( vr_2 , vr_1 ) ;
return vr_6 ;
}
@Override
public void fn_9 ( final vr_7 < ? extends tp_1 , ? extends vt_1 > vr_8 ) {
for ( final vr_7 . vr_9 < ? extends tp_1 , ? extends vt_1 > vr_10 : vr_8 . vr_11 () ) {
fn_7 ( vr_10 . vr_12 () , vr_10 . vr_5 () ) ;
}
}
@Override
public vt_1 remove ( final Object vr_1 ) {
return vr_87 . this . fn_12 ( vr_1 ) ;
}
@Override
public tp_1 fn_12 ( final Object vr_2 ) {
return vr_87 . this . remove ( vr_2 ) ;
}
@Override
public void clear () {
vr_87 . this . clear () ;
}
@Override
public vr_17 < tp_1 > fn_23 () {
if ( vl_14 == null ) {
vl_14 = new fn_26 ( vr_16 ) ;
}
return vl_14 ;
}
@Override
public vr_17 < vt_1 > fn_25 () {
if ( vl_15 == null ) {
vl_15 = new fn_24 ( vr_16 ) ;
}
return vl_15 ;
}
@Override
public vr_17 < vr_7 . vr_9 < tp_1 , vt_1 > > vr_11 () {
if ( vl_16 == null ) {
vl_16 = new fn_71 () ;
}
return vl_16 ;
}
@Override
public vr_18 < tp_1 , vt_1 > fn_28 () {
if ( isEmpty () ) {
return vr_19 . <tp_1 , vt_1 > fn_29 () ;
}
return new fn_57 ( vr_16 ) ;
}
@Override
public vr_20 < vt_1 , tp_1 > fn_31 () {
return vr_87 . this ;
}
@Override
public boolean equals ( final Object vr_21 ) {
return vr_87 . this . vr_22 ( vr_21 , tp_2 . vr_16 ) ;
}
@Override
public int fn_33 () {
return vr_87 . this . vr_23 ( tp_2 . vr_16 ) ;
}
@Override
public String toString () {
return vr_87 . this . vr_24 ( tp_2 . vr_16 ) ;
}
