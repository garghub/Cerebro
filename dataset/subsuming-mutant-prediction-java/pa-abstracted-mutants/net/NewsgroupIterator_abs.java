@Override
public boolean hasNext () {
return stringIterator . hasNext () ;
}
@Override
public NewsgroupInfo next () {
final String line = stringIterator . next () ;
return NNTPClient . parseNewsgroupListEntry ( line ) ;
}
@Override
public void remove () {
stringIterator . remove () ;
}
@Override
public Iterator < NewsgroupInfo > iterator () {
return this ;
}
