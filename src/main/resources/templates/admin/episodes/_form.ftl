<div class="form-group">
    <label for="title" class="col-sm-2 control-label">Title</label>
    <div class="col-sm-10">
        <@spring.formInput "episode.title", "class='form-control'" />
        <@spring.showErrors "<br/>" />
    </div>
</div>
<div class="form-group">
    <label for="summary" class="col-sm-2 control-label">Summary</label>
    <div class="col-sm-10">
    <@spring.formInput "episode.summary", "class='form-control'" />
    </div>
</div>
<div class="form-group">
    <label for="notes" class="col-sm-2 control-label">Notes</label>
    <div class="col-sm-10">
        <@spring.formTextarea "episode.notes",  "class='form-control'" />
    </div>
</div>
<div class="form-group">
    <label for="youtubeId" class="col-sm-2 control-label">YouTube ID</label>
    <div class="col-sm-10">
        <@spring.formInput "episode.youtubeId",  "class='form-control'" />
    </div>
</div>
<div class="form-group">
    <label for="youtubeId" class="col-sm-2 control-label">Thumbnail URL</label>
    <div class="col-sm-10">
    <@spring.formInput "episode.thumbnailUrl",  "class='form-control'" />
    </div>
</div>
<div class="form-group">
    <label for="duration" class="col-sm-2 control-label">Duration</label>
    <div class="col-sm-10">
        <@spring.formInput "episode.duration",  "class='form-control'" />
    </div>
</div>
<div class="form-group">
    <label for="sourcecodeUrl" class="col-sm-2 control-label">Sourcecode URL</label>
    <div class="col-sm-10">
        <@spring.formInput "episode.sourcecodeUrl",  "class='form-control'" />
    </div>
</div>
<div class="form-group">
    <label for="published" class="col-sm-2 control-label">Published</label>
    <div class="col-sm-10">
        <@spring.formCheckbox "episode.published",  "class='form-control'" />
    </div>
</div>
