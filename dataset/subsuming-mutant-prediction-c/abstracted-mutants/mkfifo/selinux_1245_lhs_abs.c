static tp_1
fn_1 ( tp_2 vr_1 )
{
if ( fn_2 ( vr_1 ) )
return fn_3 ( lr_1 ) ;
if ( fn_4 ( vr_1 ) )
return fn_3 ( lr_2 ) ;
if ( fn_5 ( vr_1 ) )
return fn_3 ( lr_3 ) ;
if ( fn_6 ( vr_1 ) )
return fn_3 ( lr_4 ) ;
if ( fn_7 ( vr_1 ) )
return fn_3 ( lr_5 ) ;
if ( fn_8 ( vr_1 ) )
return fn_3 ( lr_6 ) ;
if ( fn_9 ( vr_1 ) )
return fn_3 ( lr_7 ) ;
vl_1 = vl_2 ;
return 0 ;
}
static int
fn_10 ( char const * vr_2 , tp_2 vr_3 , tp_3 * vr_4 )
{
tp_3 vr_5 = NULL ;
tp_3 vr_6 = NULL ;
tp_1 vr_7 ;
int vr_8 = - 1 ;
char * vr_9 = fn_11 ( vr_2 ) ;
if ( ! vr_9 )
goto lb_1;
if ( fn_12 ( & vr_5 ) < 0 )
goto lb_1;
if ( fn_13 ( vr_9 , & vr_6 ) < 0 )
goto lb_1;
vr_7 = fn_1 ( vr_3 ) ;
if ( ! vr_7 )
goto lb_1;
vr_8 = fn_14 ( vr_5 , vr_6 , vr_7 , vr_4 ) ;
lb_1:
free ( vr_9 ) ;
fn_15 ( vr_5 ) ;
fn_15 ( vr_6 ) ;
return vr_8 ;
}
int
fn_16 ( char const * vr_2 , tp_2 vr_3 )
{
int vr_8 = - 1 ;
tp_3 vr_5 = NULL , vr_6 = NULL ;
tp_4 vr_10 = 0 , vr_11 = 0 ;
const char * vr_12 ;
char * vr_13 ;
char * vr_14 = NULL ;
if ( ! fn_17 ( vr_2 ) )
{
vr_14 = fn_18 ( vr_2 , vl_3 ) ;
if ( ! vr_14 )
error ( vl_4 , vl_1 , _ ( lr_8 ) ,
fn_19 ( vr_2 ) ) ;
vr_2 = vr_14 ;
}
if ( fn_20 ( vr_2 , vr_3 , & vr_5 ) < 0 )
{
if ( vl_1 == vl_5 )
vl_1 = vl_6 ;
goto lb_1;
}
if ( fn_10 ( vr_2 , vr_3 , & vr_6 ) < 0 )
goto lb_1;
if ( ! ( vr_10 = fn_21 ( vr_5 ) ) )
goto lb_1;
if ( ! ( vr_11 = fn_21 ( vr_6 ) ) )
goto lb_1;
if ( ! ( vr_12 = fn_22 ( vr_10 ) ) )
goto lb_1;
if ( fn_23 ( vr_11 , vr_12 ) )
goto lb_1;
if ( ! ( vr_13 = fn_24 ( vr_11 ) ) )
goto lb_1;
vr_8 = fn_25 ( vr_13 ) ;
lb_1:
fn_26 ( vr_10 ) ;
fn_26 ( vr_11 ) ;
fn_15 ( vr_5 ) ;
fn_15 ( vr_6 ) ;
free ( vr_14 ) ;
return vr_8 ;
}
static int
fn_27 ( char const * vr_2 , bool vr_15 )
{
int vr_8 = - 1 ;
struct vr_16 vr_17 ;
tp_3 vr_5 = NULL , vr_6 = NULL ;
tp_4 vr_10 = 0 , vr_11 = 0 ;
const char * vr_12 ;
char * vr_13 ;
int vr_18 ;
if ( vr_15 )
{
if ( fn_28 ( & vr_6 ) < 0 )
return vr_8 ;
vr_8 = fn_29 ( vr_2 , vr_6 ) ;
fn_15 ( vr_6 ) ;
return vr_8 ;
}
vr_18 = fn_30 ( vr_2 , vl_7 | vl_8 ) ;
if ( vr_18 == - 1 && ( vl_1 != vl_9 ) )
goto lb_1;
if ( vr_18 != - 1 )
{
if ( fn_31 ( vr_18 , & vr_17 ) < 0 )
goto lb_1;
}
else
{
if ( fn_32 ( vr_2 , & vr_17 ) < 0 )
goto lb_1;
}
if ( fn_20 ( vr_2 , vr_17 . vr_19 , & vr_5 ) < 0 )
{
if ( vl_1 == vl_5 )
vl_1 = vl_6 ;
goto lb_1;
}
if ( ! ( vr_10 = fn_21 ( vr_5 ) ) )
goto lb_1;
if ( vr_18 != - 1 )
{
if ( fn_33 ( vr_18 , & vr_6 ) < 0 )
goto lb_1;
}
else
{
if ( fn_34 ( vr_2 , & vr_6 ) < 0 )
goto lb_1;
}
if ( ! ( vr_11 = fn_21 ( vr_6 ) ) )
goto lb_1;
if ( ! ( vr_12 = fn_22 ( vr_10 ) ) )
goto lb_1;
if ( fn_23 ( vr_11 , vr_12 ) )
goto lb_1;
if ( ! ( vr_13 = fn_24 ( vr_11 ) ) )
goto lb_1;
if ( vr_18 != - 1 )
vr_8 = fn_35 ( vr_18 , vr_13 ) ;
else
vr_8 = fn_29 ( vr_2 , vr_13 ) ;
lb_1:
if ( vr_18 != - 1 )
fn_36 ( vr_18 ) ;
fn_26 ( vr_10 ) ;
fn_26 ( vr_11 ) ;
fn_15 ( vr_5 ) ;
fn_15 ( vr_6 ) ;
return vr_8 ;
}
bool
fn_37 ( char const * vr_2 , bool vr_20 , bool vr_15 )
{
char * vr_14 = NULL ;
tp_5 * vr_21 ;
bool vr_22 = true ;
if ( ! fn_17 ( vr_2 ) && ! vr_15 )
{
vr_14 = fn_18 ( vr_2 , vl_3 ) ;
if ( ! vr_14 )
error ( vl_4 , vl_1 , _ ( lr_8 ) ,
fn_19 ( vr_2 ) ) ;
}
const char * vr_23 [ 2 ] = { vr_14 ? vr_14 : vr_2 , NULL } ;
if ( ! vr_20 )
{
vr_22 = fn_27 ( * vr_23 , vr_15 ) != - 1 ; MST[NEQ$@1$@2$!LE$@1$@2$]MSP[]
free ( vr_14 ) ;
return vr_22 ;
}
vr_21 = fn_38 ( ( char * const * ) vr_23 , vl_10 , NULL ) ;
while ( 1 )
{
tp_6 * vr_24 ;
vr_24 = fn_39 ( vr_21 ) ;
if ( vr_24 == NULL )
{
if ( vl_1 != 0 )
{
error ( 0 , vl_1 , _ ( lr_9 ) ) ;
vr_22 = false ;
}
break;
}
vr_22 &= fn_27 ( vr_21 -> vr_25 , vr_15 ) != - 1 ;
}
if ( fn_40 ( vr_21 ) != 0 )
{
error ( 0 , vl_1 , _ ( lr_10 ) ) ;
vr_22 = false ;
}
free ( vr_14 ) ;
return vr_22 ;
}
