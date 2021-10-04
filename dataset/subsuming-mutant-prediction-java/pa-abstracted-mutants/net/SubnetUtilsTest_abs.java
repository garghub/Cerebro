public void testAddresses () {
final SubnetUtils utils = new SubnetUtils ( lr_1 ) ;
final SubnetInfo info = utils . getInfo () ;
assertTrue ( info . isInRange ( lr_2 ) ) ;
assertTrue ( info . isInRange ( lr_3 ) ) ;
assertTrue ( info . isInRange ( lr_4 ) ) ;
assertTrue ( info . isInRange ( lr_5 ) ) ;
assertTrue ( info . isInRange ( lr_6 ) ) ;
assertTrue ( info . isInRange ( lr_7 ) ) ;
assertFalse ( info . isInRange ( lr_8 ) ) ;
assertFalse ( info . isInRange ( lr_9 ) ) ;
assertFalse ( info . isInRange ( lr_10 ) ) ;
assertFalse ( info . isInRange ( lr_11 ) ) ;
assertFalse ( info . isInRange ( lr_12 ) ) ;
}
public void testCidrAddresses () {
SubnetUtils utils = new SubnetUtils ( lr_13 ) ;
utils . setInclusiveHostCount ( true ) ;
SubnetInfo info = utils . getInfo () ;
assertEquals ( lr_14 , info . getNetmask () ) ;
assertEquals ( 16777216 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_15 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_16 , info . getNetmask () ) ;
assertEquals ( 4294967296L , info . getAddressCountLong () ) ;
utils = new SubnetUtils ( lr_17 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_18 , info . getNetmask () ) ;
assertEquals ( 2147483648L , info . getAddressCountLong () ) ;
utils = new SubnetUtils ( lr_19 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_20 , info . getNetmask () ) ;
assertEquals ( 8388608 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_21 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_22 , info . getNetmask () ) ;
assertEquals ( 4194304 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_23 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_24 , info . getNetmask () ) ;
assertEquals ( 2097152 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_25 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_26 , info . getNetmask () ) ;
assertEquals ( 1048576 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_27 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_28 , info . getNetmask () ) ;
assertEquals ( 524288 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_29 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_30 , info . getNetmask () ) ;
assertEquals ( 262144 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_31 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_32 , info . getNetmask () ) ;
assertEquals ( 131072 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_33 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_34 , info . getNetmask () ) ;
assertEquals ( 65536 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_35 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_36 , info . getNetmask () ) ;
assertEquals ( 32768 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_37 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_38 , info . getNetmask () ) ;
assertEquals ( 16384 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_39 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_40 , info . getNetmask () ) ;
assertEquals ( 8192 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_41 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_42 , info . getNetmask () ) ;
assertEquals ( 4096 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_43 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_44 , info . getNetmask () ) ;
assertEquals ( 2048 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_45 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_46 , info . getNetmask () ) ;
assertEquals ( 1024 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_47 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_48 , info . getNetmask () ) ;
assertEquals ( 512 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_49 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_50 , info . getNetmask () ) ;
assertEquals ( 256 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_51 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_52 , info . getNetmask () ) ;
assertEquals ( 128 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_53 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_54 , info . getNetmask () ) ;
assertEquals ( 64 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_55 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_56 , info . getNetmask () ) ;
assertEquals ( 32 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_57 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_58 , info . getNetmask () ) ;
assertEquals ( 16 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_1 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_59 , info . getNetmask () ) ;
assertEquals ( 8 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_60 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_61 , info . getNetmask () ) ;
assertEquals ( 4 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_62 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_63 , info . getNetmask () ) ;
assertEquals ( 2 , info . getAddressCount () ) ;
utils = new SubnetUtils ( lr_64 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_65 , info . getNetmask () ) ;
assertEquals ( 1 , info . getAddressCount () ) ;
}
public void testNET675 () {
final SubnetUtils utils = new SubnetUtils ( lr_66 ) ;
utils . setInclusiveHostCount ( true ) ;
final SubnetInfo info = utils . getInfo () ;
assertTrue ( info . isInRange ( lr_67 ) ) ;
}
public void testNET679 () {
final SubnetUtils utils = new SubnetUtils ( lr_68 ) ;
utils . setInclusiveHostCount ( true ) ;
final SubnetInfo info = utils . getInfo () ;
assertTrue ( info . isInRange ( lr_69 ) ) ;
assertTrue ( info . isInRange ( lr_70 ) ) ;
}
public void testInvalidMasks () {
try {
new SubnetUtils ( lr_71 ) ;
fail ( lr_72 ) ;
} catch ( final IllegalArgumentException expected ) {
}
}
public void testNET428_31 () throws Exception {
final SubnetUtils subnetUtils = new SubnetUtils ( lr_73 ) ;
assertEquals ( 0 , subnetUtils . getInfo () . getAddressCount () ) ;
final String [] address = subnetUtils . getInfo () . getAllAddresses () ;
assertNotNull ( address ) ;
assertEquals ( 0 , address . length ) ;
}
public void testNET428_32 () throws Exception {
final SubnetUtils subnetUtils = new SubnetUtils ( lr_74 ) ;
assertEquals ( 0 , subnetUtils . getInfo () . getAddressCount () ) ;
final String [] address = subnetUtils . getInfo () . getAllAddresses () ;
assertNotNull ( address ) ;
assertEquals ( 0 , address . length ) ;
}
public void testParseSimpleNetmask () {
final String address = lr_2 ;
final String masks [] = new String [] { lr_14 , lr_34 , lr_50 , lr_59 } ;
final String bcastAddresses [] = new String [] { lr_75 , lr_76 , lr_12 ,
lr_8 } ;
final String lowAddresses [] = new String [] { lr_77 , lr_2 , lr_2 , lr_2 } ;
final String highAddresses [] = new String [] { lr_78 , lr_79 , lr_80 ,
lr_7 } ;
final String nextAddresses [] = new String [] { lr_3 , lr_3 , lr_3 ,
lr_3 } ;
final String previousAddresses [] = new String [] { lr_81 , lr_81 , lr_81 ,
lr_81 } ;
final String networkAddresses [] = new String [] { lr_82 , lr_81 , lr_81 , lr_81 } ;
final String cidrSignatures [] = new String [] { lr_13 , lr_33 , lr_49 ,
lr_1 } ;
final int usableAddresses [] = new int [] { 16777214 , 65534 , 254 , 6 } ;
for ( int i = 0 ; i < masks . length ; ++ i ) {
final SubnetUtils utils = new SubnetUtils ( address , masks [ i ] ) ;
final SubnetInfo info = utils . getInfo () ;
assertEquals ( bcastAddresses [ i ] , info . getBroadcastAddress () ) ;
assertEquals ( cidrSignatures [ i ] , info . getCidrSignature () ) ;
assertEquals ( lowAddresses [ i ] , info . getLowAddress () ) ;
assertEquals ( highAddresses [ i ] , info . getHighAddress () ) ;
assertEquals ( nextAddresses [ i ] , info . getNextAddress () ) ;
assertEquals ( previousAddresses [ i ] , info . getPreviousAddress () ) ;
assertEquals ( networkAddresses [ i ] , info . getNetworkAddress () ) ;
assertEquals ( usableAddresses [ i ] , info . getAddressCount () ) ;
}
}
public void testParseSimpleNetmaskExclusive () {
final String address = lr_83 ;
final String masks [] = new String [] { lr_61 , lr_63 , lr_65 } ;
final String bcast [] = new String [] { lr_83 , lr_83 , lr_83 } ;
final String netwk [] = new String [] { lr_84 , lr_85 , lr_83 } ;
final String lowAd [] = new String [] { lr_86 , lr_16 , lr_16 } ;
final String highA [] = new String [] { lr_85 , lr_16 , lr_16 } ;
final String cidrS [] = new String [] { lr_87 , lr_88 , lr_89 } ;
final int usableAd [] = new int [] { 2 , 0 , 0 } ;
for ( int i = 0 ; i < masks . length ; ++ i ) {
final SubnetUtils utils = new SubnetUtils ( address , masks [ i ] ) ;
utils . setInclusiveHostCount ( false ) ;
final SubnetInfo info = utils . getInfo () ;
assertEquals ( lr_90 + masks [ i ] , cidrS [ i ] , info . getCidrSignature () ) ;
assertEquals ( lr_91 + masks [ i ] , bcast [ i ] , info . getBroadcastAddress () ) ;
assertEquals ( lr_92 + masks [ i ] , netwk [ i ] , info . getNetworkAddress () ) ;
assertEquals ( lr_93 + masks [ i ] , usableAd [ i ] , info . getAddressCount () ) ;
assertEquals ( lr_94 + masks [ i ] , lowAd [ i ] , info . getLowAddress () ) ;
assertEquals ( lr_95 + masks [ i ] , highA [ i ] , info . getHighAddress () ) ;
}
}
public void testParseSimpleNetmaskInclusive () {
final String address = lr_83 ;
final String masks [] = new String [] { lr_61 , lr_63 , lr_65 } ;
final String bcast [] = new String [] { lr_83 , lr_83 , lr_83 } ;
final String netwk [] = new String [] { lr_84 , lr_85 , lr_83 } ;
final String lowAd [] = new String [] { lr_84 , lr_85 , lr_83 } ;
final String highA [] = new String [] { lr_83 , lr_83 , lr_83 } ;
final String cidrS [] = new String [] { lr_87 , lr_88 , lr_89 } ;
final int usableAd [] = new int [] { 4 , 2 , 1 } ;
for ( int i = 0 ; i < masks . length ; ++ i ) {
final SubnetUtils utils = new SubnetUtils ( address , masks [ i ] ) ;
utils . setInclusiveHostCount ( true ) ;
final SubnetInfo info = utils . getInfo () ;
assertEquals ( lr_90 + masks [ i ] , cidrS [ i ] , info . getCidrSignature () ) ;
assertEquals ( lr_91 + masks [ i ] , bcast [ i ] , info . getBroadcastAddress () ) ;
assertEquals ( lr_93 + masks [ i ] , usableAd [ i ] , info . getAddressCount () ) ;
assertEquals ( lr_92 + masks [ i ] , netwk [ i ] , info . getNetworkAddress () ) ;
assertEquals ( lr_94 + masks [ i ] , lowAd [ i ] , info . getLowAddress () ) ;
assertEquals ( lr_95 + masks [ i ] , highA [ i ] , info . getHighAddress () ) ;
}
}
public void testZeroAddressAndCidr () {
final SubnetUtils snu = new SubnetUtils ( lr_96 ) ;
assertNotNull ( snu ) ;
}
public void testNET521 () {
SubnetUtils utils ;
SubnetInfo info ;
utils = new SubnetUtils ( lr_96 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_16 , info . getNetmask () ) ;
assertEquals ( 4294967296L , info . getAddressCountLong () ) ;
try {
info . getAddressCount () ;
fail ( lr_97 ) ;
} catch ( final RuntimeException expected ) {
}
utils = new SubnetUtils ( lr_98 ) ;
utils . setInclusiveHostCount ( true ) ;
info = utils . getInfo () ;
assertEquals ( lr_18 , info . getNetmask () ) ;
assertEquals ( 2147483648L , info . getAddressCountLong () ) ;
try {
info . getAddressCount () ;
fail ( lr_97 ) ;
} catch ( final RuntimeException expected ) {
}
utils . setInclusiveHostCount ( false ) ;
info = utils . getInfo () ;
assertEquals ( 2147483646 , info . getAddressCount () ) ;
}
public void testNET624 () {
new SubnetUtils ( lr_96 ) ;
new SubnetUtils ( lr_16 , lr_16 ) ;
new SubnetUtils ( lr_16 , lr_18 ) ;
try {
new SubnetUtils ( lr_16 , lr_99 ) ;
fail ( lr_72 ) ;
} catch ( final IllegalArgumentException expected ) {
}
try {
new SubnetUtils ( lr_16 , lr_100 ) ;
fail ( lr_72 ) ;
} catch ( final IllegalArgumentException expected ) {
}
}
public void testNET520 () {
final SubnetUtils utils = new SubnetUtils ( lr_96 ) ;
utils . setInclusiveHostCount ( true ) ;
final SubnetInfo info = utils . getInfo () ;
assertEquals ( lr_16 , info . getNetworkAddress () ) ;
assertEquals ( lr_65 , info . getBroadcastAddress () ) ;
assertTrue ( info . isInRange ( lr_101 ) ) ;
utils . setInclusiveHostCount ( false ) ;
assertTrue ( info . isInRange ( lr_101 ) ) ;
}
public void testNET641 () {
assertFalse ( new SubnetUtils ( lr_102 ) . getInfo () . isInRange ( lr_16 ) ) ;
assertFalse ( new SubnetUtils ( lr_103 ) . getInfo () . isInRange ( lr_16 ) ) ;
assertFalse ( new SubnetUtils ( lr_104 ) . getInfo () . isInRange ( lr_16 ) ) ;
assertFalse ( new SubnetUtils ( lr_105 ) . getInfo () . isInRange ( lr_16 ) ) ;
}
