@Override
public int compare ( final File file1 , final File file2 ) {
return delegate . compare ( file2 , file1 ) ;
}
@Override
public String toString () {
return super . toString () + lr_1 + delegate . toString () + lr_2 ;
}
