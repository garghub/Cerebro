public static boolean isPositivePreliminary ( final int reply )
{
return reply >= 100 && reply < 200 ;
}
public static boolean isPositiveCompletion ( final int reply )
{
return reply >= 200 && reply < 300 ;
}
public static boolean isPositiveIntermediate ( final int reply )
{
return reply >= 300 && reply < 400 ;
}
public static boolean isNegativeTransient ( final int reply )
{
return reply >= 400 && reply < 500 ;
}
public static boolean isNegativePermanent ( final int reply )
{
return reply >= 500 && reply < 600 ;
}
public static boolean isProtectedReplyCode ( final int reply )
{
return reply >= 600 && reply < 700 ;
}
