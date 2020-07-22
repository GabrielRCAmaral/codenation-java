package challenge;

import org.springframework.stereotype.Service;


public interface QuoteService {

	Quote getQuote();
	
	Quote getQuoteByActor(String actor);

}
