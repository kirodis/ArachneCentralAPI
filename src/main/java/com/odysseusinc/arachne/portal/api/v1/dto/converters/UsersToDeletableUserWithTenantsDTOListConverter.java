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
 * Created: June 25, 2018
 */

package com.odysseusinc.arachne.portal.api.v1.dto.converters;

import com.odysseusinc.arachne.commons.utils.ConverterUtils;
import com.odysseusinc.arachne.portal.api.v1.dto.DeletableUserWithTenantsDTO;
import com.odysseusinc.arachne.portal.api.v1.dto.DeletableUserWithTenantsListDTO;
import com.odysseusinc.arachne.portal.api.v1.dto.TenantBaseDTO;
import com.odysseusinc.arachne.portal.api.v1.dto.UserWithTenantsDTO;
import com.odysseusinc.arachne.portal.model.IUser;
import com.odysseusinc.arachne.portal.model.security.Tenant;
import com.odysseusinc.arachne.portal.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersToDeletableUserWithTenantsDTOListConverter extends BaseConversionServiceAwareConverter<List<IUser>, DeletableUserWithTenantsListDTO> {
    
    @Autowired
    private ConverterUtils converterUtils;
    @Autowired
    private UserService userService;
    
    @Override
    public DeletableUserWithTenantsListDTO convert(final List<IUser> source) {

        final List<DeletableUserWithTenantsDTO> convertedList = converterUtils.convertList(source, DeletableUserWithTenantsDTO.class);

        final Set<Long> userIds = userService.checkIfUsersAreDeletable(source.stream().map(IUser::getId).collect(Collectors.toSet()));
        final Set<Long> deletableUserIds = userService.checkIfUsersAreDeletable(userIds);

        for (final DeletableUserWithTenantsDTO userDto : convertedList) {
            if (!deletableUserIds.contains(Long.valueOf(userDto.getId()))) {
                userDto.setDeletable(false);
            }
        }
        
        return new DeletableUserWithTenantsListDTO(convertedList);        
    }
}
