package lab_EVM;

import java.awt.Color;
import java.awt.Graphics;

public class ClassArkanoid {
	private static int [][]array;
	private static int n;
	private static int m;
	public ClassArkanoid() {
		n = 50;
		m = 50;
		array = new int[n][m];
	}
	public static void Level () {
		int k = 1;
		for (int i = 0; i < m; i++) {
			if (i % 5 == 0) {
				k++;
				if (k > 10) {
					k = 1;					
				}
			}
			array[0][i] = k;
			array[1][i] = k;
			array[2][i] =k;
		}
		k = 9;
		for (int i = 0; i < m; i++) {
			if (i % 5 == 0) {
				k++;
				if (k > 10) {
					k = 1;					
				}
			}
			array[3][i] = k;
			array[4][i] = k;
			array[5][i] =k;
		}
		k = 7;
		for (int i = 0; i < m; i++) {
			if (i % 5 == 0) {
				k++;
				if (k > 10) {
					k = 1;					
				}
			}
			array[6][i] = k;
			array[7][i] = k;
			array[8][i] =k;
		}
		for (int i = 19 ; i < 30; i++) {
			array[47][i] = 11;
			array[48][i] = 11;
			array[49][i] = 11;
		}
		array[46][35] = 12;
	}
	public static int PoiskLefti() {
		int i = 0;
		for (int t = 0; t < m; t++) {
			if (array[47][t] == 11) {
				i = t;
				break;
			}
		}
		return i;
	}
	public static int PoiskRighti() {
		int i = 0;
		for (int t = m - 1; t > 0; t--) {
			if (array[47][t] == 11) {
				i = t;
				break;
			}
		}
		return i;
	}
	public static void Left() {
		int i = PoiskLefti();
		if (i > 1) {
			for (int t = 0; t < 12; t++) {
				array[47][i - 1] = array[47][i];
				array[48][i - 1] = array[48][i];
				array[49][i - 1] = array[49][i];
				i++;
			}
		}
	}
	public static void Right() {
		int i = PoiskRighti();
		if (i < m - 2) {
			for (int t = 0; t < 12; t++) {
				array[47][i + 1] = array[47][i];
				array[48][i + 1] = array[48][i];
				array[49][i + 1] = array[49][i];
				i--;
			}
		}
	}
	
	public static int step1(int i, int j) {
		if (array[i + 1][j + 1] == 0 && i < n - 2 && j < m - 2) {
			array[i + 1][j + 1] = 12;
			array[i][j] = 0;
			return 4;
		} else if (i > 47){
			return 5;
		} else return 1;
	}
	public static int step2(int i, int j) {
		if (array[i + 1][j - 1] == 0 && i < n - 2 && j > 1) {
			array[i + 1][j - 1] = 12;
			array[i][j] = 0;
			return 3;
		} else if (i > 47){
			return 5;
		} else return 4;
	}
	public static int  step3(int i, int j) {
		if (array[i - 1][j + 1] == 0 && i > 1 && j < m - 2) {
			array[i - 1][j + 1] = 12;
			array[i][j] = 0;
			return 1;
		} else return 2;
	}
	public static int step4(int i, int j) {
		if (array[i - 1][j - 1] == 0 && i > 1 && j > 1) {
			array[i - 1][j - 1] = 12;
			array[i][j] = 0;
			return 2;
		} 
		if (array[i - 1][j] != 0 && array[i - 1][j] != 11) {
			Recyrs(array[i - 1][j], i - 1, j );
		}
		return 3;
	}
	public static void Recyrs(int k, int i, int j) {
		array[i][j] = 0;
		if (array[i - 1][j] == k) {
			Recyrs(array[i - 1][j], i - 1, j );
		}
		if (array[i + 1][j] == k) {
			Recyrs(array[i + 1][j], i + 1, j );
		}
		if (array[i][j + 1] == k) {
			Recyrs(array[i][j + 1], i, j + 1 );
		}
		if (array[i][j - 1] == k) {
			Recyrs(array[i][j - 1], i, j - 1);
		}
	}
	public static void print() {
		for ( int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();		
		}
		System.out.println();		
	}
	final public static int CELL_HEIGHT = 24;
	final public static int CELL_WIDTH = 24;
	public static void drawArray(Graphics g, int width, int height) {
		int cellHeight =  height / n;
		int cellWidth =  width / m;
		for (int i = 0; i < n; i++) {			
			int top = i * cellHeight;
			for (int j = 0; j < m; j++) {
				int left = j * cellWidth;
				Color []colors = {	
					  	new Color(0xFF, 0xFF, 0xFF),     
					  	new Color(0, 0, 0xCD),
						new Color(0xFF, 0, 0),	
						new Color(0, 0xFF, 0),
						new Color(0xFF, 0xFF, 0),
						new Color(0xFF, 0, 0xFF),
						new Color(0x80, 0x80, 0x80),     
						new Color(0xC0, 0xC0, 0xC0),
						new Color(0x80, 0x00, 0x80),	
						new Color(0x80, 0x80, 0x00),
						new Color(0, 80, 0),
						new Color(0, 0xFF, 0xFF),
						new Color(0, 0, 0)
				};
				if (array[i][j] == 1) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 2) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 3) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 4) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 5) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 6) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 7) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 8) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 9) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 10) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 11) {
					g.setColor(colors[array[i][j]]);
					g.fillRect(left, top, cellWidth, cellHeight);
				}
				if (array[i][j] == 12) {
					g.setColor(colors[array[i][j]]);
					g.fillOval(left, top, cellWidth, cellHeight);
				}
			}
		}
		
	}
	
}
