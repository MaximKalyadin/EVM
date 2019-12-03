package lab_EVM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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
	static int constanta = 0;
	public static String out() {
		String str = "";
		String out = "";
		for (int i = 0; i < m - 1; i++) {
			str += "x" + (i + 1) + " ";
			out += "x" + (i + 1) + " ";
		}
		out += "F\n";
		str += "F";
		System.out.println(str);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				out += mass[i][j] + "  ";
				System.out.print(mass[i][j] + "  ");
			}
			out += "\n";
			System.out.println();
		}
		System.out.println();
		return out;
	}
	
	public static String outKnf() {
		String out = "";
		System.out.println("���");
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 0) {
				out += "(";
				System.out.print("(");
				for (int j = 0; j < m-1; j++) {
					if (mass[i][j] == 1) {
						if (j == 0) {
							out += "(-x" + (j+1) + ")";
							System.out.print("(-x" + (j+1) + ")");
						} else {
							out += "+(-x" + (j+1) + ")";
							System.out.print("+(-x" + (j+1) + ")");
						}
					} else {
						if (j == 0) {
							out += "x" + (j+1);
							System.out.print("x" + (j+1));
						} else {
							out += "+x" + (j+1);
							System.out.print("+x" + (j+1));
						}
					}
				}
				out += ")";
				System.out.print(")");
			}
		}
		System.out.println();
		knf();
		return out;
	}
	
	public static String outDnf() {
		String out = "";
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 1) {
				k++;
			}
		}
		System.out.println("���");
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 1) {
				for (int j = 0; j < m-1; j++) {
					if (mass[i][j] == 0) {
						out += "(-x" + (j + 1) + ")";
						System.out.print("(-x" + (j + 1) + ")");
					} else {
						out += "x" + (j + 1);
						System.out.print("x" + (j + 1));
					}
				}
				if (k > 1) {
					out += "+";
					System.out.print("+");
					k--;
				}
			}
		}
		System.out.println();
		dnf();
		return out;
	}
	
	public static String dnf() {
		int k = KOL();
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
		String out = "";
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
			System.out.println(out += 0);
		} else {
			int kol = k - kolotr;
			for (int i = 0; i < k; i++) {
				if (pr1(i) < m-1) {
					for (int j = 0; j < m-1; j++) {
						if (arr[i][j] == 0) {
							out += "(-x" + (j + 1) + ")";
							System.out.print("(-x" + (j + 1) + ")");
						} else if (arr[i][j] == 1) {
							out += "x" + (j + 1);
							System.out.print("x" + (j + 1));
						}
					}
					if (kol > 1) {
						out += "+";
						System.out.print("+");
						kol--;
					}
				}
			}
		}
		System.out.println();
		Outdprom(k);
		return out;
	}
	public static int KOL() {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 1) {
				k++;
			}
		}
		return k;
	}
	public static String knf() {
		String out = "";
		int k = Kol();
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
		Outk(k);
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
			out += 0;
			System.out.println(0);
		} else {
			int kol = k - kolotr;
			for (int i = 0; i < k; i++) {
					if (pr2(i) < m-1) {
						out += "(";
					System.out.print("(");
					for (int j = 0; j < m-1; j++) {
						if (arr1[i][j] == 1) {
							if (j == 0) {
								out += "(-x" + (j+1) + ")";
								System.out.print("(-x" + (j+1) + ")");
							} else {
								out += "+(-x" + (j+1) + ")";
								System.out.print("+(-x" + (j+1) + ")");
							}
						} else if (arr1[i][j] == 0){
							if (j == 0) {
								out += "x" + (j+1);
								System.out.print("x" + (j+1));
							} else {
								out += "+x" + (j+1);
								System.out.print("+x" + (j+1));
							}
						}
					}
					out += ")";
					System.out.print(")");
				}
			}
		}
		System.out.println();
		Outkprom(k);
		return out;
	}
	public static int Kol() {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (mass[i][m - 1] == 0) {
				k++;
			}
		}
		return k;
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
	public static void Outk(int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < m - 1; j++) {
				System.out.print(arr1[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void Outd(int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < m - 1; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static String Outkprom(int k) {
		String eq = "";
		for (int i = 0; i < k; i++) {
			if (pr2(i) == m - 1 && pr2(i + 1) > 0) {
				eq += "(";
				for (int u = 0; u < m - 1; u++) {
					if (u == 0) {
						if (arr1[i + 1][u] == 1) {
							eq += "-x" + (u + 1);
						} else if (arr1[i + 1][u] == 0){
							eq += "x" + (u + 1);
						}
					} else {
						if (arr1[i + 1][u] == 1) {
							eq += "+(-x" + (u + 1) + ")";
						} else if (arr1[i + 1][u] == 0){
							eq += "+x" + (u + 1);
						}
					}
				}
				eq += ")";
				eq += "(";
				String y = "";
				for (int j = 0; j < m - 1; j++) {
					if ((arr1[i][j] == -1) && (arr1[i + 1][j] == -1)){
						eq += "x" + (j + 1);
						y += "(-x" + (j + 1) + ")";
					}
				}
				eq += "+" + y + ")";
			} else if (pr2(i) == 0){
				eq += "(";
				for (int j = 0; j < m - 1; j++) {
					if (j == 0) {
						if (arr1[i][j] == 1) {
							eq += "(-x" + (j + 1) + ")";
						} else {
							eq += "x" + (j + 1);
						}
					} else {
						if (arr1[i][j] == 1) {
							eq += "+(-x" + (j + 1) + ")";
						} else {
							eq += "+x" + (j + 1);
						}
					}
				}
				eq += ")";
			}
		}
		System.out.println(eq);
		return eq;
	}
	public static String Outdprom(int k) {
		String eq = "";
		int kol = 0;
		for (int i = 0; i < k; i += 2) {
			if (kol > 0) {
				eq += "+";
			}
			kol++;
			if (pr1(i) == m - 1 && pr1(i + 1) > 0) {
				for (int u = 0; u < m - 1; u++) {
					if (arr[i + 1][u] != -1) {
						if (arr[i + 1][u] == 0) {
							eq += "-x" + (u + 1);
						} else {
							eq += "x" + (u + 1);
						}
					}
				}
				if (pr1(i+1) < m - 1) {
					String y = "";
					eq += "(";
					for (int j = 0; j < m - 1; j++ ) {
						if ((arr[i][j] == -1) && (arr[i + 1][j] == -1)) {
							y += "(-x" + (j + 1) + ")";
							eq += "x" + (j + 1);
						}
					}
					eq += "+" + y + ")";
				}
			}
		}
		System.out.println(eq);
		return eq;
	}
	public static void constan() {
		constanta = 1;
	}
	public static void Draw(Graphics g) {
		if (constanta == 1) {
			int st = KOL();
			for (int i = 0; i < m - 1; i++) {
				g.setFont(new Font("Tahoma",Font.ITALIC,20));
				g.setColor(Color.black);
				g.drawString("x" + (i + 1), i*40,40);
				g.drawLine(i*40, 55, i*40, 1000);
			}
			int y = 70;
			int  a = 0;
			for (int i = 0; i < st; i++) {
				for (int j = 0; j < m - 1; j++) {
					if (arr[i][j] != -1) {
						for (int t = 0; t < m - 1; t++) {
							if (arr[i][t] == 0) {
								g.fillOval(t*40 - 2, y, 5, 5);
								g.drawLine(t*40, y + 2, 130, y + 2);
								g.drawLine(130, y-8, 130, y+10);
								g.drawLine(130, y-8, 139, y+1);
								g.drawLine(130, y+10, 139, y+1);
								g.drawOval(139, y-1, 5, 5);
								g.drawLine(144, y+1, 157, y+1);
								y += 20;
							} else if (arr[i][t] == 1) {
								g.fillOval(t*40 - 2, y, 5, 5);
								g.drawLine(t*40, y + 2, 157, y + 2);
								y += 20;
							}
						}
						g.drawLine(157, y+7, 157, y-60);
						g.drawLine(157, y+7, 170, y+7);
						g.drawLine(157, y-60, 170, y-60);
						g.drawLine(170, y-60, 180, y-50);
						g.drawLine(170, y+7, 180, y-3);
						g.drawLine(180, y-50, 180, y-3);
						g.drawLine(180, y-26, 220 - a, y-26);
						g.drawLine(220 - a, y-26, 220 - a, 275);
						g.drawLine(220 - a, 275, 250, 275);
						a += 7;
						y += 50;
						break;
					}
				}
			}
			g.drawLine(250, 250, 250, 300);
			g.drawLine(250, 250, 235, 230);
			g.drawLine(250, 300, 235, 320);
			g.drawLine(235, 230, 300, 275);
			g.drawLine(235, 320, 300, 275);
			g.drawLine(300, 275, 350, 275);
		}
	}
}
