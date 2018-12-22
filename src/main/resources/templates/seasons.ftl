<#macro seasons_list>
    <!-- Список сезонов -->
    <#if seasons??>
        <ul class="uk-list">
        <h2 class="uk-text-center" style="font-family: 'Neucha', cursive"><b>Сезоны</b></h2>
        <#list seasons as s>
            <li>
            <div class="uk-card uk-card-default uk-text-bold uk-text-center bt-custom-shape">
                <a class="for-a-special" href="/season/${s}">${s} сезон</a>
            </div>
            </li>
        </#list>
        <ul class="uk-list">
    </#if>
    <!-- /Список сезонов -->
</#macro>