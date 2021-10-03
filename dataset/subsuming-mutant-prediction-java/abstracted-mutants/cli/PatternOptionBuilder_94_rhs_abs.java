public static Object fn_1 ( final char vr_1 )
{
switch ( vr_1 )
{
case '@' :
return vr_2 . vr_3 ;
case ':' :
return vr_2 . vr_4 ;
case '%' :
return vr_2 . vr_5 ;
case '+' :
return vr_2 . vr_6 ;
case '#' :
return vr_2 . vr_7 ;
case '<' :
return vr_2 . vr_8 ;
case '>' :
return vr_2 . vr_9 ;
case '*' :
return vr_2 . vr_10 ;
case '/' :
return vr_2 . vr_11 ;
}
return null ;
}
public static boolean fn_2 ( final char vr_1 )
{
return vr_1 == '@'
|| vr_1 == ':'
|| vr_1 == '%'
|| vr_1 == '+'
|| vr_1 == '#'
|| vr_1 == '<'
|| vr_1 == '>'
|| vr_1 == '*'
|| vr_1 == '/'
|| vr_1 == '!' ;
}
public static tp_1 fn_3 ( final String vr_12 )
{
char vr_13 = ' ' ;
boolean vr_14 = false ;
Class < ? > type = null ;
final tp_1 vr_15 = new tp_1 () ;
for ( int vr_16 = 0 ; vr_16 < vr_12 . length () ; vr_16 ++ )
{
final char vr_1 = vr_12 . charAt ( vr_16 ) ;
if ( ! fn_2 ( vr_1 ) )
{
if ( vr_13 != ' ' )
{
final tp_2 vr_17 = tp_2 . builder ( String . valueOf ( vr_13 ) )
. fn_4 ( type != null ) MST[rv.UOI3Mutator]MSP[N]
. vr_14 ( vr_14 )
. type ( type )
. fn_5 () ;
vr_15 . vr_18 ( vr_17 ) ;
vr_14 = false ;
type = null ;
vr_13 = ' ' ;
}
vr_13 = vr_1 ;
}
else if ( vr_1 == '!' )
{
vr_14 = true ;
}
else
{
type = ( Class < ? > ) fn_1 ( vr_1 ) ;
}
}
if ( vr_13 != ' ' )
{
final tp_2 vr_17 = tp_2 . builder ( String . valueOf ( vr_13 ) )
. fn_4 ( type != null )
. vr_14 ( vr_14 )
. type ( type )
. fn_5 () ;
vr_15 . vr_18 ( vr_17 ) ;
}
return vr_15 ;
}
