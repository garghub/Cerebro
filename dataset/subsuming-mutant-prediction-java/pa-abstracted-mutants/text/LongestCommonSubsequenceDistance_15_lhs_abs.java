@Override
public Integer apply ( final CharSequence left , final CharSequence right ) {
if ( left == null || right == null ) {
throw new IllegalArgumentException ( lr_1 ) ; MST[ConstructorCallMutator]MSP[]
}
return left . length () + right . length () - 2 * longestCommonSubsequence . apply ( left , right ) ;
}
