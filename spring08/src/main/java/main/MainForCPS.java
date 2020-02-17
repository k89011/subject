package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;

public class MainForCPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext("classpath:appCtx.xml");

		ChangePasswordService cps = 
				ctx.getBean("changePwdSvc",ChangePasswordService.class);
		try {
			cps.changePassword("garnet2929@naver.com", "1234", "1111");
			System.out.println("암호를 변경하였습니다");
		}catch(MemberNotFoundException e) {
			System.out.println("회원정보가 존재 하지 않습니다");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("암호를 다시 확인하세요");
		}
		
	}

}
