<#import "../common/admin_navigation.ftl" as a>
<#import "../common/admin_head.ftl" as h>
<#import "../../blocks/common/footer.ftl" as f>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины | Изменить роль</title>
    <@h.adm_head/>
</head>
<body>
<@a.adm_nav/>
<div class="uk-container uk-container-expand">
    <div uk-grid>
    <#-- Секция -->
        <div class="uk-width-1-2">
    <div class="uk-section uk-padding uk-align-center">
        <div class="uk-container">
            <form action="/user/user_edit_role" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Изменить роль пользователя</legend>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Id пользователя..."
                               name="id">
                    </div>

                    <div class="uk-margin">
                        <select class="uk-select uk-form-small" name="role">
                            <option>USER</option>
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
    </div>
    <#-- /Секция -->

    <#-- Секция -->
        <div class="uk-width-1-2">

    <div class="uk-section uk-padding uk-align-center">
        <div class="uk-container">
            <form action="/user/user_add_role" method="post">

                <fieldset class="uk-fieldset">
                    <legend class="uk-legend">Добавить роль пользователя</legend>

                    <div class="uk-margin">
                        <input class="uk-input uk-form-small" type="text" placeholder="Id пользователя..."
                               name="id">
                    </div>

                    <div class="uk-margin">
                        <select class="uk-select uk-form-small" name="role">
                            <option>USER</option>
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
        </div>
    <#-- /Секция -->
    </div>

    <#if message??>
        <div class="uk-alert-primary" uk-alert>
            <a class="uk-alert-close" uk-close></a>
            <h3>Результат:</h3>
            <p>${message}</p>
        </div>
    </#if>
    <div class="uk-text-meta uk-text-center" style="margin-top: 20px">
        <p><a class="uk-link-text" href="/"> <b>Вернуться на главную</b></a></p>
    </div>
</div>
<@f.footer/>
</body>
</html>