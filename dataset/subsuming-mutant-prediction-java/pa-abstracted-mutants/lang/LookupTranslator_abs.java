@Override
public int translate ( final CharSequence input , final int index , final Writer out ) throws IOException {
if ( prefixSet . contains ( input . charAt ( index ) ) ) {
int max = longest ;
if ( index + longest > input . length () ) {
max = input . length () - index ;
}
for ( int i = max ; i >= shortest ; i -- ) {
final CharSequence subSeq = input . subSequence ( index , index + i ) ;
final String result = lookupMap . get ( subSeq . toString () ) ;
if ( result != null ) {
out . write ( result ) ;
return i ;
}
}
}
return 0 ;
}
