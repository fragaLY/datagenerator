package by.vk.datagen.service.postgres;

import by.vk.datagen.data.meta.DataDefinition;
import by.vk.datagen.repository.postgres.PostgresDBRepository;
import org.springframework.stereotype.Service;

@Service
public record PostgresDatagenService(PostgresFakeDataGenerator generator, PostgresDBRepository repository) {

  public void create(DataDefinition definition) {
    var data = generator.generate(definition);
    repository.saveAll(data);
  }
}
