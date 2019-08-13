<#import "blocks/common/head.ftl" as h>
<#import "blocks/common/names_desc_translations.ftl" as nd>
<#import "blocks/common/navigation.ftl" as n>
<#import "blocks/common/footer.ftl" as f>
<#import "blocks/common/serial_description.ftl" as a>
<#import "blocks/common/episodes_and_seasons.ftl" as es>
<#import "blocks/common/comments.ftl" as com>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><#if video??>«Гриффины» смотреть онлайн: ${video.season} сезон ${video.episode} серия<#if video.rusName??> «${video.rusName}»</#if><#else>«Гриффины» смотреть онлайн | Семьянин | Family guy | Все сезоны</#if></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta property="og:title"
          content="<#if video??>«Гриффины» смотреть онлайн: ${video.season} сезон ${video.episode} серия<#if video.rusName??> «${video.rusName}»</#if><#else>«Гриффины» смотреть онлайн | Семьянин | Family guy | Все сезоны</#if>">
    <meta name="description"
          content="<#if video??>«Гриффины» смотреть онлайн: ${video.season} сезон ${video.episode} серия<#if video.rusName??> «${video.rusName}»</#if>. <#if video.description??>${video.description}</#if><#else>Ситком «Гриффины» (англ. Family Guy, дословно «Семьянин») - смотреть онлайн все сезоны в хорошем качестве.</#if>">
    <meta property="og:description"
          content="<#if video??>«Гриффины» смотреть онлайн: ${video.season} сезон ${video.episode} серия<#if video.rusName??> «${video.rusName}»</#if>. <#if video.description??>${video.description}</#if><#else>Ситком «Гриффины» (англ. Family Guy, дословно «Семьянин») - смотреть онлайн все сезоны в хорошем качестве.</#if>">
    <meta http-equiv="content-language" content="ru">
    <meta name="keywords"
          content="гриффины, смотреть, онлайн, <#if video??>${video.episode}, cерия, ${video.season}, сезон</#if>">
    <@h.put_head/>

    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.22/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>

</head>
<body>
<@n.navigation/>
<div class="uk-container uk-container-expand">
    <#if video??>

        <div class="uk-container-large" uk-grid>
            <div class="uk-width-1-4">
                <@es.put_episodes_and_seasons/>
            </div>
            <div class="uk-width-expand">
                <div class="uk-width-expand uk-text-center">
                    <h2>Смотреть онлайн Гриффины ${video.season} <sup>сезон</sup> ${video.episode} <sup>серия</sup></h2>
                    <@nd.put_names_and_desc_and_translations/>
                </div>
                <div class="uk-height-large uk-flex-center" uk-grid>
                    <#if translation??>${translation}<#else>${video.link}</#if>
                </div>
                <@a.put_article/>
            </div>
        </div>

        <div class="uk-text-center uk-flex-center" uk-grid>
            <h4>Поделиться в социальных сетях: </h4>
            <script src="//yastatic.net/es5-shims/0.0.2/es5-shims.min.js"></script>
            <script src="//yastatic.net/share2/share.js"></script>
            <div class="ya-share2"
                 data-services="vkontakte,facebook,odnoklassniki,whatsapp,telegram">
            </div>
        </div>

    <#else>
        <div class="uk-section">
            <div class="uk-container uk-width-expand uk-text-center">
                <h3>Упс, ошибка!</h3>
                <p>Извините, но эта серия не найдена, не загружена или не существует.</p>
            </div>
        </div>
    </#if>

</div>
<@f.footer/>
</body>
</html>
