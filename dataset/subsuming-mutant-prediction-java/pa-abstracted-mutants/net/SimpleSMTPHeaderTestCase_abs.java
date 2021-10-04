@Before
public void setUp () {
beforeDate = new Date () ;
header = new SimpleSMTPHeader ( lr_1 , lr_2 , lr_3 ) ;
}
@Test
public void testToString () {
assertNotNull ( header ) ;
assertEquals ( lr_4 , checkDate ( header . toString () ) ) ;
}
@Test
public void testToStringNoSubject () {
final SimpleSMTPHeader hdr = new SimpleSMTPHeader ( lr_1 , lr_2 , null ) ;
assertNotNull ( hdr ) ;
assertEquals ( lr_5 , checkDate ( hdr . toString () ) ) ;
}
@Test ( expected = IllegalArgumentException . class )
public void testToStringNoFrom () {
new SimpleSMTPHeader ( null , null , null ) ;
}
@Test
public void testToStringNoTo () {
final SimpleSMTPHeader hdr = new SimpleSMTPHeader ( lr_1 , null , null ) ;
assertNotNull ( hdr ) ;
assertEquals ( lr_6 , checkDate ( hdr . toString () ) ) ;
}
@Test
public void testToStringAddHeader () {
final SimpleSMTPHeader hdr = new SimpleSMTPHeader ( lr_1 , null , null ) ;
assertNotNull ( hdr ) ;
hdr . addHeaderField ( lr_7 , lr_8 ) ;
hdr . addHeaderField ( lr_9 , lr_10 ) ;
assertEquals ( lr_11 , checkDate ( hdr . toString () ) ) ;
}
@Test
public void testToStringAddHeaderDate () {
final SimpleSMTPHeader hdr = new SimpleSMTPHeader ( lr_1 , null , null ) ;
assertNotNull ( hdr ) ;
hdr . addHeaderField ( lr_12 , lr_13 ) ;
assertEquals ( lr_14 , hdr . toString () ) ;
}
private String checkDate ( final String msg ) {
final Pattern pat = Pattern . compile ( lr_15 , Pattern . MULTILINE ) ;
final Matcher m = pat . matcher ( msg ) ;
if ( m . find () ) {
final String date = m . group ( 2 ) ;
final String pattern = lr_16 ;
final SimpleDateFormat format = new SimpleDateFormat ( pattern , Locale . ENGLISH ) ;
try {
final Date sentDate = format . parse ( date ) ;
final long sentSecs = sentDate . getTime () / 1000 ;
final long beforeDateSecs = beforeDate . getTime () / 1000 ;
final Date afterDate = new Date () ;
final long afterDateSecs = afterDate . getTime () / 1000 ;
if ( sentSecs < beforeDateSecs ) {
fail ( sentDate + lr_17 + beforeDate ) ;
}
if ( sentSecs > afterDateSecs ) {
fail ( sentDate + lr_18 + afterDate ) ;
}
} catch ( final ParseException e ) {
fail ( lr_19 + e ) ;
}
final int start = m . start ( 1 ) ;
final int end = m . end ( 1 ) ;
if ( start == 0 ) {
return msg . substring ( end + 1 ) ;
}
return msg . substring ( 0 , start ) + msg . substring ( end + 1 ) ;
}
fail ( lr_20 + msg ) ;
return null ;
}
