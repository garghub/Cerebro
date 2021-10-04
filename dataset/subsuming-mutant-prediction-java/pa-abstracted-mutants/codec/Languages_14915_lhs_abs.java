public static LanguageSet from ( final Set < String > langs ) {
return langs . isEmpty () ? NO_LANGUAGES : new SomeLanguages ( langs ) ;
}
@Override
public boolean contains ( final String language ) {
return this . languages . contains ( language ) ;
}
@Override
public String getAny () {
return this . languages . iterator () . next () ;
}
public Set < String > getLanguages () {
return this . languages ;
}
@Override
public boolean isEmpty () {
return this . languages . isEmpty () ;
}
@Override
public boolean isSingleton () {
return this . languages . size () == 1 ;
}
@Override
public LanguageSet restrictTo ( final LanguageSet other ) {
if ( other == NO_LANGUAGES ) {
return other ;
} else if ( other == ANY_LANGUAGE ) {
return this ;
} else {
final SomeLanguages sl = ( SomeLanguages ) other ;
final Set < String > ls = new HashSet <> ( Math . min ( languages . size () , sl . languages . size () ) ) ;
for ( final String lang : languages ) {
if ( sl . languages . contains ( lang ) ) {
ls . add ( lang ) ;
}
}
return from ( ls ) ;
}
}
@Override
public LanguageSet merge ( final LanguageSet other ) {
if ( other == NO_LANGUAGES ) {
return this ;
} else if ( other == ANY_LANGUAGE ) {
return other ;
} else {
final SomeLanguages sl = ( SomeLanguages ) other ;
final Set < String > ls = new HashSet <> ( languages ) ;
for ( final String lang : sl . languages ) {
ls . add ( lang ) ;
}
return from ( ls ) ;
}
}
@Override
public String toString () {
return lr_1 + languages . toString () + lr_2 ;
}
public static Languages getInstance ( final NameType nameType ) {
return LANGUAGES . get ( nameType ) ;
}
public static Languages getInstance ( final String languagesResourceName ) {
final Set < String > ls = new HashSet <> () ;
try ( final Scanner lsScanner = new Scanner ( Resources . getInputStream ( languagesResourceName ) ,
ResourceConstants . ENCODING ) ) {
boolean inExtendedComment = false ;
while ( lsScanner . hasNextLine () ) {
final String line = lsScanner . nextLine () . trim () ;
if ( inExtendedComment ) {
if ( line . endsWith ( ResourceConstants . EXT_CMT_END ) ) {
inExtendedComment = false ;
}
} else {
if ( line . startsWith ( ResourceConstants . EXT_CMT_START ) ) {
inExtendedComment = true ;
} else if ( line . length () > 0 ) {
ls . add ( line ) ;
}
}
}
return new Languages ( Collections . unmodifiableSet ( ls ) ) ;
}
}
private static String langResourceName ( final NameType nameType ) {
return String . format ( lr_3 , nameType . getName () ) ;
}
@Override
public boolean contains ( final String language ) {
return false ;
}
@Override
public String getAny () {
throw new NoSuchElementException ( lr_4 ) ;
}
@Override
public boolean isEmpty () {
return true ;
}
@Override
public boolean isSingleton () {
return false ;
}
@Override
public LanguageSet restrictTo ( final LanguageSet other ) {
return this ;
}
@Override
public LanguageSet merge ( final LanguageSet other ) {
return other ;
}
@Override
public String toString () {
return lr_5 ;
}
@Override
public boolean contains ( final String language ) {
return true ; MST[rv.CRCR3Mutator]MSP[]
}
@Override
public String getAny () {
throw new NoSuchElementException ( lr_6 ) ;
}
@Override
public boolean isEmpty () {
return false ;
}
@Override
public boolean isSingleton () {
return false ;
}
@Override
public LanguageSet restrictTo ( final LanguageSet other ) {
return other ;
}
@Override
public LanguageSet merge ( final LanguageSet other ) {
return other ;
}
@Override
public String toString () {
return lr_7 ;
}
public Set < String > getLanguages () {
return this . languages ;
}
