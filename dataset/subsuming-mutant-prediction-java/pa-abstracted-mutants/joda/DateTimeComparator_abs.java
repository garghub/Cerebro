public static DateTimeComparator getInstance () {
return ALL_INSTANCE ;
}
public static DateTimeComparator getInstance ( DateTimeFieldType lowerLimit ) {
return getInstance ( lowerLimit , null ) ;
}
public static DateTimeComparator getInstance ( DateTimeFieldType lowerLimit , DateTimeFieldType upperLimit ) {
if ( lowerLimit == null && upperLimit == null ) {
return ALL_INSTANCE ;
}
if ( lowerLimit == DateTimeFieldType . dayOfYear () && upperLimit == null ) {
return DATE_INSTANCE ;
}
if ( lowerLimit == null && upperLimit == DateTimeFieldType . dayOfYear () ) {
return TIME_INSTANCE ;
}
return new DateTimeComparator ( lowerLimit , upperLimit ) ;
}
public static DateTimeComparator getDateOnlyInstance () {
return DATE_INSTANCE ;
}
public static DateTimeComparator getTimeOnlyInstance () {
return TIME_INSTANCE ;
}
public DateTimeFieldType getLowerLimit () {
return iLowerLimit ;
}
public DateTimeFieldType getUpperLimit () {
return iUpperLimit ;
}
public int compare ( Object lhsObj , Object rhsObj ) {
InstantConverter conv = ConverterManager . getInstance () . getInstantConverter ( lhsObj ) ;
Chronology lhsChrono = conv . getChronology ( lhsObj , ( Chronology ) null ) ;
long lhsMillis = conv . getInstantMillis ( lhsObj , lhsChrono ) ;
if ( lhsObj == rhsObj ) {
return 0 ;
}
conv = ConverterManager . getInstance () . getInstantConverter ( rhsObj ) ;
Chronology rhsChrono = conv . getChronology ( rhsObj , ( Chronology ) null ) ;
long rhsMillis = conv . getInstantMillis ( rhsObj , rhsChrono ) ;
if ( iLowerLimit != null ) {
lhsMillis = iLowerLimit . getField ( lhsChrono ) . roundFloor ( lhsMillis ) ;
rhsMillis = iLowerLimit . getField ( rhsChrono ) . roundFloor ( rhsMillis ) ;
}
if ( iUpperLimit != null ) {
lhsMillis = iUpperLimit . getField ( lhsChrono ) . remainder ( lhsMillis ) ;
rhsMillis = iUpperLimit . getField ( rhsChrono ) . remainder ( rhsMillis ) ;
}
if ( lhsMillis < rhsMillis ) {
return - 1 ;
} else if ( lhsMillis > rhsMillis ) {
return 1 ;
} else {
return 0 ;
}
}
private Object readResolve () {
return getInstance ( iLowerLimit , iUpperLimit ) ;
}
public boolean equals ( Object object ) {
if ( object instanceof DateTimeComparator ) {
DateTimeComparator other = ( DateTimeComparator ) object ;
return ( iLowerLimit == other . getLowerLimit () ||
( iLowerLimit != null && iLowerLimit . equals ( other . getLowerLimit () ) ) ) &&
( iUpperLimit == other . getUpperLimit () ||
( iUpperLimit != null && iUpperLimit . equals ( other . getUpperLimit () ) ) ) ;
}
return false ;
}
public int hashCode () {
return ( iLowerLimit == null ? 0 : iLowerLimit . hashCode () ) +
( 123 * ( iUpperLimit == null ? 0 : iUpperLimit . hashCode () ) ) ;
}
public String toString () {
if ( iLowerLimit == iUpperLimit ) {
return lr_1
+ ( iLowerLimit == null ? lr_2 : iLowerLimit . getName () )
+ lr_3 ;
} else {
return lr_1
+ ( iLowerLimit == null ? lr_2 : iLowerLimit . getName () )
+ lr_4
+ ( iUpperLimit == null ? lr_2 : iUpperLimit . getName () )
+ lr_3 ;
}
}
