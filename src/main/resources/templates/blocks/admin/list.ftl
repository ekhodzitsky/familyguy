<#import "../common/admin_navigation.ftl" as a>
<#import "../common/admin_head.ftl" as h>
<#import "../../blocks/common/footer.ftl" as f>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины | Редактировать сезон</title>
    <@h.adm_head/>
    <!-- Vue для разработки -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
</head>
<body>
<@a.adm_nav/>
<div class="uk-container uk-container-expand">

    <#if season??>

        <table class="uk-table" id="app">
            <thead>
            <tr>
                <th>Id</th>
                <th>Серия</th>
                <th>Сезон</th>
                <th>Название (RUS)</th>
                <th>Название (ENG)</th>
                <th>Описание</th>
                <th>Переводы</th>
            </tr>
            </thead>
            <#list season as v>
                <tbody>
                <tr>
                    <td>${v.id}</td>
                    <td>${v.episode}</td>
                    <td>${v.season}</td>
                    <td><#if v.rusName??>${v.rusName}</#if></td>
                    <td><#if v.engName??>${v.engName}</#if></td>
                    <td><#if v.description??>${v.description}</#if></td>
                    <td><#if v.links??>
                            <#list v.links?keys as k>
                                <#if k??>
                                    ${k}
                                </#if>
                            </#list>
                        </#if></td>
                </tr>
                </tbody>
            </#list>
        </table>
    <#else>Сезон не загружен.
    </#if>

    <#--<ul class="uk-list" id="app">-->
    <#--<li v-for="season in seasons" :key="season.id">-->
    <#--<a class="uk-button uk-button-default uk-button-small btn-standard-without-increasing-size" :href="'/admin/list/' + season">{{ season }}</a>-->
    <#--</li>-->
    <#--</ul>-->
    <#--<script>-->
    <#--var seasonsAvailable = Vue.resource('/admin/seasons');-->
    <#--var app = new Vue({-->
    <#--el: '#app',-->
    <#--data: {-->
    <#--seasons: []-->
    <#--},-->
    <#--created: function(){-->
    <#--seasonsAvailable.get().then(result => result.json().then(data => data.forEach(season => this.seasons.push(season))))-->
    <#--}-->
    <#--});-->
    <#--</script>-->
    <@f.footer/>
</div>
</body>
</html>