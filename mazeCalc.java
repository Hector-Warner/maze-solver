import java.util.Arrays;

public class mazeCalc {
    int mazeWidth = 20;
    int mazeHeight = 20;

    int[] coords = {1,1};
    int[] goalCoords = {12,9};

    int [][] mazeLayout =
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}

            };

    public int mazeSolver(int coordX, int coordY, int cost) {
        int[] function = new int[4];
        int smallestNum = 1000;
        int[] newCoords = new int[2];
        if (mazeLayout[coordY][coordX - 1] == 0) {
            function[0] = cost + 1 + Math.abs(coordX - goalCoords[1]) + Math.abs(coordY - 1 - goalCoords[0]);
            smallestNum = function[0];
            newCoords = new int[]{coordY, coordX - 1};
        } else {
            function[0] = 1000;
        }
        if (mazeLayout[coordY][coordX + 1] == 0) {
            function[1] = cost + 1 + Math.abs(coordX - goalCoords[1]) + Math.abs(coordY + 1 - goalCoords[0]);
            if (function[1] < function[0]) {
                smallestNum = function[1];
                newCoords = new int[]{coordY, coordX + 1};
            }
        } else {
            function[0] = 1000;
        }
        if (mazeLayout[coordY - 1][coordX] == 0) {
            function[2] = cost + 1 + Math.abs(coordX - 1 - goalCoords[1]) + Math.abs(coordY - goalCoords[0]);
            if (function[2] < smallestNum) {
                smallestNum = function[2];
                newCoords = new int[]{coordY - 1, coordX};
            }
        } else {
            function[2] = 1000;
        }
        if (mazeLayout[coordY + 1][coordX] == 0) {
            function[3] = cost + 1 + Math.abs(coordX + 1 - goalCoords[1]) + Math.abs(coordY - goalCoords[0]);
            if (function[3] < smallestNum) {
                smallestNum = function[3];
                newCoords = new int[]{coordY + 1, coordX};
            }
        } else {
            function[3] = 1000;
        }
        if (smallestNum == 1000) {
            //coordX =
        }
        System.out.println(Arrays.toString(function));
        mazeLayout[coordY][coordX] = 2;
        for (int i = 0; i < mazeLayout.length; i++) {
            System.out.println(Arrays.toString(mazeLayout[i]));
        }
        mazeSolver(newCoords[1], newCoords[0], cost + 1);
        return cost + 1;
    }

    //A* Algorithm - f(n) = g(n) + h(n)
    // h(n) - Manhattan distance from coord to goal
    // g(n) - total cost


    public static void main(String args[]) {
        mazeCalc newMaze = new mazeCalc();
        newMaze.mazeSolver(newMaze.coords[1],newMaze.coords[0], 0);



    }
}
