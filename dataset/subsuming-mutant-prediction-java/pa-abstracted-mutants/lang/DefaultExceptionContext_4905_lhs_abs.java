@Override
public DefaultExceptionContext addContextValue ( final String label , final Object value ) {
contextValues . add ( new ImmutablePair < String , Object > ( label , value ) ) ;
return this ;
}
@Override
public DefaultExceptionContext setContextValue ( final String label , final Object value ) {
for ( final Iterator < Pair < String , Object > > iter = contextValues . iterator () ; iter . hasNext () ; ) {
final Pair < String , Object > p = iter . next () ;
if ( StringUtils . equals ( label , p . getKey () ) ) {
iter . remove () ;
}
}
addContextValue ( label , value ) ;
return this ;
}
@Override
public List < Object > getContextValues ( final String label ) {
final List < Object > values = new ArrayList < Object > () ;
for ( final Pair < String , Object > pair : contextValues ) {
if ( StringUtils . equals ( label , pair . getKey () ) ) {
values . add ( pair . getValue () ) ;
}
}
return values ;
}
@Override
public Object getFirstContextValue ( final String label ) {
for ( final Pair < String , Object > pair : contextValues ) {
if ( StringUtils . equals ( label , pair . getKey () ) ) {
return pair . getValue () ;
}
}
return null ;
}
@Override
public Set < String > getContextLabels () {
final Set < String > labels = new HashSet < String > () ;
for ( final Pair < String , Object > pair : contextValues ) {
labels . add ( pair . getKey () ) ;
}
return labels ;
}
@Override
public List < Pair < String , Object > > getContextEntries () {
return contextValues ;
}
@Override
public String getFormattedExceptionMessage ( final String baseMessage ) {
final StringBuilder buffer = new StringBuilder ( 256 ) ;
if ( baseMessage != null ) {
buffer . append ( baseMessage ) ;
}
if ( contextValues . size () > 0 ) {
if ( buffer . length () > 0 ) {
buffer . append ( '\n' ) ;
}
buffer . append ( lr_1 ) ;
int i = 0 ;
for ( final Pair < String , Object > pair : contextValues ) {
buffer . append ( lr_2 ) ;
buffer . append ( ++ i ) ;
buffer . append ( ':' ) ;
buffer . append ( pair . getKey () ) ;
buffer . append ( lr_3 ) ;
final Object value = pair . getValue () ;
if ( value == null ) {
buffer . append ( lr_4 ) ;
} else {
String valueStr ;
try {
valueStr = value . toString () ; MST[NonVoidMethodCallMutator]MSP[]
} catch ( final Exception e ) {
valueStr = lr_5 + ExceptionUtils . getStackTrace ( e ) ;
}
buffer . append ( valueStr ) ;
}
buffer . append ( lr_6 ) ;
}
buffer . append ( lr_7 ) ;
}
return buffer . toString () ;
}
