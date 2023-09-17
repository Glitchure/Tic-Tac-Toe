import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int[][] array = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        boolean stopped = false;
        boolean isSymmetrical = true;
        for (int i = 0; i < dimension && !stopped; i++) {
            for (int j = 0; j < dimension; j++) {
                if (array[i][j] != array[j][i]) {
                    isSymmetrical = false;
                    stopped = true;
                    break;
                }
            }
        }

        if (isSymmetrical) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}