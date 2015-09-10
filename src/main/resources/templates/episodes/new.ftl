<@application title="New Episode">
    <h1>New Episode</h1>

    <form action="/admin/episodes" method="post" class="form-horizontal">
        <#include "_form.ftl">

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" id="create" value="Create" class="btn btn-default" />
            </div>
        </div>
    </form>
</@application>