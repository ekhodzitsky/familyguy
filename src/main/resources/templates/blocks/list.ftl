<#macro put_list>
     <div class="uk-section uk-section-muted">
    <div class="uk-container">
    <div uk-grid>
    <div class="uk-width-small@m" style="border: solid; border-color: darkgrey">
    <ul class="uk-nav uk-nav-default"
    uk-switcher="connect: #compnav; animation: uk-animation-fade; toggle: > :not(.uk-nav-header)">
    <#if seasons??>
        <#list seasons as s>
            <li><a href="#">${s} сезон</a></li>
        </#list>
    <#else>
        <li><a href="#">Сезоны</a></li>
    </#if>
    </ul>
    </div>
    <div class="uk-width-expand@m">
    <ul id="compnav" class="uk-switcher">
    <#if episodes??>
        ${episodes}
    <#else>Пока нет загруженных видео.
    </#if>
    </ul>
    </div>
    </div>
    </div>
    </div>
</#macro>