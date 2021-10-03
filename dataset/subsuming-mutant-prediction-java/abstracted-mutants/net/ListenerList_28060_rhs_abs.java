public void fn_1 ( final tp_1 vr_1 )
{
vr_2 . add ( vr_1 ) ;
}
public void fn_2 ( final tp_1 vr_1 )
{
vr_2 . remove ( vr_1 ) ;
}
public int fn_3 ()
{
return vr_2 . size () ;
}
@Override
public Iterator < tp_1 > iterator () {
return vr_2 . iterator () ; MST[NonVoidMethodCallMutator]MSP[S]
}
