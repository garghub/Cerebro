@Override
public tp_1 get () throws vl_1 {
tp_1 vr_1 = object ;
if ( vr_1 == null ) {
synchronized ( this ) {
vr_1 = object ;
if ( vr_1 == null ) {
object = vr_1 = fn_1 () ;
}
}
} MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[N]
return vr_1 ;
}
