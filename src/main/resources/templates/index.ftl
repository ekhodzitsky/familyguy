<#import "navigation.ftl" as n>
<#import "footer.ftl" as f>
<#import "seasons.ftl" as s>
<#import "episodes.ftl" as e>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Family Guy Гриффины Все сезоны Смотреть онлайн</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/css/uikit.min.css"/>
    <link rel="stylesheet" href="/static/css/fg-font.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.25/js/uikit-icons.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Neucha" rel="stylesheet">
    <meta http-equiv="content-language" content="ru">
    <meta name="keywords"
          content="Семьянин, Гриффины, Смотреть, онлайн, все, сезоны, Стьюи, Брайан, Лоис, Питер, Мег, Гриффин, Family, guy, familyguy, ситком">
    <meta name="description" content="«Гриффины» (англ. Family Guy, дословно «Семьянин») -
                        это мультсериал о типичной неблагополучной американской семье,
                        главная особенность которого - жесткая сатира, не признающая рамок,
                        тонкость и неординарность юмора.">
    <meta name="google-site-verification" content="pk2omgmjxh2oSmRl99gaqWPSYU_iDu6Si7KefDgB-u8"/>
    <meta name="yandex-verification" content="f6b1aa54f6c3cf38"/>
</head>
<body>
<div class="uk-container-expand">
    <@n.navigation/>
        <!-- Basic/S -->
    <#if video??>
        <!-- Grid -->
        <div uk-grid>
        <div class="uk-width-1-4">
        <div uk-grid>
        <div class="uk-width-1-3"></div>
        <div class="uk-width-2-3">
        <@e.episodes_list/>
        </div>
        </div>
        </div>
    <!-- Grid -->

    <!-- Main column -->
        <div class="uk-width-expand uk-margin-medium-top">
    <!-- Video -->
        <div uk-grid>
        <h2 style="font-family: 'Neucha', cursive">Смотреть онлайн <strong>${video.season}
        <sup>сезон</sup> ${video.episode}
    <sup>серия</sup></strong> :</h2>
        </div>
        <div class="uk-margin-remove-left" uk-grid>
        <div class="uk-width-1-1" uk-height-viewport="expand: true"
             style="min-height: 360px; box-shadow: 10px 10px 5px grey; background-color: black">
        ${video.link}
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
        <@s.seasons_list/>
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
</div>
</body>
</html>