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
    <div uk-grid>
        <div class="uk-width-small@m" style="border: solid; border-color: darkgrey">

            <ul class="uk-nav uk-nav-default"
                uk-switcher="connect: #component-nav; animation: uk-animation-fade; toggle: > :not(.uk-nav-header)">
                <li><a href="#">Добавить</a></li>
                <li><a href="#">Удалить</a></li>
            </ul>

        </div>
        <div class="uk-width-expand@m">

            <ul id="component-nav" class="uk-switcher">
                <li>

                    <div class="uk-section uk-section-muted uk-padding">
                        <div class="uk-container">
                            <h1 class="uk-text-center"
                                style="font-family: 'Family Guy', cursive">Добавить видео</h1>
                            <form class="uk-form-horizontal uk-margin-small" action="/upload" method="post">
                                <div class="uk-margin-small">
                                    <label class="uk-form-label" for="form-horizontal-text"
                                           style="font-family: 'Neucha', cursive">Номер серии:</label>
                                    <div class="uk-form-controls">
                                        <input class="uk-input" id="form-horizontal-text" type="text"
                                               name="episode">
                                    </div>
                                </div>
                                <div class="uk-margin-small">
                                    <label class="uk-form-label" for="form-horizontal-text"
                                           style="font-family: 'Neucha', cursive">Номер сезона:</label>
                                    <div class="uk-form-controls">
                                        <input class="uk-input" id="form-horizontal-text" type="text" name="season">
                                    </div>
                                </div>
                                <div class="uk-margin-small">
                                    <label class="uk-form-label" for="form-horizontal-text"
                                           style="font-family: 'Neucha', cursive">Ссылка на iframe:</label>
                                    <div class="uk-form-controls">
                                        <input class="uk-input" id="form-horizontal-text" type="text" name="link">
                                    </div>
                                </div>
                                <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                                    <button class="uk-button uk-button-default">Добавить</button>
                                </div>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>

                </li>
                <li>

                    <div class="uk-section uk-section-muted uk-padding">
                        <div class="uk-container">
                            <h1 class="uk-text-center"
                                style="font-family: 'Family Guy', cursive">Удалить видео</h1>
                            <form class="uk-form-horizontal uk-margin-small" action="/delete" method="post">
                                <div class="uk-margin-small">
                                    <label class="uk-form-label" for="form-horizontal-text"
                                           style="font-family: 'Neucha', cursive">Номер серии:</label>
                                    <div class="uk-form-controls">
                                        <input class="uk-input" id="form-horizontal-text" type="text"
                                               name="episode">
                                    </div>
                                </div>
                                <div class="uk-margin-small">
                                    <label class="uk-form-label" for="form-horizontal-text"
                                           style="font-family: 'Neucha', cursive">Номер сезона:</label>
                                    <div class="uk-form-controls">
                                        <input class="uk-input" id="form-horizontal-text" type="text" name="season">
                                    </div>
                                </div>
                                <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                                    <button class="uk-button uk-button-default">Удалить</button>
                                </div>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
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
</div>
</body>
</html>