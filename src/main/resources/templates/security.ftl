<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    username = user.getUsername()
    user_id = user.getId()
    isAdmin = user.isAdmin()
    isUser = user.isUser()
    >

<#else>
    <#assign
    <#--name = "guest"-->
    isAdmin = false
    isUser = false
    >
</#if>