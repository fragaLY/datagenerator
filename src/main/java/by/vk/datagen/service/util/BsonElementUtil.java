package by.vk.datagen.service.util;

import by.vk.datagen.data.meta.Field;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public record BsonElementUtil(Faker faker) {

    public String create(Field field) {
        var element = "";
        switch (field.type()) {
            case ADDRESS -> element = faker.address().fullAddress();
            case DATE_AND_TIME -> element = String.valueOf(faker.date().birthday().getTime());
            case DEMOGRAPHIC -> element = faker.demographic().toString();
            case FUNNY_NAME -> element = faker.funnyName().name();
            case NAME -> element = faker.name().fullName();
            case NATION -> element = faker.nation().nationality();
            case NUMBER -> element = String.valueOf(faker.number().randomNumber());
            case PHONE_NUMBER -> element = faker.phoneNumber().phoneNumber();
            default -> throw new IllegalStateException("[DATAGEN] Unexpected field type: " + field.type());
        }
        return element;
    }

}
