public boolean fn_1 ( tp_1 vr_1 , tp_1 vr_2 ) {
return vr_1 == vr_2 ;
}
public boolean fn_1 ( tp_1 vr_1 , tp_1 vr_2 ) {
for ( tp_1 vr_3 : vr_2 . vr_4 () ) {
if ( vr_3 != vr_2 && vr_5 . fn_1 ( vr_2 , vr_3 ) )
return true ;
}
return false ;
}
@Override
public String toString () {
return String . vr_6 ( lr_1 , vr_5 ) ;
}
public boolean fn_1 ( tp_1 vr_1 , tp_1 vr_7 ) {
return ! vr_5 . fn_1 ( vr_1 , vr_7 ) ;
}
@Override
public String toString () {
return String . vr_6 ( lr_2 , vr_5 ) ;
}
public boolean fn_1 ( tp_1 vr_1 , tp_1 vr_2 ) {
if ( vr_1 == vr_2 )
return false ;
tp_1 vr_8 = vr_2 . vr_8 () ;
while ( true ) {
if ( vr_5 . fn_1 ( vr_1 , vr_8 ) )
return true ;
if ( vr_8 == vr_1 )
break;
vr_8 = vr_8 . vr_8 () ;
}
return false ;
}
@Override
public String toString () {
return String . vr_6 ( lr_3 , vr_5 ) ;
}
public boolean fn_1 ( tp_1 vr_1 , tp_1 vr_2 ) {
if ( vr_1 == vr_2 )
return false ;
tp_1 vr_8 = vr_2 . vr_8 () ;
return vr_8 != null && vr_5 . fn_1 ( vr_1 , vr_8 ) ;
}
@Override
public String toString () {
return String . vr_6 ( lr_4 , vr_5 ) ;
}
public boolean fn_1 ( tp_1 vr_1 , tp_1 vr_2 ) {
if ( vr_1 == vr_2 )
return false ;
tp_1 vr_9 = vr_2 . vr_10 () ;
while ( vr_9 != null ) {
if ( vr_5 . fn_1 ( vr_1 , vr_9 ) )
return true ;
vr_9 = vr_9 . vr_10 () ;
}
return false ;
}
@Override
public String toString () {
return String . vr_6 ( lr_5 , vr_5 ) ;
}
public boolean fn_1 ( tp_1 vr_1 , tp_1 vr_2 ) {
if ( vr_1 == vr_2 )
return false ;
tp_1 vr_9 = vr_2 . vr_10 () ;
return vr_9 != null && vr_5 . fn_1 ( vr_1 , vr_9 ) ;
}
@Override
public String toString () {
return String . vr_6 ( lr_6 , vr_5 ) ;
}
