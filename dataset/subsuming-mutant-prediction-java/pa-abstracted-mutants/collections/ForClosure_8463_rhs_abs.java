@SuppressWarnings ( lr_1 )
public static < E > Closure < E > forClosure ( final int count , final Closure < ? super E > closure ) {
if ( count <= 0 || closure == null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[S]
return NOPClosure . <E > nopClosure () ;
}
if ( count == 1 ) {
return ( Closure < E > ) closure ;
}
return new ForClosure <> ( count , closure ) ;
}
@Override
public void execute ( final E input ) {
for ( int i = 0 ; i < iCount ; i ++ ) {
iClosure . execute ( input ) ;
}
}
public Closure < ? super E > getClosure () {
return iClosure ;
}
public int getCount () {
return iCount ;
}
