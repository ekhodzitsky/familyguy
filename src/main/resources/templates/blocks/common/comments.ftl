<#macro put_comments video_comments>
    <#include "../../security.ftl">

    <form <#if user_id??>action="/add_comment" <#else>action="/login"</#if> class="uk-margin uk-flex">

        <div class="uk-width-1-6 uk-text-center">
            <h5>
                Добавить комментарий:
            </h5>
        </div>

        <div class="uk-width-4-6">
            <input class="uk-input" id="form-horizontal-text" type="text"
                   placeholder="Напиши что-нибудь здесь..." name="comment">
        </div>

        <div class="uk-width-1-6 uk-text-center">
            <button class="uk-button uk-button-default btn-standard-without-increasing-size" type="submit">Ок
            </button>
        </div>

        <div class="uk-text-center">
            <a href="#modal-center" class="uk-icon-button btn-icon-custom" uk-icon="warning" uk-toggle></a>
            <div id="modal-center" class="uk-flex-top" uk-modal>
                <div class="uk-modal-dialog uk-modal-body uk-margin-auto-vertical">

                    <button class="uk-modal-close-default" type="button" uk-close></button>
                    <h3>Желающим оставить комментарий:</h3>
                    <ul class="uk-list uk-list-bullet">
                        <li>Вы должны быть зарегистрированы</li>
                        <li>Можно оставить один комментарий под одним видео <b>раз в час</b></li>
                        <li>Максимальная длина комментария - 300 символов</li>
                        <li>Максимальная длина слова - 30 символов</li>
                        <li>Недопустимые символы: '/', '*', '_', '\\', '^', '<', '>', '@', '[', ']', '{', '}', '|'.</li>
                        <li>Запрещены: флуд, мат, оскорбления, разжигание межнациональной розни,
                            пропаганда фашизма и тд., т.е. все что нарушает законы Российской Федерации.
                            Подобные комментарии будут удаляться.
                        </li>
                    </ul>
                    <p>Пишите короткие и осмысленные комментарии.</p>
                </div>
            </div>
        </div>

        <#if user_id??>
            <input type="hidden" name="user_id" value="${user_id}"/>
        </#if>
        <input type="hidden" name="video_id" value="${video.id}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>


    </form>
    <#if video_comments??>
        <#assign i = video_comments?size>
        <#if i!=0>
            <div id="cmnts"></div>
            <script>

                Vue.component('comment-row', {
                    props: ['comment'],
                    template: '<tr>' +
                        '<th>{{comment.authorName}}</th>' +
                        '<th>{{comment.value}}</th>' +
                        '<#if isAdmin>' +
                        '<th><form v-bind:action="getUniqueLink">' +
                        '<button class="uk-icon-button btn-icon-custom" uk-icon="close" type="submit"></button></form></th>' +
                        '</#if>' +
                        '</tr>',
                    computed: {
                        getUniqueLink: function () {
                            return '/remove_comment/' + this.comment.id + '/${video.id}'
                        }
                    }
                });

                Vue.component('comments-list', {
                    props: ['comments'],
                    template: '<table class="uk-table uk-table-divider">\n' +
                        '<caption>Комментарии</caption>\n' +
                        '    <tbody>' +
                        '<comment-row v-for="comment in comments" :key="comment.id" :comment="comment" />' +
                        '</tbody>\n' +
                        '</table>',
                    created: function () {
                        this.$http.get('/adminRest/getVideoComments/${video.id}')
                            .then(response => {
                                response.json().then(data => data.forEach(comment => this.comments.push(comment)))
                            })
                    }
                });

                new Vue({
                    el: '#cmnts',
                    template: '<comments-list :comments="comments" />',
                    data: {
                        comments: []
                    }
                })
            </script>
        </#if>
    </#if>

</#macro>