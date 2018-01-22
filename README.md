# Chess

## chess printed into the terminal
move pieces in different ways to capture the enemy king

## instructions printed by typing
'''java Board help'''

 - - HELP MENU - - 
this is chess, but it's in the terminal.
~~soon it will be moved to the GUI (i hope...)~~
please make sure your file actually exists or that youre saving a board that exists
syntax:
'''java Board'''--prints the board
'''java Board new'''--sets up the board
'''java Board x1 y1 x2 y2'''--moves piece at x1,y1 to x2,y2 and prints the new possible moves
'''java Board x1 y1'''--shows possible moves for x1 y1
'''java Board save filename'''--saves game into filename so you can open it up later
'''java Board open filename'''--opens up the game in filename
'''java Board force x1 y1 x2 y2'''--forces the piece to move, but it's for experimentation (i.e. not a part of the game, only for testing)

## key
each slot printed follows this notation: (c)(p)@x.y
c is the color (either b for black or w for white)
p is the piece
 - p for pawn
 - r for rook
 - n for knight
 - b for bishop
 - q for queen
 - k for king
x is the x-coordinate & y is the y-coordinate
e.g. wp@0.4 means there is a white pawn at the point (0,4)

## what i was able to add
in my limited time, i was able to add:
 - chesspiece movement
 - turns
 - check (not really)
 - checkmate (not really)
 - saving games
 - opening games
 - sample games (type '''java Board open sample''')

## what i dont have
 - a gui
 - "checkmate' is really just killing the enemy king
 - check doesnt limit movement
 - have to run the program once for each move -- i learned about console reading too late to implement it
 - special moves (hard to implement because of the way my movement works)

## summary
 i have the majority of the BASIC, BASIC chess game done. 