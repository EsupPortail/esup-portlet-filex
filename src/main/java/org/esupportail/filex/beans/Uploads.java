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
import java.util.List;

public class Uploads implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String active_files_count;
	
	private String used_space;
	
	private String used_space_unit;
	
	private String max_used_space;
	
	private String max_used_space_unit;
	
	private List<Upload> uploads;

	public String getActive_files_count() {
		return active_files_count;
	}

	public void setActive_files_count(String activeFilesCount) {
		active_files_count = activeFilesCount;
	}

	public String getUsed_space() {
		return used_space;
	}

	public void setUsed_space(String usedSpace) {
		used_space = usedSpace;
	}

	public String getUsed_space_unit() {
		return used_space_unit;
	}

	public void setUsed_space_unit(String usedSpaceUnit) {
		used_space_unit = usedSpaceUnit;
	}

	public String getMax_used_space() {
		return max_used_space;
	}

	public void setMax_used_space(String maxUsedSpace) {
		max_used_space = maxUsedSpace;
	}

	public String getMax_used_space_unit() {
		return max_used_space_unit;
	}

	public void setMax_used_space_unit(String maxUsedSpaceUnit) {
		max_used_space_unit = maxUsedSpaceUnit;
	}

	public List<Upload> getUploads() {
		return uploads;
	}

	public void setUploads(List<Upload> uploads) {
		this.uploads = uploads;
	}

	@Override
	public String toString() {
		return "Uploads [active_files_count=" + active_files_count
				+ ", used_space=" + used_space + ", used_space_unit="
				+ used_space_unit + ", max_used_space=" + max_used_space
				+ ", max_used_space_unit=" + max_used_space_unit + ", uploads="
				+ uploads + "]";
	}
}
