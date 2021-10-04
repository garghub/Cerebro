public static Predicate < Object > instanceOfPredicate ( final Class < ? > type ) {
return new InstanceofPredicate ( Objects . requireNonNull ( type , lr_1 ) ) ; MST[ConstructorCallMutator]MSP[N]
}
@Override
public boolean evaluate ( final Object object ) {
return iType . isInstance ( object ) ;
}
public Class < ? > getType () {
return iType ;
}
