package annotatedspring.episodes;

import annotatedspring.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EpisodesRssControllerTest {
    @InjectMocks
    private EpisodesRssController episodesRssController;

    @Mock
    private EpisodesService episodesService;

    @Mock
    private EpisodeFeedGenerator episodeFeedGenerator;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(episodesRssController).build();
    }

    @Test
    public void episodeIndex_rendersIndex() throws Exception {
        Episode secondEpisode = new Episode();
        secondEpisode.setId(2);
        secondEpisode.setTitle("Second Episode");

        Episode firstEpisode = new Episode();
        firstEpisode.setId(1);
        firstEpisode.setTitle("First Episode");

        List<Episode> publishedEpisodes = new ArrayList<>();
        publishedEpisodes.add(secondEpisode);
        publishedEpisodes.add(firstEpisode);

        when(episodesService.published()).thenReturn(publishedEpisodes);

        EpisodeFeed episodeFeed = new EpisodeFeed();
        when(episodeFeedGenerator.generate(publishedEpisodes)).thenReturn(episodeFeed);

        mockMvc.perform(get("/rss").accept(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE));
    }
}