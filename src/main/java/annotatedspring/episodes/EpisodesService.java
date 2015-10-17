package annotatedspring.episodes;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodesService {
    @Autowired
    EpisodesRepository episodesRepository;

    public Iterable<Episode> all() {
        return episodesRepository.findAll();
    }

    public Episode create(Episode episode) {
        return episodesRepository.save(episode);
    }

    public Episode find(int episodeId) {
        return episodesRepository.findOne(episodeId);
    }

    public Episode update(Episode updatedEpisode) {
        return episodesRepository.save(updatedEpisode);
    }

    public Iterable<Episode> published() {
        return episodesRepository.findByPublishedOrderByIdDesc(true);
    }
    
    public Collection<Episode> latestEpisodes() {
        return episodesRepository.findFirst10ByPublishedOrderByIdDesc(true);
    }
    
    public Episode mostRecent() {
        return episodesRepository.findFirstByPublishedOrderByIdDesc(true);
    }
}
