<@application title="Admin">
    <h1>Admin</h1>

    <p><a href="/admin/episodes/new" id="create-episode" class="btn btn-primary">Create Episode</a></p>

    <table class="table">
        <thead>
            <tr>
                <th>Number</th>
                <th>Title</th>
                <th>Summary</th>
                <th>Duration</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <#list episodes as episode>
            <tr>
                <td>${episode.id}</td>
                <td>${episode.title}</td>
                <td>${episode.summary}</td>
                <td>${episode.duration}</td>
                <td><a href="/admin/episodes/${episode.id}/edit" class="btn btn-primary">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@application>
