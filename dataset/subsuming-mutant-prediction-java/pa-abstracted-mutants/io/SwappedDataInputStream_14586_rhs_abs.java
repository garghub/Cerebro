@Override
public boolean readBoolean ()
throws IOException , EOFException
{
return 0 != readByte () ;
}
@Override
public byte readByte ()
throws IOException , EOFException
{
return ( byte ) in . read () ;
}
@Override
public char readChar ()
throws IOException , EOFException
{
return ( char ) readShort () ;
}
@Override
public double readDouble ()
throws IOException , EOFException
{
return EndianUtils . readSwappedDouble ( in ) ;
}
@Override
public float readFloat ()
throws IOException , EOFException
{
return EndianUtils . readSwappedFloat ( in ) ;
}
@Override
public void readFully ( final byte [] data )
throws IOException , EOFException
{
readFully ( data , 0 , data . length ) ;
}
@Override
public void readFully ( final byte [] data , final int offset , final int length )
throws IOException , EOFException
{
int remaining = length ;
while( remaining > 0 )
{
final int location = offset + length - remaining ;
final int count = read ( data , location , remaining ) ;
if ( EOF == count )
{
throw new EOFException () ;
}
remaining -= count ;
}
}
@Override
public int readInt ()
throws IOException , EOFException
{
return EndianUtils . readSwappedInteger ( in ) ;
}
@Override
public String readLine ()
throws IOException , EOFException
{
throw new UnsupportedOperationException (
lr_1 ) ;
}
@Override
public long readLong ()
throws IOException , EOFException
{
return EndianUtils . readSwappedLong ( in ) ;
}
@Override
public short readShort ()
throws IOException , EOFException
{
return EndianUtils . readSwappedShort ( in ) ;
}
@Override
public int readUnsignedByte ()
throws IOException , EOFException
{
return in . read () ;
}
@Override
public int readUnsignedShort ()
throws IOException , EOFException
{
return EndianUtils . readSwappedUnsignedShort ( in ) ; MST[PrimitiveReturnsMutator]MSP[S]
}
@Override
public String readUTF ()
throws IOException , EOFException
{
throw new UnsupportedOperationException (
lr_2 ) ;
}
@Override
public int skipBytes ( final int count )
throws IOException , EOFException
{
return ( int ) in . skip ( count ) ;
}
