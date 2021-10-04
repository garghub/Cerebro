public void addNewsgroup ( final String newsgroup )
{
if ( newsgroups != null ) {
newsgroups . append ( ',' ) ;
} else {
newsgroups = new StringBuffer () ;
}
newsgroups . append ( newsgroup ) ; MST[NonVoidMethodCallMutator]MSP[S]
}
public void omitNewsgroup ( final String newsgroup )
{
addNewsgroup ( lr_1 + newsgroup ) ;
}
public void addDistribution ( final String distribution )
{
if ( distributions != null ) {
distributions . append ( ',' ) ;
} else {
distributions = new StringBuffer () ;
}
distributions . append ( distribution ) ;
}
public String getDate ()
{
return date ;
}
public String getTime ()
{
return time ;
}
public boolean isGMT ()
{
return isGMT ;
}
public String getDistributions ()
{
return distributions == null ? null : distributions . toString () ;
}
public String getNewsgroups ()
{
return newsgroups == null ? null : newsgroups . toString () ;
}
