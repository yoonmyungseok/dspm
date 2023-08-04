package go.kr.dspm.camel;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ByeWorldProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception{
    log.info("bye");
    Map<String, Object> result=new HashMap<>();
    result.put("message","bye world");
    exchange.getMessage().setBody(result);
  }
}
