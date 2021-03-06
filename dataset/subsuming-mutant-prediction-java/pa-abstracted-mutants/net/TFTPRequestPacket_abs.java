@Override
final DatagramPacket _newDatagram ( final DatagramPacket datagram , final byte [] data )
{
int fileLength , modeLength ;
fileLength = fileName . length () ;
modeLength = modeBytes [ mode ] . length ;
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
System . arraycopy ( fileName . getBytes () , 0 , data , 2 , fileLength ) ;
data [ fileLength + 2 ] = 0 ;
System . arraycopy ( modeBytes [ mode ] , 0 , data , fileLength + 3 ,
modeLength ) ;
datagram . setAddress ( address ) ;
datagram . setPort ( port ) ;
datagram . setData ( data ) ;
datagram . setLength ( fileLength + modeLength + 3 ) ;
return datagram ;
}
@Override
public final DatagramPacket newDatagram ()
{
int fileLength , modeLength ;
byte [] data ;
fileLength = fileName . length () ;
modeLength = modeBytes [ mode ] . length ;
data = new byte [ fileLength + modeLength + 4 ] ;
data [ 0 ] = 0 ;
data [ 1 ] = ( byte ) type ;
System . arraycopy ( fileName . getBytes () , 0 , data , 2 , fileLength ) ;
data [ fileLength + 2 ] = 0 ;
System . arraycopy ( modeBytes [ mode ] , 0 , data , fileLength + 3 ,
modeLength ) ;
return new DatagramPacket ( data , data . length , address , port ) ;
}
public final int getMode ()
{
return mode ;
}
public final String getFilename ()
{
return fileName ;
}
