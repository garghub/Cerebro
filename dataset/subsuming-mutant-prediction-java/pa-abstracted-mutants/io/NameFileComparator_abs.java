@Override
public int compare ( final File file1 , final File file2 ) {
return caseSensitivity . checkCompareTo ( file1 . getName () , file2 . getName () ) ;
}
@Override
public String toString () {
return super . toString () + lr_1 + caseSensitivity + lr_2 ;
}
