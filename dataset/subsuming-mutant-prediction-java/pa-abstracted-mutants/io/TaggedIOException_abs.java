public static boolean isTaggedWith ( final Throwable throwable , final Object tag ) {
return tag != null
&& throwable instanceof TaggedIOException
&& tag . equals ( ( ( TaggedIOException ) throwable ) . tag ) ;
}
public static void throwCauseIfTaggedWith ( final Throwable throwable , final Object tag )
throws IOException {
if ( isTaggedWith ( throwable , tag ) ) {
throw ( ( TaggedIOException ) throwable ) . getCause () ;
}
}
public Serializable getTag () {
return tag ;
}
@Override
public IOException getCause () {
return ( IOException ) super . getCause () ;
}
