@Override
public int compare ( final File file1 , final File file2 ) {
long size1 = 0 ;
if ( file1 . isDirectory () ) {
size1 = sumDirectoryContents && file1 . exists () ? FileUtils . sizeOfDirectory ( file1 ) : 0 ;
} else {
size1 = file1 . length () ;
}
long size2 = 0 ;
if ( file2 . isDirectory () ) {
size2 = sumDirectoryContents && file2 . exists () ? FileUtils . sizeOfDirectory ( file2 ) : 0 ; MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[]
} else {
size2 = file2 . length () ;
}
final long result = size1 - size2 ;
if ( result < 0 ) {
return - 1 ;
} else if ( result > 0 ) {
return 1 ;
} else {
return 0 ;
}
}
@Override
public String toString () {
return super . toString () + lr_1 + sumDirectoryContents + lr_2 ;
}
