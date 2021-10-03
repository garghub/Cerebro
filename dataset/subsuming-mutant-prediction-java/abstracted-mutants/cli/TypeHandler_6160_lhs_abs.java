public static Object fn_1 ( final String vr_1 , final Object vr_2 ) throws ParseException
{
return fn_1 ( vr_1 , ( Class < ? > ) vr_2 ) ;
}
@SuppressWarnings ( lr_1 )
public static < vt_1 > vt_1 fn_1 ( final String vr_1 , final Class < vt_1 > vr_3 ) throws ParseException
{
if ( vr_4 . vr_5 == vr_3 )
{
return ( vt_1 ) vr_1 ;
}
else if ( vr_4 . vr_6 == vr_3 )
{
return ( vt_1 ) fn_2 ( vr_1 ) ;
}
else if ( vr_4 . vr_7 == vr_3 )
{
return ( vt_1 ) fn_3 ( vr_1 ) ; MST[NullReturnValsMutator]MSP[]
}
else if ( vr_4 . vr_8 == vr_3 )
{
return ( vt_1 ) fn_4 ( vr_1 ) ;
}
else if ( vr_4 . vr_9 == vr_3 )
{
return ( vt_1 ) fn_5 ( vr_1 ) ;
}
else if ( vr_4 . vr_10 == vr_3 )
{
return ( vt_1 ) fn_6 ( vr_1 ) ;
}
else if ( vr_4 . vr_11 == vr_3 )
{
return ( vt_1 ) fn_7 ( vr_1 ) ;
}
else if ( vr_4 . vr_12 == vr_3 )
{
return ( vt_1 ) fn_8 ( vr_1 ) ;
}
else if ( vr_4 . vr_13 == vr_3 )
{
return ( vt_1 ) fn_9 ( vr_1 ) ;
}
else
{
throw new ParseException ( lr_2 + vr_3 ) ;
}
}
public static Object fn_2 ( final String vr_14 ) throws ParseException
{
Class < ? > vr_15 ;
try
{
vr_15 = Class . vr_16 ( vr_14 ) ;
}
catch ( final tp_1 vr_17 )
{
throw new ParseException ( lr_3 + vr_14 ) ;
}
try
{
return vr_15 . vr_18 () ;
}
catch ( final Exception vr_19 )
{
throw new ParseException ( vr_19 . getClass () . fn_10 () + lr_4 + vr_14 ) ;
}
}
public static tp_2 fn_3 ( final String vr_1 ) throws ParseException
{
try
{
if ( vr_1 . indexOf ( '.' ) != - 1 )
{
return Double . valueOf ( vr_1 ) ;
}
return Long . valueOf ( vr_1 ) ;
}
catch ( final tp_3 vr_19 )
{
throw new ParseException ( vr_19 . vr_20 () ) ;
}
}
public static Class < ? > fn_5 ( final String vr_14 ) throws ParseException
{
try
{
return Class . vr_16 ( vr_14 ) ;
}
catch ( final tp_1 vr_19 )
{
throw new ParseException ( lr_3 + vr_14 ) ;
}
}
public static tp_4 fn_4 ( final String vr_1 )
{
throw new fn_11 ( lr_5 ) ;
}
public static tp_5 fn_9 ( final String vr_1 ) throws ParseException
{
try
{
return new tp_5 ( vr_1 ) ;
}
catch ( final tp_6 vr_19 )
{
throw new ParseException ( lr_6 + vr_1 ) ;
}
}
public static tp_7 fn_6 ( final String vr_1 )
{
return new tp_7 ( vr_1 ) ;
}
public static tp_8 fn_7 ( String vr_1 ) throws ParseException
{
try
{
return new tp_8 ( vr_1 ) ;
}
catch ( tp_9 vr_19 )
{
throw new ParseException ( lr_7 + vr_1 ) ;
}
}
public static tp_7 [] fn_8 ( final String vr_1 )
{
throw new fn_11 ( lr_5 ) ;
}
