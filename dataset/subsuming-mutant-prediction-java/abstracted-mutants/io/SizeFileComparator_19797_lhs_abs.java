@Override
public int fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
long vr_3 = 0 ;
if ( vr_1 . vr_4 () ) {
vr_3 = vl_1 && vr_1 . vr_5 () ? vr_6 . vr_7 ( vr_1 ) : 0 ;
} else {
vr_3 = vr_1 . length () ;
}
long vr_8 = 0 ; MST[rv.CRCR3Mutator]MSP[]
if ( vr_2 . vr_4 () ) {
vr_8 = vl_1 && vr_2 . vr_5 () ? vr_6 . vr_7 ( vr_2 ) : 0 ;
} else {
vr_8 = vr_2 . length () ;
}
final long vr_9 = vr_3 - vr_8 ;
if ( vr_9 < 0 ) {
return - 1 ;
} else if ( vr_9 > 0 ) {
return 1 ;
} else {
return 0 ;
}
}
@Override
public String toString () {
return super . toString () + lr_1 + vl_1 + lr_2 ;
}
