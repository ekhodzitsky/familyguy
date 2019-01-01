<#macro add_translation>
<#-- Секция -->
    <div class="uk-section uk-padding uk-width-1-2 uk-align-center">
        <div class="uk-container">
            <form action="/add_translation" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Добавить перевод</legend>


                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Id видео..." name="id">
                    </div>

                    <div class="uk-margin">
                        <select class="uk-select uk-form-small" name="translation">
                            <option>FILIZA</option>
                            <option>COLDFILM</option>
                            <option>JASKIER</option>
                            <option>OMSKBIRD</option>
                            <option>SUNSHINE</option>
                        </select>
                    </div>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Ссылка на iframe..." name="link">
                    </div>

                    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
                        <button class="uk-button uk-button-default btn-standard-without-increasing-size" type="submit">Ок</button>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </fieldset>
            </form>
        </div>
    </div>
<#-- /Секция -->
</#macro>