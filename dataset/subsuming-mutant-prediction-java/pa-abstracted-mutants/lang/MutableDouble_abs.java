@Override
public Double getValue () {
return Double . valueOf ( this . value ) ;
}
public void setValue ( final double value ) {
this . value = value ;
}
@Override
public void setValue ( final Number value ) {
this . value = value . doubleValue () ;
}
public boolean isNaN () {
return Double . isNaN ( value ) ;
}
public boolean isInfinite () {
return Double . isInfinite ( value ) ;
}
public void increment () {
value ++ ;
}
public void decrement () {
value -- ;
}
public void add ( final double operand ) {
this . value += operand ;
}
public void add ( final Number operand ) {
this . value += operand . doubleValue () ;
}
public void subtract ( final double operand ) {
this . value -= operand ;
}
public void subtract ( final Number operand ) {
this . value -= operand . doubleValue () ;
}
@Override
public int intValue () {
return ( int ) value ;
}
@Override
public long longValue () {
return ( long ) value ;
}
@Override
public float floatValue () {
return ( float ) value ;
}
@Override
public double doubleValue () {
return value ;
}
public Double toDouble () {
return Double . valueOf ( doubleValue () ) ;
}
@Override
public boolean equals ( final Object obj ) {
return obj instanceof MutableDouble
&& Double . doubleToLongBits ( ( ( MutableDouble ) obj ) . value ) == Double . doubleToLongBits ( value ) ;
}
@Override
public int hashCode () {
final long bits = Double . doubleToLongBits ( value ) ;
return (int) ( bits ^ bits >>> 32 ) ;
}
@Override
public int compareTo ( final MutableDouble other ) {
return Double . compare ( this . value , other . value ) ;
}
@Override
public String toString () {
return String . valueOf ( value ) ;
}
