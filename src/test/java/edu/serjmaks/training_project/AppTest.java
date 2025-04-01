package edu.serjmaks.training_project;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.serjmaks.training_project.dto.dog.DogCreateDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class AppTest {

    @Container
    static MongoDBContainer container = new MongoDBContainer("mongo:4.4.4");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", container::getReplicaSetUrl);
    }

    @Test
    @SneakyThrows
    void shouldCreateDog() {
        DogCreateDto dogDto = getDogDto();
        String dogDtoString = objectMapper.writeValueAsString(dogDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/dog")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(dogDtoString))
                .andExpect(status().isCreated());
    }

    private DogCreateDto getDogDto() {
        return DogCreateDto.builder()
                .name("Fluffy")
                .age(13)
                .build();
    }
}
