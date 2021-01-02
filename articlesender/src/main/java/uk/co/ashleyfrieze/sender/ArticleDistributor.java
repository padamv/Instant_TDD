package uk.co.ashleyfrieze.sender;

import uk.co.ashleyfrieze.client.Channel;
import uk.co.ashleyfrieze.database.ArticleDataAccess;

/**
 * Work through today's articles sending them out to the right places
*/
public class ArticleDistributor {
	private Channel sport;
	private Channel entertainmet;
	private Channel other;
	private ArticleDataAccess dataAccess;

	public ArticleDistributor(Channel sport, Channel entertainmet, Channel other, ArticleDataAccess dataAccess) {
		this.sport = sport;
		this.entertainmet = entertainmet;
		this.other = other;
		this.dataAccess = dataAccess;
	}

	public void distributeTodays() {
		// TODO Auto-generated method stub
		
	}

}
