public static void fn_1 ( Object vr_1 ) {
if ( vr_1 == null )
throw new IllegalArgumentException ( lr_1 ) ;
}
public static void fn_1 ( Object vr_1 , String vr_2 ) {
if ( vr_1 == null )
throw new IllegalArgumentException ( vr_2 ) ;
}
public static void fn_2 ( boolean vr_3 ) {
if ( ! vr_3 )
throw new IllegalArgumentException ( lr_2 ) ;
}
public static void fn_2 ( boolean vr_3 , String vr_2 ) {
if ( ! vr_3 )
throw new IllegalArgumentException ( vr_2 ) ;
}
public static void fn_3 ( boolean vr_3 ) {
if ( vr_3 )
throw new IllegalArgumentException ( lr_3 ) ;
}
public static void fn_3 ( boolean vr_3 , String vr_2 ) {
if ( vr_3 )
throw new IllegalArgumentException ( vr_2 ) ;
}
public static void fn_4 ( Object [] vr_4 ) {
fn_4 ( vr_4 , lr_4 ) ;
}
public static void fn_4 ( Object [] vr_4 , String vr_2 ) {
for ( Object vr_1 : vr_4 )
if ( vr_1 == null )
throw new IllegalArgumentException ( vr_2 ) ;
}
public static void fn_5 ( String string ) {
if ( string == null || string . length () == 0 )
throw new IllegalArgumentException ( lr_5 ) ;
}
public static void fn_5 ( String string , String vr_2 ) {
if ( string == null || string . length () == 0 )
throw new IllegalArgumentException ( vr_2 ) ;
}
public static void fn_6 ( String vr_2 ) {
throw new fn_7 ( vr_2 ) ;
}
public static void fn_8 ( String vr_2 ) {
throw new IllegalArgumentException ( vr_2 ) ;
}
