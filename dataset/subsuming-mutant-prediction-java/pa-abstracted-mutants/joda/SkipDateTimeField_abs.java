public int get ( long millis ) {
int value = super . get ( millis ) ;
if ( value <= iSkip ) {
value -- ;
}
return value ;
}
public long set ( long millis , int value ) {
FieldUtils . verifyValueBounds ( this , value , iMinValue , getMaximumValue () ) ;
if ( value <= iSkip ) {
if ( value == iSkip ) {
throw new IllegalFieldValueException
( DateTimeFieldType . year () , Integer . valueOf ( value ) , null , null ) ;
}
value ++ ;
}
return super . set ( millis , value ) ;
}
public int getMinimumValue () {
return iMinValue ;
}
private Object readResolve () {
return getType () . getField ( iChronology ) ;
}
