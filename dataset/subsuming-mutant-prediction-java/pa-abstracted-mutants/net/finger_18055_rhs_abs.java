public static void main ( final String [] args )
{
boolean longOutput = false ;
int arg = 0 , index ;
String handle , host ;
FingerClient finger ;
InetAddress address = null ;
while ( arg < args . length && args [ arg ] . startsWith ( lr_1 ) )
{
if ( args [ arg ] . equals ( lr_2 ) ) {
longOutput = true ;
} else {
System . err . println ( lr_3 ) ;
System . exit ( 1 ) ;
}
++ arg ;
}
finger = new FingerClient () ;
finger . setDefaultTimeout ( 60000 ) ;
if ( arg >= args . length )
{
try
{
address = InetAddress . getLocalHost () ;
}
catch ( final UnknownHostException e )
{
System . err . println ( lr_4 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
try
{
finger . connect ( address ) ;
System . out . print ( finger . query ( longOutput ) ) ;
finger . disconnect () ;
}
catch ( final IOException e )
{
System . err . println ( lr_5 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
return ;
}
while ( arg < args . length )
{
index = args [ arg ] . lastIndexOf ( '@' ) ;
if ( index == - 1 )
{
handle = args [ arg ] ;
try
{
address = InetAddress . getLocalHost () ;
}
catch ( final UnknownHostException e )
{
System . err . println ( lr_4 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
}
else
{
handle = args [ arg ] . substring ( 0 , index ) ;
host = args [ arg ] . substring ( index + 1 ) ;
try MST[rv.AOD2Mutator]MSP[S]
{
address = InetAddress . getByName ( host ) ;
System . out . println ( lr_6 + address . getHostName () + lr_7 ) ;
}
catch ( final UnknownHostException e )
{
System . err . println ( lr_4 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
}
try
{
finger . connect ( address ) ;
System . out . print ( finger . query ( longOutput , handle ) ) ;
finger . disconnect () ;
}
catch ( final IOException e )
{
System . err . println ( lr_5 + e . getMessage () ) ;
System . exit ( 1 ) ;
}
++ arg ;
if ( arg != args . length ) {
System . out . print ( lr_8 ) ;
}
}
}
