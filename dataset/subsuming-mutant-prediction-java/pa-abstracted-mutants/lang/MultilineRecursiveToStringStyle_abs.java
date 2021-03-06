private void resetIndent () {
setArrayStart ( lr_1 + SystemUtils . LINE_SEPARATOR + spacer ( spaces ) ) ;
setArraySeparator ( lr_2 + SystemUtils . LINE_SEPARATOR + spacer ( spaces ) ) ;
setArrayEnd ( SystemUtils . LINE_SEPARATOR + spacer ( spaces - indent ) + lr_3 ) ;
setContentStart ( lr_4 + SystemUtils . LINE_SEPARATOR + spacer ( spaces ) ) ;
setFieldSeparator ( lr_2 + SystemUtils . LINE_SEPARATOR + spacer ( spaces ) ) ;
setContentEnd ( SystemUtils . LINE_SEPARATOR + spacer ( spaces - indent ) + lr_5 ) ;
}
private StringBuilder spacer ( int spaces ) {
StringBuilder sb = new StringBuilder () ;
for ( int i = 0 ; i < spaces ; i ++ ) {
sb . append ( lr_6 ) ;
}
return sb ;
}
@Override
public void appendDetail ( StringBuffer buffer , String fieldName , Object value ) {
if ( ! ClassUtils . isPrimitiveWrapper ( value . getClass () ) && ! String . class . equals ( value . getClass () )
&& accept ( value . getClass () ) ) {
spaces += indent ;
resetIndent () ;
buffer . append ( ReflectionToStringBuilder . toString ( value , this ) ) ;
spaces -= indent ;
resetIndent () ;
} else {
super . appendDetail ( buffer , fieldName , value ) ;
}
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final Object [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void reflectionAppendArrayDetail ( final StringBuffer buffer , final String fieldName , final Object array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final long [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final int [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final short [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final byte [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final char [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final double [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final float [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
@Override
protected void appendDetail ( final StringBuffer buffer , final String fieldName , final boolean [] array ) {
spaces += indent ;
resetIndent () ;
super . appendDetail ( buffer , fieldName , array ) ;
spaces -= indent ;
resetIndent () ;
}
