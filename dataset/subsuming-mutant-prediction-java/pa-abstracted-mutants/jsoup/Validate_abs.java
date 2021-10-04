public static void notNull ( Object obj ) {
if ( obj == null )
throw new IllegalArgumentException ( lr_1 ) ;
}
public static void notNull ( Object obj , String msg ) {
if ( obj == null )
throw new IllegalArgumentException ( msg ) ;
}
public static void isTrue ( boolean val ) {
if ( ! val )
throw new IllegalArgumentException ( lr_2 ) ;
}
public static void isTrue ( boolean val , String msg ) {
if ( ! val )
throw new IllegalArgumentException ( msg ) ;
}
public static void isFalse ( boolean val ) {
if ( val )
throw new IllegalArgumentException ( lr_3 ) ;
}
public static void isFalse ( boolean val , String msg ) {
if ( val )
throw new IllegalArgumentException ( msg ) ;
}
public static void noNullElements ( Object [] objects ) {
noNullElements ( objects , lr_4 ) ;
}
public static void noNullElements ( Object [] objects , String msg ) {
for ( Object obj : objects )
if ( obj == null )
throw new IllegalArgumentException ( msg ) ;
}
public static void notEmpty ( String string ) {
if ( string == null || string . length () == 0 )
throw new IllegalArgumentException ( lr_5 ) ;
}
public static void notEmpty ( String string , String msg ) {
if ( string == null || string . length () == 0 )
throw new IllegalArgumentException ( msg ) ;
}
public static void wtf ( String msg ) {
throw new IllegalStateException ( msg ) ;
}
public static void fail ( String msg ) {
throw new IllegalArgumentException ( msg ) ;
}
