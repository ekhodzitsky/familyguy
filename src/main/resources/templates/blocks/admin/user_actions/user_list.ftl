<#macro put_user_list>
    <#if user_list??>
        <table class="uk-table uk-table-divider">
            <thead>
            <tr>
                <th><b>ID</b></th>
                <th><b>Username</b></th>
                <th><b>Password</b></th>
                <th><b>Роль</b></th>
            </tr>
            </thead>
            <tbody>
            <#list user_list as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><#if user.roles??>
                            <#list user.roles as r>
                                    ${r}
                            </#list>
                        </#if>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>
</#macro>