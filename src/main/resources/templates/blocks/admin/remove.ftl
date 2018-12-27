<#macro remove_video>
    <div class="uk-section uk-section-muted uk-padding">
    <div class="uk-container">
    <h1 class="uk-text-center">Удалить видео</h1>
    <form class="uk-form-horizontal uk-margin-small" action="/delete" method="post">
    <div class="uk-margin-small">
        <label class="uk-form-label" for="form-horizontal-text">Номер серии:</label>
        <div class="uk-form-controls">
            <input class="uk-input" id="form-horizontal-text" type="text" name="episode">
        </div>
    </div>
    <div class="uk-margin-small">
        <label class="uk-form-label" for="form-horizontal-text">Номер сезона:</label>
        <div class="uk-form-controls">
            <input class="uk-input" id="form-horizontal-text" type="text" name="season">
        </div>
    </div>
    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
        <button class="uk-button uk-button-default">Удалить</button>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
    </div>
    </div>
</#macro>