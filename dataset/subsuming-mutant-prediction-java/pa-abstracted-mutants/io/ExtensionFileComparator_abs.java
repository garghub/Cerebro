@Override
public int compare ( final File file1 , final File file2 ) {
final String suffix1 = FilenameUtils . getExtension ( file1 . getName () ) ;
final String suffix2 = FilenameUtils . getExtension ( file2 . getName () ) ;
return caseSensitivity . checkCompareTo ( suffix1 , suffix2 ) ;
}
@Override
public String toString () {
return super . toString () + lr_1 + caseSensitivity + lr_2 ;
}
