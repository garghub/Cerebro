public long subtract ( long instant , int value ) {
if ( value == Integer . MIN_VALUE ) {
return subtract ( instant , ( long ) value ) ;
}
return add ( instant , - value ) ;
}
public long subtract ( long instant , long value ) {
if ( value == Long . MIN_VALUE ) {
throw new ArithmeticException ( lr_1 ) ;
}
return add ( instant , - value ) ;
}
