<@application>
    <h1>Episodes</h1>

    <table>
    <#list episodes as episode>
        <tr><td><a id="episode${episode.id}" href="/episodes/${episode.id}">${episode.title}</a></td></tr>
    </#list>
    </table>
</@application>