<@application>
    <h1>Episode ${episode.id} - ${episode.title}</h1>

    <p>${episode.summary}</p>

    <#if episode.youtubeId?? >
        <iframe width="854" height="480" src="https://www.youtube.com/embed/${episode.youtubeId}?vq=hd720" frameborder="0" allowfullscreen></iframe>
    </#if>

    <p>${episode.notesHtml}</p>

    <#if episode.sourcecodeUrl?? >
    <p><a href="${episode.sourcecodeUrl}">Episode ${episode.id} Source Code</a></p>
    </#if>

    <p><a href="/episodes/${episode.id}/edit" class="btn btn-default">Edit</a></p>

    <h2>Comments</h2>
    <#include "_discus.ftl" >

</@application>