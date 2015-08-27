package annotatedspring.episodes;

import annotatedspring.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EpisodesServiceTest {
    @InjectMocks
    private EpisodesService episodeService;

    @Mock
    private EpisodesRepository episodesRepository;

    private List<Episode> persistedEpisodes;
    private Episode persistedEpisode;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        persistedEpisodes = new ArrayList<>();
        persistedEpisode = mock(Episode.class);
    }

    @Test
    public void all_returnsAllEpisodes() throws Exception {
        when(episodesRepository.findAll()).thenReturn(persistedEpisodes);

        Iterable<Episode> episodes = episodeService.all();

        verify(episodesRepository, times(1)).findAll();
        assertThat(episodes, is(equalTo(persistedEpisodes)));
    }

    @Test
    public void create_addsAnEpisode() throws Exception {
        Episode episode = new Episode();

        episodeService.create(episode);

        verify(episodesRepository, times(1)).save(episode);
    }

    @Test
    public void find_getsAnEpisode() throws Exception {
        when(episodesRepository.findOne(1)).thenReturn(persistedEpisode);

        episodeService.find(1);

        verify(episodesRepository, times(1)).findOne(1);
    }

    @Test
    public void update_updatesAnEpisode() throws Exception {
        Episode episode = new Episode();

        when(episodesRepository.save(episode)).thenReturn(episode);

        episodeService.update(episode);

        verify(episodesRepository, times(1)).save(episode);
    }

    @Test
    public void published_returnsPublishedEpisodes() throws Exception {
        when(episodesRepository.findByPublished(true)).thenReturn(persistedEpisodes);

        Iterable<Episode> episodes = episodeService.published();

        verify(episodesRepository, times(1)).findByPublished(true);
        assertThat(episodes, is(equalTo(persistedEpisodes)));

    }
}