package com.group.libearyapp.app.config;

import org.springframework.context.annotation.Configuration;

//@Configuration + @Bean 은 외부 라이브러리나 프레임워크에서 만든 클래스를 등록할때 사용
// @Component 는 서비스, 리포지토리 모두아닌 개발자가 직접 작성한 클래스를 등록할떄 사용하며, 사용하면 스프링 서버 실행시 자동으로 감지되어 스프링 컨테이너에 적재된다.
@Configuration // 클래스에 붙이는 어노테이션  @Bean을 사용할떄 같이 사용해야한다.
public class UserConfiguration {

//  @Bean // 메서드에 붙이는 어노테이션
//  public UserRepository userRepository(JdbcTemplate jdbcTemplate) {
//    return new UserRepository(jdbcTemplate);
//  }

}
