public void testFTPClientConfigString () {
final FTPClientConfig config = new FTPClientConfig ( FTPClientConfig . SYST_VMS ) ;
assertEquals ( FTPClientConfig . SYST_VMS , config . getServerSystemKey () ) ;
assertNull ( config . getDefaultDateFormatStr () ) ;
assertNull ( config . getRecentDateFormatStr () ) ;
assertNull ( config . getShortMonthNames () ) ;
assertNull ( config . getServerTimeZoneId () ) ;
assertNull ( config . getServerLanguageCode () ) ;
}
public void testFTPClientConfigStringStringStringStringStringString () {
final FTPClientConfig conf = new FTPClientConfig ( A , B , C , D , E , F ) ;
assertEquals ( lr_1 , conf . getServerSystemKey () ) ;
assertEquals ( lr_2 , conf . getDefaultDateFormatStr () ) ;
assertEquals ( lr_3 , conf . getRecentDateFormatStr () ) ;
assertEquals ( lr_4 , conf . getShortMonthNames () ) ;
assertEquals ( lr_5 , conf . getServerTimeZoneId () ) ;
assertEquals ( lr_6 , conf . getServerLanguageCode () ) ;
}
public void testSetShortMonthNames () {
}
public void testGetServerLanguageCode () {
}
public void testLookupDateFormatSymbols () {
DateFormatSymbols dfs1 = null ;
DateFormatSymbols dfs2 = null ;
DateFormatSymbols dfs3 = null ;
DateFormatSymbols dfs4 = null ;
try {
dfs1 = FTPClientConfig . lookupDateFormatSymbols ( lr_7 ) ;
} catch ( final IllegalArgumentException e ) {
fail ( lr_8 ) ;
}
try {
dfs2 = FTPClientConfig . lookupDateFormatSymbols ( lr_9 ) ;
} catch ( final IllegalArgumentException e ) {
fail ( lr_10 ) ;
}
try {
dfs3 = FTPClientConfig . lookupDateFormatSymbols ( lr_11 ) ;
} catch ( final IllegalArgumentException e ) {
fail ( lr_12 ) ;
}
try {
dfs4 = FTPClientConfig . lookupDateFormatSymbols ( fakeLang ) ;
} catch ( final IllegalArgumentException e ) {
fail ( lr_13 ) ;
}
assertEquals ( dfs3 , dfs4 ) ;
final SimpleDateFormat sdf1 = new SimpleDateFormat ( lr_14 , dfs1 ) ;
final SimpleDateFormat sdf2 = new SimpleDateFormat ( lr_15 , dfs2 ) ;
final SimpleDateFormat sdf3 = new SimpleDateFormat ( lr_15 , dfs3 ) ;
Date d1 = null ;
Date d2 = null ;
Date d3 = null ;
try {
d1 = sdf1 . parse ( lr_16 ) ;
} catch ( final ParseException px ) {
fail ( lr_17 ) ;
}
try {
d2 = sdf2 . parse ( lr_18 ) ;
} catch ( final ParseException px ) {
fail ( lr_19 ) ;
}
try {
d3 = sdf3 . parse ( lr_20 ) ;
} catch ( final ParseException px ) {
fail ( lr_21 ) ;
}
assertEquals ( lr_22 , d1 , d2 ) ;
assertEquals ( lr_22 , d1 , d3 ) ;
}
public void testGetDateFormatSymbols () {
try {
FTPClientConfig . getDateFormatSymbols ( badDelim ) ;
fail ( lr_23 ) ;
} catch ( final IllegalArgumentException e ) {
}
try {
FTPClientConfig . getDateFormatSymbols ( tooLong ) ;
fail ( lr_24 ) ;
} catch ( final IllegalArgumentException e ) {
}
try {
FTPClientConfig . getDateFormatSymbols ( tooShort ) ;
fail ( lr_25 ) ;
} catch ( final IllegalArgumentException e ) {
}
DateFormatSymbols dfs2 = null ;
try {
dfs2 = FTPClientConfig . getDateFormatSymbols ( fakeLang ) ;
} catch ( final Exception e ) {
fail ( lr_26 ) ;
}
final SimpleDateFormat sdf1 =
new SimpleDateFormat ( lr_15 , Locale . ENGLISH ) ;
final SimpleDateFormat sdf2 = new SimpleDateFormat ( lr_15 , dfs2 ) ;
Date d1 = null ;
Date d2 = null ;
try {
d1 = sdf1 . parse ( lr_27 ) ;
} catch ( final ParseException px ) {
fail ( lr_28 ) ;
}
try {
d2 = sdf2 . parse ( lr_29 ) ;
} catch ( final ParseException px ) {
fail ( lr_30 ) ;
}
assertEquals ( lr_22 , d1 , d2 ) ;
try {
sdf1 . parse ( lr_29 ) ;
fail ( lr_31 ) ;
} catch ( final ParseException px ) {
}
try {
sdf2 . parse ( lr_27 ) ;
fail ( lr_32 ) ;
} catch ( final ParseException px ) {
}
}
