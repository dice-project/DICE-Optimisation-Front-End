/*
Copyright 2017 Eugenio Gianniti

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package it.polimi.diceH2020.launcher.controller.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.polimi.diceH2020.SPACE4Cloud.shared.settings.Scenario;
import it.polimi.diceH2020.launcher.model.PendingSubmission;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
class PendingSubmissionRepresentation extends ResourceSupport {
    private Long submissionId = null;
    private Scenario scenario = null;

    PendingSubmissionRepresentation (PendingSubmission submission) {
        submissionId = submission.getId ();
        scenario = submission.getScenario ();
    }
}
