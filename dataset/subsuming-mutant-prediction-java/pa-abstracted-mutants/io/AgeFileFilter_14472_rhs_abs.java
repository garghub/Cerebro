@Override
public boolean accept ( final File file ) {
final boolean newer = FileUtils . isFileNewer ( file , cutoff ) ;
return acceptOlder ? ! newer : newer ; MST[InlineConstantMutator]MSP[S]
}
@Override
public String toString () {
final String condition = acceptOlder ? lr_1 : lr_2 ;
return super . toString () + lr_3 + condition + cutoff + lr_4 ;
}
