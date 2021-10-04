protected static String toMessage ( final int index , final Throwable cause ) {
final String unspecified = lr_1 ;
final String name = cause == null ? unspecified : cause . getClass () . getSimpleName () ;
final String msg = cause == null ? unspecified : cause . getMessage () ;
return String . format ( lr_2 , name , index , msg ) ;
}
public int getIndex () {
return index ;
}
