@Override
public boolean hasNext () {
return iterator . hasPrevious () ;
}
@Override
public E next () {
final E obj = iterator . previous () ;
validForUpdate = true ;
return obj ;
}
@Override
public int nextIndex () {
return iterator . previousIndex () ;
}
@Override
public boolean hasPrevious () {
return iterator . hasNext () ;
}
@Override
public E previous () {
final E obj = iterator . next () ;
validForUpdate = true ;
return obj ;
}
@Override
public int previousIndex () {
return iterator . nextIndex () ;
}
@Override
public void remove () {
if ( validForUpdate == false ) { MST[rv.ROR5Mutator]MSP[]
throw new IllegalStateException ( lr_1 ) ;
}
iterator . remove () ;
}
@Override
public void set ( final E obj ) {
if ( validForUpdate == false ) {
throw new IllegalStateException ( lr_2 ) ;
}
iterator . set ( obj ) ;
}
@Override
public void add ( final E obj ) {
if ( validForUpdate == false ) {
throw new IllegalStateException ( lr_3 ) ;
}
validForUpdate = false ;
iterator . add ( obj ) ;
iterator . previous () ;
}
@Override
public void reset () {
iterator = list . listIterator ( list . size () ) ;
}
