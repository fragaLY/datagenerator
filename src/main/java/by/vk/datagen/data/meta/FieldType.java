package by.vk.datagen.data.meta;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FieldType {
  ADDRESS("Address"),
  DATE_AND_TIME("DateAndTime"),
  DEMOGRAPHIC("Demographic"),
  FUNNY_NAME("FunnyName"),
  NAME("Name"),
  NATION("Nation"),
  NUMBER("Number"),
  SIGNAL("Signal"),
  PHONE_NUMBER("PhoneNumber");

  private final String name;

  FieldType(String name) {
    this.name = name;
  }

  @JsonValue
  public String getName() {
    return name;
  }

  public static FieldType get(String name) {
    return Arrays.stream(FieldType.values())
        .filter(it -> it.getName().equals(name))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("Incorrect field type."));
  }
}
