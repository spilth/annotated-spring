<@application title="${episode.title}" description="${episode.summary}">
    <h1>Episode ${episode.id} - ${episode.title}</h1>

    <p>${episode.summary}</p>

    <#if episode.youtubeId?? >
        <iframe width="854" height="480" src="https://www.youtube.com/embed/${episode.youtubeId}?vq=hd720" frameborder="0" allowfullscreen></iframe>
    </#if>

    <div>
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active">
                <a href="#notes" aria-controls="notes" role="tab" data-toggle="tab">Notes</a>
            </li>
            <li role="presentation">
                <a href="#comments" aria-controls="comments" role="tab" data-toggle="tab" class="disqus-comment-count" data-disqus-url="http://www.annotatedspring.com${springMacroRequestContext.requestUri}">Comments</a>
            </li>
        </ul>

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="notes">
                <#if episode.sourcecodeUrl?? >
                    <p><a href="${episode.sourcecodeUrl}" class="btn btn-primary">Browse Source Code</a></p>
                </#if>

                <p>${episode.notesHtml}</p>
            </div>

            <div role="tabpanel" class="tab-pane" id="comments">
                <#include "_discus.ftl" >
            </div>
        </div>
    </div>
</@application>