@Override
public boolean accept ( final FTPFile file ) {
return true ;
}
@Override
public boolean accept ( final FTPFile file ) {
return file != null ;
}
@Override
public boolean accept ( final FTPFile file ) {
return file != null && file . isDirectory () ;
}
