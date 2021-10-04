@Override
protected synchronized void beforeWrite ( final int n ) {
count += n ; MST[rv.UOI1Mutator]MSP[]
}
public int getCount () {
final long result = getByteCount () ;
if ( result > Integer . MAX_VALUE ) {
throw new ArithmeticException ( lr_1 + result + lr_2 ) ;
}
return ( int ) result ;
}
public int resetCount () {
final long result = resetByteCount () ;
if ( result > Integer . MAX_VALUE ) {
throw new ArithmeticException ( lr_1 + result + lr_2 ) ;
}
return ( int ) result ;
}
public synchronized long getByteCount () {
return this . count ;
}
public synchronized long resetByteCount () {
final long tmp = this . count ;
this . count = 0 ;
return tmp ;
}
