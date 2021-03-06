@Override
public Boolean getValue () {
return Boolean . valueOf ( this . value ) ;
}
public void setValue ( final boolean value ) {
this . value = value ;
}
public void setFalse () {
this . value = false ;
}
public void setTrue () {
this . value = true ;
}
@Override
public void setValue ( final Boolean value ) {
this . value = value . booleanValue () ;
}
public boolean isTrue () {
return value == true ;
}
public boolean isFalse () {
return value == false ;
}
public boolean booleanValue () {
return value ;
}
public Boolean toBoolean () {
return Boolean . valueOf ( booleanValue () ) ;
}
@Override
public boolean equals ( final Object obj ) {
if ( obj instanceof MutableBoolean ) {
return value == ( ( MutableBoolean ) obj ) . booleanValue () ;
}
return false ;
}
@Override
public int hashCode () {
return value ? Boolean . TRUE . hashCode () : Boolean . FALSE . hashCode () ;
}
@Override
public int compareTo ( final MutableBoolean other ) {
return BooleanUtils . compare ( this . value , other . value ) ;
}
@Override
public String toString () {
return String . valueOf ( value ) ;
}
