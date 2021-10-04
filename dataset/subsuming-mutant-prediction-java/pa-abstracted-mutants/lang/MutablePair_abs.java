public static < L , R > MutablePair < L , R > of ( final L left , final R right ) {
return new MutablePair < L , R > ( left , right ) ;
}
@Override
public L getLeft () {
return left ;
}
public void setLeft ( final L left ) {
this . left = left ;
}
@Override
public R getRight () {
return right ;
}
public void setRight ( final R right ) {
this . right = right ;
}
@Override
public R setValue ( final R value ) {
final R result = getRight () ;
setRight ( value ) ;
return result ;
}
