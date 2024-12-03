package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.Question;

import java.util.ArrayList;

public class QuestionArrayCreator {

    public static ArrayList<Question> parseQuestionsFromJson(String jsonInput) {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            JsonObject jsonObj = JsonParser.parseString(jsonInput).getAsJsonObject();

            // Navigate through the JSON structure to find the questions array
            JsonArray candidates = jsonObj.getAsJsonArray("candidates");
            if (candidates != null && !candidates.isJsonNull() && candidates.size() > 0) {
                JsonObject content = candidates.get(0).getAsJsonObject().getAsJsonObject("content");
                JsonArray parts = content.getAsJsonArray("parts");
                if (parts != null && parts.size() > 0) {
                    String questionsJson = parts.get(0).getAsJsonObject().get("text").getAsString();

                    // Clean up the JSON string
                    questionsJson = questionsJson.replace("```json", "")
                                                 .replace("```", "")
                                                 .trim();

                    // Parse the actual questions JSON
                    JsonObject questionsObj = JsonParser.parseString(questionsJson).getAsJsonObject();
                    JsonArray jsonQuestions = questionsObj.getAsJsonArray("questions");

                    if (jsonQuestions != null) {
                        Gson gson = new Gson();
                        for (JsonElement element : jsonQuestions) {
                            JsonObject questionJson = element.getAsJsonObject();
                            
                            // Manually set the fields to match the Question class
                            Question question = new Question();
                            question.setQuestionContext(questionJson.get("questioncontext").getAsString());
                            question.setQuestionContexta(questionJson.get("questioncontexta").getAsString());
                            question.setQuestionContextb(questionJson.get("questioncontextb").getAsString());
                            question.setQuestionContextc(questionJson.get("questioncontextc").getAsString());
                            question.setQuestionContextd(questionJson.get("questioncontextd").getAsString());
                            question.setTopic(questionJson.get("topic").getAsString());
                            question.setDifficulty(questionJson.get("difficulty").getAsString());
                            question.setAnswer(questionJson.get("answer").getAsString());

                            questions.add(question);
                        }
                    } else {
                        System.out.println("No 'questions' array found in JSON input.");
                    }
                } else {
                    System.out.println("No 'parts' array found in JSON input.");
                }
            } else {
                System.out.println("No 'candidates' array found in JSON input.");
            }
        } catch (Exception e) {
            System.err.println("Error while parsing JSON: " + e.getMessage());
        }

        return questions;
    }

    // Main method remains the same
    public static void main(String[] args) {
        // JSON String from your AI response
        String jsonResponse = "{\n" +
                "  \"candidates\": [\n" +
                "    {\n" +
                "      \"content\": {\n" +
                "        \"parts\": [\n" +
                "          {\n" +
                "            \"text\": \"```json\\n{\\n  \\\"questions\\\": [\\n    {\\n      \\\"questioncontext\\\": \\\"Which of the following is NOT a factor of production?\\\",\\n      \\\"questioncontexta\\\": \\\"Land\\\",\\n      \\\"questioncontextb\\\": \\\"Labor\\\",\\n      \\\"questioncontextc\\\": \\\"Wages\\\",\\n      \\\"questioncontextd\\\": \\\"Capital\\\",\\n      \\\"topic\\\": \\\"Factors of Production\\\",\\n      \\\"difficulty\\\": \\\"Easy\\\",\\n      \\\"answer\\\": \\\"c\\\"\\n    },\\n    {\\n      \\\"questioncontext\\\": \\\"What is the term for the next best alternative forgone when making a decision?\\\",\\n      \\\"questioncontexta\\\": \\\"Opportunity cost\\\",\\n      \\\"questioncontextb\\\": \\\"Scarcity\\\",\\n      \\\"questioncontextc\\\": \\\"Utility\\\",\\n      \\\"questioncontextd\\\": \\\"Marginal cost\\\",\\n      \\\"topic\\\": \\\"Opportunity Cost\\\",\\n      \\\"difficulty\\\": \\\"Easy\\\",\\n      \\\"answer\\\": \\\"a\\\"\\n    },\\n    {\\n      \\\"questioncontext\\\": \\\"A production possibilities curve (PPC) shows the:\\\",\\n      \\\"questioncontexta\\\": \\\"Maximum possible output of two goods or services an economy can produce given its resources and technology.\\\",\\n      \\\"questioncontextb\\\": \\\"Minimum possible output of two goods or services an economy can produce given its resources and technology.\\\",\\n      \\\"questioncontextc\\\": \\\"The relationship between price and quantity demanded.\\\",\\n      \\\"questioncontextd\\\": \\\"The relationship between price and quantity supplied.\\\",\\n      \\\"topic\\\": \\\"Production Possibilities Curve\\\",\\n      \\\"difficulty\\\": \\\"Easy\\\",\\n      \\\"answer\\\": \\\"a\\\"\\n    }\\n  ]\\n}\\n```\\n\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ArrayList<Question> questions = parseQuestionsFromJson(jsonResponse);

        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestionContext());
            System.out.println("Answer: " + question.getAnswer());
            System.out.println("Topic: " + question.getTopic());
            System.out.println("Difficulty: " + question.getDifficulty());
            System.out.println();
        }
    }
}