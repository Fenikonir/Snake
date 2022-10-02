import java.util.Scanner;
import java.util.Random;
public class Snake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		System.out.println("Добро пожаловать в Змейку");
		System.out.println("Для того чтобы управлять змейкой, используйте символы :");
		//System.out.println(" 'w' - Прямо ");
		System.out.println(" 'd' - Направо ");
		System.out.println(" 'a' - Налево ");
		//System.out.println(" 's' - Вниз ");
        System.out.println("Для того чтобы начать игру нажмите '55555'");
		
		int vhod = in.nextInt();
		if (vhod == 55555) {
			

			int height = 10;
			int wight = 10;
			int inChar;
			String s = "";

			int[][] kordSnakeF = new int[3][2];
			int vzor = 0;
			String[][] poleIgrok = new String[wight][height];
			for (int i = 0; i < wight; i++) {
				for (int j = 0; j < height; j++) {

					poleIgrok[i][j] = ".";
				}
			}
			for (int i = 0; i < 3; i ++) {
				kordSnakeF[i][0] = wight / 2;
				kordSnakeF[i][1] = height / 2 + i;
			}
			try {
			while (true) {
				//long time = System.currentTimeMillis();
				//if (time % 1000 == 0) {
				s = "";
				long time = System.nanoTime();
				if (time % 10000000 == 0) {
					
					for (int i = 0; i < 100; i ++){
						System.out.println();}
					for (int i = 2; i > 0; i --) {
						kordSnakeF[i][0] = kordSnakeF[i-1][0];
						kordSnakeF[i][1] = kordSnakeF[i-1][1];
					}
					if (vzor == 0) {
						kordSnakeF[0][0] -= 1;
					} else if (vzor == 2) {
						kordSnakeF[0][0] += 1;
					} else if (vzor == 1) {
						kordSnakeF[0][1] += 1;
					} else if (vzor == 3) {
						kordSnakeF[0][1] -= 1;
					}
					for (int i = 0; i < wight; i++) {
						for (int j = 0; j < height; j++) {
							boolean flag = false;
							for (int e = 0; e < 3; e ++) {
								if (i == kordSnakeF[e][0] && j == kordSnakeF[e][1]) {
									flag = true;
								}
							}
							if (flag) {
								System.out.print("* ");
							} else {
								System.out.print(poleIgrok[i][j] + " ");
								}
						}
								System.out.println();
					}
					System.out.println("___________________");
					inChar = System.in.read();
					while (System.in.available() > 0) {
                        s += (char) inChar;
                        inChar = System.in.read();
                        if (s.equals("a")) {
							vzor -= 1;
							if (vzor == -1) {
								vzor = 3;
							}
							
						} else if (s.equals("d")) {
							vzor += 1;
							if (vzor == 4) {
								vzor = 0;
							}
						}
                    }
				}			
			}
		} catch (Exception e) {
            System.out.println("Ошибка");
        }
		
        } else {
			System.out.println("Пока...");
		}
    }
}