package annotatedspring.episodes;

import org.springframework.data.repository.CrudRepository;

public interface EpisodesRepository extends CrudRepository<Episode, Integer> {
    Iterable<Episode> findAll();
    Iterable<Episode> findByPublished(boolean published);
    Iterable<Episode> findByPublishedOrderByIdDesc(boolean published);
    Iterable<Episode> findFirst10ByPublishedOrderByIdDesc(boolean published);
    Episode findFirstByPublishedOrderByIdDesc(boolean published);
}
