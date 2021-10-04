@Override
public boolean accept ( final File file ) {
final boolean newer = FileUtils . isFileNewer ( file , cutoff ) ; MST[rv.UOI4Mutator]MSP[N]
return acceptOlder ? ! newer : newer ;
}
@Override
public String toString () {
final String condition = acceptOlder ? lr_1 : lr_2 ;
return super . toString () + lr_3 + condition + cutoff + lr_4 ;
}
