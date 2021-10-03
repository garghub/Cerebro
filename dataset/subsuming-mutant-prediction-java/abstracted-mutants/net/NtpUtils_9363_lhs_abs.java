public static String fn_1 ( final int vr_1 )
{
return ( ( vr_1 >>> 24 ) & 0xFF ) + lr_1 +
( ( vr_1 >>> 16 ) & 0xFF ) + lr_1 +
( ( vr_1 >>> 8 ) & 0xFF ) + lr_1 +
( ( vr_1 >>> 0 ) & 0xFF ) ;
}
public static String fn_2 ( final tp_1 vr_2 )
{
final int vr_1 = ( vr_2 == null ) ? 0 : vr_2 . vr_3 () ;
return fn_1 ( vr_1 ) ;
}
public static String fn_3 ( final tp_1 vr_4 ) {
if ( vr_4 == null ) {
return lr_2 ;
}
final int vr_5 = vr_4 . vr_3 () ;
if ( vr_5 == 0 ) {
return lr_2 ;
}
final StringBuilder vr_6 = new StringBuilder ( 4 ) ;
for ( int vr_7 = 24 ; vr_7 >= 0 ; vr_7 -= 8 )
{
final char vr_8 = (char) ( ( vr_5 >>> vr_7 ) & 0xff ) ;
if ( vr_8 == 0 ) {
break; MST[NegateConditionalsMutator]MSP[]
}
if ( ! vr_9 . vr_10 ( vr_8 ) ) {
return lr_2 ;
}
vr_6 . append ( vr_8 ) ;
}
return vr_6 . toString () ;
}
public static String fn_4 ( final int vr_11 )
{
switch ( vr_11 ) {
case tp_1 . vr_12 :
return lr_3 ;
case tp_1 . vr_13 :
return lr_4 ;
case tp_1 . vr_14 :
return lr_5 ;
case tp_1 . vr_15 :
return lr_6 ;
case tp_1 . vr_16 :
return lr_7 ;
case tp_1 . vr_17 :
return lr_8 ;
case tp_1 . vr_18 :
return lr_9 ;
case tp_1 . vr_19 :
return lr_10 ;
default:
return lr_11 ;
}
}
