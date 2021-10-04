@Override
public FTPFile parseFTPEntry ( final String listEntry )
{
if ( cachedFtpFileEntryParser != null )
{
final FTPFile matched = cachedFtpFileEntryParser . parseFTPEntry ( listEntry ) ;
if ( matched != null )
{
return matched ;
}
}
else
{
for ( final FTPFileEntryParser ftpFileEntryParser : ftpFileEntryParsers )
{
final FTPFile matched = ftpFileEntryParser . parseFTPEntry ( listEntry ) ;
if ( matched != null )
{
cachedFtpFileEntryParser = ftpFileEntryParser ;
return matched ;
}
}
}
return null ;
}
