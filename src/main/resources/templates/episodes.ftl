<#macro episodes_list>
    <!-- Список эпизодов -->
    <#if episodes??>
        <ul class="uk-list">
            <h2 class=" uk-text-center" style="font-family: 'Neucha', cursive"><b>${episodes[0].season} сезон</b></h2>
        <#list episodes as e>
            <li>
            <div class="uk-card uk-card-default uk-text-bold uk-text-center bt-custom-shape">
                <a class="for-a-special" href="/season/${e.season}/episode/${e.episode}">${e.episode} серия</a>
            </div>
            </li>
        </#list>
        </ul>
    </#if>
    <!-- /Список эпизодов -->
</#macro>