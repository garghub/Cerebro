public void addReference ( final String msgId ) {
if ( msgId == null || msgId . length () == 0 ) {
return;
}
if ( references == null ) {
references = new ArrayList <> () ;
}
isReply = true ;
for( final String s : msgId . split ( lr_1 ) ) {
references . add ( s ) ;
}
}
public String [] getReferences () {
if ( references == null ) {
return new String [ 0 ] ;
}
return references . toArray ( new String [ references . size () ] ) ;
}
private void simplifySubject () {
int start = 0 ;
final String subject = getSubject () ;
final int len = subject . length () ;
boolean done = false ;
while ( ! done ) {
done = true ;
while ( start < len && subject . charAt ( start ) == ' ' ) {
start ++ ;
}
if ( start < ( len - 2 )
&& ( subject . charAt ( start ) == 'r' || subject . charAt ( start ) == 'R' )
&& ( subject . charAt ( start + 1 ) == 'e' || subject . charAt ( start + 1 ) == 'E' ) ) {
if ( subject . charAt ( start + 2 ) == ':' ) {
start += 3 ;
done = false ;
} else if (
start < ( len - 2 )
&&
( subject . charAt ( start + 2 ) == '[' || subject . charAt ( start + 2 ) == '(' ) ) {
int i = start + 3 ;
while ( i < len && subject . charAt ( i ) >= '0' && subject . charAt ( i ) <= '9' ) {
i ++ ;
}
if ( i < ( len - 1 )
&& ( subject . charAt ( i ) == ']' || subject . charAt ( i ) == ')' )
&& subject . charAt ( i + 1 ) == ':' )
{
start = i + 2 ;
done = false ;
}
}
}
if ( lr_2 . equals ( simplifiedSubject ) ) {
simplifiedSubject = lr_3 ;
}
int end = len ;
while ( end > start && subject . charAt ( end - 1 ) < ' ' ) {
end -- ;
}
if ( start == 0 && end == len ) {
simplifiedSubject = subject ;
} else {
simplifiedSubject = subject . substring ( start , end ) ;
}
}
}
public static void printThread ( final Article article ) {
printThread ( article , 0 , System . out ) ;
}
public static void printThread ( final Article article , final PrintStream ps ) {
printThread ( article , 0 , ps ) ;
}
public static void printThread ( final Article article , final int depth ) { MST[VoidMethodCallMutator]MSP[]
printThread ( article , depth , System . out ) ;
}
public static void printThread ( final Article article , final int depth , final PrintStream ps ) {
for ( int i = 0 ; i < depth ; ++ i ) {
ps . print ( lr_4 ) ;
}
ps . println ( article . getSubject () + lr_5 + article . getFrom () + lr_5 + article . getArticleId () ) ;
if ( article . kid != null ) {
printThread ( article . kid , depth + 1 ) ;
}
if ( article . next != null ) {
printThread ( article . next , depth ) ;
}
}
public String getArticleId () {
return articleId ;
}
public long getArticleNumberLong () {
return articleNumber ;
}
public String getDate () {
return date ;
}
public String getFrom () {
return from ;
}
public String getSubject () {
return subject ;
}
public void setArticleId ( final String string ) {
articleId = string ;
}
public void setArticleNumber ( final long l ) {
articleNumber = l ;
}
public void setDate ( final String string ) {
date = string ;
}
public void setFrom ( final String string ) {
from = string ;
}
public void setSubject ( final String string ) {
subject = string ;
}
@Override
public boolean isDummy () {
return ( articleNumber == - 1 ) ;
}
@Override
public String messageThreadId () {
return articleId ;
}
@Override
public String [] messageThreadReferences () {
return getReferences () ;
}
@Override
public String simplifiedSubject () {
if( simplifiedSubject == null ) {
simplifySubject () ;
}
return simplifiedSubject ;
}
@Override
public boolean subjectIsReply () {
return isReply ;
}
@Override
public void setChild ( final Threadable child ) {
this . kid = ( Article ) child ;
flushSubjectCache () ;
}
private void flushSubjectCache () {
simplifiedSubject = null ;
}
@Override
public void setNext ( final Threadable next ) {
this . next = ( Article ) next ;
flushSubjectCache () ;
}
@Override
public Threadable makeDummy () {
return new Article () ;
}
@Override
public String toString () {
return articleNumber + lr_1 + articleId + lr_1 + subject ;
}
@Deprecated
public int getArticleNumber () {
return ( int ) articleNumber ;
}
@Deprecated
public void setArticleNumber ( final int a ) {
articleNumber = a ;
}
@Deprecated
public void addHeaderField ( final String name , final String val ) {
}
