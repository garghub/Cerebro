public static < E > Closure < E > ifClosure ( final Predicate < ? super E > predicate , final Closure < ? super E > trueClosure ) {
return IfClosure . <E > ifClosure ( predicate , trueClosure , NOPClosure . <E > nopClosure () ) ;
}
public static < E > Closure < E > ifClosure ( final Predicate < ? super E > predicate ,
final Closure < ? super E > trueClosure ,
final Closure < ? super E > falseClosure ) {
return new IfClosure <> ( Objects . requireNonNull ( predicate , lr_1 ) ,
Objects . requireNonNull ( trueClosure , lr_2 ) ,
Objects . requireNonNull ( falseClosure , lr_3 ) ) ;
}
@Override
public void execute ( final E input ) {
if ( iPredicate . evaluate ( input ) ) { MST[NegateConditionalsMutator]MSP[]
iTrueClosure . execute ( input ) ;
} else {
iFalseClosure . execute ( input ) ;
}
}
public Predicate < ? super E > getPredicate () {
return iPredicate ;
}
public Closure < ? super E > getTrueClosure () {
return iTrueClosure ;
}
public Closure < ? super E > getFalseClosure () {
return iFalseClosure ;
}
