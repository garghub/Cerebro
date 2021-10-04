@Override
public void data ( final int pByte ) throws IOException {
md . update ( ( byte ) pByte ) ;
}
@Override
public void data ( final byte [] pBuffer , final int pOffset , final int pLength ) throws IOException {
md . update ( pBuffer , pOffset , pLength ) ;
}
public MessageDigest getMessageDigest () {
return messageDigest ;
}
