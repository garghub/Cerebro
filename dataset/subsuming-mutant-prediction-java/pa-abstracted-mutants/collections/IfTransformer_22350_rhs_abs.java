public static < I , O > Transformer < I , O > ifTransformer ( final Predicate < ? super I > predicate ,
final Transformer < ? super I , ? extends O > trueTransformer ,
final Transformer < ? super I , ? extends O > falseTransformer ) {
return new IfTransformer <> ( Objects . requireNonNull ( predicate , lr_1 ) ,
Objects . requireNonNull ( trueTransformer , lr_2 ) ,
Objects . requireNonNull ( falseTransformer , lr_3 ) ) ;
}
public static < T > Transformer < T , T > ifTransformer (
final Predicate < ? super T > predicate ,
final Transformer < ? super T , ? extends T > trueTransformer ) {
return new IfTransformer <> ( Objects . requireNonNull ( predicate , lr_1 ) ,
Objects . requireNonNull ( trueTransformer , lr_2 ) , NOPTransformer . <T > nopTransformer () ) ;
}
@Override
public O transform ( final I input ) {
if ( iPredicate . evaluate ( input ) ) { MST[rv.ROR2Mutator]MSP[N]
return iTrueTransformer . transform ( input ) ;
}
return iFalseTransformer . transform ( input ) ;
}
public Predicate < ? super I > getPredicate () {
return iPredicate ;
}
public Transformer < ? super I , ? extends O > getTrueTransformer () {
return iTrueTransformer ;
}
public Transformer < ? super I , ? extends O > getFalseTransformer () {
return iFalseTransformer ;
}
