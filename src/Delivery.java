import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by desktop on 15/07/2016.
 */
public class Delivery {

    private int numberOfNodes;
    private Stack<Integer> stack;

    public Delivery(){
        stack = new Stack<>();

    }

    public void travellingSalesmanP(int adjacencyMatrix[][]){
        numberOfNodes = adjacencyMatrix[1].length -1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        int min;
        int shortestDistance = 0;
        boolean minFlag = false;
        System.out.print(1 + "\t");

        while (!stack.isEmpty()){
            element = stack.peek();
            i=1;
            min = Integer.MAX_VALUE;

            while(i <= numberOfNodes){
                if(adjacencyMatrix[element][i]>1 && visited[i] == 0)
                {
                    if(min > adjacencyMatrix[element][i]){
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag=true;
                    }
                }

                i++;
            }
            if(minFlag){
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                shortestDistance += min;
                minFlag = false;
                continue;
            }

            stack.pop();
        }
        System.out.println(shortestDistance);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the time/distance A-D");
        int weightAD = input.nextInt();
        /* weight = time/distance */
        if (shortestDistance<= 2*weightAD){
            System.out.println("1 person can do the delivery");
        }else {
            System.out.println("Delivery should be done by 2 people");
        }
    }

    public static void main(String...arg){

        int number_of_nodes;
        Scanner scanner = null;
        try{
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
            int adjacency_matrix[][]=new int[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");

            for (int i = 1; i<=number_of_nodes;i++){
                for (int j = 1;j<=number_of_nodes;j++){
                    adjacency_matrix[i][j]=scanner.nextInt();
                }
            }
            for (int i=1;i<=number_of_nodes;i++){
                for(int j = 1; j<=number_of_nodes;j++){
                    if(adjacency_matrix[i][j]==1 && adjacency_matrix[j][i]==0){
                        adjacency_matrix[j][i]=1;
                    }
                }
            }
            System.out.println("Below is the path outline of the shortest path:");
            Delivery delivery = new Delivery();
            delivery.travellingSalesmanP(adjacency_matrix);
        }catch (InputMismatchException inputMismatch){
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}

