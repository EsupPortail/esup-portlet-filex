/**
 * Licensed to EsupPortail under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * EsupPortail licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.esupportail.filex.web;

import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.esupportail.filex.beans.Filex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class WebController {

	protected Logger log = Logger.getLogger(WebController.class);
	
    private RestTemplate restTemplate;
    private static final String PREF_SERVICE_URL= "serviceUrl";
    private static final String PREF_REST_URL= "restUrl";    
    private static final String PREF_EPPN_ATTR = "eppnAttr";

    @Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(50 * 1000).setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
		HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		HttpComponentsClientHttpRequestFactory factory = (HttpComponentsClientHttpRequestFactory)restTemplate.getRequestFactory(); 
		factory.setHttpClient(httpClient);
	}

    
    @RequestMapping("VIEW")
    protected ModelAndView renderView(RenderRequest request, RenderResponse response) throws Exception {
        
    	ModelMap model = new ModelMap();
    	
    	final PortletPreferences prefs = request.getPreferences();
    	String eppnAttr = prefs.getValue(PREF_EPPN_ATTR, null);
    	String restUrl = prefs.getValue(PREF_REST_URL, null);
    	
    	Map userInfos = (Map) request.getAttribute(PortletRequest.USER_INFO);
    	String eppn = (String)userInfos.get(eppnAttr);
    	
    	log.info("Try to get FileX info for " + eppn);
    	
    	try {
    		
    		MultiValueMap<String,String> headers = new LinkedMultiValueMap<String,String>();
    		headers.add("eppn", eppn);

    		HttpEntity<MultiValueMap<String, String>> httpRequest = new HttpEntity<MultiValueMap<String,String>>(null, headers);
    		
    		ResponseEntity<Filex> filexEntity = restTemplate.exchange(restUrl, HttpMethod.GET, httpRequest, Filex.class);
    		log.debug("FileX info for " + eppn + " : " + filexEntity.getBody().toString());
    		
    		model.put("filex", filexEntity.getBody());
    	} catch(HttpClientErrorException e) {
    		return new ModelAndView("error", model);
    	}
    	
    	model.put("serviceUrl",prefs.getValue(PREF_SERVICE_URL,null));
        return new ModelAndView("view", model);
    }


    @RequestMapping("ABOUT")
	public ModelAndView renderAboutView(RenderRequest request, RenderResponse response) throws Exception {
		ModelMap model = new ModelMap();
		return new ModelAndView("about", model);
	}
    
    @RequestMapping("HELP")
	public ModelAndView renderHelpView(RenderRequest request, RenderResponse response) throws Exception {
		ModelMap model = new ModelMap();
		return new ModelAndView("help", model);
	}
    
}
