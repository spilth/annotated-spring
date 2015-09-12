<@application title="Episodes">
    <h1>Episodes</h1>

    <#list episodes as episode>
        <div class="row">
            <div class="col-md-5">
                <#if episode.thumbnailUrl?? >
                    <a href="/episodes/${episode.id}"><img src="${episode.thumbnailUrl}" class="img-thumbnail img-responsive" /></a>
                </#if>
            </div>
            <div class="col-md-7">
                <h3>Episode #${episode.id}</h3>
                <h2><a href="/episodes/${episode.id}" id="episode${episode.id}">${episode.title}</a></h2>
                <p>${episode.summary}</p>
                <h6>(${episode.duration} minutes)</h6>
            </div>
        </div>
    <div class="row"></div>
    </#list>

    <p><a href="/admin/episodes/new" id="create-episode" class="btn btn-default">Create Episode</a></p>
</@application>
