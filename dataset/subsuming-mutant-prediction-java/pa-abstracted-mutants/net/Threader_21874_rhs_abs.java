public Threadable thread ( final List < ? extends Threadable > messages ) {
return thread ( ( Iterable < ? extends Threadable > ) messages ) ;
}
public Threadable thread ( final Iterable < ? extends Threadable > messages ) {
if ( messages == null ) {
return null ;
}
HashMap < String , ThreadContainer > idTable = new HashMap <> () ;
for ( final Threadable t : messages ) {
if ( ! t . isDummy () ) {
buildContainer ( t , idTable ) ;
}
}
if ( idTable . isEmpty () ) {
return null ;
}
final ThreadContainer root = findRootSet ( idTable ) ;
idTable . clear () ;
idTable = null ;
pruneEmptyContainers ( root ) ;
root . reverseChildren () ;
gatherSubjects ( root ) ;
if ( root . next != null ) {
throw new RuntimeException ( lr_1 + root ) ;
}
for ( ThreadContainer r = root . child ; r != null ; r = r . next ) {
if ( r . threadable == null ) {
r . threadable = r . child . threadable . makeDummy () ;
}
}
final Threadable result = ( root . child == null ? null : root . child . threadable ) ;
root . flush () ;
return result ;
}
private void buildContainer ( final Threadable threadable , final HashMap < String , ThreadContainer > idTable ) {
String id = threadable . messageThreadId () ;
ThreadContainer container = idTable . get ( id ) ;
int bogusIdCount = 0 ;
if ( container != null ) {
if ( container . threadable != null ) {
bogusIdCount ++ ;
id = lr_2 + ( bogusIdCount ) + lr_3 ;
container = null ;
} else {
container . threadable = threadable ;
}
}
if ( container == null ) {
container = new ThreadContainer () ;
container . threadable = threadable ;
idTable . put ( id , container ) ;
}
ThreadContainer parentRef = null ;
{
final String [] references = threadable . messageThreadReferences () ;
for ( final String refString : references )
{
ThreadContainer ref = idTable . get ( refString ) ;
if ( ref == null ) {
ref = new ThreadContainer () ;
idTable . put ( refString , ref ) ;
}
if ( ( parentRef != null )
&& ( ref . parent == null )
&& ( parentRef != ref )
&& ! ( ref . findChild ( parentRef ) ) ) {
ref . parent = parentRef ;
ref . next = parentRef . child ;
parentRef . child = ref ;
}
parentRef = ref ;
}
}
if ( parentRef != null
&& ( parentRef == container || container . findChild ( parentRef ) ) )
{
parentRef = null ;
}
if ( container . parent != null ) {
ThreadContainer rest , prev ;
for ( prev = null , rest = container . parent . child ;
rest != null ;
prev = rest , rest = rest . next ) {
if ( rest == container ) {
break;
}
}
if ( rest == null ) {
throw new RuntimeException (
lr_4
+ container
+ lr_5
+ container . parent ) ;
}
if ( prev == null ) {
container . parent . child = container . next ;
} else {
prev . next = container . next ;
}
container . next = null ;
container . parent = null ;
}
if ( parentRef != null ) {
container . parent = parentRef ;
container . next = parentRef . child ;
parentRef . child = container ;
}
}
private ThreadContainer findRootSet ( final HashMap < String , ThreadContainer > idTable ) {
final ThreadContainer root = new ThreadContainer () ;
final Iterator < Map . Entry < String , ThreadContainer > > iter = idTable . entrySet () . iterator () ;
while ( iter . hasNext () ) {
final Map . Entry < String , ThreadContainer > entry = iter . next () ;
final ThreadContainer c = entry . getValue () ;
if ( c . parent == null ) {
if ( c . next != null ) {
throw new RuntimeException (
lr_6 + c . next . toString () ) ;
}
c . next = root . child ;
root . child = c ;
}
}
return root ;
}
private void pruneEmptyContainers ( final ThreadContainer parent ) {
ThreadContainer container , prev , next ;
for ( prev = null , container = parent . child , next = container . next ;
container != null ;
prev = container ,
container = next ,
next = ( container == null ? null : container . next ) ) {
if ( container . threadable == null && container . child == null ) {
if ( prev == null ) {
parent . child = container . next ;
} else {
prev . next = container . next ;
}
container = prev ;
}
else if (
container . threadable == null
&& container . child != null
&& ( container . parent != null
|| container . child . next == null ) ) {
ThreadContainer tail ;
final ThreadContainer kids = container . child ;
if ( prev == null ) {
parent . child = kids ;
} else {
prev . next = kids ;
}
for ( tail = kids ; tail . next != null ; tail = tail . next ) {
tail . parent = container . parent ;
}
tail . parent = container . parent ;
tail . next = container . next ;
next = kids ;
container = prev ;
} else if ( container . child != null ) {
pruneEmptyContainers ( container ) ;
}
}
}
private void gatherSubjects ( final ThreadContainer root ) {
int count = 0 ; MST[NegateConditionalsMutator]MSP[N]
for ( ThreadContainer c = root . child ; c != null ; c = c . next ) {
count ++ ;
}
HashMap < String , ThreadContainer > subjectTable = new HashMap <> ( (int) ( count * 1.2 ) , ( float ) 0.9 ) ;
count = 0 ;
for ( ThreadContainer c = root . child ; c != null ; c = c . next ) {
Threadable threadable = c . threadable ;
if ( threadable == null ) {
threadable = c . child . threadable ;
}
final String subj = threadable . simplifiedSubject () ;
if ( subj == null || subj . length () == 0 ) {
continue;
}
final ThreadContainer old = subjectTable . get ( subj ) ;
if ( old == null
|| ( c . threadable == null && old . threadable != null )
|| ( old . threadable != null
&& old . threadable . subjectIsReply ()
&& c . threadable != null
&& ! c . threadable . subjectIsReply () ) ) {
subjectTable . put ( subj , c ) ;
count ++ ;
}
}
if ( count == 0 ) {
return;
}
ThreadContainer prev , c , rest ;
for ( prev = null , c = root . child , rest = c . next ;
c != null ;
prev = c , c = rest , rest = ( rest == null ? null : rest . next ) ) {
Threadable threadable = c . threadable ;
if ( threadable == null ) {
threadable = c . child . threadable ;
}
final String subj = threadable . simplifiedSubject () ;
if ( subj == null || subj . length () == 0 ) {
continue;
}
final ThreadContainer old = subjectTable . get ( subj ) ;
if ( old == c ) {
continue;
}
if ( prev == null ) {
root . child = c . next ;
} else {
prev . next = c . next ;
}
c . next = null ;
if ( old . threadable == null && c . threadable == null ) {
ThreadContainer tail ;
for ( tail = old . child ;
tail != null && tail . next != null ;
tail = tail . next ) {
}
if ( tail != null ) {
tail . next = c . child ;
}
for ( tail = c . child ; tail != null ; tail = tail . next ) {
tail . parent = old ;
}
c . child = null ;
} else if (
old . threadable == null
|| ( c . threadable != null
&& c . threadable . subjectIsReply ()
&& ! old . threadable . subjectIsReply () ) ) {
c . parent = old ;
c . next = old . child ;
old . child = c ;
} else {
final ThreadContainer newc = new ThreadContainer () ;
newc . threadable = old . threadable ;
newc . child = old . child ;
for ( ThreadContainer tail = newc . child ;
tail != null ;
tail = tail . next )
{
tail . parent = newc ;
}
old . threadable = null ;
old . child = null ;
c . parent = old ;
newc . parent = old ;
old . child = c ;
c . next = newc ;
}
c = prev ;
}
subjectTable . clear () ;
subjectTable = null ;
}
@Deprecated
public Threadable thread ( final Threadable [] messages ) {
if ( messages == null ) {
return null ;
}
return thread ( Arrays . asList ( messages ) ) ;
}
