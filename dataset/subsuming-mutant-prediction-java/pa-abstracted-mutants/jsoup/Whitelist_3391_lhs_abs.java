public static Whitelist none () {
return new Whitelist () ;
}
public static Whitelist simpleText () {
return new Whitelist ()
. addTags ( lr_1 , lr_2 , lr_3 , lr_4 , lr_5 )
;
}
public static Whitelist basic () {
return new Whitelist ()
. addTags (
lr_6 , lr_1 , lr_7 , lr_8 , lr_9 , lr_10 , lr_11 , lr_12 , lr_13 , lr_2 ,
lr_3 , lr_14 , lr_15 , lr_16 , lr_17 , lr_18 , lr_19 , lr_20 , lr_21 , lr_4 , lr_22 ,
lr_23 , lr_5 , lr_24 )
. addAttributes ( lr_6 , lr_25 )
. addAttributes ( lr_7 , lr_9 )
. addAttributes ( lr_18 , lr_9 )
. addProtocols ( lr_6 , lr_25 , lr_26 , lr_27 , lr_28 , lr_29 )
. addProtocols ( lr_7 , lr_9 , lr_27 , lr_28 )
. addProtocols ( lr_9 , lr_9 , lr_27 , lr_28 )
. addEnforcedAttribute ( lr_6 , lr_30 , lr_31 )
;
}
public static Whitelist basicWithImages () {
return basic ()
. addTags ( lr_32 )
. addAttributes ( lr_32 , lr_33 , lr_34 , lr_35 , lr_36 , lr_37 , lr_38 )
. addProtocols ( lr_32 , lr_36 , lr_27 , lr_28 )
;
}
public static Whitelist relaxed () {
return new Whitelist ()
. addTags (
lr_6 , lr_1 , lr_7 , lr_8 , lr_39 , lr_9 , lr_10 , lr_40 ,
lr_41 , lr_11 , lr_42 , lr_12 , lr_13 , lr_2 , lr_43 , lr_44 , lr_45 , lr_46 , lr_47 , lr_48 ,
lr_3 , lr_32 , lr_14 , lr_15 , lr_16 , lr_17 , lr_18 , lr_19 , lr_20 , lr_21 , lr_4 ,
lr_22 , lr_23 , lr_49 , lr_50 , lr_51 , lr_52 , lr_53 , lr_54 , lr_55 , lr_5 ,
lr_24 )
. addAttributes ( lr_6 , lr_25 , lr_37 )
. addAttributes ( lr_7 , lr_9 ) MST[NonVoidMethodCallMutator]MSP[]
. addAttributes ( lr_40 , lr_20 , lr_38 )
. addAttributes ( lr_41 , lr_20 , lr_38 )
. addAttributes ( lr_32 , lr_33 , lr_34 , lr_35 , lr_36 , lr_37 , lr_38 )
. addAttributes ( lr_15 , lr_56 , lr_57 )
. addAttributes ( lr_18 , lr_9 )
. addAttributes ( lr_49 , lr_58 , lr_38 )
. addAttributes ( lr_51 , lr_59 , lr_60 , lr_61 , lr_62 , lr_38 )
. addAttributes (
lr_53 , lr_59 , lr_60 , lr_61 , lr_62 , lr_63 ,
lr_38 )
. addAttributes ( lr_24 , lr_57 )
. addProtocols ( lr_6 , lr_25 , lr_26 , lr_27 , lr_28 , lr_29 )
. addProtocols ( lr_7 , lr_9 , lr_27 , lr_28 )
. addProtocols ( lr_9 , lr_9 , lr_27 , lr_28 )
. addProtocols ( lr_32 , lr_36 , lr_27 , lr_28 )
. addProtocols ( lr_18 , lr_9 , lr_27 , lr_28 )
;
}
public Whitelist addTags ( String ... tags ) {
Validate . notNull ( tags ) ;
for ( String tagName : tags ) {
Validate . notEmpty ( tagName ) ;
tagNames . add ( TagName . valueOf ( tagName ) ) ;
}
return this ;
}
public Whitelist removeTags ( String ... tags ) {
Validate . notNull ( tags ) ;
for( String tag : tags ) {
Validate . notEmpty ( tag ) ;
TagName tagName = TagName . valueOf ( tag ) ;
if( tagNames . remove ( tagName ) ) {
attributes . remove ( tagName ) ;
enforcedAttributes . remove ( tagName ) ;
protocols . remove ( tagName ) ;
}
}
return this ;
}
public Whitelist addAttributes ( String tag , String ... attributes ) {
Validate . notEmpty ( tag ) ;
Validate . notNull ( attributes ) ;
Validate . isTrue ( attributes . length > 0 , lr_64 ) ;
TagName tagName = TagName . valueOf ( tag ) ;
tagNames . add ( tagName ) ;
Set < AttributeKey > attributeSet = new HashSet <> () ;
for ( String key : attributes ) {
Validate . notEmpty ( key ) ;
attributeSet . add ( AttributeKey . valueOf ( key ) ) ;
}
if ( this . attributes . containsKey ( tagName ) ) {
Set < AttributeKey > currentSet = this . attributes . get ( tagName ) ;
currentSet . addAll ( attributeSet ) ;
} else {
this . attributes . put ( tagName , attributeSet ) ;
}
return this ;
}
public Whitelist removeAttributes ( String tag , String ... attributes ) {
Validate . notEmpty ( tag ) ;
Validate . notNull ( attributes ) ;
Validate . isTrue ( attributes . length > 0 , lr_64 ) ;
TagName tagName = TagName . valueOf ( tag ) ;
Set < AttributeKey > attributeSet = new HashSet <> () ;
for ( String key : attributes ) {
Validate . notEmpty ( key ) ;
attributeSet . add ( AttributeKey . valueOf ( key ) ) ;
}
if( tagNames . contains ( tagName ) && this . attributes . containsKey ( tagName ) ) {
Set < AttributeKey > currentSet = this . attributes . get ( tagName ) ;
currentSet . removeAll ( attributeSet ) ;
if( currentSet . isEmpty () )
this . attributes . remove ( tagName ) ;
}
if( tag . equals ( lr_65 ) )
for( TagName name : this . attributes . keySet () ) {
Set < AttributeKey > currentSet = this . attributes . get ( name ) ;
currentSet . removeAll ( attributeSet ) ;
if( currentSet . isEmpty () )
this . attributes . remove ( name ) ;
}
return this ;
}
public Whitelist addEnforcedAttribute ( String tag , String attribute , String value ) {
Validate . notEmpty ( tag ) ;
Validate . notEmpty ( attribute ) ;
Validate . notEmpty ( value ) ;
TagName tagName = TagName . valueOf ( tag ) ;
tagNames . add ( tagName ) ;
AttributeKey attrKey = AttributeKey . valueOf ( attribute ) ;
AttributeValue attrVal = AttributeValue . valueOf ( value ) ;
if ( enforcedAttributes . containsKey ( tagName ) ) {
enforcedAttributes . get ( tagName ) . put ( attrKey , attrVal ) ;
} else {
Map < AttributeKey , AttributeValue > attrMap = new HashMap <> () ;
attrMap . put ( attrKey , attrVal ) ;
enforcedAttributes . put ( tagName , attrMap ) ;
}
return this ;
}
public Whitelist removeEnforcedAttribute ( String tag , String attribute ) {
Validate . notEmpty ( tag ) ;
Validate . notEmpty ( attribute ) ;
TagName tagName = TagName . valueOf ( tag ) ;
if( tagNames . contains ( tagName ) && enforcedAttributes . containsKey ( tagName ) ) {
AttributeKey attrKey = AttributeKey . valueOf ( attribute ) ;
Map < AttributeKey , AttributeValue > attrMap = enforcedAttributes . get ( tagName ) ;
attrMap . remove ( attrKey ) ;
if( attrMap . isEmpty () )
enforcedAttributes . remove ( tagName ) ;
}
return this ;
}
public Whitelist preserveRelativeLinks ( boolean preserve ) {
preserveRelativeLinks = preserve ;
return this ;
}
public Whitelist addProtocols ( String tag , String attribute , String ... protocols ) {
Validate . notEmpty ( tag ) ;
Validate . notEmpty ( attribute ) ;
Validate . notNull ( protocols ) ;
TagName tagName = TagName . valueOf ( tag ) ;
AttributeKey attrKey = AttributeKey . valueOf ( attribute ) ;
Map < AttributeKey , Set < Protocol > > attrMap ;
Set < Protocol > protSet ;
if ( this . protocols . containsKey ( tagName ) ) {
attrMap = this . protocols . get ( tagName ) ;
} else {
attrMap = new HashMap <> () ;
this . protocols . put ( tagName , attrMap ) ;
}
if ( attrMap . containsKey ( attrKey ) ) {
protSet = attrMap . get ( attrKey ) ;
} else {
protSet = new HashSet <> () ;
attrMap . put ( attrKey , protSet ) ;
}
for ( String protocol : protocols ) {
Validate . notEmpty ( protocol ) ;
Protocol prot = Protocol . valueOf ( protocol ) ;
protSet . add ( prot ) ;
}
return this ;
}
public Whitelist removeProtocols ( String tag , String attribute , String ... removeProtocols ) {
Validate . notEmpty ( tag ) ;
Validate . notEmpty ( attribute ) ;
Validate . notNull ( removeProtocols ) ;
TagName tagName = TagName . valueOf ( tag ) ;
AttributeKey attr = AttributeKey . valueOf ( attribute ) ;
Validate . isTrue ( protocols . containsKey ( tagName ) , lr_66 ) ;
Map < AttributeKey , Set < Protocol > > tagProtocols = protocols . get ( tagName ) ;
Validate . isTrue ( tagProtocols . containsKey ( attr ) , lr_66 ) ;
Set < Protocol > attrProtocols = tagProtocols . get ( attr ) ;
for ( String protocol : removeProtocols ) {
Validate . notEmpty ( protocol ) ;
attrProtocols . remove ( Protocol . valueOf ( protocol ) ) ;
}
if ( attrProtocols . isEmpty () ) {
tagProtocols . remove ( attr ) ;
if ( tagProtocols . isEmpty () )
protocols . remove ( tagName ) ;
}
return this ;
}
protected boolean isSafeTag ( String tag ) {
return tagNames . contains ( TagName . valueOf ( tag ) ) ;
}
protected boolean isSafeAttribute ( String tagName , Element el , Attribute attr ) {
TagName tag = TagName . valueOf ( tagName ) ;
AttributeKey key = AttributeKey . valueOf ( attr . getKey () ) ;
Set < AttributeKey > okSet = attributes . get ( tag ) ;
if ( okSet != null && okSet . contains ( key ) ) {
if ( protocols . containsKey ( tag ) ) {
Map < AttributeKey , Set < Protocol > > attrProts = protocols . get ( tag ) ;
return ! attrProts . containsKey ( key ) || testValidProtocol ( el , attr , attrProts . get ( key ) ) ;
} else {
return true ;
}
}
Map < AttributeKey , AttributeValue > enforcedSet = enforcedAttributes . get ( tag ) ;
if ( enforcedSet != null ) {
Attributes expect = getEnforcedAttributes ( tagName ) ;
String attrKey = attr . getKey () ;
if ( expect . hasKeyIgnoreCase ( attrKey ) ) {
return expect . getIgnoreCase ( attrKey ) . equals ( attr . getValue () ) ;
}
}
return ! tagName . equals ( lr_65 ) && isSafeAttribute ( lr_65 , el , attr ) ;
}
private boolean testValidProtocol ( Element el , Attribute attr , Set < Protocol > protocols ) {
String value = el . absUrl ( attr . getKey () ) ;
if ( value . length () == 0 )
value = attr . getValue () ;
if ( ! preserveRelativeLinks )
attr . setValue ( value ) ;
for ( Protocol protocol : protocols ) {
String prot = protocol . toString () ;
if ( prot . equals ( lr_67 ) ) {
if ( isValidAnchor ( value ) ) {
return true ;
} else {
continue;
}
}
prot += lr_68 ;
if ( lowerCase ( value ) . startsWith ( prot ) ) {
return true ;
}
}
return false ;
}
private boolean isValidAnchor ( String value ) {
return value . startsWith ( lr_67 ) && ! value . matches ( lr_69 ) ;
}
Attributes getEnforcedAttributes ( String tagName ) {
Attributes attrs = new Attributes () ;
TagName tag = TagName . valueOf ( tagName ) ;
if ( enforcedAttributes . containsKey ( tag ) ) {
Map < AttributeKey , AttributeValue > keyVals = enforcedAttributes . get ( tag ) ;
for ( Map . Entry < AttributeKey , AttributeValue > entry : keyVals . entrySet () ) {
attrs . put ( entry . getKey () . toString () , entry . getValue () . toString () ) ;
}
}
return attrs ;
}
static TagName valueOf ( String value ) {
return new TagName ( value ) ;
}
static AttributeKey valueOf ( String value ) {
return new AttributeKey ( value ) ;
}
static AttributeValue valueOf ( String value ) {
return new AttributeValue ( value ) ;
}
static Protocol valueOf ( String value ) {
return new Protocol ( value ) ;
}
@Override
public int hashCode () {
final int prime = 31 ;
int result = 1 ;
result = prime * result + ( ( value == null ) ? 0 : value . hashCode () ) ;
return result ;
}
@Override
public boolean equals ( Object obj ) {
if ( this == obj ) return true ;
if ( obj == null ) return false ;
if ( getClass () != obj . getClass () ) return false ;
TypedValue other = ( TypedValue ) obj ;
if ( value == null ) {
return other . value == null ;
} else return value . equals ( other . value ) ;
}
@Override
public String toString () {
return value ;
}
