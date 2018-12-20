<#macro seasons_list>
    <#if seasons??>
        <ul class="uk-list">
        <h2 class="uk-text-center" style="font-family: 'Neucha', cursive">Сезоны</h2>
        <#list seasons as s>
            <li>
            <div class="uk-animation-toggle">
            <div class="uk-card uk-card-default uk-text-bold uk-text-center uk-animation-shake bt-custom-shape">
                <a class="for-a-special" href="/season/${s}">${s} сезон</a>
            </div>
            </div>
            </li>
        </#list>
        <ul class="uk-list">
    </#if>
</#macro>