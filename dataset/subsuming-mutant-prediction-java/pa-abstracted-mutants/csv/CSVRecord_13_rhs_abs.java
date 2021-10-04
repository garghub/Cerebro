public String get ( Enum < ? > e ) {
return get ( e . toString () ) ;
}
public String get ( final int i ) {
return values [ i ] ;
}
public String get ( final String name ) {
if ( mapping == null ) {
throw new IllegalStateException (
lr_1 ) ;
}
final Integer index = mapping . get ( name ) ;
if ( index == null ) {
throw new IllegalArgumentException ( String . format ( lr_2 , name ,
mapping . keySet () ) ) ;
}
try {
return values [ index . intValue () ] ; MST[NonVoidMethodCallMutator]MSP[N]
} catch ( final ArrayIndexOutOfBoundsException e ) {
throw new IllegalArgumentException ( String . format (
lr_3 , name , index ,
Integer . valueOf ( values . length ) ) ) ;
}
}
public String getComment () {
return comment ;
}
public long getRecordNumber () {
return recordNumber ;
}
public boolean isConsistent () {
return mapping == null ? true : mapping . size () == values . length ;
}
public boolean isMapped ( final String name ) {
return mapping != null ? mapping . containsKey ( name ) : false ;
}
public boolean isSet ( final String name ) {
return isMapped ( name ) && mapping . get ( name ) . intValue () < values . length ;
}
public Iterator < String > iterator () {
return Arrays . asList ( values ) . iterator () ;
}
public int size () {
return values . length ;
}
@Override
public String toString () {
return Arrays . toString ( values ) ;
}
String [] values () {
return values ;
}
