<#macro seasons_list>
    <!-- Seasons/S -->
    <#if seasons??>
        <ul class="uk-list">
        <h2 class="uk-text-center" style="font-family: 'Neucha', cursive">Сезоны</h2>
        <#list seasons as s>
            <li>
            <div class="uk-animation-toggle">
            <div class="uk-card uk-card-default uk-text-bold uk-text-center uk-animation-shake"
            style="background-color: #ffd152; border-color: black"><a class="uk-link-text" href="/season/${s}"
        style="color: black">${s} сезон</a>
            </div>
            </div>
            </li>
        </#list>
        <ul class="uk-list">
    </#if>
<!-- Seasons/E -->
</#macro>