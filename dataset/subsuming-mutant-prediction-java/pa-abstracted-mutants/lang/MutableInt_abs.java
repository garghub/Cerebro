@Override
public Integer getValue () {
return Integer . valueOf ( this . value ) ;
}
public void setValue ( final int value ) {
this . value = value ;
}
@Override
public void setValue ( final Number value ) {
this . value = value . intValue () ;
}
public void increment () {
value ++ ;
}
public void decrement () {
value -- ;
}
public void add ( final int operand ) {
this . value += operand ;
}
public void add ( final Number operand ) {
this . value += operand . intValue () ;
}
public void subtract ( final int operand ) {
this . value -= operand ;
}
public void subtract ( final Number operand ) {
this . value -= operand . intValue () ;
}
@Override
public int intValue () {
return value ;
}
@Override
public long longValue () {
return value ;
}
@Override
public float floatValue () {
return value ;
}
@Override
public double doubleValue () {
return value ;
}
public Integer toInteger () {
return Integer . valueOf ( intValue () ) ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof MutableInt ) {
return value == ( ( MutableInt ) obj ) . intValue () ;
}
return false ;
}
@Override
public int hashCode () {
return value ;
}
@Override
public int compareTo ( final MutableInt other ) {
return NumberUtils . compare ( this . value , other . value ) ;
}
@Override
public String toString () {
return String . valueOf ( value ) ;
}
