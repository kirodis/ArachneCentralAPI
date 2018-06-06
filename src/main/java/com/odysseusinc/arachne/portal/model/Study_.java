/*
 * Copyright 2018 Observational Health Data Sciences and Informatics
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Company: Odysseus Data Services, Inc.
 * Product Owner/Architecture: Gregory Klebanov
 * Authors: Anton Gackovka
 * Created: October 24, 2017
 */

package com.odysseusinc.arachne.portal.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Study.class)
public class Study_ {
    public static volatile SingularAttribute<Study, Long> id;
    public static volatile SingularAttribute<Study, String> title;
    public static volatile SingularAttribute<Study, StudyStatus> status;
    public static volatile SingularAttribute<Study, StudyType> type;
    public static volatile SingularAttribute<Study, Boolean> privacy;
    public static volatile SingularAttribute<Study, String> kind;
}
