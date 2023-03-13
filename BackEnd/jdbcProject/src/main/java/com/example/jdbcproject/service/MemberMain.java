package com.example.jdbcproject.service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String tempName;
		int index;
		MemberDAOImpl memberDao = new MemberDAOImpl();

		while (true) {
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 회원 수정");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 > ");
			int select;
			try {
				select = Integer.parseInt(in.next());
			} catch (Exception e) {
				continue;
			}
			switch (select) {
				case 1:
					System.out.println("=== 회원 등록 ===");
					System.out.print("이름 : ");
					tempName = in.next();

					if (memberDao.findByName(tempName) != 1) {
						// 정보 등록
						MemberDTO member = new MemberDTO();
						member.setName(tempName);
						System.out.println("부서 입력 : ");member.setDepart(in.next());
						System.out.println("성별 입력 : ");member.setGender(in.next());
						System.out.println("날짜 입력 : ");member.setJoinDate(in.next());
						System.out.println("등급 입력 : ");member.setGrade(in.next());
						System.out.println("봉급 입력 : ");member.setSalary(in.nextInt());
						System.out.println("점수 입력 : ");member.setScore(in.nextInt());

						memberDao.insert(member);
						System.out.println("정보 입력이 완료 됬습니다.");
					} else {
						System.out.println("등록된 정보 입니다.");
					}
					break;

			case 2:
				System.out.println("=== 회원 검색 ===");
				System.out.print("이름 : "); tempName = in.next();
				if (memberDao.findByName(tempName) != 1) {
					System.out.println("미등록 정보입니다.");
				}else {
					MemberDTO member =memberDao.select(tempName);
					System.out.println(member.getName());
					System.out.println(member.getDepart());
					System.out.println(member.getGender());
					System.out.println(member.getJoinDate());
					System.out.println(member.getGrade());
					System.out.println(member.getSalary());
					System.out.println(member.getScore());
				}
				break;
			case 3:
				System.out.println("=== 회원 삭제 ===");
				System.out.print("이름 : "); tempName = in.next();
				if (memberDao.findByName(tempName) != 1) {
					System.out.println("미등록 정보입니다.");
				}else {
					memberDao.delete(tempName);
					System.out.println(tempName+ "삭제 되었습니다.");
				}
				break;
			case 4:
				System.out.println("=== 회원 수정 ===");
				System.out.print("이름 : "); tempName = in.next();
				if (memberDao.findByName(tempName) != 1) {
					System.out.println("미등록 정보입니다.");
				}else {
					memberDao.update(tempName,in.nextInt(),in.nextInt());
					System.out.println("정보가 수정되었습니다.");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("메뉴 확인 후 다시 입력하세요.");
			}
			}
		}

}









