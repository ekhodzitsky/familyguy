<#import "../common/admin_navigation.ftl" as a>
<#import "../common/admin_head.ftl" as h>
<#import "../../blocks/common/footer.ftl" as f>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины | Детали видео</title>
    <@h.adm_head/>
</head>
<body>
<@a.adm_nav/>
<div class="uk-container uk-container-expand">
    <#if detailed??>
        <table class="uk-table">
            <caption>Заполняемые данные</caption>
            <thead>
            <tr>
                <th>Id</th>
                <th>Серия/Cезон</th>
                <th>Название (RUS)</th>
                <th>Название (ENG)</th>
                <th>Описание</th>
                <th>Переводы</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><b>id: </b>${detailed.id}<b></b></td>
                <td>${detailed.episode}/${detailed.season}</td>
                <td><#if detailed.rusName??>${detailed.rusName}<#else>-
                    </#if></td>
                <td><#if detailed.engName??>${detailed.engName}</#if></td>
                <td><#if detailed.description??>${detailed.description}</#if></td>
                <td><#if detailed.links??>
                        <#list detailed.links?keys as k>
                            <#if k??>
                                ${k}
                            </#if>
                        </#list>
                    </#if>
                </td>
            </tr>
            </tbody>
        </table>
        <#if detailed.links??>
            <hr>
            <table class="uk-table">
                <caption>Отображаемые видео</caption>
                <thead>
                <tr>
                    <#list detailed.links?keys as k>
                        <th>${k} |
                            <form action="/admin/video_remove_translation/${detailed.id}/${k}" method="post">
                                <button type="submit">Удалить</button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </th>
                    </#list>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <#list detailed.links?values as v>
                        <td>
                            ${v}
                        </td>
                    </#list>
                </tr>
                </tbody>
            </table>
            <hr>
        </#if>
    </#if>
    <#-- /Секция -->
    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
        <p><a class="uk-link-text" href="/"> <b>Вернуться на главную</b></a></p>
    </div>
    <@f.footer/>
</div>
</body>
</html>