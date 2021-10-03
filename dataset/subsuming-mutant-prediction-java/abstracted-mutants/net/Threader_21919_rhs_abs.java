public tp_1 fn_1 ( final List < ? extends tp_1 > vr_1 ) {
return fn_1 ( ( vr_2 < ? extends tp_1 > ) vr_1 ) ;
}
public tp_1 fn_1 ( final vr_2 < ? extends tp_1 > vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
vr_3 < String , vt_1 > vr_4 = new vr_3 <> () ;
for ( final tp_1 vr_5 : vr_1 ) {
if ( ! vr_5 . vr_6 () ) {
fn_2 ( vr_5 , vr_4 ) ;
}
}
if ( vr_4 . isEmpty () ) {
return null ;
}
final vt_1 vr_7 = fn_3 ( vr_4 ) ;
vr_4 . clear () ;
vr_4 = null ;
fn_4 ( vr_7 ) ;
vr_7 . vr_8 () ;
fn_5 ( vr_7 ) ;
if ( vr_7 . vr_9 != null ) {
throw new fn_6 ( lr_1 + vr_7 ) ;
}
for ( vt_1 vr_10 = vr_7 . vr_11 ; vr_10 != null ; vr_10 = vr_10 . vr_9 ) {
if ( vr_10 . vr_12 == null ) {
vr_10 . vr_12 = vr_10 . vr_11 . vr_12 . vr_13 () ; MST[NonVoidMethodCallMutator]MSP[S]
}
}
final tp_1 vr_14 = ( vr_7 . vr_11 == null ? null : vr_7 . vr_11 . vr_12 ) ;
vr_7 . vr_15 () ;
return vr_14 ;
}
private void fn_2 ( final tp_1 vr_12 , final vr_3 < String , vt_1 > vr_4 ) {
String vr_16 = vr_12 . vr_17 () ;
vt_1 vr_18 = vr_4 . get ( vr_16 ) ;
int vr_19 = 0 ;
if ( vr_18 != null ) {
if ( vr_18 . vr_12 != null ) {
vr_19 ++ ;
vr_16 = lr_2 + ( vr_19 ) + lr_3 ;
vr_18 = null ;
} else {
vr_18 . vr_12 = vr_12 ;
}
}
if ( vr_18 == null ) {
vr_18 = new vt_1 () ;
vr_18 . vr_12 = vr_12 ;
vr_4 . vr_20 ( vr_16 , vr_18 ) ;
}
vt_1 vr_21 = null ;
{
final String [] vr_22 = vr_12 . vr_23 () ;
for ( final String vr_24 : vr_22 )
{
vt_1 vr_25 = vr_4 . get ( vr_24 ) ;
if ( vr_25 == null ) {
vr_25 = new vt_1 () ;
vr_4 . vr_20 ( vr_24 , vr_25 ) ;
}
if ( ( vr_21 != null )
&& ( vr_25 . vr_26 == null )
&& ( vr_21 != vr_25 )
&& ! ( vr_25 . vr_27 ( vr_21 ) ) ) {
vr_25 . vr_26 = vr_21 ;
vr_25 . vr_9 = vr_21 . vr_11 ;
vr_21 . vr_11 = vr_25 ;
}
vr_21 = vr_25 ;
}
}
if ( vr_21 != null
&& ( vr_21 == vr_18 || vr_18 . vr_27 ( vr_21 ) ) )
{
vr_21 = null ;
}
if ( vr_18 . vr_26 != null ) {
vt_1 vr_28 , vr_29 ;
for ( vr_29 = null , vr_28 = vr_18 . vr_26 . vr_11 ;
vr_28 != null ;
vr_29 = vr_28 , vr_28 = vr_28 . vr_9 ) {
if ( vr_28 == vr_18 ) {
break;
}
}
if ( vr_28 == null ) {
throw new fn_6 (
lr_4
+ vr_18
+ lr_5
+ vr_18 . vr_26 ) ;
}
if ( vr_29 == null ) {
vr_18 . vr_26 . vr_11 = vr_18 . vr_9 ;
} else {
vr_29 . vr_9 = vr_18 . vr_9 ;
}
vr_18 . vr_9 = null ;
vr_18 . vr_26 = null ;
}
if ( vr_21 != null ) {
vr_18 . vr_26 = vr_21 ;
vr_18 . vr_9 = vr_21 . vr_11 ;
vr_21 . vr_11 = vr_18 ;
}
}
private vt_1 fn_3 ( final vr_3 < String , vt_1 > vr_4 ) {
final vt_1 vr_7 = new vt_1 () ;
final Iterator < vr_30 . vr_31 < String , vt_1 > > vr_32 = vr_4 . vr_33 () . iterator () ;
while ( vr_32 . hasNext () ) {
final vr_30 . vr_31 < String , vt_1 > vr_34 = vr_32 . vr_9 () ;
final vt_1 vr_35 = vr_34 . vr_36 () ;
if ( vr_35 . vr_26 == null ) {
if ( vr_35 . vr_9 != null ) {
throw new fn_6 (
lr_6 + vr_35 . vr_9 . toString () ) ;
}
vr_35 . vr_9 = vr_7 . vr_11 ;
vr_7 . vr_11 = vr_35 ;
}
}
return vr_7 ;
}
private void fn_4 ( final vt_1 vr_26 ) {
vt_1 vr_18 , vr_29 , vr_9 ;
for ( vr_29 = null , vr_18 = vr_26 . vr_11 , vr_9 = vr_18 . vr_9 ;
vr_18 != null ;
vr_29 = vr_18 ,
vr_18 = vr_9 ,
vr_9 = ( vr_18 == null ? null : vr_18 . vr_9 ) ) {
if ( vr_18 . vr_12 == null && vr_18 . vr_11 == null ) {
if ( vr_29 == null ) {
vr_26 . vr_11 = vr_18 . vr_9 ;
} else {
vr_29 . vr_9 = vr_18 . vr_9 ;
}
vr_18 = vr_29 ;
}
else if (
vr_18 . vr_12 == null
&& vr_18 . vr_11 != null
&& ( vr_18 . vr_26 != null
|| vr_18 . vr_11 . vr_9 == null ) ) {
vt_1 vr_37 ;
final vt_1 vr_38 = vr_18 . vr_11 ;
if ( vr_29 == null ) {
vr_26 . vr_11 = vr_38 ;
} else {
vr_29 . vr_9 = vr_38 ;
}
for ( vr_37 = vr_38 ; vr_37 . vr_9 != null ; vr_37 = vr_37 . vr_9 ) {
vr_37 . vr_26 = vr_18 . vr_26 ;
}
vr_37 . vr_26 = vr_18 . vr_26 ;
vr_37 . vr_9 = vr_18 . vr_9 ;
vr_9 = vr_38 ;
vr_18 = vr_29 ;
} else if ( vr_18 . vr_11 != null ) {
fn_4 ( vr_18 ) ;
}
}
}
private void fn_5 ( final vt_1 vr_7 ) {
int vr_39 = 0 ;
for ( vt_1 vr_35 = vr_7 . vr_11 ; vr_35 != null ; vr_35 = vr_35 . vr_9 ) {
vr_39 ++ ;
}
vr_3 < String , vt_1 > vr_40 = new vr_3 <> ( (int) ( vr_39 * 1.2 ) , ( float ) 0.9 ) ;
vr_39 = 0 ;
for ( vt_1 vr_35 = vr_7 . vr_11 ; vr_35 != null ; vr_35 = vr_35 . vr_9 ) {
tp_1 vr_12 = vr_35 . vr_12 ;
if ( vr_12 == null ) {
vr_12 = vr_35 . vr_11 . vr_12 ;
}
final String vr_41 = vr_12 . vr_42 () ;
if ( vr_41 == null || vr_41 . length () == 0 ) {
continue;
}
final vt_1 vr_43 = vr_40 . get ( vr_41 ) ;
if ( vr_43 == null
|| ( vr_35 . vr_12 == null && vr_43 . vr_12 != null )
|| ( vr_43 . vr_12 != null
&& vr_43 . vr_12 . vr_44 ()
&& vr_35 . vr_12 != null
&& ! vr_35 . vr_12 . vr_44 () ) ) {
vr_40 . vr_20 ( vr_41 , vr_35 ) ;
vr_39 ++ ;
}
}
if ( vr_39 == 0 ) {
return;
}
vt_1 vr_29 , vr_35 , vr_28 ;
for ( vr_29 = null , vr_35 = vr_7 . vr_11 , vr_28 = vr_35 . vr_9 ;
vr_35 != null ;
vr_29 = vr_35 , vr_35 = vr_28 , vr_28 = ( vr_28 == null ? null : vr_28 . vr_9 ) ) {
tp_1 vr_12 = vr_35 . vr_12 ;
if ( vr_12 == null ) {
vr_12 = vr_35 . vr_11 . vr_12 ;
}
final String vr_41 = vr_12 . vr_42 () ;
if ( vr_41 == null || vr_41 . length () == 0 ) {
continue;
}
final vt_1 vr_43 = vr_40 . get ( vr_41 ) ;
if ( vr_43 == vr_35 ) {
continue;
}
if ( vr_29 == null ) {
vr_7 . vr_11 = vr_35 . vr_9 ;
} else {
vr_29 . vr_9 = vr_35 . vr_9 ;
}
vr_35 . vr_9 = null ;
if ( vr_43 . vr_12 == null && vr_35 . vr_12 == null ) {
vt_1 vr_37 ;
for ( vr_37 = vr_43 . vr_11 ;
vr_37 != null && vr_37 . vr_9 != null ;
vr_37 = vr_37 . vr_9 ) {
}
if ( vr_37 != null ) {
vr_37 . vr_9 = vr_35 . vr_11 ;
}
for ( vr_37 = vr_35 . vr_11 ; vr_37 != null ; vr_37 = vr_37 . vr_9 ) {
vr_37 . vr_26 = vr_43 ;
}
vr_35 . vr_11 = null ;
} else if (
vr_43 . vr_12 == null
|| ( vr_35 . vr_12 != null
&& vr_35 . vr_12 . vr_44 ()
&& ! vr_43 . vr_12 . vr_44 () ) ) {
vr_35 . vr_26 = vr_43 ;
vr_35 . vr_9 = vr_43 . vr_11 ;
vr_43 . vr_11 = vr_35 ;
} else {
final vt_1 vr_45 = new vt_1 () ;
vr_45 . vr_12 = vr_43 . vr_12 ;
vr_45 . vr_11 = vr_43 . vr_11 ;
for ( vt_1 vr_37 = vr_45 . vr_11 ;
vr_37 != null ;
vr_37 = vr_37 . vr_9 )
{
vr_37 . vr_26 = vr_45 ;
}
vr_43 . vr_12 = null ;
vr_43 . vr_11 = null ;
vr_35 . vr_26 = vr_43 ;
vr_45 . vr_26 = vr_43 ;
vr_43 . vr_11 = vr_35 ;
vr_35 . vr_9 = vr_45 ;
}
vr_35 = vr_29 ;
}
vr_40 . clear () ;
vr_40 = null ;
}
@Deprecated
public tp_1 fn_1 ( final tp_1 [] vr_1 ) {
if ( vr_1 == null ) {
return null ;
}
return fn_1 ( vr_46 . vr_47 ( vr_1 ) ) ;
}
