<#macro episodes_list>
    <#if episodes??>
        <ul class="uk-list">
        <h4 class="uk-margin-large-top uk-text-center" style="font-family: 'Neucha', cursive">${number_of_season} сезон</h4>
        <#list episodes as e>
            <li>
            <div class="uk-animation-toggle">
            <div class="uk-card uk-card-default uk-text-bold uk-text-center uk-animation-shake"
            style="background-color: #ffd152; border-color: black"><a class="uk-link-text" href="/season/${e.season}/episode/${e.episode}"
        style="color: black">${e.episode} серия</a>
            </div>
            </div>
            </li>
        </#list>
        </ul>
    </#if>
</#macro>