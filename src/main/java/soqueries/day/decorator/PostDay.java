package soqueries.day.decorator;

import soqueries.day.Day;
import soqueries.day.component.AnswerDay;
import soqueries.day.component.QuestionDay;
/**
 * <<entity>>
 * This class extends Day for run query from posts table with year, month, day, limit.
 */
public class PostDay extends Day {

	/**
	 * Default constructor, init variables of the query.
	 * @param year	The year parameter to be inserted in the query.
	 * @param month	The month parameter to be inserted in the query.
	 * @param day 	The day parameter to be inserted in the query.
	 * @param lim 	The limit parameter to be inserted in the query.
	**/
	public PostDay(final Integer year, final Integer month, final Integer day, final Integer lim) {

		super(year, month, day, lim);

	}

	/**
	 * @return String that is union of two queries
	 */
	public String getQueryString() {

		QuestionDay question = new QuestionDay(getYear(), getMonth(), getDay(), getLim());
		AnswerDay answer = new AnswerDay(getYear(), getMonth(), getDay(), getLim());
		return question.getQuery().toUnionDistinct(answer.getQuery());

	}

}

