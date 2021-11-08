package by.vk.datagen.data.meta;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Field(@NotBlank(message = "The field name should not be blank.") String name, FieldType type) {

}
