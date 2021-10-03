extern bool
print_group_list ( const char * username ,
uid_t ruid , gid_t rgid , gid_t egid ,
bool use_names , char delim )
{
bool ok = true ;
struct passwd * pwd = NULL ;
if ( username )
{
pwd = getpwuid ( ruid ) ;
if ( pwd == NULL )
ok = false ;
}
if ( ! print_group ( rgid , use_names ) )
ok = false ;
if ( egid != rgid )
{
putchar ( delim ) ;
if ( ! print_group ( egid , use_names ) )
ok = false ;
}
{
gid_t * groups ;
int i ;
int n_groups = xgetgroups ( username , ( pwd ? pwd -> pw_gid : egid ) , & groups ) ;
if ( n_groups < 0 )
{
if ( username )
{
error ( 0 , errno , _ ( lr_1 ) ,
quote ( username ) ) ;
}
else
{
error ( 0 , errno , _ ( lr_2 ) ) ;
}
return false ;
}
for ( i = 0 ; i < n_groups ; i ++ )
if ( groups [ i ] != rgid && groups [ i ] != egid )
{
putchar ( delim ) ;
if ( ! print_group ( groups [ i ] , use_names ) )
ok = false ;
}
free ( groups ) ;
}
return ok ;
}
static char *
gidtostr_ptr ( gid_t const * gid )
{
static char buf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
return umaxtostr ( * gid , buf ) ;
}
extern bool
print_group ( gid_t gid , bool use_name )
{
struct group * grp = NULL ;
bool ok = true ;
if ( use_name )
{
grp = getgrgid ( gid ) ;
if ( grp == NULL )
{
error ( 0 , 0 , _ ( lr_3 ) ,
( unsigned long int ) gid ) ;
ok = false ;
}
}
char * s = grp ? grp -> gr_name : gidtostr ( gid ) ;
fputs ( s , stdout ) ; MST[STMT!TRAPSTMT]MSP[]
return ok ;
}
