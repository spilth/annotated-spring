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
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EpisodesControllerTest {
    @InjectMocks
    private EpisodesController episodesController;

    @Mock
    private EpisodesService episodesService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(episodesController).build();
    }

    @Test
    public void episodeIndex_rendersIndex() throws Exception {
        List<Episode> episodes = new ArrayList<>();

        when(episodesService.all()).thenReturn(episodes);

        mockMvc.perform(get("/episodes"))
                .andExpect(status().isOk())
                .andExpect(view().name("episodes/index"))
                .andExpect(model().attribute("episodes", episodes));
    }

    @Test
    public void newEpisode_rendersNewForm() throws Exception {
        mockMvc.perform(get("/episodes/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("episodes/new"));
    }

    @Test
    public void createEpisode_redirectsToEpisodeIndex() throws Exception {
        mockMvc.perform(post("/episodes"))
                .andExpect(redirectedUrl("/episodes"));
    }

    @Test
    public void createEpisode_validEpisode_createsEpisode() throws Exception {
        mockMvc.perform(post("/episodes").param("title", "episode title"))
            .andExpect(redirectedUrl("/episodes"));

        verify(episodesService, times(1)).create(any(Episode.class));
    }

    @Test
    public void showEpisodes_validEpisode_rendersShow() throws Exception {
        Episode episode = mock(Episode.class);

        when(episodesService.find(1)).thenReturn(episode);

        mockMvc.perform(get("/episodes/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("episodes/show"))
            .andExpect(model().attribute("episode", episode));
    }
}