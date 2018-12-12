<#import "navigation.ftl" as n>
<#import "footer.ftl" as f>
<#import "seasons.ftl" as s>
<#import "episodes.ftl" as e>
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
<@e.episodes_list/>
</div>

<!-- Main column -->
    <div class="uk-width-expand uk-margin-medium-top">
<#if first_episode_of_season??>
    <div uk-grid>
    <h2 style="font-family: 'Neucha', cursive">Смотреть онлайн <strong>${first_episode_of_season.season}
    <sup>сезон</sup> ${first_episode_of_season.episode}
    <sup>серия</sup></strong> :</h2>
    </div>
    <div class="uk-margin-remove-left" uk-grid>
    <div class="uk-width-1-1"
    style="min-height: 360px; box-shadow: 10px 10px 5px grey; background-color: black">
    ${first_episode_of_season.link}
    </div>
    </div>
<#else>
    <div uk-grid>
        <p>Контент не загрузился или не существует.</p>
    </div>
</#if>


    <div uk-grid>
        <h2>Сезоны</h2>
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

<#--<#import "common.ftl" as c>-->
<#--<@c.common>-->
<#--<#if episodes??>-->
<#--<div uk-grid>-->

<#--<div class="uk-width-1-4">-->
<#--<h4>${season} сезон</h4>-->
<#--<ul class="uk-list uk-list-striped">-->
<#--<#list episodes as e>-->
<#--<li><a class="uk-link-muted" href="/season/${season}/episode/${e}">${e} серия</a></li>-->
<#--</#list>-->
<#--</ul>-->
<#--</div>-->

<#--<div class="uk-width-3-4">-->
<#--<#if link??>-->
<#--<div uk-grid>-->
<#--<div class="uk-width-1-6"></div>-->
<#--<div class="uk-width-4-6 uk-height-large">-->
<#--${link}-->
<#--</div>-->
<#--<div class="uk-width-1-6"></div>-->
<#--</div>-->
<#--<#else> Такого видео не существует.-->
<#--</#if>-->
<#--</div>-->
<#--</div>-->
<#--<#else> Возникла ошибка.-->
<#--</#if>-->
<#--</@c.common>-->