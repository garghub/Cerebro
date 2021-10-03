@Override
public Integer fn_1 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
return fn_2 ( vr_1 , vr_2 ) . length () ;
}
@Deprecated
public tp_1 fn_3 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
return fn_2 ( vr_1 , vr_2 ) ;
}
public tp_1 fn_2 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
if ( vr_1 == null || vr_2 == null ) {
throw new IllegalArgumentException ( lr_1 ) ;
}
final StringBuilder vr_3 = new StringBuilder ( vr_4 . vr_5 ( vr_1 . length () , vr_2 . length () ) ) ;
final int [] [] vr_6 = fn_4 ( vr_1 , vr_2 ) ;
int vr_7 = vr_1 . length () - 1 ;
int vr_8 = vr_2 . length () - 1 ;
int vr_9 = vr_6 [ vr_1 . length () ] [ vr_2 . length () ] - 1 ;
while ( vr_9 >= 0 ) {
if ( vr_1 . charAt ( vr_7 ) == vr_2 . charAt ( vr_8 ) ) {
vr_3 . append ( vr_1 . charAt ( vr_7 ) ) ;
vr_7 = vr_7 - 1 ;
vr_8 = vr_8 - 1 ;
vr_9 = vr_9 - 1 ;
} else if ( vr_6 [ vr_7 + 1 ] [ vr_8 ] < vr_6 [ vr_7 ] [ vr_8 + 1 ] ) {
vr_7 = vr_7 - 1 ;
} else {
vr_8 = vr_8 - 1 ;
}
}
return vr_3 . vr_10 () . toString () ;
}
public int [] [] fn_4 ( final tp_1 vr_1 , final tp_1 vr_2 ) {
final int [] [] vr_6 = new int [ vr_1 . length () + 1 ] [ vr_2 . length () + 1 ] ;
for ( int vr_7 = 0 ; vr_7 < vr_1 . length () ; vr_7 ++ ) {
for ( int vr_8 = 0 ; vr_8 < vr_2 . length () ; vr_8 ++ ) {
if ( vr_7 == 0 ) {
vr_6 [ vr_7 ] [ vr_8 ] = 0 ;
}
if ( vr_8 == 0 ) {
vr_6 [ vr_7 ] [ vr_8 ] = 0 ;
}
if ( vr_1 . charAt ( vr_7 ) == vr_2 . charAt ( vr_8 ) ) {
vr_6 [ vr_7 + 1 ] [ vr_8 + 1 ] = vr_6 [ vr_7 ] [ vr_8 ] + 1 ;
} else {
vr_6 [ vr_7 + 1 ] [ vr_8 + 1 ] = vr_4 . vr_5 ( vr_6 [ vr_7 + 1 ] [ vr_8 ] , vr_6 [ vr_7 ] [ vr_8 + 1 ] ) ;
}
}
}
return vr_6 ;
}
