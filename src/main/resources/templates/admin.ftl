<#import "blocks/add.ftl" as a>
<#import "blocks/remove.ftl" as r>
<#import "blocks/list.ftl" as l>
<#import "blocks/user_edit.ftl" as u>
<#import "blocks/video_remove_by_id.ftl" as i>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Family Guy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/css/uikit.min.css"/>
    <link rel="stylesheet" href="/static/css/fg-font.css">
    <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/static/favicon.ico" type="image/x-icon">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit-icons.min.js"></script>
</head>
<body>
<div class="uk-container uk-container-small">
    <div uk-grid>
        <div class="uk-width-small@m" style="border: solid; border-color: darkgrey">

            <ul class="uk-nav uk-nav-default"
                uk-switcher="connect: #component-nav; animation: uk-animation-fade; toggle: > :not(.uk-nav-header)">
                <li><a href="#">Добавить</a></li>
                <li><a href="#">Удалить</a></li>
                <li><a href="#">Удалить видео по ID</a></li>
                <li><a href="#">Редактировать пользователя</a></li>
            </ul>
        </div>
        <div class="uk-width-expand@m">
            <ul id="component-nav" class="uk-switcher">
                <li>
                    <@a.add_video/>
                </li>
                <li>
                    <@r.remove_video/>
                </li>
                <li>
                    <@i.remove_video_by_id/>
                </li>
                <li>
                    <@u.edit_user/>
                </li>
            </ul>
        </div>
    </div>
        <#if message??>
            <div uk-alert>
            <a class="uk-alert-close" uk-close></a>
            <h3 style="font-family: 'Neucha', cursive">Результат:</h3>
            <p style="font-family: 'Neucha', cursive">${message}</p>
            </div>
        </#if>
    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
        <p><a class="uk-link-text" style="font-family: 'Neucha', cursive" href="/"> Вернуться на главную</a></p>
    </div>
    <div uk-grid>
        <@l.put_list/>
    </div>
</div>
</body>
</html>