public static < E > LazyList < E > lazyList ( final List < E > list , final Factory < ? extends E > factory ) {
return new LazyList <> ( list , factory ) ;
}
public static < E > LazyList < E > lazyList ( final List < E > list , final Transformer < Integer , ? extends E > transformer ) {
return new LazyList <> ( list , transformer ) ;
}
@Override
public E get ( final int index ) {
final int size = decorated () . size () ;
if ( index < size ) {
E object = decorated () . get ( index ) ;
if ( object == null ) {
object = element ( index ) ; MST[rv.UOI3Mutator]MSP[S]
decorated () . set ( index , object ) ;
return object ;
}
return object ;
}
for ( int i = size ; i < index ; i ++ ) {
decorated () . add ( null ) ;
}
final E object = element ( index ) ;
decorated () . add ( object ) ;
return object ;
}
@Override
public List < E > subList ( final int fromIndex , final int toIndex ) {
final List < E > sub = decorated () . subList ( fromIndex , toIndex ) ;
if ( factory != null ) {
return new LazyList <> ( sub , factory ) ;
} else if ( transformer != null ) {
return new LazyList <> ( sub , transformer ) ;
} else {
throw new IllegalStateException ( lr_1 ) ;
}
}
private E element ( final int index ) {
if ( factory != null ) {
return factory . create () ;
} else if ( transformer != null ) {
return transformer . transform ( index ) ;
} else {
throw new IllegalStateException ( lr_1 ) ;
}
}
