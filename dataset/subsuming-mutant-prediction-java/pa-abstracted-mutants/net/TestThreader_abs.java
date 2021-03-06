@Test
@SuppressWarnings ( lr_1 )
public void testNullArray () {
final Threader t = new Threader () ;
final Threadable [] messages = null ;
Assert . assertNull ( t . thread ( messages ) ) ;
}
@Test
public void testNullList () {
final Threader t = new Threader () ;
final List < Threadable > messages = null ;
Assert . assertNull ( t . thread ( messages ) ) ;
}
@Test
public void testNullIterable () {
final Threader t = new Threader () ;
final Iterable < Threadable > messages = null ;
Assert . assertNull ( t . thread ( messages ) ) ;
}
@SuppressWarnings ( lr_1 )
@Test
public void testEmptyArray () {
final Threader t = new Threader () ;
final Threadable [] messages = new Threadable [ 0 ] ;
Assert . assertNull ( t . thread ( messages ) ) ;
}
@Test
public void testEmptyList () {
final Threader t = new Threader () ;
final Threadable [] messages = new Threadable [ 0 ] ;
final List < Threadable > asList = Arrays . asList ( messages ) ;
Assert . assertNull ( t . thread ( asList ) ) ;
}
@Test
public void testEmptyIterable () {
final Threader t = new Threader () ;
final Threadable [] messages = new Threadable [ 0 ] ;
final Iterable < Threadable > asList = Arrays . asList ( messages ) ;
Assert . assertNull ( t . thread ( asList ) ) ;
}
