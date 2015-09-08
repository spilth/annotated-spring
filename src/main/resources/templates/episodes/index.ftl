<@application>
    <h1>Episodes</h1>

    <table class="table">
        <thead>
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Summary</th>
                <th>Duration</th>
            </tr>
        </thead>
        <tbody>
        <#list episodes as episode>
            <tr>
                <td>${episode.id}</td>
                <td><a id="episode${episode.id}" href="/episodes/${episode.id}">${episode.title}</a></td>
                <td>${episode.summary}</td>
                <td>${episode.duration} minutes</td>
            </tr>
        </#list>
        </tbody>

    </table>

    <p><a href="/admin/episodes/new" id="create-episode" class="btn btn-default">Create Episode</a></p>
</@application>
