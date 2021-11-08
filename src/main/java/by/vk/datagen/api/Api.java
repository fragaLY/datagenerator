package by.vk.datagen.api;

import by.vk.datagen.data.meta.DataDefinition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api/data")
public interface Api {

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  @ResponseStatus(CREATED)
  ResponseEntity<Void> create(@RequestBody DataDefinition definition);
}
