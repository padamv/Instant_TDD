package uk.co.ashleyfrieze.sender;

import uk.co.ashleyfrieze.article.Article;
import uk.co.ashleyfrieze.client.Channel;
import uk.co.ashleyfrieze.client.EntertainmentChannel;
import uk.co.ashleyfrieze.client.OtherChannel;
import uk.co.ashleyfrieze.client.SportsChannel;
import uk.co.ashleyfrieze.database.ArticleDataAccess;

/**
 * Work through today's articles sending them out to the right places
 */
public class ArticleDistributor {
	private Channel sport;
	private Channel entertainmet;
	private Channel other;
	private ArticleDataAccess dataAccess;

	public ArticleDistributor(SportsChannel sport, EntertainmentChannel entertainmet, OtherChannel other,
			ArticleDataAccess dataAccess) {
		this.sport = sport;
		this.entertainmet = entertainmet;
		this.other = other;
		this.dataAccess = dataAccess;
	}

	public void distributeTodays() {
		for (Article article : dataAccess.getTodaysArticles()) {
			switch (article.getType()) {
			case SPORT:
				sport.accept(article);
				break;
			case ENTERTAINMENT:
				entertainmet.accept(article);
				break;
			default:
				other.accept(article);
			}
		}

	}

}
