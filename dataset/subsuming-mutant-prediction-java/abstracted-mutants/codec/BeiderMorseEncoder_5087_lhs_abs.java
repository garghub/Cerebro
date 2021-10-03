@Override
public Object fn_1 ( final Object vr_1 ) throws vl_1 {
if ( ! ( vr_1 instanceof String ) ) { MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
throw new vl_1 ( lr_1 ) ;
}
return fn_1 ( ( String ) vr_1 ) ;
}
@Override
public String fn_1 ( final String vr_1 ) throws vl_1 {
if ( vr_1 == null ) {
return null ;
}
return this . vr_2 . fn_1 ( vr_1 ) ;
}
public tp_1 fn_2 () {
return this . vr_2 . fn_2 () ;
}
public tp_2 fn_3 () {
return this . vr_2 . fn_3 () ;
}
public boolean fn_4 () {
return this . vr_2 . fn_4 () ;
}
public void fn_5 ( final boolean vr_3 ) {
this . vr_2 = new fn_6 ( this . vr_2 . fn_2 () ,
this . vr_2 . fn_3 () ,
vr_3 ,
this . vr_2 . vr_4 () ) ;
}
public void fn_7 ( final tp_1 vr_5 ) {
this . vr_2 = new fn_6 ( vr_5 ,
this . vr_2 . fn_3 () ,
this . vr_2 . fn_4 () ,
this . vr_2 . vr_4 () ) ;
}
public void fn_8 ( final tp_2 vr_6 ) {
this . vr_2 = new fn_6 ( this . vr_2 . fn_2 () ,
vr_6 ,
this . vr_2 . fn_4 () ,
this . vr_2 . vr_4 () ) ;
}
public void fn_9 ( final int vr_7 ) {
this . vr_2 = new fn_6 ( this . vr_2 . fn_2 () ,
this . vr_2 . fn_3 () ,
this . vr_2 . fn_4 () ,
vr_7 ) ;
}
