public int getOptionCode ()
{
return optionCode ;
}
public boolean getAcceptLocal ()
{
return acceptLocal ;
}
public boolean getAcceptRemote ()
{
return acceptRemote ;
}
public void setAcceptLocal ( final boolean accept )
{
acceptLocal = accept ;
}
public void setAcceptRemote ( final boolean accept )
{
acceptRemote = accept ;
}
public boolean getInitLocal ()
{
return initialLocal ;
}
public boolean getInitRemote ()
{
return initialRemote ;
}
public void setInitLocal ( final boolean init )
{
initialLocal = init ;
}
public void setInitRemote ( final boolean init )
{
initialRemote = init ;
}
public int [] answerSubnegotiation ( final int suboptionData [] , final int suboptionLength ) {
return null ;
}
public int [] startSubnegotiationLocal () {
return null ;
}
public int [] startSubnegotiationRemote () {
return null ;
}
boolean getWill ()
{
return willFlag ;
}
void setWill ( final boolean state )
{
willFlag = state ;
}
boolean getDo ()
{
return doFlag ;
}
void setDo ( final boolean state )
{
doFlag = state ;
}
