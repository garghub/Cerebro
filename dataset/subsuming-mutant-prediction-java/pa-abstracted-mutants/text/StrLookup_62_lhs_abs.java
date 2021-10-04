public static StrLookup < ? > noneLookup () {
return NONE_LOOKUP ;
}
public static StrLookup < String > systemPropertiesLookup () {
return SYSTEM_PROPERTIES_LOOKUP ;
}
public static < V > StrLookup < V > mapLookup ( final Map < String , V > map ) {
return new MapStrLookup <> ( map ) ;
}
public static StrLookup < String > resourceBundleLookup ( final ResourceBundle resourceBundle ) {
return new ResourceBundleLookup ( resourceBundle ) ;
}
@Override
public String lookup ( final String key ) {
if ( map == null ) {
return null ;
}
final Object obj = map . get ( key ) ;
if ( obj == null ) {
return null ;
}
return obj . toString () ; MST[ReturnValsMutator]MSP[]
}
@Override
public String toString () {
return super . toString () + lr_1 + map + lr_2 ;
}
@Override
public String lookup ( final String key ) {
if ( resourceBundle == null || key == null || ! resourceBundle . containsKey ( key ) ) {
return null ;
}
return resourceBundle . getString ( key ) ;
}
@Override
public String toString () {
return super . toString () + lr_3 + resourceBundle + lr_2 ;
}
@Override
public String lookup ( final String key ) {
if ( key . length () > 0 ) {
try {
return System . getProperty ( key ) ;
} catch ( final SecurityException scex ) {
return null ;
}
}
return null ;
}
