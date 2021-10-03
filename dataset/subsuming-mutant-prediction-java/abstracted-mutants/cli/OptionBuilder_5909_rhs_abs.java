private static void fn_1 ()
{
vl_1 = null ;
vl_2 = null ;
vl_3 = null ;
type = String . class ;
vl_4 = false ;
vl_5 = vr_1 . vr_2 ;
vl_6 = false ;
vl_7 = ( char ) 0 ;
}
public static tp_1 fn_2 ( final String vr_3 )
{
tp_1 . vl_3 = vr_3 ;
return vl_8 ;
}
public static tp_1 fn_3 ()
{
tp_1 . vl_5 = 1 ;
return vl_8 ;
}
public static tp_1 fn_3 ( final boolean fn_3 )
{
tp_1 . vl_5 = fn_3 ? 1 : vr_1 . vr_2 ;
return vl_8 ;
}
public static tp_1 fn_4 ( final String vr_4 )
{
tp_1 . vl_2 = vr_4 ;
return vl_8 ;
}
public static tp_1 fn_5 ()
{
tp_1 . vl_4 = true ;
return vl_8 ;
}
public static tp_1 fn_6 ( final char vr_5 )
{
tp_1 . vl_7 = vr_5 ;
return vl_8 ;
}
public static tp_1 fn_6 ()
{
tp_1 . vl_7 = '=' ;
return vl_8 ;
}
public static tp_1 fn_5 ( final boolean vr_6 )
{
tp_1 . vl_4 = vr_6 ;
return vl_8 ;
}
public static tp_1 fn_7 ()
{
tp_1 . vl_5 = vr_1 . vr_7 ;
return vl_8 ; MST[ReturnValsMutator]MSP[N]
}
public static tp_1 fn_7 ( final int vr_8 )
{
tp_1 . vl_5 = vr_8 ;
return vl_8 ;
}
public static tp_1 fn_8 ()
{
tp_1 . vl_5 = 1 ;
tp_1 . vl_6 = true ;
return vl_8 ;
}
public static tp_1 fn_9 ()
{
tp_1 . vl_5 = vr_1 . vr_7 ;
tp_1 . vl_6 = true ;
return vl_8 ;
}
public static tp_1 fn_9 ( final int vr_9 )
{
tp_1 . vl_5 = vr_9 ;
tp_1 . vl_6 = true ;
return vl_8 ;
}
@Deprecated
public static tp_1 fn_10 ( final Object vr_10 )
{
return fn_10 ( ( Class < ? > ) vr_10 ) ;
}
public static tp_1 fn_10 ( final Class < ? > vr_10 )
{
tp_1 . type = vr_10 ;
return vl_8 ;
}
public static tp_1 fn_11 ( final String vr_11 )
{
tp_1 . vl_1 = vr_11 ;
return vl_8 ;
}
public static vr_1 fn_12 ( final char vr_12 ) throws IllegalArgumentException
{
return fn_12 ( String . valueOf ( vr_12 ) ) ;
}
public static vr_1 fn_12 () throws IllegalArgumentException
{
if ( vl_3 == null )
{
tp_1 . fn_1 () ;
throw new IllegalArgumentException ( lr_1 ) ;
}
return fn_12 ( null ) ;
}
public static vr_1 fn_12 ( final String vr_12 ) throws IllegalArgumentException
{
vr_1 vr_13 = null ;
try
{
vr_13 = new vr_1 ( vr_12 , vl_1 ) ;
vr_13 . vr_14 ( vl_3 ) ;
vr_13 . vr_15 ( vl_4 ) ;
vr_13 . vr_16 ( vl_6 ) ;
vr_13 . vr_17 ( vl_5 ) ;
vr_13 . vr_18 ( type ) ;
vr_13 . vr_19 ( vl_7 ) ;
vr_13 . vr_20 ( vl_2 ) ;
}
finally
{
tp_1 . fn_1 () ;
}
return vr_13 ;
}
