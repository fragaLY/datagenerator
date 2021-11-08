package by.vk.datagen.data.postgres;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("data")
public record DataHolder(List<String> data) {

}
