<#macro put_list>
    <#if list??>
        <table class="uk-table uk-table-divider">
            <thead>
            <tr>
                <th style="font-family: 'Roboto Condensed', sans-serif;"><b>ID</b></th>
                <th style="font-family: 'Roboto Condensed', sans-serif;"><b>Серия</b></th>
                <th style="font-family: 'Roboto Condensed', sans-serif;"><b>Сезон</b></th>
            </tr>
            </thead>
            <tbody>
            <#list list as l>
                <tr>
                    <td style="font-family: 'Roboto Condensed', sans-serif;">${l.id}</td>
                    <td style="font-family: 'Roboto Condensed', sans-serif;">${l.episode}</td>
                    <td style="font-family: 'Roboto Condensed', sans-serif;">${l.season}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</#macro>