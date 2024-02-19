# MarsRover

### Examples

![Examples](https://cdn.discordapp.com/attachments/1108167978714923110/1208987234888323122/Capture.PNG?ex=65e5481a&is=65d2d31a&hm=33ce82b24e235e0a8b7ea2c0fba1a1d502c529629a2f7a6354bb3931fc2691d8&)



"Specification

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that the on board
cameras can get a complete view of the surrounding terrain to send back to Earth. A rover’s position is represented by a combination of x and y co-ordinates and a letter
presenting one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in
the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively,
without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

Input

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0. The rest of the input is information pertaining to the rovers
that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore
the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation. Each rover will be
finished

sequentially, which means that the second rover won’t start to move until the first one has finished moving.

Output

The output for each rover should be its final co-ordinates and heading."

"Have a think about things that aren’t mentioned in the specification. Remember, these are multi-million dollar robots on a mission that’s cost billions and taken up to a year to get there!"

## My Implementaion

You can add as many rovers as you like.

A rover cannot leave the bounds of the plateau - this was something that I assumed from the comment talking about things that aren't included in the spec

A rover **couldn't**  occupy the same space as a another rover when moving but this resulted in an output that was contradictory to the examples.

