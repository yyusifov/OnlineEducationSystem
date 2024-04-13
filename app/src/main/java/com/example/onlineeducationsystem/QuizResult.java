package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.FeedbackAdapter;
import com.example.onlineeducationsystem.model.Question;
import com.example.onlineeducationsystem.model.UserAnswer;
import com.example.onlineeducationsystem.model.UserGrades;
import com.example.onlineeducationsystem.util.UserViewModel;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private CardView resultTextCardView;

    private Button reviewButton;

    private UserViewModel userViewModel;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        show_result = findViewById(R.id.score_id);

        resultTextCardView = findViewById(R.id.result_demonstration_id);

        reviewButton = findViewById(R.id.review_but);

        recyclerView = findViewById(R.id.review_of_mistakes_id);

        Snackbar.make(reviewButton, String.valueOf(getIntent().getIntegerArrayListExtra("wrong_answers")), Snackbar.LENGTH_LONG).show();


        final ArrayList<Integer>[] wrong_answers = new ArrayList[]{getIntent().getIntegerArrayListExtra("wrong_answers")};

        userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(UserViewModel.class);


        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTextCardView.setVisibility(View.GONE);

                recyclerView.setVisibility(View.VISIBLE);

                recyclerView.setHasFixedSize(true);

                recyclerView.setLayoutManager(new LinearLayoutManager(QuizResult.this.getApplicationContext()));

                userViewModel.getAllUserAnswers().observe(QuizResult.this, new Observer<List<UserAnswer>>() {
                    @Override
                    public void onChanged(List<UserAnswer> userAnswers) {
                        FeedbackAdapter feedbackAdapter = new FeedbackAdapter((ArrayList<UserAnswer>) userAnswers.stream().filter(userAnswer ->
                            userAnswer.getUser_id() == getIntent().getIntExtra("user_id",-5))
                                .filter(userAnswer -> userAnswer.getQuiz_id() == getIntent().getIntExtra("quiz_id", -5))
                                .filter(userAnswer -> userAnswer.getCourse_id() == getIntent().getIntExtra("course_id", -5))
                                .filter(userAnswer -> userAnswer.getGrade_id() == userAnswers.get(userAnswers.size() - 1).getGrade_id())
                                .collect(Collectors.toList()));

                        recyclerView.setAdapter(feedbackAdapter);
                    }
                });

            }
        });


        userViewModel.getAllQuestions().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                List<Question> questions1 = questions.stream().filter(question -> question.getQuiz_id() == getIntent().getIntExtra("quiz_id", -1)).collect(Collectors.toList());

                Log.d("rear", String.valueOf(questions1.size()));
                if(wrong_answers[0] == null){
                    wrong_answers[0] = new ArrayList<>();
                }

                String result_text = (questions1.size() - wrong_answers[0].size()) + "/" + questions1.size();

                UserGrades userGrades = new UserGrades();

                userGrades.setGrade((float) ((questions1.size() - wrong_answers[0].size() * 1.0) / questions1.size()));

                userGrades.setCourse_id(getIntent().getIntExtra("course_id",-5));

                userGrades.setQuiz_id(getIntent().getIntExtra("quiz_id",-5));

                userGrades.setUser_id(getIntent().getIntExtra("user_id",-5));

                UserViewModel.insertUserGrade(userGrades);

                Log.d("tellthem", "tellthem");
                Snackbar.make(recyclerView, "Tell them!", Snackbar.LENGTH_SHORT).show();

                show_result.setText(result_text);

                for (int i = 0; i < wrong_answers[0].size(); i++) {

                    int finalI = i;
                    userViewModel.getAllUserGrades().observe(QuizResult.this, new Observer<List<UserGrades>>() {
                        @Override
                        public void onChanged(List<UserGrades> userGrades1) {
                            Snackbar.make(recyclerView, "Tell them1!", Snackbar.LENGTH_SHORT).show();
                            Log.d("tellthem1", "tellthem");
                            callAPI("This is my question: " + questions1.get(wrong_answers[0].get(finalI)).getQuestion_text() + "\n" + "This is the correct answer: " + questions1.get(wrong_answers[0].get(finalI)).getCorrectAnswer() + "\n Can you provide feedback for this question in a more detailed explanation?",
                                    finalI + 1, questions1.get(wrong_answers[0].get(finalI)).getCorrectAnswer(), userGrades1.get(userGrades1.size() - 1).getGrade_id());
                        }
                    });

                }

                Snackbar.make(show_result, "Number of correct answers: " + (questions1.size() - wrong_answers[0].size()), Snackbar.LENGTH_LONG).show();
            }
        });

    }

    public void callAPI(String question, int questionNumber, String correct_answer, int grade_id) {
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
                getResponse("Failed response15: " + e.getMessage(), questionNumber, correct_answer, question, grade_id);
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
                                getResponse(resultText.trim(), questionNumber, correct_answer, question, grade_id);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Handle unsuccessful response
                    String errorBody = response.body().string(); // Read the error body
                    // Update UI on the main thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getResponse("Failed response: " + errorBody, questionNumber, correct_answer, question, grade_id);
                        }
                    });
                }
            }

        });
    }



    public void getResponse(String response, int questionNumber, String correct_answer, String question_text, int grade_id){


        UserAnswer userAnswer = new UserAnswer();

        userAnswer.setQuiz_id(getIntent().getIntExtra("quiz_id",-5));
        userAnswer.setCorrect_answer(correct_answer);
        userAnswer.setUser_id(getIntent().getIntExtra("user_id",-5));
        userAnswer.setFeedback(response);
        userAnswer.setQuestion_text(question_text);
        userAnswer.setCourse_id(getIntent().getIntExtra("course_id",-5));
        //Grade i duzelt
        userAnswer.setGrade_id(grade_id);
        userAnswer.setSubtopic_number(11);

//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getUser_id()));
//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getCorrect_answer()));
//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getGrade_id()));
//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getFeedback()));
//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getQuestion_text()));
//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getQuiz_id()));
//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getCourse_id()));
//        Log.d("Yoyoyo: ", String.valueOf(userAnswer.getSubtopic_number()));


        UserViewModel.insertUserAnswer(userAnswer);

        Snackbar.make(show_result, questionNumber + " - " + response, Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onBackPressed() {
        if(recyclerView.getVisibility() == View.VISIBLE){
            recyclerView.setVisibility(View.GONE);
            resultTextCardView.setVisibility(View.VISIBLE);
        }
        else{
            Intent intent = new Intent(QuizResult.this, TestSection.class);
            intent.putExtra("course_id", getIntent().getIntExtra("course_id",-5));
            intent.putExtra("user_id", getIntent().getIntExtra("user_id",-5));
            startActivity(intent);
        }

    }
}
