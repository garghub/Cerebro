public final DateTimeField getWrappedField () {
return iField ;
}
public boolean isLenient () {
return iField . isLenient () ;
}
public int get ( long instant ) {
return iField . get ( instant ) ;
}
public long set ( long instant , int value ) {
return iField . set ( instant , value ) ;
}
public DurationField getDurationField () {
return iField . getDurationField () ;
}
public DurationField getRangeDurationField () {
return iField . getRangeDurationField () ;
}
public int getMinimumValue () {
return iField . getMinimumValue () ;
}
public int getMaximumValue () {
return iField . getMaximumValue () ;
}
public long roundFloor ( long instant ) {
return iField . roundFloor ( instant ) ;
}
