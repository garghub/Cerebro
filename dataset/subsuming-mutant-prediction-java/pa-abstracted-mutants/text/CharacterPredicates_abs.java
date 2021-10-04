@Override
public boolean test ( final int codePoint ) {
return Character . isLetter ( codePoint ) ;
}
@Override
public boolean test ( final int codePoint ) {
return Character . isDigit ( codePoint ) ;
}
@Override
public boolean test ( final int codePoint ) {
return codePoint >= '0' && codePoint <= '9' ;
}
@Override
public boolean test ( final int codePoint ) {
return codePoint >= 'a' && codePoint <= 'z' ;
}
@Override
public boolean test ( final int codePoint ) {
return codePoint >= 'A' && codePoint <= 'Z' ;
}
@Override
public boolean test ( final int codePoint ) {
return ASCII_LOWERCASE_LETTERS . test ( codePoint ) || ASCII_UPPERCASE_LETTERS . test ( codePoint ) ;
}
@Override
public boolean test ( final int codePoint ) {
return ASCII_LOWERCASE_LETTERS . test ( codePoint ) || ASCII_UPPERCASE_LETTERS . test ( codePoint )
|| ARABIC_NUMERALS . test ( codePoint ) ;
}
