public String getNameKey ( long instant ) {
return iNameKey ;
}
public int getOffset ( long instant ) {
return iWallOffset ;
}
public int getStandardOffset ( long instant ) {
return iStandardOffset ;
}
public int getOffsetFromLocal ( long instantLocal ) {
return iWallOffset ;
}
public boolean isFixed () {
return true ;
}
public long nextTransition ( long instant ) {
return instant ;
}
public long previousTransition ( long instant ) {
return instant ;
}
public java . util . TimeZone toTimeZone () {
String id = getID () ;
if ( id . length () == 6 && ( id . startsWith ( lr_1 ) || id . startsWith ( lr_2 ) ) ) {
return java . util . TimeZone . getTimeZone ( lr_3 + getID () ) ;
}
return new java . util . SimpleTimeZone ( iWallOffset , getID () ) ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof FixedDateTimeZone ) {
FixedDateTimeZone other = ( FixedDateTimeZone ) obj ;
return
getID () . equals ( other . getID () ) &&
iStandardOffset == other . iStandardOffset &&
iWallOffset == other . iWallOffset ;
}
return false ;
}
public int hashCode () {
return getID () . hashCode () + 37 * iStandardOffset + 31 * iWallOffset ;
}
