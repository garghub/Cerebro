public int getValue ( int index ) {
return iValues [ index ] ;
}
public int [] getValues () {
return ( int [] ) iValues . clone () ;
}
public Chronology getChronology () {
return iChronology ;
}
protected void setValue ( int index , int value ) {
DateTimeField field = getField ( index ) ;
int [] values = field . set ( this , index , iValues , value ) ;
System . arraycopy ( values , 0 , iValues , 0 , iValues . length ) ;
}
protected void setValues ( int [] values ) {
getChronology () . validate ( this , values ) ;
System . arraycopy ( values , 0 , iValues , 0 , iValues . length ) ;
}
public String toString ( String pattern ) {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . print ( this ) ;
}
public String toString ( String pattern , Locale locale ) throws IllegalArgumentException {
if ( pattern == null ) {
return toString () ;
}
return DateTimeFormat . forPattern ( pattern ) . withLocale ( locale ) . print ( this ) ;
}
