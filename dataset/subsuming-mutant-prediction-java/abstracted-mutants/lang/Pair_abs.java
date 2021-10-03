public static < vt_1 , vt_2 > vr_1 < vt_1 , vt_2 > fn_1 ( final vt_1 vr_2 , final vt_2 vr_3 ) {
return new vr_4 < vt_1 , vt_2 > ( vr_2 , vr_3 ) ;
}
@Override
public final vt_1 fn_2 () {
return fn_3 () ;
}
@Override
public vt_2 fn_4 () {
return fn_5 () ;
}
@Override
public int fn_6 ( final vr_1 < vt_1 , vt_2 > vr_5 ) {
return new fn_7 () . append ( fn_3 () , vr_5 . fn_3 () )
. append ( fn_5 () , vr_5 . fn_5 () ) . fn_8 () ;
}
@SuppressWarnings ( lr_1 )
@Override
public boolean equals ( final Object vr_6 ) {
if ( vr_6 == this ) {
return true ;
}
if ( vr_6 instanceof vr_7 . vr_8 < ? , ? > ) {
final vr_7 . vr_8 < ? , ? > vr_5 = ( vr_7 . vr_8 < ? , ? > ) vr_6 ;
return vr_9 . equals ( fn_2 () , vr_5 . fn_2 () )
&& vr_9 . equals ( fn_4 () , vr_5 . fn_4 () ) ;
}
return false ;
}
@Override
public int fn_9 () {
return ( fn_2 () == null ? 0 : fn_2 () . fn_9 () ) ^
( fn_4 () == null ? 0 : fn_4 () . fn_9 () ) ;
}
@Override
public String toString () {
return new StringBuilder () . append ( '(' ) . append ( fn_3 () ) . append ( ',' ) . append ( fn_5 () ) . append ( ')' ) . toString () ;
}
public String toString ( final String vr_10 ) {
return String . vr_10 ( vr_10 , fn_3 () , fn_5 () ) ;
}
