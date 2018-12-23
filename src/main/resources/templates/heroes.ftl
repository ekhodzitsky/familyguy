<#import "navigation.ftl" as n>
<#import "footer.ftl" as f>
<#import "heroes/peter.ftl" as p>
<#import "heroes/lois.ftl" as l>
<#import "heroes/brian.ftl" as b>
<#import "heroes/stewie.ftl" as s>
<#import "heroes/chris.ftl" as c>
<#import "heroes/meg.ftl" as m>
<#import "heroes/quagmire.ftl" as q>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Персонажи сериала Гриффины | Family guy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Персонажи ситкома «Гриффины», описание.">
    <meta property="og:title" content="Персонажи сериала Гриффины | Family guy">
    <meta property="og:description" content="Персонажи ситкома «Гриффины», описание.">
    <meta http-equiv="content-language" content="ru">
    <meta name="keywords"
          content="Гриффин, Смотреть, онлайн, все, сезон, Стьюи, Брайан, Лоис, Питер, Мег, Гриффин, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, серия">
    <meta name="google-site-verification" content="pk2omgmjxh2oSmRl99gaqWPSYU_iDu6Si7KefDgB-u8"/>
    <meta name="yandex-verification" content="f6b1aa54f6c3cf38"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/css/uikit.min.css"/>
    <link rel="stylesheet" href="/static/css/fg-font.css">
    <link rel="stylesheet" href="/static/css/bt-custom.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit-icons.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Neucha" rel="stylesheet">
    <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/static/favicon.ico" type="image/x-icon">
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript">
        (function (m, e, t, r, i, k, a) {
            m[i] = m[i] || function () {
                (m[i].a = m[i].a || []).push(arguments)
            };
            m[i].l = 1 * new Date();
            k = e.createElement(t), a = e.getElementsByTagName(t)[0], k.async = 1, k.src = r, a.parentNode.insertBefore(k, a)
        })
        (window, document, "script", "https://mc.yandex.ru/metrika/tag.js", "ym");

        ym(51561824, "init", {
            id: 51561824,
            clickmap: true,
            trackLinks: true,
            accurateTrackBounce: true
        });
    </script>
    <noscript>
        <div><img src="https://mc.yandex.ru/watch/51561824" style="position:absolute; left:-9999px;" alt=""/></div>
    </noscript>
    <!-- /Yandex.Metrika counter -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js"></script>
</head>
<body>
<div class="uk-container uk-container-expand">
    <@n.navigation/>
    <ul uk-tab style="font-family: Neucha, cursive">
        <li><a href="#" style="font-size: 120%; font-weight: bold">Питер</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Лоис</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Брайан</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Стьюи</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Крис</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Мег</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Гленн Куагмаер</a></li>
    </ul>
    <ul class="uk-switcher uk-margin">
        <li>
           <@p.peter/>
        </li>
        <li>
            <@l.lois/>
        </li>
        <li>
            <@b.brian/>
        </li>
        <li>
            <@s.stewie/>
        </li>
        <li>
            <@c.chris/>
        </li>
        <li>
            <@m.meg/>
        </li>
        <li>
            <@q.quagmire/>
        </li>
    </ul>
    <@f.footer/>
</div>
</body>
</html>