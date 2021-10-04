public boolean atLeast ( final JavaVersion requiredVersion ) {
return this . value >= requiredVersion . value ;
}
static JavaVersion getJavaVersion ( final String nom ) {
return get ( nom ) ;
}
static JavaVersion get ( final String nom ) {
if ( lr_1 . equals ( nom ) ) {
return JAVA_0_9 ;
} else if ( lr_2 . equals ( nom ) ) {
return JAVA_1_1 ;
} else if ( lr_3 . equals ( nom ) ) {
return JAVA_1_2 ;
} else if ( lr_4 . equals ( nom ) ) {
return JAVA_1_3 ;
} else if ( lr_5 . equals ( nom ) ) {
return JAVA_1_4 ;
} else if ( lr_6 . equals ( nom ) ) {
return JAVA_1_5 ;
} else if ( lr_7 . equals ( nom ) ) {
return JAVA_1_6 ;
} else if ( lr_8 . equals ( nom ) ) {
return JAVA_1_7 ;
} else if ( lr_9 . equals ( nom ) ) {
return JAVA_1_8 ;
} else if ( lr_10 . equals ( nom ) ) {
return JAVA_1_9 ;
}
if ( nom == null ) {
return null ;
}
final float v = toFloatVersion ( nom ) ;
if ( ( v - 1. ) < 1. ) {
final int firstComma = Math . max ( nom . indexOf ( '.' ) , nom . indexOf ( ',' ) ) ;
final int end = Math . max ( nom . length () , nom . indexOf ( ',' , firstComma ) ) ;
if ( Float . parseFloat ( nom . substring ( firstComma + 1 , end ) ) > .9f ) {
return JAVA_RECENT ;
}
}
return null ;
}
@Override
public String toString () {
return name ;
}
private static float maxVersion () {
final float v = toFloatVersion ( System . getProperty ( lr_11 , lr_12 ) ) ;
if ( v > 0 ) {
return v ;
}
return 2f ;
}
private static float toFloatVersion ( final String value ) {
final String [] toParse = value . split ( lr_13 ) ;
if ( toParse . length >= 2 ) {
try {
return Float . parseFloat ( toParse [ 0 ] + '.' + toParse [ 1 ] ) ;
} catch ( final NumberFormatException nfe ) {
}
}
return - 1 ;
}
