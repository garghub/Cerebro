public boolean isCauseOf ( final Exception exception ) {
return TaggedIOException . isTaggedWith ( exception , tag ) ;
}
public void throwIfCauseOf ( final Exception exception ) throws IOException {
TaggedIOException . throwCauseIfTaggedWith ( exception , tag ) ;
}
@Override
protected void handleIOException ( final IOException e ) throws IOException {
throw new TaggedIOException ( e , tag ) ;
}
