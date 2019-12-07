package triviaMaze_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.LinkedList;

import triviaMaze.Question;
import triviaMaze.QuestionHandler;
import triviaMaze.TypeOfQuestion;

class QuestionHandler_tests 
{
	//tests connection to db and pulling question data from db
	@Test
	void QuestionHandler_getQuestionsList()
	{
		QuestionHandler testqh = new QuestionHandler();
		assertFalse(testqh.getQuestions().isEmpty());
		
	}
}


