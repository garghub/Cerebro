private static boolean isLineBreak ( final char c ) {
return c == LF || c == CR ;
}
private static boolean isLineBreak ( final Character c ) {
return c != null && isLineBreak ( c . charValue () ) ; MST[rv.ROR2Mutator]MSP[]
}
public static CSVFormat newFormat ( final char delimiter ) {
return new CSVFormat ( delimiter , null , null , null , null , false , false , null , null , null , false ) ;
}
@Override
public boolean equals ( final Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj == null ) {
return false ;
}
if ( getClass () != obj . getClass () ) {
return false ;
}
final CSVFormat other = ( CSVFormat ) obj ;
if ( delimiter != other . delimiter ) {
return false ;
}
if ( quotePolicy != other . quotePolicy ) {
return false ;
}
if ( quoteChar == null ) {
if ( other . quoteChar != null ) {
return false ;
}
} else if ( ! quoteChar . equals ( other . quoteChar ) ) {
return false ;
}
if ( commentStart == null ) {
if ( other . commentStart != null ) {
return false ;
}
} else if ( ! commentStart . equals ( other . commentStart ) ) {
return false ;
}
if ( escape == null ) {
if ( other . escape != null ) {
return false ;
}
} else if ( ! escape . equals ( other . escape ) ) {
return false ;
}
if ( ! Arrays . equals ( header , other . header ) ) {
return false ;
}
if ( ignoreSurroundingSpaces != other . ignoreSurroundingSpaces ) {
return false ;
}
if ( ignoreEmptyLines != other . ignoreEmptyLines ) {
return false ;
}
if ( recordSeparator == null ) {
if ( other . recordSeparator != null ) {
return false ;
}
} else if ( ! recordSeparator . equals ( other . recordSeparator ) ) {
return false ;
}
return true ;
}
public String format ( final Object ... values ) {
final StringWriter out = new StringWriter () ;
try {
new CSVPrinter ( out , this ) . printRecord ( values ) ;
return out . toString () . trim () ;
} catch ( final IOException e ) {
throw new IllegalStateException ( e ) ;
}
}
public Character getCommentStart () {
return commentStart ;
}
public char getDelimiter () {
return delimiter ;
}
public Character getEscape () {
return escape ;
}
public String [] getHeader () {
return header != null ? header . clone () : null ;
}
public boolean getIgnoreEmptyLines () {
return ignoreEmptyLines ;
}
public boolean getIgnoreSurroundingSpaces () {
return ignoreSurroundingSpaces ;
}
public String getNullString () {
return nullString ;
}
public Character getQuoteChar () {
return quoteChar ;
}
public Quote getQuotePolicy () {
return quotePolicy ;
}
public String getRecordSeparator () {
return recordSeparator ;
}
public boolean getSkipHeaderRecord () {
return skipHeaderRecord ;
}
@Override
public int hashCode ()
{
final int prime = 31 ;
int result = 1 ;
result = prime * result + delimiter ;
result = prime * result + ( ( quotePolicy == null ) ? 0 : quotePolicy . hashCode () ) ;
result = prime * result + ( ( quoteChar == null ) ? 0 : quoteChar . hashCode () ) ;
result = prime * result + ( ( commentStart == null ) ? 0 : commentStart . hashCode () ) ;
result = prime * result + ( ( escape == null ) ? 0 : escape . hashCode () ) ;
result = prime * result + ( ignoreSurroundingSpaces ? 1231 : 1237 ) ;
result = prime * result + ( ignoreEmptyLines ? 1231 : 1237 ) ;
result = prime * result + ( ( recordSeparator == null ) ? 0 : recordSeparator . hashCode () ) ;
result = prime * result + Arrays . hashCode ( header ) ;
return result ;
}
public boolean isCommentingEnabled () {
return commentStart != null ;
}
public boolean isEscaping () {
return escape != null ;
}
public boolean isNullHandling () {
return nullString != null ;
}
public boolean isQuoting () {
return quoteChar != null ;
}
public CSVParser parse ( final Reader in ) throws IOException {
return new CSVParser ( in , this ) ;
}
@Override
public String toString () {
final StringBuilder sb = new StringBuilder () ;
sb . append ( lr_1 ) . append ( delimiter ) . append ( '>' ) ;
if ( isEscaping () ) {
sb . append ( ' ' ) ;
sb . append ( lr_2 ) . append ( escape ) . append ( '>' ) ;
}
if ( isQuoting () ) {
sb . append ( ' ' ) ;
sb . append ( lr_3 ) . append ( quoteChar ) . append ( '>' ) ;
}
if ( isCommentingEnabled () ) {
sb . append ( ' ' ) ;
sb . append ( lr_4 ) . append ( commentStart ) . append ( '>' ) ;
}
if ( isNullHandling () ) {
sb . append ( ' ' ) ;
sb . append ( lr_5 ) . append ( nullString ) . append ( '>' ) ;
}
if( recordSeparator != null ) {
sb . append ( ' ' ) ;
sb . append ( lr_6 ) . append ( recordSeparator ) . append ( '>' ) ;
}
if ( getIgnoreEmptyLines () ) {
sb . append ( lr_7 ) ;
}
if ( getIgnoreSurroundingSpaces () ) {
sb . append ( lr_8 ) ;
}
sb . append ( lr_9 ) . append ( skipHeaderRecord ) ;
if ( header != null ) {
sb . append ( ' ' ) ;
sb . append ( lr_10 ) . append ( Arrays . toString ( header ) ) ;
}
return sb . toString () ;
}
void validate () throws IllegalStateException {
if ( quoteChar != null && delimiter == quoteChar . charValue () ) {
throw new IllegalStateException (
lr_11 + quoteChar + lr_12 ) ;
}
if ( escape != null && delimiter == escape . charValue () ) {
throw new IllegalStateException (
lr_13 + escape + lr_12 ) ;
}
if ( commentStart != null && delimiter == commentStart . charValue () ) {
throw new IllegalStateException (
lr_14 + commentStart + lr_12 ) ;
}
if ( quoteChar != null && quoteChar . equals ( commentStart ) ) {
throw new IllegalStateException (
lr_15 + commentStart + lr_12 ) ;
}
if ( escape != null && escape . equals ( commentStart ) ) {
throw new IllegalStateException (
lr_16 + commentStart + lr_12 ) ;
}
if ( escape == null && quotePolicy == Quote . NONE ) {
throw new IllegalStateException ( lr_17 ) ;
}
if ( header != null ) {
final Set < String > set = new HashSet < String > ( header . length ) ;
set . addAll ( Arrays . asList ( header ) ) ;
if ( set . size () != header . length ) {
throw new IllegalStateException ( lr_18 + Arrays . toString ( header ) ) ;
}
}
}
public CSVFormat withCommentStart ( final char commentStart ) {
return withCommentStart ( Character . valueOf ( commentStart ) ) ;
}
public CSVFormat withCommentStart ( final Character commentStart ) {
if ( isLineBreak ( commentStart ) ) {
throw new IllegalArgumentException ( lr_19 ) ;
}
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withDelimiter ( final char delimiter ) {
if ( isLineBreak ( delimiter ) ) {
throw new IllegalArgumentException ( lr_20 ) ;
}
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withEscape ( final char escape ) {
return withEscape ( Character . valueOf ( escape ) ) ;
}
public CSVFormat withEscape ( final Character escape ) {
if ( isLineBreak ( escape ) ) {
throw new IllegalArgumentException ( lr_21 ) ;
}
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withHeader ( final String ... header ) {
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withIgnoreEmptyLines ( final boolean ignoreEmptyLines ) {
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withIgnoreSurroundingSpaces ( final boolean ignoreSurroundingSpaces ) {
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withNullString ( final String nullString ) {
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withQuoteChar ( final char quoteChar ) {
return withQuoteChar ( Character . valueOf ( quoteChar ) ) ;
}
public CSVFormat withQuoteChar ( final Character quoteChar ) {
if ( isLineBreak ( quoteChar ) ) {
throw new IllegalArgumentException ( lr_22 ) ;
}
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withQuotePolicy ( final Quote quotePolicy ) {
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withRecordSeparator ( final char recordSeparator ) {
return withRecordSeparator ( String . valueOf ( recordSeparator ) ) ;
}
public CSVFormat withRecordSeparator ( final String recordSeparator ) {
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
public CSVFormat withSkipHeaderRecord ( final boolean skipHeaderRecord ) {
return new CSVFormat ( delimiter , quoteChar , quotePolicy , commentStart , escape ,
ignoreSurroundingSpaces , ignoreEmptyLines , recordSeparator , nullString , header , skipHeaderRecord ) ;
}
