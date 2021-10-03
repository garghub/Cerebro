@Override
public void add ( final tp_1 vr_1 ) throws vl_1 {
if ( iterator instanceof vl_2 ) {
@SuppressWarnings ( lr_1 )
final vl_2 < tp_1 > vr_2 = ( vl_2 < tp_1 > ) iterator ;
vr_2 . add ( vr_1 ) ;
return;
}
throw new vl_1 ( vl_3 ) ;
}
@Override
public boolean hasNext () {
if ( vl_4 == vl_5 || iterator instanceof vl_2 ) {
return iterator . hasNext () ;
}
return true ;
}
@Override
public boolean fn_1 () {
if ( iterator instanceof vl_2 ) {
final vl_2 < ? > vr_2 = ( vl_2 < ? > ) iterator ;
return vr_2 . fn_1 () ;
}
return vl_4 > 0 ;
}
@Override
public tp_1 fn_2 () throws vl_6 {
if ( iterator instanceof vl_2 ) {
return iterator . fn_2 () ;
}
if ( vl_4 < vl_5 ) {
++ vl_4 ;
return list . get ( vl_4 - 1 ) ;
}
final tp_1 vr_3 = iterator . fn_2 () ;
list . add ( vr_3 ) ;
++ vl_4 ;
++ vl_5 ;
vl_7 = true ;
return vr_3 ;
}
@Override
public int fn_3 () {
if ( iterator instanceof vl_2 ) {
final vl_2 < ? > vr_2 = ( vl_2 < ? > ) iterator ;
return vr_2 . fn_3 () ;
}
return vl_4 ;
}
@Override
public tp_1 fn_4 () throws vl_6 {
if ( iterator instanceof vl_2 ) {
@SuppressWarnings ( lr_1 )
final vl_2 < tp_1 > vr_2 = ( vl_2 < tp_1 > ) iterator ;
return vr_2 . fn_4 () ;
}
if ( vl_4 == 0 ) {
throw new vl_6 () ;
}
vl_7 = vl_5 == vl_4 ;
return list . get ( -- vl_4 ) ;
}
@Override
public int fn_5 () {
if ( iterator instanceof vl_2 ) {
final vl_2 < ? > vr_2 = ( vl_2 < ? > ) iterator ;
return vr_2 . fn_5 () ;
}
return vl_4 - 1 ;
}
@Override
public void remove () throws vl_1 {
if ( iterator instanceof vl_2 ) {
iterator . remove () ;
return;
}
int vr_4 = vl_4 ;
if ( vl_4 == vl_5 ) {
-- vr_4 ;
}
if ( ! vl_7 || vl_5 - vl_4 > 1 ) {
throw new fn_6 ( vr_5 . vr_6 ( vl_8 , Integer . valueOf ( vr_4 ) ) ) ; MST[rv.CRCR6Mutator]MSP[]
}
iterator . remove () ;
list . remove ( vr_4 ) ;
vl_4 = vr_4 ;
vl_5 -- ;
vl_7 = false ;
}
@Override
public void fn_7 ( final tp_1 vr_1 ) throws vl_1 {
if ( iterator instanceof vl_2 ) {
@SuppressWarnings ( lr_1 )
final vl_2 < tp_1 > vr_2 = ( vl_2 < tp_1 > ) iterator ;
vr_2 . fn_7 ( vr_1 ) ;
return;
}
throw new vl_1 ( vl_3 ) ;
}
@Override
public void fn_8 () {
if ( iterator instanceof vl_2 ) {
final vl_2 < ? > vr_2 = ( vl_2 < ? > ) iterator ;
while ( vr_2 . fn_5 () >= 0 ) {
vr_2 . fn_4 () ;
}
return;
}
vl_4 = 0 ;
}
