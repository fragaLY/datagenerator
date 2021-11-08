package by.vk.datagen.data.meta;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Body(@NotEmpty(message = "The data definition fields should not be empty.") @Valid List<Field> fields) {
}
