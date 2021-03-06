Evaluator rightMostEvaluator () {
return num > 0 ? evaluators . get ( num - 1 ) : null ;
}
void replaceRightMostEvaluator ( Evaluator replacement ) {
evaluators . set ( num - 1 , replacement ) ;
}
void updateNumEvaluators () {
num = evaluators . size () ;
}
@Override
public boolean matches ( Element root , Element node ) {
for ( int i = 0 ; i < num ; i ++ ) {
Evaluator s = evaluators . get ( i ) ;
if ( ! s . matches ( root , node ) )
return false ;
}
return true ;
}
@Override
public String toString () {
return StringUtil . join ( evaluators , lr_1 ) ;
}
public void add ( Evaluator e ) {
evaluators . add ( e ) ;
updateNumEvaluators () ;
}
@Override
public boolean matches ( Element root , Element node ) {
for ( int i = 0 ; i < num ; i ++ ) {
Evaluator s = evaluators . get ( i ) ;
if ( s . matches ( root , node ) )
return true ;
}
return false ;
}
@Override
public String toString () {
return StringUtil . join ( evaluators , lr_2 ) ;
}
