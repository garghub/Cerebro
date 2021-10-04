public static String lowerCase ( final String input ) {
return input != null ? input . toLowerCase ( Locale . ENGLISH ) : lr_1 ; MST[RemoveConditionalMutator_EQUAL_ELSE]MSP[S]
}
public static String normalize ( final String input ) {
return lowerCase ( input ) . trim () ;
}
public static String normalize ( final String input , boolean isStringLiteral ) {
return isStringLiteral ? lowerCase ( input ) : normalize ( input ) ;
}
