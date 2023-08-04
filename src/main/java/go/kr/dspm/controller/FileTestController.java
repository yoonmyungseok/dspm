package go.kr.dspm.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Profile("file")
public class FileTestController {
  @Autowired
  private ProducerTemplate producerTemplate;
  Gson gson=new Gson();

  @GetMapping("/file")
  public String file(){
    log.info("###################파일 테스트!!!########################");
    return "파일";
  }
}
