public String getName () {
return tagName ;
}
public String normalName () {
return normalName ;
}
public static Tag valueOf ( String tagName , ParseSettings settings ) {
Validate . notNull ( tagName ) ;
Tag tag = tags . get ( tagName ) ;
if ( tag == null ) {
tagName = settings . normalizeTag ( tagName ) ;
Validate . notEmpty ( tagName ) ;
tag = tags . get ( tagName ) ;
if ( tag == null ) {
tag = new Tag ( tagName ) ;
tag . isBlock = false ;
}
}
return tag ;
}
public static Tag valueOf ( String tagName ) {
return valueOf ( tagName , ParseSettings . preserveCase ) ;
}
public boolean isBlock () {
return isBlock ;
}
public boolean formatAsBlock () {
return formatAsBlock ;
}
public boolean isInline () {
return ! isBlock ;
}
public boolean isEmpty () {
return empty ;
}
public boolean isSelfClosing () {
return empty || selfClosing ;
}
public boolean isKnownTag () {
return tags . containsKey ( tagName ) ;
}
public static boolean isKnownTag ( String tagName ) {
return tags . containsKey ( tagName ) ;
}
public boolean preserveWhitespace () {
return preserveWhitespace ;
}
public boolean isFormListed () {
return formList ;
}
public boolean isFormSubmittable () {
return formSubmit ;
}
Tag setSelfClosing () {
selfClosing = true ;
return this ;
}
@Override
public boolean equals ( Object o ) {
if ( this == o ) return true ;
if ( ! ( o instanceof Tag ) ) return false ;
Tag tag = ( Tag ) o ;
if ( ! tagName . equals ( tag . tagName ) ) return false ;
if ( empty != tag . empty ) return false ;
if ( formatAsBlock != tag . formatAsBlock ) return false ;
if ( isBlock != tag . isBlock ) return false ;
if ( preserveWhitespace != tag . preserveWhitespace ) return false ;
if ( selfClosing != tag . selfClosing ) return false ;
if ( formList != tag . formList ) return false ;
return formSubmit == tag . formSubmit ;
}
@Override
public int hashCode () {
int result = tagName . hashCode () ;
result = 31 * result + ( isBlock ? 1 : 0 ) ;
result = 31 * result + ( formatAsBlock ? 1 : 0 ) ;
result = 31 * result + ( empty ? 1 : 0 ) ;
result = 31 * result + ( selfClosing ? 1 : 0 ) ;
result = 31 * result + ( preserveWhitespace ? 1 : 0 ) ;
result = 31 * result + ( formList ? 1 : 0 ) ;
result = 31 * result + ( formSubmit ? 1 : 0 ) ;
return result ;
}
@Override
public String toString () {
return tagName ;
}
private static void register ( Tag tag ) {
tags . put ( tag . tagName , tag ) ;
}
