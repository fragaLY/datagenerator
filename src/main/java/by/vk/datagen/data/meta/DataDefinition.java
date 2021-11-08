package by.vk.datagen.data.meta;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DataDefinition(@Min(value = 1L, message = "At least one data sample should be persisted.") Long count,
                            @NotNull(message = "The body of data definition of fake data should not be null.") @Valid Body body) {


}
