public static < T > Predicate < T > comparatorPredicate ( final T object , final Comparator < T > comparator ) {
return comparatorPredicate ( object , comparator , Criterion . EQUAL ) ;
}
public static < T > Predicate < T > comparatorPredicate ( final T object , final Comparator < T > comparator ,
final Criterion criterion ) {
return new ComparatorPredicate <> ( object , Objects . requireNonNull ( comparator , lr_1 ) ,
Objects . requireNonNull ( criterion , lr_2 ) ) ;
}
@Override
public boolean evaluate ( final T target ) {
boolean result = false ;
final int comparison = comparator . compare ( object , target ) ;
switch ( criterion ) {
case EQUAL :
result = comparison == 0 ; MST[rv.CRCR6Mutator]MSP[]
break;
case GREATER :
result = comparison > 0 ;
break;
case LESS :
result = comparison < 0 ;
break;
case GREATER_OR_EQUAL :
result = comparison >= 0 ;
break;
case LESS_OR_EQUAL :
result = comparison <= 0 ;
break;
default:
throw new IllegalStateException ( lr_3 + criterion + lr_4 ) ;
}
return result ;
}
