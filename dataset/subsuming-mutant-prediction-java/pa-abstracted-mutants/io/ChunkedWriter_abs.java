@Override
public void write ( final char [] data , final int srcOffset , final int length ) throws IOException {
int bytes = length ;
int dstOffset = srcOffset ;
while( bytes > 0 ) {
final int chunk = Math . min ( bytes , chunkSize ) ;
out . write ( data , dstOffset , chunk ) ;
bytes -= chunk ;
dstOffset += chunk ;
}
}
