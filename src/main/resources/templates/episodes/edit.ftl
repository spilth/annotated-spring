<@application>
    <h1>Edit Episode ${episode.id}: ${episode.title}</h1>

    <form action="/episodes/${episodeId}" method="post" class="form-horizontal">
        <#include "_form.ftl">

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" id="update" value="Update" class="btn btn-default" />
            </div>
        </div>

    </form>
</@application>