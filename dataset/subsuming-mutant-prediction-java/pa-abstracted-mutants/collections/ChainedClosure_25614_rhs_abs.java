public static < E > Closure < E > chainedClosure ( final Closure < ? super E > ... closures ) {
FunctorUtils . validate ( closures ) ;
if ( closures . length == 0 ) {
return NOPClosure . <E > nopClosure () ;
}
return new ChainedClosure <> ( closures ) ;
}
@SuppressWarnings ( lr_1 )
public static < E > Closure < E > chainedClosure ( final Collection < ? extends Closure < ? super E > > closures ) {
Objects . requireNonNull ( closures , lr_2 ) ;
if ( closures . size () == 0 ) {
return NOPClosure . <E > nopClosure () ;
}
final Closure < ? super E > [] cmds = new Closure [ closures . size () ] ;
int i = 0 ;
for ( final Closure < ? super E > closure : closures ) {
cmds [ i ++ ] = closure ;
}
FunctorUtils . validate ( cmds ) ;
return new ChainedClosure <> ( false , cmds ) ; MST[ReturnValsMutator]MSP[N]
}
@Override
public void execute ( final E input ) {
for ( final Closure < ? super E > iClosure : iClosures ) {
iClosure . execute ( input ) ;
}
}
public Closure < ? super E > [] getClosures () {
return FunctorUtils . <E > copy ( iClosures ) ;
}
