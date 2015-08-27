<@application>
    <h1>Episode ${episode.id} - ${episode.title}</h1>

    <p>${episode.summary}</p>

    <#if episode.youtubeId?? >
        <iframe width="854" height="480" src="https://www.youtube.com/embed/${episode.youtubeId}" frameborder="0" allowfullscreen></iframe>
    </#if>

    <#if episode.sourcecodeUrl?? >
        <p><a href="${episode.sourcecodeUrl}">Episode ${episode.id} Source Code</a></p>
    </#if>

    <p>${episode.notes}</p>

    <p><a href="/episodes/${episode.id}/edit" class="btn btn-default">Edit</a></p>

    <#include "_discus.ftl" >

</@application>