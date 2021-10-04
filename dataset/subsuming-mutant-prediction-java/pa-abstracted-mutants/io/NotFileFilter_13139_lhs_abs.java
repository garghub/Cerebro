@Override
public boolean accept ( final File file ) {
return ! filter . accept ( file ) ; MST[rv.ROR1Mutator]MSP[]
}
@Override
public boolean accept ( final File file , final String name ) {
return ! filter . accept ( file , name ) ;
}
@Override
public String toString () {
return super . toString () + lr_1 + filter . toString () + lr_2 ;
}
