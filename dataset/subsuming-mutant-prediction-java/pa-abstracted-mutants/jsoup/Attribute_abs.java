public String getKey () {
return key ;
}
public void setKey ( String key ) {
Validate . notNull ( key ) ;
key = key . trim () ;
Validate . notEmpty ( key ) ;
if ( parent != null ) {
int i = parent . indexOfKey ( this . key ) ;
if ( i != Attributes . NotFound )
parent . keys [ i ] = key ;
}
this . key = key ;
}
public String getValue () {
return Attributes . checkNotNull ( val ) ;
}
public boolean hasDeclaredValue () {
return val != null ;
}
public String setValue ( String val ) {
String oldVal = this . val ;
if ( parent != null ) {
oldVal = parent . get ( this . key ) ;
int i = parent . indexOfKey ( this . key ) ;
if ( i != Attributes . NotFound )
parent . vals [ i ] = val ;
}
this . val = val ;
return Attributes . checkNotNull ( oldVal ) ;
}
public String html () {
StringBuilder sb = StringUtil . borrowBuilder () ;
try {
html ( sb , ( new Document ( lr_1 ) ) . outputSettings () ) ;
} catch( IOException exception ) {
throw new SerializationException ( exception ) ;
}
return StringUtil . releaseBuilder ( sb ) ;
}
protected static void html ( String key , String val , Appendable accum , Document . OutputSettings out ) throws IOException {
accum . append ( key ) ;
if ( ! shouldCollapseAttribute ( key , val , out ) ) {
accum . append ( lr_2 ) ;
Entities . escape ( accum , Attributes . checkNotNull ( val ) , out , true , false , false ) ;
accum . append ( '"' ) ;
}
}
protected void html ( Appendable accum , Document . OutputSettings out ) throws IOException {
html ( key , val , accum , out ) ;
}
@Override
public String toString () {
return html () ;
}
public static Attribute createFromEncoded ( String unencodedKey , String encodedValue ) {
String value = Entities . unescape ( encodedValue , true ) ;
return new Attribute ( unencodedKey , value , null ) ;
}
protected boolean isDataAttribute () {
return isDataAttribute ( key ) ;
}
protected static boolean isDataAttribute ( String key ) {
return key . startsWith ( Attributes . dataPrefix ) && key . length () > Attributes . dataPrefix . length () ;
}
protected final boolean shouldCollapseAttribute ( Document . OutputSettings out ) {
return shouldCollapseAttribute ( key , val , out ) ;
}
protected static boolean shouldCollapseAttribute ( final String key , final String val , final Document . OutputSettings out ) {
return (
out . syntax () == Document . OutputSettings . Syntax . html &&
( val == null || ( lr_1 . equals ( val ) || val . equalsIgnoreCase ( key ) ) && Attribute . isBooleanAttribute ( key ) ) ) ;
}
protected static boolean isBooleanAttribute ( final String key ) {
return Arrays . binarySearch ( booleanAttributes , key ) >= 0 ;
}
@Override
public boolean equals ( Object o ) {
if ( this == o ) return true ;
if ( o == null || getClass () != o . getClass () ) return false ;
Attribute attribute = ( Attribute ) o ;
if ( key != null ? ! key . equals ( attribute . key ) : attribute . key != null ) return false ;
return val != null ? val . equals ( attribute . val ) : attribute . val == null ;
}
@Override
public int hashCode () {
int result = key != null ? key . hashCode () : 0 ;
result = 31 * result + ( val != null ? val . hashCode () : 0 ) ;
return result ;
}
@Override
public Attribute clone () {
try {
return ( Attribute ) super . clone () ;
} catch ( CloneNotSupportedException e ) {
throw new RuntimeException ( e ) ;
}
}
