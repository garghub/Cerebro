void fn_1 ()
{
if( vl_1 == null ) {
return;
}
int vr_1 ;
vl_2 = false ;
vr_1 = vr_2 . vr_3 () . fn_2 () + 1 ;
if ( vr_1 > vr_2 . vr_4 ) {
vr_1 = vr_2 . vr_4 ;
}
vl_1 . vr_5 ( vr_1 ) ;
vl_1 . vr_6 ( true ) ;
vl_1 . vr_7 () ;
vl_3 = true ;
}
private int fn_3 ( final boolean vr_8 ) throws IOException
{
int vr_9 ;
while ( true )
{
if( ! vr_8 && super . vr_10 () == 0 ) {
return vl_4 ;
}
if ( ( vr_9 = super . vr_11 () ) < 0 ) {
return vl_5 ;
}
vr_9 = vr_9 & 0xff ;
synchronized ( vl_6 )
{
vl_6 . vr_12 () ;
}
vl_6 . vr_13 ( vr_9 ) ;
switch ( vl_7 )
{
case vl_8 :
if ( vr_9 == '\0' )
{
continue;
}
case vl_9 :
if ( vr_9 == vr_14 . vr_15 )
{
vl_7 = vl_10 ;
continue;
}
if ( vr_9 == '\r' )
{
synchronized ( vl_6 )
{
if ( vl_6 . vr_16 ( vr_17 . vr_18 ) ) {
vl_7 = vl_8 ;
} else {
vl_7 = vl_9 ;
}
}
} else {
vl_7 = vl_9 ;
}
break;
case vl_10 :
switch ( vr_9 )
{
case vr_14 . vr_19 :
vl_7 = vl_11 ;
continue;
case vr_14 . vr_20 :
vl_7 = vl_12 ;
continue;
case vr_14 . DO :
vl_7 = vl_13 ;
continue;
case vr_14 . vr_21 :
vl_7 = vl_14 ;
continue;
case vr_14 . vr_22 :
vl_15 = 0 ;
vl_7 = vl_16 ;
continue;
case vr_14 . vr_15 :
vl_7 = vl_9 ;
break;
case vr_14 . vr_23 :
vl_7 = vl_9 ;
continue;
default:
vl_7 = vl_9 ;
vl_6 . vr_24 ( vr_9 ) ;
continue;
}
break;
case vl_11 :
synchronized ( vl_6 )
{
vl_6 . vr_25 ( vr_9 ) ;
vl_6 . vr_26 () ;
}
vl_7 = vl_9 ;
continue;
case vl_12 :
synchronized ( vl_6 )
{
vl_6 . vr_27 ( vr_9 ) ;
vl_6 . vr_26 () ;
}
vl_7 = vl_9 ;
continue;
case vl_13 :
synchronized ( vl_6 )
{
vl_6 . vr_28 ( vr_9 ) ;
vl_6 . vr_26 () ;
}
vl_7 = vl_9 ;
continue;
case vl_14 :
synchronized ( vl_6 )
{
vl_6 . vr_29 ( vr_9 ) ;
vl_6 . vr_26 () ;
}
vl_7 = vl_9 ;
continue;
case vl_16 :
switch ( vr_9 )
{
case vr_14 . vr_15 :
vl_7 = vl_17 ;
continue;
default:
if ( vl_15 < vr_30 . length ) {
vr_30 [ vl_15 ++ ] = vr_9 ;
}
break;
}
vl_7 = vl_16 ;
continue;
case vl_17 :
switch ( vr_9 )
{
case vr_14 . vr_23 :
synchronized ( vl_6 )
{
vl_6 . vr_31 ( vr_30 , vl_15 ) ;
vl_6 . vr_26 () ;
}
vl_7 = vl_9 ;
continue;
case vr_14 . vr_15 :
if ( vl_15 < vr_30 . length ) {
vr_30 [ vl_15 ++ ] = vr_9 ;
}
break;
default:
break;
}
vl_7 = vl_16 ;
continue;
}
break;
}
return vr_9 ;
}
private boolean fn_4 ( final int vr_9 ) throws vl_18
{
boolean vr_32 ;
synchronized ( vl_19 )
{
vr_32 = vl_20 == 0 ;
while ( vl_20 >= vl_19 . length - 1 )
{
if( vl_3 )
{
vl_19 . vr_33 () ;
try
{
vl_19 . vr_34 () ;
}
catch ( final vl_18 vr_35 )
{
throw vr_35 ;
}
}
else
{
throw new fn_5 ( lr_1 ) ;
}
}
if ( vl_21 && vl_3 )
{
vl_19 . vr_33 () ;
}
vl_19 [ vl_22 ] = vr_9 ;
++ vl_20 ;
if ( ++ vl_22 >= vl_19 . length ) {
vl_22 = 0 ;
}
}
return vr_32 ;
}
@Override
public int vr_11 () throws IOException
{
synchronized ( vl_19 )
{
while ( true )
{
if ( ioException != null )
{
IOException vr_35 ;
vr_35 = ioException ;
ioException = null ;
throw vr_35 ;
}
if ( vl_20 == 0 )
{
if ( vl_23 ) {
return vl_5 ;
}
if( vl_3 )
{
vl_19 . vr_33 () ;
try
{
vl_21 = true ;
vl_19 . vr_34 () ;
vl_21 = false ;
}
catch ( final vl_18 vr_35 )
{
throw new fn_6 ( lr_2 ) ;
}
}
else
{
vl_21 = true ;
int vr_9 ;
boolean vr_8 = true ;
do
{
try
{
if ( ( vr_9 = fn_3 ( vr_8 ) ) < 0 ) {
if( vr_9 != vl_4 ) {
return vr_9 ;
}
}
}
catch ( final fn_6 vr_35 )
{
synchronized ( vl_19 )
{
ioException = vr_35 ;
vl_19 . vr_36 () ;
try
{
vl_19 . vr_34 ( 100 ) ;
}
catch ( final vl_18 vr_37 )
{
}
}
return vl_5 ;
}
try
{
if( vr_9 != vl_4 )
{
fn_4 ( vr_9 ) ;
}
}
catch ( final vl_18 vr_35 )
{
if ( vl_2 ) {
return vl_5 ;
}
}
vr_8 = false ;
}
while ( super . vr_10 () > 0 && vl_20 < vl_19 . length - 1 );
vl_21 = false ;
}
continue;
}
int vr_9 ;
vr_9 = vl_19 [ vl_24 ] ;
if ( ++ vl_24 >= vl_19 . length ) {
vl_24 = 0 ;
}
-- vl_20 ;
if( vl_20 == 0 && vl_3 ) {
vl_19 . vr_33 () ;
}
return vr_9 ;
}
}
}
@Override
public int vr_11 ( final byte vr_38 [] ) throws IOException
{
return vr_11 ( vr_38 , 0 , vr_38 . length ) ;
}
@Override
public int vr_11 ( final byte vr_38 [] , int vr_39 , int length ) throws IOException
{
int vr_9 , vr_40 ;
if ( length < 1 ) {
return 0 ;
}
synchronized ( vl_19 )
{
if ( length > vl_20 ) {
length = vl_20 ;
}
}
if ( ( vr_9 = vr_11 () ) == vl_5 ) {
return vl_5 ;
}
vr_40 = vr_39 ;
do
{
vr_38 [ vr_39 ++ ] = ( byte ) vr_9 ;
}
while ( -- length > 0 && ( vr_9 = vr_11 () ) != vl_5 );
return vr_39 - vr_40 ;
}
@Override
public boolean fn_7 ()
{
return false ;
}
@Override
public int vr_10 () throws IOException
{
synchronized ( vl_19 )
{
if ( vl_3 ) {
return vl_20 ;
}
return vl_20 + super . vr_10 () ;
}
}
@Override
public void fn_8 () throws IOException
{
super . fn_8 () ;
synchronized ( vl_19 )
{
vl_23 = true ;
vl_2 = true ;
if ( vl_1 != null && vl_1 . vr_41 () )
{
vl_1 . vr_42 () ;
}
vl_19 . vr_36 () ;
}
}
@Override
public void fn_9 ()
{
int vr_9 ;
try
{
lb_1:
while ( ! vl_2 )
{
try
{
if ( ( vr_9 = fn_3 ( true ) ) < 0 ) {
break;
}
}
catch ( final fn_6 vr_35 )
{
synchronized ( vl_19 )
{
ioException = vr_35 ;
vl_19 . vr_36 () ;
try
{
vl_19 . vr_34 ( 100 ) ;
}
catch ( final vl_18 vr_37 )
{
if ( vl_2 ) {
break lb_1;
}
}
continue;
}
} catch( final tp_1 vr_43 ) {
super . fn_8 () ;
break lb_1;
}
boolean vr_33 = false ;
try
{
vr_33 = fn_4 ( vr_9 ) ;
}
catch ( final vl_18 vr_35 )
{
if ( vl_2 ) {
break lb_1;
}
}
if ( vr_33 ) {
vl_6 . vr_44 () ;
}
}
}
catch ( final IOException vr_45 )
{
synchronized ( vl_19 )
{
ioException = vr_45 ;
}
vl_6 . vr_44 () ;
}
synchronized ( vl_19 )
{
vl_2 = true ;
vl_23 = true ;
vl_19 . vr_33 () ;
}
vl_3 = false ;
}
