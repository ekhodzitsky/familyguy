<!DOCTYPE html>
<html lang="en">
<head>
    <title>Family Guy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/css/uikit.min.css"/>
    <link rel="stylesheet" href="/static/css/fg-font.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit-icons.min.js"></script>
</head>
<body>
<div class="uk-position-center">
    <!-- Heading -->
    <h1 class="uk-heading-line uk-text-center"><span style="font-family: 'Family Guy',serif">Family Guy</span></h1>
    <form action="/login" method="post">
        <div class="uk-margin">
            <input class="uk-input uk-form-default uk-form-width-medium" type="text" name="username" placeholder="username">
        </div>
        <div class="uk-margin">
            <input class="uk-input uk-form-default uk-form-width-medium" type="text" name="password" placeholder="password">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="uk-button uk-button-default" type="submit">Ok</button>
    </form>
    <!-- Footer -->
    <hr>
    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
        Регистрация пока не реализована.
    </div>
</div>
</body>
</html>