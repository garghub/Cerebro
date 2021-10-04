@Override
public boolean hasNext () {
return enumeration . hasMoreElements () ;
}
@Override
public E next () {
last = enumeration . nextElement () ;
return last ;
}
@Override
public void remove () {
if ( collection != null ) { MST[rv.ROR5Mutator]MSP[S]
if ( last != null ) {
collection . remove ( last ) ;
} else {
throw new IllegalStateException ( lr_1 ) ;
}
} else {
throw new UnsupportedOperationException ( lr_2 ) ;
}
}
public Enumeration < ? extends E > getEnumeration () {
return enumeration ;
}
public void setEnumeration ( final Enumeration < ? extends E > enumeration ) {
this . enumeration = enumeration ;
}
