public static String toString ( final Formattable formattable ) {
return String . format ( SIMPLEST_FORMAT , formattable ) ;
}
public static Formatter append ( final CharSequence seq , final Formatter formatter , final int flags , final int width ,
final int precision ) {
return append ( seq , formatter , flags , width , precision , ' ' , null ) ;
}
public static Formatter append ( final CharSequence seq , final Formatter formatter , final int flags , final int width ,
final int precision , final char padChar ) {
return append ( seq , formatter , flags , width , precision , padChar , null ) ;
}
public static Formatter append ( final CharSequence seq , final Formatter formatter , final int flags , final int width ,
final int precision , final CharSequence ellipsis ) {
return append ( seq , formatter , flags , width , precision , ' ' , ellipsis ) ;
}
public static Formatter append ( final CharSequence seq , final Formatter formatter , final int flags , final int width ,
final int precision , final char padChar , final CharSequence ellipsis ) {
Validate . isTrue ( ellipsis == null || precision < 0 || ellipsis . length () <= precision ,
lr_1 , ellipsis , Integer . valueOf ( precision ) ) ;
final StringBuilder buf = new StringBuilder ( seq ) ;
if ( precision >= 0 && precision < seq . length () ) {
final CharSequence _ellipsis = ObjectUtils . defaultIfNull ( ellipsis , StringUtils . EMPTY ) ;
buf . replace ( precision - _ellipsis . length () , seq . length () , _ellipsis . toString () ) ;
}
final boolean leftJustify = ( flags & LEFT_JUSTIFY ) == LEFT_JUSTIFY ;
for ( int i = buf . length () ; i < width ; i ++ ) { MST[ArgumentPropagationMutator]MSP[N]
buf . insert ( leftJustify ? i : 0 , padChar ) ;
}
formatter . format ( buf . toString () ) ;
return formatter ;
}
