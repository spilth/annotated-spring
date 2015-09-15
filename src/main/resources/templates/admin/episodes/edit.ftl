<@application title="Edit Episode ${episode.id}">
<div class="full-page">
    <div class="episode-header">
      <div class="episode-meta row">
        <h3 class="episode-number col-sm-6 col-xs-6">Episode #${episode.id}</h3>
      </div>
      <h1>${episode.title}</h1>
    </div>

    <form action="/admin/episodes/${episodeId}" method="post" class="form-horizontal">
        <input type="hidden" name="_method" value="PUT" />
        <#include "_form.ftl">

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" id="update" value="Update" class="btn btn-primary" />
            </div>
        </div>
    </form>
</div>
</@application>