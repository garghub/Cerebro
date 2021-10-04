public DateTimeZone getZone ( String id ) {
if ( lr_1 . equalsIgnoreCase ( id ) ) {
return DateTimeZone . UTC ;
}
return null ;
}
public Set < String > getAvailableIDs () {
return AVAILABLE_IDS ;
}
