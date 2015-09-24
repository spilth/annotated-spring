<@application title="Admin" active="admin">
<div class="full-page">
  <div class="row">
    <div class="col-md-6">
      <h1>Admin</h1>
    </div>
    <div class="col-md-6">
      <a href="/admin/episodes/new" id="create-episode" class="create-episode btn btn-primary">Create Episode</a>
    </div>
  </div>

    <table class="admin-table table">
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
                <td><a href="/episodes/${episode.id}">${episode.title}</a></td>
                <td>${episode.summary}</td>
                <td><#if episode.duration?has_content >${episode.duration}</#if></td>
                <td><a href="/admin/episodes/${episode.id}/edit" class="btn btn-default">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</@application>

