private void validateClassName ( final String name ) throws InvalidClassException {
for ( final ClassNameMatcher m : rejectMatchers ) {
if ( m . matches ( name ) ) {
invalidClassNameFound ( name ) ;
}
}
boolean ok = false ;
for ( final ClassNameMatcher m : acceptMatchers ) {
if ( m . matches ( name ) ) {
ok = true ;
break;
}
}
if ( ! ok ) {
invalidClassNameFound ( name ) ;
}
}
protected void invalidClassNameFound ( final String className ) throws InvalidClassException {
throw new InvalidClassException ( lr_1 + className ) ; MST[experimental.NakedReceiverMutator]MSP[S]
}
@Override
protected Class < ? > resolveClass ( final ObjectStreamClass osc ) throws IOException , ClassNotFoundException {
validateClassName ( osc . getName () ) ;
return super . resolveClass ( osc ) ;
}
public ValidatingObjectInputStream accept ( final Class < ? > ... classes ) {
for ( final Class < ? > c : classes ) {
acceptMatchers . add ( new FullClassNameMatcher ( c . getName () ) ) ;
}
return this ;
}
public ValidatingObjectInputStream reject ( final Class < ? > ... classes ) {
for ( final Class < ? > c : classes ) {
rejectMatchers . add ( new FullClassNameMatcher ( c . getName () ) ) ;
}
return this ;
}
public ValidatingObjectInputStream accept ( final String ... patterns ) {
for ( final String pattern : patterns ) {
acceptMatchers . add ( new WildcardClassNameMatcher ( pattern ) ) ;
}
return this ;
}
public ValidatingObjectInputStream reject ( final String ... patterns ) {
for ( final String pattern : patterns ) {
rejectMatchers . add ( new WildcardClassNameMatcher ( pattern ) ) ;
}
return this ;
}
public ValidatingObjectInputStream accept ( final Pattern pattern ) {
acceptMatchers . add ( new RegexpClassNameMatcher ( pattern ) ) ;
return this ;
}
public ValidatingObjectInputStream reject ( final Pattern pattern ) {
rejectMatchers . add ( new RegexpClassNameMatcher ( pattern ) ) ;
return this ;
}
public ValidatingObjectInputStream accept ( final ClassNameMatcher m ) {
acceptMatchers . add ( m ) ;
return this ;
}
public ValidatingObjectInputStream reject ( final ClassNameMatcher m ) {
rejectMatchers . add ( m ) ;
return this ;
}
