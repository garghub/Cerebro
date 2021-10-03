public void fn_1 ( final String vr_1 )
{
if ( vl_1 == null ) {
vl_1 = new ArrayList <> () ;
}
vl_1 . add ( vr_1 ) ;
}
public void fn_2 ()
{
if ( vl_2 ) {
return;
}
vl_2 = true ;
if ( vl_1 == null ) {
vl_1 = new ArrayList <> () ;
}
final tp_1 vr_2 = vr_3 . vr_4 () ;
final long vr_5 = vr_2 . vr_6 () ;
final tp_1 vr_7 = vr_3 . vr_8 () ;
final long vr_9 = vr_7 . vr_6 () ;
final tp_1 vr_10 = vr_3 . vr_11 () ;
final long vr_12 = vr_10 . vr_6 () ;
if ( vr_2 . vr_13 () == 0 )
{
if ( vr_10 . vr_13 () != 0 )
{
vl_3 = Long . valueOf ( vr_12 - vl_4 ) ;
vl_1 . add ( lr_1 ) ;
} else {
vl_1 . add ( lr_2 ) ;
}
} else if ( vr_7 . vr_13 () == 0 || vr_10 . vr_13 () == 0 ) {
vl_1 . add ( lr_3 ) ;
if ( vr_5 > vl_4 ) {
vl_1 . add ( lr_4 ) ;
} else {
vl_5 = Long . valueOf ( vl_4 - vr_5 ) ;
}
if ( vr_7 . vr_13 () != 0 )
{
vl_3 = Long . valueOf ( vr_9 - vr_5 ) ;
} else if ( vr_10 . vr_13 () != 0 )
{
vl_3 = Long . valueOf ( vr_12 - vl_4 ) ;
}
} else
{
long vr_14 = vl_4 - vr_5 ;
if ( vr_12 < vr_9 )
{
vl_1 . add ( lr_5 ) ;
} else
{
final long vr_15 = vr_12 - vr_9 ;
if ( vr_15 <= vr_14 )
{
vr_14 -= vr_15 ;
} else
{
if ( vr_15 - vr_14 == 1 )
{
if ( vr_14 != 0 )
{
vl_1 . add ( lr_6 ) ;
vr_14 = 0 ;
}
} else {
vl_1 . add ( lr_7 ) ;
}
}
}
vl_5 = Long . valueOf ( vr_14 ) ;
if ( vr_5 > vl_4 ) {
vl_1 . add ( lr_4 ) ;
}
vl_3 = Long . valueOf ( ( ( vr_9 - vr_5 ) + ( vr_12 - vl_4 ) ) / 2 ) ;
}
}
public List < String > fn_3 ()
{
return vl_1 ;
}
public Long fn_4 ()
{
return vl_5 ;
}
public Long fn_5 ()
{
return vl_3 ;
}
public tp_2 fn_6 ()
{
return vr_3 ;
}
public tp_3 fn_7 () {
final tp_4 vr_16 = vr_3 . vr_17 () ;
return vr_16 == null ? null : vr_16 . fn_7 () ;
}
public long fn_8 ()
{
return vl_4 ;
}
@Override
public boolean equals ( final Object vr_18 ) MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
{
if ( this == vr_18 ) {
return true ;
}
if ( vr_18 == null || getClass () != vr_18 . getClass () ) {
return false ;
}
final tp_5 vr_19 = ( tp_5 ) vr_18 ;
return vl_4 == vr_19 . vl_4 && vr_3 . equals ( vr_19 . vr_3 ) ;
}
@Override
public int fn_9 ()
{
final int vr_20 = 31 ;
int vr_21 = ( int ) vl_4 ;
vr_21 = vr_20 * vr_21 + vr_3 . fn_9 () ;
return vr_21 ;
}
