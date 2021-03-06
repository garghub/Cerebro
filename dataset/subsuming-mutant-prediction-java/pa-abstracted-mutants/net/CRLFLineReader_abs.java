@Override
public String readLine () throws IOException {
final StringBuilder sb = new StringBuilder () ;
int intch ;
boolean prevWasCR = false ;
synchronized( lock ) {
while( ( intch = read () ) != - 1 )
{
if ( prevWasCR && intch == LF ) {
return sb . substring ( 0 , sb . length () - 1 ) ;
}
if ( intch == CR ) {
prevWasCR = true ;
} else {
prevWasCR = false ;
}
sb . append ( ( char ) intch ) ;
}
}
final String string = sb . toString () ;
if ( string . length () == 0 ) {
return null ;
}
return string ;
}
