package by.vk.datagen.service.postgres;

import by.vk.datagen.data.meta.DataDefinition;
import by.vk.datagen.data.postgres.Data;
import by.vk.datagen.service.util.BsonElementUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public record PostgresFakeDataGenerator(BsonElementUtil util) {

  private static final Long RANGE_START_INDEX = 1L;

  public Queue<Data> generate(final DataDefinition definition) {
    var data = new ConcurrentLinkedQueue<Data>();
    var rangeEndIndex = definition.count();
    var fields = definition.body().fields();
    for (long index = RANGE_START_INDEX; index < rangeEndIndex; index++) {
      var elements = new ArrayList<String>();
      fields.forEach(it -> elements.add(util.create(it)));
      data.add(new Data(elements));
    }
    return data;
  }
}
