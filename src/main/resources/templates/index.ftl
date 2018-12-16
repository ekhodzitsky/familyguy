<#import "navigation.ftl" as n>
<#import "footer.ftl" as f>
<#import "seasons.ftl" as s>
<#import "episodes.ftl" as e>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><#if title??>
            ${title}
        <#else>Family Guy Гриффины Все сезоны Смотреть онлайн
        </#if></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Ситком «Гриффины» (англ. Family Guy, дословно «Семьянин») -
                        смотреть онлайн все сезоны в хорошем качестве.">
    <meta property="og:title"
          content="<#if title??>            ${title}
<#else>Family Guy Гриффины Все сезоны Смотреть онлайн
        </#if>">
    <meta property="og:description" content="Ситком «Гриффины» (англ. Family Guy, дословно «Семьянин») -
                        смотреть онлайн все сезоны в хорошем качестве.">
    <meta http-equiv="content-language" content="ru">
    <meta name="keywords"
          content="Семьянин, Гриффины, Смотреть, онлайн, все, сезоны, Стьюи, Брайан, Лоис, Питер, Мег, Гриффин, Family, guy, familyguy, ситком">
    <meta name="google-site-verification" content="pk2omgmjxh2oSmRl99gaqWPSYU_iDu6Si7KefDgB-u8"/>
    <meta name="yandex-verification" content="f6b1aa54f6c3cf38"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/css/uikit.min.css"/>
    <link rel="stylesheet" href="/static/css/fg-font.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit-icons.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Neucha" rel="stylesheet">
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
<div class="uk-container-expand">
    <@n.navigation/>
    <#if video??>
        <div uk-grid>
        <div class="uk-width-expand uk-margin-medium-top uk-text-center">
        <h2 style="font-family: 'Neucha', cursive">Смотреть онлайн <strong>${video.season}
        <sup>сезон</sup> ${video.episode}
        <sup>серия</sup></strong> :</h2>
        </div>
        </div>
    </#if>
    <#if video??>
        <!-- Grid -->
        <div uk-grid>
        <div class="uk-width-1-4">
        <div uk-grid>
        <div class="uk-width-1-3"></div>
        <div class="uk-width-2-3">
        <div class="uk-section uk-section-muted">
        <div class="uk-container">
        <@e.episodes_list/>
        </div>
        </div>
        </div>
        </div>
        </div>
    <!-- Grid -->

    <!-- Main column -->
        <div class="uk-width-expand">
    <!-- Video -->
        <div class="uk-margin-remove-left" uk-grid>
        <div class="uk-width-1-1 uk-height-large"
             style="min-height: 360px; box-shadow: 10px 10px 5px grey; background-color: black">
        ${video.link}
        </div>
        </div>
    <div class="uk-margin-remove-left" uk-grid>
        <div class="uk-text-center uk-align-center">
            <h5 style="font-family: 'Neucha', cursive"><b>Понравился сайт? Расскажи о нём в социальных сетях :</b></h5>
            <!-- social -->
            <script src="//yastatic.net/es5-shims/0.0.2/es5-shims.min.js"></script>
            <script src="//yastatic.net/share2/share.js"></script>
            <div class="ya-share2" data-services="vkontakte,facebook,odnoklassniki,whatsapp,telegram"></div>
            <!-- /social -->
        </div>


    </div>

    <!-- Description/S -->
    <div uk-grid>
        <article class="uk-article">
            <p class="uk-article-meta uk-text-justify">«Гриффины» (англ. Family Guy, дословно «Семьянин») -
                это мультсериал о типичной неблагополучной американской семье,
                главная особенность которого - жесткая сатира, не признающая рамок,
                тонкость и неординарность юмора. Шутки на различные щепетильные и
                спорные темы (такие как наркомания, феминизм, ожирение и другие),
                приправленные обилием сексуальных сцен,
                крови и мата никого не оставят равнодушным.</p>
        </article>
    </div>
    <!-- Description/E -->
        </div>
    <!-- Grid -->
        <div class="uk-width-1-4">
        <div uk-grid>
        <div class="uk-width-2-3">
        <div class="uk-section uk-section-muted">
        <div class="uk-container">
        <@s.seasons_list/>
        </div>
        </div>
        </div>
        <div class="uk-width-1-3">
        </div>
        </div>
        </div>
        <!-- Grid -->
        </div>
    <#else>
        <div uk-grid>
            <h3 style="font-family: 'Neucha', cursive">Возникла непредвиденная ошибка. Контент не загружен.</h3>
        </div>
    </#if>
</div>
<!-- Basic/E -->
<@f.footer/>
</body>
</html>