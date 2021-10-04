@Override
public boolean accept ( final File file ) {
return ! filter . accept ( file ) ;
}
@Override
public boolean accept ( final File file , final String name ) {
return ! filter . accept ( file , name ) ; MST[rv.ROR3Mutator]MSP[]
}
@Override
public String toString () {
return super . toString () + lr_1 + filter . toString () + lr_2 ;
}
