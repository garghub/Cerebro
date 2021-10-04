@Override
public void accept ( final CommandVisitor < T > visitor ) {
visitor . visitDeleteCommand ( getObject () ) ;
}
