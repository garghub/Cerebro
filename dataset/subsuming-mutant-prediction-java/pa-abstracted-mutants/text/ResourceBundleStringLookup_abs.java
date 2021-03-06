@Override
public String lookup ( final String key ) {
if ( key == null ) {
return null ;
}
final String [] keys = key . split ( lr_1 ) ;
final int keyLen = keys . length ;
if ( keyLen != 2 ) {
throw IllegalArgumentExceptions
. format ( lr_2 , key ) ;
}
final String bundleName = keys [ 0 ] ;
final String bundleKey = keys [ 1 ] ;
try {
return ResourceBundle . getBundle ( bundleName ) . getString ( bundleKey ) ;
} catch ( final Exception e ) {
throw IllegalArgumentExceptions . format ( e , lr_3 , bundleName ,
bundleKey ) ;
}
}
