<@application title="Episodes">
  <div class="row index-wrapper">
    <#list episodes as episode>
      <div class="col-sm-6 col-md-4 video-tile-wrapper">
        <a class="video-tile-anchor" href="/episodes/${episode.id}" id="episode${episode.id}">
          <div class="thumbnail">
            <div class="thumb-img-wrapper">
              <div class="thumb-img-overlay-wrapper">
                <div class="thumb-img-overlay"></div>
                <div class="play-button-wrapper">
                  <span class="play-button glyphicon glyphicon-play-circle" aria-hidden="true">
                </div>
              </div>
              <#if episode.thumbnailUrl?? >
                  <img src="${episode.thumbnailUrl}" class="img-thumbnail img-responsive" />
              </#if>
            </div>
            <div class="caption">
              <h2 class="episode-title">${episode.title}</h2>
              <p class="epsiode-summary">${episode.summary}</p>
              <div class="episode-meta row">
                <h3 class="episode-number col-md-6">Episode #${episode.id}</h3>
                <h6 class="episode-duration col-md-6"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>${episode.duration} m</h6>
              </div>
            </div>
          </div>
        </a>
      </div>
    </#list>
  </div><!-- row -->
</@application>
