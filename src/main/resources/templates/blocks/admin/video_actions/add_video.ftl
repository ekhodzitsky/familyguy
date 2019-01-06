<#-- Добавление видео. Включает в себя номер серии, номер сезона, ссылку на iframe и указание перевода. -->
<#macro add_video>
<#-- Секция -->
    <div class="uk-section uk-padding uk-width-1-2 uk-align-center">
        <div class="uk-container">

            <form action="/upload" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Добавить видео</legend>


                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Номер серии..." name="episode">
                    </div>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Номер сезона..." name="season">
                    </div>

                    <div class="uk-margin">
                        <select class="uk-select uk-form-small" name="translation">
                            <option>FILIZA</option>
                            <option>COLDFILM</option>
                            <option>JASKIER</option>
                            <option>OMSKBIRD</option>
                            <option>SUNSHINE</option>
                            <option>BAIBAKO</option>
                            <option>KOSHARA</option>
                            <option>RENTV</option>
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
            <#-- /Секция -->
        </div>
    </div>
</#macro>