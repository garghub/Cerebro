public static byte [] nextBytes ( final int count ) {
Validate . isTrue ( count >= 0 , lr_1 ) ;
final byte [] result = new byte [ count ] ;
RANDOM . nextBytes ( result ) ;
return result ;
}
public static int nextInt ( final int startInclusive , final int endExclusive ) {
Validate . isTrue ( endExclusive >= startInclusive ,
lr_2 ) ;
Validate . isTrue ( startInclusive >= 0 , lr_3 ) ;
if ( startInclusive == endExclusive ) {
return startInclusive ;
}
return startInclusive + RANDOM . nextInt ( endExclusive - startInclusive ) ;
}
public static int nextInt () {
return nextInt ( 0 , Integer . MAX_VALUE ) ;
}
public static long nextLong ( final long startInclusive , final long endExclusive ) {
Validate . isTrue ( endExclusive >= startInclusive ,
lr_2 ) ;
Validate . isTrue ( startInclusive >= 0 , lr_3 ) ;
if ( startInclusive == endExclusive ) {
return startInclusive ;
}
return ( long ) nextDouble ( startInclusive , endExclusive ) ;
}
public static long nextLong () {
return nextLong ( 0 , Long . MAX_VALUE ) ;
}
public static double nextDouble ( final double startInclusive , final double endInclusive ) {
Validate . isTrue ( endInclusive >= startInclusive ,
lr_2 ) ;
Validate . isTrue ( startInclusive >= 0 , lr_3 ) ;
if ( startInclusive == endInclusive ) {
return startInclusive ;
}
return startInclusive + ( ( endInclusive - startInclusive ) * RANDOM . nextDouble () ) ;
}
public static double nextDouble () {
return nextDouble ( 0 , Double . MAX_VALUE ) ;
}
public static float nextFloat ( final float startInclusive , final float endInclusive ) {
Validate . isTrue ( endInclusive >= startInclusive ,
lr_2 ) ;
Validate . isTrue ( startInclusive >= 0 , lr_3 ) ;
if ( startInclusive == endInclusive ) {
return startInclusive ;
}
return startInclusive + ( ( endInclusive - startInclusive ) * RANDOM . nextFloat () ) ;
}
public static float nextFloat () {
return nextFloat ( 0 , Float . MAX_VALUE ) ;
}
