@Override
DatagramPacket _newDatagram ( final DatagramPacket datagram , final byte [] data )
{
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
data [ 2 ] = (byte)( ( blockNumber & 0xffff ) >> 8 ) ;
data [ 3 ] = (byte)( blockNumber & 0xff ) ;
datagram . setAddress ( address ) ;
datagram . setPort ( port ) ;
datagram . setData ( data ) ;
datagram . setLength ( 4 ) ;
return datagram ;
}
@Override
public DatagramPacket newDatagram ()
{
byte [] data ;
data = new byte [ 4 ] ;
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
data [ 2 ] = (byte)( ( blockNumber & 0xffff ) >> 8 ) ;
data [ 3 ] = (byte)( blockNumber & 0xff ) ;
return new DatagramPacket ( data , data . length , address , port ) ;
}
public int getBlockNumber ()
{
return blockNumber ;
}
public void setBlockNumber ( final int blockNumber )
{
this . blockNumber = blockNumber ;
}
@Override
public String toString () {
return super . toString () + lr_1 + blockNumber ;
}
