String getHardware () {
return lr_1 + Runtime . getRuntime () . availableProcessors () + lr_2
+ getSystemProperty ( lr_3 ) + this . getSystemProperty ( lr_4 , lr_5 )
+ this . getSystemProperty ( lr_6 , lr_7 ) ;
}
String getLocale () {
return lr_8 + Locale . getDefault () + lr_9 + getSystemProperty ( lr_10 ) ;
}
String getOperatingSystem () {
return getSystemProperty ( lr_11 ) + lr_12 + getSystemProperty ( lr_13 )
+ getSystemProperty ( lr_12 , lr_14 ) + lr_2 + getSystemProperty ( lr_3 )
+ getSystemProperty ( lr_4 , lr_5 ) ;
}
String getRuntime () {
return getSystemProperty ( lr_15 ) + lr_16 + getSystemProperty ( lr_17 )
+ lr_18 + getSystemProperty ( lr_19 ) ;
}
private String getSystemProperty ( final String name ) {
return SystemPropertyStringLookup . INSTANCE . lookup ( name ) ;
}
private String getSystemProperty ( final String prefix , final String name ) {
final String value = getSystemProperty ( name ) ;
if ( StringUtils . isEmpty ( value ) ) {
return StringUtils . EMPTY ;
}
return prefix + value ;
}
String getVirtualMachine () {
return getSystemProperty ( lr_20 ) + lr_16 + getSystemProperty ( lr_21 ) + lr_22
+ getSystemProperty ( lr_23 ) + lr_24 ;
}
@Override
public String lookup ( final String key ) {
switch ( key ) {
case lr_25 :
return lr_26 + getSystemProperty ( lr_27 ) ;
case lr_28 :
return getRuntime () ;
case lr_29 :
return getVirtualMachine () ;
case lr_30 :
return getOperatingSystem () ;
case lr_31 :
return getHardware () ;
case lr_32 :
return getLocale () ;
default:
throw new IllegalArgumentException ( key ) ;
}
}
