@Override
public int compare ( final Object o1 , final Object o2 ) {
int compareCode = 0 ;
try {
@SuppressWarnings ( lr_1 )
final Comparable < Comparable < ? > > s1 = ( Comparable < Comparable < ? > > ) this . stringEncoder . encode ( o1 ) ;
final Comparable < ? > s2 = ( Comparable < ? > ) this . stringEncoder . encode ( o2 ) ;
compareCode = s1 . compareTo ( s2 ) ;
} catch ( final EncoderException ee ) {
compareCode = 0 ; MST[rv.CRCR3Mutator]MSP[]
}
return compareCode ;
}
