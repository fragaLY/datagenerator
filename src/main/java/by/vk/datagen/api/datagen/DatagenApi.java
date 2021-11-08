package by.vk.datagen.api.datagen;

import by.vk.datagen.api.Api;
import by.vk.datagen.data.meta.DataDefinition;
import by.vk.datagen.service.postgres.PostgresDatagenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record DatagenApi(PostgresDatagenService service) implements Api {

  @Override
  public ResponseEntity<Void> create(DataDefinition definition) {
    service.create(definition);
    return ResponseEntity.noContent().build();
  }
}
