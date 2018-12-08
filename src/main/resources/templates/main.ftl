<#import "common.ftl" as c>
<@c.common>

    <#if seasons??>
        <!-- Seasons -->
        <div class="uk-grid-small uk-child-width-1-3 uk-text-center" uk-grid>
        <#list seasons as s>
            <div>
        <div class="uk-card uk-card-default uk-card-body"><a href="/season/${s}">${s} сезон</a></div>
            </div>
        </#list>
        </div>
    <#else>
        <div>
            <!-- Comment -->
            <p>Пока не добавлено ни одного сезона или даже серии.</p>
        </div>
    </#if>

</@c.common>