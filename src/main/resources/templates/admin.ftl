<#import "blocks/admin/video_actions/add_video.ftl" as a>
<#import "blocks/admin/video_actions/add_translation.ftl" as t>
<#import "blocks/admin/video_actions/add_names_desc.ftl" as nd>
<#import "blocks/admin/video_actions/video_list.ftl" as l>
<#import "blocks/admin/video_actions/remove_by_id.ftl" as i>

<#import "blocks/admin/user_actions/user_add.ftl" as ua>
<#import "blocks/admin/user_actions/user_edit.ftl" as ue>
<#import "blocks/admin/user_actions/user_edit_role.ftl" as ur>
<#import "blocks/admin/user_actions/user_remove_by_id.ftl" as ud>
<#import "blocks/admin/user_actions/user_list.ftl" as ul>

<#import "blocks/common/navigation.ftl" as n>
<#import "blocks/common/footer.ftl" as f>
<#import "blocks/common/article.ftl" as ar>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Family Guy | Гриффины | Admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/css/uikit.min.css"/>
    <link rel="stylesheet" href="/static/css/common.css">
    <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/static/favicon.ico" type="image/x-icon">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit-icons.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Neucha|Open+Sans" rel="stylesheet">
</head>
<body>
<div class="uk-container uk-container-small">
    <@n.navigation/>
    <ul uk-tab>
        <#-- Операции с видео -->
        <li><a href="#">Добавить видео</a></li>
        <li><a href="#">Добавить перевод</a></li>
        <li><a href="#">Название и описание</a></li>
        <li><a href="#">Удалить видео по ID</a></li>
        <li><a href="#">Список видео</a></li>
        <#-- Операции с юзером -->
        <li><a href="#">Добавить пользователя</a></li>
        <li><a href="#">Редактировать пользователя</a></li>
        <li><a href="#">Роль пользователя</a></li>
        <li><a href="#">Удалить пользователя</a></li>
        <li><a href="#">Список пользователей</a></li>
    </ul>

    <ul class="uk-switcher uk-margin">
        <#-- Операции с видео -->
        <li><@a.add_video/></li>
        <li><@t.add_translation/></li>
        <li><@nd.add_video_names_description/></li>
        <li><@i.remove_video_by_id/></li>
        <li><@l.put_list/></li>
        <#-- Операции с юзером -->
        <li><@ua.user_add/></li>
        <li><@ue.user_edit/></li>
        <li><@ur.user_edit_role/></li>
        <li><@ud.user_remove/></li>
        <li><@ul.put_user_list/></li>

    </ul>
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
    <@ar.put_article/>
    <@f.footer/>
</div>
</body>
</html>