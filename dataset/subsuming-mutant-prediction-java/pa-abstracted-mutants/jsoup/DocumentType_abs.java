public void setPubSysKey ( String value ) {
if ( value != null )
attr ( PUB_SYS_KEY , value ) ;
}
private void updatePubSyskey () {
if ( has ( PUBLIC_ID ) ) {
attr ( PUB_SYS_KEY , PUBLIC_KEY ) ;
} else if ( has ( SYSTEM_ID ) )
attr ( PUB_SYS_KEY , SYSTEM_KEY ) ;
}
public String name () {
return attr ( NAME ) ;
}
public String publicId () {
return attr ( PUBLIC_ID ) ;
}
public String systemId () {
return attr ( SYSTEM_ID ) ;
}
@Override
public String nodeName () {
return lr_1 ;
}
@Override
void outerHtmlHead ( Appendable accum , int depth , Document . OutputSettings out ) throws IOException {
if ( out . syntax () == Syntax . html && ! has ( PUBLIC_ID ) && ! has ( SYSTEM_ID ) ) {
accum . append ( lr_2 ) ;
} else {
accum . append ( lr_3 ) ;
}
if ( has ( NAME ) )
accum . append ( lr_4 ) . append ( attr ( NAME ) ) ;
if ( has ( PUB_SYS_KEY ) )
accum . append ( lr_4 ) . append ( attr ( PUB_SYS_KEY ) ) ;
if ( has ( PUBLIC_ID ) )
accum . append ( lr_5 ) . append ( attr ( PUBLIC_ID ) ) . append ( '"' ) ;
if ( has ( SYSTEM_ID ) )
accum . append ( lr_5 ) . append ( attr ( SYSTEM_ID ) ) . append ( '"' ) ;
accum . append ( '>' ) ;
}
@Override
void outerHtmlTail ( Appendable accum , int depth , Document . OutputSettings out ) {
}
private boolean has ( final String attribute ) {
return ! StringUtil . isBlank ( attr ( attribute ) ) ;
}
