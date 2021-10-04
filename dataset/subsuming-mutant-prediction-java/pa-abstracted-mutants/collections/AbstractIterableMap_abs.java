@Override
public MapIterator < K , V > mapIterator () {
return new EntrySetToMapIteratorAdapter <> ( entrySet () ) ;
}
