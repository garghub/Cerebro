@Override
final tp_1 fn_1 ( final tp_1 vr_1 , final byte [] vr_2 )
{
int vr_3 , vr_4 ;
vr_3 = vr_5 . length () ;
vr_4 = vr_6 [ vl_1 ] . length ;
vr_2 [ 0 ] = 0 ;
vr_2 [ 1 ] = ( byte ) type ;
System . vr_7 ( vr_5 . vr_8 () , 0 , vr_2 , 2 , vr_3 ) ;
vr_2 [ vr_3 + 2 ] = 0 ;
System . vr_7 ( vr_6 [ vl_1 ] , 0 , vr_2 , vr_3 + 3 ,
vr_4 ) ;
vr_1 . vr_9 ( vl_2 ) ;
vr_1 . vr_10 ( vl_3 ) ;
vr_1 . vr_11 ( vr_2 ) ;
vr_1 . vr_12 ( vr_3 + vr_4 + 3 ) ;
return vr_1 ;
}
@Override
public final tp_1 fn_2 ()
{
int vr_3 , vr_4 ;
byte [] vr_2 ;
vr_3 = vr_5 . length () ;
vr_4 = vr_6 [ vl_1 ] . length ; MST[rv.ABSMutator]MSP[]
vr_2 = new byte [ vr_3 + vr_4 + 4 ] ;
vr_2 [ 0 ] = 0 ;
vr_2 [ 1 ] = ( byte ) type ;
System . vr_7 ( vr_5 . vr_8 () , 0 , vr_2 , 2 , vr_3 ) ;
vr_2 [ vr_3 + 2 ] = 0 ;
System . vr_7 ( vr_6 [ vl_1 ] , 0 , vr_2 , vr_3 + 3 ,
vr_4 ) ;
return new tp_1 ( vr_2 , vr_2 . length , vl_2 , vl_3 ) ;
}
public final int fn_3 ()
{
return vl_1 ;
}
public final String fn_4 ()
{
return vr_5 ;
}
