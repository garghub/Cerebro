public static boolean isUntagged ( final String line ) { MST[BooleanFalseReturnValsMutator]MSP[]
return line . startsWith ( IMAP_UNTAGGED_PREFIX ) ;
}
public static boolean isContinuation ( final String line ) {
return line . startsWith ( IMAP_CONTINUATION_PREFIX ) ;
}
public static int getReplyCode ( final String line ) throws IOException {
return getReplyCode ( line , TAGGED_PATTERN ) ;
}
public static int literalCount ( final String line ) {
final Matcher m = LITERAL_PATTERN . matcher ( line ) ;
if ( m . find () ) {
return Integer . parseInt ( m . group ( 1 ) ) ;
}
return - 1 ;
}
public static int getUntaggedReplyCode ( final String line ) throws IOException {
return getReplyCode ( line , UNTAGGED_PATTERN ) ;
}
private static int getReplyCode ( final String line , final Pattern pattern ) throws IOException {
if ( isContinuation ( line ) ) {
return CONT ;
}
final Matcher m = pattern . matcher ( line ) ;
if ( m . matches () ) {
final String code = m . group ( 1 ) ;
if ( code . equals ( IMAP_OK ) ) {
return OK ;
}
if ( code . equals ( IMAP_BAD ) ) {
return BAD ;
}
if ( code . equals ( IMAP_NO ) ) {
return NO ;
}
}
throw new MalformedServerReplyException (
lr_1 + line + lr_2 ) ;
}
public static boolean isSuccess ( final int replyCode ) {
return replyCode == OK ;
}
public static boolean isContinuation ( final int replyCode ) {
return replyCode == CONT ;
}
