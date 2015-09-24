<@application title="${episode.title}" description="${episode.summary}" image="${episode.thumbnailUrl}" url="${url}">
  <div class="full-page">
    <div class="episode-header">
      <div class="episode-meta row">
        <h3 class="episode-number col-sm-6 col-xs-6">Episode #${episode.id}</h3>
          <#if episode.duration?has_content>
            <h6 class="episode-duration col-sm-6 col-xs-6"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>${episode.duration} m</h6>
          </#if>
      </div>
      <h1>${episode.title}</h1>
      <p>${episode.summary}</p>
    </div>
    <#if episode.youtubeId?? >
      <div class="iframe-wrapper">
        <iframe src="https://www.youtube.com/embed/${episode.youtubeId}?vq=hd720" frameborder="0" allowfullscreen></iframe>
        <div class="social-sharing-container">
          <div class="social-button">
            <a href="https://twitter.com/share" class="twitter-share-button" data-count="none">Tweet</a>
            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
          </div>
        </div>
      </div>
    </#if>
    <div>
        <div class="nav-tab-wrapper">
          <#if episode.sourcecodeUrl?? >
            <a href="${episode.sourcecodeUrl}" class="btn btn-primary btn-sm view-source-code">Episode Source Code</a>
          </#if>
          <ul class="nav nav-tabs" role="tablist">
              <li role="presentation" class="active">
                  <a href="#notes" aria-controls="notes" role="tab" data-toggle="tab">Transcript</a>
              </li>
              <li role="presentation">
                  <a href="#comments" aria-controls="comments" role="tab" data-toggle="tab" class="disqus-comment-count" data-disqus-url="http://www.annotatedspring.com${springMacroRequestContext.requestUri}">Comments</a>
              </li>
          </ul>
        </div>

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="notes">
                <p>${episode.notesHtml}</p>
            </div>

            <div role="tabpanel" class="tab-pane" id="comments">
                <#include "_discus.ftl" >
            </div>
        </div>
    </div>
  </div>
</@application>