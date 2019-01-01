<#-- Это кнопки выбора серий и сезонов. -->
<#macro put_episodes_and_seasons>

<#-- Сами кнопки. -->
    <ul class="uk-flex-center" uk-tab>
        <#-- Кнопка выбора серий сезона. -->
        <#if episodes??>
            <li>
                <a href="#" style="font-size: 120%; font-weight: bold">${episodes[0].season} сезон</a>
            </li>
        <#else><p>Нет серий</p>
        </#if>
        <#-- /Кнопка выбора серий сезона. -->
        <#-- Кнопка переключения сезонов. -->
        <#if seasons??>
            <li>
                <a href="#" style="font-size: 120%; font-weight: bold">Сезоны</a>
            </li>
        <#else><p>Нет сезонов</p>
        </#if>
        <#-- /Кнопка переключения сезонов. -->
    </ul>
<#-- /Сами кнопки. -->

<#-- То что кнопки переключают. -->
    <#if episodes?? && seasons??>
        <ul class="uk-switcher uk-margin">
            <#-- Это ссылки на эпизоды -->
            <li>
                <ul class="uk-list">
                    <#list episodes as e>
                        <li>
                            <form action="/season/${e.season}/episode/${e.episode}" method="get">
                                <button class="uk-button uk-button-default uk-button-small btn-standard uk-width-1-1 uk-text-center">${e.episode}
                                    серия
                                </button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </li>
                    </#list>
                </ul>
            </li>
            <#-- /Это ссылки на эпизоды -->
            <#-- Это ссылки на сезоны -->
            <li>
                <ul class="uk-list">
                    <#list seasons as s>
                        <li>
                            <form action="/season/${s}" method="get">
                                <button class="uk-button uk-button-default uk-button-small btn-standard uk-width-1-1 uk-text-center">${s}
                                    сезон
                                </button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </li>
                    </#list>
                </ul>
            </li>
            <#-- /Это ссылки на сезоны -->
        </ul>
    </#if>
</#macro>