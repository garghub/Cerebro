public static void traverse ( NodeVisitor visitor , Node root ) {
Node node = root ;
int depth = 0 ;
while ( node != null ) {
visitor . head ( node , depth ) ;
if ( node . childNodeSize () > 0 ) {
node = node . childNode ( 0 ) ;
depth ++ ;
} else {
while ( node . nextSibling () == null && depth > 0 ) {
visitor . tail ( node , depth ) ;
node = node . parentNode () ;
depth -- ;
}
visitor . tail ( node , depth ) ;
if ( node == root )
break;
node = node . nextSibling () ;
}
}
}
public static void traverse ( NodeVisitor visitor , Elements elements ) {
Validate . notNull ( visitor ) ;
Validate . notNull ( elements ) ;
for ( Element el : elements )
traverse ( visitor , el ) ;
}
public static FilterResult filter ( NodeFilter filter , Node root ) {
Node node = root ;
int depth = 0 ;
while ( node != null ) {
FilterResult result = filter . head ( node , depth ) ;
if ( result == FilterResult . STOP )
return result ;
if ( result == FilterResult . CONTINUE && node . childNodeSize () > 0 ) {
node = node . childNode ( 0 ) ;
++ depth ;
continue;
}
while ( node . nextSibling () == null && depth > 0 ) {
if ( result == FilterResult . CONTINUE || result == FilterResult . SKIP_CHILDREN ) {
result = filter . tail ( node , depth ) ;
if ( result == FilterResult . STOP )
return result ;
}
Node prev = node ;
node = node . parentNode () ;
depth -- ;
if ( result == FilterResult . REMOVE )
prev . remove () ;
result = FilterResult . CONTINUE ;
}
if ( result == FilterResult . CONTINUE || result == FilterResult . SKIP_CHILDREN ) {
result = filter . tail ( node , depth ) ;
if ( result == FilterResult . STOP )
return result ;
}
if ( node == root )
return result ;
Node prev = node ;
node = node . nextSibling () ;
if ( result == FilterResult . REMOVE )
prev . remove () ;
}
return FilterResult . CONTINUE ;
}
public static void filter ( NodeFilter filter , Elements elements ) {
Validate . notNull ( filter ) ;
Validate . notNull ( elements ) ;
for ( Element el : elements )
if ( filter ( filter , el ) == FilterResult . STOP )
break;
}
