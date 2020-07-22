package challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {

    Quote findById(Integer quoteId);

    List<Quote> findByActor(String actor);

}
