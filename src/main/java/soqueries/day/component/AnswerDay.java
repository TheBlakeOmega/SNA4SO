package soqueries.day.component;

import soqueries.Query;
import soqueries.day.Day;
/**
 * <<entity>>
 * This class extends Day for run query from answers table with year, month, day, limit.
 */
public class AnswerDay extends Day {
	private Query query = new Query();
	/**
	 * Default constructor, init variables of the query.
	 * @param year	The year parameter to be inserted in the query.
	 * @param month	The month parameter to be inserted in the query.
	 * @param day 	The day parameter to be inserted in the query.
	 * @param lim 	The limit parameter to be inserted in the query.
	**/
	public AnswerDay(final Integer year, final Integer month, final Integer day, final Integer lim) {

		super(year, month, day, lim);
		buildQuery();

	}

	private void buildQuery() {
		query.setSelect("owner_user_id");
		query.setFrom("`bigquery-public-data.stackoverflow.posts_answers`");
		query.setWhere("extract(year from creation_date)=" + getYear()
				+ " AND " + "extract(month from creation_date)=" + getMonth()
				+ " AND " + "extract(day from creation_date)=" + getDay()
				+ " AND " + "owner_user_id > 0");
		query.setGroup("owner_user_id");
		query.setOrder("owner_user_id ASC");
		query.setLimit(getLim());
	}

	/**
	 * @return query That is the query AnswerDay
	 */
	public Query getQuery() {

		return query;

	}

	/**
	 * @return method toString of the query
	 */
	@Override
	public String getQueryString() {

		return query.toString();

	}

}

