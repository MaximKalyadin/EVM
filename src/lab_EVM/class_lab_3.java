package lab_EVM;

import java.util.Scanner;

public class class_lab_3 {
	
	public static void Vvod() {
		int isxodSistema = 0;
		int dvoichnaya = 2;
		String Chislo1 = "";
		String Chislo2 = "";
		Scanner sc = new Scanner(System.in);
		try {
			isxodSistema = sc.nextInt();
			Chislo1 = sc.next();
			Chislo2 = sc.next();
		} catch(Exception e) {
			System.out.println("ошибка");
			}		
		//addition(Perevod(isxodSistema,dvoichnaya,Chislo1),Perevod(isxodSistema,dvoichnaya,Chislo2));
		//subtraction(Perevod(isxodSistema,dvoichnaya,Chislo1),Perevod(isxodSistema,dvoichnaya,Chislo2));
		//multiplication(Perevod(isxodSistema,dvoichnaya,Chislo1),Perevod(isxodSistema,dvoichnaya,Chislo2));
		div(Perevod(isxodSistema,dvoichnaya,Chislo1),Perevod(isxodSistema,dvoichnaya,Chislo2));
	}
	
	public static String Perevod(int ish, int kon, String ch) {
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
			END = END.reverse();
			String st = "";
			st += END;
			return st;
		} else {
			String str = "";
			str += ChisloVdes;
			return str;
		}
		
	}
	
	public static String addition(String ch1, String ch2) {
		char [] mass1 = ch1.toCharArray();
		char [] mass2 = ch2.toCharArray();
		int max = 0;
		String str = "";
		if (mass1.length > mass2.length) {
			max = mass1.length;
		} else {
			max = mass2.length;
		}
		char [] mass1obr = new char [max];
		char [] mass2obr = new char [max];
		for (int i = 0; i < max; i++) {
			mass1obr[i] = '0';
			mass2obr[i] = '0';
		}
		int chet = max - 1;
		if (mass1.length < max) {
			for (int i = mass1.length - 1; i >= 0; i--) {
				mass1obr[chet] = mass1[i];
				chet--;
			}
		} else {
			for (int i = 0 ; i < max; i++) {
				mass1obr[i] = mass1[i];
			}
		}
		if (mass2.length < max) {
			for (int i = mass2.length - 1; i >= 0; i--) {
				mass2obr[chet] = mass2[i];
				chet--;
			}
		} else {
			for (int i = 0 ; i < max; i++) {
				mass2obr[i] = mass2[i];
			}
		}
		int k = 0;
		for (int i = max - 1; i >= 0 ; i--) { 
			int temp1 = Character.getNumericValue(mass1obr[i]);
			int temp2 = Character.getNumericValue(mass2obr[i]);
			if (temp1 + temp2 + k == 2) {
				str += 0;
				k = 1;
			} else if (temp1 + temp2 + k == 3) {
				str += 1;
				k = 1;
			} else {
				str += temp1 + temp2 + k;
				k = 0;
			}
		}
		if (k == 1) {
			str += k;
		}
		StringBuffer End = new StringBuffer(str);
		End = End.reverse();
		String s = "" + End;
		return s;
	}
	
	public static String subtraction(String ch1, String ch2) {
		char [] mass1 = ch1.toCharArray();
		char [] mass2 = ch2.toCharArray();
		int max = 0;
		String str = "";
		if (mass1.length > mass2.length) {
			max = mass1.length;
		} else {
			max = mass2.length;
		}
		char [] mass1obr = new char [max];
		char [] mass2obr = new char [max];
		for (int i = 0; i < max; i++) {
			mass1obr[i] = '0';
			mass2obr[i] = '0';
		}
		int chet = max - 1;
		if (mass1.length < max) {
			for (int i = mass1.length - 1; i >= 0; i--) {
				mass1obr[chet] = mass1[i];
				chet--;
			}
		} else {
			for (int i = 0 ; i < max; i++) {
				mass1obr[i] = mass1[i];
			}
		}
		if (mass2.length < max) {
			for (int i = mass2.length - 1; i >= 0; i--) {
				mass2obr[chet] = mass2[i];
				chet--;
			}
		} else {
			for (int i = 0 ; i < max; i++) {
				mass2obr[i] = mass2[i];
			}
		}
		int maxz = 0;
		for (int i = 0; i < mass2obr.length; i++) {
			int tem1 = Character.getNumericValue(mass1obr[i]);
			int tem2 = Character.getNumericValue(mass2obr[i]);
			if (tem1 > tem2) {
				maxz++;
			} else if (tem1 < tem2 && maxz == 0) {
				str = "" +  -1;
				return str;
			}
			
		}
		int k = 0;
		for (int i = max - 1; i >= 0 ; i--) {
			int temp1 = Character.getNumericValue(mass1obr[i]);
			int temp2 = Character.getNumericValue(mass2obr[i]);
			int check = temp1 - temp2;
			if (check >= 0) {
				if (k == 0) {
					str += check;
				} else {
					temp1--;
					check = temp1 - temp2;
					k = 0;
					if (check == 0) {
						str += 0;
					}
				}
			}
			if (check < 0) {
				if (k == 0) {
					str += 1;
					k = 1;
				} else {
					str += 0;
				}
			}
		}
		char [] arr = str.toCharArray();
		int r = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '0') {
				r++;
			}
		}
		String s = "";
		if (r == arr.length) {
			s += '0';
			return s;
		}
		k = 0;
		int m = 1;
		while (k == 0) {
				if (arr[arr.length - m] == '0') {
					str = "";
					for (int i = 0; i < arr.length - m; i++) {
						str += arr[i];
					}
					m++;
				} else {
					k = 1;
				}
		}
		StringBuffer End = new StringBuffer(str);
		End = End.reverse();
		s = "" + End;
		return(s);
	}
	
	
	public static void multiplication(String ch1, String ch2) {
		char [] mas = ch2.toCharArray();
		String res = "";
		String Chislo = "" + ch1;
		int k = 0;
		int check = 0;
		for (int i = ch2.length() - 1; i >= 0; i--) {
			if (mas[i] == '1') {
				check++;
				if (check == 1) {
					res += Chislo;
				} else {
					Chislo += '0';
					res = addition(res, Chislo);
				}
			} else {
				Chislo += '0';
			}
		}
		System.out.println(res);
	}
	
	public static void div(String ch1, String ch2) {
		char [] mass = ch1.toCharArray();
		String end = "";
		String del = "";
		for (int i = 0; i < ch1.length(); i++) {
			del += mass[i];
			if (subtraction(del,ch2) == "-1" ) {
				if (del == "0") {
					del = "";
				}
				end += "0";
			}else if (subtraction(del,ch2) == "0") {
				del = subtraction(del, ch2);
				end += "1"; 
			} else {
				del = subtraction(del,ch2);
				end += "1";
			}
		}
		StringBuffer r = new StringBuffer(end);
		r = r.reverse();
		end = "" + r;
		char [] arr = end.toCharArray();
		end = "";
		int k = 0;
		int m = 1;
		while (k == 0) {
				if (arr[arr.length - m] == '0') {
					end = "";
					for (int i = 0; i < arr.length - m; i++) {
						end += arr[i];
					}
					m++;
				} else {
					k = 1;
				}
		}
		r = new StringBuffer(end);
		r = r.reverse();
		System.out.print(r);
	}
}
