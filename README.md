# PPT #1: Up and Down the Points Table

## Overview

A soccer tournament uses a multi-division multi-bracket approach. There are four ordered divisions, Division 4 to Division 1, with Division 1 being the best. Each division consists of four brackets, Bracket 4 to Bracket 1, with Bracket 1 being the highest-ranked bracket in a division. In effect there are 16 levels.

Teams play games and each win gains them 2 points. A draw is 0 points and a loss results in the loss of 1 point.

All teams start in Bracket 4 of Division 4. 

A teams points are capped at 5 points (except in Bracket 1 of Division 1). If a team is at 5 points and has won three games in a row then they are promoted to the next bracket. If a team is in Bracket 1 of a division (except Division 1) then they are promoted to the next (higher) division and their points are reset. A team does not go below 0 points. If a team is at 0 points and has lost three games in a row then they are moved to the lower bracket. **But** a team is moved to a lower division (from Bracket 4 of a division) only if it loses five games in a row.

## Tasks

### Task 1

Implement a `TeamTracker` type that allows us to add results for a team. 

- The `TeamTracker` type has a constructor that takes a `String` as an argument and the `String` represents the history for that team, with **W** representing a win, **L** representing a loss, and **D** representing a draw.
- The type has an `addResult` method that takes a character as input that represents the result of the most recent game.
- The type has an `addResult` method that takes a `String` as input and that represents the results of a sequence of recent games, with the first character of the `String` representing the earliest game in the sequence and the last character represent the most recent game played.
- Implement a method that returns the overall fraction of games won.
- Implement a method that returns the overall fraction of games lost.
- Implement a method that returns the overall fraction of games drawn.
- Implement a method that returns the total number of games played.

### Task 2
 
- Implement a method that returns the level that the team is currently at (which division, which bracket). We have provided a datatype `Level` that has two fields: `division` and `bracket`.
- Implement a method to check if two teams are at the same level. 

### Task 3

- Return a `List` that consists of the points that a team has obtained in all the games that they have played. The element at the 0th index of the list are the points from the first game played and the last element are the points from most recent game the team played. (This `List` should not make the type *indirectly* mutable.)
- Implement methods that take a `Level` as an argument and return the fraction of games won, lost, or drawn at that level, respectively.
- Implement a method, `similar`, that takes another `TeamTracker` as argument and returns `true` if the two teams have the same win/loss/draw fraction for games at each level (with a tolerance of 0.01). If one team has played at a higher level than the other team then only consider the levels they have jointly played at.

### Task 4

For two teams, assuming they started playing at the same time (they started in Division 4 Bracket 4 jointly), return the maximum number of games that they **could have** played against each other. 

Let g(A, i) be game i that team A played and let g(B, j) be game j that team B played. We will say that g(A, i) is g(B, j) if the teams played each other in that game. They may have played each other in this game if the following three conditions hold:

* A and B are both at the same level when they played g(A, i) and g(B, j) (divisions and brackets need to be aligned);
* g(A, i-1) was not against team B and g(B, j-1) was not against team A (no team plays consecutive games against the same opponent); 
* g(A, i) was a W and g(B, j) was an L (or vice versa), or g(A, i) and g(B, j) were both D (results have to be consistent).

**Examples**: 

1. Suppose Team A's record is WLL and Team B's record is LWW; then the two teams could have played each other in games 1 and 3 respectively. In other words, g(A, 1) could be g(B, 1) and g(A, 3) could be g(B, 3). They could have played in at most two games. If g(A, 2) were g(B, 2) then they could have played each other in at most one game. 
2. If Team A's record is WDW and Team B's record is WDL then they could have played each other in one game (their second or third game). g(A, 1) cannot be g(B, 1) because A and B won their first games.
3. If Team A's record is WWLW and Team B's record is LWL then g(A, 1) could g(B, 1) and g(A, 4) could be g(B, 3), and they would have played a maximum of two games against each other. 
4. If Team A's record is LWWWWWW and Team B's record is LLWLWL then g(A, 2) could be g(B, 1) and g(A, 4) could be  g(B, 4); g(A, 7) cannot be g(B, 6) because Team A is in Division 4 Bracket 3 at that the time of g(A, 7) and Team B is in Division 4 Bracket 4 at the time of g(B, 4).
