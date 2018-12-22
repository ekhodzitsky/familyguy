<#macro remove_video_by_id>
    <div class="uk-section uk-section-muted uk-padding">
        <div class="uk-container">
            <h3 class="uk-text-center"
                style="font-family: 'Roboto Condensed', sans-serif;">Удалить видео по <b>ID</b></h3>
            <form class="uk-form-horizontal uk-margin-small" action="/deleteById" method="post">
                <div class="uk-margin-small">
                    <label class="uk-form-label" for="form-horizontal-text"
                           style="font-family: 'Roboto Condensed', sans-serif;">ID видео</label>
                    <div class="uk-form-controls">
                        <input class="uk-input" id="form-horizontal-text" type="text"
                               name="id">
                    </div>
                </div>
                <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                    <button class="uk-button uk-button-danger">Ок</button>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</#macro>