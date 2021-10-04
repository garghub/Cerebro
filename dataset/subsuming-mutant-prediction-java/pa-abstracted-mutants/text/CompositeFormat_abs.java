@Override
public StringBuffer format ( final Object obj , final StringBuffer toAppendTo ,
final FieldPosition pos ) {
return formatter . format ( obj , toAppendTo , pos ) ;
}
@Override
public Object parseObject ( final String source , final ParsePosition pos ) {
return parser . parseObject ( source , pos ) ;
}
public Format getParser () {
return this . parser ;
}
public Format getFormatter () {
return this . formatter ;
}
public String reformat ( final String input ) throws ParseException {
return format ( parseObject ( input ) ) ;
}
