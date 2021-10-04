static void checkArray () {
final int expectedLength = LAST + 1 ;
if ( _commands . length != expectedLength ) {
throw new RuntimeException ( lr_1
+ expectedLength + lr_2 + _commands . length ) ;
}
}
public static String getCommand ( final int command )
{
return _commands [ command ] ;
} MST[rv.UOI4Mutator]MSP[]
