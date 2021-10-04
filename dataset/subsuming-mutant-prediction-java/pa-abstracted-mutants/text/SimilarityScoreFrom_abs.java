public R apply ( final CharSequence right ) {
return similarityScore . apply ( left , right ) ;
}
public CharSequence getLeft () {
return left ;
}
public SimilarityScore < R > getSimilarityScore () {
return similarityScore ;
}
