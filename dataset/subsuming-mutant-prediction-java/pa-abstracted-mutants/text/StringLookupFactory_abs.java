public StringLookup dateStringLookup () {
return DateStringLookup . INSTANCE ;
}
public StringLookup environmentVariableStringLookup () {
return EnvironmentVariableStringLookup . INSTANCE ;
}
public StringLookup interpolatorStringLookup () {
return new InterpolatorStringLookup () ;
}
public < V > StringLookup interpolatorStringLookup ( final Map < String , V > map ) {
return new InterpolatorStringLookup ( map ) ;
}
public StringLookup interpolatorStringLookup ( final StringLookup defaultStringLookup ) {
return new InterpolatorStringLookup ( defaultStringLookup ) ;
}
public StringLookup javaPlatformStringLookup () {
return JavaPlatformStringLookup . INSTANCE ;
}
public StringLookup localHostStringLookup () {
return LocalHostStringLookup . INSTANCE ;
}
public < V > StringLookup mapStringLookup ( final Map < String , V > map ) {
return MapStringLookup . on ( map ) ;
}
public StringLookup nullStringLookup () {
return NullStringLookup . INSTANCE ;
}
public StringLookup resourceBundleStringLookup () {
return ResourceBundleStringLookup . INSTANCE ;
}
public StringLookup systemPropertyStringLookup () {
return SystemPropertyStringLookup . INSTANCE ;
}
