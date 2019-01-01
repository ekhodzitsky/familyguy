<#import "blocks/common/head.ftl" as h>
<#import "blocks/common/names_desc_translations.ftl" as nd>
<#import "blocks/common/navigation.ftl" as n>
<#import "blocks/common/footer.ftl" as f>
<#import "blocks/common/article.ftl" as a>
<#import "blocks/common/episodes_and_seasons.ftl" as es>
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
<@n.navigation/>
<div class="uk-container uk-container-expand" uk-height-viewport="expand: true">
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
                    <@nd.put_names_and_desc_and_translations/>
                </div>

                <div class="uk-width-1-1 uk-height-large uk-margin-remove-left" uk-grid
                     style="min-height: auto; box-shadow: 8px 8px 4px darkgrey; background-color: black">
                    <#if translation??>
                        ${translation}
                        <#else>${video.link}
                    </#if>
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
    <#else>Контента пока нет.
    </#if>
</div>
<@f.footer/>
</body>
</html>