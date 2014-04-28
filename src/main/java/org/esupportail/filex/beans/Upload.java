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
package org.esupportail.filex.beans;

import java.io.Serializable;

public class Upload implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;

	private String upload_date;
	
	private String expire_date;
	
	private String size;
	
	private String download_count;
	
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(String uploadDate) {
		upload_date = uploadDate;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expireDate) {
		expire_date = expireDate;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDownload_count() {
		return download_count;
	}

	public void setDownload_count(String downloadCount) {
		download_count = downloadCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Upload [name=" + name + ", upload_date=" + upload_date
				+ ", expire_date=" + expire_date + ", size=" + size
				+ ", download_count=" + download_count + ", url=" + url + "]";
	}
	
}
