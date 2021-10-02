static bool
fn_1 ( int vr_1 )
{
return vr_1 == vl_1 || vr_1 == vl_2 ;
}
static bool
fn_2 ( int vr_1 )
{
switch ( vr_1 )
{
case vl_3 :
case vl_4 :
case vl_5 :
case vl_2 :
case vl_6 :
return true ;
default:
return false ;
}
}
static bool
fn_3 ( int vr_1 , char const * vr_2 )
{
return ( vl_7
&& ( fn_1 ( vr_1 )
|| ( fn_2 ( vr_1 )
&& fn_4 ( vl_8 , vr_2 ) ) ) ) ;
}
static bool
fn_5 ( char * vr_2 )
{
char * vr_3 ;
bool vr_4 = true ;
fn_6 ( vr_2 ) ;
while ( 1 )
{
vr_3 = strrchr ( vr_2 , '/' ) ;
if ( vr_3 == NULL )
break;
while ( vr_3 > vr_2 && * vr_3 == '/' )
-- vr_3 ;
vr_3 [ 1 ] = 0 ;
if ( vl_9 )
fn_7 ( stdout , _ ( lr_1 ) , fn_8 ( vr_2 ) ) ;
vr_4 = ( fn_9 ( vr_2 ) == 0 ) ;
if ( ! vr_4 )
{
if ( fn_3 ( vl_10 , vr_2 ) )
{
vr_4 = true ;
}
else
{
error ( 0 , vl_10 , _ ( lr_2 ) ,
fn_8 ( vr_2 ) ) ;
}
break;
}
}
return vr_4 ;
}
void
fn_10 ( int vr_5 )
{
if ( vr_5 != vl_11 ) MST[@!ABS$@$]MSP[]
fn_11 () ;
else
{
printf ( _ ( lr_3 ) , vl_12 ) ;
fputs ( _ ( lr_4 ) , stdout ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
fputs ( vl_13 , stdout ) ;
fputs ( vl_14 , stdout ) ;
fn_12 () ;
}
exit ( vr_5 ) ;
}
int
main ( int vr_6 , char * * vr_7 )
{
bool vr_4 = true ;
int vr_8 ;
fn_13 ( & vr_6 , & vr_7 ) ;
fn_14 ( vr_7 [ 0 ] ) ;
setlocale ( vl_15 , lr_6 ) ;
fn_15 ( vl_16 , vl_17 ) ;
fn_16 ( vl_16 ) ;
atexit ( vl_18 ) ;
vl_19 = false ;
while ( ( vr_8 = fn_17 ( vr_6 , vr_7 , lr_7 , vl_20 , NULL ) ) != - 1 )
{
switch ( vr_8 )
{
case 'p' :
vl_19 = true ;
break;
case vl_21 :
vl_7 = true ;
break;
case 'v' :
vl_9 = true ;
break;
vl_22 ;
fn_18 ( vl_23 , vl_24 ) ;
default:
fn_10 ( vl_25 ) ;
}
}
if ( vl_26 == vr_6 )
{
error ( 0 , 0 , _ ( lr_8 ) ) ;
fn_10 ( vl_25 ) ;
}
for (; vl_26 < vr_6 ; ++ vl_26 )
{
char * vr_2 = vr_7 [ vl_26 ] ;
if ( vl_9 )
fn_7 ( stdout , _ ( lr_1 ) , fn_8 ( vr_2 ) ) ;
if ( fn_9 ( vr_2 ) != 0 )
{
if ( fn_3 ( vl_10 , vr_2 ) )
continue;
error ( 0 , vl_10 , _ ( lr_9 ) , fn_8 ( vr_2 ) ) ;
vr_4 = false ;
}
else if ( vl_19 )
{
vr_4 &= fn_5 ( vr_2 ) ;
}
}
exit ( vr_4 ? vl_11 : vl_25 ) ;
}
