@Override
public int compare ( final File file1 , final File file2 ) {
final long result = file1 . lastModified () - file2 . lastModified () ;
if ( result < 0 ) {
return - 1 ;
} else if ( result > 0 ) {
return 1 ;
} else {
return 0 ;
}
}
