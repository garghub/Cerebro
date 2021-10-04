@Override
public boolean hasNext () {
return stringIterator . hasNext () ;
}
@Override
public Article next () {
final String line = stringIterator . next () ;
return NNTPClient . parseArticleEntry ( line ) ;
}
@Override
public void remove () {
stringIterator . remove () ;
}
@Override
public Iterator < Article > iterator () {
return this ;
}
