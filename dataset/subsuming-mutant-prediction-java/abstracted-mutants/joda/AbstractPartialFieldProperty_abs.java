public tp_1 fn_1 () {
return fn_2 () . getType () ;
}
public String fn_3 () {
return fn_2 () . fn_3 () ;
}
public String fn_4 () {
return Integer . toString ( get () ) ;
}
public String fn_5 () {
return fn_5 ( null ) ;
}
public String fn_5 ( tp_2 vr_1 ) {
return fn_2 () . fn_5 ( fn_6 () , get () , vr_1 ) ;
}
public String fn_7 () {
return fn_7 ( null ) ;
}
public String fn_7 ( tp_2 vr_1 ) {
return fn_2 () . fn_7 ( fn_6 () , get () , vr_1 ) ;
}
public tp_3 fn_8 () {
return fn_2 () . fn_8 () ;
}
public tp_3 fn_9 () {
return fn_2 () . fn_9 () ;
}
public int fn_10 () {
return fn_2 () . fn_11 () ;
}
public int fn_11 () {
return fn_2 () . fn_11 ( fn_6 () ) ;
}
public int fn_12 () {
return fn_2 () . fn_13 () ;
}
public int fn_13 () {
return fn_2 () . fn_13 ( fn_6 () ) ;
}
public int fn_14 ( tp_2 vr_1 ) {
return fn_2 () . fn_14 ( vr_1 ) ;
}
public int fn_15 ( tp_2 vr_1 ) {
return fn_2 () . fn_15 ( vr_1 ) ;
}
public int fn_16 ( tp_4 vr_2 ) {
if ( vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
int vr_3 = get () ;
int vr_4 = vr_2 . get ( fn_1 () ) ;
if ( vr_3 < vr_4 ) {
return - 1 ;
} else if ( vr_3 > vr_4 ) {
return 1 ;
} else {
return 0 ;
}
}
public int fn_16 ( tp_5 vr_5 ) {
if ( vr_5 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
int vr_3 = get () ;
int vr_4 = vr_5 . get ( fn_1 () ) ;
if ( vr_3 < vr_4 ) {
return - 1 ;
} else if ( vr_3 > vr_4 ) {
return 1 ;
} else {
return 0 ;
}
}
public boolean equals ( Object object ) {
if ( this == object ) {
return true ;
}
if ( object instanceof vl_1 == false ) {
return false ;
}
vl_1 vr_6 = ( vl_1 ) object ;
return
get () == vr_6 . get () &&
fn_1 () == vr_6 . fn_1 () &&
vr_7 . equals ( fn_6 () . fn_17 () , vr_6 . fn_6 () . fn_17 () ) ;
}
public int fn_18 () {
int vr_8 = 19 ;
vr_8 = 13 * vr_8 + get () ;
vr_8 = 13 * vr_8 + fn_1 () . fn_18 () ;
vr_8 = 13 * vr_8 + fn_6 () . fn_17 () . fn_18 () ;
return vr_8 ;
}
public String toString () {
return lr_2 + fn_3 () + lr_3 ;
}
