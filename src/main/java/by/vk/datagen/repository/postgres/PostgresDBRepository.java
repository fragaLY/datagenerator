package by.vk.datagen.repository.postgres;

import by.vk.datagen.data.postgres.Data;
import org.springframework.data.repository.CrudRepository;

public interface PostgresDBRepository extends CrudRepository<Data, Long> {}
