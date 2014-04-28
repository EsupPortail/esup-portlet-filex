<%--

    Licensed to EsupPortail under one or more contributor license
    agreements. See the NOTICE file distributed with this work for
    additional information regarding copyright ownership.

    EsupPortail licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file except in
    compliance with the License. You may obtain a copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<portlet:renderURL var="renderRefreshUrl" />

<div class="portlet-section">

<h2 class="portlet-title"><a href="${serviceUrl}" target="filex"><spring:message
	code="view.title" /></a></h2>

<div class="portlet-section-body">
<ul>
	<li><a href="${serviceUrl}" target="filex"> <spring:message
		code="filex.upload" /> </a></li>
	<li><a href="${serviceUrl}/manage" target="filex"> <spring:message
		code="filex.manage" /> </a></li>
</ul>
</div>



<div class="portlet-section-body">
<spring:message code="filex.infos" htmlEscape="false"
	arguments="${filex.uploads.active_files_count},${filex.uploads.used_space},${filex.uploads.used_space_unit},${filex.uploads.max_used_space},${filex.uploads.max_used_space_unit}" />
</div>


<c:forEach var="upload" items="${filex.uploads.uploads}">
	<h3 class="portlet-section-body"><a href="${upload.url}"
		target="filex">${upload.name}</a></h3>
	<ul>
		<li><spring:message code="upload.upload_date" /> : <b>${upload.upload_date}</b></li>
		<li><spring:message code="upload.expire_date" /> : <b>${upload.expire_date}</b></li>
		<li><spring:message code="upload.size" /> : <b>${upload.size}</b></li>
		<li><spring:message code="upload.download_count" /> : <b>${upload.download_count}</b></li>
	</ul>
</c:forEach></div>

