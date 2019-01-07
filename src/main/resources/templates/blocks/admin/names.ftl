<#import "../common/admin_navigation.ftl" as a>
<#import "../common/admin_head.ftl" as h>
<#import "../../blocks/common/footer.ftl" as f>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины | Добавить название и описание</title>
    <@h.adm_head/>
</head>
<body>
<@a.adm_nav/>
<div class="uk-container uk-container-expand">
    <#-- Секция -->
    <div class="uk-section uk-padding uk-width-2-3 uk-align-center">
        <div class="uk-container">

            <form action="/admin/add_names_description" method="post">

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
        </div>
    </div>
    <#-- /Секция -->
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
    <@f.footer/>
</div>
</body>
</html>