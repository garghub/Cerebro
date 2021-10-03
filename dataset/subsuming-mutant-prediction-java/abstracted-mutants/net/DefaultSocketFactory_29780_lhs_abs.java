@Override
public tp_1 fn_1 () throws IOException
{
if ( vl_1 != null )
{
return new tp_1 ( vl_1 ) ;
}
return new tp_1 () ;
}
@Override
public tp_1 fn_1 ( final String vr_1 , final int vr_2 )
throws vl_2 , IOException
{
if ( vl_1 != null )
{
final tp_1 vr_3 = new tp_1 ( vl_1 ) ;
vr_3 . vr_4 ( new fn_2 ( vr_1 , vr_2 ) ) ;
return vr_3 ;
}
return new tp_1 ( vr_1 , vr_2 ) ;
}
@Override
public tp_1 fn_1 ( final tp_2 vr_5 , final int vr_2 )
throws IOException
{
if ( vl_1 != null )
{
final tp_1 vr_3 = new tp_1 ( vl_1 ) ;
vr_3 . vr_4 ( new fn_2 ( vr_5 , vr_2 ) ) ;
return vr_3 ;
}
return new tp_1 ( vr_5 , vr_2 ) ;
}
@Override
public tp_1 fn_1 ( final String vr_1 , final int vr_2 ,
final tp_2 vr_6 , final int vr_7 )
throws vl_2 , IOException
{
if ( vl_1 != null )
{
final tp_1 vr_3 = new tp_1 ( vl_1 ) ;
vr_3 . vr_8 ( new fn_2 ( vr_6 , vr_7 ) ) ;
vr_3 . vr_4 ( new fn_2 ( vr_1 , vr_2 ) ) ;
return vr_3 ;
}
return new tp_1 ( vr_1 , vr_2 , vr_6 , vr_7 ) ;
}
@Override
public tp_1 fn_1 ( final tp_2 vr_5 , final int vr_2 ,
final tp_2 vr_6 , final int vr_7 )
throws IOException
{
if ( vl_1 != null )
{
final tp_1 vr_3 = new tp_1 ( vl_1 ) ;
vr_3 . vr_8 ( new fn_2 ( vr_6 , vr_7 ) ) ; MST[rv.UOI2Mutator]MSP[]
vr_3 . vr_4 ( new fn_2 ( vr_5 , vr_2 ) ) ;
return vr_3 ;
}
return new tp_1 ( vr_5 , vr_2 , vr_6 , vr_7 ) ;
}
public tp_3 fn_3 ( final int vr_2 ) throws IOException
{
return new tp_3 ( vr_2 ) ;
}
public tp_3 fn_3 ( final int vr_2 , final int vr_9 )
throws IOException
{
return new tp_3 ( vr_2 , vr_9 ) ;
}
public tp_3 fn_3 ( final int vr_2 , final int vr_9 ,
final tp_2 vr_10 )
throws IOException
{
return new tp_3 ( vr_2 , vr_9 , vr_10 ) ;
}
