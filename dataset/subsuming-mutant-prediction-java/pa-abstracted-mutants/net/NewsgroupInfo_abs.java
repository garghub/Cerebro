void setNewsgroup ( final String newsgroup )
{
this . newsgroup = newsgroup ;
}
void setArticleCount ( final long count )
{
estimatedArticleCount = count ;
}
void setFirstArticle ( final long first )
{
firstArticle = first ;
}
void setLastArticle ( final long last )
{
lastArticle = last ;
}
void setPostingPermission ( final int permission )
{
postingPermission = permission ;
}
public String getNewsgroup ()
{
return newsgroup ;
}
public long getArticleCountLong ()
{
return estimatedArticleCount ;
}
public long getFirstArticleLong ()
{
return firstArticle ;
}
public long getLastArticleLong ()
{
return lastArticle ;
}
public int getPostingPermission ()
{
return postingPermission ;
}
@Deprecated
public int getArticleCount () {
return ( int ) estimatedArticleCount ;
}
@Deprecated
public int getFirstArticle () {
return ( int ) firstArticle ;
}
@Deprecated
public int getLastArticle () {
return ( int ) lastArticle ;
}
