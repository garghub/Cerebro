public tp_1 fn_1 () {
return new tp_1 ( fn_2 () ) ;
}
public tp_2 fn_3 () {
return new tp_2 ( fn_2 () ) ;
}
public int fn_4 ( tp_3 vr_1 ) {
long vr_2 = this . fn_2 () ;
long vr_3 = vr_1 . fn_2 () ;
if ( vr_2 < vr_3 ) {
return - 1 ;
}
if ( vr_2 > vr_3 ) {
return 1 ;
}
return 0 ;
}
public boolean fn_5 ( tp_3 vr_4 ) {
if ( vr_4 == null ) {
vr_4 = tp_1 . vr_5 ;
}
return fn_4 ( vr_4 ) == 0 ;
}
public boolean fn_6 ( tp_3 vr_4 ) {
if ( vr_4 == null ) {
vr_4 = tp_1 . vr_5 ;
}
return fn_4 ( vr_4 ) > 0 ;
}
public boolean fn_7 ( tp_3 vr_4 ) {
if ( vr_4 == null ) {
vr_4 = tp_1 . vr_5 ;
}
return fn_4 ( vr_4 ) < 0 ;
}
public boolean equals ( Object vr_4 ) {
if ( this == vr_4 ) {
return true ;
}
if ( vr_4 instanceof tp_3 == false ) {
return false ;
}
tp_3 vr_1 = ( tp_3 ) vr_4 ;
return ( fn_2 () == vr_1 . fn_2 () ) ;
}
public int fn_8 () {
long vr_6 = fn_2 () ;
return (int) ( vr_6 ^ ( vr_6 >>> 32 ) ) ;
}
@ToString
public String toString () {
long vr_7 = fn_2 () ;
tp_4 vr_8 = new tp_4 () ;
vr_8 . append ( lr_1 ) ;
boolean vr_9 = ( vr_7 < 0 ) ;
vr_10 . vr_11 ( vr_8 , vr_7 ) ;
while ( vr_8 . length () < ( vr_9 ? 7 : 6 ) ) {
vr_8 . vr_12 ( vr_9 ? 3 : 2 , lr_2 ) ;
}
if ( ( vr_7 / 1000 ) * 1000 == vr_7 ) {
vr_8 . vr_13 ( vr_8 . length () - 3 ) ;
} else {
vr_8 . vr_12 ( vr_8 . length () - 3 , lr_3 ) ;
}
vr_8 . append ( 'S' ) ;
return vr_8 . toString () ;
}
