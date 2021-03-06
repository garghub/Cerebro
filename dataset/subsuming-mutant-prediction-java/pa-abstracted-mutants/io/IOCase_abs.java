public static IOCase forName ( final String name ) {
for ( final IOCase ioCase : IOCase . values () )
{
if ( ioCase . getName () . equals ( name ) )
{
return ioCase ;
}
}
throw new IllegalArgumentException ( lr_1 + name ) ;
}
private Object readResolve () {
return forName ( name ) ;
}
public String getName () {
return name ;
}
public boolean isCaseSensitive () {
return sensitive ;
}
public int checkCompareTo ( final String str1 , final String str2 ) {
if ( str1 == null || str2 == null ) {
throw new NullPointerException ( lr_2 ) ;
}
return sensitive ? str1 . compareTo ( str2 ) : str1 . compareToIgnoreCase ( str2 ) ;
}
public boolean checkEquals ( final String str1 , final String str2 ) {
if ( str1 == null || str2 == null ) {
throw new NullPointerException ( lr_2 ) ;
}
return sensitive ? str1 . equals ( str2 ) : str1 . equalsIgnoreCase ( str2 ) ;
}
public boolean checkStartsWith ( final String str , final String start ) {
return str . regionMatches ( ! sensitive , 0 , start , 0 , start . length () ) ;
}
public boolean checkEndsWith ( final String str , final String end ) {
final int endLen = end . length () ;
return str . regionMatches ( ! sensitive , str . length () - endLen , end , 0 , endLen ) ;
}
public int checkIndexOf ( final String str , final int strStartIndex , final String search ) {
final int endIndex = str . length () - search . length () ;
if ( endIndex >= strStartIndex ) {
for ( int i = strStartIndex ; i <= endIndex ; i ++ ) {
if ( checkRegionMatches ( str , i , search ) ) {
return i ;
}
}
}
return - 1 ;
}
public boolean checkRegionMatches ( final String str , final int strStartIndex , final String search ) {
return str . regionMatches ( ! sensitive , strStartIndex , search , 0 , search . length () ) ;
}
@Override
public String toString () {
return name ;
}
