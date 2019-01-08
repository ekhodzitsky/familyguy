<#import "../common/admin_navigation.ftl" as a>
<#import "../common/admin_head.ftl" as h>
<#import "../../blocks/common/footer.ftl" as f>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины | Список нарезок</title>
    <@h.adm_head/>
</head>
<body>
<@a.adm_nav/>
<div class="uk-container uk-container-expand">
    <#if moments??>
        <table class="uk-table uk-table-divider">
            <thead>
            <tr>
                <th><b>Id</b></th>
                <th><b>Название</b></th>
                <th><b>Iframe</b></th>
            </tr>
            </thead>
            <tbody>
            <#list moments as m>
                <tr>
                    <td>${m.id}</td>
                    <td>${m.title}</td>
                    <td>${m.link}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
    <#if message??>
        <div class="uk-alert-primary" uk-alert>
            <a class="uk-alert-close" uk-close></a>
            <h3>Результат:</h3>
            <p>${message}</p>
        </div>
    </#if>
    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
        <p><a class="uk-link-text" href="/"> <b>Вернуться на главную</b></a></p>
    </div>
    <@f.footer/>
</div>
</body>
</html>