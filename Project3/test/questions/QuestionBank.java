package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionBank {
    Question l1, l2;
    Question mc1, mc2;
    Question ms1, ms2;
    Question tf1, tf2;

    @BeforeEach
    void setUp() {
        l1 = new Likert("How do you like CS5001?");
        l2 = new Likert("How do you like CS5002?");

        mc1 = new MultipleChoice("What's the answer for multiple choice 1?",
                "1",
                "Option 1", "Option 2", "Option 3", "Option 4");
        mc2 = new MultipleChoice("What's the answer for multiple choice 2?",
                "3",
                "Option 1", "Option 2", "Option 3", "Option 4", "Option 5");

        ms1 = new MultipleSelect("What's the answer for multiple select 1?",
                "1 4",
                "Option 1", "Option 2", "Option 3", "Option 4");
        ms2 = new MultipleSelect("What's the answer for multiple select 2?",
                "3 2 5",
                "Option 1", "Option 2", "Option 3", "Option 4", "Option 5");


        tf1 = new TrueFalse("What's the answer for true or false 1?", "True");
        tf2 = new TrueFalse("What's the answer for true or false 2?", "False");
    }

    @Test
    void testConstructor(){
        assertThrows(IllegalArgumentException.class, () -> {new MultipleChoice("What's the answer?",
                "2",
                "Option 1", "Option 2");});
        assertThrows(IllegalArgumentException.class, () -> {new MultipleSelect("What's the answer?",
                "1 2",
                "Option 1", "Option 2");});
    }

    @Test
    void answer() {
        assertEquals("Correct", l1.answer("3"));
        assertEquals("Incorrect", l2.answer("8"));
        assertEquals("Incorrect", l2.answer(""));
        assertEquals("Correct", mc1.answer("1"));
        assertEquals("Incorrect", mc1.answer(""));
        assertEquals("Incorrect", mc2.answer("2"));
        assertEquals("Incorrect", mc2.answer("8"));
        assertEquals("Correct", ms1.answer("4 1"));
        assertEquals("Incorrect", ms1.answer(""));
        assertEquals("Incorrect", ms2.answer("2 3"));
        assertEquals("Incorrect", ms2.answer("8"));
        assertEquals("Correct", tf1.answer("True"));
        assertEquals("Incorrect", tf2.answer("True"));
        assertEquals("Incorrect", tf2.answer(""));
    }

    @Test
    void getText(){
        assertEquals("How do you like CS5001?", l1.getText());
        assertEquals("What's the answer for multiple choice 1?", mc1.getText());
        assertEquals("What's the answer for multiple select 1?", ms1.getText());
        assertEquals("What's the answer for true or false 1?", tf1.getText());
    }

    @Test
    void compareTo() {
        assertTrue(l1.compareTo(l2) < 0);
        assertTrue(l1.compareTo(mc1) > 0);
        assertTrue(l1.compareTo(ms1) > 0);
        assertTrue(l1.compareTo(tf1) > 0);

        assertTrue(ms1.compareTo(ms2) < 0);
        assertTrue(ms1.compareTo(mc1) > 0);
        assertTrue(ms1.compareTo(l1) < 0);
        assertTrue(ms1.compareTo(tf1) > 0);

        assertTrue(mc1.compareTo(mc2) < 0);
        assertTrue(mc1.compareTo(l1) < 0);
        assertTrue(mc1.compareTo(ms1) < 0);
        assertTrue(mc1.compareTo(tf1) > 0);

        assertTrue(tf1.compareTo(tf2) < 0);
        assertTrue(tf1.compareTo(mc1) < 0);
        assertTrue(tf1.compareTo(ms1) < 0);
        assertTrue(tf1.compareTo(l1) < 0);
    }

    @Test
    void testSoring() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(l1);
        questionList.add(mc1);
        questionList.add(ms1);
        questionList.add(tf1);
        questionList.add(l2);
        questionList.add(mc2);
        questionList.add(ms2);
        questionList.add(tf2);
        Collections.sort(questionList);

        List<Question> sortedQuestionList = new ArrayList<>();
        sortedQuestionList.add(tf1);
        sortedQuestionList.add(tf2);
        sortedQuestionList.add(mc1);
        sortedQuestionList.add(mc2);
        sortedQuestionList.add(ms1);
        sortedQuestionList.add(ms2);
        sortedQuestionList.add(l1);
        sortedQuestionList.add(l2);

        for (int i = 0; i < sortedQuestionList.size(); i++) {
            assertEquals(sortedQuestionList.get(i), questionList.get(i));
        }
    }
}