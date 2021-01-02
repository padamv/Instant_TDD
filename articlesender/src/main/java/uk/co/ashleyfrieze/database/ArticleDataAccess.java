package uk.co.ashleyfrieze.database;

import java.util.List;

import uk.co.ashleyfrieze.article.Article;

public interface ArticleDataAccess {

	/**
	 * @return all the articles from today
	 */
	List<Article> getTodaysArticles();
}
