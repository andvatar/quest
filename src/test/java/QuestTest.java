import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.javarush.tarasov.quest.entity.Quest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestTest {
    @Test
    public void parseJSONQuest() throws JsonProcessingException {
        String jsonQuest = "{\"id\": 1," +
                "    \"name\": \"Test quest\"," +
                "    \"description\": \"Test description\"," +
                "    \"startQuestionId\" : 1}";

        ObjectMapper objectMapper = new ObjectMapper();
        Quest quest =  objectMapper.readValue(jsonQuest, Quest.class);

        assertEquals(1, quest.getId());
        assertEquals("Test quest", quest.getName());
        assertEquals("Test description", quest.getDescription());
        assertEquals(1, quest.getStartQuestionId());
    }
}
