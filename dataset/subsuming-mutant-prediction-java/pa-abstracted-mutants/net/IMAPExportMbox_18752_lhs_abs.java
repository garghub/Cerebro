@Override MST[rv.ROR3Mutator]MSP[]
public void protocolReplyReceived ( final ProtocolCommandEvent event ) {
if ( event . getReplyCode () != IMAPReply . PARTIAL ) {
super . protocolReplyReceived ( event ) ;
}
}
private static boolean startsWith ( final String input , final Pattern pat ) {
final Matcher m = pat . matcher ( input ) ;
return m . lookingAt () ;
}
private static String matches ( final String input , final Pattern pat , final int index ) {
final Matcher m = pat . matcher ( input ) ;
if ( m . lookingAt () ) {
return m . group ( index ) ;
}
return null ;
}
@Override
public boolean chunkReceived ( final IMAP imap ) {
final String [] replyStrings = imap . getReplyStrings () ;
Date received = new Date () ;
final String firstLine = replyStrings [ 0 ] ;
Matcher m = PATID . matcher ( firstLine ) ;
if ( m . lookingAt () ) {
final String date = m . group ( PATID_DATE_GROUP ) ;
try {
received = IDPARSE . parse ( date ) ;
} catch ( final ParseException e ) {
System . err . println ( e ) ;
}
} else {
System . err . println ( lr_1 + firstLine + lr_2 ) ;
}
String replyTo = lr_3 ;
for( int i = 1 ; i < replyStrings . length - 1 ; i ++ ) {
final String line = replyStrings [ i ] ;
if ( line . startsWith ( lr_4 ) ) {
final String [] parts = line . split ( lr_5 , 2 ) ;
if ( ! parts [ 1 ] . equals ( lr_6 ) ) {
replyTo = parts [ 1 ] ;
if ( replyTo . startsWith ( lr_7 ) ) {
if ( replyTo . endsWith ( lr_8 ) ) {
replyTo = replyTo . substring ( 1 , replyTo . length () - 1 ) ;
} else {
System . err . println ( lr_9 + line + lr_10 + firstLine ) ;
}
}
}
break;
}
}
try {
bw . append ( lr_11 ) ;
bw . append ( replyTo ) ;
bw . append ( ' ' ) ;
bw . append ( DATE_FORMAT . format ( received ) ) ;
bw . append ( eol ) ;
bw . append ( lr_12 ) . append ( firstLine ) . append ( eol ) ;
if ( printMarker ) {
System . err . println ( lr_13 + total + lr_14 + firstLine ) ;
}
for( int i = 1 ; i < replyStrings . length - 1 ; i ++ ) {
final String line = replyStrings [ i ] ;
if ( startsWith ( line , PATFROM ) ) {
bw . append ( '>' ) ;
}
bw . append ( line ) ;
bw . append ( eol ) ;
}
final String lastLine = replyStrings [ replyStrings . length - 1 ] ;
final int lastLength = lastLine . length () ;
if ( lastLength > 1 ) {
bw . append ( lastLine , 0 , lastLength - 1 ) ;
bw . append ( eol ) ;
}
bw . append ( eol ) ;
} catch ( final IOException e ) {
e . printStackTrace () ;
throw new RuntimeException ( e ) ;
}
lastFetched = firstLine ;
total ++ ;
if ( checkSequence ) {
m = PATSEQ . matcher ( firstLine ) ;
if ( m . lookingAt () ) {
final long msgSeq = Long . parseLong ( m . group ( PATSEQ_SEQUENCE_GROUP ) ) ;
if ( lastSeq != - 1 ) {
final long missing = msgSeq - lastSeq - 1 ;
if ( missing != 0 ) {
for( long j = lastSeq + 1 ; j < msgSeq ; j ++ ) {
missingIds . add ( String . valueOf ( j ) ) ;
}
System . err . println (
lr_15 + msgSeq + lr_16 + lastSeq + lr_17 + missing ) ;
}
}
lastSeq = msgSeq ;
}
}
if ( printHash ) {
System . err . print ( lr_18 ) ;
}
return true ;
}
public void close () throws IOException {
if ( bw != null ) {
bw . close () ;
}
}
