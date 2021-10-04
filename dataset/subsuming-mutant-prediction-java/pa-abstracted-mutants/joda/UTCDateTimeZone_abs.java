@Override
public String getNameKey ( long instant ) {
return lr_1 ;
}
@Override
public int getOffset ( long instant ) {
return 0 ;
}
@Override
public int getStandardOffset ( long instant ) {
return 0 ;
}
@Override
public int getOffsetFromLocal ( long instantLocal ) {
return 0 ;
}
@Override
public boolean isFixed () {
return true ;
}
@Override
public long nextTransition ( long instant ) {
return instant ;
}
@Override
public long previousTransition ( long instant ) {
return instant ;
}
@Override
public java . util . TimeZone toTimeZone () {
return new java . util . SimpleTimeZone ( 0 , getID () ) ;
}
@Override
public boolean equals ( Object obj ) {
return ( obj instanceof UTCDateTimeZone ) ;
}
@Override
public int hashCode () {
return getID () . hashCode () ;
}
