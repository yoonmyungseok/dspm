package go.kr.dspm.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
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
@CrossOrigin(origins = "*", maxAge = 6000)
@Profile("rest")
@Slf4j
public class ApiTestController {
  @Autowired
  private ProducerTemplate producerTemplate;
  Gson gson=new Gson();
  @GetMapping(value="/rest", produces = "application/json")
  public ResponseEntity<String> apiTestController(){
    try {
      log.info("###################rest테스트 성공!!!########################");
      return ResponseEntity.status(HttpStatus.OK)
          .body(gson.toJson(producerTemplate.requestBody("direct:sayBye","")));
//      return ResponseEntity.ok(fluentProducerTemplate.to("direct:sayHello").request(String.class));
    }catch (Exception e){
      log.info("###################rest테스트 실패!!!########################");
      return ResponseEntity.ok().body(null);
    }
  }
}
