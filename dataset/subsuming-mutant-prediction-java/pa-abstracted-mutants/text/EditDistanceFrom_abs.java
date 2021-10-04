public R apply ( final CharSequence right ) {
return editDistance . apply ( left , right ) ;
}
public CharSequence getLeft () {
return left ;
}
public EditDistance < R > getEditDistance () {
return editDistance ;
}
