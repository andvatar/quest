import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.javarush.tarasov.quest.entity.Quest;
import ru.javarush.tarasov.quest.entity.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    @Test
    public void parseJSONQuestion() throws JsonProcessingException {
        String jsonQuestion = "{" +
                "    \"id\" : 1," +
                "    \"text\" : \"test question\"," +
                "    \"answers\" :" +
                "    [" +
                "      {" +
                "        \"id\" : 1," +
                "        \"text\" : \"test answer 1\"," +
                "        \"nextQuestionId\" : 2" +
                "      }," +
                "      {" +
                "        \"id\" : 2," +
                "        \"text\" : \"test answer 2\"," +
                "        \"nextQuestionId\" : 5" +
                "      }" +
                "    ]" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Question question =  objectMapper.readValue(jsonQuestion, Question.class);

        assertEquals(1, question.getId());
        assertEquals("test question", question.getText());
        assertEquals(2, question.getAnswers().size());
        assertEquals(1, question.getAnswers().get(0).getId());
        assertEquals("test answer 1", question.getAnswers().get(0).getText());
        assertEquals(2, question.getAnswers().get(0).getNextQuestionId());
        assertEquals(2, question.getAnswers().get(1).getId());
        assertEquals("test answer 2", question.getAnswers().get(1).getText());
        assertEquals(5, question.getAnswers().get(1).getNextQuestionId());
    }
}
