public static String toFullyQualifiedName ( final Class < ? > context , final String resourceName ) {
Validate . notNull ( context , lr_1 , lr_2 ) ;
Validate . notNull ( resourceName , lr_1 , lr_3 ) ;
return toFullyQualifiedName ( context . getPackage () , resourceName ) ;
}
public static String toFullyQualifiedName ( final Package context , final String resourceName ) {
Validate . notNull ( context , lr_1 , lr_2 ) ;
Validate . notNull ( resourceName , lr_1 , lr_3 ) ;
return context . getName () + lr_4 + resourceName ;
}
public static String toFullyQualifiedPath ( final Class < ? > context , final String resourceName ) {
Validate . notNull ( context , lr_1 , lr_2 ) ;
Validate . notNull ( resourceName , lr_1 , lr_3 ) ;
return toFullyQualifiedPath ( context . getPackage () , resourceName ) ;
}
public static String toFullyQualifiedPath ( final Package context , final String resourceName ) {
Validate . notNull ( context , lr_1 , lr_2 ) ;
Validate . notNull ( resourceName , lr_1 , lr_3 ) ;
return context . getName () . replace ( '.' , '/' ) + lr_5 + resourceName ;
}
