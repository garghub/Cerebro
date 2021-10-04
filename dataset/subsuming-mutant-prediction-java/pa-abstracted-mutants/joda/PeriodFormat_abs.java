public static PeriodFormatter getDefault () {
return wordBased ( Locale . ENGLISH ) ;
}
public static PeriodFormatter wordBased () {
return wordBased ( Locale . getDefault () ) ;
}
public static PeriodFormatter wordBased ( Locale locale ) {
PeriodFormatter pf = FORMATTERS . get ( locale ) ;
if ( pf == null ) {
DynamicWordBased dynamic = new DynamicWordBased ( buildWordBased ( locale ) ) ;
pf = new PeriodFormatter ( dynamic , dynamic , locale , null ) ;
PeriodFormatter existing = FORMATTERS . putIfAbsent ( locale , pf ) ;
if ( existing != null ) {
pf = existing ;
}
}
return pf ;
}
private static PeriodFormatter buildWordBased ( Locale locale ) {
ResourceBundle b = ResourceBundle . getBundle ( BUNDLE_NAME , locale ) ;
if ( containsKey ( b , lr_1 ) ) {
return buildRegExFormatter ( b , locale ) ;
} else {
return buildNonRegExFormatter ( b , locale ) ;
}
}
private static PeriodFormatter buildRegExFormatter ( ResourceBundle b , Locale locale ) {
String [] variants = retrieveVariants ( b ) ;
String regExSeparator = b . getString ( lr_1 ) ;
PeriodFormatterBuilder builder = new PeriodFormatterBuilder () ;
builder . appendYears () ;
if ( containsKey ( b , lr_2 ) ) {
builder . appendSuffix (
b . getString ( lr_2 ) . split ( regExSeparator ) ,
b . getString ( lr_3 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_4 ) , b . getString ( lr_5 ) ) ;
}
builder . appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants ) ;
builder . appendMonths () ;
if ( containsKey ( b , lr_8 ) ) {
builder . appendSuffix (
b . getString ( lr_8 ) . split ( regExSeparator ) ,
b . getString ( lr_9 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_10 ) , b . getString ( lr_11 ) ) ;
}
builder . appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants ) ;
builder . appendWeeks () ;
if ( containsKey ( b , lr_12 ) ) {
builder . appendSuffix (
b . getString ( lr_12 ) . split ( regExSeparator ) ,
b . getString ( lr_13 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_14 ) , b . getString ( lr_15 ) ) ;
}
builder . appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants ) ;
builder . appendDays () ;
if ( containsKey ( b , lr_16 ) ) {
builder . appendSuffix (
b . getString ( lr_16 ) . split ( regExSeparator ) ,
b . getString ( lr_17 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_18 ) , b . getString ( lr_19 ) ) ;
}
builder . appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants ) ;
builder . appendHours () ;
if ( containsKey ( b , lr_20 ) ) {
builder . appendSuffix (
b . getString ( lr_20 ) . split ( regExSeparator ) ,
b . getString ( lr_21 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_22 ) , b . getString ( lr_23 ) ) ;
}
builder . appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants ) ;
builder . appendMinutes () ;
if ( containsKey ( b , lr_24 ) ) {
builder . appendSuffix (
b . getString ( lr_24 ) . split ( regExSeparator ) ,
b . getString ( lr_25 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_26 ) , b . getString ( lr_27 ) ) ;
}
builder . appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants ) ;
builder . appendSeconds () ;
if ( containsKey ( b , lr_28 ) ) {
builder . appendSuffix (
b . getString ( lr_28 ) . split ( regExSeparator ) ,
b . getString ( lr_29 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_30 ) , b . getString ( lr_31 ) ) ;
}
builder . appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants ) ;
builder . appendMillis () ;
if ( containsKey ( b , lr_32 ) ) {
builder . appendSuffix (
b . getString ( lr_32 ) . split ( regExSeparator ) ,
b . getString ( lr_33 ) . split ( regExSeparator ) ) ;
} else {
builder . appendSuffix ( b . getString ( lr_34 ) , b . getString ( lr_35 ) ) ;
}
return builder . toFormatter () . withLocale ( locale ) ;
}
private static PeriodFormatter buildNonRegExFormatter ( ResourceBundle b , Locale locale ) {
String [] variants = retrieveVariants ( b ) ;
return new PeriodFormatterBuilder ()
. appendYears ()
. appendSuffix ( b . getString ( lr_4 ) , b . getString ( lr_5 ) )
. appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants )
. appendMonths ()
. appendSuffix ( b . getString ( lr_10 ) , b . getString ( lr_11 ) )
. appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants )
. appendWeeks ()
. appendSuffix ( b . getString ( lr_14 ) , b . getString ( lr_15 ) )
. appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants )
. appendDays ()
. appendSuffix ( b . getString ( lr_18 ) , b . getString ( lr_19 ) )
. appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants )
. appendHours ()
. appendSuffix ( b . getString ( lr_22 ) , b . getString ( lr_23 ) )
. appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants )
. appendMinutes ()
. appendSuffix ( b . getString ( lr_26 ) , b . getString ( lr_27 ) )
. appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants )
. appendSeconds ()
. appendSuffix ( b . getString ( lr_30 ) , b . getString ( lr_31 ) )
. appendSeparator ( b . getString ( lr_6 ) , b . getString ( lr_7 ) , variants )
. appendMillis ()
. appendSuffix ( b . getString ( lr_34 ) , b . getString ( lr_35 ) )
. toFormatter () . withLocale ( locale ) ;
}
private static String [] retrieveVariants ( ResourceBundle b ) {
return new String [] { b . getString ( lr_36 ) , b . getString ( lr_37 ) ,
b . getString ( lr_38 ) , b . getString ( lr_39 ) } ;
}
private static boolean containsKey ( ResourceBundle bundle , String key ) {
for ( Enumeration < String > en = bundle . getKeys () ; en . hasMoreElements () ; ) {
if ( en . nextElement () . equals ( key ) ) {
return true ;
}
}
return false ;
}
public int countFieldsToPrint ( ReadablePeriod period , int stopAt , Locale locale ) {
return getPrinter ( locale ) . countFieldsToPrint ( period , stopAt , locale ) ;
}
public int calculatePrintedLength ( ReadablePeriod period , Locale locale ) {
return getPrinter ( locale ) . calculatePrintedLength ( period , locale ) ;
}
public void printTo ( StringBuffer buf , ReadablePeriod period , Locale locale ) {
getPrinter ( locale ) . printTo ( buf , period , locale ) ;
}
public void printTo ( Writer out , ReadablePeriod period , Locale locale ) throws IOException {
getPrinter ( locale ) . printTo ( out , period , locale ) ;
}
private PeriodPrinter getPrinter ( Locale locale ) {
if ( locale != null && ! locale . equals ( iFormatter . getLocale () ) ) {
return wordBased ( locale ) . getPrinter () ;
}
return iFormatter . getPrinter () ;
}
public int parseInto (
ReadWritablePeriod period , String periodStr ,
int position , Locale locale ) {
return getParser ( locale ) . parseInto ( period , periodStr , position , locale ) ;
}
private PeriodParser getParser ( Locale locale ) {
if ( locale != null && ! locale . equals ( iFormatter . getLocale () ) ) {
return wordBased ( locale ) . getParser () ;
}
return iFormatter . getParser () ;
}
