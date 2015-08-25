package annotatedspring.episodes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String notes;

    private String youtubeId;

    private Integer duration;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
