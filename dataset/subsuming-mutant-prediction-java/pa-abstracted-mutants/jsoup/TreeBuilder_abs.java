protected void initialiseParse ( Reader input , String baseUri , Parser parser ) {
Validate . notNull ( input , lr_1 ) ;
Validate . notNull ( baseUri , lr_2 ) ;
doc = new Document ( baseUri ) ;
doc . parser ( parser ) ;
this . parser = parser ;
settings = parser . settings () ;
reader = new CharacterReader ( input ) ;
currentToken = null ;
tokeniser = new Tokeniser ( reader , parser . getErrors () ) ;
stack = new ArrayList <> ( 32 ) ;
this . baseUri = baseUri ;
}
Document parse ( Reader input , String baseUri , Parser parser ) {
initialiseParse ( input , baseUri , parser ) ;
runParser () ;
return doc ;
}
protected void runParser () {
while ( true ) {
Token token = tokeniser . read () ;
process ( token ) ;
token . reset () ;
if ( token . type == Token . TokenType . EOF )
break;
}
}
protected boolean processStartTag ( String name ) {
if ( currentToken == start ) {
return process ( new Token . StartTag () . name ( name ) ) ;
}
return process ( start . reset () . name ( name ) ) ;
}
public boolean processStartTag ( String name , Attributes attrs ) {
if ( currentToken == start ) {
return process ( new Token . StartTag () . nameAttr ( name , attrs ) ) ;
}
start . reset () ;
start . nameAttr ( name , attrs ) ;
return process ( start ) ;
}
protected boolean processEndTag ( String name ) {
if ( currentToken == end ) {
return process ( new Token . EndTag () . name ( name ) ) ;
}
return process ( end . reset () . name ( name ) ) ;
}
protected Element currentElement () {
int size = stack . size () ;
return size > 0 ? stack . get ( size - 1 ) : null ;
}
protected void error ( String msg ) {
ParseErrorList errors = parser . getErrors () ;
if ( errors . canAddError () )
errors . add ( new ParseError ( reader . pos () , msg ) ) ;
}
