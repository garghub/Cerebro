@Override
public boolean accept ( final File file ) {
final boolean smaller = file . length () < size ;
return acceptLarger ? ! smaller : smaller ;
}
@Override
public String toString () {
final String condition = acceptLarger ? lr_1 : lr_2 ; MST[rv.ROR3Mutator]MSP[]
return super . toString () + lr_3 + condition + size + lr_4 ;
}
