<@application>
    <h1>${episode.title}</h1>

    <#if episode.youtubeId?? >
        <iframe width="854" height="480" src="https://www.youtube.com/embed/${episode.youtubeId}" frameborder="0" allowfullscreen></iframe>
    </#if>

    <p><a href="/episodes/${episode.id}/edit">Edit</a></p>
</@application>