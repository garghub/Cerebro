public static < V > String replace ( final Object source , final Map < String , V > valueMap ) {
return new StringSubstitutor ( valueMap ) . replace ( source ) ;
}
public static < V > String replace ( final Object source , final Map < String , V > valueMap , final String prefix ,
final String suffix ) {
return new StringSubstitutor ( valueMap , prefix , suffix ) . replace ( source ) ;
}
public static String replace ( final Object source , final Properties valueProperties ) {
if ( valueProperties == null ) {
return source . toString () ;
}
final Map < String , String > valueMap = new HashMap <> () ;
final Enumeration < ? > propNames = valueProperties . propertyNames () ;
while ( propNames . hasMoreElements () ) {
final String propName = ( String ) propNames . nextElement () ;
final String propValue = valueProperties . getProperty ( propName ) ;
valueMap . put ( propName , propValue ) ;
}
return StringSubstitutor . replace ( source , valueMap ) ;
}
public static String replaceSystemProperties ( final Object source ) {
return new StringSubstitutor ( StringLookupFactory . INSTANCE . systemPropertyStringLookup () ) . replace ( source ) ;
}
private void checkCyclicSubstitution ( final String varName , final List < String > priorVariables ) {
if ( ! priorVariables . contains ( varName ) ) {
return;
}
final TextStringBuilder buf = new TextStringBuilder ( 256 ) ;
buf . append ( lr_1 ) ;
buf . append ( priorVariables . remove ( 0 ) ) ;
buf . append ( lr_2 ) ;
buf . appendWithSeparators ( priorVariables , lr_3 ) ;
throw new IllegalStateException ( buf . toString () ) ;
}
public char getEscapeChar () {
return this . escapeChar ;
}
public StringLookup getStringLookup () {
return this . variableResolver ;
}
public StringMatcher getValueDelimiterMatcher () {
return valueDelimiterMatcher ;
}
public StringMatcher getVariablePrefixMatcher () {
return prefixMatcher ;
}
public StringMatcher getVariableSuffixMatcher () {
return suffixMatcher ;
}
public boolean isDisableSubstitutionInValues () {
return disableSubstitutionInValues ;
}
public boolean isEnableSubstitutionInVariables () {
return enableSubstitutionInVariables ;
}
public boolean isPreserveEscapes () {
return preserveEscapes ;
}
public String replace ( final char [] source ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( source . length ) . append ( source ) ;
substitute ( buf , 0 , source . length ) ;
return buf . toString () ;
}
public String replace ( final char [] source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( length ) . append ( source , offset , length ) ;
substitute ( buf , 0 , length ) ;
return buf . toString () ;
}
public String replace ( final CharSequence source ) {
if ( source == null ) {
return null ;
}
return replace ( source , 0 , source . length () ) ;
}
public String replace ( final CharSequence source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( length ) . append ( source , offset , length ) ;
substitute ( buf , 0 , length ) ;
return buf . toString () ;
}
public String replace ( final Object source ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder () . append ( source ) ;
substitute ( buf , 0 , buf . length () ) ;
return buf . toString () ;
}
public String replace ( final TextStringBuilder source ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( source . length () ) . append ( source ) ;
substitute ( buf , 0 , buf . length () ) ;
return buf . toString () ;
}
public String replace ( final TextStringBuilder source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( length ) . append ( source , offset , length ) ;
substitute ( buf , 0 , length ) ;
return buf . toString () ;
}
public String replace ( final String source ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( source ) ;
if ( ! substitute ( buf , 0 , source . length () ) ) {
return source ;
}
return buf . toString () ;
}
public String replace ( final String source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( length ) . append ( source , offset , length ) ;
if ( ! substitute ( buf , 0 , length ) ) {
return source . substring ( offset , offset + length ) ;
}
return buf . toString () ;
}
public String replace ( final StringBuffer source ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( source . length () ) . append ( source ) ;
substitute ( buf , 0 , buf . length () ) ;
return buf . toString () ;
}
public String replace ( final StringBuffer source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final TextStringBuilder buf = new TextStringBuilder ( length ) . append ( source , offset , length ) ;
substitute ( buf , 0 , length ) ;
return buf . toString () ;
}
public boolean replaceIn ( final TextStringBuilder source ) {
if ( source == null ) {
return false ;
}
return substitute ( source , 0 , source . length () ) ;
}
public boolean replaceIn ( final TextStringBuilder source , final int offset , final int length ) {
if ( source == null ) {
return false ;
}
return substitute ( source , offset , length ) ;
}
public boolean replaceIn ( final StringBuffer source ) {
if ( source == null ) {
return false ;
}
return replaceIn ( source , 0 , source . length () ) ;
}
public boolean replaceIn ( final StringBuffer source , final int offset , final int length ) {
if ( source == null ) {
return false ;
}
final TextStringBuilder buf = new TextStringBuilder ( length ) . append ( source , offset , length ) ;
if ( ! substitute ( buf , 0 , length ) ) {
return false ;
}
source . replace ( offset , offset + length , buf . toString () ) ;
return true ;
}
public boolean replaceIn ( final StringBuilder source ) {
if ( source == null ) {
return false ;
}
return replaceIn ( source , 0 , source . length () ) ;
}
public boolean replaceIn ( final StringBuilder source , final int offset , final int length ) {
if ( source == null ) {
return false ;
}
final TextStringBuilder buf = new TextStringBuilder ( length ) . append ( source , offset , length ) ;
if ( ! substitute ( buf , 0 , length ) ) {
return false ;
}
source . replace ( offset , offset + length , buf . toString () ) ;
return true ;
}
protected String resolveVariable ( final String variableName , final TextStringBuilder buf , final int startPos ,
final int endPos ) {
final StringLookup resolver = getStringLookup () ;
if ( resolver == null ) {
return null ;
}
return resolver . lookup ( variableName ) ;
}
public StringSubstitutor setDisableSubstitutionInValues ( final boolean disableSubstitutionInValues ) {
this . disableSubstitutionInValues = disableSubstitutionInValues ;
return this ;
}
public StringSubstitutor setEnableSubstitutionInVariables ( final boolean enableSubstitutionInVariables ) {
this . enableSubstitutionInVariables = enableSubstitutionInVariables ;
return this ;
}
public StringSubstitutor setEscapeChar ( final char escapeCharacter ) {
this . escapeChar = escapeCharacter ;
return this ;
}
public StringSubstitutor setPreserveEscapes ( final boolean preserveEscapes ) {
this . preserveEscapes = preserveEscapes ;
return this ;
}
public StringSubstitutor setValueDelimiter ( final char valueDelimiter ) {
return setValueDelimiterMatcher ( StringMatcherFactory . INSTANCE . charMatcher ( valueDelimiter ) ) ;
}
public StringSubstitutor setValueDelimiter ( final String valueDelimiter ) {
if ( valueDelimiter == null || valueDelimiter . length () == 0 ) {
setValueDelimiterMatcher ( null ) ;
return this ;
}
return setValueDelimiterMatcher ( StringMatcherFactory . INSTANCE . stringMatcher ( valueDelimiter ) ) ;
}
public StringSubstitutor setValueDelimiterMatcher ( final StringMatcher valueDelimiterMatcher ) {
this . valueDelimiterMatcher = valueDelimiterMatcher ;
return this ;
}
public StringSubstitutor setVariablePrefix ( final char prefix ) {
return setVariablePrefixMatcher ( StringMatcherFactory . INSTANCE . charMatcher ( prefix ) ) ;
}
public StringSubstitutor setVariablePrefix ( final String prefix ) {
Validate . isTrue ( prefix != null , lr_4 ) ;
return setVariablePrefixMatcher ( StringMatcherFactory . INSTANCE . stringMatcher ( prefix ) ) ;
}
public StringSubstitutor setVariablePrefixMatcher ( final StringMatcher prefixMatcher ) {
Validate . isTrue ( prefixMatcher != null , lr_5 ) ;
this . prefixMatcher = prefixMatcher ;
return this ;
}
public StringSubstitutor setVariableResolver ( final StringLookup variableResolver ) {
this . variableResolver = variableResolver ;
return this ;
}
public StringSubstitutor setVariableSuffix ( final char suffix ) {
return setVariableSuffixMatcher ( StringMatcherFactory . INSTANCE . charMatcher ( suffix ) ) ;
}
public StringSubstitutor setVariableSuffix ( final String suffix ) {
Validate . isTrue ( suffix != null , lr_6 ) ;
return setVariableSuffixMatcher ( StringMatcherFactory . INSTANCE . stringMatcher ( suffix ) ) ;
}
public StringSubstitutor setVariableSuffixMatcher ( final StringMatcher suffixMatcher ) {
Validate . isTrue ( suffixMatcher != null , lr_7 ) ;
this . suffixMatcher = suffixMatcher ;
return this ;
}
protected boolean substitute ( final TextStringBuilder buf , final int offset , final int length ) {
return substitute ( buf , offset , length , null ) > 0 ;
}
private int substitute ( final TextStringBuilder buf , final int offset , final int length ,
List < String > priorVariables ) {
final StringMatcher pfxMatcher = getVariablePrefixMatcher () ;
final StringMatcher suffMatcher = getVariableSuffixMatcher () ;
final char escape = getEscapeChar () ;
final StringMatcher valueDelimMatcher = getValueDelimiterMatcher () ;
final boolean substitutionInVariablesEnabled = isEnableSubstitutionInVariables () ;
final boolean substitutionInValuesDisabled = isDisableSubstitutionInValues () ;
final boolean top = priorVariables == null ;
boolean altered = false ;
int lengthChange = 0 ;
char [] chars = buf . buffer ;
int bufEnd = offset + length ;
int pos = offset ;
while ( pos < bufEnd ) {
final int startMatchLen = pfxMatcher . isMatch ( chars , pos , offset , bufEnd ) ;
if ( startMatchLen == 0 ) {
pos ++ ;
} else {
if ( pos > offset && chars [ pos - 1 ] == escape ) {
if ( preserveEscapes ) {
pos ++ ;
continue;
}
buf . deleteCharAt ( pos - 1 ) ;
chars = buf . buffer ;
lengthChange -- ;
altered = true ;
bufEnd -- ;
} else {
final int startPos = pos ;
pos += startMatchLen ;
int endMatchLen = 0 ;
int nestedVarCount = 0 ;
while ( pos < bufEnd ) {
if ( substitutionInVariablesEnabled && pfxMatcher . isMatch ( chars , pos , offset , bufEnd ) != 0 ) {
endMatchLen = pfxMatcher . isMatch ( chars , pos , offset , bufEnd ) ;
nestedVarCount ++ ;
pos += endMatchLen ;
continue;
}
endMatchLen = suffMatcher . isMatch ( chars , pos , offset , bufEnd ) ;
if ( endMatchLen == 0 ) {
pos ++ ;
} else {
if ( nestedVarCount == 0 ) {
String varNameExpr = new String ( chars , startPos + startMatchLen ,
pos - startPos - startMatchLen ) ;
if ( substitutionInVariablesEnabled ) {
final TextStringBuilder bufName = new TextStringBuilder ( varNameExpr ) ;
substitute ( bufName , 0 , bufName . length () ) ;
varNameExpr = bufName . toString () ;
}
pos += endMatchLen ;
final int endPos = pos ;
String varName = varNameExpr ;
String varDefaultValue = null ;
if ( valueDelimMatcher != null ) {
final char [] varNameExprChars = varNameExpr . toCharArray () ;
int valueDelimiterMatchLen = 0 ;
for ( int i = 0 ; i < varNameExprChars . length ; i ++ ) {
if ( ! substitutionInVariablesEnabled && pfxMatcher . isMatch ( varNameExprChars , i ,
i , varNameExprChars . length ) != 0 ) {
break;
}
if ( valueDelimMatcher . isMatch ( varNameExprChars , i , 0 ,
varNameExprChars . length ) != 0 ) {
valueDelimiterMatchLen = valueDelimMatcher . isMatch ( varNameExprChars , i , 0 ,
varNameExprChars . length ) ;
varName = varNameExpr . substring ( 0 , i ) ;
varDefaultValue = varNameExpr . substring ( i + valueDelimiterMatchLen ) ;
break;
}
}
}
if ( priorVariables == null ) {
priorVariables = new ArrayList <> () ;
priorVariables . add ( new String ( chars , offset , length ) ) ;
}
checkCyclicSubstitution ( varName , priorVariables ) ;
priorVariables . add ( varName ) ;
String varValue = resolveVariable ( varName , buf , startPos , endPos ) ;
if ( varValue == null ) {
varValue = varDefaultValue ;
}
if ( varValue != null ) {
final int varLen = varValue . length () ;
buf . replace ( startPos , endPos , varValue ) ;
altered = true ;
int change = 0 ;
if ( ! substitutionInValuesDisabled ) {
change = substitute ( buf , startPos , varLen , priorVariables ) ;
}
change = change + varLen - ( endPos - startPos ) ;
pos += change ;
bufEnd += change ;
lengthChange += change ;
chars = buf . buffer ;
}
priorVariables . remove ( priorVariables . size () - 1 ) ;
break;
}
nestedVarCount -- ;
pos += endMatchLen ;
}
}
}
}
}
if ( top ) {
return altered ? 1 : 0 ;
}
return lengthChange ;
}
