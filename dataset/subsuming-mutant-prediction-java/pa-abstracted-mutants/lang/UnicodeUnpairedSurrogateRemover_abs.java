@Override
public boolean translate ( final int codepoint , final Writer out ) throws IOException {
if ( codepoint >= Character . MIN_SURROGATE && codepoint <= Character . MAX_SURROGATE ) {
return true ;
}
return false ;
}
