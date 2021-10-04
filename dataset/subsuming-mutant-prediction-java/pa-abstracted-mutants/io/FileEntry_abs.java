public boolean refresh ( final File file ) {
final boolean origExists = exists ;
final long origLastModified = lastModified ;
final boolean origDirectory = directory ;
final long origLength = length ;
name = file . getName () ;
exists = file . exists () ;
directory = exists && file . isDirectory () ;
lastModified = exists ? file . lastModified () : 0 ;
length = exists && ! directory ? file . length () : 0 ;
return exists != origExists ||
lastModified != origLastModified ||
directory != origDirectory ||
length != origLength ;
}
public FileEntry newChildInstance ( final File file ) {
return new FileEntry ( this , file ) ;
}
public FileEntry getParent () {
return parent ;
}
public int getLevel () {
return parent == null ? 0 : parent . getLevel () + 1 ;
}
public FileEntry [] getChildren () {
return children != null ? children : EMPTY_ENTRIES ;
}
public void setChildren ( final FileEntry [] children ) {
this . children = children ;
}
public File getFile () {
return file ;
}
public String getName () {
return name ;
}
public void setName ( final String name ) {
this . name = name ;
}
public long getLastModified () {
return lastModified ;
}
public void setLastModified ( final long lastModified ) {
this . lastModified = lastModified ;
}
public long getLength () {
return length ;
}
public void setLength ( final long length ) {
this . length = length ;
}
public boolean isExists () {
return exists ;
}
public void setExists ( final boolean exists ) {
this . exists = exists ;
}
public boolean isDirectory () {
return directory ;
}
public void setDirectory ( final boolean directory ) {
this . directory = directory ;
}
