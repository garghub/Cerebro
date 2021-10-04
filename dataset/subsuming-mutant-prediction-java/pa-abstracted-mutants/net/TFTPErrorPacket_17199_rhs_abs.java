@Override
DatagramPacket _newDatagram ( final DatagramPacket datagram , final byte [] data )
{
int length ;
length = message . length () ;
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
data [ 2 ] = (byte)( ( error & 0xffff ) >> 8 ) ;
data [ 3 ] = (byte)( error & 0xff ) ;
System . arraycopy ( message . getBytes () , 0 , data , 4 , length ) ;
data [ length + 4 ] = 0 ;
datagram . setAddress ( address ) ;
datagram . setPort ( port ) ;
datagram . setData ( data ) ;
datagram . setLength ( length + 4 ) ;
return datagram ;
}
@Override
public DatagramPacket newDatagram ()
{
byte [] data ;
int length ;
length = message . length () ;
data = new byte [ length + 5 ] ;
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
data [ 2 ] = (byte)( ( error & 0xffff ) >> 8 ) ;
data [ 3 ] = (byte)( error & 0xff ) ; MST[rv.CRCR1Mutator]MSP[N]
System . arraycopy ( message . getBytes () , 0 , data , 4 , length ) ;
data [ length + 4 ] = 0 ;
return new DatagramPacket ( data , data . length , address , port ) ;
}
public int getError ()
{
return error ;
}
public String getMessage ()
{
return message ;
}
@Override
public String toString () {
return super . toString () + lr_1 + error + lr_2 + message ;
}
