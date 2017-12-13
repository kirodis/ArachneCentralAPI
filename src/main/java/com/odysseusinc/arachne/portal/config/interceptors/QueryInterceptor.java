/*
 *  Copyright 2017 Observational Health Data Sciences and Informatics
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Company: Odysseus Data Services, Inc.
 *  Product Owner/Architecture: Gregory Klebanov
 *  Authors: Anton Gackovka
 *  Created: November 6, 2017
 *
 */

package com.odysseusinc.arachne.portal.config.interceptors;

import org.hibernate.EmptyInterceptor;

public class QueryInterceptor extends EmptyInterceptor {

	private ThreadLocal<Long> counter = new ThreadLocal<>();

    @Override
    public String onPrepareStatement(String sql) {
        Long count = counter.get();
        if (count != null) {
            counter.set(count + 1);
        }
        return super.onPrepareStatement(sql);
    }

    public Long getCount() {
        return counter.get();
    }

    public void clearCounter() {
        counter.remove();
    }

	public void startCounter() {
		counter.set(0L);
	}
}