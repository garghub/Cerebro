public void readServerList ( final InputStream stream , final String encoding )
throws IOException
{
this . entries = new LinkedList <> () ;
readStream ( stream , encoding ) ;
this . parser . preParse ( this . entries ) ;
resetIterator () ;
}
private void readStream ( final InputStream stream , final String encoding ) throws IOException
{
try ( final BufferedReader reader = new BufferedReader (
new InputStreamReader ( stream , Charsets . toCharset ( encoding ) ) ) ) {
String line = this . parser . readNextEntry ( reader ) ;
while ( line != null ) {
this . entries . add ( line ) ;
line = this . parser . readNextEntry ( reader ) ;
}
}
}
public FTPFile [] getNext ( final int quantityRequested ) {
final List < FTPFile > tmpResults = new LinkedList <> () ;
int count = quantityRequested ;
while ( count > 0 && this . internalIterator . hasNext () ) {
final String entry = this . internalIterator . next () ;
FTPFile temp = this . parser . parseFTPEntry ( entry ) ;
if ( temp == null && saveUnparseableEntries ) {
temp = new FTPFile ( entry ) ;
}
tmpResults . add ( temp ) ;
count -- ;
}
return tmpResults . toArray ( new FTPFile [ tmpResults . size () ] ) ;
}
public FTPFile [] getPrevious ( final int quantityRequested ) {
final List < FTPFile > tmpResults = new LinkedList <> () ;
int count = quantityRequested ;
while ( count > 0 && this . internalIterator . hasPrevious () ) {
final String entry = this . internalIterator . previous () ;
FTPFile temp = this . parser . parseFTPEntry ( entry ) ;
if ( temp == null && saveUnparseableEntries ) {
temp = new FTPFile ( entry ) ;
}
tmpResults . add ( 0 , temp ) ;
count -- ;
}
return tmpResults . toArray ( new FTPFile [ tmpResults . size () ] ) ;
}
public FTPFile [] getFiles ()
throws IOException
{
return getFiles ( FTPFileFilters . NON_NULL ) ;
}
public FTPFile [] getFiles ( final FTPFileFilter filter )
throws IOException
{
final List < FTPFile > tmpResults = new ArrayList <> () ;
final Iterator < String > iter = this . entries . iterator () ;
while ( iter . hasNext () ) {
final String entry = iter . next () ;
FTPFile temp = this . parser . parseFTPEntry ( entry ) ;
if ( temp == null && saveUnparseableEntries ) {
temp = new FTPFile ( entry ) ;
}
if ( filter . accept ( temp ) ) {
tmpResults . add ( temp ) ;
}
}
return tmpResults . toArray ( new FTPFile [ tmpResults . size () ] ) ;
}
public boolean hasNext () {
return internalIterator . hasNext () ;
}
public boolean hasPrevious () {
return internalIterator . hasPrevious () ;
}
public void resetIterator () {
this . internalIterator = this . entries . listIterator () ;
}
@Deprecated
public void readServerList ( final InputStream stream )
throws IOException
{
readServerList ( stream , null ) ;
}
