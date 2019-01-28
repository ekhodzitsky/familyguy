<#import "../common/admin_navigation.ftl" as a>
<#import "../common/admin_head.ftl" as h>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины | Детали видео</title>
    <@h.adm_head/>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.22/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
</head>
<body>
<@a.adm_nav/>
<div class="uk-container uk-container-expand">
    <div id="app"></div>
    <script>

        Vue.component('video-row', {
            props: ['video'],
            template: '<tr>' +
                '<th>{{ video.id }}</th>' +
                '<th>{{ video.episode }}</th>' +
                '<th>{{ video.season }}</th>' +
                '<th>{{ video.rusName }}</th>' +
                '<th>{{ video.engName }}</th>' +
                '<th>{{ video.description }}</th>' +
                '<th><div v-for="key in Object.keys(video.links)">{{ key }}</div></th>' +
                '</tr>'
        });

        Vue.component('videos-list', {
            props: ['videos'],
            template: '<table class="uk-table uk-table-divider">\n' +
                '<caption>Список видео</caption>\n' +
                '    <thead>\n' +
                '        <tr>\n' +
                '            <th>ID</th>\n' +
                '            <th>EPISODE</th>\n' +
                '            <th>SEASON</th>\n' +
                '            <th>NAME (RUS)</th>\n' +
                '            <th>NAME (ENG)</th>\n' +
                '            <th>DESCRIPTION</th>\n' +
                '            <th>TRANSLATIONS</th>\n' +
                '        </tr>\n' +
                '    </thead>\n' +
                '    <tbody>' +
                '<video-row v-for="video in videos" :key="video.id" :video="video" />' +
                '</tbody>\n' +
                '</table>',
            created: function () {
                this.$http.get('/adminRest/getVideos')
                    .then(response => {
                        response.json().then(data => data.forEach(video => this.videos.push(video)))
                    })
            }
        });

        new Vue({
            el: '#app',
            template: '<videos-list :videos="videos" />',
            data: {
                videos: []
            }
        })
    </script>
</div>
</body>
</html>