<#import "navigation.ftl" as n>
<#import "footer.ftl" as f>
<#import "seasons.ftl" as s>
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
    <link href="https://fonts.googleapis.com/css?family=Neucha" rel="stylesheet">
    <meta name="google-site-verification" content="pk2omgmjxh2oSmRl99gaqWPSYU_iDu6Si7KefDgB-u8" />
</head>
<body>
<div class="uk-container-expand">

    <@n.navigation/>

    <!-- Basic/S -->
    <!-- Top image -->
<img src="/static/images/grif-top-1.png" alt="Griffins Intro">

<!-- Grid -->
    <div uk-grid>
        <div class="uk-width-1-6"></div>
        <div class="uk-width-1-6">
        </div>

        <!-- Main column -->
        <div class="uk-width-expand uk-margin-medium-top">
            <#if fresh??>
                <div uk-grid>
                <h2 style="font-family: 'Neucha', cursive">Смотреть онлайн <strong>${last_season}
                <sup>сезон</sup> ${last_episode}
                <sup>серия</sup></strong> (свежак!):</h2>
                </div>
                <div class="uk-margin-remove-left" uk-grid>
                <div class="uk-width-1-1"
                style="min-height: 360px; box-shadow: 10px 10px 5px grey; background-color: black">
                ${fresh}
                </div>
                </div>
            <#else>
                <div uk-grid>
                    <h3 style="font-family: 'Neucha', cursive">К сожалению, контента нет: он пропал или не
                        загружен.</h3>
                </div>
            </#if>


            <div uk-grid>
                <h2 class="uk-text-center" style="font-family: 'Neucha', cursive">Сезоны</h2>
            </div>
            <@s.seasons_grid/>

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
        <div class="uk-width-1-6">
        </div>
        <div class="uk-width-1-6"></div>
    </div>
    <!-- Basic/E -->
    <@f.footer/>
</div>
</body>
</html>