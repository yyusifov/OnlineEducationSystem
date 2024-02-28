package com.example.onlineeducationsystem;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineeducationsystem.QuizSetUp.Quiz;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class QuizResult extends AppCompatActivity {

    public static final MediaType JSON = MediaType.get("application/json");

    OkHttpClient client = new OkHttpClient();

    private TextView show_result;

    private String[] wrongAnsweredQuestions = new String[100];

    private String[] correctAnswers = new String[100];

    private String feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        show_result = findViewById(R.id.result_id);

        int number_of_correct_answers = 0;

        boolean[] student_answers = getIntent().getBooleanArrayExtra("StudentAnswers");

        Quiz[] question_set = (Quiz[]) getIntent().getSerializableExtra("Question_Set");

        int counter = 0;

        for (int i = 0; i < student_answers.length; i++) {
            if(student_answers[i] == true){
                number_of_correct_answers++;
            }
            else{
                Log.d("Wrong answers: ", String.valueOf(question_set[i].getQuestion()));
                wrongAnsweredQuestions[counter] = question_set[i].getQuestion();

                correctAnswers[counter++] = "Question i: " + question_set[i].getCorrectAnswer();

                callAPI("This is my question: " + question_set[i].getQuestion() + "\n" + "This is the correct answer: " + question_set[i].getCorrectAnswer() + "\n Can you provide feedback for this question in a more detailed explanation?");

            }
        }

        Snackbar.make(show_result, "Number of correct answers: " + number_of_correct_answers, Snackbar.LENGTH_LONG).show();
//        callAPI("What is component in react?");
    }

    public void callAPI(String question) {
        JSONObject jsonObject = new JSONObject();
        JSONArray messagesArray = new JSONArray();

        // System message
        JSONObject systemMessage = new JSONObject();
        try {
            systemMessage.put("role", "system");
            systemMessage.put("content", "You are a helpful assistant.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        messagesArray.put(systemMessage);

        // User message (question)
        JSONObject userMessage = new JSONObject();
        try {
            userMessage.put("role", "user");
            userMessage.put("content", question);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        messagesArray.put(userMessage);

        try {
            jsonObject.put("model", "gpt-3.5-turbo");
            jsonObject.put("messages", messagesArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(jsonObject.toString(), JSON);

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer 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")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("Wassup", e.getMessage());
                getResponse("Failed response15: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                JSONObject jsonObject1 = null;
                if (response.isSuccessful()) {
                    try {
                        jsonObject1 = new JSONObject(response.body().string());
                        JSONArray jsonArray = jsonObject1.getJSONArray("choices");
                        String resultText = jsonArray.getJSONObject(0).getJSONObject("message").getString("content");

                        // Update UI on the main thread
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getResponse(resultText.trim());
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Handle unsuccessful response
                    String errorBody = response.body().string(); // Read the error body
                    Log.d("Wassup", errorBody);
                    // Update UI on the main thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getResponse("Failed response: " + errorBody);
                        }
                    });
                }
            }

        });
    }



    public void getResponse(String response){
        //Snackbar.make(show_result, response, Snackbar.LENGTH_LONG).show();
        feedback += "\n" + response;
        show_result.setText(feedback);
    }
}
