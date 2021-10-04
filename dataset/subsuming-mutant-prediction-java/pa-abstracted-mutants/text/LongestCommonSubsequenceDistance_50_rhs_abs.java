@Override
public Integer apply ( final CharSequence left , final CharSequence right ) {
if ( left == null || right == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return left . length () + right . length () - 2 * longestCommonSubsequence . apply ( left , right ) ; MST[rv.AOR2Mutator]MSP[S]
}
