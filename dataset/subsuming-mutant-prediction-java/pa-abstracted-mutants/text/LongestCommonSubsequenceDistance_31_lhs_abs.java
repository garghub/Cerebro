@Override
public Integer apply ( final CharSequence left , final CharSequence right ) {
if ( left == null || right == null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
throw new IllegalArgumentException ( lr_1 ) ;
}
return left . length () + right . length () - 2 * longestCommonSubsequence . apply ( left , right ) ;
}
