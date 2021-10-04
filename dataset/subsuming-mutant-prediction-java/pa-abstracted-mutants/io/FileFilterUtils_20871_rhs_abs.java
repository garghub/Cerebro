public static File [] filter ( final IOFileFilter filter , final File ... files ) {
if ( filter == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( files == null ) {
return new File [ 0 ] ;
}
final List < File > acceptedFiles = new ArrayList <> () ;
for ( final File file : files ) {
if ( file == null ) {
throw new IllegalArgumentException ( lr_2 ) ;
}
if ( filter . accept ( file ) ) {
acceptedFiles . add ( file ) ;
}
}
return acceptedFiles . toArray ( new File [ acceptedFiles . size () ] ) ;
}
public static File [] filter ( final IOFileFilter filter , final Iterable < File > files ) {
final List < File > acceptedFiles = filterList ( filter , files ) ;
return acceptedFiles . toArray ( new File [ acceptedFiles . size () ] ) ;
}
public static List < File > filterList ( final IOFileFilter filter , final Iterable < File > files ) {
return filter ( filter , files , new ArrayList < File > () ) ;
}
public static List < File > filterList ( final IOFileFilter filter , final File ... files ) {
final File [] acceptedFiles = filter ( filter , files ) ;
return Arrays . asList ( acceptedFiles ) ;
}
public static Set < File > filterSet ( final IOFileFilter filter , final File ... files ) {
final File [] acceptedFiles = filter ( filter , files ) ;
return new HashSet <> ( Arrays . asList ( acceptedFiles ) ) ;
}
public static Set < File > filterSet ( final IOFileFilter filter , final Iterable < File > files ) {
return filter ( filter , files , new HashSet < File > () ) ;
}
private static < T extends Collection < File > > T filter ( final IOFileFilter filter ,
final Iterable < File > files , final T acceptedFiles ) {
if ( filter == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
if ( files != null ) {
for ( final File file : files ) {
if ( file == null ) {
throw new IllegalArgumentException ( lr_3 ) ;
}
if ( filter . accept ( file ) ) {
acceptedFiles . add ( file ) ;
}
}
}
return acceptedFiles ;
}
public static IOFileFilter prefixFileFilter ( final String prefix ) {
return new PrefixFileFilter ( prefix ) ;
}
public static IOFileFilter prefixFileFilter ( final String prefix , final IOCase caseSensitivity ) {
return new PrefixFileFilter ( prefix , caseSensitivity ) ;
}
public static IOFileFilter suffixFileFilter ( final String suffix ) {
return new SuffixFileFilter ( suffix ) ; MST[ReturnValsMutator]MSP[N]
}
public static IOFileFilter suffixFileFilter ( final String suffix , final IOCase caseSensitivity ) {
return new SuffixFileFilter ( suffix , caseSensitivity ) ;
}
public static IOFileFilter nameFileFilter ( final String name ) {
return new NameFileFilter ( name ) ;
}
public static IOFileFilter nameFileFilter ( final String name , final IOCase caseSensitivity ) {
return new NameFileFilter ( name , caseSensitivity ) ;
}
public static IOFileFilter directoryFileFilter () {
return DirectoryFileFilter . DIRECTORY ;
}
public static IOFileFilter fileFileFilter () {
return FileFileFilter . FILE ;
}
@Deprecated
public static IOFileFilter andFileFilter ( final IOFileFilter filter1 , final IOFileFilter filter2 ) {
return new AndFileFilter ( filter1 , filter2 ) ;
}
@Deprecated
public static IOFileFilter orFileFilter ( final IOFileFilter filter1 , final IOFileFilter filter2 ) {
return new OrFileFilter ( filter1 , filter2 ) ;
}
public static IOFileFilter and ( final IOFileFilter ... filters ) {
return new AndFileFilter ( toList ( filters ) ) ;
}
public static IOFileFilter or ( final IOFileFilter ... filters ) {
return new OrFileFilter ( toList ( filters ) ) ;
}
public static List < IOFileFilter > toList ( final IOFileFilter ... filters ) {
if ( filters == null ) {
throw new IllegalArgumentException ( lr_4 ) ;
}
final List < IOFileFilter > list = new ArrayList <> ( filters . length ) ;
for ( int i = 0 ; i < filters . length ; i ++ ) {
if ( filters [ i ] == null ) {
throw new IllegalArgumentException ( lr_5 + i + lr_6 ) ;
}
list . add ( filters [ i ] ) ;
}
return list ;
}
public static IOFileFilter notFileFilter ( final IOFileFilter filter ) {
return new NotFileFilter ( filter ) ;
}
public static IOFileFilter trueFileFilter () {
return TrueFileFilter . TRUE ;
}
public static IOFileFilter falseFileFilter () {
return FalseFileFilter . FALSE ;
}
public static IOFileFilter asFileFilter ( final FileFilter filter ) {
return new DelegateFileFilter ( filter ) ;
}
public static IOFileFilter asFileFilter ( final FilenameFilter filter ) {
return new DelegateFileFilter ( filter ) ;
}
public static IOFileFilter ageFileFilter ( final long cutoff ) {
return new AgeFileFilter ( cutoff ) ;
}
public static IOFileFilter ageFileFilter ( final long cutoff , final boolean acceptOlder ) {
return new AgeFileFilter ( cutoff , acceptOlder ) ;
}
public static IOFileFilter ageFileFilter ( final Date cutoffDate ) {
return new AgeFileFilter ( cutoffDate ) ;
}
public static IOFileFilter ageFileFilter ( final Date cutoffDate , final boolean acceptOlder ) {
return new AgeFileFilter ( cutoffDate , acceptOlder ) ;
}
public static IOFileFilter ageFileFilter ( final File cutoffReference ) {
return new AgeFileFilter ( cutoffReference ) ;
}
public static IOFileFilter ageFileFilter ( final File cutoffReference , final boolean acceptOlder ) {
return new AgeFileFilter ( cutoffReference , acceptOlder ) ;
}
public static IOFileFilter sizeFileFilter ( final long threshold ) {
return new SizeFileFilter ( threshold ) ;
}
public static IOFileFilter sizeFileFilter ( final long threshold , final boolean acceptLarger ) {
return new SizeFileFilter ( threshold , acceptLarger ) ;
}
public static IOFileFilter sizeRangeFileFilter ( final long minSizeInclusive , final long maxSizeInclusive ) {
final IOFileFilter minimumFilter = new SizeFileFilter ( minSizeInclusive , true ) ;
final IOFileFilter maximumFilter = new SizeFileFilter ( maxSizeInclusive + 1L , false ) ;
return new AndFileFilter ( minimumFilter , maximumFilter ) ;
}
public static IOFileFilter magicNumberFileFilter ( final String magicNumber ) {
return new MagicNumberFileFilter ( magicNumber ) ;
}
public static IOFileFilter magicNumberFileFilter ( final String magicNumber , final long offset ) {
return new MagicNumberFileFilter ( magicNumber , offset ) ;
}
public static IOFileFilter magicNumberFileFilter ( final byte [] magicNumber ) {
return new MagicNumberFileFilter ( magicNumber ) ;
}
public static IOFileFilter magicNumberFileFilter ( final byte [] magicNumber , final long offset ) {
return new MagicNumberFileFilter ( magicNumber , offset ) ;
}
public static IOFileFilter makeCVSAware ( final IOFileFilter filter ) {
return filter == null ? cvsFilter : and ( filter , cvsFilter ) ;
}
public static IOFileFilter makeSVNAware ( final IOFileFilter filter ) {
return filter == null ? svnFilter : and ( filter , svnFilter ) ;
}
public static IOFileFilter makeDirectoryOnly ( final IOFileFilter filter ) {
if ( filter == null ) {
return DirectoryFileFilter . DIRECTORY ;
}
return new AndFileFilter ( DirectoryFileFilter . DIRECTORY , filter ) ;
}
public static IOFileFilter makeFileOnly ( final IOFileFilter filter ) {
if ( filter == null ) {
return FileFileFilter . FILE ;
}
return new AndFileFilter ( FileFileFilter . FILE , filter ) ;
}
