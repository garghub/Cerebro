static security_class_t
mode_to_security_class ( mode_t m )
{
if ( S_ISREG ( m ) )
return string_to_security_class ( lr_1 ) ;
if ( S_ISDIR ( m ) )
return string_to_security_class ( lr_2 ) ;
if ( S_ISCHR ( m ) )
return string_to_security_class ( lr_3 ) ;
if ( S_ISBLK ( m ) )
return string_to_security_class ( lr_4 ) ;
if ( S_ISFIFO ( m ) )
return string_to_security_class ( lr_5 ) ;
if ( S_ISLNK ( m ) )
return string_to_security_class ( lr_6 ) ;
if ( S_ISSOCK ( m ) )
return string_to_security_class ( lr_7 ) ;
errno = EINVAL ;
return 0 ;
}
static int
computecon ( char const * path , mode_t mode , security_context_t * con )
{
security_context_t scon = NULL ;
security_context_t tcon = NULL ;
security_class_t tclass ;
int rc = - 1 ;
char * dir = dir_name ( path ) ;
if ( ! dir )
goto quit;
if ( getcon ( & scon ) < 0 )
goto quit;
if ( getfilecon ( dir , & tcon ) < 0 )
goto quit;
tclass = mode_to_security_class ( mode ) ;
if ( ! tclass )
goto quit;
rc = security_compute_create ( scon , tcon , tclass , con ) ;
quit:
free ( dir ) ;
freecon ( scon ) ;
freecon ( tcon ) ;
return rc ;
}
int
defaultcon ( char const * path , mode_t mode )
{
int rc = - 1 ;
security_context_t scon = NULL , tcon = NULL ;
context_t scontext = 0 , tcontext = 0 ;
const char * contype ;
char * constr ;
char * newpath = NULL ;
if ( ! IS_ABSOLUTE_FILE_NAME ( path ) )
{
newpath = canonicalize_filename_mode ( path , CAN_MISSING ) ;
if ( ! newpath )
error ( EXIT_FAILURE , errno , _ ( lr_8 ) ,
quote ( path ) ) ;
path = newpath ;
}
if ( matchpathcon ( path , mode , & scon ) < 0 )
{
if ( errno == ENOENT )
errno = ENODATA ;
goto quit;
}
if ( computecon ( path , mode , & tcon ) < 0 )
goto quit;
if ( ! ( scontext = context_new ( scon ) ) )
goto quit;
if ( ! ( tcontext = context_new ( tcon ) ) )
goto quit;
if ( ! ( contype = context_type_get ( scontext ) ) )
goto quit;
if ( context_type_set ( tcontext , contype ) )
goto quit;
if ( ! ( constr = context_str ( tcontext ) ) )
goto quit;
rc = setfscreatecon ( constr ) ;
quit:
context_free ( scontext ) ;
context_free ( tcontext ) ;
freecon ( scon ) ;
freecon ( tcon ) ;
free ( newpath ) ;
return rc ;
}
static int
restorecon_private ( char const * path , bool local )
{
int rc = - 1 ;
struct stat sb ;
security_context_t scon = NULL , tcon = NULL ;
context_t scontext = 0 , tcontext = 0 ;
const char * contype ;
char * constr ;
int fd ;
if ( local )
{
if ( getfscreatecon ( & tcon ) < 0 )
return rc ;
rc = lsetfilecon ( path , tcon ) ;
freecon ( tcon ) ;
return rc ;
}
fd = open ( path , O_RDONLY | O_NOFOLLOW ) ;
if ( fd == - 1 && ( errno != ELOOP ) )
goto quit;
if ( fd != - 1 )
{
if ( fstat ( fd , & sb ) < 0 )
goto quit;
}
else
{
if ( lstat ( path , & sb ) < 0 )
goto quit;
}
if ( matchpathcon ( path , sb . st_mode , & scon ) < 0 )
{
if ( errno == ENOENT )
errno = ENODATA ;
goto quit;
}
if ( ! ( scontext = context_new ( scon ) ) )
goto quit;
if ( fd != - 1 )
{
if ( fgetfilecon ( fd , & tcon ) < 0 )
goto quit;
}
else
{
if ( lgetfilecon ( path , & tcon ) < 0 )
goto quit;
}
if ( ! ( tcontext = context_new ( tcon ) ) )
goto quit;
if ( ! ( contype = context_type_get ( scontext ) ) )
goto quit;
if ( context_type_set ( tcontext , contype ) )
goto quit;
if ( ! ( constr = context_str ( tcontext ) ) )
goto quit;
if ( fd != - 1 )
rc = fsetfilecon ( fd , constr ) ;
else
rc = lsetfilecon ( path , constr ) ;
quit:
if ( fd != - 1 )
close ( fd ) ;
context_free ( scontext ) ;
context_free ( tcontext ) ;
freecon ( scon ) ;
freecon ( tcon ) ;
return rc ;
}
bool
restorecon ( char const * path , bool recurse , bool local )
{
char * newpath = NULL ;
FTS * fts ;
bool ok = true ;
if ( ! IS_ABSOLUTE_FILE_NAME ( path ) && ! local )
{
newpath = canonicalize_filename_mode ( path , CAN_MISSING ) ;
if ( ! newpath )
error ( EXIT_FAILURE , errno , _ ( lr_8 ) ,
quote ( path ) ) ;
}
const char * ftspath [ 2 ] = { newpath ? newpath : path , NULL } ;
if ( ! recurse )
{
ok = restorecon_private ( * ftspath , local ) != - 1 ;
free ( newpath ) ;
return ok ;
}
fts = xfts_open ( ( char * const * ) ftspath , FTS_PHYSICAL , NULL ) ;
while ( 1 )
{
FTSENT * ent ;
ent = fts_read ( fts ) ;
if ( ent == NULL )
{
if ( errno != 0 )
{
error ( 0 , errno , _ ( lr_9 ) ) ;
ok = false ;
}
break;
}
ok &= restorecon_private ( fts -> fts_path , local ) != - 1 ; MST[BITAND$@1$@2$!GT$@1$@2$]MSP[N]
}
if ( fts_close ( fts ) != 0 )
{
error ( 0 , errno , _ ( lr_10 ) ) ;
ok = false ;
}
free ( newpath ) ;
return ok ;
}
