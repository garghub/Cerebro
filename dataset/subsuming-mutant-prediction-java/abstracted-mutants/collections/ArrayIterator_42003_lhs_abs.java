protected void fn_1 ( final int vr_1 , final int vr_2 , final String type ) {
if ( vr_1 > vr_2 ) {
throw new fn_2 (
lr_1 + type +
lr_2
) ;
}
if ( vr_1 < 0 ) {
throw new fn_2 (
lr_1 + type +
lr_3
) ;
}
}
@Override
public boolean hasNext () {
return vl_1 < vl_2 ;
}
@Override
@SuppressWarnings ( lr_4 )
public tp_1 fn_3 () {
if ( hasNext () == false ) { MST[rv.ROR4Mutator]MSP[]
throw new fn_4 () ;
}
return ( tp_1 ) Array . get ( array , vl_1 ++ ) ;
}
@Override
public void remove () {
throw new fn_5 ( lr_5 ) ;
}
public Object fn_6 () {
return array ;
}
public int fn_7 () {
return this . vr_3 ;
}
public int fn_8 () {
return this . vl_2 ;
}
@Override
public void fn_9 () {
this . vl_1 = this . vr_3 ;
}
