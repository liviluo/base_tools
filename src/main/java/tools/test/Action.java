package tools.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Action {

	@Value("${environment}")
	private String environment;

	public void environment() {
		System.out.println("当前的环境是：" + environment);
	}

}
