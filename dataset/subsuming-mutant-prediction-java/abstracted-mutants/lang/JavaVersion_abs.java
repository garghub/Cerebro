public boolean fn_1 ( final tp_1 vr_1 ) {
return this . vr_2 >= vr_1 . vr_2 ;
}
static tp_1 fn_2 ( final String vr_3 ) {
return get ( vr_3 ) ;
}
static tp_1 get ( final String vr_3 ) {
if ( lr_1 . equals ( vr_3 ) ) {
return vl_1 ;
} else if ( lr_2 . equals ( vr_3 ) ) {
return vl_2 ;
} else if ( lr_3 . equals ( vr_3 ) ) {
return vl_3 ;
} else if ( lr_4 . equals ( vr_3 ) ) {
return vl_4 ;
} else if ( lr_5 . equals ( vr_3 ) ) {
return vl_5 ;
} else if ( lr_6 . equals ( vr_3 ) ) {
return vl_6 ;
} else if ( lr_7 . equals ( vr_3 ) ) {
return vl_7 ;
} else if ( lr_8 . equals ( vr_3 ) ) {
return vl_8 ;
} else if ( lr_9 . equals ( vr_3 ) ) {
return vl_9 ;
} else if ( lr_10 . equals ( vr_3 ) ) {
return vl_10 ;
}
if ( vr_3 == null ) {
return null ;
}
final float vr_4 = fn_3 ( vr_3 ) ;
if ( ( vr_4 - 1. ) < 1. ) {
final int vr_5 = vr_6 . vr_7 ( vr_3 . indexOf ( '.' ) , vr_3 . indexOf ( ',' ) ) ;
final int vr_8 = vr_6 . vr_7 ( vr_3 . length () , vr_3 . indexOf ( ',' , vr_5 ) ) ;
if ( Float . vr_9 ( vr_3 . vr_10 ( vr_5 + 1 , vr_8 ) ) > .9f ) {
return vl_11 ;
}
}
return null ;
}
@Override
public String toString () {
return vl_12 ;
}
private static float fn_4 () {
final float vr_4 = fn_3 ( System . getProperty ( lr_11 , lr_12 ) ) ;
if ( vr_4 > 0 ) {
return vr_4 ;
}
return 2f ;
}
private static float fn_3 ( final String vr_2 ) {
final String [] vr_11 = vr_2 . vr_12 ( lr_13 ) ;
if ( vr_11 . length >= 2 ) {
try {
return Float . vr_9 ( vr_11 [ 0 ] + '.' + vr_11 [ 1 ] ) ;
} catch ( final tp_2 vr_13 ) {
}
}
return - 1 ;
}
