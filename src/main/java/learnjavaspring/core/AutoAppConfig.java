package learnjavaspring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION, classes = Configuration.class // 기존에 사용한 AppConfig 클래스를 제외하기 위한 필터
        )
)
public class AutoAppConfig {

}
