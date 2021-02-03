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

@RunWith(SpringRunner.class) // ������ ��Ʈ �׽�Ʈ�� JUnit ������ ������
@WebMvcTest(controllers = HelloController.class) /* ���� ������ ������̼� ��, Web�� ������ �� �ִ� ������̼�. @Controller ��� ���� */
public class HelloControllerTest {
	
	@Autowired // �������� �����ϴ� ���� ����.
	private MockMvc mvc; // HTTP GET, POST � ���� �� API �׽�Ʈ ����.
	
	@Test
	public void hello��_���ϵȴ�() throws Exception {
		String hello = "hello";
		
		mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string(hello));
	}

}
