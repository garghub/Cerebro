@Test
public void testToNetASCIIInputStream1 () throws Exception
{
byteTest ( false , lr_1 , lr_1 ) ;
byteTest ( false , lr_2 , lr_2 ) ;
byteTest ( false , lr_3 , lr_3 ) ;
byteTest ( false , lr_4 , lr_5 ) ;
byteTest ( false , lr_5 , lr_5 ) ;
byteTest ( false , lr_6 , lr_7 ) ;
byteTest ( false , lr_8 , lr_9 ) ;
byteTest ( false , lr_10 , lr_9 ) ;
byteTest ( false , lr_11 , lr_12 ) ;
}
@Test
public void testToNetASCIIInputStream_single_bytes () throws Exception
{
byteTest ( true , lr_1 , lr_1 ) ;
byteTest ( true , lr_2 , lr_2 ) ;
byteTest ( true , lr_6 , lr_7 ) ;
byteTest ( true , lr_3 , lr_3 ) ;
byteTest ( true , lr_4 , lr_5 ) ;
byteTest ( true , lr_5 , lr_5 ) ;
byteTest ( true , lr_8 , lr_9 ) ;
byteTest ( true , lr_10 , lr_9 ) ;
byteTest ( true , lr_11 , lr_12 ) ;
}
private void byteTest ( final boolean byByte , final String input , final String expect ) throws IOException {
final byte [] data = input . getBytes ( ASCII ) ;
final byte [] expected = expect . getBytes ( ASCII ) ;
final InputStream source = new ByteArrayInputStream ( data ) ;
try ( final ToNetASCIIInputStream toNetASCII = new ToNetASCIIInputStream ( source ) ) {
final byte [] output = new byte [ data . length * 2 ] ;
final int length = byByte ? getSingleBytes ( toNetASCII , output ) : getBuffer ( toNetASCII , output ) ;
final byte [] result = new byte [ length ] ;
System . arraycopy ( output , 0 , result , 0 , length ) ;
Assert . assertArrayEquals ( lr_13 + input , expected , result ) ;
}
}
private int getSingleBytes ( final ToNetASCIIInputStream toNetASCII , final byte [] output )
throws IOException {
int b ;
int length = 0 ;
while( ( b = toNetASCII . read () ) != - 1 ) {
output [ length ++ ] = ( byte ) b ;
}
return length ;
}
private int getBuffer ( final ToNetASCIIInputStream toNetASCII , final byte [] output )
throws IOException {
int length = 0 ;
int remain = output . length ;
int chunk ;
int offset = 0 ;
while( remain > 0 && ( chunk = toNetASCII . read ( output , offset , remain ) ) != - 1 ) {
length += chunk ;
offset += chunk ;
remain -= chunk ;
}
return length ;
}
