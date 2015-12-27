<#assign title><@spring.message "page.homepage.title" /></#assign>
<@application title=title active="resources">
  <div class="row index-wrapper">
    <#list episodes as episode>
      <div class="col-sm-6 col-md-4 video-tile-wrapper">
        <a class="video-tile-anchor" href="/episodes/${episode.id}/${episode.slug}" id="episode${episode.id}">
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
              <h3 class="episode-title">${episode.title}</h3>

              <p class="epsiode-summary">${episode.summary}</p>
              <div class="episode-meta row">
                <h6 class="episode-number col-sm-8 col-xs-8">
                  <@spring.message "page.episode.number" />${episode.id}
                  <#if episode.publishDate??>
                      - ${episode.publishDate?date?string.medium}
                  </#if>
                </h6>
                <#if episode.duration?has_content>
                  <h6 class="episode-duration col-sm-4 col-xs-4"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>${episode.duration} m</h6>
                </#if>
              </div>
            </div>
          </div>
        </a>
      </div>
    </#list>
  </div><!-- row -->
</@application>
