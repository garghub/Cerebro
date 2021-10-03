public static tp_1 fn_1 () {
tp_1 vr_1 = new tp_1 () ;
vr_1 . vr_2 () ;
return vr_1 ;
}
@Override boolean fn_2 () { return false ; }
@Override boolean fn_3 () { return true ; }
@Override boolean fn_4 () { return false ; }
@Override boolean fn_2 () { return true ; }
@Override boolean fn_3 () { return false ; }
@Override boolean fn_4 () { return false ; }
@Override boolean fn_2 () { return false ; }
@Override boolean fn_3 () { return true ; }
@Override boolean fn_4 () { return false ; } MST[rv.CRCR3Mutator]MSP[N]
@Override boolean fn_2 () { return true ; }
@Override boolean fn_3 () { return false ; }
@Override boolean fn_4 () { return true ; }
public void vr_2 () {
if ( this . vr_3 == vr_4 . vr_5 ) {
throw new fn_5 ( lr_1 ) ;
}
if ( this . vr_3 != vr_4 . vr_6 ) {
throw new fn_5 ( lr_2 ) ;
}
this . vr_7 = System . vr_8 () ;
this . vr_9 = System . vr_10 () ;
this . vr_3 = vr_4 . vr_11 ;
}
public void fn_6 () {
if ( this . vr_3 != vr_4 . vr_11 && this . vr_3 != vr_4 . vr_12 ) {
throw new fn_5 ( lr_3 ) ;
}
if ( this . vr_3 == vr_4 . vr_11 ) {
this . vr_13 = System . vr_8 () ;
}
this . vr_3 = vr_4 . vr_5 ;
}
public void fn_7 () {
this . vr_3 = vr_4 . vr_6 ;
this . vr_14 = vr_15 . vr_16 ;
}
public void fn_8 () {
if ( this . vr_3 != vr_4 . vr_11 ) {
throw new fn_5 ( lr_3 ) ;
}
this . vr_13 = System . vr_8 () ;
this . vr_14 = vr_15 . vr_17 ;
}
public void fn_9 () {
if ( this . vr_14 != vr_15 . vr_17 ) {
throw new fn_5 ( lr_4 ) ;
}
this . vr_14 = vr_15 . vr_16 ;
}
public void fn_10 () {
if ( this . vr_3 != vr_4 . vr_11 ) {
throw new fn_5 ( lr_5 ) ;
}
this . vr_13 = System . vr_8 () ;
this . vr_3 = vr_4 . vr_12 ;
}
public void fn_11 () {
if ( this . vr_3 != vr_4 . vr_12 ) {
throw new fn_5 ( lr_6 ) ;
}
this . vr_7 += System . vr_8 () - this . vr_13 ;
this . vr_3 = vr_4 . vr_11 ;
}
public long fn_12 () {
return fn_13 () / vl_1 ;
}
public long fn_13 () {
if ( this . vr_3 == vr_4 . vr_5 || this . vr_3 == vr_4 . vr_12 ) {
return this . vr_13 - this . vr_7 ;
} else if ( this . vr_3 == vr_4 . vr_6 ) {
return 0 ;
} else if ( this . vr_3 == vr_4 . vr_11 ) {
return System . vr_8 () - this . vr_7 ;
}
throw new fn_14 ( lr_7 ) ;
}
public long fn_15 () {
return fn_16 () / vl_1 ;
}
public long fn_16 () {
if ( this . vr_14 != vr_15 . vr_17 ) {
throw new fn_5 ( lr_8 ) ;
}
return this . vr_13 - this . vr_7 ;
}
public long fn_17 () {
if ( this . vr_3 == vr_4 . vr_6 ) {
throw new fn_5 ( lr_9 ) ;
}
return this . vr_9 ;
}
@Override
public String toString () {
return vr_18 . vr_19 ( fn_12 () ) ;
}
public String fn_18 () {
return vr_18 . vr_19 ( fn_15 () ) ;
}
public boolean fn_2 () {
return vr_3 . fn_2 () ;
}
public boolean fn_4 () {
return vr_3 . fn_4 () ;
}
public boolean fn_3 () {
return vr_3 . fn_3 () ;
}
