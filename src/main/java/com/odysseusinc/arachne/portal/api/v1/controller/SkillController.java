/**
 *
 * Copyright 2017 Observational Health Data Sciences and Informatics
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
 * Authors: Pavel Grafkin, Alexandr Ryabokon, Vitaly Koulakov, Anton Gackovka, Maria Pozhidaeva, Mikhail Mironov
 * Created: January 13, 2017
 *
 */

package com.odysseusinc.arachne.portal.api.v1.controller;

import com.odysseusinc.arachne.portal.api.v1.dto.dictionary.SkillDTO;
import com.odysseusinc.arachne.portal.model.Skill;
import com.odysseusinc.arachne.portal.service.SkillService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class SkillController extends BaseSkillController<Skill> {

    @Autowired
    public SkillController(
            SkillService skillService,
            GenericConversionService conversionService) {

        super(skillService, conversionService);
    }

    @Override
    protected Skill convertDtoToSkill(SkillDTO skillDTO) {

        return conversionService.convert(skillDTO, Skill.class);
    }
}
