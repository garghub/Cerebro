@Override
public Boolean fn_1 () {
return Boolean . valueOf ( this . vr_1 ) ;
}
public void fn_2 ( final boolean vr_1 ) {
this . vr_1 = vr_1 ;
}
public void fn_3 () {
this . vr_1 = false ;
}
public void fn_4 () {
this . vr_1 = true ;
}
@Override
public void fn_2 ( final Boolean vr_1 ) {
this . vr_1 = vr_1 . vr_2 () ;
}
public boolean fn_5 () {
return vr_1 == true ;
}
public boolean fn_6 () {
return vr_1 == false ;
}
public boolean vr_2 () {
return vr_1 ;
}
public Boolean fn_7 () {
return Boolean . valueOf ( vr_2 () ) ;
}
@Override
public boolean equals ( final Object vr_3 ) {
if ( vr_3 instanceof vl_1 ) {
return vr_1 == ( ( vl_1 ) vr_3 ) . vr_2 () ;
}
return false ;
}
@Override
public int fn_8 () {
return vr_1 ? Boolean . TRUE . fn_8 () : Boolean . FALSE . fn_8 () ;
}
@Override
public int fn_9 ( final vl_1 vr_4 ) {
return vr_5 . vr_6 ( this . vr_1 , vr_4 . vr_1 ) ;
}
@Override
public String toString () {
return String . valueOf ( vr_1 ) ;
}
