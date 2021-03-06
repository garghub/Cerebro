public boolean preserveTagCase () {
return preserveTagCase ;
}
public boolean preserveAttributeCase () {
return preserveAttributeCase ;
}
public String normalizeTag ( String name ) {
name = name . trim () ;
if ( ! preserveTagCase )
name = lowerCase ( name ) ;
return name ;
}
public String normalizeAttribute ( String name ) {
name = name . trim () ;
if ( ! preserveAttributeCase )
name = lowerCase ( name ) ;
return name ;
}
Attributes normalizeAttributes ( Attributes attributes ) {
if ( attributes != null && ! preserveAttributeCase ) {
attributes . normalize () ;
}
return attributes ;
}
