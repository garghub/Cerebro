public static double fn_1 ( final double ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
vr_1 . vr_2 ( array . length != 0 , lr_2 ) ;
double fn_1 = array [ 0 ] ;
for ( int vr_3 = 1 ; vr_3 < array . length ; vr_3 ++ ) {
fn_1 = fn_1 ( array [ vr_3 ] , fn_1 ) ;
}
return fn_1 ;
}
public static float fn_1 ( final float ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
vr_1 . vr_2 ( array . length != 0 , lr_2 ) ;
float fn_1 = array [ 0 ] ;
for ( int vr_3 = 1 ; vr_3 < array . length ; vr_3 ++ ) {
fn_1 = fn_1 ( array [ vr_3 ] , fn_1 ) ;
}
return fn_1 ;
}
public static double fn_1 ( final double vr_4 , final double vr_5 , final double vr_6 ) {
return fn_1 ( fn_1 ( vr_4 , vr_5 ) , vr_6 ) ;
}
public static double fn_1 ( final double vr_4 , final double vr_5 ) {
if( Double . vr_7 ( vr_4 ) ) {
return vr_5 ;
} else
if( Double . vr_7 ( vr_5 ) ) {
return vr_4 ;
} else {
return vr_8 . fn_1 ( vr_4 , vr_5 ) ;
}
}
public static float fn_1 ( final float vr_4 , final float vr_5 , final float vr_6 ) {
return fn_1 ( fn_1 ( vr_4 , vr_5 ) , vr_6 ) ;
}
public static float fn_1 ( final float vr_4 , final float vr_5 ) {
if( Float . vr_7 ( vr_4 ) ) {
return vr_5 ;
} else
if( Float . vr_7 ( vr_5 ) ) {
return vr_4 ;
} else {
return vr_8 . fn_1 ( vr_4 , vr_5 ) ;
}
}
public static double fn_2 ( final double ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
vr_1 . vr_2 ( array . length != 0 , lr_2 ) ;
double fn_2 = array [ 0 ] ;
for ( int vr_9 = 1 ; vr_9 < array . length ; vr_9 ++ ) {
fn_2 = fn_2 ( array [ vr_9 ] , fn_2 ) ;
}
return fn_2 ;
}
public static float fn_2 ( final float ... array ) {
if ( array == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
vr_1 . vr_2 ( array . length != 0 , lr_2 ) ;
float fn_2 = array [ 0 ] ;
for ( int vr_9 = 1 ; vr_9 < array . length ; vr_9 ++ ) {
fn_2 = fn_2 ( array [ vr_9 ] , fn_2 ) ;
}
return fn_2 ;
}
public static double fn_2 ( final double vr_4 , final double vr_5 , final double vr_6 ) {
return fn_2 ( fn_2 ( vr_4 , vr_5 ) , vr_6 ) ;
}
public static double fn_2 ( final double vr_4 , final double vr_5 ) {
if( Double . vr_7 ( vr_4 ) ) {
return vr_5 ;
} else
if( Double . vr_7 ( vr_5 ) ) {
return vr_4 ;
} else {
return vr_8 . fn_2 ( vr_4 , vr_5 ) ;
}
}
public static float fn_2 ( final float vr_4 , final float vr_5 , final float vr_6 ) {
return fn_2 ( fn_2 ( vr_4 , vr_5 ) , vr_6 ) ;
}
public static float fn_2 ( final float vr_4 , final float vr_5 ) {
if( Float . vr_7 ( vr_4 ) ) {
return vr_5 ;
} else
if( Float . vr_7 ( vr_5 ) ) {
return vr_4 ;
} else {
return vr_8 . fn_2 ( vr_4 , vr_5 ) ;
}
}
