@Override
public boolean accept ( final File file ) {
return ! filter . accept ( file ) ; MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
}
@Override
public boolean accept ( final File file , final String name ) {
return ! filter . accept ( file , name ) ;
}
@Override
public String toString () {
return super . toString () + lr_1 + filter . toString () + lr_2 ;
}
