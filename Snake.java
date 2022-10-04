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
		
		String vhod = in.nextLine();
		if (vhod.equals("55555")) {
			String fullHor = "11111";
			String fullSten = "11 11";
			String leftSten = "11   ";
			String rightSten = "   11";			
			String[][] matur = new String[10][5];
			matur[8][0] = fullHor;
			matur[8][1] = fullSten;
			matur[8][2] = fullHor;
			matur[8][3] = fullSten;
			matur[8][4] = fullHor;
			String[] matur1 = new String[5];
			matur[1][0] = leftSten;
			matur[1][1] = leftSten;
			matur[1][2] = leftSten;
			matur[1][3] = leftSten;
			matur[1][4] = leftSten;
			String[] matur2 = new String[5];
			matur[2][0] = fullHor;
			matur[2][1] = rightSten;
			matur[2][2] = fullHor;
			matur[2][3] = leftSten;
			matur[2][4] = fullHor;
			String[] matur3 = new String[5];
			matur[3][0] = fullHor;
			matur[3][1] = rightSten;
			matur[3][2] = fullHor;
			matur[3][3] = rightSten;
			matur[3][4] = fullHor;
			String[] matur4 = new String[5];
			matur[4][0] = fullSten;
			matur[4][1] = fullSten;
			matur[4][2] = fullHor;
			matur[4][3] = rightSten;
			matur[4][4] = rightSten;
			String[] matur5 = new String[5];
			matur[5][0] = fullHor;
			matur[5][1] = leftSten;
			matur[5][2] = fullHor;
			matur[5][3] = rightSten;
			matur[5][4] = fullHor;
			String[] matur6 = new String[5];
			matur[6][0] = leftSten;
			matur[6][1] = leftSten;
			matur[6][2] = fullHor;
			matur[6][3] = fullSten;
			matur[6][4] = fullHor;
			String[] matur7 = new String[5];
			matur[7][0] = fullHor;
			matur[7][1] = rightSten;
			matur[7][2] = rightSten;
			matur[7][3] = rightSten;
			matur[7][4] = rightSten;
			String[] matur9 = new String[5];
			matur[9][0] = fullHor;
			matur[9][1] = fullSten;
			matur[9][2] = fullHor;
			matur[9][3] = rightSten;
			matur[9][4] = rightSten;
			String[] matur0 = new String[5];
			matur[0][0] = fullHor;
			matur[0][1] = fullSten;
			matur[0][2] = fullSten;
			matur[0][3] = fullSten;
			matur[0][4] = fullHor;
			
			// Задаем размеры игрового поля
			int height = 10;
			int wight = 10;
			int snake = 6;
			int summ = 2;
			String s = "";
			// Задаем массив с координатами тельца змейки
			int[][] kordSnakeF = new int[snake][2];
			int vzor = 0;
			// Заполняем поле h на w
			String[][] poleIgrok = new String[wight][height];
			for (int i = 0; i < wight; i++) {
				for (int j = 0; j < height; j++) {

					poleIgrok[i][j] = ".";
				}
			}
			// Заполняем координатами
			for (int i = 0; i < snake; i ++) {
				kordSnakeF[i][0] = wight / 2;
				kordSnakeF[i][1] = height / 2 + i;
			}
			//try {
			while (true) {
				//long time = System.currentTimeMillis();
				//if (time % 1000 == 0) {
				s = "";
				long time = System.nanoTime();
				if (time % 1000000000 == 0) {					
					for (int i = 0; i < 100; i ++){
						System.out.println();}
					for (int i = 0; i < 5; i ++) {
						int a = summ;
						System.out.print("\t");
						while (a > 0) {
							System.out.print(matur[a % 10][i] + "  ");
							a /= 10;
						}
						System.out.println();
					}
					for (int i = snake - 1; i > 0; i --) {
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
							int flag = 5;
							for (int e = 1; e < snake; e ++) {
								if (i == kordSnakeF[0][0] && j == kordSnakeF[0][1]) {
									if (vzor == 0) {
										flag = 0;										 
									} else if (vzor == 2) { 
										flag = 2;										
									} else if (vzor == 1) {										
										flag = 1;
									} else if (vzor == 3) {
										flag = 3;										
								}
								}else if (i == kordSnakeF[e][0] && j == kordSnakeF[e][1]) {
									flag = 4;
								}
							}
							if (flag == 4) {
								System.out.print("* ");
							}else if (flag == 0) {
								System.out.print("ᐃ ");
							}else if (flag == 1) {
								System.out.print("ᐅ "); 
							}else if (flag == 2) {
								System.out.print("ᐁ ");
							}else if (flag == 3) {
								System.out.print("ᐊ ");
							} else if (flag ==5) {
								System.out.print(poleIgrok[i][j] + " ");
								}
						}
								System.out.println();
					}
					System.out.println("___________________");
					try {
						if (System.in.available() > 0) {
							s = in.nextLine();
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
					} catch (Exception e) {
						System.out.println("Ошибка");
					}

					}
				}
        } else {
			System.out.println("Пока...");
		}
    }
}