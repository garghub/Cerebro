@Override
public boolean hasNext () {
return iterator . hasNext () ;
}
@Override
public O next () {
return transform ( iterator . next () ) ;
}
@Override
public void remove () {
iterator . remove () ;
}
public Iterator < ? extends I > getIterator () {
return iterator ;
}
public void setIterator ( final Iterator < ? extends I > iterator ) {
this . iterator = iterator ;
}
public Transformer < ? super I , ? extends O > getTransformer () {
return transformer ;
}
public void setTransformer ( final Transformer < ? super I , ? extends O > transformer ) {
this . transformer = transformer ;
}
protected O transform ( final I source ) {
return transformer . transform ( source ) ;
}
