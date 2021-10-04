public static final String getCommand ( final IMAPCommand command ) {
return command . getIMAPCommand () ;
}
public String getIMAPCommand () {
return imapCommand != null ? imapCommand : name () ;
}
