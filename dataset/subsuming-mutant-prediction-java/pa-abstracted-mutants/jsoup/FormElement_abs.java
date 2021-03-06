public Elements elements () {
return elements ;
}
public FormElement addElement ( Element element ) {
elements . add ( element ) ;
return this ;
}
@Override
protected void removeChild ( Node out ) {
super . removeChild ( out ) ;
elements . remove ( out ) ;
}
public Connection submit () {
String action = hasAttr ( lr_1 ) ? absUrl ( lr_1 ) : baseUri () ;
Validate . notEmpty ( action , lr_2 ) ;
Connection . Method method = attr ( lr_3 ) . toUpperCase () . equals ( lr_4 ) ?
Connection . Method . POST : Connection . Method . GET ;
return Jsoup . connect ( action )
. data ( formData () )
. method ( method ) ;
}
public List < Connection . KeyVal > formData () {
ArrayList < Connection . KeyVal > data = new ArrayList <> () ;
for ( Element el : elements ) {
if ( ! el . tag () . isFormSubmittable () ) continue;
if ( el . hasAttr ( lr_5 ) ) continue;
String name = el . attr ( lr_6 ) ;
if ( name . length () == 0 ) continue;
String type = el . attr ( lr_7 ) ;
if ( type . equalsIgnoreCase ( lr_8 ) ) continue;
if ( lr_9 . equals ( el . normalName () ) ) {
Elements options = el . select ( lr_10 ) ;
boolean set = false ;
for ( Element option : options ) {
data . add ( HttpConnection . KeyVal . create ( name , option . val () ) ) ;
set = true ;
}
if ( ! set ) {
Element option = el . select ( lr_11 ) . first () ;
if ( option != null )
data . add ( HttpConnection . KeyVal . create ( name , option . val () ) ) ;
}
} else if ( lr_12 . equalsIgnoreCase ( type ) || lr_13 . equalsIgnoreCase ( type ) ) {
if ( el . hasAttr ( lr_14 ) ) {
final String val = el . val () . length () > 0 ? el . val () : lr_15 ;
data . add ( HttpConnection . KeyVal . create ( name , val ) ) ;
}
} else {
data . add ( HttpConnection . KeyVal . create ( name , el . val () ) ) ;
}
}
return data ;
}
@Override
public FormElement clone () {
return ( FormElement ) super . clone () ;
}
