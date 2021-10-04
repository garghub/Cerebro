private void parseArticlePointer ( final String reply , final ArticleInfo pointer )
throws MalformedServerReplyException
{
final String tokens [] = reply . split ( lr_1 ) ;
if ( tokens . length >= 3 ) {
int i = 1 ;
try
{
pointer . articleNumber = Long . parseLong ( tokens [ i ++ ] ) ;
pointer . articleId = tokens [ i ++ ] ;
return;
}
catch ( final NumberFormatException e )
{
}
}
throw new MalformedServerReplyException (
lr_2 + reply ) ;
}
private static void parseGroupReply ( final String reply , final NewsgroupInfo info )
throws MalformedServerReplyException
{
final String tokens [] = reply . split ( lr_1 ) ;
if ( tokens . length >= 5 ) {
int i = 1 ;
try
{
info . setArticleCount ( Long . parseLong ( tokens [ i ++ ] ) ) ;
info . setFirstArticle ( Long . parseLong ( tokens [ i ++ ] ) ) ;
info . setLastArticle ( Long . parseLong ( tokens [ i ++ ] ) ) ;
info . setNewsgroup ( tokens [ i ++ ] ) ;
info . setPostingPermission ( NewsgroupInfo . UNKNOWN_POSTING_PERMISSION ) ;
return ;
} catch ( final NumberFormatException e )
{
}
}
throw new MalformedServerReplyException (
lr_3 + reply ) ;
}
static NewsgroupInfo parseNewsgroupListEntry ( final String entry )
{
final String tokens [] = entry . split ( lr_1 ) ;
if ( tokens . length < 4 ) {
return null ;
}
final NewsgroupInfo result = new NewsgroupInfo () ;
int i = 0 ;
result . setNewsgroup ( tokens [ i ++ ] ) ;
try
{
final long lastNum = Long . parseLong ( tokens [ i ++ ] ) ;
final long firstNum = Long . parseLong ( tokens [ i ++ ] ) ;
result . setFirstArticle ( firstNum ) ;
result . setLastArticle ( lastNum ) ;
if ( ( firstNum == 0 ) && ( lastNum == 0 ) ) {
result . setArticleCount ( 0 ) ;
} else {
result . setArticleCount ( lastNum - firstNum + 1 ) ;
}
} catch ( final NumberFormatException e ) {
return null ;
}
switch ( tokens [ i ++ ] . charAt ( 0 ) )
{
case 'y' :
case 'Y' :
result . setPostingPermission (
NewsgroupInfo . PERMITTED_POSTING_PERMISSION ) ;
break;
case 'n' :
case 'N' :
result . setPostingPermission (
NewsgroupInfo . PROHIBITED_POSTING_PERMISSION ) ;
break;
case 'm' :
case 'M' :
result . setPostingPermission (
NewsgroupInfo . MODERATED_POSTING_PERMISSION ) ;
break;
default:
result . setPostingPermission (
NewsgroupInfo . UNKNOWN_POSTING_PERMISSION ) ;
break;
}
return result ;
}
static Article parseArticleEntry ( final String line ) {
final Article article = new Article () ;
article . setSubject ( line ) ;
final String parts [] = line . split ( lr_4 ) ;
if ( parts . length > 6 ) {
int i = 0 ;
try {
article . setArticleNumber ( Long . parseLong ( parts [ i ++ ] ) ) ;
article . setSubject ( parts [ i ++ ] ) ;
article . setFrom ( parts [ i ++ ] ) ;
article . setDate ( parts [ i ++ ] ) ;
article . setArticleId ( parts [ i ++ ] ) ;
article . addReference ( parts [ i ++ ] ) ;
} catch ( final NumberFormatException e ) {
}
}
return article ;
}
private NewsgroupInfo [] readNewsgroupListing () throws IOException
{
final Vector < NewsgroupInfo > list = new Vector <> ( 2048 ) ;
String line ;
try ( final BufferedReader reader = new DotTerminatedMessageReader ( _reader_ ) ) {
while ( ( line = reader . readLine () ) != null ) {
final NewsgroupInfo tmp = parseNewsgroupListEntry ( line ) ;
if ( tmp != null ) {
list . addElement ( tmp ) ;
} else {
throw new MalformedServerReplyException ( line ) ;
}
}
}
int size ;
if ( ( size = list . size () ) < 1 ) {
return new NewsgroupInfo [ 0 ] ;
}
final NewsgroupInfo [] info = new NewsgroupInfo [ size ] ;
list . copyInto ( info ) ;
return info ;
}
private BufferedReader __retrieve ( final int command , final String articleId , final ArticleInfo pointer )
throws IOException
{
if ( articleId != null )
{
if ( ! NNTPReply . isPositiveCompletion ( sendCommand ( command , articleId ) ) ) {
return null ;
}
}
else
{
if ( ! NNTPReply . isPositiveCompletion ( sendCommand ( command ) ) ) {
return null ;
}
}
if ( pointer != null ) {
parseArticlePointer ( getReplyString () , pointer ) ;
}
return new DotTerminatedMessageReader ( _reader_ ) ;
}
private BufferedReader retrieve ( final int command , final long articleNumber , final ArticleInfo pointer )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( sendCommand ( command ,
Long . toString ( articleNumber ) ) ) ) {
return null ;
}
if ( pointer != null ) { MST[rv.UOI3Mutator]MSP[N]
parseArticlePointer ( getReplyString () , pointer ) ;
}
return new DotTerminatedMessageReader ( _reader_ ) ;
}
public BufferedReader retrieveArticle ( final String articleId , final ArticleInfo pointer )
throws IOException
{
return __retrieve ( NNTPCommand . ARTICLE , articleId , pointer ) ;
}
public Reader retrieveArticle ( final String articleId ) throws IOException
{
return retrieveArticle ( articleId , ( ArticleInfo ) null ) ;
}
public Reader retrieveArticle () throws IOException
{
return retrieveArticle ( ( String ) null ) ;
}
public BufferedReader retrieveArticle ( final long articleNumber , final ArticleInfo pointer )
throws IOException
{
return retrieve ( NNTPCommand . ARTICLE , articleNumber , pointer ) ;
}
public BufferedReader retrieveArticle ( final long articleNumber ) throws IOException
{
return retrieveArticle ( articleNumber , null ) ;
}
public BufferedReader retrieveArticleHeader ( final String articleId , final ArticleInfo pointer )
throws IOException
{
return __retrieve ( NNTPCommand . HEAD , articleId , pointer ) ;
}
public Reader retrieveArticleHeader ( final String articleId ) throws IOException
{
return retrieveArticleHeader ( articleId , ( ArticleInfo ) null ) ;
}
public Reader retrieveArticleHeader () throws IOException
{
return retrieveArticleHeader ( ( String ) null ) ;
}
public BufferedReader retrieveArticleHeader ( final long articleNumber ,
final ArticleInfo pointer )
throws IOException
{
return retrieve ( NNTPCommand . HEAD , articleNumber , pointer ) ;
}
public BufferedReader retrieveArticleHeader ( final long articleNumber ) throws IOException
{
return retrieveArticleHeader ( articleNumber , null ) ;
}
public BufferedReader retrieveArticleBody ( final String articleId , final ArticleInfo pointer )
throws IOException
{
return __retrieve ( NNTPCommand . BODY , articleId , pointer ) ;
}
public Reader retrieveArticleBody ( final String articleId ) throws IOException
{
return retrieveArticleBody ( articleId , ( ArticleInfo ) null ) ;
}
public Reader retrieveArticleBody () throws IOException
{
return retrieveArticleBody ( null ) ;
}
public BufferedReader retrieveArticleBody ( final long articleNumber ,
final ArticleInfo pointer )
throws IOException
{
return retrieve ( NNTPCommand . BODY , articleNumber , pointer ) ;
}
public BufferedReader retrieveArticleBody ( final long articleNumber ) throws IOException
{
return retrieveArticleBody ( articleNumber , null ) ;
}
public boolean selectNewsgroup ( final String newsgroup , final NewsgroupInfo info )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( group ( newsgroup ) ) ) {
return false ;
}
if ( info != null ) {
parseGroupReply ( getReplyString () , info ) ;
}
return true ;
}
public boolean selectNewsgroup ( final String newsgroup ) throws IOException
{
return selectNewsgroup ( newsgroup , null ) ;
}
public String listHelp () throws IOException
{
if ( ! NNTPReply . isInformational ( help () ) ) {
return null ;
}
try ( final StringWriter help = new StringWriter () ;
final BufferedReader reader = new DotTerminatedMessageReader ( _reader_ ) ) {
Util . copyReader ( reader , help ) ;
return help . toString () ;
}
}
public String [] listOverviewFmt () throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( sendCommand ( lr_5 , lr_6 ) ) ) {
return null ;
}
try ( final BufferedReader reader = new DotTerminatedMessageReader ( _reader_ ) ) {
String line ;
final ArrayList < String > list = new ArrayList <> () ;
while ( ( line = reader . readLine () ) != null ) {
list . add ( line ) ;
}
return list . toArray ( new String [ list . size () ] ) ;
}
}
public boolean selectArticle ( final String articleId , final ArticleInfo pointer )
throws IOException
{
if ( articleId != null ) {
if ( ! NNTPReply . isPositiveCompletion ( stat ( articleId ) ) ) {
return false ;
}
} else {
if ( ! NNTPReply . isPositiveCompletion ( stat () ) ) {
return false ;
}
}
if ( pointer != null ) {
parseArticlePointer ( getReplyString () , pointer ) ;
}
return true ;
}
public boolean selectArticle ( final String articleId ) throws IOException
{
return selectArticle ( articleId , ( ArticleInfo ) null ) ;
}
public boolean selectArticle ( final ArticleInfo pointer ) throws IOException
{
return selectArticle ( null , pointer ) ;
}
public boolean selectArticle ( final long articleNumber , final ArticleInfo pointer )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( stat ( articleNumber ) ) ) {
return false ;
}
if ( pointer != null ) {
parseArticlePointer ( getReplyString () , pointer ) ;
}
return true ;
}
public boolean selectArticle ( final long articleNumber ) throws IOException
{
return selectArticle ( articleNumber , null ) ;
}
public boolean selectPreviousArticle ( final ArticleInfo pointer )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( last () ) ) {
return false ;
}
if ( pointer != null ) {
parseArticlePointer ( getReplyString () , pointer ) ;
}
return true ;
}
public boolean selectPreviousArticle () throws IOException
{
return selectPreviousArticle ( ( ArticleInfo ) null ) ;
}
public boolean selectNextArticle ( final ArticleInfo pointer ) throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( next () ) ) {
return false ;
}
if ( pointer != null ) {
parseArticlePointer ( getReplyString () , pointer ) ;
}
return true ;
}
public boolean selectNextArticle () throws IOException
{
return selectNextArticle ( ( ArticleInfo ) null ) ;
}
public NewsgroupInfo [] listNewsgroups () throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( list () ) ) {
return null ;
}
return readNewsgroupListing () ;
}
public Iterable < String > iterateNewsgroupListing () throws IOException {
if ( NNTPReply . isPositiveCompletion ( list () ) ) {
return new ReplyIterator ( _reader_ ) ;
}
throw new IOException ( lr_7 + getReplyString () ) ;
}
public Iterable < NewsgroupInfo > iterateNewsgroups () throws IOException {
return new NewsgroupIterator ( iterateNewsgroupListing () ) ;
}
public NewsgroupInfo [] listNewsgroups ( final String wildmat ) throws IOException
{
if( ! NNTPReply . isPositiveCompletion ( listActive ( wildmat ) ) ) {
return null ;
}
return readNewsgroupListing () ;
}
public Iterable < String > iterateNewsgroupListing ( final String wildmat ) throws IOException {
if( NNTPReply . isPositiveCompletion ( listActive ( wildmat ) ) ) {
return new ReplyIterator ( _reader_ ) ;
}
throw new IOException ( lr_8 + wildmat + lr_9 + getReplyString () ) ;
}
public Iterable < NewsgroupInfo > iterateNewsgroups ( final String wildmat ) throws IOException {
return new NewsgroupIterator ( iterateNewsgroupListing ( wildmat ) ) ;
}
public NewsgroupInfo [] listNewNewsgroups ( final NewGroupsOrNewsQuery query )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( newgroups (
query . getDate () , query . getTime () ,
query . isGMT () , query . getDistributions () ) ) )
{
return null ;
}
return readNewsgroupListing () ;
}
public Iterable < String > iterateNewNewsgroupListing ( final NewGroupsOrNewsQuery query ) throws IOException {
if ( NNTPReply . isPositiveCompletion ( newgroups (
query . getDate () , query . getTime () ,
query . isGMT () , query . getDistributions () ) ) ) {
return new ReplyIterator ( _reader_ ) ;
}
throw new IOException ( lr_10 + getReplyString () ) ;
}
public Iterable < NewsgroupInfo > iterateNewNewsgroups ( final NewGroupsOrNewsQuery query ) throws IOException {
return new NewsgroupIterator ( iterateNewNewsgroupListing ( query ) ) ;
}
public String [] listNewNews ( final NewGroupsOrNewsQuery query )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( newnews ( query . getNewsgroups () , query . getDate () , query . getTime () ,
query . isGMT () , query . getDistributions () ) ) ) {
return null ;
}
final Vector < String > list = new Vector <> () ;
try ( final BufferedReader reader = new DotTerminatedMessageReader ( _reader_ ) ) {
String line ;
while ( ( line = reader . readLine () ) != null ) {
list . addElement ( line ) ;
}
}
final int size = list . size () ;
if ( size < 1 ) {
return new String [ 0 ] ;
}
final String [] result = new String [ size ] ;
list . copyInto ( result ) ;
return result ;
}
public Iterable < String > iterateNewNews ( final NewGroupsOrNewsQuery query ) throws IOException {
if ( NNTPReply . isPositiveCompletion ( newnews (
query . getNewsgroups () , query . getDate () , query . getTime () ,
query . isGMT () , query . getDistributions () ) ) ) {
return new ReplyIterator ( _reader_ ) ;
}
throw new IOException ( lr_11 + getReplyString () ) ;
}
public boolean completePendingCommand () throws IOException
{
return NNTPReply . isPositiveCompletion ( getReply () ) ;
}
public Writer postArticle () throws IOException
{
if ( ! NNTPReply . isPositiveIntermediate ( post () ) ) {
return null ;
}
return new DotTerminatedMessageWriter ( _writer_ ) ;
}
public Writer forwardArticle ( final String articleId ) throws IOException
{
if ( ! NNTPReply . isPositiveIntermediate ( ihave ( articleId ) ) ) {
return null ;
}
return new DotTerminatedMessageWriter ( _writer_ ) ;
}
public boolean logout () throws IOException
{
return NNTPReply . isPositiveCompletion ( quit () ) ;
}
public boolean authenticate ( final String username , final String password )
throws IOException
{
int replyCode = authinfoUser ( username ) ;
if ( replyCode == NNTPReply . MORE_AUTH_INFO_REQUIRED )
{
replyCode = authinfoPass ( password ) ;
if ( replyCode == NNTPReply . AUTHENTICATION_ACCEPTED )
{
this . _isAllowedToPost = true ;
return true ;
}
}
return false ;
}
private BufferedReader __retrieveArticleInfo ( final String articleRange )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( xover ( articleRange ) ) ) {
return null ;
}
return new DotTerminatedMessageReader ( _reader_ ) ;
}
public BufferedReader retrieveArticleInfo ( final long articleNumber ) throws IOException
{
return __retrieveArticleInfo ( Long . toString ( articleNumber ) ) ;
}
public BufferedReader retrieveArticleInfo ( final long lowArticleNumber ,
final long highArticleNumber )
throws IOException
{
return
__retrieveArticleInfo ( lowArticleNumber + lr_12 +
highArticleNumber ) ;
}
public Iterable < Article > iterateArticleInfo ( final long lowArticleNumber , final long highArticleNumber )
throws IOException
{
final BufferedReader info = retrieveArticleInfo ( lowArticleNumber , highArticleNumber ) ;
if ( info == null ) {
throw new IOException ( lr_13 + getReplyString () ) ;
}
return new ArticleIterator ( new ReplyIterator ( info , false ) ) ;
}
private BufferedReader __retrieveHeader ( final String header , final String articleRange )
throws IOException
{
if ( ! NNTPReply . isPositiveCompletion ( xhdr ( header , articleRange ) ) ) {
return null ;
}
return new DotTerminatedMessageReader ( _reader_ ) ;
}
public BufferedReader retrieveHeader ( final String header , final long articleNumber )
throws IOException
{
return __retrieveHeader ( header , Long . toString ( articleNumber ) ) ;
}
public BufferedReader retrieveHeader ( final String header , final long lowArticleNumber ,
final long highArticleNumber )
throws IOException
{
return
__retrieveHeader ( header , lowArticleNumber + lr_12 + highArticleNumber ) ;
}
@Deprecated
public Reader retrieveHeader ( final String header , final int lowArticleNumber , final int highArticleNumber )
throws IOException
{
return retrieveHeader ( header , ( long ) lowArticleNumber , ( long ) highArticleNumber ) ;
}
@Deprecated
public Reader retrieveArticleInfo ( final int lowArticleNumber , final int highArticleNumber ) throws IOException {
return retrieveArticleInfo ( ( long ) lowArticleNumber , ( long ) highArticleNumber ) ;
}
@Deprecated
public Reader retrieveHeader ( final String a , final int b ) throws IOException {
return retrieveHeader ( a , ( long ) b ) ;
}
@Deprecated
public boolean selectArticle ( final int a , final ArticlePointer ap ) throws IOException {
final ArticleInfo ai = ap2ai ( ap ) ;
final boolean b = selectArticle ( a , ai ) ;
ai2ap ( ai , ap ) ;
return b ;
}
@Deprecated
public Reader retrieveArticleInfo ( final int lowArticleNumber ) throws IOException {
return retrieveArticleInfo ( ( long ) lowArticleNumber ) ;
}
@Deprecated
public boolean selectArticle ( final int a ) throws IOException {
return selectArticle ( ( long ) a ) ;
}
@Deprecated
public Reader retrieveArticleHeader ( final int a ) throws IOException {
return retrieveArticleHeader ( ( long ) a ) ;
}
@Deprecated
public Reader retrieveArticleHeader ( final int a , final ArticlePointer ap ) throws IOException {
final ArticleInfo ai = ap2ai ( ap ) ;
final Reader rdr = retrieveArticleHeader ( a , ai ) ;
ai2ap ( ai , ap ) ;
return rdr ;
}
@Deprecated
public Reader retrieveArticleBody ( final int a ) throws IOException {
return retrieveArticleBody ( ( long ) a ) ;
}
@Deprecated
public Reader retrieveArticle ( final int articleNumber , final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final Reader rdr = retrieveArticle ( articleNumber , ai ) ;
ai2ap ( ai , pointer ) ;
return rdr ;
}
@Deprecated
public Reader retrieveArticle ( final int articleNumber ) throws IOException {
return retrieveArticle ( ( long ) articleNumber ) ;
}
@Deprecated
public Reader retrieveArticleBody ( final int a , final ArticlePointer ap ) throws IOException {
final ArticleInfo ai = ap2ai ( ap ) ;
final Reader rdr = retrieveArticleBody ( a , ai ) ;
ai2ap ( ai , ap ) ;
return rdr ;
}
@Deprecated
public Reader retrieveArticle ( final String articleId , final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final Reader rdr = retrieveArticle ( articleId , ai ) ;
ai2ap ( ai , pointer ) ;
return rdr ;
}
@Deprecated
public Reader retrieveArticleBody ( final String articleId , final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final Reader rdr = retrieveArticleBody ( articleId , ai ) ;
ai2ap ( ai , pointer ) ;
return rdr ;
}
@Deprecated
public Reader retrieveArticleHeader ( final String articleId , final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final Reader rdr = retrieveArticleHeader ( articleId , ai ) ;
ai2ap ( ai , pointer ) ;
return rdr ;
}
@Deprecated
public boolean selectArticle ( final String articleId , final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final boolean b = selectArticle ( articleId , ai ) ;
ai2ap ( ai , pointer ) ;
return b ;
}
@Deprecated
public boolean selectArticle ( final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final boolean b = selectArticle ( ai ) ;
ai2ap ( ai , pointer ) ;
return b ;
}
@Deprecated
public boolean selectNextArticle ( final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final boolean b = selectNextArticle ( ai ) ;
ai2ap ( ai , pointer ) ;
return b ;
}
@Deprecated
public boolean selectPreviousArticle ( final ArticlePointer pointer ) throws IOException {
final ArticleInfo ai = ap2ai ( pointer ) ;
final boolean b = selectPreviousArticle ( ai ) ;
ai2ap ( ai , pointer ) ;
return b ;
}
private ArticleInfo ap2ai ( @SuppressWarnings ( lr_14 ) final ArticlePointer ap ) {
if ( ap == null ) {
return null ;
}
final ArticleInfo ai = new ArticleInfo () ;
return ai ;
}
@SuppressWarnings ( lr_14 )
private void ai2ap ( final ArticleInfo ai , final ArticlePointer ap ) {
if ( ap != null ) {
ap . articleId = ai . articleId ;
ap . articleNumber = ( int ) ai . articleNumber ;
}
}
