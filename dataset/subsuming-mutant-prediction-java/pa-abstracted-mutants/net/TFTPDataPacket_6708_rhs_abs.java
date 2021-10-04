@Override
DatagramPacket _newDatagram ( final DatagramPacket datagram , final byte [] data )
{
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
data [ 2 ] = (byte)( ( blockNumber & 0xffff ) >> 8 ) ;
data [ 3 ] = (byte)( blockNumber & 0xff ) ; MST[MathMutator]MSP[N]
if ( data != this . data ) {
System . arraycopy ( this . data , offset , data , 4 , length ) ;
}
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
data = new byte [ length + 4 ] ;
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
data [ 2 ] = (byte)( ( blockNumber & 0xffff ) >> 8 ) ;
data [ 3 ] = (byte)( blockNumber & 0xff ) ;
System . arraycopy ( this . data , offset , data , 4 , length ) ;
return new DatagramPacket ( data , length + 4 , address , port ) ;
}
public int getBlockNumber ()
{
return blockNumber ;
}
public void setBlockNumber ( final int blockNumber )
{
this . blockNumber = blockNumber ;
}
public void setData ( final byte [] data , final int offset , final int length )
{
this . data = data ;
this . offset = offset ;
this . length = length ;
if ( length > MAX_DATA_LENGTH ) {
this . length = MAX_DATA_LENGTH ;
} else {
this . length = length ;
}
}
public int getDataLength ()
{
return length ;
}
public int getDataOffset ()
{
return offset ;
}
public byte [] getData ()
{
return data ;
}
@Override
public String toString () {
return super . toString () + lr_1 + blockNumber + lr_2 + length ;
}
