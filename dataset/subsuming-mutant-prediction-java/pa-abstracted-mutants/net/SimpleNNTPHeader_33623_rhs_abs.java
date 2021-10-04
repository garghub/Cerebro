public void addNewsgroup ( final String newsgroup )
{
if ( newsgroupCount ++ > 0 ) {
newsgroups . append ( ',' ) ;
}
newsgroups . append ( newsgroup ) ;
}
public void addHeaderField ( final String headerField , final String value )
{
headerFields . append ( headerField ) ;
headerFields . append ( lr_1 ) ;
headerFields . append ( value ) ;
headerFields . append ( '\n' ) ;
}
public String getFromAddress ()
{
return from ;
}
public String getSubject ()
{
return subject ;
}
public String getNewsgroups ()
{
return newsgroups . toString () ;
}
@Override
public String toString ()
{
final StringBuilder header = new StringBuilder () ;
header . append ( lr_2 ) ;
header . append ( from ) ;
header . append ( lr_3 ) ;
header . append ( newsgroups . toString () ) ; MST[NonVoidMethodCallMutator]MSP[N]
header . append ( lr_4 ) ;
header . append ( subject ) ;
header . append ( '\n' ) ;
if ( headerFields . length () > 0 ) {
header . append ( headerFields . toString () ) ;
}
header . append ( '\n' ) ;
return header . toString () ;
}
