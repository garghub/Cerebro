public static void fn_1 ( tp_1 vr_1 , tp_2 vr_2 ) {
tp_2 vr_3 = vr_2 ;
int vr_4 = 0 ;
while ( vr_3 != null ) {
vr_1 . vr_5 ( vr_3 , vr_4 ) ;
if ( vr_3 . vr_6 () > 0 ) {
vr_3 = vr_3 . vr_7 ( 0 ) ;
vr_4 ++ ;
} else {
while ( vr_3 . vr_8 () == null && vr_4 > 0 ) {
vr_1 . vr_9 ( vr_3 , vr_4 ) ;
vr_3 = vr_3 . vr_10 () ;
vr_4 -- ;
}
vr_1 . vr_9 ( vr_3 , vr_4 ) ;
if ( vr_3 == vr_2 )
break;
vr_3 = vr_3 . vr_8 () ;
}
}
}
public static void fn_1 ( tp_1 vr_1 , tp_3 vr_11 ) {
vr_12 . vr_13 ( vr_1 ) ;
vr_12 . vr_13 ( vr_11 ) ;
for ( tp_4 vr_14 : vr_11 )
fn_1 ( vr_1 , vr_14 ) ;
}
public static tp_5 fn_2 ( tp_6 fn_2 , tp_2 vr_2 ) {
tp_2 vr_3 = vr_2 ;
int vr_4 = 0 ;
while ( vr_3 != null ) {
tp_5 vr_15 = fn_2 . vr_5 ( vr_3 , vr_4 ) ;
if ( vr_15 == tp_5 . vr_16 )
return vr_15 ;
if ( vr_15 == tp_5 . CONTINUE && vr_3 . vr_6 () > 0 ) {
vr_3 = vr_3 . vr_7 ( 0 ) ;
++ vr_4 ;
continue;
}
while ( vr_3 . vr_8 () == null && vr_4 > 0 ) {
if ( vr_15 == tp_5 . CONTINUE || vr_15 == tp_5 . vr_17 ) {
vr_15 = fn_2 . vr_9 ( vr_3 , vr_4 ) ;
if ( vr_15 == tp_5 . vr_16 )
return vr_15 ;
}
tp_2 vr_18 = vr_3 ;
vr_3 = vr_3 . vr_10 () ;
vr_4 -- ;
if ( vr_15 == tp_5 . REMOVE )
vr_18 . remove () ;
vr_15 = tp_5 . CONTINUE ;
}
if ( vr_15 == tp_5 . CONTINUE || vr_15 == tp_5 . vr_17 ) {
vr_15 = fn_2 . vr_9 ( vr_3 , vr_4 ) ;
if ( vr_15 == tp_5 . vr_16 )
return vr_15 ;
}
if ( vr_3 == vr_2 )
return vr_15 ;
tp_2 vr_18 = vr_3 ;
vr_3 = vr_3 . vr_8 () ;
if ( vr_15 == tp_5 . REMOVE )
vr_18 . remove () ;
}
return tp_5 . CONTINUE ;
}
public static void fn_2 ( tp_6 fn_2 , tp_3 vr_11 ) {
vr_12 . vr_13 ( fn_2 ) ;
vr_12 . vr_13 ( vr_11 ) ;
for ( tp_4 vr_14 : vr_11 )
if ( fn_2 ( fn_2 , vr_14 ) == tp_5 . vr_16 )
break;
}
