<#import "blocks/common/head.ftl" as h>
<#import "blocks/common/names_desc_translations.ftl" as nd>
<#import "blocks/common/navigation.ftl" as n>
<#import "blocks/common/footer.ftl" as f>
<#import "blocks/common/serial_description.ftl" as a>
<#import "blocks/common/episodes_and_seasons.ftl" as es>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>«Гриффины» смотреть онлайн лучшие моменты<#if moment??>: ${moment.title}</#if></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta property="og:title" content="«Гриффины» смотреть онлайн лучшие моменты<#if moment??>: ${moment.title}</#if>">
    <meta name="description" content="Нарезка смешных моментов из сериала Гриффины. <#if moment??>${moment.title}</#if>">
    <meta property="og:description" content="Нарезка смешных моментов из сериала Гриффины. <#if moment??>${moment.title}</#if>">
    <meta http-equiv="content-language" content="ru">
    <meta name="keywords" content="гриффины, смотреть, онлайн, нарезка, лучшее">
    <@h.put_head/>
</head>
<body>
<@n.navigation/>
<div class="uk-container uk-container-expand" uk-height-viewport="expand: true">
    <#if moment??>
        <div class="uk-container-large" uk-grid>
            <div class="uk-width-1-4">
                <#if moments??>
                    <#assign x = 1>
                    <div class="uk-flex-center">
                        <h3 class="uk-text-center">Еще нарезки: </h3>
                        <ul class="uk-list">
                        <#list moments as m>
                            <li>
                            <form action="/moments/${m.id}" method="get">
                                <button class="uk-button uk-button-default uk-button-small btn-standard uk-width-1-1 uk-text-center">Лучшее #${x}
                                </button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                            </li>
                            <#assign x++>
                        </#list>
                        </ul>
                    </div>
                </#if>
            </div>
            <div class="uk-width-expand">
                <div class="uk-width-expand uk-text-center">
                    <h2>Смотреть онлайн Гриффины</h2>
                    <h3><#if moment.title??>${moment.title}</#if></h3>
                </div>
                <div class="uk-height-large uk-flex-center" uk-grid>
                    <#if moment??>${moment.link}<#else>Ссылка на нарезку куда-то пропала... Хм...</#if>
                </div>
                <@a.put_article/>
            </div>
        </div>
    <#else>Контента пока нет.
    </#if>
    <div class="uk-text-center uk-flex-center" uk-grid>
        <h4>Поделиться в социальных сетях: </h4>
        <script src="//yastatic.net/es5-shims/0.0.2/es5-shims.min.js"></script>
        <script src="//yastatic.net/share2/share.js"></script>
        <div class="ya-share2"
             data-services="vkontakte,facebook,odnoklassniki,whatsapp,telegram">
        </div>
    </div>
    <@f.footer/>
</div>
</body>
</html>