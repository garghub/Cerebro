public long getTime () throws IOException
{
DataInputStream input ;
input = new DataInputStream ( _input_ ) ;
return input . readInt () & 0xffffffffL ;
}
public Date getDate () throws IOException
{
return new Date ( ( getTime () - SECONDS_1900_TO_1970 ) * 1000L ) ;
}
