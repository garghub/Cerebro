public boolean matches ( Element root , Element element ) {
return root == element ;
}
public boolean matches ( Element root , Element element ) {
for ( Element e : element . getAllElements () ) {
if ( e != element && evaluator . matches ( element , e ) )
return true ;
}
return false ;
}
@Override
public String toString () {
return String . format ( lr_1 , evaluator ) ;
}
public boolean matches ( Element root , Element node ) {
return ! evaluator . matches ( root , node ) ;
}
@Override
public String toString () {
return String . format ( lr_2 , evaluator ) ;
}
public boolean matches ( Element root , Element element ) {
if ( root == element )
return false ;
Element parent = element . parent () ;
while ( true ) {
if ( evaluator . matches ( root , parent ) )
return true ;
if ( parent == root )
break;
parent = parent . parent () ;
}
return false ;
}
@Override
public String toString () {
return String . format ( lr_3 , evaluator ) ;
}
public boolean matches ( Element root , Element element ) {
if ( root == element )
return false ;
Element parent = element . parent () ;
return parent != null && evaluator . matches ( root , parent ) ;
}
@Override
public String toString () {
return String . format ( lr_4 , evaluator ) ;
}
public boolean matches ( Element root , Element element ) {
if ( root == element )
return false ;
Element prev = element . previousElementSibling () ;
while ( prev != null ) {
if ( evaluator . matches ( root , prev ) )
return true ;
prev = prev . previousElementSibling () ;
}
return false ;
}
@Override
public String toString () {
return String . format ( lr_5 , evaluator ) ;
}
public boolean matches ( Element root , Element element ) {
if ( root == element )
return false ;
Element prev = element . previousElementSibling () ;
return prev != null && evaluator . matches ( root , prev ) ;
}
@Override
public String toString () {
return String . format ( lr_6 , evaluator ) ;
}
