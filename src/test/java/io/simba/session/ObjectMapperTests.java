package io.simba.session;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.simba.session.dto.User;
import org.junit.Test;
import org.springframework.util.Assert;


public class ObjectMapperTests {
    @Test
    public void addClassTypeInJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        byte[] serializedBytes = objectMapper.writeValueAsBytes(new User("antiair88", "simba", "antiair88@gmail.com"));
        System.out.println("serialized : " + new String(serializedBytes));

        Object deserializedObject = objectMapper.readValue(serializedBytes, Object.class);
        System.out.println("deserialized : " + deserializedObject.toString());

        Assert.isInstanceOf(User.class, deserializedObject);
    }
}
