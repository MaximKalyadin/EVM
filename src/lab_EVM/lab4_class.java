package lab_EVM;

public class lab4_class {
	static int [][] mass = {{0,0,0,1},
					 		{0,0,1,0},
							{0,1,0,0},
							{0,1,1,0},
							{1,0,0,0},
							{1,0,1,1},
							{1,1,0,1},
						    {1,1,1,1}};
	static int n = 8;
	static int m = 4;
	static int [][] arr;
	static int [][] arr1;
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
		System.out.println();
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
		knf();
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
		dnf();
	}
	
	public static void dnf() {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 1) {
				k++;
			}
		}
		arr = new int[k][m-1];
		k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 1) {
				for (int j = 0; j< m - 1; j++) {
					arr[k][j] = mass[i][j];
				}
				k++;
			}
		}
		/*for (int i = 0; i < k; i++) {
			for (int j = 0; j < m - 1; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}*/
		for (int p = 0; p < n; p++) {
			for (int i = 0; i < k; i ++) {
				for (int j = i+1; j < k; j ++) {
					for (int t = 0; t < m - 1; t++) {
						if ((arr[i][t] == arr[j][t]) && (pr1(i) == pr1(j))) {
							for (int y = 0; y < m - 1; y++) {
								if ((arr[i][y] != arr[j][y]) && (arr[i][y] != -1) && (arr[j][y] != -1)) {
									arr[i][y] = -1;
									arr[j][y] = -1;
								} 
							}
							for (int u = 0; u < m - 1; u++) {
								arr[i][u] = -1;
							}
						}
					}
				}
			}
		}
		/*for (int i = 0; i < k; i++) {
			for (int j = 0; j < m - 1; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}*/
		int kolotr = 0;
		for (int i = 0; i < k; i++) {
			int checkMi = 0;
			for (int j = 0; j < m-1; j++) {
				if (arr[i][j] == -1) {
					checkMi++;
				}
			}
			if (checkMi == m - 1) {
				kolotr++;
			}
		}
		if (kolotr == k) {
			System.out.println(0);
		} else {
			int kol = k - kolotr;
			for (int i = 0; i < k; i++) {
				if (pr1(i) < m-1) {
					for (int j = 0; j < m-1; j++) {
						if (arr[i][j] == 0) {
							System.out.print("(-x" + (j + 1) + ")");
						} else if (arr[i][j] == 1) {
							System.out.print("x" + (j + 1));
						}
					}
					if (kol > 1) {
						System.out.print("+");
						kol--;
					}
				}
			}
		}
		System.out.println();
	}
	
	public static void knf() {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 0) {
				k++;
			}
		}
		arr1 = new int[k][m-1];
		k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 0) {
				for (int j = 0; j< m - 1; j++) {
					arr1[k][j] = mass[i][j];
				}
				k++;
			}
		}
		/*for (int i = 0; i < k; i++) {
			for (int j = 0; j < m - 1; j++) {
				System.out.print(arr1[i][j]);
			}
			System.out.println();
		}*/
		for (int l = 0; l < n; l++) {
			for (int i = 0; i < k; i++) {
				for (int j = i + 1; j < k; j++) {
					for ( int t = 0; t < m - 1; t++) {
						if ((koldifferent(i) == 1) && (pr2(i) == pr2(j))) {
							for (int y = 0; y < m - 1; y++) {
								if (arr1[i][y] != arr1[j][y]) {
									arr1[i][y] = -1;
									arr1[j][y] = -1;
								}
							}
							for (int u = 0; u < m - 1; u++) {
								arr1[i][u] = -1;
							}
						}
					}
				}
			}
		}
		/*for (int i = 0; i < k; i++) {
			for (int j = 0; j < m - 1; j++) {
				System.out.print(arr1[i][j]);
			}
			System.out.println();
		}*/
		int kolotr = 0;
		for (int i = 0; i < k; i++) {
			int checkMi = 0;
			for (int j = 0; j < m-1; j++) {
				if (arr1[i][j] == -1) {
					checkMi++;
				}
			}
			if (checkMi == m - 1) {
				kolotr++;
			}
		}
		if (kolotr == k) {
			System.out.println(0);
		} else {
			int kol = k - kolotr;
			for (int i = 0; i < k; i++) {
					if (pr2(i) < m-1) {
					System.out.print("(");
					for (int j = 0; j < m-1; j++) {
						if (arr1[i][j] == 1) {
							if (j == 0) {
								System.out.print("(-x" + (j+1) + ")");
							} else {
								System.out.print("+(-x" + (j+1) + ")");
							}
						} else if (arr1[i][j] == 0){
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
		}
		System.out.println();
	}
	public static int koldifferent(int i) {
		int k = 0;
		for (int j = 0; j < m-1; j++) {
			if (arr1[i][j] != arr1[i + 1][j]) {
				k++;
			}
		}
		return k;
	}
	public static int pr2(int i) {
		int k = 0;
		for (int j = 0; j < m-1; j++) {
			if	(arr1[i][j] == -1) {
				k++;
			}
		}
		return k;
	}
	public static int pr1(int i) {
		int k = 0;
		for (int j = 0; j < m-1; j++) {
			if	(arr[i][j] == -1) {
				k++;
			}
		}
		return k;
	}
	
	
}
