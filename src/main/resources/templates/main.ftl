<#import "common.ftl" as c>
<@c.common>

    <#--<#if seasons??>-->
        <#--<!-- Seasons &ndash;&gt;-->
        <#--<div class="uk-grid-small uk-child-width-1-3 uk-text-center" uk-grid>-->
        <#--<#list seasons as s>-->
            <#--<div>-->
            <#--<div class="uk-card uk-card-default uk-card-body"><a href="/season/${s}">${s} сезон</a></div>-->
            <#--</div>-->
        <#--</#list>-->
        <#--</div>-->
    <#--<#else>-->
        <#--<div>-->
            <#--<!-- Comment &ndash;&gt;-->
            <#--<p>Пока не добавлено ни одного сезона или даже серии.</p>-->
        <#--</div>-->
    <#--</#if>-->

    <div class="uk-grid-small" uk-grid>
        <div class="uk-width-expand"></div>
        <div class="uk-width-auto">
            <div uk-form-custom="target: > * > span:last-child">
                <select>
                    <option value="1">17 сезон</option>
                    <option value="2">16 сезон</option>
                </select>
                <span class="uk-link">
                <span uk-icon="icon: more-vertical"></span>
                <span></span>
            </span>
            </div>
        </div>
        <div class="uk-width-auto">
            <div uk-form-custom="target: > * > span:last-child">
                <select>
                    <option value="1">1 серия</option>
                    <option value="2">2 серия</option>
                </select>
                <span class="uk-link">
                <span uk-icon="icon: more-vertical"></span>
                <span></span>
            </span>
            </div>
        </div>
        <div class="uk-width-auto">
            <a href="" class="uk-icon-button" uk-icon="play"></a>
        </div>
        <div class="uk-width-expand"></div>
    </div>

    <div class="uk-grid-small uk-height-large" uk-grid>
        <div class="uk-width-1-4"></div>
        <div class="uk-width-expand">
            <iframe width="100%" height="100%" src="//video.sibnet.ru/shell.php?videoid=3500263" frameborder="0" scrolling="no" allowfullscreen></iframe>
        </div>
        <div class="uk-width-1-4"></div>
    </div>



</@c.common>