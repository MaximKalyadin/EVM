package lab_EVM;

import java.util.Scanner;

public class class_lab_2 {
	
	public static void Vvod() {
		int isxodSistema = 0;
		int konechSistema = 0;
		String Chislo = "";
		Scanner sc = new Scanner(System.in);
		try {
			isxodSistema = sc.nextInt();
			konechSistema = sc.nextInt();
			Chislo = sc.next();
		} catch(Exception e) {
			System.out.println("ошибка");
			}		
		Perevod(isxodSistema,konechSistema,Chislo);
	}
	
	public static void Perevod(int ish, int kon, String ch) {
		char [] masIsh = ch.toCharArray();
		int kolElChisla = masIsh.length;
		int ChisloVdes = 0;
		if (ish != 10) {
			int stepen = kolElChisla - 1;
			for (int i = 0; i < kolElChisla; i++) {
				if (masIsh[i] == 'A') {
					ChisloVdes += (int) (10 * Math.pow(ish, stepen));
				} else if (masIsh[i] == 'B') {
					ChisloVdes += (int) (11 * Math.pow(ish, stepen));
				} else if (masIsh[i] == 'C') {
					ChisloVdes += (int) (12 * Math.pow(ish, stepen));
				} else if (masIsh[i] == 'D') {
					ChisloVdes += (int) (13 * Math.pow(ish, stepen));
				} else if (masIsh[i] == 'E') {
					ChisloVdes += (int) (14 * Math.pow(ish, stepen));
				} else if (masIsh[i] == 'F') {
					ChisloVdes += (int) (15 * Math.pow(ish, stepen));
				} else {
					int k = Character.getNumericValue(masIsh[i]);
					ChisloVdes += k * Math.pow(ish, stepen);
				}
				stepen--;
			}
		} else {
			ChisloVdes = Integer.parseInt(ch);
		}
		String End = "";
		if (kon != 10) {
			while (ChisloVdes != 0) {
				int ost = ChisloVdes % kon;
				ChisloVdes = ChisloVdes / kon;
				if (ost == 10) {
					End += 'A';
				} else if (ost == 11) {
					End += 'B';
				} else if (ost == 12) {
					End += 'C';
				} else if (ost == 13) {
					End += 'D';
				} else if (ost == 14) {
					End += 'E';
				} else if (ost == 15) {
					End += 'F';
				} else {
					End += ost;
				}
			}
			StringBuffer END = new StringBuffer(End);
			System.out.println(END.reverse());
		} else {
			System.out.println(ChisloVdes);
		}
		
	}
}
