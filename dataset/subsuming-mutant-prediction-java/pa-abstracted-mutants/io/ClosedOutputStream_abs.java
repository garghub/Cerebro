@Override
public void write ( final int b ) throws IOException {
throw new IOException ( lr_1 + b + lr_2 ) ;
}
@Override
public void flush () throws IOException {
throw new IOException ( lr_3 ) ;
}
