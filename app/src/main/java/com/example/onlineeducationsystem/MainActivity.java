package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineeducationsystem.model.UserRole;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button signIn;

    private TextView forgotPassword;

    private EditText username, password;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = findViewById(R.id.signIn);

        forgotPassword = findViewById(R.id.forgotPassword);

        username = findViewById(R.id.personUsername);

        password = findViewById(R.id.personPassword);




        userViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(UserViewModel.class);


//
//          UserRole userRole = new UserRole();
//
//          userRole.setId(1);
//
//          userRole.setRole_name("Student");
//
//          UserViewModel.insertRole(userRole);
//
//        UserGender userGender = new UserGender();
//
//        userGender.setGender_text("Male");
//
//        UserViewModel.insertUserGender(userGender);
//
//
//        UserInformation userInformation = new UserInformation();
//
//        userInformation.setUser_firstname("Tarana");
//
//        userInformation.setUser_surname("Karimova");
//
//        userInformation.setUser_password("tarana414");
//
//        userInformation.setUser_email("tkarimova41256@ada.edu.az");
//
//        userInformation.setUser_name("tkarimova41256");
//
//        userInformation.setGender_id(1);
//
//        userInformation.setPhone_number("(+994) 77 546 28 46");
//
//        userInformation.setBirth_date("06/09/2002");
//
//        userInformation.setRole_id(1);
//
//        userInformation.setCreation_date(new Date().getTime());
//
//        userInformation.setUpdate_date(new Date().getTime());
//
//        UserViewModel.insertUserInformation(userInformation);
//
//
//        CourseDescription courseDescription = new CourseDescription();
//
//        courseDescription.setDescription("This course will trace the evolution of human societies through key historical events and figures.");
//
//        courseDescription.setPassingScore(60.0);
//
//        courseDescription.setSyllabusLink("https://www.curriculumonline.ie/getmedia/da556505-f5fb-4921-869f-e0983fd80e50/SCSEC20_History_syllabus_eng.pdf");
//
//        UserViewModel.insertCourseDescription(courseDescription);
//
//
//        Courses course = new Courses();
//
//        course.setCourse_code(10259);
//
//        course.setCourse_name("History");
//
//        course.setCourse_instructor("Suleyman Cakir");
//
//        course.setDescription_id(2);
//
//        UserViewModel.insertCourse(course);
//
//
//        CourseTopics courseTopics = new CourseTopics();
//
//        courseTopics.setCourse_id(2);
//
//        courseTopics.setTopic_name("Renaissance Religion");
//
//        courseTopics.setTopic_number(6);
//
//        UserViewModel.insertCourseTopic(courseTopics);
//
//
//
//
//        CourseSubtopics courseSubtopics = new CourseSubtopics();
//
//        courseSubtopics.setSubtopic_name("The Intersection of Religion and Cartography in Renaissance Print");
//
//        courseSubtopics.setSubtopic_file("https://jmp.sh/rWiqX4JK");
//
//        courseSubtopics.setSubtopic_number(6.1);
//
//        courseSubtopics.setTopic_id(6);
//
//        UserViewModel.insertCourseSubtopic(courseSubtopics);
//
//
//
//        UserCourse userCourse = new UserCourse();
//
//        userCourse.setCourse_id(2);
//        userCourse.setUser_id(2);
//
//        UserViewModel.insertUserCourse(userCourse);
//
//        Quiz quiz = new Quiz();
//
//        quiz.setQuiz_name("Graded Quiz 1");
//
//        quiz.setCourse_id(2);
//
//        quiz.setTotal_number_of_questions(10);
//
//        UserViewModel.insertQuiz(quiz);
//
//
//
//        Question question1 = new Question();
//        question1.setQuestion_text("What year was the Gutenberg Bible first printed?");
//        question1.setAnswerA("1450");
//        question1.setAnswerB("1500");
//        question1.setAnswerC("1453");
//        question1.setAnswerD("1483");
//        question1.setCorrectAnswer("1453");
//        question1.setQuiz_id(2);
//        question1.setSubtopic_id(7);
//        UserViewModel.insertQuestion(question1);
//
//
//        Question question2 = new Question();
//        question2.setQuestion_text("Which of the following Bibles was printed in the year 1657?");
//        question2.setAnswerA("Complutense Polyglot Bible");
//        question2.setAnswerB("Erasmus Novum Instrumentum");
//        question2.setAnswerC("London Polyglot Bible");
//        question2.setAnswerD("Gutenberg Bible");
//        question2.setCorrectAnswer("London Polyglot Bible");
//        question2.setQuiz_id(2);
//        question2.setSubtopic_id(7);
//        UserViewModel.insertQuestion(question2);
//
//        Question question3 = new Question();
//        question3.setQuestion_text("What year did Nicholas Visscher publish his Old and New Testament?");
//        question3.setAnswerA("1650");
//        question3.setAnswerB("1600");
//        question3.setAnswerC("1700");
//        question3.setAnswerD("1750");
//        question3.setCorrectAnswer("1700");
//        question3.setQuiz_id(2);
//        question3.setSubtopic_id(7);
//        UserViewModel.insertQuestion(question3);
//
//        Question question4 = new Question();
//        question4.setQuestion_text("Which Bible includes the 'Novum Instrumentum' edition?");
//        question4.setAnswerA("Gutenberg Bible");
//        question4.setAnswerB("Erasmus's Bible");
//        question4.setAnswerC("Complutense Polyglot Bible");
//        question4.setAnswerD("Nicholas Visscher’s Bible");
//        question4.setCorrectAnswer("Erasmus's Bible");
//        question4.setQuiz_id(2);
//        question4.setSubtopic_id(7);
//        UserViewModel.insertQuestion(question4);
//
//        Question question5 = new Question();
//        question5.setQuestion_text("In what city was the Complutense Polyglot Bible printed?");
//        question5.setAnswerA("London");
//        question5.setAnswerB("Amsterdam");
//        question5.setAnswerC("Complutense");
//        question5.setAnswerD("None of the above");
//        question5.setCorrectAnswer("None of the above");
//        question5.setQuiz_id(2);
//        question5.setSubtopic_id(7);
//        UserViewModel.insertQuestion(question5);
//
//
//        Question question6 = new Question();
//        question6.setQuestion_text("Around what year is the Book of Hours, Use of Paris, estimated?");
//        question6.setAnswerA("1420");
//        question6.setAnswerB("1450");
//        question6.setAnswerC("1500");
//        question6.setAnswerD("1550");
//        question6.setCorrectAnswer("1450");
//        question6.setQuiz_id(1);
//        question6.setSubtopic_id(3);
//        UserViewModel.insertQuestion(question6);
//
//        Question question7 = new Question();
//        question7.setQuestion_text("Which scene from the Book of Hours features Jesus, Mary, and Joseph?");
//        question7.setAnswerA("Annunciation");
//        question7.setAnswerB("Crucifixion");
//        question7.setAnswerC("In the manger");
//        question7.setAnswerD("Final Judgement");
//        question7.setCorrectAnswer("In the manger");
//        question7.setQuiz_id(2);
//        question7.setSubtopic_id(3);
//        UserViewModel.insertQuestion(question7);
//
//        Question question8 = new Question();
//        question8.setQuestion_text("What is depicted on the first page with text in the Book of Hours?");
//        question8.setAnswerA("Saints days");
//        question8.setAnswerB("Jesus and disciples");
//        question8.setAnswerC("Holy Spirit");
//        question8.setAnswerD("Text introduction");
//        question8.setCorrectAnswer("Text introduction");
//        question8.setQuiz_id(1);
//        question8.setSubtopic_id(3);
//        UserViewModel.insertQuestion(question8);
//
//        Question question9 = new Question();
//        question9.setQuestion_text("Which illustration shows the Crucifixion of Christ?");
//        question9.setAnswerA("Image 7");
//        question9.setAnswerB("Image 8");
//        question9.setAnswerC("Image 9");
//        question9.setAnswerD("Image 10");
//        question9.setCorrectAnswer("Image 9");
//        question9.setQuiz_id(2);
//        question9.setSubtopic_id(3);
//        UserViewModel.insertQuestion(question9);
//
//        Question question10 = new Question();
//        question10.setQuestion_text("Which holiday scene is depicted by the Three Magi?");
//        question10.setAnswerA("Easter");
//        question10.setAnswerB("Christmas");
//        question10.setAnswerC("Thanksgiving");
//        question10.setAnswerD("New Year's");
//        question10.setCorrectAnswer("Christmas");
//        question10.setQuiz_id(1);
//        question10.setSubtopic_id(3);
//        UserViewModel.insertQuestion(question10);
//
//
//        Question question11 = new Question();
//        question11.setQuestion_text("Who created two different portraits of Erasmus around 1523 and 1526?");
//        question11.setAnswerA("Michelangelo");
//        question11.setAnswerB("Raphael");
//        question11.setAnswerC("Hans Holbein the Younger and Albrecht Dürer");
//        question11.setAnswerD("Leonardo da Vinci");
//        question11.setCorrectAnswer("Hans Holbein the Younger and Albrecht Dürer");
//        question11.setQuiz_id(2);
//        question11.setSubtopic_id(6);
//        UserViewModel.insertQuestion(question11);
//
//        Question question12 = new Question();
//        question12.setQuestion_text("What was the theme of the engraving 'Julius Exclusis' from 1513?");
//        question12.setAnswerA("The exclusion of Pope Julius II from heaven");
//        question12.setAnswerB("The coronation of Julius Caesar");
//        question12.setAnswerC("The baptism of Jesus");
//        question12.setAnswerD("A map of the Vatican");
//        question12.setCorrectAnswer("The exclusion of Pope Julius II from heaven");
//        question12.setQuiz_id(1);
//        question12.setSubtopic_id(6);
//        UserViewModel.insertQuestion(question12);
//
//
//        Question question13 = new Question();
//        question13.setQuestion_text("What does the 1522 Complutense Polyglot Bible represent in the context of the Reformation?");
//        question13.setAnswerA("A satire on indulgences");
//        question13.setAnswerB("A multilingual Bible supporting ecclesiastical reforms");
//        question13.setAnswerC("Portraits of Protestant reformers");
//        question13.setAnswerD("Maps of pilgrimage routes");
//        question13.setCorrectAnswer("A multilingual Bible supporting ecclesiastical reforms");
//        question13.setQuiz_id(2);
//        question12.setSubtopic_id(6);
//        UserViewModel.insertQuestion(question13);
//
//
//        Question question14 = new Question();
//        question14.setQuestion_text("What is depicted in the 'Passions of the Christ and Anti-Christ'?");
//        question14.setAnswerA("Biblical stories of Jesus and the Antichrist contrasted");
//        question14.setAnswerB("Scenes from the life of Martin Luther");
//        question14.setAnswerC("Various popes in historical contexts");
//        question14.setAnswerD("The seven-headed monster from");
//        question14.setCorrectAnswer("Biblical stories of Jesus and the Antichrist contrasted");
//        question14.setQuiz_id(2);
//        question14.setSubtopic_id(6);
//        UserViewModel.insertQuestion(question14);
//
//
//        Question question20 = new Question();
//        question20.setQuestion_text("What marks the beginning of the Second Age of the World in the Nuremberg Chronicle?");
//        question20.setAnswerA("The birth of Christ");
//        question20.setAnswerB("The Deluge");
//        question20.setAnswerC("The birth of Abraham");
//        question20.setAnswerD("The covenant with Noah");
//        question20.setCorrectAnswer("The birth of Abraham");
//        question20.setQuiz_id(2);
//        question20.setSubtopic_id(4);
//        UserViewModel.insertQuestion(question20);
//
//        Question question21 = new Question();
//        question21.setQuestion_text("What is depicted in the illustration of 'Noah’s Ark and the Rainbow Covenant'?");
//        question21.setAnswerA("The end of the world");
//        question21.setAnswerB("The covenant between God and Noah post-flood");
//        question21.setAnswerC("The building of the Tower of Babel");
//        question21.setAnswerD("The Exodus of Israelites");
//        question21.setCorrectAnswer("The covenant between God and Noah post-flood");
//        question21.setQuiz_id(2);
//        question21.setSubtopic_id(4);
//        UserViewModel.insertQuestion(question21);
//
//        Question question22 = new Question();
//        question22.setQuestion_text("In which age does the 'Jerusalem' scene occur according to the Nuremberg Chronicle?");
//        question22.setAnswerA("Third Age of the World");
//        question22.setAnswerB("Fourth Age of the World");
//        question22.setAnswerC("Second Age of the World");
//        question22.setAnswerD("First Age of the World");
//        question22.setCorrectAnswer("Second Age of the World");
//        question22.setQuiz_id(1);
//        question22.setSubtopic_id(1);
//        UserViewModel.insertQuestion(question22);
//
//        Question question23 = new Question();
//        question23.setQuestion_text("What significant biblical event is depicted in 'God creates Eve from Adam’s rib'?");
//        question23.setAnswerA("First Age of the World");
//        question23.setAnswerB("Second Age of the World");
//        question23.setAnswerC("Third Age of the World");
//        question23.setAnswerD("Fourth Age of the World");
//        question23.setCorrectAnswer("First Age of the World");
//        question23.setQuiz_id(2);
//        question23.setSubtopic_id(4);
//        UserViewModel.insertQuestion(question23);
//
//        Question question24 = new Question();
//        question24.setQuestion_text("Which world map from 1493 is featured in the Nuremberg Chronicle?");
//        question24.setAnswerA("Map of Europe");
//        question24.setAnswerB("Map of Asia");
//        question24.setAnswerC("Map of Jerusalem");
//        question24.setAnswerD("World map");
//        question24.setCorrectAnswer("World map");
//        question24.setQuiz_id(2);
//        question24.setSubtopic_id(4);
//        UserViewModel.insertQuestion(question24);
//
//        Question question15 = new Question();
//        question15.setQuestion_text("What event is depicted in the 'Burning of heretics' from the Nuremberg Chronicle?");
//        question15.setAnswerA("The Salem Witch Trials");
//        question15.setAnswerB("The Spanish Inquisition");
//        question15.setAnswerC("1300s heretic burnings");
//        question15.setAnswerD("The French Revolution");
//        question15.setCorrectAnswer("1300s heretic burnings");
//        question15.setQuiz_id(2);
//        question15.setSubtopic_id(5);
//        UserViewModel.insertQuestion(question15);
//
//        Question question16 = new Question();
//        question16.setQuestion_text("What is illustrated by the 'Dance of Death' in the Nuremberg Chronicle?");
//        question16.setAnswerA("A festival in medieval Germany");
//        question16.setAnswerB("A mythical event");
//        question16.setAnswerC("A moral allegory on the universality of death");
//        question16.setAnswerD("A historical battle");
//        question16.setCorrectAnswer("A moral allegory on the universality of death");
//        question16.setQuiz_id(2);
//        question16.setSubtopic_id(5);
//        UserViewModel.insertQuestion(question16);
//
//        Question question17 = new Question();
//        question17.setQuestion_text("Which city is prominently featured in its own colored image in the Nuremberg Chronicle?");
//        question17.setAnswerA("Rome");
//        question17.setAnswerB("Nuremberg");
//        question17.setAnswerC("Constantinople");
//        question17.setAnswerD("Babylon");
//        question17.setCorrectAnswer("Nuremberg");
//        question17.setQuiz_id(1);
//        question17.setSubtopic_id(5);
//        UserViewModel.insertQuestion(question17);
//
//        Question question18 = new Question();
//        question18.setQuestion_text("What period does 'John baptising Christ' in the Nuremberg Chronicle mark the beginning of?");
//        question18.setAnswerA("Fifth Age of the World");
//        question18.setAnswerB("Fourth Age of the World");
//        question18.setAnswerC("Third Age of the World");
//        question18.setAnswerD("Sixth Age of the World");
//        question18.setCorrectAnswer("Sixth Age of the World");
//        question18.setQuiz_id(2);
//        question18.setSubtopic_id(5);
//        UserViewModel.insertQuestion(question18);
//
//        Question question19 = new Question();
//        question19.setQuestion_text("What major biblical event is depicted at the start of the Seventh Age in the Nuremberg Chronicle?");
//        question19.setAnswerA("The creation of Adam and Eve");
//        question19.setAnswerB("The Apocalypse");
//        question19.setAnswerC("Moses receiving the Ten Commandments");
//        question19.setAnswerD("The birth of Christ");
//        question19.setCorrectAnswer("The Apocalypse");
//        question19.setQuiz_id(2);
//        question19.setSubtopic_id(5);
//        UserViewModel.insertQuestion(question19);
//
//        Question question26 = new Question();
//        question26.setQuestion_text("What is the main topic of the manuscript 'Chronique du monde depuis la création'?");
//        question26.setAnswerA("Creation of the universe");
//        question26.setAnswerB("History of France");
//        question26.setAnswerC("The Bible's historical tales");
//        question26.setAnswerD("History of printing technology");
//        question26.setCorrectAnswer("Creation of the universe");
//        question26.setQuiz_id(2);
//        question26.setSubtopic_id(1);
//        UserViewModel.insertQuestion(question26);
//
//        Question question27 = new Question();
//        question27.setQuestion_text("Which manuscript describes 'God measuring the world'?");
//        question27.setAnswerA("C’est la bible hystoriale en français");
//        question27.setAnswerB("Chronique du monde depuis la création");
//        question27.setAnswerC("Encyclopédie of Diderot and d’Alembert");
//        question27.setAnswerD("The Thomas Printing Press");
//        question27.setCorrectAnswer("C’est la bible hystoriale en français");
//        question27.setQuiz_id(2);
//        question27.setSubtopic_id(1);
//        UserViewModel.insertQuestion(question27);
//
//        Question question28 = new Question();
//        question28.setQuestion_text("What year was the 'C’est la bible hystoriale en français' manuscript created?");
//        question28.setAnswerA("1461");
//        question28.setAnswerB("1373");
//        question28.setAnswerC("1760");
//        question28.setAnswerD("1784");
//        question28.setCorrectAnswer("1373");
//        question28.setQuiz_id(2);
//        question28.setSubtopic_id(1);
//        UserViewModel.insertQuestion(question28);
//
//        Question question29 = new Question();
//        question29.setQuestion_text("What key invention is associated with the British Industrial Revolution around 1769?");
//        question29.setAnswerA("Spinning mule");
//        question29.setAnswerB("Steam engine");
//        question29.setAnswerC("Spinning jenny");
//        question29.setAnswerD("Cotton gin");
//        question29.setCorrectAnswer("Steam engine");
//        question29.setQuiz_id(2);
//        question29.setSubtopic_id(1);
//        UserViewModel.insertQuestion(question29);
//
//
//        Question question30 = new Question();
//        question30.setQuestion_text("Which year did the usage of the Flying shuttle begin during the British Industrial Revolution?");
//        question30.setAnswerA("1733");
//        question30.setAnswerB("1764");
//        question30.setAnswerC("1785");
//        question30.setAnswerD("1793");
//        question30.setCorrectAnswer("1733");
//        question30.setQuiz_id(1);
//        question30.setSubtopic_id(1);
//        UserViewModel.insertQuestion(question30);
//
        UserViewModel.deleteAllUserAnswers();

        UserViewModel.deleteAllUserGrades();
//
//        UserViewModel.deleteAllQuestions();

        //bir de back pressleri duzelt
        userViewModel.getAllRoles().observe(this, new Observer<List<UserRole>>() {
            @Override
            public void onChanged(List<UserRole> userRoles) {
                for (int i = 0; i < userRoles.size(); i++) {
                    Log.d("element " + userRoles.get(i).getId(), userRoles.get(i).getRole_name());
                }
            }
        });
    }

    public void onSignIn(View view){

//        Intent intent = new Intent(MainActivity.this, HomePage.class);
//        startActivity(intent);

        userViewModel.getAllUserInformation().observe(MainActivity.this, userInformation -> {
            for(int i = 0; i < userInformation.size(); i++){
                if(username.getText().toString().trim().equals(userInformation.get(i).getUser_name())
                        && password.getText().toString().trim().equals(userInformation.get(i).getUser_password())){

                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    intent.putExtra("Id_of_entered_user", userInformation.get(i).getId());
                    startActivity(intent);

                }
            }
        });
    }

    public void onForgotPassword(View view){
        Intent intent = new Intent(MainActivity.this, PasswordRecovery.class);

        startActivity(intent);
    }
}