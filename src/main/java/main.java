import java.util.Scanner;
import java.util.ArrayList;
class Rover {
    int x;
    int y;
    int direction;

    Plateau currentPlateau;
    public Rover(int initX, int initY, int Direction, Plateau P1){
        x = initX;
        y = initY;
        direction = Direction;
        currentPlateau = P1; //Later addition for making sure rover doesn't leave plateau
    }

    void move(String instructions){
        String[] instructionArray = instructions.split("");
        for(int i = 0; i < instructionArray.length; i++) {
            instructionArray[i] = instructionArray[i].toUpperCase();
            switch (instructionArray[i]){
                case "R":
                    direction = direction == 3 ? 0 : direction + 1;
                    break;
                case "L":
                    direction = direction == 0 ? 3 : direction - 1;
                    break;
                case "M":
                    moveForward();
            }
        }
    }

    //Note to self:
    //North = 0 | Y + 1
    //East = 1 | X + 1
    //South = 2 | Y - 1
    //West = 3 | Y - 1
    void moveForward(){ //was going to move validation to own function
        switch (direction){
            case 0:
                y = !((y + 1) > currentPlateau.YUpperBound) ?  y + 1 : y;
                break;
            case 1:
                x = !((x + 1) > currentPlateau.XUpperBound) ? x + 1 : x;
                break;
            case 2:
                y = !((y - 1) < currentPlateau.YLowerBound) ? y - 1 : y;
                break;
            case 3:
                x = !((x - 1 ) < currentPlateau.XLowerBound) ?  x - 1 : x;
                break;
        }
    }


}

class Plateau{
    int XUpperBound;
    int YUpperBound;
    int XLowerBound;
    int YLowerBound;

    ArrayList<Rover> deployedRovers = new ArrayList<Rover>();
    public Plateau(int XUpper, int YUpper){
        XUpperBound = XUpper;
        YUpperBound = YUpper;
        XLowerBound = 0;
        YLowerBound = 0;
    }

    //For making sure rovers don't bump into one another
    void addDeployedRover(Rover roverN){
        deployedRovers.add(roverN);
    }

}

public class main {

    static int DirectionToInt(String direction){
        direction = direction.trim().toUpperCase();
        switch (direction){
            case "N":
                return 0;
            case "E":
                return 1;
            case "S":
                return 2;
            case "W":
                return 3;
        }
        return 99999; // Throw error here instead
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        //Since this is constant per run in this example, it's set first
        System.out.println("Enter the top right co-ordinates (X, Y): ");
        int XUpperBound = reader.nextInt();
        int YUpperBound = reader.nextInt();

        Plateau plateau1 = new Plateau(XUpperBound, YUpperBound);

        //loop here so there can be n amount of rovers
        for(int i = 1; i != 0; i++ ){
            System.out.println("Set initial state of Rover " + i + " in format of X Y Direction(N/E/S/W)");
            int Rover1InitialPosX = reader.nextInt();
            int Rover1InitialPosY = reader.nextInt();
            //As a bonus feature, rovers can't occupy the same tile
            if (!(checkInitialPlacement(Rover1InitialPosX, Rover1InitialPosY, plateau1))){
                System.out.println("This rover landed on and has destroyed another rover");
                continue;
            };
            int Rover1InitialDirection = DirectionToInt(reader.nextLine());
            Rover rover1 = new Rover(Rover1InitialPosX, Rover1InitialPosY, Rover1InitialDirection, plateau1);
            plateau1.addDeployedRover(rover1);
            System.out.println("Input movement instructions for Rover " + i + " R and L to rotate rover left and right respectively and M will move it 1 tile forward (make sure there is a space between each input)");
            String r1Instructions = reader.nextLine();
            rover1.move(r1Instructions);
            System.out.println("Final Destination: " + rover1.x + " " + rover1.y + " " + parseCardinalDirection(rover1.direction));
        }

    }

    static boolean checkInitialPlacement(int x, int y, Plateau plat1) {
        for(int i = 0; i < plat1.deployedRovers.size(); i++){
            Rover rov = plat1.deployedRovers.get(i);
//            System.out.println(x == rov.x );
            if(x == rov.x && y == rov.y){
                return false;
            }
        }
        return true;
    }

    static String parseCardinalDirection(int direction){
        switch (direction){
            case 0:
                return "N";
            case 1:
                return "E";
            case 2:
                return "S";
            case 3:
                return "W";
        }
        return "ERROR";
    }
}
