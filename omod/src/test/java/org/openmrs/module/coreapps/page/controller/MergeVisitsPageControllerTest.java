/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 * <p>
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 * <p>
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.coreapps.page.controller;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class MergeVisitsPageControllerTest {
    MergeVisitsPageController controller;


    @Before
    public void setup() {
        controller = new MergeVisitsPageController();

    }

    @Test
    public void test_shouldRemoveVisitParameterFromReturnURL() {
        List<String> merged_visits_ids = Arrays.asList("6,7,8,9");
        String RETURN_URL = "http://localhost:8080/openmrs/coreapps/patientdashboard/patientDashboard.page?patientId=9e121f61-457f-4eaa-9121-62fbb9acdaad&visitId=7";
        String EXPECTED_URL = "http://localhost:8080/openmrs/coreapps/patientdashboard/patientDashboard.page?patientId=9e121f61-457f-4eaa-9121-62fbb9acdaad";
        Assert.assertEquals(controller.removeVisitIdFromURLIfVisitWasMerged(RETURN_URL, merged_visits_ids), EXPECTED_URL);
    }

    @Test
    public void test_shouldNotRemoveVisitParameterFromReturnURL() {
        List<String> merged_visits_ids = Arrays.asList("3,4,5,6");
        String RETURN_URL = "http://localhost:8080/openmrs/coreapps/patientdashboard/patientDashboard.page?patientId=9e121f61-457f-4eaa-9121-62fbb9acdaad&visitId=7";
        String EXPECTED_URL = RETURN_URL;
        Assert.assertEquals(controller.removeVisitIdFromURLIfVisitWasMerged(RETURN_URL, merged_visits_ids), EXPECTED_URL);
    }

}
