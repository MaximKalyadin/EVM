package lab_EVM;

public class lab4_class {
	static int [][] mass = {{0,0,0,1},
					 		{0,0,1,0},
							{0,1,0,0},
							{0,1,1,1},
							{1,0,0,0},
							{1,0,1,1},
							{1,1,0,0},
						    {1,1,1,1}};
	static int n = 8;
	static int m = 4;
	
	public static void out() {
		String str = "";
		for (int i = 0; i < m - 1; i++) {
			str += "x" + (i + 1) + " ";
		}
		str += "F";
		System.out.println(str);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(mass[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void outKnf() {
		System.out.println("КНФ");
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 0) {
				System.out.print("(");
				for (int j = 0; j < m-1; j++) {
					if (mass[i][j] == 1) {
						if (j == 0) {
							System.out.print("(-x" + (j+1) + ")");
						} else {
							System.out.print("+(-x" + (j+1) + ")");
						}
					} else {
						if (j == 0) {
							System.out.print("x" + (j+1));
						} else {
							System.out.print("+x" + (j+1));
						}
					}
				}
				System.out.print(")");
			}
		}
		System.out.println();
	}
	
	public static void outDnf() {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 1) {
				k++;
			}
		}
		System.out.println("ДНФ");
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 1) {
				for (int j = 0; j < m-1; j++) {
					if (mass[i][j] == 0) {
						System.out.print("(-x" + (j + 1) + ")");
					} else {
						System.out.print("x" + (j + 1));
					}
				}
				if (k > 1) {
					System.out.print("+");
					k--;
				}
			}
		}
		System.out.println();
	}
}
