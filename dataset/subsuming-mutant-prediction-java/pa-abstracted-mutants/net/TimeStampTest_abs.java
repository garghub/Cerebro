public void testCompare () {
final TimeStamp ts1 = new TimeStamp ( TIME1 ) ;
final TimeStamp ts2 = new TimeStamp ( TIME1 ) ;
final TimeStamp ts3 = new TimeStamp ( TIME2 ) ;
final TimeStamp ts4 = new TimeStamp ( TIME3 ) ;
assertEquals ( lr_1 , ts1 , ts2 ) ;
assertEquals ( lr_2 , 0 , ts1 . compareTo ( ts2 ) ) ;
assertEquals ( lr_3 , ts1 . ntpValue () , ts2 . ntpValue () ) ;
assertEquals ( lr_4 , ts1 . hashCode () , ts2 . hashCode () ) ;
assertEquals ( lr_5 , ts1 , ts1 ) ;
assertTrue ( lr_6 , ! ts1 . equals ( ts3 ) ) ;
assertEquals ( lr_7 , - 1 , ts1 . compareTo ( ts3 ) ) ;
assertEquals ( lr_8 , ts1 . getSeconds () , ts3 . getSeconds () ) ;
assertTrue ( lr_9 , ts1 . getFraction () != ts3 . getFraction () ) ;
assertTrue ( lr_10 , ts1 . ntpValue () != ts3 . ntpValue () ) ;
assertTrue ( lr_11 , ts1 . hashCode () != ts3 . hashCode () ) ;
final long time1 = ts1 . getTime () ;
final long time3 = ts3 . getTime () ;
assertEquals ( lr_12 , time1 , time3 ) ;
assertTrue ( lr_13 , ! ts3 . equals ( ts4 ) ) ;
assertTrue ( lr_14 , time3 != ts4 . getTime () ) ;
}
public void testUTCString () {
final TimeStamp ts1 = new TimeStamp ( TIME1 ) ;
final String actual = ts1 . toUTCString () ;
assertEquals ( lr_15 , actual ) ;
}
public void testDateConversion () {
final Calendar refCal = Calendar . getInstance ( java . util . TimeZone . getTimeZone ( lr_16 ) ) ;
final Date refDate = refCal . getTime () ;
final TimeStamp ts = new TimeStamp ( refDate ) ;
assertEquals ( lr_17 , refDate . getTime () , ts . getTime () ) ;
final Date tsDate = ts . getDate () ;
assertEquals ( refDate , tsDate ) ;
}
public void testNotSame () {
final TimeStamp time = TimeStamp . getCurrentTime () ;
Object other = Integer . valueOf ( 0 ) ;
if( time . equals ( other ) ) {
fail ( lr_18 ) ;
}
other = null ;
if( time . equals ( other ) ) {
fail ( lr_19 ) ;
}
}
