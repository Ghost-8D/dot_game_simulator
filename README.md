# dot_game_simulator

This program creates simulations of the __connect the dots game__, where two players compete with each other. The simulation is not entirely random, as the players are forced to complete the boxes, if they can, and then choose a random move.

### Requirements:
- javac >= 11.0.2

### Usage

To compile the java program execute the following commands in terminal (MacOS/Linux) or in command line (Windows):
```bash 
cd dot_game_simulator
javac -cp ./stdlib.jar DotGameSimulator.java
```

To execute the program run the following command in terminal (MacOS/Linux) or in command line (Windows):
```bash
java -cp .:./stdlib.jar DotGameSimulator N # where NxN is the dimensions of the grid
```

### Execution example 
```bash
java -cp .:./stdlib.jar DotGameSimulator 50
```

Output:
![](https://github.com/Ghost-8D/dot_game_simulator/blob/master/dot_game_simulation/dot_game_simulator_50.png)

> Note: Each execution will be different as the simulation include some randomness.
