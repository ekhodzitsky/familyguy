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

    <@h.put_head/>

    <!-- VK comments -->
    <script type="text/javascript" src="https://vk.com/js/api/openapi.js?160"></script>

    <script type="text/javascript">
        VK.init({apiId: 6797858, onlyWidgets: true});
    </script>
    <!-- /VK comments -->

</head>
<body>
<div class="uk-container-expand" uk-height-viewport="expand: true">
    <@n.navigation/>
    <#if video??>
        <div uk-grid>
            <div class="uk-width-1-4">
                <div uk-grid>
                    <div class="uk-width-1-3"></div>
                    <div class="uk-width-2-3">
                        <@es.put_episodes_and_seasons/>
                    </div>
                </div>
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

                <div id="vk_comments"></div>
                <script type="text/javascript">
                    VK.Widgets.Comments("vk_comments", {limit: 20, attach: "*"});
                </script>

                <div class="uk-flex uk-flex-wrap">
                    <div class="uk-text-center uk-width-1-2">
                        <h5>Понравился сайт? Расскажи о нём в социальных сетях: </h5>
                        <!-- social -->
                        <script src="//yastatic.net/es5-shims/0.0.2/es5-shims.min.js"></script>
                        <script src="//yastatic.net/share2/share.js"></script>
                        <div class="ya-share2"
                             data-services="vkontakte,facebook,odnoklassniki,whatsapp,telegram">
                        </div>
                        <!-- /social -->
                    </div>
                    <div class="uk-text-center uk-width-1-2">
                        <h5>Наша группа Вконтакте :</h5>
                        <a href="https://vk.com/familyguy.space">
                            <img src="/static/images/vk-logo.png" width="32px" height="32px" alt="vk-logo">
                        </a>
                    </div>
                </div>

            </div>
            <div class="uk-width-1-4">
                <div uk-grid>
                    <div class="uk-width-2-3">
                    </div>
                    <div class="uk-width-1-3">
                    </div>
                </div>
            </div>
        </div>
    <#else>
        <div uk-grid>
            <h5>Возникла непредвиденная ошибка. Контент не загружен.</h5>
        </div>
    </#if>
</div>
<@f.footer/>
</body>
</html>