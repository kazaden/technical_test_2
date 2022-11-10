<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'trip.label', default: 'Trip')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-trip" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-trip" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.trip}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.trip}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.trip}" method="PUT">
                <g:hiddenField name="version" value="${this.trip?.version}" />
                <fieldset class="form">
                    <%--<f:all bean="trip"/>--%>
                    <div class="fieldcontain ${hasErrors(bean: trip, field: 'desc', 'error')} ">
			<label for="desc">
				<g:message code="activite.desc.label" default="Desc" />
			</label>
			<g:textField name="desc" value="${trip?.desc}"/>
		    </div>

		    <div class="fieldcontain ${hasErrors(bean: trip, field: 'pro', 'error')} required">
			<label for="pro">
				<g:message code="trip.pro.label" default="Pro" />
				<span class="required-indicator">*</span>
			</label>
			<g:select id="pro" name="pro.id" from="${kaz.test.Pro.list()}" optionKey="id" required="" value="${trip?.pro?.id}" class="many-to-one"/>
		    </div>

		    <div class="fieldcontain ${hasErrors(bean: trip, field: 'title', 'error')} ">
			<label for="title">
				<g:message code="trip.title.label" default="Title" />
			</label>
			<g:textField name="title" value="${trip?.title}"/>
		    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
