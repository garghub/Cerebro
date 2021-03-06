@Override
public Writer append ( final char c ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . append ( c ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
return this ;
}
@Override
public Writer append ( final CharSequence csq ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . append ( csq ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
return this ;
}
@Override
public Writer append ( final CharSequence csq , final int start , final int end ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . append ( csq , start , end ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
return this ;
}
@Override
public void close () throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . close () ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
}
@Override
public void flush () throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . flush () ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
}
@Override
public void write ( final char cbuf [] , final int off , final int len ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . write ( cbuf , off , len ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
}
@Override
public void write ( final char [] cbuf ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . write ( cbuf ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
}
@Override
public void write ( final int c ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . write ( c ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
}
@Override
public void write ( final String str ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . write ( str ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
}
@Override
public void write ( final String str , final int off , final int len ) throws IOException {
final List < Exception > causeList = new ArrayList <> () ;
int i = 0 ;
for ( final Writer w : writers ) {
if ( w != null ) {
try {
w . write ( str , off , len ) ;
} catch ( final IOException e ) {
causeList . add ( new IOIndexedException ( i , e ) ) ;
}
}
i ++ ;
}
if ( ! causeList . isEmpty () ) {
throw new IOExceptionList ( causeList ) ;
}
}
