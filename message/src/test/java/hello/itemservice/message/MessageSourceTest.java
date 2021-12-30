package hello.itemservice.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessageSourceTest {

	@Autowired
	MessageSource messageSource;
	
	@Test
	void helloMessage() {
		String result = messageSource.getMessage("hello", null, null);
		assertThat(result).isEqualTo("�ȳ�");
	}
	
	@Test
	void notFoundMessageCode() {
		assertThatThrownBy(() -> messageSource.getMessage("no_code", null, null))
			.isInstanceOf(NoSuchMessageException.class);
	}
	
	@Test
	void notFoundMessageCodeDefaultMessage() {
		String result = messageSource.getMessage("no_code", null, "�⺻ �޽���", null);
		assertThat(result).isEqualTo("�⺻ �޽���");
	}
	
	@Test
	void argumentMessage() {
		String message = messageSource.getMessage("hello.name", new Object[] {"Spring"}, null);
		assertThat(message).isEqualTo("�ȳ� Spring");
	}
	
	@Test
	void defaultLang() {
		assertThat(messageSource.getMessage("hello", null, null)).isEqualTo("�ȳ�");
		assertThat(messageSource.getMessage("hello", null, Locale.KOREA)).isEqualTo("�ȳ�");
	}
	
	@Test
	void enLang() {
		assertThat(messageSource.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
	}
}
