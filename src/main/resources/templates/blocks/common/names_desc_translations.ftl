<#-- Кладет название серии на русском и английском, если оно есть, а также описание. -->
<#-- Если есть ссылки на перевод, добавляет + выделяет текущий выбранный перевод. -->
<#macro put_names_and_desc_and_translations>
    <#if video.rusName?? && video.engName??>
        <dl class="uk-description-list uk-padding-small article">
            <div class="uk-clearfix">
                <#if video.links??>
                <#-- Если есть ссылки на перевод, добавит лэйблы справа. -->
                    <div class="uk-float-right">
                        <#-- Сами ссылки вот: -->
                        <#list video.links?keys as k>
                            <span class="uk-label <#if tr_active??><#if k == tr_active>btn-translation-active<#else>btn-translation</#if><#else>btn-translation</#if>">
                                <a style="color: black" href="/season/${video.season}/episode/${video.episode}/${k}">
                                ${k}
                                </a>
                            </span>
                        </#list>
                    </div>
                <#-- Если есть ссылки на перевод, добавит лэйблы справа. -->
                </#if>
                <div class="uk-float-left">
                    <dt><h2>${video.rusName} <span style="font-size: 62%"><cite>${video.engName}</cite></span></h2></dt>
                </div>
            </div>
            <#if video.description??>
                <dd class="uk-text-left">${video.description}</dd>
            </#if>
        </dl>
    <#else>
    <#-- Если нет названий серии, но есть перевод, положит только перевод (если нет то и его тоже не положит): -->
        <#if video.links??>
            <div class="uk-clearfix uk-margin-small-bottom">
                <div class="uk-float-right">
                    <#-- Сами ссылки вот: -->
                    <#list video.links?keys as k>
                        <span class="uk-label <#if tr_active??><#if k == tr_active>btn-translation-active<#else>btn-translation</#if><#else>btn-translation</#if>">
                                <a style="color: black" href="/season/${video.season}/episode/${video.episode}/${k}">
                                ${k}
                                </a>
                            </span>
                    </#list>
                </div>
            </div>
        </#if>
    </#if>
</#macro>
<#-- /Кладет название серии на русском и английском, если оно есть, а также описание. -->
<#-- /Если есть ссылки на перевод, добавляет + выделяет текущий выбранный перевод. -->
