public static tp_1 fn_1 ( tp_2 vr_1 , tp_3 vr_2 ) {
if ( vr_1 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
vr_1 = vr_1 . vr_3 () ;
if ( vr_1 == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( vr_2 == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
return new tp_1 ( vr_1 , vr_2 ) ;
}
static boolean fn_2 ( tp_4 vr_4 ) {
return vr_4 != null && vr_4 . vr_5 () < vr_6 . vr_7 * 12 ;
}
public tp_3 fn_3 () {
return ( tp_3 ) fn_4 () ;
}
public tp_2 vr_3 () {
return fn_5 () ;
}
public tp_2 fn_6 ( tp_3 vr_2 ) {
if ( vr_2 == null ) {
vr_2 = tp_3 . vr_8 () ;
}
if ( vr_2 == fn_4 () ) {
return this ;
}
if ( vr_2 == tp_3 . vr_9 ) {
return fn_5 () ;
}
return new tp_1 ( fn_5 () , vr_2 ) ;
}
public long fn_7 ( int vr_10 , int vr_11 , int vr_12 ,
int vr_13 )
throws IllegalArgumentException
{
return fn_8 ( fn_5 () . fn_7
( vr_10 , vr_11 , vr_12 , vr_13 ) ) ;
}
public long fn_7 ( int vr_10 , int vr_11 , int vr_12 ,
int vr_14 , int vr_15 ,
int vr_16 , int vr_17 )
throws IllegalArgumentException
{
return fn_8 ( fn_5 () . fn_7
( vr_10 , vr_11 , vr_12 ,
vr_14 , vr_15 , vr_16 , vr_17 ) ) ;
}
public long fn_7 ( long vr_18 ,
int vr_14 , int vr_15 ,
int vr_16 , int vr_17 )
throws IllegalArgumentException
{
return fn_8 ( fn_5 () . fn_7
( vr_18 + fn_3 () . fn_9 ( vr_18 ) ,
vr_14 , vr_15 , vr_16 , vr_17 ) ) ;
}
private long fn_8 ( long vr_19 ) {
if ( vr_19 == Long . vr_20 ) {
return Long . vr_20 ;
} else if ( vr_19 == Long . vr_21 ) {
return Long . vr_21 ;
}
tp_3 vr_2 = fn_3 () ;
int vr_22 = vr_2 . vr_23 ( vr_19 ) ;
long vr_24 = vr_19 - vr_22 ;
if ( vr_19 > vl_1 && vr_24 < 0 ) {
return Long . vr_20 ;
} else if ( vr_19 < - vl_1 && vr_24 > 0 ) {
return Long . vr_21 ;
}
int vr_25 = vr_2 . fn_9 ( vr_24 ) ;
if ( vr_22 != vr_25 ) {
throw new fn_10 ( vr_19 , vr_2 . vr_26 () ) ;
}
return vr_24 ;
}
protected void fn_11 ( tp_5 vr_27 ) {
vr_28 < Object , Object > vr_29 = new vr_28 < Object , Object > () ;
vr_27 . vr_30 = fn_12 ( vr_27 . vr_30 , vr_29 ) ;
vr_27 . vr_31 = fn_12 ( vr_27 . vr_31 , vr_29 ) ;
vr_27 . vr_32 = fn_12 ( vr_27 . vr_32 , vr_29 ) ;
vr_27 . vr_33 = fn_12 ( vr_27 . vr_33 , vr_29 ) ;
vr_27 . vr_34 = fn_12 ( vr_27 . vr_34 , vr_29 ) ;
vr_27 . vr_35 = fn_12 ( vr_27 . vr_35 , vr_29 ) ;
vr_27 . vr_36 = fn_12 ( vr_27 . vr_36 , vr_29 ) ;
vr_27 . vr_37 = fn_12 ( vr_27 . vr_37 , vr_29 ) ;
vr_27 . vr_38 = fn_12 ( vr_27 . vr_38 , vr_29 ) ;
vr_27 . vr_39 = fn_12 ( vr_27 . vr_39 , vr_29 ) ;
vr_27 . vr_40 = fn_12 ( vr_27 . vr_40 , vr_29 ) ;
vr_27 . vr_41 = fn_12 ( vr_27 . vr_41 , vr_29 ) ;
vr_27 . vr_10 = fn_12 ( vr_27 . vr_10 , vr_29 ) ;
vr_27 . vr_42 = fn_12 ( vr_27 . vr_42 , vr_29 ) ;
vr_27 . vr_43 = fn_12 ( vr_27 . vr_43 , vr_29 ) ;
vr_27 . vr_44 = fn_12 ( vr_27 . vr_44 , vr_29 ) ;
vr_27 . vr_45 = fn_12 ( vr_27 . vr_45 , vr_29 ) ;
vr_27 . vr_46 = fn_12 ( vr_27 . vr_46 , vr_29 ) ;
vr_27 . vr_12 = fn_12 ( vr_27 . vr_12 , vr_29 ) ;
vr_27 . vr_47 = fn_12 ( vr_27 . vr_47 , vr_29 ) ;
vr_27 . vr_11 = fn_12 ( vr_27 . vr_11 , vr_29 ) ;
vr_27 . vr_48 = fn_12 ( vr_27 . vr_48 , vr_29 ) ;
vr_27 . vr_49 = fn_12 ( vr_27 . vr_49 , vr_29 ) ;
vr_27 . vr_50 = fn_12 ( vr_27 . vr_50 , vr_29 ) ;
vr_27 . vr_17 = fn_12 ( vr_27 . vr_17 , vr_29 ) ;
vr_27 . vr_13 = fn_12 ( vr_27 . vr_13 , vr_29 ) ;
vr_27 . vr_16 = fn_12 ( vr_27 . vr_16 , vr_29 ) ;
vr_27 . vr_51 = fn_12 ( vr_27 . vr_51 , vr_29 ) ;
vr_27 . vr_15 = fn_12 ( vr_27 . vr_15 , vr_29 ) ;
vr_27 . vr_52 = fn_12 ( vr_27 . vr_52 , vr_29 ) ;
vr_27 . vr_14 = fn_12 ( vr_27 . vr_14 , vr_29 ) ;
vr_27 . vr_53 = fn_12 ( vr_27 . vr_53 , vr_29 ) ;
vr_27 . vr_54 = fn_12 ( vr_27 . vr_54 , vr_29 ) ;
vr_27 . vr_55 = fn_12 ( vr_27 . vr_55 , vr_29 ) ;
vr_27 . vr_56 = fn_12 ( vr_27 . vr_56 , vr_29 ) ;
}
private tp_4 fn_12 ( tp_4 vr_4 , vr_28 < Object , Object > vr_29 ) {
if ( vr_4 == null || ! vr_4 . vr_57 () ) {
return vr_4 ;
}
if ( vr_29 . vr_58 ( vr_4 ) ) {
return ( tp_4 ) vr_29 . get ( vr_4 ) ;
}
tp_6 vr_59 = new tp_6 ( vr_4 , fn_3 () ) ;
vr_29 . vr_60 ( vr_4 , vr_59 ) ;
return vr_59 ;
}
private tp_7 fn_12 ( tp_7 vr_4 , vr_28 < Object , Object > vr_29 ) {
if ( vr_4 == null || ! vr_4 . vr_57 () ) {
return vr_4 ;
}
if ( vr_29 . vr_58 ( vr_4 ) ) {
return ( tp_7 ) vr_29 . get ( vr_4 ) ;
}
tp_8 vr_59 =
new tp_8 ( vr_4 , fn_3 () ,
fn_12 ( vr_4 . vr_61 () , vr_29 ) ,
fn_12 ( vr_4 . vr_62 () , vr_29 ) ,
fn_12 ( vr_4 . vr_63 () , vr_29 ) ) ;
vr_29 . vr_60 ( vr_4 , vr_59 ) ;
return vr_59 ;
}
public boolean equals ( Object vr_64 ) {
if ( this == vr_64 ) {
return true ;
}
if ( vr_64 instanceof tp_1 == false ) {
return false ;
}
tp_1 vr_65 = ( tp_1 ) vr_64 ;
return
fn_5 () . equals ( vr_65 . fn_5 () ) &&
fn_3 () . equals ( vr_65 . fn_3 () ) ;
}
public int fn_13 () {
return 326565 + fn_3 () . fn_13 () * 11 + fn_5 () . fn_13 () * 7 ;
}
public String toString () {
return lr_4 + fn_5 () + lr_5 + fn_3 () . vr_26 () + ']' ;
}
public boolean fn_14 () {
return vl_2 ? vr_66 . fn_14 () : vr_66 . fn_14 () && this . vr_67 . vr_68 () ;
}
public long vr_5 () {
return vr_66 . vr_5 () ;
}
public int fn_15 ( long vr_69 , long vr_18 ) {
return vr_66 . fn_15 ( vr_69 , fn_16 ( vr_18 ) ) ;
}
public long fn_17 ( long vr_69 , long vr_18 ) {
return vr_66 . fn_17 ( vr_69 , fn_16 ( vr_18 ) ) ;
}
public long fn_18 ( int vr_70 , long vr_18 ) {
return vr_66 . fn_18 ( vr_70 , fn_16 ( vr_18 ) ) ;
}
public long fn_18 ( long vr_70 , long vr_18 ) {
return vr_66 . fn_18 ( vr_70 , fn_16 ( vr_18 ) ) ;
}
public long add ( long vr_18 , int vr_70 ) {
int vr_22 = fn_19 ( vr_18 ) ;
vr_18 = vr_66 . add ( vr_18 + vr_22 , vr_70 ) ;
return vr_18 - ( vl_2 ? vr_22 : fn_20 ( vr_18 ) ) ;
}
public long add ( long vr_18 , long vr_70 ) {
int vr_22 = fn_19 ( vr_18 ) ;
vr_18 = vr_66 . add ( vr_18 + vr_22 , vr_70 ) ;
return vr_18 - ( vl_2 ? vr_22 : fn_20 ( vr_18 ) ) ;
}
public int fn_21 ( long vr_71 , long vr_72 ) {
int vr_22 = fn_19 ( vr_72 ) ;
return vr_66 . fn_21
( vr_71 + ( vl_2 ? vr_22 : fn_19 ( vr_71 ) ) ,
vr_72 + vr_22 ) ;
}
public long fn_22 ( long vr_71 , long vr_72 ) {
int vr_22 = fn_19 ( vr_72 ) ;
return vr_66 . fn_22
( vr_71 + ( vl_2 ? vr_22 : fn_19 ( vr_71 ) ) ,
vr_72 + vr_22 ) ;
}
private int fn_19 ( long vr_18 ) {
int vr_22 = this . vr_67 . fn_9 ( vr_18 ) ;
long vr_73 = vr_18 + vr_22 ;
if ( ( vr_18 ^ vr_73 ) < 0 && ( vr_18 ^ vr_22 ) >= 0 ) {
throw new fn_23 ( lr_6 ) ;
}
return vr_22 ;
}
private int fn_20 ( long vr_18 ) {
int vr_22 = this . vr_67 . vr_23 ( vr_18 ) ;
long vr_74 = vr_18 - vr_22 ;
if ( ( vr_18 ^ vr_74 ) < 0 && ( vr_18 ^ vr_22 ) < 0 ) {
throw new fn_23 ( lr_7 ) ;
}
return vr_22 ;
}
private long fn_16 ( long vr_18 ) {
return vr_67 . vr_75 ( vr_18 ) ;
}
@Override
public boolean equals ( Object vr_64 ) {
if ( this == vr_64 ) {
return true ;
} else if ( vr_64 instanceof tp_6 ) {
tp_6 vr_76 = ( tp_6 ) vr_64 ;
return vr_66 . equals ( vr_76 . vr_66 ) &&
vr_67 . equals ( vr_76 . vr_67 ) ;
}
return false ;
}
@Override
public int fn_13 () {
return vr_66 . fn_13 () ^ vr_67 . fn_13 () ;
}
public boolean fn_24 () {
return vr_66 . fn_24 () ;
}
public int get ( long vr_18 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . get ( vr_19 ) ;
}
public String fn_25 ( long vr_18 , tp_9 vr_77 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . fn_25 ( vr_19 , vr_77 ) ;
}
public String fn_26 ( long vr_18 , tp_9 vr_77 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . fn_26 ( vr_19 , vr_77 ) ;
}
public String fn_25 ( int vr_78 , tp_9 vr_77 ) {
return vr_66 . fn_25 ( vr_78 , vr_77 ) ;
}
public String fn_26 ( int vr_78 , tp_9 vr_77 ) {
return vr_66 . fn_26 ( vr_78 , vr_77 ) ;
}
public long add ( long vr_18 , int vr_70 ) {
if ( vl_2 ) {
int vr_22 = fn_19 ( vr_18 ) ;
long vr_19 = vr_66 . add ( vr_18 + vr_22 , vr_70 ) ;
return vr_19 - vr_22 ;
} else {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
vr_19 = vr_66 . add ( vr_19 , vr_70 ) ;
return vr_67 . vr_79 ( vr_19 , false , vr_18 ) ;
}
}
public long add ( long vr_18 , long vr_70 ) {
if ( vl_2 ) {
int vr_22 = fn_19 ( vr_18 ) ;
long vr_19 = vr_66 . add ( vr_18 + vr_22 , vr_70 ) ;
return vr_19 - vr_22 ;
} else {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
vr_19 = vr_66 . add ( vr_19 , vr_70 ) ;
return vr_67 . vr_79 ( vr_19 , false , vr_18 ) ;
}
}
public long fn_27 ( long vr_18 , int vr_70 ) {
if ( vl_2 ) {
int vr_22 = fn_19 ( vr_18 ) ;
long vr_19 = vr_66 . fn_27 ( vr_18 + vr_22 , vr_70 ) ;
return vr_19 - vr_22 ;
} else {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
vr_19 = vr_66 . fn_27 ( vr_19 , vr_70 ) ;
return vr_67 . vr_79 ( vr_19 , false , vr_18 ) ;
}
}
public long fn_28 ( long vr_18 , int vr_70 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
vr_19 = vr_66 . fn_28 ( vr_19 , vr_70 ) ;
long vr_80 = vr_67 . vr_79 ( vr_19 , false , vr_18 ) ;
if ( get ( vr_80 ) != vr_70 ) {
fn_10 vr_81 = new fn_10 ( vr_19 , vr_67 . vr_26 () ) ;
tp_10 vr_82 = new tp_10 ( vr_66 . getType () , Integer . valueOf ( vr_70 ) , vr_81 . vr_83 () ) ;
vr_82 . vr_84 ( vr_81 ) ;
throw vr_82 ;
}
return vr_80 ;
}
public long fn_28 ( long vr_18 , String vr_85 , tp_9 vr_77 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
vr_19 = vr_66 . fn_28 ( vr_19 , vr_85 , vr_77 ) ;
return vr_67 . vr_79 ( vr_19 , false , vr_18 ) ;
}
public int fn_21 ( long vr_71 , long vr_72 ) {
int vr_22 = fn_19 ( vr_72 ) ;
return vr_66 . fn_21
( vr_71 + ( vl_2 ? vr_22 : fn_19 ( vr_71 ) ) ,
vr_72 + vr_22 ) ;
}
public long fn_22 ( long vr_71 , long vr_72 ) {
int vr_22 = fn_19 ( vr_72 ) ;
return vr_66 . fn_22
( vr_71 + ( vl_2 ? vr_22 : fn_19 ( vr_71 ) ) ,
vr_72 + vr_22 ) ;
}
public final tp_4 vr_61 () {
return vl_3 ;
}
public final tp_4 vr_62 () {
return vl_4 ;
}
public boolean fn_29 ( long vr_18 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . fn_29 ( vr_19 ) ;
}
public int fn_30 ( long vr_18 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . fn_30 ( vr_19 ) ;
}
public final tp_4 vr_63 () {
return vl_5 ;
}
public long fn_31 ( long vr_18 ) {
if ( vl_2 ) {
int vr_22 = fn_19 ( vr_18 ) ;
vr_18 = vr_66 . fn_31 ( vr_18 + vr_22 ) ;
return vr_18 - vr_22 ;
} else {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
vr_19 = vr_66 . fn_31 ( vr_19 ) ;
return vr_67 . vr_79 ( vr_19 , false , vr_18 ) ;
}
}
public long fn_32 ( long vr_18 ) {
if ( vl_2 ) {
int vr_22 = fn_19 ( vr_18 ) ;
vr_18 = vr_66 . fn_32 ( vr_18 + vr_22 ) ;
return vr_18 - vr_22 ;
} else {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
vr_19 = vr_66 . fn_32 ( vr_19 ) ;
return vr_67 . vr_79 ( vr_19 , false , vr_18 ) ;
}
}
public long fn_33 ( long vr_18 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . fn_33 ( vr_19 ) ;
}
public int fn_34 () {
return vr_66 . fn_34 () ;
}
public int fn_34 ( long vr_18 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . fn_34 ( vr_19 ) ;
}
public int fn_34 ( tp_11 vr_18 ) {
return vr_66 . fn_34 ( vr_18 ) ;
}
public int fn_34 ( tp_11 vr_18 , int [] vr_86 ) {
return vr_66 . fn_34 ( vr_18 , vr_86 ) ;
}
public int fn_35 () {
return vr_66 . fn_35 () ;
}
public int fn_35 ( long vr_18 ) {
long vr_19 = vr_67 . vr_75 ( vr_18 ) ;
return vr_66 . fn_35 ( vr_19 ) ;
}
public int fn_35 ( tp_11 vr_18 ) {
return vr_66 . fn_35 ( vr_18 ) ;
}
public int fn_35 ( tp_11 vr_18 , int [] vr_86 ) {
return vr_66 . fn_35 ( vr_18 , vr_86 ) ;
}
public int fn_36 ( tp_9 vr_77 ) {
return vr_66 . fn_36 ( vr_77 ) ;
}
public int fn_37 ( tp_9 vr_77 ) {
return vr_66 . fn_37 ( vr_77 ) ;
}
private int fn_19 ( long vr_18 ) {
int vr_22 = this . vr_67 . fn_9 ( vr_18 ) ;
long vr_73 = vr_18 + vr_22 ;
if ( ( vr_18 ^ vr_73 ) < 0 && ( vr_18 ^ vr_22 ) >= 0 ) {
throw new fn_23 ( lr_6 ) ;
}
return vr_22 ;
}
@Override
public boolean equals ( Object vr_64 ) {
if ( this == vr_64 ) {
return true ;
} else if ( vr_64 instanceof tp_8 ) {
tp_8 vr_76 = ( tp_8 ) vr_64 ;
return vr_66 . equals ( vr_76 . vr_66 ) &&
vr_67 . equals ( vr_76 . vr_67 ) &&
vl_3 . equals ( vr_76 . vl_3 ) &&
vl_4 . equals ( vr_76 . vl_4 ) ;
}
return false ;
}
@Override
public int fn_13 () {
return vr_66 . fn_13 () ^ vr_67 . fn_13 () ;
}
