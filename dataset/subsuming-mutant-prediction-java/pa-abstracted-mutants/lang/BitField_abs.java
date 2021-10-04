public int getValue ( final int holder ) {
return getRawValue ( holder ) >> _shift_count ;
}
public short getShortValue ( final short holder ) {
return ( short ) getValue ( holder ) ;
}
public int getRawValue ( final int holder ) {
return holder & _mask ;
}
public short getShortRawValue ( final short holder ) {
return ( short ) getRawValue ( holder ) ;
}
public boolean isSet ( final int holder ) {
return ( holder & _mask ) != 0 ;
}
public boolean isAllSet ( final int holder ) {
return ( holder & _mask ) == _mask ;
}
public int setValue ( final int holder , final int value ) {
return ( holder & ~ _mask ) | ( ( value << _shift_count ) & _mask ) ;
}
public short setShortValue ( final short holder , final short value ) {
return ( short ) setValue ( holder , value ) ;
}
public int clear ( final int holder ) {
return holder & ~ _mask ;
}
public short clearShort ( final short holder ) {
return ( short ) clear ( holder ) ;
}
public byte clearByte ( final byte holder ) {
return ( byte ) clear ( holder ) ;
}
public int set ( final int holder ) {
return holder | _mask ;
}
public short setShort ( final short holder ) {
return ( short ) set ( holder ) ;
}
public byte setByte ( final byte holder ) {
return ( byte ) set ( holder ) ;
}
public int setBoolean ( final int holder , final boolean flag ) {
return flag ? set ( holder ) : clear ( holder ) ;
}
public short setShortBoolean ( final short holder , final boolean flag ) {
return flag ? setShort ( holder ) : clearShort ( holder ) ;
}
public byte setByteBoolean ( final byte holder , final boolean flag ) {
return flag ? setByte ( holder ) : clearByte ( holder ) ;
}
