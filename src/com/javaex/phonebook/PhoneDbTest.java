package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDbTest {
	
	public static void main(String[] args) {

		List<PhoneDb> kbj = new ArrayList<>();
		
		readTxt(kbj);
		run(kbj);
		
		
	}

	private static void run(List<PhoneDb> kbj) {
		boolean value = true;
		int num = 0;
		String serchstr = "";
		System.out.println("***********************************************");
		System.out.println("*               전화번호 관리 프로그램             *");
		System.out.println("***********************************************");
		while (value) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-----------------------------------");
			System.out.print("메뉴번호: ");
			num = sc.nextInt();
		
		switch (num) {
		case 1:
			System.out.println();
			System.out.println("<1. 리스트>");
			showInfo(kbj);
			System.out.println();
			break;
		case 2:
			System.out.println();
			System.out.println("<2. 등록>");
			add(sc, kbj);
			break;
		case 3:
			System.out.println();
			System.out.println("<3. 삭제>");
			System.out.print("번호: ");
			delete(sc, kbj);
			break;
		case 4:
			System.out.println();
			System.out.println("<4. 검색>");
			System.out.print("이름: ");
			serchstr = sc.next();
			search(kbj, serchstr);
			System.out.println();
			break;
		case 5:
			System.out.println();
			System.out.println("***********************************************");
			System.out.println("*                  감사합니다                   *");
			System.out.println("***********************************************");
			sc.close();
			value = false;
			break;

		default:
			break;
		}
	

		}
	}
	// 같은 단어 포함 리스트 검색
	private static void search(List<PhoneDb> kbj, String str) {
		for (int i = 0; i < kbj.size(); i++) {
			PhoneDb serch = (PhoneDb) kbj.get(i);
			if (serch.getName().contains(str)) {
				System.out.println(serch.toString());
			}
		}

	}
	//선택한 번호 삭제
	private static void delete(Scanner sc, List<PhoneDb> kbj) {
		int del = sc.nextInt();
		kbj.remove(del - 1);
		update(kbj);
		System.out.println();
		wirtTxt(kbj);
		System.out.println("[삭제 완료]");
	}
	//리스트 출력
	private static void showInfo(List<PhoneDb>kbj) {
		for(int i = 0; i < kbj.size(); i++){
			System.out.println(kbj.get(i).toString());
		}
	}
	//리스트 추가
	private static void add(Scanner sc, List<PhoneDb> kbj) {
		String name;
		String hp;
		String company;
		System.out.print("->이름: ");
		name = sc.next();
		System.out.print("->휴대전화: ");
		hp = sc.next();
		System.out.print("->회사전화: ");
		company = sc.next();
		kbj.add(new PhoneDb( name, hp, company));
		update(kbj);
		System.out.println();
		wirtTxt(kbj);
		System.out.println("[등록 완료]");
	}
	//번호 순차대로 다시 넘버링
	private static void update(List<PhoneDb> kbj) {
		for (int i = 0; i < kbj.size(); i++) {
			PhoneDb n = (PhoneDb) kbj.get(i);
			n.setNum(i + 1);
		}

	}
	//텍스트 읽어오기
	private static List<PhoneDb> readTxt(List<PhoneDb> kbj) {
	      Reader re = null;
	      BufferedReader br = null;
	      try {
	         re = new FileReader("C:\\javaStudy\\workspace\\minipro.\\phoneDB.txt");
	         br = new BufferedReader(re);
	         String line = "";
	         String[] person = new String[3];
	         while ((line = br.readLine())  != null) {
	            person = line.split(",");
	            kbj.add(new PhoneDb( person[0], person[1], person[2]));
	         }
	      } catch (Exception e) {
	         e.fillInStackTrace();
	      } finally {
	         try {
	            if (br != null) br.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      update(kbj);
	      return kbj;
	   }
	//텍스트 쓰기
	private static void wirtTxt(List<PhoneDb>kbj) {
		Writer wr = null;
		BufferedWriter bw =null;
		try {
			//주스트림
			wr = new FileWriter("C:\\javaStudy\\workspace\\minipro.\\phoneDB.txt");
			//메인스트림
			bw = new BufferedWriter(wr);
			
			for(int i =0; i<kbj.size();i++) {
				PhoneDb writeperson = (PhoneDb) kbj.get(i);
				bw.write(writeperson.getName() + ",");
				bw.write(writeperson.getHp() + ",");
				bw.write(writeperson.getCompany());
				bw.write("\r\n");
			}
		}catch (Exception e) {
				e.printStackTrace();
			
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
