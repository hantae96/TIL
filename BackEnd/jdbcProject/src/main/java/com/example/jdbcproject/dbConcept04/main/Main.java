package com.example.jdbcproject.dbConcept04.main;
import com.example.jdbcproject.dbConcept04.DAO.MemberDAO;
import com.example.jdbcproject.dbConcept04.DTO.RegisterRequest;
import com.example.jdbcproject.dbConcept04.Service.ChangePasswordService;
import com.example.jdbcproject.dbConcept04.Service.MemberAllService;
import com.example.jdbcproject.dbConcept04.Service.MemberDeleteService;
import com.example.jdbcproject.dbConcept04.Service.MemberRegisterService;

import java.util.Scanner;

public class Main {
	private static MemberDAO memberDao = new MemberDAO();
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		while(true){
			System.out.println("명령어를 입력하세요");
			System.out.print("> ");
			String command = sc.nextLine();
			if(command.equalsIgnoreCase("exit")){
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new")){
				processNewCommand(command.split(" "));
				continue;
			} else if(command.startsWith("change")){
				processChangeCommand(command.split(" "));
				continue;
			} else if(command.startsWith("all")) {
				processAllCommand();
				continue;
			} else if(command.startsWith("delete")) {
				processDeleteCommand(command.split(" "));
				continue;
			}
			
			printHelp();
		}
	}
	private static void processNewCommand(String[] arg) {
		//	System.out.println("정보 등록 : new [이메일] [이름] [암호] [암호확인]");

		if(arg.length != 5){
			printHelp();
			return;
		}
		// MemberRegisterService 객체 생성
		// RegisterRequest 객체 생성
		// 데이터는 RegisterRequest 객체에 입력
		// regSvc.regist() 호출
		MemberRegisterService memberRegisterService = new MemberRegisterService(memberDao);

		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEmail(arg[1]);
		registerRequest.setName(arg[2]);
		registerRequest.setPassword(arg[3]);
		registerRequest.setConfirmPassword(arg[4]);
		memberRegisterService.regist(registerRequest);
	}
	
	private static void processAllCommand() {
//		System.out.println("모든 정보 출력 : all");
		// MemberAllService 객체 생성
		// allSvc.selectAll() 호출

		MemberAllService memberAllService = new MemberAllService(memberDao);
		memberAllService.selectAll();
	}

	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePasswordService = new ChangePasswordService(memberDao);
		System.out.println("바꿀 이메일과 기존의 비밀번호, 새로운 비밀번호를 차례대로 입력하세요");
		// ChangePasswordService 객체 생성
		// change.changePassword() 호출
		String email = arg[1];
		String oldPw = arg[2];
		String newPw = arg[3];
		changePasswordService.changePassword(email,oldPw,newPw);

	}

	private static void processDeleteCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return ;
		}
		// MemberDeleteService 객체 생성
		// delete.checkPassword() 호출

		MemberDeleteService memberDeleteService = new MemberDeleteService(memberDao);
		// ChangePasswordService 객체 생성
		// change.changePassword() 호출
		String email = arg[1];
		String password = arg[2];
		String confirmPassword = arg[3];
		memberDeleteService.checkPassword(email,password,confirmPassword);

	}

	private static void printHelp(){
		System.out.println();
		System.out.println("명령어 사용법을 확인하세요.");
		System.out.println("usage : ");
		System.out.println("모든 정보 출력 : all");
		System.out.println("정보 등록 : new [이메일] [이름] [암호] [암호확인]");
		System.out.println("비밀번호 수정 : change [이메일] [현재비밀번호] [변경할비밀번호]");
		System.out.println("정보 삭제 : delete [이메일] [암호] [암호확인]");
		System.out.println("종료 : exit");
		System.out.println();
	}
}
