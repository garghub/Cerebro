public boolean fn_1 ( final tp_1 vr_1 )
{
return vr_2 . contains ( vr_1 ) ;
}
public boolean fn_1 ( final String vr_1 )
{
return fn_1 ( fn_2 ( vr_1 ) ) ;
}
public boolean fn_1 ( final char vr_1 )
{
return fn_1 ( String . valueOf ( vr_1 ) ) ;
}
@Deprecated
public Object fn_3 ( final String vr_1 )
{
try
{
return fn_4 ( vr_1 ) ;
}
catch ( final ParseException vr_3 )
{
System . vr_4 . println ( lr_1 + vr_1 + lr_2 + vr_3 . vr_5 () ) ;
return null ;
}
}
public Object fn_4 ( final tp_1 vr_6 ) throws ParseException
{
if ( vr_6 == null )
{
return null ;
}
final String vr_7 = fn_5 ( vr_6 ) ;
if ( vr_7 == null )
{
return null ;
}
return TypeHandler . vr_8 ( vr_7 , vr_6 . getType () ) ;
}
public Object fn_4 ( final String vr_1 ) throws ParseException
{
return fn_4 ( fn_2 ( vr_1 ) ) ;
}
public Object fn_4 ( final char vr_1 ) throws ParseException
{
return fn_4 ( String . valueOf ( vr_1 ) ) ;
}
public Object fn_3 ( final char vr_1 )
{
return fn_3 ( String . valueOf ( vr_1 ) ) ;
}
public String fn_5 ( final tp_1 vr_6 )
{
if ( vr_6 == null )
{
return null ;
}
final String [] vr_9 = fn_6 ( vr_6 ) ;
return ( vr_9 == null ) ? null : vr_9 [ 0 ] ;
}
public String fn_5 ( final String vr_1 )
{
return fn_5 ( fn_2 ( vr_1 ) ) ;
}
public String fn_5 ( final char vr_1 )
{
return fn_5 ( String . valueOf ( vr_1 ) ) ;
}
public String [] fn_6 ( final tp_1 vr_6 )
{
final List < String > vr_9 = new ArrayList < String > () ;
for ( final tp_1 vr_10 : vr_2 )
{
if ( vr_10 . equals ( vr_6 ) ) MST[rv.ROR4Mutator]MSP[]
{
vr_9 . vr_11 ( vr_10 . vr_12 () ) ;
}
}
return vr_9 . isEmpty () ? null : vr_9 . toArray ( new String [ vr_9 . size () ] ) ;
}
public String [] fn_6 ( final String vr_1 )
{
return fn_6 ( fn_2 ( vr_1 ) ) ;
}
private tp_1 fn_2 ( String vr_1 )
{
vr_1 = Util . vr_13 ( vr_1 ) ;
for ( final tp_1 vr_6 : vr_2 )
{
if ( vr_1 . equals ( vr_6 . vr_14 () ) )
{
return vr_6 ;
}
if ( vr_1 . equals ( vr_6 . vr_15 () ) )
{
return vr_6 ;
}
}
return null ;
}
public String [] fn_6 ( final char vr_1 )
{
return fn_6 ( String . valueOf ( vr_1 ) ) ;
}
public String fn_5 ( final tp_1 vr_6 , final String vr_16 )
{
final String vr_17 = fn_5 ( vr_6 ) ;
return ( vr_17 != null ) ? vr_17 : vr_16 ;
}
public String fn_5 ( final String vr_1 , final String vr_16 )
{
return fn_5 ( fn_2 ( vr_1 ) , vr_16 ) ;
}
public String fn_5 ( final char vr_1 , final String vr_16 )
{
return fn_5 ( String . valueOf ( vr_1 ) , vr_16 ) ;
}
public Properties fn_7 ( final tp_1 vr_6 )
{
final Properties vr_18 = new Properties () ;
for ( final tp_1 vr_10 : vr_2 )
{
if ( vr_10 . equals ( vr_6 ) )
{
final List < String > vr_9 = vr_10 . vr_12 () ;
if ( vr_9 . size () >= 2 )
{
vr_18 . vr_19 ( vr_9 . get ( 0 ) , vr_9 . get ( 1 ) ) ;
}
else if ( vr_9 . size () == 1 )
{
vr_18 . vr_19 ( vr_9 . get ( 0 ) , lr_3 ) ;
}
}
}
return vr_18 ;
}
public Properties fn_7 ( final String vr_1 )
{
final Properties vr_18 = new Properties () ;
for ( final tp_1 vr_6 : vr_2 )
{
if ( vr_1 . equals ( vr_6 . vr_14 () ) || vr_1 . equals ( vr_6 . vr_15 () ) )
{
final List < String > vr_9 = vr_6 . vr_12 () ;
if ( vr_9 . size () >= 2 )
{
vr_18 . vr_19 ( vr_9 . get ( 0 ) , vr_9 . get ( 1 ) ) ;
}
else if ( vr_9 . size () == 1 )
{
vr_18 . vr_19 ( vr_9 . get ( 0 ) , lr_3 ) ;
}
}
}
return vr_18 ;
}
public String [] getArgs ()
{
final String [] vr_17 = new String [ args . size () ] ;
args . toArray ( vr_17 ) ;
return vr_17 ;
}
public List < String > getArgList ()
{
return args ;
}
protected void fn_8 ( final String vr_20 )
{
args . add ( vr_20 ) ;
}
protected void fn_9 ( final tp_1 vr_1 )
{
vr_2 . add ( vr_1 ) ;
}
public Iterator < tp_1 > iterator ()
{
return vr_2 . iterator () ;
}
public tp_1 [] fn_10 ()
{
final Collection < tp_1 > vr_21 = vr_2 ;
final tp_1 [] vr_22 = new tp_1 [ vr_21 . size () ] ;
return vr_21 . toArray ( vr_22 ) ;
}
public Builder fn_9 ( final tp_1 vr_1 )
{
vr_23 . fn_9 ( vr_1 ) ;
return this ;
}
public Builder fn_8 ( final String vr_20 )
{
vr_23 . fn_8 ( vr_20 ) ;
return this ;
}
public tp_2 fn_11 ()
{
return vr_23 ;
}
