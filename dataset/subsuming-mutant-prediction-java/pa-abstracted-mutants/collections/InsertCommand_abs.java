@Override
public void accept ( final CommandVisitor < T > visitor ) {
visitor . visitInsertCommand ( getObject () ) ;
}
