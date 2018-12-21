<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login to Family Guy</title>
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
<div class="uk-position-center">
    <div class="uk-section uk-section-muted">
        <div class="uk-container">
            <h1 class="uk-text-center"
                style="text-shadow: 1px 1px 6px black; color: #0099cc; font-family: 'Family Guy', cursive">Family
                Guy</h1>
            <form class="uk-form-horizontal uk-margin-small" action="/login" method="post">
                <div class="uk-margin-small">
                    <label class="uk-form-label" for="form-horizontal-text" style="font-family: 'Neucha', cursive">Username:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-horizontal-text" type="text" name="username">
                    </div>
                </div>

                <div class="uk-margin-small">
                    <label class="uk-form-label" for="form-horizontal-text" style="font-family: 'Neucha', cursive">Password:</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-horizontal-text" type="text" name="password">
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="uk-text-right">
                    <button class="uk-button uk-button-default" type="submit">Ok</button>
                </div>
            </form>
            <hr>
            <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                <p style="font-family: 'Neucha', cursive"><b>Регистрация пока не реализована.</b></p>
                <p><a class="uk-link-text" style="font-family: 'Neucha', cursive" href="/"> Вернуться на главную</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>