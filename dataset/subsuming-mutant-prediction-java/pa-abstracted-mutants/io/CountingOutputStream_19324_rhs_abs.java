@Override
protected synchronized void beforeWrite ( final int n ) {
count += n ;
}
public int getCount () {
final long result = getByteCount () ;
if ( result > Integer . MAX_VALUE ) {
throw new ArithmeticException ( lr_1 + result + lr_2 ) ;
}
return ( int ) result ; MST[rv.UOI4Mutator]MSP[N]
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
