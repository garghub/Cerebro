@Override
public boolean accept ( final File file ) {
final boolean newer = FileUtils . isFileNewer ( file , cutoff ) ;
return acceptOlder ? ! newer : newer ;
}
@Override
public String toString () {
final String condition = acceptOlder ? lr_1 : lr_2 ; MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
return super . toString () + lr_3 + condition + cutoff + lr_4 ;
}
