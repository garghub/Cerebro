public static Predicate < Object > instanceOfPredicate ( final Class < ? > type ) {
return new InstanceofPredicate ( Objects . requireNonNull ( type , lr_1 ) ) ;
}
@Override
public boolean evaluate ( final Object object ) {
return iType . isInstance ( object ) ; MST[BooleanTrueReturnValsMutator]MSP[S]
}
public Class < ? > getType () {
return iType ;
}
