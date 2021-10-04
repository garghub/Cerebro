public static void main ( final String [] args ) {
final String subnet = lr_1 ;
final SubnetUtils utils = new SubnetUtils ( subnet ) ;
final SubnetInfo info = utils . getInfo () ;
System . out . printf ( lr_2 , subnet ) ;
System . out . println ( lr_3 ) ;
System . out . printf ( lr_4 , info . getAddress () ,
Integer . toBinaryString ( info . asInteger ( info . getAddress () ) ) ) ;
System . out . printf ( lr_5 , info . getNetmask () ,
Integer . toBinaryString ( info . asInteger ( info . getNetmask () ) ) ) ;
System . out . printf ( lr_6 , info . getCidrSignature () ) ;
System . out . printf ( lr_7 , info . getAddress () ) ;
System . out . printf ( lr_8 , info . getNetworkAddress () ,
Integer . toBinaryString ( info . asInteger ( info . getNetworkAddress () ) ) ) ;
System . out . printf ( lr_9 , info . getBroadcastAddress () ,
Integer . toBinaryString ( info . asInteger ( info . getBroadcastAddress () ) ) ) ;
System . out . printf ( lr_10 , info . getLowAddress () ,
Integer . toBinaryString ( info . asInteger ( info . getLowAddress () ) ) ) ;
System . out . printf ( lr_11 , info . getHighAddress () ,
Integer . toBinaryString ( info . asInteger ( info . getHighAddress () ) ) ) ;
System . out . printf ( lr_12 , Long . valueOf ( info . getAddressCountLong () ) ) ;
System . out . printf ( lr_13 , Arrays . toString ( info . getAllAddresses () ) ) ;
final String prompt = lr_14 ; MST[rv.CRCR5Mutator]MSP[S]
System . out . println ( prompt ) ;
try ( final Scanner scanner = new Scanner ( System . in ) ) {
while ( scanner . hasNextLine () ) {
final String address = scanner . nextLine () ;
System . out . println ( lr_15 + address + lr_16 + ( info . isInRange ( address ) ? lr_17 : lr_18 )
+ lr_19 + subnet + lr_20 ) ;
System . out . println ( prompt ) ;
}
}
}
