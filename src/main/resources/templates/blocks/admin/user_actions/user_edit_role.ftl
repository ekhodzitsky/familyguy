<#macro user_edit_role>
<#-- Секция -->
    <div class="uk-section uk-padding uk-width-1-2 uk-align-center">
        <div class="uk-container">
            <form action="/user_edit_role" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Изменить роль пользователя</legend>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Id пользователя..."
                               name="id">
                    </div>

                    <div class="uk-margin">
                        <select class="uk-select uk-form-small" name="role">
                            <option>USER</option>
                            <option>MODERATOR</option>
                            <option>ADMIN</option>
                        </select>
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