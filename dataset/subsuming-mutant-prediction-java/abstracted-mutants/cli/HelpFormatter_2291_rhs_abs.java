public void setWidth ( final int vr_1 )
{
this . vr_2 = vr_1 ;
}
public int getWidth ()
{
return vr_2 ;
}
public void fn_1 ( final int vr_3 )
{
this . vr_4 = vr_3 ;
}
public int fn_2 ()
{
return vr_4 ;
}
public void fn_3 ( final int vr_3 )
{
this . vr_5 = vr_3 ;
}
public int fn_4 ()
{
return vr_5 ;
}
public void fn_5 ( final String vr_6 )
{
this . vr_7 = vr_6 ;
}
public String fn_6 ()
{
return vr_7 ;
}
public void fn_7 ( final String vr_8 )
{
this . vr_9 = vr_8 ;
}
public String fn_8 ()
{
return vr_9 ;
}
public void fn_9 ( final String vr_6 )
{
this . vr_10 = vr_6 ;
}
public String fn_10 ()
{
return vr_10 ;
}
public void fn_11 ( final String vr_6 )
{
this . vr_11 = vr_6 ;
}
public String fn_12 ()
{
return vr_11 ;
}
public void fn_13 ( final String vr_12 )
{
this . vr_12 = vr_12 ;
}
public String fn_14 ()
{
return vr_12 ;
}
public void fn_15 ( final String vr_13 )
{
this . vr_14 = vr_13 ;
}
public String fn_16 ()
{
return vr_14 ;
}
public vr_15 < vt_1 > fn_17 ()
{
return vl_1 ;
}
public void fn_18 ( final vr_15 < vt_1 > vr_16 )
{
this . vl_1 = vr_16 ;
}
public void fn_19 ( final String vr_17 , final tp_1 vr_18 )
{
fn_19 ( getWidth () , vr_17 , null , vr_18 , null , false ) ;
}
public void fn_19 ( final String vr_17 , final tp_1 vr_18 , final boolean vr_19 )
{
fn_19 ( getWidth () , vr_17 , null , vr_18 , null , vr_19 ) ;
}
public void fn_19 ( final String vr_17 , final String vr_20 , final tp_1 vr_18 , final String vr_21 )
{
fn_19 ( vr_17 , vr_20 , vr_18 , vr_21 , false ) ;
}
public void fn_19 ( final String vr_17 , final String vr_20 , final tp_1 vr_18 , final String vr_21 , final boolean vr_19 )
{
fn_19 ( getWidth () , vr_17 , vr_20 , vr_18 , vr_21 , vr_19 ) ;
}
public void fn_19 ( final int vr_1 , final String vr_17 , final String vr_20 , final tp_1 vr_18 , final String vr_21 )
{
fn_19 ( vr_1 , vr_17 , vr_20 , vr_18 , vr_21 , false ) ;
}
public void fn_19 ( final int vr_1 , final String vr_17 , final String vr_20 ,
final tp_1 vr_18 , final String vr_21 , final boolean vr_19 )
{
final PrintWriter vr_22 = new PrintWriter ( System . out ) ;
fn_19 ( vr_22 , vr_1 , vr_17 , vr_20 , vr_18 , fn_2 () , fn_4 () , vr_21 , vr_19 ) ;
vr_22 . vr_23 () ;
}
public void fn_19 ( final PrintWriter vr_22 , final int vr_1 , final String vr_17 ,
final String vr_20 , final tp_1 vr_18 , final int vr_24 ,
final int vr_25 , final String vr_21 )
{
fn_19 ( vr_22 , vr_1 , vr_17 , vr_20 , vr_18 , vr_24 , vr_25 , vr_21 , false ) ;
}
public void fn_19 ( final PrintWriter vr_22 , final int vr_1 , final String vr_17 ,
final String vr_20 , final tp_1 vr_18 , final int vr_24 ,
final int vr_25 , final String vr_21 , final boolean vr_19 )
{
if ( vr_17 == null || vr_17 . length () == 0 )
{
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( vr_19 )
{
fn_20 ( vr_22 , vr_1 , vr_17 , vr_18 ) ;
}
else
{
fn_20 ( vr_22 , vr_1 , vr_17 ) ;
}
if ( vr_20 != null && vr_20 . trim () . length () > 0 )
{
fn_21 ( vr_22 , vr_1 , vr_20 ) ;
}
fn_22 ( vr_22 , vr_1 , vr_18 , vr_24 , vr_25 ) ;
if ( vr_21 != null && vr_21 . trim () . length () > 0 )
{
fn_21 ( vr_22 , vr_1 , vr_21 ) ;
}
}
public void fn_20 ( final PrintWriter vr_22 , final int vr_1 , final String vr_26 , final tp_1 vr_18 )
{
final tp_2 vr_27 = new tp_2 ( fn_6 () ) . append ( vr_26 ) . append ( lr_2 ) ;
final Collection < vt_2 > vr_28 = new ArrayList < vt_2 > () ;
final List < vt_1 > vr_29 = new ArrayList < vt_1 > ( vr_18 . vr_30 () ) ;
if ( fn_17 () != null )
{
vr_31 . vr_32 ( vr_29 , fn_17 () ) ;
}
for ( final Iterator < vt_1 > vr_33 = vr_29 . iterator () ; vr_33 . hasNext () ; )
{
final vt_1 vr_34 = vr_33 . vr_35 () ;
final vt_2 vr_36 = vr_18 . vr_37 ( vr_34 ) ;
if ( vr_36 != null )
{
if ( ! vr_28 . contains ( vr_36 ) )
{
vr_28 . add ( vr_36 ) ;
fn_23 ( vr_27 , vr_36 ) ;
}
}
else
{
fn_24 ( vr_27 , vr_34 , vr_34 . vr_38 () ) ;
}
if ( vr_33 . hasNext () )
{
vr_27 . append ( lr_2 ) ;
}
}
fn_21 ( vr_22 , vr_1 , vr_27 . toString () . indexOf ( ' ' ) + 1 , vr_27 . toString () ) ;
}
private void fn_23 ( final tp_2 vr_27 , final vt_2 vr_36 )
{
if ( ! vr_36 . vr_38 () )
{
vr_27 . append ( lr_3 ) ;
}
final List < vt_1 > vr_29 = new ArrayList < vt_1 > ( vr_36 . vr_30 () ) ;
if ( fn_17 () != null )
{
vr_31 . vr_32 ( vr_29 , fn_17 () ) ;
}
for ( final Iterator < vt_1 > vr_33 = vr_29 . iterator () ; vr_33 . hasNext () ; )
{
fn_24 ( vr_27 , vr_33 . vr_35 () , true ) ;
if ( vr_33 . hasNext () )
{
vr_27 . append ( lr_4 ) ;
}
}
if ( ! vr_36 . vr_38 () )
{
vr_27 . append ( lr_5 ) ;
}
}
private void fn_24 ( final tp_2 vr_27 , final vt_1 vr_34 , final boolean vr_39 )
{
if ( ! vr_39 )
{
vr_27 . append ( lr_3 ) ;
}
if ( vr_34 . vr_40 () != null )
{
vr_27 . append ( lr_6 ) . append ( vr_34 . vr_40 () ) ;
}
else
{
vr_27 . append ( lr_7 ) . append ( vr_34 . vr_41 () ) ;
}
if ( vr_34 . vr_42 () && ( vr_34 . fn_16 () == null || vr_34 . fn_16 () . length () != 0 ) )
{
vr_27 . append ( vr_34 . vr_40 () == null ? vr_12 : lr_2 ) ;
vr_27 . append ( lr_8 ) . append ( vr_34 . fn_16 () != null ? vr_34 . fn_16 () : fn_16 () ) . append ( lr_9 ) ;
}
if ( ! vr_39 )
{
vr_27 . append ( lr_5 ) ;
}
}
public void fn_20 ( final PrintWriter vr_22 , final int vr_1 , final String vr_17 )
{
final int vr_43 = vr_17 . indexOf ( ' ' ) + 1 ;
fn_21 ( vr_22 , vr_1 , fn_6 () . length () + vr_43 , fn_6 () + vr_17 ) ;
}
public void fn_22 ( final PrintWriter vr_22 , final int vr_1 , final tp_1 vr_18 ,
final int vr_24 , final int vr_25 )
{
final tp_2 vr_44 = new tp_2 () ;
fn_25 ( vr_44 , vr_1 , vr_18 , vr_24 , vr_25 ) ;
vr_22 . println ( vr_44 . toString () ) ;
}
public void fn_21 ( final PrintWriter vr_22 , final int vr_1 , final String vr_45 )
{
fn_21 ( vr_22 , vr_1 , 0 , vr_45 ) ;
}
public void fn_21 ( final PrintWriter vr_22 , final int vr_1 , final int vr_46 , final String vr_45 )
{
final tp_2 vr_44 = new tp_2 ( vr_45 . length () ) ;
fn_26 ( vr_44 , vr_1 , vr_46 , vr_45 ) ;
vr_22 . println ( vr_44 . toString () ) ;
}
protected tp_2 fn_25 ( final tp_2 vr_44 , final int vr_1 , final tp_1 vr_18 , final int vr_24 , final int vr_25 )
{
final String vr_47 = fn_27 ( vr_24 ) ;
final String vr_48 = fn_27 ( vr_25 ) ;
int vr_49 = 0 ;
final List < tp_2 > vr_50 = new ArrayList < tp_2 > () ;
final List < vt_1 > vr_29 = vr_18 . vr_51 () ;
if ( fn_17 () != null )
{
vr_31 . vr_32 ( vr_29 , fn_17 () ) ;
}
for ( final vt_1 vr_34 : vr_29 )
{
final tp_2 vr_52 = new tp_2 () ;
if ( vr_34 . vr_40 () == null )
{
vr_52 . append ( vr_47 ) . append ( lr_10 ) . append ( fn_12 () ) . append ( vr_34 . vr_41 () ) ;
}
else
{
vr_52 . append ( vr_47 ) . append ( fn_10 () ) . append ( vr_34 . vr_40 () ) ;
if ( vr_34 . vr_53 () )
{
vr_52 . append ( ',' ) . append ( fn_12 () ) . append ( vr_34 . vr_41 () ) ;
}
}
if ( vr_34 . vr_42 () )
{
final String vr_54 = vr_34 . fn_16 () ;
if ( vr_54 != null && vr_54 . length () == 0 )
{
vr_52 . append ( ' ' ) ;
}
else
{
vr_52 . append ( vr_34 . vr_53 () ? vr_12 : lr_2 ) ;
vr_52 . append ( lr_8 ) . append ( vr_54 != null ? vr_34 . fn_16 () : fn_16 () ) . append ( lr_9 ) ;
}
}
vr_50 . add ( vr_52 ) ;
vr_49 = vr_52 . length () > vr_49 ? vr_52 . length () : vr_49 ;
}
int vr_55 = 0 ;
for ( final Iterator < vt_1 > vr_33 = vr_29 . iterator () ; vr_33 . hasNext () ; )
{
final vt_1 vr_34 = vr_33 . vr_35 () ;
final StringBuilder vr_52 = new StringBuilder ( vr_50 . get ( vr_55 ++ ) . toString () ) ;
if ( vr_52 . length () < vr_49 )
{
vr_52 . append ( fn_27 ( vr_49 - vr_52 . length () ) ) ;
}
vr_52 . append ( vr_48 ) ;
final int vr_46 = vr_49 + vr_25 ;
if ( vr_34 . getDescription () != null )
{
vr_52 . append ( vr_34 . getDescription () ) ;
}
fn_28 ( vr_44 , vr_1 , vr_46 , vr_52 . toString () ) ;
if ( vr_33 . hasNext () )
{
vr_44 . append ( fn_8 () ) ;
}
}
return vr_44 ;
}
protected tp_2 fn_28 ( final tp_2 vr_44 , final int vr_1 ,
int vr_46 , String vr_45 )
{
int vr_56 = fn_29 ( vr_45 , vr_1 , 0 ) ;
if ( vr_56 == - 1 )
{
vr_44 . append ( fn_30 ( vr_45 ) ) ;
return vr_44 ;
}
vr_44 . append ( fn_30 ( vr_45 . vr_57 ( 0 , vr_56 ) ) ) . append ( fn_8 () ) ;
if ( vr_46 >= vr_1 ) MST[rv.UOI1Mutator]MSP[N]
{
vr_46 = 1 ;
}
final String vr_3 = fn_27 ( vr_46 ) ;
while ( true )
{
vr_45 = vr_3 + vr_45 . vr_57 ( vr_56 ) . trim () ;
vr_56 = fn_29 ( vr_45 , vr_1 , 0 ) ;
if ( vr_56 == - 1 )
{
vr_44 . append ( vr_45 ) ;
return vr_44 ;
}
if ( vr_45 . length () > vr_1 && vr_56 == vr_46 - 1 )
{
vr_56 = vr_1 ;
}
vr_44 . append ( fn_30 ( vr_45 . vr_57 ( 0 , vr_56 ) ) ) . append ( fn_8 () ) ;
}
}
private tp_3 fn_26 ( final tp_2 vr_44 , final int vr_1 , final int vr_46 , final String vr_45 )
{
try
{
final BufferedReader vr_58 = new BufferedReader ( new fn_31 ( vr_45 ) ) ;
String line ;
boolean vr_59 = true ;
while ( ( line = vr_58 . readLine () ) != null )
{
if ( ! vr_59 )
{
vr_44 . append ( fn_8 () ) ;
}
else
{
vr_59 = false ;
}
fn_28 ( vr_44 , vr_1 , vr_46 , line ) ;
}
}
catch ( final IOException vr_60 )
{
}
return vr_44 ;
}
protected int fn_29 ( final String vr_45 , final int vr_1 , final int vr_61 )
{
int vr_56 = vr_45 . indexOf ( '\n' , vr_61 ) ;
if ( vr_56 != - 1 && vr_56 <= vr_1 )
{
return vr_56 + 1 ;
}
vr_56 = vr_45 . indexOf ( '\t' , vr_61 ) ;
if ( vr_56 != - 1 && vr_56 <= vr_1 )
{
return vr_56 + 1 ;
}
if ( vr_61 + vr_1 >= vr_45 . length () )
{
return - 1 ;
}
for ( vr_56 = vr_61 + vr_1 ; vr_56 >= vr_61 ; -- vr_56 )
{
final char vr_62 = vr_45 . charAt ( vr_56 ) ;
if ( vr_62 == ' ' || vr_62 == '\n' || vr_62 == '\r' )
{
break;
}
}
if ( vr_56 > vr_61 )
{
return vr_56 ;
}
vr_56 = vr_61 + vr_1 ;
return vr_56 == vr_45 . length () ? - 1 : vr_56 ;
}
protected String fn_27 ( final int vr_63 )
{
final char [] vr_3 = new char [ vr_63 ] ;
vr_64 . vr_65 ( vr_3 , ' ' ) ;
return new String ( vr_3 ) ;
}
protected String fn_30 ( final String vr_66 )
{
if ( vr_66 == null || vr_66 . length () == 0 )
{
return vr_66 ;
}
int vr_56 = vr_66 . length () ;
while ( vr_56 > 0 && vr_67 . vr_68 ( vr_66 . charAt ( vr_56 - 1 ) ) )
{
-- vr_56 ;
}
return vr_66 . vr_57 ( 0 , vr_56 ) ;
}
public int fn_32 ( final vt_1 vr_69 , final vt_1 vr_70 )
{
return vr_69 . vr_71 () . compareToIgnoreCase ( vr_70 . vr_71 () ) ;
}
