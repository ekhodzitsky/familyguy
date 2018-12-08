<#import "common.ftl" as c>
<@c.common>
    <#if episodes??>
        <div uk-grid>

        <div class="uk-width-1-4">
        <h4>${season} сезон</h4>
        <ul class="uk-list uk-list-striped">
        <#list episodes as e>
            <li><a class="uk-link-muted" href="/season/${season}/episode/${e}">${e} серия</a></li>
        </#list>
        </ul>
        </div>

        <div class="uk-width-3-4">
        <#if link??>
            <div uk-grid>
            <div class="uk-width-1-6"></div>
            <div class="uk-width-4-6 uk-height-large">
            ${link}
            </div>
            <div class="uk-width-1-6"></div>
            </div>
        <#else> Такого видео не существует.
        </#if>
        </div>
        </div>
    <#else> Возникла ошибка.
    </#if>
</@c.common>