<#import "common.ftl" as c>
<@c.common>
    <div uk-grid>
    <div class="uk-width-1-3"></div>
    <div class="uk-card uk-card-default uk-card-body uk-width-1-4">
    <h3>Добавить видео</h3>
    <form class="uk-form-horizontal" enctype="multipart/form-data" action="/upload" method="post">
    <div class="uk-margin">
        <label class="uk-form-label" for="form-horizontal-text">Номер серии:</label>
        <div class="uk-form-controls">
            <input class="uk-input" type="text" name="episode">
        </div>
    </div>
    <div class="uk-margin">
        <label class="uk-form-label" for="form-horizontal-text">Номер сезона:</label>
        <div class="uk-form-controls">
            <input class="uk-input" type="text" name="season">
        </div>
    </div>
    <div class="uk-margin">
        <label class="uk-form-label" for="form-horizontal-text">Ссылка на видео:</label>
        <div class="uk-form-controls">
            <input class="uk-input" type="text" name="link">
        </div>
    </div>
    <button class="uk-button uk-button-primary uk-position-small uk-align-right" type="submit">Ok</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
    </div>


    <div class="uk-card uk-card-default uk-card-body uk-width-1-4">
<h3>Удалить видео</h3>
    <form class="uk-form-horizontal" enctype="multipart/form-data" action="/delete"
          method="post">
<div class="uk-margin">
    <label class="uk-form-label" for="form-horizontal-text">Номер серии:</label>
    <div class="uk-form-controls">
        <input class="uk-input" type="text" name="episode">
    </div>
</div>
<div class="uk-margin">
    <label class="uk-form-label" for="form-horizontal-text">Номер сезона:</label>
    <div class="uk-form-controls">
        <input class="uk-input" type="text" name="season">
    </div>
</div>
<button class="uk-button uk-button-danger uk-position-small uk-align-right" type="submit">Ok</button>
<input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
    </div>
    </div>
</@c.common>