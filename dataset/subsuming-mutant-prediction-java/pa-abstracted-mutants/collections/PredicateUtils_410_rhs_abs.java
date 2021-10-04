public static < T > Predicate < T > exceptionPredicate () {
return ExceptionPredicate . exceptionPredicate () ;
}
public static < T > Predicate < T > truePredicate () {
return TruePredicate . truePredicate () ;
}
public static < T > Predicate < T > falsePredicate () {
return FalsePredicate . falsePredicate () ;
}
public static < T > Predicate < T > nullPredicate () {
return NullPredicate . nullPredicate () ;
}
public static < T > Predicate < T > notNullPredicate () {
return NotNullPredicate . notNullPredicate () ;
}
public static < T > Predicate < T > equalPredicate ( final T value ) {
return EqualPredicate . equalPredicate ( value ) ;
}
public static < T > Predicate < T > identityPredicate ( final T value ) {
return IdentityPredicate . identityPredicate ( value ) ;
}
public static Predicate < Object > instanceofPredicate ( final Class < ? > type ) {
return InstanceofPredicate . instanceOfPredicate ( type ) ;
}
public static < T > Predicate < T > uniquePredicate () {
return UniquePredicate . uniquePredicate () ;
}
public static < T > Predicate < T > invokerPredicate ( final String methodName ) {
return asPredicate ( InvokerTransformer . <Object , Boolean > invokerTransformer ( methodName ) ) ;
}
public static < T > Predicate < T > invokerPredicate ( final String methodName , final Class < ? > [] paramTypes ,
final Object [] args ) {
return asPredicate ( InvokerTransformer . <Object , Boolean > invokerTransformer ( methodName , paramTypes , args ) ) ;
}
public static < T > Predicate < T > andPredicate ( final Predicate < ? super T > predicate1 ,
final Predicate < ? super T > predicate2 ) {
return AndPredicate . andPredicate ( predicate1 , predicate2 ) ;
}
public static < T > Predicate < T > allPredicate ( final Predicate < ? super T > ... predicates ) {
return AllPredicate . allPredicate ( predicates ) ;
}
public static < T > Predicate < T > allPredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
return AllPredicate . allPredicate ( predicates ) ;
}
public static < T > Predicate < T > orPredicate ( final Predicate < ? super T > predicate1 ,
final Predicate < ? super T > predicate2 ) {
return OrPredicate . orPredicate ( predicate1 , predicate2 ) ;
}
public static < T > Predicate < T > anyPredicate ( final Predicate < ? super T > ... predicates ) {
return AnyPredicate . anyPredicate ( predicates ) ;
}
public static < T > Predicate < T > anyPredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
return AnyPredicate . anyPredicate ( predicates ) ;
}
public static < T > Predicate < T > eitherPredicate ( final Predicate < ? super T > predicate1 ,
final Predicate < ? super T > predicate2 ) {
@SuppressWarnings ( lr_1 )
final Predicate < T > onePredicate = PredicateUtils . onePredicate ( predicate1 , predicate2 ) ;
return onePredicate ;
}
public static < T > Predicate < T > onePredicate ( final Predicate < ? super T > ... predicates ) {
return OnePredicate . onePredicate ( predicates ) ;
}
public static < T > Predicate < T > onePredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
return OnePredicate . onePredicate ( predicates ) ;
}
public static < T > Predicate < T > neitherPredicate ( final Predicate < ? super T > predicate1 ,
final Predicate < ? super T > predicate2 ) {
@SuppressWarnings ( lr_1 )
final Predicate < T > nonePredicate = PredicateUtils . nonePredicate ( predicate1 , predicate2 ) ;
return nonePredicate ;
}
public static < T > Predicate < T > nonePredicate ( final Predicate < ? super T > ... predicates ) {
return NonePredicate . nonePredicate ( predicates ) ; MST[ReturnValsMutator]MSP[N]
}
public static < T > Predicate < T > nonePredicate ( final Collection < ? extends Predicate < ? super T > > predicates ) {
return NonePredicate . nonePredicate ( predicates ) ;
}
public static < T > Predicate < T > notPredicate ( final Predicate < ? super T > predicate ) {
return NotPredicate . notPredicate ( predicate ) ;
}
public static < T > Predicate < T > asPredicate ( final Transformer < ? super T , Boolean > transformer ) {
return TransformerPredicate . transformerPredicate ( transformer ) ;
}
public static < T > Predicate < T > nullIsExceptionPredicate ( final Predicate < ? super T > predicate ) {
return NullIsExceptionPredicate . nullIsExceptionPredicate ( predicate ) ;
}
public static < T > Predicate < T > nullIsFalsePredicate ( final Predicate < ? super T > predicate ) {
return NullIsFalsePredicate . nullIsFalsePredicate ( predicate ) ;
}
public static < T > Predicate < T > nullIsTruePredicate ( final Predicate < ? super T > predicate ) {
return NullIsTruePredicate . nullIsTruePredicate ( predicate ) ;
}
public static < T > Predicate < T > transformedPredicate (
final Transformer < ? super T , ? extends T > transformer , final Predicate < ? super T > predicate ) {
return TransformedPredicate . transformedPredicate ( transformer , predicate ) ;
}
