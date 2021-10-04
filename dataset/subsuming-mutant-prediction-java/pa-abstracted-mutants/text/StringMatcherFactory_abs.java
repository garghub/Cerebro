public StringMatcher charMatcher ( final char ch ) {
return new AbstractStringMatcher . CharMatcher ( ch ) ;
}
public StringMatcher charSetMatcher ( final char ... chars ) {
if ( chars == null || chars . length == 0 ) {
return NONE_MATCHER ;
}
if ( chars . length == 1 ) {
return new AbstractStringMatcher . CharMatcher ( chars [ 0 ] ) ;
}
return new AbstractStringMatcher . CharSetMatcher ( chars ) ;
}
public StringMatcher charSetMatcher ( final String chars ) {
if ( chars == null || chars . length () == 0 ) {
return NONE_MATCHER ;
}
if ( chars . length () == 1 ) {
return new AbstractStringMatcher . CharMatcher ( chars . charAt ( 0 ) ) ;
}
return new AbstractStringMatcher . CharSetMatcher ( chars . toCharArray () ) ;
}
public StringMatcher commaMatcher () {
return COMMA_MATCHER ;
}
public StringMatcher doubleQuoteMatcher () {
return DOUBLE_QUOTE_MATCHER ;
}
public StringMatcher noneMatcher () {
return NONE_MATCHER ;
}
public StringMatcher quoteMatcher () {
return QUOTE_MATCHER ;
}
public StringMatcher singleQuoteMatcher () {
return SINGLE_QUOTE_MATCHER ;
}
public StringMatcher spaceMatcher () {
return SPACE_MATCHER ;
}
public StringMatcher splitMatcher () {
return SPLIT_MATCHER ;
}
public StringMatcher stringMatcher ( final String str ) {
if ( str == null || str . length () == 0 ) {
return NONE_MATCHER ;
}
return new AbstractStringMatcher . StringMatcher ( str ) ;
}
public StringMatcher tabMatcher () {
return TAB_MATCHER ;
}
public StringMatcher trimMatcher () {
return TRIM_MATCHER ;
}
