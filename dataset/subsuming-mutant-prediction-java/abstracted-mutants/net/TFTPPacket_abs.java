public static final tp_1 fn_1 ( final tp_2 vr_1 )
throws vl_1
{
byte [] vr_2 ;
tp_1 vr_3 = null ;
if ( vr_1 . vr_4 () < vl_2 ) {
throw new vl_1 (
lr_1 ) ;
}
vr_2 = vr_1 . vr_5 () ;
switch ( vr_2 [ 1 ] )
{
case vl_3 :
vr_3 = new fn_2 ( vr_1 ) ;
break;
case vl_4 :
vr_3 = new fn_3 ( vr_1 ) ;
break;
case vl_5 :
vr_3 = new fn_4 ( vr_1 ) ;
break;
case vl_6 :
vr_3 = new fn_5 ( vr_1 ) ;
break;
case ERROR :
vr_3 = new fn_6 ( vr_1 ) ;
break;
default:
throw new vl_1 (
lr_2 ) ;
}
return vr_3 ;
}
public final int getType ()
{
return type ;
}
public final tp_3 fn_7 ()
{
return vl_7 ;
}
public final int fn_8 ()
{
return vl_8 ;
}
public final void fn_9 ( final int vl_8 )
{
this . vl_8 = vl_8 ;
}
public final void fn_10 ( final tp_3 vl_7 )
{
this . vl_7 = vl_7 ;
}
@Override
public String toString () {
return vl_7 + lr_3 + vl_8 + lr_3 + type ;
}
