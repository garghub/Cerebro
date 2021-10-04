@Override
public boolean accept ( final File file ) {
final boolean smaller = file . length () < size ;
return acceptLarger ? ! smaller : smaller ; MST[BooleanFalseReturnValsMutator]MSP[]
}
@Override
public String toString () {
final String condition = acceptLarger ? lr_1 : lr_2 ;
return super . toString () + lr_3 + condition + size + lr_4 ;
}
