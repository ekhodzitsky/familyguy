<#macro user_edit>
<#-- Секция -->
    <div class="uk-section uk-padding uk-width-1-2 uk-align-center">
        <div class="uk-container">
            <form action="/user_edit" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Редактировать пользователя</legend>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Id юзера..." name="id">
                    </div>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Новый логин..." name="newUsername">
                    </div>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Новый пароль..." name="newPassword">
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