public void addListener ( final EventListener listener )
{
listeners . add ( listener ) ;
}
public void removeListener ( final EventListener listener )
{
listeners . remove ( listener ) ;
}
public int getListenerCount ()
{
return listeners . size () ;
}
@Override
public Iterator < EventListener > iterator () {
return listeners . iterator () ;
}
