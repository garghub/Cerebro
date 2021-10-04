@Override
public String lookup ( final String key ) {
return key != null ? System . getenv ( key ) : null ;
}
