# B I G   B O Y   G U I   C H E S S

_i got the idea and used concepts from a netlogo project i saw at the dojo. the main principle is having "patches" with unique "who" numbers identifying each of them and what piece (if any) is on the "patch."_

## Team Members                                                   
Jason Tung                                                     

## Team Name
Dynamic Duo

## Project Title
Big Boy GUI Chess

## I. Project Idea
 - A turn based strategy based on the a real life game which you may or may not be familiar with -- chess. 

 - Start with a setup board of chess pieces and play a game of chess with or without the timer. 

 - Players take turns moving pieces until either player is in checkmate.

 - Each player has 16 pieces: 1 king, 1 queen, 2 rooks, 2 bishops, 2 knights, and 8 pawns.
 - Pieces move in different ways depending on their types.
 - The ultimate goal is to trap the enemy’s king piece such that it is in check and there are no moves it can make without it being captured. 
 - Check: when a king piece is going to be captured next turn if there is no interception, or the king does not move. 
 - Pieces can move and capture other pieces.
 - There is a set of special moves such as en passant, castling, and promotion.

## II. Critical Features
### 1. Distinct Checkerboard Squares
 - The basis for placement and movement of pieces

### 2. Chess Pieces
 - Movement
 - Capture -- Pieces only capturing opposite color pieces
 - Non-standard movement (en passant, castling, promotion)
 - Appears on the GUI

### 3. Check & Checkmate
 - Figure out if a player is in check or checkmate (The hardest part )

### 4. Turns
 - Each player takes a turn

### 5. Win, Lose, Stalemate
 - Win/Lose is checkmate
 - Stalemate for when the checked player has no legal moves

### 6. GUI Implementation
 - Puts the chess game onto GUI
 
## III. To Be Added Later Features
 - Nice looking pieces
 - Selecting a piece will display all possible paths it can take
 - Timer
 - AI (HARD)
 - Animations
 - Move log

## IV. Development stages

### I plan on writing everything in Terminal before moving into GUI

 - [x] Make a board
 - [x] ~~Pack square into a package~~
 - [ ] Move board to GUI
 - [ ] Make ugly looking pieces **moved to later stage**
 - [x] ~~Game class which store pieces and their coordinates (probably a hash map or super array)~~ put them into ary
 - [x] Make abstract class chessPiece
 - [x] Write child classes for pieces
 - [x] Setup up board
 - [ ] Discover list of possible moves for x piece **might not be needed**
 - [ ] Write movement & capture
 - [ ] Make GUI pieces **moved from earlier stage**
 - [ ] Write board in GUI
 - [ ] Implement Pieces onto the GUI
 - [ ] Movement on GUI
 - [ ] Write special moves 
 - [ ] Implement into GUI and test
 - [ ] Write,  implement, test check
 - [ ] Write,  implement, test checkmate
 - [ ] Write,  implement, test stalemate
 
**MINIMUM FUNCTIONALITY ACHIEVED**

 - [ ] Add a timer for turns
 - [ ] Log moves on the side of the GUI
 - [ ] Make pieces look nice
 - [ ] Display possible paths
 - [ ] Add animations
 - [ ] Write a (bad) AI

## What I'm Up To
 - Making tile class
 - Writing chesspiece abstract class
 - Writing Chesspiece child classes
   - including list of possible moves
 - Organizing Packages
 - Making board
 - Putting pieces on board
 - Board setup
 - **CURRENT** Movement

## To Work On
 - Preset scenarios
 - GUI Implementation
