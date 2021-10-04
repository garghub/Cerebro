@Override
public void visitInsertCommand ( final T object ) {
pendingInsertions . add ( object ) ;
}
@Override
public void visitKeepCommand ( final T object ) {
if ( pendingDeletions . isEmpty () && pendingInsertions . isEmpty () ) {
++ skipped ;
} else {
handler . handleReplacement ( skipped , pendingDeletions , pendingInsertions ) ;
pendingDeletions . clear () ;
pendingInsertions . clear () ;
skipped = 1 ;
}
}
@Override
public void visitDeleteCommand ( final T object ) {
pendingDeletions . add ( object ) ;
}
