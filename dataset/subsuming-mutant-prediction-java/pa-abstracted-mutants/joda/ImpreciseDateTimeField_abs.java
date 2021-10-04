public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return FieldUtils . safeToInt ( getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
if ( minuendInstant < subtrahendInstant ) {
return - getDifferenceAsLong ( subtrahendInstant , minuendInstant ) ;
}
long difference = ( minuendInstant - subtrahendInstant ) / iUnitMillis ;
if ( add ( subtrahendInstant , difference ) < minuendInstant ) {
do {
difference ++ ;
} while ( add ( subtrahendInstant , difference ) <= minuendInstant );
difference -- ;
} else if ( add ( subtrahendInstant , difference ) > minuendInstant ) {
do {
difference -- ;
} while ( add ( subtrahendInstant , difference ) > minuendInstant );
}
return difference ;
}
public final DurationField getDurationField () {
return iDurationField ;
}
protected final long getDurationUnitMillis () {
return iUnitMillis ;
}
public boolean isPrecise () {
return false ;
}
public long getUnitMillis () {
return iUnitMillis ;
}
public int getValue ( long duration , long instant ) {
return ImpreciseDateTimeField . this
. getDifference ( instant + duration , instant ) ;
}
public long getValueAsLong ( long duration , long instant ) {
return ImpreciseDateTimeField . this
. getDifferenceAsLong ( instant + duration , instant ) ;
}
public long getMillis ( int value , long instant ) {
return ImpreciseDateTimeField . this . add ( instant , value ) - instant ;
}
public long getMillis ( long value , long instant ) {
return ImpreciseDateTimeField . this . add ( instant , value ) - instant ;
}
public long add ( long instant , int value ) {
return ImpreciseDateTimeField . this . add ( instant , value ) ;
}
public long add ( long instant , long value ) {
return ImpreciseDateTimeField . this . add ( instant , value ) ;
}
public int getDifference ( long minuendInstant , long subtrahendInstant ) {
return ImpreciseDateTimeField . this
. getDifference ( minuendInstant , subtrahendInstant ) ;
}
public long getDifferenceAsLong ( long minuendInstant , long subtrahendInstant ) {
return ImpreciseDateTimeField . this
. getDifferenceAsLong ( minuendInstant , subtrahendInstant ) ;
}
