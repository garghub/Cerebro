public static Locale toLocale ( final String str ) {
if ( str == null ) {
return null ;
}
if ( str . isEmpty () ) {
return new Locale ( lr_1 , lr_1 ) ;
}
if ( str . contains ( lr_2 ) ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
final int len = str . length () ;
if ( len < 2 ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
final char ch0 = str . charAt ( 0 ) ;
if ( ch0 == '_' ) {
if ( len < 3 ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
final char ch1 = str . charAt ( 1 ) ;
final char ch2 = str . charAt ( 2 ) ;
if ( ! Character . isUpperCase ( ch1 ) || ! Character . isUpperCase ( ch2 ) ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
if ( len == 3 ) {
return new Locale ( lr_1 , str . substring ( 1 , 3 ) ) ;
}
if ( len < 5 ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
if ( str . charAt ( 3 ) != '_' ) {
throw new IllegalArgumentException ( lr_3 + str ) ;
}
return new Locale ( lr_1 , str . substring ( 1 , 3 ) , str . substring ( 4 ) ) ;
}
final String [] split = str . split ( lr_4 , - 1 ) ;
final int occurrences = split . length - 1 ;
switch ( occurrences ) {
case 0 :
if ( StringUtils . isAllLowerCase ( str ) && ( len == 2 || len == 3 ) ) {
return new Locale ( str ) ;
}
throw new IllegalArgumentException ( lr_3 + str ) ;
case 1 :
if ( StringUtils . isAllLowerCase ( split [ 0 ] ) &&
( split [ 0 ] . length () == 2 || split [ 0 ] . length () == 3 ) &&
split [ 1 ] . length () == 2 && StringUtils . isAllUpperCase ( split [ 1 ] ) ) {
return new Locale ( split [ 0 ] , split [ 1 ] ) ;
}
throw new IllegalArgumentException ( lr_3 + str ) ;
case 2 :
if ( StringUtils . isAllLowerCase ( split [ 0 ] ) &&
( split [ 0 ] . length () == 2 || split [ 0 ] . length () == 3 ) &&
( split [ 1 ] . length () == 0 || ( split [ 1 ] . length () == 2 && StringUtils . isAllUpperCase ( split [ 1 ] ) ) ) &&
split [ 2 ] . length () > 0 ) {
return new Locale ( split [ 0 ] , split [ 1 ] , split [ 2 ] ) ;
}
default:
throw new IllegalArgumentException ( lr_3 + str ) ;
}
}
public static List < Locale > localeLookupList ( final Locale locale ) {
return localeLookupList ( locale , locale ) ;
}
public static List < Locale > localeLookupList ( final Locale locale , final Locale defaultLocale ) {
final List < Locale > list = new ArrayList < Locale > ( 4 ) ;
if ( locale != null ) {
list . add ( locale ) ;
if ( locale . getVariant () . length () > 0 ) {
list . add ( new Locale ( locale . getLanguage () , locale . getCountry () ) ) ;
}
if ( locale . getCountry () . length () > 0 ) {
list . add ( new Locale ( locale . getLanguage () , lr_1 ) ) ;
}
if ( list . contains ( defaultLocale ) == false ) {
list . add ( defaultLocale ) ;
}
}
return Collections . unmodifiableList ( list ) ;
}
public static List < Locale > availableLocaleList () {
return SyncAvoid . AVAILABLE_LOCALE_LIST ;
}
public static Set < Locale > availableLocaleSet () {
return SyncAvoid . AVAILABLE_LOCALE_SET ;
}
public static boolean isAvailableLocale ( final Locale locale ) {
return availableLocaleList () . contains ( locale ) ;
}
public static List < Locale > languagesByCountry ( final String countryCode ) {
if ( countryCode == null ) {
return Collections . emptyList () ;
}
List < Locale > langs = cLanguagesByCountry . get ( countryCode ) ;
if ( langs == null ) {
langs = new ArrayList < Locale > () ;
final List < Locale > locales = availableLocaleList () ;
for ( int i = 0 ; i < locales . size () ; i ++ ) {
final Locale locale = locales . get ( i ) ;
if ( countryCode . equals ( locale . getCountry () ) &&
locale . getVariant () . isEmpty () ) {
langs . add ( locale ) ;
}
}
langs = Collections . unmodifiableList ( langs ) ;
cLanguagesByCountry . putIfAbsent ( countryCode , langs ) ;
langs = cLanguagesByCountry . get ( countryCode ) ;
}
return langs ;
}
public static List < Locale > countriesByLanguage ( final String languageCode ) {
if ( languageCode == null ) {
return Collections . emptyList () ;
}
List < Locale > countries = cCountriesByLanguage . get ( languageCode ) ;
if ( countries == null ) {
countries = new ArrayList < Locale > () ;
final List < Locale > locales = availableLocaleList () ;
for ( int i = 0 ; i < locales . size () ; i ++ ) {
final Locale locale = locales . get ( i ) ;
if ( languageCode . equals ( locale . getLanguage () ) &&
locale . getCountry () . length () != 0 &&
locale . getVariant () . isEmpty () ) {
countries . add ( locale ) ;
}
}
countries = Collections . unmodifiableList ( countries ) ;
cCountriesByLanguage . putIfAbsent ( languageCode , countries ) ;
countries = cCountriesByLanguage . get ( languageCode ) ;
}
return countries ;
}
