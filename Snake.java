import java.util.Scanner;
import java.util.Random;


public class Snake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		System.out.println("Добро пожаловать в Змейку");
		System.out.println("Для того чтобы управлять змейкой, используйте символы :");
		System.out.println(" 'w' - Прямо ");
		System.out.println(" 'd' - Направо ");
		System.out.println(" 'a' - Налево ");
		System.out.println(" 's' - Вниз ");
        System.out.println("Для того чтобы начать игру нажмите '55555'");
		
		int vhod = in.nextInt();
		if (vhod == 55555) {
			

			int height = 10;
			int wight = 10;

			int[] kordSnakeF = new int[2];
	//        int[] kordSnakeS = new int[2];
			int vzor = 0;
			String[][] poleIgrok = new String[wight][height];
			for (int i = 0; i < wight; i++) {
				for (int j = 0; j < height; j++) {

					poleIgrok[i][j] = ".";
				}
			}
			kordSnakeF[0] = wight / 2;
			kordSnakeF[1] = height / 2;
	//        kordSnakeS[1] = height / 2;
	//        kordSnakeS[0] = wight / 2 - 1;
			
			for (int i = 0; i < wight; i++) {
				for (int j = 0; j < height; j++) {
					if (i == kordSnakeF[0] && j == kordSnakeF[1]) {
						System.out.print("* ");
					} else {
						System.out.print(poleIgrok[i][j] + " ");
					}

				}
				System.out.println();
			}
        } else {
			System.out.println("Пока...");
		}
    }
}

