@Override
public void accept ( final CommandVisitor < T > visitor ) {
visitor . visitKeepCommand ( getObject () ) ;
}
