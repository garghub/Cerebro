@Override
protected boolean filter ( final int ch ) {
return skipSet . contains ( Integer . valueOf ( ch ) ) ;
}
