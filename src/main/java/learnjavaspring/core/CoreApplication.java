package learnjavaspring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {
	// TODO: 비지니스 요구사항과 설계

	// 회원
		// 회원가입 및 조회
		// 회원은 일반회원과 VIP회원으로 구분
		// 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.

	// 주문과 할인 정책
		// 회원은 상품을 주문할 수 있다.
		// 회원 등급에 따른 할인 정책
		// 모든 VIP는 1000원 할인 해주는 고정 할인 금액 (추후 변경 가능)
		// 할인 정책은 변경 가능성이 높음. 오픈 직전까지 고민을 미루고 있고 최악의 경우 할인 미적용도 검토중

	// 인터페이스를 만들고 구현체를 언제든 갈아끼울 수 있도록 설계하는 방식으로 구현.


	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
