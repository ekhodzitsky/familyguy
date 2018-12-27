<#import "blocks/admin/add.ftl" as a>
<#import "blocks/admin/list.ftl" as l>
<#import "blocks/admin/user_edit.ftl" as u>
<#import "blocks/admin/video_remove_by_id.ftl" as i>
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
        <li><a href="#">Добавить видео</a></li>
        <li><a href="#">Удалить видео по ID</a></li>
        <li><a href="#">Редактировать юзера</a></li>
        <li><a href="#">Список видео</a></li>
    </ul>

    <ul class="uk-switcher uk-margin">
        <li><@a.add_video/></li>
        <li><@i.remove_video_by_id/></li>
        <li><@u.edit_user/></li>
        <li><@l.put_list/></li>
    </ul>
    <#if message??>
        <div uk-alert>
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