@Override
public Writer append ( final char c ) throws IOException {
appendable . append ( c ) ;
return this ;
}
@Override
public Writer append ( final CharSequence csq ) throws IOException {
appendable . append ( csq ) ;
return this ;
}
@Override
public Writer append ( final CharSequence csq , final int start , final int end ) throws IOException {
appendable . append ( csq , start , end ) ;
return this ;
}
@Override
public void close () throws IOException {
}
@Override
public void flush () throws IOException {
}
public T getAppendable () {
return appendable ;
}
@Override
public void write ( final char [] cbuf , final int off , final int len ) throws IOException {
Objects . requireNonNull ( cbuf , lr_1 ) ;
if ( len < 0 || ( off + len ) > cbuf . length ) {
throw new IndexOutOfBoundsException ( lr_2 + cbuf . length +
lr_3 + off + lr_4 + len ) ;
}
for ( int i = 0 ; i < len ; i ++ ) {
appendable . append ( cbuf [ off + i ] ) ;
}
}
@Override
public void write ( final int c ) throws IOException {
appendable . append ( ( char ) c ) ;
}
@Override
public void write ( final String str , final int off , final int len ) throws IOException {
Objects . requireNonNull ( str , lr_5 ) ;
appendable . append ( str , off , off + len ) ;
}
