public static CachedDateTimeZone forZone ( DateTimeZone zone ) {
if ( zone instanceof CachedDateTimeZone ) {
return ( CachedDateTimeZone ) zone ;
}
return new CachedDateTimeZone ( zone ) ;
}
public DateTimeZone getUncachedZone () {
return iZone ;
}
public String getNameKey ( long instant ) {
return getInfo ( instant ) . getNameKey ( instant ) ;
}
public int getOffset ( long instant ) {
return getInfo ( instant ) . getOffset ( instant ) ;
}
public int getStandardOffset ( long instant ) {
return getInfo ( instant ) . getStandardOffset ( instant ) ;
}
public boolean isFixed () {
return iZone . isFixed () ;
}
public long nextTransition ( long instant ) {
return iZone . nextTransition ( instant ) ;
}
public long previousTransition ( long instant ) {
return iZone . previousTransition ( instant ) ;
}
public int hashCode () {
return iZone . hashCode () ;
}
public boolean equals ( Object obj ) {
if ( this == obj ) {
return true ;
}
if ( obj instanceof CachedDateTimeZone ) {
return iZone . equals ( ( ( CachedDateTimeZone ) obj ) . iZone ) ;
}
return false ;
}
private Info getInfo ( long millis ) {
int period = (int)( millis >> 32 ) ;
Info [] cache = iInfoCache ;
int index = period & cInfoCacheMask ;
Info info = cache [ index ] ;
if ( info == null || (int)( ( info . iPeriodStart >> 32 ) ) != period ) {
info = createInfo ( millis ) ;
cache [ index ] = info ;
}
return info ;
}
private Info createInfo ( long millis ) {
long periodStart = millis & ( 0xffffffffL << 32 ) ;
Info info = new Info ( iZone , periodStart ) ;
long end = periodStart | 0xffffffffL ;
Info chain = info ;
while ( true ) {
long next = iZone . nextTransition ( periodStart ) ;
if ( next == periodStart || next > end ) {
break;
}
periodStart = next ;
chain = ( chain . iNextInfo = new Info ( iZone , periodStart ) ) ;
}
return info ;
}
public String getNameKey ( long millis ) {
if ( iNextInfo == null || millis < iNextInfo . iPeriodStart ) {
if ( iNameKey == null ) {
iNameKey = iZoneRef . getNameKey ( iPeriodStart ) ;
}
return iNameKey ;
}
return iNextInfo . getNameKey ( millis ) ;
}
public int getOffset ( long millis ) {
if ( iNextInfo == null || millis < iNextInfo . iPeriodStart ) {
if ( iOffset == Integer . MIN_VALUE ) {
iOffset = iZoneRef . getOffset ( iPeriodStart ) ;
}
return iOffset ;
}
return iNextInfo . getOffset ( millis ) ;
}
public int getStandardOffset ( long millis ) {
if ( iNextInfo == null || millis < iNextInfo . iPeriodStart ) {
if ( iStandardOffset == Integer . MIN_VALUE ) {
iStandardOffset = iZoneRef . getStandardOffset ( iPeriodStart ) ;
}
return iStandardOffset ;
}
return iNextInfo . getStandardOffset ( millis ) ;
}
