public static void main ( final String [] args ) throws Exception
{
tp_1 vr_1 = null ;
if( args . length < 1 )
{
System . vr_2 . println ( lr_1 ) ;
System . exit ( 1 ) ; MST[rv.CRCR5Mutator]MSP[]
}
final String vr_3 = args [ 0 ] ;
int vr_4 ;
if ( args . length > 1 )
{
vr_4 = Integer . vr_5 ( args [ 1 ] ) ;
}
else
{
vr_4 = 23 ;
}
try
{
vr_1 = new tp_1 ( lr_2 , true ) ;
}
catch ( final IOException vr_6 )
{
System . vr_2 . println (
lr_3
+ vr_6 . vr_7 () ) ;
}
vl_1 = new fn_1 () ;
final tp_2 vr_8 = new tp_2 ( lr_4 , false , false , true , false ) ;
final tp_3 vr_9 = new tp_3 ( true , false , true , false ) ;
final tp_4 vr_10 = new tp_4 ( true , true , true , true ) ;
try
{
vl_1 . vr_11 ( vr_8 ) ;
vl_1 . vr_11 ( vr_9 ) ;
vl_1 . vr_11 ( vr_10 ) ;
}
catch ( final tp_5 vr_6 )
{
System . vr_2 . println ( lr_5 + vr_6 . vr_7 () ) ;
}
while ( true )
{
boolean vr_12 = false ;
try
{
vl_1 . vr_13 ( vr_3 , vr_4 ) ;
final tp_6 vr_14 = new tp_6 ( new fn_2 () ) ;
vl_1 . vr_15 ( new fn_2 () ) ;
System . out . println ( lr_6 ) ;
System . out . println ( lr_7 ) ;
System . out . println ( lr_8 ) ;
System . out . println ( lr_9 ) ;
System . out . println ( lr_10 ) ;
System . out . println ( lr_11 ) ;
System . out . println ( lr_12 ) ;
System . out . println ( lr_13 ) ;
vr_14 . vr_16 () ;
final tp_7 vr_17 = vl_1 . vr_18 () ;
final byte [] vr_19 = new byte [ 1024 ] ;
int vr_20 = 0 ;
do
{
try
{
vr_20 = System . vr_21 . vr_22 ( vr_19 ) ;
if( vr_20 > 0 )
{
final String line = new String ( vr_19 , 0 , vr_20 ) ;
if( line . vr_23 ( lr_14 ) )
{
try
{
System . out . println ( lr_15 ) ;
System . out . println ( lr_16 + vl_1 . vr_24 ( 5000 ) ) ;
}
catch ( final IOException vr_6 )
{
System . vr_2 . println ( lr_17 + vr_6 . vr_7 () ) ;
}
}
else if( line . vr_23 ( lr_18 ) )
{
System . out . println ( lr_19 ) ;
for( int vr_25 = 0 ; vr_25 < 25 ; vr_25 ++ ) {
System . out . println ( lr_20 + vr_25 + lr_21 + vl_1 . vr_26 ( vr_25 ) +
lr_22 + vr_25 + lr_21 + vl_1 . vr_27 ( vr_25 ) ) ;
}
}
else if( line . vr_23 ( lr_23 ) )
{
final tp_8 vr_28 = new tp_8 ( new String ( vr_19 ) ) ;
try
{
vr_28 . vr_29 () ;
final int vr_30 = Integer . vr_5 ( vr_28 . vr_29 () ) ;
final boolean vr_31 = Boolean . vr_32 ( vr_28 . vr_29 () ) ;
final boolean vr_33 = Boolean . vr_32 ( vr_28 . vr_29 () ) ;
final boolean vr_34 = Boolean . vr_32 ( vr_28 . vr_29 () ) ;
final boolean vr_35 = Boolean . vr_32 ( vr_28 . vr_29 () ) ;
final tp_9 vr_36 = new tp_9 ( vr_30 , vr_31 , vr_33 ,
vr_34 , vr_35 ) ;
vl_1 . vr_11 ( vr_36 ) ;
}
catch ( final Exception vr_6 )
{
if( vr_6 instanceof tp_5 )
{
System . vr_2 . println ( lr_24 + vr_6 . vr_7 () ) ;
}
else
{
System . vr_2 . println ( lr_25 ) ;
System . vr_2 . println ( lr_26 ) ;
System . vr_2 . println ( lr_27 ) ;
System . vr_2 . println ( lr_28 ) ;
}
}
}
else if( line . vr_23 ( lr_29 ) )
{
final tp_8 vr_28 = new tp_8 ( new String ( vr_19 ) ) ;
try
{
vr_28 . vr_29 () ;
final int vr_30 = new Integer ( vr_28 . vr_29 () ) . fn_3 () ;
vl_1 . vr_37 ( vr_30 ) ;
}
catch ( final Exception vr_6 )
{
if( vr_6 instanceof tp_5 )
{
System . vr_2 . println ( lr_30 + vr_6 . vr_7 () ) ;
}
else
{
System . vr_2 . println ( lr_31 ) ;
System . vr_2 . println ( lr_32 ) ;
System . vr_2 . println ( lr_33 ) ;
}
}
}
else if( line . vr_23 ( lr_34 ) )
{
vl_1 . vr_38 ( vr_1 ) ;
}
else if( line . vr_23 ( lr_35 ) )
{
vl_1 . vr_39 () ;
}
else if( line . vr_40 ( lr_36 ) )
{
final byte vr_41 = vr_19 [ 1 ] ;
if ( vr_41 == '^' ) {
vr_17 . vr_42 ( vr_41 ) ;
} else {
vr_17 . vr_42 ( vr_41 - 'A' + 1 ) ;
}
vr_17 . vr_43 () ;
}
else
{
try
{
vr_17 . vr_42 ( vr_19 , 0 , vr_20 ) ;
vr_17 . vr_43 () ;
}
catch ( final IOException vr_6 )
{
vr_12 = true ;
}
}
}
}
catch ( final IOException vr_6 )
{
System . vr_2 . println ( lr_37 + vr_6 . vr_7 () ) ;
vr_12 = true ;
}
}
while( vr_20 > 0 && vr_12 == false );
try
{
vl_1 . vr_44 () ;
}
catch ( final IOException vr_6 )
{
System . vr_2 . println ( lr_38 + vr_6 . vr_7 () ) ;
}
}
catch ( final IOException vr_6 )
{
System . vr_2 . println ( lr_38 + vr_6 . vr_7 () ) ;
System . exit ( 1 ) ;
}
}
}
@Override
public void fn_4 ( final int vr_45 , final int vr_46 )
{
String vr_47 = null ;
switch ( vr_45 ) {
case vr_48 . vr_49 :
vr_47 = lr_39 ;
break;
case vr_48 . vr_50 :
vr_47 = lr_40 ;
break;
case vr_48 . vr_51 :
vr_47 = lr_41 ;
break;
case vr_48 . vr_52 :
vr_47 = lr_42 ;
break;
case vr_48 . vr_53 :
vr_47 = lr_43 ;
break;
default:
vr_47 = Integer . toString ( vr_45 ) ;
break;
}
System . out . println ( lr_44 + vr_47 + lr_45 + vr_46 ) ;
}
@Override
public void fn_5 ()
{
final tp_10 vr_54 = vl_1 . vr_55 () ;
try
{
final byte [] vr_19 = new byte [ 1024 ] ;
int vr_20 = 0 ;
do
{
vr_20 = vr_54 . vr_22 ( vr_19 ) ;
if( vr_20 > 0 )
{
System . out . vr_56 ( new String ( vr_19 , 0 , vr_20 ) ) ;
}
}
while ( vr_20 >= 0 );
}
catch ( final IOException vr_6 )
{
System . vr_2 . println ( lr_46 + vr_6 . vr_7 () ) ;
}
try
{
vl_1 . vr_44 () ;
}
catch ( final IOException vr_6 )
{
System . vr_2 . println ( lr_47 + vr_6 . vr_7 () ) ;
}
}
