public void testConstructors ()
{
assertTrue ( ! opthand1 . getInitLocal () ) ;
assertTrue ( ! opthand1 . getInitRemote () ) ;
assertTrue ( ! opthand1 . getAcceptLocal () ) ;
assertTrue ( ! opthand1 . getAcceptRemote () ) ;
assertTrue ( opthand2 . getInitLocal () ) ;
assertTrue ( opthand2 . getInitRemote () ) ;
assertTrue ( opthand2 . getAcceptLocal () ) ;
assertTrue ( opthand2 . getAcceptRemote () ) ;
assertTrue ( ! opthand3 . getInitLocal () ) ;
assertTrue ( ! opthand3 . getInitRemote () ) ;
assertTrue ( ! opthand3 . getAcceptLocal () ) ;
assertTrue ( ! opthand3 . getAcceptRemote () ) ;
}
public void testWill ()
{
opthand2 . setWill ( true ) ;
opthand3 . setWill ( false ) ;
assertTrue ( ! opthand1 . getWill () ) ;
assertTrue ( opthand2 . getWill () ) ;
assertTrue ( ! opthand3 . getWill () ) ;
}
public void testDo ()
{
opthand2 . setDo ( true ) ;
opthand3 . setDo ( false ) ;
assertTrue ( ! opthand1 . getDo () ) ;
assertTrue ( opthand2 . getDo () ) ;
assertTrue ( ! opthand3 . getDo () ) ;
}
