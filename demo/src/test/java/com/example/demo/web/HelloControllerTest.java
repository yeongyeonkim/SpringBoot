package com.example.demo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이의 연결자
@WebMvcTest(controllers = HelloController.class) /* 여러 스프링 어노테이션 중, Web에 집중할 수 있는 어노테이션. @Controller 사용 가능 */
public class HelloControllerTest {
	
	@Autowired // 스프링이 관리하는 빈을 주입.
	private MockMvc mvc; // HTTP GET, POST 등에 대한 웹 API 테스트 가능.
	
	@Test
	public void hello가_리턴된다() throws Exception {
		String hello = "hello";
		
		mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string(hello));
	}

}
