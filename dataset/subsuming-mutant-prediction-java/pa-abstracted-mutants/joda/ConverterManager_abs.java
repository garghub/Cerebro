public static ConverterManager getInstance () {
if ( INSTANCE == null ) {
INSTANCE = new ConverterManager () ;
}
return INSTANCE ;
}
public InstantConverter getInstantConverter ( Object object ) {
InstantConverter converter =
( InstantConverter ) iInstantConverters . select ( object == null ? null : object . getClass () ) ;
if ( converter != null ) {
return converter ;
}
throw new IllegalArgumentException ( lr_1 +
( object == null ? lr_2 : object . getClass () . getName () ) ) ;
}
public InstantConverter [] getInstantConverters () {
ConverterSet set = iInstantConverters ;
InstantConverter [] converters = new InstantConverter [ set . size () ] ;
set . copyInto ( converters ) ;
return converters ;
}
public InstantConverter addInstantConverter ( InstantConverter converter )
throws SecurityException {
checkAlterInstantConverters () ;
if ( converter == null ) {
return null ;
}
InstantConverter [] removed = new InstantConverter [ 1 ] ;
iInstantConverters = iInstantConverters . add ( converter , removed ) ;
return removed [ 0 ] ;
}
public InstantConverter removeInstantConverter ( InstantConverter converter )
throws SecurityException {
checkAlterInstantConverters () ;
if ( converter == null ) {
return null ;
}
InstantConverter [] removed = new InstantConverter [ 1 ] ;
iInstantConverters = iInstantConverters . remove ( converter , removed ) ;
return removed [ 0 ] ;
}
private void checkAlterInstantConverters () throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_3 ) ) ;
}
}
public PartialConverter getPartialConverter ( Object object ) {
PartialConverter converter =
( PartialConverter ) iPartialConverters . select ( object == null ? null : object . getClass () ) ;
if ( converter != null ) {
return converter ;
}
throw new IllegalArgumentException ( lr_4 +
( object == null ? lr_2 : object . getClass () . getName () ) ) ;
}
public PartialConverter [] getPartialConverters () {
ConverterSet set = iPartialConverters ;
PartialConverter [] converters = new PartialConverter [ set . size () ] ;
set . copyInto ( converters ) ;
return converters ;
}
public PartialConverter addPartialConverter ( PartialConverter converter )
throws SecurityException {
checkAlterPartialConverters () ;
if ( converter == null ) {
return null ;
}
PartialConverter [] removed = new PartialConverter [ 1 ] ;
iPartialConverters = iPartialConverters . add ( converter , removed ) ;
return removed [ 0 ] ;
}
public PartialConverter removePartialConverter ( PartialConverter converter )
throws SecurityException {
checkAlterPartialConverters () ;
if ( converter == null ) {
return null ;
}
PartialConverter [] removed = new PartialConverter [ 1 ] ;
iPartialConverters = iPartialConverters . remove ( converter , removed ) ;
return removed [ 0 ] ;
}
private void checkAlterPartialConverters () throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_5 ) ) ;
}
}
public DurationConverter getDurationConverter ( Object object ) {
DurationConverter converter =
( DurationConverter ) iDurationConverters . select ( object == null ? null : object . getClass () ) ;
if ( converter != null ) {
return converter ;
}
throw new IllegalArgumentException ( lr_6 +
( object == null ? lr_2 : object . getClass () . getName () ) ) ;
}
public DurationConverter [] getDurationConverters () {
ConverterSet set = iDurationConverters ;
DurationConverter [] converters = new DurationConverter [ set . size () ] ;
set . copyInto ( converters ) ;
return converters ;
}
public DurationConverter addDurationConverter ( DurationConverter converter )
throws SecurityException {
checkAlterDurationConverters () ;
if ( converter == null ) {
return null ;
}
DurationConverter [] removed = new DurationConverter [ 1 ] ;
iDurationConverters = iDurationConverters . add ( converter , removed ) ;
return removed [ 0 ] ;
}
public DurationConverter removeDurationConverter ( DurationConverter converter )
throws SecurityException {
checkAlterDurationConverters () ;
if ( converter == null ) {
return null ;
}
DurationConverter [] removed = new DurationConverter [ 1 ] ;
iDurationConverters = iDurationConverters . remove ( converter , removed ) ;
return removed [ 0 ] ;
}
private void checkAlterDurationConverters () throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_7 ) ) ;
}
}
public PeriodConverter getPeriodConverter ( Object object ) {
PeriodConverter converter =
( PeriodConverter ) iPeriodConverters . select ( object == null ? null : object . getClass () ) ;
if ( converter != null ) {
return converter ;
}
throw new IllegalArgumentException ( lr_8 +
( object == null ? lr_2 : object . getClass () . getName () ) ) ;
}
public PeriodConverter [] getPeriodConverters () {
ConverterSet set = iPeriodConverters ;
PeriodConverter [] converters = new PeriodConverter [ set . size () ] ;
set . copyInto ( converters ) ;
return converters ;
}
public PeriodConverter addPeriodConverter ( PeriodConverter converter )
throws SecurityException {
checkAlterPeriodConverters () ;
if ( converter == null ) {
return null ;
}
PeriodConverter [] removed = new PeriodConverter [ 1 ] ;
iPeriodConverters = iPeriodConverters . add ( converter , removed ) ;
return removed [ 0 ] ;
}
public PeriodConverter removePeriodConverter ( PeriodConverter converter )
throws SecurityException {
checkAlterPeriodConverters () ;
if ( converter == null ) {
return null ;
}
PeriodConverter [] removed = new PeriodConverter [ 1 ] ;
iPeriodConverters = iPeriodConverters . remove ( converter , removed ) ;
return removed [ 0 ] ;
}
private void checkAlterPeriodConverters () throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_9 ) ) ;
}
}
public IntervalConverter getIntervalConverter ( Object object ) {
IntervalConverter converter =
( IntervalConverter ) iIntervalConverters . select ( object == null ? null : object . getClass () ) ;
if ( converter != null ) {
return converter ;
}
throw new IllegalArgumentException ( lr_10 +
( object == null ? lr_2 : object . getClass () . getName () ) ) ;
}
public IntervalConverter [] getIntervalConverters () {
ConverterSet set = iIntervalConverters ;
IntervalConverter [] converters = new IntervalConverter [ set . size () ] ;
set . copyInto ( converters ) ;
return converters ;
}
public IntervalConverter addIntervalConverter ( IntervalConverter converter )
throws SecurityException {
checkAlterIntervalConverters () ;
if ( converter == null ) {
return null ;
}
IntervalConverter [] removed = new IntervalConverter [ 1 ] ;
iIntervalConverters = iIntervalConverters . add ( converter , removed ) ;
return removed [ 0 ] ;
}
public IntervalConverter removeIntervalConverter ( IntervalConverter converter )
throws SecurityException {
checkAlterIntervalConverters () ;
if ( converter == null ) {
return null ;
}
IntervalConverter [] removed = new IntervalConverter [ 1 ] ;
iIntervalConverters = iIntervalConverters . remove ( converter , removed ) ;
return removed [ 0 ] ;
}
private void checkAlterIntervalConverters () throws SecurityException {
SecurityManager sm = System . getSecurityManager () ;
if ( sm != null ) {
sm . checkPermission ( new JodaTimePermission ( lr_11 ) ) ;
}
}
public String toString () {
return lr_12 +
iInstantConverters . size () + lr_13 +
iPartialConverters . size () + lr_14 +
iDurationConverters . size () + lr_15 +
iPeriodConverters . size () + lr_16 +
iIntervalConverters . size () + lr_17 ;
}
