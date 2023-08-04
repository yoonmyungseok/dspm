package go.kr.dspm.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class HelloWorldRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception{
    from("direct:sayHello").process(new HelloWorldProcessor()).to("rest:get:/rest?host=localhost:9999");

//    restConfiguration().host("localhost").port("9999");
//    from("rest:get:hello?host=localhost:1234/say").transform().simple("Bye");
  }
}
