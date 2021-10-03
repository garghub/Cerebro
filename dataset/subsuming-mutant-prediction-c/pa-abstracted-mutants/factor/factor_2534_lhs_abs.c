static uintmax_t
mod2 ( uintmax_t * r1 , uintmax_t a1 , uintmax_t a0 , uintmax_t d1 , uintmax_t d0 )
{
int cntd , cnta ;
assert ( d1 != 0 ) ;
if ( a1 == 0 )
{
* r1 = 0 ;
return a0 ;
}
count_leading_zeros ( cntd , d1 ) ;
count_leading_zeros ( cnta , a1 ) ;
int cnt = cntd - cnta ;
lsh2 ( d1 , d0 , d1 , d0 , cnt ) ;
int i ;
for ( i = 0 ; i < cnt ; i ++ )
{
if ( ge2 ( a1 , a0 , d1 , d0 ) )
sub_ddmmss ( a1 , a0 , a1 , a0 , d1 , d0 ) ;
rsh2 ( d1 , d0 , d1 , d0 , 1 ) ;
}
* r1 = a1 ;
return a0 ;
}
static uintmax_t _GL_ATTRIBUTE_CONST
gcd_odd ( uintmax_t a , uintmax_t b )
{
if ( ( b & 1 ) == 0 )
{
uintmax_t t = b ;
b = a ;
a = t ;
}
if ( a == 0 )
return b ;
b >>= 1 ;
for (; ; )
{
uintmax_t t ;
uintmax_t bgta ;
while ( ( a & 1 ) == 0 )
a >>= 1 ;
a >>= 1 ;
t = a - b ;
if ( t == 0 )
return ( a << 1 ) + 1 ;
bgta = HIGHBIT_TO_MASK ( t ) ;
b += ( bgta & t ) ;
a = ( t ^ bgta ) - bgta ;
}
}
static uintmax_t
gcd2_odd ( uintmax_t * r1 , uintmax_t a1 , uintmax_t a0 , uintmax_t b1 , uintmax_t b0 )
{
while ( ( a0 & 1 ) == 0 )
rsh2 ( a1 , a0 , a1 , a0 , 1 ) ;
while ( ( b0 & 1 ) == 0 )
rsh2 ( b1 , b0 , b1 , b0 , 1 ) ;
for (; ; )
{
if ( ( b1 | a1 ) == 0 )
{
* r1 = 0 ;
return gcd_odd ( b0 , a0 ) ;
}
if ( gt2 ( a1 , a0 , b1 , b0 ) )
{
sub_ddmmss ( a1 , a0 , a1 , a0 , b1 , b0 ) ;
do
rsh2 ( a1 , a0 , a1 , a0 , 1 ) ;
while ( ( a0 & 1 ) == 0 );
}
else if ( gt2 ( b1 , b0 , a1 , a0 ) )
{
sub_ddmmss ( b1 , b0 , b1 , b0 , a1 , a0 ) ;
do
rsh2 ( b1 , b0 , b1 , b0 , 1 ) ;
while ( ( b0 & 1 ) == 0 );
}
else
break;
}
* r1 = a1 ;
return a0 ;
}
static void
factor_insert_multiplicity ( struct factors * factors ,
uintmax_t prime , unsigned int m )
{
unsigned int nfactors = factors -> nfactors ;
uintmax_t * p = factors -> p ;
unsigned char * e = factors -> e ;
int i ;
for ( i = nfactors - 1 ; i >= 0 ; i -- )
{
if ( p [ i ] <= prime )
break;
}
if ( i < 0 || p [ i ] != prime )
{
int j ;
for ( j = nfactors - 1 ; j > i ; j -- )
{
p [ j + 1 ] = p [ j ] ;
e [ j + 1 ] = e [ j ] ;
}
p [ i + 1 ] = prime ;
e [ i + 1 ] = m ;
factors -> nfactors = nfactors + 1 ;
}
else
{
e [ i ] += m ;
}
}
static void
factor_insert_large ( struct factors * factors ,
uintmax_t p1 , uintmax_t p0 )
{
if ( p1 > 0 )
{
assert ( factors -> plarge [ 1 ] == 0 ) ;
factors -> plarge [ 0 ] = p0 ;
factors -> plarge [ 1 ] = p1 ;
}
else
factor_insert ( factors , p0 ) ;
}
static void
mpz_va_init ( void (* mpz_single_init)( mpz_t ) , ... )
{
va_list ap ;
va_start ( ap , mpz_single_init ) ;
mpz_t * mpz ;
while ( ( mpz = va_arg ( ap , mpz_t * ) ) )
mpz_single_init ( * mpz ) ;
va_end ( ap ) ;
}
static void
mp_factor_init ( struct mp_factors * factors )
{
factors -> p = NULL ;
factors -> e = NULL ;
factors -> nfactors = 0 ;
}
static void
mp_factor_clear ( struct mp_factors * factors )
{
unsigned int i ;
for ( i = 0 ; i < factors -> nfactors ; i ++ )
mpz_clear ( factors -> p [ i ] ) ;
free ( factors -> p ) ;
free ( factors -> e ) ;
}
static void
mp_factor_insert ( struct mp_factors * factors , mpz_t prime )
{
unsigned long int nfactors = factors -> nfactors ;
mpz_t * p = factors -> p ;
unsigned long int * e = factors -> e ;
long i ;
for ( i = nfactors - 1 ; i >= 0 ; i -- )
{
if ( mpz_cmp ( p [ i ] , prime ) <= 0 )
break;
}
if ( i < 0 || mpz_cmp ( p [ i ] , prime ) != 0 )
{
p = xrealloc ( p , ( nfactors + 1 ) * sizeof p [ 0 ] ) ;
e = xrealloc ( e , ( nfactors + 1 ) * sizeof e [ 0 ] ) ;
mpz_init ( p [ nfactors ] ) ;
long j ;
for ( j = nfactors - 1 ; j > i ; j -- )
{
mpz_set ( p [ j + 1 ] , p [ j ] ) ;
e [ j + 1 ] = e [ j ] ;
}
mpz_set ( p [ i + 1 ] , prime ) ;
e [ i + 1 ] = 1 ;
factors -> p = p ;
factors -> e = e ;
factors -> nfactors = nfactors + 1 ;
}
else
{
e [ i ] += 1 ;
}
}
static void
mp_factor_insert_ui ( struct mp_factors * factors , unsigned long int prime )
{
mpz_t pz ;
mpz_init_set_ui ( pz , prime ) ;
mp_factor_insert ( factors , pz ) ;
mpz_clear ( pz ) ;
}
static inline void
devmsg ( char const * fmt , ... )
{
if ( dev_debug )
{
va_list ap ;
va_start ( ap , fmt ) ;
vfprintf ( stderr , fmt , ap ) ;
va_end ( ap ) ;
}
}
static void
factor_insert_refind ( struct factors * factors , uintmax_t p , unsigned int i ,
unsigned int off )
{
unsigned int j ;
for ( j = 0 ; j < off ; j ++ )
p += primes_diff [ i + j ] ;
factor_insert ( factors , p ) ;
}
static uintmax_t
factor_using_division ( uintmax_t * t1p , uintmax_t t1 , uintmax_t t0 ,
struct factors * factors )
{
if ( t0 % 2 == 0 )
{
unsigned int cnt ;
if ( t0 == 0 )
{
count_trailing_zeros ( cnt , t1 ) ;
t0 = t1 >> cnt ;
t1 = 0 ;
cnt += W_TYPE_SIZE ;
}
else
{
count_trailing_zeros ( cnt , t0 ) ;
rsh2 ( t1 , t0 , t1 , t0 , cnt ) ;
}
factor_insert_multiplicity ( factors , 2 , cnt ) ;
}
uintmax_t p = 3 ;
unsigned int i ;
for ( i = 0 ; t1 > 0 && i < PRIMES_PTAB_ENTRIES ; i ++ )
{
for (; ; )
{
uintmax_t q1 , q0 , hi , lo _GL_UNUSED ;
q0 = t0 * primes_dtab [ i ] . binv ;
umul_ppmm ( hi , lo , q0 , p ) ;
if ( hi > t1 )
break;
hi = t1 - hi ;
q1 = hi * primes_dtab [ i ] . binv ;
if ( LIKELY ( q1 > primes_dtab [ i ] . lim ) )
break;
t1 = q1 ; t0 = q0 ;
factor_insert ( factors , p ) ;
}
p += primes_diff [ i + 1 ] ;
}
if ( t1p )
* t1p = t1 ;
#define DIVBLOCK ( I ) \
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
for (; i < PRIMES_PTAB_ENTRIES ; i += 8 )
{
uintmax_t q ;
const struct primes_dtab * pd = & primes_dtab [ i ] ;
DIVBLOCK ( 0 ) ;
DIVBLOCK ( 1 ) ;
DIVBLOCK ( 2 ) ;
DIVBLOCK ( 3 ) ;
DIVBLOCK ( 4 ) ;
DIVBLOCK ( 5 ) ;
DIVBLOCK ( 6 ) ;
DIVBLOCK ( 7 ) ;
p += primes_diff8 [ i ] ;
if ( p * p > t0 )
break;
}
return t0 ;
}
static void
mp_factor_using_division ( mpz_t t , struct mp_factors * factors )
{
mpz_t q ;
unsigned long int p ;
devmsg ( lr_1 ) ;
mpz_init ( q ) ;
p = mpz_scan1 ( t , 0 ) ;
mpz_div_2exp ( t , t , p ) ;
while ( p )
{
mp_factor_insert_ui ( factors , 2 ) ;
-- p ;
}
p = 3 ;
unsigned int i ;
for ( i = 1 ; i <= PRIMES_PTAB_ENTRIES ; )
{
if ( ! mpz_divisible_ui_p ( t , p ) )
{
p += primes_diff [ i ++ ] ;
if ( mpz_cmp_ui ( t , p * p ) < 0 )
break;
}
else
{
mpz_tdiv_q_ui ( t , t , p ) ;
mp_factor_insert_ui ( factors , p ) ;
}
}
mpz_clear ( q ) ;
}
static inline uintmax_t
mulredc ( uintmax_t a , uintmax_t b , uintmax_t m , uintmax_t mi )
{
uintmax_t rh , rl , q , th , tl _GL_UNUSED , xh ;
umul_ppmm ( rh , rl , a , b ) ;
q = rl * mi ;
umul_ppmm ( th , tl , q , m ) ;
xh = rh - th ;
if ( rh < th )
xh += m ;
return xh ;
}
static uintmax_t
mulredc2 ( uintmax_t * r1p ,
uintmax_t a1 , uintmax_t a0 , uintmax_t b1 , uintmax_t b0 ,
uintmax_t m1 , uintmax_t m0 , uintmax_t mi )
{
uintmax_t r1 , r0 , q , p1 , p0 _GL_UNUSED , t1 , t0 , s1 , s0 ;
mi = - mi ;
assert ( ( a1 >> ( W_TYPE_SIZE - 1 ) ) == 0 ) ;
assert ( ( b1 >> ( W_TYPE_SIZE - 1 ) ) == 0 ) ;
assert ( ( m1 >> ( W_TYPE_SIZE - 1 ) ) == 0 ) ;
umul_ppmm ( t1 , t0 , a0 , b0 ) ;
umul_ppmm ( r1 , r0 , a0 , b1 ) ;
q = mi * t0 ;
umul_ppmm ( p1 , p0 , q , m0 ) ;
umul_ppmm ( s1 , s0 , q , m1 ) ;
r0 += ( t0 != 0 ) ;
add_ssaaaa ( r1 , r0 , r1 , r0 , 0 , p1 ) ;
add_ssaaaa ( r1 , r0 , r1 , r0 , 0 , t1 ) ;
add_ssaaaa ( r1 , r0 , r1 , r0 , s1 , s0 ) ;
umul_ppmm ( t1 , t0 , a1 , b0 ) ;
umul_ppmm ( s1 , s0 , a1 , b1 ) ;
add_ssaaaa ( t1 , t0 , t1 , t0 , 0 , r0 ) ;
q = mi * t0 ;
add_ssaaaa ( r1 , r0 , s1 , s0 , 0 , r1 ) ;
umul_ppmm ( p1 , p0 , q , m0 ) ;
umul_ppmm ( s1 , s0 , q , m1 ) ;
r0 += ( t0 != 0 ) ;
add_ssaaaa ( r1 , r0 , r1 , r0 , 0 , p1 ) ;
add_ssaaaa ( r1 , r0 , r1 , r0 , 0 , t1 ) ;
add_ssaaaa ( r1 , r0 , r1 , r0 , s1 , s0 ) ;
if ( ge2 ( r1 , r0 , m1 , m0 ) )
sub_ddmmss ( r1 , r0 , r1 , r0 , m1 , m0 ) ;
* r1p = r1 ;
return r0 ;
}
static uintmax_t _GL_ATTRIBUTE_CONST
powm ( uintmax_t b , uintmax_t e , uintmax_t n , uintmax_t ni , uintmax_t one )
{
uintmax_t y = one ;
if ( e & 1 )
y = b ;
while ( e != 0 )
{
b = mulredc ( b , b , n , ni ) ;
e >>= 1 ;
if ( e & 1 )
y = mulredc ( y , b , n , ni ) ;
}
return y ;
}
static uintmax_t
powm2 ( uintmax_t * r1m ,
const uintmax_t * bp , const uintmax_t * ep , const uintmax_t * np ,
uintmax_t ni , const uintmax_t * one )
{
uintmax_t r1 , r0 , b1 , b0 , n1 , n0 ;
unsigned int i ;
uintmax_t e ;
b0 = bp [ 0 ] ;
b1 = bp [ 1 ] ;
n0 = np [ 0 ] ;
n1 = np [ 1 ] ;
r0 = one [ 0 ] ;
r1 = one [ 1 ] ;
for ( e = ep [ 0 ] , i = W_TYPE_SIZE ; i > 0 ; i -- , e >>= 1 )
{
if ( e & 1 )
{
r0 = mulredc2 ( r1m , r1 , r0 , b1 , b0 , n1 , n0 , ni ) ;
r1 = * r1m ;
}
b0 = mulredc2 ( r1m , b1 , b0 , b1 , b0 , n1 , n0 , ni ) ;
b1 = * r1m ;
}
for ( e = ep [ 1 ] ; e > 0 ; e >>= 1 )
{
if ( e & 1 )
{
r0 = mulredc2 ( r1m , r1 , r0 , b1 , b0 , n1 , n0 , ni ) ;
r1 = * r1m ;
}
b0 = mulredc2 ( r1m , b1 , b0 , b1 , b0 , n1 , n0 , ni ) ;
b1 = * r1m ;
}
* r1m = r1 ;
return r0 ;
}
static bool _GL_ATTRIBUTE_CONST
millerrabin ( uintmax_t n , uintmax_t ni , uintmax_t b , uintmax_t q ,
unsigned int k , uintmax_t one )
{
uintmax_t y = powm ( b , q , n , ni , one ) ;
uintmax_t nm1 = n - one ;
if ( y == one || y == nm1 )
return true ;
unsigned int i ;
for ( i = 1 ; i < k ; i ++ )
{
y = mulredc ( y , y , n , ni ) ;
if ( y == nm1 )
return true ;
if ( y == one )
return false ;
}
return false ;
}
static bool
millerrabin2 ( const uintmax_t * np , uintmax_t ni , const uintmax_t * bp ,
const uintmax_t * qp , unsigned int k , const uintmax_t * one )
{
uintmax_t y1 , y0 , nm1_1 , nm1_0 , r1m ;
y0 = powm2 ( & r1m , bp , qp , np , ni , one ) ;
y1 = r1m ;
if ( y0 == one [ 0 ] && y1 == one [ 1 ] )
return true ;
sub_ddmmss ( nm1_1 , nm1_0 , np [ 1 ] , np [ 0 ] , one [ 1 ] , one [ 0 ] ) ;
if ( y0 == nm1_0 && y1 == nm1_1 )
return true ;
unsigned int i ;
for ( i = 1 ; i < k ; i ++ )
{
y0 = mulredc2 ( & r1m , y1 , y0 , y1 , y0 , np [ 1 ] , np [ 0 ] , ni ) ;
y1 = r1m ;
if ( y0 == nm1_0 && y1 == nm1_1 )
return true ;
if ( y0 == one [ 0 ] && y1 == one [ 1 ] )
return false ;
}
return false ;
}
static bool
mp_millerrabin ( mpz_srcptr n , mpz_srcptr nm1 , mpz_ptr x , mpz_ptr y ,
mpz_srcptr q , unsigned long int k )
{
mpz_powm ( y , x , q , n ) ;
if ( mpz_cmp_ui ( y , 1 ) == 0 || mpz_cmp ( y , nm1 ) == 0 )
return true ;
unsigned long int i ;
for ( i = 1 ; i < k ; i ++ )
{
mpz_powm_ui ( y , y , 2 , n ) ;
if ( mpz_cmp ( y , nm1 ) == 0 )
return true ;
if ( mpz_cmp_ui ( y , 1 ) == 0 )
return false ;
}
return false ;
}
static bool
prime_p ( uintmax_t n )
{
int k ;
bool is_prime ;
uintmax_t a_prim , one , ni ;
struct factors factors ;
if ( n <= 1 )
return false ;
if ( n < ( uintmax_t ) FIRST_OMITTED_PRIME * FIRST_OMITTED_PRIME )
return true ;
uintmax_t q = n - 1 ;
for ( k = 0 ; ( q & 1 ) == 0 ; k ++ )
q >>= 1 ;
uintmax_t a = 2 ;
binv ( ni , n ) ;
redcify ( one , 1 , n ) ;
addmod ( a_prim , one , one , n ) ;
if ( ! millerrabin ( n , ni , a_prim , q , k , one ) )
return false ;
if ( flag_prove_primality )
{
factor ( 0 , n - 1 , & factors ) ;
}
unsigned int r ;
for ( r = 0 ; r < PRIMES_PTAB_ENTRIES ; r ++ )
{
if ( flag_prove_primality )
{
is_prime = true ;
unsigned int i ;
for ( i = 0 ; i < factors . nfactors && is_prime ; i ++ )
{
is_prime
= powm ( a_prim , ( n - 1 ) / factors . p [ i ] , n , ni , one ) != one ;
}
}
else
{
is_prime = ( r == MR_REPS - 1 ) ;
}
if ( is_prime )
return true ;
a += primes_diff [ r ] ;
{
uintmax_t s1 , s0 ;
umul_ppmm ( s1 , s0 , one , a ) ;
if ( LIKELY ( s1 == 0 ) )
a_prim = s0 % n ;
else
{
uintmax_t dummy _GL_UNUSED ;
udiv_qrnnd ( dummy , a_prim , s1 , s0 , n ) ;
}
}
if ( ! millerrabin ( n , ni , a_prim , q , k , one ) )
return false ;
}
error ( 0 , 0 , _ ( lr_2 ) ) ;
abort () ;
}
static bool
prime2_p ( uintmax_t n1 , uintmax_t n0 )
{
uintmax_t q [ 2 ] , nm1 [ 2 ] ;
uintmax_t a_prim [ 2 ] ;
uintmax_t one [ 2 ] ;
uintmax_t na [ 2 ] ;
uintmax_t ni ;
unsigned int k ;
struct factors factors ;
if ( n1 == 0 )
return prime_p ( n0 ) ;
nm1 [ 1 ] = n1 - ( n0 == 0 ) ;
nm1 [ 0 ] = n0 - 1 ;
if ( nm1 [ 0 ] == 0 )
{
count_trailing_zeros ( k , nm1 [ 1 ] ) ;
q [ 0 ] = nm1 [ 1 ] >> k ;
q [ 1 ] = 0 ;
k += W_TYPE_SIZE ;
}
else
{
count_trailing_zeros ( k , nm1 [ 0 ] ) ;
rsh2 ( q [ 1 ] , q [ 0 ] , nm1 [ 1 ] , nm1 [ 0 ] , k ) ;
}
uintmax_t a = 2 ;
binv ( ni , n0 ) ;
redcify2 ( one [ 1 ] , one [ 0 ] , 1 , n1 , n0 ) ;
addmod2 ( a_prim [ 1 ] , a_prim [ 0 ] , one [ 1 ] , one [ 0 ] , one [ 1 ] , one [ 0 ] , n1 , n0 ) ;
na [ 0 ] = n0 ;
na [ 1 ] = n1 ;
if ( ! millerrabin2 ( na , ni , a_prim , q , k , one ) )
return false ;
if ( flag_prove_primality )
{
factor ( nm1 [ 1 ] , nm1 [ 0 ] , & factors ) ;
}
unsigned int r ;
for ( r = 0 ; r < PRIMES_PTAB_ENTRIES ; r ++ )
{
bool is_prime ;
uintmax_t e [ 2 ] , y [ 2 ] ;
if ( flag_prove_primality )
{
is_prime = true ;
if ( factors . plarge [ 1 ] )
{
uintmax_t pi ;
binv ( pi , factors . plarge [ 0 ] ) ;
e [ 0 ] = pi * nm1 [ 0 ] ;
e [ 1 ] = 0 ;
y [ 0 ] = powm2 ( & y [ 1 ] , a_prim , e , na , ni , one ) ;
is_prime = ( y [ 0 ] != one [ 0 ] || y [ 1 ] != one [ 1 ] ) ;
}
unsigned int i ;
for ( i = 0 ; i < factors . nfactors && is_prime ; i ++ )
{
if ( factors . p [ i ] == 2 )
rsh2 ( e [ 1 ] , e [ 0 ] , nm1 [ 1 ] , nm1 [ 0 ] , 1 ) ;
else
divexact_21 ( e [ 1 ] , e [ 0 ] , nm1 [ 1 ] , nm1 [ 0 ] , factors . p [ i ] ) ;
y [ 0 ] = powm2 ( & y [ 1 ] , a_prim , e , na , ni , one ) ;
is_prime = ( y [ 0 ] != one [ 0 ] || y [ 1 ] != one [ 1 ] ) ;
}
}
else
{
is_prime = ( r == MR_REPS - 1 ) ;
}
if ( is_prime )
return true ;
a += primes_diff [ r ] ;
redcify2 ( a_prim [ 1 ] , a_prim [ 0 ] , a , n1 , n0 ) ;
if ( ! millerrabin2 ( na , ni , a_prim , q , k , one ) )
return false ;
}
error ( 0 , 0 , _ ( lr_2 ) ) ;
abort () ;
}
static bool
mp_prime_p ( mpz_t n )
{
bool is_prime ;
mpz_t q , a , nm1 , tmp ;
struct mp_factors factors ;
if ( mpz_cmp_ui ( n , 1 ) <= 0 )
return false ;
if ( mpz_cmp_ui ( n , ( long ) FIRST_OMITTED_PRIME * FIRST_OMITTED_PRIME ) < 0 )
return true ;
mpz_inits ( q , a , nm1 , tmp , NULL ) ;
mpz_sub_ui ( nm1 , n , 1 ) ;
unsigned long int k = mpz_scan1 ( nm1 , 0 ) ;
mpz_tdiv_q_2exp ( q , nm1 , k ) ;
mpz_set_ui ( a , 2 ) ;
if ( ! mp_millerrabin ( n , nm1 , a , tmp , q , k ) )
{
is_prime = false ;
goto ret2;
}
if ( flag_prove_primality )
{
mpz_set ( tmp , nm1 ) ;
mp_factor ( tmp , & factors ) ;
}
unsigned int r ;
for ( r = 0 ; r < PRIMES_PTAB_ENTRIES ; r ++ )
{
if ( flag_prove_primality )
{
is_prime = true ;
unsigned long int i ;
for ( i = 0 ; i < factors . nfactors && is_prime ; i ++ )
{
mpz_divexact ( tmp , nm1 , factors . p [ i ] ) ;
mpz_powm ( tmp , a , tmp , n ) ;
is_prime = mpz_cmp_ui ( tmp , 1 ) != 0 ;
}
}
else
{
is_prime = ( r == MR_REPS - 1 ) ;
}
if ( is_prime )
goto ret1;
mpz_add_ui ( a , a , primes_diff [ r ] ) ;
if ( ! mp_millerrabin ( n , nm1 , a , tmp , q , k ) )
{
is_prime = false ;
goto ret1;
}
}
error ( 0 , 0 , _ ( lr_2 ) ) ;
abort () ;
ret1:
if ( flag_prove_primality )
mp_factor_clear ( & factors ) ;
ret2:
mpz_clears ( q , a , nm1 , tmp , NULL ) ;
return is_prime ;
}
static void
factor_using_pollard_rho ( uintmax_t n , unsigned long int a ,
struct factors * factors )
{
uintmax_t x , z , y , P , t , ni , g ;
unsigned long int k = 1 ;
unsigned long int l = 1 ;
redcify ( P , 1 , n ) ;
addmod ( x , P , P , n ) ;
y = z = x ;
while ( n != 1 )
{
assert ( a < n ) ;
binv ( ni , n ) ;
for (; ; )
{
do
{
x = mulredc ( x , x , n , ni ) ;
addmod ( x , x , a , n ) ;
submod ( t , z , x , n ) ;
P = mulredc ( P , t , n , ni ) ;
if ( k % 32 == 1 )
{
if ( gcd_odd ( P , n ) != 1 )
goto factor_found;
y = x ;
}
}
while ( -- k != 0 );
z = x ;
k = l ;
l = 2 * l ;
unsigned long int i ;
for ( i = 0 ; i < k ; i ++ )
{
x = mulredc ( x , x , n , ni ) ;
addmod ( x , x , a , n ) ;
}
y = x ;
}
factor_found:
do
{
y = mulredc ( y , y , n , ni ) ;
addmod ( y , y , a , n ) ;
submod ( t , z , y , n ) ;
g = gcd_odd ( t , n ) ;
}
while ( g == 1 );
n = n / g ;
if ( ! prime_p ( g ) )
factor_using_pollard_rho ( g , a + 1 , factors ) ;
else
factor_insert ( factors , g ) ;
if ( prime_p ( n ) )
{
factor_insert ( factors , n ) ;
break;
}
x = x % n ;
z = z % n ;
y = y % n ;
}
}
static void
factor_using_pollard_rho2 ( uintmax_t n1 , uintmax_t n0 , unsigned long int a ,
struct factors * factors )
{
uintmax_t x1 , x0 , z1 , z0 , y1 , y0 , P1 , P0 , t1 , t0 , ni , g1 , g0 , r1m ;
unsigned long int k = 1 ;
unsigned long int l = 1 ;
redcify2 ( P1 , P0 , 1 , n1 , n0 ) ;
addmod2 ( x1 , x0 , P1 , P0 , P1 , P0 , n1 , n0 ) ;
y1 = z1 = x1 ;
y0 = z0 = x0 ;
while ( n1 != 0 || n0 != 1 )
{
binv ( ni , n0 ) ;
for (; ; )
{
do
{
x0 = mulredc2 ( & r1m , x1 , x0 , x1 , x0 , n1 , n0 , ni ) ;
x1 = r1m ;
addmod2 ( x1 , x0 , x1 , x0 , 0 , ( uintmax_t ) a , n1 , n0 ) ;
submod2 ( t1 , t0 , z1 , z0 , x1 , x0 , n1 , n0 ) ;
P0 = mulredc2 ( & r1m , P1 , P0 , t1 , t0 , n1 , n0 , ni ) ;
P1 = r1m ;
if ( k % 32 == 1 )
{
g0 = gcd2_odd ( & g1 , P1 , P0 , n1 , n0 ) ;
if ( g1 != 0 || g0 != 1 )
goto factor_found;
y1 = x1 ; y0 = x0 ;
}
}
while ( -- k != 0 );
z1 = x1 ; z0 = x0 ;
k = l ;
l = 2 * l ;
unsigned long int i ;
for ( i = 0 ; i < k ; i ++ )
{
x0 = mulredc2 ( & r1m , x1 , x0 , x1 , x0 , n1 , n0 , ni ) ;
x1 = r1m ;
addmod2 ( x1 , x0 , x1 , x0 , 0 , ( uintmax_t ) a , n1 , n0 ) ;
}
y1 = x1 ; y0 = x0 ;
}
factor_found:
do
{
y0 = mulredc2 ( & r1m , y1 , y0 , y1 , y0 , n1 , n0 , ni ) ;
y1 = r1m ;
addmod2 ( y1 , y0 , y1 , y0 , 0 , ( uintmax_t ) a , n1 , n0 ) ;
submod2 ( t1 , t0 , z1 , z0 , y1 , y0 , n1 , n0 ) ;
g0 = gcd2_odd ( & g1 , t1 , t0 , n1 , n0 ) ;
}
while ( g1 == 0 && g0 == 1 );
if ( g1 == 0 )
{
divexact_21 ( n1 , n0 , n1 , n0 , g0 ) ;
if ( ! prime_p ( g0 ) )
factor_using_pollard_rho ( g0 , a + 1 , factors ) ;
else
factor_insert ( factors , g0 ) ;
}
else
{
uintmax_t ginv ;
binv ( ginv , g0 ) ;
n0 = ginv * n0 ;
n1 = 0 ;
if ( ! prime2_p ( g1 , g0 ) )
factor_using_pollard_rho2 ( g1 , g0 , a + 1 , factors ) ;
else
factor_insert_large ( factors , g1 , g0 ) ;
}
if ( n1 == 0 )
{
if ( prime_p ( n0 ) )
{
factor_insert ( factors , n0 ) ;
break;
}
factor_using_pollard_rho ( n0 , a , factors ) ;
return;
}
if ( prime2_p ( n1 , n0 ) )
{
factor_insert_large ( factors , n1 , n0 ) ;
break;
}
x0 = mod2 ( & x1 , x1 , x0 , n1 , n0 ) ;
z0 = mod2 ( & z1 , z1 , z0 , n1 , n0 ) ;
y0 = mod2 ( & y1 , y1 , y0 , n1 , n0 ) ;
}
}
static void
mp_factor_using_pollard_rho ( mpz_t n , unsigned long int a ,
struct mp_factors * factors )
{
mpz_t x , z , y , P ;
mpz_t t , t2 ;
devmsg ( lr_3 , a ) ;
mpz_inits ( t , t2 , NULL ) ;
mpz_init_set_si ( y , 2 ) ;
mpz_init_set_si ( x , 2 ) ;
mpz_init_set_si ( z , 2 ) ;
mpz_init_set_ui ( P , 1 ) ;
unsigned long long int k = 1 ;
unsigned long long int l = 1 ;
while ( mpz_cmp_ui ( n , 1 ) != 0 )
{
for (; ; )
{
do
{
mpz_mul ( t , x , x ) ;
mpz_mod ( x , t , n ) ;
mpz_add_ui ( x , x , a ) ;
mpz_sub ( t , z , x ) ;
mpz_mul ( t2 , P , t ) ;
mpz_mod ( P , t2 , n ) ;
if ( k % 32 == 1 )
{
mpz_gcd ( t , P , n ) ;
if ( mpz_cmp_ui ( t , 1 ) != 0 )
goto factor_found;
mpz_set ( y , x ) ;
}
}
while ( -- k != 0 );
mpz_set ( z , x ) ;
k = l ;
l = 2 * l ;
unsigned long long int i ;
for ( i = 0 ; i < k ; i ++ )
{
mpz_mul ( t , x , x ) ;
mpz_mod ( x , t , n ) ;
mpz_add_ui ( x , x , a ) ;
}
mpz_set ( y , x ) ;
}
factor_found:
do
{
mpz_mul ( t , y , y ) ;
mpz_mod ( y , t , n ) ;
mpz_add_ui ( y , y , a ) ;
mpz_sub ( t , z , y ) ;
mpz_gcd ( t , t , n ) ;
}
while ( mpz_cmp_ui ( t , 1 ) == 0 );
mpz_divexact ( n , n , t ) ;
if ( ! mp_prime_p ( t ) )
{
devmsg ( lr_4 ) ;
mp_factor_using_pollard_rho ( t , a + 1 , factors ) ;
}
else
{
mp_factor_insert ( factors , t ) ;
}
if ( mp_prime_p ( n ) )
{
mp_factor_insert ( factors , n ) ;
break;
}
mpz_mod ( x , x , n ) ;
mpz_mod ( z , z , n ) ;
mpz_mod ( y , y , n ) ;
}
mpz_clears ( P , t2 , t , z , x , y , NULL ) ;
}
static uintmax_t _GL_ATTRIBUTE_CONST
isqrt ( uintmax_t n )
{
uintmax_t x ;
unsigned c ;
if ( n == 0 )
return 0 ;
count_leading_zeros ( c , n ) ;
x = ( uintmax_t ) 1 << ( ( W_TYPE_SIZE + 1 - c ) / 2 ) ;
for (; ; )
{
uintmax_t y = ( x + n / x ) / 2 ;
if ( y >= x )
return x ;
x = y ;
}
}
static uintmax_t _GL_ATTRIBUTE_CONST
isqrt2 ( uintmax_t nh , uintmax_t nl )
{
unsigned int shift ;
uintmax_t x ;
assert ( nh < ( ( uintmax_t ) 1 << ( W_TYPE_SIZE - 2 ) ) ) ;
if ( nh == 0 )
return isqrt ( nl ) ;
count_leading_zeros ( shift , nh ) ;
shift &= ~ 1 ;
x = isqrt ( ( nh << shift ) + ( nl >> ( W_TYPE_SIZE - shift ) ) ) + 1 ;
x <<= ( W_TYPE_SIZE - shift ) / 2 ;
for (; ; )
{
uintmax_t r _GL_UNUSED ;
uintmax_t q , y ;
udiv_qrnnd ( q , r , nh , nl , x ) ;
y = ( x + q ) / 2 ;
if ( y >= x )
{
uintmax_t hi , lo ;
umul_ppmm ( hi , lo , x + 1 , x + 1 ) ;
assert ( gt2 ( hi , lo , nh , nl ) ) ;
umul_ppmm ( hi , lo , x , x ) ;
assert ( ge2 ( nh , nl , hi , lo ) ) ;
sub_ddmmss ( hi , lo , nh , nl , hi , lo ) ;
assert ( hi == 0 ) ;
return x ;
}
x = y ;
}
}
static uintmax_t _GL_ATTRIBUTE_CONST
is_square ( uintmax_t x )
{
if ( ( ( MAGIC64 >> ( x & 63 ) ) & 1 )
&& ( ( MAGIC63 >> ( x % 63 ) ) & 1 )
&& ( ( MAGIC65 >> ( ( x % 65 ) & 63 ) ) & 1 )
&& ( ( MAGIC11 >> ( x % 11 ) & 1 ) ) )
{
uintmax_t r = isqrt ( x ) ;
if ( r * r == x )
return r ;
}
return 0 ;
}
static bool
factor_using_squfof ( uintmax_t n1 , uintmax_t n0 , struct factors * factors )
{
static const unsigned int multipliers_1 [] =
{
105 , 165 , 21 , 385 , 33 , 5 , 77 , 1 , 0
} ;
static const unsigned int multipliers_3 [] =
{
1155 , 15 , 231 , 35 , 3 , 55 , 7 , 11 , 0
} ;
const unsigned int * m ;
struct { uintmax_t Q ; uintmax_t P ; } queue [ QUEUE_SIZE ] ;
if ( n1 >= ( ( uintmax_t ) 1 << ( W_TYPE_SIZE - 2 ) ) )
return false ;
uintmax_t sqrt_n = isqrt2 ( n1 , n0 ) ;
if ( n0 == sqrt_n * sqrt_n )
{
uintmax_t p1 , p0 ;
umul_ppmm ( p1 , p0 , sqrt_n , sqrt_n ) ;
assert ( p0 == n0 ) ;
if ( n1 == p1 )
{
if ( prime_p ( sqrt_n ) )
factor_insert_multiplicity ( factors , sqrt_n , 2 ) ;
else
{
struct factors f ;
f . nfactors = 0 ;
if ( ! factor_using_squfof ( 0 , sqrt_n , & f ) )
{
factor_using_pollard_rho ( sqrt_n , 1 , & f ) ;
}
unsigned int i ;
for ( i = 0 ; i < f . nfactors ; i ++ )
factor_insert_multiplicity ( factors , f . p [ i ] , 2 * f . e [ i ] ) ;
}
return true ;
}
}
for ( m = ( n0 % 4 == 1 ) ? multipliers_3 : multipliers_1 ;
* m ; m ++ )
{
uintmax_t S , Dh , Dl , Q1 , Q , P , L , L1 , B ;
unsigned int i ;
unsigned int mu = * m ;
unsigned int qpos = 0 ;
assert ( mu * n0 % 4 == 3 ) ;
if ( n1 == 0 )
{
if ( ( uintmax_t ) mu * mu * mu >= n0 / 64 )
continue;
}
else
{
if ( n1 > ( ( uintmax_t ) 1 << ( W_TYPE_SIZE - 2 ) ) / mu )
continue;
}
umul_ppmm ( Dh , Dl , n0 , mu ) ;
Dh += n1 * mu ;
assert ( Dl % 4 != 1 ) ;
assert ( Dh < ( uintmax_t ) 1 << ( W_TYPE_SIZE - 2 ) ) ;
S = isqrt2 ( Dh , Dl ) ;
Q1 = 1 ;
P = S ;
Q = Dl - P * P ;
L = isqrt ( 2 * S ) ;
B = 2 * L ;
L1 = mu * 2 * L ;
for ( i = 0 ; i <= B ; i ++ )
{
uintmax_t q , P1 , t , rem ;
div_smallq ( q , rem , S + P , Q ) ;
P1 = S - rem ;
#if STAT_SQUFOF
assert ( q > 0 ) ;
q_freq [ 0 ] ++ ;
q_freq [ MIN ( q , Q_FREQ_SIZE ) ] ++ ;
#endif
if ( Q <= L1 )
{
uintmax_t g = Q ;
if ( ( Q & 1 ) == 0 )
g /= 2 ;
g /= gcd_odd ( g , mu ) ;
if ( g <= L )
{
if ( qpos >= QUEUE_SIZE )
error ( EXIT_FAILURE , 0 , _ ( lr_5 ) ) ;
queue [ qpos ] . Q = g ;
queue [ qpos ] . P = P % g ;
qpos ++ ;
}
}
t = Q1 + q * ( P - P1 ) ;
Q1 = Q ;
Q = t ;
P = P1 ;
if ( ( i & 1 ) == 0 )
{
uintmax_t r = is_square ( Q ) ;
if ( r )
{
unsigned int j ;
for ( j = 0 ; j < qpos ; j ++ )
{
if ( queue [ j ] . Q == r )
{
if ( r == 1 )
goto next_multiplier;
if ( P >= queue [ j ] . P )
t = P - queue [ j ] . P ;
else
t = queue [ j ] . P - P ;
if ( t % r == 0 )
{
memmove ( queue , queue + j + 1 ,
( qpos - j - 1 ) * sizeof ( queue [ 0 ] ) ) ;
qpos -= ( j + 1 ) ;
}
goto next_i;
}
}
Q1 = r ;
assert ( S >= P ) ;
P += r * ( ( S - P ) / r ) ;
uintmax_t hi , lo ;
umul_ppmm ( hi , lo , P , P ) ;
sub_ddmmss ( hi , lo , Dh , Dl , hi , lo ) ;
udiv_qrnnd ( Q , rem , hi , lo , Q1 ) ;
assert ( rem == 0 ) ;
for (; ; )
{
div_smallq ( q , rem , S + P , Q ) ;
P1 = S - rem ;
#if STAT_SQUFOF
q_freq [ 0 ] ++ ;
q_freq [ MIN ( q , Q_FREQ_SIZE ) ] ++ ;
#endif
if ( P == P1 )
break;
t = Q1 + q * ( P - P1 ) ;
Q1 = Q ;
Q = t ;
P = P1 ;
}
if ( ( Q & 1 ) == 0 )
Q /= 2 ;
Q /= gcd_odd ( Q , mu ) ;
assert ( Q > 1 && ( n1 || Q < n0 ) ) ;
if ( prime_p ( Q ) )
factor_insert ( factors , Q ) ;
else if ( ! factor_using_squfof ( 0 , Q , factors ) )
factor_using_pollard_rho ( Q , 2 , factors ) ;
divexact_21 ( n1 , n0 , n1 , n0 , Q ) ;
if ( prime2_p ( n1 , n0 ) )
factor_insert_large ( factors , n1 , n0 ) ;
else
{
if ( ! factor_using_squfof ( n1 , n0 , factors ) )
{
if ( n1 == 0 )
factor_using_pollard_rho ( n0 , 1 , factors ) ;
else
factor_using_pollard_rho2 ( n1 , n0 , 1 , factors ) ;
}
}
return true ;
}
}
next_i: ;
}
next_multiplier: ;
}
return false ;
}
static void
factor ( uintmax_t t1 , uintmax_t t0 , struct factors * factors )
{
factors -> nfactors = 0 ;
factors -> plarge [ 1 ] = 0 ;
if ( t1 == 0 && t0 < 2 )
return;
t0 = factor_using_division ( & t1 , t1 , t0 , factors ) ;
if ( t1 == 0 && t0 < 2 )
return;
if ( prime2_p ( t1 , t0 ) )
factor_insert_large ( factors , t1 , t0 ) ;
else
{
if ( alg == ALG_SQUFOF )
if ( factor_using_squfof ( t1 , t0 , factors ) )
return;
if ( t1 == 0 )
factor_using_pollard_rho ( t0 , 1 , factors ) ;
else
factor_using_pollard_rho2 ( t1 , t0 , 1 , factors ) ;
}
}
static void
mp_factor ( mpz_t t , struct mp_factors * factors )
{
mp_factor_init ( factors ) ;
if ( mpz_sgn ( t ) != 0 )
{
mp_factor_using_division ( t , factors ) ;
if ( mpz_cmp_ui ( t , 1 ) != 0 )
{
devmsg ( lr_6 ) ;
if ( mp_prime_p ( t ) )
mp_factor_insert ( factors , t ) ;
else
mp_factor_using_pollard_rho ( t , 1 , factors ) ;
}
}
}
static strtol_error
strto2uintmax ( uintmax_t * hip , uintmax_t * lop , const char * s )
{
unsigned int lo_carry ;
uintmax_t hi = 0 , lo = 0 ;
strtol_error err = LONGINT_INVALID ;
for (; ; )
{
char c = * s ;
if ( c == ' ' )
s ++ ;
else if ( c == '+' )
{
s ++ ;
break;
}
else
break;
}
const char * p = s ;
for (; ; )
{
unsigned int c = * p ++ ;
if ( c == 0 )
break;
if ( UNLIKELY ( ! ISDIGIT ( c ) ) )
{
err = LONGINT_INVALID ;
break;
}
err = LONGINT_OK ;
}
for (; err == LONGINT_OK ; )
{
unsigned int c = * s ++ ;
if ( c == 0 )
break;
c -= '0' ;
if ( UNLIKELY ( hi > ~ ( uintmax_t ) 0 / 10 ) )
{
err = LONGINT_OVERFLOW ;
break;
}
hi = 10 * hi ;
lo_carry = ( lo >> ( W_TYPE_SIZE - 3 ) ) + ( lo >> ( W_TYPE_SIZE - 1 ) ) ;
lo_carry += 10 * lo < 2 * lo ;
lo = 10 * lo ;
lo += c ;
lo_carry += lo < c ;
hi += lo_carry ; MST[ADD$@1$@2$!MUL$@1$@2$]MSP[]
if ( UNLIKELY ( hi < lo_carry ) )
{
err = LONGINT_OVERFLOW ;
break;
}
}
* hip = hi ;
* lop = lo ;
return err ;
}
static void
print_uintmaxes ( uintmax_t t1 , uintmax_t t0 )
{
uintmax_t q , r ;
if ( t1 == 0 )
printf ( lr_7 PRIuMAX , t0 ) ;
else
{
q = t1 / 1000000000 ;
r = t1 % 1000000000 ;
udiv_qrnnd ( t0 , r , r , t0 , 1000000000 ) ;
print_uintmaxes ( q , t0 ) ;
printf ( lr_8 , ( int ) r ) ;
}
}
static void
print_factors_single ( uintmax_t t1 , uintmax_t t0 )
{
struct factors factors ;
print_uintmaxes ( t1 , t0 ) ;
putchar ( ':' ) ;
factor ( t1 , t0 , & factors ) ;
unsigned int j ;
unsigned int k ;
for ( j = 0 ; j < factors . nfactors ; j ++ )
for ( k = 0 ; k < factors . e [ j ] ; k ++ )
{
char buf [ INT_BUFSIZE_BOUND ( uintmax_t ) ] ;
putchar ( ' ' ) ;
fputs ( umaxtostr ( factors . p [ j ] , buf ) , stdout ) ;
}
if ( factors . plarge [ 1 ] )
{
putchar ( ' ' ) ;
print_uintmaxes ( factors . plarge [ 1 ] , factors . plarge [ 0 ] ) ;
}
putchar ( '\n' ) ;
}
static bool
print_factors ( const char * input )
{
uintmax_t t1 , t0 ;
strtol_error err = strto2uintmax ( & t1 , & t0 , input ) ;
switch ( err )
{
case LONGINT_OK :
if ( ( ( t1 << 1 ) >> 1 ) == t1 )
{
devmsg ( lr_9 ) ;
print_factors_single ( t1 , t0 ) ;
return true ;
}
break;
case LONGINT_OVERFLOW :
break;
default:
error ( 0 , 0 , _ ( lr_10 ) , quote ( input ) ) ;
return false ;
}
#if HAVE_GMP
devmsg ( lr_11 ) ;
mpz_t t ;
struct mp_factors factors ;
mpz_init_set_str ( t , input , 10 ) ;
gmp_printf ( lr_12 , t ) ;
mp_factor ( t , & factors ) ;
unsigned int j ;
unsigned int k ;
for ( j = 0 ; j < factors . nfactors ; j ++ )
for ( k = 0 ; k < factors . e [ j ] ; k ++ )
gmp_printf ( lr_13 , factors . p [ j ] ) ;
mp_factor_clear ( & factors ) ;
mpz_clear ( t ) ;
putchar ( '\n' ) ;
return true ;
#else
error ( 0 , 0 , _ ( lr_14 ) , quote ( input ) ) ;
return false ;
#endif
}
void
usage ( int status )
{
if ( status != EXIT_SUCCESS )
emit_try_help () ;
else
{
printf ( _ ( lr_15 ) ,
program_name , program_name ) ;
fputs ( _ ( lr_16 ) , stdout ) ;
fputs ( HELP_OPTION_DESCRIPTION , stdout ) ;
fputs ( VERSION_OPTION_DESCRIPTION , stdout ) ;
emit_ancillary_info () ;
}
exit ( status ) ;
}
static bool
do_stdin ( void )
{
bool ok = true ;
token_buffer tokenbuffer ;
init_tokenbuffer ( & tokenbuffer ) ;
while ( true )
{
size_t token_length = readtoken ( stdin , DELIM , sizeof ( DELIM ) - 1 ,
& tokenbuffer ) ;
if ( token_length == ( size_t ) - 1 )
break;
ok &= print_factors ( tokenbuffer . buffer ) ;
}
free ( tokenbuffer . buffer ) ;
return ok ;
}
int
main ( int argc , char * * argv )
{
initialize_main ( & argc , & argv ) ;
set_program_name ( argv [ 0 ] ) ;
setlocale ( LC_ALL , lr_17 ) ;
bindtextdomain ( PACKAGE , LOCALEDIR ) ;
textdomain ( PACKAGE ) ;
atexit ( close_stdout ) ;
alg = ALG_POLLARD_RHO ;
int c ;
while ( ( c = getopt_long ( argc , argv , lr_17 , long_options , NULL ) ) != - 1 )
{
switch ( c )
{
case DEV_DEBUG_OPTION :
dev_debug = true ;
break;
case 's' :
alg = ALG_SQUFOF ;
break;
case 'w' :
flag_prove_primality = false ;
break;
case_GETOPT_HELP_CHAR ;
case_GETOPT_VERSION_CHAR ( PROGRAM_NAME , AUTHORS ) ;
default:
usage ( EXIT_FAILURE ) ;
}
}
#if STAT_SQUFOF
if ( alg == ALG_SQUFOF )
memset ( q_freq , 0 , sizeof ( q_freq ) ) ;
#endif
bool ok ;
if ( argc <= optind )
ok = do_stdin () ;
else
{
ok = true ;
int i ;
for ( i = optind ; i < argc ; i ++ )
if ( ! print_factors ( argv [ i ] ) )
ok = false ;
}
#if STAT_SQUFOF
if ( alg == ALG_SQUFOF && q_freq [ 0 ] > 0 )
{
double acc_f ;
printf ( lr_18 , q_freq [ 0 ] ) ;
unsigned int i ;
for ( i = 1 , acc_f = 0.0 ; i <= Q_FREQ_SIZE ; i ++ )
{
double f = ( double ) q_freq [ i ] / q_freq [ 0 ] ;
acc_f += f ;
printf ( lr_19 , i == Q_FREQ_SIZE ? lr_20 : lr_17 , i ,
100.0 * f , 100.0 * acc_f ) ;
}
}
#endif
exit ( ok ? EXIT_SUCCESS : EXIT_FAILURE ) ;
}
