<#macro put_list>
    <#if list??>
        <table class="uk-table uk-table-divider">
            <thead>
            <tr>
                <th><b>ID</b></th>
                <th><b>Серия</b></th>
                <th><b>Сезон</b></th>
                <th><b>Название (rus)</b></th>
                <th><b>Название (eng)</b></th>
                <th><b>Описание</b></th>
                <th><b>Переводы</b></th>
            </tr>
            </thead>
            <tbody>
            <#list list as l>
                <tr>
                    <td>${l.id}</td>
                    <td>${l.episode}</td>
                    <td>${l.season}</td>
                    <td>
                    <#if l.rusName??>
                        ${l.rusName}
                    </#if>
                    </td>
                    <td>
                        <#if l.engName??>
                            ${l.engName}
                        </#if>
                    </td>
                    <td>
                        <#if l.description??>
                            ${l.description}
                        </#if>
                    </td>
                    <td><#if l.links??>
                            <#list l.links?keys as k>
                                <#if k??>
                                    ${k}
                                </#if>
                            </#list>
                        </#if>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</#macro>