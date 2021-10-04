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
if ( collection != null ) {
if ( last != null ) { MST[RemoveConditionalMutator_EQUAL_IF]MSP[]
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
