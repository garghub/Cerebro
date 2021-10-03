@Override
public tp_1 append ( final char vr_1 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . append ( vr_1 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
return this ;
}
@Override
public tp_1 append ( final tp_2 vr_6 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . append ( vr_6 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
return this ;
}
@Override
public tp_1 append ( final tp_2 vr_6 , final int vr_7 , final int vr_8 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . append ( vr_6 , vr_7 , vr_8 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
return this ;
}
@Override
public void fn_3 () throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . fn_3 () ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
}
@Override
public void fn_4 () throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . fn_4 () ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
}
@Override
public void fn_5 ( final char vr_9 [] , final int vr_10 , final int vr_11 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . fn_5 ( vr_9 , vr_10 , vr_11 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
}
@Override
public void fn_5 ( final char [] vr_9 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . fn_5 ( vr_9 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
}
@Override
public void fn_5 ( final int vr_1 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . fn_5 ( vr_1 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
}
@Override
public void fn_5 ( final String vr_12 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . fn_5 ( vr_12 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
}
@Override
public void fn_5 ( final String vr_12 , final int vr_10 , final int vr_11 ) throws IOException {
final List < Exception > vr_2 = new ArrayList <> () ;
int vr_3 = 0 ;
for ( final tp_1 vr_4 : vl_1 ) {
if ( vr_4 != null ) {
try {
vr_4 . fn_5 ( vr_12 , vr_10 , vr_11 ) ;
} catch ( final IOException vr_5 ) {
vr_2 . add ( new fn_1 ( vr_3 , vr_5 ) ) ;
}
}
vr_3 ++ ;
}
if ( ! vr_2 . isEmpty () ) {
throw new fn_2 ( vr_2 ) ;
}
}
