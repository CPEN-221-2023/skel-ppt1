# PPT #1: Up and Down the Points Table
## Overview
A soccer tournament uses a multi-division multi-bracket approach. There are four ordered divisions, Division 4 to Division 1, with Division 1 being the best. Each division consists of four brackets, Bracket 4 to Bracket 1, with Bracket 1 being the highest-ranked bracket in a division. In effect there are 16 levels.

Teams play games and each win gains them 2 points. A draw is 0 points and a loss results in the loss of 1 point.

All teams start in Bracket 4 of Division 4. 

A teams points are capped at 5 points (except in Bracket 1 of Division 1). If a team is at 5 points and has won three games in a row then they are promoted to the next bracket. If a team is in Bracket 1 of a division (except Division 1) then they are promoted to the next (higher) division and their points are reset. A team does not go below 0 points. If a team is at 0 points and has lost three games in a row then they are moved to the lower bracket. **But** a team is moved to a lower division (from Bracket 4 of a division) only if it loses five games in a row.

## Tasks
### Task 1
Implement a `teamtracker` type that allows us to add results for a team. 

- The `teamtracker` type has a constructor that takes a `String` as an argument and the `String` represents the history for that team, with **W** representing a win, **L** representing a loss, and **D** representing a draw.
- The type has an `addResult` method that takes a character as input that represents the result of the most recent game.
- The type has an `addResult` method that takes a `String` as input and that represents the results of a sequence of recent games, with the first character of the `String` representing the earliest game in the sequence and the last character represent the most recent game played.
- Implement a method that computes the overall fraction of games won.
- Implement a method that computes the overall fraction of games lost.
- Implement a method that computes the overall fraction of games drawn.
- Implement a method that returns the total number of games played.
### Task 2
- Implement a method that returns the level that the team is currently at (which division, which bracket).
- We provide a datatype `Level` that has two fields: `division` and `bracket`.
- Check if two teams are at the same level. (One has to implement `equals` for `Level`.)
### Task 3
- Return a `List` that consists of the points that a team has obtained in all the games that they have played. The element at the 0th index of the list are the points from the first game played and the last element are the points from most recent game the team played. (This `List` should not make the type *indirectly* mutable.)
- Implement methods that takes a `Level` as an argument and returns the fraction of games won, lost, drawn at that level.
- Implement a method, `similar`, that takes another `teamtracker` as argument and returns `true` if the two teams have the win/loss/draw fraction for games at each level (with a tolerance of 0.01). If one team has played at a higher level than the other team then only consider the levels they have jointly played at.
### Task 4
- For two teams, assuming they started playing at the same time (they started in Division 4 Bracket 4 jointly), return a list of games that they **could have** played against each other. The two teams could have played Game M against each other if they were at the same level at that time and if the results are consistent (Team 1 has a W and Team 2 has an L for that game or vice versa, or both teams have a draw for that game). The implementation has to return the indices of all such games. If one team has played more games than the other then consider only the smaller number of games for this analysis.
    - Example: Teams with records WLL and LWW could have played against each other in all three games. Teams with records WDW and WDL could have played against each other only in the last two games. (They both could not have won the first game.)
