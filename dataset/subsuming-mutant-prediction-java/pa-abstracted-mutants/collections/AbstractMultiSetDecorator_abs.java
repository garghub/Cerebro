@Override
protected MultiSet < E > decorated () {
return ( MultiSet < E > ) super . decorated () ;
}
@Override
public boolean equals ( final Object object ) {
return object == this || decorated () . equals ( object ) ;
}
@Override
public int hashCode () {
return decorated () . hashCode () ;
}
@Override
public int getCount ( final Object object ) {
return decorated () . getCount ( object ) ;
}
@Override
public int setCount ( final E object , final int count ) {
return decorated () . setCount ( object , count ) ;
}
@Override
public int add ( final E object , final int count ) {
return decorated () . add ( object , count ) ;
}
@Override
public int remove ( final Object object , final int count ) {
return decorated () . remove ( object , count ) ;
}
@Override
public Set < E > uniqueSet () {
return decorated () . uniqueSet () ;
}
@Override
public Set < Entry < E > > entrySet () {
return decorated () . entrySet () ;
}
