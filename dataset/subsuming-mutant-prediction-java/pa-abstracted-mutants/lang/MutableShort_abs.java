@Override
public Short getValue () {
return Short . valueOf ( this . value ) ;
}
public void setValue ( final short value ) {
this . value = value ;
}
@Override
public void setValue ( final Number value ) {
this . value = value . shortValue () ;
}
public void increment () {
value ++ ;
}
public void decrement () {
value -- ;
}
public void add ( final short operand ) {
this . value += operand ;
}
public void add ( final Number operand ) {
this . value += operand . shortValue () ;
}
public void subtract ( final short operand ) {
this . value -= operand ;
}
public void subtract ( final Number operand ) {
this . value -= operand . shortValue () ;
}
@Override
public short shortValue () {
return value ;
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
public Short toShort () {
return Short . valueOf ( shortValue () ) ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof MutableShort ) {
return value == ( ( MutableShort ) obj ) . shortValue () ;
}
return false ;
}
@Override
public int hashCode () {
return value ;
}
@Override
public int compareTo ( final MutableShort other ) {
return NumberUtils . compare ( this . value , other . value ) ;
}
@Override
public String toString () {
return String . valueOf ( value ) ;
}
