<#import "../common/admin_navigation.ftl" as a>
<#import "../common/admin_head.ftl" as h>
<#import "../../blocks/common/footer.ftl" as f>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины | Список <#if season??>${season[0].season} </#if>сезона</title>
    <@h.adm_head/>
</head>
<body>
<@a.adm_nav/>
<div class="uk-container uk-container-expand">
    <#if season??>
        <table class="uk-table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Серия</th>
                <th>Сезон</th>
                <th>Название (RUS)</th>
                <th>Название (ENG)</th>
                <th>Описание</th>
                <th>Переводы</th>
            </tr>
            </thead>
            <#list season as v>
                <tbody>
                <tr>
                    <td><b>[ id:</b> <a href="/admin/video_details/${v.id}">${v.id}</a> <b>]</b></td>
                    <td>${v.episode}</td>
                    <td>${v.season}</td>
                    <td><#if v.rusName??>${v.rusName}</#if></td>
                    <td><#if v.engName??>${v.engName}</#if></td>
                    <td><#if v.description??>${v.description}</#if></td>
                    <td><#if v.links??>
                            <#list v.links?keys as k>
                                <#if k??>
                                    ${k}
                                </#if>
                            </#list>
                        </#if>
                    </td>
                </tr>
                </tbody>
            </#list>
        </table>
    <#else>Сезон не загружен.
    </#if>
    <@f.footer/>
</div>
</body>
</html>