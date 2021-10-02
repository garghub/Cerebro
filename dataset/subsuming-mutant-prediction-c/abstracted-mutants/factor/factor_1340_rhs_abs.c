static tp_1
fn_1 ( tp_1 * vr_1 , tp_1 vr_2 , tp_1 vr_3 , tp_1 vr_4 , tp_1 vr_5 )
{
int vr_6 , vr_7 ;
assert ( vr_4 != 0 ) ;
if ( vr_2 == 0 )
{
* vr_1 = 0 ;
return vr_3 ;
}
fn_2 ( vr_6 , vr_4 ) ;
fn_2 ( vr_7 , vr_2 ) ;
int vr_8 = vr_6 - vr_7 ;
fn_3 ( vr_4 , vr_5 , vr_4 , vr_5 , vr_8 ) ;
int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_8 ; vr_9 ++ )
{
if ( fn_4 ( vr_2 , vr_3 , vr_4 , vr_5 ) )
fn_5 ( vr_2 , vr_3 , vr_2 , vr_3 , vr_4 , vr_5 ) ;
fn_6 ( vr_4 , vr_5 , vr_4 , vr_5 , 1 ) ;
}
* vr_1 = vr_2 ;
return vr_3 ;
}
static tp_1 tp_2
fn_7 ( tp_1 vr_10 , tp_1 vr_11 )
{
if ( ( vr_11 & 1 ) == 0 )
{
tp_1 vr_12 = vr_11 ;
vr_11 = vr_10 ;
vr_10 = vr_12 ;
}
if ( vr_10 == 0 )
return vr_11 ;
vr_11 >>= 1 ;
for (; ; )
{
tp_1 vr_12 ;
tp_1 vr_13 ;
while ( ( vr_10 & 1 ) == 0 )
vr_10 >>= 1 ;
vr_10 >>= 1 ;
vr_12 = vr_10 - vr_11 ;
if ( vr_12 == 0 )
return ( vr_10 << 1 ) + 1 ;
vr_13 = fn_8 ( vr_12 ) ;
vr_11 += ( vr_13 & vr_12 ) ;
vr_10 = ( vr_12 ^ vr_13 ) - vr_13 ;
}
}
static tp_1
fn_9 ( tp_1 * vr_1 , tp_1 vr_2 , tp_1 vr_3 , tp_1 vr_14 , tp_1 vr_15 )
{
while ( ( vr_3 & 1 ) == 0 )
fn_6 ( vr_2 , vr_3 , vr_2 , vr_3 , 1 ) ;
while ( ( vr_15 & 1 ) == 0 )
fn_6 ( vr_14 , vr_15 , vr_14 , vr_15 , 1 ) ;
for (; ; )
{
if ( ( vr_14 | vr_2 ) == 0 )
{
* vr_1 = 0 ;
return fn_7 ( vr_15 , vr_3 ) ;
}
if ( fn_10 ( vr_2 , vr_3 , vr_14 , vr_15 ) )
{
fn_5 ( vr_2 , vr_3 , vr_2 , vr_3 , vr_14 , vr_15 ) ;
do
fn_6 ( vr_2 , vr_3 , vr_2 , vr_3 , 1 ) ;
while ( ( vr_3 & 1 ) == 0 );
}
else if ( fn_10 ( vr_14 , vr_15 , vr_2 , vr_3 ) )
{
fn_5 ( vr_14 , vr_15 , vr_14 , vr_15 , vr_2 , vr_3 ) ;
do
fn_6 ( vr_14 , vr_15 , vr_14 , vr_15 , 1 ) ;
while ( ( vr_15 & 1 ) == 0 );
}
else
break;
}
* vr_1 = vr_2 ;
return vr_3 ;
}
static void
fn_11 ( struct vr_16 * vr_16 ,
tp_1 vr_17 , unsigned int vr_18 )
{
unsigned int vr_19 = vr_16 -> vr_19 ;
tp_1 * vr_20 = vr_16 -> vr_20 ;
unsigned char * vr_21 = vr_16 -> vr_21 ;
int vr_9 ;
for ( vr_9 = vr_19 - 1 ; vr_9 >= 0 ; vr_9 -- )
{
if ( vr_20 [ vr_9 ] <= vr_17 )
break;
}
if ( vr_9 < 0 || vr_20 [ vr_9 ] != vr_17 )
{
int vr_22 ;
for ( vr_22 = vr_19 - 1 ; vr_22 > vr_9 ; vr_22 -- )
{
vr_20 [ vr_22 + 1 ] = vr_20 [ vr_22 ] ;
vr_21 [ vr_22 + 1 ] = vr_21 [ vr_22 ] ;
}
vr_20 [ vr_9 + 1 ] = vr_17 ;
vr_21 [ vr_9 + 1 ] = vr_18 ;
vr_16 -> vr_19 = vr_19 + 1 ;
}
else
{
vr_21 [ vr_9 ] += vr_18 ;
}
}
static void
fn_12 ( struct vr_16 * vr_16 ,
tp_1 vr_23 , tp_1 vr_24 )
{
if ( vr_23 > 0 )
{
assert ( vr_16 -> vr_25 [ 1 ] == 0 ) ;
vr_16 -> vr_25 [ 0 ] = vr_24 ;
vr_16 -> vr_25 [ 1 ] = vr_23 ;
}
else
fn_13 ( vr_16 , vr_24 ) ;
}
static void
fn_14 ( void (* fn_15)( tp_3 ) , ... )
{
tp_4 vr_26 ;
va_start ( vr_26 , fn_15 ) ;
tp_3 * vr_27 ;
while ( ( vr_27 = va_arg ( vr_26 , tp_3 * ) ) )
fn_15 ( * vr_27 ) ;
va_end ( vr_26 ) ;
}
static void
fn_16 ( struct vr_28 * vr_16 )
{
vr_16 -> vr_20 = NULL ;
vr_16 -> vr_21 = NULL ;
vr_16 -> vr_19 = 0 ;
}
static void
fn_17 ( struct vr_28 * vr_16 )
{
unsigned int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_16 -> vr_19 ; vr_9 ++ )
fn_18 ( vr_16 -> vr_20 [ vr_9 ] ) ;
free ( vr_16 -> vr_20 ) ;
free ( vr_16 -> vr_21 ) ;
}
static void
fn_19 ( struct vr_28 * vr_16 , tp_3 vr_17 )
{
unsigned long int vr_19 = vr_16 -> vr_19 ;
tp_3 * vr_20 = vr_16 -> vr_20 ;
unsigned long int * vr_21 = vr_16 -> vr_21 ;
long vr_9 ;
for ( vr_9 = vr_19 - 1 ; vr_9 >= 0 ; vr_9 -- )
{
if ( fn_20 ( vr_20 [ vr_9 ] , vr_17 ) <= 0 )
break;
}
if ( vr_9 < 0 || fn_20 ( vr_20 [ vr_9 ] , vr_17 ) != 0 )
{
vr_20 = fn_21 ( vr_20 , ( vr_19 + 1 ) * sizeof vr_20 [ 0 ] ) ;
vr_21 = fn_21 ( vr_21 , ( vr_19 + 1 ) * sizeof vr_21 [ 0 ] ) ;
fn_22 ( vr_20 [ vr_19 ] ) ;
long vr_22 ;
for ( vr_22 = vr_19 - 1 ; vr_22 > vr_9 ; vr_22 -- )
{
fn_23 ( vr_20 [ vr_22 + 1 ] , vr_20 [ vr_22 ] ) ;
vr_21 [ vr_22 + 1 ] = vr_21 [ vr_22 ] ;
}
fn_23 ( vr_20 [ vr_9 + 1 ] , vr_17 ) ;
vr_21 [ vr_9 + 1 ] = 1 ;
vr_16 -> vr_20 = vr_20 ;
vr_16 -> vr_21 = vr_21 ;
vr_16 -> vr_19 = vr_19 + 1 ;
}
else
{
vr_21 [ vr_9 ] += 1 ;
}
}
static void
fn_24 ( struct vr_28 * vr_16 , unsigned long int vr_17 )
{
tp_3 vr_29 ;
fn_25 ( vr_29 , vr_17 ) ;
fn_19 ( vr_16 , vr_29 ) ;
fn_18 ( vr_29 ) ;
}
static inline void
fn_26 ( char const * vr_30 , ... )
{
if ( vl_1 )
{
tp_4 vr_26 ;
va_start ( vr_26 , vr_30 ) ;
vfprintf ( vl_2 , vr_30 , vr_26 ) ;
va_end ( vr_26 ) ;
}
}
static void
fn_27 ( struct vr_16 * vr_16 , tp_1 vr_20 , unsigned int vr_9 ,
unsigned int vr_31 )
{
unsigned int vr_22 ;
for ( vr_22 = 0 ; vr_22 < vr_31 ; vr_22 ++ )
vr_20 += vr_32 [ vr_9 + vr_22 ] ;
fn_13 ( vr_16 , vr_20 ) ;
}
static tp_1
fn_28 ( tp_1 * vr_33 , tp_1 vr_34 , tp_1 vr_35 ,
struct vr_16 * vr_16 )
{
if ( vr_35 % 2 == 0 )
{
unsigned int vr_8 ;
if ( vr_35 == 0 )
{
fn_29 ( vr_8 , vr_34 ) ;
vr_35 = vr_34 >> vr_8 ;
vr_34 = 0 ;
vr_8 += vl_3 ;
}
else
{
fn_29 ( vr_8 , vr_35 ) ;
fn_6 ( vr_34 , vr_35 , vr_34 , vr_35 , vr_8 ) ;
}
fn_11 ( vr_16 , 2 , vr_8 ) ;
}
tp_1 vr_20 = 3 ;
unsigned int vr_9 ;
for ( vr_9 = 0 ; vr_34 > 0 && vr_9 < vl_4 ; vr_9 ++ )
{
for (; ; )
{
tp_1 vr_36 , vr_37 , vr_38 , vr_39 vr_40 ;
vr_37 = vr_35 * vr_41 [ vr_9 ] . vl_5 ;
fn_30 ( vr_38 , vr_39 , vr_37 , vr_20 ) ;
if ( vr_38 > vr_34 )
break;
vr_38 = vr_34 - vr_38 ;
vr_36 = vr_38 * vr_41 [ vr_9 ] . vl_5 ;
if ( fn_31 ( vr_36 > vr_41 [ vr_9 ] . vl_6 ) )
break;
vr_34 = vr_36 ; vr_35 = vr_37 ;
fn_13 ( vr_16 , vr_20 ) ;
}
vr_20 += vr_32 [ vr_9 + 1 ] ;
}
if ( vr_33 )
* vr_33 = vr_34 ;
#define mc_1 ( tp_5 ) \
do { \
for (;;) \
{ \
q = t0 * pd[I].binv; \
if (LIKELY (q > pd[I].lim)) \
break; \
t0 = q; \
factor_insert_refind (factors, p, i + 1, I); \
} \
} while (0)
for (; vr_9 < vl_4 ; vr_9 += 8 )
{
tp_1 vr_42 ;
const struct vr_41 * vr_43 = & vr_41 [ vr_9 ] ;
mc_1 ( 0 ) ;
mc_1 ( 1 ) ;
mc_1 ( 2 ) ;
mc_1 ( 3 ) ;
mc_1 ( 4 ) ;
mc_1 ( 5 ) ;
mc_1 ( 6 ) ;
mc_1 ( 7 ) ;
vr_20 += vr_44 [ vr_9 ] ;
if ( vr_20 * vr_20 > vr_35 )
break;
}
return vr_35 ;
}
static void
fn_32 ( tp_3 vr_12 , struct vr_28 * vr_16 )
{
tp_3 vr_42 ;
unsigned long int vr_20 ;
fn_26 ( lr_1 ) ;
fn_22 ( vr_42 ) ;
vr_20 = fn_33 ( vr_12 , 0 ) ;
fn_34 ( vr_12 , vr_12 , vr_20 ) ;
while ( vr_20 )
{
fn_24 ( vr_16 , 2 ) ;
-- vr_20 ;
}
vr_20 = 3 ;
unsigned int vr_9 ;
for ( vr_9 = 1 ; vr_9 <= vl_4 ; )
{
if ( ! fn_35 ( vr_12 , vr_20 ) )
{
vr_20 += vr_32 [ vr_9 ++ ] ;
if ( fn_36 ( vr_12 , vr_20 * vr_20 ) < 0 )
break;
}
else
{
fn_37 ( vr_12 , vr_12 , vr_20 ) ;
fn_24 ( vr_16 , vr_20 ) ;
}
}
fn_18 ( vr_42 ) ;
}
static inline tp_1
fn_38 ( tp_1 vr_10 , tp_1 vr_11 , tp_1 vr_18 , tp_1 vr_45 )
{
tp_1 vr_46 , vr_47 , vr_42 , vr_48 , vr_49 vr_40 , vr_50 ;
fn_30 ( vr_46 , vr_47 , vr_10 , vr_11 ) ;
vr_42 = vr_47 * vr_45 ;
fn_30 ( vr_48 , vr_49 , vr_42 , vr_18 ) ;
vr_50 = vr_46 - vr_48 ;
if ( vr_46 < vr_48 )
vr_50 += vr_18 ;
return vr_50 ;
}
static tp_1
fn_39 ( tp_1 * vr_51 ,
tp_1 vr_2 , tp_1 vr_3 , tp_1 vr_14 , tp_1 vr_15 ,
tp_1 vr_52 , tp_1 vr_53 , tp_1 vr_45 )
{
tp_1 vr_1 , vr_54 , vr_42 , vr_23 , vr_24 vr_40 , vr_34 , vr_35 , vr_55 , vr_56 ;
vr_45 = - vr_45 ;
assert ( ( vr_2 >> ( vl_3 - 1 ) ) == 0 ) ;
assert ( ( vr_14 >> ( vl_3 - 1 ) ) == 0 ) ;
assert ( ( vr_52 >> ( vl_3 - 1 ) ) == 0 ) ;
fn_30 ( vr_34 , vr_35 , vr_3 , vr_15 ) ;
fn_30 ( vr_1 , vr_54 , vr_3 , vr_14 ) ;
vr_42 = vr_45 * vr_35 ;
fn_30 ( vr_23 , vr_24 , vr_42 , vr_53 ) ;
fn_30 ( vr_55 , vr_56 , vr_42 , vr_52 ) ;
vr_54 += ( vr_35 != 0 ) ;
fn_40 ( vr_1 , vr_54 , vr_1 , vr_54 , 0 , vr_23 ) ;
fn_40 ( vr_1 , vr_54 , vr_1 , vr_54 , 0 , vr_34 ) ;
fn_40 ( vr_1 , vr_54 , vr_1 , vr_54 , vr_55 , vr_56 ) ;
fn_30 ( vr_34 , vr_35 , vr_2 , vr_15 ) ;
fn_30 ( vr_55 , vr_56 , vr_2 , vr_14 ) ;
fn_40 ( vr_34 , vr_35 , vr_34 , vr_35 , 0 , vr_54 ) ;
vr_42 = vr_45 * vr_35 ;
fn_40 ( vr_1 , vr_54 , vr_55 , vr_56 , 0 , vr_1 ) ;
fn_30 ( vr_23 , vr_24 , vr_42 , vr_53 ) ;
fn_30 ( vr_55 , vr_56 , vr_42 , vr_52 ) ;
vr_54 += ( vr_35 != 0 ) ;
fn_40 ( vr_1 , vr_54 , vr_1 , vr_54 , 0 , vr_23 ) ;
fn_40 ( vr_1 , vr_54 , vr_1 , vr_54 , 0 , vr_34 ) ;
fn_40 ( vr_1 , vr_54 , vr_1 , vr_54 , vr_55 , vr_56 ) ;
if ( fn_4 ( vr_1 , vr_54 , vr_52 , vr_53 ) )
fn_5 ( vr_1 , vr_54 , vr_1 , vr_54 , vr_52 , vr_53 ) ;
* vr_51 = vr_1 ;
return vr_54 ;
}
static tp_1 tp_2
fn_41 ( tp_1 vr_11 , tp_1 vr_21 , tp_1 vr_57 , tp_1 vr_58 , tp_1 vr_59 )
{
tp_1 vr_60 = vr_59 ;
if ( vr_21 & 1 )
vr_60 = vr_11 ;
while ( vr_21 != 0 )
{
vr_11 = fn_38 ( vr_11 , vr_11 , vr_57 , vr_58 ) ;
vr_21 >>= 1 ;
if ( vr_21 & 1 )
vr_60 = fn_38 ( vr_60 , vr_11 , vr_57 , vr_58 ) ;
}
return vr_60 ;
}
static tp_1
fn_42 ( tp_1 * vr_61 ,
const tp_1 * vr_62 , const tp_1 * vr_63 , const tp_1 * vr_64 ,
tp_1 vr_58 , const tp_1 * vr_59 )
{
tp_1 vr_1 , vr_54 , vr_14 , vr_15 , vr_65 , vr_66 ;
unsigned int vr_9 ;
tp_1 vr_21 ;
vr_15 = vr_62 [ 0 ] ;
vr_14 = vr_62 [ 1 ] ;
vr_66 = vr_64 [ 0 ] ;
vr_65 = vr_64 [ 1 ] ;
vr_54 = vr_59 [ 0 ] ;
vr_1 = vr_59 [ 1 ] ;
for ( vr_21 = vr_63 [ 0 ] , vr_9 = vl_3 ; vr_9 > 0 ; vr_9 -- , vr_21 >>= 1 )
{
if ( vr_21 & 1 )
{
vr_54 = fn_39 ( vr_61 , vr_1 , vr_54 , vr_14 , vr_15 , vr_65 , vr_66 , vr_58 ) ;
vr_1 = * vr_61 ;
}
vr_15 = fn_39 ( vr_61 , vr_14 , vr_15 , vr_14 , vr_15 , vr_65 , vr_66 , vr_58 ) ;
vr_14 = * vr_61 ;
}
for ( vr_21 = vr_63 [ 1 ] ; vr_21 > 0 ; vr_21 >>= 1 )
{
if ( vr_21 & 1 )
{
vr_54 = fn_39 ( vr_61 , vr_1 , vr_54 , vr_14 , vr_15 , vr_65 , vr_66 , vr_58 ) ;
vr_1 = * vr_61 ;
}
vr_15 = fn_39 ( vr_61 , vr_14 , vr_15 , vr_14 , vr_15 , vr_65 , vr_66 , vr_58 ) ;
vr_14 = * vr_61 ;
}
* vr_61 = vr_1 ;
return vr_54 ;
}
static bool tp_2
fn_43 ( tp_1 vr_57 , tp_1 vr_58 , tp_1 vr_11 , tp_1 vr_42 ,
unsigned int vr_67 , tp_1 vr_59 )
{
tp_1 vr_60 = fn_41 ( vr_11 , vr_42 , vr_57 , vr_58 , vr_59 ) ;
tp_1 vr_68 = vr_57 - vr_59 ;
if ( vr_60 == vr_59 || vr_60 == vr_68 )
return true ;
unsigned int vr_9 ;
for ( vr_9 = 1 ; vr_9 < vr_67 ; vr_9 ++ )
{
vr_60 = fn_38 ( vr_60 , vr_60 , vr_57 , vr_58 ) ;
if ( vr_60 == vr_68 )
return true ;
if ( vr_60 == vr_59 )
return false ;
}
return false ;
}
static bool
fn_44 ( const tp_1 * vr_64 , tp_1 vr_58 , const tp_1 * vr_62 ,
const tp_1 * vr_69 , unsigned int vr_67 , const tp_1 * vr_59 )
{
tp_1 y1 , y0 , vr_70 , vr_71 , vr_61 ;
y0 = fn_42 ( & vr_61 , vr_62 , vr_69 , vr_64 , vr_58 , vr_59 ) ;
y1 = vr_61 ;
if ( y0 == vr_59 [ 0 ] && y1 == vr_59 [ 1 ] )
return true ;
fn_5 ( vr_70 , vr_71 , vr_64 [ 1 ] , vr_64 [ 0 ] , vr_59 [ 1 ] , vr_59 [ 0 ] ) ;
if ( y0 == vr_71 && y1 == vr_70 )
return true ;
unsigned int vr_9 ;
for ( vr_9 = 1 ; vr_9 < vr_67 ; vr_9 ++ )
{
y0 = fn_39 ( & vr_61 , y1 , y0 , y1 , y0 , vr_64 [ 1 ] , vr_64 [ 0 ] , vr_58 ) ;
y1 = vr_61 ;
if ( y0 == vr_71 && y1 == vr_70 )
return true ;
if ( y0 == vr_59 [ 0 ] && y1 == vr_59 [ 1 ] )
return false ;
}
return false ;
}
static bool
fn_45 ( tp_6 vr_57 , tp_6 vr_68 , tp_7 vr_72 , tp_7 vr_60 ,
tp_6 vr_42 , unsigned long int vr_67 )
{
fn_46 ( vr_60 , vr_72 , vr_42 , vr_57 ) ;
if ( fn_36 ( vr_60 , 1 ) == 0 || fn_20 ( vr_60 , vr_68 ) == 0 )
return true ;
unsigned long int vr_9 ;
for ( vr_9 = 1 ; vr_9 < vr_67 ; vr_9 ++ )
{
fn_47 ( vr_60 , vr_60 , 2 , vr_57 ) ;
if ( fn_20 ( vr_60 , vr_68 ) == 0 )
return true ;
if ( fn_36 ( vr_60 , 1 ) == 0 )
return false ;
}
return false ;
}
static bool
fn_48 ( tp_1 vr_57 )
{
int vr_67 ;
bool vr_73 ;
tp_1 vr_74 , vr_59 , vr_58 ;
struct vr_16 vr_16 ;
if ( vr_57 <= 1 )
return false ;
if ( vr_57 < ( tp_1 ) vl_7 * vl_7 )
return true ;
tp_1 vr_42 = vr_57 - 1 ;
for ( vr_67 = 0 ; ( vr_42 & 1 ) == 0 ; vr_67 ++ )
vr_42 >>= 1 ;
tp_1 vr_10 = 2 ;
vl_5 ( vr_58 , vr_57 ) ;
fn_49 ( vr_59 , 1 , vr_57 ) ;
fn_50 ( vr_74 , vr_59 , vr_59 , vr_57 ) ;
if ( ! fn_43 ( vr_57 , vr_58 , vr_74 , vr_42 , vr_67 , vr_59 ) )
return false ;
if ( vl_8 )
{
fn_51 ( 0 , vr_57 - 1 , & vr_16 ) ;
}
unsigned int vr_75 ;
for ( vr_75 = 0 ; vr_75 < vl_4 ; vr_75 ++ )
{
if ( vl_8 )
{
vr_73 = true ;
unsigned int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_16 . vr_19 && vr_73 ; vr_9 ++ )
{
vr_73
= fn_41 ( vr_74 , ( vr_57 - 1 ) / vr_16 . vr_20 [ vr_9 ] , vr_57 , vr_58 , vr_59 ) != vr_59 ;
}
}
else
{
vr_73 = ( vr_75 == vl_9 - 1 ) ;
}
if ( vr_73 )
return true ;
vr_10 += vr_32 [ vr_75 ] ;
{
tp_1 vr_55 , vr_56 ;
fn_30 ( vr_55 , vr_56 , vr_59 , vr_10 ) ;
if ( fn_31 ( vr_55 == 0 ) )
vr_74 = vr_56 % vr_57 ;
else
{
tp_1 tp_8 vr_40 ;
fn_52 ( tp_8 , vr_74 , vr_55 , vr_56 , vr_57 ) ;
}
}
if ( ! fn_43 ( vr_57 , vr_58 , vr_74 , vr_42 , vr_67 , vr_59 ) )
return false ;
}
error ( 0 , 0 , _ ( lr_2 ) ) ;
abort () ;
}
static bool
fn_53 ( tp_1 vr_65 , tp_1 vr_66 )
{
tp_1 vr_42 [ 2 ] , vr_68 [ 2 ] ;
tp_1 vr_74 [ 2 ] ;
tp_1 vr_59 [ 2 ] ;
tp_1 vr_76 [ 2 ] ;
tp_1 vr_58 ;
unsigned int vr_67 ;
struct vr_16 vr_16 ;
if ( vr_65 == 0 )
return fn_48 ( vr_66 ) ;
vr_68 [ 1 ] = vr_65 - ( vr_66 == 0 ) ;
vr_68 [ 0 ] = vr_66 - 1 ;
if ( vr_68 [ 0 ] == 0 )
{
fn_29 ( vr_67 , vr_68 [ 1 ] ) ;
vr_42 [ 0 ] = vr_68 [ 1 ] >> vr_67 ;
vr_42 [ 1 ] = 0 ;
vr_67 += vl_3 ;
}
else
{
fn_29 ( vr_67 , vr_68 [ 0 ] ) ;
fn_6 ( vr_42 [ 1 ] , vr_42 [ 0 ] , vr_68 [ 1 ] , vr_68 [ 0 ] , vr_67 ) ;
}
tp_1 vr_10 = 2 ;
vl_5 ( vr_58 , vr_66 ) ;
fn_54 ( vr_59 [ 1 ] , vr_59 [ 0 ] , 1 , vr_65 , vr_66 ) ;
fn_55 ( vr_74 [ 1 ] , vr_74 [ 0 ] , vr_59 [ 1 ] , vr_59 [ 0 ] , vr_59 [ 1 ] , vr_59 [ 0 ] , vr_65 , vr_66 ) ;
vr_76 [ 0 ] = vr_66 ;
vr_76 [ 1 ] = vr_65 ;
if ( ! fn_44 ( vr_76 , vr_58 , vr_74 , vr_42 , vr_67 , vr_59 ) )
return false ;
if ( vl_8 )
{
fn_51 ( vr_68 [ 1 ] , vr_68 [ 0 ] , & vr_16 ) ;
}
unsigned int vr_75 ;
for ( vr_75 = 0 ; vr_75 < vl_4 ; vr_75 ++ )
{
bool vr_73 ;
tp_1 vr_21 [ 2 ] , vr_60 [ 2 ] ;
if ( vl_8 )
{
vr_73 = true ;
if ( vr_16 . vr_25 [ 1 ] )
{
tp_1 vr_77 ;
vl_5 ( vr_77 , vr_16 . vr_25 [ 0 ] ) ;
vr_21 [ 0 ] = vr_77 * vr_68 [ 0 ] ;
vr_21 [ 1 ] = 0 ;
vr_60 [ 0 ] = fn_42 ( & vr_60 [ 1 ] , vr_74 , vr_21 , vr_76 , vr_58 , vr_59 ) ;
vr_73 = ( vr_60 [ 0 ] != vr_59 [ 0 ] || vr_60 [ 1 ] != vr_59 [ 1 ] ) ;
}
unsigned int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_16 . vr_19 && vr_73 ; vr_9 ++ )
{
if ( vr_16 . vr_20 [ vr_9 ] == 2 )
fn_6 ( vr_21 [ 1 ] , vr_21 [ 0 ] , vr_68 [ 1 ] , vr_68 [ 0 ] , 1 ) ;
else
fn_56 ( vr_21 [ 1 ] , vr_21 [ 0 ] , vr_68 [ 1 ] , vr_68 [ 0 ] , vr_16 . vr_20 [ vr_9 ] ) ;
vr_60 [ 0 ] = fn_42 ( & vr_60 [ 1 ] , vr_74 , vr_21 , vr_76 , vr_58 , vr_59 ) ;
vr_73 = ( vr_60 [ 0 ] != vr_59 [ 0 ] || vr_60 [ 1 ] != vr_59 [ 1 ] ) ;
}
}
else
{
vr_73 = ( vr_75 == vl_9 - 1 ) ;
}
if ( vr_73 )
return true ;
vr_10 += vr_32 [ vr_75 ] ;
fn_54 ( vr_74 [ 1 ] , vr_74 [ 0 ] , vr_10 , vr_65 , vr_66 ) ;
if ( ! fn_44 ( vr_76 , vr_58 , vr_74 , vr_42 , vr_67 , vr_59 ) )
return false ;
}
error ( 0 , 0 , _ ( lr_2 ) ) ;
abort () ;
}
static bool
fn_57 ( tp_3 vr_57 )
{
bool vr_73 ;
tp_3 vr_42 , vr_10 , vr_68 , vr_78 ;
struct vr_28 vr_16 ;
if ( fn_36 ( vr_57 , 1 ) <= 0 )
return false ;
if ( fn_36 ( vr_57 , ( long ) vl_7 * vl_7 ) < 0 )
return true ;
fn_58 ( vr_42 , vr_10 , vr_68 , vr_78 , NULL ) ;
fn_59 ( vr_68 , vr_57 , 1 ) ;
unsigned long int vr_67 = fn_33 ( vr_68 , 0 ) ;
fn_60 ( vr_42 , vr_68 , vr_67 ) ;
fn_61 ( vr_10 , 2 ) ;
if ( ! fn_45 ( vr_57 , vr_68 , vr_10 , vr_78 , vr_42 , vr_67 ) )
{
vr_73 = false ;
goto lb_1;
}
if ( vl_8 )
{
fn_23 ( vr_78 , vr_68 ) ;
fn_62 ( vr_78 , & vr_16 ) ;
}
unsigned int vr_75 ;
for ( vr_75 = 0 ; vr_75 < vl_4 ; vr_75 ++ )
{
if ( vl_8 )
{
vr_73 = true ;
unsigned long int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_16 . vr_19 && vr_73 ; vr_9 ++ )
{
fn_63 ( vr_78 , vr_68 , vr_16 . vr_20 [ vr_9 ] ) ;
fn_46 ( vr_78 , vr_10 , vr_78 , vr_57 ) ;
vr_73 = fn_36 ( vr_78 , 1 ) != 0 ;
}
}
else
{
vr_73 = ( vr_75 == vl_9 - 1 ) ;
}
if ( vr_73 )
goto lb_2;
fn_64 ( vr_10 , vr_10 , vr_32 [ vr_75 ] ) ;
if ( ! fn_45 ( vr_57 , vr_68 , vr_10 , vr_78 , vr_42 , vr_67 ) )
{
vr_73 = false ;
goto lb_2;
}
}
error ( 0 , 0 , _ ( lr_2 ) ) ;
abort () ;
lb_2:
if ( vl_8 )
fn_17 ( & vr_16 ) ;
lb_1:
fn_65 ( vr_42 , vr_10 , vr_68 , vr_78 , NULL ) ;
return vr_73 ;
}
static void
fn_66 ( tp_1 vr_57 , unsigned long int vr_10 ,
struct vr_16 * vr_16 )
{
tp_1 vr_72 , vr_79 , vr_60 , vr_80 , vr_12 , vr_58 , vr_81 ;
unsigned long int vr_67 = 1 ;
unsigned long int vr_82 = 1 ;
fn_49 ( vr_80 , 1 , vr_57 ) ;
fn_50 ( vr_72 , vr_80 , vr_80 , vr_57 ) ;
vr_60 = vr_79 = vr_72 ;
while ( vr_57 != 1 )
{
assert ( vr_10 < vr_57 ) ;
vl_5 ( vr_58 , vr_57 ) ;
for (; ; )
{
do
{
vr_72 = fn_38 ( vr_72 , vr_72 , vr_57 , vr_58 ) ;
fn_50 ( vr_72 , vr_72 , vr_10 , vr_57 ) ;
fn_67 ( vr_12 , vr_79 , vr_72 , vr_57 ) ;
vr_80 = fn_38 ( vr_80 , vr_12 , vr_57 , vr_58 ) ;
if ( vr_67 % 32 == 1 )
{
if ( fn_7 ( vr_80 , vr_57 ) != 1 )
goto lb_3;
vr_60 = vr_72 ;
}
}
while ( -- vr_67 != 0 );
vr_79 = vr_72 ;
vr_67 = vr_82 ;
vr_82 = 2 * vr_82 ;
unsigned long int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_67 ; vr_9 ++ )
{
vr_72 = fn_38 ( vr_72 , vr_72 , vr_57 , vr_58 ) ;
fn_50 ( vr_72 , vr_72 , vr_10 , vr_57 ) ;
}
vr_60 = vr_72 ;
}
lb_3:
do
{
vr_60 = fn_38 ( vr_60 , vr_60 , vr_57 , vr_58 ) ;
fn_50 ( vr_60 , vr_60 , vr_10 , vr_57 ) ;
fn_67 ( vr_12 , vr_79 , vr_60 , vr_57 ) ;
vr_81 = fn_7 ( vr_12 , vr_57 ) ;
}
while ( vr_81 == 1 );
vr_57 = vr_57 / vr_81 ;
if ( ! fn_48 ( vr_81 ) )
fn_66 ( vr_81 , vr_10 + 1 , vr_16 ) ;
else
fn_13 ( vr_16 , vr_81 ) ;
if ( fn_48 ( vr_57 ) )
{
fn_13 ( vr_16 , vr_57 ) ;
break;
}
vr_72 = vr_72 % vr_57 ;
vr_79 = vr_79 % vr_57 ;
vr_60 = vr_60 % vr_57 ;
}
}
static void
fn_68 ( tp_1 vr_65 , tp_1 vr_66 , unsigned long int vr_10 ,
struct vr_16 * vr_16 )
{
tp_1 vr_83 , vr_84 , vr_85 , vr_86 , y1 , y0 , vr_87 , vr_88 , vr_34 , vr_35 , vr_58 , vr_89 , vr_90 , vr_61 ;
unsigned long int vr_67 = 1 ;
unsigned long int vr_82 = 1 ;
fn_54 ( vr_87 , vr_88 , 1 , vr_65 , vr_66 ) ;
fn_55 ( vr_83 , vr_84 , vr_87 , vr_88 , vr_87 , vr_88 , vr_65 , vr_66 ) ;
y1 = vr_85 = vr_83 ;
y0 = vr_86 = vr_84 ;
while ( vr_65 != 0 || vr_66 != 1 )
{
vl_5 ( vr_58 , vr_66 ) ;
for (; ; )
{
do
{
vr_84 = fn_39 ( & vr_61 , vr_83 , vr_84 , vr_83 , vr_84 , vr_65 , vr_66 , vr_58 ) ;
vr_83 = vr_61 ;
fn_55 ( vr_83 , vr_84 , vr_83 , vr_84 , 0 , ( tp_1 ) vr_10 , vr_65 , vr_66 ) ;
fn_69 ( vr_34 , vr_35 , vr_85 , vr_86 , vr_83 , vr_84 , vr_65 , vr_66 ) ;
vr_88 = fn_39 ( & vr_61 , vr_87 , vr_88 , vr_34 , vr_35 , vr_65 , vr_66 , vr_58 ) ;
vr_87 = vr_61 ;
if ( vr_67 % 32 == 1 )
{
vr_90 = fn_9 ( & vr_89 , vr_87 , vr_88 , vr_65 , vr_66 ) ;
if ( vr_89 != 0 || vr_90 != 1 )
goto lb_3;
y1 = vr_83 ; y0 = vr_84 ;
}
}
while ( -- vr_67 != 0 );
vr_85 = vr_83 ; vr_86 = vr_84 ;
vr_67 = vr_82 ;
vr_82 = 2 * vr_82 ;
unsigned long int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_67 ; vr_9 ++ )
{
vr_84 = fn_39 ( & vr_61 , vr_83 , vr_84 , vr_83 , vr_84 , vr_65 , vr_66 , vr_58 ) ;
vr_83 = vr_61 ;
fn_55 ( vr_83 , vr_84 , vr_83 , vr_84 , 0 , ( tp_1 ) vr_10 , vr_65 , vr_66 ) ;
}
y1 = vr_83 ; y0 = vr_84 ;
}
lb_3:
do
{
y0 = fn_39 ( & vr_61 , y1 , y0 , y1 , y0 , vr_65 , vr_66 , vr_58 ) ;
y1 = vr_61 ;
fn_55 ( y1 , y0 , y1 , y0 , 0 , ( tp_1 ) vr_10 , vr_65 , vr_66 ) ;
fn_69 ( vr_34 , vr_35 , vr_85 , vr_86 , y1 , y0 , vr_65 , vr_66 ) ;
vr_90 = fn_9 ( & vr_89 , vr_34 , vr_35 , vr_65 , vr_66 ) ;
}
while ( vr_89 == 0 && vr_90 == 1 );
if ( vr_89 == 0 )
{
fn_56 ( vr_65 , vr_66 , vr_65 , vr_66 , vr_90 ) ;
if ( ! fn_48 ( vr_90 ) )
fn_66 ( vr_90 , vr_10 + 1 , vr_16 ) ;
else
fn_13 ( vr_16 , vr_90 ) ;
}
else
{
tp_1 vr_91 ;
vl_5 ( vr_91 , vr_90 ) ;
vr_66 = vr_91 * vr_66 ;
vr_65 = 0 ;
if ( ! fn_53 ( vr_89 , vr_90 ) )
fn_68 ( vr_89 , vr_90 , vr_10 + 1 , vr_16 ) ;
else
fn_12 ( vr_16 , vr_89 , vr_90 ) ;
}
if ( vr_65 == 0 )
{
if ( fn_48 ( vr_66 ) )
{
fn_13 ( vr_16 , vr_66 ) ;
break;
}
fn_66 ( vr_66 , vr_10 , vr_16 ) ;
return;
}
if ( fn_53 ( vr_65 , vr_66 ) )
{
fn_12 ( vr_16 , vr_65 , vr_66 ) ;
break;
}
vr_84 = fn_1 ( & vr_83 , vr_83 , vr_84 , vr_65 , vr_66 ) ;
vr_86 = fn_1 ( & vr_85 , vr_85 , vr_86 , vr_65 , vr_66 ) ;
y0 = fn_1 ( & y1 , y1 , y0 , vr_65 , vr_66 ) ;
}
}
static void
fn_70 ( tp_3 vr_57 , unsigned long int vr_10 ,
struct vr_28 * vr_16 )
{
tp_3 vr_72 , vr_79 , vr_60 , vr_80 ;
tp_3 vr_12 , vr_92 ;
fn_26 ( lr_3 , vr_10 ) ;
fn_58 ( vr_12 , vr_92 , NULL ) ;
fn_71 ( vr_60 , 2 ) ;
fn_71 ( vr_72 , 2 ) ;
fn_71 ( vr_79 , 2 ) ;
fn_25 ( vr_80 , 1 ) ;
unsigned long long int vr_67 = 1 ;
unsigned long long int vr_82 = 1 ;
while ( fn_36 ( vr_57 , 1 ) != 0 )
{
for (; ; )
{
do
{
fn_72 ( vr_12 , vr_72 , vr_72 ) ;
fn_73 ( vr_72 , vr_12 , vr_57 ) ;
fn_64 ( vr_72 , vr_72 , vr_10 ) ;
fn_74 ( vr_12 , vr_79 , vr_72 ) ;
fn_72 ( vr_92 , vr_80 , vr_12 ) ;
fn_73 ( vr_80 , vr_92 , vr_57 ) ;
if ( vr_67 % 32 == 1 )
{
fn_75 ( vr_12 , vr_80 , vr_57 ) ;
if ( fn_36 ( vr_12 , 1 ) != 0 )
goto lb_3;
fn_23 ( vr_60 , vr_72 ) ;
}
}
while ( -- vr_67 != 0 );
fn_23 ( vr_79 , vr_72 ) ;
vr_67 = vr_82 ;
vr_82 = 2 * vr_82 ;
unsigned long long int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_67 ; vr_9 ++ )
{
fn_72 ( vr_12 , vr_72 , vr_72 ) ;
fn_73 ( vr_72 , vr_12 , vr_57 ) ;
fn_64 ( vr_72 , vr_72 , vr_10 ) ;
}
fn_23 ( vr_60 , vr_72 ) ;
}
lb_3:
do
{
fn_72 ( vr_12 , vr_60 , vr_60 ) ;
fn_73 ( vr_60 , vr_12 , vr_57 ) ;
fn_64 ( vr_60 , vr_60 , vr_10 ) ;
fn_74 ( vr_12 , vr_79 , vr_60 ) ;
fn_75 ( vr_12 , vr_12 , vr_57 ) ;
}
while ( fn_36 ( vr_12 , 1 ) == 0 );
fn_63 ( vr_57 , vr_57 , vr_12 ) ;
if ( ! fn_57 ( vr_12 ) )
{
fn_26 ( lr_4 ) ;
fn_70 ( vr_12 , vr_10 + 1 , vr_16 ) ;
}
else
{
fn_19 ( vr_16 , vr_12 ) ;
}
if ( fn_57 ( vr_57 ) )
{
fn_19 ( vr_16 , vr_57 ) ;
break;
}
fn_73 ( vr_72 , vr_72 , vr_57 ) ;
fn_73 ( vr_79 , vr_79 , vr_57 ) ;
fn_73 ( vr_60 , vr_60 , vr_57 ) ;
}
fn_65 ( vr_80 , vr_92 , vr_12 , vr_79 , vr_72 , vr_60 , NULL ) ;
}
static tp_1 tp_2
fn_76 ( tp_1 vr_57 )
{
tp_1 vr_72 ;
unsigned vr_93 ;
if ( vr_57 == 0 )
return 0 ;
fn_2 ( vr_93 , vr_57 ) ;
vr_72 = ( tp_1 ) 1 << ( ( vl_3 + 1 - vr_93 ) / 2 ) ;
for (; ; )
{
tp_1 vr_60 = ( vr_72 + vr_57 / vr_72 ) / 2 ;
if ( vr_60 >= vr_72 )
return vr_72 ;
vr_72 = vr_60 ;
}
}
static tp_1 tp_2
fn_77 ( tp_1 vr_94 , tp_1 vr_95 )
{
unsigned int vr_96 ;
tp_1 vr_72 ;
assert ( vr_94 < ( ( tp_1 ) 1 << ( vl_3 - 2 ) ) ) ;
if ( vr_94 == 0 )
return fn_76 ( vr_95 ) ;
fn_2 ( vr_96 , vr_94 ) ;
vr_96 &= ~ 1 ;
vr_72 = fn_76 ( ( vr_94 << vr_96 ) + ( vr_95 >> ( vl_3 - vr_96 ) ) ) + 1 ;
vr_72 <<= ( vl_3 - vr_96 ) / 2 ;
for (; ; )
{
tp_1 vr_75 vr_40 ;
tp_1 vr_42 , vr_60 ;
fn_52 ( vr_42 , vr_75 , vr_94 , vr_95 , vr_72 ) ;
vr_60 = ( vr_72 + vr_42 ) / 2 ;
if ( vr_60 >= vr_72 )
{
tp_1 vr_38 , vr_39 ;
fn_30 ( vr_38 , vr_39 , vr_72 + 1 , vr_72 + 1 ) ;
assert ( fn_10 ( vr_38 , vr_39 , vr_94 , vr_95 ) ) ;
fn_30 ( vr_38 , vr_39 , vr_72 , vr_72 ) ;
assert ( fn_4 ( vr_94 , vr_95 , vr_38 , vr_39 ) ) ;
fn_5 ( vr_38 , vr_39 , vr_94 , vr_95 , vr_38 , vr_39 ) ;
assert ( vr_38 == 0 ) ;
return vr_72 ;
}
vr_72 = vr_60 ;
}
}
static tp_1 tp_2
fn_78 ( tp_1 vr_72 )
{
if ( ( ( vl_10 >> ( vr_72 & 63 ) ) & 1 )
&& ( ( vl_11 >> ( vr_72 % 63 ) ) & 1 )
&& ( ( vl_12 >> ( ( vr_72 % 65 ) & 63 ) ) & 1 )
&& ( ( vl_13 >> ( vr_72 % 11 ) & 1 ) ) )
{
tp_1 vr_75 = fn_76 ( vr_72 ) ;
if ( vr_75 * vr_75 == vr_72 )
return vr_75 ;
}
return 0 ;
}
static bool
fn_79 ( tp_1 vr_65 , tp_1 vr_66 , struct vr_16 * vr_16 )
{
static const unsigned int vr_97 [] =
{
105 , 165 , 21 , 385 , 33 , 5 , 77 , 1 , 0
} ;
static const unsigned int vr_98 [] =
{
1155 , 15 , 231 , 35 , 3 , 55 , 7 , 11 , 0
} ;
const unsigned int * vr_18 ;
struct { tp_1 vr_99 ; tp_1 vr_80 ; } vr_100 [ vl_14 ] ;
if ( vr_65 >= ( ( tp_1 ) 1 << ( vl_3 - 2 ) ) )
return false ;
tp_1 vr_101 = fn_77 ( vr_65 , vr_66 ) ;
if ( vr_66 == vr_101 * vr_101 )
{
tp_1 vr_23 , vr_24 ;
fn_30 ( vr_23 , vr_24 , vr_101 , vr_101 ) ;
assert ( vr_24 == vr_66 ) ;
if ( vr_65 == vr_23 )
{
if ( fn_48 ( vr_101 ) )
fn_11 ( vr_16 , vr_101 , 2 ) ;
else
{
struct vr_16 vr_102 ;
vr_102 . vr_19 = 0 ;
if ( ! fn_79 ( 0 , vr_101 , & vr_102 ) )
{
fn_66 ( vr_101 , 1 , & vr_102 ) ;
}
unsigned int vr_9 ;
for ( vr_9 = 0 ; vr_9 < vr_102 . vr_19 ; vr_9 ++ )
fn_11 ( vr_16 , vr_102 . vr_20 [ vr_9 ] , 2 * vr_102 . vr_21 [ vr_9 ] ) ;
}
return true ;
}
}
for ( vr_18 = ( vr_66 % 4 == 1 ) ? vr_98 : vr_97 ;
* vr_18 ; vr_18 ++ )
{
tp_1 vr_103 , vr_104 , vr_105 , vr_106 , vr_99 , vr_80 , vr_107 , vr_108 , vr_109 ;
unsigned int vr_9 ;
unsigned int vr_110 = * vr_18 ;
unsigned int vr_111 = 0 ;
assert ( vr_110 * vr_66 % 4 == 3 ) ;
if ( vr_65 == 0 )
{
if ( ( tp_1 ) vr_110 * vr_110 * vr_110 >= vr_66 / 64 )
continue;
}
else
{
if ( vr_65 > ( ( tp_1 ) 1 << ( vl_3 - 2 ) ) / vr_110 )
continue;
}
fn_30 ( vr_104 , vr_105 , vr_66 , vr_110 ) ;
vr_104 += vr_65 * vr_110 ;
assert ( vr_105 % 4 != 1 ) ;
assert ( vr_104 < ( tp_1 ) 1 << ( vl_3 - 2 ) ) ;
vr_103 = fn_77 ( vr_104 , vr_105 ) ;
vr_106 = 1 ;
vr_80 = vr_103 ;
vr_99 = vr_105 - vr_80 * vr_80 ;
vr_107 = fn_76 ( 2 * vr_103 ) ;
vr_109 = 2 * vr_107 ;
vr_108 = vr_110 * 2 * vr_107 ;
for ( vr_9 = 0 ; vr_9 <= vr_109 ; vr_9 ++ )
{
tp_1 vr_42 , vr_87 , vr_12 , vr_112 ;
fn_80 ( vr_42 , vr_112 , vr_103 + vr_80 , vr_99 ) ;
vr_87 = vr_103 - vr_112 ;
#if vl_15
assert ( vr_42 > 0 ) ;
vr_113 [ 0 ] ++ ;
vr_113 [ fn_81 ( vr_42 , vl_16 ) ] ++ ;
#endif
if ( vr_99 <= vr_108 )
{
tp_1 vr_81 = vr_99 ;
if ( ( vr_99 & 1 ) == 0 )
vr_81 /= 2 ;
vr_81 /= fn_7 ( vr_81 , vr_110 ) ;
if ( vr_81 <= vr_107 )
{
if ( vr_111 >= vl_14 )
error ( vl_17 , 0 , _ ( lr_5 ) ) ;
vr_100 [ vr_111 ] . vr_99 = vr_81 ;
vr_100 [ vr_111 ] . vr_80 = vr_80 % vr_81 ;
vr_111 ++ ;
}
}
vr_12 = vr_106 + vr_42 * ( vr_80 - vr_87 ) ;
vr_106 = vr_99 ;
vr_99 = vr_12 ;
vr_80 = vr_87 ;
if ( ( vr_9 & 1 ) == 0 )
{
tp_1 vr_75 = fn_78 ( vr_99 ) ;
if ( vr_75 )
{
unsigned int vr_22 ;
for ( vr_22 = 0 ; vr_22 < vr_111 ; vr_22 ++ )
{
if ( vr_100 [ vr_22 ] . vr_99 == vr_75 )
{
if ( vr_75 == 1 )
goto lb_4;
if ( vr_80 >= vr_100 [ vr_22 ] . vr_80 )
vr_12 = vr_80 - vr_100 [ vr_22 ] . vr_80 ;
else
vr_12 = vr_100 [ vr_22 ] . vr_80 - vr_80 ;
if ( vr_12 % vr_75 == 0 )
{
memmove ( vr_100 , vr_100 + vr_22 + 1 ,
( vr_111 - vr_22 - 1 ) * sizeof ( vr_100 [ 0 ] ) ) ;
vr_111 -= ( vr_22 + 1 ) ;
}
goto lb_5;
}
}
vr_106 = vr_75 ;
assert ( vr_103 >= vr_80 ) ;
vr_80 += vr_75 * ( ( vr_103 - vr_80 ) / vr_75 ) ;
tp_1 vr_38 , vr_39 ;
fn_30 ( vr_38 , vr_39 , vr_80 , vr_80 ) ;
fn_5 ( vr_38 , vr_39 , vr_104 , vr_105 , vr_38 , vr_39 ) ;
fn_52 ( vr_99 , vr_112 , vr_38 , vr_39 , vr_106 ) ;
assert ( vr_112 == 0 ) ;
for (; ; )
{
fn_80 ( vr_42 , vr_112 , vr_103 + vr_80 , vr_99 ) ;
vr_87 = vr_103 - vr_112 ;
#if vl_15
vr_113 [ 0 ] ++ ;
vr_113 [ fn_81 ( vr_42 , vl_16 ) ] ++ ;
#endif
if ( vr_80 == vr_87 )
break;
vr_12 = vr_106 + vr_42 * ( vr_80 - vr_87 ) ;
vr_106 = vr_99 ;
vr_99 = vr_12 ;
vr_80 = vr_87 ;
}
if ( ( vr_99 & 1 ) == 0 )
vr_99 /= 2 ;
vr_99 /= fn_7 ( vr_99 , vr_110 ) ;
assert ( vr_99 > 1 && ( vr_65 || vr_99 < vr_66 ) ) ;
if ( fn_48 ( vr_99 ) )
fn_13 ( vr_16 , vr_99 ) ;
else if ( ! fn_79 ( 0 , vr_99 , vr_16 ) )
fn_66 ( vr_99 , 2 , vr_16 ) ;
fn_56 ( vr_65 , vr_66 , vr_65 , vr_66 , vr_99 ) ;
if ( fn_53 ( vr_65 , vr_66 ) )
fn_12 ( vr_16 , vr_65 , vr_66 ) ;
else
{
if ( ! fn_79 ( vr_65 , vr_66 , vr_16 ) )
{
if ( vr_65 == 0 )
fn_66 ( vr_66 , 1 , vr_16 ) ;
else
fn_68 ( vr_65 , vr_66 , 1 , vr_16 ) ;
}
}
return true ;
}
}
lb_5: ;
}
lb_4: ;
}
return false ;
}
static void
fn_51 ( tp_1 vr_34 , tp_1 vr_35 , struct vr_16 * vr_16 )
{
vr_16 -> vr_19 = 0 ;
vr_16 -> vr_25 [ 1 ] = 0 ;
if ( vr_34 == 0 && vr_35 < 2 )
return;
vr_35 = fn_28 ( & vr_34 , vr_34 , vr_35 , vr_16 ) ;
if ( vr_34 == 0 && vr_35 < 2 )
return;
if ( fn_53 ( vr_34 , vr_35 ) )
fn_12 ( vr_16 , vr_34 , vr_35 ) ;
else
{
if ( vl_18 == vl_19 )
if ( fn_79 ( vr_34 , vr_35 , vr_16 ) )
return;
if ( vr_34 == 0 )
fn_66 ( vr_35 , 1 , vr_16 ) ;
else
fn_68 ( vr_34 , vr_35 , 1 , vr_16 ) ;
}
}
static void
fn_62 ( tp_3 vr_12 , struct vr_28 * vr_16 )
{
fn_16 ( vr_16 ) ;
if ( fn_82 ( vr_12 ) != 0 )
{
fn_32 ( vr_12 , vr_16 ) ;
if ( fn_36 ( vr_12 , 1 ) != 0 )
{
fn_26 ( lr_6 ) ;
if ( fn_57 ( vr_12 ) )
fn_19 ( vr_16 , vr_12 ) ;
else
fn_70 ( vr_12 , 1 , vr_16 ) ;
}
}
}
static tp_9
fn_83 ( tp_1 * vr_114 , tp_1 * vr_115 , const char * vr_116 )
{
unsigned int vr_117 ;
tp_1 vr_38 = 0 , vr_39 = 0 ;
tp_9 vr_118 = vl_20 ;
for (; ; )
{
char vr_93 = * vr_116 ;
if ( vr_93 == ' ' )
vr_116 ++ ;
else if ( vr_93 == '+' )
{
vr_116 ++ ;
break;
}
else
break;
}
const char * vr_20 = vr_116 ;
for (; ; )
{
unsigned int vr_93 = * vr_20 ++ ;
if ( vr_93 == 0 ) MST[EQ$@1$@2$!CONSTVAL$1$]MSP[N]
break;
if ( fn_84 ( ! ISDIGIT ( vr_93 ) ) )
{
vr_118 = vl_20 ;
break;
}
vr_118 = vl_21 ;
}
for (; vr_118 == vl_21 ; )
{
unsigned int vr_93 = * vr_116 ++ ;
if ( vr_93 == 0 )
break;
vr_93 -= '0' ;
if ( fn_84 ( vr_38 > ~ ( tp_1 ) 0 / 10 ) )
{
vr_118 = vl_22 ;
break;
}
vr_38 = 10 * vr_38 ;
vr_117 = ( vr_39 >> ( vl_3 - 3 ) ) + ( vr_39 >> ( vl_3 - 1 ) ) ;
vr_117 += 10 * vr_39 < 2 * vr_39 ;
vr_39 = 10 * vr_39 ;
vr_39 += vr_93 ;
vr_117 += vr_39 < vr_93 ;
vr_38 += vr_117 ;
if ( fn_84 ( vr_38 < vr_117 ) )
{
vr_118 = vl_22 ;
break;
}
}
* vr_114 = vr_38 ;
* vr_115 = vr_39 ;
return vr_118 ;
}
static void
fn_85 ( tp_1 vr_34 , tp_1 vr_35 )
{
tp_1 vr_42 , vr_75 ;
if ( vr_34 == 0 )
printf ( lr_7 vl_23 , vr_35 ) ;
else
{
vr_42 = vr_34 / 1000000000 ;
vr_75 = vr_34 % 1000000000 ;
fn_52 ( vr_35 , vr_75 , vr_75 , vr_35 , 1000000000 ) ;
fn_85 ( vr_42 , vr_35 ) ;
printf ( lr_8 , ( int ) vr_75 ) ;
}
}
static void
fn_86 ( tp_1 vr_34 , tp_1 vr_35 )
{
struct vr_16 vr_16 ;
fn_85 ( vr_34 , vr_35 ) ;
putchar ( ':' ) ;
fn_51 ( vr_34 , vr_35 , & vr_16 ) ;
unsigned int vr_22 ;
unsigned int vr_67 ;
for ( vr_22 = 0 ; vr_22 < vr_16 . vr_19 ; vr_22 ++ )
for ( vr_67 = 0 ; vr_67 < vr_16 . vr_21 [ vr_22 ] ; vr_67 ++ )
{
char vr_119 [ fn_87 ( tp_1 ) ] ;
putchar ( ' ' ) ;
fputs ( fn_88 ( vr_16 . vr_20 [ vr_22 ] , vr_119 ) , stdout ) ;
}
if ( vr_16 . vr_25 [ 1 ] )
{
putchar ( ' ' ) ;
fn_85 ( vr_16 . vr_25 [ 1 ] , vr_16 . vr_25 [ 0 ] ) ;
}
putchar ( '\n' ) ;
}
static bool
fn_89 ( const char * vr_120 )
{
tp_1 vr_34 , vr_35 ;
tp_9 vr_118 = fn_83 ( & vr_34 , & vr_35 , vr_120 ) ;
switch ( vr_118 )
{
case vl_21 :
if ( ( ( vr_34 << 1 ) >> 1 ) == vr_34 )
{
fn_26 ( lr_9 ) ;
fn_86 ( vr_34 , vr_35 ) ;
return true ;
}
break;
case vl_22 :
break;
default:
error ( 0 , 0 , _ ( lr_10 ) , fn_90 ( vr_120 ) ) ;
return false ;
}
#if vl_24
fn_26 ( lr_11 ) ;
tp_3 vr_12 ;
struct vr_28 vr_16 ;
fn_91 ( vr_12 , vr_120 , 10 ) ;
fn_92 ( lr_12 , vr_12 ) ;
fn_62 ( vr_12 , & vr_16 ) ;
unsigned int vr_22 ;
unsigned int vr_67 ;
for ( vr_22 = 0 ; vr_22 < vr_16 . vr_19 ; vr_22 ++ )
for ( vr_67 = 0 ; vr_67 < vr_16 . vr_21 [ vr_22 ] ; vr_67 ++ )
fn_92 ( lr_13 , vr_16 . vr_20 [ vr_22 ] ) ;
fn_17 ( & vr_16 ) ;
fn_18 ( vr_12 ) ;
putchar ( '\n' ) ;
return true ;
#else
error ( 0 , 0 , _ ( lr_14 ) , fn_90 ( vr_120 ) ) ;
return false ;
#endif
}
void
fn_93 ( int vr_121 )
{
if ( vr_121 != vl_25 )
fn_94 () ;
else
{
printf ( _ ( lr_15 ) ,
vl_26 , vl_26 ) ;
fputs ( _ ( lr_16 ) , stdout ) ;
fputs ( vl_27 , stdout ) ;
fputs ( vl_28 , stdout ) ;
fn_95 () ;
}
exit ( vr_121 ) ;
}
static bool
fn_96 ( void )
{
bool vr_122 = true ;
tp_10 vr_123 ;
fn_97 ( & vr_123 ) ;
while ( true )
{
tp_11 vr_124 = fn_98 ( vl_29 , vl_30 , sizeof ( vl_30 ) - 1 ,
& vr_123 ) ;
if ( vr_124 == ( tp_11 ) - 1 )
break;
vr_122 &= fn_89 ( vr_123 . vr_125 ) ;
}
free ( vr_123 . vr_125 ) ;
return vr_122 ;
}
int
main ( int vr_126 , char * * vr_127 )
{
fn_99 ( & vr_126 , & vr_127 ) ;
fn_100 ( vr_127 [ 0 ] ) ;
setlocale ( vl_31 , lr_17 ) ;
fn_101 ( vl_32 , vl_33 ) ;
fn_102 ( vl_32 ) ;
atexit ( vl_34 ) ;
vl_18 = vl_35 ;
int vr_93 ;
while ( ( vr_93 = fn_103 ( vr_126 , vr_127 , lr_17 , vl_36 , NULL ) ) != - 1 )
{
switch ( vr_93 )
{
case vl_37 :
vl_1 = true ;
break;
case 's' :
vl_18 = vl_19 ;
break;
case 'w' :
vl_8 = false ;
break;
vl_38 ;
fn_104 ( vl_39 , vl_40 ) ;
default:
fn_93 ( vl_17 ) ;
}
}
#if vl_15
if ( vl_18 == vl_19 )
memset ( vr_113 , 0 , sizeof ( vr_113 ) ) ;
#endif
bool vr_122 ;
if ( vr_126 <= vl_41 )
vr_122 = fn_96 () ;
else
{
vr_122 = true ;
int vr_9 ;
for ( vr_9 = vl_41 ; vr_9 < vr_126 ; vr_9 ++ )
if ( ! fn_89 ( vr_127 [ vr_9 ] ) )
vr_122 = false ;
}
#if vl_15
if ( vl_18 == vl_19 && vr_113 [ 0 ] > 0 )
{
double vr_128 ;
printf ( lr_18 , vr_113 [ 0 ] ) ;
unsigned int vr_9 ;
for ( vr_9 = 1 , vr_128 = 0.0 ; vr_9 <= vl_16 ; vr_9 ++ )
{
double vr_102 = ( double ) vr_113 [ vr_9 ] / vr_113 [ 0 ] ;
vr_128 += vr_102 ;
printf ( lr_19 , vr_9 == vl_16 ? lr_20 : lr_17 , vr_9 ,
100.0 * vr_102 , 100.0 * vr_128 ) ;
}
}
#endif
exit ( vr_122 ? vl_25 : vl_17 ) ;
}
