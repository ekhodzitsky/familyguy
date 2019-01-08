<#macro adm_nav>
    <nav class="uk-navbar-container" style="background-color: transparent;" uk-navbar
         xmlns="http://www.w3.org/1999/html">
        <div class="uk-navbar-left">
            <ul class="uk-navbar-nav">
                <a class="uk-navbar-item uk-logo fg-logo" href="/">Family Guy</a>
            </ul>
        </div>
        <div class="uk-navbar-right">
            <ul class="uk-navbar-nav">
                <li class="uk-active uk-text-center">
                    www.familyguy.space
                    <div class="uk-navbar-subtitle">Микросервис, посвященный любимому сериалу</div>
                </li>
            </ul>
            <a class="uk-navbar-toggle btn-menu" href="/admin" uk-icon="icon: sign-in; ratio: 1.4"></a>
        </div>
    </nav>
    <nav class="uk-navbar-container uk-margin-medium-bottom" style="background-color: #ffd152;" uk-navbar>
        <div class="uk-navbar-left">
            <div class="uk-inline">
                <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size">Сезоны</a>
                <div uk-dropdown="mode: click">
                    <#if seasons??>
                        <#list seasons as s>
                            <form action="/admin/list/${s}">
                            <button class="uk-button uk-button-default uk-button-small btn-standard uk-width-1-1 uk-text-center uk-margin">${s} сезон</button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </form>
                        </#list>
                    <#else>Нет доступных сезонов.
                    </#if>
                </div>
            </div>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/admin">Новое видео</a>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/admin/translation">Перевод</a>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/admin/names">Описание</a>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/admin/remove">Удалить</a>
            <div class="uk-inline">
                <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size">Пользователи</a>
                <div uk-dropdown="mode: click">
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/user">Добавить</a>
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/user/edit">Редактировать</a>
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/user/roles">Изменить роль</a>
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/user/user_list">Список</a>
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/user/delete">Удалить</a>
                </div>
            </div>
            <div class="uk-inline">
                <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size">Нарезки</a>
                <div uk-dropdown="mode: click">
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/admin/moments/add_page">Добавить</a>
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/admin/moments/edit_page">Редактировать</a>
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/admin/moments/remove_page">Удалить</a>
                    <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size uk-margin" href="/admin/moments/list_page">Список</a>
                </div>
            </div>
        </div>
    </nav>
</#macro>