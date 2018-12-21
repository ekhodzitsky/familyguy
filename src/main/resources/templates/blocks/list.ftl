<#macro put_list>
    <#if list??>
        <table class="uk-table uk-table-divider">
            <thead>
            <tr>
                <th>ID</th>
                <th>Серия</th>
                <th>Сезон</th>
                <th>Ссылка</th>
            </tr>
            </thead>
            <tbody>
            <#list list as l>
                <tr>
                    <td>${l.id}</td>
                    <td>${l.episode}</td>
                    <td>${l.season}</td>
                    <td>${l.link}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</#macro>