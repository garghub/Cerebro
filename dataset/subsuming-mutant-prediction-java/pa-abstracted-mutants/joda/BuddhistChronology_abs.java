public static BuddhistChronology getInstanceUTC () {
return INSTANCE_UTC ;
}
public static BuddhistChronology getInstance () {
return getInstance ( DateTimeZone . getDefault () ) ;
}
public static BuddhistChronology getInstance ( DateTimeZone zone ) {
if ( zone == null ) {
zone = DateTimeZone . getDefault () ;
}
BuddhistChronology chrono = cCache . get ( zone ) ;
if ( chrono == null ) {
chrono = new BuddhistChronology ( GJChronology . getInstance ( zone , null ) , null ) ;
DateTime lowerLimit = new DateTime ( 1 , 1 , 1 , 0 , 0 , 0 , 0 , chrono ) ;
chrono = new BuddhistChronology ( LimitChronology . getInstance ( chrono , lowerLimit , null ) , lr_1 ) ;
BuddhistChronology oldChrono = cCache . putIfAbsent ( zone , chrono ) ;
if ( oldChrono != null ) {
chrono = oldChrono ;
}
}
return chrono ;
}
private Object readResolve () {
Chronology base = getBase () ;
return base == null ? getInstanceUTC () : getInstance ( base . getZone () ) ;
}
public Chronology withUTC () {
return INSTANCE_UTC ;
}
public Chronology withZone ( DateTimeZone zone ) {
if ( zone == null ) {
zone = DateTimeZone . getDefault () ;
}
if ( zone == getZone () ) {
return this ;
}
return getInstance ( zone ) ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof BuddhistChronology ) {
BuddhistChronology chrono = ( BuddhistChronology ) obj ;
return getZone () . equals ( chrono . getZone () ) ;
}
return false ;
}
public int hashCode () {
return lr_2 . hashCode () * 11 + getZone () . hashCode () ;
}
public String toString () {
String str = lr_3 ;
DateTimeZone zone = getZone () ;
if ( zone != null ) {
str = str + '[' + zone . getID () + ']' ;
}
return str ;
}
protected void assemble ( Fields fields ) {
if ( getParam () == null ) {
fields . eras = UnsupportedDurationField . getInstance ( DurationFieldType . eras () ) ;
DateTimeField field = fields . year ;
fields . year = new OffsetDateTimeField (
new SkipUndoDateTimeField ( this , field ) , BUDDHIST_OFFSET ) ;
field = fields . yearOfEra ;
fields . yearOfEra = new DelegatedDateTimeField (
fields . year , fields . eras , DateTimeFieldType . yearOfEra () ) ;
field = fields . weekyear ;
fields . weekyear = new OffsetDateTimeField (
new SkipUndoDateTimeField ( this , field ) , BUDDHIST_OFFSET ) ;
field = new OffsetDateTimeField ( fields . yearOfEra , 99 ) ;
fields . centuryOfEra = new DividedDateTimeField (
field , fields . eras , DateTimeFieldType . centuryOfEra () , 100 ) ;
fields . centuries = fields . centuryOfEra . getDurationField () ;
field = new RemainderDateTimeField (
( DividedDateTimeField ) fields . centuryOfEra ) ;
fields . yearOfCentury = new OffsetDateTimeField (
field , DateTimeFieldType . yearOfCentury () , 1 ) ;
field = new RemainderDateTimeField (
fields . weekyear , fields . centuries , DateTimeFieldType . weekyearOfCentury () , 100 ) ;
fields . weekyearOfCentury = new OffsetDateTimeField (
field , DateTimeFieldType . weekyearOfCentury () , 1 ) ;
fields . era = ERA_FIELD ;
}
}
