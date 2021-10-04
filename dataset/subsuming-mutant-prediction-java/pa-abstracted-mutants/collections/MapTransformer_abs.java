public static < I , O > Transformer < I , O > mapTransformer ( final Map < ? super I , ? extends O > map ) {
if ( map == null ) {
return ConstantTransformer . <I , O > nullTransformer () ;
}
return new MapTransformer <> ( map ) ;
}
@Override
public O transform ( final I input ) {
return iMap . get ( input ) ;
}
public Map < ? super I , ? extends O > getMap () {
return iMap ;
}
