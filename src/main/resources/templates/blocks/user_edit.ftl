<#macro edit_user>
    <div class="uk-section uk-section-muted uk-padding">
    <div class="uk-container">
    <h1 class="uk-text-center"
        style="font-family: 'Family Guy', cursive">Редактировать пользователя</h1>
    <form class="uk-form-horizontal uk-margin-small" action="/admin" method="post">
    <div class="uk-margin-small">
        <label class="uk-form-label" for="form-horizontal-text"
               style="font-family: 'Neucha', cursive">Старый username:</label>
        <div class="uk-form-controls">
            <input class="uk-input" id="form-horizontal-text" type="text"
                   name="username">
        </div>
    </div>
    <div class="uk-margin-small">
        <label class="uk-form-label" for="form-horizontal-text"
               style="font-family: 'Neucha', cursive">Старый password:</label>
        <div class="uk-form-controls">
            <input class="uk-input" id="form-horizontal-text" type="text" name="password">
        </div>
    </div>
    <div class="uk-margin-small">
        <label class="uk-form-label" for="form-horizontal-text"
               style="font-family: 'Neucha', cursive">Новый username:</label>
        <div class="uk-form-controls">
            <input class="uk-input" id="form-horizontal-text" type="text" name="newUsername">
        </div>
    </div>
    <div class="uk-margin-small">
        <label class="uk-form-label" for="form-horizontal-text"
               style="font-family: 'Neucha', cursive">Новый password:</label>
        <div class="uk-form-controls">
            <input class="uk-input" id="form-horizontal-text" type="text" name="newPassword">
        </div>
    </div>
    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
        <button class="uk-button uk-button-danger">Изменить</button>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
    </div>
    </div>
</#macro>