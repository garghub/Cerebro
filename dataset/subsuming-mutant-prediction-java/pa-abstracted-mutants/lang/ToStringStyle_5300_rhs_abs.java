static Map < Object , Object > getRegistry () {
return REGISTRY . get () ;
}
static boolean isRegistered ( final Object value ) {
final Map < Object , Object > m = getRegistry () ;
return m != null && m . containsKey ( value ) ;
}
static void register ( final Object value ) {
if ( value != null ) {
final Map < Object , Object > m = getRegistry () ;
if ( m == null ) {
REGISTRY . set ( new WeakHashMap < Object , Object > () ) ;
}
getRegistry () . put ( value , null ) ;
}
}
static void unregister ( final Object value ) {
if ( value != null ) {
final Map < Object , Object > m = getRegistry () ;
if ( m != null ) {
m . remove ( value ) ;
if ( m . isEmpty () ) {
REGISTRY . remove () ;
}
}
}
}
public void appendSuper ( final StringBuffer buffer , final String superToString ) {
appendToString ( buffer , superToString ) ;
}
public void appendToString ( final StringBuffer buffer , final String toString ) {
if ( toString != null ) {
final int pos1 = toString . indexOf ( contentStart ) + contentStart . length () ;
final int pos2 = toString . lastIndexOf ( contentEnd ) ;
if ( pos1 != pos2 && pos1 >= 0 && pos2 >= 0 ) {
final String data = toString . substring ( pos1 , pos2 ) ;
if ( fieldSeparatorAtStart ) {
removeLastFieldSeparator ( buffer ) ;
}
buffer . append ( data ) ;
appendFieldSeparator ( buffer ) ;
}
}
}
public void appendStart ( final StringBuffer buffer , final Object object ) {
if ( object != null ) {
appendClassName ( buffer , object ) ;
appendIdentityHashCode ( buffer , object ) ;
appendContentStart ( buffer ) ;
if ( fieldSeparatorAtStart ) {
appendFieldSeparator ( buffer ) ;
}
}
}
public void appendEnd ( final StringBuffer buffer , final Object object ) {
if ( this . fieldSeparatorAtEnd == false ) {
removeLastFieldSeparator ( buffer ) ;
}
appendContentEnd ( buffer ) ;
unregister ( object ) ;
}
protected void removeLastFieldSeparator ( final StringBuffer buffer ) {
final int len = buffer . length () ;
final int sepLen = fieldSeparator . length () ;
if ( len > 0 && sepLen > 0 && len >= sepLen ) {
boolean match = true ;
for ( int i = 0 ; i < sepLen ; i ++ ) {
if ( buffer . charAt ( len - 1 - i ) != fieldSeparator . charAt ( sepLen - 1 - i ) ) {
match = false ;
break;
}
}
if ( match ) {
buffer . setLength ( len - sepLen ) ;
}
}
}
public void append ( final StringBuffer buffer , final String fieldName , final Object value , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( value == null ) {
appendNullText ( buffer , fieldName ) ;
} else {
appendInternal ( buffer , fieldName , value , isFullDetail ( fullDetail ) ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendInternal ( final StringBuffer buffer , final String fieldName , final Object value , final boolean detail ) {
if ( isRegistered ( value )
&& ! ( value instanceof Number || value instanceof Boolean || value instanceof Character ) ) {
appendCyclicObject ( buffer , fieldName , value ) ;
return;
}
register ( value ) ;
try {
if ( value instanceof Collection < ? > ) {
if ( detail ) {
appendDetail ( buffer , fieldName , ( Collection < ? > ) value ) ;
} else {
appendSummarySize ( buffer , fieldName , ( ( Collection < ? > ) value ) . size () ) ;
}
} else if ( value instanceof Map < ? , ? > ) {
if ( detail ) {
appendDetail ( buffer , fieldName , ( Map < ? , ? > ) value ) ;
} else {
appendSummarySize ( buffer , fieldName , ( ( Map < ? , ? > ) value ) . size () ) ;
}
}
void appendCyclicObject ( final StringBuffer buffer , final String fieldName , final Object value ) {
ObjectUtils . identityToString ( buffer , value ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final Object value ) {
buffer . append ( value ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final Collection < ? > coll ) {
buffer . append ( coll ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final Map < ? , ? > map ) {
buffer . append ( map ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final Object value ) {
buffer . append ( summaryObjectStartText ) ;
buffer . append ( getShortClassName ( value . getClass () ) ) ;
buffer . append ( summaryObjectEndText ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final long value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final long value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final int value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final int value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final short value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final short value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final byte value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final byte value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final char value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final char value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final double value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final double value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final float value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final float value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final boolean value ) {
appendFieldStart ( buffer , fieldName ) ;
appendDetail ( buffer , fieldName , value ) ;
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final boolean value ) {
buffer . append ( value ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final Object [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final Object [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
final Object item = array [ i ] ;
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
if ( item == null ) {
appendNullText ( buffer , fieldName ) ;
} else {
appendInternal ( buffer , fieldName , item , arrayContentDetail ) ;
}
}
buffer . append ( arrayEnd ) ;
}
protected void reflectionAppendArrayDetail ( final StringBuffer buffer , final String fieldName , final Object array ) {
buffer . append ( arrayStart ) ;
final int length = Array . getLength ( array ) ;
for ( int i = 0 ; i < length ; i ++ ) {
final Object item = Array . get ( array , i ) ;
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
if ( item == null ) {
appendNullText ( buffer , fieldName ) ;
} else {
appendInternal ( buffer , fieldName , item , arrayContentDetail ) ;
}
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final Object [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final long [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final long [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final long [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final int [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final int [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final int [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final short [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final short [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final short [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final byte [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final byte [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final byte [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final char [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final char [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final char [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final double [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final double [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final double [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final float [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final float [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final float [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
public void append ( final StringBuffer buffer , final String fieldName , final boolean [] array , final Boolean fullDetail ) {
appendFieldStart ( buffer , fieldName ) ;
if ( array == null ) {
appendNullText ( buffer , fieldName ) ;
} else if ( isFullDetail ( fullDetail ) ) {
appendDetail ( buffer , fieldName , array ) ;
} else {
appendSummary ( buffer , fieldName , array ) ;
}
appendFieldEnd ( buffer , fieldName ) ;
}
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final boolean [] array ) {
buffer . append ( arrayStart ) ;
for ( int i = 0 ; i < array . length ; i ++ ) {
if ( i > 0 ) {
buffer . append ( arraySeparator ) ;
}
appendDetail ( buffer , fieldName , array [ i ] ) ;
}
buffer . append ( arrayEnd ) ;
}
protected void appendSummary ( final StringBuffer buffer , final String fieldName , final boolean [] array ) {
appendSummarySize ( buffer , fieldName , array . length ) ;
}
protected void appendClassName ( final StringBuffer buffer , final Object object ) {
if ( useClassName && object != null ) {
register ( object ) ;
if ( useShortClassName ) {
buffer . append ( getShortClassName ( object . getClass () ) ) ;
} else {
buffer . append ( object . getClass () . getName () ) ;
}
}
}
protected void appendIdentityHashCode ( final StringBuffer buffer , final Object object ) {
if ( this . isUseIdentityHashCode () && object != null ) {
register ( object ) ;
buffer . append ( '@' ) ;
buffer . append ( Integer . toHexString ( System . identityHashCode ( object ) ) ) ;
}
}
protected void appendContentStart ( final StringBuffer buffer ) {
buffer . append ( contentStart ) ;
}
protected void appendContentEnd ( final StringBuffer buffer ) {
buffer . append ( contentEnd ) ;
}
protected void appendNullText ( final StringBuffer buffer , final String fieldName ) {
buffer . append ( nullText ) ;
}
protected void appendFieldSeparator ( final StringBuffer buffer ) {
buffer . append ( fieldSeparator ) ;
}
protected void appendFieldStart ( final StringBuffer buffer , final String fieldName ) {
if ( useFieldNames && fieldName != null ) {
buffer . append ( fieldName ) ;
buffer . append ( fieldNameValueSeparator ) ;
}
}
protected void appendFieldEnd ( final StringBuffer buffer , final String fieldName ) {
appendFieldSeparator ( buffer ) ;
}
protected void appendSummarySize ( final StringBuffer buffer , final String fieldName , final int size ) {
buffer . append ( sizeStartText ) ;
buffer . append ( size ) ;
buffer . append ( sizeEndText ) ;
}
protected boolean isFullDetail ( final Boolean fullDetailRequest ) {
if ( fullDetailRequest == null ) {
return defaultFullDetail ;
}
return fullDetailRequest . booleanValue () ;
}
protected String getShortClassName ( final Class < ? > cls ) {
return ClassUtils . getShortClassName ( cls ) ;
}
protected boolean isUseClassName () {
return useClassName ;
}
protected void setUseClassName ( final boolean useClassName ) {
this . useClassName = useClassName ;
}
protected boolean isUseShortClassName () {
return useShortClassName ;
}
protected void setUseShortClassName ( final boolean useShortClassName ) {
this . useShortClassName = useShortClassName ;
}
protected boolean isUseIdentityHashCode () {
return useIdentityHashCode ;
}
protected void setUseIdentityHashCode ( final boolean useIdentityHashCode ) {
this . useIdentityHashCode = useIdentityHashCode ;
}
protected boolean isUseFieldNames () {
return useFieldNames ;
}
protected void setUseFieldNames ( final boolean useFieldNames ) {
this . useFieldNames = useFieldNames ;
}
protected boolean isDefaultFullDetail () {
return defaultFullDetail ;
}
protected void setDefaultFullDetail ( final boolean defaultFullDetail ) {
this . defaultFullDetail = defaultFullDetail ;
}
protected boolean isArrayContentDetail () {
return arrayContentDetail ;
}
protected void setArrayContentDetail ( final boolean arrayContentDetail ) {
this . arrayContentDetail = arrayContentDetail ;
}
protected String getArrayStart () {
return arrayStart ;
}
protected void setArrayStart ( String arrayStart ) {
if ( arrayStart == null ) {
arrayStart = lr_1 ;
}
this . arrayStart = arrayStart ;
}
protected String getArrayEnd () {
return arrayEnd ;
}
protected void setArrayEnd ( String arrayEnd ) {
if ( arrayEnd == null ) {
arrayEnd = lr_1 ;
}
this . arrayEnd = arrayEnd ;
}
protected String getArraySeparator () {
return arraySeparator ;
}
protected void setArraySeparator ( String arraySeparator ) {
if ( arraySeparator == null ) {
arraySeparator = lr_1 ;
}
this . arraySeparator = arraySeparator ;
}
protected String getContentStart () {
return contentStart ;
}
protected void setContentStart ( String contentStart ) {
if ( contentStart == null ) {
contentStart = lr_1 ;
}
this . contentStart = contentStart ;
}
protected String getContentEnd () {
return contentEnd ;
}
protected void setContentEnd ( String contentEnd ) {
if ( contentEnd == null ) {
contentEnd = lr_1 ;
}
this . contentEnd = contentEnd ;
}
protected String getFieldNameValueSeparator () {
return fieldNameValueSeparator ;
}
protected void setFieldNameValueSeparator ( String fieldNameValueSeparator ) {
if ( fieldNameValueSeparator == null ) {
fieldNameValueSeparator = lr_1 ;
}
this . fieldNameValueSeparator = fieldNameValueSeparator ;
}
protected String getFieldSeparator () {
return fieldSeparator ;
}
protected void setFieldSeparator ( String fieldSeparator ) {
if ( fieldSeparator == null ) {
fieldSeparator = lr_1 ;
}
this . fieldSeparator = fieldSeparator ;
}
protected boolean isFieldSeparatorAtStart () {
return fieldSeparatorAtStart ;
}
protected void setFieldSeparatorAtStart ( final boolean fieldSeparatorAtStart ) {
this . fieldSeparatorAtStart = fieldSeparatorAtStart ;
}
protected boolean isFieldSeparatorAtEnd () {
return fieldSeparatorAtEnd ;
}
protected void setFieldSeparatorAtEnd ( final boolean fieldSeparatorAtEnd ) {
this . fieldSeparatorAtEnd = fieldSeparatorAtEnd ;
}
protected String getNullText () {
return nullText ;
}
protected void setNullText ( String nullText ) {
if ( nullText == null ) {
nullText = lr_1 ;
}
this . nullText = nullText ;
}
protected String getSizeStartText () {
return sizeStartText ;
}
protected void setSizeStartText ( String sizeStartText ) {
if ( sizeStartText == null ) {
sizeStartText = lr_1 ;
}
this . sizeStartText = sizeStartText ;
}
protected String getSizeEndText () {
return sizeEndText ;
}
protected void setSizeEndText ( String sizeEndText ) {
if ( sizeEndText == null ) {
sizeEndText = lr_1 ;
}
this . sizeEndText = sizeEndText ;
}
protected String getSummaryObjectStartText () {
return summaryObjectStartText ;
}
protected void setSummaryObjectStartText ( String summaryObjectStartText ) {
if ( summaryObjectStartText == null ) {
summaryObjectStartText = lr_1 ;
}
this . summaryObjectStartText = summaryObjectStartText ;
}
protected String getSummaryObjectEndText () {
return summaryObjectEndText ;
}
protected void setSummaryObjectEndText ( String summaryObjectEndText ) {
if ( summaryObjectEndText == null ) {
summaryObjectEndText = lr_1 ;
}
this . summaryObjectEndText = summaryObjectEndText ;
}
private Object readResolve () {
return ToStringStyle . DEFAULT_STYLE ;
}
private Object readResolve () {
return ToStringStyle . NO_FIELD_NAMES_STYLE ;
}
private Object readResolve () {
return ToStringStyle . SHORT_PREFIX_STYLE ;
}
private Object readResolve () {
return ToStringStyle . SIMPLE_STYLE ;
}
private Object readResolve () {
return ToStringStyle . MULTI_LINE_STYLE ;
}
private Object readResolve () {
return ToStringStyle . NO_CLASS_NAME_STYLE ;
}
@Override
public void append ( StringBuffer buffer , String fieldName ,
Object [] array , Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName , long [] array ,
Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName , int [] array ,
Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName ,
short [] array , Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName , byte [] array ,
Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName , char [] array ,
Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName ,
double [] array , Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName ,
float [] array , Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName ,
boolean [] array , Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException (
lr_3 ) ;
}
super . append ( buffer , fieldName , array , fullDetail ) ;
}
@Override
public void append ( StringBuffer buffer , String fieldName , Object value ,
Boolean fullDetail ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
if ( ! isFullDetail ( fullDetail ) ) {
throw new UnsupportedOperationException ( MST[VoidMethodCallMutator]MSP[N]
lr_3 ) ;
}
super . append ( buffer , fieldName , value , fullDetail ) ;
}
@Override
protected void appendDetail ( StringBuffer buffer , String fieldName , char value ) {
appendValueAsString ( buffer , String . valueOf ( value ) ) ;
}
@Override
protected void appendDetail ( StringBuffer buffer , String fieldName , Object value ) {
if ( value == null ) {
appendNullText ( buffer , fieldName ) ;
return;
}
if ( value instanceof String || value instanceof Character ) {
appendValueAsString ( buffer , value . toString () ) ;
return;
}
if ( value instanceof Number || value instanceof Boolean ) {
buffer . append ( value ) ;
return;
}
final String valueAsString = value . toString () ;
if ( isJsonObject ( valueAsString ) || isJsonArray ( valueAsString ) ) {
buffer . append ( value ) ;
return;
}
appendDetail ( buffer , fieldName , valueAsString ) ;
}
private boolean isJsonArray ( String valueAsString ) {
return valueAsString . startsWith ( getArrayStart () )
&& valueAsString . startsWith ( getArrayEnd () ) ;
}
private boolean isJsonObject ( String valueAsString ) {
return valueAsString . startsWith ( getContentStart () )
&& valueAsString . endsWith ( getContentEnd () ) ;
}
private void appendValueAsString ( StringBuffer buffer , String value ) {
buffer . append ( lr_4 + value + lr_4 ) ;
}
@Override
protected void appendFieldStart ( StringBuffer buffer , String fieldName ) {
if ( fieldName == null ) {
throw new UnsupportedOperationException (
lr_2 ) ;
}
super . appendFieldStart ( buffer , FIELD_NAME_PREFIX + fieldName
+ FIELD_NAME_PREFIX ) ;
}
private Object readResolve () {
return ToStringStyle . JSON_STYLE ;
}
