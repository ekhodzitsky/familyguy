<#import "blocks/common/head.ftl" as h>
<#import "blocks/common/navigation.ftl" as n>
<#import "blocks/common/footer.ftl" as f>
<#import "blocks/common/article.ftl" as a>
<#import "blocks/episodes_and_seasons.ftl" as es>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><#if title??>
            ${title}
        <#else>Гриффины Все сезоны Смотреть онлайн
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
          content="Гриффины, Смотреть, онлайн, все, серия, сезон,
          1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
          Стьюи, Брайан, Лоис, Питер, Мег, Гриффин, Family, guy, familyguy, ситком">
    <@h.put_head/>
</head>
<body>
<div class="uk-container uk-container-expand" uk-height-viewport="expand: true">
    <@n.navigation/>
    <#if video??>
        <div class="uk-container-large" uk-grid>
            <div class="uk-width-1-4">
                        <@es.put_episodes_and_seasons/>
            </div>
            <div class="uk-width-expand">

                <div class="uk-width-expand uk-text-center">
                    <h1>Смотреть онлайн Гриффины <strong>${video.season}
                            <sup>сезон</sup> ${video.episode}
                            <sup>серия</sup></strong> :</h1>
                </div>
                <div class="uk-margin-remove-left" uk-grid>
                    <div class="uk-width-1-1 uk-height-large"
                         style="min-height: 360px; box-shadow: 10px 10px 5px grey; background-color: black">
                        ${video.link}
                    </div>
                </div>
                <@a.put_article/>
                <hr>
                    <div class="uk-text-center">
                        <h4>Понравился сайт? Расскажи о нём в социальных сетях: </h4>
                        <!-- social -->
                        <script src="//yastatic.net/es5-shims/0.0.2/es5-shims.min.js"></script>
                        <script src="//yastatic.net/share2/share.js"></script>
                        <div class="ya-share2"
                             data-services="vkontakte,facebook,odnoklassniki,whatsapp,telegram">
                        </div>
                        <!-- /social -->
                    </div>
            </div>
        </div>
    </#if>
</div>
<@f.footer/>
</body>
</html>