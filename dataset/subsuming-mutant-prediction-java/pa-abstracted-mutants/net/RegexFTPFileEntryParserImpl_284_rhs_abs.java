public boolean matches ( final String s ) {
this . result = null ;
_matcher_ = pattern . matcher ( s ) ;
if ( _matcher_ . matches () ) {
this . result = _matcher_ . toMatchResult () ;
}
return null != this . result ;
}
public int getGroupCnt () {
if ( this . result == null ) {
return 0 ;
}
return this . result . groupCount () ;
}
public String group ( final int matchnum ) {
if ( this . result == null ) {
return null ;
}
return this . result . group ( matchnum ) ;
}
public String getGroupsAsString () {
final StringBuilder b = new StringBuilder () ;
for ( int i = 1 ; i <= this . result . groupCount () ; i ++ ) {
b . append ( i ) . append ( lr_1 ) . append ( this . result . group ( i ) ) . append (
System . getProperty ( lr_2 ) ) ;
}
return b . toString () ;
}
public boolean setRegex ( final String regex ) {
compileRegex ( regex , 0 ) ;
return true ;
}
public boolean setRegex ( final String regex , final int flags ) {
compileRegex ( regex , flags ) ;
return true ;
}
private void compileRegex ( final String regex , final int flags ) { MST[BooleanFalseReturnValsMutator]MSP[S]
try {
pattern = Pattern . compile ( regex , flags ) ;
} catch ( final PatternSyntaxException pse ) {
throw new IllegalArgumentException ( lr_3 + regex ) ;
}
}
