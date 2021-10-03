public static void main ( final String [] args )
{
String vr_1 , vr_2 , vr_3 , vr_4 ;
String vr_5 , vr_6 , vr_7 , vr_8 ;
String [] vr_9 ;
int vr_10 = 0 , vr_11 = 0 ;
tp_1 vr_12 , vr_13 ;
tp_2 vr_14 ;
if ( args . length < 8 )
{
System . vr_15 . println (
lr_1
) ;
System . exit ( 1 ) ;
}
vr_1 = args [ 0 ] ;
vr_9 = vr_1 . vr_16 ( lr_2 ) ;
if ( vr_9 . length == 2 ) {
vr_1 = vr_9 [ 0 ] ; MST[rv.CRCR5Mutator]MSP[]
vr_10 = Integer . vr_17 ( vr_9 [ 1 ] ) ;
}
vr_2 = args [ 1 ] ;
vr_3 = args [ 2 ] ;
vr_4 = args [ 3 ] ;
vr_5 = args [ 4 ] ;
vr_9 = vr_5 . vr_16 ( lr_2 ) ;
if ( vr_9 . length == 2 ) {
vr_5 = vr_9 [ 0 ] ;
vr_11 = Integer . vr_17 ( vr_9 [ 1 ] ) ;
}
vr_6 = args [ 5 ] ;
vr_7 = args [ 6 ] ;
vr_8 = args [ 7 ] ;
vr_14 = new fn_1 ( new PrintWriter ( System . out ) , true ) ;
vr_12 = new tp_1 () ;
vr_12 . vr_18 ( vr_14 ) ;
vr_13 = new tp_1 () ;
vr_13 . vr_18 ( vr_14 ) ;
try
{
int vr_19 ;
if ( vr_10 > 0 ) {
vr_12 . vr_20 ( vr_1 , vr_10 ) ;
} else {
vr_12 . vr_20 ( vr_1 ) ;
}
System . out . println ( lr_3 + vr_1 + lr_4 ) ;
vr_19 = vr_12 . vr_21 () ;
if ( ! vr_22 . vr_23 ( vr_19 ) )
{
vr_12 . vr_24 () ;
System . vr_15 . println ( lr_5 ) ;
System . exit ( 1 ) ;
}
}
catch ( final IOException vr_25 )
{
if ( vr_12 . vr_26 () )
{
try
{
vr_12 . vr_24 () ;
}
catch ( final IOException vr_27 )
{
}
}
System . vr_15 . println ( lr_6 ) ;
vr_25 . vr_28 () ;
System . exit ( 1 ) ;
}
try
{
int vr_19 ;
if ( vr_11 > 0 ) {
vr_13 . vr_20 ( vr_5 , vr_11 ) ;
} else {
vr_13 . vr_20 ( vr_5 ) ;
}
System . out . println ( lr_3 + vr_5 + lr_4 ) ;
vr_19 = vr_13 . vr_21 () ;
if ( ! vr_22 . vr_23 ( vr_19 ) )
{
vr_13 . vr_24 () ;
System . vr_15 . println ( lr_7 ) ;
System . exit ( 1 ) ;
}
}
catch ( final IOException vr_25 )
{
if ( vr_13 . vr_26 () )
{
try
{
vr_13 . vr_24 () ;
}
catch ( final IOException vr_27 )
{
}
}
System . vr_15 . println ( lr_8 ) ;
vr_25 . vr_28 () ;
System . exit ( 1 ) ;
}
lb_1:
try
{
if ( ! vr_12 . vr_29 ( vr_2 , vr_3 ) )
{
System . vr_15 . println ( lr_9 + vr_1 ) ;
break lb_1;
}
if ( ! vr_13 . vr_29 ( vr_6 , vr_7 ) )
{
System . vr_15 . println ( lr_9 + vr_5 ) ;
break lb_1;
}
vr_13 . vr_30 () ;
vr_12 . vr_31 ( vr_32 . vr_33 ( vr_13 . vr_34 () ) ,
vr_13 . vr_35 () ) ;
if ( vr_12 . vr_36 ( vr_4 ) && vr_13 . vr_37 ( vr_8 ) )
{
vr_12 . vr_38 () ;
vr_13 . vr_38 () ;
}
else
{
System . vr_15 . println (
lr_10 ) ;
break lb_1;
}
}
catch ( final IOException vr_25 )
{
vr_25 . vr_28 () ;
System . exit ( 1 ) ;
}
finally
{
try
{
if ( vr_12 . vr_26 () )
{
vr_12 . vr_39 () ;
vr_12 . vr_24 () ;
}
}
catch ( final IOException vr_25 )
{
}
try
{
if ( vr_13 . vr_26 () )
{
vr_13 . vr_39 () ;
vr_13 . vr_24 () ;
}
}
catch ( final IOException vr_25 )
{
}
}
}
