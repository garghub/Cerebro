public boolean isInclusiveHostCount () {
return inclusiveHostCount ;
}
public void setInclusiveHostCount ( final boolean inclusiveHostCount ) {
this . inclusiveHostCount = inclusiveHostCount ;
}
private long networkLong () { return network & UNSIGNED_INT_MASK ; }
private long broadcastLong () { return broadcast & UNSIGNED_INT_MASK ; }
private int low () {
return isInclusiveHostCount () ? network :
broadcastLong () - networkLong () > 1 ? network + 1 : 0 ;
}
private int high () {
return isInclusiveHostCount () ? broadcast :
broadcastLong () - networkLong () > 1 ? broadcast - 1 : 0 ;
}
public boolean isInRange ( final String address ) {
return isInRange ( toInteger ( address ) ) ;
}
public boolean isInRange ( final int address ) {
if ( address == 0 ) {
return false ;
}
final long addLong = address & UNSIGNED_INT_MASK ;
final long lowLong = low () & UNSIGNED_INT_MASK ;
final long highLong = high () & UNSIGNED_INT_MASK ;
return addLong >= lowLong && addLong <= highLong ;
}
public String getBroadcastAddress () {
return format ( toArray ( broadcast ) ) ;
}
public String getNetworkAddress () {
return format ( toArray ( network ) ) ;
}
public String getNetmask () {
return format ( toArray ( netmask ) ) ;
}
public String getAddress () {
return format ( toArray ( address ) ) ;
}
public String getNextAddress () {
return format ( toArray ( address + 1 ) ) ;
}
public String getPreviousAddress () {
return format ( toArray ( address - 1 ) ) ;
}
public String getLowAddress () {
return format ( toArray ( low () ) ) ;
}
public String getHighAddress () {
return format ( toArray ( high () ) ) ;
}
@Deprecated
public int getAddressCount () {
final long countLong = getAddressCountLong () ;
if ( countLong > Integer . MAX_VALUE ) {
throw new RuntimeException ( lr_1 + countLong ) ;
}
return ( int ) countLong ;
}
public long getAddressCountLong () {
final long b = broadcastLong () ;
final long n = networkLong () ;
final long count = b - n + ( isInclusiveHostCount () ? 1 : - 1 ) ;
return count < 0 ? 0 : count ;
}
public int asInteger ( final String address ) {
return toInteger ( address ) ;
}
public String getCidrSignature () {
return format ( toArray ( address ) ) + lr_2 + pop ( netmask ) ;
}
public String [] getAllAddresses () {
final int ct = getAddressCount () ;
final String [] addresses = new String [ ct ] ;
if ( ct == 0 ) {
return addresses ;
}
for ( int add = low () , j = 0 ; add <= high () ; ++ add , ++ j ) {
addresses [ j ] = format ( toArray ( add ) ) ;
}
return addresses ;
}
private int [] toArray ( final int val ) {
final int ret [] = new int [ 4 ] ;
for ( int j = 3 ; j >= 0 ; -- j ) {
ret [ j ] |= val >>> 8 * ( 3 - j ) & 0xff ;
}
return ret ;
}
private String format ( final int [] octets ) {
final StringBuilder str = new StringBuilder () ;
for ( int i = 0 ; i < octets . length ; ++ i ) {
str . append ( octets [ i ] ) ; MST[rv.UOI2Mutator]MSP[]
if ( i != octets . length - 1 ) {
str . append ( lr_3 ) ;
}
}
return str . toString () ;
}
@Override
public String toString () {
final StringBuilder buf = new StringBuilder () ;
buf . append ( lr_4 ) . append ( getCidrSignature () ) . append ( lr_5 )
. append ( lr_6 ) . append ( getNetmask () ) . append ( lr_7 )
. append ( lr_8 ) . append ( getNetworkAddress () ) . append ( lr_7 )
. append ( lr_9 ) . append ( getBroadcastAddress () ) . append ( lr_7 )
. append ( lr_10 ) . append ( getLowAddress () ) . append ( lr_7 )
. append ( lr_11 ) . append ( getHighAddress () ) . append ( lr_7 )
. append ( lr_12 ) . append ( getAddressCount () ) . append ( lr_7 ) ;
return buf . toString () ;
}
public final SubnetInfo getInfo () { return new SubnetInfo () ; }
private static int toInteger ( final String address ) {
final Matcher matcher = addressPattern . matcher ( address ) ;
if ( matcher . matches () ) {
return matchAddress ( matcher ) ;
}
throw new IllegalArgumentException ( String . format ( PARSE_FAIL , address ) ) ;
}
private static int matchAddress ( final Matcher matcher ) {
int addr = 0 ;
for ( int i = 1 ; i <= 4 ; ++ i ) {
final int n = rangeCheck ( Integer . parseInt ( matcher . group ( i ) ) , 0 , 255 ) ;
addr |= ( n & 0xff ) << 8 * ( 4 - i ) ;
}
return addr ;
}
private static int rangeCheck ( final int value , final int begin , final int end ) {
if ( value >= begin && value <= end ) {
return value ;
}
throw new IllegalArgumentException ( lr_13 + value + lr_14 + begin + lr_15 + end + lr_5 ) ;
}
int pop ( int x ) {
x = x - ( x >>> 1 & 0x55555555 ) ;
x = ( x & 0x33333333 ) + ( x >>> 2 & 0x33333333 ) ;
x = x + ( x >>> 4 ) & 0x0F0F0F0F ;
x = x + ( x >>> 8 ) ;
x = x + ( x >>> 16 ) ;
return x & 0x0000003F ;
}
public SubnetUtils getNext () {
return new SubnetUtils ( getInfo () . getNextAddress () , getInfo () . getNetmask () ) ;
}
public SubnetUtils getPrevious () {
return new SubnetUtils ( getInfo () . getPreviousAddress () , getInfo () . getNetmask () ) ;
}
