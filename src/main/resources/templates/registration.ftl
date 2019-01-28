<!DOCTYPE html>
<html lang="en">
<head>
    <title>Family guy | Регистрация</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/css/uikit.min.css"/>
    <link rel="stylesheet" href="/static/css/common.css">
    <link href="https://fonts.googleapis.com/css?family=Neucha|Open+Sans" rel="stylesheet">
    <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/static/favicon.ico" type="image/x-icon">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit-icons.min.js"></script>
</head>
<body>
<div class="uk-position-center">
    <h1 class="uk-text-center"
        style="text-shadow: 1px 1px 6px black; color: #0099cc; font-family: 'Family Guy', cursive">Family
        Guy</h1>
    <form action="/register" method="post">
        <fieldset class="uk-fieldset">
            <div class="uk-margin">
                <input class="uk-input uk-form-small <#if cr_fail_username??>${cr_fail_username}</#if>" type="text"
                       placeholder="Придумайте логин..." name="username">
            </div>
            <div class="uk-margin">
                <input class="uk-input uk-form-small <#if cr_fail_password??>${cr_fail_password}</#if>" type="text"
                       placeholder="Пароль (минимум 6 символов)" name="password">
            </div>
            <div class="uk-margin">
                <input class="uk-input uk-form-small <#if cr_fail_confirm??>${cr_fail_confirm}</#if>" type="text"
                       placeholder="Повторите пароль..." name="password_confirm">
            </div>
            <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                <button class="uk-button uk-button-default btn-standard-without-increasing-size" type="submit">
                    Зарегистрироваться
                </button>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <#if cr_success??>
                <div class="uk-alert-success" uk-alert>
                    <a class="uk-alert-close" uk-close></a>
                    <p>${cr_success}</p>
                </div>
            </#if>
            <#if cr_fail_message??>
                <div class="uk-alert-danger" uk-alert>
                    <a class="uk-alert-close" uk-close></a>
                    <p>${cr_fail_message}</p>
                </div>
            </#if>
            <hr>
            <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                <p>Уже есть аккаунт?<a href="/login" style="font-weight: bold"> Войти</a></p>
                <p><a class="uk-link-text" href="/">Вернуться на главную</a></p>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>