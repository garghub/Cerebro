public static < V > String replace ( final Object source , final Map < String , V > valueMap ) {
return new StrSubstitutor ( valueMap ) . replace ( source ) ;
}
public static < V > String replace ( final Object source ,
final Map < String , V > valueMap ,
final String prefix ,
final String suffix ) {
return new StrSubstitutor ( valueMap , prefix , suffix ) . replace ( source ) ;
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
return StrSubstitutor . replace ( source , valueMap ) ;
}
public static String replaceSystemProperties ( final Object source ) {
return new StrSubstitutor ( StrLookup . systemPropertiesLookup () ) . replace ( source ) ;
}
public String replace ( final String source ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( source ) ;
if ( ! substitute ( buf , 0 , source . length () ) ) {
return source ;
}
return buf . toString () ;
}
public String replace ( final String source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( length ) . append ( source , offset , length ) ;
if ( ! substitute ( buf , 0 , length ) ) {
return source . substring ( offset , offset + length ) ;
}
return buf . toString () ;
}
public String replace ( final char [] source ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( source . length ) . append ( source ) ;
substitute ( buf , 0 , source . length ) ;
return buf . toString () ;
}
public String replace ( final char [] source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( length ) . append ( source , offset , length ) ;
substitute ( buf , 0 , length ) ;
return buf . toString () ;
}
public String replace ( final StringBuffer source ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( source . length () ) . append ( source ) ;
substitute ( buf , 0 , buf . length () ) ;
return buf . toString () ;
}
public String replace ( final StringBuffer source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( length ) . append ( source , offset , length ) ;
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
final StrBuilder buf = new StrBuilder ( length ) . append ( source , offset , length ) ;
substitute ( buf , 0 , length ) ;
return buf . toString () ;
}
public String replace ( final StrBuilder source ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( source . length () ) . append ( source ) ;
substitute ( buf , 0 , buf . length () ) ;
return buf . toString () ;
}
public String replace ( final StrBuilder source , final int offset , final int length ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder ( length ) . append ( source , offset , length ) ;
substitute ( buf , 0 , length ) ;
return buf . toString () ;
}
public String replace ( final Object source ) {
if ( source == null ) {
return null ;
}
final StrBuilder buf = new StrBuilder () . append ( source ) ;
substitute ( buf , 0 , buf . length () ) ;
return buf . toString () ;
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
final StrBuilder buf = new StrBuilder ( length ) . append ( source , offset , length ) ;
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
final StrBuilder buf = new StrBuilder ( length ) . append ( source , offset , length ) ;
if ( ! substitute ( buf , 0 , length ) ) {
return false ;
}
source . replace ( offset , offset + length , buf . toString () ) ;
return true ;
}
public boolean replaceIn ( final StrBuilder source ) {
if ( source == null ) {
return false ;
}
return substitute ( source , 0 , source . length () ) ;
}
public boolean replaceIn ( final StrBuilder source , final int offset , final int length ) {
if ( source == null ) {
return false ;
}
return substitute ( source , offset , length ) ;
}
protected boolean substitute ( final StrBuilder buf , final int offset , final int length ) {
return substitute ( buf , offset , length , null ) > 0 ;
}
private int substitute ( final StrBuilder buf , final int offset , final int length , List < String > priorVariables ) {
final StrMatcher pfxMatcher = getVariablePrefixMatcher () ;
final StrMatcher suffMatcher = getVariableSuffixMatcher () ;
final char escape = getEscapeChar () ;
final StrMatcher valueDelimMatcher = getValueDelimiterMatcher () ;
final boolean substitutionInVariablesEnabled = isEnableSubstitutionInVariables () ;
final boolean substitutionInValuesDisabled = isDisableSubstitutionInValues () ;
final boolean top = priorVariables == null ;
boolean altered = false ;
int lengthChange = 0 ;
char [] chars = buf . buffer ;
int bufEnd = offset + length ;
int pos = offset ;
while ( pos < bufEnd ) {
final int startMatchLen = pfxMatcher . isMatch ( chars , pos , offset , MST[rv.UOI3Mutator]MSP[N]
bufEnd ) ;
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
if ( substitutionInVariablesEnabled
&& pfxMatcher . isMatch ( chars ,
pos , offset , bufEnd ) != 0 ) {
endMatchLen = pfxMatcher . isMatch ( chars ,
pos , offset , bufEnd ) ;
nestedVarCount ++ ;
pos += endMatchLen ;
continue;
}
endMatchLen = suffMatcher . isMatch ( chars , pos , offset ,
bufEnd ) ;
if ( endMatchLen == 0 ) {
pos ++ ;
} else {
if ( nestedVarCount == 0 ) {
String varNameExpr = new String ( chars , startPos
+ startMatchLen , pos - startPos
- startMatchLen ) ;
if ( substitutionInVariablesEnabled ) {
final StrBuilder bufName = new StrBuilder ( varNameExpr ) ;
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
if ( ! substitutionInVariablesEnabled
&& pfxMatcher . isMatch ( varNameExprChars ,
i ,
i ,
varNameExprChars . length ) != 0 ) {
break;
}
if ( valueDelimMatcher . isMatch ( varNameExprChars , i ) != 0 ) {
valueDelimiterMatchLen = valueDelimMatcher . isMatch ( varNameExprChars , i ) ;
varName = varNameExpr . substring ( 0 , i ) ;
varDefaultValue = varNameExpr . substring ( i + valueDelimiterMatchLen ) ;
break;
}
}
}
if ( priorVariables == null ) {
priorVariables = new ArrayList <> () ;
priorVariables . add ( new String ( chars ,
offset , length ) ) ;
}
checkCyclicSubstitution ( varName , priorVariables ) ;
priorVariables . add ( varName ) ;
String varValue = resolveVariable ( varName , buf ,
startPos , endPos ) ;
if ( varValue == null ) {
varValue = varDefaultValue ;
}
if ( varValue != null ) {
final int varLen = varValue . length () ;
buf . replace ( startPos , endPos , varValue ) ;
altered = true ;
int change = 0 ;
if ( ! substitutionInValuesDisabled ) {
change = substitute ( buf , startPos ,
varLen , priorVariables ) ;
}
change = change
+ varLen - ( endPos - startPos ) ;
pos += change ;
bufEnd += change ;
lengthChange += change ;
chars = buf . buffer ;
}
priorVariables
. remove ( priorVariables . size () - 1 ) ;
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
private void checkCyclicSubstitution ( final String varName , final List < String > priorVariables ) {
if ( ! priorVariables . contains ( varName ) ) {
return;
}
final StrBuilder buf = new StrBuilder ( 256 ) ;
buf . append ( lr_1 ) ;
buf . append ( priorVariables . remove ( 0 ) ) ;
buf . append ( lr_2 ) ;
buf . appendWithSeparators ( priorVariables , lr_3 ) ;
throw new IllegalStateException ( buf . toString () ) ;
}
protected String resolveVariable ( final String variableName ,
final StrBuilder buf ,
final int startPos ,
final int endPos ) {
final StrLookup < ? > resolver = getVariableResolver () ;
if ( resolver == null ) {
return null ;
}
return resolver . lookup ( variableName ) ;
}
public char getEscapeChar () {
return this . escapeChar ;
}
public void setEscapeChar ( final char escapeCharacter ) {
this . escapeChar = escapeCharacter ;
}
public StrMatcher getVariablePrefixMatcher () {
return prefixMatcher ;
}
public StrSubstitutor setVariablePrefixMatcher ( final StrMatcher prefixMatcher ) {
Validate . isTrue ( prefixMatcher != null , lr_4 ) ;
this . prefixMatcher = prefixMatcher ;
return this ;
}
public StrSubstitutor setVariablePrefix ( final char prefix ) {
return setVariablePrefixMatcher ( StrMatcher . charMatcher ( prefix ) ) ;
}
public StrSubstitutor setVariablePrefix ( final String prefix ) {
Validate . isTrue ( prefix != null , lr_5 ) ;
return setVariablePrefixMatcher ( StrMatcher . stringMatcher ( prefix ) ) ;
}
public StrMatcher getVariableSuffixMatcher () {
return suffixMatcher ;
}
public StrSubstitutor setVariableSuffixMatcher ( final StrMatcher suffixMatcher ) {
Validate . isTrue ( suffixMatcher != null , lr_6 ) ;
this . suffixMatcher = suffixMatcher ;
return this ;
}
public StrSubstitutor setVariableSuffix ( final char suffix ) {
return setVariableSuffixMatcher ( StrMatcher . charMatcher ( suffix ) ) ;
}
public StrSubstitutor setVariableSuffix ( final String suffix ) {
Validate . isTrue ( suffix != null , lr_7 ) ;
return setVariableSuffixMatcher ( StrMatcher . stringMatcher ( suffix ) ) ;
}
public StrMatcher getValueDelimiterMatcher () {
return valueDelimiterMatcher ;
}
public StrSubstitutor setValueDelimiterMatcher ( final StrMatcher valueDelimiterMatcher ) {
this . valueDelimiterMatcher = valueDelimiterMatcher ;
return this ;
}
public StrSubstitutor setValueDelimiter ( final char valueDelimiter ) {
return setValueDelimiterMatcher ( StrMatcher . charMatcher ( valueDelimiter ) ) ;
}
public StrSubstitutor setValueDelimiter ( final String valueDelimiter ) {
if ( valueDelimiter == null || valueDelimiter . length () == 0 ) {
setValueDelimiterMatcher ( null ) ;
return this ;
}
return setValueDelimiterMatcher ( StrMatcher . stringMatcher ( valueDelimiter ) ) ;
}
public StrLookup < ? > getVariableResolver () {
return this . variableResolver ;
}
public void setVariableResolver ( final StrLookup < ? > variableResolver ) {
this . variableResolver = variableResolver ;
}
public boolean isEnableSubstitutionInVariables () {
return enableSubstitutionInVariables ;
}
public void setEnableSubstitutionInVariables (
final boolean enableSubstitutionInVariables ) {
this . enableSubstitutionInVariables = enableSubstitutionInVariables ;
}
public boolean isDisableSubstitutionInValues () {
return disableSubstitutionInValues ;
}
public void setDisableSubstitutionInValues ( final boolean disableSubstitutionInValues ) {
this . disableSubstitutionInValues = disableSubstitutionInValues ;
}
public boolean isPreserveEscapes () {
return preserveEscapes ;
}
public void setPreserveEscapes ( final boolean preserveEscapes ) {
this . preserveEscapes = preserveEscapes ;
}
