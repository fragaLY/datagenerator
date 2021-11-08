package by.vk.datagen.service.util;

import by.vk.datagen.data.meta.Field;
import com.github.javafaker.Faker;
import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.stereotype.Component;

@Component
public record BsonElementUtil(Faker faker) {

    private static final AtomicDouble SIGNAL = new AtomicDouble(0.01);

    public String create(Field field) {
        var element = "";
        switch (field.type()) {
            case ADDRESS -> element = faker.address().fullAddress();
            case DATE_AND_TIME -> element = String.valueOf(faker.date().birthday().getTime());
            case DEMOGRAPHIC -> element = faker.demographic().sex();
            case FUNNY_NAME -> element = faker.funnyName().name();
            case NAME -> element = faker.name().fullName();
            case NATION -> element = faker.nation().nationality();
            case NUMBER -> element = String.valueOf(faker.number().randomNumber());
            case PHONE_NUMBER -> element = faker.phoneNumber().phoneNumber();
            case SIGNAL -> element = String.valueOf(SIGNAL.addAndGet((1/(1+Math.pow(2, -SIGNAL.get()))))); // Pierre François Verhulst algorithm
            default -> throw new IllegalStateException("[DATAGEN] Unexpected field type: " + field.type());
        }
        return element;
    }

}
