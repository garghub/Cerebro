void
fn_1 ( int vr_1 )
{
if ( vr_1 != vl_1 )
fn_2 () ;
else
{
printf ( _ ( lr_1 ) ,
vl_2 ,
vl_3 ,
vl_4 ) ;
if ( vl_5 )
fputs ( _ ( lr_2 ) , stdout ) ;
else
fputs ( _ ( lr_3 ) , stdout ) ;
printf ( _ ( lr_4 ) ,
vl_3 ) ;
fputs ( _ ( lr_5 ) , stdout ) ;
if ( vl_5 )
fputs ( _ ( lr_6 ) , stdout ) ;
else
fputs ( _ ( lr_7 ) , stdout ) ;
fputs ( _ ( lr_8 ) , stdout ) ;
fputs ( vl_6 , stdout ) ;
fputs ( vl_7 , stdout ) ;
printf ( _ ( lr_9 ) ,
vl_8 ) ;
fn_3 () ;
}
exit ( vr_1 ) ;
}
static char *
fn_4 ( char * vr_2 , tp_1 vr_3 )
{
char * vr_4 = vr_2 ;
tp_1 vr_5 ;
for ( vr_5 = 0 ; vr_5 < vr_3 ; vr_5 ++ )
{
switch ( vr_2 [ vr_5 ] )
{
case '\\' :
if ( vr_5 == vr_3 - 1 )
{
return NULL ;
}
++ vr_5 ;
switch ( vr_2 [ vr_5 ] )
{
case 'n' :
* vr_4 ++ = '\n' ;
break;
case '\\' :
* vr_4 ++ = '\\' ;
break;
default:
return NULL ;
}
break;
case '\0' :
return NULL ;
default:
* vr_4 ++ = vr_2 [ vr_5 ] ;
break;
}
}
if ( vr_4 < vr_2 + vr_3 )
* vr_4 = '\0' ;
return vr_2 ;
}
static bool
fn_5 ( char * vr_2 , tp_1 vr_3 , unsigned char * * vr_6 ,
char * * vr_7 , bool vr_8 )
{
tp_1 vr_5 ;
if ( vr_3 == 0 )
return false ;
vr_5 = vr_3 - 1 ;
while ( vr_5 && vr_2 [ vr_5 ] != ')' )
vr_5 -- ;
if ( vr_2 [ vr_5 ] != ')' )
return false ;
* vr_7 = vr_2 ;
if ( vr_8 && fn_4 ( vr_2 , vr_5 ) == NULL )
return false ;
vr_2 [ vr_5 ++ ] = '\0' ;
while ( fn_6 ( vr_2 [ vr_5 ] ) )
vr_5 ++ ;
if ( vr_2 [ vr_5 ] != '=' )
return false ;
vr_5 ++ ;
while ( fn_6 ( vr_2 [ vr_5 ] ) )
vr_5 ++ ;
* vr_6 = ( unsigned char * ) & vr_2 [ vr_5 ] ;
return true ;
}
static bool
fn_7 ( char * vr_2 , tp_1 vr_3 ,
unsigned char * * vr_6 , int * vr_9 , char * * vr_7 )
{
bool vr_8 = false ;
tp_1 vr_10 ;
tp_1 vr_5 = 0 ;
while ( fn_6 ( vr_2 [ vr_5 ] ) )
++ vr_5 ;
if ( vr_2 [ vr_5 ] == '\\' )
{
++ vr_5 ;
vr_8 = true ;
}
vr_10 = strlen ( vl_3 ) ;
if ( fn_8 ( vr_2 + vr_5 , vl_3 , vr_10 ) )
{
if ( vr_2 [ vr_5 + vr_10 ] == ' ' )
++ vr_5 ;
if ( vr_2 [ vr_5 + vr_10 ] == '(' )
{
* vr_9 = 0 ;
return fn_5 ( vr_2 + vr_5 + vr_10 + 1 ,
vr_3 - ( vr_5 + vr_10 + 1 ) ,
vr_6 , vr_7 , vr_8 ) ;
}
}
if ( vr_3 - vr_5 < vl_9 + ( vr_2 [ vr_5 ] == '\\' ) )
return false ;
* vr_6 = ( unsigned char * ) & vr_2 [ vr_5 ] ;
vr_5 += vl_10 ;
if ( ! fn_6 ( vr_2 [ vr_5 ] ) )
return false ;
vr_2 [ vr_5 ++ ] = '\0' ;
if ( ( vr_3 - vr_5 == 1 ) || ( vr_2 [ vr_5 ] != ' ' && vr_2 [ vr_5 ] != '*' ) )
{
if ( vl_11 == 0 )
return false ;
vl_11 = 1 ;
}
else if ( vl_11 != 1 )
{
vl_11 = 0 ;
* vr_9 = ( vr_2 [ vr_5 ++ ] == '*' ) ;
}
* vr_7 = & vr_2 [ vr_5 ] ;
if ( vr_8 )
return fn_4 ( & vr_2 [ vr_5 ] , vr_3 - vr_5 ) != NULL ;
return true ;
}
static bool tp_2
fn_9 ( unsigned char const * vr_2 )
{
unsigned int vr_5 ;
for ( vr_5 = 0 ; vr_5 < vl_10 ; vr_5 ++ )
{
if ( ! isxdigit ( * vr_2 ) )
return false ;
++ vr_2 ;
}
return * vr_2 == '\0' ;
}
static bool
fn_10 ( const char * vr_11 , int * vr_9 , unsigned char * vr_12 )
{
tp_3 * vr_13 ;
int vr_14 ;
bool vr_15 = fn_11 ( vr_11 , lr_10 ) ;
if ( vr_15 )
{
vl_12 = true ;
vr_13 = vl_13 ;
if ( vl_5 && * vr_9 )
{
if ( * vr_9 < 0 )
* vr_9 = ! fn_12 ( vl_14 ) ;
if ( * vr_9 )
fn_13 ( NULL , lr_11 , vl_13 ) ;
}
}
else
{
vr_13 = fopen ( vr_11 , ( vl_5 && * vr_9 ? lr_11 : lr_12 ) ) ;
if ( vr_13 == NULL )
{
error ( 0 , vl_15 , lr_13 , vr_11 ) ;
return false ;
}
}
fn_14 ( vr_13 , vl_16 ) ;
vr_14 = fn_15 ( vr_13 , vr_12 ) ;
if ( vr_14 )
{
error ( 0 , vl_15 , lr_13 , vr_11 ) ;
if ( vr_13 != vl_13 )
fclose ( vr_13 ) ;
return false ;
}
if ( ! vr_15 && fclose ( vr_13 ) != 0 )
{
error ( 0 , vl_15 , lr_13 , vr_11 ) ;
return false ;
}
return true ;
}
static bool
fn_16 ( const char * vr_16 )
{
tp_3 * vr_17 ;
tp_4 vr_18 = 0 ;
tp_4 vr_19 = 0 ;
tp_4 vr_20 = 0 ;
tp_4 vr_21 = 0 ;
tp_4 vr_22 = 0 ;
unsigned char vr_23 [ vl_17 + vl_18 ] ;
unsigned char * vr_24 = fn_17 ( vr_23 , vl_18 ) ;
tp_4 vr_25 ;
char * line ;
tp_1 vr_26 ;
bool vr_15 = fn_11 ( vr_16 , lr_10 ) ;
if ( vr_15 )
{
vl_12 = true ;
vr_16 = _ ( lr_14 ) ;
vr_17 = vl_13 ;
}
else
{
vr_17 = fopen ( vr_16 , lr_12 ) ;
if ( vr_17 == NULL )
{
error ( 0 , vl_15 , lr_13 , vr_16 ) ;
return false ;
}
}
vr_25 = 0 ;
line = NULL ;
vr_26 = 0 ;
do
{
char * vr_11 vr_27 ( = NULL ) ;
int vr_9 ;
unsigned char * vr_6 vr_27 ( = NULL ) ;
tp_5 vr_28 ;
++ vr_25 ;
if ( vr_25 == 0 )
error ( vl_19 , 0 , _ ( lr_15 ) ,
vr_16 ) ;
vr_28 = fn_18 ( & line , & vr_26 , vr_17 ) ;
if ( vr_28 <= 0 )
break;
if ( line [ 0 ] == '#' )
continue;
if ( line [ vr_28 - 1 ] == '\n' )
line [ -- vr_28 ] = '\0' ;
if ( ! ( fn_7 ( line , vr_28 , & vr_6 , & vr_9 , & vr_11 )
&& ! ( vr_15 && fn_11 ( vr_11 , lr_10 ) )
&& fn_9 ( vr_6 ) ) )
{
++ vr_18 ;
if ( vl_20 )
{
error ( 0 , 0 ,
_ ( lr_16 vl_21
lr_17 ) ,
vr_16 , vr_25 ,
vl_3 ) ;
}
++ vr_20 ;
}
else
{
static const char vr_29 [] = { '0' , '1' , '2' , '3' ,
'4' , '5' , '6' , '7' ,
'8' , '9' , 'a' , 'b' ,
'c' , 'd' , 'e' , 'f' } ;
bool vr_30 ;
++ vr_19 ;
vr_30 = fn_10 ( vr_11 , & vr_9 , vr_24 ) ;
if ( ! vr_30 )
{
++ vr_22 ;
if ( ! vl_22 )
{
printf ( _ ( lr_18 ) , vr_11 ) ;
}
}
else
{
tp_1 vr_31 = vl_10 / 2 ;
tp_1 vr_32 ;
for ( vr_32 = 0 ; vr_32 < vr_31 ; ++ vr_32 )
{
if ( tolower ( vr_6 [ 2 * vr_32 ] )
!= vr_29 [ vr_24 [ vr_32 ] >> 4 ]
|| ( tolower ( vr_6 [ 2 * vr_32 + 1 ] )
!= ( vr_29 [ vr_24 [ vr_32 ] & 0xf ] ) ) )
break;
}
if ( vr_32 != vr_31 )
++ vr_21 ;
if ( ! vl_22 )
{
if ( vr_32 != vr_31 )
printf ( lr_19 , vr_11 , _ ( lr_20 ) ) ;
else if ( ! vl_23 )
printf ( lr_19 , vr_11 , _ ( lr_21 ) ) ;
}
}
}
}
while ( ! feof ( vr_17 ) && ! ferror ( vr_17 ) );
free ( line ) ;
if ( ferror ( vr_17 ) )
{
error ( 0 , 0 , _ ( lr_22 ) , vr_16 ) ;
return false ;
}
if ( ! vr_15 && fclose ( vr_17 ) != 0 )
{
error ( 0 , vl_15 , lr_13 , vr_16 ) ;
return false ;
}
if ( vr_19 == 0 )
{
error ( 0 , 0 , _ ( lr_23 ) ,
vr_16 , vl_3 ) ;
}
else
{
if ( ! vl_22 )
{
if ( vr_18 != 0 )
error ( 0 , 0 , MST[EQ$@1$@2$!BITSHL$@1$@2$]MSP[]
( fn_19
( lr_24 vl_21 lr_25 ,
lr_24 vl_21 lr_26 ,
fn_20 ( vr_18 ) ) ) ,
vr_18 ) ;
if ( vr_22 != 0 )
error ( 0 , 0 ,
( fn_19
( lr_24 vl_21 lr_27 ,
lr_24 vl_21 lr_28 ,
fn_20 ( vr_22 ) ) ) ,
vr_22 ) ;
if ( vr_21 != 0 )
error ( 0 , 0 ,
( fn_19
( lr_24 vl_21 lr_29 ,
lr_24 vl_21 lr_30 ,
fn_20 ( vr_21 ) ) ) ,
vr_21 ) ;
}
}
return ( vr_19 != 0
&& vr_21 == 0
&& vr_22 == 0
&& ( ! vl_24 || vr_20 == 0 ) ) ;
}
static void
fn_21 ( char const * vr_33 , bool vr_34 )
{
if ( ! vr_34 )
{
fputs ( vr_33 , stdout ) ;
return;
}
while ( * vr_33 )
{
switch ( * vr_33 )
{
case '\n' :
fputs ( lr_31 , stdout ) ;
break;
case '\\' :
fputs ( lr_32 , stdout ) ;
break;
default:
putchar ( * vr_33 ) ;
break;
}
vr_33 ++ ;
}
}
int
main ( int vr_35 , char * * vr_36 )
{
unsigned char vr_23 [ vl_17 + vl_18 ] ;
unsigned char * vr_24 = fn_17 ( vr_23 , vl_18 ) ;
bool vr_37 = false ;
int vr_38 ;
bool vr_30 = true ;
int vr_9 = - 1 ;
bool vr_39 = false ;
fn_22 ( & vr_35 , & vr_36 ) ;
fn_23 ( vr_36 [ 0 ] ) ;
setlocale ( vl_25 , lr_33 ) ;
fn_24 ( vl_26 , vl_27 ) ;
fn_25 ( vl_26 ) ;
atexit ( vl_28 ) ;
setvbuf ( stdout , NULL , vl_29 , 0 ) ;
while ( ( vr_38 = fn_26 ( vr_35 , vr_36 , lr_34 , vl_30 , NULL ) ) != - 1 )
switch ( vr_38 )
{
case 'b' :
vr_9 = 1 ;
break;
case 'c' :
vr_37 = true ;
break;
case vl_31 :
vl_22 = true ;
vl_20 = false ;
vl_23 = false ;
break;
case 't' :
vr_9 = 0 ;
break;
case 'w' :
vl_22 = false ;
vl_20 = true ;
vl_23 = false ;
break;
case vl_32 :
vl_22 = false ;
vl_20 = false ;
vl_23 = true ;
break;
case vl_33 :
vl_24 = true ;
break;
case vl_34 :
vr_39 = true ;
vr_9 = 1 ;
break;
vl_35 ;
fn_27 ( vl_36 , vl_37 ) ;
default:
fn_1 ( vl_19 ) ;
}
vl_9 = vl_38 ;
vl_10 = vl_39 ;
if ( vr_39 && ! vr_9 )
{
error ( 0 , 0 , _ ( lr_35 ) ) ;
fn_1 ( vl_19 ) ;
}
if ( vr_39 && vr_37 )
{
error ( 0 , 0 , _ ( lr_36
lr_37 ) ) ;
fn_1 ( vl_19 ) ;
}
if ( 0 <= vr_9 && vr_37 )
{
error ( 0 , 0 , _ ( lr_38
lr_37 ) ) ;
fn_1 ( vl_19 ) ;
}
if ( vl_22 && ! vr_37 )
{
error ( 0 , 0 ,
_ ( lr_39 ) ) ;
fn_1 ( vl_19 ) ;
}
if ( vl_20 && ! vr_37 )
{
error ( 0 , 0 ,
_ ( lr_40 ) ) ;
fn_1 ( vl_19 ) ;
}
if ( vl_23 && ! vr_37 )
{
error ( 0 , 0 ,
_ ( lr_41 ) ) ;
fn_1 ( vl_19 ) ;
}
if ( vl_24 & ! vr_37 )
{
error ( 0 , 0 ,
_ ( lr_42 ) ) ;
fn_1 ( vl_19 ) ;
}
if ( ! vl_5 && vr_9 < 0 )
vr_9 = 0 ;
if ( vl_40 == vr_35 )
vr_36 [ vr_35 ++ ] = fn_28 ( lr_10 ) ;
for (; vl_40 < vr_35 ; ++ vl_40 )
{
char * vr_33 = vr_36 [ vl_40 ] ;
if ( vr_37 )
vr_30 &= fn_16 ( vr_33 ) ;
else
{
int vr_40 = vr_9 ;
if ( ! fn_10 ( vr_33 , & vr_40 , vr_24 ) )
vr_30 = false ;
else
{
bool vr_41 = strchr ( vr_33 , '\\' ) || strchr ( vr_33 , '\n' ) ;
if ( vr_39 )
{
if ( vr_41 )
putchar ( '\\' ) ;
fputs ( vl_3 , stdout ) ;
fputs ( lr_43 , stdout ) ;
fn_21 ( vr_33 , vr_41 ) ;
fputs ( lr_44 , stdout ) ;
}
tp_1 vr_5 ;
if ( ! vr_39 && vr_41 )
putchar ( '\\' ) ;
for ( vr_5 = 0 ; vr_5 < ( vl_10 / 2 ) ; ++ vr_5 )
printf ( lr_45 , vr_24 [ vr_5 ] ) ;
if ( ! vr_39 )
{
putchar ( ' ' ) ;
putchar ( vr_40 ? '*' : ' ' ) ;
fn_21 ( vr_33 , vr_41 ) ;
}
putchar ( '\n' ) ;
}
}
}
if ( vl_12 && fclose ( vl_13 ) == vl_41 )
error ( vl_19 , vl_15 , _ ( lr_14 ) ) ;
exit ( vr_30 ? vl_1 : vl_19 ) ;
}
