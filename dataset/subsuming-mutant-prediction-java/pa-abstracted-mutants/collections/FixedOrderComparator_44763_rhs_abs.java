public boolean isLocked () {
return isLocked ;
}
protected void checkLocked () {
if ( isLocked () ) {
throw new UnsupportedOperationException ( lr_1 ) ;
}
}
public UnknownObjectBehavior getUnknownObjectBehavior () {
return unknownObjectBehavior ;
}
public void setUnknownObjectBehavior ( final UnknownObjectBehavior unknownObjectBehavior ) {
checkLocked () ;
this . unknownObjectBehavior = Objects . requireNonNull ( unknownObjectBehavior , lr_2 ) ;
}
public boolean add ( final T obj ) {
checkLocked () ;
final Integer position = map . put ( obj , Integer . valueOf ( counter ++ ) ) ;
return position == null ;
}
public boolean addAsEqual ( final T existingObj , final T newObj ) {
checkLocked () ;
final Integer position = map . get ( existingObj ) ;
if ( position == null ) {
throw new IllegalArgumentException ( existingObj + lr_3 + this ) ;
}
final Integer result = map . put ( newObj , position ) ;
return result == null ;
}
@Override
public int compare ( final T obj1 , final T obj2 ) {
isLocked = true ;
final Integer position1 = map . get ( obj1 ) ;
final Integer position2 = map . get ( obj2 ) ;
if ( position1 == null || position2 == null ) {
switch ( unknownObjectBehavior ) {
case BEFORE :
return position1 == null ? position2 == null ? 0 : - 1 : 1 ;
case AFTER :
return position1 == null ? position2 == null ? 0 : 1 : - 1 ;
case EXCEPTION :
final Object unknownObj = position1 == null ? obj1 : obj2 ;
throw new IllegalArgumentException ( lr_4
+ unknownObj ) ;
default:
throw new UnsupportedOperationException ( lr_5
+ unknownObjectBehavior ) ;
}
}
return position1 . compareTo ( position2 ) ;
}
@Override
public int hashCode () {
int total = 17 ; MST[rv.CRCR1Mutator]MSP[S]
total = total * 37 + map . hashCode () ;
total = total * 37 + ( unknownObjectBehavior == null ? 0 : unknownObjectBehavior . hashCode () ) ;
total = total * 37 + counter ;
total = total * 37 + ( isLocked ? 0 : 1 ) ;
return total ;
}
@Override
public boolean equals ( final Object object ) {
if ( this == object ) {
return true ;
}
if ( null == object ) {
return false ;
}
if ( object . getClass () . equals ( this . getClass () ) ) {
final FixedOrderComparator < ? > comp = ( FixedOrderComparator < ? > ) object ;
return ( null == map ? null == comp . map : map . equals ( comp . map ) ) &&
( null == unknownObjectBehavior ? null == comp . unknownObjectBehavior :
unknownObjectBehavior == comp . unknownObjectBehavior &&
counter == comp . counter &&
isLocked == comp . isLocked &&
unknownObjectBehavior == comp . unknownObjectBehavior ) ;
}
return false ;
}
