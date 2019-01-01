<#macro navigation>
    <nav class="uk-navbar-container uk-margin-medium-bottom" style="background-color: transparent;" uk-navbar>
        <div class="uk-navbar-center">
            <ul class="uk-navbar-nav">
                <a class="uk-navbar-item uk-logo fg-logo" href="/">Family Guy</a>
            </ul>
            <div class="uk-navbar-item">
                <form action="/authors" method="get">
                    <button class="uk-button uk-button-default uk-button-small btn-standard-without-increasing-size uk-width-1-1 uk-text-center">
                        Создатели
                    </button>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </form>
            </div>
            <div class="uk-navbar-item">
                <form action="/heroes" method="get">
                    <button class="uk-button uk-button-default uk-button-small btn-standard-without-increasing-size uk-width-1-1 uk-text-center">
                        Персонажи
                    </button>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </form>
            </div>
            <div class="uk-navbar-item">
                <a class="uk-button uk-button-default uk-button-small btn-standard-without-increasing-size uk-width-1-1 uk-text-center"
                   href="https://vk.com/familyguy.space">ВК</a>
            </div>
        </div>
    </nav>
</#macro>