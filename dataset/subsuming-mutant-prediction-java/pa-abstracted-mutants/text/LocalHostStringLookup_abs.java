@Override
public String lookup ( final String key ) {
switch ( key ) {
case lr_1 :
try {
return InetAddress . getLocalHost () . getHostName () ;
} catch ( final UnknownHostException e ) {
return null ;
}
case lr_2 :
try {
return InetAddress . getLocalHost () . getCanonicalHostName () ;
} catch ( final UnknownHostException e ) {
return null ;
}
case lr_3 :
try {
return InetAddress . getLocalHost () . getHostAddress () ;
} catch ( final UnknownHostException e ) {
return null ;
}
default:
throw new IllegalArgumentException ( key ) ;
}
}
