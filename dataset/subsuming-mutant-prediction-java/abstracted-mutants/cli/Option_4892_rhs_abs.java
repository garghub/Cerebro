public int fn_1 ()
{
return fn_2 () . charAt ( 0 ) ;
}
String fn_2 ()
{
return ( vl_1 == null ) ? vl_2 : vl_1 ;
}
public String fn_3 ()
{
return vl_1 ;
}
public Object getType ()
{
return type ;
}
@Deprecated
public void fn_4 ( final Object type )
{
fn_4 ( ( Class < ? > ) type ) ;
}
public void fn_4 ( final Class < ? > type )
{
this . type = type ;
}
public String fn_5 ()
{
return vl_2 ;
}
public void fn_6 ( final String vl_2 )
{
this . vl_2 = vl_2 ;
}
public void fn_7 ( final boolean vr_1 )
{
this . vr_1 = vr_1 ;
}
public boolean fn_8 ()
{
return vr_1 ;
}
public boolean fn_9 ()
{
return vl_2 != null ;
}
public boolean fn_10 ()
{
return vl_3 > 0 || vl_3 == vl_4 ;
}
public String getDescription ()
{
return vl_5 ;
}
public void fn_11 ( final String vl_5 )
{
this . vl_5 = vl_5 ;
}
public boolean fn_12 ()
{
return vl_6 ;
}
public void fn_13 ( final boolean vl_6 )
{
this . vl_6 = vl_6 ;
}
public void fn_14 ( final String vr_2 )
{
this . vr_2 = vr_2 ;
}
public String fn_15 ()
{
return vr_2 ;
}
public boolean fn_16 ()
{
return vr_2 != null && vr_2 . length () > 0 ;
}
public boolean fn_17 ()
{
return vl_3 > 1 || vl_3 == vl_4 ;
}
public void fn_18 ( final int vr_3 )
{
this . vl_3 = vr_3 ;
}
public void fn_19 ( final char vr_4 )
{
this . vr_5 = vr_4 ;
}
public char fn_20 ()
{
return vr_5 ;
}
public boolean fn_21 ()
{
return vr_5 > 0 ;
}
public int getArgs ()
{
return vl_3 ;
}
void fn_22 ( final String vr_6 )
{
if ( vl_3 == vl_7 ) MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
{
throw new fn_23 ( lr_1 ) ;
}
fn_24 ( vr_6 ) ;
}
private void fn_24 ( String vr_6 )
{
if ( fn_21 () )
{
final char vr_4 = fn_20 () ;
int vr_7 = vr_6 . indexOf ( vr_4 ) ;
while ( vr_7 != - 1 )
{
if ( vr_8 . size () == vl_3 - 1 )
{
break;
}
add ( vr_6 . vr_9 ( 0 , vr_7 ) ) ;
vr_6 = vr_6 . vr_9 ( vr_7 + 1 ) ;
vr_7 = vr_6 . indexOf ( vr_4 ) ;
}
}
add ( vr_6 ) ;
}
private void add ( final String vr_6 )
{
if ( ! fn_25 () )
{
throw new fn_23 ( lr_2 ) ;
}
vr_8 . add ( vr_6 ) ;
}
public String fn_26 ()
{
return fn_27 () ? null : vr_8 . get ( 0 ) ;
}
public String fn_26 ( final int vr_7 ) throws vl_8
{
return fn_27 () ? null : vr_8 . get ( vr_7 ) ;
}
public String fn_26 ( final String vr_10 )
{
final String vr_6 = fn_26 () ;
return ( vr_6 != null ) ? vr_6 : vr_10 ;
}
public String [] getValues ()
{
return fn_27 () ? null : vr_8 . toArray ( new String [ vr_8 . size () ] ) ;
}
public List < String > fn_28 ()
{
return vr_8 ;
}
@Override
public String toString ()
{
final StringBuilder vr_11 = new StringBuilder () . append ( lr_3 ) ;
vr_11 . append ( vl_1 ) ;
if ( vl_2 != null )
{
vr_11 . append ( lr_4 ) . append ( vl_2 ) ;
}
vr_11 . append ( lr_4 ) ;
if ( fn_17 () )
{
vr_11 . append ( lr_5 ) ;
}
else if ( fn_10 () )
{
vr_11 . append ( lr_6 ) ;
}
vr_11 . append ( lr_7 ) . append ( vl_5 ) ;
if ( type != null )
{
vr_11 . append ( lr_7 ) . append ( type ) ;
}
vr_11 . append ( lr_8 ) ;
return vr_11 . toString () ;
}
private boolean fn_27 ()
{
return vr_8 . isEmpty () ;
}
@Override
public boolean equals ( final Object vr_12 )
{
if ( this == vr_12 )
{
return true ;
}
if ( vr_12 == null || getClass () != vr_12 . getClass () )
{
return false ;
}
final tp_1 vr_13 = ( tp_1 ) vr_12 ;
if ( vl_1 != null ? ! vl_1 . equals ( vr_13 . vl_1 ) : vr_13 . vl_1 != null )
{
return false ;
}
if ( vl_2 != null ? ! vl_2 . equals ( vr_13 . vl_2 ) : vr_13 . vl_2 != null )
{
return false ;
}
return true ;
}
@Override
public int fn_29 ()
{
int vr_14 ;
vr_14 = vl_1 != null ? vl_1 . fn_29 () : 0 ;
vr_14 = 31 * vr_14 + ( vl_2 != null ? vl_2 . fn_29 () : 0 ) ;
return vr_14 ;
}
@Override
public Object fn_30 ()
{
try
{
final tp_1 vr_13 = ( tp_1 ) super . fn_30 () ;
vr_13 . vr_8 = new ArrayList < String > ( vr_8 ) ;
return vr_13 ;
}
catch ( final tp_2 vr_15 )
{
throw new fn_23 ( lr_9 + vr_15 . vr_16 () ) ;
}
}
void fn_31 ()
{
vr_8 . clear () ;
}
@Deprecated
public boolean fn_32 ( final String vr_6 )
{
throw new fn_33 ( lr_10
+ lr_11 ) ;
}
boolean fn_25 ()
{
return ( fn_10 () || fn_17 () || fn_8 () ) && ( vl_3 <= 0 || vr_8 . size () < vl_3 ) ;
}
boolean fn_34 ()
{
if ( vr_1 )
{
return false ;
}
if ( vl_3 == vl_4 )
{
return vr_8 . isEmpty () ;
}
return fn_25 () ;
}
public static Builder builder ()
{
return builder ( null ) ;
}
public static Builder builder ( final String vl_1 )
{
return new Builder ( vl_1 ) ;
}
public Builder vr_2 ( final String vr_2 )
{
this . vr_2 = vr_2 ;
return this ;
}
public Builder fn_35 ( final String vl_5 )
{
this . vl_5 = vl_5 ;
return this ;
}
public Builder vl_2 ( final String vl_2 )
{
this . vl_2 = vl_2 ;
return this ;
}
public Builder vl_3 ( final int vl_3 )
{
this . vl_3 = vl_3 ;
return this ;
}
public Builder vr_1 ( final boolean vr_17 )
{
this . vr_1 = vr_17 ;
return this ;
}
public Builder vl_6 ()
{
return vl_6 ( true ) ;
}
public Builder vl_6 ( final boolean vl_6 )
{
this . vl_6 = vl_6 ;
return this ;
}
public Builder type ( final Class < ? > type )
{
this . type = type ;
return this ;
}
public Builder fn_36 ()
{
return fn_36 ( '=' ) ;
}
public Builder fn_36 ( final char vr_4 )
{
vr_5 = vr_4 ;
return this ;
}
public Builder fn_10 ()
{
return fn_10 ( true ) ;
}
public Builder fn_10 ( final boolean fn_10 )
{
vl_3 = fn_10 ? 1 : tp_1 . vl_7 ;
return this ;
}
public Builder fn_17 ()
{
vl_3 = tp_1 . vl_4 ;
return this ;
}
public tp_1 fn_37 ()
{
if ( vl_1 == null && vl_2 == null )
{
throw new IllegalArgumentException ( lr_12 ) ;
}
return new tp_1 ( this ) ;
}
