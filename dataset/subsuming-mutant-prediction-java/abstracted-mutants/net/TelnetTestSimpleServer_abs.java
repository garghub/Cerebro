@Override
public void fn_1 ()
{
boolean vr_1 = false ;
while( ! vr_1 )
{
try
{
vl_1 = vr_2 . vr_3 () ;
synchronized ( vl_1 )
{
try
{
vl_1 . vr_4 () ;
}
catch ( final Exception vr_5 )
{
System . vr_6 . println ( lr_1 + vr_5 . vr_7 () ) ;
}
try
{
vl_1 . vr_8 () ;
}
catch ( final Exception vr_5 )
{
System . vr_6 . println ( lr_2 + vr_5 . vr_7 () ) ;
}
}
}
catch ( final IOException vr_5 )
{
vr_1 = true ;
}
}
try
{
vr_2 . vr_8 () ;
}
catch ( final Exception vr_5 )
{
System . vr_6 . println ( lr_2 + vr_5 . vr_7 () ) ;
}
}
public void fn_2 ()
{
if ( vl_1 == null ) {
return;
}
synchronized ( vl_1 )
{
try
{
vl_1 . vr_9 () ;
}
catch ( final Exception vr_5 )
{
System . vr_6 . println ( lr_3 + vr_5 . vr_7 () ) ;
}
}
}
public void fn_3 ()
{
vr_10 . vr_11 () ;
try
{
vr_2 . vr_8 () ;
}
catch ( final Exception vr_5 )
{
System . vr_6 . println ( lr_2 + vr_5 . vr_7 () ) ;
}
}
public tp_1 fn_4 () throws IOException
{
if( vl_1 != null )
{
return vl_1 . fn_4 () ;
}
return null ;
}
public tp_2 fn_5 () throws IOException
{
if( vl_1 != null )
{
return vl_1 . fn_5 () ;
}
return null ;
}
