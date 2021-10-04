public static PeriodFormatter standard () {
if ( cStandard == null ) {
cStandard = new PeriodFormatterBuilder ()
. appendLiteral ( lr_1 )
. appendYears ()
. appendSuffix ( lr_2 )
. appendMonths ()
. appendSuffix ( lr_3 )
. appendWeeks ()
. appendSuffix ( lr_4 )
. appendDays ()
. appendSuffix ( lr_5 )
. appendSeparatorIfFieldsAfter ( lr_6 )
. appendHours ()
. appendSuffix ( lr_7 )
. appendMinutes ()
. appendSuffix ( lr_3 )
. appendSecondsWithOptionalMillis ()
. appendSuffix ( lr_8 )
. toFormatter () ;
}
return cStandard ;
}
public static PeriodFormatter alternate () {
if ( cAlternate == null ) {
cAlternate = new PeriodFormatterBuilder ()
. appendLiteral ( lr_1 )
. printZeroAlways ()
. minimumPrintedDigits ( 4 )
. appendYears ()
. minimumPrintedDigits ( 2 )
. appendMonths ()
. appendDays ()
. appendSeparatorIfFieldsAfter ( lr_6 )
. appendHours ()
. appendMinutes ()
. appendSecondsWithOptionalMillis ()
. toFormatter () ;
}
return cAlternate ;
}
public static PeriodFormatter alternateExtended () {
if ( cAlternateExtended == null ) {
cAlternateExtended = new PeriodFormatterBuilder ()
. appendLiteral ( lr_1 )
. printZeroAlways ()
. minimumPrintedDigits ( 4 )
. appendYears ()
. appendSeparator ( lr_9 )
. minimumPrintedDigits ( 2 )
. appendMonths ()
. appendSeparator ( lr_9 )
. appendDays ()
. appendSeparatorIfFieldsAfter ( lr_6 )
. appendHours ()
. appendSeparator ( lr_10 )
. appendMinutes ()
. appendSeparator ( lr_10 )
. appendSecondsWithOptionalMillis ()
. toFormatter () ;
}
return cAlternateExtended ;
}
public static PeriodFormatter alternateWithWeeks () {
if ( cAlternateWithWeeks == null ) {
cAlternateWithWeeks = new PeriodFormatterBuilder ()
. appendLiteral ( lr_1 )
. printZeroAlways ()
. minimumPrintedDigits ( 4 )
. appendYears ()
. minimumPrintedDigits ( 2 )
. appendPrefix ( lr_4 )
. appendWeeks ()
. appendDays ()
. appendSeparatorIfFieldsAfter ( lr_6 )
. appendHours ()
. appendMinutes ()
. appendSecondsWithOptionalMillis ()
. toFormatter () ;
}
return cAlternateWithWeeks ;
}
public static PeriodFormatter alternateExtendedWithWeeks () {
if ( cAlternateExtendedWihWeeks == null ) {
cAlternateExtendedWihWeeks = new PeriodFormatterBuilder ()
. appendLiteral ( lr_1 )
. printZeroAlways ()
. minimumPrintedDigits ( 4 )
. appendYears ()
. appendSeparator ( lr_9 )
. minimumPrintedDigits ( 2 )
. appendPrefix ( lr_4 )
. appendWeeks ()
. appendSeparator ( lr_9 )
. appendDays ()
. appendSeparatorIfFieldsAfter ( lr_6 )
. appendHours ()
. appendSeparator ( lr_10 )
. appendMinutes ()
. appendSeparator ( lr_10 )
. appendSecondsWithOptionalMillis ()
. toFormatter () ;
}
return cAlternateExtendedWihWeeks ;
}
