package annotatedspring.episodes;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface EpisodesRepository extends CrudRepository<Episode, Integer> {
    Iterable<Episode> findAll();
    Iterable<Episode> findByPublished(boolean published);
    Iterable<Episode> findByPublishedOrderByIdDesc(boolean published);
    Collection<Episode> findFirst10ByPublishedOrderByIdDesc(boolean published);
    Episode findFirstByPublishedOrderByIdDesc(boolean published);
}
