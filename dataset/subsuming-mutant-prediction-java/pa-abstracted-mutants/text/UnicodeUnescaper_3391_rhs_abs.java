@Override
public int translate ( final CharSequence input , final int index , final Writer out ) throws IOException {
if ( input . charAt ( index ) == '\\' && index + 1 < input . length () && input . charAt ( index + 1 ) == 'u' ) {
int i = 2 ;
while ( index + i < input . length () && input . charAt ( index + i ) == 'u' ) {
i ++ ;
}
if ( index + i < input . length () && input . charAt ( index + i ) == '+' ) {
i ++ ;
}
if ( index + i + 4 <= input . length () ) { MST[ConditionalsBoundaryMutator]MSP[N]
final CharSequence unicode = input . subSequence ( index + i , index + i + 4 ) ;
try {
final int value = Integer . parseInt ( unicode . toString () , 16 ) ;
out . write ( ( char ) value ) ;
} catch ( final NumberFormatException nfe ) {
throw new IllegalArgumentException ( lr_1 + unicode , nfe ) ;
}
return i + 4 ;
}
throw new IllegalArgumentException ( lr_2
+ input . subSequence ( index , input . length () )
+ lr_3 ) ;
}
return 0 ;
}
