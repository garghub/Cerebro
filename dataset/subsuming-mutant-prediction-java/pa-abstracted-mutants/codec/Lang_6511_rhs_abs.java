public boolean matches ( final String txt ) {
return this . pattern . matcher ( txt ) . find () ;
}
public static Lang instance ( final NameType nameType ) {
return Langs . get ( nameType ) ;
}
public static Lang loadFromResource ( final String languageRulesResourceName , final Languages languages ) {
final List < LangRule > rules = new ArrayList <> () ;
try ( final Scanner scanner = new Scanner ( Resources . getInputStream ( languageRulesResourceName ) ,
ResourceConstants . ENCODING ) ) {
boolean inExtendedComment = false ;
while ( scanner . hasNextLine () ) {
final String rawLine = scanner . nextLine () ;
String line = rawLine ;
if ( inExtendedComment ) {
if ( line . endsWith ( ResourceConstants . EXT_CMT_END ) ) {
inExtendedComment = false ;
}
} else {
if ( line . startsWith ( ResourceConstants . EXT_CMT_START ) ) {
inExtendedComment = true ;
} else {
final int cmtI = line . indexOf ( ResourceConstants . CMT ) ;
if ( cmtI >= 0 ) {
line = line . substring ( 0 , cmtI ) ;
}
line = line . trim () ;
if ( line . length () == 0 ) {
continue;
}
final String [] parts = line . split ( lr_1 ) ;
if ( parts . length != 3 ) {
throw new IllegalArgumentException ( lr_2 + rawLine +
lr_3 + languageRulesResourceName + lr_4 ) ;
}
final Pattern pattern = Pattern . compile ( parts [ 0 ] ) ;
final String [] langs = parts [ 1 ] . split ( lr_5 ) ;
final boolean accept = parts [ 2 ] . equals ( lr_6 ) ;
rules . add ( new LangRule ( pattern , new HashSet <> ( Arrays . asList ( langs ) ) , accept ) ) ; MST[rv.UOI1Mutator]MSP[N]
}
}
}
}
return new Lang ( rules , languages ) ;
}
public String guessLanguage ( final String text ) {
final Languages . LanguageSet ls = guessLanguages ( text ) ;
return ls . isSingleton () ? ls . getAny () : Languages . ANY ;
}
public Languages . LanguageSet guessLanguages ( final String input ) {
final String text = input . toLowerCase ( Locale . ENGLISH ) ;
final Set < String > langs = new HashSet <> ( this . languages . getLanguages () ) ;
for ( final LangRule rule : this . rules ) {
if ( rule . matches ( text ) ) {
if ( rule . acceptOnMatch ) {
langs . retainAll ( rule . languages ) ;
} else {
langs . removeAll ( rule . languages ) ;
}
}
}
final Languages . LanguageSet ls = Languages . LanguageSet . from ( langs ) ;
return ls . equals ( Languages . NO_LANGUAGES ) ? Languages . ANY_LANGUAGE : ls ;
}
