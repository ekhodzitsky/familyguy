<#macro seasons_grid>
    <!-- Seasons/S -->
    <div class="uk-grid-small" uk-grid>
    <!-- Card element/S -->
    <#if seasons??>
        <#list seasons as s>
            <div class="uk-width-1-3">
            <div class="uk-animation-toggle">
            <div class="uk-card uk-card-default uk-text-bold uk-text-center uk-animation-shake"
            style="background-color: #ffd152; border-color: black"><a class="uk-link-text" href="/season/${s}"
        style="color: black">${s} сезон</a>
            </div>
            </div>
            </div>
        </#list>
    </#if>
    <!-- Card element/S -->
    </div>
    <!-- Seasons/E -->
</#macro>