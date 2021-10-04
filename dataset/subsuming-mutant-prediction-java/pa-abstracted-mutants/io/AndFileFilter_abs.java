@Override
public void addFileFilter ( final IOFileFilter ioFileFilter ) {
this . fileFilters . add ( ioFileFilter ) ;
}
@Override
public List < IOFileFilter > getFileFilters () {
return Collections . unmodifiableList ( this . fileFilters ) ;
}
@Override
public boolean removeFileFilter ( final IOFileFilter ioFileFilter ) {
return this . fileFilters . remove ( ioFileFilter ) ;
}
@Override
public void setFileFilters ( final List < IOFileFilter > fileFilters ) {
this . fileFilters . clear () ;
this . fileFilters . addAll ( fileFilters ) ;
}
@Override
public boolean accept ( final File file ) {
if ( this . fileFilters . isEmpty () ) {
return false ;
}
for ( final IOFileFilter fileFilter : fileFilters ) {
if ( ! fileFilter . accept ( file ) ) {
return false ;
}
}
return true ;
}
@Override
public boolean accept ( final File file , final String name ) {
if ( this . fileFilters . isEmpty () ) {
return false ;
}
for ( final IOFileFilter fileFilter : fileFilters ) {
if ( ! fileFilter . accept ( file , name ) ) {
return false ;
}
}
return true ;
}
@Override
public String toString () {
final StringBuilder buffer = new StringBuilder () ;
buffer . append ( super . toString () ) ;
buffer . append ( lr_1 ) ;
if ( fileFilters != null ) {
for ( int i = 0 ; i < fileFilters . size () ; i ++ ) {
if ( i > 0 ) {
buffer . append ( lr_2 ) ;
}
final Object filter = fileFilters . get ( i ) ;
buffer . append ( filter == null ? lr_3 : filter . toString () ) ;
}
}
buffer . append ( lr_4 ) ;
return buffer . toString () ;
}
