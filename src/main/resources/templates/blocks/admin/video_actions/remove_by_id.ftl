<#macro remove_video_by_id>
<#-- Секция -->
    <div class="uk-section uk-padding uk-width-1-2 uk-align-center">
        <div class="uk-container">
            <form action="/video_remove_by_id" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Удалить видео по id</legend>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Id видео..."
                               name="id">
                    </div>

                    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                        <button class="uk-button uk-button-default btn-standard-without-increasing-size" type="submit">Удалить</button>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </fieldset>
            </form>
        </div>
    </div>
<#-- /Секция -->
</#macro>