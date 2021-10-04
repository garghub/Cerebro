@Override
public void write ( final int b ) throws IOException {
appendable . append ( ( char ) b ) ;
}
public T getAppendable () {
return appendable ;
}
