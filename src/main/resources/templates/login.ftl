<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login to Family Guy</title>
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
            <form action="/login" method="post">
                <fieldset class="uk-fieldset">
                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Логин..." name="username">
                    </div>
                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Пароль..." name="password">
                    </div>
                    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                        <button class="uk-button uk-button-default btn-standard-without-increasing-size" type="submit">Войти</button>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <hr>
                    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                        <p>Регистрация пока не реализована.</p>
                        <p><a class="uk-link-text" href="/">Вернуться на главную</a></p>
                    </div>
                </fieldset>
            </form>
        </div>
</body>
</html>