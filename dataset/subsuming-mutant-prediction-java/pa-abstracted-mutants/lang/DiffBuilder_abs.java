@Override
public Boolean getLeft () {
return Boolean . valueOf ( lhs ) ;
}
@Override
public Boolean getRight () {
return Boolean . valueOf ( rhs ) ;
}
@Override
public Boolean [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Boolean [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Byte getLeft () {
return Byte . valueOf ( lhs ) ;
}
@Override
public Byte getRight () {
return Byte . valueOf ( rhs ) ;
}
@Override
public Byte [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Byte [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Character getLeft () {
return Character . valueOf ( lhs ) ;
}
@Override
public Character getRight () {
return Character . valueOf ( rhs ) ;
}
@Override
public Character [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Character [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Double getLeft () {
return Double . valueOf ( lhs ) ;
}
@Override
public Double getRight () {
return Double . valueOf ( rhs ) ;
}
@Override
public Double [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Double [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Float getLeft () {
return Float . valueOf ( lhs ) ;
}
@Override
public Float getRight () {
return Float . valueOf ( rhs ) ;
}
@Override
public Float [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Float [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Integer getLeft () {
return Integer . valueOf ( lhs ) ;
}
@Override
public Integer getRight () {
return Integer . valueOf ( rhs ) ;
}
@Override
public Integer [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Integer [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Long getLeft () {
return Long . valueOf ( lhs ) ;
}
@Override
public Long getRight () {
return Long . valueOf ( rhs ) ;
}
@Override
public Long [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Long [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Short getLeft () {
return Short . valueOf ( lhs ) ;
}
@Override
public Short getRight () {
return Short . valueOf ( rhs ) ;
}
@Override
public Short [] getLeft () {
return ArrayUtils . toObject ( lhs ) ;
}
@Override
public Short [] getRight () {
return ArrayUtils . toObject ( rhs ) ;
}
@Override
public Object getLeft () {
return lhs ;
}
@Override
public Object getRight () {
return rhs ;
}
@Override
public Object [] getLeft () {
return lhs ;
}
@Override
public Object [] getRight () {
return rhs ;
}
@Override
public DiffResult build () {
return new DiffResult ( left , right , diffs , style ) ;
}
