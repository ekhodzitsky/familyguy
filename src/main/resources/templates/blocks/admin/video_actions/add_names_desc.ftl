<#-- Редактирование видео. Вводишь id, названия и описание. -->
<#macro add_video_names_description>
<#-- Секция -->
    <div class="uk-section uk-padding uk-width-2-3 uk-align-center">
        <div class="uk-container">

            <form action="/add_names_description" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Название и описание</legend>
                    <p>Эта форма добавляет поля (если их нет), <b>ЛИБО</b> изменяет их (редактирует), если они есть у видео. Поиск по id.</p>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Id видео..." name="id">
                    </div>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Название серии на русском..." name="rusName">
                    </div>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Название серии на английском..." name="engName">
                    </div>

                    <div class="uk-margin">
                        <textarea class="uk-textarea uk-form-small" rows="7" placeholder="Описание серии..." name="description"></textarea>
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