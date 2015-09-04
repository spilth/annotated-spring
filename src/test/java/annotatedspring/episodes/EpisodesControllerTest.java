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

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        List<Episode> publishedEpisodes = new ArrayList<>();

        when(episodesService.published()).thenReturn(publishedEpisodes);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("episodes/index"))
                .andExpect(model().attribute("episodes", publishedEpisodes));
    }

    @Test
    public void newEpisode_rendersNewForm() throws Exception {
        mockMvc.perform(get("/episodes/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("episodes/new"))
                .andExpect(model().attribute(("episode"), is(not(nullValue()))));
    }

    @Test
    public void createEpisode_redirectsToEpisodeIndex() throws Exception {
        Episode persistedEpisode = new Episode();
        persistedEpisode.setId(42);
        when(episodesService.create(any(Episode.class))).thenReturn(persistedEpisode);
        mockMvc.perform(post("/episodes").param("title", "episode title"))
                .andExpect(redirectedUrl("/episodes/42"));

        verify(episodesService, times(1)).create(any(Episode.class));
    }

    @Test
    public void createEpisode_invalidEpisode_rendersEditForm() throws Exception {

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

    @Test
    public void editEpisode_rendersEditForm() throws Exception {
        Episode episode = mock(Episode.class);

        when(episodesService.find(1)).thenReturn(episode);

        mockMvc.perform(get("/episodes/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("episodes/edit"))
                .andExpect(model().attribute("episode", episode));
    }

    @Test
    public void updateEpisode_validEpisode_updatesEpisode() throws Exception {
        mockMvc.perform(put("/episodes/1").param("title", "episode title"))
                .andExpect(redirectedUrl("/episodes/1"));

        verify(episodesService, times(1)).update(any(Episode.class));
    }

    @Test
    public void updatedEpisode_invalidEpisode_rendersEditForm() throws Exception {
        mockMvc.perform(put("/episodes/1").param("duration", "42")).andDo(print())
                .andExpect(view().name("episodes/edit"))
                .andExpect(model().attribute("episode", notNullValue()));
    }
}