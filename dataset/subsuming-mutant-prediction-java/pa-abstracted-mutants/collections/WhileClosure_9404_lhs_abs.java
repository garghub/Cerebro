public static < E > Closure < E > whileClosure ( final Predicate < ? super E > predicate ,
final Closure < ? super E > closure , final boolean doLoop ) {
return new WhileClosure <> ( Objects . requireNonNull ( predicate , lr_1 ) ,
Objects . requireNonNull ( closure , lr_2 ) , doLoop ) ;
}
@Override
public void execute ( final E input ) {
if ( iDoLoop ) {
iClosure . execute ( input ) ; MST[VoidMethodCallMutator]MSP[]
}
while ( iPredicate . evaluate ( input ) ) {
iClosure . execute ( input ) ;
}
}
public Predicate < ? super E > getPredicate () {
return iPredicate ;
}
public Closure < ? super E > getClosure () {
return iClosure ;
}
public boolean isDoLoop () {
return iDoLoop ;
}
