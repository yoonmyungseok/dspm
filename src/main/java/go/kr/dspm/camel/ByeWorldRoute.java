package go.kr.dspm.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ByeWorldRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception{
    from("direct:bye").process(new ByeWorldProcessor());
  }
}
