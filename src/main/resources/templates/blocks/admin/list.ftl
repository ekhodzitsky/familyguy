<#macro put_list>
    <#if list??>
        <table class="uk-table uk-table-divider">
            <thead>
            <tr>
                <th><b>ID</b></th>
                <th><b>Серия</b></th>
                <th><b>Сезон</b></th>
            </tr>
            </thead>
            <tbody>
            <#list list as l>
                <tr>
                    <td>${l.id}</td>
                    <td>${l.episode}</td>
                    <td>${l.season}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</#macro>