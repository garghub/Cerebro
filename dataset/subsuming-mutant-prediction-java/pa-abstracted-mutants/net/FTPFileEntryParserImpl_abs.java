@Override
public String readNextEntry ( final BufferedReader reader ) throws IOException
{
return reader . readLine () ;
}
@Override
public List < String > preParse ( final List < String > original ) {
return original ;
}
