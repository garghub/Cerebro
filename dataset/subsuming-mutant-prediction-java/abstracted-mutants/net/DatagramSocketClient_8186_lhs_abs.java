public void fn_1 () throws vl_1
{
vl_2 = vr_1 . vr_2 () ;
vl_2 . vr_3 ( vl_3 ) ;
vl_4 = true ;
}
public void fn_1 ( final int vr_4 ) throws vl_1
{
vl_2 = vr_1 . vr_2 ( vr_4 ) ;
vl_2 . vr_3 ( vl_3 ) ;
vl_4 = true ;
}
public void fn_1 ( final int vr_4 , final tp_1 vr_5 ) throws vl_1
{
vl_2 = vr_1 . vr_2 ( vr_4 , vr_5 ) ;
vl_2 . vr_3 ( vl_3 ) ;
vl_4 = true ;
}
public void fn_2 ()
{
if ( vl_2 != null ) {
vl_2 . fn_2 () ;
}
vl_2 = null ;
vl_4 = false ;
}
public boolean fn_3 ()
{
return vl_4 ;
}
public void fn_4 ( final int vr_6 )
{
vl_3 = vr_6 ;
}
public int fn_5 ()
{
return vl_3 ;
}
public void vr_3 ( final int vr_6 ) throws vl_1
{
vl_2 . vr_3 ( vr_6 ) ;
}
public int fn_6 () throws vl_1
{
return vl_2 . fn_6 () ;
}
public int fn_7 ()
{
return vl_2 . fn_7 () ;
}
public tp_1 fn_8 ()
{
return vl_2 . fn_8 () ;
}
public void fn_9 ( final tp_2 vr_7 )
{
if ( vr_7 == null ) {
vr_1 = vl_5 ;
} else {
vr_1 = vr_7 ; MST[experimental.MemberVariableMutator]MSP[]
}
}
@Deprecated
public String fn_10 () {
return vr_8 . vr_9 () ;
}
public tp_3 fn_11 () {
return vr_8 ;
}
public void fn_12 ( final tp_3 vr_8 ) {
this . vr_8 = vr_8 ;
}
