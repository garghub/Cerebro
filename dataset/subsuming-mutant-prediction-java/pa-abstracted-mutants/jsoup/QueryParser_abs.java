public static Evaluator parse ( String query ) {
try {
QueryParser p = new QueryParser ( query ) ;
return p . parse () ;
} catch ( IllegalArgumentException e ) {
throw new Selector . SelectorParseException ( e . getMessage () ) ;
}
}
Evaluator parse () {
tq . consumeWhitespace () ;
if ( tq . matchesAny ( combinators ) ) {
evals . add ( new StructuralEvaluator . Root () ) ;
combinator ( tq . consume () ) ;
} else {
findElements () ;
}
while ( ! tq . isEmpty () ) {
boolean seenWhite = tq . consumeWhitespace () ;
if ( tq . matchesAny ( combinators ) ) {
combinator ( tq . consume () ) ;
} else if ( seenWhite ) {
combinator ( ' ' ) ;
} else {
findElements () ;
}
}
if ( evals . size () == 1 )
return evals . get ( 0 ) ;
return new CombiningEvaluator . And ( evals ) ;
}
private void combinator ( char combinator ) {
tq . consumeWhitespace () ;
String subQuery = consumeSubQuery () ;
Evaluator rootEval ;
Evaluator currentEval ;
Evaluator newEval = parse ( subQuery ) ;
boolean replaceRightMost = false ;
if ( evals . size () == 1 ) {
rootEval = currentEval = evals . get ( 0 ) ;
if ( rootEval instanceof CombiningEvaluator . Or && combinator != ',' ) {
currentEval = ( ( CombiningEvaluator . Or ) currentEval ) . rightMostEvaluator () ;
replaceRightMost = true ;
}
}
else {
rootEval = currentEval = new CombiningEvaluator . And ( evals ) ;
}
evals . clear () ;
if ( combinator == '>' )
currentEval = new CombiningEvaluator . And ( newEval , new StructuralEvaluator . ImmediateParent ( currentEval ) ) ;
else if ( combinator == ' ' )
currentEval = new CombiningEvaluator . And ( newEval , new StructuralEvaluator . Parent ( currentEval ) ) ;
else if ( combinator == '+' )
currentEval = new CombiningEvaluator . And ( newEval , new StructuralEvaluator . ImmediatePreviousSibling ( currentEval ) ) ;
else if ( combinator == '~' )
currentEval = new CombiningEvaluator . And ( newEval , new StructuralEvaluator . PreviousSibling ( currentEval ) ) ;
else if ( combinator == ',' ) {
CombiningEvaluator . Or or ;
if ( currentEval instanceof CombiningEvaluator . Or ) {
or = ( CombiningEvaluator . Or ) currentEval ;
or . add ( newEval ) ;
} else {
or = new CombiningEvaluator . Or () ;
or . add ( currentEval ) ;
or . add ( newEval ) ;
}
currentEval = or ;
}
else
throw new Selector . SelectorParseException ( lr_1 + combinator ) ;
if ( replaceRightMost )
( ( CombiningEvaluator . Or ) rootEval ) . replaceRightMostEvaluator ( currentEval ) ;
else rootEval = currentEval ;
evals . add ( rootEval ) ;
}
private String consumeSubQuery () {
StringBuilder sq = StringUtil . borrowBuilder () ;
while ( ! tq . isEmpty () ) {
if ( tq . matches ( lr_2 ) )
sq . append ( lr_2 ) . append ( tq . chompBalanced ( '(' , ')' ) ) . append ( lr_3 ) ;
else if ( tq . matches ( lr_4 ) )
sq . append ( lr_4 ) . append ( tq . chompBalanced ( '[' , ']' ) ) . append ( lr_5 ) ;
else if ( tq . matchesAny ( combinators ) )
break;
else
sq . append ( tq . consume () ) ;
}
return StringUtil . releaseBuilder ( sq ) ;
}
private void findElements () {
if ( tq . matchChomp ( lr_6 ) )
byId () ;
else if ( tq . matchChomp ( lr_7 ) )
byClass () ;
else if ( tq . matchesWord () || tq . matches ( lr_8 ) )
byTag () ;
else if ( tq . matches ( lr_4 ) )
byAttribute () ;
else if ( tq . matchChomp ( lr_9 ) )
allElements () ;
else if ( tq . matchChomp ( lr_10 ) )
indexLessThan () ;
else if ( tq . matchChomp ( lr_11 ) )
indexGreaterThan () ;
else if ( tq . matchChomp ( lr_12 ) )
indexEquals () ;
else if ( tq . matches ( lr_13 ) )
has () ;
else if ( tq . matches ( lr_14 ) )
contains ( false ) ;
else if ( tq . matches ( lr_15 ) )
contains ( true ) ;
else if ( tq . matches ( lr_16 ) )
containsData () ;
else if ( tq . matches ( lr_17 ) )
matches ( false ) ;
else if ( tq . matches ( lr_18 ) )
matches ( true ) ;
else if ( tq . matches ( lr_19 ) )
not () ;
else if ( tq . matchChomp ( lr_20 ) )
cssNthChild ( false , false ) ;
else if ( tq . matchChomp ( lr_21 ) )
cssNthChild ( true , false ) ;
else if ( tq . matchChomp ( lr_22 ) )
cssNthChild ( false , true ) ;
else if ( tq . matchChomp ( lr_23 ) )
cssNthChild ( true , true ) ;
else if ( tq . matchChomp ( lr_24 ) )
evals . add ( new Evaluator . IsFirstChild () ) ;
else if ( tq . matchChomp ( lr_25 ) )
evals . add ( new Evaluator . IsLastChild () ) ;
else if ( tq . matchChomp ( lr_26 ) )
evals . add ( new Evaluator . IsFirstOfType () ) ;
else if ( tq . matchChomp ( lr_27 ) )
evals . add ( new Evaluator . IsLastOfType () ) ;
else if ( tq . matchChomp ( lr_28 ) )
evals . add ( new Evaluator . IsOnlyChild () ) ;
else if ( tq . matchChomp ( lr_29 ) )
evals . add ( new Evaluator . IsOnlyOfType () ) ;
else if ( tq . matchChomp ( lr_30 ) )
evals . add ( new Evaluator . IsEmpty () ) ;
else if ( tq . matchChomp ( lr_31 ) )
evals . add ( new Evaluator . IsRoot () ) ;
else if ( tq . matchChomp ( lr_32 ) )
evals . add ( new Evaluator . MatchText () ) ;
else
throw new Selector . SelectorParseException ( lr_33 , query , tq . remainder () ) ;
}
private void byId () {
String id = tq . consumeCssIdentifier () ;
Validate . notEmpty ( id ) ;
evals . add ( new Evaluator . Id ( id ) ) ;
}
private void byClass () {
String className = tq . consumeCssIdentifier () ;
Validate . notEmpty ( className ) ;
evals . add ( new Evaluator . Class ( className . trim () ) ) ;
}
private void byTag () {
String tagName = normalize ( tq . consumeElementSelector () ) ;
Validate . notEmpty ( tagName ) ;
if ( tagName . startsWith ( lr_8 ) ) {
evals . add ( new CombiningEvaluator . Or ( new Evaluator . Tag ( tagName ) , new Evaluator . TagEndsWith ( tagName . replace ( lr_8 , lr_34 ) ) ) ) ;
} else {
if ( tagName . contains ( lr_35 ) )
tagName = tagName . replace ( lr_35 , lr_34 ) ;
evals . add ( new Evaluator . Tag ( tagName ) ) ;
}
}
private void byAttribute () {
TokenQueue cq = new TokenQueue ( tq . chompBalanced ( '[' , ']' ) ) ;
String key = cq . consumeToAny ( AttributeEvals ) ;
Validate . notEmpty ( key ) ;
cq . consumeWhitespace () ;
if ( cq . isEmpty () ) {
if ( key . startsWith ( lr_36 ) )
evals . add ( new Evaluator . AttributeStarting ( key . substring ( 1 ) ) ) ;
else
evals . add ( new Evaluator . Attribute ( key ) ) ;
} else {
if ( cq . matchChomp ( lr_37 ) )
evals . add ( new Evaluator . AttributeWithValue ( key , cq . remainder () ) ) ;
else if ( cq . matchChomp ( lr_38 ) )
evals . add ( new Evaluator . AttributeWithValueNot ( key , cq . remainder () ) ) ;
else if ( cq . matchChomp ( lr_39 ) )
evals . add ( new Evaluator . AttributeWithValueStarting ( key , cq . remainder () ) ) ;
else if ( cq . matchChomp ( lr_40 ) )
evals . add ( new Evaluator . AttributeWithValueEnding ( key , cq . remainder () ) ) ;
else if ( cq . matchChomp ( lr_41 ) )
evals . add ( new Evaluator . AttributeWithValueContaining ( key , cq . remainder () ) ) ;
else if ( cq . matchChomp ( lr_42 ) )
evals . add ( new Evaluator . AttributeWithValueMatching ( key , Pattern . compile ( cq . remainder () ) ) ) ;
else
throw new Selector . SelectorParseException ( lr_43 , query , cq . remainder () ) ;
}
}
private void allElements () {
evals . add ( new Evaluator . AllElements () ) ;
}
private void indexLessThan () {
evals . add ( new Evaluator . IndexLessThan ( consumeIndex () ) ) ;
}
private void indexGreaterThan () {
evals . add ( new Evaluator . IndexGreaterThan ( consumeIndex () ) ) ;
}
private void indexEquals () {
evals . add ( new Evaluator . IndexEquals ( consumeIndex () ) ) ;
}
private void cssNthChild ( boolean backwards , boolean ofType ) {
String argS = normalize ( tq . chompTo ( lr_3 ) ) ;
Matcher mAB = NTH_AB . matcher ( argS ) ;
Matcher mB = NTH_B . matcher ( argS ) ;
final int a , b ;
if ( lr_44 . equals ( argS ) ) {
a = 2 ;
b = 1 ;
} else if ( lr_45 . equals ( argS ) ) {
a = 2 ;
b = 0 ;
} else if ( mAB . matches () ) {
a = mAB . group ( 3 ) != null ? Integer . parseInt ( mAB . group ( 1 ) . replaceFirst ( lr_46 , lr_47 ) ) : 1 ;
b = mAB . group ( 4 ) != null ? Integer . parseInt ( mAB . group ( 4 ) . replaceFirst ( lr_46 , lr_47 ) ) : 0 ;
} else if ( mB . matches () ) {
a = 0 ;
b = Integer . parseInt ( mB . group () . replaceFirst ( lr_46 , lr_47 ) ) ;
} else {
throw new Selector . SelectorParseException ( lr_48 , argS ) ;
}
if ( ofType )
if ( backwards )
evals . add ( new Evaluator . IsNthLastOfType ( a , b ) ) ;
else
evals . add ( new Evaluator . IsNthOfType ( a , b ) ) ;
else {
if ( backwards )
evals . add ( new Evaluator . IsNthLastChild ( a , b ) ) ;
else
evals . add ( new Evaluator . IsNthChild ( a , b ) ) ;
}
}
private int consumeIndex () {
String indexS = tq . chompTo ( lr_3 ) . trim () ;
Validate . isTrue ( StringUtil . isNumeric ( indexS ) , lr_49 ) ;
return Integer . parseInt ( indexS ) ;
}
private void has () {
tq . consume ( lr_50 ) ;
String subQuery = tq . chompBalanced ( '(' , ')' ) ;
Validate . notEmpty ( subQuery , lr_51 ) ;
evals . add ( new StructuralEvaluator . Has ( parse ( subQuery ) ) ) ;
}
private void contains ( boolean own ) {
tq . consume ( own ? lr_52 : lr_53 ) ;
String searchText = TokenQueue . unescape ( tq . chompBalanced ( '(' , ')' ) ) ;
Validate . notEmpty ( searchText , lr_54 ) ;
if ( own )
evals . add ( new Evaluator . ContainsOwnText ( searchText ) ) ;
else
evals . add ( new Evaluator . ContainsText ( searchText ) ) ;
}
private void containsData () {
tq . consume ( lr_55 ) ;
String searchText = TokenQueue . unescape ( tq . chompBalanced ( '(' , ')' ) ) ;
Validate . notEmpty ( searchText , lr_56 ) ;
evals . add ( new Evaluator . ContainsData ( searchText ) ) ;
}
private void matches ( boolean own ) {
tq . consume ( own ? lr_57 : lr_58 ) ;
String regex = tq . chompBalanced ( '(' , ')' ) ;
Validate . notEmpty ( regex , lr_59 ) ;
if ( own )
evals . add ( new Evaluator . MatchesOwn ( Pattern . compile ( regex ) ) ) ;
else
evals . add ( new Evaluator . Matches ( Pattern . compile ( regex ) ) ) ;
}
private void not () {
tq . consume ( lr_60 ) ;
String subQuery = tq . chompBalanced ( '(' , ')' ) ;
Validate . notEmpty ( subQuery , lr_61 ) ;
evals . add ( new StructuralEvaluator . Not ( parse ( subQuery ) ) ) ;
}
