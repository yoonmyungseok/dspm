package go.kr.dspm.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
@CrossOrigin(origins = "*", maxAge = 6000)
//@Profile("api")
@Slf4j
public class HelloWorldController {
  @Autowired
  private ProducerTemplate producerTemplate;

  @Autowired
  private FluentProducerTemplate fluentProducerTemplate;
  Gson gson=new Gson();

  @GetMapping(value="/hello", produces = "application/json")
  public ResponseEntity<String> sayHello(){
    try {
      log.info("###################테스트 성공!!!########################");
      return ResponseEntity.status(HttpStatus.OK)
          .body(gson.toJson(producerTemplate.requestBody("direct:sayHello","")));
//      return ResponseEntity.ok(fluentProducerTemplate.to("direct:sayHello").request(String.class));
    }catch (Exception e){
      log.info("###################테스트 실패!!!########################");
      return ResponseEntity.ok().body(null);
    }
  }
}
