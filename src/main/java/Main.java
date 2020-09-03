import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       int[][] numbers = new int[][]{
               {0, 1, 2, 3, 4},
               {5, 6, 7, 8, 9},
               {10, 11, 12, 13, 14},
               {15, 16, 17, 18, 19},
               {15, 16, 17, 18, 19},
               {15, 16, 17, 18, 19}
       };
       printDiagonalNaobowrot(numbers);

    }
    public static void printStringsList() {
        List<String> strings = new ArrayList<>();
        strings.add("Hanna");
        strings.add("Hello");
        strings.add("Hello1");
        strings.add("Hello2");
        strings.add("Hello3");

        for (int i=strings.size()-1;i>=0;i--){
            System.out.println(i + " " + strings.get(i));
        }

        // i 0 1 2 3
        // v 6 7 4 6
        // size 4
    }
    public static void printMatrix(int[][] numbers){
        for (int row = 0; row < numbers.length; row++){
            System.out.print("{");
            for (int column = 0; column < numbers[row].length;column++){
                System.out.print(numbers[row][column]);
                if (column != numbers[row].length-1 ) {
                    System.out.print(", ");
                }
            }

            System.out.print("}");
            if(row < numbers.length-1){
                System.out.print(",");
            }
            System.out.println();
        }
    }
    public static void printDiagonal(int[][] numbers){
        for (int i = 0; i < numbers.length && i < numbers[i].length;i++){
            System.out.println(numbers[i][i]);
        }
    }

    public static void printNaoborot(int[][] numbers) {
        for (int row = numbers.length-1; row >= 0;row--){
            for (int column = numbers[row].length-1; column >= 0;column--){
                System.out.print(numbers[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static void printDiagonalNaobowrot(int[][] numbers) {
        for(int y = numbers.length-1, i = 0;y>=0 && i < numbers.length && i < numbers[i].length;i++,y--){
            System.out.println(numbers[y][i]);
        }
    }
}



